<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
span {
	color: green;
	font-weight: bold;
	font-family: sans-serif;
	font-size: medium;
	text-align: center;
	font-style: italic;
}
</style>
</head>
<body>
<p align="center"><span>${successMessage}</span><p>
<jsp:include page="input.jsp"></jsp:include>
</body>
</html>