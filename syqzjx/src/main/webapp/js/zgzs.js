$('#zgzsTable').datagrid({    
	fitColumns:true,
	url:'contect/list1',  
	singleSelect:true,
	columns:[[ 
	          {field:'cid',title:'编号',width:20,align:'center'},    
	          {field:'cconcrete',title:'资质证书',width:150,align:'center',
	        	  formatter:function(value,row,index){
		        		var str = '<img width="300" height="150" alt="资质证书长腿了??" src="'+value+'"/>';
		        		return str;
		        	} 
	          },
	          {field:'operator',title:'操作',width:50,align:'center',
	        	formatter:function(value,row,index){
	        		var str = '<a class="operatorBtn" href="javaScript:void(0)" onClick="delC('+row.cid+')">删除</a>'
	        			     +'<script>$(".operatorBtn").linkbutton({iconCls: "icon-edit"});</script>';
	        		return str;
	        	}  
	          },
	          ]]
});

function delC(cid){
	$.messager.confirm('确认对话框', '您确认删除吗?', function(r){
		if (r){
		   $.get("contect/delZzzs?cid="+cid,function(data){
			   if(data){
				   $.messager.alert('消息提示','恭喜您,删除成功...','info');
				   $('#zgzsTable').datagrid('reload');
			   }else{
				   $.messager.alert('消息提示','抱歉，可能由于网络原因删除失败...','info');
			   }
		   },"json")
		}
	});

}
























