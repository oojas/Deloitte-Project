<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Information</h1>
<form action="UpdateServlet" method="post">
 ID <input type="text" name="id"></br>
 Name <input type="text" name="name"></br>
 Department <input type="text" name="dept"></br>
 Salary <input type="text" name="sal"></br>
 Address <input type="text" name="add"></br>
 <input type="Submit" value="add">
</form>
</body>
</html>