<%-- 
    Document   : addbook
    Created on : Mar 6, 2022, 1:08:35 AM
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
        <c:if test="${requestScope.alltheloai != null}">
            <form class="add-author-form" action="addbook" method="post">
                <h1>Thêm sách mới</h1>
                <h3 style="color: red; text-align: center">${requestScope.error}</h3>
                <input type="text" name="name" placeholder="Tên sách">
                <input type="text" name="image" placeholder="Ảnh">
                <input type="text" name="date" placeholder="Ngày xuất bản">
                <input type="text" name="price" placeholder="Giá">
                <input type="text" name="inventory" placeholder="Số lượng tồn kho">
                <div class="se">
                    Thể loại:
                    <select name="matheloai">
                        <c:forEach items="${requestScope.alltheloai}" var="tl">
                            <option value="${tl.maTheLoai}">${tl.theLoai}</option>
                        </c:forEach>
                    </select>
                </div> <br/>
                <div class="se">
                    Tác giả:
                    <select name="matacgia">
                        <c:forEach items="${requestScope.alltacgia}" var="tg">
                            <option value="${tg.maTacGia}">${tg.tenTacGia}</option>
                        </c:forEach>
                    </select>
                </div> <br/>
                <div class="se">
                    NXB:
                    <select name="manxb">
                        <c:forEach items="${requestScope.allnxb}" var="n">
                            <option value="${n.maNXB}">${n.tenNXB}</option>
                        </c:forEach>
                    </select>
                </div>
                <input type="submit" value="Thêm mới">
            </form>
        </c:if>
        <c:if test="${requestScope.alltheloai == null}">
            <form class="add-author-form" action="addbook">
                <h1>Thêm sách mới</h1>
                <h3 style="color: red; text-align: center">${requestScope.error}</h3>
                <input type="submit" value="Thêm sách mới">
            </form>
        </c:if>
    </body>
</html>
