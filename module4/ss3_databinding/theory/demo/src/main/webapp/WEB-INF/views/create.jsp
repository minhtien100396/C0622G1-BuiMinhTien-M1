<%--
  Created by IntelliJ IDEA.
  User: MINH TIEN
  Date: 10/13/2022
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%--//Sử dụng thẻ form của thư viện Spring--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/create" method="post" modelAttribute="student">
    <p>Name:</p>
    <form:input type="text" path="name"/>
    <p>Date Of Birth</p>
    <form:input type="date" path="dateOfBirth"/>
    <p>ClassRooms</p>
<%--    <form:select path="classRoom">--%>
<%--        <form:options items="${classRooms}"></form:options>--%>
<%--    </form:select>--%>
<%--    <form:checkboxes path="classRoom" items="${classRooms}"></form:checkboxes>--%>
    <form:radiobuttons path="classRoom" items="${classRooms}"></form:radiobuttons>
    <button type="submit">Create Student</button>
</form:form>
</body>
</html>
