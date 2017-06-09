<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>后台管理</title>
</head>
<body>
	<table id="checkInform"></table>
	<div id="modifyDiv">
		<form  id="eMessage" style="width: 85%; margin: 0px auto;" onsubmit="return mdMes()">
			<input type="hidden" name="mid" id="mid" /><br>
			<label> App Key :</label>
			<input name="mappkey"  id="mappkey" type="text" value="" />
			<br/><br/>
			<label> App Secret :</label>
			<input name="msecret"  id="msecret" type="text" value="" /><br><br>
			<label> 通知号码  :</label>
			<input name="mtel"  id="mtel" type="tel" value=""   /><br><br>
			<label> 签名名称  :</label>
			<input name="msignname" id="msignname"  type="text" value=""  /><br><br>
			<label> 模板ID :</label>
			<input name="mtemplateCode" id="mtemplateCode"  type="text" value=""  /><br><br>
			<input type="submit"  value="修改" /> 
			<input type="button" value="关闭" onclick="closeDivM()" />
		</form>
	</div>
	
	<div id="detailDiv">
			<form  id="detailMessage" style="width: 85%; margin: 0px auto;">
			<input type="hidden" name="mid" id="dmid" /><br>
			<label> App Key :</label>
			<input name="mappkey"  id="dmappkey" type="text" value="" readonly="readonly" />
			<br/><br/>
			<label> App Secret :</label>
			<input name="msecret"  id="dmsecret" type="text" value="" readonly="readonly"/><br><br>
			<label> 通知号码  :</label>
			<input name="mtel"  id="dmtel" type="tel" value="" readonly="readonly"  /><br><br>
			<label> 签名名称  :</label>
			<input name="msignname" id="dmsignname"  type="text" value="" readonly="readonly" /><br><br>
			<label> 模板ID :</label>
			<input name="mtemplateCode" id="dmtemplateCode"  type="text" value="" readonly="readonly" /><br><br>
			<input type="button" value="关闭" onclick="closeDivD()" />
		</form>
			
	</div>
	<script type="text/javascript" src="js/checkInform.js"></script>
</body>
</html>