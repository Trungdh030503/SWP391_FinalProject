<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : warrantyCheck
    Created on : Jun 21, 2023, 11:25:09 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <base href="${pageContext.request.contextPath}/">

        <meta charset="utf-8">
        <title>MultiShop - Online Shop Website Template</title>
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
            .form-container {
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 50vh;
            }

            form {
                width: 500px;
                padding: 20px;
                background-color: #f8f8f8;
                border-radius: 10px;
            }

            label {
                font-size: 18px;
                font-weight: bold;
            }

            input[type="text"],
            textarea {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                resize: vertical;
            }

            button[type="submit"] {
                width: 100%;
                padding: 12px;
                font-size: 18px;
                font-weight: bold;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
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
        <div class="form-container">
            <form action="warrantyRequest" method="post">
                <label for="serialNumber">Serial Number:</label>
                <br>
                <select id="serialNumber" name="serialNumber" required>
                    <option value="">Select a serial number</option> 
                    <c:forEach var="serialNumber" items="${serialNumbers}">
                        <option value="${serialNumber}">${serialNumber}</option>
                    </c:forEach>
                </select>
                <br>
                <label for="description">Description:</label>
                <textarea id="description" name="description" required></textarea>
                <br>
                <input type="hidden" id="ticketNumber" name="TicketNumber" readonly>
                <input type="hidden" name="status" value="1">                    
                <!--<input type="hidden" id="startDate" name="startDate" value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>">-->
                <input type="hidden" id="startDate" name="startDate" >
                <input type="hidden"  name="Email" value="${customer.getEmail()}">
                <input type="hidden"  name="name" value="${customer.getFirstName()}  ${customer.getLastName()}">
                <button type="submit">Submit</button>
            </form>
        </div>




        <!--                    var serialNumber = serialNumberSelect.value;
                            var currentDate = new Date();
                            var formattedDate = currentDate.getFullYear() + ('0' + (currentDate.getMonth() + 1)).slice(-2) + ('0' + currentDate.getDate()).slice(-2);
                            var ticketNumber = formattedDate + serialNumber;-->


        <script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function () {
                var serialNumberSelect = document.getElementById('serialNumber');
                var ticketNumberInput = document.getElementById('ticketNumber');

                serialNumberSelect.addEventListener('change', function () {
                    var serialNumber = serialNumberSelect.value;
                    var currentDate = new Date();
                    var year = currentDate.getFullYear().toString().substr(-2);
                    var formattedDate = ('0' + (currentDate.getMonth() + 1)).slice(-2) + ('0' + currentDate.getDate()).slice(-2);
                    var ticketNumber = formattedDate + year + serialNumber;
                    ticketNumberInput.value = ticketNumber;
                });
            });
        </script>






        <c:if test="${requestScope.mess != null}">
            <c:if test="${requestScope.mess.statusCode != 200}">
                <div class="container mt-3">
                    <div class="alert alert-success" role="alert">
                        ${requestScope.mess.mess}
                    </div>
                </div>
            </c:if>
            <c:if test="${requestScope.mess.statusCode == 200}">
                <div class="container mt-3">
                    <div class="alert alert-danger" role="alert">
                        ${requestScope.mess.mess}
                    </div>
                </div>
            </c:if>
        </c:if>
        <script>document.getElementById("startDate").style.display = "none";
        </script>
        <script type="text/javascript">
            document.addEventListener('DOMContentLoaded', function () {
                document.getElementById('submitForm').addEventListener('click', function () {
                    var serialNumber = document.getElementById('serialNumber').value;
                    var currentDate = new Date();
                    var formattedDate = currentDate.getFullYear() + ('0' + (currentDate.getMonth() + 1)).slice(-2) + ('0' + currentDate.getDate()).slice(-2);
                    var ticketNumber = formattedDate + serialNumber;
                    document.getElementById('ticketNumber').setAttribute('value', ticketNumber);
                    document.getElementById('warrantyForm').submit();
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
