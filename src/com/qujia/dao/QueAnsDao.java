package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.QueAns;
import com.qujia.util.StringUtil;

public class QueAnsDao extends BaseDao {

          public String getQueIdByName(String queName) {
                    String sql="select id from question where que=?";
                    String id=null;
                    ResultSet rs=null;
                     try {
                               PreparedStatement prst = con.prepareStatement(sql);
                               prst.setString(1, queName);
                               rs = prst.executeQuery();;
                               while(rs.next()){
                                          id = rs.getString("id");
                              }
                     } catch (SQLException e) {
                               e.printStackTrace();
                     }
                     this.closeDao();
                     return id;
          }
          public String getAnsIdByName(String ansName) {
                    String sql="select id from answer where ans_name=?";
                    String id=null;
                    ResultSet rs=null;
                     try {
                               PreparedStatement prst = con.prepareStatement(sql);
                               prst.setString(1, ansName);
                               rs = prst.executeQuery();;
                               while(rs.next()){
                                          id = rs.getString("id");
                              }
                     } catch (SQLException e) {
                               e.printStackTrace();
                     }
                     this.closeDao();
                     return id;
          }

          public boolean AddQueAns(QueAns qa) { 
                    String sql="insert into que_ans values(que_ans_seq.nextval,?,?,?,?)";
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
                              prst.setString(1,qa.getQueId());
                              prst.setString(2, qa.getQueName());
                              prst.setString(3,qa.getAnsId());
                              prst.setString(4,qa.getAnsName());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }

          public List<QueAns> getQueAns(QueAns qa) {
                    List<QueAns> retList = new ArrayList<QueAns>();
                    StringBuffer sqlString=new StringBuffer("select * from que_ans where nvl(ans_name,'')<>'대강써라' ");
                    PreparedStatement prst;
                    if(!StringUtil.isEmpty(qa.getQueName())){
                              sqlString.append(" and que_name like '%"+qa.getQueName()+"%'");
                    }
                    try {
//                              prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              prst=con.prepareStatement(sqlString.toString());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        QueAns qaData = new QueAns();
                                        qaData.setId(rs.getString("id"));
                                        qaData.setQueId(rs.getString("que_id"));
                                        qaData.setQueName(rs.getString("que_name"));
                                        qaData.setAnsId(rs.getString("ans_id"));
                                        qaData.setAnsName(rs.getString("ans_name"));
                                        retList.add(qaData);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return retList;
          }
          public QueAns getQueKai(QueAns qa) {
                    String sqlString="select * from que_ans where ans_name='대강써라' ";
                    PreparedStatement prst;
                    QueAns qaData=null;
                    try {
                              prst=con.prepareStatement(sqlString );
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        qaData = new QueAns();
                                        qaData.setId(rs.getString("id"));
                                        qaData.setQueId(rs.getString("que_id"));
                                        qaData.setQueName(rs.getString("que_name"));
                                        qaData.setAnsId(rs.getString("ans_id"));
                                        qaData.setAnsName(rs.getString("ans_name"));
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return qaData;
          }
          public boolean updateQueAns(QueAns qa) {
                    String sql="update que_ans set que_id=? ,que_name=?,ans_id=?,ans_name=?  where id=?";
                    PreparedStatement prst;
                    try {
                              prst = con.prepareStatement(sql);
                              prst.setString(1, qa.getQueId());
                              prst.setString(2, qa.getQueName());
                              prst.setString(3,qa.getAnsId());
                              prst.setString(4,qa.getAnsName());
                              prst.setString(5,qa.getId());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }
          
          public boolean deleteQueAns(String id) {
                    String sql="delete from que_ans where id="+id;
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    return false;
          }
          
}
