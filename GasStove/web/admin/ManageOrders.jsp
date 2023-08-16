<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css"/>
        <link rel="stylesheet" href="cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"/>


    </head>

    <body>
        <!--  Body Wrapper -->
        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
             data-sidebar-position="fixed" data-header-position="fixed">

            <%@ include file="sidebar.jsp" %>

            <!--  Main wrapper -->
            <div class="body-wrapper">
                <!--  Header Start -->
                <header class="app-header">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <ul class="navbar-nav">
                            <li class="nav-item d-block d-xl-none">
                                <a class="nav-link sidebartoggler nav-icon-hover" id="headerCollapse" href="javascript:void(0)">
                                    <i class="ti ti-menu-2"></i>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link nav-icon-hover" href="javascript:void(0)">
                                    <i class="ti ti-bell-ringing"></i>
                                    <div class="notification bg-primary rounded-circle"></div>
                                </a>
                            </li>
                        </ul>
                        <div class="navbar-collapse justify-content-end px-0" id="navbarNav">
                            <ul class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
                                <a href="https://adminmart.com/product/modernize-free-bootstrap-admin-dashboard/" target="_blank" class="btn btn-primary">Download Free</a>
                                <li class="nav-item dropdown">
                                    <a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown"
                                       aria-expanded="false">
                                        <img src="/GasStove/admin/images/profile/user-1.jpg" alt="" width="35" height="35" class="rounded-circle">
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up" aria-labelledby="drop2">
                                        <div class="message-body">
                                            <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                                                <i class="ti ti-user fs-6"></i>
                                                <p class="mb-0 fs-3">My Profile</p>
                                            </a>
                                            <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                                                <i class="ti ti-mail fs-6"></i>
                                                <p class="mb-0 fs-3">My Account</p>
                                            </a>
                                            <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                                                <i class="ti ti-list-check fs-6"></i>
                                                <p class="mb-0 fs-3">My Task</p>
                                            </a>
                                            <a href="logoutController" class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </header>
                <!--  Header End -->
                <div class="container-fluid">
                    <div class="card w-100 h-100 position-relative overflow-hidden">
                        <div class="card-body">
                            <div class="card-body p-4">
                                <div class="card-body">
                                    <div class="mb-2">
                                        <h5 class="mb-0">Orders</h5>
                                    </div>
                                    <p class="mb-3 card-subtitle">
                                        <!--                                        If you need responsive nav variations, consider using a
                                                                                series of flexbox utilities.-->
                                    </p>
                                    <!-- Nav tabs -->
                                    <ul class="nav nav-pills flex-column flex-sm-row mt-4" role="tablist">
                                        <li class="nav-item flex-sm-fill text-sm-center" role="presentation">
                                            <a class="nav-link active" data-bs-toggle="tab" href="#navpill-11" role="tab" aria-selected="true">
                                                <span>Waiting</span>
                                            </a>
                                        </li>
                                        <li class="nav-item flex-sm-fill text-sm-center" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#navpill-22" role="tab" aria-selected="false" tabindex="-1">
                                                <span>Shipping</span>
                                            </a>
                                        </li>
                                        <li class="nav-item flex-sm-fill text-sm-center" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#navpill-33" role="tab" aria-selected="false" tabindex="-1">
                                                <span>Completed</span>
                                            </a>
                                        </li>
<!--                                        <li class="nav-item flex-sm-fill text-sm-center" role="presentation">
                                            <a class="nav-link" data-bs-toggle="tab" href="#navpill-33" role="tab" aria-selected="false" tabindex="-1">
                                                <span>Canceled</span>
                                            </a>
                                        </li>-->
                                    </ul>
                                    <!-- Tab panes -->
                                    <div class="tab-content border mt-2">
                                        <div class="tab-pane p-3 active show" id="navpill-11" role="tabpanel">

                                            <div class='row'>
                                                <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                    <div class="col-md-2">
                                                        <b>Order ID</b>
                                                    </div>                               
                                                    <div class="col-md-5">
                                                        <b>Order Date</b>

                                                    </div>

                                                    <div class="col-md-2">
                                                        <b>Total Price</b>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="row">
                                                <c:forEach items="${l1}" var="o">
                                                    <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getOrderID()}
                                                            </p>

                                                        </div>                               
                                                        <div class="col-md-5">
                                                            <p class="mb-0">
                                                                ${o.getOrderDate()}
                                                            </p>


                                                        </div>

                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getTotalPrice()}
                                                            </p>

                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="/GasStove/prepareOrder?id=${o.getOrderID()}" class="badge bg-info">
                                                                Prepare
                                                            </a>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="tab-pane p-3" id="navpill-22" role="tabpanel">
                                            <div class='row'>
                                                <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                    <div class="col-md-1">
                                                        <b>Order ID</b>
                                                    </div>                               
                                                    <div class="col-md-3">
                                                        <b>Address</b>

                                                    </div>

                                                    <div class="col-md-2">
                                                        <b>Customer Name</b>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <b>Required Date    </b>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <b>Total Price</b>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="row">
                                                <c:forEach items="${l2}" var="o">
                                                    <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                        <div class="col-md-1">
                                                            <p class="mb-0">
                                                                ${o.getOrderID()}
                                                            </p>

                                                        </div>                               
                                                        <div class="col-md-3">
                                                            <p class="mb-0">
                                                                ${o.getShipCity()}, ${o.getShipAddress()}
                                                            </p>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getCustomerID()}
                                                            </p>

                                                        </div>  

                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getRequiredDate()}
                                                            </p>

                                                        </div>
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getTotalPrice()}
                                                            </p>

                                                        </div>

                                                        <div class="col-md-2">
                                                            <c:choose>
                                                                <c:when test="${o.getStatus() eq 'Shipped'}">
                                                                    <p name="shipped" class="btn-success">
                                                                        ${o.getStatus()}
                                                                    </p>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <a href="/GasStove/submitShipping?id=${o.getOrderID()}" class="badge bg-info">
                                                                        Submit
                                                                    </a>
                                                                    
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="tab-pane p-3" id="navpill-33" role="tabpanel">
                                            <div class='row'>
                                                <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                    <div class="col-md-2">
                                                        <b>Order ID</b>
                                                    </div>                               
                                                    <div class="col-md-2">
                                                        <b>Order ID</b>
                                                    </div>                               
                                                    <div class="col-md-2">
                                                        <b>Order Date</b>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <b>Customer</b>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <b>Total Price</b>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="row">
                                                <c:forEach items="${l3}" var="o">
                                                    <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getOrderID()}
                                                            </p>
                                                        </div>                               
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getOrderID()}
                                                            </p>
                                                        </div>                               
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getShippedDate()}
                                                            </p>
                                                        </div>

                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getCustomerID()}
                                                            </p>
                                                        </div>
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getTotalPrice()}
                                                            </p>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="tab-pane p-3" id="navpill-33" role="tabpanel">
                                            <div class='row'>
                                                <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                    <div class="col-md-2">
                                                        <b>Order ID</b>
                                                    </div>                               
                                                    <div class="col-md-5">
                                                        <b>Order Date</b>

                                                    </div>

                                                    <div class="col-md-2">
                                                        <b>Total Price</b>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="row">
                                                <c:forEach items="${l4}" var="o">
                                                    <div class="row border-light-gray mb-4 border-bottom pb-2" style="border-width: thin;">
                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getOrderID()}
                                                            </p>

                                                        </div>                               
                                                        <div class="col-md-5">
                                                            <p class="mb-0">
                                                                ${o.getOrderDate()}
                                                            </p>


                                                        </div>

                                                        <div class="col-md-2">
                                                            <p class="mb-0">
                                                                ${o.getTotalPrice()}
                                                            </p>

                                                        </div>
                                                        <div class="col-md-3">
                                                            <a href="/GasStove/prepareOrder?id=${o.getOrderID()}" class="badge bg-info">
                                                                Prepare
                                                            </a>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>
    <script src="/GasStove/admin/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/GasStove/admin/js/sidebarmenu.js"></script>
    <script src="/GasStove/admin/js/app.min.js"></script>
    <script src="/GasStove/admin/libs/simplebar/dist/simplebar.js"></script>
    <script src="cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

    <script>

        function showSuggestions(keyword) {
            var suggestionsList = document.querySelector('.suggestions-list');


            suggestionsList.innerHTML = '';

            if (keyword.trim() === '') {
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var suggestions = JSON.parse(this.responseText);
//                        var suggestionsList = document.querySelector('.suggestions-list');

                    // X�a g?i � c?
                    suggestionsList.innerHTML = '';

                    // Hi?n th? g?i � t?
                    suggestions.forEach(function (suggestion) {
                        var li = document.createElement('li');
                        li.textContent = suggestion;
                        suggestionsList.appendChild(li);
                    });
                }
            };
            xhttp.open("GET", "/GasStove/searchProduct?keyword=" + keyword, true);
            xhttp.send();
        }

        document.addEventListener('click', function (event) {
            var clickedElement = event.target;
            if (clickedElement.tagName === 'LI') {
                var searchBox = document.querySelector('.form-control rounded');
                searchBox.value = clickedElement.textContent;
//                    window.location.href = "/GasStove/productDetail?name=" +  clickedElement.textContent;


                document.querySelector('.suggestions-list').innerHTML = '';
            }
        });
    </script>

    <script>
        $(document).ready(function () {
            $('.dropdown').hover(function () {
                $(this).addClass('show');
                $(this).find('.dropdown-menu').addClass('show');
            }, function () {
                $(this).removeClass('show');
                $(this).find('.dropdown-menu').removeClass('show');
            });
        });
    </script>

</body>

</html>