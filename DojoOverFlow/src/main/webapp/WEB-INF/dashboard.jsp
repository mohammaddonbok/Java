<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Questions Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
        #wrapper {
            background-color: rgb(129, 216, 219);
            padding: 30px;
        }
        h1 {
            text-align: center;
        }
        #top a{
            padding-left: 170px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            margin: 20px;
            margin-left: 150px;
            margin-bottom: 30px;
        }
        th {
            text-align: left;
            border: 1px solid black;
            border-collapse: collapse;
            color: white;
            padding: 5px;
            padding-left: 10px;
            padding-right: 400px;
            background-color: blue;
            font-size: 18px;
        }
        tr td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 10px;
            background-color: rgb(237, 241, 248);
            font-size: 18px;
        }
    </style>
</head>
<body>
<div id = "wrapper">
    <div id = "top">
        <h1>Questions Dashboard</h1>
        <h4><a href = "/questions/new">Add a new question</a></h4>
    </div>
    <table>
        <thead>
        <tr>
            <th>Questions</th>
            <th>Tags</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items = "${questions}" var = "q">
            <tr>
                <td><a href = "/questions/${q.id}">${q.question}</a></td>
                <td><c:forEach items = "${q.tags}" var = "t">
                    ${t.subject},
                </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>