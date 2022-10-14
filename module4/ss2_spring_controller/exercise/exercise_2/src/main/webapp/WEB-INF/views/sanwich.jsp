<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng hiển thị gia vị với Sandwich</title>
    <style>
        body {
            font-size: 15px;
            font-family: Arial;
        }

        legend {
            text-align: left;
        }

        h2 {
            text-align: center;
            width: 30%;
            margin-top: 30px;
        }

        form {
            width: 30%;
            margin-top: -20px;
        }

        div {
            margin-bottom: 10px;
        }

        input, select {
            height: 20px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<h1>Sandwich Codiments</h1>
<form action="/sanwich">
    <span><input type="checkbox" value="Lettuce" name="condiment">Lettuce</span>
    <span><input type="checkbox" value="Tomato" name="condiment">Tomato</span>
    <span><input type="checkbox" value="Mustard" name="condiment">Mustard</span>
    <span><input type="checkbox" value="Sprouts" name="condiment">Sprouts</span>
    <hr>
    <input type="submit" value="Save">
</form>
<h1>${condiment}</h1>
</body>
</html>
