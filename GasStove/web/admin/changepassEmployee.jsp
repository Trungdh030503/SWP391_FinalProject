<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css"/>
        <style>
            .form-control:focus {
                box-shadow: none;
                border-color:  #003d99
            }

            .profile-button {
                background: rgb(0, 102, 255);
                box-shadow: none;
                border: none
            }

            .profile-button:hover {
                background: #003d99;
                padding: 8px 12px;
            }

            .profile-button:focus {
                background:  #003d99;
                box-shadow: none
            }

            .profile-button:active {
                background:  #003d99;
                box-shadow: none
            }

            .back:hover {
                color: #003d99;
                cursor: pointer
            }

            .labels {
                font-size: 18px
            }

            .form-control{
                margin-bottom: 10px;
                margin-top: -5px;
            }

            .add-experience:hover {
                background:  #003d99;
                color: #fff;
                cursor: pointer;
                border: solid 1px  #003d99
            }
            .labels{
                font-size: 20px; /* Kích thước font chữ */
                font-family: Arial, serif; /* Font chữ */
                font-weight: Italic; /* Độ đậm nhạt của font chữ (normal, bold, bolder, lighter, etc.) */
                /* Màu chữ */
            }
        </style>


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
                    <div class="container rounded bg-white mt-5 mb-5 ">
                        <c:if test="${requestScope.mess != null}"> 
                            <c:if test="${requestScope.mess.statusCode != 200}">
                                <div class="alert alert-danger" role="alert">
                                    ${requestScope.mess.mess}
                                </div>
                            </c:if>
                            <c:if test="${requestScope.mess.statusCode == 200}">
                                <div class="alert alert-success" role="alert">
                                    ${requestScope.mess.mess}
                                </div>
                            </c:if>
                        </c:if>    
                        <h1>Change Password</h1>
                        <form action = "changepassEmployee" method="post">
                            <div class="row mt-3">
                                <div class="col-md-12"><label class="labels">Old-Password</label>
                                    <input type="password" class="form-control" required="true"
                                           placeholder="Old-Password" value="" name="opass">
                                </div>
                                <div class="col-md-12"><label class="labels">New-Password</label>
                                    <input type="password" class="form-control" required="true"
                                           placeholder="New-Password" value="" name = "npass">
                                </div>
                                <div class="col-md-12"><label class="labels">Confirm-Password</label>
                                    <input type="password" class="form-control" required="true" 
                                           placeholder="Confirm-Password" value="" name="cpass">
                                </div>
                            </div>
                            <div class="mt-5 text-center">
                                <button class="btn btn-primary profile-button" type="submit">
                                    Save Changes
                                </button>
                                <a href="myProfile" class="btn btn-primary profile-button">Back to my profile</a>
                            </div>
                        </form>
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
    <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>





</body>

</html>