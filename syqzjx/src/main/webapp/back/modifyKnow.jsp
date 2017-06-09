<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<form  id="mKnow" style="width: 85%; margin: 0px auto;">
			<input type="hidden"  name="kid"  id="kid" /><br>
			<label>标题名称:</label> 
			<input name="ktag"  id="mktag" type="text" value=""   placeholder="请输入标题名称"  /><br><br>
			<label>知识内容:</label> 
			<textarea name="kcontent"  id="mkcontent"  cols="40" rows="8" style="overflow: auto;" ></textarea><br><br>
			<input type="button"  value="修改" onclick="mKnow()" /> 
			<input type="reset" value="重置" class="opt_sub" />
		</form>
	<script type="text/javascript" src="js/modifyKnow.js"></script>
</body>
</html>