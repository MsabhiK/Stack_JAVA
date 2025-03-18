<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Acceuil burger</title>
</head>
<body class="bg-dark text-light">
	<div class="container p-5">
		<h1>Burger Tracker:</h1>
		<table class="table table-striped">
  		<thead>
    		<tr class="table-info">
    			<th scope="col">ID</th>
      			<th scope="col">Burger Name</th>
      			<th scope="col">Restaurant Name</th>
      			<th scope="col">Rating(out of 5)</th>
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="burg" items="${burgers}">
    			<tr>
    				<td class="text-light"><c:out value="${burg.id}"></c:out></td>
    				<td class="text-uppercase text-light"><a href="/book/${burg.id}" class="link-primary text-decoration-none"><c:out value="${burg.burgerName}"></c:out></a></td>
					<td class="text-light"><c:out value="${burg.restaurantName}"></c:out></td>
      				<td class="text-light"><c:out value="${burg.rating}"></c:out></td>
    			</tr>
    		</c:forEach>
    	</tbody>
    	</table>
    	<form:form action="/burger/new" method="POST" modelAttribute="burger" class="col-6 p-3 bg-dark text-light">
			<h2 class="text-warning">Add a Burger:</h2>
			<div class="form-group">
                <form:label path="burgerName">Burger Name:</form:label>
                <form:errors path="burgerName" class="text-danger"/>
                <form:input type="text" path="burgerName" class="form-control"/>
            </div>

			<div class="form-group">
				<form:label path="restaurantName">Restaurant Name:</form:label>
				<form:errors path="restaurantName" class="text-danger"/>
  				<form:input type="text" path="restaurantName" class="form-control"/>
			</div>
			
			<div class="form-group">
                <form:label path="rating">Rating(out of 5):</form:label>
                <form:errors path="rating" class="text-danger"/>
                <form:input type="number" path="rating" class="form-control"/>
            </div>
            <div class="form-group">
				<form:label path="note">Note:</form:label>
				<form:errors path="note" class="text-danger"/>
  				<form:textarea class="form-control" path="note" style="height: 100px"></form:textarea>
			</div>
            <div class="form-group p-3">
            	<input type="submit" value="Submit" class="btn btn-warning"/>
            </div>
		</form:form>
    
	</div>
	
</body>
</html>