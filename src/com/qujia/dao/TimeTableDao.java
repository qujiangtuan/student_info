package com.qujia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qujia.model.TimeTable;

public class TimeTableDao extends BaseDao {

          public boolean loginTT1(TimeTable tt1) {
                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getDateStart());
                              prst.setString(3,tt1.getDateEnd());
                              prst.setInt(4,tt1.getCrId());
                              prst.setString(5,tt1.getCouNo());
                              prst.setString(6,tt1.getCrName());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean loginTT2(TimeTable tt2) {
                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt2.getWeek());
                              prst.setString(2,tt2.getDateStart());
                              prst.setString(3,tt2.getDateEnd());
                              prst.setInt(4,tt2.getCrId());
                              prst.setString(5,tt2.getCouNo());
                              prst.setString(6,tt2.getCrName());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean loginTT3(TimeTable tt3) {
                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt3.getWeek());
                              prst.setString(2,tt3.getDateStart());
                              prst.setString(3,tt3.getDateEnd());
                              prst.setInt(4,tt3.getCrId());
                              prst.setString(5,tt3.getCouNo());
                              prst.setString(6,tt3.getCrName());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean loginTT4(TimeTable tt4) {
                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt4.getWeek());
                              prst.setString(2,tt4.getDateStart());
                              prst.setString(3,tt4.getDateEnd());
                              prst.setInt(4,tt4.getCrId());
                              prst.setString(5,tt4.getCouNo());
                              prst.setString(6,tt4.getCrName());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean loginTT5(TimeTable tt5) {
                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt5.getWeek());
                              prst.setString(2,tt5.getDateStart());
                              prst.setString(3,tt5.getDateEnd());
                              prst.setInt(4,tt5.getCrId());
                              prst.setString(5,tt5.getCouNo());
                              prst.setString(6,tt5.getCrName());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }

          public boolean loginTT6(TimeTable tt6) {
                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt6.getWeek());
                              prst.setString(2,tt6.getDateStart());
                              prst.setString(3,tt6.getDateEnd());
                              prst.setInt(4,tt6.getCrId());
                              prst.setString(5,tt6.getCouNo());
                              prst.setString(6,tt6.getCrName());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 삭제1
          public boolean deleteTT1(TimeTable tt1) {
                    String sql="delete from cou_time_table  where week=? and cou_no= ? ";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getCouNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 삭제2
          public boolean deleteTT2(TimeTable tt2) {
                    String sql="delete from cou_time_table  where week=? and cou_no= ? ";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt2.getWeek());
                              prst.setString(2,tt2.getCouNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 삭제3
          public boolean deleteTT3(TimeTable tt3) {
                    String sql="delete from cou_time_table  where week=? and cou_no= ? ";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt3.getWeek());
                              prst.setString(2,tt3.getCouNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 삭제4
          public boolean deleteTT4(TimeTable tt4) {
                    String sql="delete from cou_time_table  where week=? and cou_no= ? ";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt4.getWeek());
                              prst.setString(2,tt4.getCouNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 삭제5
          public boolean deleteTT5(TimeTable tt5) {
                    String sql="delete from cou_time_table  where week=? and cou_no= ? ";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt5.getWeek());
                              prst.setString(2,tt5.getCouNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 삭제6
          public boolean deleteTT6(TimeTable tt6) {
                    String sql="delete from cou_time_table  where week=? and cou_no= ? ";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt6.getWeek());
                              prst.setString(2,tt6.getCouNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          //있는 데이터 수정1
          public boolean updateTT1(TimeTable tt1) {
                    String sql="update cou_time_table set week=?,start_time=?,end_time=?,class_no=?,cou_no=?  where tt_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getDateStart());
                              prst.setString(3,tt1.getDateEnd());
                              prst.setInt(4,tt1.getCrId());
                              prst.setString(5,tt1.getCouNo());
                              prst.setString(6,tt1.getTtNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 수정2
          public boolean updateTT2(TimeTable tt2) {
                    String sql="update cou_time_table set week=?,start_time=?,end_time=?,class_no=?,cou_no=?  where tt_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt2.getWeek());
                              prst.setString(2,tt2.getDateStart());
                              prst.setString(3,tt2.getDateEnd());
                              prst.setInt(4,tt2.getCrId());
                              prst.setString(5,tt2.getCouNo());
                              prst.setString(6,tt2.getTtNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 수정3
          public boolean updateTT3(TimeTable tt3) {
                    String sql="update cou_time_table set week=?,start_time=?,end_time=?,class_no=?,cou_no=?  where tt_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt3.getWeek());
                              prst.setString(2,tt3.getDateStart());
                              prst.setString(3,tt3.getDateEnd());
                              prst.setInt(4,tt3.getCrId());
                              prst.setString(5,tt3.getCouNo());
                              prst.setString(6,tt3.getTtNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 수정4
          public boolean updateTT4(TimeTable tt4) {
                    String sql="update cou_time_table set week=?,start_time=?,end_time=?,class_no=?,cou_no=?  where tt_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt4.getWeek());
                              prst.setString(2,tt4.getDateStart());
                              prst.setString(3,tt4.getDateEnd());
                              prst.setInt(4,tt4.getCrId());
                              prst.setString(5,tt4.getCouNo());
                              prst.setString(6,tt4.getTtNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 수정5
          public boolean updateTT5(TimeTable tt5) {
                    String sql="update cou_time_table set week=?,start_time=?,end_time=?,class_no=?,cou_no=?  where tt_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt5.getWeek());
                              prst.setString(2,tt5.getDateStart());
                              prst.setString(3,tt5.getDateEnd());
                              prst.setInt(4,tt5.getCrId());
                              prst.setString(5,tt5.getCouNo());
                              prst.setString(6,tt5.getTtNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //있는 데이터 수정6
          public boolean updateTT6(TimeTable tt6) {
                    String sql="update cou_time_table set week=?,start_time=?,end_time=?,class_no=?,cou_no=?  where tt_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt6.getWeek());
                              prst.setString(2,tt6.getDateStart());
                              prst.setString(3,tt6.getDateEnd());
                              prst.setInt(4,tt6.getCrId());
                              prst.setString(5,tt6.getCouNo());
                              prst.setString(6,tt6.getTtNo());
                              if (prst.executeUpdate() > 0)
                                        return true;            
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          
          //week 와 학수번호 에 통해서 데이터 있는지 판단1
          public boolean isExistWC1(TimeTable tt1) {
                    String sql="select  count(*) count from cou_time_table where week=? and cou_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getCouNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        count=rs.getInt("count");
                              }      
                              if(count==1) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //week 와 학수번호 에 통해서 데이터 있는지 판단2
          public boolean isExistWC2(TimeTable tt1) {
                    String sql="select  count(*) count from cou_time_table where week=? and cou_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getCouNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        count=rs.getInt("count");
                              }      
                              if(count==1) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //week 와 학수번호 에 통해서 데이터 있는지 판단3
          public boolean isExistWC3(TimeTable tt1) {
                    String sql="select  count(*) count from cou_time_table where week=? and cou_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getCouNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        count=rs.getInt("count");
                              }      
                              if(count==1) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //week 와 학수번호 에 통해서 데이터 있는지 판단4
          public boolean isExistWC4(TimeTable tt1) {
                    String sql="select  count(*) count from cou_time_table where week=? and cou_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getCouNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        count=rs.getInt("count");
                              }      
                              if(count==1) return true;    
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //week 와 학수번호 에 통해서 데이터 있는지 판단5
          public boolean isExistWC5(TimeTable tt1) {
                    String sql="select  count(*) count from cou_time_table where week=? and cou_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getCouNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        count=rs.getInt("count");
                              }      
                              if(count==1) return true;     
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
        //week 와 학수번호 에 통해서 데이터 있는지 판단6
          public boolean isExistWC6(TimeTable tt1) {
                    String sql="select  count(*) count from cou_time_table where week=? and cou_no=?";
//                    String sql="insert into cou_time_table values(tt_seq.nextval,?,?,?,?,?)";
                    int count=0;
                    try {
                              PreparedStatement prst=con.prepareStatement(sql);
                              prst.setString(1, tt1.getWeek());
                              prst.setString(2,tt1.getCouNo());
                              ResultSet rs = prst.executeQuery();
                              while (rs.next()) {
                                        count=rs.getInt("count");
                              }      
                              if(count==1) return true;
                    } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                    }
                    return false;
          }
          
          
          
          
}
