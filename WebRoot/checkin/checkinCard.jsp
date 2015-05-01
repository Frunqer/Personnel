<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>考勤列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/home.css" />
<link rel="stylesheet" href="css/basicinfo.css" />
<link rel="stylesheet" href="css/checkin.css" />

<link rel="stylesheet" href="css/skin/black/ymPrompt.css" />
<link rel="stylesheet" href="css/showLoading.css" />
<link rel="stylesheet" href="css/page/msgbox.css" />
<link rel="stylesheet" href="css/date/jquery-ui.css" />

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/home/home.js"></script>
<script type="text/javascript" src="js/checkin.js"></script>
<script type="text/javascript" src="js/ymPrompt.js"></script>
<!--自定义弹窗提示插件-->
<script type="text/javascript" src="js/myalert.js"></script>
<script type="text/javascript" src="js/page/msgbox.js"></script>
<!--遮罩提示插件-->
<script type="text/javascript" src="js/jquery.showLoading.js"></script>
</head>

<body>
	<div id="home_main">
		&nbsp;
		<!-- 头部导航层 -->
		<jsp:include page="../home/head.jsp"></jsp:include>
		<div id="home_content">
			<!-- 首页右边层 -->
			<jsp:include page="../home/home_left.jsp"></jsp:include>
			<!-- 首页内容展示层-->
			<div class="home_right right_bg ">
				<!-- 面包屑导航  -->
				<span class="spantxt"><a href="home/home.jsp">首页</a> ->
					打卡机</span>
				
				<!-- 打卡机主体结束  -->
			    <div class="checkin_info">
			    	<span class="checkin_border hour" id="hour"></span>
			    	<span class="spilt">:</span>
			    	<span class="checkin_border minute" id="minute"></span>
			    	<span class="spilt">:</span>
			    	<span class="checkin_border second" id="second"></span>
			    
			    	<div><a href="checkin.action?action=daka" class="btn checkin_btn">打  卡</a></div>
			    </div>
				<!-- 打卡机主体部分结束 -->
			</div>
		</div>
		<!-- 版权标识层 -->
		<jsp:include page="../home/foot.html"></jsp:include>
	</div>
	<!-- 主体框架结束 -->
	<div class="shadow"></div>
	<!-- 回顶部层开始 -->
	<div class="toTop"></div>
	<!-- 回顶部层结束 -->
	<script type="text/javascript">
	  function edit(){
	      window.location.href="basicinfo/basicInfo.jsp";
	  }
	  function timeClock(){
		  var d = new Date();
		  document.getElementById("hour").innerHTML = d.getHours();
		  document.getElementById("minute").innerHTML = d.getMinutes();
		  document.getElementById("second").innerHTML = d.getSeconds();
	  }
	  window.setInterval(timeClock, 1000);
	</script>
</body>
</html>
