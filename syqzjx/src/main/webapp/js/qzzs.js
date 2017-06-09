$(function(){ 
	str=window.location.href; //取得整个地址栏	
	num=str.indexOf("=") 
	if(num > 0){
		str=str.substr(num+1);
		singleKnow(str);
	}else{
			getKnows(1); 
	}
});
function getKnows(pageNum) {
	$.get("know/list?page=" + pageNum+"&rows=12",function(data) {
		$(".right_bottom").empty();

		var knows = data.rows;
		for (var i = 0; i < knows.length; i++) {
			$(".right_bottom").append("<div class='qzzs'><img src='images/n-tu.gif' />" +
					"<a href='javascript:void(0)' onclick='singleKnow("+knows[i].kid+")'>" +knows[i].ktag+"</a><span style='margin-left:15px; font-size:13px; color:#CCC;'>" +
					"["+knows[i].kdate+"]&nbsp;&nbsp;["+knows[i].kid+"]</span></div><br>");
		}
		
		$("#pList").empty();
		$("#pList").append("当前页数:["+ data.currPage+ "/"+ data.totalPage+ "]&nbsp;&nbsp; "
				+ "<a href='javascript:void(0)' onclick='getKnows(1)'>首页</a>&nbsp;&nbsp;"
				+ "<a href='javascript:void(0)' onclick='getKnows("+ (data.currPage - 1)+ ")'>上一页</a>&nbsp;&nbsp; "
				+ "<a href='javascript:void(0)' onclick='getKnows("+ (data.currPage + 1)+ ")'>下一页</a>&nbsp;&nbsp;"
				+ "<a href='javascript:void(0)' onclick='getKnows("+ data.totalPage+ ")'>末页</a>&nbsp;&nbsp;");
	}, "json");
}


$.post("product/allTypeList", function(data) {//data是个对象

	$("#trDiv").empty();	
	for (var i = 0; i < data.length; i++) {
		$("#trDiv").append("<tr> <td><img src='images/xiaotu.jpg'/></td>"
                    +"<td><a href='page/lou.jsp?ptid=" +data[i].ptid+"'>"+data[i].ptname+"</a></td> </tr>");
	}
}, "json");

function singleKnow(obj){
	$("#pList").empty();
	$(".right_bottom").empty();	
	$.get("know/selectKnows?kid=" + obj,function (data){
		for (var i = 0; i < data.length; i++) {
			$(".right_bottom").append("<p class='qzzsp1'>"+data[i].ktag+"</p><p>发布日期&nbsp;:&nbsp;"+data[i].kdate+"</p>"
					+"<div class='qzzsCont'>&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].kcontent+"</div>");
		}
	},"json");
	return false;
}
