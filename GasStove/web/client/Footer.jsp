<%-- 
    Document   : Footer
    Created on : May 15, 2023, 7:29:07 PM
    Author     : DUC ANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <title>MultiShop - Online Shop Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="/GasStove/client/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/GasStove/client/lib/animate/animate.min.css" rel="stylesheet">
    <link href="/GasStove/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/GasStove/client/css/style.css" rel="stylesheet">
    <style>.footer-area {
  background-color: #ffcf20;
  padding-top: 20px;
  padding-bottom: 20px;
  color: black;
}
</style>
</head>
     <!-- Footer Start -->
        <footer class="footer-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Policy</h6>
                            <div class="row" style="color: black">
                                <ul class="col-lg-6  col-md-6 col-sm-6">
                                    <li><a href="${pageContext.request.contextPath}/policy/Privacy"style="color: black" > Privacy Policy </a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/Shipping"style="color: black">Shipping Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/Return"style="color: black">Return Policy</a></li><!-- comment -->

                                </ul>

                                <ul class="col-lg-6  col-md-6 col-sm-6">

                                    <li><a href="${pageContext.request.contextPath}/policy/Security"style="color: black">Security Policy</a></li><!-- comment -->
                                    <li><a href="${pageContext.request.contextPath}/policy/Customer"style="color: black">Customer Service Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/Affiliate"style="color: black">Affiliate Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/SocialMedia"style="color: black">Social Media Policy</a></li>

                                </ul>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Newsletter</h6>
                            <p>Stay update with our latest</p>
                            <div class="" id="mc_embed_signup">

                                <form target="_blank" novalidate="true" action="registerController"
                                      method="get" class="form-inline">

                                    <div class="d-flex flex-row">

                                        <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '"
                                               required="" type="email">


                                        <button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
                                        <div style="position: absolute; left: -5000px;">
                                            
                                        </div>

                                        <!-- <div class="col-lg-4 col-md-4">
                                                                <button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button>
                                                        </div>  -->
                                    </div>
                                    <div class="info"></div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Follow Us</h6>
                            <p>Let us be social</p>
                            <div class="footer-social d-flex align-items-center">
                                <a href="https://www.facebook.com/profile.php?id=100094108170425"><i class='fab fa-facebook-messenger' style='font-size:24px;color:#000000'></i></a>
                                <a href="https://join.skype.com/px5scxT0ZbKF"><i class="lnr lnr-phone-handset"></i></a>
                                <!--                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                                                <a href="#"><i class="fa fa-behance"></i></a>-->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
                    <p class="footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p> 
                </div>
            </div>
                                    
        </footer>
                                      <script type="text/javascript">
            var Tawk_API = Tawk_API || {}, Tawk_LoadStart = new Date();
            (function () {
                var s1 = document.createElement("script"), s0 = document.getElementsByTagName("script")[0];
                s1.async = true;
                s1.src = 'https://embed.tawk.to/648f52ab94cf5d49dc5e757d/1h37tlrgg';
                s1.charset = 'UTF-8';
                s1.setAttribute('crossorigin', '*');
                s0.parentNode.insertBefore(s1, s0);
            })();
        </script>
                                    
     <!--footer end-->
</html>