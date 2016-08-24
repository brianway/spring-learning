<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><fmt:message key="website.title"/></title>
</head>
<body>
<fmt:message key="user.userList.title"/>
<table>
    <c:forEach items="${userList}" var="user">
    <tr>
        <td>
            <a href="<c:url value="/user/showUser/${user.userName}"/>">
                    ${user.userName}
            </a>
        </td>
        <td>
                ${user.realName}
        </td>
        <td>
            <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
        </td>
    </tr>
    </c:forEach>
    <table>
</body>
</html>
