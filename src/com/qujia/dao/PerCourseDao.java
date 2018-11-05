package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.PerCourse;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;

public class PerCourseDao extends BaseDao {

          public boolean addApplyCourse(PerCourse pc) {
                    String sql = "insert into per_course(year,term,cou_name,cou_no,learn_type,class_no,"
                                        + "credit_type,tt_cr,stu_no,stu_name,cou_dept,stu_dept,proname,pno,is_eva) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,'no')";
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

          public List<PerCourse> getPCList(PerCourse per,String sno) {
                    List<PerCourse> retList=new ArrayList<PerCourse>();
//                  String sqlString="select * from per_course where stu_no=? order by year,term";
                    String sqlString;
//                  sqlString=new StringBuffer("select * from per_course where stu_no=? order by year,term ");
                  if(StringUtil.isEmpty(per.getYear())&&per.getTerm()==0){
                            sqlString="select * from per_course where stu_no='"+sno+"' order by year,term ";
                  }else{
                            sqlString="select * from per_course where stu_no='"+sno+"' and year like '%"+per.getYear()+"%'  and term like '%"+per.getTerm()+"%' order by year,term ";
                  }
                  try {
                            PreparedStatement prst=con.prepareStatement(sqlString);
//                  try {
//                            PreparedStatement prst=con.prepareStatement(sqlString);
//                            prst.setString(1,sno);
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
                                      pcData.setGrade(e.getString("grade"));
                                      pcData.setScore(e.getDouble("score"));
                                      pcData.setIsEva(e.getString("is_eva"));
                                      retList.add(pcData);
                            }
                  } catch (SQLException e) {
                            e.printStackTrace();
                  }
                  
                  return retList;
          }
          public List<PerCourse> getPCList2(PerCourse per,String sno) {
                    int year1=Integer.parseInt(sno.substring(0, 3));
                    int year2=Integer.parseInt(DateUtil.getThisYear());
                    List<PerCourse> retList=new ArrayList<PerCourse>();
                              PerCourse pc1Data=null;
                              PerCourse pc2Data=null;
                                      int i=year1;
                                      while(i<=year2){
                                                pc1Data =new PerCourse();
                                                pc2Data =new PerCourse();
                                                pc1Data.setYear(i+"");
                                                pc1Data.setTerm(1);
                                                
                                                pc2Data.setYear(i+"");
                                                pc2Data.setTerm(2);
                                                i++;
                                      }
                                      retList.add(pc1Data);
                                      retList.add(pc2Data);
//                                      System.out.println("retList="+retList);
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

          public boolean UpdateScore(PerCourse ss) {
                    String sql="update per_course set grade=?,score=? where cou_no=? and stu_no=?";
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
                              prst.setString(1, ss.getGrade());
                              prst.setDouble(2,ss.getScore());
                              prst.setString(3,ss.getCouNo());
                              prst.setString(4,ss.getSno());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    
                    return false;
          }

          public boolean updateIsEva(String sno, String couNo) {
                    String sql="update per_course set is_eva='yes'  where cou_no=? and stu_no=?";
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
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
          //신청학점 받기
          public int getCreditApply(String year, int term, String sno) {
                    String sql="select sum(credit_type) credit_All from "
                                        +"(select peco.stu_no,peco.year,peco.term,peco.credit_type,peco.grade,peco.score  "
                                        +"from per_course peco where peco.stu_no=? and peco.year=? and peco.term=?)";
                    int countApply=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              prst.setString(2,year);
                              prst.setInt(3,term);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        countApply=e.getInt("credit_All");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return countApply;
          }
          //취득학점 받기
          public int getCreditCurr(String year, int term, String sno) {
                    String sql="select sum(credit_type) credit_curr from "
                                        +" (select peco.stu_no,peco.year,peco.term,peco.credit_type,peco.grade,peco.score  "
                                        +" from per_course peco where peco.stu_no=? and peco.year=? and peco.term=?) t "
                                        +" where nvl(grade,'A')<>'F'";
                    int countCurr=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              prst.setString(2,year);
                              prst.setInt(3,term);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        countCurr=e.getInt("credit_curr");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return countCurr;
          }
          //평점
          public Object getAvg(String year, int term, String sno) {
                    String sql="select avg(score) avg_score from "
                                        +"(select peco.stu_no,peco.year,peco.term,peco.credit_type,peco.grade,peco.score  "
                                        +"from per_course peco where peco.stu_no=? and peco.year=? and peco.term=?)";
                    int avgScore=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              prst.setString(2,year);
                              prst.setInt(3,term);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        avgScore=e.getInt("avg_score");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return avgScore;
          }
          //전필
          public int getMajMust(String sno) {
                    String sql="select sum(credit_type) maj_must_sum from "
                                        +" (select peco.stu_no,peco.year,peco.term,peco.credit_type,peco.grade,peco.score "
                                        + " from per_course peco where peco.stu_no=? and learn_type='전필')";
                    int majMustSum=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        majMustSum=e.getInt("maj_must_sum");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return majMustSum;
                    
          }
          //전선
          public int getMajCho(String sno) {
                    String sql="select sum(credit_type) maj_cho_sum from "
                                        +" (select peco.stu_no,peco.year,peco.term,peco.credit_type,peco.grade,peco.score "
                                        + " from per_course peco where peco.stu_no=? and learn_type='전선')";
                    int majChoSum=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        majChoSum=e.getInt("maj_cho_sum");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return majChoSum;
                    
          }
          //교필
          public int getCulMust(String sno) {
                    String sql="select sum(credit_type) cul_must_sum from "
                                        +" (select peco.stu_no,peco.year,peco.term,peco.credit_type,peco.grade,peco.score "
                                        + " from per_course peco where peco.stu_no=? and learn_type='교필')";
                    int CulMustSum=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        CulMustSum=e.getInt("cul_must_sum");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return CulMustSum;
                    
          }
          //교선
          public int getCulCho(String sno) {
                    String sql="select sum(credit_type) cul_cho_sum from "
                                        +" (select peco.stu_no,peco.year,peco.term,peco.credit_type,peco.grade,peco.score "
                                        + " from per_course peco where peco.stu_no=? and learn_type='교선')";
                    int culChoSum=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sno);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        culChoSum=e.getInt("cul_cho_sum");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return culChoSum;
          }
}
