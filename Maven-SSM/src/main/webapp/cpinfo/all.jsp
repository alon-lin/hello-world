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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/cpinfo/all.js"></script>
<style type="text/css">
.layui-table img {
width: auto;
height: auto;
max-width: 100% !important;
max-height: 100%;
}
</style>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">

	<div class="layui-btn-group demoTable" style="margin-top: 10px;margin-left: 10px;">
		<button class="layui-btn" data-type="getCheckData" >添加产品信息</button>
		<!-- <button class="layui-btn" data-type="getCheckLength" style="background-color: #ebb683;">获取选中数目</button>
		<button class="layui-btn" data-type="isAll" style="background-color: #ebb683;">验证是否全选</button> -->
	</div>
	
	
	<!-- 定义图片模板 -->
	<script type="text/html" id="xx">
		<img src="${pageContext.request.contextPath }/{{d.fimg}}">
	</script>
	

	<table class="layui-table"
		lay-data="{ url:'${pageContext.request.contextPath}/cpinfo.do?method=all', page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
				<th lay-data="{field:'fid', sort: true}">编号</th>
				<th lay-data="{field:'fname'}">产品名称</th>
				<th lay-data="{field:'cname'}">产品类别名称</th>
				<th lay-data="{field:'fdw'}">产品规格</th>
				<th lay-data="{field:'faddress'}">产地</th>
				<th lay-data="{field:'foutprice'}">出售价</th>
				<th lay-data="{field:'finprice'}">进货价</th>
				<th lay-data="{field:'fimg',templet: '#xx'}">产品图片</th>
				<th lay-data="{field:'fcount'}">库存数量</th>
				<th
					lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}">操作</th>
			</tr>
		</thead>
	</table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
</script>

<!-- <script type="text/javascript">
layui.use('table', function(){
	  var table = layui.table;
	layui.use('table', function(){
		var table = layui.table;
		table.render()
	} 
}
</script> -->
</body>
</html>