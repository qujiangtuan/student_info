package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.YearDeptStand;
import com.qujia.util.StringUtil;

public class YearDeptStandDao extends BaseDao {
       // add YearDeptStand
          public boolean addYearStand(YearDeptStand yds) {
                    String sql = "insert into year_stand values(?,?,?,?,?,?,?,?,?,?,?)";

                    try {
                              PreparedStatement prst = con.prepareStatement(sql);
                              prst.setString(1, yds.getYearNo());
                              prst.setString(2, yds.getLoginDate());
                              prst.setInt(3,yds.getCredit());
                              prst.setInt(4,yds.getMajor());
                              prst.setInt(5,yds.getMajorMust());
                              prst.setInt(6,yds.getCulMust());
                              prst.setInt(7,yds.getRecTatio());
                              prst.setInt(8,yds.getRecTemp());
                              prst.setInt(9,yds.getRecForm());
                              prst.setString(10,yds.getOrgId());
                              prst.setString(11,yds.getDeptName());
                              if (prst.executeUpdate() > 0)
                                        return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    this.closeDao();
                    return false;
          }

          public List<YearDeptStand> getYDSList(YearDeptStand ydStand) {
                    List<YearDeptStand> retList=new ArrayList<YearDeptStand>();
                    String sqlString=new String("select * from year_stand");
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString);
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        YearDeptStand yds =new YearDeptStand();
                                        yds.setYearNo(e.getString("year_no"));
                                        Integer credit = e.getInt("credit");
                                        yds.setCredit(credit);
                                        int major = e.getInt("major");
                                        yds.setMajor(major);
                                        int majorMust = e.getInt("major_must");
                                        yds.setMajorMust(majorMust);
                                        yds.setMajorChose(major-majorMust);
                                        int cul=credit-major;
                                        yds.setCul(cul);
                                        int culMust = e.getInt("cul_must");
                                        yds.setCulMust(culMust);
                                        yds.setCulChose(cul-culMust);
                                        yds.setRecTatio(e.getInt("rec_tatio"));
                                        yds.setRecTemp(e.getInt("rec_temp"));
                                        yds.setRecForm(e.getInt("rec_form"));
                                        yds.setOrgId(e.getString("orgid"));
                                        yds.setLoginDate(e.getString("logindate"));
                                        yds.setDeptName(e.getString("deptname"));
                                        retList.add(yds);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
        //학변별 학사기준 천제 list
          public List<YearDeptStand> getYDSList2(YearDeptStand ydStand){
                    List<YearDeptStand> retList=new ArrayList<YearDeptStand>();
                    String sqlString=null;
                    if(StringUtil.isEmpty(ydStand.getYearNo())&&StringUtil.isEmpty(ydStand.getDeptName())){
                              sqlString=new String("select * from year_stand");
                    }
                    if(!StringUtil.isEmpty(ydStand.getYearNo())&&StringUtil.isEmpty(ydStand.getDeptName())){
                              sqlString=new String("select * from year_stand where year_no like '%"+ydStand.getYearNo()+"%'");
                    }
                    if(!StringUtil.isEmpty(ydStand.getDeptName())&&StringUtil.isEmpty(ydStand.getYearNo())){
                              sqlString=new String("select * from year_stand where deptname like '%"+ydStand.getDeptName()+"%'");
                    }
                    if(!StringUtil.isEmpty(ydStand.getDeptName())&&!StringUtil.isEmpty(ydStand.getYearNo())){
                              sqlString=new String("select * from year_stand where year_no like '%"+ydStand.getYearNo()+"%' and deptname like '%"+ydStand.getDeptName()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString );
                              //preparedStatement.setString(1, "%"+Student.getName()+"%");
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        YearDeptStand yds=new YearDeptStand();
                                        yds.setYearNo(e.getString("year_no"));
                                        Integer credit = e.getInt("credit");
                                        yds.setCredit(credit);
                                        int major = e.getInt("major");
                                        yds.setMajor(major);
                                        int majorMust = e.getInt("major_must");
                                        yds.setMajorMust(majorMust);
                                        yds.setMajorChose(major-majorMust);
                                        int cul=credit-major;
                                        yds.setCul(cul);
                                        int culMust = e.getInt("cul_must");
                                        yds.setCulMust(culMust);
                                        yds.setCulChose(cul-culMust);
                                        yds.setRecTatio(e.getInt("rec_tatio"));
                                        yds.setRecTemp(e.getInt("rec_temp"));
                                        yds.setRecForm(e.getInt("rec_form"));
                                        yds.setOrgId(e.getString("orgid"));
                                        yds.setLoginDate(e.getString("logindate"));
                                        yds.setDeptName(e.getString("deptname"));
                                        retList.add(yds);
                              }
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
          
          //학년별 학사기준 변경
          public boolean updateDStand(YearDeptStand ydStand) {
                    String sql="update year_stand set credit=?,major=?,major_must=?,cul_must=?,rec_tatio=?,rec_temp=?,rec_form=?  where year_no=?";
                    PreparedStatement prst;
                    try {
                              prst=con.prepareStatement(sql);
                              prst.setInt(1, ydStand.getCredit());
                              prst.setInt(2, ydStand.getMajor());
                              prst.setInt(3,ydStand.getMajorMust());
                              prst.setInt(4,ydStand.getCulMust());
                              prst.setInt(5,ydStand.getRecTatio());
                              prst.setInt(6,ydStand.getRecTemp());
                              prst.setInt(7,ydStand.getRecForm());
                              prst.setString(8,ydStand.getYearNo());
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    
                    return false;
          }
        //학년별 학사기준 삭제
          public boolean delete(String yearNo) {
                    String sql="delete from year_stand where year_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, yearNo);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    
                    return false;
          }
}
