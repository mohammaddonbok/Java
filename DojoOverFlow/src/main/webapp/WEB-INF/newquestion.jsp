<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Question</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
        #wrapper {
            background-color: rgb(129, 216, 219);
            padding: 30px;
        }
        h1{
            display: inline-block;
        }
        a {
            color: white;
            font-size: 25px;
            display: inline-block;
            padding-left: 600px;
        }
    </style>
</head>
<body>
<div id = "wrapper">
    <h1>Submit a Question</h1>
    <a href = "/questions">Back to Dashboard</a>
    <form action = "/questions/new/process" method = "post">
        <p>
            <c:out value = "${question}"/><br>
            Question: <br><br>
            <textarea name = "question" cols = "50" rows = "4"></textarea>
        </p>
        <p>
            <c:out value = "${tag}"/><br>
            Tags: <input type = "text" name = "tags">
        </p>
        <input type = "submit" value = "Add Question"/>
    </form>
</div>
</body>
</html>