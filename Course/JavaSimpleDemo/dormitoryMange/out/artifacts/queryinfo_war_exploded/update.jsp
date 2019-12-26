
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改宿舍基本信息</h3>
    <form action="updatedormServlet" method="post">
        <div class="form-group">
            <label for="name">宿舍名称：</label>
            <input type="text" class="form-control" id="name" name="name" value=${dorm.name}  placeholder="输入名字" />
        </div>

        <div class="form-group">
            <label for="dormid">宿舍编号：</label>
            <input type="text" class="form-control" id="dormid"  name="dormid" value=${dorm.dormid}  readonly="readonly"  placeholder="请输入宿舍编号" />
        </div>

        <div class="form-group">
            <label for="level">楼层号：</label>
            <input type="text" class="form-control" id="level"  name="level" value=${dorm.level}  placeholder="请输入楼层号" />
        </div>

        <div class="form-group">
            <label for="gender">宿舍类型：</label>
            <input type="text" class="form-control" id="gender"  name="gender" value=${dorm.gender}  placeholder="输入宿舍类型" />
        </div>


        <div class="form-group">
            <label for="des">宿舍基本信息：</label>
            <input type="text" id="des" class="form-control" value=${dorm.description}  name="description" placeholder="宿舍信息"/>
        </div>

        <div class="form-group">
            <label for="apart">所属公寓：</label>
            <input type="text" id="apart" class="form-control" value=${dorm.apart} name="apart"    placeholder="所在公寓"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
        </div>
    </form>
</div>
</body>
</html>
