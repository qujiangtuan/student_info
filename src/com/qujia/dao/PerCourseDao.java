package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.PerCourse;

public class PerCourseDao extends BaseDao {

          public boolean addApplyCourse(PerCourse pc) {
                    String sql = "insert into per_course values(?,?,?,?,?,?,?,?,?,null)";
                    try {
                     PreparedStatement prst=con.prepareStatement(sql);
                     prst.setString(1, pc.getYear());
                     prst.setInt(2, pc.getTerm());
                     prst.setString(3, pc.getCouName());
                     prst.setString(4, pc.getCouNo());
                     prst.setString(5, pc.getLearnType());
                     prst.setString(6, pc.getProName());
                     prst.setString(7, pc.getClassNo());
                     prst.setString(8, pc.getCreditType());
                     prst.setString(9, pc.getTtcr());
//                     prst.setString(10, pc.get);
                     if (prst.executeUpdate() > 0)
                               return true;            
           } catch (SQLException e) {
                     e.printStackTrace();
           }
                    return false;
          }

          public List<PerCourse> getPCList(PerCourse perCourse) {
                    List<PerCourse> retList=new ArrayList<PerCourse>();
                  String sqlString="select * from per_course ";
                  try {
                            PreparedStatement prst=con.prepareStatement(sqlString);
                            //preparedStatement.setString(1, "%"+Student.getName()+"%");
                            ResultSet e = prst.executeQuery();
                            while(e.next()){
                                      PerCourse pcData =new PerCourse();
                                      pcData.setYear(e.getString("year"));
                                      pcData.setTerm(e.getInt("term"));
                                      pcData.setCouName(e.getString("cou_name"));
                                      pcData.setCouNo(e.getString("cou_no"));
                                      pcData.setLearnType(e.getString("learn_type"));
                                      pcData.setProName(e.getString("proname"));
                                      pcData.setClassNo(e.getString("class_no"));
                                      pcData.setCreditType(e.getString("credit_type"));
                                      pcData.setTtcr(e.getString("tt_cr"));
                                      retList.add(pcData);
                            }
                  } catch (SQLException e) {
                            e.printStackTrace();
                  }
                  
                  return retList;
          }

          public boolean deletePC(String couNo) {
                    String sql="delete from per_course where cou_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, couNo);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    return false;
          }

          public int getCouCounts() {
                    String sqlString="select count(*) count from per_course ";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              //preparedStatement.setString(1, "%"+Student.getName()+"%");
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        count=e.getInt("count");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return count;
          }
          
          public int getCredit2() {
                    int counts = getCouCounts();
                    String sqlString="select credit_type from per_course ";
                    int[] creditArray=new int[counts];
                    int creditAll=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              ResultSet e = prst.executeQuery();
                              if(counts==0){
                                        return creditAll=0;
                              }
                              while(e.next()){
                                        creditAll += e.getInt("credit_type");
                              }      
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return creditAll;
          }
          //중복 확인
          public boolean couIsExist(String couNo) {
                    String sqlString="select count(*) count from per_course where cou_no=?";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              prst.setString(1, couNo);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        count=e.getInt("count");
                              }
                              if(count>0) return true;
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }
          
}
