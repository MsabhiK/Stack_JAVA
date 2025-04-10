<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title><c:out value="${student.name}"/></title>
</head>
<body class="mx-auto p-4" style="width: 45%">
	<h1 class="text-center"><c:out value="${student.name}"/>'s classes</h1>
	<p><a href="/">Dashboard</a></p>
	
	<form action="/students/${student.id}/addcourseTOstudent" method="post">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td colspan="1">
						<label for="courseId">Classes:</label>
						<select name="courseId" class="input form-select" aria-label="Default select">
				    		<c:forEach var="course" items="${availableCourses}">
				    			<option value="${course.id}">${course.nameCourse}</option>
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
				<th>Class Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="course" items="${assignedCourses}">
				<tr>
					<td><a href="/classes/${course.id}"><c:out value="${course.nameCourse}"/></a></td>
					<td><a href="/students/${student.id}/classes/${course.id}/drop"><c:out value="Drop"/></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>