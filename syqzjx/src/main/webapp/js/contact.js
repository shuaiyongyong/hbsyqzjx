//JavaScript Document
$.get("context/all",function(data){
	for (var i = 0; i < data.length; i++) {
		if(data[i].ctype == 4){//-- 1 电话号码  2 微信二维码路径  3 微信账号 4 邮箱 5 证书 6 资质证书旁的产品展示图片
			$("#web").html("&nbsp;"+data[i].cconcrete);
		}
	}
},"json")

$.get("cominfo/listContect?ctype=1",function(data){
		$("#tel1").html("&nbsp;"+data[0].cconcrete);
		$("#tel2").html("&nbsp;"+data[1].cconcrete);
},"json")
$.get("cominfo/listContect?ctype=3",function(data){
	$("#wNum").html("&nbsp;"+data[0].cconcrete+"、"+data[1].cconcrete);
},"json")
$.get("cominfo/listContect?ctype=2",function(data){
	$("#wPic1").attr('src',data[0].cconcrete);
	$("#wPic2").attr('src',data[1].cconcrete);

},"json")