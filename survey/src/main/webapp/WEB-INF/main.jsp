<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: msys
  Date: 1/5/2021
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo Survey Index</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<form action="/info" method="post">
<label for="name"> Your Name</label>
<input type="text" id="name" name="name"><br><br>
<label for="location" >Dojo Location</label>
<select name="location" id="location" >
    <option value="Nablus" >Nablus</option>
    <option value="Ramallah">Ramallah</option>
    <option value="Jordan">Jordan</option>
</select><br><br>
<label for="Language">Select language:</label>
<select  id="Language" name="language">
    <option value="arabic">Arabic</option>
    <option value="english">English</option>
    <option value="spanish">Spanish</option>
</select><br><br>
<label for="comment">Comment here(optional):</label><br>
<textarea id="comment" name=comment></textarea><br><br>
<input class="butt" type="submit" value="Button"><br><br>
</form>
</body>
</html>
