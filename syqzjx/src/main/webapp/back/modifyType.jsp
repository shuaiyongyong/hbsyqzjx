<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<form  id="mType" style="width: 85%; margin: 0px auto;">
			<input type="hidden" name="ptyid" id="ptyid" /><br>
			<label>类别名称:</label> 
			<input name="ptyname"  id="ptyname" type="text" value=""   placeholder="请输入产品类别名称"  /><br><br/>
			<input type="button"  value="修改" onclick="mdPtype()" /> 
			<input type="reset" value="重置" class="opt_sub" />
		</form>
	<script type="text/javascript" src="js/modifyType.js"></script>
</body>
</html>