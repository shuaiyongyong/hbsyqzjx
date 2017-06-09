$.get("know/selectKnows?kid=" + kid, function(data) {
	$("#kid").val(data[0].kid);
	$("#mktag").val(data[0].ktag);
	$("#mkcontent").val(data[0].kcontent);
}, "json");



function mKnow() {
	if($("#mktag").val().trim() == "" || $("#mkcontent").val().trim() == ""){
		$.messager.alert("消息提示","起重知识不能为空,请输入起重知识!!","warning");
		return false;
	}
	var params=$("#mKnow").serialize();
	$.post("know/update",params ,function(data) {//data是个对象
		if(data){
			$.messager.alert("消息提示","修改成功！！","info");	
			$('#knowInfo').datagrid("reload");
			parent.closeMK();
		}else{
			$.messager.alert("消息提示","修改失败！！","info");
		}
	}, "json");
	return false;
}

function closeMK(){
	$("#modifyKnow").dialog("close",true);
}
