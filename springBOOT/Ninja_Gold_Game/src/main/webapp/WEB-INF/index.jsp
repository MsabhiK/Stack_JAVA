<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<title>NINJA GOLD GAME</title>
</head>
<body>
<div class="container">
        <div class="d-flex flex-column  mt-3">
           
            <p>YOUR GOLD: <c:out value ="${gold}"/></p>
            <form action="/reset" method="POST"><input class="button" type="submit" value="RESET"/></form>
        </div>
        <div class="d-flex gap-2 mt-2">
            <form action="/" method="post" class="card bg-light col-2 text-center">
                <h3>HOUSE</h3>
                <p>(earns2 - 5 golds)</p>
                <input type="hidden" name="house" />
                <input type="submit" class="bg-success" value="Find Gold!"/>
            </form>
            <form action="/" method="post" class="card bg-light col-2 text-center">
                <h3>CAVE</h3>
                <p>(earns5 - 10 golds)</p>
                <input type="hidden" name="cave" />
                <input type="submit" class="bg-danger" value="Find Gold!"/>
            </form>
            <form action="/" method="post" class="card bg-light col-3 text-center">
                <h3>FARM</h3>
                <p>earns(10 - 20 golds)</p>
                <input type="hidden" name="farm" />
                <input type="submit" class="bg-primary" value="Find Gold!"/>
            </form>

            <form action="/" method="post" class="card bg-light col-3 text-center">
                <h3>QUEST</h3>
                <p>(earns/takes 0 - 50 golds)</p>
                <input type="hidden" name="quest" />
                <input type="submit" class="bg-warning" value="Find Gold!"/>
            </form>
            <form action="/" method="post" class="card bg-light col-2 text-center">
                <h3>SPA</h3>
                <p>(loses 5 - 20 golds)</p>
                <input type="hidden" name="spa" />
                <input type="submit" class="bg-info" value="Find Gold!"/>
            </form>
        </div>
        <h3>Activities:</h3>
			<iframe width="50%" src="/activities" title="Activities Iframe"></iframe>

    </div>

</body>
</html>