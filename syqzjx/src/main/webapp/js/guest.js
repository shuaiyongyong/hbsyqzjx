
var d;
$.post("context/all",function(data){
	d=data;
},"json")


function getGuest(){
	$(".contact").empty();
	$(".contact").append('<form onsubmit=" return sendGuest()" id="guestId" method="post">'
            +'<span >您的姓名：</span><input type="text" name="gname" size="12px" required="required" class="content"/><br/>'
            +'<span >联系电话：</span><input type="tel" name="gtel" size="24px" required="required" id="gTel" class="content"/><br/>'
            +'<span >电子邮件：</span><input type="email" name="gemail" size="24px" required="required" class="content"/><br/>'
            +'<textarea style="resize:none;font-size:13px;"  name="gcontent" id="gcontent" class="content" ></textarea><br/>'
            +'<input type="submit" name="send" value="提交" class="send"/>'
            +'<input type="reset" name="send" value="重写" class="reset"/>'
            +'</form>');
}
function sendPhone(){
	$(".contact").empty();
	$(".contact").append("<p style='font-size:14px; font-weight:bold; margin-top:50px;margin-left:48px;'>"
					+"地  &nbsp;&nbsp;址：河北省保定市清苑区东吕工业园区</p>"
					+"<p style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:48px;'>"
					+"邮  &nbsp;&nbsp;编：071100</p>"
					+"<p style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:48px;'>"
					+"电  &nbsp;&nbsp;话：<span id='guest_tel' ></span></p>"
					+"<p  style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:48px;'>"
					+"Email：<span id='guest_email'></span></p>");
	
		tel="";
		for(var i=0;i<d.length;i++){
			if(d[i].ctype==1){
				tel+=d[i].cconcrete+"&nbsp;"
			}else if(d[i].ctype==4){
				$("#guest_email").html(d[i].cconcrete)
			}
		}
		$("#guest_tel").html(tel)
}
function sendWeixin(){
	$(".contact").empty();
	$(".contact").append("<p style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:48px;'>微信号：<span id='guest_wxnb'></span></p>"
					+"<p style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:48px;'>微信二维码：</p>"
					);
	var wxnb="";
	for(var i=0;i<d.length;i++){
		if(d[i].ctype==3){
			wxnb+=d[i].cconcrete+"&nbsp;"
		}else if(d[i].ctype==2){
			$(".contact").append("<img src='"+d[i].cconcrete+"' style='margin-top:10px; margin-left:30px;'/>")
		}
	}
	$("#guest_wxnb").html(wxnb);
}

//提交留言
function sendGuest(){
	var gContent=$("#gContent").val();
	var param=$("#guestId").serialize();
	var telStr=$("#gTel").val();
	var regTel=/^1[34578]\d{9}$/;
	if(regTel.test(telStr)){
		if(gContent!=''){
			$.post("guest/insert",param,function(data){
				if(data){
					$.post("message/inform",function(d){
						if(d){
							alert("留言成功")
						}
					},"json")
					$(".content").val("");
				}
			},"json");
		}
	}else{
		alert("电话号码格式不正确")
	}
	return false;
}

function sendC(){

//	var telStr=$("#tel").val();
	var regTel=/^1[34578]\d{9}$/;
	if(regTel.test(telStr)){
		
		timer=setInterval("countS1()",1000);
		$.post("guest/sendCode?mobile="+telStr,function(){
			
		});
	}else{
		$.messager.alert("消息提示","电话号码格式错误","info");
	}
	
}