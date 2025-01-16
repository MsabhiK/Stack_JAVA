<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fruits</title>
</head>
<body>
	<h1>Two plus two is: </h1>
	<h2><c:out value="${5+2}"/></h2>
	
	<h1>Fruit of the Day</h1>
	<h2><c:out value="${fruit}"/></h2>
	<p><c:out value="${first}"/></p>
	<p><c:out value="${last}"/></p>
	<p><c:out value="${age}"/></p>
	<h1>Welcome User!!!</h1>
	<p><a href="/counter">Touch for Counter</a></p>
	<p><a href="/counter2">Touch for Counter + 2</a></p>
</body>
</html>