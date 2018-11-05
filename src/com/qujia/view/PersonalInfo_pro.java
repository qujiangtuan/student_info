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
import com.qujia.dao.ProStaffDao;
import com.qujia.model.Org;
import com.qujia.model.ProStaff;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class PersonalInfo_pro extends JFrame {

	private JPanel contentPane;
	private JLabel label_name,label_orgName,label_perType,label_proType,label_teaType,label_pno,label_ait;
	private JTextField textField_tel1,textField_address,textField_email1;
	private ProStaff ps,psTmp;
	private List<Org> orgList;
	private JButton button;
	private JButton btnNewButton;
	private JTextField textField_tel2;
	private JComboBox comboBox_tel,comboBox_email2;
	private String[] telArray;
	private String[] emailArray;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo_pro frame = new PersonalInfo_pro();
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
	public PersonalInfo_pro() {
	          this.setResizable(false);
		setTitle("\uAC1C\uC778\uC815\uBCF4");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 660, 362);
		
		ViewUtil vu=new ViewUtil();
        vu.showCenter(this);
        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uC131    \uBA85:");
		lblNewLabel.setBounds(59, 45, 62, 15);
		
		
		
		label_name = new JLabel("123");
		label_name.setBounds(131, 45, 130, 15);
		
		JLabel lblNewLabel_2 = new JLabel("\uC18C\uC18D\uBD80\uC11C:");
		lblNewLabel_2.setBounds(59, 81, 62, 15);
		
		label_orgName = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
		label_orgName.setBounds(131, 81, 122, 15);
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638:");
		lblNewLabel_4.setBounds(59, 126, 62, 15);
		
		JLabel lblNewLabel_5 = new JLabel("\uC774 \uBA54 \uC77C:");
		lblNewLabel_5.setBounds(307, 126, 62, 15);
		
		JLabel lblNewLabel_6 = new JLabel("\uC8FC    \uC18C:");
		lblNewLabel_6.setBounds(59, 173, 54, 15);
		
		JLabel lblNewLabel_7 = new JLabel("\uB2F4\uB2F9\uC9C1\uC704:");
		lblNewLabel_7.setBounds(307, 81, 62, 15);
		
		label_perType = new JLabel("\uC804\uC784\uAD50\uC218");
		label_perType.setBounds(387, 81, 75, 15);
		
		JButton submitButton = new JButton("수 정");
		submitButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    updateProInfoAction(e);
		          }
		});
		submitButton.setBounds(214, 238, 69, 23);
		
		JLabel lblNewLabel_9 = new JLabel("\uC544 \uC774 \uB514:");
		lblNewLabel_9.setBounds(307, 45, 62, 15);
		
		label_pno = new JLabel("1876114");
		label_pno.setBounds(387, 45, 162, 15);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_7);
		contentPane.add(lblNewLabel_5);
		contentPane.add(lblNewLabel_6);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		contentPane.add(label_name);
		contentPane.add(label_orgName);
		contentPane.add(label_perType);
		contentPane.add(lblNewLabel_9);
		contentPane.add(label_pno);
		contentPane.add(submitButton);
		
		label_proType = new JLabel("\uC9C1    \uC6D0");
		label_proType.setFont(new Font("Dialog", Font.BOLD, 13));
		label_proType.setBounds(276, 10, 89, 15);
		contentPane.add(label_proType);
		
		label_teaType = new JLabel("\uAC15\uC0AC");
		label_teaType.setBounds(472, 81, 95, 15);
		contentPane.add(label_teaType);
		
		
		
		textField_tel1 = new JTextField("01042421555");
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
		textField_tel1.setBounds(185, 122, 48, 23);
		contentPane.add(textField_tel1);
		
		textField_email1 = new JTextField("qujiangtuan@qq.com");
		textField_email1.setBounds(387, 122, 83, 23);
		contentPane.add(textField_email1);
		
		textField_address = new JTextField("New label");
		textField_address.setBounds(131, 169, 401, 23);
		contentPane.add(textField_address);
		
		button = new JButton("취 소");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    dispose();
		          }
		});
		button.setBounds(373, 238, 69, 23);
		contentPane.add(button);
		
		btnNewButton = new JButton("조회");
		btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    SearchAddressFrm saf=new SearchAddressFrm(new JFrame());
                            saf.setVisible(true);
                            textField_address.setText(addSearchAddress());
		          }
		});
		btnNewButton.setBounds(544, 169, 69, 23);
		contentPane.add(btnNewButton);
		
		comboBox_tel = new JComboBox();
		telArray=new String[] {"010","032", "062", "051", "053", "042", "052", "031", "033", "043", "041", "063", "061", "054", "055", "064"};
		comboBox_tel.setModel(new DefaultComboBoxModel(telArray));
		comboBox_tel.setBounds(133, 123, 48, 22);
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
		textField_tel2.setBounds(235, 122, 48, 23);
		contentPane.add(textField_tel2);
		
		label_ait = new JLabel("@");
		label_ait.setFont(new Font("Dialog", Font.BOLD, 12));
		label_ait.setBounds(472, 127, 12, 15);
		contentPane.add(label_ait);
		
		comboBox_email2 = new JComboBox();
		comboBox_email2.setEditable(true);
		emailArray=new String[] {"","naver.com", "gmail.com", "pukyong.ac.kr", 
		                    "hanmail.com", "hanmail.net", "daum.net", "kornet.net", "korea.com", 
		                    "hanafos.com", "yahoo.com.kr", "qq.com", "163.com"};
		comboBox_email2.setModel(new DefaultComboBoxModel(new String[] {"", "naver.com", "gmail.com", "pukyong.ac.kr", "hanmail.com", "hanmail.net", "daum.net", "kornet.net", "korea.com", "hanafos.com", "yahoo.com.kr", "qq.com", "163.com"}));
		comboBox_email2.setBounds(491, 123, 122, 21);
		contentPane.add(comboBox_email2);
		
		ps=(ProStaff) MainFrm.userObject;
		ProStaffDao psDao=new ProStaffDao();
		psTmp=psDao.login(ps);
		setInfor();
	}
	          
          protected void updateProInfoAction(ActionEvent e) {
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
                    String pno=psTmp.getpNo();
                    ProStaff ps=new ProStaff();
                    ps.setTel(tel);
                    ps.setEmail(email);
                    ps.setAddress(address);
                    ps.setpNo(pno);
                    ProStaffDao psDao=new ProStaffDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(psDao.updatePerInfro(ps)){
                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                              }
                    }
          }

          protected String addSearchAddress() {
                    return SearchAddressFrm.getSearchAddr();
          }

          private void setInfor() {
                    label_proType.setText(psTmp.getProType());
                    label_name.setText(psTmp.getpName());
                    label_pno.setText(psTmp.getpNo());
                    label_orgName.setText(this.getOrgNameById(psTmp.getOrgId()));
                    label_perType.setText(psTmp.getPerType());
                    if("교원".equals(psTmp.getProType())){
                              if(!StringUtil.isEmpty(psTmp.getTeaType())) {
                                        label_teaType.setText(psTmp.getTeaType());
                              }else{
                                        label_teaType.setText("");
                              }
                    }else{
                              label_teaType.setText("");
                    }
                    //전화
                    String telAll=psTmp.getTel();
                    for(int i=0;i<comboBox_tel.getItemCount();i++){
                              if(telAll.substring(0, 3).equals(telArray[i])){
                                        comboBox_tel.setSelectedIndex(i);
                              } 
                    }
                    textField_tel1.setText(telAll.substring(3, 7));
                    textField_tel2.setText(telAll.substring(7, 11));
                    //이메일
                    String emailAll=psTmp.getEmail();
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
                    textField_address.setText(psTmp.getAddress());
                    
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
