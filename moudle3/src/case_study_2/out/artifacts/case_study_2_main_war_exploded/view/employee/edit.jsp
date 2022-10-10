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
        <pre>Birthday:          <input type="date" name="dateOfBirth" value="${employee.dateOfBirth}"> </pre>
        <pre>IdCard:            <input type="text" name="idCard" value="${employee.idCard}"> </pre>
        <pre>Salary:            <input type="text" name="salary" value="${employee.salary}"> </pre>
        <pre>PhoneNumber:       <input type="text" name="phoneNumber" value="${employee.phoneNumber}"> </pre>
        <pre>Email:             <input type="text" name="email" value="${employee.email}"> </pre>
        <pre>Address:           <input type="text" name="address" value="${employee.address}"> </pre>
        <pre>Position:          <select id="position" name="position">
                                            <c:forEach var="position" items="${positionMap}">
                                                <c:if test="${position.key == employee.positionId}">
                                                    <option selected value="${position.key}">${position.value}</option>
                                                </c:if>
                                                <c:if test="${position.key != employee.positionId}">
                                                    <option value="${position.key}">${position.value}</option>
                                                </c:if>
                                            </c:forEach>
                                </select></pre>
        <pre>Education Degree:  <select name="educationDegree">
                                            <c:forEach var="educationDegree" items="${educationDegreeMap}">
                                                <c:if test="${educationDegree.key == employee.educationDegreeId}">
                                                    <option selected value="${educationDegree.key}">${educationDegree.value}</option>
                                                </c:if>
                                                <c:if test="${educationDegree.key != employee.educationDegreeId}">
                                                    <option value="${educationDegree.key}">${educationDegree.value}</option>
                                                </c:if>
                                            </c:forEach>
                                </select></pre>
        <pre>Division:          <select name="division">
                                            <c:forEach var="division" items="${divisionMap}">
                                                <c:if test="${division.key == employee.divisionId}">
                                                    <option selected value="${division.key}">${division.value}</option>
                                                </c:if>
                                                <c:if test="${division.key != employee.divisionId}">
                                                    <option value="${division.key}">${division.value}</option>
                                                </c:if>
                                            </c:forEach>
                                </select></pre>
        <pre>                    <input type="submit" value="Edit"></pre>
    </form>
</div>
<pre style="text-align: center"> ${mess}</pre>
<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
