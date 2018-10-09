package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qujia.model.Address;
import com.qujia.util.StringUtil;

public class AddressDao extends BaseDao {
          public List<Address> getAddressList(Address addr){
                    List<Address> retList=new ArrayList<Address>();
                    StringBuffer sqlString=new StringBuffer("select * from address");
                    if(!StringUtil.isEmpty(addr.getDong())){
                              sqlString.append(" and dong like '%"+addr.getDong()+"%'");
                    }
                    if(!StringUtil.isEmpty(addr.getBldg())){
                              sqlString.append(" and bldg like '%"+addr.getBldg()+"%'");
                    }
                    try {
                              PreparedStatement prst=con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
                              //preparedStatement.setString(1, "%"+Student.getName()+"%");
                              ResultSet e = prst.executeQuery();
                              while(e.next()){
                                        Address s =new Address();
                                        s.setSeq(e.getString("seq"));
                                        s.setZipcode(e.getString("zipcode"));
                                        s.setSido(e.getString("sido"));
                                        s.setGugun(e.getString("gugun"));
                                        s.setDong(e.getString("dong"));
                                        s.setRi(e.getString("ri"));
                                        s.setBldg(e.getString("bldg"));
                                        s.setBunji(e.getString("bunji"));
                                        retList.add(s);
                              }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    
                    return retList;
          }
          public Address getSearchAddr(Address addr){

                    String sql = "select * from address where seq= ?";
                    Address addrRst=null;
                   ResultSet rs=null;
                    try {
                              PreparedStatement prst = con.prepareStatement(sql);
                              prst.setString(1, addr.getSeq());
                              rs = prst.executeQuery();;
                              while(rs.next()){
                                        addrRst = new Address();
                                        addrRst.setSeq(rs.getString("seq"));
                                        addrRst.setZipcode(rs.getString("zipcode"));
                                        addrRst.setSido(rs.getString("sido"));
                                        addrRst.setGugun(rs.getString("gugun"));
                                        addrRst.setDong(rs.getString("dong"));
                                        addrRst.setRi(rs.getString("ri"));
                                        addrRst.setBldg(rs.getString("bldg"));
                                        addrRst.setBunji(rs.getString("bunji"));
                             }
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    this.closeDao();
                    return addrRst;
                   
          }
}
