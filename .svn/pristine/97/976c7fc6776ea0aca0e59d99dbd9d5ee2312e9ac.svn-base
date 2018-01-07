<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<html class="w3c">
<head>
<meta charset="utf-8">
<style>html,body{height:100%}html,body,form,input,span,p,img,ul,ol,li,dl,dt,dd{margin:0;padding:0;border:0}ul,ol{list-style:none}
body{background:#fff;font:12px/1.5 arial,sans-serif;text-align:center}a{text-decoration:none}a:hover{text-decoration:underline}
.page-wrap{position:relative;min-height:100%;_height:100%}
#input-container{width:500px;height:34px;display:inline-block;border:2px solid #3eaf0e;box-shadow:0 2px 1px #f0f0f0;position:relative;z-index:1}#suggest-align{height:32px;position:relative}
#input{width:485px;height:22px;margin:5px 0 5px 8px;outline:0;background:#fff;font-size:16px;line-height:22px;vertical-align:top}
#search-button{width:100px;height:38px;_height:40px;display:inline-block;margin-left:5px;outline:0;border:1px solid #3eaf0e;*border:0;box-shadow:0 1px 1px rgba(0,0,0,0.2);-webkit-box-shadow:0 1px 1px rgba(0,0,0,0.2);-moz-box-shadow:0 1px 1px rgba(0,0,0,0.2);background:url(http://p1.qhimg.com/d/_onebox/btn-98-114.png) no-repeat #3eaf0e;color:#fff;font:bold 16px arial,sans-serif;vertical-align:top;cursor:pointer}#search-button.hover{border:1px solid #4bbe11;*border:0;background-position:0 -38px}#search-button.mousedown{border:1px solid #4bbe11;*border:0;background-position:0 -76px}#slogan{padding-top:80px}#slogan a{color:#3eaf0e;text-decoration:none}#slogan a:hover{color:#ef730f}#footer{width:100%;height:36px;line-height:36px;text-align:left;color:#959595;position:absolute;left:0;bottom:0}#footer p{margin:0 20px}#footer a{color:#959595;margin:0 5px 0 3px}#footer span{float:right;font-style:normal;color:#959595}.ac_wrap{position:absolute;z-index:100;overflow-y:hidden;font-size:14px;background:#fff;text-align:left;line-height:20px}.ac_wrap_inner{z-index:10;border:1px solid #999}.ac_wrap ul{background:#fff url(http://p1.qhimg.com/d/_hao360/sou360/bg_sug.jpg) no-repeat bottom right}.ac_wrap li{padding-left:8px;line-height:26px;cursor:pointer}.ac_wrap li.hover{background:#e6e6e6}.ac_wrap li.selected{background:#eee}.ac_toolbar{font-size:12px;position:absolute;bottom:0;right:10px;height:24px;line-height:24px;text-align:right;color:#e5e5e5}.ac_toolbar a{margin-left:15px;color:#66F}.ac_bgIframe{position:absolute;top:0;left:0;z-index:-1;width:expression(this.parentNode.offsetWidth);height:2000px}#so-nav-tabs{font-size:14px;text-align:left;padding-left:150px;position:relative;z-index:999}#so-nav-tabs a,#so-nav-tabs strong{height:31px;line-height:31px;display:inline-block;margin-right:18px;*margin-right:15px;color:#333}#so-nav-tabs a:hover{color:#3eaf0e;text-decoration:none}#so-nav-tabs strong{color:#3eaf0e}#so-nav-more{width:50px;position:absolute;z-index:0;top:30px;right:195px;margin-left:370px;*margin-left:-70px;padding:0;line-height:30px;text-align:left;border:1px #dedede solid;background:#fff;list-style:none;display:none}#so-nav-more a{width:100%;display:block;margin:0;text-indent:10px}#so-nav-more a:hover{background:#f1f1f1}#so-nav-tabs-more{width:45px;background:url(http://p0.qhimg.com/d/inn/56e29abd/arr.gif) 32px 15px no-repeat}.desktop{width:148px;height:30px;display:block;background:url(http://p1.qhimg.com/t01e739d9d685bc2d8f.png) no-repeat -5px -6px;margin:0 auto}.desktop:hover{background-position:-5px -60px}.tools{width:560px;margin:100px auto 0 165px;display:none}.tools dt{height:30px;border-top:1px solid #ededed;position:relative;z-index:0}.tools dt div{width:80px;color:#666;background:#fff url(http://p0.qhimg.com/d/inn/888902b7/arr.png) no-repeat 75px -19px;position:relative;margin:-10px auto 0;padding-right:10px;cursor:pointer}.tools dt div.close{background-position:75px 8px}.tools dd{width:100%;height:90px;overflow:hidden}.tools dd a{width:70px;height:70px;color:#8c8c8c;text-decoration:none;border-radius:5px;display:block;padding:18px 0 0;float:left;outline:0}.tools dd a:hover{color:#4eb51b;background:#f9f9f9;text-decoration:none}.tools dd span{width:30px;height:30px;display:inline-block;background:url(http://p0.qhimg.com/d/inn/af75f7f9/icons.png);margin:0 auto 5px}.tools-tq span{background-position:0 0}a.tools-fy span{background-position:0 -32px}a.tools-rl span{background-position:0 -64px}a.tools-jsq span{background-position:0 -256px}a.tools-kd span{background-position:0 -128px}a.tools-kb span{background-position:0 -160px}a.tools-hcp span{background-position:0 -192px}a.tools-mnxc span{background-position:0 -224px}a:hover.tools-tq span{background-position:-32px 0}a:hover.tools-fy span{background-position:-32px -32px}a:hover.tools-rl span{background-position:-32px -64px}a:hover.tools-jsq span{background-position:-32px -256px}a:hover.tools-kd span{background-position:-32px -128px}a:hover.tools-kb span{background-position:-32px -160px}a:hover.tools-hcp span{background-position:-32px -192px}a:hover.tools-mnxc span{background-position:-32px -224px}
#upload-button{width:100px;height:38px;_height:40px;display:inline-block;margin-left:5px;outline:0;border:1px solid #3eaf0e;*border:0;box-shadow:0 1px 1px rgba(0,0,0,0.2);-webkit-box-shadow:0 1px 1px rgba(0,0,0,0.2);-moz-box-shadow:0 1px 1px rgba(0,0,0,0.2);background:url(http://p1.qhimg.com/d/_onebox/btn-98-114.png) no-repeat #3eaf0e;color:#fff;font:bold 16px arial,sans-serif;vertical-align:top;cursor:pointer}#search-button.hover{border:1px solid #4bbe11;*border:0;background-position:0 -38px}#search-button.mousedown{border:1px solid #4bbe11;*border:0;background-position:0 -76px}#slogan{padding-top:80px}#slogan a{color:#3eaf0e;text-decoration:none}#slogan a:hover{color:#ef730f}#footer{width:100%;height:36px;line-height:36px;text-align:left;color:#959595;position:absolute;left:0;bottom:0}#footer p{margin:0 20px}#footer a{color:#959595;margin:0 5px 0 3px}#footer span{float:right;font-style:normal;color:#959595}.ac_wrap{position:absolute;z-index:100;overflow-y:hidden;font-size:14px;background:#fff;text-align:left;line-height:20px}.ac_wrap_inner{z-index:10;border:1px solid #999}.ac_wrap ul{background:#fff url(http://p1.qhimg.com/d/_hao360/sou360/bg_sug.jpg) no-repeat bottom right}.ac_wrap li{padding-left:8px;line-height:26px;cursor:pointer}.ac_wrap li.hover{background:#e6e6e6}.ac_wrap li.selected{background:#eee}.ac_toolbar{font-size:12px;position:absolute;bottom:0;right:10px;height:24px;line-height:24px;text-align:right;color:#e5e5e5}.ac_toolbar a{margin-left:15px;color:#66F}.ac_bgIframe{position:absolute;top:0;left:0;z-index:-1;width:expression(this.parentNode.offsetWidth);height:2000px}#so-nav-tabs{font-size:14px;text-align:left;padding-left:150px;position:relative;z-index:999}#so-nav-tabs a,#so-nav-tabs strong{height:31px;line-height:31px;display:inline-block;margin-right:18px;*margin-right:15px;color:#333}#so-nav-tabs a:hover{color:#3eaf0e;text-decoration:none}#so-nav-tabs strong{color:#3eaf0e}#so-nav-more{width:50px;position:absolute;z-index:0;top:30px;right:195px;margin-left:370px;*margin-left:-70px;padding:0;line-height:30px;text-align:left;border:1px #dedede solid;background:#fff;list-style:none;display:none}#so-nav-more a{width:100%;display:block;margin:0;text-indent:10px}#so-nav-more a:hover{background:#f1f1f1}#so-nav-tabs-more{width:45px;background:url(http://p0.qhimg.com/d/inn/56e29abd/arr.gif) 32px 15px no-repeat}.desktop{width:148px;height:30px;display:block;background:url(http://p1.qhimg.com/t01e739d9d685bc2d8f.png) no-repeat -5px -6px;margin:0 auto}.desktop:hover{background-position:-5px -60px}.tools{width:560px;margin:100px auto 0 165px;display:none}.tools dt{height:30px;border-top:1px solid #ededed;position:relative;z-index:0}.tools dt div{width:80px;color:#666;background:#fff url(http://p0.qhimg.com/d/inn/888902b7/arr.png) no-repeat 75px -19px;position:relative;margin:-10px auto 0;padding-right:10px;cursor:pointer}.tools dt div.close{background-position:75px 8px}.tools dd{width:100%;height:90px;overflow:hidden}.tools dd a{width:70px;height:70px;color:#8c8c8c;text-decoration:none;border-radius:5px;display:block;padding:18px 0 0;float:left;outline:0}.tools dd a:hover{color:#4eb51b;background:#f9f9f9;text-decoration:none}.tools dd span{width:30px;height:30px;display:inline-block;background:url(http://p0.qhimg.com/d/inn/af75f7f9/icons.png);margin:0 auto 5px}.tools-tq span{background-position:0 0}a.tools-fy span{background-position:0 -32px}a.tools-rl span{background-position:0 -64px}a.tools-jsq span{background-position:0 -256px}a.tools-kd span{background-position:0 -128px}a.tools-kb span{background-position:0 -160px}a.tools-hcp span{background-position:0 -192px}a.tools-mnxc span{background-position:0 -224px}a:hover.tools-tq span{background-position:-32px 0}a:hover.tools-fy span{background-position:-32px -32px}a:hover.tools-rl span{background-position:-32px -64px}a:hover.tools-jsq span{background-position:-32px -256px}a:hover.tools-kd span{background-position:-32px -128px}a:hover.tools-kb span{background-position:-32px -160px}a:hover.tools-hcp span{background-position:-32px -192px}a:hover.tools-mnxc span{background-position:-32px -224px}

</style>

<script type="text/javascript">

function upload(){
	document.forms[0].action = "${basePath}file/file_uploadUI.action";
	document.forms[0].submit();
}
</script>
</head>
<body>
<div class="page-wrap">
	
	<div id="main" style="margin-top:80px;">
        <p id="logo" style="height:auto;margin-bottom:0;" >
                 intsmaze极致搜索               
        </p>
        <br/>
	  
		<p id="logo-xp"><a href="javascript:void(0)" ></a></p>
		<div id="search-box" style="padding-top: 10px;">
		
			<form name="form1" action="${basePath}file/file_fileLook.action" target="mainFrame" method="post">
				<span id="input-container">
					<div id="suggest-align">
						<input type="text" name="selectname" id="input"  suggestWidth="501px" autocomplete="off" x-webkit-speech><cite id="suggest-tp"></cite>
					</div>
				</span>
				<input type="submit" id="search-button" value="搜索一下">
				<input type="submit" id="upload-button" value="上传文件" onclick="javascript:upload();">
			</form>	
		</div>
  </div>
</div>

</body>
</html>
