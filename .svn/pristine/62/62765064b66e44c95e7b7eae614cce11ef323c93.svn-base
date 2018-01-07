<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
%>

<html>
<head>
    <title>FlexPaper AdaptiveUI</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="IE=Edge" http-equiv="X-UA-Compatible"></meta>
    <meta name="viewport" content="initial-scale=1,user-scalable=no,maximum-scale=1,width=device-width" />
    <style type="text/css" media="screen">
        html, body	{ height:100%; }
        body { margin:0; padding:0; overflow:auto; }
        #flashContent { display:none; }
    </style>

    <link rel="stylesheet" type="text/css" href="css/flexpaper.css" />
    <script type="text/javascript" src="${basePath}js/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}js/jquery.extensions.min.js"></script>
    <!--[if gte IE 10 | !IE ]><!-->
    <script type="text/javascript" src="${basePath}js/three.min.js"></script>
    <!--<![endif]-->
    <script type="text/javascript" src="${basePath}js/flexpaper.js"></script>
    <script type="text/javascript" src="${basePath}js/flexpaper_handlers.js"></script>
</head>
<body>

<div id="documentViewer" class="flexpaper_viewer" style="position:absolute;left:20px;top:10px;width:1300px;height:800px"></div>

<script type="text/javascript">

    $('#documentViewer').FlexPaperViewer(
            { config : {

                SWFFile : '${basePath}upload/${swfsrc}',
     
                Scale : 0.6,
                ZoomTransition : 'easeOut',
                ZoomTime : 0.5,
                ZoomInterval : 0.1,
                FitPageOnLoad : true,
                FitWidthOnLoad : false,
                FullScreenAsMaxWindow : false,
                ProgressiveLoading : false,
                MinZoomSize : 0.2,
                MaxZoomSize : 5,
                SearchMatchAll : false,
                InitViewMode : '',
                RenderingOrder : 'flash,html',
                StartAtPage : '',

                EnableWebGL : true,
                ViewModeToolsVisible : true,
                ZoomToolsVisible : true,
                NavToolsVisible : true,
                CursorToolsVisible : true,
                SearchToolsVisible : true,
                WMode : 'transparent',
                localeChain: 'en_US'
            }}
    );
</script>

</div>

</body>
</html>