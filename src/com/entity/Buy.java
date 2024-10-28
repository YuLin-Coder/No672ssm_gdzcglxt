package com.entity;

import com.util.VeDate;

public class Buy {
	private String buyid = "B" + VeDate.getStringId();// 生成主键编号
	private String applyxid;// 采购单号
	private String cateid;// 设备类型
	private String equipmentname;// 资产名称
	private String price;// 采购单价
	private String num;// 采购数量
	private String total;// 总计金额
	private String supplier;// 供应商
	private String sendnum;// 发放数量
	private String addtime;// 采购日期
	private String memo;// 备注
	private String ano;// 映射数据
	private String catename;// 映射数据

	public String getBuyid() {
		return buyid;
	}

	public void setBuyid(String buyid) {
		this.buyid = buyid;
	}

	public String getApplyxid() {
		return this.applyxid;
	}

	public void setApplyxid(String applyxid) {
		this.applyxid = applyxid;
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

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSendnum() {
		return this.sendnum;
	}

	public void setSendnum(String sendnum) {
		this.sendnum = sendnum;
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

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Buy [buyid=" + this.buyid + ", applyxid=" + this.applyxid + ", cateid=" + this.cateid + ", equipmentname=" + this.equipmentname
				+ ", price=" + this.price + ", num=" + this.num + ", total=" + this.total + ", supplier=" + this.supplier + ", sendnum="
				+ this.sendnum + ", addtime=" + this.addtime + ", memo=" + this.memo + ", ano=" + this.ano + ", catename=" + this.catename
				+ "]";
	}

}
