<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<title>Song Info</title>
</head>
<body>
	<br>
	<br>
	
	<h1 class="float-left">Song details:</h1>
	<table>
    	<thead>
    		<tr>
	            <td class="float-left">Title:</td>
	            <td class="float-left"><c:out value="${song.title}"></c:out></td>
        	</tr>
        	<tr>
	            <td class="float-left">Artist:</td>
	            <td class="float-left"><c:out value="${song.artist}"></c:out></td>
        	</tr>
        	<tr>
	            <td class="float-left">Rating (1-10):</td>
	            <td class="float-left"><c:out value="${song.rating}"></c:out></td>
        	</tr>
    	</thead>
	</table>
	<br>
	<p class="float-left"><a href="/dashboard">Dashboard</a></p>
</body>
</html>