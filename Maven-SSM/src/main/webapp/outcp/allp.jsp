<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/outcp/allp.js"></script>
<style type="text/css">
</style>
</head>
<body>

	<input type="hidden" id="path" value="${pageContext.request.contextPath }/">
	<!-- 总金额 -->
	<input type="hidden" id="pr" value="<%=session.getAttribute("pr")%>">
	<input type="hidden" id="rcard" value="<%=session.getAttribute("rcard")%>">
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
    			
    		</tr>
    	</c:forEach>
    </table>
    <table align="center" >
    	<tr>
    		<td>
    			 <form class="layui-form"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
					<table>
						<tr>
							<td>
								 <div class="layui-form-item">
									    <div class="layui-input-inline">
									      <button class="layui-btn" lay-submit lay-filter="test">立即提交</button>
									    </div>
									  </div>
									  <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
							</td>
						</tr>
						<tr>
							<td>
								总计:${oor},你是本店的${dname}享有${d}折。本次实际消费${pr}
							</td>
						</tr>
					</table>	
					</form>	
    		</td>
    	</tr>
    </table>
  </div>
</body>
</html>