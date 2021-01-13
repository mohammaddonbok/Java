<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/13/2021
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1> New Category </h1>
    <form:form action="/categories/new" method="POST" modelAttribute="categories">
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input type="text" path="name"/><br><br>
        <form:button>create</form:button>
    </form:form>
</center>

</body>
</html>