/*js验证*/

$(function(){
	$("#basic_form").validate({
		 rules:{
			   username:{
	                required:true,
	            },
	            birthday:{
	                required:true,
	                dateISO:true
	                
	            },
	            mobile:{
	            	required:true,
	            	number:true,
	            	minlength:11
	            }
	            
	        },
	        messages:{
	        	   username:{
		                required:"姓名不能为空",
		            },
		            birthday:{
		                required:"出生日期不能为空",
		                dateISO:"日期格式不正确"
		                
		            },
		            mobile:{
		            	required:"手机号不能为空",
		            	number:"必须填入数字",
		            	minlength:"手机号为11位"
		            }
		            

	        },
	        errorPlacement: function(error, element) {
	                  error.appendTo(element.siblings("span"));
	        }
	        
	})
	
	// 用于提交基本信息
	$("#basic_submit").click(function(){
		var username = $.trim($("#username").val());
		var sex = $.trim($("input[name='sex']:checked").val());
		var birthday = $.trim($("#birthday").val());
		var policies = $.trim($("#policies").val());
		var provice= $.trim($("#province").val());
		var city= $.trim($("#city").val());
		var mobile = $.trim($("#mobile").val());
		var qq = $.trim($("#qq").val());
		// 获取表单数据信息
		if($("#basic_form").valid()){
			// 判断验证是否通过
//			alert(username+","+sex+","+birthday+","+policies+","+provice+","+city+","+mobile+","+qq);
			$(".shadow").show().showLoading();
			$.ajax({
				type:"POST",
				url:"user.action",
				data:{
					action:"basic",
					username:username,
					sex:sex,
					birthday:birthday,
					policies:policies,
					native:provice+"-"+city,
					mobile:mobile,
					qq:qq
				},
				success:function(data){
					var message = data;
					
					 if(message == "success"){
						 //说明提交成功，转向对应的基本信息预览界面
						 ymPrompt.succeedInfo(
							        {
							            message:"更新信息成功",
							            dragOut:false,
							            handler:function(){
							            	//跳转到信息展示页中
							            	window.location.href="basicinfo/basicInfoShow.jsp";
							            }
							          
							        }
							    );
					 }else{
						 //说明信息更新有误
						 callErrorDialog("更新信息失败");
					 }
					$(".shadow").show().hideLoading().hide();
					
				}
			})
		}
	})
})