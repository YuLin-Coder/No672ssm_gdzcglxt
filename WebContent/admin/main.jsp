<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%><!doctype html>
<html lang="zh_CN">
<head>
<base href="<%=basePath%>" />
<title>欢迎使用固定资产管理系统</title>
<link rel="stylesheet" href="asset/css/pintuer.css">
<link rel="stylesheet" href="asset/css/admin.css">
<script src="asset/js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">
			<h1>固定资产管理系统</h1>
		</div>
		<div class="head-l">
			<font color="#FFFFFF">您好，${sessionScope.realname }&nbsp; ${sessionScope.role }</font> &nbsp;&nbsp; 
			<a class="button button-little bg-red"
				href="admin/exit.action"><span class="icon-power-off"></span>退出登录</a>
		</div>
	</div>
	<%
		String role = (String) session.getAttribute("role");
		if ("管理员".equals(role)) {
	%>
	<jsp:include page="menu.jsp"></jsp:include>
	<%
		} else if ("部门管理".equals(role)) {
	%>
	<jsp:include page="menu1.jsp"></jsp:include>
	<%
		} else {
	%>
	<jsp:include page="menu2.jsp"></jsp:include>
	<%
		}
	%>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="javascript:;" target="right" class="icon-home"> 首页</a></li>
		<li><a href="javascript:;" id="a_leader_txt"></a></li>
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="" name="main" width="100%" height="100%"></iframe>
	</div>
</body>
</html>