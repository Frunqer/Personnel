$(document).ready(function() {
$("#daytime").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最大日期
    maxDate:new Date()
//    showStatus: true,
//    showOn: "both",
//    buttonImage: "../style/css/datepicker/calendar.gif",
//    buttonImageOnly: true

}).attr("readonly", "readonly");
$("#daytime12").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '2008:2059',//年份范围
    // 最小日期
    minDate:new Date(),
    showStatus: true,
    showOn: "both",
    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true
}).attr("readonly", "readonly");

 $("#daytime1").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最大日期
    maxDate:new Date()
//    showStatus: true,
//    showOn: "both",
//    buttonImage: "../style/css/datepicker/calendar.gif",
//    buttonImageOnly: true

}).attr("readonly", "readonly");
 $("#daytime2").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最大日期
    showStatus: true,
    showOn: "both",
    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly");
 $("#daytime3").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最大日期
//    showStatus: true,
//    showOn: "both",
//    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly");
 
 $("#daytime31").datepicker({
	    // 选择年份的上下限
	    // yearRange:"-99:+0",
	    yearRange: '1958:2059',//年份范围
	    // 最大日期
//	    showStatus: true,
//	    showOn: "both",
//	    buttonImage: "../style/css/datepicker/calendar.gif",
	    buttonImageOnly: true

	}).attr("readonly", "readonly");
 
 
 $("#daytime4").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最大日期
    showStatus: true,
    showOn: "both",
    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly");
 $("#daytime5").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最大日期
    showStatus: true,
    showOn: "both",
    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly");


$("#daytime19").datepicker({
//    // 选择年份的上下限
//    // yearRange:"-99:+0",
    yearRange: '2010:2099',//年份范围
//    // 最大日期
      minDate:new Date(),
//    showStatus: true,
//    showOn: "both",
//    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly");
 $("#daytime4").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最大日期
    showStatus: true,
    showOn: "both",
    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly");
 $("#daytime33").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最小日期
    minDate:new Date(),
    showStatus: true,
    showOn: "both",
    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly");
 $("#daytime22").datepicker({
    // 选择年份的上下限
    // yearRange:"-99:+0",
    yearRange: '1958:2059',//年份范围
    // 最小日期
    minDate:new Date(),
    showStatus: true,
    showOn: "both",
    buttonImage: "../style/css/datepicker/calendar.gif",
    buttonImageOnly: true

}).attr("readonly", "readonly"); 
$("#daytime7").datepicker({
	    // 选择年份的上下限
	    // yearRange:"-99:+0",
	    yearRange: '1958:2059',//年份范围
	    // 最小日期
	    minDate:new Date(new Date().getFullYear()-1,0,1),
	    maxDate:new Date()
//	    showStatus: true,
//	    showOn: "both",
//	    buttonImage: "../style/css/datepicker/calendar.gif",
//	    buttonImageOnly: true
}).attr("readonly", "readonly");

    var d = new Date();   
    var year = d.getFullYear();   
    var month = d.getMonth()+1;   
    if(month<10){
        month="0"+month;
    }
    var date = d.getDate();    
    if(date<10){
        date="0"+date;
    }  
    $("#daytime19").val(year+"-"+month+"-"+date);
});
