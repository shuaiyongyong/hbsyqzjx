
$.get("contect/getCconcrete?cid="+cid,function(data){
	if(data.ctype=="1"){
		$("#ctype").html("电话号码");
	}else if(data.ctype=="3"){
		$("#ctype").html("微信帐号");
	}else if(data.ctype=="4"){
		$("#ctype").html("邮箱");
	}
	$("#cconcrete").val(data.cconcrete);
	
	
},"json");


$('.modifyBtn').linkbutton({
	iconCls: 'icon-edit',
	onClick:function(){
		$("#conForm").submit();
	}	
});
$("#conForm").form({
	url : "contect/changeCconcrete1?cid="+cid,
	success : function(data) {
		if (data.trim() =="true") {
			alert("修改成功...");
			closeModifyC();
			$('#contectTable').datagrid("reload");
		}else{
			alert("修改失败!!!");
		}
	}
});
