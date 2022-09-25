<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng Từ điển đơn giản - Servlet</title>
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
<form action="/distionary">
    <fieldset>
        <legend><h1>VietNamese Distionary</h1></legend>
        <div style="text-align: center">
            <input type="search" name="word" placeholder="Enter your word:" 　>
            <input type="submit" value="Search" style="width: 80px">
        </div>
    </fieldset>
</form>
</body>
</html>
