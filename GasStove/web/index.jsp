<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cổng thanh toán VNPAY</title>
    <!-- Bootstrap core CSS -->
    <link href="/GasStove/assets/bootstrap.min.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="/GasStove/assets/jumbotron-narrow.css" rel="stylesheet">
    <style>
        body {
            background-color: #f1f1f1;
            color: #333333;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 10px;
        }

        .header {
            text-align: center;
            margin-bottom: 30px;
        }

        .header h3 {
            font-size: 24px;
            font-weight: bold;
            color: #333333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group button {
            display: block;
            width: 100%;
            padding: 10px;
            font-size: 18px;
            color: #ffffff;
            background-color: #4CAF50;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .form-group button:hover {
            background-color: #45a049;
        }

        .footer {
            text-align: center;
            margin-top: 30px;
            padding-top: 10px;
            border-top: 1px solid #cccccc;
        }

        .footer p {
            font-size: 14px;
            color: #999999;
        }
    </style>
</head>

<body>
<div class="container">
    <div class="header clearfix">
        <h3 class="text-muted">Cổng thanh toán VNPAY</h3>
    </div>
    <div class="form-group">
        <button onclick="pay()" style="background-color: #007bff;">Giao dịch thanh toán</button><br>
    </div>
    <div class="form-group">
        <button onclick="querydr()" style="background-color: #6c757d;">Truy vấn kết quả thanh toán</button><br>
    </div>
    <div class="form-group">
        <button onclick="refund()" style="background-color: #dc3545;">Hoàn tiền giao dịch</button><br>
    </div>
    <p>&nbsp;</p>
    <footer class="footer">
        <p>&copy; VNPAY 2023</p>
    </footer>
</div>
<script>
    function pay() {
        window.location.href = "/GasStove/vnpay_pay.jsp";
    }
    function querydr() {
        window.location.href = "/GasStove/vnpay_querydr.jsp";
    }
    function refund() {
        window.location.href = "/GasStove/vnpay_refund.jsp";
    }
</script>
</body>
</html>
