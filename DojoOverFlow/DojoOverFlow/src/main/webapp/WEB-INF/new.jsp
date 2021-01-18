<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/13/2021
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>What is your question</h1>
    <form:form action="/" method="post" modelAttribute="newQuest">
        <div class="form-group">
            <form:label path="question">Question</form:label>
            <form:errors path="question"/>
            <form:textarea class="form-control" path="question"></form:textarea>
        </div>
        <div class="form-group">
            <form:label path="tags">Tags</form:label>
            <form:errors path="tags"/>
            <form:input class="form-control" path="tags"/>
        </div>
        <button>Submit</button>
    </form:form>
</body>
</html>
