<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/5/2021
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dojo Survey Index</title>
    <link rel="stylesheet" type="text/css" href="css/result.css">
</head>
<body>
<div>
<h1>Submitted Info</h1>
<h3>name :<c:out value="${name}"/></h3>
<h3>location :<c:out value="${location}"/> </h3>
<h3>language :<c:out value="${language}"/> </h3>
<h3>comment :<c:out value="${comment}"/> </h3>
</div>
</body>
</html>
