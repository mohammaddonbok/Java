<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/13/2021
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>


<html>
<head>
    <title>List Products</title>
</head>
<body>
<center>
    <h1> New Product</h1>
    <form:form action="/products/new" method="POST" modelAttribute="prod">
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input type="text" path="name"/><br><br>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:input type="text" path="description"/><br><br>
        <form:label path="price">Price:</form:label>
        <form:errors path="price"/>
        <form:input type="text" path="price"/>
        <form:button>create</form:button>
    </form:form>
</center>



</body>
</html>