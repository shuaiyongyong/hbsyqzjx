
$("#LeftSider").accordion({
	fit:true,
});

$.get("cominfo/list",function(data){
	$("#top_logo").attr('src',data.cbrand);
},"json");

var urlJson={"简介管理":"editIntro.jsp","公司图标":"companyTu.jsp","资格证书":"zgzs.jsp","上传证书":"sczs.jsp","联系方式":"contect.jsp",
		     "编辑信息":"editUser.jsp",
		     "添加分类":"addType.jsp","编辑分类":"editType.jsp",
		     "添加产品":"addProduct.jsp","编辑产品":"editProduct.jsp",
		     "查看留言":"checkMes.jsp",
		     "添加招聘信息":"addJob.jsp","编辑招聘信息":"editJob.jsp",
		     "添加知识":"addKnow.jsp", "编辑知识":"editKnow.jsp",
		     "添加动态":"addTrend.jsp","编辑动态":"editTrend.jsp",
		     "编辑短信环境":"checkInform.jsp"		};

$(".menutree").tree({
	onClick:function(node){
		//alert(node.text);
		var nt=node.text;
		if($('#main').tabs('exists',nt)){   //当前面板存在
			//打开当前选中面板
			$('#main').tabs('select',nt);
		}else{                              //当前面板不存在
			if(urlJson[nt]){
				$('#main').tabs('add',{    
				    title:nt,    
				    href:"back/"+urlJson[nt],    
				    closable:true,    
				});  
			}else{
				$('#main').tabs('add',{    
				    title:nt,    
				    content:'<h1>'+nt+'</h1>',    
				    closable:true,    
				});  
			}
		}
	}
});
$("#main").tabs({
	fit:true,
})