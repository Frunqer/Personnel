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
    
    <title>头像修改页面</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/home.css"/>
    <link rel="stylesheet" href="css/imge_head.css"/>
    <link rel="stylesheet" href="css/skin/black/ymPrompt.css"/>
    <link rel="stylesheet" href="css/showLoading.css"/>
    <!-- 加载上传组件的css -->
    <link rel="stylesheet" href="css/uploadify.css"/>

    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/home/home.js"></script>
    <script type="text/javascript" src="js/ymPrompt.js"></script>
    <!--自定义弹窗提示插件-->
    <script type="text/javascript" src="js/myalert.js"></script>
    <!--遮罩提示插件-->
    <script type="text/javascript" src="js/jquery.showLoading.js"></script>
    <!-- 加载上传组件需要的js -->
    <script type="text/javascript" src="js/uploadify/jquery.uploadify.js"></script>
    <script type="text/javascript" src="js/uploadify/swfobject.js"></script>
    <script type="text/javascript">
     //是否确认上传
    function comfirmUpdate(){
     //调用组件的确认事件
     ymPrompt.confirmInfo({title:'系统提示',
     message:'确认上传该图片吗？',
     handler:function(sign){
        if(sign == "ok"){
          //触发了确定按钮，响应后台事件
          var path = $("#headImage").attr("src");
          var email = $("#headImage").attr("title");
          window.location.href="user.action?action=image&path="+path+"&email="+email;
        }else{
       
        }
     }
     })
 }
 
    
    </script>
  </head>
  
  <body>
    <div id="home_main">&nbsp; 
    <!-- 头部导航层 -->
    <jsp:include page="../home/head.jsp"></jsp:include>
    <div id="home_content">
    <!-- 首页右边层 -->
    <jsp:include page="../home/home_left.jsp"></jsp:include>
    <!-- 首页内容展示层-->
    <div class="home_right right_bg ">
        <!-- 面包屑导航  -->
        <span class="spantxt"><a href="home/home.jsp">首页</a> -> 头像修改</span>
        <!-- 用于上传组件的封装 -->
        <div class="upload_img_head">
            <input type="file" name="image" id="uploadify"/>
            <div id="fileQueue">
        </div>
         <!-- 图片显示位置  -->            
            <div class="image_local">
               <img alt="头像" src='<s:property value="#session.loginUser.head_image" default="upload/default_head.png"/>' width="160px" height="160px" id="headImage" title="${session.loginUser.email }">
            </div>
            <input type="button" class="btn btnUpload" value="上  传" onclick="comfirmUpdate()" />
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
 <!-- 初始化上传组件  -->
 <script type="text/javascript">

 $(document).ready(function() {
            var onSelect=function(file){
             }
            var uploadify_onSelectError = function(file, errorCode, errorMsg) {
            
                     switch(errorCode)
                    {
                        case -100:
                            callWarningDialog('每次只能上传一个文件');
                            break;
                        case -110:
                           callWarningDialog('文件不能大于5M');
                            break;
                        case -120:
                            break;
                        case -130:
                            break;
                        default:   
                    }
                }
            var onUploadStart=function(file) {
                                 }
             $("#uploadify").uploadify({  
                            'auto'  : true,  
                            'swf'     : 'uploadify.swf',  
                            'uploader'          : 'upload.action',  //后台处理的请求  
                            'queueID'           : 'fileQueue',//与下面的id对应  
                            'queueSizeLimit' :1,
                             'method':'post',
                            'removeTimeout':0.1,  
                            'buttonText'       : '选择图片' ,
                            'fileSizeLimit'      :5*1024,
                            'fileObjName'    :'image',
                            'fileTypeExts' : '*.jpg;*.png;*.gif;',
                            'onSelect'          :onSelect,
                            'multi':false,
                            'overrideEvents' : ['onDialogClose','onUploadSuccess','onUploadError','onSelectError','onUploadStart'],
                            'onSelectError'   : uploadify_onSelectError,
                            onUploadStart: function (file) {
                                
                                if(file.name.length==0){
                                    $('#uploadify').uploadify('cancel');
                                    callWarningDialog("文件不能为空");
                                }
                                else if(file.name.indexOf("@")>0){
                                    $('#uploadify').uploadify('cancel');
                                     callWarningDialog("文件名中不能含有@字符");
                               
                                }
                                else if(file.name.indexOf(",")>0){
                                    $('#file_upload').uploadify('cancel');
                                      callWarningDialog("文件名中不能含有,字符");
                                      
                                }
                                 else if(file.name.indexOf(" ")>0){
                                     $('#uploadify').uploadify('cancel');
                                      callWarningDialog("文件名中不能含有空格");
                                        
                                }
                                 else if(file.name.indexOf(".")<0){
                                     $('#uploadify').uploadify('cancel');
                                     callWarnningDialog("文件格式不对");
                                    }
                            } ,
                            'onUploadSuccess' : function(file,data,response) {
                               var str=data;
                               var obj = eval('(' + str + ')');//格式化json数据
                               $("#headImage").attr("src","upload/"+obj.imagePath);
                             },
                              'onUploadError'    :function(file, errorCode, errorMsg, errorString) {
                                
                                 }
              });  
            
    });  
 
 
 </script>
</html>
