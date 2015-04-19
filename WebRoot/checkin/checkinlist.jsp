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
					考勤列表</span>
				<div id="info">
				        <form>
				            <select id="month" class="monthSelect">
				                <option value="01">1月</option>
				                <option value="02">2月</option>
				                <option value="03">3月</option>
				                <option value="04">4月</option>
				                <option value="05">5月</option>
				                <option value="06">6月</option>
				                <option value="07">7月</option>
				                <option value="08">8月</option>
				                <option value="09">9月</option>
				                <option value="10">10月</option>
				                <option value="11">11月</option>
				                <option value="12">12月</option>
				            </select>
				            <input type="button" class="btn checkin_search" value="搜  索">
				        </form>
				        <div>
				            <span>
				                 <s:property value="#session.loginUser.name" default="客官"/>,您在<s:property value="#session.month"/>月的考勤记录如下表
				            </span>
				        </div>
				        <table class="stripe">
				            <tr>
				                <th>考勤Email</th>
				                <th>上班打卡</th>
				                <th>下班打卡</th>
				                <th>上班状态</th>
				                <th>下班状态</th>
				                <th>考勤状态</th>
				            </tr>
				            <s:iterator value="#session.checkinList" var="checkin">
				              <tr>
                                <td><s:property  value="email"/></td>
                                <td><s:date name="check_morning" format="yy-MM-dd HH:mm:ss"/></td>
                                <td><s:date name="check_night" format="yy-MM-dd HH:mm:ss"/></td>
                                <td><s:property  value="morning_status"/></td>
                                <td><s:property  value="night_status"/></td>
                                <td><s:property  value="status"/></td>
                             </tr>
				            </s:iterator>
				           
				        </table>
				</div>
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
	</script>
</body>
</html>
