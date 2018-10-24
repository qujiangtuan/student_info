package com.qujia.model;

public class PerCourse {
          private String year;
          private int term;
          private String couName;
          private String couNo;
          private String learnType;
          private int creditType;
          private String proId;
          private String proName;
          private String classNo;
          private String ttcr;
          private String grade;
          private String sno;//학번
          private String sName;//학생명
          private String couDept;//수강대상 /교과목소속학과
          private String stuDept;//학생 소속학과
          
          
          
         
          public String getCouDept() {
                    return couDept;
          }
          public void setCouDept(String couDept) {
                    this.couDept = couDept;
          }
          public String getStuDept() {
                    return stuDept;
          }
          public void setStuDept(String stuDept) {
                    this.stuDept = stuDept;
          }
          public String getsName() {
                    return sName;
          }
          public void setsName(String sName) {
                    this.sName = sName;
          }
          public String getSno() {
                    return sno;
          }
          public void setSno(String sno) {
                    this.sno = sno;
          }
          public int getCreditType() {
                    return creditType;
          }
          public void setCreditType(int creditType) {
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
