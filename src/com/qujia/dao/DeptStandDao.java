package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.DeptStand;
import com.qujia.util.StringUtil;

public class DeptStandDao extends BaseDao {
          // add dept
          public boolean addDeptStand(DeptStand dStand) {
                   // insert into dept_stand values(stand_seq.nextval,'11334',52,null,'2015-06-20',124,4,12,'')
//                    String sql = "insert into dept_stand values(stand_seq.nextval,?,?,?,null,?,?,?,?)";
                    String sql = "insert into dept_stand values(stand_seq.nextval,?,?,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst = con.prepareStatement(sql);
                              prst.setString(1, dStand.getOrgid());
                              prst.setInt(2, dStand.getMin());
                              prst.setInt(3, dStand.getMax());
//                              prst.setInt(4, dStand.getInNum());
                              prst.setString(4, dStand.getLoginDate());
                              prst.setInt(5, dStand.getYear1());
                              prst.setInt(6, dStand.getYear2());
                              prst.setString(7, dStand.getDeptExplain());
                              prst.setString(8, dStand.getOrgName());
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
          public List<DeptStand> getDeptStandList(DeptStand dStand) {
                    List<DeptStand> retList = new ArrayList<DeptStand>();
                    // String sqlString = "select * from dept_stand where id='01'";
                    String sqlString = "select * from dept_stand ";
                    if(!StringUtil.isEmpty(dStand.getOrgName())){
                              //sqlString+="select * from dept_stand where org_id like '%2031%';";
                              sqlString+="where deptname like '%"+dStand.getOrgName()+"%'";
                    }
                    try {
                              PreparedStatement prst = con
                                                  .prepareStatement(sqlString);
                              //prst.setString(1, dept.getDeptNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        DeptStand dStandData = new DeptStand();
                                        dStandData.setStandId(rs.getString("id"));
                                        dStandData.setOrgid(rs.getString("org_id"));;
                                        dStandData.setMin(rs.getInt("min"));
                                        dStandData.setMax(rs.getInt("max"));
//                                        dStandData.setInNum(rs.getInt("in_num"));
                                        dStandData.setLoginDate(rs.getString("login_date"));
                                        dStandData.setYear1(rs.getInt("year1"));
                                        dStandData.setYear2(rs.getInt("year2"));
                                        dStandData.setDeptExplain(rs.getString("dept_exp"));
                                        dStandData.setOrgName(rs.getString("deptname"));
                                        retList.add(dStandData);
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return retList;
          }
          //学科基准删除（delete deptStand)
          public boolean deleteStand(String id){
                    String sql="delete from dept_stand where id=?";
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
          //更新学科基准（uptate dept）
          public boolean updateDStand(DeptStand dStand){
                    String sql="update dept_stand set min=?, max=? , year1=? , year2=? , dept_exp=? where id=?";
                    PreparedStatement prst;
                    try {
                              prst = con.prepareStatement(sql);
//                              prst.setString(1, dStand.getOrgid());
                              prst.setInt(1,dStand.getMin());
                              prst.setInt(2, dStand.getMax());
                              prst.setInt(3, dStand.getYear1());
                              prst.setInt(4,dStand.getYear2());
                              prst.setString(5,dStand.getDeptExplain());
                              prst.setString(6, dStand.getStandId());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return false;
          }
//학과마다 학생 인수 계산
//          public int getStudentCount(String orgid) {
////                    String sqlString = "select count(*) from student where orgid=(select o.org_code from org o where o.name=?)";
//                    String sql= "select count(*) count1 from student where orgid=?";
//                    PreparedStatement prst;
//                    int counts = 0;
//                              try {
//                                        prst = con.prepareStatement(sql);
//                                        prst.setString(1,orgid);
//                                        ResultSet rs = prst.executeQuery();
//                                        while(rs.next()){
//                                                  counts=rs.getInt("count1");
//                                        }
//                                       
//                              } catch (SQLException e) {
//                                        e.printStackTrace();
//                              }
//                              
//                    return counts;
//          }
}
