package com.qujia.model;

public class Org {
          private String orgCode;
          private String name;
          private String sName;
          private String orgType;
          private String coGrCode;
          private String gsDepMajCode;
          private String aftType;
          private String parCode;
          private String todayDate;
          
          public String getTodayDate() {
                    return todayDate;
          }
          public void setTodayDate(String todayDate) {
                    this.todayDate = todayDate;
          }
          public String getParCode() {
                    return parCode;
          }
          public void setParCode(String parCode) {
                    this.parCode = parCode;
          }
          public String getOrgCode() {
                    return orgCode;
          }
          public void setOrgCode(String orgCode) {
                    this.orgCode = orgCode;
          }
          public String getName() {
                    return name;
          }
          public void setName(String name) {
                    this.name = name;
          }
          public String getsName() {
                    return sName;
          }
          public void setsName(String sName) {
                    this.sName = sName;
          }
          public String getOrgType() {
                    return orgType;
          }
          public void setOrgType(String orgType) {
                    this.orgType = orgType;
          }
          public String getCoGrCode() {
                    return coGrCode;
          }
          public void setCoGrCode(String coGrCode) {
                    this.coGrCode = coGrCode;
          }
          public String getGsDepMajCode() {
                    return gsDepMajCode;
          }
          public void setGsDepMajCode(String gsDepMajCode) {
                    this.gsDepMajCode = gsDepMajCode;
          }
          public String getAftType() {
                    return aftType;
          }
          public void setAftType(String aftType) {
                    this.aftType = aftType;
          }
          @Override
          public String toString() {
//        	  orgType;//교육기과,소속기관
//              coGrCode;//대학,대학원
//              gsDepMajCode;//학부/학과/전공
//              aftType;/부속기과에서 부분
        	  if(coGrCode==null&&gsDepMajCode==null&&aftType!=null) {
//        		  return "["+orgType+"] / ["+aftType+"] --- "+name;
        		  return name+"--["+aftType+"] / ["+orgType+"] ";
        	  }if(coGrCode!=null&&gsDepMajCode==null&&aftType==null) {
//        		  return "["+orgType+"] / ["+coGrCode+"] --- "+name;
        		  return name+"--["+coGrCode+"] / ["+orgType+"]";
        	  }if(coGrCode==null&&gsDepMajCode!=null&&aftType==null){
        	       return name+"--["+gsDepMajCode+"] / ["+orgType+"]";
        	  }if(aftType==null&&gsDepMajCode==null&&coGrCode==null) {
//        		  return "["+orgType+"] --- "+name;
        		  return name+"--["+orgType+"]";
        	  }else {
//        		  return "["+orgType+"] / ["+coGrCode+"] / ["+gsDepMajCode+"] --- "+name;
        		  return name+"--["+gsDepMajCode+"] / ["+coGrCode+"] / ["+orgType+"]";
        	  }
                    
          }
          
}
