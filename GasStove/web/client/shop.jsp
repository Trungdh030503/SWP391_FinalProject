<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="Entity.Product" %>
<%@ page import="Controller.ProductDao" %>--%>
<%--<%@page import=""%>--%>

<%@ page import="java.text.Normalizer" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <!--<title>MultiShop - Online Shop Website Template</title>-->
        <title>Xuyên</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="client/img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="client/lib/animate/animate.min.css" rel="stylesheet">
        <link href="client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="client/css/style.css" rel="stylesheet">

        <style>
            /* CSS cho � t�m ki?m */
            .search-container {
                display: flex;
                justify-content: center;
                margin-top: 20px;
            }

            .search-box {
                width: 300px;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-size: 16px;
            }

            .suggestions-container {
                position: relative;
            }

            .suggestions-list {
                position: absolute;
                z-index: 1;
                top: 100%;
                left: 0;
                width: 300px;
                padding: 0;
                margin: 0;
                list-style: none;
                background-color: #fff;
                border: 1px solid #ccc;
                border-top: none;
                border-radius: 4px;
                box-shadow: 0px 4px 5px rgba(0, 0, 0, 0.2);
            }

            .suggestions-list li {
                padding: 10px;
                cursor: pointer;
            }

            .suggestions-list li:hover {
                background-color: #f2f2f2;
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

            button {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                cursor: pointer;
            }
        </style>
    </head>

    <body>
        <%
            int totalPages = 100; // Total number of pages
            int currentPage = 1;
            int maxVisiblePages = 5; // Maximum number of visible page links
            int shownumber = 9;
            String order = "none";
            String currentshownumber = request.getParameter("shownumber");
            String thiscategory = "";
            String thissubcategory = "";
            
            String currentcategory = request.getParameter("category");
            if (currentcategory != null && !currentcategory.isEmpty()){
                thiscategory = currentcategory;
            }
            
            String currentsubcategory = request.getParameter("subcategory");
            if (currentsubcategory != null && !currentsubcategory.isEmpty()){
                thissubcategory = currentsubcategory;
            }
            
            if (currentshownumber != null && !currentshownumber.isEmpty()) {
                try {
                    shownumber = Integer.parseInt(currentshownumber);
                } catch (NumberFormatException e) {
                    // Handle the case when the parameter is not a valid integer
                    // You can set an error message or perform appropriate error handling
                }
            }      
            String currentorder = request.getParameter("order");
            if (currentorder !=null && !currentshownumber.isEmpty()){
                order = currentorder;
            }
        
            String currentPageParam = request.getParameter("page");
            if (currentPageParam != null && !currentPageParam.isEmpty()) {
                try {
                    currentPage = Integer.parseInt(currentPageParam);
                } catch (NumberFormatException e) {
                    // Handle the case when the parameter is not a valid integer
                    // You can set an error message or perform appropriate error handling
                }
            }

            int pagesToShow = Math.min(maxVisiblePages, totalPages); // Number of page links to show

            // Calculate the start and end page numbers for the current subset
            int startPage = Math.max(currentPage - (pagesToShow / 2), 1);
            int endPage = Math.min(startPage + pagesToShow - 1, totalPages);
        %>
        
        
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
        <%@ include file="Header.jsp" %>
        



        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <a class="breadcrumb-item text-dark" href="#">Shop</a>
                        <span class="breadcrumb-item active">Shop List</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Shop Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">


                <!-- Shop Product Start -->
                <div class="col-lg-12 col-md-8">
                    <div class="row pb-3">
                        <!--Sorting Start-->
                        <div class="col-12 pb-1">
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <!--                            <div>
                                                                <button class="btn btn-sm btn-light"><i class="fa fa-th-large"></i></button>
                                                                <button class="btn btn-sm btn-light ml-2"><i class="fa fa-bars"></i></button>
                                                            </div>-->
                                <div class="ml-2">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sorting</button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <!--                                        <a class="dropdown-item" href="#">Latest</a>-->
                                            <!--<a class="dropdown-item" href="#">Popularity</a>-->
                                            <a class="dropdown-item" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=<%=shownumber%>&page=<%= 1 %>&order=asc">Price Ascending</a>

                                            <a class="dropdown-item" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=<%=shownumber%>&page=<%= 1 %>&order=des">Price Descending</a>
                                        </div>
                                    </div>
                                    <div class="btn-group ml-2">
                                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Showing</button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=10&page=<%= currentPage %>&order=<%= order %>">10</a>
                                            <a class="dropdown-item" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=20&page=<%= currentPage %>&order=<%= order %>">20</a>
                                            <a class="dropdown-item" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=30&page=<%= currentPage %>&order=<%= order %>">30</a>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--Sorting End-->
                        <c:forEach items="${list}" var="p">
                            <div class="col-lg-3 col-md-6 col-sm-6 pb-1">
                                <div class="product-item bg-light mb-4">
                                    <div class="product-img position-relative overflow-hidden">
                                            <img class="img-fluid w-100" src="client/${p.imageURL}" alt="">
                                        <div class="product-action">
                                            <a class="btn btn-outline-dark btn-square checkcart" href="javascript:void(0);" onclick='addToCart("<c:out value="${p.productName}"/>", "<c:out value="${p.getSalePrice()}"/>", "<c:out value="${p.productID}"/>", "<c:out value="${p.getStock()}"/>")'>
                                                <i class="fa fa-shopping-cart"></i>
                                            </a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                            <a class="btn btn-outline-dark btn-square" href="Detail/${p.getProductcode()}"><i class="fa fa-search"></i></a>
                                            <form data-product-id="${p.productID}" method="get" action="addToCartController">
                                            <input type="hidden" name="productName" value="<c:out value="${p.productName}"/>">
                                            <input type="hidden" name="productID" value="<c:out value="${p.productID}"/>">
                                            <input type="hidden" name="salePrice" value="<c:out value="${p.getSalePrice()}"/>">
                                            <input type="hidden" name="page" value="shop">
                                            </form>
                                            <!--<a class="btn btn-outline-dark btn-square" href="productDetail?id=${p.productID}"><i class="fa fa-shopping-cart"></i></a>-->
                                        </div>
                                    </div>
                                    <div class="text-center py-4">
                                        <a class="h6 text-decoration-none text-truncate" href="Detail/${p.getProductcode()}">${p.productName}</a>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h5>${p.getSalePrice()}</h5>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-center mt-2">
                                            <h9 class="text-muted ml-2"><del>${p.getUnitPriceFixed()} d</del></h9>
                                        </div>

                                        <!--                                <div class="d-flex align-items-center justify-content-center mb-1">
                                                                            <small class="fa fa-star text-primary mr-1"></small>
                                                                            <small class="fa fa-star text-primary mr-1"></small>
                                                                            <small class="fa fa-star text-primary mr-1"></small>
                                                                            <small class="fa fa-star text-primary mr-1"></small>
                                                                            <small class="fa fa-star text-primary mr-1"></small>
                                                                            <small>(99)</small>
                                                                        </div>-->
                                    </div>
                                </div>
                            </div>
                        </c:forEach>


                        <div class="col-12">

                            <nav>
                                <ul class="pagination justify-content-center">
                                    <!--<li class="page-item disabled"><a class="page-link" href="#2">Previous</span></a></li>-->
                                    <% if (currentPage == 1) { %>
                                    <li class="page-item disabled"><a class="page-link" href="#2">Previous</span></a></li>                            
                                        <% } else { %>                           
                                    <li class="page-item"><a class="page-link" href="#2">Previous</span></a></li>                          
                                        <% } %>                           
                                        <% if (startPage > 1) { %>
                                    <li class="page-item">
                                        <a class="page-link" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=<%= shownumber %>&page=<%= startPage - 1 %>&order=<%= order %>">...</a>
                                    </li>
                                    <% } %>                                                
                                    <% for (int i = startPage; i <= endPage; i++) { %>
                                    <li class="page-item <%= (i == currentPage) ? "active" : "" %>">
                                        <a class="page-link" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=<%= shownumber %>&page=<%= i %>&order=<%= order %>"><%= i %></a>
                                    </li>
                                    <% } %>
                                    <% if (endPage < totalPages) { %>
                                    <li class="page-item">
                                        <a class="page-link" href="/GasStove/productController?category=<%= thiscategory %>&subcategory=<%= thissubcategory %>&shownumber=<%= shownumber %>&page=<%= endPage + 1 %>&order=<%= order %>">...</a>
                                    </li>
                                    <% } %>                            
                                    <% if (currentPage == totalPages) { %>
                                    <li class="page-item disabled"><a class="page-link" href="#2">Next</span></a></li>                           
                                        <% } else { %>                          
                                    <li class="page-item"><a class="page-link" href="#2">Next</span></a></li>
                                        <% } %>
                                </ul>

                            </nav>
                        </div>
                    </div>
                </div>
                <!-- Shop Product End -->
            </div>
        </div>
        <!-- Shop End -->

        <%@ include file="Footer.jsp" %>
        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="client/lib/easing/easing.min.js"></script>
        <script src="client/lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="client/mail/jqBootstrapValidation.min.js"></script>
        <script src="client/mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="client/js/main.js"></script>
        <script>
                                    function redirectToLink(checkboxId, link) {
                                        var checkbox = document.getElementById(checkboxId);
                                        if (checkbox.checked) {
                                            window.location.href = link;
                                        }
                                    }
        </script>
        <script>
            // H�m g?i y�u c?u AJAX ?? l?y g?i � t?
            function showSuggestions(keyword) {
                var suggestionsList = document.querySelector('.suggestions-list');

                // X�a g?i � c?
                suggestionsList.innerHTML = '';

                          if (keyword.trim() === '') {
                              return;
                          }

                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        var suggestions = JSON.parse(this.responseText);
//                        var suggestionsList = document.querySelector('.suggestions-list');

                        // X�a g?i � c?
                        suggestionsList.innerHTML = '';

                        // Hi?n th? g?i � t?
                        suggestions.forEach(function (suggestion) {
                            var li = document.createElement('li');
                            li.textContent = suggestion;
                            suggestionsList.appendChild(li);
                        });
                    }
                };
                xhttp.open("GET", "/GasStove/searchProduct?keyword=" + keyword, true);
                xhttp.send();
            }

            document.addEventListener('click', function (event) {
                var clickedElement = event.target;
                if (clickedElement.tagName === 'LI') {
                    var searchBox = document.querySelector('.form-control');
                    searchBox.value = clickedElement.textContent;
//                    window.location.href = "/GasStove/productDetail?name=" +  clickedElement.textContent;
                    
                    // X�a danh s�ch g?i �
                    document.querySelector('.suggestions-list').innerHTML = '';
                }
            });
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
        
<script>
$(document).ready(function() {
    $('.dropdown').hover(function() {
        $(this).addClass('show');
        $(this).find('.dropdown-menu').addClass('show');
    }, function() {
        $(this).removeClass('show');
        $(this).find('.dropdown-menu').removeClass('show');
    });
});
</script>
<script>
    function addToCart(productName, salePrice, productID, stock) {
        
        console.log(productName);
        console.log(salePrice);
        console.log(productID);
        var forms = document.querySelectorAll('form');
        console.log(forms.prototype)
        var form;
        for (var i = 0; i < forms.length; i++) {
          if (forms[i].getAttribute('data-product-id') === productID) {
            form = forms[i];
            break;
          }
        }
        form.querySelector('input[name="productName"]').value = productName;
        form.querySelector('input[name="salePrice"]').value = salePrice
        form.submit();
        console.log("cau khac di")
    }
</script>
    </body>

</html>