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
                <a class="navbar-brand" href="/service">
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
                            <a class="navbar-brand" href="/service" style="color: pink"><strong
                                    style="font-size: 20px">Add New <span
                                    style="font-style: italic;border-radius: 10px;background-color: deeppink; color: white; font-size: 30px">Service</span></strong></a>
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
<div style="margin: 20px 400px">
    <form action="/service?action=create" method="post">
        <pre>Name:                                      <input type="text" name="name"> </pre>
        <pre>Area:                                      <input type="text" name="area"> </pre>
        <pre>Cost:                                      <input type="text" name="cost"> </pre>
        <pre>Max People:                                <input type="text" name="maxPeople"> </pre>
        <pre>Standard Room:                             <input type="text" name="standardRoom"> </pre>
        <pre>Description Other Convenience:             <input type="text" name="descriptionOtherConvenience"> </pre>
        <pre>Pool Area:                                 <input type="text" name="poolArea"> </pre>
        <pre>Number Of Floors:                          <input type="text" name="numberOfFloors"> </pre>
        <pre>Facility Free:                             <input type="text" name="facilityFree"> </pre>
        <pre>Facility Type:                             <select name="facilityTypeId">
                   <option value="">Chọn Hạ Tầng</option>
                   <option value="1">Villa</option>
                   <option value="2">House</option>
                   <option value="3">Room</option>
            </select></pre>
        <pre>Rent Type:                                 <select name="rentTypeId">
                   <option value="">Chọn Kiểu Thuê</option>
                   <option value="1">Year</option>
                   <option value="2">Month</option>
                   <option value="3">Day</option>
                   <option value="4">Hour</option>
            </select>
        </pre>

        <pre>                                            <input type="submit" value="Add"></pre>
    </form>
</div>
<pre>                                                                                     ${mess}</pre>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
