package com.qujia.model;



public class TimeTable {
          private String ttNo;
          private String week;
          private Boolean bool;
          private String dateStart;
          private String dateEnd;
//          private ClassRoom cr;
//          private OpenCourse oc;
          private int crId;
          private String couNo;
          private String crName;
          
          
           
          public String getCrName() {
                    return crName;
          }
          public void setCrName(String crName) {
                    this.crName = crName;
          }
          //          public OpenCourse getOc() {
//                    return oc;
//          }
//          public void setOc(OpenCourse oc) {
//                    this.oc = oc;
//          }
          public String getTtNo() {
                    return ttNo;
          }
          public void setTtNo(String ttNo) {
                    this.ttNo = ttNo;
          }
          public String getWeek() {
                    return week;
          }
          public void setWeek(String week) {
                    this.week = week;
          }
          public Boolean getBool() {
                    return bool;
          }
          public Boolean setBool(Boolean bool) {
                    return this.bool = bool;
          }
          
          public String getDateStart() {
                    return dateStart;
          }
          public void setDateStart(String dateStart) {
                    this.dateStart = dateStart;
          }
          public String getDateEnd() {
                    return dateEnd;
          }
          public void setDateEnd(String dateEnd) {
                    this.dateEnd = dateEnd;
          }
//          public ClassRoom getCr() {
//                    return cr;
//          }
//          public void setCr(ClassRoom cr) {
//                    this.cr = cr;
//          }
          
       
          public String getCouNo() {
                    return couNo;
          }
       
          public int getCrId() {
                    return crId;
          }
          public void setCrId(int crId) {
                    this.crId = crId;
          }
          public void setCouNo(String couNo) {
                    this.couNo = couNo;
          }
          @Override
          public String toString() {
                    return week +crName+"("
                                        + dateStart + " - " + dateEnd
                                        + ")" ;
          }
      
          
          
}
