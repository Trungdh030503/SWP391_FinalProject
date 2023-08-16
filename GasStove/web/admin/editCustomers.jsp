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
        
        <form action="listCustomer" method="post">
            <div class="container-xl px-4 mt-4">
                <!-- Account page navigation-->
                <hr class="mt-0 mb-4">
                <div class="row">
                    <div class="col-xl-4">
                        <!-- Profile picture card-->

                        <div class="card mb-4 mb-xl-0">
                            <div class="card-header">Profile Picture</div>
                            <div class="card-body text-center">
                                <!-- Profile picture image-->
                                
                                <img class="img-account-profile rounded-circle mb-2" src="https://img.freepik.com/premium-vector/men-icon-trendy-avatar-character-cheerful-happy-people-flat-vector-illustration-round-frame-male-portraits-group-team-adorable-guys-isolated-white-background_275421-280.jpg?w=2000" alt="">
                                <div class="small font-italic text-muted mb-4">${customer.firstName} ${customer.lastName}</div>
                                <!-- Profile picture upload button-->
                               
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-8">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="card-header" >Account Details</div>
                            <div class="card-body">
                                <!-- Form Group (username)-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->
                                    <div class="col-md-1">
                                        <label  class="fw-bold" for="inputFirstName">ID</label>
                                        <input class="form-control" name="id" type="text" value="${customer.customerID}" readonly required>
                                    </div>
                                     <div class="col-md-6">
                                        <label  class="fw-bold" for="inputFirstName">Username</label>
                                        <input class="form-control" name="username" type="text" value="${customer.username}" readonly required>
                                    </div>
                                    <!-- Form Group (last name)-->
                                    <div class="col-md-5">
                                        <label class="fw-bold" for="inputLastName">Password</label>
                                        <input class="form-control" name="password" type="text"  value="${customer.password}" readonly required>
                                    </div>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">

                                    <div class="col-md-6">
                                        <label class="fw-bold" for="inputFirstName">First Name</label>
                                        <input class="form-control" name="firstname" type="text"  value="${customer.firstName}"readonly required>
                                    </div>

                                    <div class="col-md-6">
                                        <label class="fw-bold" for="inputLastName">Last Name</label>
                                        <input class="form-control" name="lastname" type="text"value="${customer.lastName}"readonly required>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label class="fw-bold" >Email Address</label>
                                    <input class="form-control" name="email" type="email" value="${customer.email}"readonly required>
                                </div>

                                <div class="row gx-3 mb-3">
                                    <div class="col-md-7">
                                        <label class="fw-bold" >Phone Number</label>
                                        <input class="form-control" name="phone" type="text"  value="${customer.phoneNumber}"readonly required>
                                    </div>

                                    <div class="col-md-3">
                                        <label class="fw-bold" >Bought Count</label>
                                        <input class="form-control" name="boughtcount" type="text"  value="${customer.boughtCount}" readonly required>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <label class="fw-bold" >Address Detail</label>
                                    <input class="form-control" name="address" type="text" value="${customer.addressDetail}"readonly required>
                                </div>

                                <div class="row gx-3 mb-3">
                                    <div class="col-md-6">
                                        <label class="fw-bold" for="inputOrgName">City</label>
                                        <input class="form-control" name="city" type="text"  value="${customer.city}"readonly required>
                                    </div>

                                    <div class="col-md-6">
                                        <label class="fw-bold" for="inputLocation">District</label>
                                        <input class="form-control" name="district" type="text" value="${customer.district}"readonly required>
                                    </div>
                                </div>

                                <div class="row gx-3 mb-3">
                                    <div class="col-md-6">
                                        <label class="fw-bold" for="inputOrgName">Created Date</label>
                                        <input class="form-control" name="created" type="text"  value="${customer.createdDate}" readonly required>
                                    </div>

                                    <div class="col-md-6">
                                        <label class="fw-bold" for="inputLocation">Modified Date</label>
                                        <input class="form-control" name="modified" type="text" value="${customer.modifiedDate}" readonly required>
                                    </div>
                                </div>

                                    <input class="btn btn-primary" type="submit" value="Done">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </form>                        
    </body>
</html>
