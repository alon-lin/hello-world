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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/getcp/allOutcp.js"></script>
<style type="text/css">
#ed{
	width: 140px;
	height: 26px;
	line-height: 26px;
	background-color: #ebb683;
}
</style>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	<input type="hidden" id="fid" value="<%=request.getParameter("fid") %>">
	

	<div class="layui-tab layui-tab-card">
	  <ul class="layui-tab-title">
	    <li class="layui-this">会员消费</li>
	    <li>散客消费</li>
	  </ul>
	  <div class="layui-tab-content" style="height: 80%;">
	    <div class="layui-tab-item layui-show">
	    	<table class="layui-table"
				lay-data="{ url:'${pageContext.request.contextPath}/outcp.do?method=allpp&fid='+<%=request.getParameter("fid") %>, page:true, id:'idTest'}"
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
						<th lay-data="{field:'price'}">折扣价价</th>
						<th lay-data="{field:'allPrice'}">小计</th>
						<th lay-data="{field:'ttime'}">购买时间</th>
						<th lay-data="{field:'uname'}">经办人</th>
						<!-- <th lay-data="{field:'tflag'}">优惠金额</th> -->
						<!-- <th
							lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th> -->
					</tr>
				</thead>
			</table>
	    </div>
	    <div class="layui-tab-item">
	    	<table class="layui-table"
				lay-data="{ url:'${pageContext.request.contextPath}/outcp1.do?method=allx&fid='+<%=request.getParameter("fid") %>, page:true, id:'idTest'}"
				lay-filter="demo">
				<thead>
					<tr>
						<!-- <th lay-data="{type:'checkbox', fixed: 'left'}"></th> -->
						<th lay-data="{field:'wid', sort: true}">散客编号</th>
						<th lay-data="{field:'wname'}">散客名称</th>
						<th lay-data="{field:'wtel'}">散客电话</th>
						<th lay-data="{field:'cname'}">产品类型</th>
						<th lay-data="{field:'fname'}">产品名称</th>
						<th lay-data="{field:'foutprice'}">产品售价</th>
						<th lay-data="{field:'wcount'}">购买数量</th>
						<th lay-data="{field:'price'}">小计</th>
						<th lay-data="{field:'wtime'}">消费时间</th>
						<th lay-data="{field:'uname'}">经办人</th>
						
						<!-- <th
							lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th> -->
					</tr>
				</thead>
			</table>
	    </div>
	  </div>
	</div>


<script>
layui.use('element', function(){
  var $ = layui.jquery
  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
  
  
  
});
</script>


</body>
</html>