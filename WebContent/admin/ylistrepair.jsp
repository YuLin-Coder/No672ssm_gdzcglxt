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
			<strong class="icon-reorder">资产发放信息列表</strong>
		</div>
		<table class="table table-hover text-center">

			<thead>
				<tr>
					<th>维修批次</th>
					<th>维修设备</th>
					<th>申请维修人</th>
					<th>维修原因</th>
					<th>维修花费</th>
					<th>维修时间</th>
					<th>备注</th>
				</tr>
			</thead>
			<c:forEach items="${repairList}" var="repair">
				<tr>
					<td>${repair.repairid}</td>
					<td>${repair.equipmentname}</td>
					<td>${repair.employname}</td>
					<td>${repair.reason}</td>
					<td>${repair.cost}</td>
					<td>${repair.addtime}</td>
					<td>${repair.memo}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8"><div class="pagelist">${html }</div></td>
			</tr>
		</table>
	</div>
</body>
</html>
