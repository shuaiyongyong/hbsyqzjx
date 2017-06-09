$.get("guest/getByid?gid=" + gsid,function(data){
	$("#gcontents").html("&nbsp;&nbsp;&nbsp;"+data.gcontent);
	$("#gdate").html(data.gtime);
},"json");