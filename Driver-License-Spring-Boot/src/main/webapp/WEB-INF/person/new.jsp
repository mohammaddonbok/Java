<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: scc
  Date: 1/11/2021
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<center>
    <H1>Add a new Person </H1>
    <form:form  action="/create" method="post" modelAttribute="person">
        <div>
            <form:label path="firstName">First Name:</form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>

        </div>

        <div>
            <form:label path="lastName">Last Name:</form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </div>

        <div>
            <input type="submit" value="Create">
        </div>
    </form:form>



</center>

</body>
</html>
