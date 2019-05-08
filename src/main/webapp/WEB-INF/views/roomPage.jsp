<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/28
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房态</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
        <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript"
            src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${APP_PATH}/static/jqueryui/jquery-ui.min.css">
    <script src="${APP_PATH}/static/jqueryui/jquery-ui.min.js"></script>
    </head>
<body>
<%--已入住模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="checkinModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">已入住</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <form class="form-inline">
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="peoName_add_input">
                                <span class=" glyphicon glyphicon-user" aria-hidden="true"></span>
                                姓名
                            </label>
                            <p class="form-control-static col-sm-offset-3" id="checkin_name"></p>
                        </div>
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="peoName_add_input">
                                <span class=" glyphicon glyphicon-user" aria-hidden="true"></span>
                                手机
                            </label>
                            <p class="form-control-static col-sm-offset-3" id="checkin_phone"></p>
                        </div>
                    </form>
                </div>
                <div class="row">
                    <form class="form-inline">
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="peoName_add_input">
                                <span class=" glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                                入住日期
                            </label>
                            <p class="form-control-static col-sm-offset-3" id="checkin_time_in"></p>
                        </div>
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="peoName_add_input">
                                <span class=" glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                                退房日期
                            </label>
                            <p class="form-control-static col-sm-offset-3" id="checkin_time_out"></p>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <%--默认传送一个隐藏的订单号--%>
                                <input type="hidden" id="checkin_orderId">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" id="check_out">办理退房</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<%--已预定模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="orderedModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">已预定</h4>
            </div>
            <div class="modal-body">
               <div class="row">
                   <form class="form-inline">
                       <div class="form-group col-sm-6" style="padding-bottom: 15px">
                           <label for="peoName_add_input">
                               <span class=" glyphicon glyphicon-user" aria-hidden="true"></span>
                               姓名
                           </label>
                           <p class="form-control-static col-sm-offset-3" id="ordered_name"></p>
                       </div>
                       <div class="form-group col-sm-6" style="padding-bottom: 15px">
                           <label for="peoName_add_input">
                               <span class=" glyphicon glyphicon-user" aria-hidden="true"></span>
                               手机
                           </label>
                           <p class="form-control-static col-sm-offset-3" id="ordered_phone"></p>
                       </div>
                   </form>
               </div>

                <div class="row">
                    <form class="form-inline">
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="peoName_add_input">
                                <span class=" glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                                入住日期
                            </label>
                            <p class="form-control-static col-sm-offset-3" id="ordered_time_in"></p>
                        </div>
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label for="peoName_add_input">
                                <span class=" glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                                退房日期
                            </label>
                            <p class="form-control-static col-sm-offset-3" id="ordered_time_out"></p>
                        </div>
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
                <button type="button" class="btn btn-primary" id="check_in">办理入住</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<%--房态主表模态框--%>
<div class="modal fade" tabindex="-1" role="dialog" id="mainModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">预定</h4>
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
                                <span class=" glyphicon glyphicon-phone-alt" aria-hidden="true"></span>
                                手机
                            </label>
                            <input type="email" class="form-control " name="peoPhone" id="peoPhone_add_input" >
                        </div>
                    </form>
                </div>
                <div class="row">
                    <form class="form-inline">
                        <div class="form-group col-sm-6 " style="padding-bottom: 15px">
                            <label>
                                <span class=" glyphicon glyphicon-list-alt" aria-hidden="true"></span>
                                日期
                            </label>
                            <p class="form-control-static col-sm-offset-3" id="date_static"></p>
                        </div>
                        <div class="form-group col-sm-6" style="padding-bottom: 15px">
                            <label >
                                <span class=" glyphicon glyphicon-time" aria-hidden="true"></span>
                                几晚
                            </label>
                            <select class="form-control" id="night" style="width: 196px">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                                <option>10</option>
                                <option>11</option>
                                <option>12</option>
                                <option>13</option>
                                <option>14</option>
                                <option>15</option>
                                <option>16</option>
                                <option>17</option>
                                <option>18</option>
                                <option>19</option>
                                <option>20</option>
                                <option>21</option>
                                <option>22</option>
                                <option>29</option>
                                <option>24</option>
                                <option>25</option>
                                <option>26</option>
                                <option>27</option>
                                <option>28</option>
                                <option>29</option>
                                <option>30</option>
                            </select>
                        </div>
                    </form>
                </div>
                <div class="row">
                    <form class="form-inline">
                        <div class="form-group col-sm-6">
                            <label >
                                <span class="glyphicon glyphicon-tags" aria-hidden="true"></span>
                                房间
                            </label>
                            <p class="form-control-static  col-sm-offset-3" id="room_num"></p>
                        </div>
                        <div class="form-group col-sm-6">
                            <label >
                                <span class=" glyphicon glyphicon-piggy-bank" aria-hidden="true"></span>
                                房费￥
                            </label>
                            <p class="form-control-static  col-sm-offset-3" id="room_price"></p>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <%--默认传送一个隐藏的房间状态是1预定--%>
                                <input type="hidden" id="roomStatus" value="1"  >
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="order_save">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid" id="head-bar">
        <div class="navbar-header">
            <a class="navbar-brand" >HostelManagent</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav ">
                <li> <a id="get_room">查询房态</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#">房态<span class="sr-only">(current)</span></a></li>
                <li><a href="orderPage">订单</a></li>
                <li><a href="peoplePage">客人</a></li>
                <li><a href="earningPage">统计</a></li>
                <li><a href="setting">管理</a></li>
            </ul>
        </div>
    </div>
</nav>
<div style="width:100% ;height:100% ;">
    <%--房间类型显示部分--%>
    <div style="width: 143px;height:100% ;float: left;left: 0;">
        <input class="btn btn-default btn-lg"  id="datepicker" style="width: 143px;height: 40px" type="button" value="请先选择时间">
        <div style="width: 143px;height:100% " >
            <table class="table table-bordered" id="room_type" style="text-align: center;">
            </table>
        </div>
    </div>
    <%--房态主要部分--%>
    <div style="width:85%;height:100% ;float:left">
        <table class="table table-bordered">
            <thead>
            <tr id="room_main_head">
                <%--日期表头内容--%>
            </tr>
            </thead>
            <tbody id="room_main">
             <%--房态位置--%>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    var set_time;//将设定好的时间存下来
    $(function() {
        $( "#datepicker" ).datepicker({dateFormat: "yy-mm-dd"});
    });

    $("#check_in").click(function () {
       //为已经预定状态模特框中办理入住按钮绑定事件
       //1、修改该订单的房间状态1->2
       $.ajax({
         url:"${APP_PATH}/status",
           type:"POST",
           data:{
               "orderId":$("#orderId").val(),
               "status":"2"
           },
           success:function (result) {
           }
       });
        //关闭模态框
        $("#orderedModal").modal('hide');
        //2、重新载入主房态页面//本来用settablemain就可以，但是不加上面那个就没法黄
        set_table_type();
        set_table_main();

    });

    $("#check_out").click(function () {
        //为已经预定状态模特框中办理入住按钮绑定事件
        //1、修改该订单的房间状态1->2
        $.ajax({
            url:"${APP_PATH}/status",
            type:"POST",
            data:{
                "orderId":$("#checkin_orderId").val(),
                "status":"3"
            },
            success:function (result) {
            }
        });
        //关闭模态框
        $("#checkinModal").modal('hide');
        //2、重新载入主房态页面//本来用settablemain就可以，但是不加上面那个就没法黄
        set_table_type();
        set_table_main();

    });

    $("#order_save").click(function () {
        //为空房模态框中保存按钮绑定事件
        //1、保存生成order
       save_order();
       //2、保存客人信息
        save_people();
        //关闭模态框
        $("#mainModal").modal('hide');
        //3、重新载入主房态页面
        set_table_type();
        set_table_main();
    });

    $("#night").change(function () {
        var title = $("#room_num").text();
        //动态计算房费
        $.ajax({
            url:"${APP_PATH}/calPrice",
            data:{
                title:encodeURI(title),//中文依旧乱码，但只用数字部分
                night:$("#night").val()
            },
            type:"GET",
            success:function (result) {
                //取出金额设置每种房间的金额
                $("#room_price").empty();
                $("#room_price").append(result.extend.price);
            }
        });
    });

    $("#get_room").click(function () {
        //为查询房态按钮绑定按键
        //1、获取用户设定日期
        set_time= $( "#datepicker" ).val();
        //2、先添加查询表首从设定日期处开始
        set_table_head(set_time);
        //3、设置左方房型栏
        set_table_type();
        //4、填充主表格
        set_table_main();
        //5、为主表格设置模态框并绑定单击事件
        set_table_main_click();


    });


    function set_table_main_click() {
        //5、为主表格空房状态设置模态框
        $(document).on("click",".bg",function () {
            var idx = $(this).attr("idx");//这个按钮所在列数从0开始
            //想个办法把表头的日期取到
            var date=$(this).parents("table").find("th:eq("+idx+")").text();
            //取到td中title标签
            var title=$(this).attr("title");
            //为日期标签设置固定值,先清空
            $("#date_static").empty();
            $("#date_static").append(date);
            //设置房间类型房间号固定值，先清空
            $("#room_num").empty();
            $("#room_num").append(title);
            //发送ajax请求查询该房间价格
            $.ajax({
               url:"${APP_PATH}/checkPrice",
               data:{
                   title:encodeURI(title)//中文依旧乱码，但只用数字部分
               },
               type:"GET",
               success:function (result) {
                   //取出金额设置每种房间的金额
                   $("#room_price").empty();
                   $("#room_price").append(result.extend.price);
               }
            });
            if(!$(this).hasClass("ordered")&&!$(this).hasClass("checkin")&&!$(this).hasClass("checkout"))//屏蔽预定/入住状态按钮
            $("#mainModal").modal({
                backdrop:"static"
            });
        });

        // ordered状态房间按钮设置弹出模态框
        $(document).on("click","#ordered",function () {
            var orderId=$(this).attr("orderId");
            //根据按钮上绑定的orderId属性发送ajax请求寻找信息填充
            $.ajax({
                url:"${APP_PATH}/orderBtn",
                type:"GET",
                data:"orderId="+orderId,
                success:function (result) {
                    console.log(result);
                    $("#ordered_name").empty();
                    $("#ordered_name").append(result.extend.peoName);
                    $("#ordered_phone").empty();
                    $("#ordered_phone").append(result.extend.peoPhone);
                    $("#ordered_time_in").empty();
                    $("#ordered_time_in").append(result.extend.beginTime);
                    $("#ordered_time_out").empty();
                    $("#ordered_time_out").append(result.extend.endTime);
                    $("#orderId").empty();
                    $("#orderId").val(orderId);
                }
            });
            $("#orderedModal").modal({
                backdrop:"static"
            });
        });

        //checkin状态房间按钮设置弹出模态框
        $(document).on("click","#checkin",function () {
            var orderId=$(this).attr("orderId");
            //根据按钮上绑定的orderId属性发送ajax请求寻找信息填充
            $.ajax({
                url:"${APP_PATH}/orderBtn",
                type:"GET",
                data:"orderId="+orderId,
                success:function (result) {
                    console.log(result);
                    $("#checkin_name").empty();
                    $("#checkin_name").append(result.extend.peoName);
                    $("#checkin_phone").empty();
                    $("#checkin_phone").append(result.extend.peoPhone);
                    $("#checkin_time_in").empty();
                    $("#checkin_time_in").append(result.extend.beginTime);
                    $("#checkin_time_out").empty();
                    $("#checkin_time_out").append(result.extend.endTime);
                    $("#checkin_orderId").empty();
                    $("#checkin_orderId").val(orderId);
                }
            });
            $("#checkinModal").modal({
                backdrop:"static"
            });
        });

        $(document).on("click","#checkout",function () {
           alert("已退房");
        });
    }
    
    function date_minus(orderTime) {
        //订单时间与设定时间做减法
        //返回的是distance
        //算法公式：begin=distance
        //end=distance+night
        var a =Date.parse(new Date(orderTime));
        var b =Date.parse(new Date(set_time));
        return parseInt((a - b) / (1000 * 60 * 60 * 24));
    }

    function set_table_main() {
        $.ajax({
            url:"${APP_PATH}/roomType",
            type:"GET",
            success:function (result) {
                console.log(result);
                //开始拼接房态部分
                $("#room_main").empty();
                var Type=result.extend.roomType;
                var Order=result.extend.orderMain;
                $.each(Type,function (index,item) {
                    //一层循环遍历房间类型名称
                    var TypeNum = item.typeRoomNum;//房间类型号List
                    var TypeName = item.typeName;//房间类型名
                    // $.each(Order,function (index,item) {
                    //    //二层遍历order
                    //    var night = item.night;
                    //    var ordTime = item.ordTime;
                    //    var ordRoomId = item.ordRoomId;
                    //    $.each(TypeNum,function (index,item) {
                    //       //三曾遍历房间号
                    //        var trTd = $("<tr></tr>");
                    //        for(var i=0;i<30;i++){
                    //            var tdTd = $("<td></td>");
                    //            var title = TypeName+"-"+item;
                    //            if(ordRoomId == item){
                    //                var distance= date_minus(ordTime);
                    //                var begin=distance;
                    //                var end = distance+night;
                    //                if(i>=begin&&i<end){
                    //                    tdTd.addClass("ordered").prop("title",title).attr("idx",i).appendTo(trTd);
                    //                }else
                    //                    tdTd.addClass("bg").prop("title",title).attr("idx",i).appendTo(trTd);
                    //            }else
                    //                tdTd.addClass("bg").prop("title",title).attr("idx",i).appendTo(trTd);
                    //        }
                    //
                    //    });
                    // });
                    $.each(TypeNum,function (index,item) {
                        //二层遍历遍历房间号
                        var trTd = $("<tr></tr>");//每一个房间号生成一个tr
                        //循环30天
                        for(var i=0;i<30;i++){
                            var tdTd = $("<td></td>");
                            var title = TypeName+"-"+item;//显示标签
                            var Id = item;//下一个循环检验用的
                            $.each(Order,function (index,item) {
                                //三层遍历遍历order
                                if(item.ordRoomId == Id)
                                {   //这个item.ordRoomId有多种可能，所以当这个房间号在order中时，也有可能进去下面的else判断
                                    //如果房间状态是 订房（1） 或 入住（2）
                                    //说明这一行要绿
                                    //还要判断日期（那一列要绿）
                                    //算出区间
                                    //算法公式：begin=distance
                                    //end=distance+night
                                    var distance= date_minus(item.ordTime);
                                    var begin=distance;
                                    var end = distance+item.night;
                                    //alert("distance:"+distance+"end:"+end);
                                    //alert(item.night);
                                    if(i>=begin&&i<end){
                                        //每一列每个块有单独按钮(在这个区间的都是特殊按钮，1已经预定，2已经入住)
                                        if(item.ordStatus==1)
                                        tdTd.addClass("ordered").prop("title",title).attr("idx",i).text(item.peoName).attr("id","ordered").attr("orderId",item.ordId).appendTo(trTd);
                                        else if(item.ordStatus==2)
                                            tdTd.addClass("checkin").prop("title",title).attr("idx",i).text(item.peoName).attr("id","checkin").attr("orderId",item.ordId).appendTo(trTd);
                                        else if(item.ordStatus==3)
                                            tdTd.addClass("checkout").prop("title",title).attr("idx",i).text(item.peoName).attr("id","checkout").attr("orderId",item.ordId).appendTo(trTd);
                                    }else{
                                        tdTd.addClass("bg").prop("title",title).attr("idx",i).appendTo(trTd);
                                    }

                                }else if(item.ordRoomId != Id)
                                    tdTd.addClass("bg").prop("title",title).attr("idx",i).appendTo(trTd);
                            });//endeach

                        }//endfor
                        trTd.appendTo($("#room_main"));
                    });
                });

            }
        });
    }

    function set_table_head(time) {
        //发送AJAX请求处理时间
        $.ajax({
            url:"${APP_PATH}/date",
            type:"POST",
            data:"time="+time,
            success:function (result) {
                console.log(result);
                //开始拼接页首
                $("#room_main_head").empty();
                var dateList = result.extend.dateList;

                $.each(dateList,function (index,item) {
                    var table_handTd = $("<th></th>").append(item).attr("nowrap","nowrap");

                    table_handTd.appendTo($("#room_main_head"));
                })

            }
        });
    }

    function set_table_type() {
        //发送ajax请求获取房间类型和每种房间数量
        $.ajax({
            url:"${APP_PATH}/roomType",
            type:"GET",
            success:function (result) {
                console.log(result);
                //开始拼接房间类型部分
                $("#room_type").empty();
                var Type=result.extend.roomType;

                $.each(Type,function (index,item) {
                    var falg=1;
                    var TypeNum = item.typeRoomNum;
                    var TypeNameTd=$("<td></td>").append(item.typeName).prop("rowspan",item.typeNum).addClass("roomTypestyle");
                    var trTd = $("<tr></tr>");
                    TypeNameTd.appendTo(trTd);
                    $("<td></td>").append(item.typeRoomNum[0]).addClass("roomTypestyle").appendTo(trTd);
                    trTd.appendTo($("#room_type"));
                    $.each(TypeNum,function (index,item) {
                        if(falg==1){
                            falg++;
                            return true;
                        }
                        var trTdx = $("<tr></tr>");
                        var TypeId = $("<td></td>").append(item).addClass("roomTypestyle");
                        TypeId.appendTo(trTdx);
                        trTdx.appendTo($("#room_type"));
                    });

                });
            }
        });
    }

    function save_order() {
        //绑定给保存按钮，产生订单信息
        var peoName=$("#peoName_add_input").val();
        var peoPhone=$("#peoPhone_add_input").val();
        var order_time=$("#date_static").text();
        var night=$("#night").val();
        var room_num=$("#room_num").text();
        var ord_fee=$("#room_price").text();
        var ord_status=$("#roomStatus").val();

        $.ajax({
            url:"${APP_PATH}/order",
            type:"POST",
            data:{
                "peoName":peoName,
                    "peoPhone":peoPhone,
                    "order_time":order_time,
                    "night":night,
                    "room_num":room_num,
                    "ord_fee":ord_fee,
                    "ord_status":ord_status
            },
            dateType:"json",
            success:function (result) {
                //点击完保存按钮，这时候当前按钮对应房间的状态需要改变
            }
        });
    }

    function save_people() {
        //绑定给保存按钮，产生客人信息
        var peoName=$("#peoName_add_input").val();
        var peoPhone=$("#peoPhone_add_input").val();
        var ord_fee=$("#room_price").text();
        $.ajax({
            url:"${APP_PATH}/people",
            type:"POST",
            data:{
                "peoName":peoName,
                "peoPhone":peoPhone,
                "ord_fee":ord_fee
            },
            dateType:"json",
            success:function () {

            }
        })
    }
</script>
<style type="text/css">
    <%--防止导航条和房间栏遮挡--%>
    body{
        margin-top: 51px;
        /*margin-left: 143px;*/

    }
    /*房态选择大表格中td（status为0空房）样式*/
    .bg{
        cursor: pointer;
        height: 39px;

    }
    .bg:hover{
        cursor: pointer;
        height: 39px;
        background-color:	#E8E8E8;
    }
    /*已预定样式*/
    .ordered{
        cursor: pointer;
        height: 39px;
        background-color: green;
    }
    .ordered:hover{
        cursor: pointer;
        height: 39px;
        background-color: #419641;
    }
    /*已入住样式*/
    .checkin{
        cursor: pointer;
        height: 39px;
        background-color: #ec971f;
    }
    .checkin:hover{
        cursor: pointer;
        height: 39px;
        background-color: #f0ad4e;
    }

    /*已退房样式*/
    .checkout{
        cursor: pointer;
        height: 39px;
        background-color: #888888;
    }
    .checkout:hover{
        cursor: pointer;
        height: 39px;
        background-color: #adadad;
    }
    /*左边房型样式*/
    .roomTypestyle{
        cursor: pointer;
        vertical-align:middle;
    }
    .roomTypestyle:hover{
        cursor: pointer;
        vertical-align:middle;
        background-color:	#E8E8E8;
    }

    /*滚动条*/
    #room_type{
        overflow-x: hidden;
        overflow-y: scroll;
    }
</style>
</body>
</html>
