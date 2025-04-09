<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>show product</title>
</head>
<body class="container p-3">
	<h1>${product.name}</h1>
	<p><a href="/">Home</a></p>
	<hr>
	<p>Description: <c:out value="${product.description}"/></p>
	<p>Price: <c:out value="${product.price}"/> dinars(DT)</p>
	<hr>
	<h3>Categories:</h3>
	<ul>
		<c:forEach var="category" items="${categoriesByProduct}">
			<li><c:out value="${category.name}"></c:out></li>
		</c:forEach>
	</ul>
	<hr>
	<form action="/products/${id}" method="post">
		<h4>Add Category:</h4>				
		<select name="categoryId" id="categoryId" class="input">
		    <c:forEach var="category" items="${notAssignedCategories}">
		    	<option value="${category.id}">${category.name}</option>
		    </c:forEach>
		</select>
		<input class="input" class="button" type="submit" value="Add"/>
	</form>
</body>
</html>