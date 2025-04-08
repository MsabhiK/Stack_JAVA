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
	<div class="container p-3">
		<div class="d-flex justify-content-between bd-highlight">
  			<div class="bd-highlight"><h4 class="font-monospace fw-bold">Hello, <c:out value="${user.userName}"/>. Welcome to..</h4></div>
  			<div class="bd-highlight d-flex align-items-center"><a href="/logout">LogOut</a></div>
  		</div>
  		<div class="d-flex justify-content-between bd-highlight">
  			<div class="bd-highlight text-uppercase"><h1>The Book broker!</h1></div>
  			<div class="bd-highlight d-flex align-items-start"><a href="/addPage">+ Add to my shelf</a></div>
  		</div>
  		
  		<table class="table caption-top">
  			<caption class="font-monospace fw-bold text-warning">Available books to Borrow</caption>
  			<thead>
				<tr class="table-warning">
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Owner</th>
					<th>Action</th>
				</tr>
			</thead>
				<c:forEach var="book" items="${books}">
					<c:if test="${user.id!=book.borrower.id}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.authorName}"/></td>
						<td><c:out value="${book.user.userName}"/></td>
						<td>
							<c:if test="${user==book.user}">
								<a href="/books/${book.id}/edit">edit / delete</a>
							</c:if>
							<c:if test="${user!=book.user}">
								<a href="/books/${book.id}/borrow">borrow</a>
							</c:if>
						</td>
					</tr>
					</c:if>
				</c:forEach>
		
		</table>
		
		<table class="table caption-top">
  			<caption class="font-monospace fw-bold text-primary">Books I'm Borrowing!</caption>
  			<thead>
				<tr class="table-primary">
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Owner</th>
					<th>Action</th>
				</tr>
			</thead>
				<c:forEach var="book" items="${books}">
					<c:if test="${user.id==book.borrower.id}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.authorName}"/></td>
						<td><c:out value="${book.user.userName}"/></td>
						<c:if test="${user!=book.user}">
							<td><a href="books/${book.id}/return">return</a></td>
						</c:if>
					</tr>
					</c:if>
				</c:forEach>
		
		</table>
	</div>
	
</body>
</html>