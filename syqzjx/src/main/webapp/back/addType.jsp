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
	<form id="addType" style="width: 85%;">
		<br>
		<br>
		<p>
			<label> 产品类别 :</label> <input name="ptname" id="ptname" type="text"
				value="" class="ptname" />
		</p>
		<br />
		<!-- <input type="submit"  value="添加" /> -->
		<input type="button" value="添加" onclick="addType()" />&nbsp;&nbsp; <input
			type="reset" value="重置" class="opt_sub" />
	</form>
</center>
	<script type="text/javascript" src="js/addType.js"></script>
</body>
</html>