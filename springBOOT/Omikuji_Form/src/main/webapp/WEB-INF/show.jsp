<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<!--<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />-->
</head>
<body>
	<h1>Here's Your Omikuji!</h1>
	
	<h3 style="width: 50%;">
		<c:out value="${result}"/>
	</h3>

	<div class="center">
		<a href="/omikuji">Go Back</a>
	</div>

</body>
</html>