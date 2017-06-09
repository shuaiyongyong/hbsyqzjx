<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<form  id="mTel" style="width: 85%; margin: 0px auto;"><br>
			<label>原始号码:</label><label id="oldTel" ></label><br><br>
			<label>新 号 码 :</label> 
			<input name="mutel"  id="mutel" type="tel" value=""   placeholder="请输入新的手机号码"  /><br><br>
			<input type="button"  value="修改" onclick="mTel()" /> 
			<input type="reset" value="重置" class="opt_sub" />
		</form>
	<script type="text/javascript" src="js/modifyTel.js"></script>
</body>
</html>