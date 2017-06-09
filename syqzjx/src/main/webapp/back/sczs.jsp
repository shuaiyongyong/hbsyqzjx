<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<div id="sczsDiv">
		<br/><br/><br/><br/>
		<center>
		<form id="zszsForm" method="post" enctype="multipart/form-data">
			<br/><br/><br/>&nbsp;&nbsp;
			<input id="infi" type="file" name="cconcrete" onChange="changePic(this)"/>
			<br/><br/><br/>
			<img id="zzzsPic" width="320" height="165" alt="资质证书哪里跑?" src="images/ccwt.png"/>
			<br/><br/><br/><br/>
			<a class="scBtn" href="javaScript:void(0)">上传</a>
		</form>
		</center>
	</div>
	
	<script type="text/javascript" src="js/sczs.js"></script>
	
</body>
</html>