<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Event</title>
    <link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <style>
        #wrapper {
            background-color: lightgrey;
            height: 650px;
        }
        #top {
            padding: 25px;
            padding-left: 70px;
            font-size: 24px;
            background-color: #9ee57a;
        }
        h1 {
            display: inline-block;
        }
        #topright {
            margin-left: 900px;
            display: inline-block;
        }
        #blackline {
            height: 3px;
            background-color: black;
        }
        #main {
            padding: 15px;
            padding-left: 70px;
        }
    </style>
</head>
<body>
<div id = "wrapper">
    <div id = "top">
        <h1>Edit Event</h1>
        <div id = "topright">
            <a href = "/events">Back</a>
        </div>
    </div>
    <div id = "blackline"></div>
    <div id = "main">
        <p><c:out value = "${error}" /></p>
        <form method = "POST" action = "/events/${event.id}/edit/process">
            <p>Name:</p>
            <input type = "text" name = "name" value = "${event.name}"/><br>
            <p>Date:</p>
            <input type = "date" name = "date" value = "${event.date}"/><br>
            <p>Location:</p>
            <input type = "text" name = "city" value = "${event.city}"/>
            <select name = "state" cssclass="dropdown-menu">
                <option value="AL" cssclass="dropdown-item">Alabama</option>
                <option value="CA" cssclass="dropdown-item">California</option>
                <option value="AK" cssclass="dropdown-item">Alaska</option>
                <option value="AZ" cssclass="dropdown-item">Arizona</option>
                <option value="AR" cssclass="dropdown-item">Arkansas</option>
                <option value="CO" cssclass="dropdown-item">Colorado</option>
                <option value="CT" cssclass="dropdown-item">Connecticut</option>
                <option value="DE" cssclass="dropdown-item">Delaware</option>
                <option value="DC" cssclass="dropdown-item">District Of Columbia</option>
            </select>
            <br><br>
            <button type="submit" class="btn btn-dark">Edit</button>
        </form>
    </div>
</div>
</body>
</html>