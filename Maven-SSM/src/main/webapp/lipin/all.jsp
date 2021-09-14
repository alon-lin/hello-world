<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/lipin/all.js"></script>
<style type="text/css">
/* .layui-table-cell{
     height: auto!important;
     white-space: normal;
} */


</style>
</head>
<body>
	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	
	
	<!-- 动态表格中的内容 -->
	<!-- 
	<DIV  id="barDemo" style="display: none;">
	  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
      <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
      <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
      
	</DIV> -->
	<script type="text/html" id="barDemo1">
		<a class="layui-btn layui-btn-xs" lay-event="edit" id="ed">兑换记录</a>
	</script>

	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="detail" id="ed">编辑</a>
	</script>
	
	<!-- 按钮组 -->
	<div class="layui-btn-group demoTable" style="margin-top: 10px;margin-left: 10px;">
		<button class="layui-btn" data-type="addemp" id="add">增加礼品</button>
		<!-- <button class="layui-btn" data-type="uppemp" id="upp">修改员工</button>
		<button class="layui-btn" data-type="getCheckData">批量删除</button> -->
	</div>
	
	
	
	<!-- 主要内容 -->
	<table class="layui-hide" id="test" lay-filter="demo"></table>
	<!-- 分页控件 -->
    <!-- <div id="laypage"></div> -->
</body>
</html>