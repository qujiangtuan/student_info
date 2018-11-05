package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Question;
import com.qujia.util.StringUtil;

public class QuestionDao extends BaseDao {

          public boolean AddQue(Question qu) {
                    String sql="insert into question values(que_seq.nextval,?,?)";
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
                              prst.setString(1,qu.getQue());
                              prst.setString(2, qu.getObj());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }

          public List<Question> getQueList(Question qu) {
                    List<Question> retList = new ArrayList<Question>();
                    StringBuffer sqlString=new StringBuffer("select * from question");
                    PreparedStatement prst;
                    if(!StringUtil.isEmpty(qu.getQue())){
                              sqlString.append(" and que like '%"+qu.getQue()+"%'");
                    }
                    if(!StringUtil.isEmpty(qu.getObj())){
                              sqlString.append(" and obj like '%"+qu.getObj()+"%'");
                    }
                    try {
                              prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        Question quData = new Question();
                                        quData.setId(rs.getString("id"));
                                        quData.setQue(rs.getString("que"));
                                        quData.setObj(rs.getString("obj"));
                                        retList.add(quData);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return retList;
          }

          public boolean updateQuestion(Question qu) {
                    String sql="update question set que=? , obj=?  where id=?";
                    PreparedStatement prst;
                    try {
                              prst = con.prepareStatement(sql);
                              prst.setString(1, qu.getQue());
                              prst.setString(2, qu.getObj());
                              prst.setString(3,qu.getId());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean deleteQue(String id) {
                    String sql="delete from question where id="+id;
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
