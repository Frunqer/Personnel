<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人事通企业主页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/home.css"/>
    <link rel="stylesheet" href="css/lunbo.css"/>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/skin/black/ymPrompt.css"/>
    <link rel="stylesheet" href="css/showLoading.css"/>

    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/home/home.js"></script>
    <!-- 仿淘宝的轮播滚动 -->
    <script type="text/javascript" src="js/home/lunbo.js"></script>
    <script type="text/javascript" src="js/ymPrompt.js"></script>
    <!--自定义弹窗提示插件-->
    <script type="text/javascript" src="js/myalert.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/jquery.form.js"></script>
    <!--遮罩提示插件-->
    <script type="text/javascript" src="js/jquery.showLoading.js"></script>
  </head>
  
  <body>
    <div id="home_main">&nbsp; 
    <!-- 头部导航层 -->
    <jsp:include page="head.jsp"></jsp:include>
    <div id="home_content">
    <!-- 首页右边层 -->
    <jsp:include page="home_left.jsp"></jsp:include>
    <!-- 首页内容展示层-->
    <div class="home_right">
        <div class="banner">
            <div class="banner-btn">
                <a href="javascript:;" class="prevBtn"><i></i></a>
                <a href="javascript:;" class="nextBtn"><i></i></a>
            </div>
            <ul class="banner-img">
                <li><a href="#"><img src="images/img/1.jpg"></a></li>
                <li><a href="#"><img src="images/img/2.jpg"></a></li>
                <li><a href="#"><img src="images/img/3.jpg"></a></li>
                <li><a href="#"><img src="images/img/4.jpg"></a></li>
                <li><a href="#"><img src="images/img/5.jpg"></a></li>
                <li><a href="#"><img src="images/img/6.jpg"></a></li>
            </ul>
            <ul class="banner-circle"></ul>
        </div>
        <div class="notice">
            <span>企业公告</span><span><a href="notice.action?action=more">more</a></span>
            
            
            <s:if test="#session.notices!=null">
                <ul>
                <s:iterator  value="#session.notices" var="notice">
                    <li>
                    	<a href="notice.action?action=single&id=<s:property value="id"/>">
                    		<s:property value="title" />
                    	</a></li>
                </s:iterator>
                </ul>
            </s:if>
            <s:else>
                <span>对不起暂时没有公告！</span>
            
            </s:else>
            
        </div>
        <div class="chekin">
            <span>员工签到</span>
            <!-- 打卡机，仿造京东的内部打卡系统 -->
            <a class="sign" href="checkin.action?action=daka">
            <!-- 显示签到的日期 -->
                <span class="sign_number"></span>
            </a>
        </div>
    </div>
    </div>
    <!-- 版权标识层 -->
    <jsp:include page="foot.html"></jsp:include>
</div>
<!-- 主体框架结束 -->
<!-- 回顶部层开始 -->
<div class="toTop">
</div>
<!-- 回顶部层结束 -->
  </body>
</html>
