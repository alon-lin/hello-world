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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/youhui/upd.js"></script>
</head>
<body>
	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	<input type="hidden" id="yid" value="<%=request.getParameter("yid")%>">
	<form class="layui-form layui-form-pane" action="#">
		<table align="center" style="margin-top: 40px;">
			<tr>
				<td>
				<div class="layui-form-item">
					<div class="layui-inline">
				      <label class="layui-form-label">活动开始时间</label>
				      <div class="layui-input-inline">
				        <input type="text" class="layui-input" id="test1" placeholder="yyyy-MM-dd"  lay-verify="required">
				      </div>
				    </div>
				  </div>
				</td>
			</tr>
			<tr>
				<td>
				<div class="layui-form-item">
					<div class="layui-inline">
				      <label class="layui-form-label">活动结束时间</label>
				      <div class="layui-input-inline">
				        <input type="text" class="layui-input" id="test2" placeholder="yyyy-MM-dd"  lay-verify="required">
				      </div>
				    </div>
				  </div>
				</td>
			</tr>
			<tr>
				<td>
					  <div class="layui-form-item layui-form-text">
					    <label class="layui-form-label" style = "width:300px;">活动标题</label>
					    <div class="layui-input-block">
					      <textarea placeholder="请输入内容" class="layui-textarea" style = "width:300px;" id="ytitle" lay-verify="required"></textarea>
					    </div>
					  </div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">起始金额</label>
						<div class="layui-input-inline">
							<input type="text" id="ymoney" lay-verify="required|number"
								placeholder="请输入优惠金额" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">优惠金额</label>
						<div class="layui-input-inline">
							<input type="text" id="ylessmoney" lay-verify="required|number"
								placeholder="请输入优惠金额" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit="" lay-filter="demo1" >立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<script>
		layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#test1' //指定元素
		  });
		//执行一个laydate实例
		  laydate.render({
		    elem: '#test2' //指定元素
		  });
		});
	</script>
</body>
</html>