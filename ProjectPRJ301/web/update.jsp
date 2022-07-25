<%-- 
    Document   : update
    Created on : Mar 6, 2022, 4:04:25 PM
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
                top: 50%;
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

            .se {
                color: white;
                margin-left: 92px;
            }
        </style>
    </head>
    <body>
        <div style="margin-top: 30px">
            <a href="allbook">Trang chủ</a>
            <a href="addmenu.jsp">Quay lại</a>
        </div>

        <form class="add-author-form" action="update" method="post">
            <c:set var="b" value="${requestScope.book}"></c:set>
            <h1>Sửa thông tin sách</h1>
            <h3 style="color: red; text-align: center">${requestScope.error}</h3>
            <input type="text" name="id" placeholder="Mã sách" value="${b.maSach}" readonly>
            <input type="text" name="name" placeholder="Tên sách" value="${b.tenSach}">
            <input type="text" name="image" placeholder="Ảnh" value="${b.anh}">
            <input type="text" name="date" placeholder="Ngày xuất bản" value="${b.ngayXB}">
            <input type="text" name="price" placeholder="Giá" value="${b.gia}">
            <input type="text" name="inventory" placeholder="Số lượng tồn kho" value="${b.soLuongTonKho}">
            <div class="se">
                Thể loại:
                <select name="matheloai">
                    <c:forEach items="${requestScope.alltheloai}" var="tl">
                        <option value="${tl.maTheLoai}" <c:if test="${tl.maTheLoai==b.maTheLoai}">selected</c:if>>${tl.theLoai}</option>
                    </c:forEach>
                </select>
            </div> <br/>
            <div class="se">
                Tác giả:
                <select name="matacgia">
                    <c:forEach items="${requestScope.alltacgia}" var="tg">
                        <option value="${tg.maTacGia}" <c:if test="${tg.maTacGia==b.maTacGia}">selected</c:if>>${tg.tenTacGia}</option>
                    </c:forEach>
                </select>
            </div> <br/>
            <div class="se">
                NXB:
                <select name="manxb">
                    <c:forEach items="${requestScope.allnxb}" var="n">
                        <option value="${n.maNXB}" <c:if test="${n.maNXB==b.maNXB}">selected</c:if>>${n.tenNXB}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Cập nhật">
        </form>
    </body>
</html>
