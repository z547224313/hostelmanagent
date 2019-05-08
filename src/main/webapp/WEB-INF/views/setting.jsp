<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/28
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript"
            src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/layui/css/layui.css">
    <script src="${APP_PATH}/static/layui/layui.js"></script>
</head>
<body>
<%--编辑模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="editModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <form class="form-inline">
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="roomType_edit_input">
                                <span class=" glyphicon glyphicon-user" aria-hidden="true"></span>
                                房间类型
                            </label>
                            <input type="text" name="roomType" class="form-control" id="roomType_edit_input" >
                        </div>
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="roomPrice_edit_input">
                                <span class=" glyphicon glyphicon-user" aria-hidden="true"></span>
                                房间价格
                            </label>
                            <input type="email" class="form-control " name="roomPrice" id="roomPrice_edit_input" >
                        </div>
                    </form>
                </div>
                <div class="row">
                    <form class="form-inline">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <%--默认传送一个隐藏的订单号--%>
                                <input type="hidden" id="roomId">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="save_edit">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<%--添加房型模态框--%>
<div class="modal fade" id="settingInsertModel" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" id="modal_close" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">添加房型</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="roomType_add_input"class="col-sm-2 control-label">房间类型</label>
                        <div class="col-sm-10">
                            <input type="text" name="roomType" class="form-control" id="roomType_add_input" placeholder="房间类型">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="roomPrice_add_input"class="col-sm-2 control-label">价格</label>
                        <div class="col-sm-10">
                            <input type="text" name="roomPrice" class="form-control" id="roomPrice_add_input" placeholder="房间价格">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="roomId_add_input"class="col-sm-2 control-label">房间号</label>
                        <div class="col-sm-10">
                            <input type="text" name="roomId" class="form-control" id="roomId_add_input" placeholder="房间号">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <%--默认传送一个隐藏的房间状态是0未使用--%>
                            <input type="hidden" name="roomStatus" value="0" id="roomStatus_add_input" >
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="room_save_input">保存</button>
            </div>
        </div>
    </div>
</div>

<%--首页导航栏--%>
<nav class="navbar navbar-default">
    <div class="container-fluid" id="head-bar">
        <div class="navbar-header">
            <a class="navbar-brand" >HostelManagent</a>
        </div>
        <%--当前页面功能栏--%>
        <div class="collapse navbar-collapse " >
            <ul class="nav navbar-nav ">
               <li> <a href="#" id="setting-insert">添加房型</a></li>
            </ul>
            <%--总页面栏--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="roomPage">房态</a></li>
                <li><a href="orderPage">订单</a></li>
                <li><a href="peoplePage">客人</a></li>
                <li><a href="earningPage">统计</a></li>
                <li class="active"><a href="#">管理<span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
    </div>
</nav>
<table id="roomTable" >

</table>
<script type="text/javascript">
    //发送AJAX请求房间信息
    $(function () {
        get_all_room();
    });
    function get_all_room () {
        //发送AJAX请求房间信息
        $.ajax({
            url:"${APP_PATH}/room",
            type:"GET",
            success:function (result) {
                // 拼接表格
                console.log(result);
                layui.use('table', function(){
                    var table = layui.table;
                    //第一个实例
                    table.render({
                        elem: '#roomTable'
                        ,height: 500
                        ,data: result.extend.allroom
                        ,page: true //开启分页,
                        ,limits : "[5,10,15,20,25,30,35,40,45,50]"
                        ,cols: [[ //表头
                            {field: 'roomId',title: '房间号',sort:true}
                            ,{field: 'roomType', title: '房间类型', width:338}
                            ,{field: 'roomPrice', title: '房间价格', width:455,sort:true}
                            ,{width:150, title:'操作', toolbar: '#barDemo'}
                        ]]
                    });
                });
            }
        })
    }
    //添加房型按钮绑定模态框
    $("#setting-insert").click(function () {
        //点击激活状态
        $("#setting-insert").parent().addClass("active");
        $("#settingInsertModel").modal({
            backdrop:"static"
        });
    });

    //模态框关闭按钮绑定时间
    $("#modal_close").click(function () {
        //添加房型模态框关闭解除激活
        $("#setting-insert").parent().removeClass("active");
    });

    //保存按钮
    $("#room_save_input").click(function () {
        $.ajax({
            url:"${APP_PATH}/room",
            type:"POST",
            data:$("#settingInsertModel form").serialize(),
            success:function (result) {
                alert(result.msg);
                $("#settingInsertModel").modal('hide');
                //添加房型模态框关闭解除激活
                $("#setting-insert").parent().removeClass("active");
                get_all_room();

            }

        });
    });

    //单个删除按钮绑定事件
    $(document).on("click","#delete",function () {
        //弹出确认删除对话框
        var roomId=$(this).parents("tr").find("td:eq(0)").text();
        var roomName=$(this).parents("tr").find("td:eq(1)").text();
        if(confirm("确认删除"+roomId+"号"+roomName+"吗？")){
            $.ajax({
                url:"${APP_PATH}/room/"+roomId,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    get_all_room();
                }
            })
        }
    });
    $(document).on("click","#edit",function () {
        //为编辑按钮绑定单击事件
        //取到要修改的订单号
        var roomId=$(this).parents("tr").find("td:eq(0)").text();
        //设置模态框里默认传的值
        $("#roomId").val(roomId);
        $("#editModal").modal({
            backdrop:"static"
        });
    });

    $("#save_edit").click(function () {
        var roomType = $("#roomType_edit_input").val();
        var roomPrice = $("#roomPrice_edit_input").val();
        var roomId = $("#roomId").val();
        //编辑里保存按钮
        $.ajax({
            url:"${APP_PATH}/roomx",
            type:"POST",
            data:{
                "roomType":roomType,
                "roomPrice":roomPrice,
                "roomId":roomId
            },
            success:function (result) {
                alert(result.msg);
                $("#editModal").modal("hide");
                get_all_room();
            }
        });
    });
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" id="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" id="delete">删除</a>
</script>
</body>
</html>
