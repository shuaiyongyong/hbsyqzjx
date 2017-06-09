<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>

	<form id="EjobForm" method="post" style="text-align:center;font-size: 14px;">
		<br>
		<p><input type="hidden" id="meid" name="eid"/></p>
		<p><span>职位名称:</span>&nbsp;<input type="text" id="mename" name="ename"/></p><br>
		<p><span>招聘人数:</span>&nbsp;<input type="text" id="mecount" name="ecount"/></p><br>
		<p><span>工作地点:</span>&nbsp;<input type="text" id="meaddress" name="eaddress"/></p><br>
		<p><span>有效时间:</span>&nbsp;<input type="text" id="metime" name="etime"/></p><br>
		<p><span>职位描述:</span>&nbsp;
			<textarea id="medescription" rows="7" cols="20" style="resize: none;" name="edescription"></textarea>
		</p>
		<br><br>
		<p><a class="editBtn" href="javascript:void(0)">修改</a></p>
	</form>
	
	
	<script type="text/javascript" src="js/editJobInfo.js"></script>
</body>
</html>