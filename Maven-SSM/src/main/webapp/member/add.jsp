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
	src="${pageContext.request.contextPath }/js/member/add.js"></script>
</head>
<body>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">


	<form class="layui-form layui-form-pane"  method="post">
		<table align="center" style="margin-top: 20px;">
			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员卡号：</label>
						<div class="layui-input-inline">
							<input type="text" name="rcard" id="rcard" lay-verify="required"
								placeholder="请输入会员卡号" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员姓名：</label>
						<div class="layui-input-inline">
							<input type="text" name="rname" id="rname" lay-verify="required"
								placeholder="请输入会员姓名" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>


			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员相片：</label>
						<div class="layui-input-inline">
							<input type="file" name="img" id="img" lay-verify="required"
								placeholder="请上传会员相片" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员手机号：</label>
						<div class="layui-input-inline">
							<input type="text" name="rtel" id="rtel" lay-verify="required"
								placeholder="请输入会员手机号" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>

			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">卡号密码：</label>
						<div class="layui-input-inline">
							<input type="text" name="rpsw" id="rpsw" lay-verify="required"
								placeholder="请输入卡号密码" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员性别：</label>
						<div class="layui-input-inline">
							<select name="interest" id="rsex" name="rsex" lay-filter="aihao">
								<option value="1">男</option>
								<option value="0">女</option>
							</select>
						</div>
					</div>
				</td>
			</tr>

			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员等级：</label>
						<div class="layui-input-inline">
							<select name="interest" name="did" id="did" lay-filter="aihao">
								<option value="0">---请选择会员等级---</option>
							</select>
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">会员生日：</label>
						<div class="layui-input-inline">
							<input type="text" name="rbirthday" id="rbirthday"
								lay-verify="required" placeholder="请输入生日日期" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</td>
			</tr>




			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">卡状态：</label>
						<div class="layui-input-inline">
							<select name="interest" id="rstatus" name="rstatus"
								lay-filter="aihao">
								<option value="1">正常</option>
								<option value="0">破损</option>
							</select>
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">卡余额：</label>
						<div class="layui-input-inline">
							<input type="text" name="rmoney" id="rmoney" value="0"
								disabled="disabled" readonly="readonly" placeholder="请输入卡号密码"
								autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>



			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">卡积分：</label>
						<div class="layui-input-inline">
							<input type="text" name="rjf" id="rjf" value="0"
								disabled="disabled" readonly="readonly" placeholder="请输入卡号密码"
								autocomplete="off" class="layui-input">
						</div>

					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">车牌号：</label>
						<div class="layui-input-inline">
							<input type="text" name="rcarnum" id="rcarnum"
								lay-verify="required" placeholder="请输入车牌号" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</td>
			</tr>





			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">汽车品牌：</label>
						<div class="layui-input-inline">
							<select name="interest" name="aid" id="aid" lay-filter="xilie">
							</select>
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">汽车系列：</label>
						<div class="layui-input-inline">
							<select name="interest" name="xid" id="xid">
							</select>
						</div>
					</div>
				</td>
			</tr>



			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">汽车颜色：</label>
						<div class="layui-input-inline">
							<input type="text" name="rcolor" id="rcolor"
								lay-verify="required" placeholder="请输入汽车颜色" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">行驶里程：</label>
						<div class="layui-input-inline">
							<input type="text" name="rway" id="rway" lay-verify="required"
								placeholder="请输入行驶里程" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>



			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">证件类型：</label>
						<div class="layui-input-inline">
							<select name="interest" name="zid" id="zid" lay-filter="aihao">
								<option value="0" selected="selected">---请选择证件类型---</option>
							</select>
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">证件编号：</label>
						<div class="layui-input-inline">
							<input type="text" name="rnum" id="rnum" lay-verify="required"
								placeholder="请输入证件编号" autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>



			<tr>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">联系地址：</label>
						<div class="layui-input-inline">
							<input type="text" name="raddress" id="raddress"
								lay-verify="required" placeholder="请输入联系地址" autocomplete="off"
								class="layui-input">
						</div>
					</div>
				</td>
				<td>
					<div class="layui-form-item">
						<label class="layui-form-label">开通时间：</label>
						<div class="layui-input-inline">
							<input type="text" name="rtime" id="rtime" lay-verify="required"
								disabled="disabled" readonly="readonly" placeholder="请输入开通时间"
								autocomplete="off" class="layui-input">
						</div>
					</div>
				</td>
			</tr>

			<tr>
				<td colspan="2">
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">文本域</label>
						<div class="layui-input-block">
							<textarea placeholder="请输入内容" class="layui-textarea" id="rremark"></textarea>
						</div>
					</div>
				</td>

			</tr>

			<tr>
				<td colspan="2" align="center">
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
