package com.qujia.model;

public class ProStaff {
	private String pNo;
	private String pName;
	private String peName;
	private String proType;
	private String perType;
	private String teaType;
	private String sex;
	private String idCardNo;
	private String orgId;
	private String address;
	private String tel;
	private String email;
	private String loginDate;
	private String password;
	private String supId;
	public String getpNo() {
		return pNo;
	}
	public void setpNo(String pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getPeName() {
		return peName;
	}
	public void setPeName(String peName) {
		this.peName = peName;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getPerType() {
		return perType;
	}
	public void setPerType(String perType) {
		this.perType = perType;
	}
	public String getTeaType() {
		return teaType;
	}
	public void setTeaType(String teaType) {
		this.teaType = teaType;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSupId() {
		return supId;
	}
	public void setSupId(String supId) {
		this.supId = supId;
	}
          @Override
          public String toString() {
                    return "["+perType+"]-"+pName;
          }
	
}
