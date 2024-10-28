package com.entity;

import com.util.VeDate;

public class Send {
	private String sendid = "S" + VeDate.getStringId();// 生成主键编号
	private String applyxid;// 批次
	private String deptid;// 部门
	private String employid;// 接收人
	private String equipmentname;// 资产名称
	private String num;// 接收数量
	private String addtime;// 日期
	private String memo;// 备注
	private String ano;// 映射数据
	private String deptname;// 映射数据
	private String employname;// 映射数据

	public String getSendid() {
		return sendid;
	}

	public void setSendid(String sendid) {
		this.sendid = sendid;
	}

	public String getApplyxid() {
		return this.applyxid;
	}

	public void setApplyxid(String applyxid) {
		this.applyxid = applyxid;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getEmployid() {
		return this.employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getEquipmentname() {
		return this.equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
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
		return "Send [sendid=" + this.sendid + ", applyxid=" + this.applyxid + ", deptid=" + this.deptid + ", employid=" + this.employid
				+ ", equipmentname=" + this.equipmentname + ", num=" + this.num + ", addtime=" + this.addtime + ", memo=" + this.memo + ", ano="
				+ this.ano + ", deptname=" + this.deptname + ", employname=" + this.employname + "]";
	}

}
