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
	<div class="container">
		<div class="d-flex justify-content-between bd-highlight">
  			<div class="bd-highlight"><h1 class="text-uppercase">Welcome: <c:out value="${user.userName}"/></h1></div>
  			<div class="bd-highlight d-flex align-items-center"><a href="/logout">LogOut</a></div>
  		</div>
  		<div class="d-flex justify-content-between bd-highlight">
  			<div class="bd-highlight font-monospace fw-bold">Books from everyone shelves:</div>
  			<div class="bd-highlight d-flex align-items-start"><a href="/addPage">+ Add to my shelf</a></div>
  		</div>
  		
  		<table class="table">
		
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
			<c:forEach var="book" items="${books}">
			
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.authorName}"/></td>
					<td><c:out value="${book.user.userName}"/></td>
				</tr>
			</c:forEach>
		
		</table>
	</div>
	
</body>
</html>