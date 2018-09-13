package com.qujia.model;

public class Dept {
          private String deptNo;
          private String deptName;
          private String college;
          private Integer credit;
          private Integer pNum;
          private String loginDate;
          private Integer year1;
          private Integer year2;
          private String deptExplain;

          public String getDeptNo() {
                    return deptNo;
          }

          public void setDeptNo(String deptNo) {
                    this.deptNo = deptNo;
          }

          public String getDeptName() {
                    return deptName;
          }

          public void setDeptName(String deptName) {
                    this.deptName = deptName;
          }

          public String getCollege() {
                    return college;
          }

          public void setCollege(String college) {
                    this.college = college;
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

          @Override
          public String toString() {
                    return "Dept [deptNo=" + deptNo + ", deptName=" + deptName
                                        + ", college=" + college + ", credit="
                                        + credit + ", pNum=" + pNum
                                        + ", loginDate=" + loginDate
                                        + ", year1=" + year1 + ", year2="
                                        + year2 + ", deptExplain="
                                        + deptExplain + "]";
          }

}
