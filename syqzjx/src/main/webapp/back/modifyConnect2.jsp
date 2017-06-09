<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>

	<form id="picForm" method="post" enctype="multipart/form-data" style="text-align:center;">
		<br/><br/><br/>&nbsp;&nbsp;
		<input id="picInputFile" type="file" name="cconcrete" onChange="changePic(this)"/>
		<br/><br/><br/>
		<img id="chatPic" class="chatPic" width="140" height="140" alt="二维码跑哪儿去了"/>
		<br/><br/><br/>
		<a class="modifyBtn" href="javaScript:void(0)">修改</a>
	</form>
	
	<script type="text/javascript" src="js/modifyConnect2.js"></script>
</body>
</html>