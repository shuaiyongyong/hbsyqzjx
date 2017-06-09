$('#checkInform').datagrid({    
	fitColumns : true,
    url:'message/list',    
    singleSelect:true,
    pagination : true,
    pageList:[5,10,15],
    columns:[[    
        {
        	field:'mid',
        	title:'ID',
        	width:100,
        	align:'center'
        },  {
        	field:'mappkey',
        	title:'APP KEY',
        	width:100,
        	align:'center'
        },  {
        	field:'msecret',
        	title:'App Secret',
        	width:200,
        	align:'center'
        },  {
        	field:'mtel',
        	title:'通知电话',
        	width:100,
        	align:'center',
        	formatter: function(value,row,index){
        		if(row.mtype==2){
        			return '';
        		}
        		return row.mtel;
        	}
        },{
        	field:'msignname',
        	title:'签名名称',
        	width:100,
        	align:'center'
        }, {
        	field:'mtemplateCode',
        	title:'模板ID',
        	width:100,
        	align:'center'
        },{
        	field:'mtype',
        	title:'短信类型',
        	width:100,
        	align:'center',
        	formatter: function(value,row,index){
        		var t;
        		if(row.mtype==1){
        			t='短信通知';
        		}else{
        			t='验证码'
        		}
        		var str ='<span>'+t+'</span>';
        		return str;
        	}
        }, {
        	field:'operate',
        	title:'操作',
        	width:100,
        	align:'center',
        	formatter: function(value,row,index){
        		var str ='<a class="operatorBtn" href="javascript:void(0)" onClick="operatorMes(3,'
        			+index+')">详情</a>&nbsp;'
        			+'<a class="operatorBtn" href="javascript:void(0)" onClick="operatorMes(2,'
        			+index+')">修改</a>&nbsp;'

        			+'<script>$(".operatorBtn").linkbutton();</script>';
        		return str;
        	}
        } ]]    
});  

function operatorMes(operType,index){
	switch (operType) {

	case 2:
		parent.openMM(index);//修改
		break;
	case 3:
		parent.openDM(index);//详情
		break;
	}
};


$("#detailDiv").dialog({
	title:"短信环境详情",
	closable:false
});
$("#detailDiv").dialog("close");
function openDM(index){
	$("#detailDiv").dialog("open");
	var row = $("#checkInform").datagrid("getRows")[index];
	$("#dmid").val(row.mid);
	$("#dmappkey").val(row.mappkey);
	$("#dmsecret").val(row.msecret);
	$("#dmtel").val(row.mtel);
	$("#dmsignname").val(row.msignname);
	$("#dmtemplateCode").val(row.mtemplateCode);
	if(row.mtype==2){
		$("#dmtel").val('')
	}
};
$("#modifyDiv").dialog({
	title:"用户修改",
	closable:false
});
$("#modifyDiv").dialog("close");
function closeDivM(){
	$("#modifyDiv").dialog("close");
}
function closeDivD(){
	$("#detailDiv").dialog("close");
}
function openMM(index){
	$("#modifyDiv").dialog("open");
	var row = $("#checkInform").datagrid("getRows")[index];
	$("#mid").val(row.mid);
	$("#mappkey").val(row.mappkey);
	$("#msecret").val(row.msecret);
	$("#mtel").val(row.mtel);
	$("#msignname").val(row.msignname);
	$("#mtemplateCode").val(row.mtemplateCode);
	if(row.mtype==2){
		$("#mtel").attr("readonly","readonly")
		$("#mtel").val('')
	}else if(row.mtype==1){
		$("#mtel").removeAttr("readonly");
	}
};
function mdMes(){
	var param=$("#eMessage").serialize();
	var regTel=/^1[34578]\d{9}$/;
	var telStr=$("#mtel").val();

	if(regTel.test(telStr)||telStr==''){
	$.post("message/modify",param,function(data){
		 $.messager.show({
				title : '修该短信模板',
				msg : data ? "修改成功..." : "修改失败！！！",
				showType : 'show',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop + 40,
				}
			});
		 $("#modifyDiv").dialog("close");
	},"json");
	
	}else{
		$.messager.alert('警告','电话号码格式错误','warning');
	}
	return false;
}
