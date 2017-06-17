<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        div {
            border: 1px solid gray;
            margin-bottom: 20px;
            padding: 5px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
    <script>
        function list() {
            $.ajax({
                url:'<c:url value="/product/list"/>',
                dataType:'json',
                success:function (res, status) {
                    console.log(res);
                    $("#result").html(JSON.stringify(res));
                },
                error:function (res) {
                    console.log(res)
                    $("#result").html('error');
                }
            })
        }
        function add() {
            $.ajax({
                url:'<c:url value="/product/addProduct"/>',
                dataType:'json',
                type:'post',
                data:{name:$('#addName').val(), desc:$('#addDesc').val()},
                success:function (res, status) {
                    console.log(res);
                    $("#result").html(JSON.stringify(res));
                },
                error:function (res) {
                    console.log(res)
                    $("#result").html('error');
                }
            })
        }
        function update() {
            $.ajax({
                url:'<c:url value="/product/updateProduct"/>',
                dataType:'json',
                type:'post',
                data:{id:$('#updateId').val(), name:$('#updateName').val(), desc:$('#updateDesc').val()},
                success:function (res, status) {
                    console.log(res);
                    $("#result").html(JSON.stringify(res));
                },
                error:function (res) {
                    console.log(res)
                    $("#result").html('error');
                }
            })
        }
        function find() {
            $.ajax({
                url:'<c:url value="/product/detail"/>',
                dataType:'json',
                type:'post',
                data:{id:$('#findId').val()},
                success:function (res, status) {
                    console.log(res);
                    $("#result").html(JSON.stringify(res));
                },
                error:function (res) {
                    console.log(res)
                    $("#result").html('error');
                }
            })
        }
        function deleteProduct() {
            $.ajax({
                url:'<c:url value="/product/delete"/>',
                dataType:'json',
                type:'post',
                data:{id:$('#deleteId').val()},
                success:function (res, status) {
                    console.log(res);
                    $("#result").html(JSON.stringify(res));
                },
                error:function (res) {
                    console.log(res)
                    $("#result").html('error');
                }
            })
        }
    </script>
</head>
<body>
    <h1>json客户端</h1>
    <div><button onclick="list()">列表</button></div>
    <div>
        <p>商品名称：<input type="text" id="addName"></p>
        <p>商品描述：<input type="text" id="addDesc"></p>
        <p><button onclick="add()">新增</button></p>
    </div>
    <div>
        <p>商品id：<input type="text" id="updateId"></p>
        <p>商品名称：<input type="text" id="updateName"></p>
        <p>商品描述：<input type="text" id="updateDesc"></p>
        <p><button onclick="update()">修改</button></p>
    </div>
    <div><input type="text" id="findId" value="1"><button onclick="find()">查找</button></div>
    <div><input type="text" id="deleteId" value="1"><button onclick="deleteProduct()">删除</button></div>
    <div id="result"></div>
</body>
</html>