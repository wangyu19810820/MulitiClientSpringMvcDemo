<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>添加商品</h1>
<form action="<c:url value="/product/addProduct"/>">
    <p>商品名称：<input type="text" name="name"></p>
    <p>商品描述：<input type="text" name="desc"></p>
    <input type="submit">
</form>
</body>
</html>