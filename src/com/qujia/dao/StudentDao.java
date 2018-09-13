package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Student;
import com.qujia.util.StringUtil;

public class StudentDao extends BaseDao{
            public boolean addStudent(Student student){
                      String sql="insert into s_student values(?,?,?,?,?,?,?,? )";
                      try {
                                PreparedStatement prst=con.prepareStatement(sql);
                                prst.setString(1, student.getsNo());
                                prst.setString(2, student.getName());
                                prst.setInt(3,student.getClassId());
                                prst.setString(4,student.getSex());
                                prst.setString(5, student.getIdCardNo());
                                prst.setString(6, student.getJoinDate());
                                prst.setString(7, student.getEmail());
                                prst.setString(8,student.getPassword());
                                
                                if(prst.executeUpdate()>0) return true;
                      } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                      }
                      return false;
            }
            public List<Student> getStudentList(Student student){
                      List<Student> retList=new ArrayList<Student>();
                      StringBuffer sqlString=new StringBuffer("select * from s_student");
                      if(!StringUtil.isEmpty(student.getName())){
                                sqlString.append(" and name like '%"+student.getName()+"%'");
                      }
                      if(student.getClassId()!=0){
                                sqlString.append(" and classId = "+student.getClassId());
                      }
                      try {
                                PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                                //preparedStatement.setString(1, "%"+Student.getName()+"%");
                                ResultSet executeQuery = prst.executeQuery();
                                while(executeQuery.next()){
                                          Student s =new Student();
                                          s.setsNo(executeQuery.getString("sno"));
                                          s.setName(executeQuery.getString("name"));
                                          s.setClassId(executeQuery.getInt("classid"));
                                          s.setSex(executeQuery.getString("sex"));
                                          s.setIdCardNo(executeQuery.getString("idcardno"));
                                          s.setJoinDate(executeQuery.getString("joindate"));
                                          s.setEmail(executeQuery.getString("email"));
                                          s.setPassword(executeQuery.getString("password"));
                                          retList.add(s);
                                }
                      } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                      }
                      
                      return retList;
            }
          //delete student
            public boolean delete(int sNo){
                      String sql="delete from s_student where sNo=?";
                      try {
                                PreparedStatement prst=con.prepareStatement(sql);
                                prst.setInt(1, sNo);
                                if(prst.executeUpdate()>0){
                                          return true;
                                }
                      } catch (SQLException e) {    
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                      }
                      
                      return false;
            }
            //update Student
            public boolean updateStudent(Student student){
                      String sql="update s_student set name = ? , classid=?,sex=?,email=? where sno=?";
                      try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,student.getName());
                              prst.setInt(2,student.getClassId());
                              prst.setString(3, student.getSex());
                              prst.setString(4,student.getEmail());
                              prst.setString(5, student.getsNo());
                              
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
