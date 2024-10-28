package com.entity;

import com.util.VeDate;

public class Employ {
	private String employid = "E" + VeDate.getStringId();// 生成主键编号
	private String username;// 用户名
	private String password;// 密码
	private String employname;// 员工姓名
	private String sex;// 性别
	private String birthday;// 出生日期
	private String deptid;// 所在部门
	private String contact;// 联系方式
	private String role;// 角色
	private String addtime;// 创建日期
	private String memo;// 备注
	private String deptname;// 映射数据

	public String getEmployid() {
		return employid;
	}

	public void setEmployid(String employid) {
		this.employid = employid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmployname() {
		return this.employname;
	}

	public void setEmployname(String employname) {
		this.employname = employname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getDeptid() {
		return this.deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
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

	// 重载方法 生成JSON类型字符串
	@Override
	public String toString() {
		return "Employ [employid=" + this.employid + ", username=" + this.username + ", password=" + this.password + ", employname="
				+ this.employname + ", sex=" + this.sex + ", birthday=" + this.birthday + ", deptid=" + this.deptid + ", contact="
				+ this.contact + ", role=" + this.role + ", addtime=" + this.addtime + ", memo=" + this.memo + ", deptname=" + this.deptname
				+ "]";
	}

}
