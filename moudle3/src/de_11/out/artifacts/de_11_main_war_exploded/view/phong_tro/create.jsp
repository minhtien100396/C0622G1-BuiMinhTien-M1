<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm Mới Phòng Trọ</title>
</head>
<body>
<center>
    <h1>Quản Lí Phòng Trọ</h1>
    <h2>
        <a href="/phongtro">Danh Sách Phòng Trọ</a>
    </h2>
</center>
<div align="center">
    <form action="/phongtro?action=create" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Thêm Mới Phòng Trọ</h2>
            </caption>
            <tr>
                <th>Tên Người Thuê Trọ:</th>
                <td>
                    <input type="text" name="tenNguoiThueTro" id="tenNguoiThueTro" size="45" value='${phongTro.tenNguoiThueTro}'/>
                    <p style="color:red;">${map.get('tenNguoiThueTro')}</p>
                </td>
            </tr>
            <tr>
                <th>Số Điện Thọai:</th>
                <td>
                    <input type="text" name="soDienThoai" id="soDienThoai" size="45" value='${phongTro.soDienThoai}'/>
                    <p style="color:red;">${map.get('soDienThoai')}</p>
                </td>
            </tr>
            <tr>
                <th>Ngày Bắt Đầu Thuê Trọ:</th>
                <td>
                    <input type="date" name="ngayBatDauThueTro" id="ngayBatDauThueTro" size="15" value='${phongTro.ngayBatDauThueTro}'/>
                    <p style="color:red;">${map.get('ngayBatDauThueTro')}</p>
                </td>
            </tr>
            <tr>
                <th>Hình Thức Thanh Toán:</th>
                <td>
                    <select id="maThanhToan" name="maThanhToan">
                        <option value="100">- Hình Thức Thanh Toán -</option>
                        <c:forEach var="hinhThucThanhToanMap" items="${hinhThucThanhToanMap}">
                                <option value="${hinhThucThanhToanMap.key}">${hinhThucThanhToanMap.value}</option>
                        </c:forEach>
<%--                        <c:forEach var="hinhThucThanhToanMap" items="${hinhThucThanhToanMap}">--%>
<%--                            <c:if test="${hinhThucThanhToanMap.key == phongTro.maThanhToan}">--%>
<%--                                <option value="${hinhThucThanhToanMap.key}">${hinhThucThanhToanMap.value}</option>--%>
<%--                            </c:if>--%>
<%--&lt;%&ndash;                            <c:if test="${position.key != employee.positionId}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                <option value="${position.key}">${position.value}</option>&ndash;%&gt;--%>
<%--&lt;%&ndash;                            </c:if>&ndash;%&gt;--%>
<%--                        </c:forEach>--%>
                    </select>
                    <p style="color:red;">${map.get('maThanhToan')}</p>
                </td>
            </tr>
            <tr>
                <th>Ghi Chú:</th>
                <td>
                    <input type="text" name="ghiChu" id="ghiChu" size="15" value='${phongTro.ghiChu}'/>
                    <p style="color:red;">${map.get('ghiChu')}</p>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<p style="text-align: center">
    <span style="color:blue">
            ${mess}
    </span>
</p>
</body>
</html>