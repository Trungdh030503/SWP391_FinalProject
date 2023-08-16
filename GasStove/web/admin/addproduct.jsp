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
            <!-- Sidebar Start -->
            <aside class="left-sidebar">
                <!-- Sidebar scroll-->
                <div>
                    <div class="brand-logo d-flex align-items-center justify-content-between">
                        <a href="./index.html" class="text-nowrap logo-img">
                            <img src="/GasStove/admin/images/logos/dark-logo.svg" width="180" alt="" />
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
                                <span class="hide-menu">Home</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="/GasStove/admin/dashboard.jsp" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-layout-dashboard"></i>
                                    </span>
                                    <span class="hide-menu">Dashboard</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./customers.jsp" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-users"></i>
                                    </span>
                                    <span class="hide-menu">Customer</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="productController" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-list-details"></i>
                                    </span>
                                    <span class="hide-menu">Products</span>
                                </a>
                            </li>    
                            <li class="nav-small-cap">
                                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                <span class="hide-menu">UI COMPONENTS</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-buttons.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-article"></i>
                                    </span>
                                    <span class="hide-menu">Buttons</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-alerts.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-alert-circle"></i>
                                    </span>
                                    <span class="hide-menu">Alerts</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-card.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-cards"></i>
                                    </span>
                                    <span class="hide-menu">Card</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-forms.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-file-description"></i>
                                    </span>
                                    <span class="hide-menu">Forms</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./ui-typography.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-typography"></i>
                                    </span>
                                    <span class="hide-menu">Typography</span>
                                </a>
                            </li>
                            <li class="nav-small-cap">
                                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                <span class="hide-menu">AUTH</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./authentication-login.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-login"></i>
                                    </span>
                                    <span class="hide-menu">Login</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./authentication-register.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-user-plus"></i>
                                    </span>             
                                    <span class="hide-menu">Register</span>
                                </a>
                            </li>
                            <li class="nav-small-cap">
                                <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                <span class="hide-menu">EXTRA</span>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./icon-tabler.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-mood-happy"></i>
                                    </span>
                                    <span class="hide-menu">Icons</span>
                                </a>
                            </li>
                            <li class="sidebar-item">
                                <a class="sidebar-link" href="./sample-page.html" aria-expanded="false">
                                    <span>
                                        <i class="ti ti-aperture"></i>
                                    </span>
                                    <span class="hide-menu">Sample Page</span>
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
                                    <img src="/GasStove/admin/images/backgrounds/rocket.png" alt="" class="img-fluid">
                                </div>
                            </div>
                        </div>
                    </nav>
                    <!-- End Sidebar navigation -->
                </div>
                <!-- End Sidebar scroll-->
            </aside>
            <!--  Sidebar End -->
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
                                            <a href="./authentication-login.html" class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
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
                            <div class="card-body border-top">
                                <form action="addProduct" method="post" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Product Name</label>
                                                <input type="text" name="name" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Model</label>
                                                <input type="text" name="model" class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label class="control-label col-form-label">Category</label>
                                                <select class="form-select" name="category">
                                                    <c:forEach items="${categories}" var="c">
                                                        <option>${c.getSubCategoryName()}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label class="control-label col-form-label">Brand</label>
                                                <select class="form-select" name="brand">
                                                    <c:forEach items="${brands}" var="b">
                                                        <option>${b}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Price (VND)</label>
                                                <input type="text" class="form-control" name="price">
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Sale Off (%)</label>
                                                <input type="text" class="form-control" name="sale">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Stock</label>
                                                <input aria-label="quantity" class="form-control" max="999" min="0" name="stock" type="number" value="${product.getStock()}">

                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Warranty Period</label>
                                                <input type="text" class="form-control" name="warranty" >
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="mb-3">
                                                <label class="control-label col-form-label">Select Image File</label>
                                                <div class="input-group flex-nowrap">
                                                    <div class="custom-file">
                                                        <input type="file" class="form-control" id="inputGroupFile01" name="imagefile">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="mb-3">
                                                <label class="control-label col-form-label">Description</label>
                                                <textarea class="form-control" aria-label="With textarea" name="description"></textarea>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="card-body border-top">
                                                <button type="submit" class="btn btn-success rounded-pill px-4">
                                                    <div class="d-flex align-items-center">
                                                        <i class="ti ti-device-floppy me-1 fs-4"></i>
                                                        Save
                                                    </div>
                                                </button>
                                                <button type="button" class="btn btn-danger rounded-pill px-4 ms-2 text-white" onclick="redirectToController()">
                                                    Cancel
                                                </button>
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
    <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>
    <script src="/GasStove/admin/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/GasStove/admin/js/sidebarmenu.js"></script>
    <script src="/GasStove/admin/js/app.min.js"></script>
    <script src="/GasStove/admin/libs/simplebar/dist/simplebar.js"></script>
    <script src="/GasStove/admin/js/editing.js"></script>
    <script>
    function redirectToController() {
        window.location.href = "/GasStove/productController";
    }
    </script>
</body>

</html>