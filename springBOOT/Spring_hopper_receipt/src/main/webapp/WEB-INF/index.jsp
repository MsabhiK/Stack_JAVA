<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Hooper's Receipt</title>
</head>
<body>
	<h1>Customer Name:- <c:out value="${first}"/></h1>
	<p>Item Name:- <c:out value="${item}"/></p>
	<p>Price:- $<c:out value="${price}"/></p>
	<p>Description:- <c:out value="${dicte}"/></p>
	<p>Vendor:- <c:out value="${vendor}"/></p>
</body>
<script type="text/javascript" src="/js/app.js"></script>
</html>