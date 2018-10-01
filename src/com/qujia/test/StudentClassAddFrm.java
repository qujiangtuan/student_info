package com.qujia.test;

import java.awt.EventQueue;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.qujia.dao.ClassDao;
import com.qujia.model.StudentClass;
import com.qujia.util.StringUtil;
import javax.swing.SpringLayout;

public class StudentClassAddFrm extends JInternalFrame {
          private JTextField classNameTextField;
          private JTextArea classInfoTextArea;

          /**
           * Launch the application.
           */
//          public static void main(String[] args) {
//                    EventQueue.invokeLater(new Runnable() {
//                              public void run() {
//                                        try {
//                                                  StudentClassAddFrm frame = new StudentClassAddFrm();
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
          public StudentClassAddFrm() {
                    setTitle("분반정보추가");
                    setBounds(100, 100, 450, 300);
                    setClosable(true);
                    setIconifiable(true);
                    JLabel classNameLabel = new JLabel("분반이름：");
                    classNameLabel.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/className.png")));
                    classNameLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel classInfoLabel = new JLabel("분반정보：");
                    classInfoLabel.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/classinfo.png")));
                    classInfoLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    classNameTextField = new JTextField();
                    classNameTextField.setColumns(10);
                    
                    
                    classInfoTextArea= new JTextArea();
                    classInfoTextArea.setLineWrap(true);//激活自动换行功能 
                    classInfoTextArea.setWrapStyleWord(true);//激活断行不断字功能
                    JButton submitButton = new JButton("추가");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        submitClass(ae);
                              }
                    });
                    submitButton.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/add.png")));
                    submitButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton resetButton = new JButton("초기화");
                    resetButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        resetValue(ae);
                              }
                    });
                    resetButton.setIcon(new ImageIcon(StudentClassAddFrm.class.getResource("/images/reset.png")));
                    resetButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    SpringLayout springLayout = new SpringLayout();
                    springLayout.putConstraint(SpringLayout.NORTH, classNameTextField, 37, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, classNameTextField, 177, SpringLayout.WEST, getContentPane());
                    springLayout.putConstraint(SpringLayout.SOUTH, classNameTextField, 72, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.EAST, classNameTextField, 319, SpringLayout.WEST, getContentPane());
                    springLayout.putConstraint(SpringLayout.NORTH, classNameLabel, 46, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, classNameLabel, 88, SpringLayout.WEST, getContentPane());
                    springLayout.putConstraint(SpringLayout.NORTH, classInfoTextArea, 104, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, classInfoTextArea, 177, SpringLayout.WEST, getContentPane());
                    springLayout.putConstraint(SpringLayout.SOUTH, classInfoTextArea, 193, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.NORTH, classInfoLabel, 104, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, classInfoLabel, 88, SpringLayout.WEST, getContentPane());
                    springLayout.putConstraint(SpringLayout.NORTH, resetButton, 217, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, resetButton, 233, SpringLayout.WEST, getContentPane());
                    springLayout.putConstraint(SpringLayout.NORTH, submitButton, 219, SpringLayout.NORTH, getContentPane());
                    springLayout.putConstraint(SpringLayout.WEST, submitButton, 119, SpringLayout.WEST, getContentPane());
                    getContentPane().setLayout(springLayout);
                    getContentPane().add(submitButton);
                    getContentPane().add(resetButton);
                    getContentPane().add(classInfoLabel);
                    getContentPane().add(classInfoTextArea);
                    getContentPane().add(classNameLabel);
                    getContentPane().add(classNameTextField);

          }
          //提交添加课程
          protected void submitClass(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    String className=classNameTextField.getText().toString();
                    String classInfo=classInfoTextArea.getText().toString();
                    if(StringUtil.isEmpty(className)){
                              JOptionPane.showMessageDialog(this, "분반 이름은 비워 둘 수 없습니다 ！");
                    }
                    StudentClass scl=new StudentClass();
                    scl.setName(className);
                    scl.setInfo(classInfo);
                    ClassDao classDao =new ClassDao();
                    if(classDao.addClass(scl)){
                              JOptionPane.showMessageDialog(this, "분반이 성공적으로 추가되었습니다 ！");
                    }else{
                              JOptionPane.showMessageDialog(this, "분반이 추가에 실패했습니다 ！");
                    }
                    classDao.closeDao();
                    resetValue(ae);
          }

          //添加班级重置事件
          protected void resetValue(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    classNameTextField.setText("");
                    classInfoTextArea.setText("");
          }
}
