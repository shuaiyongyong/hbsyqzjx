$('#productInfo').datagrid({    
	fitColumns : true,
    url:'product/list',    
    singleSelect:true,
    pagination : true,
    pageList:[5,10,15],
    columns:[[    
        {
        	field:'pid',
        	title:'产品ID',
        	width:50,
        	align:'center'
        },  {
        	field:'pname',
        	title:'产品名称',
        	width:100,
        	align:'center'
        }, {
        	field:'pbrife',
        	title:'产品简介',
        	width:150,
        	align:'center'
        }, {
        	field:'ppic',
        	title:'产品图片',
        	width:100,
        	align:'center',
        	formatter: function(value,row,index){
    			if(value == null || value == "/upload/"){
    				return "<img width='100'  src = 'images/1.jpg' />"
    			}else{
    				return "<img width='100'  src = '"+value+"' />"
    			}
    		}
        },{
        	field:'nsummary',
        	title:'操作',
        	width:60,
        	align:'center',
        	formatter: function(value,row,index){
        		var str ='<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(2,'
        			+row.pid+')">修改</a>&nbsp;'
        			+'<a class="operatorBtn" href="javascript:void(0)" onClick="operatorFun(1,'
        			+row.pid+')">详情</a>'
        			+'<script>$(".operatorBtn").linkbutton();</script>';
        		return str;
        	}
        } ]]    
});  

function operatorFun(operType,id){
	switch (operType) {
	case 1:	
		parent.openDP(id);	//详情
		break;
	case 2:	
		parent.openMP(id);	//修改
		break;
	}
};

var pid;
function openDP(id){
	pid = id;
	$("#detailProduct").dialog({
		title:'detailProduct',
		width:420,
		height:500,
		left:300,
		href: 'back/detailProduct.jsp',    
	    modal: true 
	});
};


function openMP(id){
	pid = id;
	$("#modifyProduct").dialog({
		title:'modifyProduct',
		width:600,
		height:650,
		left:300,
		href: 'back/modifyProduct.jsp',
		modal: true
	});
};

