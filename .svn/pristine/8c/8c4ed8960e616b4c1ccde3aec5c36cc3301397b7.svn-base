<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件共享</title>
<meta name="keywords" content="文件共享">
<meta name="description" content="文件共享">
<link href="${basePath}css/sign.css" rel="stylesheet" type="text/css">
<link href="${basePath}css/jquery.css" rel="stylesheet" type="text/css">
<script src="${basePath }js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="${basePath }js/jquery.validate.min.js" type="text/javascript"></script>
<Script language="javascript">
$().ready(
		function() {
		
			$.validator.setDefaults({
				submitHandler : function(form) {
					form.submit();
				}
			}),

			$("#signupForm").validate({
				rules : {
					account : {
						required : true,
						minlength : 5
					},
					password : {
						required : true,
						minlength : 5
					},
				},
				messages : {
					account : {
						required : "请输入姓名",
						minlength : "账号不能小于{0}个字 符"
					},
					password : {
						required : "请输入密码",
						minlength : "密码不能小于{0}个字 符"
					}
				}
			});
		}
);
	
</Script>

</head>

<body>
<div class="sign" id="warp_login">
  <div class="loginWrap"> 
  <a target="_blank" href="http://www.51cto.com/" class="logo"></a>
    <div class="loginPic">
      <div class="loginImg">
	  		<a href="${basePath}home/home_home.action" target="_top">
			<img src="${basePath}images/wKiom1Ym8ljyFtkNAAF3cfwNE8Q269.jpg" alt="" border="0" height="360" width="570"></a>	  	  
	  </div>
      <div class="loginBord">
        <div class="loginTit">
          <div class="tosignup"> 还没有账号？ 
          <a href="${basePath}user/user_registerUI.action" target="mainFrame">15秒注册</a> </div>
          <h1>登录文件共享</h1>
        </div>
        
       <s:property value="tipAccount"/>   
       
       <form action="${basePath}user/user_loginUser.action" target="_top" method="post" id="signupForm" name="Form1">
           
      	<p>
			<s:textfield  name="account" id="account" placeholder="用户名/邮箱/手机"  class="{required:true,minlength:5}/"/>
        </p>
        <p>
          
			<s:password  name="password" id="password"  placeholder="密码"   class="{required:true,minlength:5}/"/>
            </p>

		  
          <p> 
          <a class="fr" href="${basePath}user/user_findUI.action" target="mainFrame">忘记密码?</a>  
            <label for="agree_userterm">
              <input name="autologin" type="checkbox">&nbsp;10天内自动登录 </label>
          </p>
          
          <input value="登 录" class="loginbtn" type="submit">
          
        </form>
        
        
        <div class="otherAccout">
          <p>你也可以使用以下账号登录</p>
		  <a href="http://ucenter.51cto.com/api/auth.php?type=sina"> <i class="iweibo"></i>新浪微博</a>
		  <a href="http://ucenter.51cto.com/api/auth.php?type=renren"> <i class="irenren"></i>人人网</a>
		  <a href="http://ucenter.51cto.com/api/auth.php?type=douban"> <i class="douban"></i>豆瓣网</a>	  
		</div>
        <div class="shadow_l"></div>
        <div class="shadow_r"></div>
      </div>
    </div>
  </div>
</div>

<div class="foot">
<a href="http://www.51cto.com/about/aboutus.html" target="_blank">关于我们</a>
|
<a href="http://www.51cto.com/about/zhaopin.html" target="_blank">诚聘英才</a>
|
<a href="http://www.51cto.com/about/contactus.html" target="_blank">联系我们</a>
|
<a href="http://www.51cto.com/about/history.html" target="_blank">网站大事</a>
|
<a href="http://www.51cto.com/php/guestbook/" target="_blank">意见反馈</a>
|
<a href="http://www.51cto.com/about/map.htm" target="_blank">网站地图</a>
<br>Copyright © 2005-2014 <a href="http://www.51cto.com/" target="_blank">51CTO.COM</a> 版权所有
</div>

</body></html>