package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qujia.util.ViewUtil;

public class GradeCheckFrm extends JFrame {

          private JPanel contentPane;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  GradeCheckFrm frame = new GradeCheckFrm();
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
          public GradeCheckFrm() {
                    this.setResizable(false);
                    setTitle("\uD559\uC810\uD655\uC778");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 438, 488);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uC774\uB984:");
                    label.setBounds(84, 37, 52, 15);
                    
                    JLabel lblNewLabel = new JLabel("\uCDE8 \uC9C0\uC559\uD22C\uC548");
                    lblNewLabel.setBounds(154, 37, 100, 15);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uACFC:");
                    lblNewLabel_1.setBounds(84, 70, 52, 15);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
                    lblNewLabel_2.setBounds(154, 70, 100, 15);
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC878\uC5C5\uC774\uC218\uD559\uC810:");
                    lblNewLabel_3.setBounds(36, 103, 100, 15);
                    
                    JLabel lblNewLabel_4 = new JLabel("132");
                    lblNewLabel_4.setBounds(154, 103, 52, 15);
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC804\uACF5\uC774\uC218\uD559\uC810:");
                    lblNewLabel_5.setBounds(36, 136, 100, 15);
                    
                    JLabel label_1 = new JLabel("91");
                    label_1.setBounds(154, 136, 52, 15);
                    
                    JLabel lblNewLabel_6 = new JLabel("\uC804\uACF5\uD544\uC218\uD559\uC810:");
                    lblNewLabel_6.setBounds(36, 169, 100, 15);
                    
                    JLabel label_2 = new JLabel("\uC804\uACF5\uC120\uD0DD\uD559\uC810:");
                    label_2.setBounds(36, 202, 100, 15);
                    
                    JLabel label_3 = new JLabel("\uAD50\uC591\uC774\uC218\uD559\uC810:");
                    label_3.setBounds(36, 235, 100, 15);
                    
                    JLabel label_4 = new JLabel("\uAD50\uC591\uD544\uC218\uD559\uC810:");
                    label_4.setBounds(36, 268, 100, 15);
                    
                    JLabel label_5 = new JLabel("\uAD50\uC591\uC120\uD0DD\uD559\uC810:");
                    label_5.setBounds(36, 301, 100, 15);
                    
                    JLabel label_6 = new JLabel("36");
                    label_6.setBounds(277, 103, 39, 15);
                    
                    JLabel label_7 = new JLabel("22");
                    label_7.setBounds(277, 136, 39, 15);
                    
                    JLabel label_8 = new JLabel("12");
                    label_8.setBounds(277, 169, 39, 15);
                    
                    JLabel lblNewLabel_7 = new JLabel("\uD559\uB144:");
                    lblNewLabel_7.setBounds(266, 37, 39, 15);
                    
                    JLabel lblNewLabel_8 = new JLabel("1");
                    lblNewLabel_8.setBounds(335, 37, 39, 15);
                    
                    JLabel lblNewLabel_9 = new JLabel("\uD559\uAE30:");
                    lblNewLabel_9.setBounds(266, 70, 39, 15);
                    
                    JLabel label_9 = new JLabel("2");
                    label_9.setBounds(335, 70, 39, 15);
                    
                    JLabel label_10 = new JLabel("54");
                    label_10.setBounds(154, 169, 52, 15);
                    
                    JLabel label_11 = new JLabel("37");
                    label_11.setBounds(154, 202, 52, 15);
                    
                    JLabel label_12 = new JLabel("41");
                    label_12.setBounds(154, 235, 52, 15);
                    
                    JLabel label_13 = new JLabel("26");
                    label_13.setBounds(154, 268, 52, 15);
                    
                    JLabel label_14 = new JLabel("15");
                    label_14.setBounds(154, 301, 52, 15);
                    
                    JLabel label_15 = new JLabel("10");
                    label_15.setBounds(277, 202, 39, 15);
                    
                    JLabel label_16 = new JLabel("14");
                    label_16.setBounds(277, 235, 39, 15);
                    
                    JLabel label_17 = new JLabel("8");
                    label_17.setBounds(277, 268, 39, 15);
                    
                    JLabel label_18 = new JLabel("6");
                    label_18.setBounds(277, 301, 52, 15);
                    
                    JLabel lblNewLabel_10 = new JLabel("\uD3C9\uADE0\uC131\uC801:");
                    lblNewLabel_10.setBounds(58, 334, 63, 15);
                    
                    JLabel lblB = new JLabel("B+");
                    lblB.setBounds(277, 334, 39, 15);
                    
                    JButton btnNewButton = new JButton("\uD655\uC778");
                    btnNewButton.setBounds(171, 396, 83, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(label);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(lblNewLabel_6);
                    contentPane.add(label_2);
                    contentPane.add(label_3);
                    contentPane.add(label_4);
                    contentPane.add(label_5);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(label_1);
                    contentPane.add(lblNewLabel);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(label_10);
                    contentPane.add(label_11);
                    contentPane.add(label_12);
                    contentPane.add(label_13);
                    contentPane.add(label_14);
                    contentPane.add(lblNewLabel_10);
                    contentPane.add(lblB);
                    contentPane.add(btnNewButton);
                    contentPane.add(label_18);
                    contentPane.add(label_17);
                    contentPane.add(label_16);
                    contentPane.add(label_15);
                    contentPane.add(label_7);
                    contentPane.add(label_6);
                    contentPane.add(label_8);
                    contentPane.add(lblNewLabel_7);
                    contentPane.add(lblNewLabel_9);
                    contentPane.add(label_9);
                    contentPane.add(lblNewLabel_8);
          }

}
