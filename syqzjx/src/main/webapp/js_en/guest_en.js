function getGuest(){
	$(".contact").empty();
	$(".contact").append('<form onsubmit=" return sendGuest()" id="guestId" method="post">'
            +'<span >&nbsp;&nbsp;&nbsp;&nbsp;Name：</span><input type="text" name="gname" size="12px" required="required" class="content"/><br/>'
            +'<span >&nbsp;&nbsp;&nbsp;&nbsp;Phone：</span><input type="tel" name="gtel" size="24px" required="required" class="content"/><br/>'
            +'<span >&nbsp;&nbsp;&nbsp;&nbsp;E_mail：</span><input type="email" name="gemail" size="24px" required="required" class="content"/><br/>'
            +'<textarea style="resize:none;font-size:13px;"  name="gcontent" id="gcontent" class="content" ></textarea><br/>'
            +'<input type="submit" name="send" value="send" class="send"/>'
            +'<input type="reset" name="send" value="rewrite" class="reset"/>'
            +'</form>');
}
function sendPhone(){
	$(".contact").empty();
	$(".contact").append("<p style='font-size:14px; font-weight:bold; margin-top:50px;margin-left:28px;'>"
			+"Address：East Industrial Park, Baoding, Hebei</p>"
			+"<p style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:28px;'>"
			+"Zip code：071100</p>"
			+"<p style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:28px;'>"
			+"Telephone：13722237047  13303028262</p>"
			+"<p style='font-size:14px; font-weight:bold; margin-top:23px;margin-left:28px;'>"
			+"E_Mail：hbsyqzjx@foxmail.com</p>");
}
function sendWeixin(){
	$(".contact").empty();
	$(".contact").append("<p style='font-size:14px; font-weight:bold; margin-top:15px;margin-left:48px;'>We chat number：</p>"
			+"<p style='font-size:14px; font-weight:bold; margin-top:15px;margin-left:48px;'>13722237047、13303028262</p>"
			+"<p style='font-size:14px; font-weight:bold; margin-top:15px;margin-left:48px;'>Micro signal code：</p>"
			+"<img src='images/weixin1.jpg' style='margin-top:10px; margin-left:30px;'/>"
			+"<img src='images/weixin2.jpg' style='margin-top:10px; margin-left:20px;'/>");
}


$.get("cominfo/list",function(data){
	$("#logoIMG").attr('src',data.cbrand);
	$("#logoIMG2").attr('src',data.cbrand);
},"json");