
function changePic(obj){
	$("#pic").attr("src",window.URL.createObjectURL(obj.files[0]));
	if($("#cbrand").val()!=""){
		//
		$('.modifyBtn').linkbutton('enable');
	}
}

$.get("cominfo/list",function(data){
	$("#pic").attr('src',data.cbrand);
},"json");

$('.modifyBtn').linkbutton({
	iconCls: 'icon-edit',
	onClick:function(){
		$("#logoForm").submit();
	}	
});
//默认按钮失效
$('.modifyBtn').linkbutton('disable'); 

$("#logoForm").form({
	url : "cominfo/changeLogo",
	success : function(data) {
		if (data.trim() =="true") {
			
			$('.modifyBtn').linkbutton('disable'); // 使更改按钮失效
			$("#cbrand").val("");    //清空<input type="file"/>
			
			$.messager.show({
				title:'修改logo',
				msg:'修改成功',
				showType:'show',
				style:{
					top:document.body.scrollTop+document.documentElement.scrollTop+250,
					bottom:''
				}
			});
		}else{
			$.messager.show({
				title:'修改logo',
				msg:'修改失败!!',
				showType:'show',
				style:{
					top:document.body.scrollTop+document.documentElement.scrollTop+250,
					bottom:''
				}
			});
		}
	}
});
