package com.qujia.model;

public class ClassRoom {
          private Integer crNo;
          private String crName;
          private String crExplain; //教室说明
          
          public ClassRoom() {
                    super();
          }
           
          public Integer getCrNo() {
                    return crNo;
          }
          public void setCrNo(Integer crNo) {
                    this.crNo = crNo;
          }
          public String getCrName() {
                    return crName;
          }
          public void setCrName(String crName) {
                    this.crName = crName;
          }
          public String getCrExplain() {
                    return crExplain;
          }
          public void setCrExplain(String crExplain) {
                    this.crExplain = crExplain;
          }
          @Override
          public String toString() {
                    return "ClassRoom [crNo=" + crNo + ", crName=" + crName
                                        + ", crExplain=" + crExplain + "]";
          }
          
          
}
