package com.deloitte.portal.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "employement_history")
@Data
public class EmployeeHistory {

	@Id
	@Column(name="id")
	private Integer empHistoryId;
	
	@Column(name="emp_id", insertable = false, updatable = false)
	private Integer empId;
	
	@Column(name="organization_name")
	private String orgName;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="until_date")
	private Date toDate;
	
	private String location;
	
	private String country;
	
	private String post;
	
	@Column(name = "skill_used")
	private String skills;
	
	@ManyToOne()
	@JoinColumn(name = "emp_id")
	private Employee employee;

	public Integer getEmpHistoryId() {
		return empHistoryId;
	}

	public void setEmpHistoryId(Integer empHistoryId) {
		this.empHistoryId = empHistoryId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
