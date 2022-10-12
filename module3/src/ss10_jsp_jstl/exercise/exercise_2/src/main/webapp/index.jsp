<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng Calculator</title>
    <style>
        body{
            font-size: 15px;
            font-family: Arial;
        }

        legend{
            text-align: left;
        }
        h2{
            text-align: center;
            width: 30%;
            margin-top: 30px;
        }
        form{
            width: 30%;
            margin-top: -20px;
        }
        div {
            margin-bottom:10px ;
        }
        input,select {
            height: 20px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<h2>Simple Calculator</h2>
<form action="/calculator">
    <fieldset>
        <legend><h3>Calculator</h3></legend>
        <div style="margin-top: -5px">
            <label for="first"style="margin-left: 23px">First operand:</label>
            <input type="text" name="first" placeholder="Số hạng thứ nhất:" id="first" required>
        </div>
        <div>
            <label for="operator" style="margin-left: 50px">Operator:</label>
            <select id="operator" name="select" >
                <option value="+" name="sum">Cộng</option>
                <option value="-" name="subtraction" selected>Trừ</option>
                <option value="x" name="multiplication">Nhân</option>
                <option value="/" name="division">Chia</option>
            </select>
        </div>
        <div>
            <label for="second">Second operand:</label>
            <input type="text" name="second" placeholder="Số hạng thứ hai:" id="second" required>
        </div>
        <div style="text-align: center; margin-bottom: 10px">
            <input type="submit" value="Calculator" style="height: 30px;margin-top: 10px">
        </div>
    </fieldset>
</form>
<h3 style="padding-left: 10px; width: 100%">${result}</h3>
</body>
</html>
