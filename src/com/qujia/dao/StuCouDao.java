package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qujia.model.StuCou;

public class StuCouDao extends BaseDao {

          public boolean AddSC(StuCou sc) {
                    String sql="insert into stu_cou values(?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sc.getSno());
                              prst.setString(2,sc.getSname());
                              prst.setString(3,sc.getCouNo());
                              prst.setString(4,sc.getCouName());
                              prst.setString(5,sc.getApplyDate());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean isSC(String sNo, String couNo) {
                    String sqlString="select count(*) count from stu_cou where sno=? and cou_no=?";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              prst.setString(1, sNo);
                              prst.setString(2, couNo);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        count=e.getInt("count");
                              }
                              if(count>0) return true;
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }
          
}
