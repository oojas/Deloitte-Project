package com.deloitte.doa;
import java.sql.*;

import com.deloitte.modal.Employee;
public class Dao {
public static int Connect(Employee emp)
{ int val=0;
		try {
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","ojas");
		 System.out.println("Connection Successful");
		val= saveEmployee(emp,con);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	return val;
}
public static int saveEmployee(Employee emp,Connection con) throws SQLException
  {
	  PreparedStatement ps=con.prepareStatement("INSERT INTO EMP_DETAILS VALUES (?,?,?,?,?)");
	  ps.setInt(1, emp.getEmp_ID());
	  ps.setString(2,emp.getEmp_Name() );
	  ps.setString(3, emp.getEmp_Dept());
	  ps.setDouble(4, emp.getEmp_Salary());
	  ps.setString(5, emp.getEmp_Address());
	 return ps.executeUpdate();
  }
}
