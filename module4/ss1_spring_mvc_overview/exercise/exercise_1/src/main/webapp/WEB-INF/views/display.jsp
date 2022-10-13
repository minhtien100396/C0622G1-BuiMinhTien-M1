<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Ứng dụng chuyển đổi tiền tệ</title>
    <style>
        form {
            margin-top: -20px;
            width: 30%;
        }

        legend {
            text-align: center;
        }

        input {
            margin-bottom: 20px;
        }

        .data {
            margin-left: 1px;
        }

        input {
            margin-left: 10px;
        }

        label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<form action="/conveter/usd" method="post">
    <fieldset>
        <legend><h1>Currency Converter</h1></legend>
        <div class="data">
            <label for="rate">Rate:</label>
            <input type="text" name="rate" id="rate" value="22000" readonly>
        </div>
        <div>
            <label for="usd">USD:</label>
            <input type="text" name="usd" id="usd">
        </div>
        <div>
            <input type="submit" value="Converter" style="margin-left: 0px">
        </div>
    </fieldset>
</form>
<c:if test="${usd > 0}">
    <h1>${usd} USD = ${result} VND</h1>
</c:if>
<c:if test="${usd <= 0}">
    <h2>${error}</h2>
</c:if>
</body>
</html>
