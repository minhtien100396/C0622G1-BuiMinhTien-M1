<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hiển thị danh sách khách hàng</title>
    <style>
        img {
            height: 100px;
            width: 100px;
        }
    </style>
</head>
<body>
<table border="1px" width="100%" style="text-align: center" >
    <caption><h1>Danh Sách Khách Hàng</h1></caption>
    <tr>
        <th>STT</th>
        <th>MSKH</th>
        <th style="width: 200px">Họ Và Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th style="width: 400px">Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerListServlet}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.dateOfBirth}</td>
            <td>${customer.address}</td>
            <td>
                <c:choose>
                    <c:when test="${customer.id == 1}">
                        <img src="img/woman_1.jpg" alt="MSKH = 1">
                    </c:when>
                    <c:when test="${customer.id == 2}">
                        <img src="img/human_2.jfif" alt="MSKH = 2">
                    </c:when>
                    <c:when test="${customer.id == 3}">
                        <img src="img/human_3.jfif" alt="MSKH = 3">
                    </c:when>
                    <c:when test="${customer.id == 4}">
                        <img src="img/human_4.jfif" alt="MSKH = 4">
                    </c:when>
                    <c:when test="${customer.id == 5}">
                        <img src="img/human_5.jfif" alt="MSKH = 5">
                    </c:when>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
