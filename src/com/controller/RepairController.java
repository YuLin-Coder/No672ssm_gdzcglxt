package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Repair;
import com.service.RepairService;
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
@RequestMapping(value = "/repair", produces = "text/plain;charset=utf-8")
public class RepairController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private RepairService repairService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private EmployService employService;

	// 准备添加数据
	@RequestMapping("createRepair.action")
	public String createRepair() {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Equipment x = new Equipment();
		x.setDeptid(deptid);
		x.setStatus("正常");
		List<Equipment> equipmentList = this.equipmentService.getEquipmentByCond(x);
		this.getRequest().setAttribute("equipmentList", equipmentList);
		return "admin/addrepair";
	}

	// 添加数据
	@RequestMapping("addRepair.action")
	public String addRepair(Repair repair) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		String adminid = (String) this.getSession().getAttribute("adminid");
		repair.setDeptid(deptid);
		repair.setEmployid(adminid);
		repair.setAddtime(VeDate.getStringDateShort());
		this.repairService.insertRepair(repair);
		return "redirect:/repair/createRepair.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteRepair.action")
	public String deleteRepair(String id) {
		this.repairService.deleteRepair(id);
		return "redirect:/repair/getAllRepair.action";
	}

	// 批量删除数据
	@RequestMapping("deleteRepairByIds.action")
	public String deleteRepairByIds() {
		String[] ids = this.getRequest().getParameterValues("repairid");
		if (ids != null) {
			for (String repairid : ids) {
				this.repairService.deleteRepair(repairid);
			}
		}
		return "redirect:/repair/getAllRepair.action";
	}

	// 更新数据
	@RequestMapping("updateRepair.action")
	public String updateRepair(Repair repair) {
		this.repairService.updateRepair(repair);
		return "redirect:/repair/getAllRepair.action";
	}

	// 显示全部数据
	@RequestMapping("getAllRepair.action")
	public String getAllRepair(String number) {
		List<Repair> repairList = this.repairService.getAllRepair();
		PageHelper.getPage(repairList, "repair", null, null, 10, number, this.getRequest(), null);
		return "admin/listrepair";
	}

	@RequestMapping("getDeptRepair.action")
	public String getDeptRepair(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Repair repair = new Repair();
		repair.setDeptid(deptid);
		List<Repair> repairList = this.repairService.getRepairByCond(repair);
		PageHelper.getUserPage(repairList, "repair", "getDeptRepair", 10, number, this.getRequest());
		return "admin/xlistrepair";
	}

	@RequestMapping("getMyRepair.action")
	public String getMyRepair(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Repair repair = new Repair();
		repair.setEmployid(adminid);
		List<Repair> repairList = this.repairService.getRepairByCond(repair);
		PageHelper.getUserPage(repairList, "repair", "getMyRepair", 10, number, this.getRequest());
		System.out.println(repairList);
		return "admin/ylistrepair";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryRepairByCond.action")
	public String queryRepairByCond(String cond, String name, String number) {
		Repair repair = new Repair();
		if (cond != null) {
			if ("deptid".equals(cond)) {
				repair.setDeptid(name);
			}
			if ("equipmentid".equals(cond)) {
				repair.setEquipmentid(name);
			}
			if ("reason".equals(cond)) {
				repair.setReason(name);
			}
			if ("cost".equals(cond)) {
				repair.setCost(name);
			}
			if ("employid".equals(cond)) {
				repair.setEmployid(name);
			}
			if ("addtime".equals(cond)) {
				repair.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				repair.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.repairService.getRepairByLike(repair), "repair", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryrepair";
	}

	// 按主键查询数据
	@RequestMapping("getRepairById.action")
	public String getRepairById(String id) {
		Repair repair = this.repairService.getRepairById(id);
		this.getRequest().setAttribute("repair", repair);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		return "admin/editrepair";
	}

}
