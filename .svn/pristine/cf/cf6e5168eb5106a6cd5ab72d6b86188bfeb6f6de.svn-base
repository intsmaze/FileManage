<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=7">



<link href="${basePath}css/Down_Head.css" rel="stylesheet" type="text/css">
<link href="${basePath}css/master_zyn.css" rel="stylesheet" type="text/css">

<body>


<div id="container">
<div id="left">
<div class="mod">
<div class="title">
<h2>举报文件名</h2>
</div>

<form method="post" action="${basePath}report/report_saveReport.action" name="cform">
	<table class="valuation" border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
		<tr>
		<s:property value='fileid'/>
		<input name="fileid" value="<s:property value='fileid'/>" type="hidden"/>
			<th align="right" valign="top">举报原因</th>
			<td align="left" height="130" valign="middle">
				<textarea style="background-color: #ffffff; font-size: 14px;width:500px;" name="reason" id="comment_content"  class="text_6" rows="8" cols="50"></textarea></td>
		</tr>
		<tr>
			<td align="right" valign="middle">&nbsp;</td>
			<td height="50">
				<input name="step" value="2" type="hidden">
				<input src="${basePath}images/down1.gif" type="image"></td>
		</tr>
	</tbody></table>
  </form>


<style>
.valuation {
    margin-top: 20px;
}
.valuation th {
    color: #323232;
}
.faq {
    background-color: #FFFFCB;
    border: 1px solid #CCCC00;
    color: #363520;
    line-height: 24px;
    margin: 10px auto;
    padding: 10px 0;
    width: 700px;
}
.faq h3 {
    font-size: 14px;
    font-weight: bold;
    text-align: center;
}
.faq p {
    margin: 0 auto;
    width: 680px;
}
.faq p span {
    color: #F5740C;
}
.faq p a {
    color: #0B70B5;
    text-align: center;
    text-decoration: underline;
}

</style>
</div>
<div id="pop3" style="display:none;height: 2000px;" class="blackMask"></div>
<div id="pop" style="display:none"></div>
</div>
<br class="dle">
<div style="display:none"><img src="${basePath}images/guanbi.gif">
<img src="${basePath}images/ico4_4.gif">
<img src="${basePath}images/bq_bg2.gif"></div>
</div>

<script language="javascript">
 function content_txt(){
   var txt = document.getElementById("comment_content");
   if(document.cform.comment_content.disabled==false&&document.cform.comment_content.value=="您对本资源的使用评价是其他Down友的宝贵参考（限500字内），请先选择评级后再进行评价"){
   txt.innerHTML=" ";
  }
 }
 function comment_txt(){
  var sel = document.getElementById("comment_assess");
  if(sel.checked=="true"){
   document.cform.comment_content.disabled=true;
  }else{
   document.cform.comment_content.disabled=false;
  }
 }
function check_form(thisform){
	var comment_assess_null = "请对资源进行评级";
	var comment_content_null = "请填写评论内容";
	var comment_content_big = "评论内容请勿超过500字"; 
	var comment_content_short = "评论内容请勿少于5个汉字";
	var checkit = false;
	for (var i=0;i<thisform.comment_assess.length;i++) {
		if (thisform.comment_assess[i].checked) {
			checkit=true;break
		}
	}
	if (checkit==false) {
		alert(comment_assess_null);
		return false
	}
	if ((trim(thisform.comment_content.value)=="") || (thisform.comment_content.value=="您对本资源的使用评价是其他Down友的宝贵参考（限500字内），请先选择评级后再进行评价"))
	{
		alert(comment_content_null);
		return false;
	}
	if (trim(thisform.comment_content.value).length<5)
	{
		alert(comment_content_short);
		return false;
	}
	if (false === checkIWK2(thisform.comment_content.value))
	{
		alert("评论内容存在非法关键词");
		return false;
	}
	
	if (thisform.comment_content.value.length>500)
	{
		alert(comment_content_big);
		return false;
	}
	if (!confirm("确认提交吗？提交后将不能修改")){
	return false;
	}
}
</script>


</body></html>