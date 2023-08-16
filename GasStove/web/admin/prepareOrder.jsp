<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css"/>



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
                                    <div class="p-3" id="custom-invoice">
                                        <!-- 5 -->
                                        <form action="submitOrder" method="POST">
                                            <div class="invoice-127" id="printableArea">
                                                <div class="row pt-3">
                                                    <h5>
                                                        OrderID: 
                                                        <input type="text" class="form-control" name="id" value="${order.getOrderID()}">
                                     
                                                    </h5>
                                                    <div class="col-md-12">
                                                        <!--                                                    <div class="">
                                                                                                                <address>
                                                                                                                    <h6>&nbsp;From,</h6>
                                                                                                                    <h6 class="fw-bold">&nbsp;Steve Jobs</h6>
                                                                                                                    <p class="ms-1">
                                                                                                                        1108, Clair Street, <br>Massachusetts,
                                                                                                                        <br>Woods Hole - 02543
                                                                                                                    </p>
                                                                                                                </address>
                                                                                                            </div>-->
                                                        <div class="text-end">
                                                            <address>
                                                                <h6>Address,</h6>

                                                                <p class="ms-4">
                                                                    ${order.getShipAddress()}
                                                                </p>
                                                                <p class="mt-4 mb-1">
                                                                    <span>Order Date :</span>
                                                                    <i class="ti ti-calendar"></i>
                                                                    ${order.getOrderDate()}
                                                                </p>
                                                                <p>
                                                                    <span>Due Date :</span> 
                                                                    <input class="form-control" type="date" value="${order.getOrderDate()}" name="requiredate">
                                                                </p>
                                                            </address>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="table-responsive mt-5" style="clear: both">
                                                            <table class="table table-hover">
                                                                <thead>
                                                                    <!-- start row -->
                                                                    <tr>
                                                                        <th class="text-center">#</th>
                                                                        <th>Description</th>
                                                                        <th class="text-end">Quantity</th>
                                                                        <th class="text-end">Unit Cost</th>
                                                                        <!--<th class="text-end">Total</th>-->
                                                                    </tr>
                                                                    <!-- end row -->
                                                                </thead>
                                                                <tbody>
                                                                    <!-- start row -->
                                                                    <c:forEach items="${orders}" var="o">
                                                                        <tr>
                                                                            <td class="text-center">1</td>
                                                                            <td>${o.getProduct().getProductName()}</td>
                                                                            <td class="text-end">${o.getQuantity()}</td>
                                                                            <td class="text-end">${o.getProduct().getUnitPriceFixed()}</td>
                                                                            <!--<td class="text-end">$48</td>-->
                                                                        </tr>

                                                                    </c:forEach>

                                                                    <!-- end row -->
                                                                    <!-- start row -->

                                                                    <!-- end row -->
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-12">
                                                        <div class="pull-right mt-4 text-end">
                                                            <p>Sub - Total amount: ${order.getTotalPrice()}vnd</p>
                                                            <!--<p>vat (10%) : $2,085</p>-->
                                                            <!--<hr>-->
                                                            <!--<h3><b>Total :</b> $22,943</h3>-->
                                                        </div>
                                                        <div class="clearfix"></div>
                                                        <hr>
                                                        <div class="text-end">
                                                            <button class="btn btn-danger" type="submit">
                                                                Submit Order
                                                            </button>
                                                            <!--                                                        <button class="btn btn-default print-page" type="button">
                                                                                                                        <span><i class="ti ti-printer fs-5"></i>
                                                                                                                            Print</span>
                                                                                                                    </button>-->
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </form>
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