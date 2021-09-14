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
	src="${pageContext.request.contextPath }/js/duihuan/add.js"></script>
</head>
<body>
<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
<input type="text" id="dmoneyBl" style="display:none; ">
	<form class="layui-form layui-form-pane" action="#">
		<table align="center" style="margin-top: 40px;">
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员卡号</label>
						<div class="layui-input-inline">
							<input type="text" id="rcard" lay-verify="required"
								placeholder="请输入会员卡号" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr class="x">
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员姓名</label>
						<div class="layui-input-inline">
							<input type="text" id="rname" lay-verify="required"
								placeholder="请输入会员姓名" autocomplete="off" class="layui-input" disabled="disabled">
						</div>
					</div>
				</td>
			</tr>
			<tr class="x">
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">积分余额</label>
						<div class="layui-input-inline">
							<input type="text" id="rjf" lay-verify="required"
								placeholder="请输入会员姓名" autocomplete="off" class="layui-input" disabled="disabled">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">礼品信息</label>
						<div class="layui-input-inline">
							<select name="nid" id="nid" lay-filter="aihao" >
							</select>
						</div>
					</div>
				</td>
			</tr>
			<tr class="o">
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">所需积分</label>
						<div class="layui-input-inline">
							<input type="text" id="njf" lay-verify="required"
								placeholder="请输入所需积分" autocomplete="off" class="layui-input" disabled="disabled">
						</div>
					</div>
				</td>
			</tr>
			<tr class="o">
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">剩余数量</label>
						<div class="layui-input-inline">
							<input type="text" id="nncount" lay-verify="required"
								placeholder="请输入消费金额" autocomplete="off" class="layui-input" disabled="disabled">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">兑换数量</label>
						<div class="layui-input-inline">
							<input type="text" id="hcount" lay-verify="required"
								placeholder="请输入兑换数量" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">剩余积分</label>
						<div class="layui-input-inline">
							<input type="text" id="jf" lay-verify="required"
								placeholder="请输入剩余积分" autocomplete="off" class="layui-input" disabled="disabled">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
