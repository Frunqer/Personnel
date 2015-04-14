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

<title>员工信息预览页</title>

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

<link rel="stylesheet" href="css/date/jquery-ui.css" />

<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/home/home.js"></script>
<script type="text/javascript" src="js/basic.js"></script>
<!-- 导入验证框架 -->
<script type="text/javascript" src="js/jquery.validate.js"></script>
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
				<span class="spantxt"><a href="home/home.jsp">首页</a> ->
					基本资料预览</span>
				<div id="info">
				<form>
					<table>
						<tr>
							<td><label for="username">姓名：</label>
							</td>
							<td><s:if test="#session.loginUser.name !=null">
						              ${session.loginUser.name }
						          </s:if> <s:else>
						                  还没设置哦！
						          </s:else></td>
						</tr>
						<tr>
							<td>性别：</td>
							<td><s:if test="#session.loginUser.sex !=null">
                                      ${session.loginUser.sex }
                                  </s:if>
                                  <s:else>
                                                                             还没设置哦！
                                  </s:else>
							</td>
						</tr>
						<tr>
							<td>出生日期：</td>
							<td><s:if test="#session.loginUser.name !=null">
                                      ${session.loginUser.birthday }
                                  </s:if> <s:else>
                                          还没设置哦！
                                  </s:else>
							</td>
						</tr>
						<tr>
							<td>政治面貌：</td>
							<td><s:if test="#session.loginUser.name !=null">
                                      ${session.loginUser.policies }
                                  </s:if> <s:else>
                                          还没设置哦！
                                  </s:else></td>
						</tr>
						<tr>
							<td>家乡：</td>
							<td><s:if test="#session.loginUser.name !=null">
                                      ${session.loginUser.native_home }
                                  </s:if> <s:else>
                                                                                                            还没设置哦！
                                  </s:else></td>

						</tr>

						<tr>
							<td>手机号：</td>
							<td><s:if test="#session.loginUser.name !=null">
                                      ${session.loginUser.mobile }
                                  </s:if> <s:else>
                                          还没设置哦！
                                  </s:else>
							</td>

						</tr>
						<tr>
							<td>QQ：</td>
							<td><s:if test="#session.loginUser.name !=null">
                                      ${session.loginUser.qq }
                                  </s:if> <s:else>
                                                             还没设置哦！
                                  </s:else></td>

						</tr>
						<tr>
							<td colspan="2"><input type="button" value="修改"
								class="btn" onclick="edit()"></td>
						</tr>
					</table>
					</form>
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
