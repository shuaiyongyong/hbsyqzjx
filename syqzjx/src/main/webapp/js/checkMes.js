$('#mesInfo').datagrid({    
	fitColumns : true,
    url:'guest/list',    
    singleSelect:true,
    pagination : true,
    pageList:[5,10,15],
    columns:[[    
        {
        	field:'gid',
        	title:'ID',
        	width:100,
        	align:'center'
        },  {
        	field:'gname',
        	title:'留言姓名',
        	width:100,
        	align:'center'
        },  {
        	field:'gtel',
        	title:'留言方式',
        	width:100,
        	align:'center'
        },  {
        	field:'gemail',
        	title:'联系邮箱',
        	width:100,
        	align:'center'
        },{
        	field:'gtime',
        	title:'留言时间',
        	width:100,
        	align:'center'
        }, {
        	field:'gcontent',
        	title:'模板ID',
        	width:100,
        	align:'center'
        }, {
        	field:'operate',
        	title:'操作',
        	width:100,
        	align:'center',
        	formatter: function(value,row,index){
        		var str ='<a class="operatorBtn" href="javascript:void(0)" onClick="operatorGue(3,'
        			+row.gid+')">详情</a>&nbsp;'
        			+'<a class="operatorBtn" href="javascript:void(0)" onClick="operatorGue(1,'
        			+row.gid+')">删除</a>'
        			+'<script>$(".operatorBtn").linkbutton();</script>';
        		return str;
        	}
        } ]]    
});  
 

function operatorGue(operType,id){
	switch (operType) {
	case 1:
		parent.openDMS(id);
		break;

	case 3:
		parent.openTMS(id);//详情
		break;
	}
};

function openDMS(id){
	$.messager.confirm('删除留言', '是否确定删除此留言？', function(r){
		if (r){		
		   $.get("guest/delete?gid=" + id ,function(data){
			   if(data){
					$('mesInfo').datagrid("reload");
				}
			   $.messager.show({
					title : '删除留言',
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
var gsid; 
function openTMS(id){
	gsid=id
	$("#detailGuest").dialog({
		title:'detailGuest',
		width:420,
		height:320,
		left:10,
		href: 'back/detailMes.jsp'
	});
};

