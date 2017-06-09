<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<div id="companyLogoDiv">
		<br/><br/><br/><br/>
		<center>
		<form id="logoForm" method="post" enctype="multipart/form-data">
			<br/><br/><br/>&nbsp;&nbsp;
			<input type="file" id="cbrand" name="cbrand" value="选择上传图片" onChange="changePic(this)"/>
			<br/><br/><br/><br/>
			<img id="pic" class="pic" width="136" height="50" alt="公司logo"/>
			<br/><br/><br/><br/>
			<a class="modifyBtn" href="javaScript:void(0)">修改</a>
		</form>
		</center>
	</div>
	<script type="text/javascript" src="js/companyTu.js"></script>
</body>
</html>