<%-- 
    Document   : vieworderdetail
    Created on : Mar 16, 2022, 11:37:06 PM
    Author     : May Tinh Ha Anh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .menu-profile a:link {
                text-decoration: none;
            }

            .menu-profile a {
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
                cursor: pointer;

            }

            .menu-profile a:hover {
                background-color: rgba(0, 0, 0, 0.8);
            }

            .menu-profile a:active {
                background-color: #4CAF50;
                border: 2px solid #4CAF50;                
            }

            /*            .menu-profile a:visited {
                            background-color: orange;
                            border: 2px solid black;                
                        }*/

            td {
                text-align: center;
                padding: 2px 10px;
            }

            td a {
                color: white;
            }

            td a:link {
                color: white;
                text-decoration: none;
            }

            td a:hover {
                color: orange;
                text-decoration: none;
            }

        </style>
    </head>
    <body style="background-color: orange">
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
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="allbook">T4BookStore</a>
                            </div>

                            <div class="collapse navbar-collapse" id="mynavbar">                       
                                <ul class="nav navbar-nav navbar-right">
                                    <li>
                                        <c:if test="${sessionScope.account == null}">
                                            <a href="#"></a>
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                            <c:if test="${sessionScope.account.maPhanQuyen == 0}">
                                                <a href="showcart"><i class="glyphicon glyphicon-shopping-cart"></i> Giỏ hàng(${requestScope.cartsize})</a>
                                            </c:if>
                                            <c:if test="${sessionScope.account.maPhanQuyen == 1}">
                                                <a href="#"><i class="glyphicon glyphicon-signal"></i> Doanh thu</a>
                                            </c:if>
                                        </c:if>
                                    </li>
                                    <li>
                                        <c:if test="${sessionScope.account == null}">
                                            <a href="introduction.jsp"><i class="glyphicon glyphicon-book"></i> Giới thiệu</a>
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                            <a href="profile?tendangnhap=${sessionScope.account.tenDangNhap}"><i class="glyphicon glyphicon-user"></i> ${sessionScope.account.tenDangNhap}</a>
                                        </c:if>
                                    </li>
                                    <li>
                                        <c:if test="${sessionScope.account == null}">
                                            <a href="login"><i class="glyphicon glyphicon-log-in"></i> Đăng Nhập/Đăng ký</a>
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                            <a href="logout"><i class="glyphicon glyphicon-log-out"></i> Đăng xuất</a>
                                        </c:if>
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

            <div class="content" style="display: flex;">
                <div class="menu-profile" style="flex-grow: 2; color: white; padding: 2% 2%; margin-top: 2%;">
                    <c:if test="${sessionScope.account.maPhanQuyen == 0}"> 
                        <a href="profile?tendangnhap=${sessionScope.account.tenDangNhap}" style="background-color: #4CAF50; border: 2px solid #4CAF50;">Thông tin khách hàng</a> <br/><br/><br/>
                        <a href="vieworder">Đơn hàng đã đặt</a> <br/><br/><br/>
                        <a href="changepassword.jsp">Đổi mật khẩu</a> <br/><br/><br/>
                        <a href="updateinformation?mataikhoan=${sessionScope.account.maTaiKhoan}">Edit</a> <br/><br/><br/>
                    </c:if>

                    <c:if test="${sessionScope.account.maPhanQuyen == 1}"> 
                        <a href="profile?tendangnhap=${sessionScope.account.tenDangNhap}" style="background-color: #4CAF50; border: 2px solid #4CAF50;">Thông tin khách hàng</a> <br/><br/><br/>
                        <a href="viewallorder">Tất cả đơn hàng</a> <br/><br/><br/>
                        <a href="changepassword.jsp">Đổi mật khẩu</a> <br/><br/><br/>
                        <a href="updateinformation?mataikhoan=${sessionScope.account.maTaiKhoan}">Edit</a> <br/><br/><br/>
                    </c:if>
                </div>
                <div class="profile" style="color: white; width: 70%; margin: 0 auto; padding: 2% 2%; flex-grow: 3;">
                    <div class="view-content" style="width: 100%; margin: 0 auto; background-color: black; padding: 2% 5%; font-size: 20px;">
                        <table border="1px" style="margin: 0 auto; width: 100%;">
                            <tr>
                                <td>Tên sách</td>
                                <td>Số lượng</td>
                                <td>Giá</td>
                            </tr>
                            <c:forEach items="${requestScope.orderdetail}" var="i">
                                <tr>
                                    <td>${i.sach.tenSach}</td>
                                    <td>${i.soLuong}</td>
                                    <td>${i.gia}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>

            <div style="clear: both;"></div>
            <!--Footer-->
            <div class="row" style="background-color: black; color: white; display: flex; margin-top: 2%">
                <div class="gtfooter" style="flex-grow: 1 ;padding-left: 2%; padding-top: 2%; padding-bottom: 2%;">
                    <img src="images/bs.png">
                    <p style="margin-top: 2%;">T4BookStore nhà sách online, nhận đặt hàng trực tuyến và giao hàng tận nơi. </p>
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
