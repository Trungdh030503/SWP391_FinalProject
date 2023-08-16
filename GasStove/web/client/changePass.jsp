
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <%@include file="../client/css/setupCss.jsp" %>
        
        <style>
            .form-control:focus {
                box-shadow: none;
                border-color: #003d99
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
                background: #003d99;
                box-shadow: none
            }

            .profile-button:active {
                background: #003d99;
                box-shadow: none
            }

            .back:hover {
                color: #003d99;
                cursor: pointer
            }

            .labels {
                font-size: 16px
            }

            .form-control {
                margin-bottom: 10px;
                margin-top: -5px;
            }

            .add-experience:hover {
                background: #003d99;
                color: #fff;
                cursor: pointer;
                border: solid 1px #003d99
            }
        </style>
    </head>
    <body>
         <%@ include file="Header.jsp" %>
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
    <div class="form-container">
    <form action = "changePassController" method="post">
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
            <a href="productController" class="btn btn-primary profile-button">Back to home page</a>
        </div>
    </form>
        </div>
    <%@include file="Footer.jsp" %>

</body>
</html>
