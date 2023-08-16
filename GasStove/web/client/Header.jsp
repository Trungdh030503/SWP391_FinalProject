<%-- 
    Document   : Header
    Created on : May 15, 2023, 10:14:39 AM
    Author     : DUC ANH
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Entity.CartItem" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="/GasStove/client/img/favicon.ico" rel="icon">

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
        <%
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            int itemQuantity = 0;
            if (cart != null && !cart.isEmpty()) {
                itemQuantity = cart.size();
            }    
        %>
        
        <div id="fb-root"></div>
        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v17.0" nonce="eeCMw7j0"></script>
        
        <div class="container-fluid">
            <div class="row bg-secondary py-1 px-xl-5">
                <div class="col-lg-6 d-none d-lg-block">
                    <div class="d-inline-flex align-items-center h-100">
                        <a class="text-body mr-3" href="">About</a>
                        <a class="text-body mr-3" href="">Contact</a>
                        <a class="text-body mr-3" href="">Help</a>
                        <a class="text-body mr-3" href="">FAQs</a>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown"></button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <c:if test="${sessionScope.id == null}">
                                    <a href="/GasStove/loginController" class="dropdown-item">
                                        Login
                                    </a> 
                                </c:if>
                                <c:if test="${sessionScope.id != null}">
                                    <a href="/GasStove/changePassController" class="dropdown-item">
                                        Change Password
                                    </a> 
                                </c:if>

                                <c:if test="${sessionScope.id != null}">
                                    <a href="/GasStove/logoutController" class="dropdown-item">
                                        Log out
                                    </a> 
                                </c:if>
                                <c:if test="${sessionScope.id != null}">
                                    <a href="/GasStove/profileController" class="dropdown-item">
                                        My Profile
                                    </a> 
                                </c:if>
                                <c:if test="${sessionScope.id != null}">
                                    <a href="/GasStove/userPurchase" class="dropdown-item">
                                        My Purchase
                                    </a> 
                                </c:if>
                                
                                <%--<c:if test="${sessionScope.id != null}">--%>
                                    <!--<a href="forgotPassword.jsp" class="dropdown-item">-->
                                        <!--quen mat khau-->
                                    <!--</a>--> 
                                <%--</c:if>--%>

                            </div>
                        </div>
<!--                        <c:if test="${sessionScope.id == null}">
                            <a href="/GasStove/loginController" class="">
                                Login
                            </a> 
                        </c:if>-->
                        <div class="btn-group mx-2">
                            <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">USD</button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item" type="button">EUR</button>
                                <button class="dropdown-item" type="button">GBP</button>
                                <button class="dropdown-item" type="button">CAD</button>
                            </div>
                        </div>
                        <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">EN</button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <button class="dropdown-item" type="button">FR</button>
                                <button class="dropdown-item" type="button">AR</button>
                                <button class="dropdown-item" type="button">RU</button>
                            </div>
                        </div>
                    </div>
                    <div class="d-inline-flex align-items-center d-block d-lg-none">
                        <a href="" class="btn px-0 ml-2">
                            <i class="fas fa-heart text-dark"></i>
                            <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                        </a>
                        <a href="" class="btn px-0 ml-2">
                            <i class="fas fa-shopping-cart text-dark"></i>
                            <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
                <div class="col-lg-4">
                    <a href="" class="text-decoration-none">
                        <span class="h1 text-uppercase text-primary bg-dark px-2">Stove</span>
                        <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Shop</span>
                    </a>
                </div>
                <div class="col-lg-4 col-6 text-left">
<!--                    <form action="searchProduct" method = "post">
                        <div class="search-container input-group">
                            <div class="suggestions-container">
                                <input type="text" class="search-box form-control" name="Search" placeholder="Search" onkeyup="showSuggestions(this.value)">
                                <ul class="suggestions-list"></ul>
                            </div>
                        </div>
                    </form>-->
                    <form action="searchProduct" method = "post">
                        <div class="input-group">
                            <input type="text" class="form-control" name="Search" placeholder="Search for products" onkeyup="showSuggestions(this.value)">
                            <ul class="suggestions-list"></ul>
                            <div class="input-group-append">
                                <button class="input-group-text bg-transparent text-primary" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-4 col-6 text-right">
                    <p class="m-0">Customer Service</p>
                    <h5 class="m-0">+012 345 6789</h5>
                </div>
            </div>
        </div>
        <!-- Topbar End -->



    <!-- Navbar Start -->
 <!-- Navbar Start -->
        <div class="container-fluid bg-dark mb-30">
            <div class="row px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                        <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Categories</h6>
                        <i class="fa fa-angle-down text-dark"></i>
                    </a>
                    <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                        <div class="navbar-nav w-100">
                            <%--<c:forEach items="${clist}" var="cs">--%>
 
                            <c:forEach items="${clist}" var="cs">
                                <c:set var="category" value="${cs.get(0).getCategoryID()}" />
                                <div class="nav-item dropdown dropright">
                                    <a href="/GasStove/productController?category=${category}&subcategory=&shownumber=10&page=${currentPage}&order=${order}" class="nav-link dropdown-toggle">${cs.get(0).getCategoryName()} <i class="fa fa-angle-right float-right mt-1"></i></a>
                                    <div class="dropdown-menu position-absolute rounded-0 border-0 m-0">
                                        <c:forEach items="${cs}" var="c">
                                            <a href="/GasStove/productController?category=${c.getCategoryID()}&subcategory=${c.getSubCategoryName()}&shownumber=10&page=${currentPage}&order=${order}" class="dropdown-item">${c.getSubCategoryName()}</a>
                                        </c:forEach>
                                    </div>
                                </div>
                            </c:forEach>
                            
                            <%--</c:forEach>--%>
                            
<!--                            <a href="" class="nav-item nav-link">Shirts</a>
                            <a href="" class="nav-item nav-link">Jeans</a>
                            <a href="" class="nav-item nav-link">Swimwear</a>
                            <a href="" class="nav-item nav-link">Sleepwear</a>
                            <a href="" class="nav-item nav-link">Sportswear</a>
                            <a href="" class="nav-item nav-link">Jumpsuits</a>
                            <a href="" class="nav-item nav-link">Blazers</a>
                            <a href="" class="nav-item nav-link">Jackets</a>
                            <a href="" class="nav-item nav-link">Shoes</a>-->
                        </div>
                    </nav>
                </div>
                <div class="col-lg-9">
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                        <a href="" class="text-decoration-none d-block d-lg-none">
                            <span class="h1 text-uppercase text-dark bg-light px-2">Multi</span>
                            <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
                        </a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="/GasStove/indexController" class="nav-item nav-link">Home</a>
                                <a href="/GasStove/productController" class="nav-item nav-link">Shop</a>
                                <a href="#" class="nav-item nav-link">Shop Detail</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages <i class="fa fa-angle-down mt-1"></i></a>
                                    <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                        <a href="/GasStove/cartController" class="dropdown-item">Shopping Cart</a>
                                        <a href="checkout.html" class="dropdown-item">Checkout</a>
                                    </div>
                                </div>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Warranty Service <i class="fa fa-angle-down mt-1"></i></a>
                                    <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                        <a href="/GasStove/warrantyRequest" class="dropdown-item">Warranty Request</a>
                                        <a href="warrantyTracking" class="dropdown-item">Warranty Tracking</a>
                                    </div>
                                </div>
                            </div>
                            <div class="navbar-nav ml-auto py-0 d-none d-lg-block">
                                <a href="" class="btn px-0">
                                    <i class="fas fa-heart text-primary"></i>
                                    <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">0</span>
                                </a>
                                <a href="/GasStove/cartController" class="btn px-0 ml-3">
                                    <i class="fas fa-shopping-cart text-primary"></i>
                                    <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;"><%=itemQuantity%></span>
                                </a>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Navbar End -->
    <!-- Navbar End -->

        <script>
                // Get the active page from the session
                var activePage = '<%= session.getAttribute("activepage") %>';
                // Select the navbar element
                var navbar = document.querySelector('.navbar-nav.mr-auto.py-0');
                // Select all the <a> tags inside the navbar
                var navLinks = navbar.querySelectorAll('.navbar-nav .nav-link');

                // Loop through each <a> tag and check if its href matches the active page
                for (var i = 0; i < navLinks.length; i++) {
                    var content = navLinks[i].textContent.trim();

                    if ((activePage === 'productlist' && content === 'Shop') ||
                        (activePage === 'product' && content === 'Shop Detail') ||
                        (activePage === 'Cart' && content === 'Pages') ||
                        (activePage === 'home' && content === 'Home') || 
                        (activePage === 'warranty' && content === 'Warranty Service')) {
                        navLinks[i].classList.add('active');
                    }
                }
           
    </script>

</html>