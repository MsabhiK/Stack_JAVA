<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Insert title here</title>
</head>
<body class="p-2">
	<h5>Your prefered book with Id ---> <c:out value="${book.id}"/> is:</h5>
	<hr>
	<h1><c:out value="${book.title}"/></h1>
	<p>Description: <c:out value="${book.description}"/></p>
	<p>Number of pages: <c:out value="${book.nbreofpages}"/></p>
	<p>Language: <c:out value="${book.language}"/></p>
	<hr>
	<c:forEach var="b" items="${books}">
		<p><c:out value="${b.title}"/></p>
	</c:forEach>
	
</body>
</html>