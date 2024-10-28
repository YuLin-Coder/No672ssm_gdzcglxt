package com.entity;

import com.util.VeDate;

public class Applyx {
	private String applyxid = "A" + VeDate.getStringId();// 生成主键编号
	private String ano;// 申请单号
	private String employid;// 申请人
	private String deptid;// 部门
	private String cateid;// 资产类型
	private String equipmentname;// 设备名称
	private String reason;// 申请原因
	private String num;// 采购数量
	private String addtime;// 申请日期
	private String status;// 状态
	private String memo;// 备注
	private String employname;// 映射数据
	private String deptname;// 映射数据
	private String catename;// 映射数据

	public String getApplyxid() {
		return applyxid;
	}

	public void setApplyxid(String applyxid) {
		this.applyxid = applyxid;
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
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

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getEquipmentname() {
		return this.equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Applyx [applyxid=" + this.applyxid + ", ano=" + this.ano + ", employid=" + this.employid + ", deptid=" + this.deptid
				+ ", cateid=" + this.cateid + ", equipmentname=" + this.equipmentname + ", reason=" + this.reason + ", num=" + this.num
				+ ", addtime=" + this.addtime + ", status=" + this.status + ", memo=" + this.memo + ", employname=" + this.employname
				+ ", deptname=" + this.deptname + ", catename=" + this.catename + "]";
	}

}
