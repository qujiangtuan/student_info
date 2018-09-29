package com.qujia.model;

public class Student {
          private String sNo;
          private String name;
          private String orgId;
          private String sex;
          private String password;
          private String idCardNo;
          private String email;
          private String joinDate;
          private String tel;
          private String adress;
          
          private String majorType;
          private String major;
          private String applyDate;
          
          

          
          public String getMajorType() {
			return majorType;
		}
		public void setMajorType(String majorType) {
			this.majorType = majorType;
		}
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
		}
		public String getApplyDate() {
			return applyDate;
		}
		public void setApplyDate(String applyDate) {
			this.applyDate = applyDate;
		}
		public String getOrgId() {
                    return orgId;
          }
          public void setOrgId(String orgId) {
                    this.orgId = orgId;
          }
          public String getTel() {
                    return tel;
          }
          public void setTel(String tel) {
                    this.tel = tel;
          }
          public String getAdress() {
                    return adress;
          }
          public void setAdress(String adress) {
                    this.adress = adress;
          }
          public String getsNo() {
                    return sNo;
          }
          public void setsNo(String sNo) {
                    this.sNo = sNo;
          }
          public String getName() {
                    return name;
          }
          public void setName(String name) {
                    this.name = name;
          }
           
          public String getSex() {
                    return sex;
          }
          public void setSex(String sex) {
                    this.sex = sex;
          }
          public String getPassword() {
                    return password;
          }
          public void setPassword(String password) {
                    this.password = password;
          }
          public String getIdCardNo() {
                    return idCardNo;
          }
          public void setIdCardNo(String idCardNo) {
                    this.idCardNo = idCardNo;
          }
          public String getEmail() {
                    return email;
          }
          public void setEmail(String email) {
                    this.email = email;
          }
          public String getJoinDate() {
                    return joinDate;
          }
          public void setJoinDate(String joinDate) {
                    this.joinDate = joinDate;
          }
          @Override
          public String toString() {
                    return "Student [sNo=" + sNo + ", name=" + name
                                        + ", orgId=" + orgId + ", sex=" + sex
                                        + ", password=" + password
                                        + ", idCardNo=" + idCardNo + ", email="
                                        + email + ", joinDate=" + joinDate
                                        + ", tel=" + tel + ", adress=" + adress
                                        + "]";
          }
          
          

          
}
