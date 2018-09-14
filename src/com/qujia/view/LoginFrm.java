package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.AdminDao;
import com.qujia.model.Admin;
import com.qujia.model.UserType;
import com.qujia.util.StringUtil;

public class LoginFrm extends JFrame {

          private JPanel contentPane;
          private JTextField userNameTextField;
          private JPasswordField passwordTextField;
          private JComboBox userTypeComboBox;

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
                    setFont(new Font("나눔명조", Font.BOLD, 14));
                    setIconImage(Toolkit.getDefaultToolkit()
                                        .getImage(LoginFrm.class
                                                            .getResource("/images/student1.png")));
                    setTitle("학사관리시스템");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 554, 368);
                    contentPane = new JPanel();
                    contentPane.setBackground(new Color(230, 230, 250));
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    setLocationRelativeTo(null);
                    JLabel label = new JLabel("학사관리시스템");
                    label.setIcon(new ImageIcon(LoginFrm.class
                                        .getResource("/images/student2.png")));
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 18));

                    JLabel userNameLabel_1 = new JLabel(" 아 이 디：");
                    userNameLabel_1.setIcon(new ImageIcon(LoginFrm.class
                                        .getResource("/images/username.png")));
                    userNameLabel_1.setFont(new Font("NanumMyeongjo",
                                        Font.BOLD, 13));

                    userNameTextField = new JTextField();
                    userNameTextField.setColumns(10);

                    JLabel passwordLabel = new JLabel("비밀번호：");
                    passwordLabel.setIcon(new ImageIcon(LoginFrm.class
                                        .getResource("/images/password.png")));
                    passwordLabel.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    passwordTextField = new JPasswordField();
                    passwordTextField.setColumns(10);

                    JLabel userTypeLabel = new JLabel(" 역     할 ：");
                    userTypeLabel.setIcon(new ImageIcon(LoginFrm.class
                                        .getResource("/images/userType.png")));
                    userTypeLabel.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    userTypeComboBox = new JComboBox();
                    userTypeComboBox.setModel(new DefaultComboBoxModel(
                                        new UserType[] { UserType.STUDENT,
                                                            UserType.TEACHER,
                                                            UserType.ADMIN }));
                    userTypeComboBox.setFont(new Font("NanumMyeongjo",
                                        Font.BOLD, 13));

                    JButton loginButton = new JButton("    로그인");
                    loginButton.setHorizontalAlignment(SwingConstants.LEFT);
                    loginButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        loginAction(ae);
                              }
                    });
                    loginButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 14));
                    loginButton.setIcon(null);

                    JButton resetButton = new JButton("비밀번호 찾기");
                    resetButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        FindPassword fp = new FindPassword();
                                        fp.setVisible(true);
                              }
                    });
                    resetButton.setIcon(null);
                    resetButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 14));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane
                                                            .createSequentialGroup()
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addGap(156)
                                                                                                    .addComponent(label))
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addContainerGap(121,
                                                                                                                        Short.MAX_VALUE)
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addComponent(loginButton,
                                                                                                                                            GroupLayout.PREFERRED_SIZE,
                                                                                                                                            111,
                                                                                                                                            GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addComponent(userTypeLabel)
                                                                                                                        .addComponent(passwordLabel)
                                                                                                                        .addComponent(userNameLabel_1))
                                                                                                    .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.TRAILING)
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createParallelGroup(
                                                                                                                                                                Alignment.LEADING)
                                                                                                                                            .addGroup(gl_contentPane
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.TRAILING,
                                                                                                                                                                                    false)
                                                                                                                                                                .addComponent(passwordTextField)
                                                                                                                                                                .addComponent(userNameTextField,
                                                                                                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                    155,
                                                                                                                                                                                    Short.MAX_VALUE))
                                                                                                                                            .addComponent(userTypeComboBox,
                                                                                                                                                                0,
                                                                                                                                                                155,
                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                                                            .addComponent(resetButton)))))
                                                            .addGap(135)));
                    gl_contentPane.setVerticalGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane
                                                            .createSequentialGroup()
                                                            .addGap(46)
                                                            .addComponent(label)
                                                            .addGap(55)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(userNameTextField,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(userNameLabel_1))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(passwordTextField,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(passwordLabel))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(userTypeLabel)
                                                                                .addComponent(userTypeComboBox,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(ComponentPlacement.RELATED,
                                                                                27,
                                                                                Short.MAX_VALUE)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(resetButton,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    29,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(loginButton,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    29,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addGap(31)));
                    contentPane.setLayout(gl_contentPane);
          }

          protected void loginAction(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    String userName = userNameTextField.getText().toString();
                    String password = passwordTextField.getText().toString();
                    UserType selectedItem = (UserType) userTypeComboBox
                                        .getSelectedItem();
                    // 判断用户输入的字符串是否为空
                    if (StringUtil.isEmpty(userName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "사용자 이름은 비워 둘 수 없습니다！");
                              return;
                    }
                    if (StringUtil.isEmpty(password)) {
                              JOptionPane.showMessageDialog(this,
                                                  "비밀번호는 비워 둘 수 없습니다.！");
                              return;
                    }
                    Admin admin = null;
                    if ("관리자".equals(selectedItem.getName())) {
                              // 系统管理员登陆
                              AdminDao adminDao = new AdminDao();
                              Admin adminTmp = new Admin();
                              adminTmp.setName(userName);
                              adminTmp.setPassword(password);
                              admin = adminDao.login(adminTmp);
                              adminDao.closeDao();
                              if (admin == null) {
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
                    } else if ("교원".equals(selectedItem.getName())) {
                              // 教师登陆

                    } else {
                              // 学生登陆

                    }
          }

          // protected void resetValue(ActionEvent ae) {
          // // TODO Auto-generated method stub
          // userNameTextField.setText("");
          // passwordTextField.setText("");
          // userTypeComboBox.setSelectedIndex(0);
          // }
}
