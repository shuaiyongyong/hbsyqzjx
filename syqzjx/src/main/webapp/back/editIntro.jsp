<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body id="editIntroBody">

	<div id="divButton">
		<button class="buttC" onclick="showObj1()">查看详情</button>
		<button class="buttE" onclick="showObj2()">修改信息</button>
	</div>

	<center>
	<div id="divBott">
		<div id="editIntro1"></div>
		<div id="editIntro2">
				<textarea id="textD" rows="16" cols="70" style="resize: none;" name="cbrife"></textarea>
				<br>
				<button class="buttE"
					onclick="changeIntro()">修改</button>
					
		</div>
	</div>
	</center>
	
	<script type="text/javascript" src="js/editIntro.js"></script>
</body>
</html>