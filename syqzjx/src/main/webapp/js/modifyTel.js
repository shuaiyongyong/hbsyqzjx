$.get("user/selectUser",function(data){
	$("#oldTel").html(data.utel);
},"json");

function mTel() {
	var telStr=$("#mutel").val();
	var regTel=/^1[34578]\d{9}$/;
	var params = $("#mTel").serialize();
	if(!(regTel.test(telStr))){
		$.messager.alert('警告','电话号码格式错误','warning');
	}else{
		$.messager.confirm('修改绑定手机号码', '是否确定修改此手机号码？', function(r){
			if (r){		
				$.post("user/mdTel",params ,function(data) {
					if(data){
						$.messager.alert("消息提示","修改成功！！","info");	
						parent.restUT();
						$("#modifyTel").dialog("close",true);
					}else{
						$.messager.alert("消息提示","修改失败！！","info");
					}
				},"json");
			}		
		});
	}
	return false;
}
