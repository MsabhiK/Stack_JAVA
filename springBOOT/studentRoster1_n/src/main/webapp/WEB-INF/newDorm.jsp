<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>New Dorm</title>
    <link rel="stylesheet" href="/css/style.css"> 
</head>
<body class="mx-auto p-4" style="width: 45%">
	<h1 class="text-center">New Dorm</h1>
	<p><a href="/">Dashboard</a></p>
	<form:form action="/dorms/new" modelAttribute="dorm" method="post">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td><form:label path="name" for="name">Name:</form:label></td>
					<td><div><form:errors path="name" class="text-danger"/><form:input path="name" type="text" style="width: 100%" class="form-control"/></div></td>
				</tr>
				<tr>
					<td colspan="2"><input value="Add" type="submit" class="btn btn-outline-success" style="width: 100%"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>
</html>
