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
	src="${pageContext.request.contextPath }/js/look/all.js"></script>
<style type="text/css">


#x {
	font-weight: bold;
}
</style>
</head>
<body>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">

	<div class="layui-card">
		<div class="layui-card-header">
			<h4 id="x">查询条件</h4>
		</div>
		<div class="layui-card-body">
			<div class="demoTable">
				<div class="layui-btn-group demoTable">
					<button class="layui-btn" data-type="getCheckData"
						>添加关怀</button>
				</div>
				<span style="padding-left: 30px;"></span> 会员卡号：
				<div class="layui-inline">
					<input class="layui-input" name="id" id="demoReload"
						autocomplete="off">
				</div>
				<button class="layui-btn" data-type="reload">搜索</button>
				<span style="padding-left: 30px;"></span> 日期：
				<div class="layui-inline">
					<input type="text" name="date" id="dateReload" autocomplete="off"
						class="layui-input" data-type="dateReload">
				</div>
				<button class="layui-btn" data-type="rel">搜索</button>
			</div>



			<table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>


			<script>
				layui
						.use(
								'table',
								function() {
									var table = layui.table;

									//方法级渲染
									table
											.render({
												elem : '#LAY_table_user',
												url : '${pageContext.request.contextPath}/look.do?method=all',
												cols : [ [ {
													field : 'kid',
													title : '关怀编号',
													sort : true,
													fixed : true
												}, {
													field : 'rcard',
													title : '会员卡号'
												}, {
													field : 'rname',
													title : '会员名称'
												}, {
													field : 'ktime',
													title : '关怀时间',
													sort : true
												}, {
													field : 'kremark',
													title : '关怀备注'
												}, {
													field : 'uname',
													title : '经办人'
												} ] ],
												id : 'testReload',
												page : true,
												height : 315
											});

									var $ = layui.$, active = {
									/* reload: function(){
									  var demoReload = $('#demoReload');
									  //执行重载
									  table.reload('testReload', {
									    page: {
									      curr: 1 //重新从第 1 页开始
									    }
									    ,where: {
									    	 rcard: demoReload.val()
									    }
									  });
									},
									rel:function(){
										var dateReload=$('#dateReload').val();
										table.reload('testReload', {
									        page: {
									          curr: 1 //重新从第 1 页开始
									        }
									        ,where: {
									        	 ktime:dateReload
									        }
									      });
									} */

									};

									$('.demoTable .layui-btn').on('click',function() {
														var type = $(this)
																.data('type');
														var demoReload = $(
																'#demoReload')
																.val();
														var dateReload = $(
																'#dateReload')
																.val();
														if (type == 'rel'
																|| type == 'reload') {
															if (demoReload == ''
																	&& dateReload == '') {
																table
																		.render({
																			elem : '#LAY_table_user',
																			url : '${pageContext.request.contextPath}/look.do?method=all',
																			cols : [ [
																					{
																						field : 'kid',
																						title : '关怀编号',
																						sort : true,
																						fixed : true
																					},
																					{
																						field : 'rcard',
																						title : '会员卡号'
																					},
																					{
																						field : 'rname',
																						title : '会员名称'
																					},
																					{
																						field : 'ktime',
																						title : '关怀时间',
																						sort : true
																					},
																					{
																						field : 'kremark',
																						title : '关怀备注'
																					},
																					{
																						field : 'uname',
																						title : '经办人'
																					} ] ],
																			id : 'testReload',
																			page : true,
																			height : 315
																		});
															} else if (demoReload != ''
																	&& dateReload != '') {
																table
																		.reload(
																				'testReload',
																				{
																					page : {
																						curr : 1
																					//重新从第 1 页开始
																					},
																					where : {
																						ktime : dateReload,
																						rcard : demoReload
																					}
																				});
															} else if (demoReload != '') {
																table
																		.reload(
																				'testReload',
																				{
																					page : {
																						curr : 1
																					//重新从第 1 页开始
																					},
																					where : {
																						rcard : demoReload
																					}
																				});
															} else if (dateReload != '') {
																table
																		.reload(
																				'testReload',
																				{
																					page : {
																						curr : 1
																					//重新从第 1 页开始
																					},
																					where : {
																						ktime : dateReload
																					}
																				});
															}
														}

														active[type] ? active[type]
																.call(this)
																: '';
													});
								});
			</script>

		</div>
	</div>






	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" id="ed">编辑</a>
</script>
	<script type="text/javascript">
		layui.use([ 'element', 'laydate' ], function() {
			var element = layui.element, laydate = layui.laydate;
			laydate.render({
				elem : '#dateReload'
			});
		});
	</script>

</body>
</html>