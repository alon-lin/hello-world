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
	src="${pageContext.request.contextPath }/js/member/utils.js"></script>
<style type="text/css">

</style>
</head>
<body>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
	<input type="hidden" id="size" value="<%=session.getAttribute("ar")%>">


	<div id="container"
		style="min-width: 600px; height: 500px; width: 48%; float: left;"></div>
	<div id="right"
		style="height: 100%; width: 50%; border: 1px solid yellow; float: right;">
		<c:forEach var="item" begin="1" end="${ar}">

			<table class="layui-table"
				lay-data="{ url:'${pageContext.request.contextPath}/member.do?method=pll&did='+${item}, page:true, id:'idTest'}"
				lay-filter="demo">
				<div class="layui-btn-group demoTable"
					style="margin-top: 10px; margin-left: 10px;">
					<button class="layui-btn" data-type="getCheckData"
						>
						以下是 <input type="hidden" id="did${item}" value="${item}" /><span
							id="dname${item}"></span> 信息
					</button>
				</div>
				<thead>
					<tr>
						<th lay-data="{field:'rid', sort: true}">编号</th>
						<th lay-data="{field:'rcard'}">卡号</th>
						<th lay-data="{field:'rname'}">名称</th>
						<th lay-data="{field:'sex'}">性别</th>
						<th lay-data="{field:'dname'}">等级</th>
						<th lay-data="{field:'rjf'}">卡积分</th>
						<th lay-data="{field:'raddress'}">地址</th>
						<th lay-data="{field:'rmoney'}">余额</th>
						<th
							lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo1'}">查看详情</th>

					</tr>
				</thead>
			</table>
		</c:forEach>


<script type="text/html" id="barDemo1">
  <a class="layui-btn layui-btn-xs" lay-event="one" id="ed">查看详情</a>
</script>

		
		<script>
			layui.use('table', function() {
				var table = layui.table;
				//监听工具条
				table.on('tool(demo)', function(obj) {
					var data = obj.data;
					if (obj.event === 'one') {
						window.location.href='${pageContext.request.contextPath}/member/all.jsp';
					}
				});
			});
		</script>
	</div>
</body>
</html>