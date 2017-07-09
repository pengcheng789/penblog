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
    <title>Welcome - PenBlog</title>
</head>
<body>
    <h1>Welcome to PenBlog!</h1>
    <a href="<c:url value="/user/register" />">
        Register
    </a>
</body>
</html>
