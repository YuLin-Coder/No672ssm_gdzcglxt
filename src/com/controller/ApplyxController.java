package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Applyx;
import com.service.ApplyxService;
import com.entity.Employ;
import com.entity.Dept;
import com.entity.Cate;
import com.service.EmployService;
import com.service.DeptService;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/applyx", produces = "text/plain;charset=utf-8")
public class ApplyxController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private ApplyxService applyxService;
	@Autowired
	private EmployService employService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createApplyx.action")
	public String createApplyx() {
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		this.getRequest().setAttribute("ano", "A" + VeDate.getStringDatex());
		return "admin/addapplyx";
	}

	// 添加数据
	@RequestMapping("addApplyx.action")
	public String addApplyx(Applyx applyx) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		String adminid = (String) this.getSession().getAttribute("adminid");
		applyx.setEmployid(adminid);
		applyx.setDeptid(deptid);
		applyx.setAddtime(VeDate.getStringDateShort());
		applyx.setStatus("待审核");
		this.applyxService.insertApplyx(applyx);
		return "redirect:/applyx/createApplyx.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteApplyx.action")
	public String deleteApplyx(String id) {
		this.applyxService.deleteApplyx(id);
		return "redirect:/applyx/getAllApplyx.action";
	}

	// 批量删除数据
	@RequestMapping("deleteApplyxByIds.action")
	public String deleteApplyxByIds() {
		String[] ids = this.getRequest().getParameterValues("applyxid");
		if (ids != null) {
			for (String applyxid : ids) {
				this.applyxService.deleteApplyx(applyxid);
			}
		}
		return "redirect:/applyx/getAllApplyx.action";
	}

	// 更新数据
	@RequestMapping("updateApplyx.action")
	public String updateApplyx(Applyx applyx) {
		this.applyxService.updateApplyx(applyx);
		return "redirect:/applyx/getDeptApplyx.action";
	}

	// 更新状态
	@RequestMapping("status.action")
	public String status(String id) {
		String status = "审核通过";
		Applyx applyx = this.applyxService.getApplyxById(id);
		applyx.setStatus(status);
		this.applyxService.updateApplyx(applyx);
		return "redirect:/applyx/getDeptApplyx.action";
	}

	@RequestMapping("refuse.action")
	public String refuse(String id) {
		String status = "管理员拒绝";
		Applyx applyx = this.applyxService.getApplyxById(id);
		applyx.setStatus(status);
		this.applyxService.updateApplyx(applyx);
		return "redirect:/applyx/getAllApplyx.action";
	}

	// 显示全部数据
	@RequestMapping("getAllApplyx.action")
	public String getAllApplyx(String number) {
		List<Applyx> applyxList = this.applyxService.getAllApplyx();
		PageHelper.getPage(applyxList, "applyx", null, null, 10, number, this.getRequest(), null);
		return "admin/listapplyx";
	}

	@RequestMapping("getDeptApplyx.action")
	public String getDeptApplyx(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Applyx applyx = new Applyx();
		applyx.setDeptid(deptid);
		List<Applyx> applyxList = this.applyxService.getApplyxByCond(applyx);
		PageHelper.getUserPage(applyxList, "applyx", "getDeptApplyx", 10, number, this.getRequest());
		return "admin/xlistapplyx";
	}

	@RequestMapping("getMyApplyx.action")
	public String getMyApplyx(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Applyx applyx = new Applyx();
		applyx.setEmployid(adminid);
		List<Applyx> applyxList = this.applyxService.getApplyxByCond(applyx);
		PageHelper.getUserPage(applyxList, "applyx", "getDeptApplyx", 10, number, this.getRequest());
		return "admin/ylistapplyx";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryApplyxByCond.action")
	public String queryApplyxByCond(String cond, String name, String number) {
		Applyx applyx = new Applyx();
		if (cond != null) {
			if ("ano".equals(cond)) {
				applyx.setAno(name);
			}
			if ("employid".equals(cond)) {
				applyx.setEmployid(name);
			}
			if ("deptid".equals(cond)) {
				applyx.setDeptid(name);
			}
			if ("cateid".equals(cond)) {
				applyx.setCateid(name);
			}
			if ("equipmentname".equals(cond)) {
				applyx.setEquipmentname(name);
			}
			if ("reason".equals(cond)) {
				applyx.setReason(name);
			}
			if ("num".equals(cond)) {
				applyx.setNum(name);
			}
			if ("addtime".equals(cond)) {
				applyx.setAddtime(name);
			}
			if ("status".equals(cond)) {
				applyx.setStatus(name);
			}
			if ("memo".equals(cond)) {
				applyx.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.applyxService.getApplyxByLike(applyx), "applyx", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryapplyx";
	}

	// 按主键查询数据
	@RequestMapping("getApplyxById.action")
	public String getApplyxById(String id) {
		Applyx applyx = this.applyxService.getApplyxById(id);
		this.getRequest().setAttribute("applyx", applyx);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editapplyx";
	}

}
