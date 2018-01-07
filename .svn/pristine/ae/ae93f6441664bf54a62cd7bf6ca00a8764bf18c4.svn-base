<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	application.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<style>
.porleft p {
 height: 35px;
}
.fb{ font-weight:bold;}
.link-login{font-family: '宋体';}
.porleft{height:800px;}
#nextwrap{position:relative;}
#validatecode{width:75px;}
#pre{font-size:12px;line-height:34px;cursor:pointer;}
.btnGray input.disable{color:#a0a0a0;cursor:default;}
</style>
<link rel="stylesheet" href="${basePath }js/login_6_v20150304144336.css" type="text/css">
<script src="${basePath }js/jquery-1.4.4.min.js" type="text/javascript"></script>
<script src="${basePath }js/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>

<script type="text/javascript">

</script>		

</head>
<body>
<div class="cb win1000">
		<form id="signupForm" method="post" target="mainFrame"
		action="${basePath}user/user_editUser.action" enctype="multipart/form-data">
		<div class="porleft">
			 <div class="regMenu">
               <span id="regTab" class="active"><a>个人信息</a></span>
            </div>
            <s:hidden name="user.userid"/>
            
            <div class="regWrap">
                <div id="regCon" style="">
                  <p>
                    <span class="regtlx">账号:</span>
                    <s:property value="user.account"/>
                     <s:hidden name="user.account"/>
                  </p>
                  <p>
                    <span class="regtlx">电子邮箱:</span>
                    <s:property value="user.email"/>
                     <s:hidden name="user.email"/>
                  </p>
            </div>     
                
            <div id="regCon" style="">
                 <p>
                   <span class="regtlx">昵称</span>
      			   <s:textfield id="name" name="user.name"/><s:fielderror fieldName="user.name"/>
				   <span id="nickName_Tip"></span> 
                 </p>
                 <p>
                     <span class="regtlx">头像</span>
                     <s:if test="%{user.image != null && user.image != ''}">
	                 		<img src="${basePath}upload/<s:property value='user.image'/>" width="100" height="70"/>
	               			  <!-- 作用很重要，因为没有设置的话，进入编辑页面，不更改图片，那么点击保存，action的File headImg收到的数据流是空的，而action
	                			接收的user.headImg是空的，所以会导致更新用户时，用户表的图片字段变为空了。
	                			这里设置有值得情况下隐藏字段为user.headImg就是当不更改图像设置时，能把用户原有图像路径传给 user.headImg-->
	                		 <s:hidden name="user.image"/>
                 	 </s:if> 
            		 <input type="file" name="headImg" width="100"/> 
                    </p>
                </div>  
                <br><br>  
                <div id="passwordCon">
               		<p>
                		<span class="regtlx">生日:</span>
                		<s:textfield id="birthday" name="user.birthday" readonly="true" 
            				onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" >
            				<s:param name="value"><s:date name="user.birthday" format="yyyy-MM-dd"/></s:param>
           				 </s:textfield>   
                	</p>
                	<p id="cpp">
                	 	<span class="regtlx">恶意行为:</span>
                	 	<s:property value="user.badBehavior"/>
                	 	 <s:hidden name="user.badBehavior"/>
                	</p>
				</div>    
                <p class="submitwrap">
                    <span class="regtlx">&nbsp;</span>
                    <label id="butt" class="butt">
                    <input class="btns" type="submit" value="完成修改" />           
                    </label>
                    <span id="gologin"><span id="loginOpt"><a href="#">修改密码</a></span></span>
                </p>
				</div>
            </div>
		</form>
	</div>
</body>
</html>