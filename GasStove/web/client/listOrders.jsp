<%-- 
    Document   : listWarranty
    Created on : Jun 22, 2023, 12:29:38 AM
    Author     : Lenovo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

<!--        <base href="${pageContext.request.contextPath}/">-->

        <meta charset="utf-8">
        <title>MultiShop - Online Shop Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <!--href="../SWP_1/assets/css/styles.min.css"-->
        <link href="client/css/style.css" rel="stylesheet">
        <link href="client/lib/animate/animate.min.css" rel="stylesheet">
        <link href="client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="client/css/style.css" rel="stylesheet">
        <!-- Libraries Stylesheet -->
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <link href="css/newcss1.css" rel="stylesheet" type="text/css"/>
        <link href="css/newcss2.css" rel="stylesheet" type="text/css"/>

    </head>
    <script>
        function adjustFooter() {
            var body = document.body;
            var html = document.documentElement;
            var footer = document.querySelector('.footer-area');
            var height = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight);
            if (height > window.innerHeight) {
                footer.style.position = 'static';
            } else {
                footer.style.position = 'absolute';
                footer.style.bottom = '0';
                footer.style.left = '0';
                footer.style.width = '100%';
            }
        }

        window.addEventListener('load', adjustFooter);
        window.addEventListener('resize', adjustFooter);
    </script>
    <body>
        <%@ include file="Header.jsp" %>
        <h1> 
        
        
        </h1>
        <div class="table-responsive">
        <table class="table text-nowrap mb-0 align-middle">
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Total Price</th>
                <th>Required Date</th>   
                <th>Shipped Date</th>
                <th>Status</th>
                <th>Warranty</th>
                
               
            </tr>
            <c:forEach var="order" items="${orders}">
                <tr>
                    <td>${order.getOrderID()}</td>
                    <td>${order.getOrderDate()}</td>
                    <td>${order.getTotalPrice()}</td>
                    <td>${order.getRequiredDate()}</td>
                    <td>${order.getShippedDate()}</td>
                    <td>${order.getStatus()}</td>
                    <td>
                        <form action="warrantyRequest" method="post">
                            <input type="hidden" name="orderID" value="${order.getOrderID()}">
                            <button type="submit">Request Warranty</button>
                        </form>
                    </td>
                  
                </tr>
            </c:forEach>
        </table>
            </div>     
        <style>
            /* CSS cho bảng */
            table {
                border-collapse: collapse;
                width: 100%;
                border: 1px solid #ddd;
                font-size: 14px;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            th {
                background-color: #eee;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
        <%@include file="Footer.jsp" %>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>
