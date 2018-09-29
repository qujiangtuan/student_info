package com.qujia.view;

import java.awt.CardLayout;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.qujia.util.ViewUtil;

public class ScoreInputFrm extends  JFrame {

          private JPanel contentPane;
          private CardLayout card;
          private JTextField textField;
          private JTextField textField_1;
          private JTextField textField_2;
          private JTextField textField_3;
          private JTextField textField_4;
          private JTextField textField_5;
          private JTextField textField_6;
          private JTextField textField_7;
          private JTextField textField_8;
          private JTextField textField_9;
          private JTextField textField_10;
          private JTextField textField_11;
          private JTextField textField_12;
          private JTextField textField_13;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreInputFrm frame = new ScoreInputFrm();
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
          public ScoreInputFrm() {
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 552, 444);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JPanel panel_one = new JPanel();
                    
                    JPanel panel_two = new JPanel();
                    
                    JPanel panel_info = new JPanel();
                    
                    JLabel label_6 = new JLabel("\uC774\uB984:");
                    
                    JLabel label_7 = new JLabel("\uCDE8 \uC9C0\uC559\uD22C\uC548");
                    
                    JLabel label_8 = new JLabel("\uD559\uBC88:");
                    
                    JLabel lblNewLabel_5 = new JLabel("201518047");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uD559\uB144:");
                    
                    JLabel label_9 = new JLabel("4");
                    
                    JLabel lblNewLabel_7 = new JLabel("\uD559\uACFC:");
                    
                    JLabel lblNewLabel_8 = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
                    GroupLayout gl_panel_info = new GroupLayout(panel_info);
                    gl_panel_info.setHorizontalGroup(
                              gl_panel_info.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_info.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(label_6)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(label_7)
                                                  .addGap(18)
                                                  .addComponent(label_8)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(lblNewLabel_5)
                                                  .addGap(18)
                                                  .addComponent(lblNewLabel_6)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(label_9)
                                                  .addGap(29)
                                                  .addComponent(lblNewLabel_7)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(lblNewLabel_8)
                                                  .addContainerGap(190, Short.MAX_VALUE))
                    );
                    gl_panel_info.setVerticalGroup(
                              gl_panel_info.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_info.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_panel_info.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_6)
                                                            .addComponent(label_7)
                                                            .addComponent(label_8)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(label_9)
                                                            .addComponent(lblNewLabel_7)
                                                            .addComponent(lblNewLabel_8))
                                                  .addContainerGap(60, Short.MAX_VALUE))
                    );
                    panel_info.setLayout(gl_panel_info);
                    card=new CardLayout(0,0);
                    panel_two.setLayout(card);
                    
                    JPanel panel_a = new JPanel();
                    panel_a.setBackground(new Color(192, 192, 192));
                    panel_two.add(panel_a, "panel_a");
                    
                    JLabel label = new JLabel("\uC131\uC801\uC785\uB825");
                    
                    JLabel lblNewLabel = new JLabel("\uC911\uAC04\uACE0\uC0AC:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel label_1 = new JLabel("\uAE30\uB9D0\uACE0\uC0AC:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uACFC     \uC81C:");
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uCD9C     \uC11D:");
                    
                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    
                    JLabel lblNewLabel_3 = new JLabel("30%");
                    
                    JLabel lblNewLabel_4 = new JLabel("30%");
                    
                    JLabel label_2 = new JLabel("20%");
                    
                    JLabel label_3 = new JLabel("10%");
                    
                    JLabel label_4 = new JLabel("\uBC1C     \uD45C:");
                    
                    textField_4 = new JTextField();
                    textField_4.setColumns(10);
                    
                    JLabel label_5 = new JLabel("10%");
                    
                    JLabel label_10 = new JLabel("\uCDE8\uB4DD\uC131\uC801:");
                    
                    textField_5 = new JTextField();
                    textField_5.setColumns(10);
                    
                    JLabel lblNewLabel_9 = new JLabel("\uCDE8\uB4DD\uB4F1\uAE09:");
                    
                    textField_6 = new JTextField();
                    textField_6.setText("");
                    textField_6.setColumns(10);
                    
                    JButton btnNewButton_2 = new JButton("\uD655\uC778");
                    btnNewButton_2.setBackground(new Color(175, 238, 238));
                    btnNewButton_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 14));
                    GroupLayout gl_panel_a = new GroupLayout(panel_a);
                    gl_panel_a.setHorizontalGroup(
                              gl_panel_a.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_a.createSequentialGroup()
                                                  .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_a.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(label)
                                                                                .addGroup(gl_panel_a.createSequentialGroup()
                                                                                          .addGap(10)
                                                                                          .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING)
                                                                                                    .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                              .addComponent(lblNewLabel)
                                                                                                              .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                              .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                              .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                              .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                              .addGroup(gl_panel_a.createParallelGroup(Alignment.TRAILING)
                                                                                                                        .addComponent(label_4)
                                                                                                                        .addComponent(lblNewLabel_2)
                                                                                                                        .addComponent(label_1)
                                                                                                                        .addComponent(lblNewLabel_1))
                                                                                                              .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                              .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING, false)
                                                                                                                        .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                                                  .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                  .addComponent(label_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                                                                                                        .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                                                  .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                  .addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                                        .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                                                  .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                  .addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                                        .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                                                  .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                  .addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                                                          .addGap(10)
                                                                                          .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING)
                                                                                                    .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                              .addComponent(label_10)
                                                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                              .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(gl_panel_a.createSequentialGroup()
                                                                                                              .addComponent(lblNewLabel_9)
                                                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                              .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
                                                            .addGroup(gl_panel_a.createSequentialGroup()
                                                                      .addGap(43)
                                                                      .addComponent(btnNewButton_2)))
                                                  .addContainerGap(261, Short.MAX_VALUE))
                    );
                    gl_panel_a.setVerticalGroup(
                              gl_panel_a.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_a.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(label)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addGroup(gl_panel_a.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(label_10)
                                                            .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_panel_a.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_1)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(lblNewLabel_9)
                                                            .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_panel_a.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(label_2))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_a.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(label_3))
                                                            .addComponent(lblNewLabel_2))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_a.createSequentialGroup()
                                                                      .addGroup(gl_panel_a.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_4))
                                                                      .addGap(18)
                                                                      .addComponent(btnNewButton_2))
                                                            .addComponent(label_5))
                                                  .addContainerGap(68, Short.MAX_VALUE))
                    );
                    panel_a.setLayout(gl_panel_a);
                    
                    JPanel panel_b = new JPanel();
                    panel_b.setBackground(new Color(255, 182, 193));
                    panel_two.add(panel_b, "panel_b");
                    
                    JLabel label_11 = new JLabel("\uC131\uC801\uC785\uB825");
                    
                    JLabel label_12 = new JLabel("\uC911\uAC04\uACE0\uC0AC:");
                    
                    JLabel label_13 = new JLabel("\uAE30\uB9D0\uACE0\uC0AC:");
                    
                    JLabel label_14 = new JLabel("\uACFC     \uC81C:");
                    
                    JLabel label_15 = new JLabel("\uCD9C     \uC11D:");
                    
                    JLabel label_16 = new JLabel("\uBC1C     \uD45C:");
                    
                    textField_7 = new JTextField();
                    textField_7.setColumns(10);
                    
                    textField_8 = new JTextField();
                    textField_8.setColumns(10);
                    
                    textField_9 = new JTextField();
                    textField_9.setColumns(10);
                    
                    textField_10 = new JTextField();
                    textField_10.setColumns(10);
                    
                    textField_11 = new JTextField();
                    textField_11.setColumns(10);
                    
                    JLabel label_17 = new JLabel("20%");
                    
                    JLabel label_18 = new JLabel("20%");
                    
                    JLabel label_19 = new JLabel("20%");
                    
                    JLabel label_20 = new JLabel("20%");
                    
                    JLabel label_21 = new JLabel("20%");
                    
                    textField_12 = new JTextField();
                    textField_12.setColumns(10);
                    
                    JLabel label_22 = new JLabel("\uCDE8\uB4DD\uB4F1\uAE09:");
                    
                    textField_13 = new JTextField();
                    textField_13.setText("");
                    textField_13.setColumns(10);
                    
                    JLabel label_23 = new JLabel("\uCDE8\uB4DD\uC131\uC801:");
                    
                    JButton button = new JButton("\uBCC0\uACBD");
                    button.setFont(new Font("NanumMyeongjo", Font.BOLD, 14));
                    button.setBackground(new Color(175, 238, 238));
                    GroupLayout gl_panel_b = new GroupLayout(panel_b);
                    gl_panel_b.setHorizontalGroup(
                              gl_panel_b.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_b.createSequentialGroup()
                                                  .addGap(24)
                                                  .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(2)
                                                                      .addComponent(label_15)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(18)
                                                                      .addComponent(label_20, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(2)
                                                                      .addComponent(label_16)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(18)
                                                                      .addComponent(label_21, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(33)
                                                                      .addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(2)
                                                                      .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_panel_b.createSequentialGroup()
                                                                                          .addGroup(gl_panel_b.createParallelGroup(Alignment.TRAILING)
                                                                                                    .addGroup(Alignment.LEADING, gl_panel_b.createSequentialGroup()
                                                                                                              .addComponent(label_12)
                                                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                              .addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                              .addGap(24)
                                                                                                              .addComponent(label_17, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(Alignment.LEADING, gl_panel_b.createSequentialGroup()
                                                                                                              .addComponent(label_13)
                                                                                                              .addGap(10)
                                                                                                              .addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                              .addGap(18)
                                                                                                              .addComponent(label_18, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                                                                    .addGroup(gl_panel_b.createSequentialGroup()
                                                                                                              .addGap(38)
                                                                                                              .addComponent(label_22)
                                                                                                              .addGap(4)
                                                                                                              .addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(Alignment.TRAILING, gl_panel_b.createSequentialGroup()
                                                                                                              .addGap(38)
                                                                                                              .addComponent(label_23)
                                                                                                              .addGap(4)
                                                                                                              .addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                                                .addGroup(gl_panel_b.createSequentialGroup()
                                                                                          .addComponent(label_14)
                                                                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                          .addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(18)
                                                                                          .addComponent(label_19, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)))))
                                                  .addGap(161))
                                        .addGroup(gl_panel_b.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(label_11, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(429, Short.MAX_VALUE))
                    );
                    gl_panel_b.setVerticalGroup(
                              gl_panel_b.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_b.createSequentialGroup()
                                                  .addGap(12)
                                                  .addComponent(label_11)
                                                  .addGap(18)
                                                  .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(3)
                                                                      .addComponent(label_23))
                                                            .addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(gl_panel_b.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_12)
                                                                      .addComponent(label_17)
                                                                      .addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                  .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(10)
                                                                      .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_panel_b.createParallelGroup(Alignment.BASELINE)
                                                                                          .addComponent(label_13)
                                                                                          .addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_panel_b.createSequentialGroup()
                                                                                          .addGap(3)
                                                                                          .addComponent(label_22))
                                                                                .addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(13)
                                                                      .addComponent(label_18)))
                                                  .addGap(10)
                                                  .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_b.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_14)
                                                                      .addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(3)
                                                                      .addComponent(label_19)))
                                                  .addGap(10)
                                                  .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_b.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_15)
                                                                      .addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGap(3)
                                                                      .addComponent(label_20)))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addGroup(gl_panel_b.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_b.createSequentialGroup()
                                                                      .addGroup(gl_panel_b.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(label_16, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18)
                                                                      .addComponent(button, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(label_21))
                                                  .addContainerGap(58, Short.MAX_VALUE))
                    );
                    panel_b.setLayout(gl_panel_b);
                    
                    JButton btnNewButton = new JButton("\uC131\uC801\uC785\uB825");
                    btnNewButton.setBackground(new Color(102, 205, 170));
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        card.show(panel_two, "panel_a");
                              }
                    });
                    
                    JButton btnNewButton_1 = new JButton("\uC131\uC801\uBCC0\uACBD");
                    btnNewButton_1.setBackground(new Color(255, 182, 193));
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        card.show(panel_two, "panel_b");
                              }
                    });
                    GroupLayout gl_panel_one = new GroupLayout(panel_one);
                    gl_panel_one.setHorizontalGroup(
                              gl_panel_one.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_one.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(btnNewButton)
                                                  .addGap(18)
                                                  .addComponent(btnNewButton_1)
                                                  .addContainerGap(354, Short.MAX_VALUE))
                    );
                    gl_panel_one.setVerticalGroup(
                              gl_panel_one.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_one.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(btnNewButton)
                                                            .addComponent(btnNewButton_1))
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panel_one.setLayout(gl_panel_one);
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(panel_one, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel_info, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel_two, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addComponent(panel_one, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(6)
                                                  .addComponent(panel_info, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(6)
                                                  .addComponent(panel_two, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    );
                    contentPane.setLayout(gl_contentPane);
          }
}
