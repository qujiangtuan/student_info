package com.qujia.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.qujia.dao.AdminDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Admin;
import com.qujia.model.ProStaff;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;

public class EditPasswordFrm extends JFrame {

          private JPanel contentPane;
          private JPasswordField oldPasswordTextField;
          private JPasswordField newPasswordTextField;
          private JPasswordField confirmPasswordTextField;
          private JLabel currentUserLabel;//修改密码时的当前用户
          private JLabel label_old;
          private JLabel label_1;
          private JLabel label_new2;
   
          /**
           * Launch the application.
           */
//          public static void main(String[] args) {
//                    EventQueue.invokeLater(new Runnable() {
//                              public void run() {
//                                        try {
//                                                  EditPasswordFrm frame = new EditPasswordFrm();
//                                                  frame.setVisible(true);
//                                        } catch (Exception e) {
//                                                  e.printStackTrace();
//                                        }
//                              }
//                    });
//          }

          /**
           * Create the frame.
           */
          public EditPasswordFrm( ) {
                    this.setResizable(false);
                    setTitle("비밀번호수정");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 450, 300);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
//                    setClosable(true);
//                    setIconifiable(true);
                    JLabel oldPasswordLabel = new JLabel("현재 비밀번호:");
                    oldPasswordLabel.setBounds(58, 60, 119, 19);
                    oldPasswordLabel.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/password.png")));
                    oldPasswordLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel newPasswordLable = new JLabel("새   비밀번호:");
                    newPasswordLable.setBounds(58, 108, 119, 19);
                    newPasswordLable.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/editPassword.png")));
                    newPasswordLable.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    oldPasswordTextField = new JPasswordField();
                    oldPasswordTextField.getDocument().addDocumentListener(new DocumentListener() {
                              @Override
                              public void removeUpdate(DocumentEvent e) {
                                        inputPassword(e);
                              }
                              @Override
                              public void insertUpdate(DocumentEvent e) {
                                        inputPassword(e);
                              }
                              @Override
                              public void changedUpdate(DocumentEvent e) {
                                        inputPassword(e);
                              }
                              public void inputPassword(DocumentEvent e){
                                        String oldPwInput = null;
                                        String oldPassword;
                                        try {
                                                  oldPwInput = e.getDocument().getText(e.getDocument().getStartPosition().getOffset(), e.getDocument().getLength());
                                                  if("관리자".equals(MainFrm.userType.getName())){
                                                          AdminDao adminDao=new AdminDao();
                                                          Admin adminTmp=new Admin();
                                                          Admin admin=(Admin)MainFrm.userObject;
                                                          adminTmp=adminDao.searchOldPassword(admin);
                                                          oldPassword=adminTmp.getPassword();
                                                          if(oldPassword.equals(oldPwInput)){
                                                                    label_old.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/true.png")));
                                                          }else{
                                                                    label_old.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/false.png")));
                                                          }
                                                          adminDao.closeDao();
                                                          return;
                                                }else if("학생".equals(MainFrm.userType.getName())) {
                                                        StudentDao sDao=new StudentDao();
                                                        Student sTmp=new Student();
                                                        Student student=(Student) MainFrm.userObject;
                                                        sTmp = sDao.searchOldPassword(student);
                                                        oldPassword=sTmp.getPassword();
                                                        if(oldPassword.equals(oldPwInput)){
                                                                  label_old.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/true.png")));
                                                        }else{
                                                                  label_old.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/false.png")));
                                                        }
                                                        sDao.closeDao();
                                                        return;
                                                }else {
                                                        ProStaffDao psDao=new ProStaffDao();
                                                        ProStaff psTmp=new ProStaff();
                                                        ProStaff ps = (ProStaff) MainFrm.userObject;
                                                        psTmp = psDao.searchOldPassword(ps);
                                                        oldPassword=psTmp.getPassword();
                                                        if(oldPassword.equals(oldPwInput)){
                                                                  label_old.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/true.png")));
                                                        }else{
                                                                  label_old.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/false.png")));
                                                        }
                                                        psDao.closeDao();
                                                        return;
                                                }
                                        } catch (Exception e2) {
                                        }
                              }
                    });

                    oldPasswordTextField.setBounds(201, 59, 124, 21);
                    oldPasswordTextField.setColumns(10);
                    
                    newPasswordTextField = new JPasswordField();
                    newPasswordTextField.setBounds(201, 107, 124, 21);
                    newPasswordTextField.setColumns(10);
                    
                    JLabel confirmPasswordLable = new JLabel("비밀번호확인:");
                    confirmPasswordLable.setBounds(58, 157, 125, 19);
                    confirmPasswordLable.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/editPassword.png")));
                    confirmPasswordLable.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    confirmPasswordTextField = new JPasswordField();
                    confirmPasswordTextField.getDocument().addDocumentListener(new DocumentListener() {
                              @Override
                              public void removeUpdate(DocumentEvent e) {
                                        sure();
                              }
                              @Override
                              public void insertUpdate(DocumentEvent e) {
                                        sure();
                              }
                              @Override
                              public void changedUpdate(DocumentEvent e) {
                                        sure();
                              }
                              private void sure() {
                                        String pwInput1=newPasswordTextField.getText().toString();
                                        String pwInput2 = confirmPasswordTextField.getText().toString();
                                        if(pwInput1.equals(pwInput2)){
                                                  label_new2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/true.png")));
                                        }else{
                                                  label_new2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/false.png")));
                                        }
                              }
                    });
                    confirmPasswordTextField.setBounds(201, 156, 124, 21);
                    confirmPasswordTextField.setColumns(10);
                     
                    JButton submitButton = new JButton("수 정");
                    submitButton.setBounds(83, 211, 76, 27);
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        submitEdit(ae);
                              }
                    });
                    submitButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    submitButton.setIcon(null);
                    
                    JButton resetButton = new JButton("최 소");
                    resetButton.setBounds(249, 211, 76, 27);
                    resetButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        dispose();
//                                        resetValue(ae);
                              }
                    });
                    resetButton.setIcon(null);
                    resetButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel currentUserLabel_1 = new JLabel("사 용 자:");
                    currentUserLabel_1.setBounds(58, 15, 119, 19);
                    currentUserLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    currentUserLabel_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/studentManager.png")));
                    
                    currentUserLabel = new JLabel("김진수");
                    currentUserLabel.setBounds(201, 15, 124, 19);
                    currentUserLabel.setEnabled(true);
                    currentUserLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    contentPane.setLayout(null);
                    contentPane.add(currentUserLabel_1);
                    contentPane.add(newPasswordLable);
                    contentPane.add(confirmPasswordLable);
                    contentPane.add(oldPasswordLabel);
                    contentPane.add(confirmPasswordTextField);
                    contentPane.add(newPasswordTextField);
                    contentPane.add(oldPasswordTextField);
                    contentPane.add(currentUserLabel);
                    contentPane.add(submitButton);
                    contentPane.add(resetButton);
                    
                    label_old = new JLabel("");
//                    label_old.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/true.png")));
                    label_old.setBounds(336, 60, 21, 17);
                    contentPane.add(label_old);
                    
                    label_1 = new JLabel("");
                    label_1.setBounds(336, 110, 21, 17);
                    contentPane.add(label_1);
                    
                    label_new2 = new JLabel("");
//                    label_new2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/true.png")));
                    label_new2.setBounds(337, 159, 21, 17);
                    contentPane.add(label_new2);
                    //当前用户设定
                    if("관리자".equals(MainFrm.userType.getName())){
                              Admin admin =(Admin)MainFrm.userObject;
                              currentUserLabel.setText("【관리자】 "+admin.getName());
                    }else if("학생".equals(MainFrm.userType.getName())) {
                    	Student student =(Student) MainFrm.userObject;
                    	currentUserLabel.setText("【학생】 "+student.getName());
                    }else {
                    	ProStaff ps=(ProStaff) MainFrm.userObject;
                    	currentUserLabel.setText("【교직원】 "+ps.getpName());
                    }
          }
          //密码提交修改
          protected void submitEdit(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    String oldPassword=oldPasswordTextField.getText().toString();
                    String newPassword=newPasswordTextField.getText().toString();
                    String confirmPassword=confirmPasswordTextField.getText().toString();
                    if(StringUtil.isEmpty(oldPassword)){
                             JOptionPane.showMessageDialog(this, "현재 비밀번호를 입력하시오!"); 
                             return; 
                    }
                    if(StringUtil.isEmpty(newPassword)){
                              JOptionPane.showMessageDialog(this, "새로운 비밀번호를 입력하시오!"); 
                              return; 
                     }
                    if(StringUtil.isEmpty(confirmPassword )){
                              JOptionPane.showMessageDialog(this, "새로운 비밀번호를 확인하시오!"); 
                              return; 
                     }
                    if(!newPassword.equals(confirmPassword)){
                              JOptionPane.showMessageDialog(this, "입력한 새로운 비밀번호가 같지 않습니다!");
                              return;
                    }
                    if("관리자".equals(MainFrm.userType.getName())){
                              AdminDao adminDao=new AdminDao();
                              Admin adminTmp=new Admin();
                              Admin admin=(Admin)MainFrm.userObject;
                              adminTmp.setName(admin.getName());
                              adminTmp.setPassword(oldPassword);
                              JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
                              adminDao.closeDao();
                              resetValue();
                              return;
                    }else if("학생".equals(MainFrm.userType.getName())) {
                    		StudentDao sDao=new StudentDao();
                    		Student sTmp=new Student();
                    		Student student=(Student) MainFrm.userObject;
                    		sTmp.setName(student.getName());
                    		sTmp.setPassword(student.getPassword());
                    		sTmp.setsNo(student.getsNo());
                    		JOptionPane.showMessageDialog(this, sDao.editPassword(sTmp,newPassword));
                    	    sDao.closeDao();
                    	    resetValue();
                    	    return;
                    }else {
                    		ProStaffDao psDao=new ProStaffDao();
                    		ProStaff psTmp=new ProStaff();
                    	    ProStaff ps = (ProStaff) MainFrm.userObject;
                    	    psTmp.setpNo(ps.getpNo());
                    	    psTmp.setpName(ps.getpName());
                    	    psTmp.setPassword(ps.getPassword());
                    	    JOptionPane.showMessageDialog(this, psDao.editPassword(psTmp,newPassword));
                    	    psDao.closeDao();
                    	    resetValue();
                    	    return;
                    }
                    
          }
          //修改密码重置按钮事件方法
          protected void resetValue() { 
                    // TODO Auto-generated method stub
                    oldPasswordTextField.setText("");
                    newPasswordTextField.setText("");
                    confirmPasswordTextField.setText("");
                    label_old.setIcon(null);
                    label_new2.setIcon(null);
          }
}
