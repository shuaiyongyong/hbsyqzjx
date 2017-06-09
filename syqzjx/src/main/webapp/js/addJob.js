$('.addBtn').linkbutton({
	iconCls: 'icon-add',
	onClick:function(){
		if($("#aename").val()==""){
			$.messager.alert('温馨提示','职位名称不能为空!!!','info');
			return false;
		}
		$("#AjobForm").submit();
	}	
});

$("#AjobForm").form({
	url : "employ/addJob",
	success : function(data) {
		if(data){
			clearForm();//清空表单
			if($('#main').tabs('exists','编辑招聘信息')){
				$('#employTable').datagrid("reload");
			}
			$.messager.alert('温馨提示','发布招聘信息成功,回到"编辑招聘信息"查看...','info');
		}else{
			$.messager.alert('消息提示','由于某些原因,发布失败!!!','info');
		}
	}
});

//清空表单
function clearForm(){
	$("#aename").val("");
	$("#aecount").val("");
	$("#aeaddress").val("");
	$("#aetime").val("");
	$("#medescription").val("");
}