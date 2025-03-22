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
	<div class="container p-5 d-flex flex-wrap justify-content-around">
		<div class="col-6 p-3 text-dark">
			<h1>Expense Details:</h1>
			<table class="table table-bordered">
				<tr>
					<td>Expense Name: </td>
					<td><c:out value="${depense.expense}"/></td>
				</tr>
				<tr>
					<td>Expense Description: </td> 
					<td><c:out value="${depense.description}"/></td>
				</tr>
				<tr>
					<td>Vendor: </td> 
					<td><c:out value="${depense.vendor}"/></td>
				</tr>
				<tr>
					<td>Amount: </td>
					<td>$<c:out value="${depense.amount}"/></td>
				</tr>
			</table>			
		</div>
		<div>
			<a href="/"><button type="button" class="btn btn-outline-info p-3">Go back</button></a>
		</div>
	</div>

</body>
</html>