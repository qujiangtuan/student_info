package com.qujia.model;

public class OpenCourse {
          private String couNo;//학수번호(개설교과목번호)
          private String subCode;//교과목코드
          private String couName;//개설교과목명
          private String schYear;//대상학년
          private String proId;//교원번호
          private String classNo;//분반
          private String term;//대상학기
          private String envMethod;//평가방법
          private int fixedNum;//정원
          private int currNum;//현원
          private String status;//개설상태
          private String proName;
          private String loginDate;
          private TimeView tv;
          
          
          
           
          public TimeView getTv() {
                    return tv;
          }
          public void setTv(TimeView tv) {
                    this.tv = tv;
          }
          public String getLoginDate() {
                    return loginDate;
          }
          public void setLoginDate(String loginDate) {
                    this.loginDate = loginDate;
          }
          public String getProName() {
                    return proName;
          }
          public void setProName(String proName) {
                    this.proName = proName;
          }
          public String getStatus() {
                    return status;
          }
          public void setStatus(String status) {
                    this.status = status;
          }
          public String getCouNo() {
                    return couNo;
          }
          public void setCouNo(String couNo) {
                    this.couNo = couNo;
          }
          public String getSubCode() {
                    return subCode;
          }
          public void setSubCode(String subCode) {
                    this.subCode = subCode;
          }
          public String getCouName() {
                    return couName;
          }
          public void setCouName(String couName) {
                    this.couName = couName;
          }
          public String getSchYear() {
                    return schYear;
          }
          public void setSchYear(String schYear) {
                    this.schYear = schYear;
          }
          public String getProId() {
                    return proId;
          }
          public void setProId(String proId) {
                    this.proId = proId;
          }
          public String getClassNo() {
                    return classNo;
          }
          public void setClassNo(String classNo) {
                    this.classNo = classNo;
          }
          public String getTerm() {
                    return term;
          }
          public void setTerm(String term) {
                    this.term = term;
          }
          public String getEnvMethod() {
                    return envMethod;
          }
          public void setEnvMethod(String envMethod) {
                    this.envMethod = envMethod;
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
          @Override
          public String toString() {
                    return "OpenCourse [couNo=" + couNo + ", subCode="
                                        + subCode + ", couName=" + couName
                                        + ", schYear=" + schYear + ", proId="
                                        + proId + ", classNo=" + classNo
                                        + ", term=" + term + ", envMethod="
                                        + envMethod + ", fixedNum=" + fixedNum
                                        + ", currNum=" + currNum + "]";
          }
          
          
          
}
