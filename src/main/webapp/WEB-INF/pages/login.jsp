<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>请登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="shorticon icon" type="image/x-icon" href="http://1994.github.com/favicon.ico?v=0.4.2">
    <style>
        * {
            font-family: "Helvetica Neue", Helvetica, "Segoe UI", Ubuntu, "Hiragino Sans GB", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading, .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            font-size: 16px;
            height: auto;
            padding: 10px;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="text"] {
            margin-bottom: -1px;
            border-bottom-left-radius: 0;
            border-bottom-right-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }

        .account-wall {
            margin-top: 20px;
            padding: 40px 0px 20px 0px;
            background-color: #f7f7f7;
            -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        }


        #login_form {
            margin-top: 70px;
        }


        html,
        body {
            height: 100%;
        }

        #wrap {
            min-height: 100%;
            height: auto !important;
            height: 100%;
            margin: 0 auto -60px;
        }

        #footer {
            height: 60px;
        }
        #footer {
            background-color: #f5f5f5;
        }

        @media (max-width: 767px) {
            #footer {
                margin-left: -20px;
                margin-right: -20px;
                padding-left: 20px;
                padding-right: 20px;
            }
        }

        #footer .container {
            width: auto;
            max-width: 680px;
        }
        #footer_text {
            margin-top: 20px;

        }


    </style>
</head>
<body>
<div id="wrap">
<nav class="navbar navbar-inverse">

    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://reecoblog.info">我的博客</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/about">关于</a></li>
        </ul>
    </div>
</nav>

<div id="login_form">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h2 class="text-center">输入图书馆账号</h2>

                <div class="account-wall">
                    <form class="form-signin" method="post" action="/user/login">
                        <input type="text" class="form-control" placeholder="学号" name="username" required autofocus>
                        <input type="password" class="form-control" placeholder="密码" name="password" required>

                        <c:if test="${message!=null}">
                            <div id="error-message" class="alert alert-danger" role="alert">${message}</div>
                        </c:if>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            登录
                        </button>
                    </form>
                </div>
            </div>
        </div>



    </div>
</div>

</div>
<div id="footer">
    <div class="container">
        <div align="center">
        <p id="footer_text" class="credit">没个footer显得很不专业的样子，但又不知道放什么好</p>
        </div>
    </div>
</div>

<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
