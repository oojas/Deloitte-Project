<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<style type="text/css">
span {
	color: green;
	font-weight: bold;
	font-family: sans-serif;
	font-size: large;
	text-align: center;
}

.error {
	color: red;
	font-weight: normal;
	font-family: sans-serif;
	font-size: 12px;
	text-align: center;
}
button {
	background-color: #1c87c9;
	border: none;
	color: white;
	padding: 5px 7px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	margin: 4px 2px;
	cursor: default;
}

</style>
</head>
<body>
	<h1>Add/Update Employee Record</h1>
	<form:form action="/input" method="post"
		modelAttribute="employee">
		
		<table>
			<tr>
				<td>Employee No# (*)</td>
				<td><form:input path="empId" placeholder="Enter Employee #" /></td>
				<td><form:errors path="empId" cssClass="error" /></td>
			</tr>
			<tr>
				<td>First Name (*)</td>
				<td><form:input path="firstName" placeholder="Enter first name" /></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Date of Birth (*)</td>
				<td><form:input path="dob" type="Date"/></td>
				<td><form:errors path="dob" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Mobile No# (*)</td>
				<td><form:input path="mobileNo" placeholder="Enter mobile #" /></td>
				<td><form:errors path="mobileNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Office mail (*)</td>
				<td><form:input path="officeEmailId"
						placeholder="Enter office mail id" /></td>
				<td><form:errors path="officeEmailId" cssClass="error" /></td>
				<td class="error">${officeemailMsg[0]}</td>
			</tr>
			<tr>
				<td>Date of joining (*)</td>
				<td><form:input path="doj" type="date" pattern="dd-MM-yyyy" /></td>
				<td><form:errors path="doj" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Post (*)</td>
				<td><form:input path="postName" placeholder="Enter post name" /></td>
				<td><form:errors path="postName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Basic Pay (*)</td>
				<td><form:input path="basicPay" placeholder="Enter basic pay" /></td>
				<td><form:errors path="basicPay" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Pan No#</td>
				<td><form:input path="panNo" placeholder="Enter pan #" /></td>
				<td><form:errors path="panNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Permanent Address</td>
				<td><form:textarea path="permanentAddress"
						placeholder="Enter permanent address" /></td>
				<td><form:errors path="permanentAddress" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Last Name (*)</td>
				<td><form:input path="lastName" placeholder="Enter last name" /></td>
				<td><form:errors path="lastName" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Gender (*)</td>
				<td><form:select path="gender">
						<form:option value="" label="Select a gender"></form:option>
						<form:option value="m" label="Male"></form:option>
						<form:option value="f" label="Female"></form:option>
						<form:option value="nd" label="Transgender"></form:option>
					</form:select></td>
				<td><form:errors path="gender" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Email Id (Personal) (*)</td>
				<td><form:input path="emailId" placeholder="Enter email id" /></td>
				<td><form:errors path="emailId" cssClass="error"/></td>
				<td class="error">${emailMsg[0]}</td>
			</tr>
			<tr>
				<td>Employee Level (*)</td>
				<td><form:input path="empLevel"
						placeholder="Enter Employee level" /></td>
				<td><form:errors path="empLevel" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Blood Group (*)</td>
				<td><form:select path="bloodGroup">
						<form:option value="" label="Select Blood Group"></form:option>
						<form:option value="A+" label="A+"></form:option>
						<form:option value="B+" label="B+"></form:option>
						<form:option value="O+" label="O+"></form:option>
						<form:option value="A-" label="A-"></form:option>
						<form:option value="B-" label="B-"></form:option>
						<form:option value="O-" label="O-"></form:option>
						<form:option value="AB+" label="AB+"></form:option>
						<form:option value="AB-" label="AB-"></form:option>
					</form:select></td>
				<td><form:errors path="bloodGroup" cssClass="error"/></td>
			</tr>
			<tr>
				<td>House Allowance (*)</td>
				<td><form:input path="houseAllowance" placeholder="Enter HRA" /></td>
				<td><form:errors path="houseAllowance" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Aadhaar No#</td>
				<td><form:input path="aadhaarNo" placeholder="Enter aadhaar #" /></td>
				<td><form:errors path="aadhaarNo" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Present Address</td>
				<td><form:input path="presentAddress"
						placeholder="Enter present address" /></td>
				<td><form:errors path="presentAddress" cssClass="error"/></td>
			</tr>
			<tr>
				<td align="center"><form:button type="submit">Submit</form:button></td>
				<td align="center"><form:button type="reset">Cancel</form:button>
			</tr>
		</table>
	</form:form>
	<button onclick="window.location.href='/home'">Back to Home</button>
</body>
</html>