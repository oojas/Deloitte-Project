package com.deloitte.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.doa.GetInfo;
import com.deloitte.modal.Employee;
//@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 int id=Integer.parseInt(request.getParameter("id"));
	try {
		Employee emp = GetInfo.connect(id);
		PrintWriter pr=response.getWriter();
		if(emp==null)pr.print("The values for ID are not present");
		 pr.println("ID "+emp.getEmp_ID());
		 pr.println("Name "+emp.getEmp_Name());
		 pr.println("Department "+emp.getEmp_Dept());
		 pr.println("Salary "+emp.getEmp_Salary());
		 pr.println("Address "+emp.getEmp_Address());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	}

}
