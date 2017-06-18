<%@ page import="java.util.Set,java.lang.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Api List</title>
</head>
<body>
<h1>商品接口模拟器</h1>
<ul>
    <li><a href="<c:url value="/product/list.api"/>">商品列表</a></li>
    <li><a href="<c:url value="/product/detail.api?id=1"/>">商品详情</a></li>
    <li><a href="<c:url value="/product/addProduct.api?name=aa&desc=bb"/>">新增商品</a></li>
    <li><a href="<c:url value="/product/updateProduct.api?id=2&name=cc&desc=dd"/>">更新商品</a></li>
    <li><a href="<c:url value="/product/delete.api?id=2"/>">删除商品</a></li>
</ul>
</body>
</html>
