/**
 * Created by zhouzhenjiang on 2015/2/3.
 */
/*我的提示控件封装*/
function callErrorDialog(message){
    ymPrompt.errorInfo({
        message:'<div style="font-size:16px;font-weight: bold;">'+message+'</div>',
        title:'错误提示',
        dragOut:false
    });

}

function callWarningDialog(message){
    ymPrompt.alert({
        message:message,
        dragOut:false
    });

}

function callSucceedDialog(message){
    ymPrompt.succeedInfo(
        {
            message:message,
            dragOut:false
        }
    );

}