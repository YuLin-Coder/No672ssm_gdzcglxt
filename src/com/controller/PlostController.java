package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Plost;
import com.service.PlostService;
import com.entity.Dept;
import com.entity.Equipment;
import com.entity.Employ;
import com.service.DeptService;
import com.service.EquipmentService;
import com.service.EmployService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/plost", produces = "text/plain;charset=utf-8")
public class PlostController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private PlostService plostService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private EmployService employService;

	// 准备添加数据
	@RequestMapping("createPlost.action")
	public String createPlost() {
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		this.getRequest().setAttribute("wno", "P" + VeDate.getStringDatex());
		return "admin/addplost";
	}

	// 添加数据
	@RequestMapping("addPlost.action")
	public String addPlost(Plost plost) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		String adminid = (String) this.getSession().getAttribute("adminid");
		plost.setDeptid(deptid);
		plost.setEmployid(adminid);
		plost.setAddtime(VeDate.getStringDateShort());
		this.plostService.insertPlost(plost);
		return "redirect:/plost/createPlost.action";
	}

	// 通过主键删除数据
	@RequestMapping("deletePlost.action")
	public String deletePlost(String id) {
		this.plostService.deletePlost(id);
		return "redirect:/plost/getAllPlost.action";
	}

	// 批量删除数据
	@RequestMapping("deletePlostByIds.action")
	public String deletePlostByIds() {
		String[] ids = this.getRequest().getParameterValues("plostid");
		if (ids != null) {
			for (String plostid : ids) {
				this.plostService.deletePlost(plostid);
			}
		}
		return "redirect:/plost/getAllPlost.action";
	}

	// 更新数据
	@RequestMapping("updatePlost.action")
	public String updatePlost(Plost plost) {
		this.plostService.updatePlost(plost);
		return "redirect:/plost/getAllPlost.action";
	}

	// 显示全部数据
	@RequestMapping("getAllPlost.action")
	public String getAllPlost(String number) {
		List<Plost> plostList = this.plostService.getAllPlost();
		PageHelper.getPage(plostList, "plost", null, null, 10, number, this.getRequest(), null);
		return "admin/listplost";
	}

	@RequestMapping("getDeptPlost.action")
	public String getDeptPlost(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Plost plost = new Plost();
		plost.setDeptid(deptid);
		List<Plost> plostList = this.plostService.getPlostByCond(plost);
		PageHelper.getUserPage(plostList, "plost", "getDeptPlost", 10, number, this.getRequest());
		return "admin/xlistplost";
	}

	@RequestMapping("getMyPlost.action")
	public String getMyPlost(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Plost plost = new Plost();
		plost.setEmployid(adminid);
		List<Plost> plostList = this.plostService.getPlostByCond(plost);
		PageHelper.getUserPage(plostList, "plost", "getMyPlost", 10, number, this.getRequest());
		return "admin/ylistplost";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryPlostByCond.action")
	public String queryPlostByCond(String cond, String name, String number) {
		Plost plost = new Plost();
		if (cond != null) {
			if ("pno".equals(cond)) {
				plost.setPno(name);
			}
			if ("deptid".equals(cond)) {
				plost.setDeptid(name);
			}
			if ("equipmentid".equals(cond)) {
				plost.setEquipmentid(name);
			}
			if ("reason".equals(cond)) {
				plost.setReason(name);
			}
			if ("lost".equals(cond)) {
				plost.setLost(name);
			}
			if ("employid".equals(cond)) {
				plost.setEmployid(name);
			}
			if ("addtime".equals(cond)) {
				plost.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				plost.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.plostService.getPlostByLike(plost), "plost", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryplost";
	}

	// 按主键查询数据
	@RequestMapping("getPlostById.action")
	public String getPlostById(String id) {
		Plost plost = this.plostService.getPlostById(id);
		this.getRequest().setAttribute("plost", plost);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		return "admin/editplost";
	}

}
