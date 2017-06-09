$("#loginDiv").dialog({
	title: '后台登陆',
	width: 360,
	height: 250,
	closable: false,
});

//账号密码登录
function changeNumLogin(){
	$(".loginForm1").css('display','block');
	$(".loginForm2").css('display','none');
	clearTimeout(time);
}
//手机验证码登录
function changeTelLogin(){
	$(".loginForm1").css('display','none');
	$(".loginForm2").css('display','block');
	$("#send").text("获取验证码");
	$('#send').linkbutton('enable');
	clearTimeout(time);
}

//定时器
var time;
var i =60;
function dsq(){
	i--;
	if(i<=0){
		$("#send").text("获取验证码");
		$('#send').linkbutton('enable');
		clearTimeout(time);
	}else{
		$("#send").text("获取验证码("+i+")");
		$('#send').linkbutton('disable');
		time=window.setTimeout("dsq()", 1000);
	}
}

function sendCode(){
	var utel=$("#utel").val();
	if(!(/^1[345678]\d{9}$/.test(utel))){ 
		$.messager.alert("消息提示","请输入真确的手机号码!!!","warning"); 
		return false; 
	} 
	
	$.get("user/checkTel?utel="+utel,function(data){//写上参数后，才可传递数据
		if(data){
			//发送验证码
			$.get("message/phoneCode?utel="+utel,function(d){
				if(d){
					$.messager.alert("消息提示","验证码已发送至手机号码!","info");
					dsq();
				}else{
					$.messager.alert("消息提示","验证码发送失败!","warning");
					clearInterval(time);
					$("#send").html("获取验证码");
					$('#send').linkbutton('enable');
				}
			},"json");
		}else{
			$.messager.alert("消息提示","手机号码不正确","warning");
			$('#loginForm')[0].reset();
		}
		
	},"json");
}

$('#send').linkbutton();