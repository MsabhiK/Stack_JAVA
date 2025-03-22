<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Edit depense</title>
</head>
<body>
	<div class="container p-5 d-flex flex-wrap justify-content-around">
		<form:form action="/expense/${depense.id}" method="put" modelAttribute="depense" class="col-6 p-3 bg-dark text-light">
			<h2 class="text-center text-success">Edit Expense:</h2>
			<!--<form:input type="hidden" path="id" value="${book.id}" class="form-control"/>-->
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
                <form:label path="expense">Expense Name:</form:label>
                <form:errors path="expense" class="text-danger"/>
                <form:input type="text" path="expense" value="${depense.expense}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <form:label path="vendor">Vendor Name:</form:label>
                <form:errors path="vendor" class="text-danger"/>
                <form:input type="text" path="vendor" value="${depense.vendor}" class="form-control"/>
            </div>
            
            <div class="form-group">
                <form:label path="amount">Amount:</form:label>
                <form:errors path="amount" class="text-danger"/>
                <form:input type="number" path="amount" value="${depense.amount}" class="form-control"/>
            </div>

			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="text-danger"/>
  				<form:textarea class="form-control" placeholder="Leave some description for the depense" path="description" value="${depense.description}" style="height: 100px"></form:textarea>
			</div>
			
            <div class="form-group p-3">
            	<input type="submit" value="Submit" class="btn btn-outline-primary float-end"/>
            </div>
		</form:form>
		<div>
			<a href="/"><button type="button" class="btn btn-outline-info">Go back</button></a>
		</div>
	</div>

</body>
</html>