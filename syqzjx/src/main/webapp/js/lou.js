
$(function(){ 
	str=window.location.href; //取得整个地址栏	
	num=str.indexOf("=") 
	if(num > 0){
		str=str.substr(num+1);
		typeSee(str);
	}else{
		getProducts(1); 
	}
});
function getProducts(pageNum) {
	$.get("product/list?page=" + pageNum+"&rows=12",function(data) {
		$(".right_bottom").empty();

		var product = data.rows;

		for (var i = 0; i < product.length; i++) {
			$(".right_bottom").append("<div class='RightImages'>"
					+"<a href='javascript:void(0)' onclick='singleSee("+product[i].pid+")'><img class='imges' src='"+product[i].ppic+"'></a>"
					+"<li>"+product[i].pname+"</li> </div>");
		}
		$("#pList").empty();
		$("#pList").append("当前页数:["+ data.currPage+ "/"+ data.totalPage+ "]&nbsp;&nbsp; "
				+ "<a href='javascript:void(0)' onclick='getProducts(1)'>首页</a>&nbsp;&nbsp;"
				+ "<a href='javascript:void(0)' onclick='getProducts("+ (data.currPage - 1)+ ")'>上一页</a>&nbsp;&nbsp; "
				+ "<a href='javascript:void(0)' onclick='getProducts("+ (data.currPage + 1)+ ")'>下一页</a>&nbsp;&nbsp;"
				+ "<a href='javascript:void(0)' onclick='getProducts("+ data.totalPage+ ")'>末页</a>&nbsp;&nbsp;");
	}, "json");
}

$.post("product/allTypeList", function(data) {//data是个对象

	$("#trDiv").empty();	
	for (var i = 0; i < data.length; i++) {
		$("#trDiv").append("<tr> <td><img src='images/xiaotu.jpg'/></td>"
				+"<td><a href='javascript:void(0)' onclick='typeSee("+data[i].ptid+")'>"+data[i].ptname+"</a></td> </tr>");
	}
}, "json");

function typeSee(obj){
	getProductType(1);
	function getProductType(pageNum){
		$.get("product/list?page=" + pageNum+"&rows=12&ptid=" + obj,function(data) {
			$(".right_bottom").empty();
			$("#pList").empty();
			var product = data.rows;
			if(product == null || product ==""){
				$(".right_bottom").append("<h1 id='h'>该系列产品暂未上传信息,尽请期待!!!</h1>");
				
			}else{
				for (var i = 0; i < product.length; i++) {
					$(".right_bottom").append("<div class='RightImages'>"
							+"<a href='javascript:void(0)' onclick='singleSee("+product[i].pid+")'><img class='imges' src='"+product[i].ppic+"'></a>"
							+"<li>"+product[i].pname+"</li> </div>");
				}

				$("#pList").append("当前页数:["+ data.currPage+ "/"+ data.totalPage+ "]&nbsp;&nbsp; "
						+ "<a href='javascript:void(0)' onclick='getProductType(1)'>首页</a>&nbsp;&nbsp;"
						+ "<a href='javascript:void(0)' onclick='getProductType("+ (data.currPage - 1)+ ")'>上一页</a>&nbsp;&nbsp; "
						+ "<a href='javascript:void(0)' onclick='getProductType("+ (data.currPage + 1)+ ")'>下一页</a>&nbsp;&nbsp;"
						+ "<a href='javascript:void(0)' onclick='getProductType("+ data.totalPage+ ")'>末页</a>&nbsp;&nbsp;");
			}
			
		}, "json");
	}
	return false;
}

/**
 * dia
 * @param obj
 * @returns {Boolean}
 */
function singleSee(obj){
	$(".right_bottom").empty();
	$("#pList").empty();
	$.get("product/selectPic?pid=" + obj,function(data){
		for (var i = 0; i < data.length; i++) {
			$(".right_bottom").append("<div class='right_bottom_xq'>"
					+"<li>"+data[i].pname+"</li> <div class='xqt'> <img src='"+data[i].ppic+"'width='100%' height='100%' /> </div><br>"
					+"<div class='xqp'>"
					+"<p style='margin-left:20px; color:#F30;'><img src='images/xiaotu0.jpg'>&nbsp;&nbsp;详细介绍</p>"
					+"<p><span style=' font-weight:bold;'>&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].pbrife+""
					+"</p> </div> </div>");
		}
	}, "json");
	return false;
}


