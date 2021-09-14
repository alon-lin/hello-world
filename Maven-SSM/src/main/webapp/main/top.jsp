<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath }/Templates/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/Templates/js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>

<body style="background:url(${pageContext.request.contextPath }/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.jsp" target="_parent"><img src="${pageContext.request.contextPath }/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="default.html" target="rightFrame" class="selected"><img src="${pageContext.request.contextPath }/images/icon01.png" title="系统管理" /><h2>系统管理</h2></a></li>
    <li><a href="imgtable.html" target="rightFrame"><img src="${pageContext.request.contextPath }/images/icon02.png" title="会员管理" /><h2>会员管理</h2></a></li>
    <li><a href="imglist.html"  target="rightFrame"><img src="${pageContext.request.contextPath }/images/icon03.png" title="库存管理" /><h2>库存管理</h2></a></li>
    <li><a href="tools.html"  target="rightFrame"><img src="${pageContext.request.contextPath }/images/icon04.png" title="消费管理" /><h2>消费管理</h2></a></li>
    <li><a href="computer.html" target="rightFrame"><img src="${pageContext.request.contextPath }/images/icon05.png" title="积分兑换" /><h2>积分兑换</h2></a></li>
    <li><a href="tab.html"  target="rightFrame"><img src="${pageContext.request.contextPath }/images/icon06.png" title="客户关怀" /><h2>客户关怀</h2></a></li>
        <li><a href="tab.html"  target="rightFrame"><img src="${pageContext.request.contextPath }/images/icon06.png" title="统计报表" /><h2>统计报表</h2></a></li>
    </ul>
            
    <div class="topright">    
    <ul>
    <li><span><img src="${pageContext.request.contextPath }/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="${pageContext.request.contextPath }/login.jsp" target="_parent">退出</a></li>
    </ul>
    
      <div class="user">
    <span>${user.urealname}</span>
    <i>消息</i>
    <b>5</b>
    </div>   
    </div>

</body>
</html>
