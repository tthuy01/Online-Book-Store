<%-- 
    Document   : allbook
    Created on : Mar 3, 2022, 5:19:25 PM
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
        <link rel="stylesheet" href="css/stylesheet.css">

        <!--Bootstrap-->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <style>
            .filter-name {
                width: 100%;
            }

            .openbtn {
                width: 16%;
                float: right;
            }

            .sidebar {
                height: 100%;
                width: 0;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: black;
                color: white;
                overflow-x: hidden;
                transition: 0.5s;
                padding-top: 60px;

            }

            .sidebar a {
                padding: 8px 8px 8px 32px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
                transition: 0.3s;
                color: #F3F90E;
            }

            .sidebar a:hover {
                color: #FFFFFF;
            }

            .sidebar .closebtn {
                position: absolute;
                top: 0;
                right: 25px;
                font-size: 36px;
                margin-left: 50px;
            }

            .openbtn {
                font-size: 20px;
                cursor: pointer;
                background-color: black;
                color: white;
                padding: 10px;
                border: none;
            }

            .openbtn:hover {
                background-color: #4CAF50;
            }
        </style>
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

            <!--Menu2 và slider-->
            <div class="row">
                <div class="col-12">
                    <!--Tạo danh sách mục và slider-->
                    <div class="row">
                        <div class="under-nav col-md-12">

                            <!--Danh sách mục-->
                            <div class="left-nav">
                                <div class="title-menu2">
                                    <h3><strong>Danh mục sản phẩm</strong></h3>
                                </div>
                                <ul class="menu2">
                                    <c:set var="matheloai" value="${requestScope.matheloai}"></c:set>
                                    <c:forEach items="${requestScope.alltheloai}" var="tl">
                                        <li><a href="tab?matheloai=${tl.maTheLoai}">${tl.theLoai}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>

                            <!--Slider-->
                            <div class="right-nav">
                                <div class="row sl">
                                    <div class="nopadding">
                                        <div id="carousel-myslider" class="carousel slide mys" data-ride="carousel">
                                            <!--Indicators-->
                                            <ol class="carousel-indicators">
                                                <li data-target="#carousel-myslider" data-slide-to="0" class="active"></li>
                                                <li data-target="#carousel-myslider" data-slide-to="1"></li>
                                                <li data-target="#carousel-myslider" data-slide-to="2"></li>
                                            </ol>

                                            <!--Wrapper-->
                                            <div class="carousel-inner" role="listbox">
                                                <div class="item active">
                                                    <a href="#"><img src="images/hr1.jpg" alt="Ảnh"></a>
                                                </div>

                                                <div class="item">
                                                    <a href="#"><img src="images/bsx.jpg" alt="Ảnh"></a>
                                                </div>

                                                <div class="item">
                                                    <a href="#"><img src="images/dtvncct.jpg" alt="Ảnh"></a>
                                                </div>
                                            </div>

                                            <!--Controls-->
                                            <a href="#carousel-myslider" class="left carousel-control" role="button" data-slide="prev">
                                                <span class="glyphicon glyphicon-chevron-left"></span>
                                            </a>
                                            <a href="#carousel-myslider" class="right carousel-control" role="button" data-slide="next">
                                                <span class="glyphicon glyphicon-chevron-right"></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--Nội dung-->
            <div class="row nd">

                <!--Tiêu đề nội dung-->
                <div class="col-12">
                    <div class="title-content">

                        <div class="title-content-right">
                            <h3>
                                <c:if test="${sessionScope.account == null}">
                                    <a href="allbook">Tất cả sản phẩm</a>
                                </c:if>
                                <c:if test="${sessionScope.account != null}">
                                    <c:if test="${sessionScope.account.maPhanQuyen == 0}">
                                        <a href="allbook">Tất cả sản phẩm</a>
                                    </c:if>
                                    <c:if test="${sessionScope.account.maPhanQuyen == 1}">
                                        <a href="addmenu.jsp">Thêm sách mới</a>
                                    </c:if>
                                </c:if>
                            </h3>
                        </div>

                        <div class="title-content-left">
                            <h3><a href="hotsale">Sách bán chạy</a></h3>
                        </div>  

                        <div class="title-content-select">
                            <h4>
                                <select name="sort" onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);">
                                    <option value="default">Sắp xếp theo</option>
                                    <option value="?sort=asc">Tăng dần theo giá</option>
                                    <option value="?sort=desc">Giảm dần theo giá</option>
                                </select>
                            </h4>
                        </div>

                        <div style="clear: both;"></div>

                    </div>
                </div>

                <!--Filter-->
                <div class="col-12">
                    <div class="filter-name">
                        <h3><button class="openbtn" onclick="openNav()">☰ Nhà xuất bản</button></h3>
                    </div>

                    <div>
                        <div id="mySidebar" class="sidebar">
                            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
                            <div style="margin-left: 20px">
                                <h3>Nhà xuất bản</h3>
                                <form action="filternxb">
                                    <%--    <c:forEach items="${requestScope.allnxb}" var="n">
                                            <input type="checkbox" class="checkbox-option-n form-check form-check-inline" name="manxb" value="${n.maNXB}">
                                            <span>${n.tenNXB}</span> <br/>
                                        </c:forEach> --%>
                                    <c:set var="m" value="${requestScope.allnxb}"></c:set>
                                    <c:set var="tf" value="${requestScope.maNXBTF}"></c:set>
                                    <c:forEach begin="0" end="${(m.size()-1)}" var="i">
                                        <input onclick="this.form.submit()" type="checkbox" class="checkbox-option-n form-check form-check-inline" 
                                               name="manxb" value="${m.get(i).getMaNXB()}"${tf[i]?"checked":""}>
                                        ${m.get(i).getTenNXB()} <br/>
                                    </c:forEach>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>  

                <div style="clear: both;"></div>

                <!--Sản phẩm-->
                <div class="col-md-12 list-sp">
                    <form action="" method="">
                        <c:forEach items="${requestScope.allbook}" var="ab">
                            <div class="col-md-3 sp">
                                <div class="sp-img">
                                    <img src="${ab.anh}" alt="${ab.tenSach}" class="img-responsive img-center">
                                </div>

                                <div class="sp-des">
                                    <p class="sp-des-title"><a href="detail?masach=${ab.maSach}" style="font-weight: bold; font-size: 16px">${ab.tenSach}</a></p>
                                    <p class="sp-des-price">Giá: ${ab.gia}VNĐ</p>
                                </div>

                                <div class="sp-option">
                                    <c:if test="${sessionScope.account != null}">

                                        <c:if test="${sessionScope.account.maPhanQuyen == 0}">
                                            <%--<input type="button" onclick="buy('${ab.maSach}')" value="Mua ngay">--%>
                                            <a href="detail?masach=${ab.maSach}" class="sp-option-buy">Mua ngay</a>
                                        </c:if>
                                        <c:if test="${sessionScope.account.maPhanQuyen == 1}">
                                            <a onclick="doDelete('${ab.maSach}')" href="#" class="sp-option-buy">Xóa</a>
                                        </c:if>


                                        <c:if test="${sessionScope.account.maPhanQuyen == 0}">
                                            <a href="detail?masach=${ab.maSach}" class="sp-option-shoppingcart">Thêm giỏ hàng</a>
                                        </c:if>
                                        <c:if test="${sessionScope.account.maPhanQuyen == 1}">
                                            <a href="update?masach=${ab.maSach}" class="sp-option-shoppingcart">Sửa</a>
                                        </c:if>

                                    </c:if>
                                </div>
                            </div>
                        </c:forEach>
                    </form>

                    <div style="clear: both"></div>

                    <div class="paging">
                        <div class="pagination">
                            <c:set var="page" value="${requestScope.page}"></c:set>
                            <c:if test="${requestScope.action == (1)}">
                                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                    <a class="${i==page?"active":""}" href="allbook?page=${i}">${i}</a>
                                </c:forEach>
                            </c:if>

                            <c:if test="${requestScope.action == (2)}">
                                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                    <a class="${i==page?"active":""}" href="tab?page=${i}&matheloai=${matheloai}">${i}</a>
                                </c:forEach>
                            </c:if>

                            <c:if test="${requestScope.action == (3)}">
                                <c:set var="key" value="${requestScope.key}"></c:set>
                                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                    <a class="${i==page?"active":""}" href="search?page=${i}&key=${key}">${i}</a>
                                </c:forEach>
                            </c:if>

                            <%-- 
                            <c:if test="${requestScope.action == (4)}">
                                <c:set var="key" value="${requestScope.key}"></c:set>
                                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                    <a class="${i==page?"active":""}" href="filternxb?page=${i}">${i}</a>
                                </c:forEach>
                            </c:if>
                            --%>        
                        </div>
                    </div>
                </div>
            </div>

            <div style="clear: both;"></div>
            <!--Footer-->
            <div class="row" style="background-color: black; color: white; display: flex;">
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
        <script src="js/mycode.js"></script>
    </body>
</html>
