package com.qujia.model;

public class TimeView {
          private String ttNo;
          private String week;
          private String startTime;
          private String endTime;
          private String crName;
          private String couNo;
          private int crNo;
          
          public String getTtNo() {
                    return ttNo;
          }
          public void setTtNo(String ttNo) {
                    this.ttNo = ttNo;
          }
          public int getCrNo() {
                    return crNo;
          }
          public void setCrNo(int crNo) {
                    this.crNo = crNo;
          }
          public String getWeek() {
                    return week;
          }
          public void setWeek(String week) {
                    this.week = week;
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
          public String getCrName() {
                    return crName;
          }
          public void setCrName(String crName) {
                    this.crName = crName;
          }
          public String getCouNo() {
                    return couNo;
          }
          public void setCouNo(String couNo) {
                    this.couNo = couNo;
          }
          @Override
          public String toString() {
                    return week +crName+"("
                                        + startTime + " - " + endTime
                                        + ")" ;
          }
          
}
