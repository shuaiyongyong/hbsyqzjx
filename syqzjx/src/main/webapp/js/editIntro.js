$(".buttC").linkbutton({iconCls: "icon-search"});
$(".buttE").linkbutton({iconCls: "icon-edit"});

function lodInfo(){
	$.get("cominfo/list",function(data){
		$("#editIntro1").html("&nbsp;&nbsp;&nbsp;&nbsp;"+data.cbrife);
		$("#textD").html(data.cbrife);
	},"json");
}
lodInfo();



var obj1=$("#editIntro1");
var obj2=$("#editIntro2");
function showObj1(){
	obj1.css('display','block');
	obj2.css('display','none');
}

function showObj2(){
	obj1.css('display','none');
	obj2.css('display','block');
}


function changeIntro(){
	var cbrife=$("#textD").val();
	var params={"cbrife":cbrife};
	$.post("cominfo/changeIntro",params,function(data){
		if(data){
			lodInfo();
		}
		$.messager.show({
			title:'修改简介',
			msg: data ? "修改成功..." : "修改失败!!!",
					showType:'show',
					style:{
						top:document.body.scrollTop+document.documentElement.scrollTop+250,
					}
		});

	},"json");
	return false;
}



