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
	<form id="mUser">
			<input type="hidden" name="usid" id="usid" /><br>
			<label> 用 户 名 ：</label> <label id="uname"></label>
			<br/><br/>
			<label> 新 密 码 ：</label>
			<input name="newpwd"  id="newpwd" type="password" value="" /><br><br>
			<label> 确认密码：</label>
			<input name="upwd"  id="mnewpwd" type="password" value=""   /><br><br>
			<label> 绑定手机：</label><label id="tel"  ></label>&nbsp;&nbsp;<a href="javascript:void(0)" id="mdUtel" class="mdBtn">修改绑定手机</a><br><br>
			<input type="button"  value="修改" onclick="mdUser()" /> 
			<input type="reset" value="重置" class="opt_sub" />
			<br/><br/>
		</form>
</center>
	<script type="text/javascript" src="js/editUser.js"></script>
</body>
</html>