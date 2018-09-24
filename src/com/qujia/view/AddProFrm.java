package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.util.ViewUtil;

public class AddProFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTextField textField_tel;
          private JTextField textField_ename;
          private JTextField textField_address;
          private JTextField textField_email;
          private JTextField textField_cardid_1;
          private JTextField textField_cardid_2;

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
                    setTitle("\uAD50\uC9C1\uC6D0\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 654, 419);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAD50\uC6D0\uC774\uB984:");
                    
                    textField_name = new JTextField();
                    textField_name.setColumns(10);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC6D0\uAD6C\uBD84:");
                    
                    JRadioButton radioButton_1 = new JRadioButton("\uC804\uC784\uAD50\uC218");
                    
                    JRadioButton radioButton_2 = new JRadioButton("\uACB8\uC784\uAD50\uC218");
                    
                    JRadioButton radioButton_3 = new JRadioButton("\uC2DC\uAC04\uAC15\uC0AC");
                    
                    JComboBox comboBox_pro = new JComboBox();
                    comboBox_pro.setModel(new DefaultComboBoxModel(new String[] {"", "\uC815\uAD50\uC218", "\uBD80\uAD50\uC218", "\uC870\uAD50\uC218", "\uC804\uC784\uAC15\uC0AC"}));
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC804\uD654\uBC88\uD638:");
                    
                    textField_tel = new JTextField();
                    textField_tel.setColumns(10);
                    
                    DatePicker datePicker = new DatePicker();
                    
                    JLabel lblNewLabel_1 = new JLabel("    \uC601\uC5B4\uC774\uB984:");
                    
                    textField_ename = new JTextField();
                    textField_ename.setColumns(10);
                    
                    JLabel label = new JLabel("       \uC131 \uBCC4:");
                    
                    JLabel label_1 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638:");
                    
                    JLabel label_2 = new JLabel("    \uC18C\uC18D\uC870\uC9C1:");
                    
                    JLabel label_3 = new JLabel("        \uC8FC\uC18C:");
                    
                    JLabel label_4 = new JLabel("      \uC774\uBA54\uC77C:");
                    
                    textField_address = new JTextField();
                    textField_address.setColumns(10);
                    
                    textField_email = new JTextField();
                    textField_email.setColumns(10);
                    
                    JRadioButton radioButton_female = new JRadioButton("\uB0A8");
                    
                    JRadioButton radioButton_male = new JRadioButton("\uC5EC");
                    
                    JComboBox comboBox_dept = new JComboBox();
                    
                    JLabel lblNewLabel_3 = new JLabel("\uB4F1\uB85D\uC77C\uC790:");
                    
                    DatePicker datePicker_1 = new DatePicker();
                    
                    textField_cardid_1 = new JTextField();
                    textField_cardid_1.setColumns(10);
                    
                    textField_cardid_2 = new JTextField();
                    textField_cardid_2.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uB4F1 \uB85D");
                    btnNewButton.setBackground(new Color(224, 255, 255));
                    
                    JButton btnNewButton_1 = new JButton("\uCDE8 \uC18C");
                    btnNewButton_1.setBackground(new Color(255, 182, 193));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(58)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(btnNewButton)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(textField_name))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                          .addComponent(textField_tel)
                                                                                          .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                                                                              .addComponent(radioButton_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                              .addComponent(radioButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                              .addComponent(radioButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                                                                                                    .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                    .addComponent(comboBox_pro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                                      .addComponent(lblNewLabel_5)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(datePicker_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                  .addGap(16)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                      .addComponent(label, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                                                .addComponent(label_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(label_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(label_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                                                            .addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(textField_ename))
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                          .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                                              .addComponent(textField_cardid_1, 0, 0, Short.MAX_VALUE)
                                                                                                              .addComponent(radioButton_female, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                                                                                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                              .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                                        .addGap(17)
                                                                                                                        .addComponent(radioButton_male, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                                                                                        .addGap(7))
                                                                                                              .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                                        .addGap(18)
                                                                                                                        .addComponent(textField_cardid_2, 0, 0, Short.MAX_VALUE))))
                                                                                          .addComponent(comboBox_dept, 0, 130, Short.MAX_VALUE)
                                                                                          .addComponent(textField_address, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                                                                          .addComponent(textField_email, Alignment.TRAILING)))
                                                                      .addGap(18)
                                                                      .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(73))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(btnNewButton_1)
                                                                      .addContainerGap())))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(37)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_ename, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(22)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(radioButton_1)
                                                            .addComponent(comboBox_pro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label)
                                                            .addComponent(radioButton_female)
                                                            .addComponent(radioButton_male))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(radioButton_2)
                                                            .addComponent(label_1)
                                                            .addComponent(textField_cardid_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField_cardid_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(8)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(radioButton_3)
                                                            .addComponent(label_2)
                                                            .addComponent(comboBox_dept, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(textField_tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_3)
                                                            .addComponent(textField_address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_4)
                                                                      .addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(lblNewLabel_3))
                                                            .addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(43)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(btnNewButton)
                                                            .addComponent(btnNewButton_1))
                                                  .addContainerGap(60, Short.MAX_VALUE))
                    );
                    contentPane.setLayout(gl_contentPane);
          }
}
