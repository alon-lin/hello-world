<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.4.0.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/layui/layui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/outcp/add.js"></script>
<style type="text/css">
#tab {
	/* width: 80%;
	height: 20px; */
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
#t {
	margin-top: 20px;
}
</style>
</head>
<body>
	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
	<input type="hidden" id="rid" value="<%=request.getParameter("rid")%>">
	<input type="hidden" id="ca" value="<%=session.getAttribute("rcard")%>">
	<input type="hidden" id="x" value="<%=request.getParameter("x")%>">

	<form class="layui-form layui-form-pane" action="#">
		<div class="layui-card">
			<div class="layui-card-header">查询条件</div>
			<div class="layui-card-body">
				<table>
					<tr>
						<td>
							<div class="layui-form-item">
								<label class="layui-form-label">请输入会员卡号</label>
								<div class="layui-input-inline">
									<input type="text" lay-verify="required" placeholder="请输入会员卡号"
										autocomplete="off" class="layui-input" id="rcard">
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
				<table align="center" class="layui-table" id="tab"
					style="margin-top: 10px">
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
			</div>
		</div>

	</form>




	
	
	<div class="layui-card">
  <div class="layui-card-header">
  	<form class="layui-form layui-form-pane" action="#">
		<table id="t">
			<tr>
				<td>
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<button class="layui-btn" lay-submit="" lay-filter="demo2">
								<i class="layui-icon layui-icon-cart"
									style="font-size: 20px; color: #1E9FFF;"></i>购买商品
							</button>
						</div>
						<div class="layui-input-inline">
							<button class="layui-btn" lay-submit="" lay-filter="demo3">
								<i class="layui-icon layui-icon-ok"
									style="font-size: 20px; color: #1E9FFF;"></i>结账
							</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</form>
  </div>
  <div class="layui-card-body">
    <table class="layui-table" id="p">
    		<tr>
    			<td>编号</td>
    			<td>产品编号</td>
    			<td>产品类别</td>
    			<td>产品名称</td>
    			<td>产品售价</td>
    			<td>折扣价</td>
    			<td>产品数量</td>
    			<td>小计</td>
    			<td>删除</td>
    		</tr>
    	<c:forEach items="${sessionScope.arr}" var="item">
    		<tr>
    			<td>${item.id}</td>
    			<td>${item.fid}</td>
    			<td>${item.cname}</td>
    			<td>${item.fname}</td>
    			<td>${item.foutprice}</td>
    			<td>${item.price}</td>
    			<td>${item.count}</td>
    			<td>${item.allPrice}</td>
    			<td>
    				<a class="layui-btn" href="${pageContext.request.contextPath }/outcp.do?method=del&id=${item.id}">删除</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
  </div>
</div>

</body>
</html>