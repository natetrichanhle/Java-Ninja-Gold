<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>
	<h1>Your Gold: <c:out value="${ showGold }"/></h1>
	<div>
		<form action="/farm" method="POST">
			<label>Farm <br> (earns 10-20 gold) <br></label>
			<input type="submit" placeholder="Find Gold" name="farm">
		</form>
		<form action="/cave" method="POST">
			<label>Cave <br> (earns 5-10 gold) <br></label>
			<input type="submit" placeholder="Find Gold" name="cave">
		</form>
	</div>
	<div>
    <span>Activities:</span>
    <div>
    <ul>
        <c:forEach var="activities" items="${activity}">
        <li><c:out value="${activities}" /></li>
        </c:forEach>
    </ul>
    </div>
</div>
</body>
</html>