/*分页操作的JS代码*/
var jsonMyPagination;
$(function(){
	var currange;
	jsonMyPagination=$("#example").myPagination({
		currentPage:1,
		pageNumber:10,
		 ajax: {
	            on: true,
	            url:"page.action?action=notice",
	            dataType: 'json',
	            ajaxStart: function() {
	              ZENG.msgbox.show(" 正在加载中，请稍后...", 6, 10000);
	            },
	            callback: function(json) {
	             ZENG.msgbox.hide();
	             var htmlStr="";
	             if(json.notices.length>0){
	            	 htmlStr+="<ul>";
	            	 $.each(json.notices,function(i,n){
	            		 htmlStr+="<li><a href='notice.action?action=single&id="+n.id+"'>"+n.title+"</a></li>";
	            	 });
	            	 htmlStr+="</ul>";
	             }else{
	            	 htmlStr="<span>对不起，暂时没有公告</span>"
	             }
	            $("#list").html(htmlStr);
	            }
	          }
	});
})

