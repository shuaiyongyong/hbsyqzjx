<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<form id="addKnow"  style="width: 85%; margin-left: 300px;"><!-- onsubmit="return addKnow()"  -->
			<p>
				<label> 标题 :</label>
				 <input name="ktag"  id="ktag" type="text" value="" />
			</p>
			<p>
				<label> 内容 :</label>
				 <textarea name="kcontent"  id="kcontent"  cols="40" rows="8" style="overflow: auto;"></textarea>
			</p>
			<!-- <input type="submit"  value="添加" /> -->
			<input type="button"  value="添加" onclick="addKnow()" /> &nbsp;&nbsp;
			<input type="reset" value="重置" class="opt_sub"  />
		</form>

	<script type="text/javascript" src="js/addKnow.js"></script>
</body>
</html>