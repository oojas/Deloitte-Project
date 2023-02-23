package com.deloitte.doa;
import java.sql.*;

import com.deloitte.modal.Employee;
public class GetInfo {
  public static Employee connect(int id) throws ClassNotFoundException, SQLException {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","ojas");
		  System.out.println("Connection Successful");
		Employee  emp=getInfo(con,id);
	  return emp;
  }
  public static Employee getInfo(Connection con, int id) throws SQLException
  {
	  PreparedStatement res=con.prepareStatement("SELECT * FROM EMP_DETAILS WHERE EMP_ID = "+id);
	 ResultSet rs=res.executeQuery();
	 Employee emp=null;
	 while(rs.next())
	 {
		 
		 emp=new Employee(id,rs.getString(2) ,rs.getString(3) , rs.getDouble(4),rs.getString(5));
	 }
	 return emp;
  }
}

