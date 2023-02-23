package com.deloitte.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.portal.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("select emp from employees emp order by emp.firstName asc")
	List<Employee> findAll();
	
	@Query("select emp from employees emp where emp.empId= :id")
	List<Employee> searchEmployeeById(int id);
		
	@Query("select emp from employees emp where emp.gender= :gender and (emp.firstName like %:name% or emp.lastName like %:name%) or (emp.gender= :gender or (emp.firstName like %:name% or emp.lastName like %:name%))")
	List<Employee> searchEmployeeByName(String gender, String name);
	
	@Query("select count(*) from employees")
	int NoOfRecords();
	
	@Query(value="select * from employees emp where emp.gender= :gender", nativeQuery=true)
	List<Employee> findByGender(String gender);
	
	@Query(value="select emp.email_id from employees emp", nativeQuery=true)
	List<String> getAllEmail();
	
}
