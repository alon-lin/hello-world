<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/highcharts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/highcharts-3d.src.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/exporting.src.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/member/jsUtils.js"></script>
<style type="text/css">


.demoTable {
	/* 	margin-left: 10px; */
	margin-top: 10px;
}

#container {
	margin-left: 10px;
}
</style>
</head>
<body>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="one" id="ed">查看详情</a>
</script>
	<div class="demoTable">
		<span style="padding-left: 30px;"></span> 段一(<=)：
		<div class="layui-inline">
			<input class="layui-input" name="id" id="oneDemoReload"
				autocomplete="off">
		</div>
		<span style="padding-left: 30px;"></span> 段二(<=)：
		<div class="layui-inline">
			<input class="layui-input" name="id" id="twoDemoReload"
				autocomplete="off">
		</div>
		<span style="padding-left: 30px;"></span> 段三(<=)：
		<div class="layui-inline">
			<input class="layui-input" name="id" id="threeDemoReload"
				autocomplete="off">
		</div>


		<button class="layui-btn" data-type="rel">搜索</button>
	</div>
	<div id="container"
		style="min-width: 600px; height: 500px; width: 48%; float: left;"></div>
	<div id="right"
		style="height: 100%; width: 50%;  float: right;">
		<div>
			<button class="layui-btn" data-type="getCheckData" id="btn9"
				>
				以下是<span id="onejf"></span> 信息
			</button>
			<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>
		</div>
		<div>
		<button class="layui-btn" data-type="getCheckData" id="btn"
				>
				以下是<span id="onejf1"></span> 信息
			</button>
			<table class="layui-hide" id="LAY_table_user1" lay-filter="user"></table>
		</div>
		<div id="d3">
		<button class="layui-btn" data-type="getCheckData" id="btn1"
				>
				以下是<span id="onejf2"></span> 信息
			</button>
			<table class="layui-hide" id="LAY_table_user2" lay-filter="user"></table>
		</div>
		<div id="d4">
		<button class="layui-btn" data-type="getCheckData" id="btn2"
				>
				以下是<span id="onejf3"></span> 信息
			</button>
			<table class="layui-hide" id="LAY_table_user3" lay-filter="user"></table>
		</div>
		
	</div>

</body>
</html>