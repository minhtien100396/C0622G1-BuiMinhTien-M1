<%--
  Created by IntelliJ IDEA.
  User: MINH TIEN
  Date: 10/13/2022
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/create" method="post">
    <p>Name:</p>
    <input type="text" name="name">
    <p>Date Of Birth</p>
    <input type="date" name="dateOfBirth">
    <button type="submit">Create Student</button>
</form>
</body>
</html>
