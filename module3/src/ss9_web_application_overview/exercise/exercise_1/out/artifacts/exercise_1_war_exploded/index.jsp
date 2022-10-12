<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ứng dụng Product Discount Calculator</title>
    <style>
        body {
            font-size: 15px;
            font-family: Arial;
        }

        form {
            width: 40%;
        }

        input {
            margin-bottom: 15px;
            height: 25px;
            text-align: center;
            margin-left: 10px;
        }

        label {
            font-weight: bold;
        }

        .row2 {
            padding-left: 75px;
        }

        .row3 {
            padding-left: 19px;
        }
    </style>
</head>
<body>
<form action="/discount">
    <fieldset>
        <legend style="text-align: center"><h2>Product Discount Calculator</h2></legend>
        <div class="row1">
            <label for="describe">Product Description :</label>
            <input id="describe" type="text" name="describe" placeholder="Mô tả của sản phẩm" size="30px">
        </div>
        <div class="row2">
            <label for="price">List Price :</label>
            <input id="price" type="text" name="price" placeholder="Giá niêm yết của sản phẩm" size="30px">
        </div>
        <div class="row3">
            <label for="discount">Discount Percent :</label>
            <input id="discount" type="text" name="discount" placeholder="Tỷ lệ chiết khấu (phần trăm)" size="30px">
        </div>
        <div style="text-align: center;margin-top: 20px">
            <input type="submit" value="Calculate Discount" style="margin-left: 0px; height: 30px; width: 150px;">
        </div>
    </fieldset>
</form>
</body>
</html>
