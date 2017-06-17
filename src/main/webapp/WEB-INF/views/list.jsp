<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="<c:url value="/product/addInit"/>">添加</a>
    <h1>商品列表</h1>
    <div style="padding: 10px; margin-bottom: 10px;">
        <c:forEach var="product" items="${result.data}">
            <p>名称：${product.name}</p>
            <p>描述：${product.desc}</p>
            <p><a href="<c:url value="/product/detail"><c:param name = "id" value = "${product.id}"/></c:url>">详情</a></p>
            <p><a href="<c:url value="/product/updateInit"><c:param name = "id" value = "${product.id}"/></c:url>">修改</a></p>
            <p><a href="<c:url value="/product/delete"><c:param name = "id" value = "${product.id}"/></c:url>">删除</a></p>
        </c:forEach>
    </div>
</body>
</html>
