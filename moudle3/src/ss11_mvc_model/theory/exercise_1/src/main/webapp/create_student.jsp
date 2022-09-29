<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student_servlet" method="post">
    <input type="hidden" name="actionUser" value="create">
    <input type="text" name="nameStudent">
    <input type="submit" value="Register">
</form>
</body>
</html>
