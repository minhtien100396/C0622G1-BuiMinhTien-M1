<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý User sử dụng JSP-Servlet-JDBC-MySQL</title>
</head>
<body>
<h1 style="text-align: center">User Management</h1>
<h2 style="text-align: center"><a href="view/user/add.jsp">Add New User</a></h2>
<h3 style="text-align: center">List of User</h3>
<table border="1px" style="width: 100%; text-align: center">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="user" items="${userList}" varStatus="status">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.country}</td>
            <td><a href="/user?actionUser=delete&id=${user.id}">Delete</a></td>
            <td><a href="/user?actionUser=edit&id=${user.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
