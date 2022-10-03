<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
<h1 style="text-align: center">User Management</h1>
<h2 style="text-align: center"><a href="/user">List All User</a></h2>
<h3 style="text-align: center">Edit User</h3>
<form action="/user?actionUser=edit" method="post">
    <div>
        ID:
        <input type="text" name="id" value="${user.id}" readonly>
    </div>
    <div>
        User Name:
        <input type="text" name="name" value="${user.name}">
    </div>
    <div>
        User Email:
        <input type="email" name="email" value="${user.email}">
    </div>
    <div>
        Country:
        <input type="text" name="country" value="${user.country}">
    </div>
    <input type="submit" value="Edit">
</form>
<h3>${mess}</h3>
</body>
</html>
