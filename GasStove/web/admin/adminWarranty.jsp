<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css"/>
        <script>
    function validateForm2() {
        var statusInput = document.getElementById("statusInput");
        if (statusInput.value === "2") {
            alert("Status must not be 'Process' for this action.");
            return false; // Ngăn form submit nếu status là 1
        }
    }
</script>


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
                                <!-- Tab navigation -->
                                <ul class="nav nav-tabs">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="request-tab" data-bs-toggle="tab" href="#request">Request</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="processing-tab" data-bs-toggle="tab" href="#processing">Processing</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="completed-tab" data-bs-toggle="tab" href="#completed">Completed</a>
                                    </li>
                                </ul>

                                <div class="tab-content">
                                    <!-- Request tab -->
                                    <div class="tab-pane fade show active" id="request">
                                        <div class="table-responsive">
                                            <table class="table text-nowrap mb-0 align-middle">
                                                <tr style="font-weight: bold">
                                                    <td hidden>WarrantyID</td>
                                                    <td>Product Name</td>
                                                    <td>Serial Number</td>
                                                    <td>OrderID</td>
                                                    <td>Customerid</td>
                                                    <td>Custome Email</td>
                                                    <td>StartDate</td>
                                                    <td>EndDate</td>
                                                    <td hidden>Status</td>
                                                    <td>EmployeeID</td>
                                                    <td>Ticket Number</td>
                                                    <td>Description</td>
                                                    <td>Action</td>
                                                </tr>
                                                <c:forEach items="${warranty}" var="w">
                                                    <c:if test="${w.getStatus() == 1}">
                                                        <tr>
                                                            <td hidden>${w.getWarrantyID()}</td>
                                                            <td>${w.getProduct().getProductName()}</td>
                                                            <td>${w.getSerialNumber()}</td>
                                                            <td>${w.getOrderID()}</td>
                                                            <td>${w.getCustomerid()}</td>
                                                            <td>${w.getCustomer().getEmail()}</td>
                                                            <td>${w.getStartDate()}</td>
                                                            <td>${w.getEndDate()}</td>
                                                            <td class="status" hidden>${w.getStatus()}</td>
                                                            <td>${w.getEmployeeID()}</td>
                                                            <td>${w.getTicketNumber()}</td>
                                                            <td>${w.getDescription()}</td>
                                                            <td> 
<!--                                                                <a href="editStatus?WarrantyID=${w.getWarrantyID()}&productID=${w.getProduct().getProductID()}&orderID=${w.getOrderID()}&tab=request" class="edit" data-toggle="modal">
                                                                    <i class="material-icons" data-toggle="tooltip" title="Edit">Edit</i>
                                                                </a>-->
                                                                <a href="editStatus?SerialNumber=${w.getSerialNumber()}" class="edit" data-toggle="modal">
                                                                    <i class="material-icons" data-toggle="tooltip" title="Edit">Edit</i>
                                                                </a>

                                                            </td>
                                                        </tr>
                                                    </c:if>
                                                </c:forEach>
                                            </table>
                                        </div>
                                    </div>


                                    <!-- Processing tab -->
                                    <div class="tab-pane fade" id="processing">

                                        <!-- Nội dung của tab "Processing" -->
                                        <div class="tab-pane fade show active" id="Processing">
                                            <div class="table-responsive">
                                                <table class="table text-nowrap mb-0 align-middle">
                                                    <tr style="font-weight: bold">
                                                        <td hidden>WarrantyID</td>
                                                        <td>Product Name</td>
                                                        <td>Serial Number</td>
                                                        <td>OrderID</td>
                                                        <td>Customerid</td>
                                                        <td>Customer Email</td>
                                                        <td>StartDate</td>
                                                        <td>EndDate</td>
                                                        <td>Status</td>
                                                        <td>EmployeeID</td>
                                                        <td>Ticket Number</td>
                                                        <td>Description</td>
                                                        <td>Edit Status</td>
                                                    </tr>
                                                    <c:forEach items="${warranty}" var="w">
                                                        <c:if test="${w.getStatus() == 2}">
                                                            <tr>
                                                                <td hidden>${w.getWarrantyID()}</td>
                                                                <td>${w.getProduct().getProductName()}</td>
                                                                <td>${w.getSerialNumber()}</td>
                                                                <td>${w.getOrderID()}</td>
                                                                <td>${w.getCustomerid()}</td>
                                                                <td>${w.getCustomer().getEmail()}</td>
                                                                <td>${w.getStartDate()}</td>
                                                                <td>${w.getEndDate()}</td>
                                                                <td class="status">${w.getStatus()}</td>
                                                                <td>${w.getEmployeeID()}</td>
                                                                <td>${w.getTicketNumber()}</td>
                                                                <td>${w.getDescription()}</td>
                                                                
                                                                <td>
                                                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editStatusModal${w.getWarrantyID()}">Edit</button>

                                                                </td>

                                                            </tr>
                                                            <!-- Edit Shipping Modal -->
                                                            <div class="modal fade" id="editStatusModal${w.getWarrantyID()}" tabindex="-1" role="dialog" aria-labelledby="editStatusModal${w.getWarrantyID()}Label" aria-hidden="true">
                                                                <div class="modal-dialog" role="document">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="editStatusModal${w.getWarrantyID()}Label">Edit Shipping Status</h5>
                                                                            <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                                                                                <span aria-hidden="true">&times;</span>
                                                                            </button>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            <form action="editStatus" method="post" onsubmit="return validateForm2();">
                                                                                <input type="hidden" name="WarrantyID" value="${w.getWarrantyID()}">
                                                                                <input type="hidden" name="employeeID" value="${w.getEmployeeID()}" >
                                                                                <input type="hidden" name="ProductID" value="${w.getProduct().getProductID()}">
                                                                                <input type="hidden" name="OrderID" value="${w.getOrderID()}">
                                                                                <input type="hidden" name="StartDate" value="${w.getStartDate()}">
                                                                                <input type="hidden" name="tab" value="request">
                                                                                <div class="form-group">
<!--                                                                                    <label for="status${w.getWarrantyID()}">Status</label>
                                                                                    <input type="text" class="form-control" id="status${w.getWarrantyID()}" name="Status" value="${w.getStatus()}">-->
                                                                                    <label for="inputcom" class="control-label col-form-label">Status</label>
                                                                                    <select class="form-select" name="Status" id="statusInput" required="">
                                                                                        <c:choose>
                                                                                            <c:when test="${w.getStatus() == 1}">
                                                                                                <option value="2">Processing</option>
                                                                                                <option value="1" selected >Requested</option>
                                                                                            </c:when>
                                                                                            <c:when test="${w.getStatus() == 2}">
                                                                                                <option value="2" selected>Processing</option>
                                                                                                <option value="3">Finished</option>
                                                                                            </c:when>
                                                                                        </c:choose>
                                                                                    </select>

                                                                                </div>
                                                                                
                                                                                <div class="form-group">
                                                                                    <label for="endDate${w.getWarrantyID()}">End Date</label>
                                                                                    <input type="date" class="form-control" id="endDate${w.getWarrantyID()}" name="EndDate" value="${w.getEndDate()}">
                                                                                </div>
                                                                                <button type="submit" class="btn btn-primary">Save Changes</button>
                                                                            </form>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>
                                                </table>
                                            </div>

                                        </div>


                                    </div>

                                    <!-- Completed tab -->
                                    <div class="tab-pane fade" id="completed">

                                        <!-- Nội dung của tab "Completed" -->
                                        <div class="tab-pane fade show active" id="Completed">
                                            <div class="table-responsive">
                                                <table class="table text-nowrap mb-0 align-middle">
                                                    <tr style="font-weight: bold">
                                                        <td>WarrantyID</td>
                                                        <td>Product Name</td>
                                                        <td>OrderID</td>
                                                        <td>Customerid</td>
                                                        <td>StartDate</td>
                                                        <td>EndDate</td>
                                                        <td>Status</td>
                                                        <td>EmployeeID</td>
                                                        <td>Customer's feedback</td>
                                                        <!--<td>Action</td>-->
                                                    </tr>
                                                    <c:forEach items="${warranty}" var="w">
                                                        <c:if test="${w.getStatus() == 3}">
                                                            <tr>
                                                                <td>${w.getWarrantyID()}</td>
                                                                <td>${w.getProduct().getProductName()}</td>
                                                                <td>${w.getOrderID()}</td>
                                                                <td>${w.getCustomerid()}</td>
                                                                <td>${w.getStartDate()}</td>
                                                                <td>${w.getEndDate()}</td>
                                                                <td>${w.getStatus()}</td>
                                                                <td>${w.getEmployeeID()}</td>
                                                                <td>${w.getComment()}</td>
                                                                <td>
                                                                     <!--<a href="editStatus?WarrantyID=${w.getWarrantyID()}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">Edit</i></a>-->
                                                                </td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>
                                                </table>
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
    <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>





</body>

</html>