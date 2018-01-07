<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    pageContext.setAttribute("basePath",request.getContextPath()+"/");
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript" src="${basePath}js/jquery.js"></script>
		<script type="text/javascript" src="${basePath}js/flexpaper_flash.js"></script>
		<script type="text/javascript" src="${basePath}js/flexpaper_flash_debug.js"></script>
		<style type="text/css" media="screen">
html,body {
	height: 100%;
}

body {
	margin: 0;
	padding: 0;
	overflow: auto;
}

#flashContent {
	display: none;
}
</style>
		<title>文档在线预览系统</title>
	</head>
	<body>
	${basePath}${param.swfsrc}
	<a href="http://localhost:8080${basePath}upload/${param.swfsrc}">aaaaa</a>
	
		<div style="position: absolute; left: 50px; top: 10px;">
			<a id="viewerPlaceHolder" style="width: 820px; height: 650px; display: block"></a>
			
			<script type="text/javascript"> 
				var fp = new FlexPaperViewer(	
						 'FlexPaperViewer',
						 'viewerPlaceHolder', { config : {
						 SwfFile : escape('http://localhost:8080${basePath}upload/${param.swfsrc}'),//编码设置
						 Scale : 0.6, 
						 ZoomTransition : 'easeOut',//变焦过渡
						 ZoomTime : 0.5,
						 ZoomInterval : 0.2,//缩放滑块-移动的缩放基础[工具栏]
						 FitPageOnLoad : true,//自适应页面
						 FitWidthOnLoad : true,//自适应宽度
						 FullScreenAsMaxWindow : false,//全屏按钮-新页面全屏[工具栏]
						 ProgressiveLoading : false,//分割加载
						 MinZoomSize : 0.2,//最小缩放
						 MaxZoomSize : 3,//最大缩放
						 SearchMatchAll : true,
						 InitViewMode : 'Portrait',//初始显示模式(SinglePage,TwoPage,Portrait)
						 
						 ViewModeToolsVisible : true,//显示模式工具栏是否显示
						 ZoomToolsVisible : true,//缩放工具栏是否显示
						 NavToolsVisible : true,//跳页工具栏
						 CursorToolsVisible : false,
						 SearchToolsVisible : true,
  							PrintPaperAsBitmap:false,
  						 localeChain: 'en_US'
						 }});
	        </script>  
		</div>
	</body>
</html>
