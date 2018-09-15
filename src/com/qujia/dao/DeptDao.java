package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Dept;
import com.qujia.util.StringUtil;

public class DeptDao extends BaseDao {
          // add dept
          public boolean addDept(Dept dept) {
                    // "insert into Dept values('01','computer','jingying',60,30,'1992-06-10',132,4,12,'this is computer')";
                    String sql = "insert into Dept values(?,?,?,?,null,?,?,?,?,?)";

                    try {
                              PreparedStatement prst = con
                                                  .prepareStatement(sql);
                              prst.setString(1, dept.getDeptNo());
                              prst.setString(2, dept.getDeptName());
                              prst.setString(3, dept.getCollege());
                              prst.setInt(4, dept.getpNum());
                              prst.setString(5, dept.getLoginDate());
                              prst.setInt(6, dept.getCredit());
                              prst.setInt(7, dept.getYear1());
                              prst.setInt(8, dept.getYear2());
                              prst.setString(9, dept.getDeptExplain());
                              if (prst.executeUpdate() > 0)
                                        return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    this.closeDao();
                    return false;
          }

          // dept list
          public List<Dept> getDeptList(Dept dept) {
                    List<Dept> retList = new ArrayList<Dept>();
                    // String sqlString = "select * from Dept where id='01'";
                    String sqlString = "select * from Dept ";
                    if(!StringUtil.isEmpty(dept.getDeptName())){
                              //sqlString+="select * from Dept where dept_name like '%영%';";
                              sqlString+="where dept_name like '%"+dept.getDeptName()+"%'";
                    }
                    try {
                              PreparedStatement prst = con
                                                  .prepareStatement(sqlString);
                              //prst.setString(1, dept.getDeptNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        Dept deptData = new Dept();
                                        deptData.setDeptNo(rs.getString("id"));
                                        deptData.setDeptName(rs.getString("dept_name"));
                                        deptData.setCollege(rs.getString("college"));
                                        deptData.setpNum(rs.getInt("p_num"));
                                        deptData.setInNum(rs.getInt("in_num"));
                                        deptData.setLoginDate(rs.getString("login_date"));
                                        deptData.setCredit(rs.getInt("credit"));
                                        deptData.setYear1(rs.getInt("year1"));
                                        deptData.setYear2(rs.getInt("year2"));
                                        deptData.setDeptExplain(rs.getString("dept_exp"));
                                        retList.add(deptData);
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return retList;
          }
          //学科删除（delete dept)
          public boolean delete(String id){
//                    String sql="delete from dept where id='02'";
                    String sql="delete from dept where id=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,id);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          //更新学科（uptate dept）
          public boolean updateDept(Dept dept){
//                    String sql="update dept set id='04' ,dept_name='경제학과' , college='경영대학' , p_num=50 , credit=150 , year1=6 , year2=14 , dept_exp='경제학과...' where id='01'";
                    String sql="update dept set dept_name=? , college=? , p_num=?, credit=? , year1=? , year2=? , dept_exp=? where id=?";
                    PreparedStatement prst;
                    try {
                              prst = con.prepareStatement(sql);
//                              prst.setString(1, dept.getDeptNo());
                              prst.setString(1, dept.getDeptName());
                              prst.setString(2,dept.getCollege());
                              prst.setInt(3,dept.getpNum());
                              prst.setInt(4, dept.getCredit());
                              prst.setInt(5, dept.getYear1());
                              prst.setInt(6,dept.getYear2());
                              prst.setString(7,dept.getDeptExplain());
                              prst.setString(8, dept.getDeptNo());
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
