<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bảng Danh Sách Sinh Viên</title>
</head>
<body>
<table border="1px" width="100%" style="text-align: center">
    <caption><h1>Bảng Danh Sách Sinh Viên</h1></caption>
    <tr>
        <th>No</th>
        <th>Id</th>
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>Gender</th>
        <th>Grade</th>
        <th>ClassRoom</th>
        <th>Detail PathVariable</th>
        <th>Detail RequestParam</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.dateOfBirth}</td>
            <td>
                <c:if test="${student.gender == 1}">
                    Nữ
                </c:if>
                <c:if test="${student.gender == 0}">
                    Nam
                </c:if>
            </td>
            <td>
                <c:choose>
                    <c:when test="${student.grade < 5}">
                        Bad
                    </c:when>
                    <c:when test="${student.grade < 8}">
                        Nomal
                    </c:when>
                    <c:when test="${student.grade < 9}">
                        Good
                    </c:when>
                    <c:otherwise>
                        VeryGood
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${student.classRoom}</td>
            <td><a href="/detail/${student.id}">Detail Student</a></td>
            <td><a href="/detail?id=${student.id}">Detail Student</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/create">Create new student</a>
<h1 style="color: blue">${msg}</h1>
</body>
</html>
