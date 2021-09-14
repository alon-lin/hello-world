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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/cpinfo/add.js"></script>
</head>
<body>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
	<br>


	<form class="layui-form layui-form-pane" action="#" method="post">

		<table align="center">
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">产品名称：</label>
						<div class="layui-input-inline">
							<input type="text" name="fname" id="fname" lay-verify="required"
								placeholder="请输入产品名称" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">产品类型：</label>
						<div class="layui-input-inline">
							<select name="interest" name="cid" id="cid" lay-filter="aihao">
								
							</select>
						</div>
					</div>
				</td>
			</tr>


			<tr>
				<td>

					<div class="layui-form-item">
						<label class="layui-form-label">产品单位：</label>
						<div class="layui-input-inline">
							<select name="interest" id="fdw" name="fdw" lay-verify="required"
								lay-filter="aihao">
								
							</select>
						</div>
					</div>
				</td>
			</tr>

			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">产品产地：</label>
						<div class="layui-input-inline">
							<input type="text" name="faddress" id="faddress"
								lay-verify="required" placeholder="请输入产品产地" autocomplete="off"
								class="layui-input">
						</div>
					</div>

				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">出售价格：</label>
						<div class="layui-input-inline">
							<input type="text" name="foutprice" id="foutprice"
								lay-verify="required|number" placeholder="请输入出售价格" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">进货价格：</label>
						<div class="layui-input-inline">
							<input type="text" name="finprice" id="finprice"
								lay-verify="required|number" placeholder="请输入进货价格" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">产品相片：</label>
						<div class="layui-input-inline">
							<input type="file" name="img" id="img" lay-verify="required"
								placeholder="请上传会员相片" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					  <div class="layui-form-item">
					    <div class="layui-input-block">
					      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
					      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
					    </div>
					  </div>
				</td>
			</tr>
		</table>
		<input type="hidden" id="fcount" name="fcount" value="0">
	</form>

</body>
</html>