<%--
  Created by IntelliJ IDEA.
  User: MINH TIEN
  Date: 10/17/2022
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting</title>
</head>
<body>
<h3>Setting</h3>
<form:form action="/result" method="post" modelAttribute="configuringEmail">
    <table>
        <tr>
            <td><form:label path="langueges">Langueges:</form:label></td>
            <td>
                <form:select path="langueges">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size:</form:label></td>
            <td>
                <span>Show</span>
                <form:select path="pageSize">
                    <form:options items="${pageSize}"></form:options>
                </form:select>
                <span>emails per page</span>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter:</form:label></td>
            <td><form:checkboxes path="spamsFilter" items="${spamsFilter}"></form:checkboxes></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature:</form:label></td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>

    </table>
    <div style="padding-left: 50px;margin-top: 10px">
        <span><input type="submit" value="Update"></span>
        <span><input type="reset" value="Cancel"></span>
    </div>
</form:form>
<p style="color: blue">${msg}</p>
</body>
</html>
