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
    	<li><a href="index.jsp">首页</a></li>
        <li><a href="page/about.jsp">公司简介</a></li>
        <li><a href="page/lou.jsp">产品展示</a></li>
        <li><a href="page/news.jsp">公司动态</a></li> 
        <li><a href="page/zzzs.jsp">资质证书</a></li>
        <li><a href="page/qzzs.jsp">起重知识</a></li>
        <li><a href="page/job.jsp">人才招聘</a></li>
        <li><a href="page/contact.jsp">联系我们</a></li>
        <li><a href="page/guest.jsp">留言反馈</a></li>
    </menu>
    
    <!--中间动态图片-->
    <embed src="images/banner.swf" class="embed"></embed>

    
   <!--中间内容区-->
    <article>
       <div class="contact">
        	<form onsubmit="return sendGuest()" id="guestId" method="post">
            <span>您的姓名：</span><input  type="text" name="gname" id="gName" size="12px" required="required" class="content"/><br/>
            <span>联系电话：</span><input type="tel" name="gtel" id="gTel" size="24px" class="content" required="required"/><br/>
            <span>电子邮件：</span><input type="email" name="gemail" id="gEmail" size="24px" class="content" required="required"/><br/>
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
        <p class="p1">(C)Copyright 2016 版权所有：河北山叶起重机械制造有限公司 &nbsp;地址:河北省保定市清苑区东吕工业园区 &nbsp;邮编:071100【<a href="page/login.jsp" target="_blank">企业邮箱登陆</a>】 </p>
         <p class="p2">&nbsp;&nbsp;电话：13722237047 13303028262 &nbsp;&nbsp; E-mail：hbsyqzjx@foxmail.com</p>
         <p class="p3">技术支持：<a href="#" target="_blank">gCoder工作室</a> </p>
    </footer>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/guest.js"></script>
    <script type="text/javascript" src="js/basic.js"></script>
</body>
</html>
