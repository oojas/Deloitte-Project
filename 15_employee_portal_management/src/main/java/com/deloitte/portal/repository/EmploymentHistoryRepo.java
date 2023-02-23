package com.deloitte.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.deloitte.portal.model.EmployeeHistory;

public interface EmploymentHistoryRepo extends JpaRepository<EmployeeHistory, Long>{

	@Query(value="select * from employment_history eh inner join employees e using(emp_id) where eh.emp_id= :id order by until_date desc", nativeQuery = true)
	List<EmployeeHistory> getEmployeeHistoryById(int id);
	
	/*
	 * @Query(value="delete from employement_history where emp_id=:id", nativeQuery
	 * = true) void deleteEmployeeHistoryById(int id);
	 */
}
