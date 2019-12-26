<%@page  contentType="text/html; charset=UTF-8"  language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <script type="text/javascript">
        function confirm() {
            if (confirm("是否进入查询用户信息页面")){
                location.href = "";
            }
        }
    </script>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
    <a style="font-size: larger">欢迎管理员：${users.username} , 登录查询系统</a>
</div>
<a href="dormListServlet" style="text-decoration:none;font-size:15px"> 查询宿舍基本信息</a>
</body>
</html>