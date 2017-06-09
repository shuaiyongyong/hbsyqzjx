// JavaScript Document

//图片轮换
window.onload =function () { 
	var dome=document.getElementById("dom");
	var dome1=document.getElementById("dom1");
	var dome2=document.getElementById("dom2");
	var speed=30; //设置向左滚动速度
	dome2.innerHTML=dome1.innerHTML; //复制dome1为dome2
	function moveLeft(){
		if(dome2.offsetLeft<=dome.scrollLeft){ //当滚动至dome1与dome2交界时
			dome.scrollLeft-=dome2.offsetLeft; //dome跳到最顶端
		}else{
			dome.scrollLeft++;
		}
	}
	var MyMar=setInterval(moveLeft,speed); //设置定时器
	dome.onmouseover=function() {clearInterval(MyMar)} ;//鼠标移上时清除定时器达到滚动停止的目的
	dome.onmouseout=function() {MyMar=setInterval(moveLeft,speed)}; //鼠标移开时重设定时器，继续滚动
}

$.get("cominfo/list",function(data){
	$("#compInfo").html("&nbsp;&nbsp;&nbsp;&nbsp;"+data.cbrife.substr(0,185)+
			"...<a href='page/about.jsp'>更多请点击...</a>");
	$("#logoIMG").attr('src',data.cbrand);
	$("#logoIMG2").attr('src',data.cbrand);
},"json");

$.get("cominfo/listProductType",function(data){
	if(data.length>=9){
		for(var i=0;i<data.length;i++){
			$("#tdpt"+i).html("<a href='page/lou.jsp?ptid="+data[i].ptid+"'>"+data[i].ptname+"</a>");
		}
	}else if(data.length<9){
		for(var i=0;i<data.length;i++){
			$("#tdpt"+i).html("<a href='page/lou.jsp?ptid="+data[i].ptid+"'>"+data[i].ptname+"</a>");
		}
		for(var j=0;j<9-data.length;j++){
			$("#tdpt"+data.length+1+j).html("暂无该类型");
		}
	}
},"json");


$.get("cominfo/listContect?ctype=5",function(data){
	$("#zzzsImg").attr('src',data[0].cconcrete);
},"json");


$.get("cominfo/listKnow",function(data){
	if(data.length>=6){
		for(var i=0;i<6;i++){
			$("#knowTable").append('<tr height="30">'+
					'<td style="border-bottom:dotted 1px #A3A3A3;"><img src="images/x-tu.jpg"/></td>'+
					'<td style="border-bottom:dotted 1px #A3A3A3;"><a href="page/qzzs.jsp?kid='+data[i].kid+'">'+data[i].ktag+'</a></td>'+
					'<td style="border-bottom:dotted 1px #A3A3A3; color:#39F;" align="center">['+data[i].kdate+']</td>'+
			'</tr>');
		}
	}else{
		for(var i=0;i<data.length;i++){
			$("#knowTable").append('<tr height="30">'+
					'<td style="border-bottom:dotted 1px #A3A3A3;"><img src="images/x-tu.jpg"/></td>'+
					'<td style="border-bottom:dotted 1px #A3A3A3;"><a href="page/qzzs.jsp?kid='+data[i].kid+'">'+data[i].ktag+'</a></td>'+
					'<td style="border-bottom:dotted 1px #A3A3A3; color:#39F;" align="center">['+data[i].kdate+']</td>'+
			'</tr>');
		}
	}
	
},"json");


$.get("cominfo/listContect?ctype=1",function(data){
	$("#tdTel").html(data[0].cconcrete+"&nbsp;&nbsp;"+data[1].cconcrete);
},"json");

$.get("cominfo/listContect?ctype=4",function(data){
	$("#tdEmail").html(data[0].cconcrete);
},"json");


