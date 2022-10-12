<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng chuyển đổi tiền tệ - Servlet</title>
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
            margin-left: 10px ;
        }
        label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<form action="/currency">
    <fieldset>
        <legend><h1>Currency Converter</h1></legend>
        <div class="data">
            <label for="rate" >Rate:</label>
            <input type="text" name="rate" id="rate" value="22000" readonly>
        </div>
        <div>
            <label for="usd">USD:</label>
            <input type="text" name="usd" id="usd">
        </div>
        <div >
            <input type="submit" value="Converter" style="margin-left: 0px">
        </div>
    </fieldset>
</form>
</body>
</html>
