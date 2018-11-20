package com.qujia.model;

import java.io.InputStream;

public class ProCourseView {
          private String couName;
          private String couNo;
          private String proName;
          private String pno;
          private String classNo;
          private String ttcr;
          //file table
          private String id;
          private String name;
          private int size1;
          private String file1;
          private int lecEvaMark;
          
          //file inputStream
          private InputStream reader;
          private String eva;//주관식 평가결과
          
          
          
          



          
          public String getEva() {
                    return eva;
          }
          public void setEva(String eva) {
                    this.eva = eva;
          }
          public String getPno() {
                    return pno;
          }
          public void setPno(String pno) {
                    this.pno = pno;
          }
          public InputStream getReader() {
                    return reader;
          }
          public void setReader(InputStream reader) {
                    this.reader = reader;
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
 
          public String getId() {
                    return id;
          }
          public void setId(String id) {
                    this.id = id;
          }
          public String getName() {
                    return name;
          }
          public void setName(String name) {
                    this.name = name;
          }
          public int getSize1() {
                    return size1;
          }
          public void setSize1(int size1) {
                    this.size1 = size1;
          }
          public String getFile1() {
                    return file1;
          }
          public void setFile1(String file1) {
                    this.file1 = file1;
          }
          public int getLecEvaMark() {
                    return lecEvaMark;
          }
          public void setLecEvaMark(int lecEvaMark) {
                    this.lecEvaMark = lecEvaMark;
          }
         
          
          
          
}
