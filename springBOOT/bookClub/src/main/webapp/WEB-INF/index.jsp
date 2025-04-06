<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Authentifications</title>
</head>
<body>
	<div class="card-body p-4">
    	<h1 class="card-title text-uppercase">Welcome!</h1>
    	<h4 class="card-text">Join our growing community:</h4>
  	</div>    
    <div class="d-flex justify-content-around">
        <form:form action="/register" method="post" modelAttribute="newUser" class="col-4 bg-light p-4 my-0 text-dark">
            <h2 class="text-primary">Registration</h2>
            <div>
				<form:label path="userName">Full Name:</form:label><br>
                <form:errors path="userName" class="text-danger"/>
                <form:input type="text" path="userName" class="form-control"/>
            </div>			
			<div>
				<form:label path="email">Email:</form:label><br>
				<form:errors path="email" class="text-danger"/>
	  			<form:input type="text" path="email" class="form-control"/>
	  		</div>	
            <div>
				<form:label path="password">Password:</form:label><br>
				<form:errors path="password" class="text-danger"/>
	  			<form:input type="password" path="password" class="form-control"/>
	  		</div>	
            <div>
				<form:label path="confirm">Confirm Password:</form:label><br>
				<form:errors path="confirm" class="text-danger"/>
	  			<form:input type="password" path="confirm" class="form-control"/>
	  		</div>	
            <button type="submit" class="btn btn-primary float-end my-2">Register</button>   
        </form:form>
        
        <form:form action="/login" method="post" modelAttribute="newLogin" class="col-4 bg-light p-4 my-0 text-dark">
            <h2 class="text-success">Login</h2>
            <div>
				<form:label path="email">Email:</form:label><br>
				<form:errors path="email" class="text-danger"/>
	  			<form:input type="text" path="email" class="form-control"/>
	  		</div>	
            <div>
				<form:label path="password">Password:</form:label><br>
				<form:errors path="password" class="text-danger"/>
	  			<form:input type="password" path="password" class="form-control"/>
	  		</div>	

            <button type="submit" class="btn btn-success float-end my-2">Login</button>
        </form:form>
    </div>

</body>
</html>