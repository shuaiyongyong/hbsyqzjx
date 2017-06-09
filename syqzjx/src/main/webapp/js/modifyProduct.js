$.get("product/selectPic?pid=" + pid, function(data) {
	$("#npid").val(data[0].pid);
	$("#npname").val(data[0].pname);
	$("#npbrife").html(data[0].pbrife);
	if(data[0].ppic == null || data[0].ppic =="/upload/"){
		$("#currPic").attr("src","images/1.jpg");
	}else{
		$("#currPic").attr("src",data[0].ppic);
	}
	var ptid =data[0].ptid;
	$.get("product/allTypeList", function(d) {
		//alert(JSON.stringify(d));//把js的json对象转换成json字符串
		for (var i = 0; i < d.length; i++) {
			$("#ptid").append(
					"<option value='" + d[i].ptid + "'  "
					+ (d[i].ptid == data[0].ptid ? "selected" : " ") + ">"
					+ d[i].ptname + "</option>");
		}
	}, "json");
}, "json");

function addPic(obj) {
	var picURI = window.URL.createObjectURL(obj.files[0]);// 根据图片资源创建一个图片路径
	$("#currPic").attr("src", picURI);
}


function mProduct() {

	if($("#npname").val().trim()=="" || $("#npbrife").val().trim()=="" || $("#cpic").val().trim()==""){
		$.messager.alert("消息提示","产品信息不能为空,请输入产品信息!!","warning");
		return false;
	}
	
	var formData = new FormData($("#mProduct")[0]);

	$.ajax({
		url : 'product/modifyProduct',
		type : 'POST',
		data : formData,
		async : false,
		cache : false,
		contentType : false,
		processData : false,
		success : function(returndata) {
			if (returndata) {
				parent.closeMP();
				$('#productInfo').datagrid("reload");
			}
			$.messager.show({
				title : '修改产品信息',
				msg : returndata ? "修改成功..." : "修改失败！！！",
				showType : 'show',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop + 40,
				}
			});
		}
	});
}

function closeMP(){
	$("#modifyProduct").dialog("close",true);
}