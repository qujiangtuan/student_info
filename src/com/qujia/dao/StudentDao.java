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
                	  studentRst.setOrgId(rs.getString("orgid"));
                	  studentRst.setSex(rs.getString("sex"));
                	  studentRst.setIdCardNo(rs.getString("idcardno"));
                	  studentRst.setJoinDate(rs.getString("joindate"));
                	  studentRst.setEmail(rs.getString("email"));
                	  studentRst.setPassword(rs.getString("password"));
                	  studentRst.setTel(rs.getString("tel"));
                	  studentRst.setAdress(rs.getString("address"));
                	  studentRst.setMajorType(rs.getString("major_type"));
                	  studentRst.setMajor(rs.getString("major"));
                	  studentRst.setApplyDate(rs.getString("applydate"));
                	  studentRst.setInSchState(rs.getString("insch_status"));
                	  studentRst.setDegreeProcess(rs.getString("degree"));
                	  studentRst.setInSchYear(rs.getString("sch_year"));
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
                      String sql="insert into student values(?,?,?,?,?,?,?,?,?,?,null,null,null,'재학중',?,?,?)";
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
                                prst.setString(11,student.getDegreeProcess());
                                prst.setString(12,student.getInSchYear());
                                prst.setString(13,student.getDeptName());
                                
                                if(prst.executeUpdate()>0) return true;
                      } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                      }
                      return false;
            }
            public boolean UpdateAppendMajor(Student student){
//            	update student set major_type='123',major='345',applydate='2015-03-49' where name='gerge'
                String sql="update student set major_type=?,major=?,applydate=? where sno=?";
                try {
                          PreparedStatement prst=con.prepareStatement(sql);
                          prst.setString(1, student.getMajorType());
                          prst.setString(2, student.getMajor());
                          prst.setString(3,student.getApplyDate());
                          prst.setString(4,student.getsNo());
                          if(prst.executeUpdate()>0) return true;
                } catch (SQLException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                }
                return false;
      }
            public List<Student> getStudentList(Student student){
//                      System.out.println("--------");
//                      System.out.println("name="+student.getName());
//                      System.out.println("sno="+student.getsNo());
//                      System.out.println("deptname="+student.getDeptName());
//                      System.out.println("orgid="+student.getOrgId());
                      
                      List<Student> retList=new ArrayList<Student>();
                      StringBuffer sqlString=new StringBuffer("select * from student");
                      String sql = null;
                      if(!StringUtil.isEmpty(student.getOrgId())&&StringUtil.isEmpty(student.getDeptName())
                                          ||StringUtil.isEmpty(student.getsNo())
                                          ||!StringUtil.isEmpty(student.getName())){
                                sql="select * from student where orgid in(select org_code from org where par_org='"
                                                              +student.getOrgId()+"') or orgid ='"
                                                              +student.getOrgId()+"'  order by deptname desc";
                      }
                      if(!StringUtil.isEmpty(student.getName())){
                                sqlString.append(" and name like '%"+student.getName()+"%'");
                      }
                      if(!StringUtil.isEmpty(student.getsNo())){
                                sqlString.append(" and sno like '%"+student.getsNo()+"%'");
                      }
                      if(!StringUtil.isEmpty(student.getDeptName())){
                                sqlString.append(" and deptname like '%"+student.getDeptName()+"%'");
                      }
                     
                      try {
                                PreparedStatement prst;
                                if(!StringUtil.isEmpty(student.getOrgId())&&StringUtil.isEmpty(student.getName())
                                                    &&StringUtil.isEmpty(student.getsNo())
                                                    &&!StringUtil.isEmpty(student.getDeptName())){
                                          prst=con.prepareStatement(sql);
                                }else{
                                          prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                                }
                                
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
                                          s.setInSchState(executeQuery.getString("insch_status"));
                                          s.setDegreeProcess(executeQuery.getString("degree"));
                                          s.setInSchYear(executeQuery.getString("sch_year"));
                                          s.setDeptName(executeQuery.getString("deptname"));
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
                      String sql="update student set orgid=?,insch_status=?,deptname=?   where sno=?";
                      try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,student.getOrgId());
                              prst.setString(2,student.getInSchState());
//                              prst.setString(3,student.getDegreeProcess());
                              prst.setString(3, student.getDeptName());
                              prst.setString(4,student.getsNo());
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
            //학번과 이메일 있는 지 확인
          public boolean isStudent(Student stu) {
                    String sql="select * from student where sno=? and email=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, stu.getsNo());
                              prst.setString(2, stu.getEmail());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          //이메일로 비밀번호 수정
          public boolean updatePassword(Student stu, String random) {
                    String sql = "update student set password=?  where sno=?";
                    PreparedStatement prst =null;
                    ResultSet rs;
                    try {
                              prst= con.prepareStatement(sql);
                              prst.setString(1, random);
                              prst.setString(2, stu.getsNo());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          public Student searchOldPassword(Student student) {
                              String sql = "select password from student where sno= ? ";
                              PreparedStatement prst =null;
                              Student stRst=null;
                              ResultSet rs;
                              int id=0;
                              try {
                                        prst= con.prepareStatement(sql);
                                        prst.setString(1, student.getsNo());
                                        rs = prst.executeQuery();
                                        while(rs.next()){
                                                  stRst = new Student();
                                                  stRst.setPassword(rs.getString("password"));
                                       }
                              } catch (SQLException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                              }
                    return stRst;
          }
//          public String getStNameById(Student st) {
//                    String sql = "select name from student where sno= ? ";
//                    PreparedStatement prst =null;
//                    String nameData=null;
//                    ResultSet rs;
//                    int id=0;
//                    try {
//                              prst= con.prepareStatement(sql);
//                              prst.setString(1, st.getsNo());
//                              rs = prst.executeQuery();
//                              while(rs.next()){
//                                        nameData=rs.getString("name");
//                             }
//                    } catch (SQLException e1) {
//                              // TODO Auto-generated catch block
//                              e1.printStackTrace();
//                    }
//                    return nameData;
//          }
          public Student getSelectRowObject(Student student) {
                    String sql = "select * from student where sno= ? ";
                    PreparedStatement prst =null;
                    Student setStu=null;
                    ResultSet rs;
                    int id=0;
                    try {
                              prst= con.prepareStatement(sql);
                              prst.setString(1, student.getsNo());
                              rs = prst.executeQuery();
                              while(rs.next()){
                                        setStu=new Student();
                                        setStu.setsNo(rs.getString("sno"));
                                        setStu.setName(rs.getString("name"));
                                        setStu.setOrgId(rs.getString("orgid"));
                                        setStu.setDeptName(rs.getString("deptname"));
                             }
                    } catch (SQLException e1) {
                              // TODO Auto-generated catch block
                              e1.printStackTrace();
                    }
                    return setStu;
          }
}
