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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.qujia.util.ViewUtil;

public class FindPassword extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_1;

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
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel label_1 = new JLabel("\uC774\uBA54\uC77C:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JButton button = new JButton("\uD655 \uC778");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
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
                                                                      .addComponent(textField, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(label_1)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_1)))
                                                  .addContainerGap(57, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(39)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(button)
                                                            .addComponent(button_1))
                                                  .addGap(34))
                    );
                    contentPane.setLayout(gl_contentPane);
          }


}
