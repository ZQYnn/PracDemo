
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
    <h3 style="text-align: center;">修改当前宿舍学生信息</h3>
    <form action="updateNumberServlet?dormid=${number.dormid}" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value=${number.name} readonly="readonly" placeholder="输入名字" />
        </div>

        <input type="hidden" name="stuid" value="${number.stuid}">
        <div class="form-group">
            <label>性别：</label>
            <c:if test="${number.gender == '男'}">
                <input type="radio" name="gender" value="男"  checked/>男
                <input type="radio" name="gender" value="女"  />女
            </c:if>

        </div>
        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" value=${number.age}  placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="id">宿舍号：</label>
            <input type="text" id="id" class="form-control" value=${number.dormid}  name="dormid" placeholder="输入宿舍号"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />

        </div>
    </form>
</div>
</body>
</html>
