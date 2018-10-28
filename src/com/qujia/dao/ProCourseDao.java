package com.qujia.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.sql.BLOB;

public class ProCourseDao extends BaseDao {

          public boolean insertFile(File inputFile,String couNo,String pno) {
//                    Connection conn = TestOracle.getConnection();
                    Statement st = null;
                    ResultSet rs = null;
                    try {
                              con.setAutoCommit(false);
                        boolean defaultCommit = con.getAutoCommit();
                        st = con.createStatement();
//                        File inputFile = file;
                        String fileName = inputFile.getName();
                        long size = (long) inputFile.length();
                        String sql = "insert into pro_course(id,name,size1,file1,pno,cou_no) values" +
                                "(proc_seq.nextval,'" + fileName + "',"+ size +",empty_blob(),'"+pno+"','"+couNo+"')";
                        st.executeUpdate(sql);
                        sql = "select * from pro_course  where pno="+pno +" and cou_no="+couNo+"  for update";
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
                            con.commit();
                            con.setAutoCommit(defaultCommit);
                        }
                        if(st.executeUpdate(sql)>0) return true;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }  catch(FileNotFoundException e){
                        e.printStackTrace();
                    }  catch(IOException e){
                        e.printStackTrace();
                    }  finally{
                        try {
                            if(con!=null){con.close();} 
                            if(st!=null){st.close();}
                            if(rs!=null){rs.close();}
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
          }

          public boolean downFile(String absolutePath, String fileName,
                              String couNo, String pno) {
                    Statement st  = null;
                    ResultSet rs = null;
                    String sql;
                    try{
                        st = con.createStatement();
                        sql = "select * from pro_course where cou_no= '"+couNo+"' and pno= '"+pno+"'";
                        rs = st.executeQuery(sql);
                        if(rs.next()){
                            Blob blob = rs.getBlob("FILE1");
                            InputStream reader = blob.getBinaryStream();
                            OutputStream writer = new BufferedOutputStream(new FileOutputStream(new File(absolutePath+fileName)));
                            byte b[] = new byte[1024];
                            for(int i = 0; (i = reader.read(b)) > 0 ;)
                                writer.write(b, 0, i);
                            writer.close();
                            reader.close();
                            
                        }
                        if(st.executeUpdate(sql)>0)  return true; 
                    }catch (SQLException e) {
                        e.printStackTrace();
                    }  catch(FileNotFoundException e){
                        e.printStackTrace();
                    }  catch(IOException e){
                        e.printStackTrace();
                    }  finally{
                        try {
                            if(con!=null){con.close();} 
                            if(st!=null){st.close();}
                            if(rs!=null){rs.close();}
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
          }

          public boolean deleteFile(String couNo, String pno) {
                    String sql="delete from pro_course where pno=? and cou_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, pno);
                              prst.setString(2, couNo);
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
