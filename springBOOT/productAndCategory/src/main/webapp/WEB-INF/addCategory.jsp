<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Add Category</title>
</head>
<body class="container p-3">
	<h1>New Category</h1>
	<p><a href="/">Home</a></p>
	<hr>
	
	<form:form action="/categories/new" method="post" modelAttribute="category" class="p-4 my-5 bg-light text-dark fw-bolder" style="width:300px; height:150px;">
	
		<table>
		    <thead>
		    	<tr>
		            <td class="float-left">Name:</td>
		            <td class="float-left">
		            	<form:errors path="name" class="text-danger"/>
						<form:input class="input" path="name"/>
		            </td>
		        </tr>
		        <tr>
		        	<td colspan=2><input class="input" class="button btn btn-dark" type="submit" value="Submit"/></td>
		        </tr>
		    </thead>
		</table>
	</form:form>
</body>
</html>