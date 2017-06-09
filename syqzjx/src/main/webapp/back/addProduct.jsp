<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<form id="addProduct" enctype="multipart/form-data" 
		style="width: 85%; margin: 0px auto;"><!--  onsubmit="return addProduct()" -->
			<p>
				<label> 产品类别 </label> <select name="aptid" id="aptid"></select>
			</p>
			<p>
				<label>  产品名称 </label> <input name="apname"  id="apname" type="text" value="" class="opt_input"  required="required" />
			</p>
			<p>
				<label> 产品简介 </label>
				<textarea name="apbrife"  id="apbrife"  cols="70" rows="10" required="required"></textarea>
			</p>
			<p>
				<label> 上传图片 </label> <input name="appic" id="adpics" type="file" onchange="addPpic(this)" multiple="multiple"  required="required"  /><br> 
				<img id="acurrPic" src="images/ccwt.png" width="120">
			</p>
			<p id="pics"></p>

			<!-- <input type="submit"  value="添加"  />  -->
			<input type="button"  value="添加" onclick="addProduct()" /> 
			<input type="reset" value="重置" class="opt_sub" />
		</form>
	<script type="text/javascript" src="js/addProduct.js"></script>
</body>
</html>