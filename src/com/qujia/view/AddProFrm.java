package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.util.ViewUtil;

public class AddProFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_3;
          private JTextField textField_5;
          private JTextField textField_6;
          private JTextField textField_7;
          private JTextField textField_2;
          private JTextField textField_1;

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
                    setBounds(100, 100, 507, 375);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uAD50\uC6D0\uC774\uB984:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC601\uC5B4\uC774\uB984:");
                    
                    JLabel lblNewLabel = new JLabel("\uAD50\uC9C1\uC6D0\uAD6C\uBD84:");
                    
                    JComboBox comboBox = new JComboBox();
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uC784\uAD50\uC218", "\uACB8\uC784\uAD50\uC218", "\uC2DC\uAC04\uAC15\uC0AC"}));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC6D0\uAD6C\uBD84:");
                    
                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uC815\uAD50\uC218", "\uBD80\uAD50\uC218", "\uC870\uAD50\uC218", "\uC804\uC784\uAC15\uC0AC"}));
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC124\uBCC4:");
                    
                    JLabel lblNewLabel_4 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638:");
                    
                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uC8FC\uC18C:");
                    
                    textField_5 = new JTextField();
                    textField_5.setColumns(10);
                    
                    JLabel lblNewLabel_7 = new JLabel("\uC804\uD654\uBC88\uD638:");
                    
                    textField_6 = new JTextField();
                    textField_6.setColumns(10);
                    
                    JLabel lblNewLabel_8 = new JLabel("\uC774\uBA54\uC77C:");
                    
                    textField_7 = new JTextField();
                    textField_7.setColumns(10);
                    
                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\uB0A8", "\uC5EC"}));
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uB4F1  \uB85D");
                    btnNewButton.setBackground(new Color(175, 238, 238));
                    btnNewButton.setFont(new Font("ÈÞ¸Õ°íµñ", Font.BOLD, 13));
                    
                    JButton btnNewButton_1 = new JButton("\uCDE8 \uC18C");
                    btnNewButton_1.setBackground(new Color(222, 184, 135));
                    btnNewButton_1.setFont(new Font("ÈÞ¸Õ°íµñ", Font.BOLD, 13));
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JLabel lblNewLabel_9 = new JLabel("\uB4F1\uB85D\uC77C\uC9DC:");
                    
                    DatePicker datePicker = new DatePicker();
                    
                    JComboBox comboBox_3 = new JComboBox();
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC"}));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(btnNewButton)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(lblNewLabel_9)
                                                                                .addComponent(lblNewLabel_7)
                                                                                .addComponent(lblNewLabel_5)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addComponent(lblNewLabel)
                                                                                .addComponent(label))
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(datePicker, 0, 0, Short.MAX_VALUE)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                          .addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                          .addComponent(textField_6)
                                                                                          .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                          .addComponent(textField, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                                                                .addComponent(comboBox_3, 0, 101, Short.MAX_VALUE))))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(lblNewLabel_8))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(textField_5, 133, 133, 133)
                                                            .addComponent(btnNewButton_1)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                                                            .addComponent(comboBox_1, 0, 133, Short.MAX_VALUE)
                                                            .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                                            .addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(118))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_2))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(lblNewLabel_3)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel_4)
                                                                      .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel_5)
                                                                      .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel_6)
                                                                      .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                  .addGap(23)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_7)
                                                            .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_8)
                                                            .addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(23)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(datePicker, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_9, Alignment.TRAILING))
                                                  .addGap(25)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(btnNewButton)
                                                            .addComponent(btnNewButton_1))
                                                  .addGap(40))
                    );
                    contentPane.setLayout(gl_contentPane);
          }
}
