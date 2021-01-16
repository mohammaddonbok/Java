<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Events Signup Page</title>
    <link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="start.css">
</head>
<body>
<div id = "wrapper">
    <h1>Welcome! Please sign in below! </h1>
    <div id = "register">
        <h2>Register here!</h2>

        <form:form method = "POST" action = "/register" modelAttribute = "user">
            <p>
                <form:label path = "firstName">First Name:</form:label>
                <form:errors path = "firstName"/><br>
                <form:input path = "firstName"/>
            </p>
            <p>
                <form:label path = "lastName">Last Name: </form:label>
                <form:errors path = "lastName"/><br>
                <form:input path = "lastName"/>
            </p>
            <p>
                <form:label path = "email">Email:</form:label>
                <form:errors path = "email"/><br>
                <form:input path = "email"/>
            </p>
            <form:label path = "city">Location:</form:label>
            <form:errors path = "city"/><br>
            <form:input path = "city"/>

            <form:select path = "state" cssclass="dropdown-menu">
                <option value="AL" cssclass="dropdown-item">Alabama</option>
                <option value="CA" cssclass="dropdown-item">California</option>

                <option value="AK" cssclass="dropdown-item">Alaska</option>
                <option value="AZ" cssclass="dropdown-item">Arizona</option>
                <option value="AR" cssclass="dropdown-item">Arkansas</option>
                <option value="CO" cssclass="dropdown-item">Colorado</option>
                <option value="CT" cssclass="dropdown-item">Connecticut</option>
                <option value="DE" cssclass="dropdown-item">Delaware</option>
                <option value="DC" cssclass="dropdown-item">District Of Columbia</option>
            </form:select>
            <p>
                <form:label path = "password">Password:
                    (Must be at least 6 characters long, have no white spaces, and have one more instance
                    of the following: uppercase letter, lowercase letter, and a number)</form:label>
                <form:errors path = "password"/><br>
                <form:password path = "password"/>
            </p>
            <p>
                <form:label path = "passwordConfirmation">Password Confirmation:</form:label>
                <form:errors path = "passwordConfirmation"/><br>
                <form:password path = "passwordConfirmation"/>
            </p>
            <button type="submit" class="btn btn-dark">Register</button>

        </form:form>
    </div>

    <div id = "login">
        <h2>Login here!</h2>
        <p><c:out value = "${error}" /></p>
        <form method = "POST" action = "/login">
            <p>
                <label for = "email">Email</label><br>
                <input type = "text" id = "email" name = "email"/>
            </p>
            <p>
                <label for = "password">Password</label><br>
                <input type = "password" id = "password" name = "password"/>
            </p>
            <button type="submit" class="btn btn-dark">Login</button>
        </form>
    </div>
</div>
</body>
</html>