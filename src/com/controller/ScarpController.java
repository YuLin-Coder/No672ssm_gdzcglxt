package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Scarp;
import com.service.ScarpService;
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
@RequestMapping(value = "/scarp", produces = "text/plain;charset=utf-8")
public class ScarpController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private ScarpService scarpService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private EmployService employService;

	// 准备添加数据
	@RequestMapping("createScarp.action")
	public String createScarp() {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Equipment x = new Equipment();
		x.setDeptid(deptid);
		x.setStatus("正常");
		List<Equipment> equipmentList = this.equipmentService.getEquipmentByCond(x);
		this.getRequest().setAttribute("equipmentList", equipmentList);
		return "admin/addscarp";
	}

	// 添加数据
	@RequestMapping("addScarp.action")
	public String addScarp(Scarp scarp) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		String adminid = (String) this.getSession().getAttribute("adminid");
		scarp.setDeptid(deptid);
		scarp.setEmployid(adminid);
		scarp.setAddtime(VeDate.getStringDateShort());
		this.scarpService.insertScarp(scarp);
		Equipment x = this.equipmentService.getEquipmentById(scarp.getEquipmentid());
		x.setStatus("报废");
		this.equipmentService.updateEquipment(x);
		return "redirect:/scarp/createScarp.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteScarp.action")
	public String deleteScarp(String id) {
		this.scarpService.deleteScarp(id);
		return "redirect:/scarp/getAllScarp.action";
	}

	// 批量删除数据
	@RequestMapping("deleteScarpByIds.action")
	public String deleteScarpByIds() {
		String[] ids = this.getRequest().getParameterValues("scarpid");
		if (ids != null) {
			for (String scarpid : ids) {
				this.scarpService.deleteScarp(scarpid);
			}
		}
		return "redirect:/scarp/getAllScarp.action";
	}

	// 更新数据
	@RequestMapping("updateScarp.action")
	public String updateScarp(Scarp scarp) {
		this.scarpService.updateScarp(scarp);
		return "redirect:/scarp/getAllScarp.action";
	}

	// 显示全部数据
	@RequestMapping("getAllScarp.action")
	public String getAllScarp(String number) {
		List<Scarp> scarpList = this.scarpService.getAllScarp();
		PageHelper.getPage(scarpList, "scarp", null, null, 10, number, this.getRequest(), null);
		return "admin/listscarp";
	}

	@RequestMapping("getDeptScarp.action")
	public String getDeptScarp(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Scarp scarp = new Scarp();
		scarp.setDeptid(deptid);
		List<Scarp> scarpList = this.scarpService.getScarpByCond(scarp);
		PageHelper.getUserPage(scarpList, "scarp", "getDeptScarp", 10, number, this.getRequest());
		return "admin/xlistscarp";
	}

	@RequestMapping("getMyScarp.action")
	public String getMyScarp(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Scarp scarp = new Scarp();
		scarp.setEmployid(adminid);
		List<Scarp> scarpList = this.scarpService.getScarpByCond(scarp);
		PageHelper.getUserPage(scarpList, "scarp", "getMyScarp", 10, number, this.getRequest());
		return "admin/ylistscarp";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryScarpByCond.action")
	public String queryScarpByCond(String cond, String name, String number) {
		Scarp scarp = new Scarp();
		if (cond != null) {
			if ("deptid".equals(cond)) {
				scarp.setDeptid(name);
			}
			if ("equipmentid".equals(cond)) {
				scarp.setEquipmentid(name);
			}
			if ("reason".equals(cond)) {
				scarp.setReason(name);
			}
			if ("employid".equals(cond)) {
				scarp.setEmployid(name);
			}
			if ("addtime".equals(cond)) {
				scarp.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				scarp.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.scarpService.getScarpByLike(scarp), "scarp", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryscarp";
	}

	// 按主键查询数据
	@RequestMapping("getScarpById.action")
	public String getScarpById(String id) {
		Scarp scarp = this.scarpService.getScarpById(id);
		this.getRequest().setAttribute("scarp", scarp);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		return "admin/editscarp";
	}

}
