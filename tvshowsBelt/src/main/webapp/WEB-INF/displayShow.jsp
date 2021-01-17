<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/17/2021
  Time: 11:41 AM
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
    <title>Show TV Show Page</title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <a href="/shows">TV Shows</a>
    <a href="/shows">Dashboard</a>

    <a href="/shows/new">Add Show</a>

    <a href="/logout">Log Out</a>
</nav>

<div class="container mt-3" ">
    <div class="row">
        <div class="col-xs-6 col-md-6">
            <h1><c:out value="${show.title}" /></h1>
            <h6>Network: <c:out value="${show.network}" /></h6>
            <h6>Average Rating: <c:out value="${show.avgRating}" /></h6>
            <c:if test = "${show.userTitle.id == user.id}">
                <p><a href="/shows/${show.id}/edit"><button class="btn btn-dark">Edit This Show</button></a></p>
            </c:if>
            <hr>
            <h3 class="text-center">Users who rated this show:</h3>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Rating</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${show.reviews}" var="s">
                    <tr>
                        <td>${s.user.name}</td>
                        <td>${s.rating}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
        <div class="col-xs-6 col-md-6">
            <h3>Rate this Show</h3>
            <p style="color: red;"><c:out value="${error}" /></p>
            <p style="color: red;"><form:errors path="review.*"/></p>
            <form:form method="POST" action="/shows/${show.id}/review" modelAttribute="review">
                <p>
                    <form:label path="rating">Rating:</form:label>
                    <form:select path="rating">
                        <form:option value="5">5</form:option>
                        <form:option value="4">4</form:option>
                        <form:option value="3">3</form:option>
                        <form:option value="2">2</form:option>
                        <form:option value="1">1</form:option>
                    </form:select>
                </p>
                <form:input type="hidden" path="user" value="${user.id}" />
                <form:input type="hidden" path="show" value="${show.id}" />
                <button type="submit" class="btn btn-dark">Rate</button>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>