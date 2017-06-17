<%@page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>输入数量商品id，查看商品详情</h1>
    <form action="<c:url value="/product/find"/>">
        <input type="text" name="id">
        <input type="submit">
    </form>
    <p>商品详情</p>
    <p>商品名称：${product.name}</p>
    <p>商品描述：${product.desc}</p>
</body>
</html>
