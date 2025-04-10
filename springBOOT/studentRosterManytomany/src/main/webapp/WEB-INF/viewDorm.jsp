<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title><c:out value="${dorm.name}"/></title>
    <!--<link rel="stylesheet" href="/css/style.css">   -->
</head>
<body class="mx-auto p-4" style="width: 45%">
	<h1 class="text-center"><c:out value="${dorm.name}"/> Students</h1>
	<p><a href="/">Dashboard</a></p>
	
	<form action="/" method="post">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td colspan="1">
						<label for="name">Students:</label>
						<select name="stud" class="input form-select" aria-label="Default select">
				    		<c:forEach var="stud" items="${studentss}">
				    			<option value="${stud.id}">${stud.name}</option>
				    		</c:forEach>
						</select>
					</td>
					<td colspan="1">
						<input value="Add" type="submit" class="btn btn-outline-success" style="width: 100%"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<hr>
	<table class="col-3 mx-auto table table-striped table-bordered text-center">
		<thead>
			<tr class="bg-info">
				<th>Student</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<td><a href="/students/${student.id}"><c:out value="${student.name}"/></a></td>
					<td><a href="/students/remove/${student.id}"><c:out value="Remove"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
