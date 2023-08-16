<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.Normalizer" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="Entity.CartItem" %>
<%@ page import="Entity.Customer" %>
<%@ page import="DAO.CustomerDAO" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.text.DecimalFormat" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>MultiShop - Online Shop Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="client/img/favicon.ico" rel="icon">

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
        <!--        Jquery-->
        <script src="https://code.jquery.com/jquery-3.6.3.js"
        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
        <!--        CDN Axios-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js"
                integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <!-- ThÆ° viá»n jQuery UI -->
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
        <!--        JS-->
        <script src="client/js/SignUp.js" defer></script>
        <!-- style for pop up check out -->
        <style>
            .popup {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.6);
                display: flex;
                align-items: center;
                justify-content: center;
                z-index: 9999;
            }

            .popup-content {
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                text-align: center;
            }

            h2 {
                margin-top: 0;
            }

            button {
                padding: 10px 20px;
                background-color: #ff5c5c;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            button:hover {
                background-color: #e60000;
            }
        </style>
    </head>

    <body>
        <% 
        int customerID = (int)session.getAttribute("id");    
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.getCustomerById(customerID);
        %>
        <%@ include file="Header.jsp" %>
        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <a class="breadcrumb-item text-dark" href="#">Shop</a>
                        <span class="breadcrumb-item active">Checkout</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Checkout Start -->
        <form id="myFuckingForm" action="<%= request.getContextPath() %>/checkoutController" method="post">
            <div class="container-fluid">
                <div class="row px-xl-5">
                    <div class="col-lg-7">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
                        <div class="bg-light p-30 mb-5">
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label for="firstName">firstName</label>
                                    <input class="form-control" id="firstName" name="firstName" type="text" placeholder="John" value=" <%= customer.getFirstName() %>" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="lastName">lastName</label>
                                    <input class="form-control" id="lastName" name="lastName" type="text" placeholder="Doe" value=" <%= customer.getLastName() %>" readonly="" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="email">E-mail</label>
                                    <input class="form-control" type="text" id="email" name="email" placeholder="example@email.com" value=" <%= customer.getEmail() %>" readonly="" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="phoneNumber">phoneNumber</label>
                                    <input class="form-control" type="text" id="phoneNumber" name="phoneNumber" placeholder="+123 456 789" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="addressDetail">addressDetail</label>
                                    <input class="form-control" type="text"  id="addressDetail" name="addressDetail" placeholder="123 Street" required>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label for="cityId">cityId</label>
                                    <br>
                                    <select class="form-control" id="cityId" name="cityId" value="${cityValue}" required>
                                        <!-- Add more city options as needed -->
                                    </select>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>District</label>
                                    <br>
                                    <select class="form-control" id="districtId" name="districtId" value="${districtValue}" required>
                                        <!-- Add more district options as needed -->
                                    </select>
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Required Date</label>
                                    <input class="form-control" id="datepicker" name="dateRequired" required>
                                </div>
                            </div>
                            <input type="hidden" id="city" name="city">
                            <input type="hidden" id="district" name="district">
                        </div>
                    </div>
                    <div class="col-lg-5">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                        <div class="bg-light p-30 mb-5">
                            <div class="border-bottom">
                                <h6 class="mb-3">Products</h6>
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
                                <div class="d-flex justify-content-between">
                                    <p><%= item.getQuantity() %>   x  <%= item.getProductName() %></p>
                                    <p><%= fUnitPrice %></p>
                                </div>
                                <% 
                                    }
                                } else {
                                %>
                                <div>Cart is empty</div>
                                <% 
                                } 
                                %>
                            </div>
                            <div class="border-bottom pt-3 pb-2">
                                <div class="d-flex justify-content-between mb-3">
                                    <h6>Subtotal</h6>
                                    <h6><%= fTotalPriceOfBill %> VND</h6>
                                </div>
                                <div class="d-flex justify-content-between mb-3">
                                    <h6>Maintenance</h6>
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
                                                totalPriceOfBill = subtracted;
                                            %>
                                            <h5><%=  ret%> VND</h5>
                                        </c:when>
                                        <c:otherwise>
                                            <h5><%= fTotalPriceOfBill %> VND</h5>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="mb-5">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
                            <div class="bg-light p-30">
                                <div class="form-group">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="payment" id="paypal" value="paypal">
                                        <label class="custom-control-label" for="paypal">VNPay</label>
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="payment" id="banktransfer" value="direct">
                                        <label class="custom-control-label" for="banktransfer">Direct Check</label>
                                    </div>
                                </div>
                                <input type="hidden" name="selectedPayment" id="selectedPayment">
                                <button class="btn btn-block btn-primary font-weight-bold py-3" type="button" onclick="submitForm()">Place Order</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Checkout End -->
            <input type="hidden" name="totalPrice" value="<%= totalPriceOfBill.intValue() %>">
        </form>

        <%@ include file="Footer.jsp" %>
        <script>
            function submitForm() {
                var selectedPayment = document.querySelector('input[name="payment"]:checked');
                if (selectedPayment) {
                    document.getElementById("selectedPayment").value = selectedPayment.value;
                    document.getElementById("myFuckingForm").submit();
                } else {
                    alert("Please select a payment option.");
                }
            }
        </script>
    </body>
</html>