package com.qujia.model;

public class PerCourse {
          private String year;
          private int term;
          private String couName;
          private String couNo;
          private String learnType;
          private String creditType;
          private String proId;
          private String proName;
          private String classNo;
          private String ttcr;
          private String grade;
          
          
          public String getCreditType() {
                    return creditType;
          }
          public void setCreditType(String creditType) {
                    this.creditType = creditType;
          }
          public String getYear() {
                    return year;
          }
          public void setYear(String year) {
                    this.year = year;
          }
          public int getTerm() {
                    return term;
          }
          public void setTerm(int i) {
                    this.term = i;
          }
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
          public String getLearnType() {
                    return learnType;
          }
          public void setLearnType(String learnType) {
                    this.learnType = learnType;
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
          public String getGrade() {
                    return grade;
          }
          public void setGrade(String grade) {
                    this.grade = grade;
          }
          @Override
          public String toString() {
                    return "PerCourse [year=" + year + ", term=" + term
                                        + ", couName=" + couName + ", couNo="
                                        + couNo + ", learnType=" + learnType
                                        + ", creditType=" + creditType
                                        + ", proId=" + proId + ", proName="
                                        + proName + ", classNo=" + classNo
                                        + ", ttcr=" + ttcr + ", grade=" + grade
                                        + "]";
          }
          
          
}
