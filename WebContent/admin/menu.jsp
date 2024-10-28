<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="leftnav">
	<div class="leftnav-title">
		<strong><span class="icon-list"></span>管理菜单</strong>
	</div>

	<h2>
		<span ></span>管理员信息管理
	</h2>
	<ul>
		<li><a href="admin/createAdmin.action" target="main"><span class="icon-pencil-square-o"></span>新增管理员信息</a></li>
		<li><a href="admin/getAllAdmin.action" target="main"><span class="icon-reorder"></span>管理员信息列表</a></li>
		<li><a href="admin/queryAdminByCond.action" target="main"><span class="icon-search"></span>查询管理员信息</a></li>
		<li><a href="admin/prePwd.action" target="main"><span class="icon-search"></span>修改密码</a></li>
	</ul>

	<h2>
		<span ></span>基本信息管理
	</h2>
	<ul>
		<li><a href="dept/createDept.action" target="main"><span class="icon-pencil-square-o"></span>新增部门信息</a></li>
<%--		<li><a href="dept/getAllDept.action" target="main"><span class="icon-reorder"></span>部门信息列表</a></li>--%>
		<li><a href="dept/queryDeptByCond.action" target="main"><span class="icon-search"></span>查询部门信息</a></li>
		<li><a href="cate/createCate.action" target="main"><span class="icon-pencil-square-o"></span>新增资产类型信息</a></li>
		<li><a href="cate/getAllCate.action" target="main"><span class="icon-reorder"></span>资产类型信息列表</a></li>
		<li><a href="cate/queryCateByCond.action" target="main"><span class="icon-search"></span>查询资产类型信息</a></li>
	</ul>

	<h2>
		<span ></span>员工信息管理
	</h2>
	<ul>
		<li><a href="employ/createEmploy.action" target="main"><span class="icon-pencil-square-o"></span>新增员工信息</a></li>
		<li><a href="employ/getAllEmploy.action" target="main"><span class="icon-reorder"></span>员工信息列表</a></li>
		<li><a href="employ/queryEmployByCond.action" target="main"><span class="icon-search"></span>查询员工信息</a></li>
	</ul>

	<h2>
		<span ></span>服务器申请信息
	</h2>
	<ul>
		<li><a href="applyx/getAllApplyx.action" target="main"><span class="icon-reorder"></span>采购申请信息列表</a></li>
		<li><a href="applyx/queryApplyxByCond.action" target="main"><span class="icon-search"></span>查询采购申请信息</a></li>
	</ul>

<%--	<h2>--%>
<%--		<span class="icon-user"></span>资产采购信息管理--%>
<%--	</h2>--%>
<%--	<ul>--%>
<%--		<li><a href="buy/getAllBuy.action" target="main"><span class="icon-reorder"></span>资产采购信息列表</a></li>--%>
<%--		<li><a href="buy/queryBuyByCond.action" target="main"><span class="icon-search"></span>查询资产采购信息</a></li>--%>
<%--	</ul>--%>

	<h2>
		<span ></span>资产发放信息管理
	</h2>
	<ul>
		<li><a href="send/getAllSend.action" target="main"><span class="icon-reorder"></span>资产发放信息列表</a></li>
		<li><a href="send/querySendByCond.action" target="main"><span class="icon-search"></span>查询资产发放信息</a></li>
	</ul>

	<h2>
		<span ></span>固定资产信息管理
	</h2>
	<ul>
		<li><a href="equipment/getAllEquipment.action" target="main"><span class="icon-reorder"></span>固定资产信息列表</a></li>
		<li><a href="equipment/queryEquipmentByCond.action" target="main"><span class="icon-search"></span>查询固定资产信息</a></li>
		<li><a href="repair/getAllRepair.action" target="main"><span class="icon-reorder"></span>设备维修信息列表</a></li>
		<li><a href="repair/queryRepairByCond.action" target="main"><span class="icon-search"></span>查询维护维修信息</a></li>
		<li><a href="scarp/getAllScarp.action" target="main"><span class="icon-reorder"></span>资产报废信息列表</a></li>
		<li><a href="scarp/queryScarpByCond.action" target="main"><span class="icon-search"></span>查询资产报废信息</a></li>
	</ul>

<%--	<h2>--%>
<%--		<span class="icon-user"></span>设备借用归还管理--%>
<%--	</h2>--%>
<%--	<ul>--%>
<%--		<li><a href="lend/getAllLend.action" target="main"><span class="icon-reorder"></span>设备借用信息列表</a></li>--%>
<%--		<li><a href="lend/queryLendByCond.action" target="main"><span class="icon-search"></span>查询设备借用信息</a></li>--%>
<%--		<li><a href="back/getAllBack.action" target="main"><span class="icon-reorder"></span>借用归还信息列表</a></li>--%>
<%--		<li><a href="back/queryBackByCond.action" target="main"><span class="icon-search"></span>查询借用归还信息</a></li>--%>
<%--	</ul>--%>

<%--	<h2>--%>
<%--		<span class="icon-user"></span>盘点信息管理--%>
<%--	</h2>--%>
<%--	<ul>--%>

<%--		<li><a href="pwin/getAllPwin.action" target="main"><span class="icon-reorder"></span>盘盈信息列表</a></li>--%>
<%--		<li><a href="pwin/queryPwinByCond.action" target="main"><span class="icon-search"></span>查询盘盈信息</a></li>--%>
<%--		<li><a href="admin/pwinchart.jsp" target="main"><span class="icon-pencil-square-o"></span>盘盈信息统计</a></li>--%>
<%--		<li><a href="plost/getAllPlost.action" target="main"><span class="icon-reorder"></span>盘亏信息列表</a></li>--%>
<%--		<li><a href="plost/queryPlostByCond.action" target="main"><span class="icon-search"></span>查询盘亏信息</a></li>--%>
<%--		<li><a href="admin/plostchart.jsp" target="main"><span class="icon-pencil-square-o"></span>盘亏信息统计</a></li>--%>
<%--	</ul>--%>

</div>



