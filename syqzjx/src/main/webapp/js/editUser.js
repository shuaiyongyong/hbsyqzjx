$(function(){ 
	restUT();
});
function restUT(){
	$("#mUser").get(0).reset();
	$.get("user/selectUser",function(data){
		$("#usid").val(data.usid);
		$("#uname").html(data.uname);
		$("#tel").html(data.utel);
		$(".mdBtn").linkbutton();
	},"json");
}

$("#mdUtel").click(function(){
	$('#modifyTel').dialog({    
	    title: 'modifyTel',    
	    width: 300,    
	    height: 200,    
	    closed: false,    
	    cache: false,    
	    href: 'back/modifyTel.jsp',    
	    modal: true   
	});    
});
function mdUser() {
	var newpwd =$("#newpwd").val();
	 var mnewpwd =$("#mnewpwd").val();
	 var params = $("#mUser").serialize();
	 if(newpwd.trim() != mnewpwd.trim()){
		 $.messager.alert('警告','两次密码不相同','warning');
		$("#newpwd").val("");
		$("#mnewpwd").val("");
	 }else if(newpwd.trim()==''||mnewpwd.trim()==''){
		 $.messager.alert('警告','密码不能为空','warning');
		 
	 }else{
		 $.post("user/update",params ,function(data) {
			 	if(data){
			 		$.messager.alert("消息提示","修改成功！！","info")	;
			 		$("#newpwd").val("");
					$("#mnewpwd").val("");
				}else{
					$.messager.alert("消息提示","修改失败！！","warning")	;
					$("#newpwd").val("");
					$("#mnewpwd").val("");
				}
		 },"json");
	 }		
	return false;
}
