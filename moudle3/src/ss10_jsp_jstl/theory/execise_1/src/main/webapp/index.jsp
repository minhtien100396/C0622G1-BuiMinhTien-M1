<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentList</title>
</head>
<body>
<h2>Student List</h2>
<table border="1px">
    <tr>
        <th>No</th>
        <th>Id</th>
        <th>Name</th>
        <th>DateOfBirth</th>
        <th>Gender</th>
        <th>Grade</th>
    </tr>
    <%--    var: đại diện cho từng phần tử trong danh sách studentList,
            Còn item đại diện cho danh sách--%>
    <c:forEach var="studentObj" items="${studentListServlet}" varStatus="loop">
        <tr>
                <%--            Cách dùng c:out--%>
                <%--            <td></td>--%>
                <%--            <td><c:out value="${studentObj.id}"></c:out></td>--%>
                <%--            <td><c:out value="${studentObj.name}"></c:out></td>--%>
                <%--            <td><c:out value="${studentObj.dateOfBirth}"></c:out></td>--%>
                <%--            <td></td>--%>
                <%--            <td></td>--%>
                <%--            --%>
                <%--            Cách dùng nhanh--%>
            <td>${loop.count}</td>
            <td>${studentObj.id}</td>
            <td>${studentObj.name}</td>
            <td>${studentObj.dateOfBirth}</td>
            <td>
                <c:if test="${studentObj.gender == 1}">
                    Male
                </c:if>
                <c:if test="${studentObj.gender == 0}">
                    Female
                </c:if>
            </td>

                <%--                   choose: giống switch-case
                                        test: chứa mệnh đề điều kiên
                                        otherwise: giống default        --%>
            <td>
                <c:choose>
                    <c:when test="${studentObj.grade < 5}">
                        Bad
                    </c:when>
                    <c:when test="${studentObj.grade < 8 }">
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
</body>
</html>
