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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/highcharts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/highcharts-3d.src.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/exporting.src.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/cpinfo/utils.js"></script>
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

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
	<!-- 定义图片模板 -->
	<script type="text/html" id="xx">
		<img src="${pageContext.request.contextPath }/{{d.fimg}}">
	</script>


	<div id="container"
		style="min-width: 500px; height: 500px; width: 48%;  float: left;"></div>


	<div id="right"
		style="height: 100%; width: 50%; float: right;">
		<table class="layui-table"
			lay-data="{ url:'${pageContext.request.contextPath}/cpinfo.do?method=pll', page:true, id:'idTest'}"
			lay-filter="demo">
			<div class="layui-btn-group demoTable"
				style="margin-top: 10px; margin-left: 10px;">
				<button class="layui-btn" ">以下是产品销量统计</button>
			</div>
			<thead>
				<tr>
					<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
					<th lay-data="{field:'fid', sort: true}">编号</th>
					<th lay-data="{field:'fname'}">产品名称</th>
					<th lay-data="{field:'cname'}">产品类别名称</th>
					<th lay-data="{field:'faddress'}">产地</th>
					<th lay-data="{field:'foutprice'}">出售价</th>
					<th lay-data="{field:'fimg',templet: '#xx'}">产品图片</th>
					<th lay-data="{field:'fcount'}">库存数量</th>
					<th lay-data="{field:'xcount'}">销售数量</th>
					<th
						lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}">操作</th>
				</tr>
			</thead>
		</table>

	</div>




	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="ed">明细</a>
</script>
<script>
layui.use('table', function(){
  var table = layui.table;
  var path=$('#path').val();
  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'detail'){
	      layer.msg('ID：'+ data.id + ' 的查看操作');
	    } else if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        obj.del();
	        layer.close(index);
	      });
	    } else if(obj.event === 'edit'){
	    	window.location.href = path+"getcp/allOutcp.jsp?fid="+data.fid;
	    }
	  });
  
});
</script>
</body>
</html>