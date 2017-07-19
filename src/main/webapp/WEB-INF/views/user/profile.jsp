<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: pen
  Date: 17-7-9
  Time: 上午11:15
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
    <title>Edit User - PenBlog</title>
</head>
<body>
    <div class="container head">

       <span id="sayHello">
       </span> ${user.nickname}
    </div>

    <!-- 导航栏 -->
    <div class="container my-nav">
        <ul class="nav nav-tabs nav-justified">
            <li role="presentation" class="active"><a href="#">个人信息</a></li>
            <li role="presentation"><a href="#">收藏</a></li>
            <li role="presentation"><a href="#">评论</a></li>
        </ul>
    </div>
    <!-- /导航栏 -->

    <div class="container">
        <div class="row">
            <div class="col-xs-4 head_image">
                <!-- 头像区 -->
                <img src="<c:url value="${user.head_image}" />">
                <div style="margin-top: 20px;">
                    <button class="btn btn-default"
                            data-toggle="modal" data-target="#uploadHeadImgModal">
                        <span class="glyphicon glyphicon-pencil"></span>
                        上传头像
                    </button>
                </div>
            </div>

            <div class="col-xs-8 information-list">
                <!-- 昵称栏 -->
                <div class="row information">
                    <div class="col-xs-4">
                        昵称
                    </div>
                    <div class="col-xs-6">
                        ${user.nickname}
                    </div>
                    <div class="col-xs-2">
                        <button class="btn btn-default"
                                data-toggle="modal" data-target="#editNicknameModal">
                            <span class="glyphicon glyphicon-pencil"></span> 修改
                        </button>
                    </div>
                </div>

                <!--邮箱栏-->
                <div class="row information">
                    <div class="col-xs-4">
                        注册邮箱
                    </div>
                    <div class="col-xs-6">
                        ${user.mail}
                    </div>
                </div>

                <!--性别栏-->
                <div class="row information">
                    <div class="col-xs-4">
                        性别
                    </div>
                    <div class="col-xs-6">
                        ${user.sex}
                    </div>
                    <button class="btn btn-default"
                            data-toggle="modal" data-target="#editSexModal">
                        <span class="glyphicon glyphicon-pencil"></span> 修改
                    </button>
                </div>

                <!--注册日期栏-->
                <div class="row information">
                    <div class="col-xs-4">
                        注册日期
                    </div>
                    <div class="col-xs-6">
                        ${user.create_date}
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap 模态框 -->
    <!-- 修改昵称 -->
    <div class="modal fade" tabindex="-1" role="dialog"
         id="editNicknameModal" aria-labelledby="editNicknameModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="editNicknameModalLabel">
                        修改昵称
                    </h4>
                </div>

                <form action="<c:url value="/user/edit/nickname/${user.id}" />" method="post">
                <div class="modal-body">
                    <input type="text" name="nickname" class="form-control"
                           value="${user.nickname}">
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

    <!-- 修改性别 -->
    <div class="modal fade" tabindex="-1" role="dialog"
         id="editSexModal" aria-labelledby="editSexModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="editSexModalLabel">
                        选择性别
                    </h4>
                </div>

                <form action="<c:url value="/user/edit/sex/${user.id}" />" method="post">
                    <div class="modal-body">
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="male" value="男" checked>男
                        </label>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="female" value="女">女
                        </label>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            取消
                        </button>
                        <button type="submit" class="btn btn-primary">
                            提交
                        </button>
                    </div>
                </form>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <!-- 上传头像 -->
    <div class="modal fade" tabindex="-1" role="dialog"
         id="uploadHeadImgModal" aria-labelledby="uploadHeadImgModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="uploadHeadImgModalLabel">
                        上传头像
                    </h4>
                </div>

                <form action="<c:url value="/user/upload/head_image/${user.id}" />"
                      method="post" enctype="multipart/form-data">
                    <div class="modal-body">
                        选择文件 <input type="file" name="file">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            取消
                        </button>
                        <button type="submit" class="btn btn-primary">
                            上传
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
    <script src="/penblog/statics/js/user/profile.js" ></script>

    <script>document.getElementById("sayHello").innerHTML = sayHello();</script>

</body>
</html>
