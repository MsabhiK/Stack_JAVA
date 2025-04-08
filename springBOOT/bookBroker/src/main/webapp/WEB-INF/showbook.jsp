<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container p-3">
		<div class="d-flex justify-content-between bd-highlight">
			<div class="bd-highlight fw-bold align-items-end"><h1><c:out value="${book.title}"/></h1></div>
  			<div class="bd-highlight d-flex"><a href="/books">back to the shelves!</a></div>
  		</div>
  	</div>
	<div class="container">
		<c:choose>
			<c:when test="${user.userName.equals(book.user.userName)}">
				<h3 class="font-monospace fw-bold"><span class="text-danger">You</span> read <span class="text-info"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.authorName}"/></span></h3>
				<h5>Here are your's thoughts:</h5>
				<hr />
				<p><c:out value="${book.description}"/></p>
				<hr />
				<div class="form-group p-2 mx-2">
		        	<a href="/books/${book.id}/remove"><input type="button" value="delete" class="btn btn-outline-danger text-secondary fw-bold float-end" style="width:100px;"></a>
		        	<a href="/books/${book.id}/edit"><input type="button" value="edit" class="btn btn-outline-primary  text-secondary fw-bold float-end mx-3" style="width:100px;"></a>
        		</div>
			</c:when>
			<c:otherwise> 
				<h3 class="font-monospace fw-bold"><span class="text-danger"><c:out value="${book.user.userName}"/></span> read <span class="text-info"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.authorName}"/></span></h3>
				<h5>Here are <c:out value="${book.user.userName}"/>'s thoughts:</h5>
				<hr />
					<p><c:out value="${book.description}"/></p>
				<hr />
			</c:otherwise>
		</c:choose>
		
	</div>
		

</body>
</html>

<!-- 

 -->