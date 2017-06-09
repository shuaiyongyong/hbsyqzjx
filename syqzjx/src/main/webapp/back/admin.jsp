<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="/syqzjx/">
<meta charset="UTF-8">
<title>河北山叶起重机械制造有限公司</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="css/admin.css">
</head>
<body class="easyui-layout" id="LayoutBody">   
    <div data-options="region:'north',title:'山叶起重后台管理系统',collapsible:false" id="north">
    
    	<div id="logoDiv"><img id="top_logo" width="136" height="50" style="margin-top:10px;" src="images/logo.gif"></div>
    	
    	<div id="top_span"><p>欢迎使用<span style="font-size:42px;font-style:italic;color:red;">山叶</span> 后台管理系统</p></div>
    	<div id="top_right">
    		<a href="./page/login.jsp">【注销登录】</a>
    		<img src="images/dh.jpg">
    	</div>
    </div>   
    <div data-options="region:'west',title:'菜单栏',split:true,collapsible:false" style="width:200px;" style="width:100px;">
    	<div id="LeftSider">
			
			<div title="公司信息管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>简介管理</span></li>
					<li><span>公司图标</span></li>
					<li><span>资格证书</span></li>
					<li><span>上传证书</span></li>
					<li><span>联系方式</span></li>
				</ul>
			</div>
			<div title="用户信息管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>编辑信息</span></li>
				</ul>
			</div>
			<div title="产品分类管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>添加分类</span></li>
					<li><span>编辑分类</span></li>
				</ul>
			</div>
			<div title="产品信息管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>添加产品</span></li>
					<li><span>编辑产品</span></li>
				</ul>
			</div>
			<div title="留言反馈管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>查看留言</span></li>
				</ul>
			</div>
			<div title="招聘信息管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>添加招聘信息</span></li>
					<li><span>编辑招聘信息</span></li>
				</ul>
			</div>
			<div title="起重知识管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>添加知识</span></li>
					<li><span>编辑知识</span></li>
				</ul>
			</div>
			<div title="公司动态管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>添加动态</span></li>
					<li><span>编辑动态</span></li>
				</ul>
			</div>
			<div title="短信通知管理" data-options="iconCls:'icon-man'">
				<ul class="menutree">
					<li><span>编辑短信环境</span></li>
				</ul>
			</div>
		</div>
    
    
    </div>   
    <div data-options="region:'center',title:'操作界面'">
        <div id="main">
			<div title="主界面">
				<h1>欢迎进入山叶后台管理系统</h1>
			</div>
		</div>
    </div> 
    
    <!-- 修改联系方式div -->
    <div id="modifyConnectDiv"></div>
    <!-- 修改招聘信息div -->
    <div id="editEmployDiv"></div>
    <!-- 修改产品类别div -->
    <div id="modifyType"></div>
    <!-- 修改产品信息div -->
    <div id="modifyProduct"></div>
    <!-- 产品信息详情div -->
    <div id="detailProduct"></div>
    <!-- 起重知识详情div -->
    <div id="detailKnow"></div>
    <!-- 修改起重信息div -->
     <div id="modifyKnow"></div>
     <!-- 公司动态详情div -->
     <div id="detailTrend"></div>
     <!-- 修改公司动态div -->
     <div id="modifyTrend"></div>
    	 <!-- 查看留言内容 -->
	<div id="detailGuest"></div>
		 <!-- 修改绑定手机-->
	<div id="modifyTel"></div>
	
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/admin.js"></script>
    
    
      
</body>  
</html>