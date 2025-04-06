<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Edit Book</title>
</head>
<body class="bg-secondary">
	<div class="container p-3">
		<div class="d-flex justify-content-between bd-highlight">
			<div class="bd-highlight fw-bold align-items-end"><h3>Change your entry!:</h3></div>
  			<div class="bd-highlight d-flex"><a href="/books">back to the shelves!</a></div>
  		</div>
  		
  		<form:form action="/books/${book.id}/edit" method="put" modelAttribute="book" class="p-4 my-5 text-dark fw-bolder" style="width:1000px; height:350px;">
  			<input type="hidden" name="_method" value="put">
	        <div class="row mb-3">
	        	<form:label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" path="title"></form:label>
		        <div class="col-sm-10">
		        	<p><form:errors path="title" class="text-danger"/></p>
		        	<p><form:errors path="authorName" class="text-danger"/></p>
		        	<p><form:errors path="description" class="text-danger"/></p>
		        </div>
		    </div>
	        <div class="row mb-3">
				<form:label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" path="title">Title:</form:label>
				<div class="col-sm-10">
	            	<form:input type="text" path="title" value="${book.title}" class="form-control form-control-lg" placeholder="add Book's title"/>
	            </div>
	        </div>
	        <div class="row mb-3">
				<form:label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" path="authorName">Author Name:</form:label>
				<div class="col-sm-10">
	            	<form:input type="text" path="authorName" value="${book.authorName}" class="form-control form-control-lg" placeholder="add Book's author Name"/>
	            </div>
	        </div>
	        <div class="row mb-3">
				<form:label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg" path="description">My Thoughts:</form:label><br>
				<div class="col-sm-10">
	  				<form:textarea class="form-control form-control-lg" path="description" value="${book.description}" style="height:100px;" placeholder="add description"></form:textarea>
	  			</div>
	  		</div>
	  		<div class="form-row">
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
			</div>
	        	<input type="submit" value="Submit" class="btn btn-outline-primary btn-light text-dark float-end">
    	</form:form>
  		
  	</div>

</body>
</html>