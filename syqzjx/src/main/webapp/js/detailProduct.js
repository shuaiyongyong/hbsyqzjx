$.get("product/selectPic?pid=" + pid,function(data){
	$("#pname").html(data[0].pname);
	$("#pbrife").html("&nbsp;&nbsp;&nbsp;"+data[0].pbrife);
	$("#ppic").attr("src",data[0].ppic);
},"json");