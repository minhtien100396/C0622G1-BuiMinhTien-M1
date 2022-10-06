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
                                    style="font-size: 20px">Add New <span
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
    <form action="/student?action=add" method="post">
        <%--    <pre>ID:       <input type="text" name="id"/></pre>--%>
        <pre>Name:     <input type="text" name="name"> </pre>
        <pre>Gender :  <input type="radio" name="gender" value="true">Nam <input type="radio" value="false" name="gender"> Nữ </pre>
        <pre>Birthday: <input type="date" name="birthday"> </pre>
        <pre>Point:    <input type="number" name="point"> </pre>
        <c:if test="${map.get('point')!=null}">
            <span>${map.get('point')}</span>
        </c:if>
        <%--    <pre>Account:  <input type="text" name="account"> </pre>--%>
        <pre>Email:    <input type="text" name="email"> </pre>
        <c:if test="${map.get('email')!=null}">
            <span>${map.get('email')}</span>
        </c:if>
        <pre>ClassId:  <select name="classId">
                   <option value="">Chọn lớp</option>
                   <c:forEach var="cls" items="${classList}">
                       <option value="${cls.id}">${cls.name}</option>
                   </c:forEach>
                    </select></pre>
        <pre>           <button>Save</button></pre>
    </form>
</div>

<script src="../../bootstrap/js/bootstrap.js"></script>
<script src="../../bootstrap/js/bootstrap.min.js"></script>
<script src="../../bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
