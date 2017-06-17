<%@page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>商品详情</h1>
    <p>商品名称：${product.name}</p>
    <p>商品描述：${product.desc}</p>
</body>
</html>