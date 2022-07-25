<%-- 
    Document   : login
    Created on : Mar 3, 2022, 5:43:15 PM
    Author     : May Tinh Ha Anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T4 Book Store</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--Thêm logo vào link-->
        <link rel="icon" href="images/bs.png">

        <style>
            body {
                margin: 0;
                padding: 0;
                background-color: orange;
            }

            .login-form {
                width: 400px;
                padding: 40px;
                position: absolute;
                top: 40%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: rgba(0, 0, 0, 0.8);
            }

            .login-form h1 {
                color: white;
                text-transform: uppercase;
                font-weight: 500;
                text-align: center;
            }

            .login-form input[type="text"], .login-form input[type="password"] {
                border: 0;
                background: none;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid orange;
                padding: 14px 10px;
                width: 200px;
                outline: none;
                color: white;
                border-radius: 24px;
                transform: 0.25s;
            }
            .login-form input[type="text"]:focus, .login-form input[type="password"]:focus {
                width: 280px;
                border-color: green;
            }

            .rem {
                margin-left: 80px;

            }

            .login-form input[type="submit"] {
                border: 0;
                background: none;
                display: block;
                margin: 20px auto;
                text-align: center;
                border: 2px solid orange;
                padding: 14px 40px;
                outline: none;
                color: white;
                border-radius: 24px;
                transform: 0.25s;
                cursor: pointer;
            }

            .login-form input[type="submit"]:hover {
                background-color: orange;
            }

            .dk a {
                border: 0;
                background: none;
                padding: 5px;
                border: 2px solid orange;
                outline: none;
                border-radius: 24px;
                transform: 0.25s;
                cursor: pointer;
            }

            .dk a:link{
                color: white;
                text-decoration: none;
            }

            .dk a:hover{
                background-color: orange;
            }      
        </style>
    </head>
    <body>
        <form class="login-form" action="login" method="post">
            <h1>Đăng nhập</h1>
            <h3 style="color: red; text-align: center">${requestScope.error}</h3>
            <input type="text" name="user" placeholder="Enter username" value="${cookie.user.value}">
            <input type="password" name="pass" placeholder="Enter password" value="${cookie.pass.value}">
            <input type="checkbox" ${(cookie.rem.value eq 'on')?"checked":""} name="rem" style="margin-left: 90px;"><span style="color: white;">Remember me</span> <br/>
            <input type="submit" value="Đăng nhập">
            <div class="dk" style="margin-top: 20px; margin-left: 90px;">
                <span style="color: white;">Bạn chưa có tài khoản?</span> <a href="signup" style="color: white">Đăng ký</a> <br/>
            </div>
        </form>
    </body>
</html>
