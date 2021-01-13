<<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/13/2021
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categoriy</title>
</head>
<body>
<div style="width: 500px; margin: auto">
    <h1><c:out value="${category.name}"/></h1>
    <div style="float: left">
        <h2>Products</h2>
        <ul>
            <c:forEach items="${contain}" var="c">
                <li>${c.name}</li>
            </c:forEach>
        </ul>
    </div>

    <div style="float: right">

        <form:form action="/assProduct/${category.id}" method="post" modelAttribute="categoryProductObj">
            <h2>
                <form:label  path="product">Add Category:</form:label><br>
                <form:select  path="product">
                    <c:forEach items="${notContain}" var="prod">
                        <form:option value="${prod.id}"><c:out value="${prod.name}"/></form:option>
                    </c:forEach>
                </form:select>
            </h2>
            <form:hidden path="category" value="${category.id}" />
            <input id="btn" type="submit" value="Create"/>
        </form:form>
    </div>
</div>

</body>
</html>
