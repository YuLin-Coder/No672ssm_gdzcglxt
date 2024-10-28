<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用后台管理系统</title>
<link rel="stylesheet" href="asset/css/pintuer.css">
<link rel="stylesheet" href="asset/css/admin.css">
<script src="asset/js/jquery.js"></script>
<script src="asset/js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-reorder">设备借用信息列表</strong>
		</div>
		<table class="table table-hover text-center">

			<thead>
				<tr>
					<th>借用单号</th>
					<th>借用人</th>
					<th>部门</th>
					<th>设备</th>
					<th>借用原因</th>
					<th>状态</th>
					<th>日期</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${lendList}" var="lend">
				<tr>
					<td>${lend.lno}</td>
					<td>${lend.employname}</td>
					<td>${lend.deptname}</td>
					<td>${lend.equipmentname}</td>
					<td>${lend.reason}</td>
					<td>${lend.status}</td>
					<td>${lend.addtime}</td>
					<td>${lend.memo}</td>
					<td><c:if test="${lend.status eq '通过审核'}">
							<a href="back/addBack.action?id=${lend.lendid}" title="确认归还">确认归还</a>
						</c:if></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8"><div class="pagelist">${html }</div></td>
			</tr>
		</table>
	</div>
</body>
</html>

