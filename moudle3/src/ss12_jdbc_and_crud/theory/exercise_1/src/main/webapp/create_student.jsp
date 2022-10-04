<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student_servlet" method="post">
        <input type="hidden" name="actionUser" value="create">
    <div>Name:</div>
    <div>
        <input type="text" name="nameStudent">
    </div>
    <div>Date Of Birth:</div>
    <div>
        <input type="date" name="dateOfBirth">
    </div>
    <input type="submit" value="Register">
</form>
</body>
</html>
