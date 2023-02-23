package com.deloitte.portal.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.deloitte.portal.model.Employee;

public class CSVHelper {

	public static ByteArrayInputStream employeesToCSV(List<Employee> employees) {
		final CSVFormat format = CSVFormat.DEFAULT.withHeader("Emp Id", "Name", "DoJ", "Post", "Level", "Mobile","Personal Mail","Office Mail","DoB","Blood Group","Pan No","Aadhaar No");

		try (ByteArrayOutputStream out = new ByteArrayOutputStream();
				CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
			for (Employee emp : employees) {
				List<String> data = Arrays.asList(String.valueOf(emp.getEmpId()), emp.getFirstName()+" "+emp.getLastName(), emp.getDoj(),emp.getPostName(),String.valueOf(emp.getEmpLevel()),emp.getMobileNo(),emp.getEmailId(),emp.getOfficeEmailId(),emp.getDob(),emp.getBloodGroup(),emp.getPanNo(),emp.getAadhaarNo());

				csvPrinter.printRecord(data);
			}
			csvPrinter.flush();
			return new ByteArrayInputStream(out.toByteArray());

		} catch (IOException e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
	}

}
