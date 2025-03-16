<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>Insert title here</title>
</head>
<body>
	<div class="container p-5">
		<h1>All Books:</h1>
		<table class="table table-striped">
  		<thead>
    		<tr>
    			<th scope="col">ID</th>
      			<th scope="col">Title</th>
      			<th scope="col">Language</th>
      			<th scope="col">#Pages</th>
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="b" items="${books}">
    			<tr>
    				<td><c:out value="${b.id}"></c:out></td>
    				<td class="text-uppercase"><a href="/book/${b.id}" class="link-primary text-decoration-none"><c:out value="${b.title}"></c:out></a></td>
					<td><c:out value="${b.language}"></c:out></td>
      				<td><c:out value="${b.nbreofpages}"></c:out></td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>	
	</div>
	
</body>
</html>