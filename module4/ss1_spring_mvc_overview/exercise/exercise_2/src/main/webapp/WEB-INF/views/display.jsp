<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ứng dụng Từ điển đơn giản</title>
    <style>
        form {
            margin-top: -20px;
            width: 30%;
        }

        legend {
            text-align: center;
        }

        input {
            margin-left: 10px;
            margin-bottom: 20px;
            height: 30px;
        }

    </style>
</head>
<body>
<form action="/distionary/result" method="post">
    <fieldset>
        <legend><h1>VietNamese Distionary</h1></legend>
        <div style="text-align: center">
            <input type="text" name="word" placeholder="Enter your word:" 　>
            <input type="submit" value="Search" style="width: 80px">
        </div>
    </fieldset>
</form>
<c:if test="${result == null}">
    <h1>${error}</h1>
</c:if>
<c:if test="${result != null}">
    <h1>${word} : ${result}</h1>
</c:if>
</body>
</html>
