$.get("product/allTypeList", function(d) {
	//alert(JSON.stringify(d));//把js的json对象转换成json字符串
	for (var i = 0; i < d.length; i++) {
		$("#aptid").append(
				"<option value='" + d[i].ptid + "'  >"
				+ d[i].ptname + "</option>");
	}
}, "json");

function addPpic(obj) {
	var picURI = window.URL.createObjectURL(obj.files[0]);// 根据图片资源创建一个图片路径
	$("#acurrPic").attr("src", picURI);
}


function addProduct() {

	if($("#apname").val().trim()=="" || $("#apbrife").val().trim()=="" || $("#adpics").val().trim()==""){
		$.messager.alert("消息提示","产品信息不能为空,请输入产品信息!!","warning");
		return false;
	}
	var tname =$("#addProduct").serialize();
	$.post("product/selectProductByName",tname,function (data){
		if(data){
			$.messager.alert("消息提示","添加失败!该产品名称已存在!!","warning");
		}else{
			var formData = new FormData($("#addProduct")[0]);
			$.ajax({
				url : 'product/addProduct',
				type : 'POST',
				data : formData,
				async : false,
				cache : false,
				contentType : false,
				processData : false,
				success : function(returndata) {
					if(returndata){
						$("#addProduct").get(0).reset();
						$("#apbrife").html("");
					}
					$.messager.show({
						title : '添加产品信息',
						msg :returndata.trim() == "true" ? "添加成功..." : "添加失败！！！",
								showType : 'show',
								style : {
									top : document.body.scrollTop
									+ document.documentElement.scrollTop + 40,
								}
					});
				}
			});
		}
	},"json");

	return false;
}