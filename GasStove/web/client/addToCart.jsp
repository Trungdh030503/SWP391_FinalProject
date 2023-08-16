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
        <style>
            .popup {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5);
                z-index: 9999;
            }

            .popup-content {
                background-color: #fff;
                width: 400px;
                height: 300px;
                margin: 100px auto;
                text-align: center;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            }

            .coupon-item {
                margin-bottom: 10px;
            }

            .coupon-item label {
                display: inline-block;
                font-weight: bold;
                cursor: pointer;
            }

            .coupon-item input[type="radio"] {
                margin-left: 5px;
            }

            .popup-buttons {
                margin-top: 20px;
            }

        </style>
    </head>

    <body>

        <%@ include file="Header.jsp" %>


        <div id="popup" class="popup">
            <div class="popup-content">
                <h2>Select Coupon</h2>
                <div class="couponlist">
                    <c:forEach var="coupon" items="${coupons}">
                        <div class="coupon-item">
                            <label>
                        ${coupon.getProduct().getProductName()}    -        ${coupon.getCouponName()} (${coupon.getDiscount()}%)
                                <input type="checkbox" name="selectedCoupon" value="${coupon.getCouponID()}">
                                <!--<input type="checkbox" name="selectedCoupon" value="${coupon.getCouponID()}" data-discount="${coupon.getDiscount()}" class="discount-checkbox">-->


                            </label>
                        </div>
                    </c:forEach>
                </div>
                <div class="popup-buttons">
                    <button id="submitBtn" onclick="applyDiscount()">Submit</button>
                    <button id="closeBtn">Cancel</button>
                </div>
            </div>
        </div>




        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var popup = document.getElementById("popup");
                var closeBtn = document.getElementById("closeBtn");
                //var addToCartBtn = document.querySelector(".checkcart");
                //var showPopup = false; // Bi?n ?? ki?m tra xem pop-up c  n n hi?n th? hay kh ng

                closeBtn.addEventListener("click", function () {
                    popup.style.display = "none";
                });



            });
            function loadpopup() {
                var popup = document.getElementById("popup");
                popup.style.display = "flex";
            }
        </script>




        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <a class="breadcrumb-item text-dark" href="#">Shop</a>
                        <span class="breadcrumb-item active">Shopping Cart</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Cart Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-lg-8 table-responsive mb-5">
                    <table class="table table-light table-borderless table-hover text-center mb-0">
                        <thead class="thead-dark">
                            <tr>
                                <th>Products</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                        </thead>

                        <tbody class="align-middle">


                            <% 

                            BigDecimal totalPriceOfBill = BigDecimal.ZERO;
                            DecimalFormat formatter = new DecimalFormat("###,###,###,###,###");
                            String fTotalPriceOfBill = "";
                            if (cart != null && !cart.isEmpty()) {
                                for (CartItem item : cart) {
                                    totalPriceOfBill = totalPriceOfBill.add(item.getTotalPrice());
                                    BigDecimal price = item.getUnitPrice();
                                    fTotalPriceOfBill = formatter.format(totalPriceOfBill);
                                    String fTotalPriceOfOneItem = formatter.format(item.getTotalPrice());
                                    String fUnitPrice = formatter.format(price);
                            %>
                            <tr class="cart-item-row">
                                <td class="align-middle"><%= item.getProductName() %></td>
                                <td class="align-middle"><%= fUnitPrice %></td>
                                <td class="align-middle">
                                    <div class="input-group quantity mx-auto" style="width: 100px;">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-primary btn-minus" >
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                        <input id="quantityInput" type="text" class="form-control form-control-sm bg-secondary border-0 text-center" value="<%= item.getQuantity() %>">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-primary btn-plus">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                </td>
                                <td class="align-middle" id="totalPrice"><%= fTotalPriceOfOneItem %></td>
                                <!--<td class="align-middle" id="totalPrice" data-original-price="<%= fTotalPriceOfOneItem %>"><%= fTotalPriceOfOneItem %></td>-->

                                <td class="align-middle">
                                    <form action="<%= request.getContextPath() %>/addToCartController" method="post" id="addToCartForm_<%= item.getProductID() %>">
                                        <%= item.getProductID() %>
                                        <input type="hidden" name="page" value="cart">
                                        <input type="hidden" name="productID" value="<%= item.getProductID() %>">
                                        <a class="btn btn-sm btn-danger" onclick="submitForm('<%= item.getProductID() %>')"><i class="fa fa-times"></i></a>
                                    </form>
                                </td>      
                            </tr>
                            <% 
                                }
                                
                                
                                
                            } else {
                            %>
                            <tr>
                                <td colspan="3">Cart is empty</td>
                            </tr>
                            <% } 
                            %> 

                        </tbody>
                    </table>
                </div>
                <div class="col-lg-4">
                    <!--<form class="mb-30" action="cartController">-->
                    <div class="input-group">
                        <!--<input type="text" class="form-control border-0 p-4" placeholder="Coupon Code">-->
                        <div class="input-group-append">
                            <button class="btn btn-primary" onclick="loadpopup()">Apply Coupon</button>
                        </div>
                    </div>
                    <!--</form>-->
                    <!--                    <form class="mb-30" action="cartController" method="post">
                                            <div class="input-group">
                                                <div class="input-group-append">
                                                    <button class="btn btn-primary">Accept Maintenance Sale</button>
                                                </div>
                                            </div>
                                        </form>-->
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Cart Summary</span></h5>
                    <div class="bg-light p-30 mb-5">
                        <div class="border-bottom pb-2">
                            <div class="d-flex justify-content-between mb-3">
                                <h6>Subtotal</h6>
                                <h6><%= fTotalPriceOfBill %> VND</h6>
                            </div>
                            <div class="d-flex justify-content-between mb-3">
                                <h6>MaintenanceSale</h6>
                                <c:choose>
                                    <c:when test="${subtract != null}">
                                        <h6>${subtract}VND</h6>
                                    </c:when>
                                    <c:otherwise>
                                        <h6>0 VND</h6>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h6 class="font-weight-medium">Shipping</h6>
                                <h6 class="font-weight-medium">0 VND</h6>
                            </div>
                        </div>
                        <div class="pt-2">
                            <div class="d-flex justify-content-between mt-2">
                                <h5>Total</h5>
                                <c:choose>
                                    <c:when test="${subtract != null}">
                                        <%BigDecimal subtract = (BigDecimal)request.getAttribute("subtract");
                                            BigDecimal subtracted = totalPriceOfBill.subtract(subtract);
                                            String ret = formatter.format(subtracted);
                                        %>
                                        <h5><%=  ret%> VND</h5>
                                    </c:when>
                                    <c:otherwise>
                                        <h5><%= fTotalPriceOfBill %> VND</h5>
                                    </c:otherwise>
                                </c:choose>

                            </div>

                            <!--<form action="<%= request.getContextPath() %>/checkoutController" method="post">-->
                            <!-- C?c tr??ng th?ng tin c?n ?i?n -->

                            <form action="<%= request.getContextPath() %>/checkoutController" method="get">
                                <!-- C?c tr??ng th?ng tin c?n ?i?n -->
                                <c:if test="${subtract != null}">
                                    <input type="hidden" name="subtract" value="${subtract}">
                                </c:if>
                                <button class="btn btn-block btn-primary font-weight-bold my-3 py-3" type="submit">Proceed To Checkout</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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