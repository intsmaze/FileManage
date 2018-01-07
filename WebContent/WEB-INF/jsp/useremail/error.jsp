<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html class="htmlnocolor" lang="zh">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>账号激活</title>
    <link href="${basePath }css/activateAccount/common.css" rel="stylesheet">
    <link href="${basePath }css/activateAccount/main.css" rel="stylesheet">
 
</head>
<body class="bodybgcolor">

<style type="text/css">
    html , body{font-family: Arial, "宋体";}
</style>

<div class="main">
  <div class="contant">
   	<div class="conBg">
        <div class="yan_zheng resetpassword">
		    <h3 class="loginTit4"><s:property value="tip"/></h3>
        	<p class="loginDes5"></p>	
        	<a href="http://mail.qq.com/" class="btn btn-normal217 btn-success marginT20">进入首页</a>	
			<dl class="yanz_dl">
			    <dt>没有收到重置密码邮件？你可以：</dt>
				<dd>1.到邮箱中的垃圾邮件、广告邮件目录中找找</dd>
				<dd>2.再次尝试重设密码</dd>
				<dd>3.与我们的客服联系，电话：400-885-9898</dd>
			</dl>
		</div>
	</div>   
  </div>
</div>
</body>
</html>