package com.qujia.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.AdminDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Admin;
import com.qujia.model.ProStaff;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;

public class EditPasswordFrm extends JInternalFrame {

          private JPanel contentPane;
          private JPasswordField oldPasswordTextField;
          private JPasswordField newPasswordTextField;
          private JPasswordField confirmPasswordTextField;
          private JLabel currentUserLabel;//修改密码时的当前用户
   
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
          
                    setTitle("비밀번호수정");
//                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 450, 300);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    setClosable(true);
                    setIconifiable(true);
                    JLabel oldPasswordLabel = new JLabel("옛  암호：");
                    oldPasswordLabel.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/password.png")));
                    oldPasswordLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel newPasswordLable = new JLabel("새  안호：");
                    newPasswordLable.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/editPassword.png")));
                    newPasswordLable.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    oldPasswordTextField = new JPasswordField();
                    oldPasswordTextField.setColumns(10);
                    
                    newPasswordTextField = new JPasswordField();
                    newPasswordTextField.setColumns(10);
                    
                    JLabel confirmPasswordLable = new JLabel("안호확인：");
                    confirmPasswordLable.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/editPassword.png")));
                    confirmPasswordLable.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    confirmPasswordTextField = new JPasswordField();
                    confirmPasswordTextField.setColumns(10);
                     
                    JButton submitButton = new JButton("수 정");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        submitEdit(ae);
                              }
                    });
                    submitButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    submitButton.setIcon(null);
                    
                    JButton resetButton = new JButton("최 소");
                    resetButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        dispose();
//                                        resetValue(ae);
                              }
                    });
                    resetButton.setIcon(null);
                    resetButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel currentUserLabel_1 = new JLabel("사 용 자：");
                    currentUserLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    currentUserLabel_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/studentManager.png")));
                    
                    currentUserLabel = new JLabel("김진수");
                    currentUserLabel.setEnabled(true);
                    currentUserLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(89)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(currentUserLabel_1)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                          .addComponent(newPasswordLable)
                                                                                          .addComponent(confirmPasswordLable)
                                                                                          .addComponent(oldPasswordLabel))
                                                                                .addGap(18)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                          .addComponent(confirmPasswordTextField)
                                                                                          .addComponent(newPasswordTextField)
                                                                                          .addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                                                          .addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                      .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                                                .addComponent(submitButton)
                                                                                .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(resetButton))))
                                                  .addContainerGap(103, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(currentUserLabel_1)
                                                            .addComponent(currentUserLabel))
                                                  .addGap(25)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(oldPasswordLabel))
                                                  .addGap(27)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(newPasswordLable))
                                                  .addGap(28)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(confirmPasswordLable))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(resetButton)
                                                            .addComponent(submitButton))
                                                  .addGap(27))
                    );
                    contentPane.setLayout(gl_contentPane);
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
                             JOptionPane.showMessageDialog(this, "옛 비밀번호 입력하시오!"); 
                             return; 
                    }
                    if(StringUtil.isEmpty(newPassword)){
                              JOptionPane.showMessageDialog(this, "새 비밀번호 입력하시오!"); 
                              return; 
                     }
                    if(StringUtil.isEmpty(confirmPassword )){
                              JOptionPane.showMessageDialog(this, "확인 비밀번호 입력하시오!"); 
                              return; 
                     }
                    if(!newPassword.equals(confirmPassword)){
                              JOptionPane.showMessageDialog(this, "두번 입력한 안호가 일치하지 않습니다!");
                              return;
                    }
                    if("관리자".equals(MainFrm.userType.getName())){
                              AdminDao adminDao=new AdminDao();
                              Admin adminTmp=new Admin();
                              Admin admin=(Admin)MainFrm.userObject;
                              System.out.println(admin);
                              adminTmp.setName(admin.getName());
                              adminTmp.setPassword(oldPassword);
                              
                              JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
                              adminDao.closeDao();
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
                    	    return;
                    }
                    
          }
          //修改密码重置按钮事件方法
          protected void resetValue(ActionEvent ae) { 
                    // TODO Auto-generated method stub
                    oldPasswordTextField.setText("");
                    newPasswordTextField.setText("");
                    confirmPasswordTextField.setText("");
          }
}
