package com.qujia.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.StuCourseView;
import com.qujia.util.StringUtil;

public class StuCourseViewDao extends BaseDao {
          public List<StuCourseView> getCourseViewList(StuCourseView cv) {
                    List<StuCourseView> retList=new ArrayList<StuCourseView>();
                    StringBuffer sqlString=new StringBuffer("select * from stu_course_view ");
//                    String sqlString="select * from per_course";
                    InputStream reader;
                    if(!StringUtil.isEmpty(cv.getSno())){
                              sqlString.append(" and stu_no like '%"+cv.getSno()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getsName())){
                        sqlString.append(" and stu_name like '%"+cv.getsName()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getCouNo())){
                              sqlString.append(" and cou_no like '%"+cv.getCouNo()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getCouName())){
                              sqlString.append(" and cou_name like '%"+cv.getCouName()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getPno())){
                              sqlString.append(" and pno like '%"+cv.getPno()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getProName())){
                              sqlString.append(" and proname like '%"+cv.getProName()+"%'");
                    }
                    if(!StringUtil.isEmpty(cv.getStuDept())){
                              sqlString.append(" and stu_dept like '%"+cv.getStuDept()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        StuCourseView cvData =new StuCourseView();
                                        cvData.setYear(e.getString("year"));
                                        cvData.setTerm(e.getInt("term"));
                                        cvData.setCouName(e.getString("cou_name"));
                                        cvData.setCouNo(e.getString("cou_no"));
                                        cvData.setLearnType(e.getString("learn_type"));
                                        cvData.setProName(e.getString("proname"));
                                        cvData.setClassNo(e.getString("class_no"));
                                        cvData.setCreditType(e.getInt("credit_type"));
                                        cvData.setTtcr(e.getString("tt_cr"));
                                        cvData.setSno(e.getString("stu_no"));
                                        cvData.setCouDept(e.getString("cou_dept"));
                                        cvData.setStuDept(e.getString("stu_dept"));
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
