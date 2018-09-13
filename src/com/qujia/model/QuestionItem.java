package com.qujia.model;

public class QuestionItem {
          private int itemNo;
          private String itemContent;
          private String score;
          public int getItemNo() {
                    return itemNo;
          }
          public void setItemNo(int itemNo) {
                    this.itemNo = itemNo;
          }
          public String getItemContent() {
                    return itemContent;
          }
          public void setItemContent(String itemContent) {
                    this.itemContent = itemContent;
          }
          public String getScore() {
                    return score;
          }
          public void setScore(String score) {
                    this.score = score;
          }
          @Override
          public String toString() {
                    return "QuestionItem [itemNo=" + itemNo + ", itemContent="
                                        + itemContent + ", score=" + score
                                        + "]";
          }
          
}
