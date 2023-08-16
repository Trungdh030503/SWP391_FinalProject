<%-- 
    Document   : editCustomers
    Created on : May 23, 2023, 3:42:46 PM
    Author     : krikn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="admin/css/edit.css">
    </head>
    <body>

        <form action="updateNew" method="post" enctype="multipart/form-data">
            <div class="container-xl px-4 mt-4">
                <!-- Account page navigation-->
                <hr class="mt-0 mb-4">
                <div class="row">
                    <div class="col-xl-4">
                        <!-- Profile picture card-->

                        <div class="card mb-4 mb-xl-0">
                            <div class="card-header">Image Picture</div>
                            <div class="card-body text-center">
                                <!-- Profile picture image-->
                                <img src="newImage/${news.imageURL}" width="300" alt=""/>
                                <!-- Profile picture upload button-->

                            </div>
                        </div>
                    </div>
                    <div class="col-xl-8">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="card-header" >Edit New</div>
                            <div class="card-body">
                                <!-- Form Group (username)-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->
                                    <div class="col-md-5">
                                        <label  class="fw-bold" for="inputFirstName">Type</label>
                                        <input class="form-control" name="type" type="text" value="${news.type}">
                                    </div>
                                    <!-- Form Group (last name)-->
                                    <div class="col-md-7">
                                        <label class="fw-bold" for="inputLastName">Title</label>
                                        <input class="form-control" name="title" type="text"  value="${news.title}" >
                                    </div>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">

                                    <div class="col-md-4">
                                        <label class="fw-bold" for="inputFirstName">Sale Percent</label>
                                        <input class="form-control" name="salePercent" type="text"  value="${news.salePercent}">
                                    </div>

                                    <div class="col-md-4">
                                        <label class="fw-bold" for="inputFirstName">Product ID</label>
                                        <input class="form-control" name="productID" type="text"  value="${news.productID}">
                                    </div>

                                    <div class="col-md-4">
                                        <label class="fw-bold" for="inputFirstName">Category ID</label>
                                        <input class="form-control" name="categoryID" type="text"  value="${news.categoryID}">
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label class="fw-bold" >Image URL</label>
                                    <div class="custom-file">
                                        <input type="file" class="form-control" id="inputGroupFile01" name="Avatar" value="${news.imageURL}" >
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label class="control-label col-form-label">Description</label>
                                    <textarea class="form-control" aria-label="With textarea" name="description" style="height: 400px">${news.description}</textarea>
                                </div>

                                <input class="btn btn-primary" type="submit" value="Edit">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form> 

        <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>
        <script src="/GasStove/admin/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="/GasStove/admin/js/sidebarmenu.js"></script>
        <script src="/GasStove/admin/js/app.min.js"></script>
        <script src="/GasStove/admin/libs/simplebar/dist/simplebar.js"></script>
        <script src="/GasStove/admin/js/editing.js"></script>                         
        <script src="/GasStove/ckeditor/ckeditor/ckeditor.js"></script>                          
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


    </body>
</html>