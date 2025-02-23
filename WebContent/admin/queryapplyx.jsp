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
			<strong class="icon-search">采购申请信息查询</strong>
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
				</tr>
			</c:forEach>
			<tr>
				<td colspan="10"><div class="pagelist">
						<form action="applyx/queryApplyxByCond.action" name="myform" method="post">
							<label>查询条件: <select name="cond" class="select" style="width: 150px; line-height: 17px; display: inline-block">
									<option value="ano">按申请单号查询</option>
									<option value="employid">按申请人查询</option>
									<option value="deptid">按部门查询</option>
									<option value="cateid">按资产类型查询</option>
									<option value="equipmentname">按设备名称查询</option>
									<option value="reason">按申请原因查询</option>
									<option value="num">按采购数量查询</option>
									<option value="addtime">按申请日期查询</option>
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

