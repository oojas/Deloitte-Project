package com.deloitte.modal;

public class Employee {
 private int Emp_ID;
 private String Emp_Name;
 private String Emp_Dept;
 private double Emp_Salary;
 private String Emp_Address;
 
public int getEmp_ID() {
	return Emp_ID;
}
public void setEmp_ID(int emp_ID) {
	Emp_ID = emp_ID;
}
public Employee(int emp_ID, String emp_Name, String emp_Dept, double emp_Salary, String emp_Address) {
	super();
	Emp_ID = emp_ID;
	Emp_Name = emp_Name;
	Emp_Dept = emp_Dept;
	Emp_Salary = emp_Salary;
	Emp_Address = emp_Address;
}
public String getEmp_Name() {
	return Emp_Name;
}
public void setEmp_Name(String emp_Name) {
	Emp_Name = emp_Name;
}
public String getEmp_Dept() {
	return Emp_Dept;
}
public void setEmp_Dept(String emp_Dept) {
	Emp_Dept = emp_Dept;
}
public double getEmp_Salary() {
	return Emp_Salary;
}
public void setEmp_Salary(double emp_Salary) {
	Emp_Salary = emp_Salary;
}
public String getEmp_Address() {
	return Emp_Address;
}
public void setEmp_Address(String emp_Address) {
	Emp_Address = emp_Address;
}
}
