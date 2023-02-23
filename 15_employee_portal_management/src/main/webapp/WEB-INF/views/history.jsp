<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employment History</title>
<style type="text/css">
table {
	width: 700px;
}

td {
	border: 1px solid black;
	padding: 5px;
	border-collapse: collapse;
	text-align: center
}

th {
	width: 200px;
	border: 1px solid black
}

span {
	color: green;
	font-weight: bold;
	font-family: sans-serif;
	font-size: large;
}

div{
	color: red;
	font-weight: bold;
	font-family: sans-serif;
	font-size: large;
	font-style: italic;
}

h1 {
	text-align: center;
}

body {
	align: center;
}
.center {
	margin-left: auto;
	margin-right: auto;
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
	<div><p align="center">${norecords}</p></div>
	<h1>${employee.firstName}&#32;${employee.lastName}
		&#35;${employee.empId}</h1>
	<table class="center">
		<tr>
			<th>Organization</th>
			<th>Period</th>
			<th>Location</th>
			<th>Post</th>
		</tr>
		<c:forEach var="empHis" items="${empHistory}">
		<tr>
			<td>${empHis.orgName}</td>
			<td><fmt:formatDate pattern="MM/yyyy" value="${empHis.fromDate}"/>~<fmt:formatDate pattern="MM/yyyy" value="${empHis.toDate}"/></td>
			<td>${empHis.location} (${empHis.country})</td>
			<td>${empHis.post}</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<p align="center"><button onclick="window.location.href='/home'">Back to Home</button></p>
</body>
</html>