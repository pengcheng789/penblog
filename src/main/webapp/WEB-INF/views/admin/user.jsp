<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: pen
  Date: 17-7-6
  Time: 下午8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage User - PenBlog</title>
</head>
<body>
    <h1>要删除的是：${id} ${result}</h1>
    <table>
        <tr>
            <th>id</th>
            <th>mail</th>
            <th>nickname</th>
            <th>password</th>
            <th>sex</th>
            <th>create_date</th>
            <th>operate</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.mail}</td>
                <td>${user.nickname}</td>
                <td>${user.password}</td>
                <td>${user.sex}</td>
                <td>${user.create_date}</td>
                <td>
                    <a href="#">edit</a>
                    <a href="<c:url value="/admin/user/delete/${user.id}" />">
                        delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
