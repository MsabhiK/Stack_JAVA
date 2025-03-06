<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Fruit Store</title>
</head>
<body>
	<div class="container">
		<h1>Hello</h1>
		<table class="table table-striped">
  		<thead>
    		<tr>
      			<th scope="col">Name</th>
      			<th scope="col">Price</th>
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="oneFruit" items="${fruitsFromMyController}">
    			<tr>
    				<c:choose>
    					<c:when test="${oneFruit.name.startsWith('G')}">
							<td style="color:red;"><c:out value="${oneFruit.name}"></c:out></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${oneFruit.name}"></c:out></td>
						</c:otherwise>
    				</c:choose>
      				<td><c:out value="${oneFruit.price}$"></c:out></td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>	
	</div>
</body>
</html>



