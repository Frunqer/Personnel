<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String pageCount =(String)session.getAttribute("pageCount");
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>公告列表页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/home.css" />
<link rel="stylesheet" href="css/notice.css" />
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/page/page.css" />
<link rel="stylesheet" href="css/skin/black/ymPrompt.css" />
<link rel="stylesheet" href="css/showLoading.css" />
<link rel="stylesheet" href="css/page/msgbox.css" />


<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/home/home.js"></script>
<script type="text/javascript" src="js/ymPrompt.js"></script>
<!--自定义弹窗提示插件-->
<script type="text/javascript" src="js/myalert.js"></script>

<!-- 分页组件  -->
<script type="text/javascript" src="js/page/jquery.myPagination6.0.js"></script>
<script type="text/javascript" src="js/page/msgbox.js"></script>
<script type="text/javascript" src="js/page/page.js"></script>
</head>

<body>
	<div id="home_main">
		&nbsp;
		<!-- 头部导航层 -->
		<jsp:include page="../home/head.jsp"></jsp:include>
		<div id="home_content">
			<!-- 首页右边层 -->
			<jsp:include page="../home/home_left.jsp"></jsp:include>
			<!-- 通知列表展示页 -->
			<div class="home_right right_bg list_notice">
				<!-- 面包屑导航  -->
				<span class="spantxt"><a href="home/home.jsp">首页</a> -> 公告列表</span>

				<p
					style="margin-left: 20px; margin-top: 10px;margin-bottom: 10px;font-family: WebFont; font-size: large;">公告列表</p>
				<hr>
				<!-- 用于列表的显示  -->
				<div id="list">
				   
				</div>
				<!-- 用于分页信息的显示  -->
				<div id="example"></div>

			</div>
		</div>
		<!-- 版权标识层 -->
		<jsp:include page="../home/foot.html"></jsp:include>
	</div>

	<!-- 主体框架结束 -->
	<!-- 回顶部层开始 -->
	<div class="toTop"></div>
	<!-- 回顶部层结束 -->
</body>
</html>
