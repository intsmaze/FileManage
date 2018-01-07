<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉受理管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }nsfw/complain_deal.action" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong>&nbsp;-&nbsp;投诉受理</div></div>
    <div class="tableH2">投诉详细信息<span style="color:red;">(<s:property value="#complainStateMap[complain.state]"/>)</span></div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	<tr><td colspan="2" align="center">投诉人信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">是否匿名投诉：</td>
            <td><s:property value="complain.isNm?'匿名投诉':'非匿名投诉'"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人单位：</td>
            <td>
            <s:if test="!complain.isNm">
            	<s:property value="complain.compCompany"/>
            </s:if>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人姓名：</td>
            <td><s:if test="!complain.isNm"><s:property value="complain.compName"/></s:if></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人手机：</td>
            <td>
            <s:if test="!complain.isNm">
            <s:property value="complain.compMobile"/>
            </s:if><s:elseif test="%{complain.compMobile.length() > 10}">
            <s:property value="%{complain.compMobile.substring(0,3) + '****' + complain.compMobile.substring(7,11)}"/>
            </s:elseif>
            </td>
        </tr>
        <tr><td colspan="2" align="center">投诉信息</td></tr>
        <tr>
            <td class="tdBg">投诉时间：</td>
            <td>
            	<s:date name="complain.compTime" format="yyyy-MM-dd HH:mm"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">被投诉部门：</td>
            <td><s:property value="complain.toCompDept"/></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人：</td>
            <td><s:property value="complain.toCompName"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉标题：</td>
            <td><s:property value="complain.compTitle"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td><s:property value="complain.compContent" 
            escape="false"/></td>
        </tr>
        <tr><td colspan="2" align="center">受理信息</td></tr>
        <tr>
            <td colspan="2">
            	<s:iterator value="complain.complainReplies" status="st">
            		<fieldset style="border: solid 1px #c0c0c0;margin-top:5px;"><legend style="color:green;font-weight:bold;">回复<s:property value="#st.count"/>&nbsp;</legend>
						<div style="width:100%; text-align:center;color:#ccc;maring-top:5px;">
						回复部门：<s:property value="replyDept"/>&nbsp;&nbsp;
						回复人：<s:property value="replyer"/>&nbsp;&nbsp;
						回复时间：<s:date name="replyTime" format="yyyy-MM-dd HH:mm"/>
						</div>
						<div style="width:100%;maring-top:10px;font-size:13px;padding-left:5px;">
						<s:property value="replyContent"/>
						</div>
					</fieldset>
            	</s:iterator>
            </td>
        </tr>
        <tr><td colspan="2" align="center">受理操作</td></tr>
        <tr>
            <td class="tdBg">回复部门：</td>
            <td>
            <s:property value="#session.SYS_USER.dept"/>
            <s:hidden name="reply.replyDept" value="%{#session.SYS_USER.dept}"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">回复人：</td>
            <td>
            <s:property value="#session.SYS_USER.name"/>
            <s:hidden name="reply.replyer" value="%{#session.SYS_USER.name}"/>
            </td>
        </tr>

        <tr>
            <td class="tdBg" width="200px">回复内容：</td>
            <td><s:textarea name="reply.replyContent" cols="90" rows="8" /></td>
        </tr>
    </table>
    <s:hidden name="complain.compId"/>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>