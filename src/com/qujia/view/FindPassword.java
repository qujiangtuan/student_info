package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.ProStaffDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.ProStaff;
import com.qujia.model.SendEMail;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class FindPassword extends JFrame {

          private JPanel contentPane;
          private JTextField textField_id;
          private JTextField textField_email;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  FindPassword frame = new FindPassword();
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
          public FindPassword() {
                    setTitle("\uBE44\uBC00\uBC88\uD638\uCC3E\uAE30");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100,100,354, 243);
                   
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uC544\uC774\uB514:");
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_id = new JTextField();
                    textField_id.setColumns(10);
                    
                    JLabel label_1 = new JLabel("\uC774\uBA54\uC77C:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_email = new JTextField();
                    textField_email.setColumns(10);
                    
                    JButton button = new JButton("\uD655 \uC778");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        try {
                                                  findPasswordAction(e);
                                        } catch (Exception e1) {
                                                  // TODO Auto-generated catch block
                                                  e1.printStackTrace();
                                        }
                              }
                    });
                    button.setBackground(new Color(240, 248, 255));
                    
                    JButton button_1 = new JButton("\uCDE8 \uC18C");
                    button_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    button_1.setBackground(new Color(240, 248, 255));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(52)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(button)
                                                                      .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                      .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(label)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_id, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(label_1)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_email)))
                                                  .addContainerGap(57, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(39)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label)
                                                            .addComponent(textField_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_1)
                                                            .addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(button)
                                                            .addComponent(button_1))
                                                  .addGap(34))
                    );
                    contentPane.setLayout(gl_contentPane);
          }

          protected void findPasswordAction(ActionEvent e) throws Exception {
                    String id = textField_id.getText().toString();
                    String email = textField_email.getText().toString();
                    String random=StringUtil.getRandom3()+StringUtil.getRandom4();
                    if(StringUtil.isEmpty(id)){
                              JOptionPane.showMessageDialog(this, "아이디를 입력해주세요!");
                              return;
                    }
                    if(StringUtil.isEmpty(email)){
                              JOptionPane.showMessageDialog(this, "이메일을 입력해주세요!");
                              return;
                    }
                    int len=id.length();
                    if(len==9){//학생
                              Student stu=new Student();
                              stu.setsNo(id);
                              stu.setEmail(email);
                              StudentDao stuDao=new StudentDao();
                              if(stuDao.isStudent(stu)&&stuDao.updatePassword(stu,random)){
                                        new SendEMail(random, email);
                                        JOptionPane.showMessageDialog(this, "새 비밀번호를 이메일로 보냈습니다.");
                              }else{
                                        JOptionPane.showMessageDialog(this, "아이디나 이메일을 잘못 입력했습니다.");
                              }
                    }else if(len==7){//교직원
                              ProStaff ps=new ProStaff();
                              ps.setpNo(id);
                              ps.setEmail(email);
                              ProStaffDao psDao=new ProStaffDao();
                              if(psDao.isProStaff(ps)&&psDao.updatePassword(ps,random)){
                                        new SendEMail(random, email);
                                        JOptionPane.showMessageDialog(this, "새 비밀번호를 이메일로 보냈습니다.");
                              }else{
                                        JOptionPane.showMessageDialog(this, "아이디나 이메일을 잘못 입력했습니다.");
                              }
                    }else{
                              JOptionPane.showMessageDialog(this, "아이디를 잘못 입력했습니다.");
                    }
                    resetValue();
          }

          private void resetValue() {
                    textField_id.setText("");
                    textField_email.setText("");
          }


}
