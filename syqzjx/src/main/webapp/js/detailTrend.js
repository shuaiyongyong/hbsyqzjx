$.get("trend/selectNews?tid=" + tid,function(data){
	$("#ttags").html(data[0].ttag);
	$("#tcontents").html("&nbsp;&nbsp;&nbsp;"+data[0].tcontent);
	$("#tdate").html(data[0].tDate);
},"json");