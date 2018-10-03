package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Student;
import com.qujia.util.StringUtil;

public class StudentDao extends BaseDao{
			//student login
	public Student login(Student student){

        String sql = "select * from student where sno=? and password= ?";
        Student studentRst=null;
       ResultSet rs=null;
        try {
                  //把sql语句传给数据库操作对象
                  PreparedStatement prst = con.prepareStatement(sql);
                  prst.setString(1, student.getsNo());
                  prst.setString(2, student.getPassword());
                  rs = prst.executeQuery();;
                  while(rs.next()){
                	  studentRst = new Student();
                	  studentRst.setsNo(rs.getString("sno"));
                	  studentRst.setName(rs.getString("name"));
                	  studentRst.setPassword(rs.getString("password"));
                 }
        } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
        }
        this.closeDao();
        return studentRst;
       
	}
			//add student
            public boolean addStudent(Student student){
                      String sql="insert into student values(?,?,?,?,?,?,?,?,?,?,null,null,null)";
                      try {
                                PreparedStatement prst=con.prepareStatement(sql);
                                prst.setString(1, student.getsNo());
                                prst.setString(2, student.getName());
                                prst.setString(3,student.getOrgId());
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
            public boolean UpdateAppendMajor(Student student){
//            	update student set major_type='123',major='345',applydate='2015-03-49' where name='gerge'
                String sql="update student set major_type=?,major=?,applydate=? where name=?";
                try {
                          PreparedStatement prst=con.prepareStatement(sql);
                          prst.setString(1, student.getMajorType());
                          prst.setString(2, student.getMajor());
                          prst.setString(3,student.getApplyDate());
                          prst.setString(4,student.getName());
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
                      if(!StringUtil.isEmpty(student.getOrgId())){
                                sqlString.append(" and orgid = '"+student.getOrgId()+"'");
                      }
                      try {
                                PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                                //preparedStatement.setString(1, "%"+Student.getName()+"%");
                                ResultSet executeQuery = prst.executeQuery();
                                while(executeQuery.next()){
                                          Student s =new Student();
                                          s.setsNo(executeQuery.getString("sno"));
                                          s.setName(executeQuery.getString("name"));
                                          s.setOrgId(executeQuery.getString("orgid"));
                                          s.setSex(executeQuery.getString("sex"));
                                          s.setIdCardNo(executeQuery.getString("idcardno"));
                                          s.setJoinDate(executeQuery.getString("joindate"));
                                          s.setEmail(executeQuery.getString("email"));
                                          s.setPassword(executeQuery.getString("password"));
                                          s.setTel(executeQuery.getString("tel"));
                                          s.setAdress(executeQuery.getString("address"));
                                          s.setMajorType(executeQuery.getString("major_type"));
                                          s.setMajor(executeQuery.getString("major"));
                                          s.setApplyDate(executeQuery.getString("applydate"));
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
                      String sql="update student set orgid=? where sno=?";
                      try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,student.getOrgId());
                              prst.setString(2,student.getsNo());
//                              prst.setString(3, student.getSex());
//                              prst.setString(4,student.getEmail());
//                              prst.setString(5,student.getTel());
//                              prst.setString(6,student.getAdress());
//                              prst.setString(7, student.getsNo());
                              
                              if(prst.executeUpdate()>0){ 
                                        return true;
                              }
                              
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                      return false;
            }
          //update password
            public String editPassword(Student student,String newPasswrod){
                      String sql = "select * from student where sno= ? and password= ?";
                      PreparedStatement prst =null;
                      ResultSet rs;
                      //String sno=null;
                      try {
                                prst= con.prepareStatement(sql);
                                prst.setString(1, student.getsNo());
                                prst.setString(2, student.getPassword());
                                rs = prst.executeQuery();
                                if(!rs.next()){
                                          String retString ="옛 암호 오류！";
                                          return retString;
                                }
                                //sno=rs.getString("sno");
                                //id=rs.getInt("id");
                                //System.out.println("id:"+id);
                      } catch (SQLException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                      }
                      String retString ="수정 실패";
                      String sqlString = "update student set password = ? where sno = ?";
                       
                      try {
                                prst = con.prepareStatement(sqlString);
                                prst.setString(1, newPasswrod);
                                prst.setString(2, student.getsNo());
                               int rst= prst.executeUpdate();
                                if(rst>0){
                                          retString="암호 수정 성공했습니다！";
                                }
                      } catch ( Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                      }
                      
                      return retString;
            }
}
