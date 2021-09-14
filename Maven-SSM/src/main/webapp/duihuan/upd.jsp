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
	src="${pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/lipin/upd.js"></script>
</head>
<body>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
		<input type="hidden" id="nid" value="<%=request.getParameter("nid")%>">


	<form class="layui-form layui-form-pane" method="post">
		<table align="center" style="margin-top: 20px;">
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">礼品名称：</label>
						<div class="layui-input-inline">
							<input type="text" name="rcard" id="nname" lay-verify="required"
								placeholder="请输入会员卡号" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">所需积分：</label>
						<div class="layui-input-inline">
							<input type="text" name="rname" id="njf" lay-verify="required"
								placeholder="请输入会员姓名" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">进货数量：</label>
						<div class="layui-input-inline">
							<input type="text" name="ncount" id="ncount"
								lay-verify="required" placeholder="请输入会员姓名" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</td>
			</tr>



			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">礼品相片：</label>
						<div class="layui-input-inline">
							<input type="file" name="img" id="img" lay-verify="required"
								placeholder="请上传会员相片" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>

			</tr>
			<tr>
				<td align="center">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</td>
			</tr>

		</table>

	</form>

</body>
</html>
