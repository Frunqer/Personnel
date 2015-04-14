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

<title>头部导航栏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>

	<!-- 头部导航层 -->
	<div class="head">
		<ul>
			<li><a href="menu.action?num=1"><img src="images/head/filebg.png">
			</a>
			</li>
			<li><a href="menu.action?num=2"><img src="images/head/salary.png">
			</a>
			</li>
			<li><a href="menu.action?num=3"><img src="images/head/check.png">
			</a>
			</li>
			<li><a href="menu.action?num=4"><img src="images/head/work.png">
			</a>
			</li>
		</ul>
		<!-- 用户名显示部位 -->
		<div class="head_user">
			<s:if test="#session.loginUser!=null">
			    您好：  <s:property value="#session.loginUser.email"/> /<a href="user.action?action=logout" style="text-decoration: none;color: black;">退出</a>
			</s:if>
			<s:else>
				<script>
					window.location.href = "relogin.html";
				</script>
			</s:else>
		</div>
	</div>
</body>
</html>
