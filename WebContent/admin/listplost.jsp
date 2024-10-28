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
			<strong class="icon-reorder">盘亏信息列表</strong>
		</div>
		<table class="table table-hover text-center">

			<thead>
				<tr>
					<th>单号</th>
					<th>部门</th>
					<th>设备</th>
					<th>原因</th>
					<th>损失</th>
					<th>经手人</th>
					<th>日期</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${plostList}" var="plost">
				<tr>
					<td>${plost.pno}</td>
					<td>${plost.deptname}</td>
					<td>${plost.equipmentname}</td>
					<td>${plost.reason}</td>
					<td>${plost.lost}</td>
					<td>${plost.employname}</td>
					<td>${plost.addtime}</td>
					<td>${plost.memo}</td>
					<td><a href="plost/deletePlost.action?id=${plost.plostid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><span
							class="icon-trash-o"></span>删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8"><div class="pagelist">${html }</div></td>
			</tr>
		</table>
	</div>
</body>
</html>

