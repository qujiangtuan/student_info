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
                      String sql="insert into student values(?,?,?,?,?,?,?,?,?,?)";
                      try {
                                PreparedStatement prst=con.prepareStatement(sql);
                                prst.setString(1, student.getsNo());
                                prst.setString(2, student.getName());
                                prst.setString(3,student.getDeptId());
                                prst.setString(4,student.getSex());
                                prst.setString(5, student.getIdCardNo());
                                prst.setString(6, student.getJoinDate());
                                prst.setString(7, student.getEmail());
                                prst.setString(8,student.getPassword());
                                prst.setString(9,student.getTel());
                                prst.setString(10,student.getAdress());
                                
                                if(prst.executeUpdate()>0) return true;
                      } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                      }
                      return false;
            }
            public List<Student> getStudentList(Student student){
                      List<Student> retList=new ArrayList<Student>();
                      StringBuffer sqlString=new StringBuffer("select * from student");
                      if(!StringUtil.isEmpty(student.getName())){
                                sqlString.append(" and name like '%"+student.getName()+"%'");
                      }
                      if(!StringUtil.isEmpty(student.getsNo())){
                                sqlString.append(" and sno like '%"+student.getsNo()+"%'");
                      }
                      if(student.getDeptId()!=null){
                                sqlString.append(" and deptid = '"+student.getDeptId()+"'");
                      }
                      try {
                                PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                                //preparedStatement.setString(1, "%"+Student.getName()+"%");
                                ResultSet executeQuery = prst.executeQuery();
                                while(executeQuery.next()){
                                          Student s =new Student();
                                          s.setsNo(executeQuery.getString("sno"));
                                          s.setName(executeQuery.getString("name"));
                                          s.setDeptId(executeQuery.getString("deptid"));
                                          s.setSex(executeQuery.getString("sex"));
                                          s.setIdCardNo(executeQuery.getString("idcardno"));
                                          s.setJoinDate(executeQuery.getString("joindate"));
                                          s.setEmail(executeQuery.getString("email"));
                                          s.setPassword(executeQuery.getString("password"));
                                          s.setTel(executeQuery.getString("tel"));
                                          s.setAdress(executeQuery.getString("address"));
                                          retList.add(s);
                                }
                      } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                      }
                      
                      return retList;
            }
          //delete student
            public boolean delete(String sNo){
                      String sql="delete from student where sNo=?";
                      try {
                                PreparedStatement prst=con.prepareStatement(sql);
                                prst.setString(1, sNo);
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
                      String sql="update student set name = ? , deptid=?,sex=?,email=? , tel= ?, address=? where sno=?";
                      try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,student.getName());
                              prst.setString(2,student.getDeptId());
                              prst.setString(3, student.getSex());
                              prst.setString(4,student.getEmail());
                              prst.setString(5,student.getTel());
                              prst.setString(6,student.getAdress());
                              prst.setString(7, student.getsNo());
                              
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
