<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css"/>
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
        </style>
    </head>

    <body>
        <%
        int totalPages = 100; // Total number of pages
        int currentPage = 1;
        int maxVisiblePages = 5; // Maximum number of visible page links
        int shownumber = 9;
        
        String currentshownumber = request.getParameter("shownumber");
        if (currentshownumber != null && !currentshownumber.isEmpty()) {
            try {
                shownumber = Integer.parseInt(currentshownumber);
            } catch (NumberFormatException e) {
                // Handle the case when the parameter is not a valid integer
                // You can set an error message or perform appropriate error handling
            }
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
                                <form action="searchProduct" method="post">                                            
                                    <div class="row gx-3 mb-3">
                                        <div class="col-md-8">
                                            <h5 class="card-title fw-semibold mb-4">Products</h5>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="input-group">
                                                <!--<input type="text" name="search" class="form-control rounded" placeholder="Search"/>-->
                                                <input type="text" class="form-control rounded" name="Search" placeholder="Search" onkeyup="showSuggestions(this.value)">
                                                <ul class="suggestions-list"></ul>
                                            </div>
                                        </div>
                                        <div class="col-md-1" >
                                            <input class="btn btn-primary" type="submit" value="Search">
                                        </div>
                                    </div>
                                    
<!--                                    <div class="search-container">
                                        <div class="suggestions-container">
                                            <input type="text" class="search-box" name="Search" placeholder="Search" onkeyup="showSuggestions(this.value)">
                                            <ul class="suggestions-list"></ul>
                                        </div>
                                    </div>-->
                                </form>
                                <a href="/GasStove/addProduct" class="btn btn-primary" data-template="editTwo" >
                                    Add Product
                                </a>
                                    <br><br>
                                <div class="table-responsive">
                                    <table class="table text-start align-middle table-bordered table-hover mb-0">
                                        <thead>
                                            <tr class="text-dark">
                                                <th scope="col">Product Name</th>
                                                <th scope="col">Category</th>
                                                <th scope="col">Brand</th>
                                                <th scope="col">Price</th>
                                                <th scope="col">Stock</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${list}" var="p">
                                                <tr>
                                                    <td>${p.productName}</td>
                                                    <td>${p.categoryID}</td>
                                                    <td>${p.brand}</td>
                                                    <td>


                                                        <h6 class="fs-4 fw-semibold mb-0">${p.getSalePrice()}</h6>
                                            <h7 class="fs-4 fw-semibold mb-0 text-muted"> <del>${p.getUnitPrice()}</del></h7>
                                            </td>
                                            <td>${p.getStock()}</td>

                                            <td class="" style="">
                                                <a href="#!" class="btn btn-ghost btn-icon btn-sm rounded-circle texttooltip" data-template="eyeThree" data-bs-toggle="modal" data-bs-target="#product-${p.productID}">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-eye icon-xs"><path d="M1 12s4-8 11-8 11 8 11 8-4 8-11 8-11-8-11-8z"></path><circle cx="12" cy="12" r="3"></circle></svg>

                                                    <div id="eyeThree" class="d-none">
                                                        <span>View</span>
                                                    </div>


                                                </a>
                                                <div id="product-${p.productID}" class="modal fade" tabindex="-1" aria-labelledby="bs-example-modal-md" style="display: none;" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header d-flex align-items-center">
                                                                <h4 class="modal-title" id="myModalLabel">
                                                                    View Image
                                                                </h4>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <img class="img-fluid w-100" src="client/${p.getImageURL()}" alt="">
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-light-danger text-danger font-medium waves-effect" data-bs-dismiss="modal">
                                                                    Close
                                                                </button>
                                                            </div>
                                                        </div>
                                                        <!-- /.modal-content -->
                                                    </div>
                                                    <!-- /.modal-dialog -->
                                                </div>
                                                <a href="Detail/${p.getProductcode()}" class="btn btn-ghost btn-icon btn-sm rounded-circle texttooltip" data-template="editTwo" >
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit icon-xs"><path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path><path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path></svg>
                                                    <div id="editTwo" class="d-none">
                                                        <span>Edit</span>
                                                    </div>
                                                </a>
                                                <a href="addCoupon?productID=${p.getProductID()}" class="btn btn-ghost btn-icon btn-sm rounded-circle texttooltip" data-template="addThree" >
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-activity"><line x1="12" y1="5" x2="12" y2="19"></line><line x1="5" y1="12" x2="19" y2="12"></line></svg>
                                                    <div id="addThree" class="d-none">
                                                        <span>Edit</span>
                                                    </div>
                                                </a>
<!--                                                <a href="#!" class="btn btn-ghost btn-icon btn-sm rounded-circle texttooltip" data-template="trashThree" data-bs-toggle="modal" data-bs-target="#add-${p.productID}">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash-2 icon-xs"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>
                                                    <div id="trashThree" class="d-none">
                                                        <span>Add</span>
                                                    </div>
                                                </a>-->
<!--                                                <div id="add-${p.productID}" class="modal fade" tabindex="-1" aria-labelledby="bs-example-modal-md" style="display: none;" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header d-flex align-items-center">
                                                                <h4 class="modal-title" id="myModalLabel">
                                                                    Add Stock
                                                                </h4>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Submit"></button>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                Do you want to add stock?
                                                            </div>
                                                            <div class="modal-footer">
                                                                <a href="addStockProduct?id=${p.productID}" class="btn btn-primary">Confirm</a>

                                                                <button type="button" class="btn btn-light-danger text-danger font-medium waves-effect" data-bs-dismiss="modal">
                                                                    Close
                                                                </button>
                                                            </div>
                                                        </div>
                                                         /.modal-content 
                                                    </div>
                                                     /.modal-dialog 
                                                </div>-->


                                            </td>
                                            </tr>

                                        </c:forEach>

                                        </tbody>
                                    </table>

                                </div>
                                <br>
                                <br>
                                <ul class="pagination d-flex align-items-center justify-content-center">
                                    <% if (currentPage == 1) { %>
                                    <li class="paginate_button page-item previous disabled" id="example_previous">
                                        <a href="#" aria-controls="example" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                                    </li>
                                    <% } else { %>   
                                    <li class="paginate_button page-item previous" id="example_previous">
                                        <a href="/GasStove/productController?shownumber=9&page=<%= currentPage - 1 %>"  aria-controls="example" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                                    </li>
                                    <% } %>                           
                                    <% if (startPage > 1) { %>           
                                    <li class="paginate_button page-item">
                                        <a href="/GasStove/productController?shownumber=9&page=<%= startPage - 1 %>" aria-controls="example" data-dt-idx="1" tabindex="0" class="page-link">...</a>
                                    </li>
                                    <% } %>                                                
                                    <% for (int i = startPage; i <= endPage; i++) { %>
                                    <li class="paginate_button page-item <%= (i == currentPage) ? "active" : "" %>">
                                        <a href="/GasStove/productController?shownumber=9&page=<%= i %>" aria-controls="example" data-dt-idx="2" tabindex="0" class="page-link"><%= i %></a>
                                    </li>
                                    <% } %>
                                    <%      if (endPage < totalPages) { %>
                                    <li class="paginate_button page-item">
                                        <a href="/GasStove/productController?shownumber=9&page=<%= endPage + 1 %>" aria-controls="example" data-dt-idx="1" tabindex="0" class="page-link">...</a>
                                    </li>
                                    <% } %>                            
                                    <% if (currentPage == totalPages) { %>
                                    <li class="paginate_button page-item next disabled" id="example_next">
                                        <a href="" aria-controls="example" data-dt-idx="3" tabindex="0" class="page-link">Next</a>
                                    </li>
                                    <% } else { %> 
                                    <li class="paginate_button page-item next" id="example_next">
                                        <a href="/GasStove/productController?shownumber=9&page=<%= currentPage + 1 %>" aria-controls="example" data-dt-idx="3" tabindex="0" class="page-link">Next</a>
                                    </li>
                                    <% } %>
                                </ul>
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
                    var searchBox = document.querySelector('.form-control rounded');
                    searchBox.value = clickedElement.textContent;
//                    window.location.href = "/GasStove/productDetail?name=" +  clickedElement.textContent;
                    
                    // X�a danh s�ch g?i �
                    document.querySelector('.suggestions-list').innerHTML = '';
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
</body>

</html>