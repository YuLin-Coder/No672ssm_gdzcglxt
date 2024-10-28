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
<script type="text/javascript" src="js/scarp.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div class="panel admin-panel" style="width: 75%; margin: 0 auto;">
		<div class="panel-head" id="add">
			<strong><span class="icon-edit"></span>编辑资产报废信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="scarp/updateScarp.action" name="myform">

				<div class="form-group">
					<div class="label">
						<label>资产</label>
					</div>
					<div class="field">
						<select name="equipmentid" class="input w150" id="equipmentid"><c:forEach items="${equipmentList}" var="equipment">
								<option value="${equipment.equipmentid}" ${equipment.equipmentid == scarp.equipmentid?"selected":"" }>${equipment.equipmentname }</option>
							</c:forEach></select>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>原因</label>
					</div>
					<div class="field">
						<input type="text" name="reason" class="input w150" id="reason" value="${scarp.reason}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>备注</label>
					</div>
					<div class="field">
						<input type="text" name="memo" class="input w150" id="memo" value="${scarp.memo}" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label><input type="hidden" id="basepath" value="<%=basePath%>" /></label>
					</div>
					<div class="field">
						<input type="hidden" name="scarpid" id="scarpid" value="${scarp.scarpid}" /><input type="hidden" name="deptid" id="deptid"
							value="${scarp.deptid}" /> <input type="hidden" name="employid" id="employid" value="${scarp.employid}" /> <input type="hidden"
							name="addtime" id="addtime" value="${scarp.addtime}" />

						<button class="button bg-main icon-check-square-o" type="submit">提交保存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>



