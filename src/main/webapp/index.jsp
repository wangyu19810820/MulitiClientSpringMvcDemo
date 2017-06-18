<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<p>Controller中设置模型属性，避免使用“result”作为属性名。</p>
<p>这个值在springweb.xml中设置modelKey，以及在ResultModel中设置RESULT_BEAN_NAME，进行调整</p>
<a href="<c:url value="/product/list"/>">网页</a>
<a href="client.jsp">json模拟客户端</a>
<a href="apilist.jsp">接口模拟器</a>
</body>
</html>
