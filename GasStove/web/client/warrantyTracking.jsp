<%-- 
    Document   : warrantyTracking
    Created on : Jun 25, 2023, 9:37:36 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css"/>
        <base href="${pageContext.request.contextPath}/">


        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <!--href="../SWP_1/assets/css/styles.min.css"-->
        <link href="client/css/style.css" rel="stylesheet">
        <link href="client/lib/animate/animate.min.css" rel="stylesheet">
        <link href="client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="client/css/style.css" rel="stylesheet">
        <!-- Libraries Stylesheet -->
        <link href="css/newcss.css" rel="stylesheet" type="text/css"/>
        <link href="css/newcss1.css" rel="stylesheet" type="text/css"/>
        <link href="css/newcss2.css" rel="stylesheet" type="text/css"/>
        <style>
            #myProgress {
                width: 100%;
                background-color: grey;
            }

            #myBar {
                width: 1%;
                height: 30px;
                background-color: green;
            }
        </style>
    </head>

    <script>
        function adjustFooter() {
            var body = document.body;
            var html = document.documentElement;
            var footer = document.querySelector('.footer-area');
            var height = Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight);
            if (height > window.innerHeight) {
                footer.style.position = 'static';
            } else {
                footer.style.position = 'absolute';
                footer.style.bottom = '0';
                footer.style.left = '0';
                footer.style.width = '100%';
            }
        }

        window.addEventListener('load', adjustFooter);
        window.addEventListener('resize', adjustFooter);
    </script>
    <body>
        <%@ include file="Header.jsp" %>


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
                            <li class="nav-item">
                                <a class="nav-link" id="outofwarranty-tab" data-bs-toggle="tab" href="#outofwarranty">Remain</a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <!-- Request tab -->
                            <div class="tab-pane fade show active" id="request">
                                <div class="table-responsive">
                                    <table class="table text-nowrap mb-0 align-middle">
                                        <tr style="font-weight: bold">
                                            <td>WarrantyID</td>
                                            <td>Product Name</td>
                                            <td>Serial Number</td>
                                            <td>OrderID</td>
                                            <td>StartDate</td>
                                            <td>EndDate</td>
                                            <td>Ticket Number</td>
                                            <!--<td>Status</td>-->
                                            <!--<td>Action</td>-->
                                            <!--<td>Feedback</td>-->
                                        </tr>
                                        <c:forEach items="${warranty}" var="w">
                                            <!--<c:if test="${w.getStatus() == 1}">-->
                                                <tr>
                                                    <td>${w.getWarrantyID()}</td>
                                                    <td>${w.getProduct().getProductName()}</td>
                                                    <td>${w.getSerialNumber()}</td>
                                                    <td>${w.getOrderID()}</td>
                                                    <td>${w.getStartDate()}</td>
                                                    <td>${w.getEndDate()}</td>
                                                    <td>${w.getTicketNumber()}</td>
                                                    <!--<td class="status">${w.getStatus()}</td>-->
                                                    <!--<td>${w.getEmployeeID()}</td>-->
                                                    <!--<td>${w.getComment()}</td>-->
                                                    <td>
                                                        <!--<a href="editStatus?WarrantyID=${w.getWarrantyID()}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">Edit</i></a>-->
                                                    </td>
                                                </tr>
                                                <!--</c:if>-->
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
                                                <td>WarrantyID</td>
                                                <td>Product Name</td>
                                                <td>Serial Number</td>
                                                <td>OrderID</td>
                                                <td>Customerid</td>
                                                <td>StartDate</td>
                                                <td>EndDate</td>
                                                <td>Ticket Number</td>
                                                <!--<td>Status</td>-->
                                                <!--<td>EmployeeID</td>-->
                                                <!--<td>Action</td>-->
                                                <!--<td>Feedback</td>-->
                                            </tr>
                                            <c:forEach items="${warranty}" var="w">
                                                <c:if test="${w.getStatus() == 2}">
                                                    <tr>
                                                        <td>${w.getWarrantyID()}</td>
                                                        <td>${w.getProduct().getProductName()}</td>
                                                        <td>${w.getSerialNumber()}</td>
                                                        <td>${w.getOrderID()}</td>
                                                        <td>${w.getCustomerid()}</td>
                                                        <td>${w.getStartDate()}</td>
                                                        <td>${w.getEndDate()}</td>
                                                        <td>${w.getTicketNumber()}</td>
                                                        <!--<td class="status">${w.getStatus()}</td>-->
                                                        <!--<td>${w.getEmployeeID()}</td>-->
                                                        <!--<td>${w.getComment()}</td>-->
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

                            <!-- Completed tab -->
                            <div class="tab-pane fade" id="completed">

                                <!-- Nội dung của tab "Completed" -->
                                <div class="tab-pane fade show active" id="Completed">
                                    <div class="table-responsive">
                                        <table class="table text-nowrap mb-0 align-middle">
                                            <tr style="font-weight: bold">
                                                <td>WarrantyID</td>
                                                <td>Product Name</td>
                                                <td>Serial Number</td>
                                                <td>OrderID</td>
                                                <td>Customerid</td>
                                                <td>StartDate</td>
                                                <td>EndDate</td>
                                                <td>Ticket Number</td>
                                                <!--<td>Status</td>-->
                                                <!--<td>EmployeeID</td>-->
                                                <!--<td>Action</td>-->
                                                <td>Feedback</td>
                                            </tr>
                                            <c:forEach items="${warranty}" var="w">
                                                <c:if test="${w.getStatus() == 3}">
                                                    <tr>
                                                        <td>${w.getWarrantyID()}</td>
                                                        <td>${w.getProduct().getProductName()}</td>
                                                        <td>${w.getSerialNumber()}</td>
                                                        <td>${w.getOrderID()}</td>
                                                        <td>${w.getCustomerid()}</td>
                                                        <td>${w.getStartDate()}</td>
                                                        <td>${w.getEndDate()}</td>
                                                        <td>Ticket Number</td>
                                                        <!--<td>${w.getStatus()}</td>-->
                                                        <!--<td>${w.getEmployeeID()}</td>-->
                                                        <td>
                                                            <a href="#" class="edit" data-toggle="modal" data-target="#feedbackModal${w.getWarrantyID()}">
                                                                <i class="material-icons" data-toggle="tooltip" title="Add Feedback">Add Feedback</i>
                                                            </a>
                                                        </td>

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
                            <!-- Feedback Modal -->
                            <c:forEach items="${warranty}" var="w">
                                <div class="modal fade" id="feedbackModal${w.getWarrantyID()}" tabindex="-1" role="dialog" aria-labelledby="feedbackModalLabel${w.getWarrantyID()}" aria-hidden="true">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="feedbackModalLabel${w.getWarrantyID()}">Add Feedback</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="feedback" method="POST">
                                                    <input type="hidden" name="WarrantyID" value="${w.getWarrantyID()}">
                                                    <input type="hidden" name="OrderID" value="${w.getOrderID()}">
                                                    <input type="hidden" name="ProductID" value="${w.getProduct().getProductID()}">
                                                    <div class="form-group">
                                                        <label for="feedbackText${w.getWarrantyID()}">Feedback:</label>
                                                        <textarea class="form-control" id="feedbackText${w.getWarrantyID()}" name="feedbackText" rows="3" required></textarea>
                                                    </div>
                                                    <button type="submit" class="btn btn-primary">Submit</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="tab-pane fade" id="outofwarranty">

                                <!-- Nội dung của tab "outofwarranty" -->
                                <div class="tab-pane fade show active" id="outofwarranty">

                                    <div class="table-responsive">
                                        <table class="table text-nowrap mb-0 align-middle">
                                            <tr style="font-weight: bold">
                                                <td>Serial Number</td>
                                                <td>Product Name</td>
                                                <td>OrderID</td>
                                                <td>StartDate</td>
                                                <td>EndDate</td>
                                                <td>Warranty CountDown</td>
                                                <td></td>
                                                <!--<td>Status</td>-->
                                                <!--<td>EmployeeID</td>-->
                                                <!--<td>Action</td>-->
                                            </tr>

                                            <c:forEach items="${warranty}" var="a">

                                                <tr>
                                                    <td>${a.getSerialNumber()}</td>
                                                    <td>${a.getProduct().getProductName()}</td>
                                                    <td>${a.getOrderID()}</td>
                                                    <td>${a.getWarrantyStartDate()}</td>
                                                    <td>${a.getWarrantyEndDate()}</td>
                                                    ${a.getWarrantyRatio()}
                                                    <c:if test="${a.getWarrantyRatio() < 100}">
                                                        <td>
                                                            <div id="myProgress">
                                                                <div id="myBar" style="width: ${a.getWarrantyRatio()}%;"></div>
                                                            </div>
                                                        </td>
                                                    </c:if>
                                                    <c:if test="${a.getWarrantyRatio() >= 100}">
                                                        <td>
                                                            Expired
                                                        </td>
                                                        <td>

                                                            <form action="maintenanceRequest" method="POST">
                                                                <input type="hidden" value="${a.getSerialNumber()}" name="SerialNumber">
                                                                <c:if test="${a.getStatus() != 4}">
                                                                    <button type="submit" class="btn btn-primary">
                                                                        Request fixing
                                                                    </button>
                                                                </c:if>
                                                            </form>
                                                                <c:if test="${a.getStatus() == 4}">
                                                                    Waiting to fix
                                                                </c:if>
                                                        </td>
                                                    </c:if>
                                                </tr>


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
        <script>
            function addToCart(productName, salePrice, productID) {
                console.log(productName);
                console.log(salePrice);
                console.log(productID);
                var forms = document.querySelectorAll('form');
                var form;
                for (var i = 0; i < forms.length; i++) {
                    if (forms[i].getAttribute('data-product-id') === productID) {
                        form = forms[i];
                        break;
                    }
                }
                form.querySelector('input[name="productID"]').value = productID;
                form.querySelector('input[name="productName"]').value = productName;
                form.querySelector('input[name="salePrice"]').value = salePrice;
                form.submit();
            }
        </script>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                // Place your JavaScript code here
                // ...
            });

        </script>


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
<script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function () {
                var orderIDDropdown = document.getElementById('orderID');
                var detailIDDropdown = document.getElementById('detailID');
                detailIDDropdown.disabled = true;
                orderIDDropdown.addEventListener('change', function () {
                    var selectedOrderID = this.value;
                    detailIDDropdown.disabled = false;
                    for (var i = 0; i < detailIDDropdown.options.length; i++) {
                        var option = detailIDDropdown.options[i];
                        var optionOrderID = option.getAttribute('data-orderid');

                        if (selectedOrderID === optionOrderID) {
                            option.style.display = 'block';
                        } else {
                            option.style.display = 'none';
                        }
                    }
                });
            });
</script> 






<%@include file="Footer.jsp" %>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Contact Javascript File -->
<script src="mail/jqBootstrapValidation.min.js"></script>
<script src="mail/contact.js"></script>

<!-- Template Javascript -->
<script src="js/main.js"></script>
</body>
</html>
