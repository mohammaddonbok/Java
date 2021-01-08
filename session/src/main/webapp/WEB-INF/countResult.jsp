<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dedo
  Date: 1/6/2021
  Time: 3:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show counter</title>
</head>
<body>
<h1>You Have visited localHost <c:out value="${count+1}"/> times</h1><br>
    <a href="/">Test another visit</a>

</body>
</html>