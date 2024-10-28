package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Lend;
import com.service.LendService;
import com.entity.Employ;
import com.entity.Dept;
import com.entity.Equipment;
import com.service.EmployService;
import com.service.DeptService;
import com.service.EquipmentService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/lend", produces = "text/plain;charset=utf-8")
public class LendController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private LendService lendService;
	@Autowired
	private EmployService employService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EquipmentService equipmentService;

	// 准备添加数据
	@RequestMapping("createLend.action")
	public String createLend() {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Equipment x = new Equipment();
		x.setDeptid(deptid);
		x.setStatus("正常");
		List<Equipment> equipmentList = this.equipmentService.getEquipmentByCond(x);
		this.getRequest().setAttribute("equipmentList", equipmentList);
		this.getRequest().setAttribute("lno", "L" + VeDate.getStringDatex());
		return "admin/addlend";
	}

	// 添加数据
	@RequestMapping("addLend.action")
	public String addLend(Lend lend) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		String adminid = (String) this.getSession().getAttribute("adminid");
		lend.setEmployid(adminid);
		lend.setDeptid(deptid);
		lend.setStatus("待审核");
		lend.setAddtime(VeDate.getStringDateShort());
		this.lendService.insertLend(lend);
		return "redirect:/lend/createLend.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteLend.action")
	public String deleteLend(String id) {
		this.lendService.deleteLend(id);
		return "redirect:/lend/getAllLend.action";
	}

	// 批量删除数据
	@RequestMapping("deleteLendByIds.action")
	public String deleteLendByIds() {
		String[] ids = this.getRequest().getParameterValues("lendid");
		if (ids != null) {
			for (String lendid : ids) {
				this.lendService.deleteLend(lendid);
			}
		}
		return "redirect:/lend/getAllLend.action";
	}

	// 更新数据
	@RequestMapping("updateLend.action")
	public String updateLend(Lend lend) {
		this.lendService.updateLend(lend);
		return "redirect:/lend/getAllLend.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "通过审核";
		Lend lend = this.lendService.getLendById(id);
		lend.setStatus(status);
		this.lendService.updateLend(lend);
		Equipment x = this.equipmentService.getEquipmentById(lend.getEquipmentid());
		x.setStatus("借出");
		this.equipmentService.updateEquipment(x);
		return "redirect:/lend/getDeptLend.action";
	}

	// 显示全部数据
	@RequestMapping("getAllLend.action")
	public String getAllLend(String number) {
		List<Lend> lendList = this.lendService.getAllLend();
		PageHelper.getPage(lendList, "lend", null, null, 10, number, this.getRequest(), null);
		return "admin/listlend";
	}

	@RequestMapping("getDeptLend.action")
	public String getDeptLend(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Lend lend = new Lend();
		lend.setDeptid(deptid);
		List<Lend> lendList = this.lendService.getLendByCond(lend);
		PageHelper.getUserPage(lendList, "lend", "getDeptLend", 10, number, this.getRequest());
		return "admin/xlistlend";
	}

	@RequestMapping("getMyLend.action")
	public String getMyLend(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Lend lend = new Lend();
		lend.setEmployid(adminid);
		List<Lend> lendList = this.lendService.getLendByCond(lend);
		PageHelper.getUserPage(lendList, "lend", "getMyLend", 10, number, this.getRequest());
		return "admin/ylistlend";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryLendByCond.action")
	public String queryLendByCond(String cond, String name, String number) {
		Lend lend = new Lend();
		if (cond != null) {
			if ("lno".equals(cond)) {
				lend.setLno(name);
			}
			if ("employid".equals(cond)) {
				lend.setEmployid(name);
			}
			if ("deptid".equals(cond)) {
				lend.setDeptid(name);
			}
			if ("equipmentid".equals(cond)) {
				lend.setEquipmentid(name);
			}
			if ("reason".equals(cond)) {
				lend.setReason(name);
			}
			if ("status".equals(cond)) {
				lend.setStatus(name);
			}
			if ("addtime".equals(cond)) {
				lend.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				lend.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.lendService.getLendByLike(lend), "lend", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querylend";
	}

	// 按主键查询数据
	@RequestMapping("getLendById.action")
	public String getLendById(String id) {
		Lend lend = this.lendService.getLendById(id);
		this.getRequest().setAttribute("lend", lend);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		return "admin/editlend";
	}

}
