<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div style="margin: 20px 530px;width: 100%" >
    <form action="/customer?action=create" method="post">
        <pre>Name:              <input type="text" name="name" value="${customer.name}"> </pre>
        <c:if test="${map.get('name')!=null}">
            <pre>               <span style="color:red;">${map.get('name')}</span></pre>
        </c:if>
<%--        <pre>Gender :           <input type="radio" name="gender" value="1">Nam      <input type="radio" value="0" name="gender"> Nữ</pre>--%>
        <pre>Gender:            <select name="gender" >
                   <option value=100>-Select-</option>
                   <option value=1>Male</option>
                   <option value=2>Female</option>
            </select></pre>
        <c:if test="${map.get('gender') != null}">
            <pre>               <span style="color:red;">${map.get("gender")}</span></pre>
        </c:if>
        <pre>Birthday:          <input type="date" name="dateOfBirth" required> </pre>
        <c:if test="${map.get('dateOfBirth')!=null}">
            <pre>               <span style="color:red;">${map.get('dateOfBirth')}</span></pre>
        </c:if>
        <pre>IdCard:            <input type="text" name="idCard" value="${customer.idCard}"> </pre>
        <c:if test="${map.get('idCard')!=null}">
            <pre>               <span style="color:red;">${map.get('idCard')}</span></pre>
        </c:if>
        <pre>PhoneNumber:       <input type="text" name="phoneNumber" value="${customer.phoneNumber}"> </pre>
        <c:if test="${map.get('phoneNumber')!=null}">
            <pre>               <span style="color:red;">${map.get('phoneNumber')}</span></pre>
        </c:if>
        <pre>Email:             <input type="text" name="email" value="${customer.email}"> </pre>
        <c:if test="${map.get('email')!=null}">
            <pre>               <span style="color:red;">${map.get('email')}</span></pre>
        </c:if>
        <pre>Address:           <input type="text" name="address" value="${customer.address}"> </pre>
        <c:if test="${map.get('address')!=null}">
            <pre>               <span style="color:red;">${map.get('address')}</span></pre>
        </c:if>
        <pre>Customer Type:     <select name="customerTypeId" >
                   <option value=100>-Select-</option>
                   <option value=1>Diamond</option>
                   <option value=2>Platinium</option>
                   <option value=3>Gold</option>
                   <option value=4>Silver</option>
                   <option value=5>Member</option>
            </select></pre>
        <c:if test="${map.get('customerTypeId') != null}">
            <pre>               <span style="color:red;">${map.get("customerTypeId")}</span></pre>
        </c:if>
        <pre>                    <input type="submit" value="Add"></pre>
    </form>
</div>
<pre style="text-align: center"> ${mess}</pre>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
