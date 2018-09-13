package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.StudentClass;
import com.qujia.util.StringUtil;

/**
 * 班级信息与数据库的操作
 * @author qujia
 *
 */
public class ClassDao extends BaseDao {
          public boolean addClass(StudentClass scl){
                    String sql = "insert into s_class values(?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setInt(1, scl.getId());
                              prst.setString(2, scl.getName());
                              prst.setString(3,scl.getInfo());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          public List<StudentClass> getClassList(StudentClass studentClass){
                    List<StudentClass> retList=new ArrayList<StudentClass>();
                    String sqlString="select * from s_class";
                    if(!StringUtil.isEmpty(studentClass.getName())){
                              sqlString += " where name like '%"+studentClass.getName()+"%'";
                    }
                    try {
                              PreparedStatement preparedStatement=con.prepareStatement(sqlString);
                              //preparedStatement.setString(1, "%"+studentClass.getName()+"%");
                              ResultSet executeQuery = preparedStatement.executeQuery();
                              while(executeQuery.next()){
                                        StudentClass sc=new StudentClass();
                                        sc.setId(executeQuery.getInt("id"));
                                        sc.setName(executeQuery.getString("name"));
                                        sc.setInfo(executeQuery.getString("info"));
                                        retList.add(sc);
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
          //delete class
          public boolean delete(int id){
                    String sql="delete from s_class where id=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setInt(1, id);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return false;
          }
          //update class
          public boolean update(StudentClass sc){
                    String sql="update s_class set name = ?, info = ? where id = ?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);  
                              prst.setString(1, sc.getName());
                              prst.setString(2, sc.getInfo());
                              prst.setInt(3,sc.getId());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
}
