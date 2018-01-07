<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<HTML>
<HEAD>
<TITLE>首页</TITLE>
<LINK href="/css/Font.css" type="text/css" rel="stylesheet">
<STYLE>BODY {
	SCROLLBAR-ARROW-COLOR: #ffffff; SCROLLBAR-BASE-COLOR: #dee3f7
}
</STYLE>

<SCRIPT type="text/javascript">
function submitrequest(action){
eval("document.location='"+action+"'");
}
</SCRIPT>
</HEAD>

<FRAMESET border=0 frameSpacing=0 rows=41,* frameBorder=0 id="mainparent">
<!-- rows说明按行分，82，*说明分两行，第一行行高82，第二行占满浏览器 ， framespacing="0" 表示框架与框架间保留的空白的距离-->
	<FRAME name=topFrame id="topFrame" src="${basePath}/home/home_title.action" noResize scrolling=no>
	<!-- FRAME指明第一行引用哪个页面。这里使用sturts2进行转发页面。 -->
	<FRAME name="mainFrame" id="mainFrame"src="${basePath}/home/home_main.action" >
</FRAMESET>
</HTML>
