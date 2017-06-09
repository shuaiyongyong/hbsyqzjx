$('#employTable').datagrid({    
	fitColumns:true,
	url:'employ/list',  
	singleSelect:true,
	columns:[[ 
	          {field:'eid',title:'编号',width:20,align:'center'},    
	          {field:'ename',title:'职位名称',width:80,align:'center'},
	          {field:'ecount',title:'招聘人数',width:50,align:'center'},
	          {field:'eaddress',title:'工作地点',width:50,align:'center'},
	          {field:'etime',title:'有效时间',width:80,align:'center'},
	          {field:'edescription',title:'职位描述',width:120,align:'center'},
	          {field:'operator',title:'操作',width:70,align:'center',
	        	formatter:function(value,row,index){
	        		var str = '<a class="operatorBtn" href="javaScript:void(0)" onClick="delE('+row.eid+')">删除</a>&nbsp;&nbsp;'
	        				 +'<a class="operatorBtn" href="javaScript:void(0)" onClick="editE('+row.eid+')">编辑</a>'
	        			     +'<script>$(".operatorBtn").linkbutton({iconCls: "icon-edit"});</script>';
	        		return str;
	        	}  
	          },
	          ]]
});


var eid;
function editE(id){
	eid=id;
	$("#editEmployDiv").dialog({
		title:'更改招聘信息',
		width:450,
		height:550,
		left:500,
		modal:true,
		href:'back/editJobInfo.jsp?'
	});
}
function closeEditE(){
	$('#editEmployDiv').dialog('close',true);
}

function delE(id){
	$.messager.confirm('确认对话框', '您确认删除吗?', function(r){
		if(r){
			$.get("employ/delJob?eid="+id,function(data){
				$.messager.show({
					title:'删除招聘信息',
					msg: data ? "删除成功..." : "删除失败!!!",
							showType:'show',
							style:{
								top:document.body.scrollTop+document.documentElement.scrollTop+250,
							}
				});
				
				$('#employTable').datagrid("reload");
				
			},"json")
		}
	});
}
















