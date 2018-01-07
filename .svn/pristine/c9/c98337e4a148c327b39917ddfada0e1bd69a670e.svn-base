<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="${basePath}css/nsfw/css.css" rel="stylesheet" type="text/css" />
<link href="${basePath}css/nsfw/style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>


<frameset cols="*,1222,*" class="bj" frameborder="no" border="0" framespacing="0">
    <frame src="${basePath}common/bg.jsp" scrolling="No" noresize="noresize"/>
   
    <frameset rows="156,*" cols="*" frameborder="no" border="0" framespacing="0">
       
        <frame src="${basePath}/adminhome/home_top.action" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" />
      
        <frameset cols="14%,60%" frameborder="no" border="0" framespacing="0">
        
            <frame src="${basePath}/adminhome/home_left.action" scrolling="yes" noresize="noresize" id="leftFrame" />
            
            <frame src="${basePath}report/report_findAll.action" name="mainFrame" id="mainFrame" />
            
        </frameset>
    </frameset>
    
    <frame src="${basePath}common/bg.jsp" scrolling="No" noresize="noresize"/>
    
</frameset>


</html>