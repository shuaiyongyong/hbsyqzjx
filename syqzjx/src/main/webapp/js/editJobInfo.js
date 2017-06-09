$("#meid").val(eid);
$.get("employ/listById?eid="+eid,function(data){
	$("#mename").val(data.ename);
	$("#mecount").val(data.ecount);
	$("#meaddress").val(data.eaddress);
	$("#metime").val(data.etime);
	$("#medescription").val(data.edescription);
},"json");

$('.editBtn').linkbutton({
	iconCls: 'icon-edit',
	onClick:function(){
		
		$("#EjobForm").submit();
	}	
});

$("#EjobForm").form({
	url : "employ/modify",
	success : function(data) {
		if(data){
			$('#employTable').datagrid("reload");
			$.messager.alert('温馨提示','佳琪同学,修改成功...','info');
			closeEditE();
		}else{
			$.messager.alert('消息提示','由于某些原因,修改失败!!!','info');
		}
	}
});
