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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/getcp/all.js"></script>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	<input type="hidden" id="fid" value="<%=request.getParameter("fid")%>">

	<div class="layui-btn-group demoTable" style="margin-top: 10px;margin-left: 10px;">
		<button class="layui-btn" data-type="getCheckData" >添加入库记录</button>
	<!-- 	<button class="layui-btn" data-type="getCheckLength" >获取选中数目</button>
		<button class="layui-btn" data-type="isAll" >验证是否全选</button> -->
	</div>
	
	
	<!-- 定义图片模板 -->
	<script type="text/html" id="xx">
		<img src="${pageContext.request.contextPath }/{{d.fimg}}">
	</script>
	

	<table class="layui-table"
		lay-data="{ url:'${pageContext.request.contextPath}/getcp.do?method=selAll&fid='+<%=request.getParameter("fid")%>, page:true, id:'idTest'}"
		lay-filter="demo">
		<thead>
			<tr>
				<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
				<th lay-data="{field:'gid', sort: true}">编号</th>
				<th lay-data="{field:'fname'}">产品名称</th>
				<th lay-data="{field:'gcount'}">入库数量</th>
				<th lay-data="{field:'gtime'}">入库时间</th>
				<th lay-data="{field:'uname'}">经办人名称</th>
			</tr>
		</thead>
	</table>



<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="out" id="ed">入库记录</a>
</script>
<script type="text/html" id="barDemo2">
  <a class="layui-btn layui-btn-xs" lay-event="up" id="ed">出库记录</a>
</script>
</body>
</html>