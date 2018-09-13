package com.qujia.model;



public class TableTime {
          private int week;
          private Boolean bool;
          private String dateStart;
          private String dateEnd;
          private ClassRoom cr;
          
          public int getWeek() {
                    return week;
          }
          public int setWeek(int week) {
                    return this.week = week;
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
          public ClassRoom getCr() {
                    return cr;
          }
          public void setCr(ClassRoom cr) {
                    this.cr = cr;
          }
          @Override
          public String toString() {
                    return "TableTime [bool=" + bool + ", dateStart="
                                        + dateStart + ", dateEnd=" + dateEnd
                                        + ", cr=" + cr + "]";
          }
          
}
