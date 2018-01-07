<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<html><head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=7">
<title>上传资料_51CTO下载中心</title>
<link href="${basePath}css/Down_Head.css" rel="stylesheet" type="text/css">

<link href="${basePath}css/master_w.css" rel="stylesheet" type="text/css">
<%@include file="/common/header.jsp"%>
<script type="text/javascript">

function register(){
	document.forms[0].action = "${basePath}file/file_uploadFile.action";
	document.forms[0].submit();
} 
 </script>
</head>

<body>
<div id="head">
<style type="text/css">
.clear{ padding:0; margin:0; font-size:0; line-height:0; height:0; clear:both;}
.hr12{height:12px;}
#head {
    font-family: 宋体;
    margin: 0 auto 8px;
    width: 960px;
}
#head .mininav {
    background: url(/images/mininav_bg.gif) repeat scroll 0 0 transparent;
    color: #BBBBBB;
    height: 19px;
    padding: 16px 10px 0 0;
    text-align: right;
}
#head .mininav a {
    color: #696969;
    padding: 2px 3px 0;
    text-decoration: none;
}
#head .mininav a:hover {
    color: #CC0000;
    text-decoration: underline;
}
#head .subNav {
    background: url(/images/subNav_bg.gif) no-repeat scroll right center transparent;
    height: 94px;
}
#head .subNav .logo {
    float: left;
    height: 58px;
    padding: 19px 0 0 15px;
    width: 150px;
}
#head .subNav .daohang {
    color: #3B6C00;
    float: right;
    height: 30px;
    padding: 26px 10px 0 0;
    width: 345px;
}
#head .subNav .daohang span {
    padding-right: 12px;
}
#head .subNav .daohang a {
    color: #3B6C00;
    padding: 0 5px;
    text-decoration: none;
}
#head .subNav .daohang a:hover {
    color: #CC0000;
    text-decoration: underline;
}
.head_soso{width:410px; height:70px; padding-top:25px; float:left; margin-left:60px;}
.head_soso_01{ float:left; background:url(/images/re_sosobg.jpg) no-repeat; width:350px; height:34px;}
.head_soso_01_text{ border:none; background:none;float:left;width:260px; height:34px;color:#000; line-height:34px; padding:0 5px;}
.head_soso_search{ border:none; background:none; cursor:pointer;float:left; background:url(/images/re_sosobtn.jpg) no-repeat; width:56px; height:34px; }
.select_box { float:left;width:70px; height:30px; margin-top:2px; position:relative; background:#fafafa;}
.submit_box {width:80px; position:relative; padding:0; font-size:12px; text-align:center;}
.soso_leftlist ul.ul02 li a:link,.soso_leftlist ul.ul02 li a:visited,.relate_date_tit a:link,.relate_date_tit a:visited,.head_soso_tag a:link,.head_soso_tag a:visited{color:#999;}
.soso_leftlist ul.ul02 li a:hover,.relate_date ul li p a:hover,.relate_date_tit a:hover,.head_soso_tag a:hover{ color:#cc0000;}
.soso_leftlist ul.ul02 li a:active,.relate_date_tit a:active,.head_soso_tag a:active{color:#999;}
.head_soso_tag{clear:left;}
.select_box input {cursor:pointer; display:block; line-height:28px; width:100%; height:28px; overflow:hidden;border:none;background:none; padding:0 2px 0 5px;  background: url(/images/select_bg.gif) no-repeat right top; color:#999;}
.select_box ul {width:80px; position:absolute; left:0; top:30px;background:#fff; overflow: hidden;display:none; background:#ebebeb; z-index:99999;}
.select_box ul li {display:block;height:30px;overflow:hidden;line-height:30px;padding-left:5px;width:100%;cursor:pointer;}
.bdSug_app{display:none;}
.head_soso_tag {
    color: #999999;
    line-height: 25px;
    text-align: left;
}
.data_name span.name a{display:inline-block;}
</style>



<div class="tag"><dl>


</dl></div>


</div>
<div id="shangchuan">
<div id="right">
<div class="nav">
<div class="title1"><img src="${basePath}images/w_icon_01.gif"> 上传资料</div>
<div style="font-size:12px; color:#444; float:right; padding:13px 10px 0 0;">请勿上传任何含有病毒、木马、政治敏感、色情以及侵犯他人版权的资料！</div>
</div>

<div class="ziyuan">

<form  name="form1"  action="" method="post" enctype="multipart/form-data">

  <table align="center" border="0" cellspacing="2" width="100%">
    <tbody>
	
	<s:fielderror fieldName="office"></s:fielderror>
	<tr>
      <td align="right" width="74">文件：</td>
      <td><s:file name="office" class="shurukuang_bian" size="50" id="upload" /></td>
    </tr>
    <tr>
      <td align="right" width="74">文件：</td>
      <td><s:file name="office" class="shurukuang_bian" size="50" id="upload" /></td>
    </tr>
    	
	<tr>
      <td align="right" width="74">资料标题：</td>
      <td><s:textfield name="userFile.title" class="shurukuang_bian" size="50" id="upload_title"/>
      <s:fielderror fieldName="userFile.title"></s:fielderror></td>    
    </tr>

    <tr>
      <td align="right">资料简介：</td>
      <td><s:textfield  size="100"  class="miaoshu" name="userFile.introduce" />
       <s:fielderror fieldName="userFile.introduce"></s:fielderror>
      </td>
      
    </tr>

  </tbody></table>


<div class="xian"> </div>
<div style="width:337px;" class="tijiao">
<table style="margin: 10px 0 0 90px;" border="0" cellpadding="0" cellspacing="0" width="550">
  <tbody><tr>
    <td width="75">
    <input src="${basePath}images/w_tijiao.gif" 
    alt="提交" onclick="javascript:register();" type="image">
    </td>
  </tr>
</tbody>
</table>
</div>

</form></div>


</div>
<br class="dle">
</div>
</body></html>