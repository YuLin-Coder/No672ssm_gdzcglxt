package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Employ;
import com.service.EmployService;
import com.entity.Dept;
import com.service.DeptService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/employ", produces = "text/plain;charset=utf-8")
public class EmployController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private EmployService employService;
	@Autowired
	private DeptService deptService;

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		return "admin/deditpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Employ employ = this.employService.getEmployById(adminid);
		if (password.equals(employ.getPassword())) {
			employ.setPassword(repassword);
			this.employService.updateEmploy(employ);
		} else {
			this.getRequest().setAttribute("message", "旧密码错误");
		}
		return "redirect:/employ/prePwd.action";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Employ employ = this.employService.getEmployById(adminid);
		this.getRequest().setAttribute("employ", employ);
		return "admin/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Employ employ) {
		this.employService.updateEmploy(employ);
		return "redirect:/employ/userinfo.action";
	}

	// 准备添加数据
	@RequestMapping("createEmploy.action")
	public String createEmploy() {
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		return "admin/addemploy";
	}

	// 添加数据
	@RequestMapping("addEmploy.action")
	public String addEmploy(Employ employ) {
		employ.setAddtime(VeDate.getStringDateShort());
		this.employService.insertEmploy(employ);
		return "redirect:/employ/createEmploy.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteEmploy.action")
	public String deleteEmploy(String id) {
		this.employService.deleteEmploy(id);
		return "redirect:/employ/getAllEmploy.action";
	}

	// 批量删除数据
	@RequestMapping("deleteEmployByIds.action")
	public String deleteEmployByIds() {
		String[] ids = this.getRequest().getParameterValues("employid");
		if (ids != null) {
			for (String employid : ids) {
				this.employService.deleteEmploy(employid);
			}
		}
		return "redirect:/employ/getAllEmploy.action";
	}

	// 更新数据
	@RequestMapping("updateEmploy.action")
	public String updateEmploy(Employ employ) {
		this.employService.updateEmploy(employ);
		return "redirect:/employ/getAllEmploy.action";
	}

	// 显示全部数据
	@RequestMapping("getAllEmploy.action")
	public String getAllEmploy(String number) {
		List<Employ> employList = this.employService.getAllEmploy();
		PageHelper.getPage(employList, "employ", null, null, 10, number, this.getRequest(), null);
		return "admin/listemploy";
	}

	@RequestMapping("getDeptEmploy.action")
	public String getDeptEmploy(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Employ employ = new Employ();
		employ.setDeptid(deptid);
		List<Employ> employList = this.employService.getEmployByCond(employ);
		PageHelper.getUserPage(employList, "employ", "getWorkEmploy", 10, number, this.getRequest());
		return "admin/xlistemploy";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryEmployByCond.action")
	public String queryEmployByCond(String cond, String name, String number) {
		Employ employ = new Employ();
		if (cond != null) {
			if ("username".equals(cond)) {
				employ.setUsername(name);
			}
			if ("password".equals(cond)) {
				employ.setPassword(name);
			}
			if ("employname".equals(cond)) {
				employ.setEmployname(name);
			}
			if ("sex".equals(cond)) {
				employ.setSex(name);
			}
			if ("birthday".equals(cond)) {
				employ.setBirthday(name);
			}
			if ("deptid".equals(cond)) {
				employ.setDeptid(name);
			}
			if ("contact".equals(cond)) {
				employ.setContact(name);
			}
			if ("role".equals(cond)) {
				employ.setRole(name);
			}
			if ("addtime".equals(cond)) {
				employ.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				employ.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.employService.getEmployByLike(employ), "employ", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryemploy";
	}

	// 按主键查询数据
	@RequestMapping("getEmployById.action")
	public String getEmployById(String id) {
		Employ employ = this.employService.getEmployById(id);
		this.getRequest().setAttribute("employ", employ);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		return "admin/editemploy";
	}

}
