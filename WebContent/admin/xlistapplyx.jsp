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
			<strong class="icon-reorder">采购申请信息列表</strong>
		</div>
		<table class="table table-hover text-center">

			<thead>
				<tr>
					<th>申请单号</th>
					<th>申请人</th>
					<th>部门</th>
					<th>资产类型</th>
					<th>设备名称</th>
					<th>申请原因</th>
					<th>采购数量</th>
					<th>申请日期</th>
					<th>状态</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${applyxList}" var="applyx">
				<tr>
					<td>${applyx.ano}</td>
					<td>${applyx.employname}</td>
					<td>${applyx.deptname}</td>
					<td>${applyx.catename}</td>
					<td>${applyx.equipmentname}</td>
					<td>${applyx.reason}</td>
					<td>${applyx.num}</td>
					<td>${applyx.addtime}</td>
					<td>${applyx.status}</td>
					<td>${applyx.memo}</td>
					<td><c:if test="${applyx.status eq '待审核'}">
							<a href="applyx/status.action?id=${applyx.applyxid}" title="通过审核">通过审核</a>&nbsp;&nbsp;
					<a href="applyx/getApplyxById.action?id=${applyx.applyxid}" title="编辑">编辑</a>
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

