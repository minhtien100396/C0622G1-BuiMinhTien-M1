<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><%=request.getAttribute("describe")%></h3>
<h3><%=request.getAttribute("price")%></h3>
<h3><%=request.getAttribute("discount")%></h3>
<h3><%=request.getAttribute("discountAmount")%></h3>
<h3><%=request.getAttribute("discountPrice")%></h3>
</body>
</html>
