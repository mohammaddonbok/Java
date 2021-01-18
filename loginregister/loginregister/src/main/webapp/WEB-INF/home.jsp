<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <style>
        #wrapper {
            padding: 25px;
            background-color: lightgrey;
        }
    </style>
</head>
<body>
<div id = "wrapper">
    <h1>Welcome, ${user.firstName} ${user.lastName}</h1>
    <a href = "/logout">Log Out!</a>
</div>
</body>
</html>