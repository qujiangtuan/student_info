package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.ClassRoom;
import com.qujia.util.StringUtil;

public class ClassRoomDao extends BaseDao {

          public boolean loginCR(ClassRoom cr) {
                    String sql=" insert into classroom values(cr_seq.nextval,?,?,?)";
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
                              prst.setString(1,cr.getCrName());
                              prst.setInt(2, cr.getCounts());
                              prst.setString(3,cr.getExp());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public List<ClassRoom> getCsList(ClassRoom cr) {
                    List<ClassRoom> retList = new ArrayList<ClassRoom>();
                    StringBuffer sqlString=new StringBuffer("select * from classroom");
//                    StringBuffer sqlString = "select * from classroom ";
                    PreparedStatement prst;
                    if(!StringUtil.isEmpty(cr.getCrName())){
                              sqlString.append(" and name like '%"+cr.getCrName()+"%'");
                    }
                    if(!StringUtil.isEmpty(cr.getExp())){
                              sqlString.append(" and exp like '%"+cr.getExp()+"%'");
                    }
                    try {
                              prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        ClassRoom csData = new ClassRoom();
                                        csData.setCrNo(rs.getInt("id"));
                                        csData.setCrName(rs.getString("name"));
                                        csData.setCounts(rs.getInt("counts"));
                                        csData.setExp(rs.getString("exp"));
                                        retList.add(csData);
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return retList;
          }

          public boolean updateCR(ClassRoom cr) {
                    String sql="update classroom set name=? , counts=? , exp=?  where id=?";
                    PreparedStatement prst;
                    try {
                              prst = con.prepareStatement(sql);
                              prst.setString(1, cr.getCrName());
                              prst.setInt(2, cr.getCounts());
                              prst.setString(3,cr.getExp());
                              prst.setInt(4,cr.getCrNo());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean deleteCR(String cno) {
                    String sql="delete from classroom where id="+cno;
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

          public int getCrNo(String crName) {
                    String sql="select id from classroom where name=?";
                    PreparedStatement prst;
                    int crNo=0;
                    ResultSet rs ;
                    try {
                              prst = con.prepareStatement(sql);
                              prst.setString(1, crName);
                              rs = prst.executeQuery();
                              while (rs.next()) {
                                        crNo=rs.getInt("id");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return crNo;
          }
          
          
}
