<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<form  id="eMessage" style="width: 85%; margin: 0px auto;">
			<input type="hidden" name="eid" id="eid" /><br>
			<label> App Key :</label>
			<input name="mappkey"  id="mappkey" type="text" value="" />
			<br/><br/>
			<label> App Secret :</label>
			<input name="msecret"  id="msecret" type="text" value="" /><br><br>
			<label> 通知号码  :</label>
			<input name="mtel"  id="metl" type="tel" value=""   /><br><br>
			<label> 签名名称  :</label>
			<input name="msignname" id="msignname"  type="text" value=""  /><br><br>
			<label> 模板ID :</label>
			<input name="mtemplateCode" id="mtemplateCode"  type="text" value=""  /><br><br>
			<input type="button"  value="修改" onclick="mdUser()" /> 
			<input type="reset" value="重置" class="opt_sub" />
		</form>
	<script type="text/javascript" src="js/editUser.js"></script>
</body>
</html>