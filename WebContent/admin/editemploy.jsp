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
<script type="text/javascript" src="js/employ.js" charset="utf-8"></script>
<script type="text/javascript" src="js/selimage.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div class="panel admin-panel" style="width: 75%; margin: 0 auto;">
		<div class="panel-head" id="add">
			<strong><span class="icon-edit"></span>编辑员工信息</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="employ/updateEmploy.action" name="myform">

				<div class="form-group">
					<div class="label">
						<label>用户名</label>
					</div>
					<div class="field">
						<input type="text" name="username" class="input w150" id="username" value="${employ.username}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>员工姓名</label>
					</div>
					<div class="field">
						<input type="text" name="employname" class="input w150" id="employname" value="${employ.employname}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>性别</label>
					</div>
					<div class="field" style="padding-top: 8px;">
						<input type="radio" name="sex" value="男" title="男" ${employ.sex == "男"?"checked":""}>男 &nbsp;&nbsp;&nbsp;&nbsp;<input
							type="radio" name="sex" value="女" title="女" ${employ.sex == "女"?"checked":""}>女
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>出生日期</label>
					</div>
					<div class="field">
						<input type="text" name="birthday" class="input w150" id="birthday" value="${employ.birthday}" onclick="WdatePicker()"
							readonly="readonly" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>所在部门</label>
					</div>
					<div class="field">
						<select name="deptid" class="input w150" id="deptid"><c:forEach items="${deptList}" var="dept">
								<option value="${dept.deptid}" ${dept.deptid == employ.deptid?"selected":"" }>${dept.deptname }</option>
							</c:forEach></select>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>联系方式</label>
					</div>
					<div class="field">
						<input type="text" name="contact" class="input w150" id="contact" value="${employ.contact}" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>角色</label>
					</div>
					<div class="field" style="padding-top: 8px;">
						<input type="radio" name="role" value="普通员工" title="普通员工" ${employ.role == "普通员工"?"checked":""}>普通员工 &nbsp;&nbsp;&nbsp;&nbsp;<input
							type="radio" name="role" value="部门管理" title="部门管理" ${employ.role == "部门管理"?"checked":""}>部门管理
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>备注</label>
					</div>
					<div class="field">
						<input type="text" name="memo" class="input w150" id="memo" value="${employ.memo}" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label><input type="hidden" id="basepath" value="<%=basePath%>" /></label>
					</div>
					<div class="field">
						<input type="hidden" name="employid" id="employid" value="${employ.employid}" /><input type="hidden" name="password" id="password"
							value="${employ.password}" /> <input type="hidden" name="addtime" id="addtime" value="${employ.addtime}" />

						<button class="button bg-main icon-check-square-o" type="submit">提交保存</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>




