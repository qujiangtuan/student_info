package com.qujia.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.ProCourseView;
import com.qujia.util.StringUtil;

public class ProCourseViewDao extends BaseDao {
          public List<ProCourseView> getCourseViewList(ProCourseView cv) {
                    List<ProCourseView> retList=new ArrayList<ProCourseView>();
                    StringBuffer sqlString=new StringBuffer("select * from pro_course_view ");
//                    String sqlString="select * from per_course";
                    InputStream reader;
                    if(!StringUtil.isEmpty(cv.getCouNo())){
                              sqlString.append(" and cou_no like '%"+cv.getCouNo()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getCouName())){
                              sqlString.append(" and cou_name like '%"+cv.getCouName()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getPno())){
                              sqlString.append(" and proid like '%"+cv.getPno()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getProName())){
                              sqlString.append(" and proname like '%"+cv.getProName()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        ProCourseView cvData =new ProCourseView();
                                        cvData.setCouName(e.getString("cou_name"));
                                        cvData.setCouNo(e.getString("cou_no"));
                                        cvData.setPno(e.getString("proid"));
                                        cvData.setProName(e.getString("proname"));
                                        cvData.setClassNo(e.getString("class_no"));
                                        cvData.setTtcr(e.getString("tt_cr"));
                                        cvData.setId(e.getString("id"));
                                        cvData.setName(e.getString("name"));
                                        cvData.setSize1(e.getInt("size1"));
                                        //inputStream
                                        try {
                                                  Blob blob = e.getBlob("FILE1");
                                                  reader = blob.getBinaryStream();
                                        } catch (Exception e2) {
                                                  reader=null;
                                        }
                                        cvData.setReader(reader);
                                        retList.add(cvData);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
}
