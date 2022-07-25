<%-- 
    Document   : detail
    Created on : Mar 12, 2022, 9:01:42 PM
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

        <!--css-->
        <link rel="stylesheet" href="css/detailstyle.css">

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
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="allbook">T4BookStore</a>
                            </div>

                            <div class="collapse navbar-collapse" id="mynavbar">                       
                                <ul class="nav navbar-nav navbar-right">
                                    <!--                                    <li><a href="#">Giới thiệu</a></li>
                                                                        <li><a href="#">Giỏ hàng</a></li>
                                                                        <li><a href="#">Đăng Nhập/Đăng ký</a></li>-->
                                    <li>
                                        <c:if test="${sessionScope.account == null}">
                                            <a href="#"></a>
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                            <c:if test="${sessionScope.account.maPhanQuyen == 0}">
                                                <a href="showcart"><i class="glyphicon glyphicon-shopping-cart"></i> Giỏ hàng(${requestScope.cartsize})</a>
                                            </c:if>
                                            <c:if test="${sessionScope.account.maPhanQuyen == 1}">
                                                <a href="doanhthu"><i class="glyphicon glyphicon-signal"></i> Doanh thu</a>
                                            </c:if>
                                        </c:if>
                                    </li>
                                    <li>
                                        <c:if test="${sessionScope.account == null}">
                                            <a href="#"><i class="glyphicon glyphicon-book"></i> Giới thiệu</a>
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

            <div class="product-detail">
                <c:set var="bd" value="${requestScope.bookdetail}"></c:set>
                    <div class="product-detail-img">
                        <img src="${bd.anh}" class="img-responsive img-center" width="400px" height="400px">
                </div>

                <div class="product-detail-des" style="color: white; background-color: black; margin-right: 7%;">
                    <div class="product-detail-des-item" style="padding-left: 4%; padding-right: 4%;">
                        <h1>${bd.tenSach}</h1>
                        <p>Tác giả: ${bd.tg.tenTacGia}</p>
                        <p>Thể loại: ${bd.tl.theLoai}</p>
                        <p>Nhà xuất bản: ${bd.n.tenNXB}</p>
                        <p>Ngày xuất bản: ${bd.ngayXB} (Năm-tháng-ngày)</p>
                        <p>Giá: ${bd.gia}</p>
                        <p>Số lượng tồn kho: ${bd.soLuongTonKho}</p>
                        <p>Số lượng trong giỏ hàng: ${requestScope.soluongcuasachtronggiohangtheomasach}</p>
                        <form action="" name="f">
                            <p>Số lượng
                                <input style="color: black;" type="button" onclick="minus('${bd.soLuongTonKho-requestScope.soluongcuasachtronggiohangtheomasach}')" value="-">
                                <!-- <form action="#"> -->
                                <input style="color: black; width: 10%; text-align: center;" type="text" <c:if test="${bd.soLuongTonKho-requestScope.soluongcuasachtronggiohangtheomasach > 0}"> value="1" </c:if> 
                                       <c:if test="${bd.soLuongTonKho-requestScope.soluongcuasachtronggiohangtheomasach <= 0}"> value="0" </c:if> 
                                           id="soluong" name="soluong">
                                       <!-- </form> -->
                                       <input style="color: black;" type="button" onclick="plus('${bd.soLuongTonKho-requestScope.soluongcuasachtronggiohangtheomasach}')" value="+">
                            </p>
                        </form>
                    </div>
                    <div class="product-detail-option">
                        <form action="" method="post">
                            <a class="product-detail-option-scart" href="#" onclick="addtocart('${bd.maSach}')">Thêm vào giỏ hàng</a> &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="product-detail-option-buy" href="#" onclick="buy('${bd.maSach}')">Mua ngay</a>
                        </form>
                    </div>
                </div>
            </div>

            <%--    <!--Thêm bình luận-->
                <div class="cmt row" style="background-color: black; color: white; margin-top: 2%;">
                    <div class="cmt-title">
                        <h1>Bình luận</h1>
                    </div>
                    <div class="cmt-detail">
                        
                    </div>
                </div>
            --%>

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
    </body>
</html>

<script>
    function minus(num) {
        var t = document.getElementById('soluong').value;
        if (parseInt(t) > 1) {
            document.getElementById('soluong').value = parseInt(t) - 1;
        }
        if (parseInt(num) <= 0)
        {
            document.getElementById('soluong').value = 0;
        }
    }

    function plus(num) {
        var t = document.getElementById('soluong').value;
        document.getElementById('soluong').value = parseInt(t) + 1;
        if (parseInt(num) <= 0)
        {
            document.getElementById('soluong').value = 0;
        } else
        {
            if ((parseInt(t) + 1) <= num)
            {
                document.getElementById('soluong').value = parseInt(t) + 1;
            } else
            {
                document.getElementById('soluong').value = parseInt(t);
            }
        }
    }

    function addtocart(maSach) {
        var m = document.getElementById('soluong').value;
        window.location = "addtocart?masach=" + maSach + "&soluong=" + m;
    }
    
    function buy(maSach) {
        var m = document.getElementById('soluong').value;
        window.location = "buy?masach=" + maSach + "&soluong=" + m;
    }
</script>
