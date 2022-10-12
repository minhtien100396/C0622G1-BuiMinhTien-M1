<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--C1:--%>
<%--<form action="/sum_servlet">--%>
<%--C2:--%>
<%--<form action="sum_servlet_JSP.jsp">--%>
<%--C3:--%>
<form action="/sum_servlet">
    <input type="hidden" name="flag" value="sum2Number">
    <div>Number 1:</div>
    <div>
        <input type="text" name="numberOne">
    </div>
    <div>Number 2:</div>
    <div>
        <input type="text" name="numberTwo">
    </div>
    <input type="submit" value="Sum">
</form>
</body>
</html>
