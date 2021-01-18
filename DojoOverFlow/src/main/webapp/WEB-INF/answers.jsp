<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Question Profile</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
        #wrapper {
            background-color: rgb(129, 216, 219);
            padding: 30px;
            padding-left: 120px;
        }
        h1 {
            text-align: center;
            padding-right: 50px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            margin-top: 20px;
            margin-bottom: 30px;
        }
        th {
            text-align: left;
            border: 1px solid black;
            border-collapse: collapse;
            color: white;
            padding: 5px;
            padding-left: 10px;
            padding-right: 350px;
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
        #answers {
            display: inline-block;
            width: 680px;
        }
        #submitanswer{
            display: inline-block;
            vertical-align: top;
            margin-left: 20px;
            margin-top: 20px;
            width: 350px;
        }
    </style>
</head>
<body>
<div id = "wrapper">
    <h1>${question.getQuestion()}</h1>
    <h3>Tags: </h3><c:forEach items = "${question.getTags()}" var = "t">
    ${t.getSubject()},
</c:forEach>
    <div id = "main">
        <div id = "answers">
            <table>
                <thead>
                <tr>
                    <th>Answers</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items = "${question.getAnswers()}" var = "a">
                    <tr>
                        <td>${a.answer}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div id = "submitanswer">
            <h4>Add your answer:</h4>
            <c:out value = "${answer}"/><br>
            <form action = "/questions/${question.getId()}/answer" method = "post">
                <p>
                    <textarea name = "answer" cols = "50" rows = "4"></textarea>
                </p>
                <input type = "submit" value = "Answer!"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>