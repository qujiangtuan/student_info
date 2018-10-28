package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.PerCourse;
import com.qujia.util.StringUtil;

public class PerCourseDao extends BaseDao {

          public boolean addApplyCourse(PerCourse pc) {
                    String sql = "insert into per_course(year,term,cou_name,cou_no,learn_type,class_no,"
                                        + "credit_type,tt_cr,stu_no,stu_name,cou_dept,stu_dept,proname,pno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    try {
                     PreparedStatement prst=con.prepareStatement(sql);
                     prst.setString(1, pc.getYear());
                     prst.setInt(2, pc.getTerm());
                     prst.setString(3, pc.getCouName());
                     prst.setString(4, pc.getCouNo());
                     prst.setString(5, pc.getLearnType());
                     prst.setString(6, pc.getClassNo());
                     prst.setInt(7, pc.getCreditType());
                     prst.setString(8, pc.getTtcr());
                     prst.setString(9,pc.getSno());
                     prst.setString(10,pc.getsName());
                     prst.setString(11, pc.getCouDept());
                     prst.setString(12,pc.getStuDept());
                     prst.setString(13, pc.getProName());
                     prst.setString(14, pc.getProId());
                     if (prst.executeUpdate() > 0)
                               return true;            
           } catch (SQLException e) {
                     e.printStackTrace();
           }
                    return false;
          }

          public List<PerCourse> getPCList(PerCourse perCourse,String sno) {
                    List<PerCourse> retList=new ArrayList<PerCourse>();
                  String sqlString="select * from per_course where stu_no=?";
                  try {
                            PreparedStatement prst=con.prepareStatement(sqlString);
                            prst.setString(1,sno);
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
                                      pcData.setCreditType(e.getInt("credit_type"));
                                      pcData.setTtcr(e.getString("tt_cr"));
                                      retList.add(pcData);
                            }
                  } catch (SQLException e) {
                            e.printStackTrace();
                  }
                  
                  return retList;
          }

          public boolean deletePC(String couNo,String sno) {
                    String sql="delete from per_course where cou_no=? and stu_no= ?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, couNo);
                              prst.setString(2,sno);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    return false;
          }

          public int getCouCounts(String sno) {
                    String sqlString="select count(*) count from per_course where stu_no=?";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              prst.setString(1,sno);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        count=e.getInt("count");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return count;
          }
          
          public int getCredit2(String sno) {
                    int counts = getCouCounts(sno);
                    String sqlString="select credit_type from per_course where stu_no=?";
                    int[] creditArray=new int[counts];
                    int creditAll=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              prst.setString(1,sno);
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
          public boolean couIsExist(String couNo,String sno) {
                    String sqlString="select count(*) count from per_course where cou_no=? and stu_no=?";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              prst.setString(1, couNo);
                              prst.setString(2, sno);
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
/*
 * StringBuffer sqlString=new StringBuffer("select * from pro_staff");
        if(!StringUtil.isEmpty(ps.getpName())){
                  sqlString.append(" and pname like '%"+ps.getpName()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getpNo())){
            sqlString.append(" and pno like '%"+ps.getpNo()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getProType())){
                  sqlString.append(" and pro_type like '%"+ps.getProType()+"%'");
        }
//        if(!StringUtil.isEmpty(ps.getPerType())){
//            sqlString.append(" and per_type like '%"+ps.getPerType()+"%'");
//        }
        if(!StringUtil.isEmpty(ps.getOrgName())){
            sqlString.append(" and orgname like '%"+ps.getOrgName()+"%'");
        }
        try {
                  PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
 * 
 * 
 */
          
          public List<PerCourse> getCourseList(PerCourse pc) {
                    List<PerCourse> retList=new ArrayList<PerCourse>();
                    StringBuffer sqlString=new StringBuffer("select * from per_course ");
//                    String sqlString="select * from per_course";
                    if(!StringUtil.isEmpty(pc.getSno())){
                              sqlString.append(" and stu_no like '%"+pc.getSno()+"%'");
                    }
                    if(!StringUtil.isEmpty(pc.getsName())){
                        sqlString.append(" and stu_name like '%"+pc.getsName()+"%'");
                    }
                    if(!StringUtil.isEmpty(pc.getCouNo())){
                              sqlString.append(" and cou_no like '%"+pc.getCouNo()+"%'");
                    }
                    if(!StringUtil.isEmpty(pc.getCouName())){
                              sqlString.append(" and cou_name like '%"+pc.getCouName()+"%'");
                    }
                    if(!StringUtil.isEmpty(pc.getProName())){
                              sqlString.append(" and proname like '%"+pc.getProName()+"%'");
                    }
                    if(!StringUtil.isEmpty(pc.getStuDept())){
                              sqlString.append(" and stu_dept like '%"+pc.getStuDept()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
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
                                        pcData.setCreditType(e.getInt("credit_type"));
                                        pcData.setTtcr(e.getString("tt_cr"));
                                        pcData.setSno(e.getString("stu_no"));
                                        pcData.setCouDept(e.getString("cou_dept"));
                                        pcData.setStuDept(e.getString("stu_dept"));
                                        retList.add(pcData);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    
                    return retList;
          }

          public int getCurrNum(String couNo) {
                    String sqlString="select count(*) count from per_course where cou_no=?";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              prst.setString(1, couNo);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        count=e.getInt("count");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return count;
          }

          public boolean deleteCourse(String sno, String couNo) {
                    String sql="delete from per_course where stu_no=? and cou_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              prst.setString(2, couNo);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    return false;
          }

}
