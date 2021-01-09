<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/style.css"
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome, again</title>
</head>
<body>
<h1> Your Gold : ${gold}</h1>

<div class = "wrapper">
    <div class="location">
        <h1> Farm </h1>
        <h2> earn 10 -20 Gold </h2>
        <form action= "/" method="POST">
            <input name="farm" type="submit" value = "Find Gold!"/>
        </form>
    </div>
    <div class="location">
        <h1> Cave </h1>
        <h2> earn 5 -10 Gold </h2>
        <form action= "/" method="POST">
            <input name="cave" type="submit" value = "Find Gold!"/>
        </form>
    </div>
    <div class="location">
        <h1> House </h1>
        <h2> earn 2-5 Gold </h2>
        <form action= "/" method="POST">
            <input name="house" type="submit" value = "Find Gold!"/>
        </form>
    </div>
    <div class="location">
        <h1> Casino </h1>
        <h2> earn 0 - 50 Gold </h2>
        <form action= "/" method="POST">
            <input name="casino" type="submit" value = "Find Gold!"/>
        </form>
    </div>

    <div>
        <c:forEach var="activity" items="${activites}" >
            <h1> ${activity}</h1>
        </c:forEach>
    </div>



</body>
</html>
