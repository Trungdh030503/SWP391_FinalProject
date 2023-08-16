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
        <style>
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                min-width: 1000px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 15px;
                background: #FFA54E;
                color: #fff;
                padding: 16px 30px;
                min-width: 100%;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }
        </style>

        <form action="../addNew" method="post" enctype="multipart/form-data">
            <div class="container-xl px-4 mt-4">
                <!-- Account page navigation-->
                <hr class="mt-0 mb-4">

                <div class="row">
                    <!--                    <div class="col-xl-4">
                                             Profile picture card
                    
                                            <div class="card mb-4 mb-xl-0">
                                                <div class="card-header">Image Picture</div>
                                                <div class="card-body text-center">
                                                     Profile picture image
                                                    <img  width="300" alt=""/>
                                                     Profile picture upload button
                    
                                                </div>
                                            </div>
                                        </div>-->
                    <div class="col-xl-">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="table-wrapper">
                                <div class="table-title">
                                    <h4>Manage <b>New</b></h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <!-- Form Group (username)-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->
                                    <div class="col-md-5">
                                        <label  class="fw-bold" for="inputFirstName">Type</label>
                                        <input class="form-control" name="type" type="text" placeholder="Type">
                                    </div>
                                    <!-- Form Group (last name)-->
                                    <div class="col-md-7">
                                        <label class="fw-bold" for="inputLastName">Title</label>
                                        <input class="form-control" name="title" type="text"  placeholder="Title" >
                                    </div>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">

                                    <div class="col-md-4">
                                        <label class="fw-bold" for="inputFirstName">Sale Percent</label>
                                        <input class="form-control" name="salePercent" type="text"  placeholder="Sale Percent">
                                    </div>

                                    <div class="col-md-4">
                                        <label class="fw-bold" for="inputFirstName">Product ID</label>
                                        <input class="form-control" name="productID" type="text"  placeholder="Product ID">
                                    </div>

                                    <div class="col-md-4">
                                        <label class="fw-bold" for="inputFirstName">Category ID</label>
                                        <input class="form-control" name="categoryID" type="text"  placeholder="Category ID">
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label class="fw-bold" >Image URL</label>
                                    <div class="custom-file">
                                        <input type="file" class="form-control" id="inputGroupFile01" name="Avatar">
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label class="control-label col-form-label">Description</label>
                                    <textarea class="form-control" aria-label="With textarea" name="description" style="height: 400px"></textarea>
                                </div>

                                <input type="submit" value="Add">
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

        </script>


    </body>
</html>