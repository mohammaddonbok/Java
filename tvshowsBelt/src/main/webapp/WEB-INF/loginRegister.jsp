<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/17/2021
  Time: 11:27 AM
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
    <link rel="stylesheet" type="text/css" href="loginRegister.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <title>Index Page</title>
</head>
<body>
<div id="wrapper">
    <div id="register">
            <h1>Register</h1>
            <p style="color: red;"><form:errors path="user.*"/></p>
            <form:form method="POST" action="/users" modelAttribute="user">
                <p>
                    <form:label path="name">Name:</form:label><br>
                    <form:input type="text" path="name"/>
                </p>
                <p>
                    <form:label path="email">Email:</form:label><br>
                    <form:input type="email" path="email"/>
                </p>
                <p>
                    <form:label path="password">Password:</form:label><br>
                    <form:password path="password"/>
                </p><br>
                <p>
                    <form:label path="passwordConfirmation">Password Confirmation:</form:label><br>
                    <form:password path="passwordConfirmation"/>
                </p>
                <button type="submit" class="btn btn-dark">Register</button>
            </form:form>
        </div>

        <div id = "login">
            <h1>Log In</h1>
            <p style="color: #ff0000;"><c:out value="${error}" /></p>
            <form method="post" action="/login">
                <p>
                    <label for="email">Email</label><br>
                    <input type="text" id="email" name="email"/>
                </p>
                <p>
                    <label for="password">Password</label><br>
                    <input type="password" id="password" name="password"/>
                </p>
                <button type="submit" class="btn btn-dark">Login</button>
            </form>
        </div>
    </div>
</body>
</html>