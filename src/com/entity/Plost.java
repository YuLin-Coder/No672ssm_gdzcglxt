package com.entity;

import com.util.VeDate;

public class Plost {
	private String plostid = "P" + VeDate.getStringId();// 生成主键编号
	private String pno;// 单号
	private String deptid;// 部门
	private String equipmentid;// 设备
	private String reason;// 原因
	private String lost;// 损失
	private String employid;// 经手人
	private String addtime;// 日期
	private String memo;// 备注
	private String deptname;// 映射数据
	private String equipmentname;// 映射数据
	private String employname;// 映射数据

	public String getPlostid() {
		return plostid;
	}

	public void setPlostid(String plostid) {
		this.plostid = plostid;
	}

	public String getPno() {
		return this.pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getEquipmentid() {
		return this.equipmentid;
	}

	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getLost() {
		return this.lost;
	}

	public void setLost(String lost) {
		this.lost = lost;
	}

	public String getEmployid() {
		return this.employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getEquipmentname() {
		return this.equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	public String getEmployname() {
		return this.employname;
	}

	public void setEmployname(String employname) {
		this.employname = employname;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Plost [plostid=" + this.plostid + ", pno=" + this.pno + ", deptid=" + this.deptid + ", equipmentid=" + this.equipmentid
				+ ", reason=" + this.reason + ", lost=" + this.lost + ", employid=" + this.employid + ", addtime=" + this.addtime + ", memo="
				+ this.memo + ", deptname=" + this.deptname + ", equipmentname=" + this.equipmentname + ", employname=" + this.employname + "]";
	}

}
