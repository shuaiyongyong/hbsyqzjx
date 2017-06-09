$.get("trend/selectNews?tid=" + tid,function(data){
	$("#mttags").val(data[0].ttag);
	$("#mtcontent").val(data[0].tcontent);
	$("#mtid").val(data[0].tid);
},"json");



function mTrend() {
	if($("#mttags").val().trim() == "" || $("#mtcontent").val().trim() == ""){
		$.messager.alert("消息提示","公司动态不能为空,请输入公司动态!!","warning");
		return false;
	}
	var params=$("#mTrend").serialize();
	$.post("trend/update",params ,function(data) {//data是个对象
		if(data){
			$.messager.alert("消息提示","修改成功！！","info");	
			$('#trendInfo').datagrid("reload");
			parent.closeMT();
		}else{
			$.messager.alert("消息提示","修改失败！！","info");
		}
	}, "json");
	return false;
}

function closeMT(){
	$("#modifyTrend").dialog("close",true);
}
