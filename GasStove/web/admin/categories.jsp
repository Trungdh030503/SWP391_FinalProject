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
            function back() {
                window.location.href = "home";
            }
            function doDelete(id)
            {
                var c = confirm("Do you want to delete this category?");
                if (c)
                {
                    window.location.href = "/GasStove/delete?CategoryID=" + id;
                }
//                else
//                {
//                    window.location.href = "/GasStove/categoryController"
//                }
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
                                <!--Add category-->
                                <a href="#!" class="btn btn-primary"  data-bs-toggle="modal" data-bs-target="#addcategory">
                                    Add Category
                                </a>

                                <div id="addcategory" class="modal fade" tabindex="-1" aria-labelledby="bs-example-modal-md" style="display: none;" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <form action="addCategory" method="post">
                                            <div class="modal-content">
                                                <div class="modal-header d-flex align-items-center">
                                                    <h4 class="modal-title" id="myModalLabel">
                                                        Add category
                                                    </h4>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="card-body border-top">

                                                        <div class="row">
                                                            <div class="col-sm-12 col-md-6">

                                                                <label for="inputcom" class="control-label col-form-label">Subcategory Name</label>
                                                                <input list="categories" name="categoryname" class="form-control">
                                                                <datalist id="categories">
                                                                    <c:forEach items="${list}" var="cs">
                                                                        <option value="${cs.get(0).categoryName}">
                                                                    </c:forEach>
                                                                </datalist>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-12 col-md-6">
                                                                <div class="mb-3">
                                                                    <label for="inputcom" class="control-label col-form-label">Subcategory Name</label>
                                                                    <input type="text" class="form-control" name="SubCategoryName">
                                                                </div>
                                                            </div>
                                                        </div>


                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-light-success text-danger font-medium waves-effect">
                                                        Save
                                                    </button>
                                                    <button type="button" class="btn btn-light-danger text-danger font-medium waves-effect" data-bs-dismiss="modal">
                                                        Close
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>

                                <br><br>
                                <div class="table-responsive">

                                    <table class="table text-start align-middle table-bordered table-hover mb-0">
                                        <thead>
                                            <tr class="text-dark">
                                                <th scope="col">Category ID</th>
                                                <th scope="col">Category Name</th>
                                                <th scope="col">Subcategory Name</th>
                                                <th scope="col">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach items="${clist}" var="cs">
                                                <tr>
                                                    <td>${cs.getCategoryID()}</td>
                                                    <td id="categoryname-${cs.getCategoryID()}" style="position: relative;">
                                                        <span>${cs.getCategoryName()}</span>
                                                    </td>
                                                    <td id="subcategory-${cs.getCategoryID()}" style="position: relative;">
                                                        <span>${cs.getSubCategoryName()}</span>

                                                    </td>
                                                    <td>
                                                        <a href="/GasStove/editCategory?id=${cs.getCategoryID()}" class="btn btn-ghost btn-icon btn-sm rounded-circle texttooltip" data-template="editTwo" >
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-edit icon-xs"><path d="M11 4H4a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7"></path><path d="M18.5 2.5a2.121 2.121 0 0 1 3 3L12 15l-4 1 1-4 9.5-9.5z"></path></svg>
                                                            <div id="editTwo" class="d-none">
                                                                <span>Edit</span>
                                                            </div>
                                                        </a>
                                                        <a href="" class="btn btn-ghost btn-icon btn-sm rounded-circle texttooltip" data-template="trashThree" onclick="doDelete()">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash-2 icon-xs"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>
                                                            <div id="trashThree" class="d-none">
                                                                <span>Delete</span>
                                                            </div>
                                                        </a>
                                                    </td>
                                                </tr>

                                            </c:forEach>




                                        </tbody>
                                    </table>



                                </div>
                                <br>
                                <br>

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
                                                            function editsub(categoryID) {
                                                                const subcategoryElement = document.getElementById('subcategory-' + categoryID);

                                                                subcategoryElement.contentEditable = !subcategoryElement.isContentEditable;
                                                                subcategoryElement.focus();
                                                            }
    </script>
    <script>
        function filterFunction() {
            var input, filter, ul, li, a, i;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            div = document.getElementById("myDropdown");
            a = div.getElementsByTagName("a");
            for (i = 0; i < a.length; i++) {
                txtValue = a[i].textContent || a[i].innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    a[i].style.display = "";
                } else {
                    a[i].style.display = "none";
                }
            }
        }
    </script>
    <script>
        // Hàm g?i yêu c?u AJAX ?? l?y g?i ý t?
        function showSuggestions(keyword) {
            var suggestionsList = document.querySelector('.suggestions-list');

            // Xóa g?i ý c?
            suggestionsList.innerHTML = '';

            if (keyword.trim() === '') {
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var suggestions = JSON.parse(this.responseText);
//                        var suggestionsList = document.querySelector('.suggestions-list');

                    // Xóa g?i ý c?
                    suggestionsList.innerHTML = '';

                    // Hi?n th? g?i ý t?
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

                // Xóa danh sách g?i ý
                document.querySelector('.suggestions-list').innerHTML = '';
            }
        });
    </script>

    <script>
        $(document).ready(function () {
            $('.dropdown').hover(function () {
                $(this).addClass('show');
                $(this).find('.dropdown-menu').addClass('show');
            }, function () {
                $(this).removeClass('show');
                $(this).find('.dropdown-menu').removeClass('show');
            });
        });
    </script>
</body>

</html>