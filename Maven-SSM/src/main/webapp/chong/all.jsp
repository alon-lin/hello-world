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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/chong/all.js"></script>
<style type="text/css">

</style>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">

	<div class="layui-btn-group demoTable" style="margin-top: 10px;margin-left: 10px;">
		<button class="layui-btn" data-type="getCheckData" >我要充值</button>
		<!-- <button class="layui-btn" data-type="getCheckLength" >获取选中数目</button>
		<button class="layui-btn" data-type="isAll" >验证是否全选</button> -->
	</div>

	<table class="layui-table"
		lay-data="{ url:'${pageContext.request.contextPath}/chong.do?method=all', page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<th lay-data="{field:'oid', sort: true}">充值编号</th>
				<th lay-data="{field:'rname'}">会员名称</th>
				<th lay-data="{field:'omoney'}">充值金额</th>
				<th lay-data="{field:'ytitle'}">活动名称</th>
				<th lay-data="{field:'osmoney'}">优惠金额</th>
				<th lay-data="{field:'olastmoney'}">最终金额</th>
				<th lay-data="{field:'uname'}">经办人编号</th>
				<th lay-data="{field:'oremark'}">备注</th>
				<th lay-data="{field:'otime'}">充值时间</th>
			</tr>
		</thead>
	</table>



</body>
</html>