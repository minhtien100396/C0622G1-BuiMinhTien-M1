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
                <a class="navbar-brand" href="/customer">
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
                            <a class="navbar-brand" href="/customer" style="color: pink"><strong
                                    style="font-size: 20px">Add New <span
                                    style="font-style: italic;border-radius: 10px;background-color: deeppink; color: white; font-size: 30px">Customer</span></strong></a>
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
    <form action="/customer?action=create" method="post">
        <pre>Name:              <input type="text" name="name"> </pre>
        <pre>Gender :           <input type="radio" name="gender" value="1">Nam      <input type="radio" value="0" name="gender"> Nữ</pre>
        <pre>Birthday:          <input type="date" name="dateOfBirth"> </pre>
        <pre>IdCard:            <input type="text" name="idCard"> </pre>
        <pre>PhoneNumber:       <input type="text" name="phoneNumber"> </pre>
        <pre>Email:             <input type="text" name="email"> </pre>
        <pre>Address:           <input type="text" name="address"> </pre>
        <pre>Customer Type:     <select name="customerType">
                   <option value="">Chọn Loại Khách</option>
                   <option value="1">Diamond</option>
                   <option value="2">Platinium</option>
                   <option value="3">Gold</option>
                   <option value="4">Silver</option>
                   <option value="5">Member</option>
            </select>
        </pre>
        <pre>                    <input type="submit" value="Add"></pre>
    </form>
</div>
<pre>                                                                               ${mess}</pre>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
