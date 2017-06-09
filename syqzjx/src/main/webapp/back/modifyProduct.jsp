<%@  page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理界面</title>
</head>

<body>
		<form id="mProduct" enctype="multipart/form-data" style="width: 85%; margin: 0px auto;">
			<input type="hidden" name="pid" id="npid" />
			<p>
				<label> 产品类别 </label> <select name="ptid" id="ptid"></select>
			</p><br>
			<p>
				<label> 产品名称 </label> <input name="pname"  id="npname" type="text" value="" />
			</p><br>
			<p>
				<label> 产品简介 </label>
				<textarea name="pbrife"  id="npbrife"  cols="40" rows="8" style="overflow: auto;"></textarea>
			</p><br>
			<p>
				<label> 产品图片 </label> <input name="file"  id="cpic" type="file" onchange="addPic(this)" multiple="multiple" /><br> 
				<img id="currPic" alt="图片" src="images/1.jpg"  width="100">
			</p>
			<p id="pics"></p>

			<input type="button"  value="修改" onclick="mProduct()" /> 
			<input type="reset" value="重置" class="opt_sub" />
		</form>
	<script type="text/javascript" src="js/modifyProduct.js"></script>
</body>
</html>
