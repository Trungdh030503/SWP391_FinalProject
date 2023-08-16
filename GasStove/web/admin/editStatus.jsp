<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css" />
        <script>
            function validateForm() {
                var statusInput = document.getElementById("statusInput");
                if (statusInput.value == 1) {
                    alert("Warning: Status cannot be 0. Please select a different value.");
                    return false;
                }
            }
        </script>

    </head>

    <body>
        <!--  Body Wrapper -->
        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
             data-sidebar-position="fixed" data-header-position="fixed">

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
                                <a href="https://adminmart.com/product/modernize-free-bootstrap-admin-dashboard/" target="_blank"
                                   class="btn btn-primary">Download Free</a>
                                <li class="nav-item dropdown">
                                    <a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown"
                                       aria-expanded="false">
                                        <img src="/GasStove/admin/images/profile/user-1.jpg" alt="" width="35" height="35"
                                             class="rounded-circle">
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
                                <form action="editStatus" method="post" onsubmit="return validateForm()">
                                    <div class="row">
                                        <!--                                        <div class="col-sm-12 col-md-6">
                                                                                    <div class="mb-3">
                                                                                        <label for="inputcom" class="control-label col-form-label">Warranty ID</label>
                                                                                        <input type="text" class="form-control" name="WarrantyID" value="${warranty.getWarrantyID()}"
                                                                                               readonly>
                                                                                    </div>
                                                                                </div>-->
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Choose warranty type</label>
                                                <select class="form-select" name="WarrantyID" id="WarrantyID" required="">
                                                            <option value="1" >1 đổi 1</option>
                                                            <option value="2" >miễn phí</option>
                                                            <option value="3" >khác</option>
                                                     
                                                </select>
                                            </div>
                                        </div>

                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Status</label>
                                                <select class="form-select" name="Status" id="statusInput" required="">
                                                    <c:choose>
                                                        <c:when test="${warranty.getStatus() == 1}">
                                                            <option value="2">Processing</option>
                                                            <option value="1" selected >Requested</option>
                                                        </c:when>
                                                        <c:when test="${warranty.getStatus() == 2}">
                                                            <option value="2" selected>Processing</option>
                                                            <option value="3">Finished</option>
                                                        </c:when>
                                                    </c:choose>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">ProductID</label>
                                                <input type="text" class="form-control" name="ProductID" id="ProductID"
                                                        value="${warranty.getProductID()}" readonly>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">OrderID</label>
                                                <input type="text" class="form-control" name="OrderID" id="OrderID"
                                                       value="${warranty.getOrderID()}" readonly>
                                            </div>                        
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">CustomerID</label>
                                                <input type="text" class="form-control" name="CustomerID" id="CustomerID"
                                                       value="${warranty.getCustomerid()}" readonly>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-6">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">CustomerEmail</label>
                                                <input type="text" class="form-control" name="CustomerEmail" id="CustomerEmail"
                                                       value="${warranty.getCustomer().getEmail()}" readonly>
                                            </div>                        
                                        </div>

                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Description</label>
                                                <input type="text" class="form-control" name="Description" id="Description"
                                                       value="${warranty.getDescription()}" readonly>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Serial Number</label>
                                                <input type="text" class="form-control" name="SerialNumber" id="SerialNumber"
                                                       value="${warranty.getSerialNumber()}" readonly>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Ticket Number</label>
                                                <input type="text" class="form-control" name="TicketNumber" id="TicketNumber"
                                                       value="${warranty.getTicketNumber()}" readonly>
                                            </div>                        
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Start Date</label>
                                                <input type="date" class="form-control" name="StartDate" id="startDateInput"
                                                       value="${warranty.getStartDate()}" readonly>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">End Date</label>
                                                <input type="date" class="form-control" name="EndDate" id="endDateInput"
                                                       value="${warranty.getEndDate()}" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-12 col-md-4">
                                            <div class="mb-3">
                                                <label for="inputcom" class="control-label col-form-label">Employee</label>
                                                <select class="form-select" name="employeeID" id="employeeInput" 
                                                        <c:if test="${param.tab == 'request'}">
                                                            readonly
                                                        </c:if>
                                                        >
                                                    <c:forEach items="${employee}" var="e">
                                                        <option value="${e.getEmployeeID()}">${e.getFirstName()} ${e.getLastName()}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                        </div>




                                    </div>



                                    <div class="row">
                                        <div class="col-12">
                                            <div class="card-body border-top">
                                                <button type="submit" class="btn btn-success rounded-pill px-4" onclick="updateStatus()">
                                                    <div class="d-flex align-items-center">
                                                        <i class="ti ti-device-floppy me-1 fs-4"></i>
                                                        Save
                                                    </div>
                                                </button>

                                                <a href="/GasStove/adminWarranty" class="btn btn-danger rounded-pill px-4 ms-2 text-white">Back to admin
                                                    Warranty</a>

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

        <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>
        <script src="/GasStove/admin/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="/GasStove/admin/js/sidebarmenu.js"></script>
        <script src="/GasStove/admin/js/app.min.js"></script>
        <script src="/GasStove/admin/libs/simplebar/dist/simplebar.js"></script>
        <script src="/GasStove/admin/js/editing.js"></script>





    </body>

</html>
