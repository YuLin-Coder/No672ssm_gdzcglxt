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
			<strong class="icon-reorder">固定资产信息列表</strong>
		</div>
		<table class="table table-hover text-center">

			<thead>
				<tr>
					<th>资产编号</th>
					<th>资产名称</th>
					<th>采购批次</th>
					<th>所在部门</th>
					<th>资产类型</th>
					<th>创建日期</th>
					<th>状态</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${equipmentList}" var="equipment">
				<tr>
					<td>${equipment.eno}</td>
					<td>${equipment.equipmentname}</td>
					<td>${equipment.ano}</td>
					<td>${equipment.deptname}</td>
					<td>${equipment.catename}</td>
					<td>${equipment.addtime}</td>
					<td>${equipment.status}</td>
					<td>${equipment.memo}</td>
					<td><a href="equipment/getEquipmentById.action?id=${equipment.equipmentid}"><span class="icon-edit"></span>编辑</a>&nbsp;&nbsp;<a
						href="equipment/deleteEquipment.action?id=${equipment.equipmentid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><span
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

