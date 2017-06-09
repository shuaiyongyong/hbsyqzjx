// JavaScript Document

window.onload =function () { 
	var dome=document.getElementById("dom");
	var dome1=document.getElementById("dom1");
	var dome2=document.getElementById("dom2");
	var speed=20; //设置向左滚动速度
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
	$("#logoIMG").attr('src',data.cbrand);
	$("#logoIMG2").attr('src',data.cbrand);
},"json");