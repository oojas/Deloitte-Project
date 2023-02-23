package com.deloitte.portal.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.portal.helper.CSVHelper;
import com.deloitte.portal.model.Employee;
import com.deloitte.portal.model.EmployeeHistory;
import com.deloitte.portal.repository.EmployeeRepository;
import com.deloitte.portal.repository.EmploymentHistoryRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmploymentHistoryRepo employmentHistory;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee findById(int empId) {
		if(employeeRepository.findById((long) empId).isPresent()) {
			return employeeRepository.findById((long) empId).get();
		}
		return null;
	}

	@Override
	public void delete(int empId) {
			employeeRepository.deleteById((long) empId);
	}

	@Override
	
	public List<Employee> searchEmployeeById(int id) {
		if(employeeRepository.searchEmployeeById(id).isEmpty()) {
			return null;
		}
		return employeeRepository.searchEmployeeById(id);
	}

	@Override
	public List<Employee> searchEmployeeByName(String gender, String name) {
		if(employeeRepository.searchEmployeeByName(gender, name).isEmpty()) {
			return null;
		}
		return employeeRepository.searchEmployeeByName(gender, name);
	}

	@Override
	public List<EmployeeHistory> getEmployeeHistoryById(int id) {
		if(employmentHistory.getEmployeeHistoryById(id).isEmpty()) {
			return null;
		}
		return employmentHistory.getEmployeeHistoryById(id);
	}

	@Override
    public ByteArrayInputStream load() {
    	List<Employee> emp= employeeRepository.findAll();
        ByteArrayInputStream in = CSVHelper.employeesToCSV(emp);
        return in;
    }

	@Override
	public int getNoOfRecords() {
		return (int) employeeRepository.count();
	}

	@Override
	public List<Employee> findByGender(String gender) {
		List<Employee> emp=employeeRepository.findByGender(gender);
		if(emp.isEmpty()) {
			return null;
		}
		return employeeRepository.findByGender(gender);
	}
	
	
}
