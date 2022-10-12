<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo trang web để đăng nhập và hiển thị lời chào</title>
    <style>
        body {
            font-size: 15px;
            font-family: Tahoma;
        }
        form{
            margin: -20px 20px 0px 20px;
        }
        form input {
            margin-bottom: 15px;
            line-height: 20px;
        }
        form label {
            text-align: left;
            font-weight: bold;
            margin-right: 75px;
        }
    </style>
</head>
<body>
<form action="/login" method="post">
    <fieldset style="width: 40%">
        <legend style="text-align: center"><h1>Login</h1></legend>
        <div style="text-align: left">
            <div>
                <label for="lab-1">UserName:</label>
                <input id="lab-1" type="text" name="username" placeholder="username" size="20px" style="text-align: center">
            </div>
            <div style="padding-left: 2px">
                <label for="lab-2">PassWord:</label>
                <input id="lab-2" type="password" name="password" placeholder="password" size="20px" style="text-align: center">
            </div>
            <div style="text-align: center">
                <input type="submit" value="Sign in" style="width: 80px">
            </div>
        </div>
    </fieldset>
</form>
</body>
</html>
