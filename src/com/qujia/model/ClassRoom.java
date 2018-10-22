package com.qujia.model;

public class ClassRoom {
          private int crNo;
          private String crName;
          private int counts;
          private String exp; //교실설명
          
          public ClassRoom() {
                    super();
          }

        


          public int getCrNo() {
                    return crNo;
          }
          public void setCrNo(int crNo) {
                    this.crNo = crNo;
          }
          public String getCrName() {
                    return crName;
          }

          public void setCrName(String crName) {
                    this.crName = crName;
          }

          public int getCounts() {
                    return counts;
          }

          public void setCounts(int counts) {
                    this.counts = counts;
          }

          public String getExp() {
                    return exp;
          }

          public void setExp(String exp) {
                    this.exp = exp;
          }

          @Override
          public String toString() {
                    return crName;
          }
          
           
           
          
          
}
