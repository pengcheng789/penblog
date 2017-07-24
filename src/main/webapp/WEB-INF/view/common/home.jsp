<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pen
  Date: 17-7-3
  Time: 下午5:35
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
    <link rel="stylesheet"
          href="<c:url value="/asset/css/common/home.css" />" >
    <title>Welcome - PenBlog</title>
</head>
<body>
    <div class="container head">
        Welcome To<br/>
        PenBlog
    </div>

    <div class="container my-nav">
        <ul class="nav nav-tabs nav-justified">
            <li role="presentation" class="active"><a href="#">首页</a></li>
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
            <li role="presentation">
                <a href="<c:url value="/user/login"/>">登录</a>
            </li>
        </ul>
    </div>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous">
    </script>

</body>
</html>
