package com.deloitte.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteInfo {
public static int connect(int id) throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","ojas");
	System.out.println("Connection Successful");
	int status=DeleteInfoMysql(con, id);
	return status;
}
public static int DeleteInfoMysql(Connection con, int id) throws SQLException
{
	PreparedStatement pr=con.prepareStatement("DELETE EMP_DETAILS FROM EMP_DETAILS WHERE EMP_ID="+id);
	return pr.executeUpdate();
}
}
