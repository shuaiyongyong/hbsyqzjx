$('#trendInfo').datagrid({    
	fitColumns : true,
    url:'trend/list',    
    singleSelect:true,
    pagination : true,
    pageList:[5,10,15],
    columns:[[    
        {
        	field:'tid',
        	title:'ID',
        	width:100,
        	align:'center'
        },  {
        	field:'ttag',
        	title:'标题',
        	width:100,
        	align:'center'
        },  {
        	field:'tcontent',
        	title:'动态内容',
        	width:200,
        	align:'center'
        },  {
        	field:'tDate',
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
        			+row.tid+')">详情</a>&nbsp;'
        			+'<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(2,'
        			+row.tid+')">修改</a>&nbsp;'
        			+'<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(1,'
        			+row.tid+')">删除</a>'
        			+'<script>$(".operatorBtn").linkbutton();</script>';
        		return str;
        	}
        } ]]    
});  

function operatorFun(operType,id){
	switch (operType) {
	case 1:
		parent.openRT(id);
		break;
	case 2:
		parent.openMT(id);
		break;
	case 3:
		parent.openDT(id);
		break;
	}
};

function openRT(id){
	$.messager.confirm('删除动态信息', '是否确定删除此动态信息？', function(r){
		if (r){		
		   $.get("trend/remove?tid=" + id ,function(data){
			   if(data){
					$('#trendInfo').datagrid("reload");
				}
			   $.messager.show({
					title : '删除动态信息',
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

function openDT(id){
	tid = id;
	$("#detailTrend").dialog({
		title:'detailTrend',
		width:420,
		height:320,
		left:10,
		href: 'back/detailTrend.jsp'
	});
};

function openMT(id){
	tid = id;
	$("#modifyTrend").dialog({
		title:'modifyTrend',
		width:500,
		height:350,
		left:10,
		href: 'back/modifyTrend.jsp'
	});
};
