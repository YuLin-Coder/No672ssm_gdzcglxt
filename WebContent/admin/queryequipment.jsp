<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="check_logstate.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用网站后台管理系统</title>
<link rel="stylesheet" href="asset/css/pintuer.css">
<link rel="stylesheet" href="asset/css/admin.css">
<script src="asset/js/jquery.js"></script>
<script src="asset/js/pintuer.js"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-search">固定资产信息查询</strong>
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
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8"><div class="pagelist">
						<form action="equipment/queryEquipmentByCond.action" name="myform" method="post">
							<label>查询条件: <select name="cond" class="select" style="width: 150px; line-height: 17px; display: inline-block">
									<option value="eno">按资产编号查询</option>
									<option value="equipmentname">按资产名称查询</option>
									<option value="applyxid">按采购批次查询</option>
									<option value="deptid">按所在部门查询</option>
									<option value="cateid">按资产类型查询</option>
									<option value="addtime">按创建日期查询</option>
									<option value="status">按状态查询</option>
									<option value="memo">按备注查询</option>
							</select>
							</label>&nbsp;&nbsp;&nbsp; <label>关键字: <input type="text" name="name" required style="width: 100px" /></label>&nbsp;&nbsp;&nbsp; <label><input
								type="submit" value="查询" class="button border-main " /> </label>${html }
						</form>
					</div></td>
			</tr>
		</table>
	</div>
</body>
</html>

