function changePic(obj){
	$("#zzzsPic").attr("src",window.URL.createObjectURL(obj.files[0]));
}

$('.scBtn').linkbutton({
	iconCls: 'icon-add',
	onClick:function(){
		if($("#infi").val()==""){
			$.messager.alert('警告提示','佳琪同学,文件不能为空!','info');
			return false;
		}
		$("#zszsForm").submit();
	}	
});

$("#zszsForm").form({
	url : "contect/sczs",
	success : function(data) {
		if (data.trim() =="true") {
			//如果资格证书的面板已经存在，刷新
			if($('#main').tabs('exists','资格证书')){
				$('#zgzsTable').datagrid("reload");
			}
			
			$.messager.show({
				title:'上传证书',
				msg:'上传成功',
				showType:'show',
				style:{
					top:document.body.scrollTop+document.documentElement.scrollTop+250,
					bottom:''
				}
			});
			$("#infi").val("");
			$("#zzzsPic").attr("src","images/ccwt.png");
		}else{
			$.messager.show({
				title:'上传证书',
				msg:'上传失败!!',
				showType:'show',
				style:{
					top:document.body.scrollTop+document.documentElement.scrollTop+250,
					bottom:''
				}
			});
		}
	}
});
