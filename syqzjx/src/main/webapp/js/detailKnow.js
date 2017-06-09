$.get("know/selectKnows?kid=" + kid,function(data){
	$("#ktags").html(data[0].ktag);
	$("#kcontents").html("&nbsp;&nbsp;&nbsp;"+data[0].kcontent);
	$("#kdate").html(data[0].kdate);
},"json");