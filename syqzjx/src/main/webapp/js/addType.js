function addType(){
	if ($("#ptname").val().trim()=='' ||  $("#ptname").val().trim()== null ) {
		$.messager.alert("消息提示","请输入产品类型名","warning")
		return false;
	}
	var tname =$("#addType").serialize();
	$.post("product/selectTypeByName",tname,function (data){
		if(data){
			$.messager.alert("消息提示","添加失败!该产品类型已存在!!","warning")
		}else{
			$.post("product/addProductType",tname,function (data){
				if(data){
					$.messager.alert("消息提示","添加成功!!","info");
					$("#addType").get(0).reset();
					$("#ptname").html("");
				}else{
					$.messager.alert("消息提示","添加失败!!","info");
					$("#addType").get(0).reset();
					$("#ptname").html("");
				}
//			var formData = new FormData($("#addType")[0]);
//			
//			$.ajax({
//				url : 'product/addProductType',
//				type : 'POST',
//				data : formData,
//				async : false,
//				cache : false,
//				contentType : false,
//				processData : false,
//				success : function(returndata) {
//					if(returndata){
//						$("#addType").get(0).reset();
//						$("#ptname").html("");
//					}
//					$.messager.show({
//						title : '添加产品类型',
//						msg :returndata.trim() == "true" ? "添加成功..." : "添加失败！！！",
//								showType : 'show',
//								style : {
//									top : document.body.scrollTop
//									+ document.documentElement.scrollTop + 40,
//								}
//					});
//				}
			},"json");
		}
	},"json");

	return false;
}