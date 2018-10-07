package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.dao.SecondMajorRangeDao;
import com.qujia.model.Org;
import com.qujia.model.SecondMajorRange;
import com.qujia.util.DateUtil;
import com.qujia.util.ViewUtil;

public class AddAppendMajorOrgFrm extends JFrame {

          private JPanel contentPane;
          private JComboBox comboBox_base,comboBox_allow;
          private JSpinner spinner_start,spinner_end;
          private JComboBox comboBox_allowType,comboBox_rangetype;
          
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddAppendMajorOrgFrm frame = new AddAppendMajorOrgFrm();
                                                  frame.setVisible(true);
                                        } catch (Exception e) {
                                                  e.printStackTrace();
                                        }
                              }
                    });
          }

          /**
           * Create the frame.
           */
          public AddAppendMajorOrgFrm() {
                    setTitle("\uBCF5\uC218\uBD80\uC804\uACF5\uD5C8\uC6A9\uBC94\uC704\uCD94\uAC00");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 576, 322);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAE30\uC900\uD559\uACFC:");
                    lblNewLabel.setBounds(67, 45, 72, 15);
                    
                    comboBox_base = new JComboBox();
                    comboBox_base.setBounds(163, 42, 309, 21);
                    
                    comboBox_allow = new JComboBox();
                    comboBox_allow.setBounds(163, 82, 309, 21);
                    
                    JLabel label = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    label.setBounds(67, 85, 72, 15);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC801\uC6A9\uB144\uB3C4:");
                    lblNewLabel_1.setBounds(67, 124, 72, 15);
                    
                    spinner_start = new JSpinner();
                    spinner_start.setBounds(163, 121, 113, 22);
                    spinner_start.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    spinner_end = new JSpinner();
                    spinner_end.setBounds(362, 121, 110, 22);
                    spinner_end.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD5C8\uC6A9\uAD6C\uBD84:");
                    lblNewLabel_2.setBounds(67, 164, 72, 15);
                    
                     comboBox_allowType = new JComboBox();
                     comboBox_allowType.setBounds(163, 161, 113, 21);
                    comboBox_allowType.setModel(new DefaultComboBoxModel(new String[] {"\uBCF5\uC218\uC804\uACF5", "\uBD80\uC804\uACF5"}));
                    
                    JLabel lblNewLabel_3 = new JLabel("\uBC94\uC704\uAD6C\uBD84:");
                    lblNewLabel_3.setBounds(286, 164, 66, 15);
                    
                     comboBox_rangetype = new JComboBox();
                     comboBox_rangetype.setBounds(362, 161, 110, 21);
                    comboBox_rangetype.setModel(new DefaultComboBoxModel(new String[] {"\uB300\uD559", "\uD559\uBD80", "\uD559\uACFC", "\uC804\uACF5"}));
                    
                    JButton AddButton = new JButton("\uCD94 \uAC00");
                    AddButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        AddAppendMajorAciton(e);
                              }
                    });
                    AddButton.setBounds(163, 226, 63, 23);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(label);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(AddButton);
                    contentPane.add(comboBox_allow);
                    contentPane.add(comboBox_base);
                    contentPane.add(comboBox_allowType);
                    contentPane.add(spinner_start);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(spinner_end);
                    contentPane.add(comboBox_rangetype);
                    
                    
                    setDeptName();
                    
          }
          //복수부전공 허용범위 추가 event
        protected void AddAppendMajorAciton(ActionEvent e) {
                  Org org1=(Org)comboBox_base.getSelectedItem();
                  String orgidBase=org1.getOrgCode();
                  Org org2=(Org)comboBox_allow.getSelectedItem();
                  String orgidAllow=org2.getOrgCode();
                  String startTime = spinner_start.getValue().toString();
                  String endTime=spinner_end.getValue().toString();
                  String allowType = comboBox_allowType.getSelectedItem().toString();
                  String rangeType = comboBox_rangetype.getSelectedItem().toString();
                  String loginDate=DateUtil.getTodayDate();
                  String orgidBaseNm=org1.getName();
                  String orgidAllowNm=org2.getName();
                  String isAllow=getIsAllow(endTime,loginDate);
                  
                  SecondMajorRange smr=new SecondMajorRange();
                  smr.setOrgidBase(orgidBase);
                  smr.setOrgidAllow(orgidAllow);
                  smr.setStartTime(startTime);
                  smr.setEndTime(endTime);
                  smr.setAllowType(allowType);
                  smr.setRangeType(rangeType);
                  smr.setLoginDate(loginDate);
                  smr.setOrgidBaseName(orgidBaseNm);
                  smr.setOrgidAllowName(orgidAllowNm);
                  smr.setIsAllow(isAllow);
                  SecondMajorRangeDao amrDao=new SecondMajorRangeDao();
                  if(amrDao.addSecondMajorRange(smr)){
                            JOptionPane.showMessageDialog(this, "복수부전공허용 추가 성공했습니다!");
                  }else{
                            JOptionPane.showMessageDialog(this, "복수부전공허용 추가 실패했습니다!");
                  }
          }
        //허용여부 판단
        private String getIsAllow(String endTime, String loginDate) {
                  String flag=null;
                  String dateYear = loginDate.substring(0, 4);
                  int dateyear = Integer.parseInt(dateYear);
                  int endtime=Integer.parseInt(endTime);
                  if(dateyear>=endtime){
                            flag="No";
                  }else{
                            flag="Yes";
                  }
                    return flag;
          }

//학과 받기
          protected void setDeptName() {
                    // TODO Auto-generated method stub
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList=orgDao.getOrgdeptNameList(new Org());
                    for (Org org: orgList) {
                              comboBox_base.addItem(org);
                              comboBox_allow.addItem(org);
                    }
                    orgDao.closeDao();
          }
          
}
