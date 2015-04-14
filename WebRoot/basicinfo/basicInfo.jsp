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

<title>员工基本信息</title>

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
<script type="text/javascript" src="js/basic.js"></script>
<!-- 导入验证框架 -->
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/ymPrompt.js"></script>
<!--自定义弹窗提示插件-->
<script type="text/javascript" src="js/myalert.js"></script>
<!--遮罩提示插件-->
<script type="text/javascript" src="js/jquery.showLoading.js"></script>
<!-- 加载上传组件需要的js -->
<script type="text/javascript" src="js/uploadify/jquery.uploadify.js"></script>
 <script type="text/javascript" src="js/uploadify/swfobject.js"></script>
 
 <script type="text/javascript" src="js/date/jquery-ui.js"></script>
 <script type="text/javascript" src="js/date/ui.datepicker-zh-CN.js"></script>
<!-- 加载省市联动框  -->
 <script type="text/javascript" src="js/select/jquery.city.select.js"></script>
 <script type="text/javascript" src="js/select/prettify.js"></script>
 <script type="text/javascript" src="js/city.js"></script>
<script type="text/javascript">
$(function(){
    $("#birthday").datepicker({
        changeYear:true,
        changeMonth:true,
        dateFormat:'yy-mm-dd',
        showAnim:'fadeIn',
        yearRange:'-50:+0'
    });

})
</script>

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
				<span class="spantxt"><a href="home/home.jsp">首页</a> -> 基本资料</span>
				<div id="info">
					<form action="" method="post" id="basic_form">
						<table>
						  <tr>
						      <td><label for="username">姓名：</label></td>
						      <td><input type="text" name="username" id="username" required="required" value="${session.loginUser.name }"><span>*</span></td>
						  </tr>
						  <tr>
						      <td>性别：</td>
						      <td><label for="male">男：</label><input type="radio" name="sex" value="male" checked="checked" />
						      <label for="female">女：</label><input type="radio" name="sex" value="female"  /></td>
						  </tr>
						  <tr>
						      <td>出生日期：</td>
						      <td><input type="text"  name="birthday" id="birthday" readonly="readonly" value="${session.loginUser.birthday }"/><span>*</span></td>
						  </tr>
						   <tr>
                              <td>政治面貌：</td>
                              <td>
                                  <select id="policies" name="policies"  class="select">
                                     <option value="中共党员">中共党员</option>
                                     <option value="预备党员">预备党员</option>
                                     <option value="共青团员">共青团员</option>
                                     <option value="群众" selected="selected">群众</option>
                                  </select>
                              </td>
                          </tr>
						  <tr>
						      <td>省份：</td>
						      <td>
						          <select id="province"  name="province" class="select">
						             <option value="载入中">载入中</option>
						          </select>
						      </td>
						     
						  </tr>
						  <tr>
                              <td>城市：</td>
                              <td>
                                  <select id="city" name="city" class="select">
                                     <option value="载入中">载入中</option>
                                  </select>
                              </td>
                             
                          </tr>
                          <tr>
                            <td>手机号：</td>
                            <td><input type="text" name="mobile" id="mobile" value="${session.loginUser.mobile }">  <span>*</span></td>
                          
                          </tr>
                           <tr>
                            <td>QQ：</td>
                            <td><input type="text" name="qq" id="qq" value="${session.loginUser.qq }"></td>
                         
                          </tr>
                          <tr>
                            <td colspan="2">
                                <input type="button" value="提  交" class="btn" id="basic_submit">
                                <input type="reset" value="重  置" class="btn">
                            </td>
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
</body>
</html>
