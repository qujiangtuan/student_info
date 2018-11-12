package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.ProStaff;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;

public class ProStaffDao extends BaseDao {
	public ProStaff login(ProStaff ps){

        String sql = "select * from pro_staff where pno=? and password= ?";
        ProStaff psRst=null;
       ResultSet rs=null;
        try {
                  //把sql语句传给数据库操作对象
                  PreparedStatement prst = con.prepareStatement(sql);
                  prst.setString(1, ps.getpNo());
                  prst.setString(2, ps.getPassword());
                  rs = prst.executeQuery();;
                  while(rs.next()){
                	  psRst = new ProStaff();
                	  
                	  psRst.setpNo(rs.getString("pno"));
                	  psRst.setpName(rs.getString("pname"));
                	  psRst.setPeName(rs.getString("pename"));
                	  psRst.setProType(rs.getString("pro_type"));
                	  psRst.setPerType(rs.getString("per_type"));
//                	  psRst.setTeaType(rs.getString("tea_type"));
                	  psRst.setSex(rs.getString("sex"));
                	  psRst.setIdCardNo(rs.getString("id_card_no"));
                	  psRst.setOrgId(rs.getString("orgid"));
                	  psRst.setAddress(rs.getString("address"));
                	  psRst.setTel(rs.getString("tel"));
                	  psRst.setEmail(rs.getString("email"));
                	  psRst.setLoginDate(rs.getString("login_date"));
                	  psRst.setPassword(rs.getString("password"));
                	  psRst.setSupId(rs.getString("sup_id"));     
                 }
        } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
        }
        this.closeDao();
        return psRst;
       
}
	//add ProStaff
	public boolean addProStaff(ProStaff ps){
        String sql="insert into pro_staff values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
                  PreparedStatement prst=con.prepareStatement(sql);
                  prst.setString(1, ps.getpNo());
                  prst.setString(2, ps.getpName());
                  prst.setString(3, ps.getPeName());
                  prst.setString(4, ps.getProType());
                  prst.setString(5, ps.getPerType());
//                  prst.setString(6, ps.getTeaType());
                  prst.setString(6, ps.getSex());
                  prst.setString(7, ps.getIdCardNo());
                  prst.setString(8, ps.getOrgId());
                  prst.setString(9, ps.getAddress());
                  prst.setString(10, ps.getTel());
                  prst.setString(11, ps.getEmail());
                  prst.setString(12, ps.getLoginDate());
                  prst.setString(13, ps.getPassword());
                  prst.setString(14, ps.getSupId());
                  prst.setString(15,ps.getOrgName());
                  if(prst.executeUpdate()>0) return true;
        } catch (SQLException e) {
                  e.printStackTrace();
        }
        return false;
	}
	//get ProStaffDao List
	public List<ProStaff> getProStaffList(ProStaff ps){
        List<ProStaff> retList=new ArrayList<ProStaff>();
        StringBuffer sqlString=new StringBuffer("select * from pro_staff");
        if(!StringUtil.isEmpty(ps.getpName())){
                  sqlString.append(" and pname like '%"+ps.getpName()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getpNo())){
            sqlString.append(" and pno like '%"+ps.getpNo()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getProType())){
                  sqlString.append(" and pro_type like '%"+ps.getProType()+"%'");
        }
//        if(!StringUtil.isEmpty(ps.getPerType())){
//            sqlString.append(" and per_type like '%"+ps.getPerType()+"%'");
//        }
        if(!StringUtil.isEmpty(ps.getOrgName())){
            sqlString.append(" and orgname like '%"+ps.getOrgName()+"%'");
        }
        try {
                  PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                  //preparedStatement.setString(1, "%"+Student.getName()+"%");
                  ResultSet e = prst.executeQuery();
                  while(e.next()){
                	  ProStaff psDate =new ProStaff();
                	     psDate.setpNo(e.getString("pno"));
	         			 psDate.setpName(e.getString("pname"));
	         			 psDate.setPeName(e.getString("pename"));
	         			 psDate.setProType(e.getString("pro_type"));
	         			 psDate.setPerType(e.getString("per_type"));
//	         			 psDate.setTeaType(e.getString("tea_type"));
	         			 psDate.setSex(e.getString("sex"));
	         			 psDate.setIdCardNo(e.getString("id_card_no"));
	         			 psDate.setOrgId(e.getString("orgid"));
	         			 psDate.setAddress(e.getString("address"));
	         			 psDate.setTel(e.getString("tel"));
	         			 psDate.setEmail(e.getString("email"));
	         			 psDate.setLoginDate(e.getString("login_date"));
	         			 psDate.setPassword(e.getString("password"));
	         			 psDate.setSupId(e.getString("sup_id"));     
	         			 psDate.setOrgName(e.getString("orgname"));
                      retList.add(psDate);
                  }
        } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
        }
        
        return retList;
	}
	//getHistory
	public List<ProStaff> getProHistory(ProStaff ps){
	          List<ProStaff> retList=new ArrayList<ProStaff>();
	          StringBuffer sqlString=new StringBuffer("select * from pro_history where pro_id like '%"+ps.getpNo()+"%' order by up_date");
//	          if(!StringUtil.isEmpty(ps.getpNo())){
//	                    sqlString.append(" and pro_id like '%"+ps.getpNo()+"%'");
//	          }
	          try {
	                    PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
	                    //preparedStatement.setString(1, "%"+Student.getName()+"%");
	                    ResultSet e = prst.executeQuery();
	                    while(e.next()){
	                        ProStaff psDate =new ProStaff();
	                           psDate.setId(e.getInt("id"));
	                           psDate.setpNo(e.getString("pro_id"));
	                           psDate.setpName(e.getString("pname"));
	                           psDate.setProType(e.getString("pro_type"));
	                           psDate.setPerType(e.getString("per_type"));
	                           psDate.setOrgName(e.getString("dept_name"));
	                           psDate.setSupName(e.getString("sup_pro"));
	                           psDate.setLoginDate(e.getString("up_date"));
	                        retList.add(psDate);
	                    }
	          } catch (SQLException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	          }
	          
	          return retList;
	      }
	 //update ProStaff
    public boolean updateProStaff(ProStaff ps){
//              String sql="update pro_staff set pname = ? , pename=?,pro_type=?,per_type=?,"
//                                  + "tea_type=?,sex=?,orgid=?,address=?,tel=?,email=?,sup_id=?  where pno=?";
              String sql="update pro_staff set per_type=?,orgid=?,sup_id=?,orgname=? where pno=?";
              try {
                      PreparedStatement prst=con.prepareStatement(sql);
                      prst.setString(1, ps.getPerType());
//                      prst.setString(2, ps.getTeaType());
                      prst.setString(2, ps.getOrgId());
                      prst.setString(3, ps.getSupId());
                      prst.setString(4,ps.getOrgName());
                      prst.setString(5, ps.getpNo());
                      if(prst.executeUpdate()>0){ 
                                return true;
                      }
                      
            } catch (SQLException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
            }
              return false;
    }
  //delete ProStaff
    public boolean deleteProStaff(String pNo){
              String sql="delete from pro_staff where pno=?";
              try {
                        PreparedStatement prst=con.prepareStatement(sql);
                        prst.setString(1, pNo);
                        if(prst.executeUpdate()>0){
                                  return true;
                        }
              } catch (SQLException e) {    
                        // TODO Auto-generated catch block
                        e.printStackTrace();
              }
              
              return false;
    }
  //update password
    public String editPassword(ProStaff ps,String newPasswrod){
              String sql = "select * from pro_staff where pno= ? and password= ?";
              PreparedStatement prst =null;
              ResultSet rs;
              try {
                        prst= con.prepareStatement(sql);
                        prst.setString(1, ps.getpNo());
                        prst.setString(2, ps.getPassword());
                        rs = prst.executeQuery();
                        if(!rs.next()){
                                  String retString ="옛 암호 오류！";
                                  return retString;
                        }
              } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
              }
              String retString ="수정 실패";
              String sqlString = "update pro_staff set password = ? where pno = ?";
               
              try {
                        prst = con.prepareStatement(sqlString);
                        prst.setString(1, newPasswrod);
                        prst.setString(2, ps.getpNo());
                       int rst= prst.executeUpdate();
                        if(rst>0){
                                  retString="암호 수정 성공했습니다！";
                        }
              } catch ( Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
              }
              
              return retString;
    }
  //get ProStaffDao List
    public List<ProStaff> getSearchStaffList(ProStaff ps){
        List<ProStaff> retList=new ArrayList<ProStaff>();
        StringBuffer sqlString=new StringBuffer("select * from pro_staff where pro_type='직원'");
        if(!StringUtil.isEmpty(ps.getpName())){
                  sqlString.append(" and pname like '%"+ps.getpName()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getPerType())){
            sqlString.append(" and per_type like '%"+ps.getPerType()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getOrgId())){
            sqlString.append(" and orgid like '%"+ps.getOrgId()+"%'");
        }
        try {
                  PreparedStatement prst=con.prepareStatement(sqlString.toString());
                  ResultSet e = prst.executeQuery();
                  while(e.next()){
                      ProStaff psDate =new ProStaff();
                         psDate.setpNo(e.getString("pno"));
                         psDate.setpName(e.getString("pname"));
                         psDate.setProType(e.getString("pro_type"));
                         psDate.setPerType(e.getString("per_type"));
                         psDate.setSex(e.getString("sex"));
                         psDate.setOrgId(e.getString("orgid"));
                         psDate.setSupId(e.getString("sup_id")); 
                         psDate.setOrgName(e.getString("orgname"));
                         retList.add(psDate);
                    }
                } catch (SQLException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                }
                return retList;
        }
    //get 교원
    public List<ProStaff> getSearchProList(ProStaff ps){
        List<ProStaff> retList=new ArrayList<ProStaff>();
        StringBuffer sqlString=new StringBuffer("select * from pro_staff where pro_type='교원'");
        if(!StringUtil.isEmpty(ps.getpName())){
                  sqlString.append(" and pname like '%"+ps.getpName()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getPerType())){
            sqlString.append(" and per_type like '%"+ps.getPerType()+"%'");
        }
        if(!StringUtil.isEmpty(ps.getOrgId())){
            sqlString.append(" and orgid like '%"+ps.getOrgId()+"%'");
        }
        try {
                  PreparedStatement prst=con.prepareStatement(sqlString.toString());
                  ResultSet e = prst.executeQuery();
                  while(e.next()){
                      ProStaff psData =new ProStaff();
                      psData.setpNo(e.getString("pno"));
                      psData.setpName(e.getString("pname"));
                      psData.setPerType(e.getString("per_type"));
//                      psData.setTeaType(e.getString("tea_type"));
                      psData.setSex(e.getString("sex"));
                      psData.setOrgId(e.getString("orgid"));
                      psData.setOrgName(e.getString("orgname"));
                         retList.add(psData);
                    }
                } catch (SQLException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                }
                return retList;
        }
    
        public boolean isProStaff(ProStaff ps) {
              String sql="select * from pro_staff where pno=? and email=?";
              try {
                        PreparedStatement prst=con.prepareStatement(sql);
                        prst.setString(1, ps.getpNo());
                        prst.setString(2, ps.getEmail());
                        if(prst.executeUpdate()>0) return true;
              } catch (SQLException e) {
                        e.printStackTrace();
              }
              return false;
        }
        
        public boolean updatePassword(ProStaff ps, String random) {
                  String sql = "update pro_staff set password=?  where pno=?";
                  PreparedStatement prst =null;
                  ResultSet rs;
                  try {
                            prst= con.prepareStatement(sql);
                            prst.setString(1, random);
                            prst.setString(2, ps.getpNo());
                            if(prst.executeUpdate()>0){
                                      return true;
                            }
                  } catch (SQLException e) {    
                            e.printStackTrace();
                  }
                  return false;
        }
        
        public ProStaff searchOldPassword(ProStaff ps) {
                  String sql = "select password from pro_staff where pno= ? ";
                  PreparedStatement prst =null;
                  ProStaff psRst=null;
                  ResultSet rs;
                  int id=0;
                  try {
                            prst= con.prepareStatement(sql);
                            prst.setString(1, ps.getpNo());
                            rs = prst.executeQuery();
                            while(rs.next()){
                                      psRst = new ProStaff();
                                      psRst.setPassword(rs.getString("password"));
                           }
                  } catch (SQLException e1) {
                            e1.printStackTrace();
                  }
                  return psRst;
        }
        
        public String getProId(String proName) {
                  String sql="select pno from pro_staff where pname= ? ";
                  String proid=null;
                  try {
                            PreparedStatement prst=con.prepareStatement(sql);
                            prst.setString(1, proName);
                            ResultSet rs = prst.executeQuery();
                            while(rs.next()){
                                      proid=rs.getString("pno");
                            }
                  } catch (SQLException e) {
                            e.printStackTrace();
                  }
                  return proid;
        }
        
            public String getProName(String proid) {
                      String sql="select pname from pro_staff where pno= ? ";
                      String proName=null;
                      try {
                                PreparedStatement prst=con.prepareStatement(sql);
                                prst.setString(1, proid);
                                ResultSet rs = prst.executeQuery();
                                while(rs.next()){
                                          proName=rs.getString("pname");
                                }
                      } catch (SQLException e) {
                                e.printStackTrace();
                      }
                      return proName;
            }
          public boolean updatePerInfro(ProStaff ps) {
                    String sql = "update pro_staff set tel=?,email=?,address=?  where pno=?";
                    PreparedStatement prst =null;
                    ResultSet rs;
                    try {
                              prst= con.prepareStatement(sql);
                              prst.setString(1, ps.getTel());
                              prst.setString(2,ps.getEmail());
                              prst.setString(3,ps.getAddress());
                              prst.setString(4, ps.getpNo());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {    
                              e.printStackTrace();
                    }
                    return false;
          }
          //String sql="update pro_staff set per_type=?,tea_type=?,orgid=?,sup_id=?,orgname=? where pno=?";
          public boolean insertHistory(ProStaff ps) {
                    String sql="insert into pro_history values(pro_his_seq.nextval,?,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, ps.getpNo());
                              prst.setString(2, ps.getpName());
                              prst.setString(3, ps.getProType());
                              prst.setString(4, ps.getPerType());
                              prst.setString(5,ps.getOrgName());
                              prst.setString(6, ps.getSupName());
                              prst.setString(7, DateUtil.getTodayDateTime());
                              if(prst.executeUpdate()>0) return true;
                    } catch (SQLException e) {
                              e.printStackTrace();
                    }
                    return false;
          }
        
}
