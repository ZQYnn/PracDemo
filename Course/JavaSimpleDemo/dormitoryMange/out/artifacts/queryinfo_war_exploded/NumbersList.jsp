<%@page  contentType="text/html; charset=UTF-8"  language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <script>
        function deleteusers(id, dormid) {
            if (confirm("确定要删除吗？")){
                location.href="delNumberServlet?stuid=" + id +"&dormid=" +dormid;
            }
        }
        window.onload = function () {
            document.getElementById("delSelected").onclick = function(){
                if(confirm("您确定要删除选中条目吗？ 并返回宿舍信息主页面")){
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
    <title>宿舍信息成员</title>

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


    <div align="center">
        <a style="font-size: 20px"> ${dormid} 宿舍成员信息如下</a>
    </div>
    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="add.jsp">添加宿舍成员</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>

    <form id="form" action="delSeletedNumsServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" ></th>
                <th>学生ID</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>宿舍号</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${numbers}" var="user" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="uid" value=${user.dormid}></th>
                    <td>${user.stuid}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.dormid}</td>
                    <td><a class="btn btn-default btn-sm " href="FindNumberbyIdServlet?stuid=${user.stuid}" target="_blank">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href= "javascript:deleteusers(${user.stuid}, ${user.dormid})"> 删除</a></td>
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
