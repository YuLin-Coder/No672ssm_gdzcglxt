<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="leftnav">
	<div class="leftnav-title">
		<strong><span class="icon-list"></span>部门管理菜单</strong>
	</div>
	<h2>
<%--		<span class="icon-user"></span>工作人员管理--%>
		<span ></span>工作人员管理

	</h2>
	<ul>
<%--		<li><a href="employ/getDeptEmploy.action" target="main"><span class="icon-reorder"></span>部门工作人员信息</a></li>--%>
	<li><a href="employ/getDeptEmploy.action" target="main"><span class="icon-reorder"></span>部门工作人员信息</a></li>
	<li><a href="employ/userinfo.action" target="main"><span class="icon-reorder"></span>个人信息</a></li>
	<li><a href="employ/prePwd.action" target="main"><span class="icon-reorder"></span>修改密码</a></li>
	</ul>

	<h2>
		<span ></span>基础管理
	</h2>
	<ul>
<%--		<li><a href="dept/queryDeptByCond.action" target="main"><span class="icon-search"></span>查询部门信息</a></li>--%>
		<li><a href="cate/queryCateByCond.action" target="main"><span class="icon-search"></span>资产类型信息查询</a></li>
	</ul>

	<h2>
		<span ></span>采购申请管理
	</h2>
	<ul>
		<li><a href="applyx/getDeptApplyx.action" target="main"><span class="icon-reorder"></span>服务器申请</a></li>
	</ul>

	<h2>
		<span ></span>资产发放管理
	</h2>
	<ul>
		<li><a href="send/getDeptSend.action" target="main"><span class="icon-reorder"></span>部门资产发放信息</a></li>
		<li><a href="send/getMySend.action" target="main"><span class="icon-reorder"></span>我的资产发放信息</a></li>
	</ul>

	<h2>
		<span ></span>固定资产管理
	</h2>
	<ul>
		<li><a href="equipment/getDeptEquipment.action" target="main"><span class="icon-reorder"></span>部门固定资产信息</a></li>
		<li><a href="repair/createRepair.action" target="main"><span class="icon-pencil-square-o"></span>新增资产维修信息</a></li>
<%--		<li><a href="repair/getDeptRepair.action" target="main"><span class="icon-reorder"></span>部门维护维修信息</a></li>--%>
<%--		<li><a href="repair/getMyRepair.action" target="main"><span class="icon-reorder"></span>我的维护维修信息</a></li>--%>
		<li><a href="scarp/createScarp.action" target="main"><span class="icon-pencil-square-o"></span>新增资产报废信息</a></li>
<%--		<li><a href="scarp/getDeptScarp.action" target="main"><span class="icon-reorder"></span>部门资产报废信息</a></li>--%>
<%--		<li><a href="scarp/getMyScarp.action" target="main"><span class="icon-reorder"></span>我的资产报废信息</a></li>--%>
	</ul>

<%--	<h2>--%>
<%--		<span ></span>设备借用归还管理--%>
<%--	</h2>--%>
<%--	<ul>--%>
<%--		<li><a href="lend/createLend.action" target="main"><span class="icon-pencil-square-o"></span>新增设备借用信息</a></li>--%>
<%--		<li><a href="lend/getDeptLend.action" target="main"><span class="icon-reorder"></span>部门设备借用信息</a></li>--%>
<%--		<li><a href="lend/getMyLend.action" target="main"><span class="icon-reorder"></span>我的设备借用信息</a></li>--%>
<%--		<li><a href="back/getDeptBack.action" target="main"><span class="icon-reorder"></span>部门借用归还信息</a></li>--%>
<%--		<li><a href="back/getMyBack.action" target="main"><span class="icon-reorder"></span>我的借用归还信息</a></li>--%>
<%--	</ul>--%>

<%--	<h2>--%>
<%--		<span class="icon-user"></span>盘点管理--%>
<%--	</h2>--%>
<%--	<ul>--%>
<%--		<li><a href="pwin/createPwin.action" target="main"><span class="icon-pencil-square-o"></span>新增盘盈信息</a></li>--%>
<%--		<li><a href="pwin/getMyPwin.action" target="main"><span class="icon-reorder"></span>我的盘盈信息</a></li>--%>
<%--		<li><a href="pwin/getDeptPwin.action" target="main"><span class="icon-reorder"></span>部门盘盈信息</a></li>--%>
<%--		<li><a href="plost/createPlost.action" target="main"><span class="icon-pencil-square-o"></span>新增盘亏信息</a></li>--%>
<%--		<li><a href="plost/getMyPlost.action" target="main"><span class="icon-reorder"></span>我的盘亏信息</a></li>--%>
<%--		<li><a href="plost/getDeptPlost.action" target="main"><span class="icon-reorder"></span>部门盘亏信息</a></li>--%>
<%--	</ul>--%>

</div>



