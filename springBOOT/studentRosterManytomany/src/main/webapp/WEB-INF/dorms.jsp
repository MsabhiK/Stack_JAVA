<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Dorms</title>
    <link rel="stylesheet" href="/css/style.css"> 
</head>
<body class="mx-auto p-3" style="width: 45%">
	
	<p><a href="/dorms/new">Add a new dorm</a></p>
	<p><a href="/students/new">Add a new student</a></p>
	<p><a href="/classes/new">Add a new class</a></p>
	<p><a href="/classes">View all Classes</a></p>
	<h1 class="text-center">Dorms</h1>
	<table class="col-3 mx-auto table table-striped table-bordered text-center">
		<thead>
			<tr class="bg-success">
				<th>Dorm</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dorm" items="${dorms}">
				<tr>
					<td><c:out value="${dorm.name}"/></td>
					<td><a href="/dorms/${dorm.id}"><c:out value="See Students"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<h1 class="text-center">All Students</h1>
	<table class="col-3 mx-auto table table-striped table-bordered text-center">
		<thead>
			<tr class="bg-dark text-light">
				<th>Student Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<td><a href="/students/${student.id}"><c:out value="${student.name}"/></a></td>
					<td><a href="/students/delete/${student.id}"><c:out value="Delete"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
