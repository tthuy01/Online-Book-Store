<%-- 
    Document   : addmenu
    Created on : Mar 5, 2022, 10:29:10 PM
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

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <style>
            body {
                background-color: orange;
            }

            h3 a:link {
                text-decoration: none;
                color: white;
            }

            .nd {
                margin-top: 25%;
                background-color: rgba(0, 0, 0, 0.8);
            }

            h3 {
                margin-top: 20px;
                margin-bottom: 20px;
                box-sizing: border-box;
                border: 0;
                background: none;
                padding: 10px;
                border: 2px solid orange;
                outline: none;
                border-radius: 24px;
                transform: 0.25s;
                cursor: pointer;
            }

            h3:hover {
                background-color: orange;
                color: white;
            }
            
            a:visited {
                color: white;
            }
                       
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row nd">
                <div class="col-md-3 text-center">
                    <h3><a href="allbook">Trang chủ</a></h3>
                </div>
                <div class="col-md-3 text-center">
                    <h3><a href="addauthor.jsp">Thêm tác giả</a></h3>
                </div>
                <div class="col-md-3 text-center">
                    <h3><a href="addpublisher.jsp">Thêm nhà xuất bản</a></h3>
                </div>
                <div class="col-md-3 text-center">
                    <h3><a href="addbook">Thêm sách mới</a></h3>
                </div>
            </div>
        </div>


        <!--Thư viên javascript của Bootstrap-->
        <script src="js/Jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
