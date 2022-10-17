<%--
  Created by IntelliJ IDEA.
  User: MINH TIEN
  Date: 10/17/2022
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Infomation</title>
</head>
<body>
<h2>Sumitted Employee Information</h2>
<table>
    <tr>
        <td>Name:</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${employee.contactNumber}</td>
    </tr>
</table>
<p style="color: blue">${msg}</p>
</body>
</html>
