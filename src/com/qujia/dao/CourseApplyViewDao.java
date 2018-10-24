package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.CourseApplyView;
import com.qujia.util.StringUtil;

public class CourseApplyViewDao extends BaseDao {

          public List<CourseApplyView> getCavList(CourseApplyView ca) {
                    List<CourseApplyView> retList=new ArrayList<CourseApplyView>();
//                    List<ProStaff> retList=new ArrayList<ProStaff>();
                    StringBuffer sqlString=new StringBuffer("select * from course_apply_view ");
                    if(!StringUtil.isEmpty(ca.getCouName())){
                              sqlString.append(" and cou_name like '%"+ca.getCouName()+"%'");
                    }
                    if(!StringUtil.isEmpty(ca.getCouNo())){
                        sqlString.append(" and cou_no like '%"+ca.getCouNo()+"%'");
                    }
                    if(!StringUtil.isEmpty(ca.getOrgName())){
                              sqlString.append(" and orgname like '%"+ca.getOrgName()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              //preparedStatement.setString(1, "%"+Student.getName()+"%");
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        CourseApplyView cavData =new CourseApplyView();
                                        cavData.setCouName(e.getString("cou_name"));
                                        cavData.setCouNo(e.getString("cou_no"));
                                        cavData.setOrgName(e.getString("orgname"));
                                        cavData.setSchYear(e.getString("schyear"));
                                        cavData.setLearnType(e.getString("learn_type"));
                                        cavData.setCreditType(e.getString("credit_type"));
                                        cavData.setProId(e.getString("proid"));
                                        cavData.setFixedNum(e.getInt("fixed_num"));
                                        cavData.setCurrNum(e.getInt("curr_num"));
                                        cavData.setClassNo(e.getString("class_no"));
                                        cavData.setTtcr(e.getString("tt_cr"));
                                        retList.add(cavData);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
          
}
