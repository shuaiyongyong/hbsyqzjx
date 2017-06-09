$(function(){ 
	str=window.location.href; //取得整个地址栏	
	num=str.indexOf("=") 
	if(num > 0){
		str=str.substr(num+1);
		singleTrend(str);
	}else{
		getTrends(1); 
	}
});
function getTrends(pageNum) {
	$.get("trend/list?page=" + pageNum+"&rows=12",function(data) {
		$(".right_bottom").empty();

		var trends = data.rows;
		for (var i = 0; i < trends.length; i++) {
			$(".right_bottom").append("<div class='gsdt'><img src='images/n-tu.gif' />" +
					"<a href='javascript:void(0)' onclick='singleTrend("+trends[i].tid+")'>" +trends[i].ttag+"</a><span style='margin-left:15px; font-size:13px; color:#CCC;'>" +
					"["+trends[i].tDate+"]&nbsp;&nbsp;["+trends[i].tid+"]</span></div><br>");
		}
		
		$("#pList").empty();
		$("#pList").append("当前页数:["+ data.currPage+ "/"+ data.totalPage+ "]&nbsp;&nbsp; "
				+ "<a href='javascript:void(0)' onclick='getTrends(1)'>首页</a>&nbsp;&nbsp;"
				+ "<a href='javascript:void(0)' onclick='getTrends("+ (data.currPage - 1)+ ")'>上一页</a>&nbsp;&nbsp; "
				+ "<a href='javascript:void(0)' onclick='getTrends("+ (data.currPage + 1)+ ")'>下一页</a>&nbsp;&nbsp;"
				+ "<a href='javascript:void(0)' onclick='getTrends("+ data.totalPage+ ")'>末页</a>&nbsp;&nbsp;");
	}, "json");
}


$.post("product/allTypeList", function(data) {//data是个对象

	$("#trDiv").empty();	
	for (var i = 0; i < data.length; i++) {
		$("#trDiv").append("<tr> <td><img src='images/xiaotu.jpg'/></td>"
                    +"<td><a href='page/lou.jsp?ptid=" +data[i].ptid+"'>"+data[i].ptname+"</a></td> </tr>");
	}
}, "json");

function singleTrend(obj){
	$(".right_bottom").empty();	
	$("#pList").empty();
	$.get("trend/selectNews?tid=" + obj,function (data){
		for (var i = 0; i < data.length; i++) {
			$(".right_bottom").append("<p class='newsp1'>"+data[i].ttag+"</p><p>发布日期&nbsp;:&nbsp;"+data[i].tDate+"</p>"
					+"<div class='newCont'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].tcontent+"</div>");
		}
	},"json");
	return false;
	
}
