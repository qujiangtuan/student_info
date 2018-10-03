package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.model.Org;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddOrgFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_orgName;
          private JTextField textField_sName;
          private JRadioButton radioButton_1,radioButton_2,radioButton_3;
          private ButtonGroup bGroup;
          private CardLayout card;
          private JPanel panel_1,panel_2,panel;
          private JButton submitButton;
          private JButton cancelButton;
          private JComboBox comboBox_2,comboBox_1,comboBox_3;
          private JLabel label_3;
          private JComboBox comboBox_par;
          private JPanel panel_3;
          private JComboBox comboBox;
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
                    setTitle("\uC870\uC9C1\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 566, 315);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC870\uC9C1\uBA85:");
                    
                    textField_orgName = new JTextField();
                    textField_orgName.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC57D\uC5B4\uBA85:");
                    
                    textField_sName = new JTextField();
                    textField_sName.setColumns(10);
                    
                    JLabel label = new JLabel("\uC870\uC9C1\uAD6C\uBD84:");
                    
                    radioButton_1 = new JRadioButton("\uAD50\uC721\uAE30\uAD00");
                    radioButton_1.setSelected(true);
                    radioButton_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_1.isSelected()){
                                                  card.show(panel, "p1");
                                        }
                              }
                    });
                    
                    radioButton_2 = new JRadioButton("\uBD80\uC18D\uAE30\uAD00");
                    radioButton_2.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_2.isSelected()){
                                                  card.show(panel, "p2");
                                        }
                              }
                    });
                    radioButton_3 = new JRadioButton("본부행정기관");
                    radioButton_3.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                                  if(radioButton_3.isSelected()){
                                            card.show(panel, "p3");
                                  }
                        }
              });
                    bGroup=new ButtonGroup();
                    bGroup.add(radioButton_1);
                    bGroup.add(radioButton_2);
                    bGroup.add(radioButton_3);
                    
                    card=new CardLayout(5,5);
                    panel = new JPanel(card);
                    
                    submitButton = new JButton("\uB4F1 \uB85D");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        addOrg(e);
                              }
                    });
                    
                    cancelButton = new JButton("\uCDE8 \uC18C");
                    
                    label_3 = new JLabel("\uC0C1\uC704\uC870\uC9C1:");
                    
                    comboBox_par = new JComboBox();
                    
                    
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGap(71)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    						.addComponent(lblNewLabel)
                    						.addComponent(label))
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addComponent(textField_orgName, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                    							.addGap(42)
                    							.addComponent(lblNewLabel_1)
                    							.addPreferredGap(ComponentPlacement.RELATED))
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addComponent(radioButton_1)
                    							.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    							.addComponent(radioButton_2)
                    							.addGap(22)))
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addComponent(textField_sName, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(radioButton_3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                    					.addGap(37))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addContainerGap()
                    					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGap(22)
                    					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addComponent(submitButton)
                    							.addGap(113)
                    							.addComponent(cancelButton))
                    						.addComponent(comboBox_par, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
                    					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)))
                    			.addGap(39))
                    );
                    gl_contentPane.setVerticalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addGap(35)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(lblNewLabel)
                    				.addComponent(textField_orgName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel_1)
                    				.addComponent(textField_sName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    				.addComponent(radioButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    				.addComponent(radioButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    				.addComponent(radioButton_3))
                    			.addPreferredGap(ComponentPlacement.UNRELATED)
                    			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(comboBox_par, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(label_3))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(submitButton)
                    				.addComponent(cancelButton))
                    			.addContainerGap())
                    );
                    
                    panel_1 = new JPanel();
                    panel_1.setBackground(new Color(175, 238, 238));
                    panel.add(panel_1, "p1");
                    
                    JLabel label_1 = new JLabel("\uD559\uACFC\uC804\uACF5\uAD6C\uBD84:");
                    
                    comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "\uD559\uBD80", "\uD559\uACFC", "\uC804\uACF5"}));
                    
                    comboBox_1 = new JComboBox();
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\uB300\uD559", "\uB300\uD559\uC6D0"}));
                    
                    JLabel label_2 = new JLabel("\uB300\uC0C1:");
                    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
                    gl_panel_1.setHorizontalGroup(
                              gl_panel_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_1.createSequentialGroup()
                                                  .addGap(59)
                                                  .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
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
                    panel_2.setBackground(new Color(255, 222, 173));
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
                    panel_3.setBackground(new Color(255, 255, 255));
                    panel.add(panel_3, "p3");
                    
                    comboBox = new JComboBox();
                    GroupLayout gl_panel_3 = new GroupLayout(panel_3);
                    gl_panel_3.setHorizontalGroup(
                    	gl_panel_3.createParallelGroup(Alignment.TRAILING)
                    		.addGap(0, 481, Short.MAX_VALUE)
                    		.addGroup(gl_panel_3.createSequentialGroup()
                    			.addContainerGap(47, Short.MAX_VALUE)
                    			.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                    			.addGap(24))
                    );
                    gl_panel_3.setVerticalGroup(
                    	gl_panel_3.createParallelGroup(Alignment.LEADING)
                    		.addGap(0, 50, Short.MAX_VALUE)
                    		.addGroup(gl_panel_3.createSequentialGroup()
                    			.addContainerGap()
                    			.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    			.addContainerGap(19, Short.MAX_VALUE))
                    );
                    panel_3.setLayout(gl_panel_3);
                    contentPane.setLayout(gl_contentPane);
                    
                    setOrgName();
          }
          //org login
          protected void addOrg(ActionEvent e) {
                    // TODO Auto-generated method stub
                    
                    String orgCode,name,sName,orgType,coGrCode,gsDepMajCode,aftType,parCode,todayDate;
//                    orgCode="";
                    name=textField_orgName.getText().toString();
                    sName=textField_sName.getText().toString();
                    orgType=radioButton_1.isSelected() ? radioButton_1
                                        .getText() :  (radioButton_2.isSelected() ? radioButton_2.getText():radioButton_3.getText());
                    coGrCode=comboBox_1.getSelectedItem().toString();
                    gsDepMajCode=comboBox_2.getSelectedItem().toString();
                    aftType=comboBox_3.getSelectedItem().toString();
                    Org orgPar = (Org) comboBox_par.getSelectedItem();
                    try {
                              parCode=orgPar.getOrgCode();
                    } catch (NullPointerException e2) {
                              parCode=null;
                    }
                    
                    if (StringUtil.isEmpty(name)) {
                              JOptionPane.showMessageDialog(this,
                                                  "조직이름을 입력하십시오！");
                              return;
                    }
                    orgCode = MakeOrgCode(radioButton_1,radioButton_2,comboBox_1,comboBox_2);
                    todayDate=DateUtil.getTodayDate();
                    Org org=new Org();
                    org.setOrgCode(orgCode);
                    org.setName(name);
                    org.setsName(sName);
                    org.setOrgType(orgType);
                    org.setCoGrCode(coGrCode);
                    org.setGsDepMajCode(gsDepMajCode);
                    org.setAftType(aftType);
                    org.setParCode(parCode);
                    org.setTodayDate(todayDate);
                    OrgDao orgDao=new OrgDao();
                    if(orgDao.addOrg(org)){
                              JOptionPane.showMessageDialog(this, "조직 등록 성공!");
                    }else{
                              JOptionPane.showMessageDialog(this, "조직 등록 실패!");
                    }
                    orgDao.closeDao();
                    resetValue();
                    setOrgName();
                    
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
//          restValue
          private void resetValue() {
                    // TODO Auto-generated method stub
                    textField_orgName.setText("");
                    textField_sName.setText("");
                    bGroup.clearSelection();
                    radioButton_1.setSelected(true);
                    comboBox_1.setSelectedIndex(0);
                    comboBox_2.setSelectedIndex(0);
                    comboBox_3.setSelectedIndex(0);
                    comboBox_par.setSelectedIndex(0);
          }
        //상위 조직 从数据库中把数据填充选择框
          protected void setOrgName() {
                    comboBox_par.removeAllItems();
                    // TODO Auto-generated method stub
                   OrgDao orgDao=new OrgDao();
                    List<Org> orgList = orgDao.getOrgList(new Org());
                    String str=null;
                    comboBox_par.addItem(str);
                    for (Org org : orgList) {
                              comboBox_par.addItem(org);
                    }
                    orgDao.closeDao();
          }
}
