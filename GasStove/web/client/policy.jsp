<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.Normalizer" %>
<%@ page import="java.util.regex.Pattern" %>
<html lang="en" >

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
    </head>
    <style>.footer-area {
   position: flex;
   left: 0;
   bottom: 0;
   width: 100%;
}
</style>
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
        
        <!--================Blog Area =================-->
        <section class="blog_area single-post-area section_gap">
            <div class="row justify-content-center">
                <div class="col-lg-2" ></div>
                <div class="col-lg-8">
                    ${requestScope.policy}
                </div>
                <div class="col-lg-2" ></div>
                
            </div>
        </section>
        <!--================Blog Area =================-->
        

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
