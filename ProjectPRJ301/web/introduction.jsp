<%-- 
    Document   : introduction
    Created on : Mar 15, 2022, 1:05:20 AM
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
    </head>
    <body style="background-color: orange;">
        <div class="container">

            <!--Ảnh bìa-->
            <div class="row">
                <div class="col-12">
                    <img src="images/ab1.jpg" class="img-responsive img-center">
                </div>
            </div>

            <!--Thanh điều hướng (menu1)-->
            <div class="row">
                <div class="col-12">
                    <nav class="nav navbar navbar-inverse" role="navigation">
                        <div class="container-fluid"> <!--lớp container-fluif làm cho phần tử có chiều rộng là 100%-->

                            <!--Dùng thêm button để responsive-->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar">
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="allbook">T4BookStore</a>
                            </div>

                            <div class="collapse navbar-collapse" id="mynavbar">                       
                                <ul class="nav navbar-nav navbar-right">                                   
                                    <li>
                                        <a href="introduction.jsp"><i class="glyphicon glyphicon-book"></i> Giới thiệu</a>
                                    </li>
                                    <li>
                                        <a href="login"><i class="glyphicon glyphicon-log-in"></i> Đăng Nhập/Đăng ký</a>
                                    </li>
                                </ul>

                                <!--Search box--> 
                                <form action="search" class="navbar-form" role="search" style="text-align: center;">
                                    <div class="form-group">
                                        <input type="search" class="form-control" placeholder="Nhập tên sách, tác giả" name="key" style="width: 350px" value="${requestScope.key}"/>
                                    </div>
                                    <button type="submit" class="btn btn-warning glyphicon glyphicon-search"></button>
                                </form>

                            </div>
                        </div>
                    </nav>
                </div>
            </div>

            <!--Nội dung-->
            <div class="row nd" style="background-color: black; color: white; width: 40%; margin: 0 auto;">
                <div style="padding: 5%;">
                    <h1 style="text-align: center;">T4 Book Store</h1>
                    <p style="margin-top: 2%;">Cửa hàng sách online. Nhận đặt hàng trực tuyến và ship tận nơi. KHÔNG hỗ trợ đặt mua và nhận hàng trực tiếp tại văn phòng.</p>
                    <p>Chi tiết xin liên hệ:</p>
                    <p><i class="glyphicon glyphicon-envelope"> <span>admin@gmail.com</span></i></p>
                    <p><i class="glyphicon glyphicon-phone-alt"> <span>1900123456</span></i></p>
                    <p><i class="glyphicon glyphicon-phone"> <span>012345678</span></i></p>
                    <p><img src="images/icon-facebook.png" alt="" height="18px" width="18px"><a
                            href="https://www.facebook.com/" style="color: white; padding-left: 10px;">Facebook</a></p>
                    <p><img src="images/icon-address.jpg" height="18px" width="18px"><span style="padding-left: 10px;">Thái
                            Nguyên</span></p>
                    <p style="margin-bottom: 5%;">Cảm ơn mọi người đã ghé thăm.</p>
                </div>
            </div>

            <div style="clear: both;"></div>
            <!--Footer-->
            <div class="row" style="background-color: black; color: white; display: flex; margin-top: 2%;">
                <div class="gtfooter" style="flex-grow: 1 ;padding-left: 2%; padding-top: 2%; padding-bottom: 2%;">
                    <img src="images/bs.png">
                    <p style="margin-top: 2%;">T4BookStore nhà sách online, nhận đặt hàng trực tuyến và giao hàng tận nơi.
                    </p>
                </div>
                <div class="lhfooter" style="flex-grow: 1; padding-right: 2%; padding-top: 2%; padding-bottom: 2%;">
                    <p>Chi tiết xin liên hệ:</p>
                    <p><i class="glyphicon glyphicon-envelope"> admin@gmail.com</i></p>
                    <p><i class="glyphicon glyphicon-phone-alt"> 1900123456</i></p>
                    <p><i class="glyphicon glyphicon-phone"> 012345678</i></p>
                </div>
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
