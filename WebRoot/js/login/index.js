/**
 * Created by zhouzhenjiang on 2015/2/1.
 */
/*登录界面JS*/

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
        var error_msg = $(".error_msg").text();
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
        if(password == ""){
            $(".error_msg").html("请输入密码").fadeIn(1000);
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
    })



});


