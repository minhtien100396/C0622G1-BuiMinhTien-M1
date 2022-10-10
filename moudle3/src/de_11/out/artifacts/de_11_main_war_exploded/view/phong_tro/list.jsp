<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Quản Lý Phòng Trọ</title>
    <link rel="stylesheet" href="../../bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<center>
    <h1>Quản Lý Phòng Trọ</h1>
    <h2>
        <a href="/phongtro?action=create">Thêm Phòng Trọ</a>
    </h2>
    <h3>Danh Sách Phòng Trọ</h3>
</center>
<div align="center">
    <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên Người Thuê Trọ</th>
            <th>Số Điện Thoại</th>
            <th>Ngày Bắt Đầu Thuê</th>
            <th>Hình Thức Thanh Toán</th>
            <th>Ghi Chú</th>
            <th>Chức Năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="phongTro" items="${phongTroList}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><c:out value="${phongTro.tenNguoiThueTro}"/></td>
                <td><c:out value="${phongTro.soDienThoai}"/></td>
                <td><c:out value="${phongTro.ngayBatDauThueTro}"/></td>
                <c:if test="${!hinhThucThanhToanMap.containsKey(phongTro.maThanhToan)}">
                    <td>
                        No Position
                    </td>
                </c:if>
                <td>${hinhThucThanhToanMap.get(phongTro.maThanhToan)}</td>
                <td><c:out value="${phongTro.ghiChu}"/></td>
                <td>
                            <!-- Button trigger modal EDIT -->
<%--                            <button type="button" class="btn btn-primary" data-bs-toggle="modal"--%>
<%--                                    data-bs-target="#exampleModal1${user.id}">--%>
<%--                                Chỉnh Sửa--%>
<%--                            </button>--%>

<%--                            <!-- Modal -->--%>
<%--                            <div class="modal fade" id="exampleModal1${user.id}" tabindex="-1"--%>
<%--                                 aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--                                <div class="modal-dialog">--%>
<%--                                    <div class="modal-content">--%>
<%--                                        <div class="modal-header">--%>
<%--                                            <h5 class="modal-title" id="exampleModalLabel1" style="color: #000">Thay đổi thông tin</h5>--%>
<%--                                            <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
<%--                                                    aria-label="Close"></button>--%>
<%--                                        </div>--%>
<%--                                        <div class="modal-body" style="color: #000">--%>
<%--                                            Bạn có muốn thay đổi thông tin <strong class="text-danger">${user.name}</strong> không ?--%>
<%--                                        </div>--%>
<%--                                        <div class="modal-footer">--%>
<%--                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close--%>
<%--                                            </button>--%>
<%--                                            <a href="/users?action=edit&id=${user.id}" class="btn btn-secondary">Thay Đổi</a>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>




                    <!-- Button trigger modal DELETE -->
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#exampleModal${phongTro.maPhongTro}">
                        Xoá
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal${phongTro.maPhongTro}" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel" style="color: #000">Xoá Phòng Trọ</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body" style="color: #000">
                                    Bạn có muốn xoá Phòng Trọ của <strong class="text-danger">${phongTro.tenNguoiThueTro}</strong> không ?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <a href="/phongtro?action=delete&maPhongTro=${phongTro.maPhongTro}" class="btn btn-secondary">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="/phongtro" style="height: 30px; line-height: 30px">
        <input type="hidden" name="action" value="search">
        <input type="text" name="searchTenNguoiThueTro" placeholder="TenNguoiThueTro">
        <input type="text" name="searchSoDienThoai" placeholder="SoDienThoai">
        <select name="searchHinhThucThanhToan">
            <option selected value="100">- HinhThucThanhToan -</option>
            <c:forEach var="hinhThucThanhToanMap" items="${hinhThucThanhToanMap}">
                <option value="${hinhThucThanhToanMap.key}">${hinhThucThanhToanMap.value}</option>
            </c:forEach>
        </select>
        <button type="submit">Search</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>