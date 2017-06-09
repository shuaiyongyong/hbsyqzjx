
$.get("contect/getCconcrete?cid="+cid,function(data){
	$("#chatPic").attr('src',data.cconcrete);
},"json");


$('.modifyBtn').linkbutton({
	iconCls: 'icon-edit',
	onClick:function(){
		if($("#picInputFile").val()==""){
			$.messager.alert('警告提示','图片路径还没选呢!','info');
			return false;
		}
		
		$("#picForm").submit();
	}	
});



$("#picForm").form({
	url : "contect/changeCconcrete?cid="+cid,
	success : function(data) {
		if (data.trim() =="true") {
			$.messager.alert('消息提示','恭喜您，修改成功...','info');
			closeModifyC();
			$('#contectTable').datagrid("reload");
		}else{
			$.messager.alert('消息提示','抱歉，修改失败,请检查网络...','info');
		}
	}
});

function changePic(obj){
	$("#chatPic").attr("src",window.URL.createObjectURL(obj.files[0]));
}