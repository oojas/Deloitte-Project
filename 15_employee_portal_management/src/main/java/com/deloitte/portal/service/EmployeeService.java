package com.deloitte.portal.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.deloitte.portal.model.Employee;
import com.deloitte.portal.model.EmployeeHistory;

public interface EmployeeService {
	List<Employee> findAll();
	
	void save(Employee employee);
	
	Employee findById(int empId);
	
	void delete(int empId);
	
	List<Employee> searchEmployeeById(int id);
		
	List<Employee> searchEmployeeByName(String gender, String name);
	
	List<EmployeeHistory> getEmployeeHistoryById(int id);
	
	ByteArrayInputStream load();
	
	int getNoOfRecords();
	
	List<Employee> findByGender(String gender);
}
