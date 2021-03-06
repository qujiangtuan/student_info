package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.model.Org;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddOrgFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_orgName;
//          private JTextField textField_sName;
          private JRadioButton radioButton_1,radioButton_2,radioButton_3;
          private ButtonGroup bGroup;
          private CardLayout card;
          private JPanel panel_1,panel_2,panel;
          private JButton submitButton;
          private JButton cancelButton;
          private JComboBox comboBox_2,comboBox_1,comboBox_3;
          private JLabel label_3;
          private JPanel panel_3;
          private JTextField textField_par;
          private List<Org> orgList;
          private static String orgType="교육기관";
          private static String orgName;
          
          
          public static String getOrgName() {
                    return orgName;
          }

          public static void setOrgName(String orgName) {
                    AddOrgFrm.orgName = orgName;
          }

          public String getOrgType() {
                    return orgType;
          }

          public void setOrgType(String orgType) {
                    this.orgType = orgType;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddOrgFrm frame = new AddOrgFrm();
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
          public AddOrgFrm() {
                    this.setResizable(false);
                    setTitle("\uC870\uC9C1\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 566, 315);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC870\uC9C1\uBA85:");
                    lblNewLabel.setBounds(76, 43, 54, 15);
                    
                    textField_orgName = new JTextField();
                    textField_orgName.setBounds(148, 40, 226, 21);
                    textField_orgName.setColumns(10);
                    
//                    JLabel lblNewLabel_1 = new JLabel("\uC57D\uC5B4\uBA85:");
//                    lblNewLabel_1.setBounds(284, 43, 54, 15);
                    
//                    textField_sName = new JTextField();
//                    textField_sName.setBounds(342, 40, 127, 21);
//                    textField_sName.setColumns(10);
                    
                    JLabel label = new JLabel("\uC870\uC9C1\uAD6C\uBD84:");
                    label.setBounds(63, 83, 67, 15);
                    
                    radioButton_1 = new JRadioButton("\uAD50\uC721\uAE30\uAD00");
                    radioButton_1.setBounds(148, 79, 84, 23);
                    radioButton_1.setSelected(true);
                    radioButton_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_1.isSelected()){
                                                  card.show(panel, "p1");
                                                  orgType="교육기관";
                                        }
                              }
                    });
                    
                    radioButton_2 = new JRadioButton("\uBD80\uC18D\uAE30\uAD00");
                    radioButton_2.setBounds(247, 79, 85, 23);
                    radioButton_2.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_2.isSelected()){
                                                  card.show(panel, "p2");
                                                  orgType="부속기관";
                                        }
                              }
                    });
                    radioButton_3 = new JRadioButton("본부행정기관");
                    radioButton_3.setBounds(342, 79, 118, 23);
                    radioButton_3.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                                  if(radioButton_3.isSelected()){
                                            card.show(panel, "p3");
                                            orgType="본부행정기관";
                                  }
                        }
              });
                    bGroup=new ButtonGroup();
                    bGroup.add(radioButton_1);
                    bGroup.add(radioButton_2);
                    bGroup.add(radioButton_3);
                    
                    card=new CardLayout(5,5);
                    panel = new JPanel(card);
                    panel.setBounds(15, 108, 491, 60);
                    
                    submitButton = new JButton("\uB4F1 \uB85D");
                    submitButton.setBounds(142, 226, 78, 23);
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        addOrg(e);
                              }
                    });
                    
                    cancelButton = new JButton("\uCDE8 \uC18C");
                    cancelButton.setBounds(300, 225, 74, 23);
                    cancelButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    
                    label_3 = new JLabel("\uC0C1\uC704\uC870\uC9C1:");
                    label_3.setBounds(110, 186, 74, 15);
                    
                    textField_par = new JTextField();
                    textField_par.setEditable(false);
                    textField_par.setBounds(192, 184, 202, 21);
                    textField_par.setColumns(10);
                    
                    JButton searchButton = new JButton("조회");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchOrgForOrgFrm sof=new SearchOrgForOrgFrm(new JFrame(),orgType);
                                        sof.setVisible(true);
                                        textField_par.setText(addSearchOrg());
                              }
                    });
                    searchButton.setBounds(404, 182, 69, 23);
                    
                    panel_1 = new JPanel();
                    panel_1.setBackground(new Color(240, 240, 240));
                    panel.add(panel_1, "p1");
                    
                    JLabel label_1 = new JLabel("\uD559\uACFC\uC804\uACF5\uAD6C\uBD84:");
                    
                    comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "\uD559\uBD80", "\uD559\uACFC", "\uC804\uACF5"}));
                    
                    comboBox_1 = new JComboBox();
                    comboBox_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        String cogo = e.getItem().toString();
                                        if("대학원".equals(cogo)){
                                                  comboBox_2.setEnabled(false);
                                        }else{
                                                  comboBox_2.setEnabled(true);
                                        }
                              }
                    });
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\uB300\uD559", "\uB300\uD559\uC6D0"}));
                    
                    JLabel label_2 = new JLabel("대상구분:");
                    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
                    gl_panel_1.setHorizontalGroup(
                              gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                  .addGap(37)
                                                  .addComponent(label_2)
                                                  .addGap(18)
                                                  .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addComponent(label_1, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                                  .addGap(18)
                                                  .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(25))
                    );
                    gl_panel_1.setVerticalGroup(
                              gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_2)
                                                            .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_1)
                                                            .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(53))
                    );
                    panel_1.setLayout(gl_panel_1);
                    
                    panel_2 = new JPanel();
                    panel_2.setBackground(new Color(240, 240, 240));
                    panel.add(panel_2, "p2");
                    
                    comboBox_3 = new JComboBox();
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "\uC0B0\uD559\uD611\uB825\uB2E8", "\uC804\uC0B0\uC174\uD130", "\uBC15\uBB3C\uAD00", "\uB3C4\uC11C\uAD00"}));
                    GroupLayout gl_panel_2 = new GroupLayout(panel_2);
                    gl_panel_2.setHorizontalGroup(
                              gl_panel_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
                                                  .addContainerGap(47, Short.MAX_VALUE)
                                                  .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(24))
                    );
                    gl_panel_2.setVerticalGroup(
                              gl_panel_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_2.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(19, Short.MAX_VALUE))
                    );
                    panel_2.setLayout(gl_panel_2);
                    
                    panel_3 = new JPanel();
                    panel_3.setBackground(new Color(240, 240, 240));
                    panel.add(panel_3, "p3");
                    GroupLayout gl_panel_3 = new GroupLayout(panel_3);
                    gl_panel_3.setHorizontalGroup(
                              gl_panel_3.createParallelGroup(Alignment.TRAILING)
                                        .addGap(0, 481, Short.MAX_VALUE)
                    );
                    gl_panel_3.setVerticalGroup(
                              gl_panel_3.createParallelGroup(Alignment.LEADING)
                                        .addGap(0, 50, Short.MAX_VALUE)
                    );
                    panel_3.setLayout(gl_panel_3);
                    contentPane.setLayout(null);
                    contentPane.add(textField_par);
                    contentPane.add(searchButton);
                    contentPane.add(lblNewLabel);
                    contentPane.add(label);
                    contentPane.add(textField_orgName);
//                    contentPane.add(lblNewLabel_1);
                    contentPane.add(radioButton_1);
                    contentPane.add(radioButton_2);
//                    contentPane.add(textField_sName);
                    contentPane.add(radioButton_3);
                    contentPane.add(panel);
                    contentPane.add(label_3);
                    contentPane.add(submitButton);
                    contentPane.add(cancelButton);
                    
          }
          protected String addSearchOrg() {
                    return SearchOrgForOrgFrm.getOrgName();
          }

          //org login
          protected void addOrg(ActionEvent e) {
                    // TODO Auto-generated method stub
                    
                    String orgCode,sName,coGrCode,gsDepMajCode,aftType,parCode,todayDate;
//                    orgCode="";
                    orgName=textField_orgName.getText().toString();
//                    sName=textField_sName.getText().toString();
//                    orgType=radioButton_1.isSelected() ? radioButton_1
//                                        .getText() :  (radioButton_2.isSelected() ? radioButton_2.getText():radioButton_3.getText());
                    coGrCode=comboBox_1.getSelectedItem().toString();
                    gsDepMajCode=comboBox_2.getSelectedItem().toString();
                    aftType=comboBox_3.getSelectedItem().toString();
                    String orgParName = textField_par.getText().toString();
                    try {
                              parCode=this.getOrgidByOrgName(orgParName);
                    } catch (NullPointerException e2) {
                              parCode=null;
                    }
                    
                    if (StringUtil.isEmpty(orgName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "조직이름을 입력하십시오！");
                              return;
                    }
                    orgCode = MakeOrgCode(radioButton_1,radioButton_2,comboBox_1,comboBox_2);
//                    orgCode="110360";
                    while(this.isRepeat(orgCode)){
                              orgCode = MakeOrgCode(radioButton_1,radioButton_2,comboBox_1,comboBox_2);
                    }
                    todayDate=DateUtil.getTodayDate();
                    Org org=new Org();
                    org.setOrgCode(orgCode);
                    org.setName(orgName);
//                    org.setsName(sName);
                    org.setOrgType(orgType);
                    org.setCoGrCode(coGrCode);
                    org.setGsDepMajCode(gsDepMajCode);
                    org.setAftType(aftType);
                    org.setParCode(parCode);
                    org.setTodayDate(todayDate);
                    OrgDao orgDao=new OrgDao();
                    if(orgDao.addOrg(org)){
                              JOptionPane.showMessageDialog(this, "조직 등록 성공했습니다!");
                    }else{
                              JOptionPane.showMessageDialog(this, "조직 등록 실패했습니다!");
                    }
                    orgDao.closeDao();
                    
                    dispose();
                    System.out.println(orgType);
                    if("교육기관".equals(orgType)&&(!StringUtil.isEmpty(gsDepMajCode))){
                              resetValue();
                              AddDeptStandFrm adsf=new AddDeptStandFrm();
                              adsf.setVisible(true);    
                    }else{
                              resetValue();
                              return;
                    }
          }
          // get orgCode 조직코드 생성
          private String MakeOrgCode(JRadioButton jr1,JRadioButton jr2,JComboBox jc1,JComboBox jc2) {
                    String orgCode;
                    String str1,str2,str3;//코드
                    //교육기관/부속기관
                    if(jr1.isSelected()){
                              str1="1";
                    }else if(jr2.isSelected()){
                              str1="2";
                    }else {
                    	str1="3";
                    }
                    //대학/대학원
                    int s2=jc1.getSelectedIndex();
                    if(s2==0){
                              str2="0";
                    }else if(s2==1){
                              str2="1";
                    }else{
                              str2="2";
                    }
                    //학부/학과/전공
                    int s3=jc2.getSelectedIndex();
                    if(s3==0){
                              str3="0";
                    }else if(s3==1){
                              str3="1";
                    }else if(s3==2){
                              str3="2";
                    }else{
                              str3="3";
                    }
                    orgCode=str1+str2+str3+StringUtil.getRandom2();
                    return orgCode;
          }
          private boolean isRepeat(String str){
//                    orgCode="110651";
                    Org org=new Org();
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList = orgDao.getOrgList(org);
                    List<String> orgNoList = new ArrayList<String>();
                    for (Org orgNo2 : orgList) {
                              String string1=orgNo2.getOrgCode();
                              orgNoList.add(string1);
                    }
                    if(!orgNoList.contains(str)){
                              return false;
                    }else{
                              return true;
                    }
//                    return false;
          }
//          restValue
          private void resetValue() {
                    // TODO Auto-generated method stub
                    textField_orgName.setText("");
//                    textField_sName.setText("");
                    bGroup.clearSelection();
                    radioButton_1.setSelected(true);
                    comboBox_1.setSelectedIndex(0);
                    comboBox_2.setSelectedIndex(0);
                    comboBox_3.setSelectedIndex(0);
                    textField_par.setText("");
          }
//        //상위 조직 从数据库中把数据填充选择框
//          protected void setOrgName() {
//                    // TODO Auto-generated method stub
//                   OrgDao orgDao=new OrgDao();
//                    List<Org> orgList = orgDao.getOrgList(new Org());
//                    String str=null;
//                    for (Org org : orgList) {
//                              comboBox_par.addItem(org);
//                    }
//                    orgDao.closeDao();
//          }
        //orgid에 통해서 orgName를 받는다
          public String getOrgNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
        //orgName에 통해서 orgid를 받는다
          public String getOrgidByOrgName(String name){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getName().equals(name)) return org.getOrgCode();
                    }
                    return "";
          }
}
