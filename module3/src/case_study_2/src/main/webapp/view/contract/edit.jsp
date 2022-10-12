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
                <a class="navbar-brand" href="/contract">
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
                            <a class="navbar-brand" href="/contract" style="color: pink"><strong
                                    style="font-size: 20px">Edit <span
                                    style="font-style: italic;border-radius: 10px;background-color: deeppink; color: white; font-size: 30px">Contract</span></strong></a>
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
    <form action="/contract?action=edit" method="post">
        <input type="hidden" name="id" value="${contract.id}">
        <pre>Start Date:        <input type="date" name="startDate" value="${contract.startDate}"> </pre>
        <pre>End Date:          <input type="date" name="endDate" value="${contract.endDate}"> </pre>
        <pre>Deposit:           <input type="text" name="deposit" value="${contract.deposit}"> </pre>
        <pre>Employee Id:       <input type="text" name="employeeId" value="${contract.employeeId}"> </pre>
        <pre>Customer Id:       <input type="text" name="customerId" value="${contract.customerId}"> </pre>
        <pre>Facility Id:       <input type="text" name="facilityId" value="${contract.facilityId}"> </pre>
        <pre>                   <input type="submit" value="Edit"></pre>
    </form>
</div>
<pre>                                                                               ${mess}</pre>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
