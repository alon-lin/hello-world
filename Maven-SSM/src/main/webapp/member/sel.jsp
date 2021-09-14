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
	src="${pageContext.request.contextPath }/js/member/sel.js"></script>
<style type="text/css">
#tab{
		width: 80%;
		height:20px;
		margin: 0 auto;
	}
	</style>
</head>

<body>

	<input type="hidden" id="path"
		value="${pageContext.request.contextPath }/">
		<input type="hidden" id="rid"
		value="<%=request.getParameter("rid")%>">
	
	<table  class="layui-table" id="tab">
		<tr>
			<td>
				会员编号
			</td>
			<td>
				<div id="rrid"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				会员卡号
			</td>
			<td>
				<div id="rcard"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				会员名称
			</td>
			<td>
				<div id="rname"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				会员密码
			</td>
			<td>
				<div id="rpsw"></div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				会员图片
			</td>
			<td>
				<div id=""><img alt="" src="" id="img" width="100px;" height="40px;"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				会员电话
			</td>
			<td>
				<div id="rtel"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				会员性别
			</td>
			<td>
				<div id="sex"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				会员等级
			</td>
			<td>
				<div id="dname"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				会员生日
			</td>
			<td>
				<div id="rbirthday"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				卡状态
			</td>
			<td>
				<div id="status"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				卡积分
			</td>
			<td>
				<div id="rjf"></div>
			</td>
		</tr>
		
		
			<tr>
			<td>
				车牌号
			</td>
			<td>
				<div id="rcarnum"></div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				汽车系列
			</td>
			<td>
				<div id="xname"></div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				汽车颜色
			</td>
			<td>
				<div id="rcolor"></div>
			</td>
		</tr>
		
			
		<tr>
			<td>
				行驶里程
			</td>
			<td>
				<div id="rway"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				凭证
			</td>
			<td>
				<div id="zname"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				证件编号
			</td>
			<td>
				<div id="rnum"></div>
			</td>
		</tr>
		
		<tr>
			<td>
				地址
			</td>
			<td>
				<div id="raddress"></div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				备注
			</td>
			<td>
				<div id="rremark"></div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				开通时间
			</td>
			<td>
				<div id="rtime"></div>
			</td>
		</tr>
		
		
		<tr>
			<td>
				余额
			</td>
			<td>
				<div id="rmoney"></div>
			</td>
		</tr>
		
		
		
		
		
		
		
		
		
		
		
		
	</table>

	

</body>
</html>
