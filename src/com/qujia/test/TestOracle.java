package com.qujia.test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.sql.BLOB;
 
public class TestOracle {
    
    static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1522:xe";
            String user = "student";
            String password = "6317800";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스 연결 성공！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
 
    //将文件从文件夹存储到Oracle
    public void testInsert(File inputFile){
        Connection conn = TestOracle.getConnection();
        Statement st = null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            boolean defaultCommit = conn.getAutoCommit();
            st = conn.createStatement();
//            File inputFile = file;
            String fileName = inputFile.getName();
            long size = (long) inputFile.length();
            String sql = "insert into tb_blob values" +
                    "(1,'" + fileName + "',"+ size +",empty_blob())";
            st.executeUpdate(sql);
            sql = "select * from tb_blob  where id = 1 for update";
            rs = st.executeQuery(sql);
            if(rs.next()){
                BLOB blob = (BLOB)rs.getBlob("FILE1");
                OutputStream outStream = blob.getBinaryOutputStream();
                InputStream fin = new FileInputStream(inputFile);
                byte[] b = new byte[blob.getBufferSize()];
                int len = 0;
                while((len = fin.read(b))!=-1){
                    outStream.write(b,0,len);
                }
                fin.close();
                outStream.flush();
                conn.commit();
                conn.setAutoCommit(defaultCommit);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }  catch(FileNotFoundException e){
            e.printStackTrace();
        }  catch(IOException e){
            e.printStackTrace();
        }  finally{
            try {
                if(conn!=null){conn.close();} 
                if(st!=null){st.close();}
                if(rs!=null){rs.close();}
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //将文件从Oracle读出到文件夹
    private void testQuery() {
        Connection conn = null;
        Statement st  = null;
        ResultSet rs = null;
        try{
            conn = this.getConnection();
            st = conn.createStatement();
            String sql = "select * from tb_blob where id = 1";
            rs = st.executeQuery(sql);
            if(rs.next()){
                Blob blob = rs.getBlob("FILE1");
                InputStream reader = blob.getBinaryStream();
                OutputStream writer = new BufferedOutputStream(new FileOutputStream(new File("H:\\test1_fromDB.txt")));
                byte b[] = new byte[1024];
                for(int i = 0; (i = reader.read(b)) > 0 ;)
                    writer.write(b, 0, i);
                writer.close();
                reader.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }  catch(FileNotFoundException e){
            e.printStackTrace();
        }  catch(IOException e){
            e.printStackTrace();
        }  finally{
            try {
                if(conn!=null){conn.close();} 
                if(st!=null){st.close();}
                if(rs!=null){rs.close();}
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
     
//    public static void main(String[] args) throws Exception {
//        
//        new TestOracle().testInsert();
//         
//        new TestOracle().testQuery();
//        System.out.println("Done!");
//        
// 
//    }
 
    
 
}
