package com.deloitte.portal.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.portal.model.Employee;
import com.deloitte.portal.model.EmployeeHistory;
import com.deloitte.portal.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class PortalController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<Employee> employee = employeeService.findAll();
		int count= employeeService.getNoOfRecords();
		mav.addObject("recordsCount", count);
		mav.addObject("employee", employee);
		return mav;
	}

	@RequestMapping("/input")
	public ModelAndView addEmployee() {
		ModelAndView mav = new ModelAndView("input");
		mav.addObject("employee", new Employee());
		return mav;
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("employee") Employee employee, BindingResult br) {
		if (br.hasErrors()) {
			String message = "Form has invalid input data, please correct the errors and submit again!";
			return new ModelAndView("errorpage", "errorMessage", message);
		}
		try {
			employeeService.save(employee);
			String message = "Employee record has been saved successfully";
			return home().addObject("successMessage", message);
		}
		catch(DataIntegrityViolationException e) {
			if(e.getMessage().contains("email_id")) {
				String[] message= {"Email is already taken","Form has invalid input data, please correct the errors and submit again!"};
				return new ModelAndView("errorpage","emailMsg",message);
			}
			String[] message= {"Email is already taken","Form has invalid input data, please correct the errors and submit again!"};
			return new ModelAndView("errorpage","officeemailMsg",message);
		}

	}
	

	@RequestMapping("/input/{empId}")
	public ModelAndView edit(@PathVariable("empId") int id) {
		ModelAndView mav = new ModelAndView("edit-input");
		Employee employee = employeeService.findById(id);
		mav.addObject("employee", employee);
		return mav;
	}

	@RequestMapping(value = "/home/{empId}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("empId") int id) {
		employeeService.delete(id);
		String message="Employee record has been deleted successfully";
		return home().addObject("deleteMsg",message);
	}

	@RequestMapping(value = "/search")
	public String searchEmployeebyId(Model model, @Param("id") Integer id, @Param("gender") String gender,
			@Param("name") String name) {
		if (id != null) {
			List<Employee> employee = employeeService.searchEmployeeById(id);
			if (employee == null) {
				String msg = "Sorry, No Employee records found!";
				model.addAttribute("message", msg);
				return "home";
			} else {
				model.addAttribute("employee", employee);
				model.addAttribute("id", id);
				return "home";
			}
		}
		else if (name != null) {
			List<Employee> emp = employeeService.searchEmployeeByName(gender, name);
			if (emp == null) {
				String msg = "Sorry, No Employee records found!";
				model.addAttribute("message", msg);
				return "home";
			}
			model.addAttribute("employee", emp);
			return "home";
		}
		else if (gender != null) {
			List<Employee> empList = employeeService.findByGender(gender);
			if (empList == null) {
				String msg = "Sorry, No Employee records found!";
				model.addAttribute("message", msg);
				return "home";
			}
			model.addAttribute("employee", empList);
			return "home";
		}

		return "redirect:/home";
	}

	@RequestMapping(value = "/history/{empId}", method = RequestMethod.GET)
	public ModelAndView getEmploymentHistory(@PathVariable("empId") int id) {
		ModelAndView mav = new ModelAndView("history");
		List<EmployeeHistory> empHis = employeeService.getEmployeeHistoryById(id);
		if (empHis == null) {
			Employee emp = employeeService.findById(id);
			String message = "Sorry, No Employement history records found!";
			mav.addObject("norecords", message);
			mav.addObject("employee", emp);
			return mav;
		}
		Employee emp = employeeService.findById(id);
		mav.addObject("employee", emp);
		mav.addObject("empHistory", empHis);
		return mav;
	}

	@RequestMapping("/download")
	public ResponseEntity<InputStreamResource> exportCSV() throws Exception {
        DateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
        String currentDateTime = dateFormatter.format(new Date());
        
		String filename = "Employee"+currentDateTime+".csv";
		InputStreamResource file = new InputStreamResource(employeeService.load());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/csv")).body(file);

	}
}
