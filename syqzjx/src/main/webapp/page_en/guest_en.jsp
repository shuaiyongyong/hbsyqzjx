<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="/syqzjx/">
<title>河北山叶起重机械制造有限公司</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="shortcut icon" type="image/x-icon" href="images/yclogo.png" />
<link rel="stylesheet" type="text/css" href="css/basic.css">
<link rel="stylesheet" type="text/css" href="css/guest.css">
</head>
<body>
	<!--顶部的flash-->
	<header>
    	<div>
    		<div id="logo"><img id="logoIMG" width="136" height="50"/></div>
        	<div id="syqz">
        		<img src="images/theme.jpg">
        	</div>
        	<div id="zyw">
            	<a href="page/guest.jsp"><img src="images/zh.jpg"/><span class="zh">中文版</span></a>
                &nbsp;
            	<a href="page_en/guest_en.jsp"><img src="images/en.jpg"/><span class="zh">English</span></a>
            </div>
       		<div id="him"><img src="images/dh.jpg"/></div>
        </div>
       
    </header>
    
    
    <!--菜单部分-->
    <menu>
    	<li><a href="page_en/index_en.jsp">Home</a></li>
        <li><a href="page_en/about_en.jsp">About Company</a></li>
        <li><a href="page_en/lou_en.jsp">Produce</a></li>
        <li><a href="page_en/news_en.jsp">Trends</a></li> 
        <li><a href="page_en/zzzs_en.jsp">Certificate</a></li>
        <li><a href="page_en/qzzs_en.jsp">Lifting knowledge</a></li>
        <li><a href="page_en/job_en.jsp">Job</a></li>
        <li><a href="page_en/contact_en.jsp">Contact us</a></li>
        <li><a href="page_en/guest_en.jsp">Leave Mes</a></li>
    </menu>
    
    
    <!--中间动态图片-->
    <embed src="images/banner.swf" class="embed"></embed>
    <!--中间内容区-->
       <article>
       <div class="contact">
        	<form onsubmit="return sendGuest()" id="guestId" method="post">
            <span>&nbsp;&nbsp;&nbsp;&nbsp;Name：</span><input  type="text" name="gname" id="gName" size="12px" required="required" class="content"/><br/>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;Phone：</span><input type="tel" name="gtel" id="gTel" size="24px" class="content" required="required"/><br/>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;E_mail：</span><input type="email" name="gemail" id="gEmail" size="24px" class="content" required="required"/><br/>
            <textarea style="resize:none; font-size:13px;" name="gcontent" id="gContent"class="content"></textarea><br/>
            <input type="submit" name="send" value="提交" class="send"/>
            <input type="reset" name="send" value="重写" class="reset"/>
            </form>
       	</div>
       
        <div class="cliPic">
            <a href="javascript:void(0)" onClick="getGuest()"><div class="Img"><img src="images/online_message.png" width="100%" height="100%"/></a></div>
            <a href="javascript:void(0)" onClick="sendPhone()"><div class="Img"><img src="images/online_tel.png" width="100%" height="100%"/></a></div>
            <a href="javascript:void(0)" onClick="sendWeixin()"><div class="Img"><img src="images/online_weixin.jpg" width="100%" height="100%"/></a></div>
        </div>
    </article>
     <!--底部版权-->
    <footer>
    	
    	<br/><img id="logoIMG2" width="80" height="40"/>
        <p class="p1">(C)Copyright 2016 All rights reserved：Hebei mountain co., LTD &nbsp; &nbsp;Zip code:071100【<a href="page/login.jsp" target="_blank">The background of landing</a>】 </p>
         <p class="p2">&nbsp;&nbsp;phone：13722237047 13303028262 &nbsp;&nbsp; E-mail：hbsyqzjx@foxmail.com</p>
        <p class="p3">Technical support：<a href="#" target="_blank">The studio of gCoder</a> </p>
    </footer>
    
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js_en/guest_en.js"></script>
</body>
</html>
