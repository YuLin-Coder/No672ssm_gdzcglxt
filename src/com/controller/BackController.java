package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Back;
import com.service.BackService;
import com.entity.Lend;
import com.entity.Dept;
import com.entity.Equipment;
import com.entity.Employ;
import com.service.LendService;
import com.service.DeptService;
import com.service.EquipmentService;
import com.service.EmployService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/back", produces = "text/plain;charset=utf-8")
public class BackController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private BackService backService;
	@Autowired
	private LendService lendService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private EmployService employService;

	// 添加数据
	@RequestMapping("addBack.action")
	public String addBack(String id) {
		Lend lend = this.lendService.getLendById(id);
		lend.setStatus("确认归还");
		this.lendService.updateLend(lend);
		String deptid = (String) this.getSession().getAttribute("deptid");
		String adminid = (String) this.getSession().getAttribute("adminid");
		Back back = new Back();
		back.setLendid(id);
		back.setDeptid(deptid);
		back.setEquipmentid(lend.getEquipmentid());
		back.setEmployid(adminid);
		back.setAddtime(VeDate.getStringDateShort());
		this.backService.insertBack(back);
		Equipment x = this.equipmentService.getEquipmentById(lend.getEquipmentid());
		x.setStatus("正常");
		this.equipmentService.updateEquipment(x);
		return "redirect:/lend/getMyLend.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBack.action")
	public String deleteBack(String id) {
		this.backService.deleteBack(id);
		return "redirect:/back/getAllBack.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBackByIds.action")
	public String deleteBackByIds() {
		String[] ids = this.getRequest().getParameterValues("backid");
		if (ids != null) {
			for (String backid : ids) {
				this.backService.deleteBack(backid);
			}
		}
		return "redirect:/back/getAllBack.action";
	}

	// 更新数据
	@RequestMapping("updateBack.action")
	public String updateBack(Back back) {
		this.backService.updateBack(back);
		return "redirect:/back/getAllBack.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBack.action")
	public String getAllBack(String number) {
		List<Back> backList = this.backService.getAllBack();
		PageHelper.getPage(backList, "back", null, null, 10, number, this.getRequest(), null);
		return "admin/listback";
	}

	@RequestMapping("getDeptBack.action")
	public String getDeptBack(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Back back = new Back();
		back.setDeptid(deptid);
		List<Back> backList = this.backService.getBackByCond(back);
		PageHelper.getUserPage(backList, "back", "getDeptBack", 10, number, this.getRequest());
		return "admin/xlistback";
	}

	@RequestMapping("getMyBack.action")
	public String getMyBack(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Back back = new Back();
		back.setEmployid(adminid);
		List<Back> backList = this.backService.getBackByCond(back);
		PageHelper.getUserPage(backList, "back", "getMyBack", 10, number, this.getRequest());
		return "admin/ylistback";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBackByCond.action")
	public String queryBackByCond(String cond, String name, String number) {
		Back back = new Back();
		if (cond != null) {
			if ("lendid".equals(cond)) {
				back.setLendid(name);
			}
			if ("deptid".equals(cond)) {
				back.setDeptid(name);
			}
			if ("equipmentid".equals(cond)) {
				back.setEquipmentid(name);
			}
			if ("employid".equals(cond)) {
				back.setEmployid(name);
			}
			if ("addtime".equals(cond)) {
				back.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				back.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.backService.getBackByLike(back), "back", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryback";
	}

	// 按主键查询数据
	@RequestMapping("getBackById.action")
	public String getBackById(String id) {
		Back back = this.backService.getBackById(id);
		this.getRequest().setAttribute("back", back);
		List<Lend> lendList = this.lendService.getAllLend();
		this.getRequest().setAttribute("lendList", lendList);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Equipment> equipmentList = this.equipmentService.getAllEquipment();
		this.getRequest().setAttribute("equipmentList", equipmentList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		return "admin/editback";
	}

}
