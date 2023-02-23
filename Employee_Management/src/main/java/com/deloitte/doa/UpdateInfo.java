package com.deloitte.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.deloitte.modal.Employee;

public class UpdateInfo {
 public static int connect(Employee emp) {
	 int val=0;
		try {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","ojas");
		 System.out.println("Connection Successful");
		val= UpdateEmployee(emp,con);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	return val;
 }
 public static int UpdateEmployee(Employee emp,Connection con) throws SQLException
 {
	 PreparedStatement ps=con.prepareStatement("UPDATE EMP_DETAILS SET EMP_NAME=?, EMP_DEPT=?,EMP_SALARY=?,EMP_ADDRESS=? WHERE EMP_ID= "+emp.getEmp_ID());
	  ps.setString(1,emp.getEmp_Name() );
	  ps.setString(2, emp.getEmp_Dept());
	  ps.setDouble(3, emp.getEmp_Salary());
	  ps.setString(4, emp.getEmp_Address());
	 return ps.executeUpdate();
 }
}
