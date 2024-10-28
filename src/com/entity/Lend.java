package com.entity;

import com.util.VeDate;

public class Lend {
	private String lendid = "L" + VeDate.getStringId();// 生成主键编号
	private String lno;// 借用单号
	private String employid;// 借用人
	private String deptid;// 部门
	private String equipmentid;// 设备
	private String reason;// 借用原因
	private String status;// 状态
	private String addtime;// 日期
	private String memo;// 备注
	private String employname;// 映射数据
	private String deptname;// 映射数据
	private String equipmentname;// 映射数据

	public String getLendid() {
		return lendid;
	}

	public void setLendid(String lendid) {
		this.lendid = lendid;
	}

	public String getLno() {
		return this.lno;
	}

	public void setLno(String lno) {
		this.lno = lno;
	}

	public String getEmployid() {
		return this.employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getEmployname() {
		return this.employname;
	}

	public void setEmployname(String employname) {
		this.employname = employname;
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

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Lend [lendid=" + this.lendid + ", lno=" + this.lno + ", employid=" + this.employid + ", deptid=" + this.deptid
				+ ", equipmentid=" + this.equipmentid + ", reason=" + this.reason + ", status=" + this.status + ", addtime=" + this.addtime
				+ ", memo=" + this.memo + ", employname=" + this.employname + ", deptname=" + this.deptname + ", equipmentname="
				+ this.equipmentname + "]";
	}

}
