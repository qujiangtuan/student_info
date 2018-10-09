package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Org;
import com.qujia.util.StringUtil;

public class OrgDao extends BaseDao {
         public boolean addOrg(Org org){
                   String sql = "insert into org values(?,?,?,?,?,?,?,?,?)";
                   try {
                    PreparedStatement prst=con.prepareStatement(sql);
                    prst.setString(1, org.getOrgCode());
                    prst.setString(2,org.getName());
                    prst.setString(3,org.getsName());
                    prst.setString(4,org.getOrgType());
                    prst.setString(5,org.getCoGrCode());
                    prst.setString(6,org.getGsDepMajCode());
                    prst.setString(7,org.getAftType());
                    prst.setString(8,org.getParCode());
                    prst.setString(9,org.getTodayDate());
                    if (prst.executeUpdate() > 0)
                              return true;            
          } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
          }
                   return false;
         }
         //递归查询
         //select * from emp start with mgr='7839' connect by mgr=prior empno;
         /*
                      * --부모 삭제하면 자식 다 삭제//부모 id=2 의 자식 다 삭제
            delete node where node_id in(  
                select node_id from node  
                  start with node=2  
                  connect by prior node_id=up_node );  
          */
         //조직 천제 list
         public List<Org> getOrgList(Org org){
                   List<Org> retList=new ArrayList<Org>();
                   StringBuffer sqlString=new StringBuffer("select * from org");
                   if(!StringUtil.isEmpty(org.getName())){
                             sqlString.append(" and name like '%"+org.getName()+"%'");
                   }
                   if(!StringUtil.isEmpty(org.getOrgType())){
                             sqlString.append(" and org_type like '%"+org.getOrgType()+"%'");
                   }
                   if(!StringUtil.isEmpty(org.getOrgCode())){
                             sqlString.append(" and org_code like '%"+org.getOrgCode()+"%'");
                   }
                   if(!StringUtil.isEmpty(org.getCoGrCode())){
                             sqlString.append(" and co_gr_code = '"+org.getCoGrCode()+"'");
                   }
                   if(!StringUtil.isEmpty(org.getGsDepMajCode())){
                             sqlString.append(" and gs_dpt_maj_code = '"+org.getGsDepMajCode()+"'");
                   }
                   try {
                             PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                             //preparedStatement.setString(1, "%"+Student.getName()+"%");
                             ResultSet executeQuery = prst.executeQuery();
                             while(executeQuery.next()){
                                       Org o=new Org();
                                       o.setOrgCode(executeQuery.getString("org_code"));
                                       o.setName(executeQuery.getString("name"));
                                       o.setsName(executeQuery.getString("sname"));
                                       o.setOrgType(executeQuery.getString("org_type"));
                                       o.setCoGrCode(executeQuery.getString("co_gr_code"));
                                       o.setGsDepMajCode(executeQuery.getString("gs_dpt_maj_code"));
                                       o.setAftType(executeQuery.getString("aft_type"));
                                       o.setParCode(executeQuery.getString("par_org"));
                                       o.setTodayDate(executeQuery.getString("login_date"));
                                       retList.add(o);
                             }
                   } catch (SQLException e) {
                             // TODO Auto-generated catch block
                             e.printStackTrace();
                   }
                   
                   return retList;
         }
         //대학,대학원 list
         public List<Org> getColNameList(Org org){
                   List<Org> retList=new ArrayList<Org>();
                   String sqlString ="select * from org where CO_GR_CODE is not null";
                   try {
                             PreparedStatement prst=con.prepareStatement(sqlString);
                             ResultSet executeQuery = prst.executeQuery();
                             while(executeQuery.next()){
                                       Org o=new Org();
                                       o.setOrgCode(executeQuery.getString("org_code"));
                                       o.setName(executeQuery.getString("name"));
                                       o.setsName(executeQuery.getString("sname"));
                                       o.setOrgType(executeQuery.getString("org_type"));
                                       o.setCoGrCode(executeQuery.getString("co_gr_code"));
                                       o.setGsDepMajCode(executeQuery.getString("gs_dpt_maj_code"));
                                       o.setAftType(executeQuery.getString("aft_type"));
                                       o.setParCode(executeQuery.getString("par_org"));
                                       retList.add(o);
                             }
                   } catch (SQLException e) {
                             // TODO Auto-generated catch block
                             e.printStackTrace();
                   }
                   
                   return retList;
         }
         //학부,학과,전공 list
         public List<Org> getOrgdeptNameList(Org org){
                   List<Org> retList=new ArrayList<Org>();
                   StringBuffer sqlString=new StringBuffer("select * from org where (gs_dpt_maj_code is not null or co_gr_code='대학원') ");
                   if(!StringUtil.isEmpty(org.getName())){
                             sqlString.append(" and name like '%"+org.getName()+"%'");
                   }
                   if(!StringUtil.isEmpty(org.getGsDepMajCode())){
                             sqlString.append(" and gs_dpt_maj_code = '"+org.getGsDepMajCode()+"'");
                   }
                   try {
//                             PreparedStatement prst=con.prepareStatement(sqlString);
                             PreparedStatement prst=con.prepareStatement(sqlString.toString());
                             ResultSet executeQuery = prst.executeQuery();
                             while(executeQuery.next()){
                                       Org o=new Org();
                                       o.setOrgCode(executeQuery.getString("org_code"));
                                       o.setName(executeQuery.getString("name"));
                                       o.setsName(executeQuery.getString("sname"));
                                       o.setOrgType(executeQuery.getString("org_type"));
                                       o.setCoGrCode(executeQuery.getString("co_gr_code"));
                                       o.setGsDepMajCode(executeQuery.getString("gs_dpt_maj_code"));
                                       o.setAftType(executeQuery.getString("aft_type"));
                                       o.setParCode(executeQuery.getString("par_org"));
                                       retList.add(o);
                             }
                   } catch (SQLException e) {
                             // TODO Auto-generated catch block
                             e.printStackTrace();
                   }
                   
                   return retList;
         }
       //delete org
         public boolean deleteOrg(String orgCode){
                   String sql="delete from org where org_code="+orgCode;
                   PreparedStatement prst;
                   try {
                             prst=con.prepareStatement(sql);
                             if(prst.executeUpdate()>0){
                                       return true;
                             }
                   } catch (SQLException e) {    
                             // TODO Auto-generated catch block
                             e.printStackTrace();
                   }
                   
                   return false;
         }
       //update parCode =null
         public boolean updateParCode(String orgCode){
                   String sql="update org set par_org=null where par_org="+orgCode;
                   PreparedStatement prst;
                   try {
                             prst=con.prepareStatement(sql);
                             if(prst.executeUpdate()>0){
                                       return true;
                             }
                   } catch (SQLException e) {    
                             // TODO Auto-generated catch block
                             e.printStackTrace();
                   }
                   
                   return false;
         }
         //update org
         public boolean updateOrg(Org org){
                   String sql="update org set name = ? , sname= ? ,par_org=? where org_code=?";
                   try {
                           PreparedStatement prst=con.prepareStatement(sql);
                           prst.setString(1,org.getName());
                           prst.setString(2,org.getsName());
                           prst.setString(3,org.getParCode());
                           prst.setString(4,org.getOrgCode());
                           if(prst.executeUpdate()>0){ 
                                     return true;
                           }
                           
                 } catch (SQLException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                 }
                   return false;
         }
         public Org getSearchDept(Org org){

                   String sql = "select * from org where org_code= ?";
                   Org orgRst=null;
                  ResultSet rs=null;
                   try {
                             //把sql语句传给数据库操作对象
                             PreparedStatement prst = con.prepareStatement(sql);
                             prst.setString(1, org.getOrgCode());
                             rs = prst.executeQuery();;
                             while(rs.next()){
                                       orgRst = new Org();
                                       orgRst.setName(rs.getString("name"));
                                       orgRst.setOrgCode(rs.getString("org_code"));
                                       orgRst.setCoGrCode(rs.getString("co_gr_code"));
                            }
                   } catch (SQLException e) {
                             // TODO Auto-generated catch block
                             e.printStackTrace();
                   }
                   this.closeDao();
                   return orgRst;
                  
         }
}
