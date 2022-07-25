<%-- 
    Document   : mycart
    Created on : Mar 14, 2022, 12:51:06 AM
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
            h1 {
                text-align: center;
            }

            table {
                border-collapse: collapse;
                margin: 0 auto;
            }

            a {
                text-decoration: none;
                color: black;
                font-size: 20px;
                border: 1px solid black;
                border-radius: 24px;
                padding: 2px 5px;
                font-weight: bold;
            }
            
            a:link {
                text-decoration: none;
            }
            
            a:hover {
                text-decoration: none;
                color: white;
                background-color: orange;
            }

            th, td {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Shopping cart online</h1>
        <table border="1px" width="80%">
            <tr>
                <th>STT</th>
                <th>Tên sách</th>
                <th>Số lượng</th>
                <th>Giá</th>
                <th>Tổng tiền</th>
                <th>Xóa khỏi giỏ hàng</th>
            </tr>
            <c:set var="o" value="${requestScope.cart}"></c:set>
            <c:set var="stt" value="0"></c:set>
            <c:forEach items="${o.items}" var="i">
                <c:set var="stt" value="${stt+1}"></c:set>
                    <tr>
                        <td>${stt}</td>
                    <td>${i.getSach().getTenSach()}</td>
                    <td style="text-align: center;">
                        <button><a href="process?soluong=-1&masach=${i.getSach().getMaSach()}">-</a></button>
                        ${i.getSoLuong()}
                        <button><a href="process?soluong=1&masach=${i.getSach().getMaSach()}">+</a></button>
                    </td>
                    <td class="tr">${i.getGia()}VND</td>
                    <td class="tr">${i.getGia() * i.getSoLuong()}VND</td>
                    <td style="text-align: center;">
                        <!--<form action="process" method="post">-->
                            <input type="hidden" name="masach" value="i.sach.maSach">
                            <!--<input type="submit" value="Xóa">-->
                            <a href="process?soluong=0&masach=${i.getSach().getMaSach()}"><i class="glyphicon glyphicon-trash"></i>Xóa</a>
                        <!--</form>-->
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3 style="margin-left: 10%;">Tổng tiền: ${o.totalMoney}VND</h3>
        <hr/>
        <form action="checkout" style="margin-left: 10%;">
            <input type="submit" value="Mua ngay">
        </form>
        <hr/>
        <a href="allbook" style="margin-left: 10%;">Trang chủ</a>

        <!--Thư viên javascript của Bootstrap-->
        <script src="js/Jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    </body>
</html>
