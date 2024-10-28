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
<script src="echart/echarts.min.js" charset="UTF-8"></script>
<script src="echart/chartwin.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js" charset="utf-8"></script>
</head>
<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong class="icon-search">盘盈统计</strong>
		</div>
		<table class="table table-hover text-center">
			<tr>
				<td><div class="text-center" id="chartmain" style="width: 100%; height: 500px;"></div></td>
			</tr>
			<tr>
				<td>
					<form>
						<label><input type="text" name="start" style="width: 120px" id="start" onclick="WdatePicker()" readonly="readonly"
							placeholder="请输入开始日期" /> </label>&nbsp;&nbsp;&nbsp; <label><input type="text" name="end" style="width: 120px" id="end"
							onclick="WdatePicker()" readonly="readonly" placeholder="请输入结束日期" /></label>&nbsp;&nbsp;&nbsp; <label> <input type="button"
							name="sub" id="sub" value="统计" /></label><input type="hidden" name="basepath" value="<%=basePath%>">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

