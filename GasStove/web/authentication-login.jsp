<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="google-signin-client_id" content="285513587704-bfomf8qlc0kijp8167fpar8co8lp3s8n.apps.googleusercontent.com">

        <title>góep bán ga</title>
        <link rel="shortcut icon" type="image/png" href="/GasStove/admin/images/logos/favicon.png" />
        <link rel="stylesheet" href="/GasStove/admin/css/styles.min.css" />
    </head>

    <body>
        <!--  Body Wrapper -->
        <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
             data-sidebar-position="fixed" data-header-position="fixed">
            <div
                class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
                <div class="d-flex align-items-center justify-content-center w-100">
                    <div class="row justify-content-center w-100">
                        <div class="col-md-8 col-lg-6 col-xxl-3">
                            <div class="card mb-0">
                                <div class="card-body">
                                    <a href="./index.html" class="text-nowrap logo-img text-center d-block py-3 w-100">
                                        <img src="/GasStove/admin/images/logos/dark-logo.svg" width="180" alt="">
                                    </a>
                                    <p class="text-center">Your Social Campaigns</p>
                                    <form action="loginController" method="post">
                                        <div class="mb-3">
                                            <label for="exampleInputEmail1" class="form-label">Username</label>
                                            <input  class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp">
                                        </div>
                                        <div class="mb-4">
                                            <label for="exampleInputPassword1" class="form-label">Password</label>
                                            <input type="password" class="form-control" name="password" id="exampleInputPassword1">
                                        </div>
                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                            <div class="form-check">
                                                <input class="form-check-input primary" type="checkbox" value="" id="flexCheckChecked" checked>
                                                <label class="form-check-label text-dark" for="flexCheckChecked">
                                                    Remember this Device
                                                </label>
                                            </div>
                                            <a class="text-primary fw-bold" href="./forgotPassword.jsp">Forgot Password ?</a>
                                        </div>
                                        <div class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">
                                            <button style="color: black" class="btn" type="submit">Sign in</button>
                                        </div>

                                        <div class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">
                                            <a style="color: black" href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:9999/GasStove/login-google&response_type=code&client_id=285513587704-bfomf8qlc0kijp8167fpar8co8lp3s8n.apps.googleusercontent.com&approval_prompt=force">Login with Google</a>

                                        </div>


                                        <div class="d-flex align-items-center justify-content-center">
                                            <a class="text-primary fw-bold ms-2" href="registerController">Create an account</a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="/GasStove/admin/libs/jquery/dist/jquery.min.js"></script>
        <script src="/GasStove/admin/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://apis.google.com/js/platform.js" async defer></script>

    </body>


</html>