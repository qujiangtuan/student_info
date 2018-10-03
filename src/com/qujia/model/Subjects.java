package com.qujia.model;
//교과목
public class Subjects {
          private String subCode;
          private String subName;//교과목명
          private String subEname;//교과목 영어명
          private String learnType;//이수구분(전필...)
          private String creditType;//이수학점(3,2,1)
          private String orgId;//소속부서
          private String colType;//대상(대학생,대학원생)
          private String schYear;//대상학년
          private String term;//대상학기
          private String subExp;//교과목 설명
          public String getSubCode() {
                    return subCode;
          }
          public void setSubCode(String subCode) {
                    this.subCode = subCode;
          }
          public String getSubName() {
                    return subName;
          }
          public void setSubName(String subName) {
                    this.subName = subName;
          }
          public String getSubEname() {
                    return subEname;
          }
          public void setSubEname(String subEname) {
                    this.subEname = subEname;
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
          public String getOrgId() {
                    return orgId;
          }
          public void setOrgId(String orgId) {
                    this.orgId = orgId;
          }
          public String getColType() {
                    return colType;
          }
          public void setColType(String colType) {
                    this.colType = colType;
          }
          
          public String getSchYear() {
                    return schYear;
          }
          public void setSchYear(String schYear) {
                    this.schYear = schYear;
          }
          public String getTerm() {
                    return term;
          }
          public void setTerm(String term) {
                    this.term = term;
          }
          public String getSubExp() {
                    return subExp;
          }
          public void setSubExp(String subExp) {
                    this.subExp = subExp;
          }
          @Override
          public String toString() {
                    return subName;
          }
          
          
}
