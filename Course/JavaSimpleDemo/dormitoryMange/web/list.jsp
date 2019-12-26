<%@page  contentType="text/html; charset=UTF-8"  language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <script>
        function deletedorm(dormid) {
            if (confirm("确定要删除吗？")){
                location.href="deletDormServlet?dormid=" + dormid;
            }
        }
        window.onload = function () {
            document.getElementById("delSelected").onclick = function(){
                if(confirm("您确定要删除选中条目吗？")){
                    var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }
                    if(flag){//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }
                }
            }
        }
    </script>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>宿舍信息系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>

<body>
<div class="container">
    <h3 style="text-align: center">宿舍信息管理</h3>
    <div style="float: left">
        <form class="form-inline" action="findDormconditionServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">宿舍名称</label>
                <input type="text" name="name" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">楼层</label>
                <input type="text" name="level" class="form-control" id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">描述信息</label>
                <input type="text" name="description" class="form-control" id="exampleInputEmail2" >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
            <button type="submit" class="btn btn-default">全部</button>
        </form>
    </div>
    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="addDorm.jsp">添加宿舍</a>
    </div>
    <form id="form" action="delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th>宿舍名称</th>
            <th>宿舍号</th>
            <th>宿舍楼层</th>
            <th>宿舍类型</th>
            <th>宿舍基本信息</th>
            <th>所在宿舍名称</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${dorms}" var="dorm" varStatus="s">
            <tr>

                <td>${dorm.name}</td>
                <td>${dorm.dormid}</td>
                <td>${dorm.level}</td>
                <td>${dorm.gender}</td>
                <td>${dorm.description}</td>
                <td>${dorm.apart}</td>
                <td><a class="btn btn-default btn-sm " href="findDormByIdServlet?dormid=${dorm.dormid}" target="_blank">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href= "javascript:deletedorm(${dorm.dormid})"> 删除</a>
                    <a class="btn btn-default btn-sm" href= "findNumbersServlet?dormid=${dorm.dormid}" target="_blank"> 查看宿舍成员</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>

    <!--
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
            <span style="font-size: 25px; margin-left: 25px">

            </span>
        </nav>
    </div>-->
</div>
</body>
</html>
