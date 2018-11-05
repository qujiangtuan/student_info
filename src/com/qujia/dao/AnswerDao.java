package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Answer;
import com.qujia.util.StringUtil;

public class AnswerDao extends BaseDao {

          public boolean AddAnswer(Answer ans) {
                    String sql=" insert into answer values(ans_seq.nextval,?,?,?)";
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
                              prst.setString(1,ans.getAnsName());
                              prst.setString(2, ans.getAnsType());
                              prst.setInt(3,ans.getInfo());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }

          public List<Answer> getAnsList(Answer ans) {
                    List<Answer> retList = new ArrayList<Answer>();
                    StringBuffer sqlString=new StringBuffer("select * from answer");
                    PreparedStatement prst;
                    if(!StringUtil.isEmpty(ans.getAnsName())){
                              sqlString.append(" and ans_name like '%"+ans.getAnsName()+"%'");
                    }
                    if(!StringUtil.isEmpty(ans.getAnsType())){
                              sqlString.append(" and ans_type like '%"+ans.getAnsType()+"%'");
                    }
                    try {
                              prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        Answer ansData = new Answer();
                                        ansData.setId(rs.getString("id"));
                                        ansData.setAnsName(rs.getString("ans_name"));
                                        ansData.setAnsType(rs.getString("ans_type"));
                                        ansData.setInfo(rs.getInt("info"));
                                        retList.add(ansData);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return retList;
          }

          public boolean updateAns(Answer ans) {
                    String sql="update answer set ans_name=? , ans_type=? , info=?  where id=?";
                    PreparedStatement prst;
                    try {
                              prst = con.prepareStatement(sql);
                              prst.setString(1, ans.getAnsName());
                              prst.setString(2, ans.getAnsType());
                              prst.setInt(3,ans.getInfo());
                              prst.setString(4,ans.getId());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean deleteAns(String id) {
                    String sql="delete from answer where id="+id;
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
