package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qujia.model.Subjects;

public class SubjectsDao extends BaseDao {
          //subject login
          public boolean addSubjects(Subjects sbj){
                    String sql="insert into subject values(?,?,?,?,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, sbj.getSubCode() );
                              prst.setString(2, sbj.getSubName());
                              prst.setString(3, sbj.getSubEname());
                              prst.setString(4, sbj.getLearnType());
                              prst.setString(5, sbj.getCreditType());
                              prst.setString(6, sbj.getOrgId() );
                              prst.setString(7, sbj.getColType());
                              prst.setString(8, sbj.getSchYear());
                              prst.setString(9, sbj.getTerm());
                              prst.setString(10, sbj.getSubExp());
                              
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
}
