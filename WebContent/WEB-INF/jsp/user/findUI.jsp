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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册会员-58同城</title>
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
<script src="${basePath }js/jquery.validate.min.js"
	type="text/javascript"></script>
		
<script type="text/javascript">
$().ready(
		function() {
			 $("#email").blur(
						function() {
							var x = document.getElementById("email").value
							$.post(
									"${basePath}user/user_checkEmail.action?email="
											+ x + "&time="
											+ new Date().getTime(), null,
									function(data, textStatus) {
									    if (data == 2) {
											$("#txtemail_Tip").empty();
											$("#txtemail_Tip").append("邮箱有效");
										} else if (data == 3){
											$("#txtemail_Tip").empty();
											$("#txtemail_Tip").append("邮箱无效，请确认");
										}
									});
						});/**,
			$.validator.setDefaults({
				submitHandler : function(form) {
					form.submit();
				}
			}),

			$("#signupForm").validate({
				rules : {
					email : {
						required : true,
						email : true
					},
					password : {
						required : true,
						minlength : 5
					},
					confirm_password : {
						required : true,
						minlength : 5,
						equalTo : "#password"
					}
				},
				messages : {
					email : {
						required : "请输入Email地址",
						email : "请输入正确的email地址"
					},
					password : {
						required : "请输入密码",
						minlength : "密码不能小于{0}个字 符"
					},
					confirm_password : {
						required : "请输入确认密码",
						minlength : "确认密码不能小于5个字符",
						equalTo : "两次输入密码不一致不一致"
					}
				}
			});*/
		});
</script>
</head>
<body>
	<div class="cb win1000">
		<s:form id="signupForm" name="signupForm" 
		 action="findUser.action" method="post" namespace="/user">
		<div class="porleft">
			       <div class="regMenu">
               <span id="regTab" class="active"><a>密码找回</a></span>
            </div>
            <div class="regWrap">
                <div id="regCon" style="">
                    <p>
                    	<span class="regtlx">电&nbsp;子&nbsp;邮&nbsp;箱</span>
                    	<s:textfield id="email" name="email" class="required email" />
				        <s:property value="tipEmail"/>
                        <span id="txtemail_Tip"></span> 
                        <s:fielderror fieldName="email"/>
                    </p>
                </div> 
                
                <div id="passwordCon">
                <p>
                	<span class="regtlx">密　　　码</span>
                     <s:password id="password"
				name="password" type="password" class="{required:true,minlength:5}" />
				<s:fielderror fieldName="password"/>
				<span id="password_Tip" style="z-index: 100;"></span> 
                </p>
                <p id="cpp">
                	<span class="regtlx">确&nbsp;认&nbsp;密&nbsp;码</span>
                	 <s:password
				id="confirm_password" name="confirm_password" type="password"
				class="{required:true,minlength:5,equalTo:'#password'}" />
                    <span id="cpassword_Tip"></span> 
                </p>
				</div>             
                <p class="submitwrap">
                    <span class="regtlx">&nbsp;</span>
                    <label id="butt" class="butt">
                    <input class="btns" type="submit" value="立即找回" />               
                    </label>
                </p>
				</div>
            </div>
	</s:form>
	</div>

</body></html>
