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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/member/all.js"></script>
<style type="text/css">

</style>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">

	<div class="layui-btn-group demoTable" style="margin-top: 10px;margin-left: 10px;">
		<button class="layui-btn" data-type="getCheckData" >添加会员信息</button>
		<!-- <button class="layui-btn" data-type="getCheckLength" >获取选中数目</button>
		<button class="layui-btn" data-type="isAll" >验证是否全选</button> -->
	</div>
	
	
	<!-- 定义图片模板 -->
	<script type="text/html" id="xx">
		<img src="${pageContext.request.contextPath }/{{d.rimg}}">
	</script>
	

	<table class="layui-table"
		lay-data="{ url:'${pageContext.request.contextPath}/member.do?method=all', page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
				<th lay-data="{field:'rid', sort: true}">会员编号</th>
				<th lay-data="{field:'rcard'}">会员卡号</th>
				<th lay-data="{field:'rname'}">会员名称</th>
				<th lay-data="{field:'rimg',templet: '#xx'}">会员图片</th>
				<th lay-data="{field:'rtel'}">会员电话</th>
				<th lay-data="{field:'sex'}">会员性别</th>
				<th lay-data="{field:'dname'}">会员等级</th>
				<th lay-data="{field:'status'}">卡状态</th>
				<th lay-data="{field:'rjf'}">卡积分</th>
				<th lay-data="{field:'raddress'}">地址</th>
				<th lay-data="{field:'rmoney'}">余额</th>
				<th lay-data="{field:'aname'}">汽车品牌</th>
				<th lay-data="{field:'xname'}">汽车系列</th>
				<th
					lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo1'}">查看详情</th>
					<th
					lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}">操作</th>
			</tr>
		</thead>
	</table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="ed">编辑</a>
</script>
<script type="text/html" id="barDemo1">
  <a class="layui-btn layui-btn-xs" lay-event="one" id="ed">查看详情</a>
</script>

</body>
</html>