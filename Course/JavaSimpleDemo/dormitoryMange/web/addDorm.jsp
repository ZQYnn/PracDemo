
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加宿舍信息</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <center><h3>添加宿舍</h3></center>
    <form action="addDormServlet" method="post">
        <div class="form-group">
            <label for="name">宿舍名称：</label>
            <input type="text" class="form-control" id="name" name="name"   placeholder="输入宿舍名称" />
        </div>

        <div class="form-group">
            <label for="dormid">宿舍编号：</label>
            <input type="text" class="form-control" id="dormid"  name="dormid"   placeholder="请输入宿舍编号" />
        </div>

        <div class="form-group">
            <label for="level">楼层号：</label>
            <input type="text" class="form-control" id="level"  name="level"   placeholder="请输入楼层号" />
        </div>




        <div class="form-group">
            <label for="gender">宿舍类型：</label>
            <input type="text" class="form-control" id="gender"  name="gender"   placeholder="输入宿舍类型" />
        </div>


        <div class="form-group">
            <label for="des">宿舍基本信息：</label>
            <input type="text" id="des" class="form-control"  name="description" placeholder="宿舍信息"/>
        </div>

        <div class="form-group">
            <label for="apart">所属公寓：</label>
            <input type="text" id="apart" class="form-control"  name="apart"    placeholder="所在公寓"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>
