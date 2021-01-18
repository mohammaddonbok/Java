<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/13/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Questions Dashboard</title>
</head>
<body>
    <h1>Questions Dashboard</h1>
    <thead>
    <tr>
        <th>Question</th>
        <th>Tags</th>
    </tr>
    </thead>
    <c:forEach items="${ questions }" var="question">
        <tr>
        <td><a href="/${ question.id }">${ question.question}</a></td>
        <td>
        <c:forEach items="${ question.tags }" var="tag">
            <span>${ tag.subject }<c:if test="${ question.tags.indexOf(tag) != question.tags.size() - 1 }">, </c:if></span>
        </c:forEach>
        </td>
        </tr>
    </c:forEach>
    </table>
    <a href="/new">New Question</a>
</body>
</html>
