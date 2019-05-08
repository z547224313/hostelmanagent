<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:forward page="/roomcheck"/>
<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <title>首页</title>
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script type="text/javascript"
            src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

</body>
</html>