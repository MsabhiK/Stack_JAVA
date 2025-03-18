<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Show and edit Burger</title>
</head>
<body>
	<div class="container p-5 d-flex flex-wrap justify-content-around">
		<form:form action="/burger/${burger.id}" method="put" modelAttribute="burger" class="col-4 p-3 bg-dark text-light">
			<h2 class="text-center text-primary">Edit Burger:</h2>
			<!--<form:input type="hidden" path="id" value="${burger.id}" class="form-control"/>-->
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
                <form:label path="burgerName">Burger Name:</form:label>
                <form:errors path="burgerName" class="text-danger"/>
                <form:input type="text" path="burgerName" value="${burger.burgerName}" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="restaurantName">Restaurant Name:</form:label>
                <form:errors path="restaurantName" class="text-danger"/>
                <form:input type="text" path="restaurantName" value="${burger.restaurantName}" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="rating">rating(out of 5):</form:label>
                <form:errors path="rating" class="text-danger"/>
                <form:input type="number" path="rating" value="${burger.rating}" class="form-control" style="width:80px;"/>
            </div>
			<div class="form-group">
				<form:label path="note">Note:</form:label>
				<form:errors path="note" class="text-danger"/>
  				<form:textarea class="form-control" path="note" value="${burger.note}" style="height: 100px"></form:textarea>
			</div>
			
            <div class="form-group p-3 float-end">
            	<input type="submit" value="Submit" class="btn btn-primary"/>
            </div>
		</form:form>
		
		<div class="col-4">
			<h3 class="text-uppercase text-dark"><c:out value="${burger.burgerName}"/></h3>
			<p><span class="text-uppercase text-primary">Restaurant Name: </span> <c:out value="${burger.restaurantName}"/></p>
			<p><span class="text-uppercase text-primary">Note: </span><c:out value="${burger.note}"/></p>
			<p><span class="text-uppercase text-primary">Rating: </span><c:out value="${burger.rating}"/></p>
		</div>
		<div class="col-2">
			<a href="/"><button type="button" class="btn btn-outline-info">Retour à l'acceuil</button></a>
		</div>
	</div>

</body>
</html>