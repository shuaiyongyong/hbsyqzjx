$('#typeInfo').datagrid({    
	fitColumns : true,
    url:'product/typeList',    
    singleSelect:true,
    pagination : true,
    pageList:[5,10,15],
    columns:[[    
        {
        	field:'ptid',
        	title:'产品类型ID',
        	width:100,
        	align:'center'
        },  {
        	field:'ptname',
        	title:'产品类型名称',
        	width:200,
        	align:'center'
        }, {
        	field:'nsummary',
        	title:'操作',
        	width:100,
        	align:'center',
        	formatter: function(value,row,index){
        		var str ='<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(1,'
        			+row.ptid+')">修改</a>&nbsp;'
        			+'<script>$(".operatorBtn").linkbutton();</script>';
        		return str;
        	}
        } ]]    
});  

function operatorFun(operType,id){
	switch (operType) {
	case 1:
		parent.openMPT(id);
		break;
	}
};


function openMPT(id){
	ptid = id;
	$("#modifyType").dialog({
		title:'modifyType',
		width:300,
		height:200,
		left:10,
		href: 'back/modifyType.jsp'
	});
};
