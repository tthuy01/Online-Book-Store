<%-- 
    Document   : addauthor
    Created on : Mar 5, 2022, 11:39:41 PM
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

        <style>
            body {
                margin: 0;
                padding: 0;
                background-color: orange;
            }

            .add-author-form {
                width: 400px;
                padding: 40px;
                position: absolute;
                top: 45%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: rgba(0, 0, 0, 0.8);
            }

            .add-author-form h1 {
                color: white;
                text-transform: uppercase;
                font-weight: 500;
                text-align: center;
            }

            .add-author-form input[type="text"] {
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
            .add-author-form input[type="text"]:focus {
                width: 280px;
                border-color: green;
            }

            .add-author-form input[type="submit"] {
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

            .add-author-form input[type="submit"]:hover {
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
            }
        </style>
    </head>
    <body>
        <div style="margin-top: 30px">
            <a href="allbook">Trang chủ</a>
            <a href="addmenu.jsp">Quay lại</a>
        </div>
        <form class="add-author-form" action="addauthor">
            <h1>Thêm tác giả</h1>
            <h3 style="color: red; text-align: center">${requestScope.error}</h3>
            <input type="text" name="name" placeholder="Tên tác giả">
            <input type="text" name="date" placeholder="Ngày sinh (yyyy-mm-dd)">
            <input type="text" name="address" placeholder="Địa chỉ">
            <div class="g" style="color: white; padding-left: 92px;">
                Giới tính
                <input type="radio" name="gender" value="0" checked>Nam
                <input type="radio" name="gender" value="1">Nữ
            </div>
            <input type="submit" value="Thêm mới">
        </form>
    </body>
</html>
