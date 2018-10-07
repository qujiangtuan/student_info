package com.qujia.model;

public class SecondMajorRange {
          private String allowNo;
          private String orgidBase;
          private String orgidAllow;
          private String startTime;
          private String endTime;
          private String allowType;
          private String rangeType;
          private String loginDate;
          
          private String orgidBaseName;
          private String orgidAllowName;
          private String isAllow;
          
          public String getIsAllow() {
                    return isAllow;
          }
          public void setIsAllow(String isAllow) {
                    this.isAllow = isAllow;
          }
          public String getOrgidBaseName() {
                    return orgidBaseName;
          }
          public void setOrgidBaseName(String orgidBaseName) {
                    this.orgidBaseName = orgidBaseName;
          }
          public String getOrgidAllowName() {
                    return orgidAllowName;
          }
          public void setOrgidAllowName(String orgidAllowName) {
                    this.orgidAllowName = orgidAllowName;
          }
          public String getAllowNo() {
                    return allowNo;
          }
          public void setAllowNo(String allowNo) {
                    this.allowNo = allowNo;
          }
          public String getOrgidBase() {
                    return orgidBase;
          }
          public void setOrgidBase(String orgidBase) {
                    this.orgidBase = orgidBase;
          }
          public String getOrgidAllow() {
                    return orgidAllow;
          }
          public void setOrgidAllow(String orgidAllow) {
                    this.orgidAllow = orgidAllow;
          }
          public String getStartTime() {
                    return startTime;
          }
          public void setStartTime(String startTime) {
                    this.startTime = startTime;
          }
          public String getEndTime() {
                    return endTime;
          }
          public void setEndTime(String endTime) {
                    this.endTime = endTime;
          }
          public String getAllowType() {
                    return allowType;
          }
          public void setAllowType(String allowType) {
                    this.allowType = allowType;
          }
          public String getRangeType() {
                    return rangeType;
          }
          public void setRangeType(String rangeType) {
                    this.rangeType = rangeType;
          }
          public String getLoginDate() {
                    return loginDate;
          }
          public void setLoginDate(String loginDate) {
                    this.loginDate = loginDate;
          }
//          @Override
//          public String toString() {
//                    return orgidAllow;
//          }
          @Override
          public String toString() {
                    return "SecondMajorRange [allowNo=" + allowNo
                                        + ", orgidBase=" + orgidBase
                                        + ", orgidAllow=" + orgidAllow
                                        + ", startTime=" + startTime
                                        + ", endTime=" + endTime
                                        + ", allowType=" + allowType
                                        + ", rangeType=" + rangeType
                                        + ", loginDate=" + loginDate
                                        + ", orgidBaseName=" + orgidBaseName
                                        + ", orgidAllowName=" + orgidAllowName
                                        + ", isAllow=" + isAllow + "]";
          }
          
          
          
          
}
