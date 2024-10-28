package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Plost;
import com.entity.Pwin;
import com.service.PlostService;
import com.service.PwinService;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chart", produces = "text/plain;charset=utf-8")
public class ChartController extends BaseController {
	@Autowired
	private PwinService pwinService;

	@Autowired
	private PlostService plostService;

	@RequestMapping("getWin.action")
	@ResponseBody
	public String getWin() {
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		long days = VeDate.getDays(end, start);
		JSONArray day = new JSONArray();// 定义day存放数值
		JSONArray total = new JSONArray();// 定义total存放数值
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(end, "-" + i);
			Pwin pwin = new Pwin();
			pwin.setAddtime(nxtDay);
			List<Pwin> winList = this.pwinService.getPwinByCond(pwin);
			total.add(winList.size());
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("total", total.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}

	@RequestMapping("getLost.action")
	@ResponseBody
	public String getLost() {
		String start = this.getRequest().getParameter("start");
		String end = this.getRequest().getParameter("end");
		long days = VeDate.getDays(end, start);
		JSONArray day = new JSONArray();// 定义day存放数值
		JSONArray total = new JSONArray();// 定义total存放数值
		JSONArray count = new JSONArray();// 定义count存放数值
		for (int i = 0; i < days; i++) {
			String nxtDay = VeDate.getNextDay(end, "-" + i);
			Plost lost = new Plost();
			lost.setAddtime(nxtDay);
			List<Plost> list = this.plostService.getPlostByCond(lost);
			total.add(list.size());
			count.add(list.size());
			day.add(nxtDay);
		}
		JSONObject json = new JSONObject();
		json.put("total", total.toString());
		json.put("count", count.toString());
		json.put("days", day.toString().replaceAll("\"", ""));
		System.out.println(json.toString());
		return json.toString();
	}
}
