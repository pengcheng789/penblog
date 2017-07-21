<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pen
  Date: 17-7-21
  Time: 下午9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
          href="<c:url value="/statics/css/user/register.css" /> ">
    <title>登录 - PenBlog</title>
</head>
<body>

    <div class="container">
        <div class="title">
            Login<br/>
            PenBlog Reader<br/>
        </div>
    </div>

    <div class="container my-nav">
        <ul class="nav nav-tabs nav-justified">
            <li role="presentation">
                <a href="<c:url value="/home"/>">
                    首页
                </a>
            </li>
            <li role="presentation" class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    分类 <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">Java</a></li>
                    <li><a href="#">Android</a></li>
                    <li><a href="#">Mysql</a></li>
                    <li><a href="#">Linux</a></li>
                </ul>
            </li>
            <li role="presentation">
                <a href="<c:url value="/user/register"/>">注册</a>
            </li>
            <li role="presentation" class="active">
                <a href="<c:url value="/user/login"/>">登录</a>
            </li>
        </ul>
    </div>

    <div class="container">
        <form class="form-horizontal" method="post">
            <div class="form-group">
                <label for="mail" class="col-xs-offset-1 col-xs-2 control-label">
                    邮箱
                </label>
                <div class="col-xs-6">
                    <input type="email" class="form-control" id="mail"
                           name="mail" placeholder="输入邮箱">
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-xs-offset-1 col-xs-2 control-label">
                    密码
                </label>
                <div class="col-xs-6">
                    <input type="password" class="form-control" id="password"
                           name="password"
                           placeholder="输入密码">
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-2">
                    <input type="submit" class="btn btn-primary" value="登录">
                </div>
                <div class="col-sm-offset-1 col-xs-2">
                    <input type="reset" class="btn btn-default" value="重置">
                </div>
            </div>
        </form>
    </div>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous">
    </script>
</body>
</html>
