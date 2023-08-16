<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modernize Free</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css"/>
        <style>
            .container {
                /*position: relative;*/
                width: 650px;
                height: 400px;
                background: #fff;
                display: flex;
                align-items: center;
                justify-content: center;
                border: 5px solid rgb(244, 254, 255);
            }
            #lens {
                position: absolute;
                border: 2px solid grey;
                border-radius: 50%;
                overflow: hidden;
                cursor: none;
                box-shadow: inset 0 0 10px 2px grey;
                filter: drop-shadow(0 0 2px grey);
                /*                z-index: 9999;*/
            }
            #zoom img{
                width: 650px;
                height: 400px;
            }
            #lens > * {
                cursor: none;
            }

            @media (max-height: 600px) {
                #zoom img, .container{
                    width: 520px;
                    height: 330px;
                }
            }

        </style>
    </head>

    <body>

        <!--  Body Wrapper -->
        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
             data-sidebar-position="fixed" data-header-position="fixed">
            <!--             Sidebar Start 
                        <aside class="left-sidebar">
                             Sidebar scroll
                            <div>
                                <div class="brand-logo d-flex align-items-center justify-content-between">
                                    <a href="./index.html" class="text-nowrap logo-img">
                                        <img src="/GasStove/admin/images/logos/dark-logo.svg" width="180" alt="" />
                                    </a>
                                    <div class="close-btn d-xl-none d-block sidebartoggler cursor-pointer" id="sidebarCollapse">
                                        <i class="ti ti-x fs-8"></i>
                                    </div>
                                </div>
                                 Sidebar navigation
                                <nav class="sidebar-nav scroll-sidebar" data-simplebar="">
                                    <ul id="sidebarnav">
                                        <li class="nav-small-cap">
                                            <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                            <span class="hide-menu">Home</span>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="/GasStove/admin/dashboard.jsp" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-layout-dashboard"></i>
                                                </span>
                                                <span class="hide-menu">Dashboard</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./customers.jsp" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-users"></i>
                                                </span>
                                                <span class="hide-menu">Customer</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="productController" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-list-details"></i>
                                                </span>
                                                <span class="hide-menu">Products</span>
                                            </a>
                                        </li>    
                                        <li class="nav-small-cap">
                                            <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                            <span class="hide-menu">UI COMPONENTS</span>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./ui-buttons.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-article"></i>
                                                </span>
                                                <span class="hide-menu">Buttons</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./ui-alerts.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-alert-circle"></i>
                                                </span>
                                                <span class="hide-menu">Alerts</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./ui-card.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-cards"></i>
                                                </span>
                                                <span class="hide-menu">Card</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./ui-forms.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-file-description"></i>
                                                </span>
                                                <span class="hide-menu">Forms</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./ui-typography.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-typography"></i>
                                                </span>
                                                <span class="hide-menu">Typography</span>
                                            </a>
                                        </li>
                                        <li class="nav-small-cap">
                                            <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                            <span class="hide-menu">AUTH</span>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./authentication-login.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-login"></i>
                                                </span>
                                                <span class="hide-menu">Login</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./authentication-register.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-user-plus"></i>
                                                </span>             
                                                <span class="hide-menu">Register</span>
                                            </a>
                                        </li>
                                        <li class="nav-small-cap">
                                            <i class="ti ti-dots nav-small-cap-icon fs-4"></i>
                                            <span class="hide-menu">EXTRA</span>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./icon-tabler.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-mood-happy"></i>
                                                </span>
                                                <span class="hide-menu">Icons</span>
                                            </a>
                                        </li>
                                        <li class="sidebar-item">
                                            <a class="sidebar-link" href="./sample-page.html" aria-expanded="false">
                                                <span>
                                                    <i class="ti ti-aperture"></i>
                                                </span>
                                                <span class="hide-menu">Sample Page</span>
                                            </a>
                                        </li>
                                    </ul>
                                    <div class="unlimited-access hide-menu bg-light-primary position-relative mb-7 mt-5 rounded">
                                        <div class="d-flex">
                                            <div class="unlimited-access-title me-3">
                                                <h6 class="fw-semibold fs-4 mb-6 text-dark w-85">Upgrade to pro</h6>
                                                <a href="https://adminmart.com/product/modernize-bootstrap-5-admin-template/" target="_blank" class="btn btn-primary fs-2 fw-semibold lh-sm">Buy Pro</a>
                                            </div>
                                            <div class="unlimited-access-img">
                                                <img src="/GasStove/admin/images/backgrounds/rocket.png" alt="" class="img-fluid">
                                            </div>
                                        </div>
                                    </div>
                                </nav>
                                 End Sidebar navigation 
                            </div>
                             End Sidebar scroll
                        </aside>
                          Sidebar End -->
            <!--  Main wrapper -->
            <!--<div class="body-wrapper">-->
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
                                        <a href="./authentication-login.html" class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
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
                        <div class="card-body border-top">
                            <form action="/GasStove/Detail" method="post" enctype="multipart/form-data">


                                <div class="row">

                                    <div class="mb-3">
                                        <label for="inputcom" class="control-label col-form-label">Product ID: ${product.productID}</label>
                                        <input type="hidden" name="id" class="form-control" value="${product.productID}">
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-12">
                                        <div class="mb-3">
                                            <label for="inputcom" class="control-label col-form-label">Product Name</label>
                                            <input type="text" name="name" class="form-control" value="${product.productName}" >
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-12">
                                        <div class="mb-3">
                                            <label for="inputcom" class="control-label col-form-label">Model</label>
                                            <input type="text" name="model" class="form-control" value="${product.modelNumber}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="mb-3">
                                            <label class="control-label col-form-label">Category</label>
                                            <select class="form-select" name="category">
                                                <c:forEach items="${categories}" var="c">
                                                    <option>${c.getSubCategoryName()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="mb-3">
                                            <label class="control-label col-form-label">Brand</label>
                                            <select class="form-select" name="brand">
                                                <c:forEach items="${brands}" var="b">
                                                    <option>${b}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="mb-3">
                                            <label for="inputcom" class="control-label col-form-label">Price (VND)</label>
                                            <input type="text" class="form-control" name="price" value="${product.getUnitPrice()}">
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="mb-3">
                                            <label for="inputcom" class="control-label col-form-label">Sale Off (%)</label>
                                            <input type="text" class="form-control" name="sale" value="${product.getSaleoffPercent()}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 col-md-6">
                                        <div class="mb-3">
                                            <label for="inputcom" class="control-label col-form-label">Add Stock(current: ${product.getStock()})</label>
                                            <input aria-label="quantity" class="form-control" max="999" min="0" name="stock" type="number" value="0">

                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-md-6">
                                        <div class="mb-3">
                                            <label for="inputcom" class="control-label col-form-label">Warranty Period</label>
                                            <input type="text" class="form-control" name="warranty" value="${product.getWarrantyPeriod()}">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <!--<a class="sidebar-link has-arrow active" href="#" aria-expanded="false">-->
                                    <div class="col-sm-12 col-md-4">
                                        <div class="mb-3">
                                            <label class="control-label col-form-label">Add Image File</label>
                                            <div class="input-group flex-nowrap">
                                                <div class="custom-file">
                                                    <input type="file" class="form-control" id="inputGroupFile01" name="imagefile">
                                                    <br>
                                                    <button type="button" class="btn btn-danger rounded-pill text-white" id="addImageButton">Add</button>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="imageList" id="imageList">
                                                <c:forEach items="${product.getImageURLs()}" var="p"  varStatus="loop">                                                    
                                                    <span id="imageSpan-${loop.index + 1}">
                                                        <img src="../client/${p}" alt="Image" width="80" height="60" onclick="changeZoomImage('${p}')">
                                                        <button type="button" class="btn-close" aria-label="Close" onclick="confirmDelete('${loop.index + 1}')"></button>
                                                    </span>
                                                </c:forEach>

                                            </div>

                                        </div>

                                    </div>

                                    <!--<span class="hide-menu">Forgot Password</span>-->
                                    <!--</a>-->
                                    <div class="col-sm-12 col-md-4">
                                        <div class="mb-3">
                                            <div class="container">

                                                <div id="zoom">
                                                    <img src="../client/${product.getImageURL()}" alt="" id="zoomedImg">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-12">

                                    </div>
                                    <div class="col-12">
                                        <div class="mb-3">
                                            <label class="control-label col-form-label">Description</label>
                                            <textarea class="form-control" aria-label="With textarea" name="description" style="height: 400px">${product.getDescription()}</textarea>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <div class="card-body border-top">
                                            <button type="submit" class="btn btn-success rounded-pill px-4">
                                                <div class="d-flex align-items-center">
                                                    <i class="ti ti-device-floppy me-1 fs-4"></i>
                                                    Save
                                                </div>
                                            </button>
                                            <button type="button" class="btn btn-danger rounded-pill px-4 ms-2 text-white" onclick="redirectToController()">
                                                Cancel
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>

            </div>
            <!--</div>-->
        </div>
    </div>
    <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>
    <script src="/GasStove/admin/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/GasStove/admin/js/sidebarmenu.js"></script>
    <script src="/GasStove/admin/js/app.min.js"></script>
    <script src="/GasStove/admin/libs/simplebar/dist/simplebar.js"></script>
    <script src="/GasStove/admin/js/editing.js"></script>
    <script src="/GasStove/ckeditor/ckeditor/ckeditor.js"></script>

    <script>
        function confirmDelete(loopindex) {
            const confirmation = confirm('Are you sure you want to delete this image?');
            if (confirmation) {
              deleteSpan(loopindex);
            }
          }

        function deleteSpan(loopindex) {
          const spanId = `imageSpan-${loopindex}`;
          const spanElement = document.getElementById(spanId);
          if (spanElement) {
            spanElement.remove();
            console.log('Span deleted:', spanId);
          }
        }
        </script>
    <script>
                                                document.addEventListener('DOMContentLoaded', function () {
                                                    var fileInput = document.getElementById('inputGroupFile01');
                                                    var addButton = document.getElementById('addImageButton');
                                                    var imageList = document.getElementById('imageList');

                                                    addButton.addEventListener('click', function () {
                                                        var newSpan = document.createElement('span');
                                                        var newImage = document.createElement('img');
                                                        newImage.src = URL.createObjectURL(fileInput.files[0]);
                                                        newImage.alt = 'Image';
                                                        newImage.width = 80;
                                                        newImage.height = 60;
                                                        newImage.onclick = function () {
                                                            changeZoomImage(newImage.src);
                                                        };
                                                        var newButton = document.createElement('button');
                                                        newButton.type = 'button';
                                                        newButton.className = 'btn-close';
                                                        newButton.setAttribute('aria-label', 'Close');
                                                        newSpan.appendChild(newImage);
                                                        newSpan.appendChild(newButton);
                                                        imageList.appendChild(newSpan);
                                                        fileInput.value = '';
                                                    });
                                                });
    </script>

    <script>
        var editor = '';
        $(document).ready(function () {
            //logic 
            editor = CKEDITOR.replace('description');
        });
        function redirectToController() {
            window.location.href = "/GasStove/productController";
        }
    </script>
    <script>

        const lensSize = 200;

        function magnify(id, zoom) {
//            var picture = document.querySelector('.carousel-item.active img');

            const el = document.getElementById(id);
            let lens = null;
            let copy = null;

            function createLens() {
                lens = document.createElement("div");
                lens.setAttribute("id", "lens");
                lens.style.width = lensSize + "px";
                lens.style.height = lensSize + "px";

                // Position the lens inside the container
                lens.style.position = "absolute";
                lens.style.left = "50%"; // Adjust left position as needed
                lens.style.top = "50%"; // Adjust top position as needed
                lens.style.transform = "translate(-50%, -50%)"; // Center the lens

                el.appendChild(lens);
                el.getBoundingClientRect();

                copy = el.cloneNode(true);
                copy.style.zoom = zoom;
                lens.appendChild(copy);

                copy.style.width = el.offsetWidth * zoom + "px";
                copy.style.height = el.offsetHeight * zoom + "px";
                copy.style.position = "absolute";
            }

            function updateLens() {
                if (lens) {
                    el.removeChild(lens);
                    lens = null;
                    copy = null;
                }

                createLens();
            }

            el.addEventListener("mousemove", (ev) => {
                ev.preventDefault();
                ev.stopPropagation();

                if (!lens) {
                    createLens();
                }

                const pos = getCursorPos(ev);
                lens.style.left = pos.x - 100 + "px";
                lens.style.top = pos.y - 100 + "px";
                copy.style.left = -(pos.x - el.offsetLeft) + (lensSize / zoom) * 0.5 + "px";
                copy.style.top = -(pos.y - el.offsetTop) + (lensSize / zoom) * 0.5 + "px";
            });

            el.addEventListener("mouseout", () => {
                if (lens) {
                    el.removeChild(lens);
                    lens = null;
                    copy = null;
                }
            });

            // Function to update the lens and copy when the image changes


            return {updateZoomedImage};
        }


        function getCursorPos(e) {
            var x = (window.Event) ? e.pageX : event.clientX + (document.documentElement.scrollLeft ? document.documentElement.scrollLeft : document.body.scrollLeft);
            var y = (window.Event) ? e.pageY : event.clientY + (document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop);
            return {x: x, y: y};
        }

        const zoom = magnify("zoom", 4);
    </script>

    <script>
        function changeZoomImage(imageUrl) {
            var zoomedImg = document.getElementById('zoomedImg');
            zoomedImg.src = '../client/' + imageUrl;
            zoom.updateZoomedImage("new_image_url.jpg");
            updatelens();
        }
    </script>
</body>

</html>