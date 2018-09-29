package com.qujia.model;


public class DeptStand {
          private String standId; //기준 id
          private String orgName;//#조직 이름
          private String college;//#소속대학/대학원
          private String orgid;//조직 코드
          private Integer credit;//이수학점
          private Integer pNum;//모집인원
          private Integer inNum;//재학인원
          private String loginDate;//등록 일자
          private Integer year1;//수학년한
          private Integer year2;//재학년한
          private String deptExplain;//기준 보충설명
          
          public Integer getInNum() {
                    return inNum;
          }
          public void setInNum(Integer inNum) {
                    this.inNum = inNum;
          }
          
          public String getOrgid() {
                    return orgid;
          }
          public void setOrgid(String orgid) {
                    this.orgid = orgid;
          }
          public String getOrgName() {
                    return orgName;
          }
          public void setOrgName(String orgName) {
                    this.orgName = orgName;
          }
          
          public String getCollege() {
                    return college;
          }
          public void setCollege(String college) {
                    this.college = college;
          }
          public String getStandId() {
                    return standId;
          }

          public void setStandId(String standId) {
                    this.standId = standId;
          }

          public Integer getCredit() {
                    return credit;
          }

          public void setCredit(Integer credit) {
                    this.credit = credit;
          }

          public Integer getpNum() {
                    return pNum;
          }

          public void setpNum(Integer pNum) {
                    this.pNum = pNum;
          }

          public String getLoginDate() {
                    return loginDate;
          }

          public void setLoginDate(String loginDate) {
                    this.loginDate = loginDate;
          }

          public Integer getYear1() {
                    return year1;
          }

          public void setYear1(Integer year1) {
                    this.year1 = year1;
          }

          public Integer getYear2() {
                    return year2;
          }

          public void setYear2(Integer year2) {
                    this.year2 = year2;
          }

          public String getDeptExplain() {
                    return deptExplain;
          }

          public void setDeptExplain(String deptExplain) {
                    this.deptExplain = deptExplain;
          }
          public String getOrgIdByName(String name){
                    if(orgName.equals(name)) return standId;
                    return "";
          }

          

}
