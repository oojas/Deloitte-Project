package com.deloitte.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.doa.Dao;
import com.deloitte.doa.UpdateInfo;
import com.deloitte.modal.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      int id=Integer.parseInt(request.getParameter("id"));
	      String name=request.getParameter("name");
	      String dept=request.getParameter("dept");
	      double sal=Double.parseDouble(request.getParameter("sal"));
	      String add=request.getParameter("add");
	      PrintWriter p=response.getWriter();
	      int status =UpdateInfo.connect(new Employee(id, name, dept, sal, add));
	      if(status>0)
	      {
	    	 p.println("Saved Record Successfully"); 
	      }
	      else
	      {
	    	  p.println("Not saved");
	      }
	}

}
