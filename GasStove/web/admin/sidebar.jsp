<%-- 
    Document   : sidebar
    Created on : Jun 15, 2023, 10:16:33 AM
    Author     : 5580
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="../admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="../admin/css/styles.min.css"/>
    </head>
    <body>
        
                    <!-- Sidebar Start -->
            <aside class="left-sidebar">
                <!-- Sidebar scroll-->
                <div>
                    <div class="brand-logo d-flex align-items-center justify-content-between">
                        <a href="./index.html" class="text-nowrap logo-img">
                            <img src="./admin/images/logos/dark-logo.svg" width="180" alt="" />
                        </a>
                        <div class="close-btn d-xl-none d-block sidebartoggler cursor-pointer" id="sidebarCollapse">
                            <i class="ti ti-x fs-8"></i>
                        </div>
                    </div>
                    <!-- Sidebar navigation-->
                    <nav class="sidebar-nav scroll-sidebar" data-simplebar="">
                        <ul id="sidebarnav">
                            <li class="nav-small-cap">
                                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                <span >Home</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/admin/dashboard.jsp" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-layout-dashboard"></i>
                                    </span>
                                    <span >Dashboard</span>
                                </a>
                            </li>

                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/myProfile" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-users"></i>
                                    </span>
                                    <span >My Profile</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/listCustomer" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-users"></i>
                                    </span>
                                    <span >Customer</span>
                                </a>
                            </li>
                            <%
                                String jobTitle = (String) request.getSession().getAttribute("type");

                                if (jobTitle != null && jobTitle.equals("admin")) {
                            %>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/listEmployee" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-users"></i>
                                    </span>
                                    <span>Employee</span>
                                </a>
                            </li>
                            <%
                                } else {
                            %>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="#" aria-expanded="false" onclick="alert('Access denied');">
                                    <span>
                                        <i class="ti ti-users"></i>
                                    </span>
                                    <span>Employee</span>
                                </a>
                            </li>
                            <%
                                }
                            %>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/productController" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >Products</span>
                                </a>
                            </li>  
                             <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/categoryController" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >Categories</span>
                                </a>
                            </li>  
                             <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/manageCoupon" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >Coupons</span>
                                </a>
                            </li>  
                             <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/listNew" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >List New</span>
                                </a>
                            </li>  
                             <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/userPurchase" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >Orders</span>
                                </a>
                            </li>  
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/chatController" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >Chat with Customer</span>
                                </a>
                            </li> 
                             <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/adminWarranty" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >Warranty manage</span>
                                </a>
                            </li> 
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/MainternanceController" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span >Maintenance Requests</span>
                                </a>
                            </li> 
                            <li class="nav-small-cap">
                                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                <span >UI COMPONENTS</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-buttons.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-article"></i>
                                    </span>
                                    <span >Buttons</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-alerts.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-alert-circle"></i>
                                    </span>
                                    <span >Alerts</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-card.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-cards"></i>
                                    </span>
                                    <span >Card</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-forms.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-file-description"></i>
                                    </span>
                                    <span >Forms</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-typography.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-typography"></i>
                                    </span>
                                    <span >Typography</span>
                                </a>
                            </li>
                            <li class="nav-small-cap">
                                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                <span >AUTH</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./authentication-login.jsp" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-login"></i>
                                    </span>
                                    <span >Login</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./SignUp.jsp" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-user-plus"></i>
                                    </span>
                                    <span >Register</span>
                                </a>
                            </li>
                            <li class="nav-small-cap">
                                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                <span >EXTRA</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./icon-tabler.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-mood-happy"></i>
                                    </span>
                                    <span >Icons</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./sample-page.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-aperture"></i>
                                    </span>
                                    <span >Sample Page</span>
                                </a>
                            </li>
                        </ul>
                        <div class="unlimited-access hide-menu bg-light-primary position-relative mb-7 mt-5 rounded">
                            <div class="d-flex">
                                <div class="unlimited-access-title me-3">
                                    <h6 class="fw-semibold fs-4 mb-6 text-dark w-85">Upgrade to pro</h6>
                                    <a href="https://adminmart.com/product/modernize-bootstrap-5-admin-template/" target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">Buy Pro</a>
                                </div>
                                <div class="unlimited-access-img">
                                    <img src="./admin/images/backgrounds/rocket.png" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                    </nav>
                    <!-- End Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
            </aside>
            <!--  Sidebar End -->
        
        <script src="../admin/libs/jquery/dist/jquery.min.js"></script>
        <script src="../admin/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="../admin/js/sidebarmenu.js"></script>
        <script src="../admin/js/app.min.js"></script>
        <script src="../admin/libs/simplebar/dist/simplebar.js"></script>
    </body>
</html>
