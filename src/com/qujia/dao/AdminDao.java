package com.qujia.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qujia.model.Admin;

public class AdminDao extends BaseDao {
          /**
           * 管理员登陆
           */
 
          public Admin login(Admin admin){

                    String sql = "select * from s_admin where name=? and password= ?";
                    Admin adminRst=null;
                   ResultSet rs=null;
                    try {
                              //把sql语句传给数据库操作对象
                              PreparedStatement prst = con.prepareStatement(sql);
                              prst.setString(1, admin.getName());
                              prst.setString(2, admin.getPassword());
                              rs = prst.executeQuery();;
                              while(rs.next()){
                                        adminRst = new Admin();
                                        adminRst.setId(rs.getInt(1));
                                        adminRst.setName(rs.getString(2));
                                        adminRst.setPassword(rs.getString(3));
                                        adminRst.setCreateDate(rs.getString(4));
                             }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    this.closeDao();
                    return adminRst;
                   
          }
          //update password
          public String editPassword(Admin admin,String newPasswrod){
                    String sql = "select * from s_admin where name= ? and password= ?";
                    PreparedStatement prst =null;
                    ResultSet rs;
                    int id=0;
                    
                    try {
                              prst= con.prepareStatement(sql);
                              prst.setString(1, admin.getName());
                              prst.setString(2, admin.getPassword());
                              rs = prst.executeQuery();
                              if(!rs.next()){
                                        String retString ="옛 암호 오류！";
                                        return retString;
                              }
                              id=rs.getInt("id");
                              System.out.println("id:"+id);
                    } catch (SQLException e1) {
                              // TODO Auto-generated catch block
                              e1.printStackTrace();
                    }
                    String retString ="수정 실패";
                    String sqlString = "update s_admin set password = ? where id = ?";
                     
                    try {
                              prst = con.prepareStatement(sqlString);
                              prst.setString(1, newPasswrod);
                              prst.setInt(2, id);
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
        //update password
          public Admin searchOldPassword(Admin admin){
                    String sql = "select password from s_admin where name= ? ";
                    PreparedStatement prst =null;
                    Admin adminRst=null;
                    ResultSet rs;
                    int id=0;
                    try {
                              prst= con.prepareStatement(sql);
                              prst.setString(1, admin.getName());
                              rs = prst.executeQuery();
                              while(rs.next()){
                                        adminRst = new Admin();
                                        adminRst.setPassword(rs.getString("password"));
                             }
                    } catch (SQLException e1) {
                              // TODO Auto-generated catch block
                              e1.printStackTrace();
                    }
                    return adminRst;
          }
}
