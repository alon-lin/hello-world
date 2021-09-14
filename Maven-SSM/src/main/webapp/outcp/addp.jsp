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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/outcp/addp.js"></script>

</head>
<body>
	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	<input type="hidden" id="rcard" value="<%=request.getParameter("rcard")%>">
	<form class="layui-form layui-form-pane" action="#">
		<table align="center" style="margin-top: 40px;">
			<tr>
				<td>
					 <div class="layui-form-item">
					    <label class="layui-form-label">产品类别</label>
					    <div class="layui-input-inline">
					      <select name="cid" id="cid" lay-filter="cids">
					      </select>
					    </div>
					  </div>
				</td>	
			</tr>
			<tr>
				<td>
				<div class="layui-form-item">
					    <label class="layui-form-label">产品名称</label>
					    <div class="layui-input-inline">
					      <select name="fid" id="fid" lay-filter="fids">
					      </select>
					    </div>
					  </div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">库存总量</label>
						<div class="layui-input-inline">
							<input type="text" id="fcount" lay-verify="required|number"
								placeholder="请输入库存总量" autocomplete="off" class="layui-input" disabled="disabled">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">出售价格</label>
						<div class="layui-input-inline">
							<input type="text" id="foutprice" lay-verify="required|number"
								placeholder="请输入出售价格" autocomplete="off" class="layui-input" disabled="disabled">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">购买数量</label>
						<div class="layui-input-inline">
							<input type="text" id="xcount" lay-verify="required|number"
								placeholder="请输入购买数量" autocomplete="off" class="layui-input">
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
</body>
</html>