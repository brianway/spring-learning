<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
当前用户是 ${user.userName},userId 为 ${user.userId}
<c:if test="${userSession != null}">
    <br> session 用户是 ${userSession.userName},userId 为 ${userSession.userId}
</c:if>
</body>
</html>