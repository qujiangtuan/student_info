package com.qujia.model;

public class CourseApplyView {
          private String couName;
          private String couNo;
          private String orgName;
          private String schYear;
          private String learnType;
          private String creditType;
          private String proId;
          private String proName;
          private int fixedNum;
          private int currNum;
          private String classNo;
          private String ttcr;
          public String getCouName() {
                    return couName;
          }
          public void setCouName(String couName) {
                    this.couName = couName;
          }
          public String getCouNo() {
                    return couNo;
          }
          public void setCouNo(String couNo) {
                    this.couNo = couNo;
          }
          public String getOrgName() {
                    return orgName;
          }
          public void setOrgName(String orgName) {
                    this.orgName = orgName;
          }
          public String getSchYear() {
                    return schYear;
          }
          public void setSchYear(String schYear) {
                    this.schYear = schYear;
          }
          public String getLearnType() {
                    return learnType;
          }
          public void setLearnType(String learnType) {
                    this.learnType = learnType;
          }
          public String getCreditType() {
                    return creditType;
          }
          public void setCreditType(String creditType) {
                    this.creditType = creditType;
          }
          public String getProId() {
                    return proId;
          }
          public void setProId(String proId) {
                    this.proId = proId;
          }
          public String getProName() {
                    return proName;
          }
          public void setProName(String proName) {
                    this.proName = proName;
          }
          public int getFixedNum() {
                    return fixedNum;
          }
          public void setFixedNum(int fixedNum) {
                    this.fixedNum = fixedNum;
          }
          public int getCurrNum() {
                    return currNum;
          }
          public void setCurrNum(int currNum) {
                    this.currNum = currNum;
          }
          public String getClassNo() {
                    return classNo;
          }
          public void setClassNo(String classNo) {
                    this.classNo = classNo;
          }
          public String getTtcr() {
                    return ttcr;
          }
          public void setTtcr(String ttcr) {
                    this.ttcr = ttcr;
          }
          @Override
          public String toString() {
                    return "CourseApply [couName=" + couName + ", couNo="
                                        + couNo + ", orgName=" + orgName
                                        + ", schYear=" + schYear
                                        + ", learnType=" + learnType
                                        + ", creditType=" + creditType
                                        + ", proId=" + proId + ", proName="
                                        + proName + ", fixedNum=" + fixedNum
                                        + ", currNum=" + currNum + ", classNo="
                                        + classNo + ", ttcr=" + ttcr + "]";
          }
          
          
}
