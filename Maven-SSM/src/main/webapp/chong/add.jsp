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
	src="${pageContext.request.contextPath }/js/chong/add.js"></script>
	<style type="text/css">
	#tab{
		width: 80%;
		height:20px;
		margin: 0 auto;
	}
	/* #tab tr{
		height: 30px;
		line-height: 30px;
	}
	
	#i tr{
		height: 30px;
		line-height: 30px;
	} */
	</style>
</head>
<body>
	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">

	<form class="layui-form layui-form-pane" action="#">
		<table  style="margin-top: 40px;margin-left: 10%;">
			<tr>
				<td>
				<div class="layui-form-item">
				<label class="layui-form-label">请输入会员卡号</label>
					<div class="layui-input-inline">
						<input type="text"  lay-verify="required"
							placeholder="请输入会员卡号" autocomplete="off" class="layui-input" id="rcard">
					</div>
				</div>	
					</td>
				<td style="padding-left: 80px;">
				<div class="layui-form-item">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				</div>	
				</td>
			</tr>
		</table>
	</form>

	<table align="center" class="layui-table" id="tab" style="margin-top: 10px">
		<tr>
			<td>会员编号</td>
			<td>
				<div id="rrid"></div>
			</td>
			<td>会员卡号</td>
			<td>
				<div id="rrcard"></div>
			</td>
			<td>会员名称</td>
			<td>
				<div id="rname"></div>
			</td>
			<td rowspan="2">会员图片</td>
			<td rowspan="2">
				<div id="">
					<img alt="" src="" id="img" width="100px;" height="40px;">
				</div>
			</td>
			
		</tr>



		<tr>
		<td>会员密码</td>
			<td>
				<div id="rpsw"></div>
			</td>
			
			<td>会员电话</td>
			<td>
				<div id="rtel"></div>
			</td>
			<td>会员性别</td>
			<td>
				<div id="sex"></div>
			</td>
			
		</tr>
		<tr>
		<td>会员等级</td>
			<td>
				<div id="dname"></div>
			</td>
			<td>会员生日</td>
			<td>
				<div id="rbirthday"></div>
			</td>
			<td>卡状态</td>
			<td>
				<div id="status"></div>
			</td>
			<td>卡积分</td>
			<td>
				<div id="rjf"></div>
			</td>
		</tr>
			
		<tr>
		
			<td>车牌号</td>
			<td>
				<div id="rcarnum"></div>
			</td>
			<td>汽车系列</td>
			<td>
				<div id="xname"></div>
			</td>
			<td>汽车颜色</td>
			<td>
				<div id="rcolor"></div>
			</td>
			<td>行驶里程</td>
			<td>
				<div id="rway"></div>
			</td>
			
		</tr>

		<tr>
		
			<td>凭证</td>
			<td>
				<div id="zname"></div>
			</td>
			<td>证件编号</td>
			<td>
				<div id="rnum"></div>
			</td>
			<td>地址</td>
			<td>
				<div id="raddress"></div>
			</td>
			<td>备注</td>
			<td>
				<div id="rremark"></div>
			</td>
		</tr>
		<tr>
		
			<td colspan="2">开通时间</td>
			<td colspan="2">
				<div id="rtime"></div>
			</td>
			<td colspan="2">余额</td>
			<td colspan="2">
				<div id="rmoney"></div>
			</td>
		</tr>
	</table>


<form class="layui-form layui-form-pane" action="#">
	<table style="margin-top: 10px;margin-left: 10%;" id="i">
		<tr>
			<td>
			<div class="layui-form-item">
				<label class="layui-form-label">会员卡号</label>
					<div class="layui-input-inline">
						<input type="text"  lay-verify="required"
							placeholder="请输入会员卡号" autocomplete="off" class="layui-input" id="xrcard" disabled="disabled">
					</div>
					</div>
			</td>
			<td style="padding-left: 80px;">
			<div class="layui-form-item">
				<label class="layui-form-label">优惠活动：</label>
						<div class="layui-input-inline">
							<select name="interest"  id="yid" lay-filter="aihao">
								
							</select>
						</div>
</div>
			</td>
		</tr>
		<tr>
			<td>
			<div class="layui-form-item">
				<label class="layui-form-label">充值金额</label>
					<div class="layui-input-inline">
						<input type="text"  lay-verify="required|number"
							placeholder="请输入会员卡号" autocomplete="off" class="layui-input" id="omoney">
					</div>
					</div>
			</td>
			<td style="padding-left: 80px;">
			<div class="layui-form-item">
				<label class="layui-form-label">起始金额</label>
					<div class="layui-input-inline">
						<input type="text"  lay-verify="required|number"
							placeholder="请输入起始金额" autocomplete="off" class="layui-input" id="ylessmoney" disabled="disabled">
					</div>
					</div>
			</td>
		</tr>
		<tr>
			<td>
			<div class="layui-form-item">
				<label class="layui-form-label">最终金额</label>
					<div class="layui-input-inline">
						<input type="text"  lay-verify="required|number"
							placeholder="请输入最终金额" autocomplete="off" class="layui-input" id="olastmoney">
					</div>
					</div>
			</td>
			<td style="padding-left: 80px;">
			<div class="layui-form-item">
				<label class="layui-form-label">优惠金额</label>
					<div class="layui-input-inline">
						<input type="text"  lay-verify="required"
							placeholder="请输入优惠金额" autocomplete="off" class="layui-input" id="ymoney" disabled="disabled">
					</div>
					</div>
			</td>
		</tr>
		<tr  style="margin-top: 10px;">
			<td colspan="2">
			<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入备注" class="layui-textarea" id="oremark"></textarea>
    </div>
  </div>
			</td>
		</tr>
		<tr>
			<td>
				<div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo2">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
			</td>
		</tr>
	</table>
</form>

</body>
</html>