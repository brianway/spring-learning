<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请上传用户头像</title>
</head>
<body>
<h1>
    请选择上传的头像文件
</h1>
<form method="post" action="<c:url value="/user/upload"/>" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file"/>
    <input type="submit"/>
</form>
</body>
</html>