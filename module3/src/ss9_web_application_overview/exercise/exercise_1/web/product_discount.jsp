<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng Product Discount Calculator</title>
</head>
<body>
<%
    if (request.getAttribute("describe") == null) {
%>
<h3>${result}</h3>
<%
} else {
%>
<h3>Mô tả của sản phẩm : ${describe}</h3>
<h3>Giá niêm yết của sản phẩm : ${price} VNĐ</h3>
<h3>Tỷ lệ chiết khấu (phần trăm) : ${discount}%</h3>
<h3>Lượng chiết khấu : ${discountAmount}VNĐ</h3>
<h3>Giá sau khi đã được chiết khấu : ${discountPrice} VNĐ</h3>
<%
    }

%>

</body>
</html>
