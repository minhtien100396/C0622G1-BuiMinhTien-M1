<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bảng Danh Sách Sinh Viên</title>
</head>
<body>
<table border="1px" width="100%" style="text-align: center">
    <caption><h1>Bảng Danh Sách Sinh Viên</h1></caption>
    <div>
        <form action="/?actionUser=search">
            <input type="hidden" name="actionUser" value="search">
            <input type="search" name="search">
            <input type="submit" value="Search">
        </form>
    </div>
    <tr>
        <th>No</th>
        <th>Id</th>
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>Gender</th>
        <th>Grade</th>
    </tr>
    <c:forEach var="student" items="${studenListServlet}" varStatus="loop">
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
        </tr>
    </c:forEach>
</table>
<a href="/?actionUser=create">Create new student</a>
</body>
</html>
