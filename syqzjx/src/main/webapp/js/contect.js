$('#contectTable').datagrid({    
	fitColumns:true,
	url:'contect/list',  
	singleSelect:true,
	columns:[[ 
	          {field:'cid',title:'编号',width:80,align:'center'},    
	          {field:'ctype',title:'类型',width:140,align:'center',
	        	  formatter:function(value,row,index){
	        		  var str=null;
	        		  if(value=="1"){
	        			  str="电话号码";
	        		  }else if(value=="2"){
	        			  str="微信二维码";
	        		  }else if(value=="3"){
	        			  str="微信账号";
	        		  }else if(value=="4"){
	        			  str="邮箱";
	        		  }
	        		  return str;
		          } 
	          },
	          {field:'cconcrete',title:'联系方式',width:150,align:'center',
	        	  formatter:function(value,row,index){
	        		  var str=null;
	        		  if(row.ctype=="2"){
	        			  str='<img alt="二维码咋不见了..." src="'+value+'"/>';
	        		  }else{
	        			  str=value;
	        		  }
	        		 return str;
		          } 
	          },
	          {field:'operator',title:'操作',width:120,align:'center',
	        	formatter:function(value,row,index){
	        		var str = '<a class="operatorBtn1" href="javaScript:void(0)" onClick="modifyC('+row.ctype+','+row.cid+')">编辑</a>&nbsp;'
	        			+'<script>$(".operatorBtn1").linkbutton({iconCls: "icon-edit"});</script>';
	        		return str;
	        	}  
	          },
	          ]]
});

var cid;
function modifyC(ctype,id){
	cid=id;
	if(ctype=="2"){
		$("#modifyConnectDiv").dialog({
			title:'更改二维码',
			width:300,
			height:450,
			left:300,
			modal:true,
			href:'back/modifyConnect2.jsp?'
		});
	}else{
		$("#modifyConnectDiv").dialog({
			title:'更改联系方式',
			width:220,
			height:320,
			left:300,
			modal:true,
			href:'back/modifyConnect1.jsp?'
		});
	}
}

function closeModifyC(){
	$('#modifyConnectDiv').dialog('close',true);
}













