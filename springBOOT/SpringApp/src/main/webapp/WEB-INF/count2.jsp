<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Counter 2</title>
</head>
<body>
	<p> You have visited site 2 <a href="http://localhost:8080">http://localhost:8080</a> <c:out value="${count2}"/> times</p>
	<a href="/reset2"><button>Reset</button></a>
</body>
</html>