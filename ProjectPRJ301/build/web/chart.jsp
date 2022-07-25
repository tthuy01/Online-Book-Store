<%-- 
    Document   : chart
    Created on : Mar 22, 2022, 1:09:54 AM
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

        <!--Chart.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.1/chart.min.js"></script>

        <style>
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
                color: black;
                border-radius: 24px;
                transform: 0.25s;
                cursor: pointer;
            }

            a:hover {
                background-color: rgba(0, 0, 0, 0.8);
                text-decoration: none;
                color: orange;
            }
        </style>
    </head>
    <body>
        <div style="margin-top: 30px; margin-bottom: 30px;">
            <a href="allbook">Trang chủ</a>
            <a href="doanhthu">Quay lại</a>
        </div>
        <hr/>

        <div style="width: 80%; margin: 0 auto;">
            <canvas id="myChart"></canvas>
            <h3 style="text-align: center;">Doanh thu theo tháng</h3>
        </div>
        <hr/>

        <div style="width: 40%; margin: 0 auto;">
            <canvas id="myChart1"></canvas>
            <h3 style="text-align: center;">Tỷ lệ bán theo thể loại</h3>
        </div>
    </body>

    <script>
//        var bienX = ['thu2', 'thu3', 'thu4', 'thu5', 'thu6', 'thu7', 'thu8'];
        var time = [
        <c:forEach items="${requestScope.listthoigian}" var="t">
        '${t}' <c:if test="${t != (requestScope.listthoigian.size()-1)}">,</c:if>
        </c:forEach>
        ];
//        var bienY = [2, 5, 6, 8, 1, 3, 10, 0];
        var sale = [
        <c:forEach items="${requestScope.listdoanhthu}" var="s">
            ${s} <c:if test="${s != (requestScope.listdoanhthu.size()-1)}">,</c:if>
            <c:if test="${s == (requestScope.listdoanhthu.size()-1)}">, 0</c:if>
        </c:forEach>
        ];
        var CHART = document.getElementById('myChart').getContext('2d');
        var lineChart = new Chart(CHART, {
        type: 'line',
                data: {
                labels: time,
                        datasets: [{
                        label: 'Doanh thu theo tháng',
                                backgroundColor: 'orange',
                                borderColor: 'orange',
                                data: sale
                        }]
                }
        })


                <%--var theLoai = [
        <c:forEach items="${requestScope.listtheloai.maTheLoai}" var="t">
                '${t}' <c:if test="${t != (requestScope.listtheloai.size()-1)}">,</c:if>
        </c:forEach>
                ];--%>
                var theLoai = [
                                'Sách luyện thi đại học','Sách giáo khoa','Sách tham khảo',
                                'Sách dành cho thiếu nhi','Truyện ngôn tình','Truyện tranh',
                                'Văn học nước ngoài','Văn học Việt Nam'
                            ];
        var luotBan = [
        <c:forEach items="${requestScope.listluotban}" var="s">
            ${s} <c:if test="${s != (requestScope.listluotban.size()-1)}">,</c:if>
        </c:forEach>
        ];
        var CHART1 = document.getElementById('myChart1').getContext('2d');
        var pieChart = new Chart(CHART1, {
        type: 'pie',
                data: {
                labels: theLoai,
                        datasets: [{
                        label:  'ABC',
                                backgroundColor: [
                                    'rgb(255, 99, 132)',
                                    'rgb(54, 162, 235)',
                                    'orange',
                                    'RGBA( 255, 69, 0, 1 )',
                                    'gray',
                                    'rgba( 148, 0, 211, 1 )',
                                    'rgba( 144, 238, 144, 1 )',
                                    'rgba( 255, 228, 181, 1 )',
                                  ],
                                data: luotBan,
                                hoverOffset: 4
                        }]
                }
        })
    </script>
</html>
