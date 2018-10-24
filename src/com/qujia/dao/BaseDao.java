package com.qujia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.util.DBUtil;
import com.qujia.util.StringUtil;

/**
 *创建对数据库连接对象，整个项目与数据库打交道用的一个对象 
 *author qujia
 *
 */
public class BaseDao {
          //创建一个数据库连接对象
          public Connection con=new DBUtil().getCon();
          //关闭连接数据库
          public void closeDao(){
                    try {
                              con.close();
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
          }
         
}
