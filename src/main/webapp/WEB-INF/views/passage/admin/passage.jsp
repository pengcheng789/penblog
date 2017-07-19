<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pen
  Date: 17-7-19
  Time: 上午10:44
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
          href="<c:url value="/statics/css/user/profile.css" />" >
    <link rel="stylesheet"
          href="<c:url value="/statics/css/user/navbar.css" />">
    <link rel="stylesheet"
          href="<c:url value="/statics/css/common/my_tools.css" />">
    <link rel="stylesheet"
          href="<c:url value="/statics/css/passage/admin/passage.css" />">
    <title>文章管理 - PenBlog</title>
</head>
<body>
    <div class="container head">
        <span id="sayHello"></span>
        <br/>
        管理员-${user.nickname}
    </div>

    <!-- 导航栏 -->
    <div class="container my-nav">
        <ul class="nav nav-tabs nav-justified">
            <li role="presentation">
                <a href="<c:url value="/user/profile/${user.id}"/>">
                    个人信息
                </a>
            </li>
            <li role="presentation" class="active">
                <a href="<c:url value="/passage/list/${user.id}" />">
                    文章管理
                </a>
            </li>
            <li role="presentation"><a href="#">收藏管理</a></li>
            <li role="presentation"><a href="#">评论管理</a></li>
        </ul>
    </div>
    <!-- /导航栏 -->

    <!-- 内容区 -->
    <div class="container content">
        <div class="row">
            <div class="col-xs-12">
                <button type="button" class="btn btn-default"
                        data-toggle="modal" data-target="#addCategoryModal">
                    添加分类
                </button>
            </div>
        </div>

        <c:forEach var="category" items="${categories}">
            <div class="row category">
                <div class="col-xs-12">
                    <h3>${category.name}</h3>
                </div>
                <div class="col-xs-12 my-line"></div>
            </div>
        </c:forEach>
    </div>
    <!-- /内容区 -->

    <!-- Bootstrap 模态框 -->
    <!-- 添加分类 -->
    <div class="modal fade" tabindex="-1" role="dialog"
         id="addCategoryModal" aria-labelledby="addCategoryModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="addCategoryModalLabel">
                        添加分类
                    </h4>
                </div>

                <form action="<c:url value="/passage/category/add/${user.id}" />" method="post">
                    <div class="modal-body">
                        <input type="text" name="name" class="form-control">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            取消
                        </button>
                        <button type="submit" class="btn btn-primary">
                            确认
                        </button>
                    </div>
                </form>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous">
    </script>
    <script src="/penblog/statics/js/user/profile.js"></script>

    <script>document.getElementById("sayHello").innerHTML = sayHello();</script>
</body>
</html>
