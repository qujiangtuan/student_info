package com.qujia.model;

import java.io.File;

public class Notice {
          private String title;
          private String writer;
          private String obj;
          private String content;
          private String fileName;
          private long size1;
          private File file;
          private String loginDate;
          private String num;//계산
          private String id;
          
          
          
          
          
          public String getId() {
                    return id;
          }
          public void setId(String id) {
                    this.id = id;
          }
          public String getNum() {
                    return num;
          }
          public void setNum(String num) {
                    this.num = num;
          }
          public String getTitle() {
                    return title;
          }
          public void setTitle(String title) {
                    this.title = title;
          }
          public String getWriter() {
                    return writer;
          }
          public void setWriter(String writer) {
                    this.writer = writer;
          }
          public String getObj() {
                    return obj;
          }
          public void setObj(String obj) {
                    this.obj = obj;
          }
          public String getContent() {
                    return content;
          }
          public void setContent(String content) {
                    this.content = content;
          }
          public String getFileName() {
                    return fileName;
          }
          public void setFileName(String fileName) {
                    this.fileName = fileName;
          }
          public long getSize1() {
                    return size1;
          }
          public void setSize1(long size) {
                    this.size1 = size;
          }
          public File getFile() {
                    return file;
          }
          public void setFile(File file) {
                    this.file = file;
          }
          public String getLoginDate() {
                    return loginDate;
          }
          public void setLoginDate(String loginDate) {
                    this.loginDate = loginDate;
          }
          
          
}
