<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/14/2021
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ninja</title>
</head>
<body>
<center>
    <h1>New Ninja</h1>
    <form:form action="/ninja/new" method="post" modelAttribute="createNinja">
        <form:label path="dojo">Dojos</form:label>
        <form:select  path="dojo" >
            <c:forEach items="${dojos}" var="do">
                <form:option value="${do.id}"><c:out value="${do.name}"/></form:option>
            </c:forEach>
        </form:select><br>

        <form:label path="firstName">First Name:</form:label>
        <form:input type="text" path="firstName"/><br>

        <form:label path="lastName">Last Name:</form:label>
        <form:input type="text" path="lastName"/><br>

        <form:label path="age">Age:</form:label>
        <form:input type="number" path="age"/><br>

        <form:button>Create</form:button>
    </form:form>
</center>
</body>
</html>
