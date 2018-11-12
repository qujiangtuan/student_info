package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.StuCouScoreView;
import com.qujia.util.StringUtil;

public class StuCouScoreViewDao extends BaseDao {

          public List<StuCouScoreView> getScsvList(StuCouScoreView scsv) {
                    List<StuCouScoreView> retList=new ArrayList<StuCouScoreView>();
                    StringBuffer sqlString=new StringBuffer("select * from stu_cou_score_view where cou_no=? ");
                    if(!StringUtil.isEmpty(scsv.getSno())){
                              sqlString.append(" and sno like '%"+scsv.getSno()+"%'");
                    }
                    if(!StringUtil.isEmpty(scsv.getName())){
                              sqlString.append(" and name like '%"+scsv.getName()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString());
                              prst.setString(1, scsv.getCouNo());
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        StuCouScoreView sc=new StuCouScoreView();
                                        sc.setSno(e.getString("sno"));
                                        sc.setName(e.getString("name"));
                                        sc.setOrgid(e.getString("orgid"));
                                        sc.setTel(e.getString("tel"));
                                        sc.setEmail(e.getString("email"));
                                        sc.setSchYear(e.getString("sch_year"));
                                        sc.setPno(e.getString("pno"));
                                        sc.setCouNo(e.getString("cou_no"));
                                        sc.setGrade(e.getString("grade"));
                                        retList.add(sc);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return retList;
          }

          public String getCounts(String couno) {
                    String sql="select count(*) count from stu_cou_score_view where cou_no= ? ";
                    int counts=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, couno);
                              ResultSet rs = prst.executeQuery();
                              while(rs.next()){
                                        counts=rs.getInt("count");
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return counts+"";
          }


}
