<%--
  Created by IntelliJ IDEA.
  User: MINH TIEN
  Date: 10/17/2022
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcom, Enter The Employee Details</h3>
<form:form action="/employee/create" method="post" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID:</form:label></td>
            <td><form:input path="id"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee's name:</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Contact's number:</form:label></td>
            <td><form:input path="contactNumber"></form:input></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
