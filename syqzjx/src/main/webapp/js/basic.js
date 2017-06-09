//JavaScript Document

$.get("cominfo/list",function(data){
	$("#logoIMG").attr('src',data.cbrand);
	$("#logoIMG2").attr('src',data.cbrand);
},"json");
