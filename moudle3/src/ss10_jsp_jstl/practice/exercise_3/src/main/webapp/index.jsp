<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng Từ điển đơn giản - JSP</title>
</head>
<body>
<form action="/dictionary" method="post">
    <h1>Vietnamese Dictionary</h1>
    <div>
        <input type="text" placeholder="Enter your word:" name="search" style="height: 30px" required>
        <input type="submit" value="Search" style="height: 30px">
    </div>
</form>
<h3>${result}</h3>
</body>
</html>
