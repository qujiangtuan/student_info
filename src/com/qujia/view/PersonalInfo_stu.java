package com.qujia.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class PersonalInfo_stu extends JFrame {

	private JPanel contentPane;
	private JLabel label_name,label_sno,label_dept,label_appendMajor;
	private JLabel label_degree,label_schYear,label_app;
	private JTextField textField_tel1,textField_email1,textField_address;
	private List<Org> orgList;
	private Student student,stuTemp;
	private JButton button;
	private JButton button_1;
	private JComboBox comboBox_tel;
	private JTextField textField_tel2;
	private JLabel label_ait;
	private JComboBox comboBox_email2;
	private String[] telArray;
	private String[] emailArray;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo_stu frame = new PersonalInfo_stu();
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
	public PersonalInfo_stu() {
	          this.setResizable(false);
		setTitle("\uAC1C\uC778\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 647, 371);
		
		ViewUtil vu=new ViewUtil();
        vu.showCenter(this);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC131    \uBA85:");
		lblNewLabel.setBounds(48, 45, 65, 15);
		
		label_name = new JLabel("123");
		label_name.setBounds(131, 45, 130, 15);
		
		JLabel lblNewLabel_2 = new JLabel("\uD559\uBD80(\uACFC):");
		lblNewLabel_2.setBounds(48, 78, 65, 15);
		
		label_dept = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
		label_dept.setBounds(131, 78, 130, 15);
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638:");
		lblNewLabel_4.setBounds(48, 151, 65, 15);
		
		JLabel lblNewLabel_5 = new JLabel("\uC774 \uBA54 \uC77C:");
		lblNewLabel_5.setBounds(329, 151, 65, 15);
		
		JLabel lblNewLabel_6 = new JLabel("\uC8FC    \uC18C:");
		lblNewLabel_6.setBounds(48, 194, 65, 15);
		
		label_app = new JLabel("\uCD94\uAC00\uC804\uACF5:");
		label_app.setBounds(48, 111, 65, 15);
		
		label_appendMajor = new JLabel("\uC5C6\uC74C");
		label_appendMajor.setBounds(131, 111, 130, 15);
		
		JButton submitButton = new JButton("최 소");
		submitButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		submitButton.setBounds(332, 252, 84, 23);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(label_app);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		contentPane.add(label_appendMajor);
		contentPane.add(label_name);
		contentPane.add(label_dept);
		contentPane.add(submitButton);
		
		JLabel lblNewLabel_9 = new JLabel("\uD559    \uBC88:");
		lblNewLabel_9.setBounds(330, 45, 65, 15);
		contentPane.add(lblNewLabel_9);
		
		label_sno = new JLabel("201518047");
		label_sno.setBounds(405, 45, 84, 15);
		contentPane.add(label_sno);
		
		JLabel lblNewLabel_11 = new JLabel("\uD559\uC704\uACFC\uC815:");
		lblNewLabel_11.setBounds(330, 78, 65, 15);
		contentPane.add(lblNewLabel_11);
		
		
		label_degree = new JLabel("\uD559\uC0AC\uACFC\uC815");
		label_degree.setBounds(405, 78, 84, 15);
		contentPane.add(label_degree);
		
		JLabel lblNewLabel_13 = new JLabel("\uD559    \uB144:");
		lblNewLabel_13.setBounds(330, 111, 65, 15);
		contentPane.add(lblNewLabel_13);
		
		label_schYear = new JLabel("1");
		label_schYear.setBounds(405, 111, 84, 15);
		contentPane.add(label_schYear);
		
		textField_tel1 = new JTextField("01040421777");
		textField_tel1.addKeyListener(new KeyAdapter() {
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
                            int len = textField_tel1.getText()
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
		textField_tel1.setBounds(177, 147, 60, 23);
		contentPane.add(textField_tel1);
		
		textField_email1 = new JTextField("qujiangtuan@qq.com");
		textField_email1.setBounds(405, 147, 84, 23);
		contentPane.add(textField_email1);
		
		textField_address = new JTextField("\uBD80\uACBD");
		textField_address.setBounds(131, 190, 414, 23);
		contentPane.add(textField_address);
		
		button = new JButton("수 정");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    updateStuInfoAction(e);
		          }
		});
		button.setBounds(193, 252, 84, 23);
		contentPane.add(button);
		
		button_1 = new JButton("조회");
		button_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    SearchAddressFrm saf=new SearchAddressFrm(new JFrame());
                            saf.setVisible(true);
                            textField_address.setText(addSearchAddress());
		          }
		});
		button_1.setBounds(557, 190, 72, 23);
		contentPane.add(button_1);
		
		comboBox_tel = new JComboBox();
		telArray=new String[] {"010", "032", "062", "051", "053", "042", "052", "031", "033", "043", "041", "063", "061", "054", "055", "064"};
		comboBox_tel.setModel(new DefaultComboBoxModel(telArray));
		comboBox_tel.setBounds(125, 148, 50, 21);
		contentPane.add(comboBox_tel);
		
		textField_tel2 = new JTextField((String) null);
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
                                      ke.consume();
                                      return;
                            }
                            int len = textField_tel2.getText()
                                                .length();
                            if (len > 3) {
                                      ke.consume();
                                      JOptionPane.showMessageDialog(
                                                          null,
                                                          "4자리 초과하면 안됩니다!");
                                      ke.consume();
                                      return;
                            }
		          }
		});
		textField_tel2.setBounds(239, 147, 60, 24);
		contentPane.add(textField_tel2);
		
		label_ait = new JLabel("@");
		label_ait.setFont(new Font("Dialog", Font.BOLD, 13));
		label_ait.setBounds(492, 151, 13, 15);
		contentPane.add(label_ait);
		
		comboBox_email2 = new JComboBox();
		emailArray=new String[] {"", "naver.com", "gmail.com", "pukyong.ac.kr", "hanmail.com", 
		                    "hanmail.net", "daum.net", "kornet.net", "korea.com", "hanafos.com", "yahoo.com.kr", 
		                    "qq.com", "163.com"};
		comboBox_email2.setModel(new DefaultComboBoxModel(emailArray));
		comboBox_email2.setBounds(511, 148, 118, 21);
		contentPane.add(comboBox_email2);
		
		student =(Student) MainFrm.userObject;
		StudentDao stuDao=new StudentDao();
		stuTemp=stuDao.login(student);
		setInfor();
	}
	
          protected String addSearchAddress() {
                    return SearchAddressFrm.getSearchAddr();
          }

          protected void updateStuInfoAction(ActionEvent e) {
                  //전화번호
                    String tel1 = comboBox_tel.getSelectedItem().toString();
                    String tel2= textField_tel1.getText().toString();
                    String tel3 = textField_tel1.getText().toString();
                    String tel=tel1+tel2+tel3;
                    //이메일
                    String email1 = textField_email1.getText().toString();
                    String email2= label_ait.getText().toString();
                    String email3 = comboBox_email2.getSelectedItem().toString();
                    String email=email1+email2+email3;
                    //주소
                    String address = textField_address.getText().toString();
                    String sno=stuTemp.getsNo();
                    Student stu=new Student();
                    stu.setTel(tel);
                    stu.setEmail(email);
                    stu.setAdress(address);
                    stu.setsNo(sno);
                    StudentDao stuDao=new StudentDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(stuDao.updateStuInfro(stu)){
                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                              }
                    }
          }

          private void setInfor() {
                    label_name.setText(stuTemp.getName());
                    label_sno.setText(stuTemp.getsNo());
                    label_dept.setText(this.getOrgNameById(stuTemp.getOrgId()));
                    label_degree.setText(stuTemp.getDegreeProcess());
                    label_app.setText(this.getApptype());
                    label_appendMajor.setText(this.getAppendMajor());
                    label_schYear.setText(stuTemp.getInSchYear());
                  //전화
                    String telAll=stuTemp.getTel();
                    for(int i=0;i<comboBox_tel.getItemCount();i++){
                              if(telAll.substring(0, 3).equals(telArray[i])){
                                        comboBox_tel.setSelectedIndex(i);
                              } 
                    }
                    textField_tel1.setText(telAll.substring(3, 7));
                    textField_tel2.setText(telAll.substring(7, 11));
                    //이메일
                    String emailAll=stuTemp.getEmail();
                    int index=emailAll.indexOf("@");
                    textField_email1.setText(emailAll.substring(0, index));
                    String emailEnd=emailAll.substring(index+1);
                    try {
                              for(int i=0;i<comboBox_email2.getItemCount();i++){
                                        if(emailEnd.equals(emailArray[i])){
                                                  comboBox_email2.setSelectedIndex(i);
                                        } 
                              }
                    } catch (Exception e) {
                              comboBox_email2.setSelectedItem(emailEnd);
                    }
                    
                    //주소
                    textField_address.setText(stuTemp.getAdress());
                    
//                    textField_tel1.setText(stuTemp.getTel());
//                    textField_email1.setText(stuTemp.getEmail());
//                    textField_address.setText(stuTemp.getAdress());
                    
          }
          private String getApptype() {
                    if(StringUtil.isEmpty(stuTemp.getMajorType())){
                              return "추가전공:";
                    }else{
                              if("부전공".equals(stuTemp.getMajorType())){
                                        return "부 전  공:";
                              }else{
                                        return "복수전공:";
                              }
                    }
          }

        private String getAppendMajor() {
                   if(StringUtil.isEmpty(stuTemp.getMajor())){
                             return "없음";
                   }else{
                             return stuTemp.getMajor();
                   }
          }

        //orgid에 통해서 orgName를 받는다
          public String getOrgNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
}
