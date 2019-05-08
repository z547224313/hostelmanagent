<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/28
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单页面</title>
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
                            <label for="peoName_add_input">
                                <span class=" glyphicon glyphicon-user" aria-hidden="true"></span>
                                姓名
                            </label>
                            <input type="text" name="peoName" class="form-control" id="peoName_add_input" >
                        </div>
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="peoPhone_add_input">
                                <span class="  glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
                                手机
                            </label>
                            <input type="email" class="form-control " name="peoPhone" id="peoPhone_add_input" >
                        </div>
                    </form>
                </div>
                <div class="row">
                    <form class="form-inline">
                        <div class="form-group">
                            <div class="col-sm-10">
                                <%--默认传送一个隐藏的订单号--%>
                                <input type="hidden" id="orderId">
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

<nav class="navbar navbar-default">
    <div class="container-fluid" id="head-bar">
        <div class="navbar-header">
            <a class="navbar-brand" >HostelManagent</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-right">
                <li><a href="roomPage">房态</a></li>
                <li class="active"><a href="#">订单</a></li>
                <li><a href="peoplePage">客人</a></li>
                <li><a href="earningPage">统计</a></li>
                <li><a href="setting">管理</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<table id="orderTable" >

</table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit" id="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" id="delete">删除</a>
</script>
<script>
    loadPage();

    $(document).on("click","#edit",function () {
        //为编辑按钮绑定单击事件
        //取到要修改的订单号
        var ordId=$(this).parents("tr").find("td:eq(6)").next().text();
        //设置模态框里默认传的值
        $("#orderId").val(ordId);
        $("#editModal").modal({
            backdrop:"static"
        });
    });

    $(document).on("click","#delete",function () {
        var ordId=$(this).parents("tr").find("td:eq(6)").next().text();
        if(confirm("确认删除吗？")){
            $.ajax({
                url:"${APP_PATH}/deleteOrder",
                type:"POST",
                data:"orderId="+ordId,
                success:function (result) {
                    loadPage();
                }
            });
        }
    });

    $("#save_edit").click(function () {
        var peoName = $("#peoName_add_input").val();
        var peoPhone = $("#peoPhone_add_input").val();
        var orderId = $("#orderId").val();
        //编辑里保存按钮
        $.ajax({
            url:"${APP_PATH}/orderx",
            type:"POST",
            data:{
                "peoName":peoName,
                "peoPhone":peoPhone,
                "orderId":orderId
            },
            success:function (result) {
                $("#editModal").modal("hide");
                loadPage();
            }
        });
    });

    function loadPage() {
        //载入页面
        $.ajax({
            url:"${APP_PATH}/orderx",
            type:"GET",
            success:function (result) {
                console.log(result);
                layui.use('table', function(){
                    var table = layui.table;
                    //第一个实例
                    table.render({
                        elem: '#orderTable'
                        ,height: 500
                        ,data: result.extend.orderMain
                        ,page: true //开启分页,
                        ,limits : "[5,10,15,20,25,30,35,40,45,50]"
                        ,cols: [[ //表头
                            {field: 'peoName', title: '客人姓名', width:150}
                            ,{field: 'peoPhone', title: '手机号', width:200}
                            ,{field: 'ordTime', title: '预定日期', width:200}
                            ,{field: 'endTime', title: '退房日期', width: 200}
                            ,{field: 'room', title: '房间', width: 150}
                            ,{field: 'orderFee', title: '费用', width: 130, sort: true}
                            ,{field: 'ordStatus', title: '订单状态', width: 160 }
                            ,{field: 'ordId',title: '订单号',hide:true}
                            ,{width:150, title:'操作', toolbar: '#barDemo'}
                        ]]
                    });
                });
            }

        });
    }
</script>
</body>
</html>
