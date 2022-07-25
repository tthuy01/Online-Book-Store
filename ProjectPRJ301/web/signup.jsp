<%-- 
    Document   : signup
    Created on : Mar 4, 2022, 11:20:59 PM
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

            .dk-form {
                width: 800px;
                padding: 40px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: rgba(0, 0, 0, 0.8);
            }

            .dk-form h1 {
                color: white;
                text-transform: uppercase;
                font-weight: 500;
                text-align: center;
            }

            .dk-form input[type="text"], .dk-form input[type="password"] {
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

            .dk-form input[type="text"]:focus, .dk-form input[type="password"]:focus{
                width: 280px;
                border-color: green;
            }

            .dk-form input[type="submit"] {
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

            .dk-form input[type="submit"]:hover {
                background-color: orange;
            }

            .content-left {
                width: 50%;
                float: left;
                text-align: center;
            }

            .content-right {
                width: 50%;
                float: right;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <form class="dk-form" action="signup" method="post">
            <h1>Đăng ký</h1>
            <h3 style="color: red; text-align: center">${requestScope.error}</h3>
            <div class="content-left">
                <input type="text" name="name" placeholder="Họ và tên">
                <input type="text" name="date" placeholder="Ngày sinh">
                <input type="text" name="phone" placeholder="Số điện thoại">
                <input type="text" name="email" placeholder="Email">
            </div>
            <div class="content-right">
                <input type="text" name="address" placeholder="Địa chỉ">
                <input type="text" name="user" placeholder="Tên đăng nhập">
                <input type="password" name="pass" placeholder="Mật khẩu">
                <input type="password" name="cfpass" placeholder="Xác nhận mật khẩu">
            </div>
            <div style="color: white; padding-left: 92px;">
                Giới tính:
                <input type="radio" name="gender" value="0" checked>Nam
                <input type="radio" name="gender" value="1">Nữ
            </div>
            <input type="submit" value="Đăng ký">
        </form>
    </body>
</html>
