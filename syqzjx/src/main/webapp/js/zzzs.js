//后台需要:
	//1.添加资质证书
	//设置资质证书旁边的页面

	function getMessage(){
		//资质证书
		$.post("context/zs",function(data){
			for(var i=0;i<data.length;i++){
				if(data[i].ctype==6){
					//资质质证书旁的内容获取
					$.post("product/getzsbrief?img="+data[i].cconcrete,function(d){
						$("#left_img").append('<img width="299" src="'+d.ppic+'" height="370"/>')
						$("#left_bottom").append('<li>'+d.pbrife+'</li>')
					},"json")
				break;
				}
				
				$("#zs").append("<img src='"+data[i].cconcrete+"' />");
			}
			
		},"json");
	
	}
	
	
	getMessage();
