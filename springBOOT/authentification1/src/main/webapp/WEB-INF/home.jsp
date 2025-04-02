<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Home</title>
</head>
<body>
	<div class="container mx-3">
		<h1 class="text-uppercase">Welcome: <c:out value="${user.userName}"/></h1>
		<p class="font-monospace fw-bold">This is your dashboard. Nothing to see here yet.</p>
		<a href="/logout">LogOut</a>
	</div>
	
</body>
</html>