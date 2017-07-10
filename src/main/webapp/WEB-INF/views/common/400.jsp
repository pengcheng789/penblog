<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pen
  Date: 17-7-9
  Time: 上午11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, userId-scalable=no">
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link type="text/css" rel="stylesheet"
          href="<c:url value="/statics/css/common/4xx.css" /> ">
    <title>Not Found - PenBlog</title>
</head>
<body>
    <div class="container">
        <div class="head">
            400 BAD REQUEST
        </div>

        <div>
            <a href="<c:url value="/" />">
                <button type="button" class="btn btn-default">
                    <span class="glyphicon glyphicon-home"></span>
                    回到主页
                </button>
            </a>
        </div>
    </div>
</body>
</html>
