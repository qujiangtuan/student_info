package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Subjects;
import com.qujia.util.StringUtil;

public class SubjectsDao extends BaseDao {
          //subject login
          public boolean addSubjects(Subjects sbj){
                    String sql="insert into subject values(?,?,?,?,?,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sbj.getSubCode() );
                              prst.setString(2, sbj.getSubName());
                              prst.setString(3, sbj.getSubEname());
                              prst.setString(4, sbj.getLearnType());
                              prst.setString(5, sbj.getOrgId() );
                              prst.setString(6, sbj.getColType());
                              prst.setString(7, sbj.getSubExp());
                              prst.setString(8,sbj.getOrgName());
                              prst.setInt(9, sbj.getCreditType());
                              prst.setString(10,sbj.getSchYear());
                              prst.setString(11,sbj.getEnvMethod());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          public List<Subjects> getSubjectsList(Subjects sb){
                    List<Subjects> retList=new ArrayList<Subjects>();
                    StringBuffer sqlString=new StringBuffer("select * from subject");
                    if(!StringUtil.isEmpty(sb.getSubName())){
                              sqlString.append(" and sub_name like '%"+sb.getSubName()+"%'");
                    }
                    if(!StringUtil.isEmpty(sb.getOrgName())){
                              sqlString.append(" and orgname like '%"+sb.getOrgName()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        Subjects sbj=new Subjects();
                                        sbj.setSubCode(e.getString("sub_cod"));
                                        sbj.setSubName(e.getString("sub_name"));
                                        sbj.setSubEname(e.getString("sub_ename"));
                                        sbj.setLearnType(e.getString("learn_type"));
                                        sbj.setCreditType(e.getInt("credit_type"));
                                        sbj.setOrgId(e.getString("orgid"));
                                        sbj.setColType(e.getString("col_type"));
                                        sbj.setSubExp(e.getString("sub_exp"));
                                        sbj.setOrgName(e.getString("orgname"));
                                        sbj.setSchYear(e.getString("schyear"));
                                        sbj.setEnvMethod(e.getString("env_method"));
                                        retList.add(sbj);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
          public boolean updateSubjects(Subjects sub) {
                    String sql="update subject set learn_type=?,credit_type=?,col_type=?,sub_exp=?,schyear=?,env_method=?  where sub_cod=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sub.getLearnType());
                              prst.setInt(2, sub.getCreditType());
                              prst.setString(3,sub.getColType());
                              prst.setString(4,sub.getSubExp());
                              prst.setString(5,sub.getSchYear());
                              prst.setString(6,sub.getEnvMethod());
                              prst.setString(7,sub.getSubCode());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }
          public boolean deleteSubjects(String subNO) {
                    String sql="delete from subject where sub_cod=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, subNO);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          public String getSubId(String subName) {
                    String sql="select sub_cod from subject where sub_name= ? ";
                    String subid=null;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, subName);
                              ResultSet rs = prst.executeQuery();
                              while(rs.next()){
                                        subid=rs.getString("sub_cod");
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return subid;
          }
          public String getSubName(String id) {
                    String sql="select sub_name from subject where sub_cod= ? ";
                    String subName=null;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, id);
                              ResultSet rs = prst.executeQuery();
                              while(rs.next()){
                                        subName=rs.getString("sub_name");
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return subName;
          }
}
