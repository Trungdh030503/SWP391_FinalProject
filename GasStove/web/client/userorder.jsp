<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.Normalizer" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="Entity.CartItem" %>
<%@ page import="java.math.BigDecimal" %>

<%@ page import="java.util.*" %>

<%@ page import="java.text.DecimalFormat" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>MultiShop - Online Shop Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="/GasStove/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="/GasStove/client/lib/animate/animate.min.css" rel="stylesheet">
        <link href="/GasStove/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="/GasStove/client/css/style.css" rel="stylesheet">
    </head>

    <body>

        <%@ include file="Header.jsp" %>

        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-6">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="/GasStove/indexController">Home</a>
                        <a class="breadcrumb-item text-dark" href="/GasStove/userPurchase">Purchase</a>
                        <span class="breadcrumb-item active">Order</span>
                    </nav>
                </div>

            </div>

            <div class="row px-xl-5">
                <div class="col mb-30">
                    <div class="bg-light p-30">
                        <div class='row checking'>
                            <div class='col-md-1'></div>
                            <div class='col-md-2'>
                                <img src="/GasStove/unchecked.png" width='50px'>
                                <span>Order Placed</span>
                            </div>
                            <div class='col-md-2'>
                                <img src="/GasStove/unchecked.png" width='50px'>
                                <span>Order Shipped Out</span>
                            </div>
                            <div class='col-md-2'>
                                <img src="/GasStove/unchecked.png" width='50px'>
                                <span>Order Delivered</span>
                            </div>
                            <div class='col-md-2'>
                                <img src="/GasStove/unchecked.png" width='50px'>
                                <span>Order Completed</span>
                            </div>
                            <div class='col-md-2'>
                                <img src="/GasStove/unchecked.png" width='50px'>
                                <span>Order Canceled</span>
                            </div>
                            <div class='col-md-1'></div>
                        </div>
                    </div>
                </div>
            </div>


            <script>
                window.onload = function () {
                    var status = "${o.getStatus()}"; // Assuming ${o.getStatus()} returns the status string

                    // Get the image elements
                    var images = document.querySelectorAll('.row.checking img');

                    // Set the appropriate image source based on the status
                    if (status === 'Waiting') {
                        images[0].src = "/GasStove/checked.png";
                    } else
                    if (status === 'Shipping') {
                        images[0].src = "/GasStove/checked.png";
                        images[1].src = "/GasStove/checked.png";
                    } else
                    if (status === 'Shipped') {
                        images[0].src = "/GasStove/checked.png";
                        images[1].src = "/GasStove/checked.png";
                        images[2].src = "/GasStove/checked.png";
                    } else
                    if (status === 'Completed') {
                        images[0].src = "/GasStove/checked.png";
                        images[1].src = "/GasStove/checked.png";
                        images[2].src = "/GasStove/checked.png";
                        images[3].src = "/GasStove/checked.png";
                    } else
                    if (status === 'Canceled') {
                        images[4].src = "/GasStove/checked.png";
                    }
                    ;
                }
            </script>

            <div class="row px-xl-5">
                <div class="col mb-30">
                    <div class="bg-light p-30">
                        <div class='col-md-4 border-right'>
                            <h3>Delivery Address</h3>
                            <p>
                                ${o.getShipAddress()},
                                ${o.getShipCity()}
                            </p>
                        </div>
                        <div class='col-md-8 border-left'>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Cart Start -->


        <!-- Cart End -->

        <%@ include file="Footer.jsp" %>


        <script>
            function submitForm(formId) {
                var form = document.getElementById("addToCartForm_" + formId);
                form.submit();
            }
        </script>
        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="/GasStove/client/lib/easing/easing.min.js"></script>
        <script src="/GasStove/client/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="/GasStove/client/mail/jqBootstrapValidation.min.js"></script>
        <script src="/GasStove/client/mail/contact.js"></script>

        <script src="/GasStove/client/js/main.js"></script>
        <!-- Template Javascript -->

        <script>
            function submitForm(formId) {
                var form = document.getElementById("addToCartForm_" + formId);
                form.submit();
            }
        </script>
    </body>

</html>