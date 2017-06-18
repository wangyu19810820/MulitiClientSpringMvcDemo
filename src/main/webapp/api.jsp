<%@ page import="java.util.Set,java.lang.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <style>
        div {
            background-color: darkgray;
            padding: 10px;
            margin: 10px;
        }
        p {
            margin-top: 0;
        }
    </style>
</head>
<body>
<%
    Set<String> keys = request.getParameterMap().keySet();
%>

<div>
    <p>请求路径：</p>
    <p><%=request.getAttribute("requestUri")%></p>
</div>

<div>
    <p>请求参数：</p>
    <ul>
    <% for (String key : keys) { %>
        <li><%=key%>=<%=request.getParameter(key)%></li>
    <% } %>
    </ul>
</div>

<div>
    <p>返回json</p>
    <pre><%=request.getAttribute("result")%></pre>
</div>
</body>
</html>
