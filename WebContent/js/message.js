/*短消息js*/
var lang = new Array();
var userAgent = navigator.userAgent.toLowerCase();
var is_opera = userAgent.indexOf('opera') != -1 && opera.version();
var is_moz = (navigator.product == 'Gecko') && userAgent.substr(userAgent.indexOf('firefox') + 8, 3);
var is_ie = (userAgent.indexOf('msie') != -1 && !is_opera) && userAgent.substr(userAgent.indexOf('msie') + 5, 3);

function $(id) {
	return document.getElementById(id);
}
function doane(event) {
	e = event ? event : window.event;
	if(is_ie) {
		e.returnValue = false;
		e.cancelBubble = true;
	} else if(e) {
		e.stopPropagation();
		e.preventDefault();
	}
}
var hiddenobj = new Array();
var pmwinposition = new Array();
function pmwin(action, param) {
	var objs = document.getElementsByTagName("OBJECT");
	if(action == 'open') {
		for(i = 0;i < objs.length; i ++) {
			if(objs[i].style.visibility != 'hidden') {
				objs[i].setAttribute("oldvisibility", objs[i].style.visibility);
				objs[i].style.visibility = 'hidden';
			}
		}
		var clientWidth = document.body.clientWidth;
		var clientHeight = document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight;
		var scrollTop = document.body.scrollTop ? document.body.scrollTop : document.documentElement.scrollTop;
		var pmwidth = 800;
		var pmheight = clientHeight * 0.9;
		if(!$('pmlayer')) {
			div = document.createElement('div');div.id = 'pmlayer';
			div.style.width = pmwidth + 'px';
			div.style.height = pmheight + 'px';
			div.style.left = ((clientWidth - pmwidth) / 2) + 'px';
			div.style.position = 'absolute';
			div.style.zIndex = '999';
			$('append_parent').appendChild(div);
			$('pmlayer').innerHTML = '<div style="width: 800px; background: #666666; margin: 5px auto; text-align: left">' +
				'<div style="width: 800px; height: ' + pmheight + 'px; padding: 1px; background: #FFFFFF; border: 1px solid #7597B8; position: relative; left: -6px; top: -3px">' +
				'<div onmouseover="pmwindrag(this)" style="cursor: move; position: relative; left: 0px; top: 0px; width: 800px; height: 30px; margin-bottom: -30px;"></div>' +
				'<a href="javascript:void(0)" onclick="pmwin(\'close\')" title="关闭" target="_self"><div style="cursor:pointer;position: absolute; right: 20px; top: 15px;border: 0px ">X</div></a>' +
				'<div id="pmwinmask" style="margin-top: 30px; position: absolute; width: 100%; height: 100%; display: none"></div><iframe id="pmframe" name="pmframe" style="width:' + pmwidth + 'px;height:100%" allowTransparency="true" frameborder="0"></iframe></div></div>';
		}
		$('pmlayer').style.display = '';
		$('pmlayer').style.top = ((clientHeight - pmheight) / 2 + scrollTop) + 'px';
		if(!param) {
			pmframe.location = 'http://down.51cto.com/pm.php';
		} else {
			pmframe.location = 'http://down.51cto.com/pm.php?msgto='+param;
		}
		dis_select=document.getElementsByTagName('select');
		for (i=0;i<dis_select.length ; i++)
		{
			dis_select[i].style.display="none";
		}
	} else if(action == 'close') {
		for(i = 0;i < objs.length; i ++) {
			if(objs[i].attributes['oldvisibility']) {
				objs[i].style.visibility = objs[i].attributes['oldvisibility'].nodeValue;
				objs[i].removeAttribute('oldvisibility');
			}
		}
		hiddenobj = new Array();
		$('pmlayer').style.display = 'none';
		dis_select=document.getElementsByTagName('select');
		for (i=0;i<dis_select.length ; i++)
		{
			dis_select[i].style.display="";
		}
	}
}

var pmwindragstart = new Array();
function pmwindrag(obj) {
	obj.onmousedown = function(e) {
		if(is_ie) {
			document.body.onselectstart = function() {
				return false;
			}
		}
		pmwindragstart = is_ie ? [event.clientX, event.clientY] : [e.clientX, e.clientY];
		pmwindragstart[2] = parseInt($('pmlayer').style.left);
		pmwindragstart[3] = parseInt($('pmlayer').style.top);
		$('pmwinmask').style.display = '';
		doane(e);
	}
	_attachEvent(document.body, 'mousemove', function(e) {
		if(pmwindragstart[0]) {
			var pmwindragnow = is_ie ? [event.clientX, event.clientY] : [e.clientX, e.clientY];
			with($('pmlayer')) {
				style.left = (pmwindragstart[2] + pmwindragnow[0] - pmwindragstart[0]) + 'px';
				style.top = (pmwindragstart[3] + pmwindragnow[1] - pmwindragstart[1]) + 'px';
			}
			doane(e);
		}
	});
	obj.onmouseup = function(e) {
		if(is_ie) {
			document.body.onselectstart = function() {
				return true;
			}
		}
		pmwindragstart = [];
		$('pmwinmask').style.display = 'none';
		doane(e);
	}
	obj.onmouseover = null;
}
function _attachEvent(obj, evt, func) {
	if(obj.addEventListener) {
		obj.addEventListener(evt, func, false);
	} else if(obj.attachEvent) {
		obj.attachEvent("on" + evt, func);
	}
}

function mb_strlen(str) {
	var len = 0;
	for(var i = 0; i < str.length; i++) {
		len += str.charCodeAt(i) < 0 || str.charCodeAt(i) > 255 ? (charset == 'utf-8' ? 3 : 2) : 1;
	}
	return len;
}
function strlen(str) {
	return (is_ie && str.indexOf('\n') != -1) ? str.replace(/\r?\n/g, '_').length : str.length;
}

function trim(str) {
	return (str + '').replace(/(\s+)$/g, '').replace(/^\s+/g, '');
}

/*资源页面对资源点评js*/
function InitAjax(){
	var ajax=false; 
	if(window.XMLHttpRequest){ 
			var ajax = new XMLHttpRequest();
		}
		else if(window.ActiveXObject){ 
			var ajax = new ActiveXObject("Microsoft.XMLHTTP");
		}
	return ajax;
}
/*下载处理*/

function download(tid,sub,webno) {
    sub = sub == undefined ? 0 : sub;
	webno = webno == undefined ? 1 : webno;
	//webno = tid >525993 ? 1 : webno;
	webno = (0 == webno) ? 1 : webno;
	url="http://down.51cto.com/download.php?t=" + Math.random();
	re="do=list&tid="+tid + '&issub=' + sub +'&webno=' + webno;
	ajax = new InitAjax();
	ajax.open("POST",url,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    ajax.setRequestHeader("If-Modified-Since","0");
	ajax.send(re);
	result=ajax.responseText;
	$('pop2').innerHTML = result;
	$('pop2').style.left = ((document.body.clientWidth - 565) / 2) + 'px';
	$('pop2').style.display="";
	$('pop3').style.display="";
		
	if(tid!=0 && sub!=0){
		if_down=1;
	}
}

/*举报处理*/
function dw_report(dw_uid,tid){
	if (!dw_uid)
	{
		alert('请先登录');
		return false;
	}
	if (tid)
	{
		url="http://down.51cto.com/download.php";
		re="do=list&tid="+tid;
		ajax = new InitAjax();
		ajax.open("POST",url,false);
		ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		ajax.send(re);
		result=ajax.responseText;
		$('pop').innerHTML = result;
		$('pop').style.display="";
		$('pop3').style.display="";
	}
}
function dw_loginform(str){
	if (str)
	{
		$('dw_loginform_title').innerHTML = str
	}else{
		$('dw_loginform_title').innerHTML = '下载登录'
	}
	$('dw_loginform').style.display='';
	var clientWidth = document.body.clientWidth;
	var clientHeight = document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight;
	var scrollTop = document.body.scrollTop ? document.body.scrollTop : document.documentElement.scrollTop;
	$('dw_loginform').style.left = ((clientWidth - 250) / 2) + 'px';
	$('dw_loginform').style.top = ((clientHeight - 150) / 2 + scrollTop) + 'px';
	$('login_username_id').focus();
	return false;
}

//编辑资源
function edit_resource(tid){
	url="http://down.51cto.com/download.php";
	re="do=editresource&tid="+tid;
	ajax = new InitAjax();
	ajax.open("POST",url,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;
	$('pop').innerHTML = result;
    $('pop').style.left = ((document.body.clientWidth - 565) / 2) + 'px';
	$('pop').style.display="";
	$('pop3').style.display="";
}

//计算字符串长度，汉字==2字符
function GetNaturalLength(value) {
	var _tmp = trim(value);
	var _length = 0;
	for (var i = 0; i < _tmp.length; i++) {
		if (_tmp.charCodeAt(i) > 255) {
			_length = _length + 2;
		}
		else {
			_length++;
		}
	}
	return _length;
}

function edit_resource_submit(){
	var upload_title_error = "标题长度限制：3-30汉字";
	var upload_content_error = "简介长度限制：10-500汉字";
	var upload_tag_error ="请填写标签";
	var edit_tid = $('edit_tid').value;
	var edit_title = $('edit_title').value;
	var edit_content = $('edit_content').value;
	var edit_tag = $('edit_tag').value;
	var edit_dou = $('edit_dou').value;
	if (GetNaturalLength(edit_title)<6 || GetNaturalLength(edit_title)>60 || trim(edit_title)=="")
	{	
		alert(upload_title_error);
		return false;
	}
	if (trim(edit_tag)=="")
	{
		alert(upload_tag_error);
		return false;
	}
	tag_array = edit_tag.split(/,|，/);
	if (tag_array.length >5)
	{
	alert('标签请勿超过5个');
	return false;
	}
	if (GetNaturalLength(edit_content)<20 || GetNaturalLength(edit_content)>1000||trim(edit_content)=="")
	{
		alert(upload_content_error);
		return false;
	}
	url="http://down.51cto.com/download.php";
	re="do=editresource&tid="+edit_tid+"&edit_tag="+encodeURIComponent(edit_tag)+"&edit_title="+encodeURIComponent(edit_title)+"&edit_content="+encodeURIComponent(edit_content)+"&edit_dou="+edit_dou+"&step=2";

	ajax = new InitAjax();
	ajax.open("POST",url,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;
	$('pop').innerHTML = result;
}
//资源介绍页
function getcomment(tid,assess,page,downloads,cid){
	url="http://down.51cto.com/download.php";
	re="do=getcomment&tid="+tid+"&assess="+assess+"&page="+page+"&downloads="+downloads+"&cid="+cid;
	ajax = new InitAjax();
	ajax.open("POST",url,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;
	$('resources_comment').innerHTML = result;
	$('resources_comment').focus();
	/*
	if (page == 1)
	{
		jQuery("#youzi").show();
		var youzihtml = jQuery("#youzihtml").val();
		jQuery("#youzi").html(youzihtml);
	}else{
		jQuery("#youzi").hide();
		var youzihtml = jQuery("#youzi").html();
		jQuery("#youzi").html("<input type='hidden' value='"+youzihtml+"' id='youzihtml'>");
	}
	*/
	if (page == 1)
	{
		jQuery("#youzi").show();
		//var youzihtml = jQuery("#youzihtml").val();
		//jQuery("#youzi").html(youzihtml);
	}else{
		jQuery("#youzi").hide();
		//var youzihtml = jQuery("#youzi").html();
		//jQuery("#youzi").html("<input type='hidden' value='"+youzihtml+"' id='youzihtml'>");
	}
	form_ajax();
}
function commentassess(tid,cid,assess,logurl)
{
	url="http://down.51cto.com/download.php";
	re="do=commentassess&cid="+cid+"&assess="+assess+"&tid="+tid;
	ajax = new InitAjax();
	ajax.open("POST",url,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;
	var regx = /支持|反对/g
	if (result.search(regx) != -1)
	{
		if (assess == 0)
		{
			if ($('support_'+cid))
			{
				$('support_'+cid).innerHTML = result;
			}
			if ($('good_support_'+cid))
			{
				$('good_support_'+cid).innerHTML = result;
			}
		}
		if (assess == 1)
		{
			if ($('oppose_'+cid))
			{
				$('oppose_'+cid).innerHTML = result;
			}
			if ($('good_oppose_'+cid))
			{
				$('good_oppose_'+cid).innerHTML = result;
			}
		}
		
	}else{
		if (result=="您已经退出，请重新登录!")
		{
			if(logurl)
			{
				document.location.href = logurl;
			}
			else
			{		
				//alert(result);
				dw_loginform('请先登陆');
			}	
		}else{
		alert(result);
		}
	}
}
function report_this(dw_uid,tid){
	if (!dw_uid)
	{
		//alert('请先登录');
		dw_loginform('请先登陆');
		return false;
	}
	url="http://down.51cto.com/download.php";
	re="do=reportsources&tid="+tid;
	ajax = new InitAjax();
	ajax.open("POST",url,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;
	$('pop').innerHTML = result;
	var clientWidth = document.body.clientWidth;
	var clientHeight = document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight;
	var scrollTop = document.body.scrollTop ? document.body.scrollTop : document.documentElement.scrollTop;
	$('pop').style.left = ((clientWidth - 565) / 2) + 'px';
	$('pop').style.top = ((clientHeight - 160) / 2 + scrollTop) + 'px';
	$('pop').style.display="";
	$('pop3').style.display="";
}

function report_resources(){
	if ($('report_type').value=="0")
	{
		alert("请选择举报类型!");
		return false;
	}
	if (trim($('report_details').value)=="")
	{
		alert("请填写举报详情！");
		return false;
	}
	var report_tid = $('report_tid').value;
	var report_type = $('report_type').value;
	var report_details =$('report_details').value;
	url="http://down.51cto.com/download.php";
	re="do=reportsources&report_tid="+report_tid+"&report_type="+report_type+"&report_details="+report_details;
	ajax = new InitAjax();
	ajax.open("POST",url,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;
	$('pop').innerHTML = result;
	var clientWidth = document.body.clientWidth;
	var clientHeight = document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight;
	var scrollTop = document.body.scrollTop ? document.body.scrollTop : document.documentElement.scrollTop;
	$('pop').style.left = ((clientWidth - 565) / 2) + 'px';
	$('pop').style.top = ((clientHeight - 160) / 2 + scrollTop) + 'px';
	$('pop').style.display="";
	$('pop3').style.display="";
}
/*下载用户*/
function down_record(tid){
	window.open('http://down.51cto.com/download.php?do=udownlist&tid='+tid,'','width=600,height=200,top=100,left=200,scrollbars=yes,resizable=no,location=no,status=yes');
}
function del_resources(id){
	if(id==0){
	return confirm("您确定要删除该资源吗？");
	}else{
		return confirm("您确定要删除该消息吗？");
	}
	
}

function showShareDesc() {
    var shareLi = $('shareLi');
	var msnQLi = $('msnQLi');
	var bbsLi = $('bbsLi');
	var urlTableDisplay = $('shareUrlTable').style;
	if(!shareLi.className)
	{
		$('shareDiv').className = "fenx1";
		urlTableDisplay.display = 'inline';
		msnQLi.className = '';
		bbsLi.className = "";
        shareLi.className = 'li1';
        $('shariImg').src = $('shariImg').src.replace('shari','shari_bg');

        $('showShareDescText1').style.display = 'inline';
        $('shareText1').style.display = 'none';

        $('showShareDescText2').style.display = 'inline';
        $('shareText2').style.display = 'none';

		$('shareTextTD1').width = 646;
		$('shareTextTD2').width = 40;
	}
	else
	{
		$('shareDiv').className = "fenx";
		urlTableDisplay.display = 'none';
		shareLi.className = '';
        $('shariImg').src = $('shariImg').src.replace('shari_bg','shari');
        $('showShareDescText1').style.display = 'none';
        $('showShareDescText2').style.display = 'none';
	}
}

//点击msn/q
function clickMsnq(uid, tid) {
    var url = share_url;
    var shareLi = $('shareLi');
	var msnQLi = $('msnQLi');
	var bbsLi = $('bbsLi');
	var urlTableDisplay = $('shareUrlTable').style;
	if(!msnQLi.className)
	{
        if (uid) {
            var sid = getShareId(tid);
            if (sid) {
                url += '&sid=' + sid;
            }
        }
		$('shareDiv').className = "fenx1";
		$('shareText').value = url;
		urlTableDisplay.display = 'inline';

        $('shariImg').src = $('shariImg').src.replace('shari_bg','shari');

        $('showShareDescText1').style.display = 'none';
        $('shareText1').style.display = 'inline';

        $('showShareDescText2').style.display = 'none';
        $('shareText2').style.display = 'inline';

        $('sharebbs').style.display = 'none';
        $('sharemsn').style.display = 'inline';
        
		msnQLi.className = 'li2';
		bbsLi.className = "";
        shareLi.className = '';
		$('shareTextTD1').width = 356;
		$('shareTextTD2').width = 330;
	}
	else
	{
		$('shareDiv').className = "fenx1";
//		urlTableDisplay.display = 'none';
        $('sharemsn').style.display = 'none';

        $('showShareDescText1').style.display = 'inline';
        $('shareText1').style.display = 'none';

        $('showShareDescText2').style.display = 'inline';
        $('shareText2').style.display = 'none';
        $('shariImg').src = $('shariImg').src.replace('shari','shari_bg');

		msnQLi.className = '';
		$('shareTextTD1').width = 646;
		$('shareTextTD2').width = 40;
	}
	
	shareTotal('msnq');
}

//点击论坛
function clickBbs(uid, tid, threadTitle) {
    var url = share_url;
    var shareLi = $('shareLi');
	var msnQLi = $('msnQLi');
	var bbsLi = $('bbsLi');
	var urlTableDisplay = $('shareUrlTable').style;
	if(!bbsLi.className) {
        if (uid) {
            var sid = getShareId(tid);
            if (sid) {
                url += '&sid=' + sid;
            }
        }
		$('shareDiv').className = "fenx1";
		$('shareText').value = "[url=" + url + "][u]" + threadTitle + "[/u][/url]";
		urlTableDisplay.display = 'inline';

        $('shariImg').src = $('shariImg').src.replace('shari_bg','shari');

        $('showShareDescText1').style.display = 'none';
        $('shareText1').style.display = 'inline';

        $('showShareDescText2').style.display = 'none';
        $('shareText2').style.display = 'inline';

        $('sharebbs').style.display = 'inline';
        $('sharemsn').style.display = 'none';
        
		msnQLi.className = '';
		bbsLi.className = "li4";
        shareLi.className = '';

		$('shareTextTD1').width = 390;
		$('shareTextTD2').width = 296;
	}
	else
	{
		$('shareDiv').className = "fenx1";
        $('sharebbs').style.display = 'none';
        $('showShareDescText1').style.display = 'inline';
        $('shareText1').style.display = 'none';

        $('showShareDescText2').style.display = 'inline';
        $('shareText2').style.display = 'none';
        $('shariImg').src = $('shariImg').src.replace('shari','shari_bg');
//		urlTableDisplay.display = 'none';
		bbsLi.className = '';
		$('shareTextTD1').width = 646;
		$('shareTextTD2').width = 40;
	}
	
	shareTotal('bbs');
}

//资源页面，分享按钮
function copyShareUrl(copy, title){
	if (window.clipboardData){ 
		if($('msnQLi').className == 'li2')
		{
			copy = "推荐一个我刚下载的资料，相信我没错的：" + title + copy;
			var alertText = "复制成功，你可以粘贴到MSN或QQ中发给好友。";
		}
		else
		{
			var alertText = "复制成功，你可以粘贴到论坛分享给坛友。";
		}
		window.clipboardData.clearData();    
		window.clipboardData.setData("Text", copy);
		alert(alertText);
		$('shareText').select(); 
	} 
	else if (window.netscape){ 
		alert("您使用的浏览器不支持此复制功能，请使用Ctrl+C或鼠标右键。");
		$('shareText').select();
	} 
	return false; 
}

//下载专题首页搜索
function selectKeywords()
{
	if(document.formsearch.keywords.value == '搜索你感兴趣的专题')
	{
		document.formsearch.keywords.style.color = '#000';
		document.formsearch.keywords.value = '';
	}
	else
	{
		document.formsearch.keywords.style.color = '#000';	
	}
}
function blurKeywords()
{
	if(document.formsearch.keywords.value == '')
	{
		document.formsearch.keywords.style.color = '#999999';
		document.formsearch.keywords.value = '搜索你感兴趣的专题';
	}
	else
	{
		document.formsearch.keywords.style.color = '#000';	
	}
}

//获取免费下载豆
function getFreeCredits() {
	var adv_str ='';
	if (typeof(tip_adv) !='undefined' && tip_adv['title']) {
		jQuery.each(tip_adv['title'], function(i, n){
			
			if (tip_adv['link'][i]) {
				adv_str +='<a style="color:blue;" target="_blank" href="' + tip_adv['link'][i] + '">' + n + '</a><br />';
			}
		});
	}

	var a_content ='<div id="dialog" title="下载中心提示您："> <p style="text-align:center;padding:25px 0 20px 0;line-height:20px;">您已收获<span id="tebie">2</span>颗下载豆！<br />豆豆送不停，记得明天再来哦^_^</p> <div style="margin:0px 44px;text-align:center; line-height:24px;">' + adv_str+'</div>';
	var result ='';
	jQuery(a_content).dialog({
		autoOpen: false,
		width: 350,
		buttons: {
			"确定": function() {
				jQuery("#creditsspan").html('<a href="/credits" target="_blank"><u>下载豆：' + result + '</u></a>');			
				jQuery("#left_credits").html(result);
				jQuery(this).dialog("close");
			}
		},
		draggable:false,
		minHeight:'10px',
		resizable:false

	});

	jQuery.ajax({
		'type':'post',
		'url':'/download.php?do=getfreecredits&t=' + Math.random(),
		'dataType':'html',
		'success':function(res){
			cres = res;
			ling_cent = res;
			if(isNaN(res)){//string
				tmp_res = res.split(',');
				cres = tmp_res[0];
				ling_cent = tmp_res[1];
			}
			switch(cres) {
				case '0':
					alert("领取失败");
					return false; break;
				case '1':
					alert("今天您已经领取过了，记得明天再来哦^_^");
					return false;break;
				default:
					var today = new Date();				
					jQuery('#dialog').dialog('open');						
					if ('25' == today.getDate()) {
						//$('#tebie').text('10');//周年下载豆
					}
					jQuery('#tebie').text(ling_cent);//周年下载豆
					result = cres;
			}
		}
	
	
	});	

	return false;	
}

//
function shareTotal(type)
{
		
	var shareUrl = "http://down.51cto.com/download.php";
	var re = 'do=sharetotal&type=' + type;
	ajax = new InitAjax();
	ajax.open("POST",shareUrl,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;	
}

function addFavor() {
    var fav_url = 'http://down.51cto.com';
	var fav_title = '51CTO下载中心_IT资料分享与免费下载平台';
    var statUrl = "http://down.51cto.com/extend/rg/stat.php?type=458&id=666&t=" + Math.random();
    ajax = new InitAjax();
    ajax.open("GET", statUrl, true);
    ajax.send();
	if (document.all && window.external) {
	    window.external.AddFavorite(fav_url,fav_title);
	}else if (window.sidebar)   {
      window.sidebar.addPanel(fav_title,fav_url, "");
    }else {
	    alert("浏览器不支持，请按[CTRL+D]手动加入收藏夹");
	}
}
function getShareId(tid) {
	var shareUrl = "http://down.51cto.com/download.php";
	var re = 'do=getshareid&tid=' + tid;
	ajax = new InitAjax();
	ajax.open("POST",shareUrl,false);
	ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	ajax.send(re);
	result=ajax.responseText;
    if (result == '0') {
        // 未登录
    } else if (result == '-1') {
        // 资源不存在
    } else if (result == '-2') {
        // 分享自己上传的资源不奖励
    } else if (result != '' && !isNaN(result)) {
        return result;
    }
}

function clickShare(uid,tid,_this,type) {
    var url = share_url;
    if (uid) {
        var sid = getShareId(tid);
        if (sid) {
            url += '&sid=' + sid;
        }
    }
    url = encodeURIComponent(url);
    _this.href = _this.href.replace('share_url', url);
    console.log(_this.href);
    shareTotal(type);
}


//获得jiathis分享地址
function getJiaThisShareId(uid, tid) {
	var url = share_url;
	if (uid) {
		var sid = getShareId(tid);
		if (sid) {
			url += '&sid=' + sid;
		}
	}
	
	return url;
}

// 导航下拉菜单
var jsddm_timeout           = 100;
var jsddm_closetimer        = 0;
var jsddm_ddmenuitem        = 0;

function jsddm_open(id, obj) {	
    jsddm_canceltimer();
	jsddm_close();
	jsddm_ddmenuitem = $('jdddm_id' + id);
    jsddm_ddmenuitem.style.display = 'inline';

	var w3c=(document.getElementById)? true:false;
	var ns6=(w3c && (navigator.appName=="Netscape"))? true: false;
	var left,top;
	if (!ns6){
		var nLt = 0;
		var nTp = 0;
		var offsetParent = obj;
		while (offsetParent!=null && offsetParent!=document.body) {
			nLt += offsetParent.offsetLeft;
			nTp += offsetParent.offsetTop;
			offsetParent=offsetParent.offsetParent;
		}
		left = nLt + 12;
		top = nTp + obj.offsetHeight - 8;
	} else {
		left = obj.offsetLeft + 12;
		top = obj.offsetTop + obj.offsetHeight - 8;
	}

	jsddm_ddmenuitem.style.top = top + "px";
	jsddm_ddmenuitem.style.left = left + "px";
}

function jsddm_close() {
    if(jsddm_ddmenuitem) jsddm_ddmenuitem.style.display = 'none';
}

function jsddm_timer() {	
    jsddm_closetimer = window.setTimeout(jsddm_close, jsddm_timeout);
}

function jsddm_canceltimer() {	
    if(jsddm_closetimer) {	
        window.clearTimeout(jsddm_closetimer);
		jsddm_closetimer = null;
    }

}
jQuery(function(){
	//初始化显示的颜色
	jQuery('.subNav  input:[name=keywords]').each(function(){
		var default_value = jQuery(this).attr('default_value');
		var value = jQuery.trim(jQuery(this).val());
		if(default_value != value && value){
			jQuery(this).css('color','#000');
		}
	})
	jQuery('#search_submit').click(function(){
		var default_value = jQuery('#top_search').attr('default_value');
		var value = jQuery.trim(jQuery('#top_search').val());
		var keyword = value;
		var c_re = jQuery('.subNav input[name="c_re"]:checked').val();
		search_log(keyword,'',c_re,'','');//记录日志
		if(default_value == value || !value){
			return false;
		}else{
			return true;
		}
	}).bind('keyup', function(event){
		if (event.keyCode=="13"){
			var default_value = jQuery('#top_search').attr('default_value');
			var value = jQuery.trim(jQuery('#top_search').val());
			var keyword = value;
			var c_re = jQuery('.subNav input[name="c_re"]:checked').val();
			search_log(keyword,'',c_re,'','');//记录日志
			if(default_value == value || !value){
				return false;
			}else{
				return true;
			}
		}
	});
	jQuery('.subNav input:[name=keywords]').blur(function(){
		//失去焦点
		var default_value = jQuery(this).attr('default_value');
		var value = jQuery.trim(jQuery(this).val());
		if(default_value == value || !value){
			jQuery(this).css('color','#D9D9D9').val(default_value);
		}
	}).focus(function(){
		//获得焦点
		var default_value = jQuery(this).attr('default_value');
		var value = jQuery.trim(jQuery(this).val());
		if(default_value == value || !value){
			jQuery(this).css('color','#000').val('');
		}
	})
	/**
	 * 下载评论可可恢复
	 */
	jQuery('.repost').live('click',function(){
		if(!is_login()){
			window.location = homeLogUrl;
			return false;
		}else if (!is_down() && !is_manager() && !is_upload()){
			alert('您还未下载本资料,不能回复评论');
			return false;
		}
		var form = jQuery(this).parent().parent().find('.pHf')
		form.show();
		form.find('textarea').val('');
		document.location.hash = 'textarea_'+jQuery(this).attr('cid');
		jQuery('#comment_'+jQuery(this).attr('cid')).find('textarea')[0].focus();
		return false;
	})
	jQuery('.close_repost_form').live('click',function(){
		jQuery(this).parent().parent().parent().hide();
	})
	form_ajax();
});
/**
 * 用户检索的时候记录日志
 * @param keyword    搜索的关键词
 * @param c_it       技术分类二级分类
 * @param c_re       资料属性
 * @param c_co       企业分类
 * @param c_in       行业分类
 */
function search_log(keyword,c_it,c_re,c_co,c_in){
	jQuery.ajaxSetup({async: false}); 
	var url='/search_log.php?keyword='+keyword+'&c_it='+c_it+'&c_re='+c_re+'&c_co='+c_co+'&c_in='+c_in;
	jQuery.get(url,function(){})
}
function form_ajax(){
	jQuery('.repost_form').ajaxForm({
		success:function(data){
			if(data.flag){
				jQuery('#comment_'+data.comment_id+' .cont_dis').append(data.html);
				jQuery('#comment_'+data.comment_id+' .pHf').hide();
				alert('评论成功');
			}else{
				alert(data.msg);
			}
		},
		dataType:'json'
	}).submit(function(){
		jQuery(this).parent().show();
	});
}
/**
 * 判断用户是否登录
 */
function is_login(){
	if(uid!='0')	return true;
	return false;
}
/**
 * 判断用户是否已经下载
 */
function is_down(){
	if(if_down!='0')	return true;
	return false;
}
/**
 * 判断用户是否是管理员
 */
function is_manager(){
	if(group == 2) return true;
	return false;
}
function is_upload(){
	if(author==uid) return true;
	return false;
}

/**
 * 检查是否用非法关键词
**/
function checkIWK2(Kstr){
	var falg =true;
	jQuery.ajax({
	   async:false,
	   type: "POST",
	   dataType:'json',
	   url: "http://down.51cto.com/service/down_ajax.php?do=IWFilter_Check",
	   data: {'cword':Kstr},
	   success: function(rdata){
		 if (rdata.status==false){
			falg = false;
		 }
	   }
	});
	return falg;
}