package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Buy;
import com.service.BuyService;
import com.entity.Applyx;
import com.entity.Cate;
import com.service.ApplyxService;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/buy", produces = "text/plain;charset=utf-8")
public class BuyController extends BaseController {
	// @Autowired的作用是自动注入依赖的ServiceBean
	@Autowired
	private BuyService buyService;
	@Autowired
	private ApplyxService applyxService;
	@Autowired
	private CateService cateService;

	// 准备添加数据
	@RequestMapping("createBuy.action")
	public String createBuy(String id) {
		Applyx applyx = this.applyxService.getApplyxById(id);
		this.getRequest().setAttribute("applyx", applyx);
		return "admin/addbuy";
	}

	// 添加数据
	@RequestMapping("addBuy.action")
	public String addBuy(Buy buy) {
		double total = Double.parseDouble(buy.getNum()) * Double.parseDouble(buy.getPrice());
		buy.setTotal("" + VeDate.getDouble(total));
		buy.setSendnum("0");
		this.buyService.insertBuy(buy);
		Applyx applyx = this.applyxService.getApplyxById(buy.getApplyxid());
		applyx.setStatus("已采购");
		this.applyxService.updateApplyx(applyx);
		return "redirect:/applyx/getAllApplyx.action";
	}

	// 通过主键删除数据
	@RequestMapping("deleteBuy.action")
	public String deleteBuy(String id) {
		this.buyService.deleteBuy(id);
		return "redirect:/buy/getAllBuy.action";
	}

	// 批量删除数据
	@RequestMapping("deleteBuyByIds.action")
	public String deleteBuyByIds() {
		String[] ids = this.getRequest().getParameterValues("buyid");
		if (ids != null) {
			for (String buyid : ids) {
				this.buyService.deleteBuy(buyid);
			}
		}
		return "redirect:/buy/getAllBuy.action";
	}

	// 更新数据
	@RequestMapping("updateBuy.action")
	public String updateBuy(Buy buy) {
		this.buyService.updateBuy(buy);
		return "redirect:/buy/getAllBuy.action";
	}

	// 显示全部数据
	@RequestMapping("getAllBuy.action")
	public String getAllBuy(String number) {
		List<Buy> buyList = this.buyService.getAllBuy();
		PageHelper.getPage(buyList, "buy", null, null, 10, number, this.getRequest(), null);
		return "admin/listbuy";
	}

	// 按条件查询数据 (模糊查询)
	@RequestMapping("queryBuyByCond.action")
	public String queryBuyByCond(String cond, String name, String number) {
		Buy buy = new Buy();
		if (cond != null) {
			if ("applyxid".equals(cond)) {
				buy.setApplyxid(name);
			}
			if ("cateid".equals(cond)) {
				buy.setCateid(name);
			}
			if ("equipmentname".equals(cond)) {
				buy.setEquipmentname(name);
			}
			if ("price".equals(cond)) {
				buy.setPrice(name);
			}
			if ("num".equals(cond)) {
				buy.setNum(name);
			}
			if ("total".equals(cond)) {
				buy.setTotal(name);
			}
			if ("supplier".equals(cond)) {
				buy.setSupplier(name);
			}
			if ("sendnum".equals(cond)) {
				buy.setSendnum(name);
			}
			if ("addtime".equals(cond)) {
				buy.setAddtime(name);
			}
			if ("memo".equals(cond)) {
				buy.setMemo(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.buyService.getBuyByLike(buy), "buy", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybuy";
	}

	// 按主键查询数据
	@RequestMapping("getBuyById.action")
	public String getBuyById(String id) {
		Buy buy = this.buyService.getBuyById(id);
		this.getRequest().setAttribute("buy", buy);
		List<Applyx> applyxList = this.applyxService.getAllApplyx();
		this.getRequest().setAttribute("applyxList", applyxList);
		List<Cate> cateList = this.cateService.getAllCate();
		this.getRequest().setAttribute("cateList", cateList);
		return "admin/editbuy";
	}

}
