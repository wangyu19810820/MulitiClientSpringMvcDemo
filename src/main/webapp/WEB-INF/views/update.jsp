<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>更新商品</h1>
<form action="<c:url value="/product/updateProduct"/>">
    <input type="text" name="id" value="${product.id}">
    <p>商品名称：<input type="text" name="name" value="${product.name}"></p>
    <p>商品描述：<input type="text" name="desc" value="${product.desc}"></p>
    <input type="submit">
</form>
</body>
</html>