package com.qujia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 以数据库建立连接
 * 
 * @author qujia
 *
 */
public class DBUtil {
          // private String dbUrl="jdbc:oracle:thin:@localhost:1522:XE";
          private String dbUrl = "jdbc:oracle:thin:@210.110.136.106:1521:XE";
          private String dbUserName = "student";
          private String dbPassword = "6317800";
          private String jdbcName = "oracle.jdbc.driver.OracleDriver";

          /**
           * 获取数据库连接
           */
          public Connection getCon() {
                    try {
                              Class.forName(jdbcName);
                    } catch (ClassNotFoundException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    Connection con = null;
                    try {
                              con = (Connection) DriverManager
                                                  .getConnection(dbUrl,
                                                                      dbUserName,
                                                                      dbPassword);
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return con;
          }

          /**
           * 关闭数据库连接
           * 
           * @throws SQLException
           */
          public void closeCon(Connection con) throws SQLException {
                    if (con != null) {
                              con.close();
                    }
          }

          public static void main(String[] args) {
                    DBUtil dbUtil = new DBUtil();
                    try {
                              dbUtil.getCon();
                              System.out.println("데이터베이스 연결 성공！");
                    } catch (Exception e) {
                              // TODO: handle exception
                              e.printStackTrace();
                              System.out.println("데이터베이스 연결 실패！");
                    }

          }
}
