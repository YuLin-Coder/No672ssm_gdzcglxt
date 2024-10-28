package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Pwin;
import com.service.PwinService;
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
@RequestMapping(value = "/pwin", produces = "text/plain;charset=utf-8")
public class PwinController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private PwinService pwinService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private EmployService employService;

	// 准备添加数据
	@RequestMapping("createPwin.action")
	public String createPwin() {
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		this.getRequest().setAttribute("wno", "P" + VeDate.getStringDatex());
		return "admin/addpwin";
	}

	// 添加数据
	@RequestMapping("addPwin.action")
	public String addPwin(Pwin pwin) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		String adminid = (String) this.getSession().getAttribute("adminid");
		pwin.setDeptid(deptid);
		pwin.setEmployid(adminid);
		pwin.setAddtime(VeDate.getStringDateShort());
		this.pwinService.insertPwin(pwin);
		return "redirect:/pwin/createPwin.action";
	}

	// 通过主键删除数据
	@RequestMapping("deletePwin.action")
	public String deletePwin(String id) {
		this.pwinService.deletePwin(id);
		return "redirect:/pwin/getAllPwin.action";
	}

	// 批量删除数据
	@RequestMapping("deletePwinByIds.action")
	public String deletePwinByIds() {
		String[] ids = this.getRequest().getParameterValues("pwinid");
		if (ids != null) {
			for (String pwinid : ids) {
				this.pwinService.deletePwin(pwinid);
			}
		}
		return "redirect:/pwin/getAllPwin.action";
	}

	// 更新数据
	@RequestMapping("updatePwin.action")
	public String updatePwin(Pwin pwin) {
		this.pwinService.updatePwin(pwin);
		return "redirect:/pwin/getAllPwin.action";
	}

	// 显示全部数据
	@RequestMapping("getAllPwin.action")
	public String getAllPwin(String number) {
		List<Pwin> pwinList = this.pwinService.getAllPwin();
		PageHelper.getPage(pwinList, "pwin", null, null, 10, number, this.getRequest(), null);
		return "admin/listpwin";
	}

	@RequestMapping("getDeptPwin.action")
	public String getDeptPwin(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Pwin pwin = new Pwin();
		pwin.setDeptid(deptid);
		List<Pwin> pwinList = this.pwinService.getPwinByCond(pwin);
		PageHelper.getUserPage(pwinList, "pwin", "getDeptPwin", 10, number, this.getRequest());
		return "admin/xlistpwin";
	}

	@RequestMapping("getMyPwin.action")
	public String getMyPwin(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Pwin pwin = new Pwin();
		pwin.setEmployid(adminid);
		List<Pwin> pwinList = this.pwinService.getPwinByCond(pwin);
		PageHelper.getUserPage(pwinList, "pwin", "getMyPwin", 10, number, this.getRequest());
		return "admin/ylistpwin";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryPwinByCond.action")
	public String queryPwinByCond(String cond, String name, String number) {
		Pwin pwin = new Pwin();
		if (cond != null) {
			if ("wno".equals(cond)) {
				pwin.setWno(name);
			}
			if ("deptid".equals(cond)) {
				pwin.setDeptid(name);
			}
			if ("equipmentid".equals(cond)) {
				pwin.setEquipmentid(name);
			}
			if ("reason".equals(cond)) {
				pwin.setReason(name);
			}
			if ("employid".equals(cond)) {
				pwin.setEmployid(name);
			}
			if ("addtime".equals(cond)) {
				pwin.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				pwin.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.pwinService.getPwinByLike(pwin), "pwin", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querypwin";
	}

	// 按主键查询数据
	@RequestMapping("getPwinById.action")
	public String getPwinById(String id) {
		Pwin pwin = this.pwinService.getPwinById(id);
		this.getRequest().setAttribute("pwin", pwin);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		return "admin/editpwin";
	}

}
