<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Product</title>
</head>
<body>
<div style="width: 500px; margin: auto">
    <h1><c:out value="${product.name}"/></h1>
    <div style="float: left">
    <h2>Categories</h2>
    <ul>
        <c:forEach items="${categoriesAdded}" var="c">
            <li>${c.name}</li>
        </c:forEach>
    </ul>
    </div>

        <div style="float: right">

            <form:form action="/associate/${product.id}" method="post" modelAttribute="categoryProductObj">
                <h2>
                    <form:label  path="category">Add Category:</form:label>
                    <form:select  path="category">
                        <c:forEach items="${categoriesNotAdded}" var="cat">
                            <form:option value="${cat.id}"><c:out value="${cat.name}"/></form:option>
                        </c:forEach>
                    </form:select>
                </h2>
                <form:hidden path="product" value="${product.id}" />
                <input id="btn" type="submit" value="Create"/>
            </form:form>
    </div>
</div>

</body>
</html>
