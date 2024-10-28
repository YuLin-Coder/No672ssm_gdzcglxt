package com.entity;

import com.util.VeDate;

public class Back {
	private String backid = "B" + VeDate.getStringId();// 生成主键编号
	private String lendid;// 借用单号
	private String deptid;// 部门
	private String equipmentid;// 设备
	private String employid;// 经手人
	private String addtime;// 日期
	private String memo;// 备注
	private String lno;// 映射数据
	private String deptname;// 映射数据
	private String equipmentname;// 映射数据
	private String employname;// 映射数据

	public String getBackid() {
		return backid;
	}

	public void setBackid(String backid) {
		this.backid = backid;
	}

	public String getLendid() {
		return this.lendid;
	}

	public void setLendid(String lendid) {
		this.lendid = lendid;
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

	public String getLno() {
		return this.lno;
	}

	public void setLno(String lno) {
		this.lno = lno;
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
		return "Back [backid=" + this.backid + ", lendid=" + this.lendid + ", deptid=" + this.deptid + ", equipmentid=" + this.equipmentid
				+ ", employid=" + this.employid + ", addtime=" + this.addtime + ", memo=" + this.memo + ", lno=" + this.lno + ", deptname="
				+ this.deptname + ", equipmentname=" + this.equipmentname + ", employname=" + this.employname + "]";
	}

}
