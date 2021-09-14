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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/upd.js"></script>
<style type="text/css">

</style>
</head>
<body>
	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	<input type="hidden" id="uid" value="<%=request.getParameter("uid")%>">

	<form class="layui-form layui-form-pane" action="#">
		<table align="center" style="margin-top: 40px;">
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">员工姓名</label>
						<div class="layui-input-inline">
							<input type="text" id="uname" lay-verify="required"
								placeholder="请输入员工姓名" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">密码</label>
						<div class="layui-input-inline">
							<input type="password" id="upsw" lay-verify="required"
								placeholder="请输入密码" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">真实姓名</label>
						<div class="layui-input-inline">
							<input type="text" id="urealname" lay-verify="required"
								placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">电话</label>
						<div class="layui-input-inline">
							<input type="text" id="utel" lay-verify="required|number"
								placeholder="请输入电话" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
				    <label class="layui-form-label">单选框</label>
				    <div class="layui-input-block">
				      <input type="radio" name="usex" value="1" title="男" checked="checked" id="male">
				      <input type="radio" name="usex" value="0" title="女" id="female">
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