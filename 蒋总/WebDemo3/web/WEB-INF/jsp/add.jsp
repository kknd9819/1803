<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String  ctxpath = request.getContextPath();%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style>
        h2{
            text-align: center;
        }
        p{
            text-align: center;
        }
        body{
            padding-top: 70px;
            padding-bottom: 30px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">CURD练习</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="<%=ctxpath%>/students">列表</a></li>
                <li class="active"><a href=<%=ctxpath%>/add>新增</a></li>

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <div class="panel panel-info">
        <!-- Default panel contents -->
        <div class="panel-heading">增删改查</div>
        <div class="panel-body">
            <form action="<%=ctxpath%>/add" method="post">

                <div class="form-group">
                    <label for = "student_name">学生姓名</label>
                    <input type="text" class="form-control" id="student_name" name="student_name" placeholder="学生姓名">
                </div>

                <div class="form-group">
                    <label for="age">学生年龄</label>
                    <input type="text" class="form-control" id="age" name="age" placeholder="年龄">
                </div>

                <div class="form-group">
                    <label for="sex">性别</label>
                    <input type="text" class="form-control" id="sex" name="sex" placeholder="性别">
                </div>

                <div class="form-group">
                    <label for="tlephone">学生电话</label>
                    <input type="text" class="form-control" id="tlephone" name="tlephone" placeholder="学生电话">
                </div>



                <button type="submit" class="btn btn-success">提交</button>
                <button type="button" class="btn btn-default" id ="back">返回</button>
            </form>

        </div>
    </div>
</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script>
    var back = document.getElementById("back");
    back.onclick = function () {
        window.history.back();
    }
</script>
</body>
</html>