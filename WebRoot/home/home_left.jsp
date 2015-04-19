<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>右部导航栏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div class="home_left">
		<!-- 用户头像和昵称 -->
		<div class="home_img">
			<a href="basicinfo/change_head.jsp"><img src='<s:property value="#session.loginUser.head_image" default="upload/default_head.png"/>' width="80px" height="80px"></a>
			<!-- 可以用来链接到基本资料 -->
			<span id="user_email">${session.loginUser.email }</span>
		</div>
		<!-- 在每个分栏下可以进行的操作 -->
		<div class="left_menu">
			<ul>
				<s:if test="#session.menuLevel != null">
					<s:if test="#session.menuLevel ==1">
						<li><a href="basicinfo/basicInfoShow.jsp">基 本 资 料</a>
						</li>
						<li><a href="#">公 司 部 门</a>
						</li>
						<li><a href="#">联 系 同 事</a>
						</li>
					</s:if>
					<s:elseif test="#session.menuLevel ==2">
						<li><a href="salary/salary_model.jsp">薪 酬 模 板</a>
						</li>
						<li><a href="#">薪 酬 变 更</a>
						</li>
						<li><a href="#">薪 酬 组 成</a>
						</li>
					</s:elseif>
					<s:elseif test="#session.menuLevel ==3">
						<li><a href="checkin.action?action=list">考 勤 记 录</a>
						</li>
						<li><a href="#">打   卡   机</a>
						</li>
						<li><a href="#">请 假 申 请</a>
						</li>
					</s:elseif>
					<s:elseif test="#session.menuLevel ==4">
						<li><a href="#">基 本 资 料</a>
						</li>
						<li><a href="#">公 司 部 门</a>
						</li>
						<li><a href="#">联 系 同 事</a>
						</li>
					</s:elseif>
				</s:if>
				<s:else>
					<li>没列表</li>
				</s:else>

			</ul>
		</div>
	</div>
</body>
</html>
