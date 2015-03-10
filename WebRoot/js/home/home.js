/**
 * Created by zhouzhenjiang on 2015/3/8.
 */

$(function(){

    $(".head ul li").hover(

      function(){
          var index =  $(this).index();
          if(index == 0) {
              $(this).find("img").attr("src", "images/head/filebg_over.png");
          }else if(index == 1){
              $(this).find("img").attr("src", "images/head/salary_over.png");
          }else if(index == 2){
              $(this).find("img").attr("src", "images/head/check_over.png");
          }else if(index == 3){
              $(this).find("img").attr("src", "images/head/work_over.png");
          }
      },
        function(){
            var index =  $(this).index();
            if(index == 0) {
                $(this).find("img").attr("src", "images/head/filebg.png");
            }else if(index == 1){
                $(this).find("img").attr("src", "images/head/salary.png");
            }else if(index == 2){
                $(this).find("img").attr("src", "images/head/check.png");
            }else if(index == 3){
                $(this).find("img").attr("src", "images/head/work.png");
            }
        }
    );
    
    $(window).scroll(function(){ 
  	  if ($(window).scrollTop()>100){ 
  		  $(".toTop").fadeIn(1500); 
  	  } 
  	  else 
  	  { 
  		  $(".toTop").fadeOut(1500); 
  	  } 
    }); 
    // 当点击跳转链接后，回到页面顶部位置
    $(".toTop").click(function(){ 
  	  $('body,html').animate({scrollTop:0},1000); 
  	  return false; 
    		
     }); 
    week();

});
/*员工签到js开始*/

function week(){
	var objDate= new Date();
	var week = objDate.getDay();
	switch(week)
		{
			case 0:
			week="周日";
			break;
			case 1:
			week="周一";
			break;
			case 2:
			week="周二";
			break;
			case 3:
			week="周三";
			break;
			case 4:
			week="周四";
			break;
			case 5:
			week="周五";
			break;
			case 6:
			week="周六";
			break;
		}
	$(".sign_number").html( week );
}