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
    
    <title>公告页</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/home.css"/>
    <link rel="stylesheet" href="css/notice.css"/>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/skin/black/ymPrompt.css"/>
    <link rel="stylesheet" href="css/showLoading.css"/>

    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/home/home.js"></script>
    <script type="text/javascript" src="js/ymPrompt.js"></script>
    <!--自定义弹窗提示插件-->
    <script type="text/javascript" src="js/myalert.js"></script>
    <!--遮罩提示插件-->
    <script type="text/javascript" src="js/jquery.showLoading.js"></script>
  </head>
  
  <body>
    <div id="home_main">&nbsp; 
    <!-- 头部导航层 -->
    <jsp:include page="../home/head.jsp"></jsp:include>
    <div id="home_content">
    <!-- 首页右边层 -->
    <jsp:include page="../home/home_left.jsp"></jsp:include>
    <!-- 首页内容展示层-->
    <div class="home_right  right_bg single_notice">
        <!-- 面包屑导航  -->
        <span><a href="home/home.jsp">首页</a> -> <a href="notice.action?action=more">公告列表</a> -> 公告</span>
        <!--公告标题部分 -->
         <div class="n_title">
         <s:property value="#request.singleNotice.title"/>
            <span style="text-align: right;"> 
            <!-- 用struts2的date标签进行格式化处理 -->
                   发布日期： <s:date name="#request.singleNotice.createTime" format="yy-MM-dd HH:mm"/>
                   </span>
         </div>
        <hr>
        <!-- 内容部分 -->
        <div class="n_content">
            <s:if test="#request.singleNotice.content != null">
                <s:property value="#request.singleNotice.content"/>
            </s:if>
            <s:else>
                <p>内容同标题！</p>
            </s:else>
        </div>
           
    </div>
    </div>
    <!-- 版权标识层 -->
    <jsp:include page="../home/foot.html"></jsp:include>
</div>
<!-- 主体框架结束 -->
<!-- 回顶部层开始 -->
<div class="toTop">
</div>
<!-- 回顶部层结束 -->
  </body>
</html>
