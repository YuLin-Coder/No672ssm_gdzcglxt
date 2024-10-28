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
			<strong class="icon-search">部门信息查询</strong>
		</div>
		<table class="table table-hover text-center">

			<thead>
				<tr>
					<th>部门名称</th>
					<th>负责人</th>
					<th>联系方式</th>
					<th>创建日期</th>
					<th>备注</th>
				</tr>
			</thead>
			<c:forEach items="${deptList}" var="dept">
				<tr>
					<td>${dept.deptname}</td>
					<td>${dept.manager}</td>
					<td>${dept.contact}</td>
					<td>${dept.addtime}</td>
					<td>${dept.memo}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><div class="pagelist">
						<form action="dept/queryDeptByCond.action" name="myform" method="post">
							<label>查询条件: <select name="cond" class="select" style="width: 150px; line-height: 17px; display: inline-block">
									<option value="deptname">按部门名称查询</option>
									<option value="manager">按负责人查询</option>
									<option value="contact">按联系方式查询</option>
									<option value="addtime">按创建日期查询</option>
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
