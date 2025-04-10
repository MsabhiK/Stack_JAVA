<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>All Classes</title>
    <link rel="stylesheet" href="/css/style.css"> 
</head>
<body class="mx-auto p-4" style="width: 45%">
	<h1 class="text-center text-upercase">All Classes</h1>
	<p><a href="/">Dashboard</a></p>
	<hr>
	<table class="col-3 mx-auto table table-striped table-bordered text-center">
		<thead>
			<tr class="bg-info">
				<th>Classes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${courses}">
				<tr>
					<td class="text-uppercase"><a href="/classes/${course.id}"><c:out value="${course.nameCourse}"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
