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
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="client/lib/animate/animate.min.css" rel="stylesheet">
        <link href="client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="client/css/style.css" rel="stylesheet">
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
                        <!--<span class="breadcrumb-item active">Shopping Cart</span>-->
                    </nav>
                </div>

            </div>

            <div class="row px-xl-5">
                <div class="col">
                    <div class="bg-light p-30">
                        <div class="nav nav-tabs mb-4">


                            <a class="nav-item nav-link text-dark active" data-toggle="tab" href="#tab-pane-1">All</a>


                            <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-2">To pay</a>


                            <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-3">To ship</a>

                            <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-4">To receive </a>

                            <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-5">Completed </a>

                            <!--<a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-6">Cancelled </a>-->

                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="tab-pane-1">


                                <!--{o.getStatus()}-->
                                <c:forEach items="${olist}" var="o">
                                    <div class="row border-bottom pb-2" >
                                        <div class="col-md-9">
                                        </div>
                                        <div class="col-md-3">
                                            ${o.getStatus()}
                                        </div>
                                    </div>
                                    <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                        <div class="col-md-2"><img src="client/${o.getProduct().imageURL}" width="200" height="200" alt=""/></div>                               
                                        <div class="col-md-5">
                                            <span>
                                                ${o.getProduct().getProductName()}
                                            </span>
                                            <p>
                                                x${o.getQuantity()}
                                            </p>
                                        </div>

                                        <div class="col-md-2">${o.getProduct().getUnitPriceFixed()}</div>
                                        <div class="col-md-2">
                                            <br>
                                            <!--<form method ='post' action='userPurchase/order/${o.getOrderID()}'>-->
                                            <a href="order/${o.getOrderID()}" class="btn-primary btn">
                                                Delivery Status 
                                            </a>
                                            <br>
                                            <br>
                                            <!--<button type='submit' class="btn-primary">Delivery Status</button>-->
                                            <!--</form>-->
                                            <a href="Detail/${o.getProduct().getProductcode()}" class="btn-primary btn">
                                                Rate Product
                                            </a>
                                            <br>
                                            <br>
                                            <!--                                            <a href="#" class="btn-primary btn">
                                                                                            Cancel
                                                                                        </a>-->
                                        </div>

                                    </div>
                                </c:forEach>

                            </div>
                            <div class="tab-pane fade" id="tab-pane-2">
                                <div class="row">
                                    <div class="col-md-2">
                                        ID
                                    </div>
                                    <div class="col-md-2">Price</div>
                                    <div class="col-md-2">Address</div>
                                </div>
                                <c:forEach items="${l1}" var="o1">

                                    <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                        <!--<div class="col-md-2"><img src="client/${o.getProduct().imageURL}" width="200" height="200" alt=""/></div>-->                               
                                        <div class="col-md-2">
                                            ${o1.getOrderID()}
                                        </div>
                                        <div class="col-md-2">${o1.getTotalPrice()}</div>
                                        <div class="col-md-2">${o1.getShipAddress()}</div>
                                        <!--                                        <div class="col-md-2">
                                                                                    <br>
                                                                                    <form method ='post' action='userPurchase/order/${o.getOrderID()}'>
                                                                                        <a href="order/${o.getOrderID()}" class="btn btn-primary">
                                                                                            Delivery Status 
                                                                                        </a>
                                                                                            <button type='submit' class="btn-primary">Delivery Status</button>
                                                                                    </form>
                                                                                    <a href="#" class="btn-primary">
                                                                                        Rate Product
                                                                                    </a>
                                                                                </div>-->

                                    </div>
                                </c:forEach>
                            </div>
                            <div class="tab-pane fade" id="tab-pane-3">
                                <div class="row">
                                    <div class="col-md-2">
                                        ID
                                    </div>
                                    <div class="col-md-2">Price</div>
                                    <div class="col-md-2">Address</div>
                                </div>
                                <c:forEach items="${l2}" var="o2">

                                    <c:choose>
                                        <c:when test="${o2.getStatus() eq 'Shipping'}">
                                            <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">

                                                <div class="col-md-2">
                                                    ${o2.getOrderID()}
                                                </div>
                                                <div class="col-md-2">${o2.getTotalPrice()}</div>
                                                <div class="col-md-2">${o2.getShipAddress()}</div>
                                            </div>
                                        </c:when>
                                    </c:choose>

                                </c:forEach>
                            </div>
                            <div class="tab-pane fade" id="tab-pane-4">
                                <div class="row">
                                    <div class="col-md-2">
                                        ID
                                    </div>
                                    <div class="col-md-2">Price</div>
                                    <div class="col-md-2">Address</div>
                                </div>
                                <c:forEach items="${l2}" var="o2">

                                    <c:choose>
                                        <c:when test="${o2.getStatus() eq 'Shipped'}">
                                            <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">                              
                                                <div class="col-md-2">
                                                    ${o2.getOrderID()}
                                                </div>
                                                <div class="col-md-2">${o2.getTotalPrice()}</div>
                                                <div class="col-md-2">${o2.getShipAddress()}</div>
                                                <div class="col-md-2">
                                                    <a href="submitShipping?id=${o2.getOrderID()}" class="btn btn-primary">Submit</a>
                                                </div>
                                            </div>
                                        </c:when>
                                    </c:choose>

                                </c:forEach>
                            </div>


                            <div class="tab-pane fade" id="tab-pane-5">
                                <div class="row">
                                    <div class="col-md-2">
                                        ID
                                    </div>
                                    <div class="col-md-2">Price</div>
                                    <div class="col-md-2">Address</div>
                                </div>
                                <c:forEach items="${l3}" var="o3">


                                    <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">                              
                                        <div class="col-md-2">
                                            ${o3.getOrderID()}
                                        </div>
                                        <div class="col-md-2">${o3.getTotalPrice()}</div>
                                        <div class="col-md-2">${o3.getShipAddress()}</div>
<!--                                        <div class="col-md-2">
                                            <a href="submitShipping?id=${o2.getOrderID()}" class="btn btn-primary">Submit</a>
                                        </div>-->
                                    </div>

                                </c:forEach>
                            </div>
                            <!--                            <div class="tab-pane fade" id="tab-pane-6">
                            
                                                        </div>-->

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
        <script src="client/lib/easing/easing.min.js"></script>
        <script src="client/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="client/mail/jqBootstrapValidation.min.js"></script>
        <script src="client/mail/contact.js"></script>

        <script src="client/js/main.js"></script>
        <!-- Template Javascript -->

        <script>
            function submitForm(formId) {
                var form = document.getElementById("addToCartForm_" + formId);
                form.submit();
            }
        </script>
    </body>

</html>