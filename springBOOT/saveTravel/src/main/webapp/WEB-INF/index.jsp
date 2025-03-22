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
	<title>Dashboard</title>
</head>
<body>
	<div class="container p-3">
		<h1 class="text-primary">Save Travel:</h1>
		<table class="table table-striped table-bordered text-align-center">
  		<thead>
    		<tr class="table-info text-center">
    			<th scope="col">Expense</th>
      			<th scope="col">Vendor</th>
      			<th scope="col">Amount</th>
      			<th scope="col">Action</th>
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="depense" items="${depenses}">
    			<tr>
    				<td class="text-uppercase text-center link-primary text-decoration-underline"><a href="expense/${depense.id}"> <c:out value="${depense.expense}"></c:out></a></td>
					<td class="text-center"><c:out value="${depense.vendor}"></c:out></td>
					<td class="text-center">$<fmt:formatNumber type="number" minFractionDigits="2" value="${depense.amount}"/></td>
      				<!--<td class="text-light">$<c:out value="${depense.amount}"></c:out></td>-->
      				<td class="text-center">
						<a href="/expense/edit/${depense.id}" class="link-primary text-decoration-underline">edit</a> |
						<a href="/expense/delete/${depense.id}"><input type="hidden" name="_method" value="delete"><button type="button" class="btn btn-outline-danger">delete</button></a>  
						<!--<form action="/expense/delete/${depense.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="delete" class="btn btn-outline-danger"/>
						</form>-->
      				</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    	</table>
 
    	<form:form action="/expense/new" method="POST" modelAttribute="depense" class="col-6 p-2">  
			<h3 class="text-primary">Add an Expense:</h3>
			<div class="row g-2 align-items-center">
				<div>
					<form:label path="expense">Expense Name:</form:label><br>
                	<form:errors path="expense" class="text-danger"/>
                	<form:input type="text" path="expense" class="form-control"/>
            	</div>			
				<div>
					<form:label path="vendor">Vendor Name:</form:label><br>
					<form:errors path="vendor" class="text-danger"/>
	  				<form:input type="text" path="vendor" class="form-control"/>
	  			</div>	
				<div>
                	<form:label path="amount">Amount ($):</form:label><br>
	                <form:errors path="amount" class="text-danger"/>
	                <form:input type="number" step="0.01" min="0" path="amount" class="form-control"/>
	            </div>
           		<div>
					<form:label path="description">Description:</form:label><br>
					<form:errors path="description" class="text-danger"/>
	  				<form:textarea class="form-control" path="description" style="height:100px;"></form:textarea>
	  			</div>
			</div>
            <div class="form-group p-3 float-end">
            	<input type="submit" value="Submit" class="btn btn-primary"/>
            </div>
		</form:form>
 
	</div>
	
</body>
</html>