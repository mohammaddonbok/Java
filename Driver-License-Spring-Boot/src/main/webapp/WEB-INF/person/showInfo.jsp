<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: scc
  Date: 1/11/2021
  Time: 12:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
    <p> License:<c:out value="${person.license.numberAsString}"/></p>
    <p>State: <c:out value="${person.license.state}"/></p>
    <p>Expiration Date:<c:out value="${person.license.expirationDate}"/></p>

</center>

</body>
</html>
