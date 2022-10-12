<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Ứng dụng chuyển đổi tiền tệ - JSP</title>
</head>
<body>
<form action="/converter">
    <h1>Currency Converter</h1>
    Rate:
    <div><input type="text" name="rate" value="22000" readonly></div>
    USD:
    <div><input type="text" name="usd" required></div>
    <br>
    <div><input type="submit" value="Converter"></div>
</form>
<div>
<%--    <c:choose>--%>
<%--        <c:when test="${usd <0}">--%>
<%--            <h2>USD không thể là số âm</h2>--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--            <h2>${vnd}</h2>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>
    <c:if test="${usd <0}">
        <h2>USD không thể là số âm</h2>
    </c:if>
    <c:if test="${usd >=0}">
        <h2>${vnd}</h2>
    </c:if>
</div>
</body>
</html>
