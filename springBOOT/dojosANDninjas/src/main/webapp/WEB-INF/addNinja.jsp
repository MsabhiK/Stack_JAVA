<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>New Ninja</title>
</head>
<body>
    <form:form action="/ninjas/add" method="post" modelAttribute="ninja" class="col-4 bg-success bg-opacity-10 p-4 my-5 mx-auto text-dark fw-bolder">
        <h2 class="text-center text-success text-uppercase">New NINJA</h2>
        <div class="form-group p-2">
            <form:label path="dojo">Dojos:</form:label>
        	<form:select path="dojo" class="form-select">
        		<c:forEach var="oneDojo" items="${dojos}">
	        		<option value="${oneDojo.id}"><c:out value="${oneDojo.name}"/></option>
        		</c:forEach>
        	</form:select>
        </div>
        <div class="form-group p-2">
			<form:label path="first_name">First_name:</form:label>
            <form:errors path="first_name" class="text-danger"/>
            <form:input type="text" path="first_name" class="form-control"/>
        </div>
        <div class="form-group p-2">
			<form:label path="last_name">Last_name:</form:label>
            <form:errors path="last_name" class="text-danger"/>
            <form:input type="text" path="last_name" class="form-control"/>
        </div>
        <div class="form-group p-2">
			<form:label path="age">Âge:</form:label>
            <form:errors path="age" class="text-danger"/>
            <form:input type="number" path="age" class="form-control"/>
        </div>
        <div class="form-group p-2">
        	<input type="submit" value="Add new Ninja" class="btn btn-outline-success btn-secondary text-white">
        	<a href="/"><input type="button" value="Dashboard" class="btn-primary btn btn-outline-dark float-end"></a>
        </div>
    </form:form>

</body>
</html>