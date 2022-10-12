<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--C2: trộn code java vào html -> khó kiểm soát code--%>
    <%
        double a = Double.parseDouble(request.getParameter("numberOne"));
        double b = Double.parseDouble(request.getParameter("numberTwo"));
        double result = a + b;
    %>
<%-- <%result%>: hiển thị ra màn hình giống sout   --%>
    <h2 style="color: green"><%=result%></h2>
</body>
</html>
