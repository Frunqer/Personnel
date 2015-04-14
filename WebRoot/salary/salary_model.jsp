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

<title>薪酬福利模板</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/home.css" />
<link rel="stylesheet" href="css/basicinfo.css" />

<link rel="stylesheet" href="css/skin/black/ymPrompt.css" />
<link rel="stylesheet" href="css/showLoading.css" />
<!-- 加载上传组件的css -->
<link rel="stylesheet" href="css/uploadify.css" />

<link rel="stylesheet" href="css/date/jquery-ui.css" />

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/home/home.js"></script>
<script type="text/javascript" src="js/ymPrompt.js"></script>
<!--自定义弹窗提示插件-->
<script type="text/javascript" src="js/myalert.js"></script>
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
				<span class="spantxt"><a href="home/home.jsp">首页</a> -> 薪酬模板</span>
				<div id="info">
				<div class="model_salary">
				    <p>尊敬的<span> 候振杰</span> 先生/女士：
				       <p>欢迎来到贵公司，非常希望我们共同进步<br>
				    <p>   薪酬福利，具体条款如下：
				     <p>(一)预期现金收入为税前人民币:
				       <p>试用期/转正，预期目标年薪为，税前人民币 <span>11.7 万/年</span>，包含的薪酬项目为月度基薪(基本工资、固定加班费等)、月度绩效和年度奖金，其中月度绩效和年度奖金实际发放金额根据公司绩效考核方案和个人绩效达成支付。
				       <p>个人月度薪酬结构根据入职后当时的公司的薪酬结构进行月份薪酬的拆分，同时享受入职定岗后后的公司规定的相关福利补贴，如餐补或免费餐、全勤奖等。
				       <p>个人薪酬构成及细节及本文文件属于商业秘密，请您予以保密。
				      
				       <p>(二)福利
				       <p>公司将按照法律规定为您叫乃社会保险及住房公积金
				       <p>(三)个人所得税
				       <p>根据国家规定，个人所得税应有个人承担，并有公司扣代缴。
				</div>
				        
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
</body>
</html>
