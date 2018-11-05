package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.OpenCourse;
import com.qujia.model.TimeView;
import com.qujia.util.StringUtil;

public class OpenCourseDao extends BaseDao {

          public boolean loginCourse(OpenCourse oc) {
                    String sql="insert into open_course values(?,?,?,?,?,?,?,0,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, oc.getCouNo());
                              prst.setString(2, oc.getSubCode());
                              prst.setString(3,oc.getCouName());
//                              prst.setString(4,oc.getSchYear());
                              prst.setString(4,oc.getProId());
                              prst.setString(5,oc.getClassNo());
                              prst.setString(6,oc.getTerm());
//                              prst.setString(8,oc.getEnvMethod());
                              prst.setInt(7,oc.getFixedNum());
                              prst.setString(8,oc.getStatus());
                              prst.setString(9, oc.getProName());
                              prst.setString(10,oc.getLoginDate());
                              prst.setString(11,oc.getTtcr());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public List<OpenCourse> getOCList(OpenCourse oc) {
                    List<OpenCourse> retList=new ArrayList<OpenCourse>();
                    StringBuffer sqlString=new StringBuffer("select * from open_course");
                    String sql = null;
                    if(!StringUtil.isEmpty(oc.getCouNo())){
                              sqlString.append(" and cou_no like '%"+oc.getCouNo()+"%'");
                    }
                    if(!StringUtil.isEmpty(oc.getCouName())){
                              sqlString.append(" and cou_name like '%"+oc.getCouName()+"%'");
                    }
                    if(!StringUtil.isEmpty(oc.getProName())){
                              sqlString.append(" and proname like '%"+oc.getProName()+"%'");
                    }
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet rs = prst.executeQuery();
                              while(rs.next()){
                                        OpenCourse o =new OpenCourse();
                                        o.setCouNo(rs.getString("cou_no"));
                                        o.setSubCode(rs.getString("sub_code"));
                                        o.setCouName(rs.getString("cou_name"));
//                                        o.setSchYear(rs.getString("schyear"));
                                        o.setProId(rs.getString("proid"));
                                        o.setClassNo(rs.getString("class_no"));
                                        o.setTerm(rs.getString("term"));
//                                        o.setEnvMethod(rs.getString("env_method"));
                                        o.setFixedNum(rs.getInt("fixed_num"));
                                        o.setCurrNum(rs.getInt("curr_num"));
                                        o.setStatus(rs.getString("status"));
                                        o.setLoginDate(rs.getString("logindate"));
                                        o.setTtcr(rs.getString("tt_cr"));
                                        retList.add(o);
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return retList;
          }

          public boolean updateOC(OpenCourse oc) {
                    String sql="update open_course set proid=?,proname=?,term=?,class_no=?,fixed_num=?,status=?,tt_cr=?  where cou_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,oc.getProId());
                              prst.setString(2, oc.getProName());
//                              prst.setString(3,oc.getSchYear());
                              prst.setString(3,oc.getTerm());
                              prst.setString(4,oc.getClassNo());
                              prst.setInt(5,oc.getFixedNum());
                              prst.setString(6, oc.getStatus());
                              prst.setString(7,oc.getTtcr());
                              prst.setString(8, oc.getCouNo());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean deleteOC(String couNO) {
                    String sql="delete from open_course where cou_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, couNO);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return false;
          }
          public List<TimeView> getTimeList(String  couNo) {
                    String sql="select tt_no,week,start_time,end_time,name,cou_no  from time_view  where cou_no=?";
                    List<TimeView> retList=new ArrayList<TimeView>();
                    PreparedStatement prst;
                    try{
                    prst=con.prepareStatement(sql);
                    prst.setString(1,couNo);
                    ResultSet rs = prst.executeQuery();
                    while(rs.next()){
                              TimeView tvdata=new TimeView();
                              tvdata.setTtNo(rs.getString("tt_no"));
                              tvdata.setWeek(rs.getString("week"));
                              tvdata.setCrName(rs.getString("name"));
                              tvdata.setStartTime(rs.getString("start_time"));
                              tvdata.setEndTime(rs.getString("end_time"));
//                              tvdata.setCrNo(rs.getInt("id"));
                              retList.add(tvdata);
                    }
          } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
          }
          //System.out.println(listToString2(retList, ','));        
          return retList;
          }

          public boolean updateCurrNum(String couNo, int count2) {
                    String sql="update open_course set curr_num=?  where cou_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setInt(1, count2);
                              prst.setString(2, couNo);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return false;
          }

          public String getCouName(String cnoInput) {
                    String sql = "select cou_name from open_course where cou_no= ? ";
                    PreparedStatement prst =null;
                    String couName="";
                    ResultSet rs;
                    int id=0;
                    try {
                              prst= con.prepareStatement(sql);
                              prst.setString(1, cnoInput);
                              rs = prst.executeQuery();
                              while(rs.next()){
                                        couName=rs.getString("cou_name");
                             }
                    } catch (SQLException e1) {
                              // TODO Auto-generated catch block
                              e1.printStackTrace();
                    }
                    return couName;
          }

          public boolean isCouNo(String cnoInput) {
                    String sql = "select count(*) count from open_course where cou_no= ? ";
                    PreparedStatement prst =null;
                    int count=0;
                    ResultSet rs;
                    int id=0;
                    try {
                              prst= con.prepareStatement(sql);
                              prst.setString(1, cnoInput);
                              rs = prst.executeQuery();
                              while(rs.next()){
                                        count=rs.getInt("count");
                             }
                              if(count==1) return true;
                    } catch (SQLException e1) {
                              // TODO Auto-generated catch block
                              e1.printStackTrace();
                    }
                    return false;
          }
          
}
