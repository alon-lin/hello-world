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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/lipin/allRes.js"></script>
<style type="text/css">

</style>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	<input type="hidden" id="nid" value="<%=request.getParameter("nid")%>">


	<table class="layui-table"
		lay-data="{ url:'${pageContext.request.contextPath}/duihuan.do?method=allx&nid='+<%=request.getParameter("nid")%>, page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
				<th lay-data="{field:'hid', sort: true}">兑换编号</th>
				<th lay-data="{field:'nid'}">礼品名称</th>
				<th lay-data="{field:'rname'}">会员名称</th>
				<th lay-data="{field:'nname'}">礼品名称</th>
				<th lay-data="{field:'hcount'}">兑换数量</th>
				<th lay-data="{field:'htime'}">兑换时间</th>
				<th lay-data="{field:'uname'}">经办人</th>
			</tr>
		</thead>
	</table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="ed">编辑</a>
</script>

</body>
</html>