<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
span {
	color: red;
	font-weight: bold;
	font-family: sans-serif;
	font-size: medium;
	text-align: center;
	font-style: italic;
}
</style>
</head>
<body>
<span>${errorMessage}</span>
<span>${emailMsg[1]}</span>
<span>${officeemailMsg[1]}</span>
<jsp:include page="input.jsp"></jsp:include>
</body>
</html>