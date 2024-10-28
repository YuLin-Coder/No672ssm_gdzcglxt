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
			<strong class="icon-reorder">资产采购信息列表</strong>
		</div>
		<table class="table table-hover text-center">

			<thead>
				<tr>
					<th>采购单号</th>
					<th>设备类型</th>
					<th>资产名称</th>
					<th>采购单价</th>
					<th>采购数量</th>
					<th>总计金额</th>
					<th>供应商</th>
					<th>发放数量</th>
					<th>采购日期</th>
					<th>备注</th>
					<th>操作</th>
				</tr>
			</thead>
			<c:forEach items="${buyList}" var="buy">
				<tr>
					<td>${buy.ano}</td>
					<td>${buy.catename}</td>
					<td>${buy.equipmentname}</td>
					<td>${buy.price}</td>
					<td>${buy.num}</td>
					<td>${buy.total}</td>
					<td>${buy.supplier}</td>
					<td>${buy.sendnum}</td>
					<td>${buy.addtime}</td>
					<td>${buy.memo}</td>
					<td><c:if test="${buy.sendnum ne buy.num }">
							<a href="send/createSend.action?id=${buy.buyid}" title="发放物资">发放物资</a>&nbsp;&nbsp;
						</c:if><a href="buy/deleteBuy.action?id=${buy.buyid}" onclick="{if(confirm('确定要删除吗?')){return true;}return false;}"><span
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

