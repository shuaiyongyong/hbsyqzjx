//获取job内容
function getJob(){
	$("#return_btn").empty()
	$("#return_btn").append('<table align="center" border="1px"'+
			'cellspacing="0" cellpadding="0" bordercolor="#CBCBCB" id="job_description">'+
        	'<thead style="background:#EEEEEE">'+
               ' <tr align="center" height="30px">'+
                   ' <td>序号</td>'+
                   ' <td>职位名称</td>'+
                   ' <td>招聘人数</td>'+
                   ' <td>工作地点</td>'+
                   ' <td>有效时间</td>'+
                   ' <td>职位描述</td>'+
               ' </tr>'+
           ' </thead>'+
            '<tbody id="job_body">'+
           ' </tbody>'+
        '</table>')
	$.post("employ/all",function(data){
		for(var i=0;i<data.length;i++){
			$("#job_body").append(' <tr align="center" height="30px">'+
				                    '<td>'+(i+1)+'</td>'+
				                    '<td>'+data[i].ename+'</td>'+
				                    '<td>'+data[i].ecount+'</td>'+
				                    '<td>'+data[i].eaddress+'</td>'+
				                    '<td>'+data[i].etime+'</td>'+
				                    '<td><a href="javascript:void(0) " onclick=getDescroption('+data[i].eid+')>查看</a></td>'+
				                	'</tr>')
		}
	},"json")
}
getJob();
function getDescroption( eid){
	$.post("employ/getdescription?eid="+eid,function(data){
		$("#job_description").empty();
		$("#job_description").append("<li>"+data.edescription+"</li></br>" +
				"<button style='float:right;' onclick='getJob();'><<</button>")
		
	},"json")
	
}