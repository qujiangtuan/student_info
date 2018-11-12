package com.qujia.view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.ProStaffDao;
import com.qujia.model.ProStaff;
import com.qujia.model.SendEmailToSP;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddProFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTextField textField_ename;
          private JTextField textField_address1;
          private JTextField textField_email1;
          private JTextField textField_cardid_1;
          private JTextField textField_cardid_2;
          private JTextField textField_tel2;
          private  JRadioButton teacherRadioButton,empRadioButton;
          private  JRadioButton radioButton_1,radioButton_3,radioButton_5;
          private JRadioButton radioButton_2,radioButton_4,radioButton_6;
          private  JRadioButton radioButton_male,radioButton_female;
          private ButtonGroup bgroup1,bgroup2,bgroup3;
          private JPanel panel,panel_1,panel_2;
          private CardLayout card;
          private JComboBox comboBox_emptype;
          private JLabel label_7;
          private JLabel label_8;
          private JTextField textField_address2;
          private JTextField textField_org;
          private JButton btnNewButton_2;
          private JButton button;
          private JComboBox comboBox_tel1;
          private JTextField textField_tel3;
          private JLabel lblNewLabel_2;
          private JLabel label_9;
          private JLabel label_ait;
          private JComboBox comboBox_email2;
          private JTextField textField_sup;
          private JButton btnNewButton_3;
          
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddProFrm frame = new AddProFrm();
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
          public AddProFrm() {
                    this.setResizable(false);
                    setTitle("\uAD50\uC9C1\uC6D0\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 796, 440);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("교직원이름:");
                    lblNewLabel.setBounds(51, 45, 74, 15);
                    
                    textField_name = new JTextField();
                    textField_name.setBounds(135, 42, 210, 21);
                    textField_name.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("    \uC601\uC5B4\uC774\uB984:");
                    lblNewLabel_1.setBounds(361, 45, 96, 15);
                    
                    textField_ename = new JTextField();
                    textField_ename.setBounds(461, 42, 223, 21);
                    textField_ename.setColumns(10);
                    
                    JLabel label = new JLabel("       \uC131 \uBCC4:");
                    label.setBounds(361, 89, 96, 15);
                    
                    JLabel label_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638:");
                    label_1.setBounds(361, 116, 96, 15);
                    
                    JLabel label_2 = new JLabel("    \uC18C\uC18D\uC870\uC9C1:");
                    label_2.setBounds(361, 154, 96, 15);
                    
                    JLabel label_3 = new JLabel("        \uC8FC\uC18C:");
                    label_3.setBounds(361, 185, 96, 15);
                    
                    JLabel label_4 = new JLabel("      \uC774\uBA54\uC77C:");
                    label_4.setBounds(361, 263, 96, 15);
                    
                    textField_address1 = new JTextField();
                    textField_address1.setBounds(461, 182, 223, 21);
                    textField_address1.setColumns(10);
                    
                    textField_email1 = new JTextField();
                    textField_email1.setBounds(461, 260, 96, 21);
                    textField_email1.setColumns(10);
                    
                    radioButton_male = new JRadioButton("\uB0A8");
                    radioButton_male.setBounds(461, 85, 59, 23);
                    radioButton_male.setSelected(true);
                    radioButton_female = new JRadioButton("\uC5EC");
                    radioButton_female.setBounds(537, 85, 55, 23);
                    bgroup3=new ButtonGroup();
                    bgroup3.add(radioButton_male);
                    bgroup3.add(radioButton_female);
                    
                    textField_cardid_1 = new JTextField();
                    textField_cardid_1.setBounds(461, 114, 86, 21);
                    textField_cardid_1.addKeyListener(new KeyAdapter() {
                    	@Override
                    	public void keyTyped(KeyEvent ke) {
                    		int keyChar = ke.getKeyChar();
                            if (keyChar >= KeyEvent.VK_0
                                                && keyChar <= KeyEvent.VK_9
                                                || keyChar == KeyEvent.VK_BACK_SPACE
                                                || keyChar == KeyEvent.VK_DELETE) {

                            } else {
                                      ke.consume();
                                      JOptionPane.showMessageDialog(
                                                          null,
                                                          "숫자만 입력 가능합니다!");
                                      return;
                            }
                            int len = textField_cardid_1.getText()
                                                .length();
                            if (len > 5) {
                                      ke.consume();
                                      // JOptionPane.showMessageDialog(null,
                                      // "6짜리 초과하면 안 됩니다!");
                                      KeyboardFocusManager.getCurrentKeyboardFocusManager()
                                                          .focusNextComponent();
                                      return;
                            }
                    	}
                    });
                    textField_cardid_1.setColumns(10);
                    
                    textField_cardid_2 = new JTextField();
                    textField_cardid_2.setBounds(579, 113, 105, 21);
                    textField_cardid_2.addKeyListener(new KeyAdapter() {
                    	@Override
                    	public void keyTyped(KeyEvent ke) {
                    		 int keyChar = ke.getKeyChar();
                             if (keyChar >= KeyEvent.VK_0
                                                 && keyChar <= KeyEvent.VK_9
                                                 || keyChar == KeyEvent.VK_BACK_SPACE
                                                 || keyChar == KeyEvent.VK_DELETE) {

                             } else {
                                       ke.consume();
                                       JOptionPane.showMessageDialog(
                                                           null,
                                                           "숫자만 입력 가능합니다!");
                                       ke.consume();
                                       return;
                             }
                             int len = textField_cardid_2.getText()
                                                 .length();
                             if (len > 6) {
                                       ke.consume();
                                       JOptionPane.showMessageDialog(
                                                           null,
                                                           "7자리 초과하면 안 됩니다!");
                                       ke.consume();
                                       return;
                             }
                    	}
                    });
                    textField_cardid_2.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uB4F1 \uB85D");
                    btnNewButton.setBounds(280, 311, 63, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		try {
                                                  addProSubmit(ae);
                                        } catch (Exception e) {
                                                  // TODO Auto-generated catch block
                                                  e.printStackTrace();
                                        }
                    	}
                    });
                    
                    JButton btnNewButton_1 = new JButton("\uCDE8 \uC18C");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    btnNewButton_1.setBounds(461, 311, 63, 23);
                    
                    JLabel staff_typeLabel = new JLabel("\uAD50\uC9C1\uC6D0\uAD6C\uBD84:");
                    staff_typeLabel.setBounds(51, 89, 74, 15);
                   
                    teacherRadioButton = new JRadioButton("\uAD50\uC6D0");
                    teacherRadioButton.setBounds(135, 85, 57, 23);
                    teacherRadioButton.setSelected(true);
                    teacherRadioButton.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent arg0) {
                    		card.show(panel, "panel_1");
                    		comboBox_emptype.setSelectedIndex(0);
                    		textField_sup.setText("");
                    	}
                    });
                    
                    empRadioButton = new JRadioButton("\uC9C1\uC6D0");
                    empRadioButton.setBounds(192, 85, 153, 23);
                    empRadioButton.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent e) {
                    		card.show(panel, "panel_2");
                    		bgroup2.clearSelection();
                    		radioButton_1.setSelected(true);
//                    		comboBox_superior1.setSelectedIndex(0);
                    	}
                    });
                    bgroup1=new ButtonGroup();
                    bgroup1.add(teacherRadioButton);
                    bgroup1.add(empRadioButton);
                    panel = new JPanel();
                    panel.setBounds(51, 114, 292, 128);
                    
                    JLabel lblNewLabel_3 = new JLabel("연락처:");
                    lblNewLabel_3.setBounds(51, 263, 63, 15);
                    
                    textField_tel2 = new JTextField();
                    textField_tel2.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar = ke.getKeyChar();
                                        if (keyChar >= KeyEvent.VK_0
                                                            && keyChar <= KeyEvent.VK_9
                                                            || keyChar == KeyEvent.VK_BACK_SPACE
                                                            || keyChar == KeyEvent.VK_DELETE) {

                                        } else {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "숫자만 입력 가능합니다!");
                                                  return;
                                        }
                                        int len = textField_tel2.getText()
                                                            .length();
                                        if (len > 3) {
                                                  ke.consume();
                                                  // JOptionPane.showMessageDialog(null,
                                                  // "6짜리 초과하면 안 됩니다!");
                                                  KeyboardFocusManager.getCurrentKeyboardFocusManager()
                                                                      .focusNextComponent();
                                                  return;
                                        }
                              }
                    });
                    textField_tel2.setBounds(204, 260, 60, 21);
                    textField_tel2.setColumns(10);
                    
                    JLabel label_6 = new JLabel("-");
                    label_6.setBounds(557, 114, 6, 19);
                    
                    card=new CardLayout(0,0);
                    panel.setLayout(card);
                    
                    panel_1 = new JPanel();
                    panel.add(panel_1, "panel_1");
                    
                    JLabel label_5 = new JLabel("직위: ");
                    label_5.setBounds(21, 18, 45, 15);
                    radioButton_1 = new JRadioButton("정교수");
                    radioButton_1.setBounds(74, 14, 83, 23);
                    radioButton_1.setSelected(true);
                    radioButton_3 = new JRadioButton("조교수");
                    radioButton_3.setBounds(74, 54, 83, 23);
                    
                    radioButton_5 = new JRadioButton("겸임교수");
                    radioButton_5.setBounds(74, 99, 83, 23);
                    
                    
                    panel_1.setLayout(null);
                    panel_1.add(label_5);
                    panel_1.add(radioButton_5);
                    panel_1.add(radioButton_3);
                    panel_1.add(radioButton_1);
                    
                    radioButton_2 = new JRadioButton("부교수");
                    radioButton_2.setBounds(173, 14, 83, 23);
                    panel_1.add(radioButton_2);
                    
                    radioButton_4 = new JRadioButton("전임강사");
                    radioButton_4.setBounds(173, 54, 83, 23);
                    panel_1.add(radioButton_4);
                    
                    radioButton_6 = new JRadioButton("시간강가");
                    radioButton_6.setBounds(173, 99, 83, 23);
                    panel_1.add(radioButton_6);
                    
                    bgroup2=new ButtonGroup();
                    bgroup2.add(radioButton_1);
                    bgroup2.add(radioButton_3);
                    bgroup2.add(radioButton_5);
                    bgroup2.add(radioButton_2);
                    bgroup2.add(radioButton_4);
                    bgroup2.add(radioButton_6);
                    
                    panel_2 = new JPanel();
                    panel.add(panel_2, "panel_2");
                    
                    comboBox_emptype = new JComboBox();
                    comboBox_emptype.setBounds(80, 28, 103, 21);
                    comboBox_emptype.setModel(new DefaultComboBoxModel(new String[] {"", "부장", "차장", "대리", "사원"}));
                    
                    JLabel lblNewLabel_5 = new JLabel("직      위:");
                    lblNewLabel_5.setBounds(10, 31, 70, 15);
                    
                    label_7 = new JLabel("\uC9C1\uC18D\uC0C1\uC0AC:");
                    label_7.setBounds(10, 70, 70, 15);
                    panel_2.setLayout(null);
                    panel_2.add(lblNewLabel_5);
                    panel_2.add(label_7);
                    panel_2.add(comboBox_emptype);
                    
                    textField_sup = new JTextField();
                    textField_sup.setEditable(false);
                    textField_sup.setBounds(79, 66, 104, 21);
                    panel_2.add(textField_sup);
                    textField_sup.setColumns(10);
                    
                    btnNewButton_3 = new JButton("조회");
                    btnNewButton_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchSuperiorFrm ssf=new SearchSuperiorFrm(new JFrame());
                                        ssf.setVisible(true);
                                        textField_sup.setText(addSearchSuperior());
                              }
                    });
                    btnNewButton_3.setBounds(189, 66, 70, 23);
                    panel_2.add(btnNewButton_3);
                    contentPane.setLayout(null);
                    contentPane.add(staff_typeLabel);
                    contentPane.add(lblNewLabel);
                    contentPane.add(teacherRadioButton);
                    contentPane.add(empRadioButton);
                    contentPane.add(textField_name);
                    contentPane.add(panel);
                    contentPane.add(label);
                    contentPane.add(label_4);
                    contentPane.add(label_3);
                    contentPane.add(label_2);
                    contentPane.add(label_1);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(btnNewButton);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(textField_tel2);
                    contentPane.add(textField_ename);
                    contentPane.add(textField_cardid_1);
                    contentPane.add(radioButton_male);
                    contentPane.add(radioButton_female);
                    contentPane.add(label_6);
                    contentPane.add(textField_cardid_2);
                    contentPane.add(textField_address1);
                    contentPane.add(textField_email1);
                    contentPane.add(btnNewButton_1);
                    
                    label_8 = new JLabel("    상세주소:");
                    label_8.setBounds(361, 224, 96, 15);
                    contentPane.add(label_8);
                    
                    textField_address2 = new JTextField();
                    textField_address2.setColumns(10);
                    textField_address2.setBounds(461, 221, 223, 21);
                    contentPane.add(textField_address2);
                    
                    textField_org = new JTextField();
                    textField_org.setEditable(false);
                    textField_org.setBounds(461, 151, 223, 21);
                    contentPane.add(textField_org);
                    textField_org.setColumns(10);
                    
                    btnNewButton_2 = new JButton("조회");
                    btnNewButton_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchOrgForProFrm sdf=new SearchOrgForProFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_org.setText(addSearch());
                              }
                    });
                    btnNewButton_2.setBounds(687, 150, 66, 23);
                    contentPane.add(btnNewButton_2);
                    
                    button = new JButton("조회");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchAddressFrm saf=new SearchAddressFrm(new JFrame());
                                        saf.setVisible(true);
                                        textField_address1.setText(addSearchAddress());
                              }
                    });
                    button.setBounds(687, 181, 66, 23);
                    contentPane.add(button);
                    
                    comboBox_tel1 = new JComboBox();
                    comboBox_tel1.setModel(new DefaultComboBoxModel(new String[] {"010", "02", "032", "062", "051", "053", "042", "052", "031", "033", "043", "041", "063", "061", "054", "055", "064"}));
                    comboBox_tel1.setBounds(114, 260, 68, 21);
                    contentPane.add(comboBox_tel1);
                    
                    textField_tel3 = new JTextField();
                    textField_tel3.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar = ke.getKeyChar();
                                        if (keyChar >= KeyEvent.VK_0
                                                            && keyChar <= KeyEvent.VK_9
                                                            || keyChar == KeyEvent.VK_BACK_SPACE
                                                            || keyChar == KeyEvent.VK_DELETE) {

                                        } else {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "숫자만 입력 가능합니다!");
                                                  ke.consume();
                                                  return;
                                        }
                                        int len = textField_tel3.getText()
                                                            .length();
                                        if (len > 3) {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "4짜리 초과하면 안 됩니다!");
                                                  ke.consume();
                                                  return;
                                        }
                              }
                    });
                    textField_tel3.setBounds(288, 260, 57, 21);
                    contentPane.add(textField_tel3);
                    textField_tel3.setColumns(10);
                    
                    lblNewLabel_2 = new JLabel("-");
                    lblNewLabel_2.setBounds(192, 263, 6, 15);
                    contentPane.add(lblNewLabel_2);
                    
                    label_9 = new JLabel("-");
                    label_9.setBounds(274, 263, 6, 15);
                    contentPane.add(label_9);
                    
                    label_ait = new JLabel("@");
                    label_ait.setFont(new Font("Dialog", Font.BOLD, 13));
                    label_ait.setBounds(560, 263, 13, 15);
                    contentPane.add(label_ait);
                    
                    comboBox_email2 = new JComboBox();
                    comboBox_email2.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "pukyong.ac.kr", "hanmail.com", "hanmail.net", "daum.net", "kornet.net", "korea.com", "hanafos.com", "yahoo.com.kr", "qq.com", "163.com"}));
                    comboBox_email2.setEditable(true);
                    comboBox_email2.setBounds(579, 260, 105, 21);
                    contentPane.add(comboBox_email2);
//                    setDeptName();
//                    setSuperior();
          }
          protected String addSearchSuperior() {
                    return SearchSuperiorFrm.getpName();
          }

          protected String addSearchAddress() {
                    return SearchAddressFrm.getSearchAddr();
          }

          protected String addSearch() {
                    return SearchOrgForProFrm.getDeptName();
          }

          //submit add pro action
		protected void addProSubmit(ActionEvent ae) throws Exception {
			String pno,name,ename,staffType,sex,personType,teacherType=null,supid=null;
			String cardid1,cardid2,cardid,orgId,orgName,address,address1,address2,email,email1,email2,ait,tel,tel1,tel2,tel3,date;
			name=textField_name.getText().toString();
			if(StringUtil.isEmpty(name)) {
		                 JOptionPane.showMessageDialog(this, "교직원이름을 입력해주세요!");
		                 return;
		             }
			ename=textField_ename.getText().toString();
			staffType=teacherRadioButton.isSelected() ? teacherRadioButton.getText():empRadioButton.getText();
			sex=radioButton_male.isSelected() ? radioButton_male.getText() : radioButton_female.getText();
			if(teacherRadioButton.isSelected()) {
				personType=radioButton_1.isSelected()? radioButton_1.getText(): 
				          (radioButton_2.isSelected()? radioButton_2.getText():
				          (radioButton_3.isSelected()? radioButton_3.getText():
				          (radioButton_4.isSelected()? radioButton_4.getText():radioButton_5.getText())));
//				if(radioButton_1.isSelected()) {
//					teacherType=comboBox_teacher.getSelectedItem().toString();
//				}else {
//					teacherType=null;
//				}
			}else {
				personType=comboBox_emptype.getSelectedItem().toString();
				try {
				       supid=SearchSuperiorFrm.getpNo();
				} catch (Exception e) {
					   supid=null;
				}
				
			}
			cardid1=textField_cardid_1.getText().toString();
			cardid2=textField_cardid_2.getText().toString();
			cardid=cardid1+"-"+cardid2;
			if(StringUtil.isEmpty(cardid1)||StringUtil.isEmpty(cardid2)) {
		                 JOptionPane.showMessageDialog(this, "주민등록번호를 입력해주세요!");
		                 return;
		             }
			
			//조직코드
			orgName = textField_org.getText().toString();
			orgId=SearchOrgForProFrm.getOrdId();
			if(StringUtil.isEmpty(orgId)||StringUtil.isEmpty(orgName)) {
                      JOptionPane.showMessageDialog(this, "소속조직을 선택해주세요!");
                      return;
                  }
			//주소
			address1=textField_address1.getText().toString();
			try {
			          address2 = textField_address2.getText().toString();
          } catch (Exception e) {
                    address2="";
          }
			address=address1+address2;
			if(StringUtil.isEmpty(address1)) {
		                 JOptionPane.showMessageDialog(this, "주소를 선택해주세요!");
		                 return;
		             }
			//이메일
			email1=textField_email1.getText().toString();
			ait = label_ait.getText().toString();
			email2 = comboBox_email2.getSelectedItem().toString();
			email=email1+ait+email2;
			if(StringUtil.isEmpty(email1)||StringUtil.isEmpty(email2)) {
		                 JOptionPane.showMessageDialog(this, "이메일을 입력해주세요!");
		                 return;
		             }
			//전화번
			tel1=comboBox_tel1.getSelectedItem().toString();
			tel2=textField_tel2.getText().toString();
			tel3=textField_tel3.getText().toString();
			tel=tel1+tel2+tel3;
			if(StringUtil.isEmpty(tel1)||StringUtil.isEmpty(tel2)) {
		                 JOptionPane.showMessageDialog(this, "전화번호를 입력해주세요!");
		                 return;
		             }
			//등록일자
			date=DateUtil.getTodayDate();
			//교직원번호
			 pno=getStudentNumber(date,orgId);
			 while(this.isRepeat(pno)){
			           pno=getStudentNumber(date,orgId);
			 }
			 
			 
			 ProStaff ps=new ProStaff();
			 ps.setpNo(pno);
			 ps.setpName(name);
			 ps.setPeName(ename);
			 ps.setProType(staffType);
			 ps.setPerType(personType);
			 ps.setTeaType(teacherType);
			 ps.setSex(sex);
			 ps.setIdCardNo(cardid);
			 ps.setOrgId(orgId);
			 ps.setAddress(address);
			 ps.setTel(tel);
			 ps.setEmail(email);
			 ps.setLoginDate(date);
			 ps.setPassword(cardid1);
			 ps.setSupId(supid);
			 ps.setOrgName(orgName);
			 ProStaffDao psDao=new ProStaffDao();
			 
			 if(psDao.addProStaff(ps)) {
			         //id,password 학생의 이메일에 보내기
                     new SendEmailToSP(pno,cardid1, email);
                     JOptionPane.showMessageDialog(this,
                                         "교직원이 등록 성공했습니다! ");
           } else {
                     JOptionPane.showMessageDialog(this,
                                         "교직원이 등록 실패했습니다！");
           }
			psDao.closeDao();	
			resetValue();
//			setSuperior();
		}
//		//직속상사 从数据库中把数据填充选择框
//        protected void setSuperior() {
//                  // TODO Auto-generated method stub
//                 ProStaffDao psDao=new ProStaffDao();
//                 ProStaff ps1=new ProStaff();
//                 ps1.setProType("교원");
//                 ProStaff ps2=new ProStaff();
//                 ps2.setProType("직원");
//                  List<ProStaff> proStaffList1 = psDao.getProStaffList(ps1);
//                  List<ProStaff> proStaffList2 = psDao.getProStaffList(ps2);
//                  String str=null;
////                  for (ProStaff psa : proStaffList1) {
////                	  comboBox_superior1.addItem(psa);
////				}
//                  for (ProStaff psb : proStaffList2) {
//                	  comboBox_superior2.addItem(psb);
//				}
//                  psDao.closeDao();
//        }
//		//学科 从数据库中把数据填充选择框
//        protected void setDeptName() {
//                  // TODO Auto-generated method stub
//                  OrgDao orgDao=new OrgDao();
//                  List<Org> orgList=orgDao.getOrgList(new Org());
//                  for (Org org: orgList) {
//                	  comboBox_org.addItem(org);
//                  }
//                  orgDao.closeDao();
//        }
		//등록하고 초기화
		public void resetValue() {
			textField_name.setText("");
			textField_ename.setText("");
			textField_address1.setText("");
			textField_address2.setText("");
			textField_cardid_1.setText("");
			textField_cardid_2.setText("");
			textField_email1.setText("");
			comboBox_email2.setSelectedIndex(0);
			textField_tel2.setText("");
			textField_tel3.setText("");
			bgroup1.clearSelection();
			bgroup2.clearSelection();
			bgroup3.clearSelection();
			radioButton_male.setSelected(true);
			radioButton_1.setSelected(true);
			teacherRadioButton.setSelected(true);
			textField_org.setText("");
			comboBox_emptype.setSelectedIndex(0);
			textField_sup.setText("");
		}
			//日期格式	
		 public String getStringDate(DatePicker datepick) {
             String stringDate;
             SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
             Date date;
             if(datepick.getValue()==null){
                       date=new Date();
             }else{
                       date = (Date) datepick.getValue();
             }
             stringDate = form.format(date);
             return stringDate;
		 }
		 // 获取教授id
         public String getStudentNumber(String str1,String string) {
                   String str = str1.substring(2, 4);
                   String str2;
                   str2=string.substring(3, 5);
                   String sNo = str + str2 + getRandom();
                   return sNo;
         }
         ///종복확인
         private boolean isRepeat(String str){
                   ProStaff ps=new ProStaff();
                   ProStaffDao psDao=new ProStaffDao();
                   List<ProStaff> psList = psDao.getProStaffList(new ProStaff());
                   List<String> psNoList = new ArrayList<String>();
                   for (ProStaff psNo2 : psList) {
                             String string1=psNo2.getpNo();
                             psNoList.add(string1);
                   }
                   if(!psNoList.contains(str)){
                             return false;
                   }else{
                             return true;
                   }
         }
         // 获取一个随机产生的三位数（001,001）
         public String getRandom() {
                   String threeNumber;
                   Random random = new Random();
                   int i = random.nextInt(1000);
                   String str = i + "";
                   if (i >= 0 && i <= 9) {
                             threeNumber = "00" + str;
                   } else if (i >= 10 && i <= 99) {
                             threeNumber = "0" + str;
                   } else {
                             threeNumber = str;
                   }
                   return threeNumber;
         }
}
