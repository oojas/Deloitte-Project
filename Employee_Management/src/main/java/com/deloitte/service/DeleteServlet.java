package com.deloitte.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.doa.DeleteInfo;
import com.deloitte.modal.Employee;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id=Integer.parseInt(request.getParameter("id"));
       PrintWriter out=response.getWriter();
       try {
		int status=DeleteInfo.connect(id);
		if(status>0)out.println("Record Deleted Successfully");
		else out.println("Record Not Deleted");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
