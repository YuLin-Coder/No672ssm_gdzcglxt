package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Applyx;
import com.entity.Cate;
import com.entity.Dept;
import com.entity.Equipment;
import com.service.ApplyxService;
import com.service.CateService;
import com.service.DeptService;
import com.service.EquipmentService;
import com.util.PageHelper;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/equipment", produces = "text/plain;charset=utf-8")
public class EquipmentController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private ApplyxService applyxService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private CateService cateService;

	// 通过主键删除数据
	@RequestMapping("deleteEquipment.action")
	public String deleteEquipment(String id) {
		this.equipmentService.deleteEquipment(id);
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 批量删除数据
	@RequestMapping("deleteEquipmentByIds.action")
	public String deleteEquipmentByIds() {
		String[] ids = this.getRequest().getParameterValues("equipmentid");
		if (ids != null) {
			for (String equipmentid : ids) {
				this.equipmentService.deleteEquipment(equipmentid);
			}
		}
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 更新数据
	@RequestMapping("updateEquipment.action")
	public String updateEquipment(Equipment equipment) {
		this.equipmentService.updateEquipment(equipment);
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "";
		Equipment equipment = this.equipmentService.getEquipmentById(id);
		if (status.equals(equipment.getStatus())) {
			status = "";
		}
		equipment.setStatus(status);
		this.equipmentService.updateEquipment(equipment);
		return "redirect:/equipment/getAllEquipment.action";
	}

	// 显示全部数据
	@RequestMapping("getAllEquipment.action")
	public String getAllEquipment(String number) {
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		PageHelper.getPage(equipmentList, "equipment", null, null, 10, number, this.getRequest(), null);
		return "admin/listequipment";
	}

	@RequestMapping("getDeptEquipment.action")
	public String getDeptEquipment(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Equipment x = new Equipment();
		x.setDeptid(deptid);
		List<Equipment> equipmentList = this.equipmentService.getEquipmentByCond(x);
		PageHelper.getUserPage(equipmentList, "equipment", "getDeptEquipment", 10, number, this.getRequest());
		return "admin/xlistequipment";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryEquipmentByCond.action")
	public String queryEquipmentByCond(String cond, String name, String number) {
		Equipment equipment = new Equipment();
		if (cond != null) {
			if ("eno".equals(cond)) {
				equipment.setEno(name);
			}
			if ("equipmentname".equals(cond)) {
				equipment.setEquipmentname(name);
			}
			if ("applyxid".equals(cond)) {
				equipment.setApplyxid(name);
			}
			if ("deptid".equals(cond)) {
				equipment.setDeptid(name);
			}
			if ("cateid".equals(cond)) {
				equipment.setCateid(name);
			}
			if ("addtime".equals(cond)) {
				equipment.setAddtime(name);
			}
			if ("status".equals(cond)) {
				equipment.setStatus(name);
			}
			if ("memo".equals(cond)) {
				equipment.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.equipmentService.getEquipmentByLike(equipment), "equipment", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/queryequipment";
	}

	// 按主键查询数据
	@RequestMapping("getEquipmentById.action")
	public String getEquipmentById(String id) {
		Equipment equipment = this.equipmentService.getEquipmentById(id);
		this.getRequest().setAttribute("equipment", equipment);
		List<Applyx> applyxList = this.applyxService.getAllApplyx();
		this.getRequest().setAttribute("applyxList", applyxList);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editequipment";
	}

}
