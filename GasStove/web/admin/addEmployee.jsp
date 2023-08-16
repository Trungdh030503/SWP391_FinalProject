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
                <%@ include file="sidebar.jsp" %>
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
                            <div class="card-body border-top">
                                <form action="addEmployee" method="post" enctype="multipart/form-data">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">First Name</label>
                                                <input type="text" class="form-control" name="FirstName" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Last Name</label>
                                                <input type="text" class="form-control" name="LastName" required>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <!--                                        <div class="col-sm-12 col-md-6">
                                                                                    <div class="mb-3">
                                                                                        <label for="inputcom" class="control-label col-form-label">Employee ID</label>
                                                                                        <input type="text" class="form-control" name="EmployeeID" required>
                                                                                    </div>
                                                                                </div>-->
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">JobTitle</label>
                                                <select class="form-control" name="JobTitle" required>
                                                    <option value="">--JobTitle--</option>
                                                    <option value="admin">admin</option>
                                                    <option value="Employee">Employee</option>
                                                </select>
                                            </div>
                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Email</label>
                                                <input type="email" class="form-control" name="Email" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Username</label>
                                                <input type="text" class="form-control" name="Username" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Password</label>
                                                <input type="password" class="form-control" name="Password" id="passwordField" readonly onclick="generatePassword()">
                                            </div>
                                        </div>

                                        <script>
                                            function generatePassword() {
                                                var length = 8;
                                                var charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+";
                                                var password = "";
                                                for (var i = 0; i < length; i++) {
                                                    password += charset.charAt(Math.floor(Math.random() * charset.length));
                                                }
                                                document.getElementById("passwordField").value = password;
                                            }
                                        </script>


                                    </div>
                                    <div class="row">

                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Salary ($)</label>
                                                <input type="text" class="form-control" name="Salary" required >
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Hire Date</label>
                                                <input type="date" class="form-control" name="HireDate" required >
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Address</label>
                                                <input type="text" class="form-control" name="Address" required>

                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Phone Number</label>
                                                <input type="text" class="form-control" name="PhoneNumber" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="col-12">
                                            <div class="mb-6">
                                                <label class="control-label col-form-label">Avatar</label>
                                                <div class="input-group flex-nowrap">
                                                    <div class="custom-file">
                                                        <input type="file" class="form-control" id="inputGroupFile01" onchange="previewImage(this);" name="Avatar" value="${employee.getAvatarURL()}">
                                                    </div>
                                                </div>
                                            </div>
                                            <img src="avatar/${employee.getAvatarURL()}" alt="Avatar">
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
                                                <button type="button" class="btn btn-danger rounded-pill px-4 ms-2 text-white" onclick="clearForm()">
                                                    Clear Form
                                                </button>

                                            </div>
                                      
                                        </div>
                                        <script>
                                            function clearForm() {
                                                $('form :input').val('');
                                            }
                                        </script>
                                          <script>
                                    function previewImage(input) {
                                        var preview = document.getElementById('avatar-preview');
                                        if (input.files && input.files[0]) {
                                            var reader = new FileReader();
                                            reader.onload = function (e) {
                                                preview.src = e.target.result;
                                            }
                                            reader.readAsDataURL(input.files[0]);
                                        }
                                    }
                                </script>
                                    </div>
                                </form>

                            </div>
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
                            <c:if test="${not empty message}">
                                <div class="alert alert-success">${message}</div>
                            </c:if>
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