<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="c_pate" style="margin-top: 5px;">
        <s:if test="pageResult.totalCount > 0">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="left">
                 	总共 <s:property value="pageResult.totalCount"/> 条记录，
                 	当前第 <s:property value="pageResult.pageNo"/> 页，
                 	共 <s:property value="pageResult.totalPageCount"/> 页 
                 	<s:if test="pageResult.pageNo > 1">
                 	        &nbsp;&nbsp;<a href="javascript:doGoPage(<s:property value='pageResult.pageNo-1'/>)">上一页</a>
              	    </s:if>
              	    <s:if test="pageResult.pageNo < pageResult.totalPageCount">
                            &nbsp;&nbsp;<a href="javascript:doGoPage(<s:property value='pageResult.pageNo+1'/>)">下一页</a>
                    </s:if>        
					到&nbsp;<input id="pageNo" name="pageNo" type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value="<s:property value='pageResult.pageNo'/>" /> &nbsp;&nbsp;
			    </td>
			</tr>
		</table>
		</s:if><s:else>暂无数据！</s:else>	
        </div>
		<script type="text/javascript">
		//翻页
		function doGoPage(pageNo){
			document.getElementById("pageNo").value = pageNo;
			document.forms[0].action=list_url;
			document.forms[0].submit();
		}
		</script>