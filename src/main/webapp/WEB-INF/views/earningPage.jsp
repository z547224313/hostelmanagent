<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/28
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收入统计</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript"
            src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/static/echarts/http_cdn.bootcss.com_echarts_4.2.1-rc1_echarts-en.common.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid" id="head-bar">
        <div class="navbar-header">
            <a class="navbar-brand" >HostelManagent</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-right">
                <li><a href="roomPage">房态</a></li>
                <li><a href="orderPage">订单</a></li>
                <li><a href="peoplePage">客人</a></li>
                <li class="active"><a href="#">统计</a></li>
                <li><a href="setting">管理</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid" style="border: 1px solid #c5c5c5">
    <div class="row">
        <div class="col-md-4">
            <h3>客房运营总览</h3>
        </div>
    </div>
    <div class="row" id="msg">
        <div class="col-md-4 col-sm-offset-3" >
            <p>
                共
                <strong style="color: orange; font-size: 30px" id="all_night">

                </strong>
                间夜，
                <strong style="color: orange; font-size: 30px" id="income">

                </strong>
                元
            </p>
            <p style="color: lightgray">有效订单</p>
        </div>
        <div class="col-sm-5" style="float: right">
        <p>
            <strong style="color: orange; font-size: 30px" id="ADR">

            </strong>
            元
        </p>
            <p style="color: lightgray">平均房价</p>
    </div>
    </div>

</div>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;float: right"></div>
<div id="main2" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    //客房运营总览
   $.ajax({
      url:"${APP_PATH}/statistic",
       type:"GET",
       success:function (result) {
            $("#msg strong").empty();
            $("#all_night").append(result.extend.allNight);
            $("#income").append(result.extend.income);
            $("#ADR").append(result.extend.ADR);
       }
   });
</script>
<script type="text/javascript">
    //过去三十天营业收入图表
    // 基于准备好的dom，初始化echarts实例
    var inComeChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    inComeChart.setOption({
        title: {
            text: '过去30天营业收入趋势'
        },
        tooltip: {},
        legend: {
            data:['收入']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '收入',
            type: 'line',
            data: []
        }]
    });
    // 使用刚指定的配置项和数据显示图表。

    $.ajax({
        url:"${APP_PATH}/incomeChart",
        type:"GET",
        success:function(result) {
            console.log(result);
            inComeChart.setOption({
                xAxis: {
                    data: result.Date
                },
                legend: {
                    data:['收入']
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '收入',
                    data: result.Price
                }]
            });
        }
    });
</script>
<script type="text/javascript">
    //过去三十天平均房价图表
    var ADRChart = echarts.init(document.getElementById('main2'));
    ADRChart.setOption({
        title: {
            text: '过去30天平均房价'
        },
        tooltip: {},
        legend: {
            data:['价格']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '价格',
            type: 'line',
            data: []
        }]
    });

    $.ajax({
        url:"${APP_PATH}/ADRChart",
        type:"GET",
        success:function(result) {
            console.log(result);
            ADRChart.setOption({
                xAxis: {
                    data: result.Date
                },
                legend: {
                    data:['价格']
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '价格',
                    data: result.Price
                }]
            });
        }
    });

</script>
</body>
</html>
