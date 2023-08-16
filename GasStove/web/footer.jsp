<%-- 
    Document   : footer.jsp
    Created on : Jan 16, 2023, 3:41:14 PM
    Author     : black
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- start footer Area -->
        <footer class="footer-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Policy</h6>
                            <div class="row">
                                <ul class="col-lg-6  col-md-6 col-sm-6">
                                    <li><a href="${pageContext.request.contextPath}/policy/Privacy"> Privacy Policy </a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/Shipping">Shipping Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/Return">Return Policy</a></li><!-- comment -->


                                    <!--                                <li>Shipping Policy: The website should have a shipping policy that outlines estimated delivery times, shipping rates, and any applicable restrictions or fees. Customers should also be informed of any delays or issues with their order.</li> comment 
                                                                    <li>Privacy Policy The website should have a clear privacy policy that outlines how customer data will be collected, stored, and used. The policy should also include details on how customers can opt-out of marketing communications and request the removal of their personal data.</li>
                                    
                                                                    <li>Return Policy: The website should have a clear and concise return policy that outlines how customers can initiate a return, what products are eligible for returns, and any conditions or restrictions that may apply. This policy should also include details on refunds, exchanges, and restocking fees.</li>
                                                                    <li>Security Policy: The website should have a security policy that outlines the measures taken to protect customer data and prevent unauthorized access. This policy should include details on data encryption, firewalls, and other security measures.</li>
                                                                    <li>Customer Service Policy: The website should have a customer service policy that outlines how customer inquiries and issues will be handled. This policy should include information on response times, escalation procedures, and how to contact customer support.</li>
                                                                    <li>Affiliate Policy: If the website has an affiliate program, there should be a policy that outlines the terms and conditions of the program, including commission rates, payment schedules, and any restrictions or requirements for participating.</li>
                                                                    <li>Social Media Policy: If the website has social media channels, there should be a policy that outlines the acceptable use of these channels, any prohibited activities, and the consequences of violating the policy. This policy should also include information on how customer inquiries and complaints will be handled through social media channels.</li>-->
                                </ul>

                                <ul class="col-lg-6  col-md-6 col-sm-6">

                                    <li><a href="${pageContext.request.contextPath}/policy/Security">Security Policy</a></li><!-- comment -->
                                    <li><a href="${pageContext.request.contextPath}/policy/Customer">Customer Service Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/Affiliate">Affiliate Policy</a></li>
                                    <li><a href="${pageContext.request.contextPath}/policy/SocialMedia">Social Media Policy</a></li>

                                    <!--                                <li>Shipping Policy: The website should have a shipping policy that outlines estimated delivery times, shipping rates, and any applicable restrictions or fees. Customers should also be informed of any delays or issues with their order.</li> comment 
                                                                    <li>Privacy Policy The website should have a clear privacy policy that outlines how customer data will be collected, stored, and used. The policy should also include details on how customers can opt-out of marketing communications and request the removal of their personal data.</li>
                                    
                                                                    <li>Return Policy: The website should have a clear and concise return policy that outlines how customers can initiate a return, what products are eligible for returns, and any conditions or restrictions that may apply. This policy should also include details on refunds, exchanges, and restocking fees.</li>
                                                                    <li>Security Policy: The website should have a security policy that outlines the measures taken to protect customer data and prevent unauthorized access. This policy should include details on data encryption, firewalls, and other security measures.</li>
                                                                    <li>Customer Service Policy: The website should have a customer service policy that outlines how customer inquiries and issues will be handled. This policy should include information on response times, escalation procedures, and how to contact customer support.</li>
                                                                    <li>Affiliate Policy: If the website has an affiliate program, there should be a policy that outlines the terms and conditions of the program, including commission rates, payment schedules, and any restrictions or requirements for participating.</li>
                                                                    <li>Social Media Policy: If the website has social media channels, there should be a policy that outlines the acceptable use of these channels, any prohibited activities, and the consequences of violating the policy. This policy should also include information on how customer inquiries and complaints will be handled through social media channels.</li>-->
                                </ul>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Newsletter</h6>
                            <p>Stay update with our latest</p>
                            <div class="" id="mc_embed_signup">

                                <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                      method="get" class="form-inline">

                                    <div class="d-flex flex-row">

                                        <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '"
                                               required="" type="email">


                                        <button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
                                        <div style="position: absolute; left: -5000px;">
                                            <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
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
                                <a href="https://www.facebook.com/profile.php?id=100094108170425"><i class='fab fa-facebook-messenger' style='font-size:24px;color:Blue'></i></a>
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
        <!-- End footer Area -->
    </body>
</html>
