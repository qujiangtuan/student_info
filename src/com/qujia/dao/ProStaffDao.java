package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.ProStaff;
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
                	  psRst.setPassword(rs.getString("password"));
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
                  prst.setString(6, ps.getTeaType());
                  prst.setString(7, ps.getSex());
                  prst.setString(8, ps.getIdCardNo());
                  prst.setString(9, ps.getOrgId());
                  prst.setString(10, ps.getAddress());
                  prst.setString(11, ps.getTel());
                  prst.setString(12, ps.getEmail());
                  prst.setString(13, ps.getLoginDate());
                  prst.setString(14, ps.getPassword());
                  prst.setString(15, ps.getSupId());
                  if(prst.executeUpdate()>0) return true;
        } catch (SQLException e) {
                  // TODO Auto-generated catch block
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
        if(!StringUtil.isEmpty(ps.getOrgId())){
            sqlString.append(" and orgid like '%"+ps.getOrgId()+"%'");
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
	         			 psDate.setTeaType(e.getString("tea_type"));
	         			 psDate.setSex(e.getString("sex"));
	         			 psDate.setIdCardNo(e.getString("id_card_no"));
	         			 psDate.setOrgId(e.getString("orgid"));
	         			 psDate.setAddress(e.getString("address"));
	         			 psDate.setTel(e.getString("tel"));
	         			 psDate.setEmail(e.getString("email"));
	         			 psDate.setLoginDate(e.getString("login_date"));
	         			 psDate.setPassword(e.getString("password"));
	         			 psDate.setSupId(e.getString("sup_id"));     
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
              String sql="update pro_staff set per_type=?,tea_type=?,orgid=?,sup_id=? where pno=?";
              try {
                      PreparedStatement prst=con.prepareStatement(sql);
                      prst.setString(1, ps.getPerType());
                      prst.setString(2, ps.getTeaType());
                      prst.setString(3, ps.getOrgId());
                      prst.setString(4, ps.getSupId());
                      prst.setString(5, ps.getpNo());
//                      prst.setString(1,ps.getpName());
//                      prst.setString(2, ps.getPeName());
//                      prst.setString(3, ps.getProType());
//                      prst.setString(4, ps.getPerType());
//                      prst.setString(5, ps.getTeaType());
//                      prst.setString(6, ps.getSex());
//                      prst.setString(7, ps.getOrgId());
//                      prst.setString(8, ps.getAddress());
//                      prst.setString(9, ps.getTel());
//                      prst.setString(10, ps.getEmail());
//                      prst.setString(11, ps.getSupId());
//                      prst.setString(12, ps.getpNo());
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
}
