<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录后台管理系统</title>
<link href="${pageContext.request.contextPath }/Templates/css/style.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript"
	src="${pageContext.request.contextPath }/Templates/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/Templates/js/cloud.js"
	type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userinfo/login.js"></script>

<script language="javascript">
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
</script>

</head>

<body
	style="background-color: #df7611; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">
		<span class="systemlogo"></span>
		<input type="hidden" value="${pageContext.request.contextPath }/" id="path">
		<div class="loginbox loginbox3">
			<ul>
				<li><input name="" type="text" class="loginuser"  id="uname"/></li>
				<li><input name="" type="password" class="loginpwd"  id="upsw"/></li>
				<li class="yzm"><span><input name="" type="text"
						value="验证码" onclick="JavaScript:this.value=''" /></span><cite>X3D5S</cite>
				</li>
				<li><input name="" type="button" class="loginbtn" value="登录" id="btn"/><label>
						<input name="" type="checkbox" value="" checked="checked" />记住密码
				</label><label><a href="#">忘记密码？</a></label></li>
			</ul>
		</div>
	</div>


	<div class="loginbm">
		版权所有 2014 <a href="http://www.uimaker.com">uimaker.com</a>
		仅供学习交流，勿用于任何商业用途
	</div>


</body>
</html>