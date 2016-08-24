<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>新增用户</title>
    <style>
        .errorClass {
            color: red
        }
    </style>
</head>
<body>
<spring:bind path="user.*">
    <c:forEach var="error" items="${status.errorMessages}">
        <B>
            <CSS color=RED>
                <BR><c:out value="${error}"/>
            </CSS>
        </B>
    </c:forEach>
</spring:bind>

<form:form commandName="user" action="/user/userValidator">
    <table>
        <tr>
            <td>用户名：</td>
            <td>
                <form:errors path="userName" cssClass="errorClass" element="div"/>
                <form:input path="userName"/>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <form:errors path="password" cssClass="errorClass" element="div"/>
                <form:password path="password"/>
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <form:errors path="realName" cssClass="errorClass" element="div"/>
                <form:input path="realName"/>

            </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td>
                <form:errors path="birthday" cssClass="errorClass" element="div"/>
                <form:input path="birthday"/>
            </td>
        </tr>
        <tr>
            <td>工资：</td>
            <td>
                <form:errors path="salary" cssClass="errorClass" element="div"/>
                <form:input path="salary"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="提交"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>