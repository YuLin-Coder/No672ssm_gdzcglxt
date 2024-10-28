<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="leftnav">
	<div class="leftnav-title">
		<strong><span class="icon-list"></span>员工菜单</strong>
	</div>

	<h2>
		<span class="icon-user"></span>个人信息
	</h2>
	<ul>
		<li><a href="employ/userinfo.action" target="main"><span class="icon-pencil-square-o"></span>个人信息</a></li>
		<li><a href="employ/prePwd.action" target="main"><span class="icon-reorder"></span>修改密码</a></li>
	</ul>

	<h2>
		<span class="icon-user"></span>资产类型信息
	</h2>
	<ul>
		<li><a href="cate/queryCateByCond.action" target="main"><span class="icon-search"></span>查询资产类型信息</a></li>
	</ul>

	<h2>
		<span class="icon-user"></span>采购申请信息
	</h2>
	<ul>
		<li><a href="applyx/createApplyx.action" target="main"><span class="icon-pencil-square-o"></span>新增采购申请信息</a></li>
		<li><a href="applyx/getMyApplyx.action" target="main"><span class="icon-reorder"></span>我的采购申请列表</a></li>
	</ul>
	<h2>
		<span class="icon-user"></span>资产接收信息
	</h2>
	<ul>
		<li><a href="send/getMySend.action" target="main"><span class="icon-reorder"></span>我的资产接收列表</a></li>
	</ul>
	<h2>
		<span class="icon-user"></span>固定资产信息
	</h2>
	<ul>
		<li><a href="repair/createRepair.action" target="main"><span class="icon-pencil-square-o"></span>新增资产维修信息</a></li>
		<li><a href="repair/getMyRepair.action" target="main"><span class="icon-reorder"></span>我的资产维修列表</a></li>
		<li><a href="scarp/createScarp.action" target="main"><span class="icon-pencil-square-o"></span>新增资产报废信息</a></li>
		<li><a href="scarp/getMyScarp.action" target="main"><span class="icon-reorder"></span>我的资产报废列表</a></li>
	</ul>

<%--	<h2>--%>
<%--		<span class="icon-user"></span>设备借用归还信息--%>
<%--	</h2>--%>
<%--	<ul>--%>
<%--		<li><a href="lend/createLend.action" target="main"><span class="icon-pencil-square-o"></span>新增设备借用信息</a></li>--%>
<%--		<li><a href="lend/getMyLend.action" target="main"><span class="icon-reorder"></span>我的设备借用列表</a></li>--%>
<%--		<li><a href="back/getMyBack.action" target="main"><span class="icon-reorder"></span>我的借用归还列表</a></li>--%>
<%--	</ul>--%>

<%--	<h2>--%>
<%--		<span class="icon-user"></span>盘点信息--%>
<%--	</h2>--%>
<%--	<ul>--%>
<%--		<li><a href="pwin/createPwin.action" target="main"><span class="icon-pencil-square-o"></span>新增盘盈信息</a></li>--%>
<%--		<li><a href="pwin/getMyPwin.action" target="main"><span class="icon-reorder"></span>我的盘盈列表</a></li>--%>
<%--		<li><a href="plost/createPlost.action" target="main"><span class="icon-pencil-square-o"></span>新增盘亏信息</a></li>--%>
<%--		<li><a href="plost/getMyPlost.action" target="main"><span class="icon-reorder"></span>我的盘亏列表</a></li>--%>
<%--	</ul>--%>

</div>



