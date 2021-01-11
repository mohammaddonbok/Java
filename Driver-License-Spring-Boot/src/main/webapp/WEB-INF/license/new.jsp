<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: scc
  Date: 1/11/2021
  Time: 12:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Add a new Person </h1>
    <form:form action="/createlicense" method="POST" modelAttribute="license">
        <div class="form-group">
            <form:label path="person">Person</form:label>
            <form:errors path="person"/>
            <form:select class="form-control" path="person">
                <c:forEach items="${ persons }" var="p">
                    <form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:input class="form-control" path="state"/>
        </div>
        <div class="form-group">
            <form:label path="expirationDate">Expiration Date</form:label>
            <form:errors path="expirationDate"/>
            <form:input type="date" class="form-control" path="expirationDate"/>
        </div>
        <button>Add License</button>
    </form:form>



</center>
</body>
</html>
