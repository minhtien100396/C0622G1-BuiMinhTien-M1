<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="../../bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css">
<body>
<div class="container-fluid" style="margin-top: 10px">
    <div class="container-fluid">
        <nav class="navbar navbar-light bg-black">
            <div class="container-fluid" style="height: 120px; line-height: 120px;margin-top: -10px">
                <a class="navbar-brand" href="/employee">
                    <img src="../../img/home_1.png" alt="" width="80" height="100"
                         class="d-inline-block align-content-center">
                </a>
                <strong style="color: white; font-family: 'Lucida Sans'; font-size: 20px; margin-right: 0px;color: pink">Bùi
                    Minh Tiến</strong>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid" style="margin-top: 10px">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <nav class="navbar navbar-expand-lg bg-black">
                    <div class="container-fluid">
                        <div class="col-lg-12">
                            <a class="navbar-brand" href="/employee" style="color: pink"><strong
                                    style="font-size: 20px">Edit<span
                                    style="font-style: italic;border-radius: 10px;background-color: deeppink; color: white; font-size: 30px">Employee</span></strong></a>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                    data-bs-target="#navbarSupportedContent"
                                    aria-controls="navbarSupportedContent"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>
<div style="margin: 20px 500px">
    <form action="/employee?action=edit" method="post">
        <input type="hidden" name="id" value="${employee.id}">
        <pre>Name:              <input type="text" name="name" value="${employee.name}"> </pre>
        <%--        <pre>Gender :  <input type="radio" name="gender" value="true">Nam --%>
        <%--            <input type="radio" value="false" name="gender"> Nữ --%>
        <%--        </pre>--%>
        <pre>Birthday:          <input type="date" name="dateOfBirth" value="${employee.dateOfBirth}"> </pre>
        <pre>IdCard:            <input type="text" name="idCard" value="${employee.idCard}"> </pre>
        <pre>Salary:            <input type="text" name="salary" value="${employee.salary}"> </pre>
        <pre>PhoneNumber:       <input type="text" name="phoneNumber" value="${employee.phoneNumber}"> </pre>
        <pre>Email:             <input type="text" name="email" value="${employee.email}"> </pre>
        <pre>Address:           <input type="text" name="address" value="${employee.address}"> </pre>
        <pre>Position:          <select name="position" value="${employee.positionId}">
                   <option value="">Chọn Vị Trí</option>
                   <option value="1">Lễ Tân</option>
                   <option value="2">Phục Vụ</option>
                   <option value="3">Chuyên viên</option>
                   <option value="4">Giám sát</option>
                   <option value="5">Quản lý</option>
                   <option value="6">Giám đốc</option>
            </select>
        </pre>
        <pre>Education Degree:  <select name="educationDegree" value="${employee.educationDegreeId}">
                   <option value="">Chọn Trình Độ Học Vấn</option>
                   <option value="1">Trung Cấp</option>
                   <option value="2">Cao Đẳng</option>
                   <option value="3">Đại Học</option>
                   <option value="4">Sau Đại Học</option>
            </select>
        </pre>
        <pre>Division:          <select name="division" value="${employee.divisionId}">
                   <option value="">Chọn Bộ Phận</option>
                   <option value="1">Sale-Marketing</option>
                   <option value="2">Hành chính</option>
                   <option value="3">Phục vụ</option>
                   <option value="4">Quản lý</option>
            </select>
        </pre>
        <pre>                    <input type="submit" value="Edit"></pre>
    </form>
</div>
<pre>                                                                               ${mess}</pre>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
