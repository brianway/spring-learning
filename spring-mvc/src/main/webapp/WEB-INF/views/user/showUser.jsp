<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
当前用户是${user.userName},userId为${user.userId}
<c:if test="userSession != null">
    <br> session用户是${userSession.userName},userId为${userSession.userId}
</c:if>
</body>
</html>