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
	<title>Acceuil</title>
</head>
<body>
    <div class="d-flex justify-content-around">
        <form:form action="/dojos/add" method="post" modelAttribute="dojo" class="col-4 bg-white p-5 my-3 text-dark">
            <h2 class="text-center text-primary text-uppercase">New DOJO</h2>
            <div class="form-group">
					<form:label path="name">Name:</form:label>
                	<form:errors path="name" class="text-danger"/>
                	<form:input type="text" path="name" class="form-control"/>
            </div>
            <div class="form-group p-2 my-2">
            <input type="submit" value="Create" class="btn btn-outline-success btn-primary text-white">
            <a href="/ninjas/new"><input type="button" value="NEW NINJA" class="btn btn-outline-warning float-end"></a>
            </div>
        </form:form>
        <div class="col-2 bg-secondary p-2 text-dark bg-opacity-10 my-5 text-center">
            <h2 class="text-primary text-uppercase">All DOJO</h2>
            <c:forEach var="dojo" items="${dojos}">
            <p>
               <a href="/dojos/${dojo.id}" class="text-uppercase text-decoration-nones text-secondary text-opacity-75 fw-bold"><c:out value="${dojo.name}"></c:out></a>
            </p>
            </c:forEach>
        </div>
    </div>

</body>
</html>