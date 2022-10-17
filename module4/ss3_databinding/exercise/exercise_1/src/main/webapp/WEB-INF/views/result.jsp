<%--
  Created by IntelliJ IDEA.
  User: MINH TIEN
  Date: 10/17/2022
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h2>Result</h2>
<form:form action="/" modelAttribute="configuringEmail" method="post">
    <table>
        <tr>
            <td><form:label path="langueges">Langueges:</form:label></td>
            <td>
                <form:input path="langueges"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size:</form:label></td>
            <td>
                <form:input path="pageSize"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter:</form:label></td>
            <td>
                <form:input path="spamsFilter"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature:</form:label></td>
            <td>
                <form:input path="signature"/>
            </td>
        </tr>

    </table>
    <input type="submit" value="Back list">
</form:form>
<p style="color: blue">${msg}</p>
</body>
</html>
