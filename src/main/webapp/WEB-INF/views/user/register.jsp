<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pen
  Date: 17-7-3
  Time: 下午5:45
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
    <title>Register user - PenBlog</title>
</head>
<body>
    <div class="container">
        <div class="title">
            Register<br/>
            PenBlog Reader<br/>
        </div>
    </div>

    <div class="container register">
        <div class="error">
            ${error}
        </div>
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
                <label for="nickname" class="col-xs-offset-1 col-xs-2 control-label">
                    昵称
                </label>
                <div class="col-xs-6">
                    <input type="text" class="form-control" id="nickname" name="nickname"
                           placeholder="输入昵称">
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
                <label for="confirm_password" class="col-xs-offset-1 col-xs-2 control-label">
                    确认密码
                </label>
                <div class="col-xs-6">
                    <input type="password" class="form-control" id="confirm_password"
                           name="confirm_password" placeholder="再次输入密码进行确认">
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-offset-1 col-xs-2 control-label">
                    性别
                </label>
                <div class="col-xs-offset-1 col-xs-2">
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="male" value="男" checked>男
                    </label>
                </div>
                <div class="col-xs-2">
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="female" value="女">女
                    </label>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-offset-4 col-xs-2">
                    <input type="submit" class="btn btn-primary" value="注册">
                </div>
                <div class="col-sm-offset-1 col-xs-2">
                    <input type="reset" class="btn btn-default" value="重置">
                </div>
            </div>
        </form>
    </div>

</body>
</html>
