<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>

<center>
	<form id="AjobForm" method="post" style="text-align:center;font-size: 14px;">
		<br>
		<p><span>职位名称:</span>&nbsp;<input type="text" id="aename" name="ename"/></p><br>
		<p><span>招聘人数:</span>&nbsp;<input type="text" id="aecount" name="ecount"/></p><br>
		<p><span>工作地点:</span>&nbsp;<input type="text" id="aeaddress" name="eaddress"/></p><br>
		<p><span>有效时间:</span>&nbsp;<input type="text" id="aetime" name="etime"/></p><br>
		<p><span>职位描述:</span>&nbsp;
			<textarea id="medescription" rows="7" cols="20" style="resize: none;" name="edescription"></textarea>
		</p>
		<br><br>
		<p><a class="addBtn" href="javascript:void(0)">添加</a></p>
		<br>
	</form>
</center>	
	
	<script type="text/javascript" src="js/addJob.js"></script>
</body>
</html>