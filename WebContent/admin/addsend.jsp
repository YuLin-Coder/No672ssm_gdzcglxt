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
<script type="text/javascript" src="js/send.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div class="panel admin-panel" style="width: 75%; margin: 0 auto;">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>新增资产发放信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="send/addSend.action" name="myform">

				<div class="form-group">
					<div class="label">
						<label>接收人</label>
					</div>
					<div class="field">
						<select name="employid" class="input w150" id="employid"><option value="">---请选择接收人--</option>
							<c:forEach items="${employList}" var="employ">
								<option value="${employ.employid}">${employ.employname }</option>
							</c:forEach></select>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>接收数量</label>
					</div>
					<div class="field">
						<input type="text" name="num" class="input w150" id="num" placeholder="请输入接收数量" value="${buy.num }" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>备注</label>
					</div>
					<div class="field">
						<input type="text" name="memo" class="input w150" id="memo" placeholder="请输入备注" />
					</div>
				</div>


				<div class="form-group">
					<div class="label">
						<label><input type="hidden" id="basepath" value="<%=basePath%>" /><input type="hidden" name="buyid" id="buyid"
							value="${buy.buyid }" /></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit">提交保存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>




