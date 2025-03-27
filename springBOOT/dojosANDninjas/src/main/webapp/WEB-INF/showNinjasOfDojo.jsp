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
	<title>Show Ninjas of Dojo</title>
</head>
<body>
	<div class="container mx-auto my-5">
	    <div class="card-body">
        <h1 class="card-title text-warning text-uppercase">Ninjas from: <c:out value="${dojo.name}"/></h1>
        <table class="table table-hover my-2">
            <thead class="bg-secondary text-white">
                <tr>
                    <th>Full Name</th>
                    <th>Age</th>
                    <th>Created At</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ninja" items="${dojo.ninjas}">
                <tr>
                    <td><c:out value="${ninja.first_name}"/> <c:out value="${ninja.last_name}"/></td>
                    <td><c:out value="${ninja.age}"/></td>
                    <td><c:out value="${ninja.createdAt}"/></td>
                    <td>
                        <a href="/ninjas/edit/${{ninja.id}}">Edit</a> |
                        <a href="/ninjas/delete/${{ninja.id}}/${{dojo.id}}">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="/" class="btn btn-primary">HOME</a>
  </div>
	
</body>
</html>