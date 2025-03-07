<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>COUNT</title>
</head>
<body>
	<div class="alert alert-primary my-2" role="alert">
  		<p>
  			You have visited <a href="/" class="alert-link">http://localhost:8080</a> <c:out value="${count}"/> times.
  			<a href="#"><button type="reset" class="btn btn-dark">RESET</button></a>
  		</p>
  		<a href="/" class="link-primary">Test another visit?</a>
	</div>
</body> 
</html>