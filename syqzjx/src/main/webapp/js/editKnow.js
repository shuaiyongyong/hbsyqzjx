$('#knowInfo').datagrid({    
	fitColumns : true,
    url:'know/list',    
    singleSelect:true,
    pagination : true,
    pageList:[5,10,15],
    columns:[[    
        {
        	field:'kid',
        	title:'ID',
        	width:100,
        	align:'center'
        },  {
        	field:'ktag',
        	title:'标题',
        	width:100,
        	align:'center'
        },  {
        	field:'kcontent',
        	title:'知识内容',
        	width:200,
        	align:'center'
        },  {
        	field:'kdate',
        	title:'发布时间',
        	width:100,
        	align:'center'
        }, {
        	field:'nsummary',
        	title:'操作',
        	width:100,
        	align:'center',
        	formatter: function(value,row,index){
        		var str ='<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(3,'
        			+row.kid+')">详情</a>&nbsp;'
        			+'<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(2,'
        			+row.kid+')">修改</a>&nbsp;'
        			+'<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(1,'
        			+row.kid+')">删除</a>'
        			+'<script>$(".operatorBtn").linkbutton();</script>';
        		return str;
        	}
        } ]]    
});  

function operatorFun(operType,id){
	switch (operType) {
	case 1:
		parent.openRK(id);
		break;
	case 2:
		parent.openMK(id);
		break;
	case 3:
		parent.openDK(id);
		break;
	}
};

function openRK(id){
	$.messager.confirm('删除起重知识', '是否确定删除此起重知识？', function(r){
		if (r){		
		   $.get("know/remove?kid=" + id ,function(data){
			   if(data){
					$('#knowInfo').datagrid("reload");
				}
			   $.messager.show({
					title : '删除起重知识',
					msg : data ? "删除成功..." : "删除失败！！！",
					showType : 'show',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop + 40,
					}
				});
		   },"json");
		}
	});


};

function openDK(id){
	kid = id;
	$("#detailKnow").dialog({
		title:'detailKnow',
		width:420,
		height:320,
		left:10,
		href: 'back/detailKnow.jsp'
	});
};

function openMK(id){
	kid = id;
	$("#modifyKnow").dialog({
		title:'modifyKnow',
		width:500,
		height:350,
		left:10,
		href: 'back/modifyKnow.jsp'
	});
};
