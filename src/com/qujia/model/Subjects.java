package com.qujia.model;
//������
public class Subjects {
          private String subCode;
          private String subName;//�������
          private String subEname;//������ �����
          private String learnType;//�̼�����(����...)
          private String creditType;//�̼�����(3,2,1)
          private String orgId;//�ҼӺμ�
          private String colType;//���(���л�,���п���)
          private String schYear;//����г�
          private String term;//����б�
          private String subExp;//������ ����
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
