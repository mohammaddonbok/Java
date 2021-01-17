<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/17/2021
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="js/time.js"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>New Show Page</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
                <a href="/shows">Dashboard</a>
                <a  href="/shows/new">Add Show <span class="sr-only">(current)</span></a>
                <a class="nav-link" href="/logout">Log Out</a>
</nav>
<div class="container mt-3">
    <h1>Create a new show</h1>
    <p style="color: red;"><form:errors path="show.*"/></p>

    <form:form method="POST" action="/shows" modelAttribute="show">
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title"/>
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:input type="text" path="network"/>
        </p>
        <form:input type="hidden" path="userTitle" value="${user.id}"/>
        <input type="submit" value="Add TV Show"/>
    </form:form>
</div>
</body>
</html>