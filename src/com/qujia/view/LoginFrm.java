package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.AdminDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Admin;
import com.qujia.model.ProStaff;
import com.qujia.model.Student;
import com.qujia.model.UserType;
import com.qujia.util.StringUtil;

public class LoginFrm extends JFrame {

          private JPanel contentPane;
          private JTextField userNameTextField;
          private JPasswordField passwordTextField;
          private JRadioButton studentRadioButton,proRadioButton,adminButton;
          private ButtonGroup bgroup;
          private JLabel lblNewLabel;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  LoginFrm frame = new LoginFrm();
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
          public LoginFrm() {
                    this.setResizable(false);
                    setFont(new Font("나눔명조", Font.BOLD, 14));
                    setIconImage(Toolkit.getDefaultToolkit()
                                        .getImage(LoginFrm.class
                                                            .getResource("/images/student1.png")));
                    setTitle("학사관리시스템");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 554, 436);
                    contentPane = new JPanel();
                    contentPane.setBackground(new Color(230, 230, 250));
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    setLocationRelativeTo(null);
                    JLabel label = new JLabel("학사관리시스템");
                    label.setBounds(161, 51, 169, 32);
                    label.setIcon(new ImageIcon(LoginFrm.class
                                        .getResource("/images/student2.png")));
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 18));

                    JLabel userNameLabel_1 = new JLabel(" 아 이 디：");
                    userNameLabel_1.setBounds(110, 139, 103, 19);
                    userNameLabel_1.setIcon(new ImageIcon(LoginFrm.class
                                        .getResource("/images/username.png")));
                    userNameLabel_1.setFont(new Font("NanumMyeongjo",
                                        Font.BOLD, 13));

                    userNameTextField = new JTextField();
                    userNameTextField.setBounds(243, 138, 155, 21);
                    userNameTextField.setColumns(10);

                    JLabel passwordLabel = new JLabel("비밀번호：");
                    passwordLabel.setBounds(110, 178, 105, 19);
                    passwordLabel.setIcon(new ImageIcon(LoginFrm.class
                                        .getResource("/images/password.png")));
                    passwordLabel.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    passwordTextField = new JPasswordField();
                    passwordTextField.setBounds(243, 177, 155, 21);
                    passwordTextField.setColumns(10);

                    JButton loginButton = new JButton("    로그인");
                    loginButton.setBounds(121, 267, 111, 29);
                    loginButton.setHorizontalAlignment(SwingConstants.LEFT);
                    loginButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        loginAction(ae);
                              }
                    });
                    loginButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 14));
                    loginButton.setIcon(null);

                    JButton resetButton = new JButton("비밀번호 찾기");
                    resetButton.setBounds(262, 267, 137, 29);
                    resetButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        FindPassword fp = new FindPassword();
                                        fp.setVisible(true);
                              }
                    });
                    resetButton.setIcon(null);
                    resetButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 14));
                    contentPane.setLayout(null);
                    contentPane.add(label);
                    contentPane.add(loginButton);
                    contentPane.add(passwordLabel);
                    contentPane.add(userNameLabel_1);
                    contentPane.add(passwordTextField);
                    contentPane.add(userNameTextField);
                    contentPane.add(resetButton);
                    
                    studentRadioButton = new JRadioButton(UserType.STUDENT.getName());
                    studentRadioButton.setOpaque(false);
                    studentRadioButton.setSelected(true);
                    studentRadioButton.setFont(new Font("Dialog", Font.BOLD, 13));
                    studentRadioButton.setBounds(144, 216, 57, 23);
                    contentPane.add(studentRadioButton);
                    
                    proRadioButton = new JRadioButton(UserType.TEACHER.getName());
                    proRadioButton.setOpaque(false);
                    proRadioButton.setFont(new Font("Dialog", Font.BOLD, 13));
                    proRadioButton.setBounds(222, 216, 83, 23);
                    contentPane.add(proRadioButton);
                    
                    adminButton = new JRadioButton(UserType.ADMIN.getName());
                    adminButton.setOpaque(false);
                    adminButton.setFont(new Font("Dialog", Font.BOLD, 13));
                    adminButton.setBounds(321, 216, 77, 23);
                    contentPane.add(adminButton);
                    bgroup=new ButtonGroup();
                    bgroup.add(studentRadioButton);
                    bgroup.add(proRadioButton);
                    bgroup.add(adminButton);
                    
                    lblNewLabel = new JLabel("");
                    lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login2.jpg")));
                    lblNewLabel.setBounds(0, 0, 548, 407);
                    contentPane.add(lblNewLabel);
          }

          protected void loginAction(ActionEvent ae) {
                    String userName = userNameTextField.getText().toString();
                    String password = passwordTextField.getText().toString();
                    UserType selectedItem;
                    String selectedName = studentRadioButton.isSelected() ? studentRadioButton.getText() : 
                              (proRadioButton.isSelected()? proRadioButton.getText():adminButton.getText());
                    if(studentRadioButton.isSelected()){
                              selectedItem=UserType.STUDENT;
                    }else if(proRadioButton.isSelected()){
                              selectedItem=UserType.TEACHER;
                    }else{
                              selectedItem=UserType.ADMIN;
                    }
                    if (StringUtil.isEmpty(userName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "사용자 아이디를 입력해주세요！");
                              return;
                    }
                    if (StringUtil.isEmpty(password)) {
                              JOptionPane.showMessageDialog(this,
                                                  "비밀번호를 입력해주세요！");
                              return;
                    }
                    Admin admin = null;
                    if ("관리자".equals(selectedName)) {
                              AdminDao adminDao = new AdminDao();
                              Admin adminTmp = new Admin();
                              adminTmp.setName(userName);
                              adminTmp.setPassword(password);
                              admin = adminDao.login(adminTmp);
                              adminDao.closeDao();
                              if (admin == null|| !(userName.equals(admin.getName()))) {
                                        JOptionPane.showMessageDialog(this,
                                                            "사용자 이름 또는 비밀번호가 잘못되었습니다！");
                                        return;
                              }
                              JOptionPane.showMessageDialog(this, "【"
                                                  + selectedItem.getName()
                                                  + "】：" + admin.getName()
                                                  + " , 환영합니다 !");
                              this.dispose();
                              new MainFrm(selectedItem, admin).setVisible(true);
                    } else if ("교직원".equals(selectedName)) {
                    			ProStaff ps=null;
                    			ProStaffDao psDao=new ProStaffDao();
                    			ProStaff psTmp=new ProStaff();
                    			psTmp.setpNo(userName);
                    			psTmp.setPassword(password);
                    			ps= psDao.login(psTmp);
                    			psDao.closeDao();
                    			if(ps==null||!(userName.equals(ps.getpNo()))) {
                        			JOptionPane.showMessageDialog(this, "사용자 이름 또는 비밀번호가 잘못되었습니다！");
                        			return;
                        		} 
                        		JOptionPane.showMessageDialog(this, "【"
                                        + selectedItem.getName()
                                        + "】：" + ps.getpName()
                                        + " , 환영합니다 !");
                        		this.dispose();
                        		new MainFrm(selectedItem, ps).setVisible(true);
                    			
                    } else {
                    		Student student=null;
                    		StudentDao sDao=new StudentDao();
                    		Student stemp=new Student();
                    		stemp.setsNo(userName);
                    		stemp.setPassword(password);
                    		student=sDao.login(stemp);
                    		sDao.closeDao();
                    		if(student==null||!(userName.equals(student.getsNo()))) {
                    			JOptionPane.showMessageDialog(this, "사용자 이름 또는 비밀번호가 잘못되었습니다！");
                    			return;
                    		} 
                    		JOptionPane.showMessageDialog(this, "【"
                                    + selectedItem.getName()
                                    + "】：" + student.getName()
                                    + " , 환영합니다 !");
                    		this.dispose();
                    		new MainFrm(selectedItem, student).setVisible(true);
                    		
                    }
          }
}
