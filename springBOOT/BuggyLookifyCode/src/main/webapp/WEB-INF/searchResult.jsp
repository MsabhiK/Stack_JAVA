<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Search result</title>
</head>
<body>
	<h2 class="float-left">Songs by: <c:out value="${searchTerm}"></c:out></h2>
	
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
		<c:forEach var="song" items="${songs}">
			<tr>
				<td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
				<td><c:out value="${song.rating}"></c:out></td>
				<td><a href="/songs/${song.id}/delete">delete</a></td>
			</tr>	
		</c:forEach>
    </tbody>
</table>
</body>
</html>