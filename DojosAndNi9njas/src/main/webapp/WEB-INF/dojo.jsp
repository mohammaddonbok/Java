<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/14/2021
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojos</title>
</head>
<body>
<center>
    <h1>New Dojo</h1>
    <form:form action="/dojo/new" method="post" modelAttribute="addDojo">
        <form:label path="name"/>
        <form:input type="text" path="name"/>
        <form:button>Create</form:button>
        
    </form:form>

</center>

</body>
</html>
