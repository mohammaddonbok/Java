<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/7/2021
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>The Code</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="wrapper">
<p><c:out value="${error}"/></p>
<form action="/check" method="post">
    <label>What is The Code?</label><br>
    <input type="text" name="code"><br>
    <input type="submit" value="Try Code">
</form>
</div>
</body>
</html>
