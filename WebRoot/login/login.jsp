<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人事通用户界面</title>
    
	 <meta charset="UTF-8">

	<link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/skin/black/ymPrompt.css"/>
    <link rel="stylesheet" href="css/showLoading.css"/>

    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>


    <script type="text/javascript" src="js/login/index.js"></script>
    <script type="text/javascript" src="js/ymPrompt.js"></script>
    <!--自定义弹窗提示插件-->
    <script type="text/javascript" src="js/myalert.js"></script>
    <script type="text/javascript" src="js/jquery.validate.js"></script>
    <script type="text/javascript" src="js/jquery.form.js"></script>
    <!--遮罩提示插件-->
    <script type="text/javascript" src="js/jquery.showLoading.js"></script>

  </head>
  
  <body>
   <!--登录层开始-->
<div class="main bg" id="main_login">
    <div class="login" id="div_login">
        <span style="font-size: 20px;color: white;font-weight: bold;">Login</span>

        <div class="form_login" id="form_login">
            <div class="error_msg"></div>
            <form action="" method="post" id="loginForm">
                <table>
                    <tr>
                        <td><input type="text" placeholder="邮箱"  class="txt user_name" id="email"
                                   name="email"></td>
                    </tr>
                    <tr>
                        <td><input type="password" placeholder="密码" class="txt pass_word" id="password"
                                   name="password"></span>
                        </td>
                    </tr>
                </table>
                <input type="checkbox" style="margin:20px 0px 0px 20px;" id="remind"><span
                    style="color:white;margin: 20px 0px 0px 2px;"><label for="remind">记住账户</label></span>
                <a href="#">忘记密码</a>
                <input type="button" value="登  录" class="btn btn_login">

            </form>
        </div>
    </div>
    <div class="reg" id="div_reg">
        <span style="font-size: 20px;color: white;font-weight: bold;">Register</span>

        <p style="margin-top: 10px;color: white; line-height: 30px;">
            免费账户<br>
            如果您还没有人事通账户<br>
            快来加入我们的大家庭<br>
            还等什么?马上注册！
        </p>
        <input type="button" value="注  册" class="btn btn_reg"/>
    </div>
</div>
<!--登录层结束-->

<!--注册层开始-->
<div class="main_reg bg">
    <span class="title_reg">Register</span>

    <div class="reg_div">
        <form action="" method="post" id="reg_form" >
            <ul>
                <li>
                    <input type="text" id="reg_username" name="reg_username" autofocus="true" class="txt2" placeholder="邮箱"/>
                    <span style="display:block;color: white;margin-left: 20px"></span>
                </li>
                <li>
                    <input type="password" id="reg_pwd" name="reg_pwd" class="txt2" placeholder="密码"/>
                    <span style="display:block;color: white;margin-left: 20px"></span>
                </li>
                <li>
                    <input type="password" id="confirm_pwd" name="confirm_pwd" class="txt2" placeholder="确认密码"/>
                    <span style="display:block;color: white;margin-left: 20px"></span>
                </li>
                <li>
                    <input type="text" id="reg_code" name="reg_code" class="txt2 check_txt" placeholder="验证码">
                    <input type="button" id="reg_attach" name="reg_attach" class="btn btn_check" value="获取验证码">
                    <span style="display:block;color: white;margin-left: 20px"></span>
                </li>
                <li>
                    <input type="button" class="btn btn_go" value="登  录" id="goLogin">
                    <input type="submit" class="btn btn_go" value="注  册" id="regSubmit">
                </li>
            </ul>
        </form>
    </div>
</div>
<!--注册层结束-->
<!--遮罩层-->
<div class="shadow"></div>
<!-- 遮罩层结束 -->  
  </body>
</html>
