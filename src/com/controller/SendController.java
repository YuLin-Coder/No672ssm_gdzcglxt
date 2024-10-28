package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Applyx;
import com.entity.Buy;
import com.entity.Dept;
import com.entity.Employ;
import com.entity.Equipment;
import com.entity.Send;
import com.service.ApplyxService;
import com.service.BuyService;
import com.service.DeptService;
import com.service.EmployService;
import com.service.EquipmentService;
import com.service.SendService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/send", produces = "text/plain;charset=utf-8")
public class SendController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private SendService sendService;
	@Autowired
	private ApplyxService applyxService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private EmployService employService;
	@Autowired
	private BuyService buyService;
	@Autowired
	private EquipmentService equipmentService;

	// 准备添加数据
	@RequestMapping("createSend.action")
	public String createSend(String id) {
		Buy buy = this.buyService.getBuyById(id);
		this.getRequest().setAttribute("buy", buy);
		Applyx applyx = this.applyxService.getApplyxById(buy.getApplyxid());
		Employ employ = new Employ();
		employ.setDeptid(applyx.getDeptid());
		List<Employ> employList = this.employService.getEmployByCond(employ);
		this.getRequest().setAttribute("employList", employList);

		return "admin/addsend";
	}

	// 添加数据
	@RequestMapping("addSend.action")
	public String addSend(Send send) {
		String buyid = this.getRequest().getParameter("buyid");
		Buy buy = this.buyService.getBuyById(buyid);
		Applyx applyx = this.applyxService.getApplyxById(buy.getApplyxid());
		applyx.setStatus("已发放");
		this.applyxService.updateApplyx(applyx);
		send.setApplyxid(applyx.getApplyxid());
		send.setDeptid(applyx.getDeptid());
		send.setEquipmentname(buy.getEquipmentname());
		send.setAddtime(VeDate.getStringDateShort());
		this.sendService.insertSend(send);
		for (int i = 0; i < Integer.parseInt(send.getNum()); i++) {
			Equipment x = new Equipment();
			x.setAddtime(VeDate.getStringDateShort());
			x.setApplyxid(applyx.getApplyxid());
			x.setCateid(applyx.getCateid());
			x.setDeptid(applyx.getDeptid());
			x.setEno("E" + VeDate.getStringDatex() + i);
			x.setEquipmentid("E" + VeDate.getStringDatex() + i);
			x.setMemo("");
			x.setStatus("正常");
			x.setEquipmentname(buy.getEquipmentname() + (i + 1));
			this.equipmentService.insertEquipment(x);
		}
		buy.setSendnum(send.getNum());
		this.buyService.updateBuy(buy);
		return "redirect:/buy/getAllBuy.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteSend.action")
	public String deleteSend(String id) {
		this.sendService.deleteSend(id);
		return "redirect:/send/getAllSend.action";
	}

	// 批量删除数据
	@RequestMapping("deleteSendByIds.action")
	public String deleteSendByIds() {
		String[] ids = this.getRequest().getParameterValues("sendid");
		if (ids != null) {
			for (String sendid : ids) {
				this.sendService.deleteSend(sendid);
			}
		}
		return "redirect:/send/getAllSend.action";
	}

	// 更新数据
	@RequestMapping("updateSend.action")
	public String updateSend(Send send) {
		this.sendService.updateSend(send);
		return "redirect:/send/getAllSend.action";
	}

	// 显示全部数据
	@RequestMapping("getAllSend.action")
	public String getAllSend(String number) {
		List<Send> sendList = this.sendService.getAllSend();
		PageHelper.getPage(sendList, "send", null, null, 10, number, this.getRequest(), null);
		return "admin/listsend";
	}

	@RequestMapping("getDeptSend.action")
	public String getDeptSend(String number) {
		String deptid = (String) this.getSession().getAttribute("deptid");
		Send send = new Send();
		send.setDeptid(deptid);
		List<Send> sendList = this.sendService.getSendByCond(send);
		PageHelper.getUserPage(sendList, "send", "getDeptSend", 10, number, this.getRequest());
		return "admin/xlistsend";
	}

	@RequestMapping("getMySend.action")
	public String getMySend(String number) {
		String adminid = (String) this.getSession().getAttribute("adminid");
		Send send = new Send();
		send.setEmployid(adminid);
		List<Send> sendList = this.sendService.getSendByCond(send);
		PageHelper.getUserPage(sendList, "send", "getMySend", 10, number, this.getRequest());
		return "admin/ylistsend";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("querySendByCond.action")
	public String querySendByCond(String cond, String name, String number) {
		Send send = new Send();
		if (cond != null) {
			if ("applyxid".equals(cond)) {
				send.setApplyxid(name);
			}
			if ("deptid".equals(cond)) {
				send.setDeptid(name);
			}
			if ("employid".equals(cond)) {
				send.setEmployid(name);
			}
			if ("equipmentname".equals(cond)) {
				send.setEquipmentname(name);
			}
			if ("num".equals(cond)) {
				send.setNum(name);
			}
			if ("addtime".equals(cond)) {
				send.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				send.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.sendService.getSendByLike(send), "send", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querysend";
	}

	// 按主键查询数据
	@RequestMapping("getSendById.action")
	public String getSendById(String id) {
		Send send = this.sendService.getSendById(id);
		this.getRequest().setAttribute("send", send);
		List<Applyx> applyxList = this.applyxService.getAllApplyx();
		this.getRequest().setAttribute("applyxList", applyxList);
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("deptList", deptList);
		List<Employ> employList = this.employService.getAllEmploy();
		this.getRequest().setAttribute("employList", employList);
		return "admin/editsend";
	}

}
