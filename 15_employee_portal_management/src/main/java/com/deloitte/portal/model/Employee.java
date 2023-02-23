package com.deloitte.portal.model;


import java.util.List;

import com.deloitte.portal.constraints.AadhaarNoConstraint;
import com.deloitte.portal.constraints.AgeConstraint;
import com.deloitte.portal.constraints.PanNoConstraint;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity(name = "employees")
@Table(name = "employees", uniqueConstraints = {@UniqueConstraint(columnNames = {"email_id","office_mail"})})
@Data
public class Employee {
	
	@Id
	@Column(name="emp_id",unique = true)
	@NotNull(message = "Please input valid Id")
	private Integer empId;
	
	@NotEmpty(message = "Input between 1 to 50 characters")
	@Pattern(regexp = "(?=.*[a-zA-Z]).{1,50}$", message="Please input alphabets only!")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty(message = "Input between 1 to 50 characters")
	@Pattern(regexp ="(?=.*[a-zA-Z]).{1,50}$", message="Please input alphabets only!")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "Please input valid gender!")
	private String gender;
	
	@AgeConstraint(message = "Please input a valid date, age must be >=20")
	private String dob;
	
	@Column(name="pan_num", nullable = true)
	@PanNoConstraint(message = "Please input alphanumeric only! 10 characters required")
	private String panNo;
	
	@Column(name="aadhaar_num")
	@AadhaarNoConstraint(message = "Please input numeric only! Maximum 12 characters")
	private String aadhaarNo;
	
	@NotEmpty(message = "Please input valid mobile #")
	@Size(max = 10, message = "Please input 10 characters only!")
	@Pattern(regexp = "(?=.*[0-9]).{10}$", message="Please input alphanumeric only! Maximum 10 characters")
	@Column(name = "mobile_num")
	private String mobileNo;
	
	@NotEmpty(message = "Please input an email!")
	@Email(message = "Please input a valid email!")
	@Column(name="email_id", unique = true, nullable = false)
	private String emailId;
	
	@NotEmpty(message = "Please input an email!")
	@Email(message = "Please input a valid email or Email is already taken!")
	@Column(name="office_mail", unique = true, nullable = false)
	private String officeEmailId;
	
	@Size(max= 200, message = "Text should not exceed 200 characters!")
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Size(max= 200, message = "Text should not exceed 200 characters!")
	@Column(name="present_address")
	private String presentAddress;
	
	@NotBlank(message = "Please select a valid blood group!")
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Column(name="profile_pict")
	private String profilePic;
	
	@NotBlank(message = "Please input a valid DoJ!")
	private String doj;
	
	@NotNull(message = "Please select a value between 7 to 30!")
	@Min(value = 7,message = "Please select a value between 7 to 30!")
	@Max(value = 30, message = "Please select a value between 7 to 30!")
	@Column(name="emp_level")
	private Integer empLevel;
	
	@NotEmpty(message = "Please input valid post!")
	@Size(max = 30, message = "Please input 30 characters only!")
	@Pattern(regexp = "(?=.*[a-zA-Z]).{1,30}$", message="Please input alphabets only!")
	@Column(name="post_name")
	private String postName;
	
	@NotNull(message = "Please input valid basic pay!")
	@Min(value = 100, message="Please input between 3 to 8 characters!")
	@Max(value = 99999999, message="Please input between 3 to 8 characters!")
	@Column(name="basic_pay")
	private Integer basicPay;
	
	@NotNull(message = "Please input valid house allowance!")
	@Min(value = 100,message="Please input between 3 to 5 characters!")
	@Max(value = 99999, message="Please input between 3 to 5 characters!")
	@Column(name="house_allowance")
	private Integer houseAllowance;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<EmployeeHistory> history;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOfficeEmailId() {
		return officeEmailId;
	}

	public void setOfficeEmailId(String officeEmailId) {
		this.officeEmailId = officeEmailId;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public Integer getEmpLevel() {
		return empLevel;
	}

	public void setEmpLevel(Integer empLevel) {
		this.empLevel = empLevel;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Integer getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Integer basicPay) {
		this.basicPay = basicPay;
	}

	public Integer getHouseAllowance() {
		return houseAllowance;
	}

	public void setHouseAllowance(Integer houseAllowance) {
		this.houseAllowance = houseAllowance;
	}

	public List<EmployeeHistory> getHistory() {
		return history;
	}

	public void setHistory(List<EmployeeHistory> history) {
		this.history = history;
	}
	
	
}
