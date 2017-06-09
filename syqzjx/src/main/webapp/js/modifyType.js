$.get("product/selectTypeByPtid?ptid=" + ptid, function(data) {
	$("#ptyname").val(data[0].ptname);
	$("#ptyid").val(data[0].ptid);
}, "json");


//做异步用户名校验
function  checkPtyname(obj){
	var params = $("#ptyname").val();
	if(params == "" || params == null){
		$("#tnameInfo").html("");
		return;
	}
	var tname =$("#mType").serialize();
	$.post("product/selectTypeByName",tname,function (data){
//		alert(data)
		if(data){
			$("#tnameInfo").html("该产品类型已存在!!");
			$("#tnameInfo").css("color","red");
		}else{
			$("#tnameInfo").html(" 主题名称可以使用！");
			$("#tnameInfo").css("color","green");
		}
	},"json");
	return false;
}

function mdPtype() {
	var name = $("#ptyname").val();
	if(name.trim() == ""  ||  name.trim() == null){
		$.messager.alert("消息提示","请输入产品类型,产品类型不能为空！！！","warning");
		return false;
	}
	var params =$("#mType").serialize();
//	var params=$("#mType").serialize();
	$.post("product/modifyType",params ,function(d) {//data是个对象
		if(d){
			$.messager.alert("消息提示","修改成功！！","info");	
			$('#typeInfo').datagrid("reload");
			parent.closeMPT();
		}else{
			$.messager.alert("消息提示","修改失败！！","info");
		}
	}, "json");
	return false;
}

function closeMPT(){
	$("#modifyType").dialog("close",true);
}
