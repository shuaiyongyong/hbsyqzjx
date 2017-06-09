function addKnow(){
	if($("#ktag").val().trim() == "" || $("#kcontent").val().trim() == ""){
		$.messager.alert("消息提示","起重知识不能为空,请输入起重知识!!","warning");
		return false;
	}
	var params = $("#addKnow").serialize();
	$.post("know/addKnow",params, function(data){
		var resultStr;
		if(data){
			resultStr = "成功....";
			$("#addKnow").get(0).reset();
			$("#kcontent").html("");
		}else{
			resultStr = "失败....";
		}

		//添加书签结果信息
		$.messager.show({
			title:'添加起重知识',
			msg:'添加信息' + resultStr,
			showType:'show',
			style:{
				top:document.body.scrollTop+document.documentElement.scrollTop,
			}
		});

	}, "json");
	return false;
}