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
	src="${pageContext.request.contextPath }/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/highcharts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/highcharts-3d.src.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/exporting.src.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lipin/utils.js"></script>
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
		style="height: 100%; width: 50%;float: right;">
		<table class="layui-table"
			lay-data="{ url:'${pageContext.request.contextPath}/lipin.do?method=all', page:true, id:'idTest'}"
			lay-filter="demo">
			<div class="layui-btn-group demoTable"
				style="margin-top: 10px; margin-left: 10px;">
				<button class="layui-btn" >以下是礼品兑换统计</button>
			</div>
			<thead>
				<tr>
					<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
					<th lay-data="{field:'nid', sort: true}">编号</th>
					<th lay-data="{field:'nname'}">礼品名称</th>
					<th lay-data="{field:'nimg',templet: '#xx'}">礼品图片</th>
					<th lay-data="{field:'njf'}">积分值</th>
					<th lay-data="{field:'ncount'}">总库存量</th>
					<th lay-data="{field:'nncount'}">剩余库存量</th>
					<th
						lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}">兑换记录</th>
				</tr>
			</thead>
		</table>

	</div>




<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="ed">兑换记录</a>
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
    	window.location.href=path+"lipin/allRes.jsp?nid="+data.nid;
    }
  });
});
</script>
</body>
</html>