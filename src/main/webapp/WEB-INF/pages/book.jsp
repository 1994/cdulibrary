<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>借书记录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link rel="shorticon icon" type="image/x-icon" href="http://1994.github.com/favicon.ico?v=0.4.2">
    <style type="text/css">
        * {
            font-family: "Helvetica Neue", Helvetica, "Segoe UI", Ubuntu, "Hiragino Sans GB", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif;
        }

        .row {
            margin-top: 40px;
            padding: 0 10px;
        }

        .panel-heading div {
            margin-top: -18px;
            font-size: 15px;
        }

        .panel-heading div span {
            margin-left: 5px;
        }

        .panel-body {
            display: none;
        }

        .panel-success {
            border-color: #22b24c;
        }

        .panel-success > .panel-heading {
            color: #3c763d;
            background-color: #22b24c;
            border-color: #22b24c;
        }

        .panel-title {
            margin-top: 0;
            margin-bottom: 0;
            font-size: 17px;
            color: #ffffff;
        }

        /*#books {*/
        /*margin-top: 100px;;*/
        /*}*/

        .center {
            width: auto;
            display: table;
            margin-left: auto;
            margin-right: auto;
        }

        .text-center {
            text-align: center;
        }

        #email {
            margin-top: 50px;
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
<div id="books">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">Books</h3>

                        <div class="pull-right">
                        </div>
                    </div>
                    <div class="panel-body">
                        <input type="text" class="form-control" id="task-table-filter" data-action="filter"
                               data-filters="#task-table" placeholder="Filter Tasks"/>
                    </div>
                    <div class="table-responsive">
                        <c:if test="${sessionScope.books.size()!=0 }">
                            <table class="table table-hover table-condensed table-striped" id="task-table">
                                <thead>
                                <tr>
                                    <%--<th>编号</th>--%>
                                    <th>书名/作者</th>
                                    <th>借阅日期</th>
                                    <th>归还日期</th>
                                    <th>归还地点</th>
                                    <th>剩余天数</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${sessionScope.books}" var="book">
                                    <tr>
                                        <%--<td>${book.code}</td>--%>
                                        <td>${book.name}</td>
                                        <td>${book.borrowData.toString("YYYY-MM-DD")}</td>
                                        <td>${book.returnData.toString("YYYY-MM-DD")}</td>
                                        <td>${book.place}</td>
                                        <td>${book.remainDay}</td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </c:if>

                        <c:if test="${books.size()==0 }">
                            <h2 class="center">您尚未有借书记录</h2>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div class="center" id="email">
            <form action="/user/add" method="post">
                <div class="input-group">

                    <c:if test="${succ==null}">
                        <input type="text" name="email" class="form-control" placeholder="输入邮箱接受提醒服务"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit">Go!</button>
                                </span>
                    </c:if>
                </div>
                <c:if test="${message!=null}">
                    <div id="error-message" class="alert alert-danger" role="alert">${message}</div>
                </c:if>

                <c:if test="${already!=null}">
                    <div id="error-message" class="alert alert-danger" role="alert">${already}</div>
                </c:if>

                <c:if test="${succ!=null}">
                    <div id="error-message" class="alert alert-success" role="alert">
                        注册成功，不出意外您将收到一封测试邮件，若是QQ用户，请检查您的垃圾箱。
                    </div>
                </c:if>
            </form>
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

</body>

</html>
