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
<link rel="stylesheet" type="text/css" href="css/about.css">
<link rel="stylesheet" type="text/css" href="css/basic.css">
</head>

<body>
	<!--顶部的flash-->
	<header>
    	<div>
    		<div id="logo"><img id="logoIMG" width="136" alt="公司logo" height="50"/></div>
        	<div id="syqz">
        		<img src="images/theme.jpg">
        	</div>
        	<div id="zyw">
            	<a href="page/about.jsp"><img src="images/zh.jpg"/><span class="zh">中文版</span></a>
                &nbsp;
            	<a href="page_en/about_en.jsp"><img src="images/en.jpg"/><span class="zh">English</span></a>
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
    	<div class="left">
        	<div class="left_top"><img width="100%" height="100%" src="images/about1.png"/></div>
            
            
        	<div class="left_map" id="dituContent"></div>
            <div class="left_button"><input type="button" value="定位到河北山叶起重机械有限公司" style="color:#093" onclick="theLocation()" /></div>
            
        </div>
        <div class="right">
        	<div class="Img">
            	<img width="100%" height="100%" src="images/about2.jpg"/>  
            </div>
    		 <div class="right_bottom">
       	 		<div class="Text">
        			&nbsp;&nbsp;&nbsp;&nbsp;<span style="font-size:16px; font-weight:bold;">河北山叶起重机械制造限公司</span>
        			<p id="textP"></p>
        		</div> 
            </div>	
        </div>
    </article>
    
    <!--底部版权-->
    <footer>
    	
    	<br/><img id="logoIMG2" width="80" height="40"/>
        <p class="p1">(C)Copyright 2016 版权所有：河北山叶起重机械制造有限公司 &nbsp;地址:河北省保定市清苑区东吕工业园区 &nbsp;邮编:071100【<a href="page/login.jsp" target="_blank">企业邮箱登陆</a>】 </p>
         <p class="p2">&nbsp;&nbsp;电话：13722237047 13303028262 &nbsp;&nbsp; E-mail：hbsyqzjx@foxmail.com</p>
         <p class="p3">技术支持：<a href="#" target="_blank">gCoder工作室</a> </p>
    </footer>
    <script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="js/about.js"></script>
</body>
</html>