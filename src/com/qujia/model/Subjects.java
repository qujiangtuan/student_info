package com.qujia.model;
//������
public class Subjects {
          private String subCode;
          private String subName;//�������
          private String subEname;//������ �����
          private String subMname;//������ ����
          private String learnType;//�̼�����(����...)
          private String creditType;//�̼�����(3,2,1)
          private String orgId;//�ҼӺμ�
          private String colType;//���(���л�,���п���)
          private String subExp;//������ ����
          private String orgName;
          
          
          
          public String getOrgName() {
                    return orgName;
          }
          public void setOrgName(String orgName) {
                    this.orgName = orgName;
          }
          public String getSubMname() {
                    return subMname;
          }
          public void setSubMname(String subMname) {
                    this.subMname = subMname;
          }
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
