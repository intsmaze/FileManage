<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
<title>Home</title>
<link href="${basePath}css/adminstyle.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
</head>
<body>
<div class="login">
	<h2>管理员登陆</h2>
	<div class="login-top">
		<h1>LOGIN FORM</h1>
		
		<form  action="${basePath}admin/admin_loginAdmin.action"  method="post">
			<input type="text" name="admin.account" value="User Id" onfocus="this.value = '';" >
			<input type="password" name="admin.password" value="password" onfocus="this.value = '';" >
	    	  <div class="forgot">
	    	<a href="#">forgot Password</a>
	    	<input type="submit" value="Login" >
	   		 </div>
	    </form>
	    
	
	</div>
	
	<div class="login-bottom">
	</div>
</div>	

</body>
</html>