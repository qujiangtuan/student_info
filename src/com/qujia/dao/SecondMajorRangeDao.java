package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.SecondMajorRange;
import com.qujia.util.StringUtil;

public class SecondMajorRangeDao extends BaseDao {
          //add
          public boolean addSecondMajorRange(SecondMajorRange smr){
//                    String sql="insert into sec_maj_allow(allow_no,start_time,end_time,allow_type,range_type,login_date,orgid_base,orgid_allow) "
//                                        + "values(allow_seq.nextval,?,?,?,?,?,?,?)";
                    String sql="insert into sec_maj_allow"
                                        + " values(allow_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1,smr.getStartTime());
                              prst.setString(2,smr.getEndTime());
                              prst.setString(3,smr.getAllowType());
                              prst.setString(4,smr.getRangeType());
                              prst.setString(5,smr.getLoginDate());
                              prst.setString(6, smr.getOrgidBase());
                              prst.setString(7,smr.getOrgidAllow());
                              prst.setString(8,smr.getOrgidBaseName());
                              prst.setString(9,smr.getOrgidAllowName());
                              prst.setString(10,smr.getIsAllow());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          public List<SecondMajorRange> getSMRList(SecondMajorRange smr){
                    List<SecondMajorRange> retList=new ArrayList<SecondMajorRange>();
                    StringBuffer sqlString=new StringBuffer("select * from sec_maj_allow");
                    if(!StringUtil.isEmpty(smr.getOrgidBaseName())){
                              sqlString.append(" and orgid_base_nm like '%"+smr.getOrgidBaseName()+"%'");
                    }
                    if(!StringUtil.isEmpty(smr.getOrgidAllowName())){
                              sqlString.append(" and orgid_allow_nm like '%"+smr.getOrgidAllowName()+"%'");
                    }
                    
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              //preparedStatement.setString(1, "%"+Student.getName()+"%");
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        SecondMajorRange smrData =new SecondMajorRange();
                                        smrData.setAllowNo(e.getString("allow_no"));
                                        smrData.setStartTime(e.getString("start_time"));
                                        smrData.setEndTime(e.getString("end_time"));
                                        smrData.setAllowType(e.getString("allow_type"));
                                        smrData.setRangeType(e.getString("range_type"));
                                        smrData.setLoginDate(e.getString("login_date"));
                                        smrData.setOrgidBase(e.getString("orgid_base"));
                                        smrData.setOrgidAllow(e.getString("orgid_allow"));
                                        smrData.setOrgidBaseName(e.getString("orgid_base_nm"));
                                        smrData.setOrgidAllowName(e.getString("orgid_allow_nm"));
                                        smrData.setIsAllow(e.getString("is_allow"));
                                        retList.add(smrData);
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
          //허용 삭제
          public boolean delete(String allowNo) {
                    String sql="delete from sec_maj_allow where allow_no=?";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, allowNo);
                              if(prst.executeUpdate()>0){
                                        return true;
                              }
                    } catch (SQLException e) {    
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return false;
          }
          //수정
          public boolean updateSMR(SecondMajorRange smr) {
                    String sql="update sec_maj_allow set orgid_allow=?,start_time=?,end_time=?,"
                                        + "allow_type=?,range_type=?,is_allow=?, "
                                        + "orgid_allow_nm=?   where allow_no=?";
                    try {
                            PreparedStatement prst=con.prepareStatement(sql);
                            prst.setString(1,smr.getOrgidAllow());
                            prst.setString(2,smr.getStartTime());
                            prst.setString(3,smr.getEndTime());
                            prst.setString(4,smr.getAllowType());
                            prst.setString(5,smr.getRangeType());
                            prst.setString(6,smr.getIsAllow());
                            prst.setString(7, smr.getOrgidAllowName());
                            prst.setString(8,smr.getAllowNo());
                            if(prst.executeUpdate()>0){ 
                                      return true;
                            }
                            
                  } catch (SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                  }
                    return false;
          }
          //허용 판단
          public SecondMajorRange isAllow(SecondMajorRange smr){

                    String sql = "select * from sec_maj_allow where orgid_base_nm=? and orgid_allow_nm= ?";
                    SecondMajorRange smrRst=null;
                   ResultSet rs=null;
                    try {
                              //把sql语句传给数据库操作对象
                              PreparedStatement prst = con.prepareStatement(sql);
                              prst.setString(1, smr.getOrgidBaseName());
                              prst.setString(2, smr.getOrgidAllowName());
                              rs = prst.executeQuery();;
                              while(rs.next()){
                                        smrRst = new SecondMajorRange();
                                        smrRst.setAllowType(rs.getString("allow_type"));
                                        smrRst.setRangeType(rs.getString("range_type"));
                                        smrRst.setOrgidBaseName(rs.getString("orgid_base_nm"));
                                        smrRst.setOrgidAllowName(rs.getString("orgid_allow_nm"));
                                        smrRst.setIsAllow(rs.getString("is_allow"));
                             }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    this.closeDao();
                    return smrRst;
                   
          }
          
}
