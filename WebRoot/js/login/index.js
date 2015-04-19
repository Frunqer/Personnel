/**
 * Created by zhouzhenjiang on 2015/2/1.
 */
/*登录界面JS*/

//邮箱的正则表达式

var emailreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
var isSubmit = false;
$(function(){
     $(".btn_reg").click(function(){

        $('#main_login').stop().animate({
            left:-1000
        },1000);
         $('.main_reg').stop().animate({
             left: "50%"
         },1000).fadeIn(1000);
     });
    $("#goLogin").click(function(){
        $('#main_login').stop().animate({
            left:"50%"
        },1000).fadeIn(1000);
        $('.main_reg').stop().animate({
            left: -1000
        },1000);
    });

    $(".btn_login").click(function(){
       //进行登录时的校验
        var error_msg = $.trim($(".error_msg").text());
        var email =$.trim($("#email").val());
        var password=$.trim($("#password").val());
        if(!isSubmit){
            //说明校验没通过
            if(error_msg=="") {
                callErrorDialog("请输入邮箱和密码");
            }else{
                callErrorDialog(error_msg);

            }
        }else{
            //说明校验通过，这里使用ajaxSubmit()进行异步提交
        	
            $(".shadow").show().showLoading();
            //自己写遮罩层
            //进行异步上传请求
            $.ajax({
            	type:"POST",
            	url:"login.action",
            	data:{
            		email:email,
            		pwd:password
            	},
            	success:function(data){
            		$(".shadow").show().hideLoading().hide();
               		if(data == "noexist"){
            			callErrorDialog("邮箱未注册");
            		}else if(data == "error"){
            			callErrorDialog("邮箱或密码错误");
            		}else if(data == "success"){
            			ymPrompt.succeedInfo(
    					        {
    					            message:"登录成功",
    					            dragOut:false,
    					            handler:function(){
    					                /*页面初始化的时候向后台*/
    					            	window.location.href="notice.action?action=top";
    					            }
    					        }
    					    );
            		}
            	}
            	
            });
        }

    });
    $(".form_login .user_name").blur(function(){
       //失去焦点是验证
        var username= $.trim($(this).val());
        if(username == ""){
            $(".error_msg").html("请输入邮箱").fadeIn(1000);
            isSubmit=false;
        }else if(!emailreg.test(username)){
            $(".error_msg").html("邮箱格式错误").fadeIn(1000);
            isSubmit=false;
        }else {
            $(".error_msg").fadeOut(1000);
            isSubmit=true;
        }
    });

    $(".form_login .pass_word").blur(function(){
        var password = $.trim($(this).val());
        var username= $.trim($(".form_login .user_name").val());
        if(password == ""){
            $(".error_msg").html("请输入密码").fadeIn(1000);
            isSubmit=false;
        }else if(password.length <6){
        	 $(".error_msg").html("密码不能小于6位").fadeIn(1000);
             isSubmit=false;
        } else if(username == ""){
            $(".error_msg").html("请输入邮箱").fadeIn(1000);
            isSubmit=false;
        }else if(!emailreg.test(username)){
            $(".error_msg").html("邮箱格式错误").fadeIn(1000);
            isSubmit=false;
        }else {
            $(".error_msg").fadeOut(1000);
            isSubmit=true;
        }
    });

    $("#reg_form").validate({
        rules:{
            reg_username:{
                required:true,
                email:true
            },
            reg_pwd:{
                required:true,
                minlength:6
            },
            confirm_pwd:{
                required:true,
                minlength:6,
                equalTo:"#reg_pwd"
            }
        },
        messages:{
            reg_username:{
                required:"请输入邮箱",
                email:"请输入正确的邮箱格式"
            },
            reg_pwd:{
                required:"请输入密码",
                minlength:"密码最少为6位"
            },
            confirm_pwd:{
                required:"请输入确认密码",
                minlength: "确认密码不能小于6个字符",
                equalTo: "两次输入密码不一致不一致"
            }

        },
        errorPlacement: function(error, element) {
                  error.appendTo(element.siblings("span"));
        }
        
    });
    /*注册代码的提交*/
    $("#regSubmit").click(function(){
    	var code = $.trim($("#reg_code").val());
    	var email = $.trim($("#reg_username").val());
    	var pwd = $.trim($("#reg_pwd").val());
    	if($("#reg_form").valid()){
    		//判断是否输入验证码
    		if(code == ""){
    			callErrorDialog("验证码不能为空");
    			return;
    		}
    		$(".shadow").show().showLoading();
    		$.ajax({
    			type:"post",
    			url:"reg.action",
    			data:{
    				email:email,
    				pwd:pwd,
    				code:code
    			},
    			success:function(data){
    				if(data == "用户名已存在"){
    					callErrorDialog("用户名已存在");
    				}else if(data == "success"){
    					ymPrompt.succeedInfo(
    					        {
    					            message:"注册成功",
    					            dragOut:false,
    					            handler:go
    					        }
    					    );
    				}else if(data == "error"){
    					callErrorDialog("注册失败，请重新注册");
    				}else if(data == "验证码错误"){
    					callErrorDialog("验证码错误")
    				}
    				$(".shadow").show().hideLoading().hide();
    				
    			}
    		});
    	}
    	
    });
    
    function go(){
    	window.location.href="notice.action?action=top";//跳转到首页
    }
    var wait = 60;
    var timer;
    /*验证码倒计时*/
    $("#reg_attach").click(function(){
    	var email = $.trim($("#reg_username").val());
    	if(email == ""){
    		callErrorDialog("邮箱不能为空");
    		return;
    	}
    	$(this).val(wait+"秒后获取").attr("disabled","disabled");
    	
    	timer = setInterval(coutDown, 1000);
    	
    	// 进行异步获取验证码
    	$.ajax({
    		type:"post",
    		url:"code.action",
    		data:{
    			email:email
    		},
    		success:function(data){
    			callSucceedDialog("验证码为："+data);
    		}
    	});
    });
    
    function coutDown(){
    	if(wait > 0){
    		wait--;
    		$("#reg_attach").val(wait+"秒后获取");
    	}else{
    		//如果小于0，恢复原状
    		$("#reg_attach").val("获取验证码").removeAttr("disabled");
    		wait=60;
    		window.clearInterval(timer);
    	}
    }
    
    
    
    
    
});


