package com.deloitte.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.doa.Dao;
import com.deloitte.modal.Employee;

@SuppressWarnings("serial")
public class SaveServlet extends HttpServlet {


	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
      int id=Integer.parseInt(req.getParameter("id"));
      String name=req.getParameter("name");
      String dept=req.getParameter("dept");
      double sal=Double.parseDouble(req.getParameter("sal"));
      String add=req.getParameter("add");
      PrintWriter p=response.getWriter();
      int status =Dao.Connect(new Employee(id, name, dept, sal, add));
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
