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
import java.util.ArrayList;
import java.util.List;

import oracle.sql.BLOB;

import com.qujia.model.Notice;
import com.qujia.util.StringUtil;

public class NoticeDao extends BaseDao {

          public boolean loginNotic(Notice no) {
                    String sql = "insert into notice(id,title,writer,obj,content,login_date,num) values(notice_seq.nextval,?,?,?,?,?,?)";
                    try {
                     PreparedStatement prst=con.prepareStatement(sql);
                     prst.setString(1, no.getTitle());
                     prst.setString(2,no.getWriter());
                     prst.setString(3,no.getObj());
                     prst.setString(4,no.getContent());
                     prst.setString(5,no.getLoginDate());
                     prst.setString(6,no.getNum());
                     if (prst.executeUpdate() > 0)
                               return true;            
           } catch (SQLException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
           }
                    return false;
          }

          public boolean isExit(String num) {
                    String sql = "select count(*) count from notice where num=?";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,num);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        count=e.getInt("count");
                              }
                              if (count > 0) return true;            
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean insertFile(File inputFile, String num) {
                    Statement st = null;
                    ResultSet rs = null;
                    try {
                              con.setAutoCommit(false);
                        boolean defaultCommit = con.getAutoCommit();
                        st = con.createStatement();
                        String fileName = inputFile.getName();
                        long size = (long) inputFile.length();
//                        String sql = "insert into pro_course(id,name,size1,file1,pno,cou_no) values" +
//                                "(proc_seq.nextval,'" + fileName + "',"+ size +",empty_blob(),'"+pno+"','"+couNo+"')";
                        String sql = "update notice set file_name='"+fileName+"',size1="+size+", file1=empty_blob() where num= '"+num+"'";
                        st.executeUpdate(sql);
                        sql = "select * from notice  where num='"+num +"'  for update";
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

          public List<Notice> getNoticeList(Notice no) {
                    List<Notice> retList=new ArrayList<Notice>();
                    StringBuffer sqlString=new StringBuffer("select * from notice  ");
                    if(!StringUtil.isEmpty(no.getTitle())){
                              sqlString.append(" and title like '%"+no.getTitle()+"%'");
                    }
                    if(!StringUtil.isEmpty(no.getObj())){
                        sqlString.append(" and obj like '%"+no.getObj()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        Notice not =new Notice();
                                        not.setId(e.getString("id"));
                                        not.setTitle(e.getString("title"));
                                        not.setWriter(e.getString("writer"));
                                        not.setObj(e.getString("obj"));
                                        not.setLoginDate(e.getString("login_date"));
                                        retList.add(not);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return retList;
          }
          public List<Notice> getNoticeStuList(Notice no) {
                    List<Notice> retList=new ArrayList<Notice>();
                    StringBuffer sqlString=new StringBuffer("select * from notice  where nvl(obj,'')<>'교원공지' ");
                    if(!StringUtil.isEmpty(no.getTitle())){
                              sqlString.append(" and title like '%"+no.getTitle()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString());
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        Notice not =new Notice();
                                        not.setId(e.getString("id"));
                                        not.setTitle(e.getString("title"));
                                        not.setWriter(e.getString("writer"));
                                        not.setObj(e.getString("obj"));
                                        not.setLoginDate(e.getString("login_date"));
                                        retList.add(not);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return retList;
          }
          public List<Notice> getNoticeProList(Notice no) {
                    List<Notice> retList=new ArrayList<Notice>();
                    StringBuffer sqlString=new StringBuffer("select * from notice  where nvl(obj,'')<>'학생공지'  ");
                    if(!StringUtil.isEmpty(no.getTitle())){
                              sqlString.append("  and title like '%"+no.getTitle()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString());
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        Notice not =new Notice();
                                        not.setId(e.getString("id"));
                                        not.setTitle(e.getString("title"));
                                        not.setWriter(e.getString("writer"));
                                        not.setObj(e.getString("obj"));
                                        not.setLoginDate(e.getString("login_date"));
                                        retList.add(not);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return retList;
          }
          public Notice getNoticeList2(Notice no) {
                    Notice not=new Notice();
                    StringBuffer sqlString=new StringBuffer("select * from notice  ");
                    if(!StringUtil.isEmpty(no.getTitle())){
                              sqlString.append(" and title like '%"+no.getTitle()+"%'");
                    }
                    if(!StringUtil.isEmpty(no.getObj())){
                        sqlString.append(" and obj like '%"+no.getObj()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        not.setId(e.getString("id"));
                                        not.setTitle(e.getString("title"));
                                        not.setWriter(e.getString("writer"));
                                        not.setObj(e.getString("obj"));
                                        not.setContent(e.getString("content"));
                                        not.setLoginDate(e.getString("login_date"));
                                        not.setFileName(e.getString("file_name"));
//                                        not.setFile(e.getBlob("file1"));
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return not;
          }

          public Notice getOneNotice(String id) {
                    String sql="select * from notice where id=?";
                    Notice not=null;
                  try {
                            PreparedStatement prst=con.prepareStatement(sql);
                            prst.setString(1, id);
                            ResultSet e = prst.executeQuery();
                            while(e.next()){
                                      not =new Notice();
                                      not.setId(e.getString("id"));
                                      not.setTitle(e.getString("title"));
                                      not.setWriter(e.getString("writer"));
                                      not.setObj(e.getString("obj"));
                                      not.setContent(e.getString("content"));
                                      not.setFileName(e.getString("file_name"));
                                      not.setLoginDate(e.getString("login_date"));
                                      not.setNum(e.getString("num"));
                            }
                  } catch (SQLException e) {
                            e.printStackTrace();
                  }
                  return not;
          }

          public boolean deleteNotice(String noticeNo) {
                    String sql="delete from notice where id=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, noticeNo);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean updateNotice(Notice no) {
                    String sql = "update notice set title=?,writer=?,obj=?,content=?,login_date=?  where id=?";
                    try {
                     PreparedStatement prst=con.prepareStatement(sql);
                     prst.setString(1, no.getTitle());
                     prst.setString(2,no.getWriter());
                     prst.setString(3,no.getObj());
                     prst.setString(4,no.getContent());
                     prst.setString(5,no.getLoginDate());
                     prst.setString(6,no.getId());
                     if (prst.executeUpdate() > 0)
                               return true;            
           } catch (SQLException e) {
                     e.printStackTrace();
           }
                    return false;
          }

          public File getFile(String id) {
                              Statement st  = null;
                              ResultSet rs = null;
                              String sql;
                              File file=null;
                              try{
                                  st = con.createStatement();
                                  sql = "select * from notice where id= '"+id+"'";
                                  rs = st.executeQuery(sql);
                                  if(rs.next()){
                                      Blob blob = rs.getBlob("FILE1");
                                      InputStream reader = blob.getBinaryStream();
                                      file=new File(rs.getString("file_name"));
                                      OutputStream writer;
                                        writer = new BufferedOutputStream(new FileOutputStream(file));
                                      byte b[] = new byte[1024];
                                        for(int i = 0; (i = reader.read(b)) > 0 ;)
                                                    writer.write(b, 0, i);
                                      writer.close();
                                      reader.close();
                                  }
                              }catch (SQLException e) {
                                  e.printStackTrace();
                              }catch (FileNotFoundException e) {
                                        e.printStackTrace();
                              } catch (IOException e) {
                                        e.printStackTrace();
                              }finally{
                                  try {
                                      if(con!=null){con.close();} 
                                      if(st!=null){st.close();}
                                      if(rs!=null){rs.close();}
                                  }
                                  catch (SQLException e) {
                                      e.printStackTrace();
                                  }
                              }
                              return file;
          }

          public boolean deleteFile(String id) {
                    String sql="update notice set file_name=null,size1=0,file1=null where id=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, id);
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
