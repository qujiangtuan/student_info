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
import javax.swing.text.View;

import com.eltima.components.ui.DatePicker;
import com.qujia.util.ViewUtil;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AddDeptFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTextField textField_num;
          private JTextField textField_3;
          private JTextField textField_year1;
          private JTextField textField_year2;
          private JTextField textField_credit;
          private JTextField textField_no;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddDeptFrm frame = new AddDeptFrm();
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
          public AddDeptFrm() {
                    setTitle("\uD559\uACFC(\uC804\uACF5)\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 471, 546);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label_no = new JLabel("\uD559\uACFC\uCF54\uB4DC:");
                    label_no.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_name = new JTextField();
                    textField_name.setColumns(10);
                    
                    JLabel label_uni = new JLabel("\uC18C\uC18D\uB300\uD559:");
                    label_uni.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel label_credit = new JLabel("\uC878\uC5C5\uC774\uC218\uD559\uC810:");
                    label_credit.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_num = new JTextField();
                    textField_num.setColumns(10);
                    
                    JLabel label_num = new JLabel("\uBAA8\uC9D1\uC778\uC6D0:");
                    label_num.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    label_num.setBackground(new Color(175, 238, 238));
                    
                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    
                    JLabel label_loginDate = new JLabel("\uB4F1\uB85D\uC77C\uC9DC:");
                    label_loginDate.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel label_year1 = new JLabel("\uC218\uD559\uB144\uD55C:");
                    label_year1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_year1 = new JTextField();
                    textField_year1.setColumns(10);
                    
                    JLabel label_year2 = new JLabel("\uC7AC\uD559\uB144\uD55C:");
                    label_year2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_year2 = new JTextField();
                    textField_year2.setColumns(10);
                    
                    JComboBox comboBox_uni = new JComboBox();
                    comboBox_uni.setEditable(true);
                    comboBox_uni.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_uni.setModel(new DefaultComboBoxModel(new String[] {"\uACF5\uD559\uB300\uD559", "\uBB38\uD654\uB300\uD559", "\uACBD\uC601\uB300\uD559", "\uC218\uC0B0\uB300\uD559"}));
                    
                    JButton button_submit = new JButton("\uB4F1 \uB85D");
                    button_submit.setBackground(new Color(175, 238, 238));
                    button_submit.setFont(new Font("NanumMyeongjo", Font.BOLD, 14));
                    
                    textField_credit = new JTextField();
                    textField_credit.setColumns(10);
                    
                    JLabel label_name = new JLabel("\uD559\uACFC\uC774\uB984:");
                    label_name.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    textField_no = new JTextField();
                    textField_no.setColumns(10);
                    
                    DatePicker datePicker = new DatePicker();
                    
                    JButton button_cancel = new JButton("\uCDE8 \uC18C");
                    button_cancel.setFont(new Font("Dialog", Font.BOLD, 14));
                    button_cancel.setBackground(new Color(175, 238, 238));
                    
                    JLabel label_explain = new JLabel("\uD559\uACFC\uC124\uBA85:");
                    label_explain.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JScrollPane scrollPane = new JScrollPane();
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGap(76)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                          .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                                                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                                              .addComponent(label_year1)
                                                                                                              .addComponent(label_year2)
                                                                                                              .addComponent(label_num)
                                                                                                              .addComponent(label_loginDate)
                                                                                                              .addComponent(label_explain, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                                                              .addComponent(label_credit)
                                                                                                              .addComponent(label_uni)
                                                                                                              .addComponent(label_name)
                                                                                                              .addComponent(label_no))
                                                                                                    .addGap(29)
                                                                                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                              .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                                                                              .addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                                                                              .addComponent(textField_year1, 125, 125, Short.MAX_VALUE)
                                                                                                              .addComponent(textField_year2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                                                                              .addComponent(textField_3, 125, 125, Short.MAX_VALUE)
                                                                                                              .addComponent(textField_num, 125, 125, Short.MAX_VALUE)))
                                                                                          .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                    .addComponent(button_submit, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                                                    .addPreferredGap(ComponentPlacement.RELATED))))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                          .addComponent(textField_name, 125, 125, Short.MAX_VALUE)
                                                                                          .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                    .addGap(1)
                                                                                                    .addComponent(textField_credit))
                                                                                          .addComponent(comboBox_uni, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                                                                          .addComponent(textField_no))
                                                                                .addGap(1))))
                                                  .addGap(144))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(23)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_no))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_name))
                                                  .addGap(26)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(comboBox_uni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_uni))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_credit))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_num))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(label_loginDate)
                                                            .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(16)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(textField_year1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_year1))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(textField_year2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_year2)))
                                                            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(label_explain, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(19)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(button_submit))
                                                  .addGap(22))
                    );
                    
                    JTextArea textArea_explain = new JTextArea();
                    textArea_explain.setLineWrap(true);
                    scrollPane.setViewportView(textArea_explain);
                    contentPane.setLayout(gl_contentPane);
          }
}
