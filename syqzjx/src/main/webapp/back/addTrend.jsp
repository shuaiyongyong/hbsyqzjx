<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<form id="addTrend"  style="width: 85%; margin-left: 300px;"><!-- onsubmit="return addTrend()"  -->
			<p>
				<label> 动态标题 :</label>
				 <input name="ttag"  id="ttag" type="text" value="" />
			</p>
			<p>
				<label> 动态内容 :</label>
				 <textarea name="tcontent"  id="tcontent"  cols="40" rows="8" style="overflow: auto;"></textarea>
			</p>
			<!-- <input type="submit"  value="添加" /> -->
			<input type="button"  value="添加" onclick="addTrend()" /> &nbsp;&nbsp;
			<input type="reset" value="重置" class="opt_sub"  />
		</form>

	<script type="text/javascript" src="js/addTrend.js"></script>
</body>
</html>