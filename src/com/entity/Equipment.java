package com.entity;

import com.util.VeDate;

public class Equipment {
	private String equipmentid = "E" + VeDate.getStringId();// 生成主键编号
	private String eno;// 资产编号
	private String equipmentname;// 资产名称
	private String applyxid;// 采购批次
	private String deptid;// 所在部门
	private String cateid;// 资产类型
	private String addtime;// 创建日期
	private String status;// 状态
	private String memo;// 备注
	private String ano;// 映射数据
	private String deptname;// 映射数据
	private String catename;// 映射数据

	public String getEquipmentid() {
		return equipmentid;
	}

	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}

	public String getEno() {
		return this.eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getEquipmentname() {
		return this.equipmentname;
	}

	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
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

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
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

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Equipment [equipmentid=" + this.equipmentid + ", eno=" + this.eno + ", equipmentname=" + this.equipmentname + ", applyxid="
				+ this.applyxid + ", deptid=" + this.deptid + ", cateid=" + this.cateid + ", addtime=" + this.addtime + ", status="
				+ this.status + ", memo=" + this.memo + ", ano=" + this.ano + ", deptname=" + this.deptname + ", catename=" + this.catename
				+ "]";
	}

}
