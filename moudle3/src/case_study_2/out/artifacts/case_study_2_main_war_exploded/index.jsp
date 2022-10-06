<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
    <style>
        #navbarSupportedContent ul li a {
            color: white;
        }
        #navbarSupportedContent ul ul li:hover {
            background: pink;
        }
        #navbarSupportedContent ul li a:hover {
            background: pink;
            color: black;
        }
    </style>
</head>
<body>
<div class="container-fluid" style="margin-top: 10px">
    <div class="container bg">
        <nav class="navbar navbar-light bg-black">
            <div class="container-fluid" style="height: 120px; line-height: 120px;margin-top: -10px">
                <a class="navbar-brand" href="#">
                    <img src="img/home_1.png" alt="" width="80" height="100"
                         class="d-inline-block align-content-center">
                </a>
                <strong style="color: white; font-family: 'Lucida Sans'; font-size: 20px; margin-right: 0px;color: pink">Bùi Minh
                    Tiến</strong>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid" style="margin-top: 10px">
    <div class="container">
        <nav class="navbar navbar-expand-lg bg-black">
            <div class="container-fluid" >
                <a class="navbar-brand" href="#" style="color: pink"><strong>FURUMA</strong></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Employee
                            </a>
                            <ul class="dropdown-menu bg-black">
                                <li><a class="dropdown-item" href="/employee">Employee Management</a></li>
                                <li><a class="dropdown-item" href="/employee?action=create">Add New Employee</a></li>
                                <li><hr class="dropdown-divider bg-light"></li>
                                <li><a class="dropdown-item" href="#">Edit Employee Information</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Customer
                            </a>
                            <ul class="dropdown-menu bg-black">
                                <li><a class="dropdown-item" href="/customer">Customer Management</a></li>
                                <li><a class="dropdown-item" href="#">Create New Customer</a></li>
                                <li><hr class="dropdown-divider bg-light"></li>
                                <li><a class="dropdown-item" href="#">Edit Customer Information</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown bg-black">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Service
                            </a>
                            <ul class="dropdown-menu bg-black">
                                <li><a class="dropdown-item" href="/service">Service Management</a></li>
                                <li><a class="dropdown-item" href="#">Create New Service</a></li>
                                <li><hr class="dropdown-divider bg-light"></li>
                                <li><a class="dropdown-item" href="#">Edit Service Information</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Contract
                            </a>
                            <ul class="dropdown-menu bg-black">
                                <li><a class="dropdown-item" href="/contract">Contract Management</a></li>
                                <li><a class="dropdown-item" href="#">Create New Contract</a></li>
                                <li><hr class="dropdown-divider bg-light"></li>
                                <li><a class="dropdown-item" href="#">Edit Contract Information</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" style="border-color: pink;border-width: 5px">
                        <button class="btn btn-outline-success" type="submit" style="color: pink; border-color: pink">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="container-fluid">
    <div class="container" style="height: 2320px">
        <div class="row" style="margin-top: 10px">
            <div class="col-lg-4">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card" style="width: 18rem;">
                            <img src="img/img_left_1.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk of the card's content.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-lg-12">
                        <div class="card" style="width: 18rem;">
                            <img src="img/img_left_2.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk of the card's content.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-lg-12">
                        <div class="card" style="width: 18rem;">
                            <img src="img/img_left_3.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk of the card's content.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-lg-12">
                        <div class="card" style="width: 18rem;">
                            <img src="img/img_left_4.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the
                                    bulk of the card's content.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px">
                    <div class="col-lg-12">
                        <iframe width=288" height="200" src="https://www.youtube.com/embed/IjlT_4mvd-c"
                                title="The Furama Resort DaNang - Couples Corporate" frameborder="0"
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="row" style="margin-top: 5px">
                    <div class="col-lg-12">
                        <div class="card" style="width: 18rem;">
                            <img src="img/img_left_5.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title" style="color:peru;">DỊCH VỤ LẶN BIỂN VÀ CÂU CÁ</h5>
                                <p class="card-text">Chỉ mất 20 phút bằng tàu cao tốc hoặc 40 phút bằng thuyền đánh cá
                                    di chuyển từ bãi biển Furama Resort Đà Nẵng tới bán đảo Sơn Trà hay còn được gọi là
                                    Núi Khỉ, nơi đây tác biệt với khu vực lặn bằng ống thở, câu cá và bơi lội thỏa
                                    thích.</p>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">An item</li>
                                <li class="list-group-item">A second item</li>
                                <li class="list-group-item">A third item</li>
                            </ul>
                            <div class="card-body">
                                <a href="#" class="card-link">Card link</a>
                                <a href="#" class="card-link">Another link</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="row" style="margin-top: 10px">
                    <div class="col-lg-12" style="text-align: center">
                        <span style="color: peru; padding-bottom: 20px; font-weight: bold; font-family: Tahoma; font-size: 20px">KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM THỰC TẠI VIỆT NAM.</span>
                        <iframe style="margin-top: 10px" width="725" height="350"
                                src="https://www.youtube.com/embed/0YT3hj2TLb8" title="Furama Resort Danang"
                                frameborder="0"
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                                allowfullscreen></iframe>
                    </div>
                </div>
                <div class="row" style="margin-top: 10px; text-align: center">
                    <div class="col-lg-12">
                        <span style="color: peru; padding-bottom: 20px; font-weight: bold; font-family: Tahoma; font-size: 20px">TRẢI NGHIỆM ẨM THỰC & GIẢI TRÍ</span>
                        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel"
                             style="margin-top: 10px">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0"
                                        class="active" aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                                        aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                                        aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active" data-bs-interval="10000">
                                    <img src="img/carousel_1.JPG" class="d-block w-100 " alt="Hình 1"
                                         style="height: 400px; line-height: 400px">
                                </div>
                                <div class="carousel-item" data-bs-interval="2000">
                                    <img src="img/carousel_2.JPG" class="d-block w-100 " alt="Hình 2"
                                         style="height: 400px; line-height: 400px">
                                </div>
                                <div class="carousel-item">
                                    <img src="img/carousel_3.JPG" class="d-block w-100" alt="Hình 3"
                                         style="height: 400px; line-height: 400px">
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                                    data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                                    data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="row" style="margin-top: 20px; height: 20px; line-height: 20px">
                    <div class="col-lg-12" style="text-align: center">
                        <span style="color: peru; padding-bottom: 20px; font-weight: bold; font-family: Tahoma; font-size: 20px">GIẢI TRÍ</span>
                        <div class="card mb-3" style="margin-top: 10px">
                            <img src="img/img_right_1.jpg" class="card-img-top" alt="...">
                            <div class="card-body" style="text-align: left">
                                <h5 class="card-title" style="color:peru;">THÁI CỰC QUYỀN</h5>
                                <p class="card-text">Đừng quên các tham gia lớp học Thái Cực Quyền trên bãi biển tại khu
                                    nghỉ cùng nhiều các hoạt động thay đổi hàng ngày khác tại đây bao gồm các chương
                                    trình học yoga, bóng chuyền bãi biển, bóng đá, thi đấu cầu lông đều được tổ
                                    chức.</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body" style="text-align: left">
                                <img src="img/img_right_2.jpg" class="card-img-bottom" alt="...">
                                <h5 class="card-title" style="margin-top: 10px; color: peru">CÁC HOẠT ĐỘNG CHO TRẺ EM</h5>
                                <p class="card-text">Câu lạc bộ Trẻ em mở cửa miễn phí từ 9:30 sáng đến 18:30 chiều mỗi
                                    ngày. Đội ngũ nhân viên trông trẻ dày dặn kinh nghiệm sẽ giúp các ông bố, bà mẹ chăm
                                    sóc những thiên thần nhỏ và giữ chúng được vui vẻ suốt cả ngày.

                                    Dịch vụ giữ trẻ tư nhân có thể được sắp xếp theo yêu cầu. Vui lòng đặt trước 24 giờ
                                    để đặt dịch vụ. Đối với những trẻ lớn hơn, khu nghỉ có một sân chơi nằm trên bãi
                                    biển với một loạt trò chơi giải trí thú vị như xây lâu đài cát, cầu trượt, thả
                                    diều,…</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid" style="margin-top: 10px">
    <div class="container-fluid">
        <div class="row" style="margin: 0px 0px">
            <div class="col-lg-12 bg-black" style="height: 60px; color: white; line-height: 60px; font-size: 14px">
                <div>
                    <span style="color: pink">* Some software, accessories, and devices sold separately.</span>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../bootstrap/js/bootstrap.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script src="../bootstrap/js/bootstrap.bundle.min.js"></script></body>
</html>