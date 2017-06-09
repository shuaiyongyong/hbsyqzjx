function addTrend(){
	if($("#ttag").val().trim() == "" || $("#tcontent").val().trim() == ""){
		$.messager.alert("消息提示","公司动态不能为空,请输入公司动态!!","warning");
		return false;
	}
	var params = $("#addTrend").serialize();
	$.post("trend/addTrend",params, function(data){
		var resultStr;
		if(data){
			resultStr = "成功....";
			$("#addTrend").get(0).reset();
			$("#tcontent").html("");
		}else{
			resultStr = "失败....";
		}

		//添加书签结果信息
		$.messager.show({
			title:'添加公司动态',
			msg:'添加动态' + resultStr,
			showType:'show',
			style:{
				top:document.body.scrollTop+document.documentElement.scrollTop,
			}
		});

	}, "json");
	return false;
}