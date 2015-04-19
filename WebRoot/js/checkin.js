$(document).ready(function() {
	$(".stripe tr").mouseover(function() {
		// 如果鼠标移到class为stripe的表格的tr上时，执行函数
		$(this).addClass("over");
	}).mouseout(function() {
		// 给这行添加class值为over，并且当鼠标一出该行时执行函数
		$(this).removeClass("over");
	}) // 移除该行的class
	$(".stripe tr:even").addClass("alt");
	
	
	//获取当前月份
	var objectDate = new Date();
	var month = objectDate.getMonth()+1;
	month = month>10?month:"0"+month;
	$(".monthSelect").val(month);
	
	$(".checkin_search").click(function(){
		var month = $(".monthSelect").val();
		ZENG.msgbox.show(" 正在加载中，请稍后...", 6, 10000);
		$.ajax({
			type:"POST",
			url:"checkin.action",
			data:{
				month:month,
				action:"list",
				type:"sync"
			},
			success:function(){
				 ZENG.msgbox.hide();
				window.location.reload();
			}
		})
	})
});