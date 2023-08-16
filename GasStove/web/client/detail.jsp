<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page import="java.text.Normalizer" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.*" %>




<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>${product.getProductName()}</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="../client/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  
        <!--<link rel="canonical"  href="/web/tweet-button">-->
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="../client/lib/animate/animate.min.css" rel="stylesheet">
        <link href="../client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="../client/css/style.css" rel="stylesheet">
        <style>
            /*            html, body {
                            margin: 0;
                            padding: 0;
                            color: antiquewhite;
                            background-color: #483D8B;
                        }*/
            .container {
                padding: 15px;
                display: flex;
                flex-wrap: wrap;
            }

            .container div {
                margin: 10px;
            }

            .pictures {
                width: 64px;
            }

            .pictures img{
                margin-bottom: 6px;
            }

            .picture {
                position: relative;
                width: 420px;
                height: 303px;
            }

            img {
                width: 100%;
            }

            .img-active {
                box-shadow: 0 0 10px #fc2133, 0 0 10px #fc2133, 0 0 10px #fc2133;
            }

            .rect {
                position: absolute;
                margin: 0px !important;
                padding: 0;
                width: 200px;
                height: 150px;
                background-color: #78787c4d;
                transform: translate(-50%, -50%);
                pointer-events: none;
                opacity: 0;
            }


            /*            .zoom {
                            position: relative;
                            top: 100px;
                            left: 20px;
                        top: 0;
                            left: 0;
                            z-index: 1;
                            background-image: url('client/${product.imageURL}');
                            box-shadow: 5px 5px 5px rgb(24, 24, 24);
                            opacity: 0;
                            
                        }*/

            .zoom {
                position: relative;
                width : 300px;
                height :     300px;
                z-index: 1;
                background-image: url('../client/${product.imageURL}');
                box-shadow: 5px 5px 5px rgb(24, 24, 24);
                opacity: 0;
            }

            .rect-active {
                opacity: 1;
            }
            .popup {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5);
                z-index: 9999; /* ??m b?o pop-up hi?n th? tr�n c�c ph?n t? kh�c */
            }

            .popup-content {
                background-color: #fff;
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                text-align: center;
            }

        </style>
        <style>
            /*.rating-stars i:hover,*/
            /*            .rating-stars i:hover ~ i {
                            color: #f8ac30;  Color for hovered star and previous stars 
                        }*/
        </style>


        <meta property="og:title" content="Your News Title">
        <meta property="og:description" content="Description of your news">
        <meta property="og:type" content="article">
    </head>

    <body>
        <%@ include file="Header.jsp" %>

        <div id="popup" class="popup">
            <div class="popup-content">
                <h2>Login Required</h2>
                <p>You need to be logged in to access the cart.</p>
                <button id="closeBtn">Cancel</button>
            </div>
        </div>

        <div id="popup2" class="popup">
            <div class="popup-content">
                <h2>Out of stock</h2>
                <p>Apology for the inconvenience :'( </p>
                <button id="closeBtn2">Cancel</button>
            </div>
        </div>

        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <a class="breadcrumb-item text-dark" href="../productController">Shop</a>
                        <span class="breadcrumb-item active">Shop Detail</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Shop Detail Start -->
        <div class="container-fluid pb-5">
            <div class="row px-xl-5">

                <!--<div class="col-md-12 mb-30">-->
                <div class="col-sm-8 mb-30">
                    <div class="container">

                        <div class="pictures">
                            <c:forEach items="${product.getImageURLs()}" var="p" varStatus="loop">
                                <span>
                                    <!--<img src="../client/${p}" alt="Image" width="80" height="60" onclick="changeZoomImage('${p}')">-->
                                    <img id="pic${loop.index + 1}" onmouseover="changeImage('../client/${p}', ${loop.index + 1})" src="../client/${p}">
                                </span>
                            </c:forEach>
                        </div>
                        <div class="picture" id="picture">
                            <div class="rect" id="rect"></div>
                            <img id="pic" src="../client/${product.imageURL}">
                        </div>
                        <div class="zoom" id="zoom"></div>
                    </div>
                </div>

                <div class="col-sm-3 h-auto mb-30">
                    <!--<div class="zoom-overlay"></div>-->
                    <div class="h-100 bg-light p-30">
                        <h3>${product.getProductName()}</h3>
                        <!--                    <div class="d-flex mb-3">
                                                <div class="text-primary mr-2">
                                                    <small class="fas fa-star"></small>
                                                    <small class="fas fa-star"></small>
                                                    <small class="fas fa-star"></small>
                                                    <small class="fas fa-star-half-alt"></small>
                                                    <small class="far fa-star"></small>
                                                </div>
                                                <small class="pt-1">(99 Reviews)</small>
                                            </div>-->
                        <h3 class="font-weight-semi-bold mb-4">$150.00</h3>
                        <div>
                            <h3 class="font-weight-semi-bold">${product.getSalePrice()}</h3>
                        </div>
                        <div class="mt-2">
                            <h5 class="font-weight-semi-bold mb-4"><del>${product.getUnitPriceFixed()} d</del></h5>
                        </div>
                        <div>
                            <h7><label>Model Number</label>: <a title="${product.getModelNumber()}" href="#">${product.getModelNumber()}</a></h7>                       
                        </div>
                        <div>
                            <h7><label>Category</label>: <a title="${catergory}" href="#">${category}</a></h7>                       
                        </div>
                        <div>
                            <h7><label>Brand</label>: <a title="${product.getBrand()}" href="#">${product.getBrand()}</a></h7>                       
                        </div>


                        <!--                    <p class="mb-4">Volup erat ipsum diam elitr rebum et dolor. Est nonumy elitr erat diam stet sit
                                                clita ea. Sanc ipsum et, labore clita lorem magna duo dolor no sea
                                                Nonumy</p>-->
                        <!--                    <div class="d-flex mb-3">
                                                <strong class="text-dark mr-3">Sizes:</strong>
                                                <form>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="size-1" name="size">
                                                        <label class="custom-control-label" for="size-1">XS</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="size-2" name="size">
                                                        <label class="custom-control-label" for="size-2">S</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="size-3" name="size">
                                                        <label class="custom-control-label" for="size-3">M</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="size-4" name="size">
                                                        <label class="custom-control-label" for="size-4">L</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="size-5" name="size">
                                                        <label class="custom-control-label" for="size-5">XL</label>
                                                    </div>
                                                </form>
                                            </div>-->
                        <!--                    <div class="d-flex mb-4">
                                                <strong class="text-dark mr-3">Colors:</strong>
                                                <form>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="color-1" name="color">
                                                        <label class="custom-control-label" for="color-1">Black</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="color-2" name="color">
                                                        <label class="custom-control-label" for="color-2">White</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="color-3" name="color">
                                                        <label class="custom-control-label" for="color-3">Red</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="color-4" name="color">
                                                        <label class="custom-control-label" for="color-4">Blue</label>
                                                    </div>
                                                    <div class="custom-control custom-radio custom-control-inline">
                                                        <input type="radio" class="custom-control-input" id="color-5" name="color">
                                                        <label class="custom-control-label" for="color-5">Green</label>
                                                    </div>
                                                </form>
                                            </div>-->
                        <form action="/GasStove/addToCartController" method="get">
                            <div class="d-flex align-items-center mb-4 pt-2">
                                <input type="hidden" value="${product.getProductID()}" name="productID"><!-- comment -->
                                <input type="hidden" value="detail" name="page">
                                <div class="input-group quantity mr-3" style="width: 130px;">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-minus">
                                            <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    <input type="text" class="form-control bg-secondary border-0 text-center" value="1" name="number">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-plus">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </div>
                                <button class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</button>
                            </div>
                        </form>

                        <div class="d-flex pt-2">
                            <strong class="text-dark mr-2">Share on:</strong>
                            <div class="d-inline-flex">
                                <a class="text-dark px-2" onclick="shareOnFB()">
                                    <i class="fab fa-facebook-f"></i>
                                </a>

                                <!--                                <div class="fb-share-button" data-href="https://developers.facebook.com/docs/plugins/" data-layout="" data-size="">
                                                                    <a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse" class="fb-xfbml-parse-ignore">
                                                                    </a>
                                                                </div>-->
                                <a class="text-dark px-2" onclick="shareOntwitter()">
                                    <i class="fab fa-twitter"></i>
                                </a>

                                <script>
                                    function shareOnFB() {
                                        var url = "https://www.facebook.com/sharer/sharer.php?u=https://www.google.com";
                                        window.open(url, '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=300,width=600');
                                        return false;
                                    }
                                    function shareOntwitter() {
                                        var url = 'https://twitter.com/intent/tweet?url=https://www.google.com&via=getboldify&text=Bepgas';
                                        TwitterWindow = window.open(url, 'TwitterWindow', 'width = 600, height = 900');
                                        return false;
                                    }
                                </script>
                                <!--                                <a class="text-dark px-2" href="">
                                                                    <i class="fab fa-linkedin-in"></i>
                                                                </a>
                                                                <a class="text-dark px-2" href="">
                                                                    <i class="fab fa-pinterest"></i>
                                                                </a>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row px-xl-5">
                <div class="col">
                    <div class="bg-light p-30">
                        <div class="nav nav-tabs mb-4">
                            <a class="nav-item nav-link text-dark active" data-toggle="tab" href="#tab-pane-1">Description</a>
                            <!--<a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-2">Information</a>-->
                            <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-3">Reviews (0)</a>
                        </div>
                        <div class="tab-content">
                            <div class="tab-pane fade show active" id="tab-pane-1">
                                ${product.getDescription()}
                                <!--                            <h4 class="mb-3">Product Description</h4>
                                                            <p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam sea. Consetetur vero aliquyam invidunt duo dolores et duo sit. Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod. Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut diam consetetur duo justo est, sit sanctus diam tempor aliquyam eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr sanctus eirmod takimata dolor ea invidunt.</p>
                                                            <p>Dolore magna est eirmod sanctus dolor, amet diam et eirmod et ipsum. Amet dolore tempor consetetur sed lorem dolor sit lorem tempor. Gubergren amet amet labore sadipscing clita clita diam clita. Sea amet et sed ipsum lorem elitr et, amet et labore voluptua sit rebum. Ea erat sed et diam takimata sed justo. Magna takimata justo et amet magna et.</p>-->
                            </div>
                            <div class="tab-pane fade" id="tab-pane-2">
                                <h4 class="mb-3">Additional Information</h4>
                                <p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam sea. Consetetur vero aliquyam invidunt duo dolores et duo sit. Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod. Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut diam consetetur duo justo est, sit sanctus diam tempor aliquyam eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr sanctus eirmod takimata dolor ea invidunt.</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item px-0">
                                                Sit erat duo lorem duo ea consetetur, et eirmod takimata.
                                            </li>
                                            <li class="list-group-item px-0">
                                                Amet kasd gubergren sit sanctus et lorem eos sadipscing at.
                                            </li>
                                            <li class="list-group-item px-0">
                                                Duo amet accusam eirmod nonumy stet et et stet eirmod.
                                            </li>
                                            <li class="list-group-item px-0">
                                                Takimata ea clita labore amet ipsum erat justo voluptua. Nonumy.
                                            </li>
                                        </ul> 
                                    </div>
                                    <div class="col-md-6">
                                        <ul class="list-group list-group-flush">
                                            <li class="list-group-item px-0">
                                                Sit erat duo lorem duo ea consetetur, et eirmod takimata.
                                            </li>
                                            <li class="list-group-item px-0">
                                                Amet kasd gubergren sit sanctus et lorem eos sadipscing at.
                                            </li>
                                            <li class="list-group-item px-0">
                                                Duo amet accusam eirmod nonumy stet et et stet eirmod.
                                            </li>
                                            <li class="list-group-item px-0">
                                                Takimata ea clita labore amet ipsum erat justo voluptua. Nonumy.
                                            </li>
                                        </ul> 
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="tab-pane-3">
                                <div class="row">
                                    <div class="col-md-6">
                                        <h4 class="mb-4">${flist.size()} reviews for "${product.getProductName()}"</h4>
                                        <c:forEach var="f" items="${flist}">
                                            <div class="media mb-4">
                                                <img src="img/user.jpg" alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
                                                <div class="media-body">
                                                    <h6>${f.getCustomer().getFirstName()}<small> - <i>${f.getFeedbackDate()}</i></small></h6>
                                                    <div class="text-primary mb-2">
                                                        <i class=" "></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star"></i>
                                                        <i class="fas fa-star-half-alt"></i>
                                                        <i class="far fa-star"></i>
                                                    </div>
                                                    <p>${f.getFeedbackDetail()}</p>
                                                </div>
                                            </div>

                                        </c:forEach>

                                    </div>
                                    <div class="col-md-6">
                                        <h4 class="mb-4">Leave a review</h4>
                                        <small>Your email address will not be published. Required fields are marked *</small>
                                        <div class="d-flex my-3 star-container">
                                            <p class="mb-0 mr-2">Your Rating * :</p>
                                            <div class="rating-stars">
                                                <i class="far fa-star"></i>
                                                <i class="far fa-star"></i>
                                                <i class="far fa-star"></i>
                                                <i class="far fa-star"></i>
                                                <i class="far fa-star"></i>
                                            </div>
                                        </div>

                                        <form action="/GasStove/reviewProduct" method="post">
                                            <input type="hidden" name="ProductID" value="${product.getProductID()}">
                                            <div class="form-group">
                                                <label for="message">Your Review *</label>
                                                <textarea id="message" cols="30" rows="5" name = "message" class="form-control" required=""></textarea>
                                            </div>
                                            <div class="form-group">
                                                <label for="name">Your Name *</label>
                                                <input type="text" class="form-control" id="name" required="">
                                            </div>
                                            <div class="form-group">
                                                <label for="email">Your Email *</label>
                                                <input type="email" class="form-control" id="email" required="">
                                            </div>
                                            <input type="hidden" id="rating" name="rating" value="0">
                                            <div class="form-group mb-0">
                                                <input type="submit" value="Leave Your Review" class="btn btn-primary px-3">
                                            </div>
                                        </form>
                                        <script>
                                            // Get all the <i> elements within the rating-stars container
                                            const ratingStars = document.querySelectorAll('.rating-stars i');
                                            const ratingInput = document.getElementById('rating');
                                            ratingStars.forEach((star, index) => {
                                                star.addEventListener('mouseover', () => {
                                                    // Add fas class to the hovered star and previous stars
                                                    for (let i = 0; i <= index; i++) {
                                                        ratingStars[i].classList.remove('far');
                                                        ratingStars[i].classList.add('fas');
                                                    }
                                                });

                                                star.addEventListener('click', () => {
                                                    // Toggle clicked class on the rating-stars container
                                                    star.parentNode.classList.toggle('clicked');

                                                    // Add fas class to the clicked star and previous stars
                                                    for (let i = 0; i <= index; i++) {
                                                        ratingStars[i].classList.remove('far');
                                                        ratingStars[i].classList.add('fas');
                                                    }
                                                    for (let i = index + 1; i <= 4; i++) {
                                                        ratingStars[i].classList.remove('fas');
                                                        ratingStars[i].classList.add('far');
                                                    }
                                                    // Update the value of the hidden input field
                                                    ratingInput.value = index + 1;
                                                });
                                            });
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Shop Detail End -->


        <!--         Products Start 
                <div class="container-fluid py-5">
                    <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">You May Also Like</span></h2>
                    <div class="row px-xl-5">
                        <div class="col">
                            <div class="owl-carousel related-carousel">
                                <div class="product-item bg-light">
                                    <div class="product-img position-relative overflow-hidden">
                                        <img class="img-fluid w-100" src="${product.getImageURL()}" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-center mb-1">
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small>(99)</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-item bg-light">
                                    <div class="product-img position-relative overflow-hidden">
                                        <img class="img-fluid w-100" src="img/product-2.jpg" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-center mb-1">
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small>(99)</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-item bg-light">
                                    <div class="product-img position-relative overflow-hidden">
                                        <img class="img-fluid w-100" src="img/product-3.jpg" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-center mb-1">
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small>(99)</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-item bg-light">
                                    <div class="product-img position-relative overflow-hidden">
                                        <img class="img-fluid w-100" src="img/product-4.jpg" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-center mb-1">
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small>(99)</small>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-item bg-light">
                                    <div class="product-img position-relative overflow-hidden">
                                        <img class="img-fluid w-100" src="img/product-5.jpg" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a class="h6 text-decoration-none text-truncate" href="">Product Name Goes Here</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h5>$123.00</h5><h6 class="text-muted ml-2"><del>$123.00</del></h6>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-center mb-1">
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small class="fa fa-star text-primary mr-1"></small>
                                            <small>(99)</small>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                 Products End -->

        <%@ include file="Footer.jsp" %>

        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>

        <script>
            // main picture
            var picture = document.querySelector('#pic');

            // side pictures
            var picture1 = document.querySelector('#pic1');
            var picture2 = document.querySelector('#pic2');
            var picture3 = document.querySelector('#pic3');
            var picture4 = document.querySelector('#pic4');
            var picture5 = document.querySelector('#pic5');
            var picture6 = document.querySelector('#pic6');

            // Main picture container
            var mainContainer = document.querySelector('#picture');

            // selector
            var rect = document.querySelector("#rect");

            // Zoom window
            var zoom = document.querySelector('#zoom');

            // list of pictures 
            picList = [picture1, picture2, picture3, picture4, picture5, picture6]

            // Active side picture
            let picActive = 1;

            // Add a boxshodow to the first piture (Current active picture)
            picture1.classList.add('img-active');

            // change image 
            function changeImage(imgSrc, n) {
                // This will change the main image
                picture.src = imgSrc;
                // This will change the background image of the zoom window
                zoom.style.backgroundImage = "url(" + imgSrc + ")";
                // removing box shodow from the previous active side picture
                picList[picActive - 1].classList.remove('img-active');
                // Add box shodow to active side picture
                picList[n - 1].classList.add('img-active');
                // update the active side picture 
                picActive = n;
            }


            // Width and height of main picture in px
            let w1 = mainContainer.offsetWidth;
            let h1 = mainContainer.offsetHeight;

            // Zoom ratio
            let ratio = 3;

            // Zoom window background-image size
            zoom.style.backgroundSize = w1 * ratio + 'px ' + h1 * ratio + 'px';

            // Coordinates of mouse cursor
            let x, y, xx, yy;

            // Width and height of selector
            let w2 = rect.offsetWidth / 2;
            let h2 = rect.offsetHeight / 2;

            // zoom window width and height
            zoom.style.width = w2 * ratio + 'px';
            zoom.style.height = h2 * ratio + 'px';

            // half of selector shows outside the main picture
            // We need half of width and height
            w2 = w2 / 2;
            h2 = h2 / 2;
            // moving the selector box 
            function move(event) {
                // How far is the mouse cursor from an element
                // x how far the cursor from left of element
                x = event.offsetX;
                // y how far the cursor from the top of an element
                y = event.offsetY;

                xx = x - w2;
                yy = y - h2;
                // Keeping the selector inside the main picture
                // left of picture
                if (x < w2) {
                    x = w2;
                    // matching the zoom window with the selector
                    xx = 0;
                }
                // right of main picture
                if (x > w1 - w2) {
                    x = w1 - w2;
                    xx = x - w2;
                }
                // top of main picture 
                if (y < h2) {
                    y = h2;
                    yy = 0;
                }
                // bottom of main picture
                if (y > h1 - h2) {
                    y = h1 - h2;
                }

                xx = xx * ratio;
                yy = yy * ratio;
                // changing the position of the selector
                rect.style.left = x + 'px';
                rect.style.top = y + 'px';
                // changing background image of zoom window
                zoom.style.backgroundPosition = '-' + xx + 'px ' + '-' + yy + 'px';
            }

            mainContainer.addEventListener('mousemove', function () {
                move(event);
                addOpacity();
            })

            // show selector
            // show zoom window
            function addOpacity() {
                rect.classList.add('rect-active');
                zoom.classList.add('rect-active');
            }

            // Hide the zoom window 
            function removeOpacity() {
                zoom.classList.remove('rect-active');
            }

            mainContainer.addEventListener('mouseout', function () {
                removeOpacity();
            })
            
            
        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                var popup = document.getElementById("popup");
                var popup2 = document.getElementById("popup2");
                var closeBtn = document.getElementById("closeBtn");
                var closeBtn2 = document.getElementById("closeBtn2");
                //var addToCartBtn = document.querySelector(".checkcart");
                //var showPopup = false; // Bi?n ?? ki?m tra xem pop-up c� n�n hi?n th? hay kh�ng

                closeBtn.addEventListener("click", function() {
                    popup.style.display = "none";
                });
                closeBtn2.addEventListener("click", function() {
                    popup2.style.display = "none";
                });

                var params = new URLSearchParams(window.location.search);
                var showPopupValue = params.get("showPopup");
                var showPopupValue2 = params.get("showPopup2");
                console.log(showPopupValue)
                if (showPopupValue === 'true') {
                    popup.style.display = "block";
                }
                if (showPopupValue2 === 'true') {
                    popup2.style.display = "block";
                }
            });
        </script>
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="../client/lib/easing/easing.min.js"></script>
        <script src="../client/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="../client/mail/jqBootstrapValidation.min.js"></script>
        <script src="../client/mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="../client/js/main.js"></script>

    </body>

</html>