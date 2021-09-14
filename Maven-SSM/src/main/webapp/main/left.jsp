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
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#fff3e1;">
	<div class="lefttop"><span></span>功能导航</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/images/leftico01.png" /></span>基本功能
    </div>
    	<ul class="menuson">
        
        <!-- <li class="active"><cite></cite><a href="#" target="rightFrame">系统首页</a><i></i></li> -->
        <li><cite></cite><a href="${pageContext.request.contextPath }/dj/all.jsp" target="rightFrame">会员等级设置</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/cptype/all.jsp" target="rightFrame">产品分类设置</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/servicetype/all.jsp" target="rightFrame">服务记录设置</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/pz/all.jsp" target="rightFrame">自定(客户凭证)</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/cartype/all.jsp" target="rightFrame">自定(汽车品牌)</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/carxl/all.jsp" target="rightFrame">自定(汽车系列)</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/youhui/all.jsp" target="rightFrame">优惠活动设置</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/user/all.jsp" target="rightFrame">操作员管理</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath }/images/leftico02.png" /></span>会员管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/member/all.jsp" target="rightFrame">会员信息管理</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/chong/all.jsp" target="rightFrame">充值服务</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="${pageContext.request.contextPath }/images/leftico03.png" /></span>库存管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/cpinfo/all.jsp" target="rightFrame">产品信息</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/getcp/all.jsp" target="rightFrame">库存管理</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="${pageContext.request.contextPath }/images/leftico04.png" /></span>消费管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${pageContext.request.contextPath }/outcp/all.jsp" target="rightFrame">会员消费信息</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/sanke/all.jsp" target="rightFrame">散客消费信息</a><i></i></li>
        <li><cite></cite><a href="${pageContext.request.contextPath }/jici/all.jsp" target="rightFrame">计次消费信息</a><i></i></li>
    </ul>
    </dd>  
    
      <dd><div class="title"><span><img src="${pageContext.request.contextPath }/images/leftico04.png" /></span>积分兑换</div>
	    <ul class="menuson">
	        <li><cite></cite><a href="${pageContext.request.contextPath }/lipin/all.jsp" target="rightFrame">礼品信息</a><i></i></li>
	        <li><cite></cite><a href="${pageContext.request.contextPath }/duihuan/all.jsp" target="rightFrame">积分兑换</a><i></i></li>
	    </ul>
	  </dd> 
	    
     <dd><div class="title"><span><img src="${pageContext.request.contextPath }/images/leftico04.png" /></span>关怀管理</div>
	    <ul class="menuson">
	        <li><cite></cite><a href="${pageContext.request.contextPath }/look/all.jsp" target="rightFrame">关怀信息</a><i></i></li>
	    </ul>
	  </dd> 
	  
	  
	  <dd><div class="title"><span><img src="${pageContext.request.contextPath }/images/leftico04.png" /></span>统计报表</div>
	    <ul class="menuson">
	        <li><cite></cite><a href="${pageContext.request.contextPath }/member.do?method=ok" target="rightFrame">客户等级报表</a><i></i></li>
	        <li><cite></cite><a href="${pageContext.request.contextPath }/cpinfo/utils.jsp" target="rightFrame">产品分类报表</a><i></i></li>
	        <li><cite></cite><a href="${pageContext.request.contextPath }/lipin/utils.jsp" target="rightFrame">礼品分类报表</a><i></i></li>
	        <li><cite></cite><a href="${pageContext.request.contextPath }/member/jfUtils.jsp" target="rightFrame">会员积分报表</a><i></i></li>
	    </ul>
	  </dd> 
    
    </dl>
    
    
    
      
     
    
</body>
</html>
