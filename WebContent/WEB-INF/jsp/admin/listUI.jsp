<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>投诉受理管理</title>

<script type="text/javascript">
	
	//受理
	function doDeal(fileId, userid) {
		document.forms[0].action = "${basePath}admin/admin_dealFile.action?userFileId="+ fileId + "&userId=" + userid;
		document.forms[0].submit();
	}
	
	//拒绝
	function refuse(fileId, userid) {
		document.forms[0].action = "${basePath}admin/admin_refuse.action?userFileId="+ fileId + "&userId=" + userid;
		document.forms[0].submit();
	}
</script>

</head>


<body class="rightBody">
	
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>投诉受理管理</strong>
						</div>
					</div>


					<div class="t_list" style="margin: 0px; border: 0px none;">
						<table width="100%" border="0">
							<tr class="t_tit">
								<td align="center">投诉原因</td>
								<td width="120" align="center">被投诉文件名</td>
								<td width="120" align="center">投诉人名称</td>
								<td width="140" align="center">投诉时间</td>
								<td width="100" align="center">查看文件信息</td>
								<td width="100" align="center">操作</td>
							</tr>

							<s:iterator value="pageResult.items">
								<tr>

									<td align="center"><s:property value="reason" /></td>
									<td align="center"><s:property value="userFile.title" /></td>
									<td align="center"><s:property value="user.account" /></td>

									<!-- <td align="center"><s:date name="compTime" format="yyyy-MM-dd HH:mm"/></td>  -->
									<td align="center">时间</td>
									<td align="center"><a
										href="${basePath}file/file_fileLookId.action?fileid=<s:property value='userFile.fileId'/>"
										target="_blank">查看</a></td>

									<td align="center"><a
										href="javascript:doDeal('<s:property value='userFile.fileId'/>','<s:property value='user.userid'/>')">受理</a>|
										<a href="javascript:refuse('<s:property value='userFile.fileId'/>','<s:property value='user.userid'/>')">拒绝</a>
									</td>

								</tr>
							</s:iterator>

						</table>
					</div>
				</div>

	<div id="page">
		<form name="f1" class="form" action="" method="post">
			<s:if test="pageResult.totalCount > 0">
				<span class="nums" style="margin-left: 12px">总共 <s:property
						value="pageResult.totalCount" /> 条记录， 当前第 <s:property
						value="pageResult.pageNo" /> 页， 共 <s:property
						value="pageResult.totalPageCount" /> 页 ， 
						<s:if test="pageResult.pageNo > 1">&nbsp;&nbsp;
						<a href="javascript:doGoPage(<s:property value='pageResult.pageNo-1'/>)">上一页</a>
					     </s:if> 
					     <s:if test="pageResult.pageNo < pageResult.totalPageCount">&nbsp;&nbsp;&nbsp;&nbsp;
					     <a href="javascript:doGoPage(<s:property value='pageResult.pageNo+1'/>)">下一页</a>
					     </s:if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
					     <input  id="pageNo" name="pageNo" type="hidden" value="<s:property value='pageResult.pageNo'/>" />
					      &nbsp;&nbsp;找到相关结果约${pageResult.totalCount}个
				</span>

			</s:if>
			<s:else>
				<span class="nums" style="margin-left: 12px">找到相关结果约${pageResult.totalCount}个</span>
			</s:else>
		</form>
	</div>

				<script type="text/javascript">
					//翻页
					function doGoPage(pageNo) {
						document.getElementById("pageNo").value = pageNo;
						document.forms[0].action = "${basePath}report/report_findAll.action";
						document.forms[0].submit();
					}
				</script>
				<!-- <jsp:include page="/common/pageNavigator.jsp"/> -->
			</div>
		</div>	
</body>
</html>