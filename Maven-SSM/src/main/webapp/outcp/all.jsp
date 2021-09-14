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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/outcp/all.js"></script>
<style type="text/css">

</style>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">

	<div class="layui-btn-group demoTable" style="margin-top: 10px;margin-left: 10px;">
		<button class="layui-btn" data-type="getCheckData" >添加会员消费信息</button>
		<!-- <button class="layui-btn" data-type="getCheckLength" >获取选中数目</button>
		<button class="layui-btn" data-type="isAll" >验证是否全选</button> -->
	</div>

	<table class="layui-table"
		lay-data="{ url:'${pageContext.request.contextPath}/outcp.do?method=all', page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
				<th lay-data="{field:'tid', sort: true}">类别编号</th>
				<th lay-data="{field:'rname'}">会员名称</th>
				<th lay-data="{field:'cname'}">产品类别名称</th>
				<th lay-data="{field:'fname'}">产品名称</th>
				<th lay-data="{field:'xcount'}">购买数量</th>
				<th lay-data="{field:'allPrice'}">出售价</th>
				<th lay-data="{field:'price'}">折扣价</th>
				<th lay-data="{field:'price'}">小计</th>
				<th lay-data="{field:'ttime'}">购买时间</th>
				<th lay-data="{field:'uname'}">经办人</th>
				<!-- <th lay-data="{field:'tflag'}">优惠金额</th> -->
				<!-- <th
					lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th> -->
			</tr>
		</thead>
	</table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="ed">编辑</a>
</script>

</body>
</html>