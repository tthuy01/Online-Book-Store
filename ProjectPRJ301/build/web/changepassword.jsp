<%-- 
    Document   : changepassword
    Created on : Mar 17, 2022, 12:22:34 AM
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
        <link rel="icon" href="images/bs.png" type="image/x-icon">

        <!--Bootstrap-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <style>
            body {
                margin: 0;
                padding: 0;
                background-color: orange;
            }

            .change-password-form {
                width: 400px;
                padding: 40px;
                position: absolute;
                top: 45%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: rgba(0, 0, 0, 0.8);
            }

            .change-password-form h1 {
                color: white;
                text-transform: uppercase;
                font-weight: 500;
                text-align: center;
            }

            .change-password-form input[type="password"] {
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
            .change-password-form input[type="password"]:focus {
                width: 280px;
                border-color: green;
            }

            .change-password-form input[type="submit"] {
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

            .change-password-form input[type="submit"]:hover {
                background-color: orange;
            }

            a:link {
                text-decoration: none;
            }

            a {
                margin-left: 10px;
                margin-top: 50px;
                font-size: 20px;

                border: 0;
                background: none;
                /*display: block;*/
                text-align: center;
                border: 2px solid black;
                padding: 14px 40px;
                outline: none;
                color: white;
                border-radius: 24px;
                transform: 0.25s;
                cursor: pointer;
            }

            a:hover {
                background-color: rgba(0, 0, 0, 0.8);
                color: white;
            }
        </style>
    </head>
    <body style="background-color: orange">
        <div style="margin-top: 30px">
            <a href="allbook">Trang chủ</a>
            <a href="profile?tendangnhap=${sessionScope.account.tenDangNhap}">Quay lại</a>
        </div>
        <!--Change password-->
        <div class="change-password">
            <form class="change-password-form" action="changepassword">
                <h1>Đổi mật khẩu</h1>
                <input type="password" name="old" placeholder="Mật khẩu cũ">
                <input type="password" name="new" placeholder="Mật khẩu mới">
                <input type="password" name="renew" placeholder="Nhập lại mật khẩu mới">
                <input type="submit" value="Change">
                <div class="notice">
                    <p style="color: red; text-align: center; font-size: 20px;">${requestScope.notice}</p>
                </div>
            </form>
        </div>
    </div>


    <!--Thư viên javascript của Bootstrap-->
    <script src="js/Jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
