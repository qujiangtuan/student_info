package com.qujia.view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
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
                    setTitle("\uD559\uC810\uD655\uC778");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 571, 442);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uC774\uB984:");
                    
                    JLabel lblNewLabel = new JLabel("\uCDE8 \uC9C0\uC559\uD22C\uC548");
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uACFC:");
                    
                    JLabel lblNewLabel_2 = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC878\uC5C5\uC774\uC218\uD559\uC810:");
                    
                    JLabel lblNewLabel_4 = new JLabel("132");
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC804\uACF5\uC774\uC218\uD559\uC810:");
                    
                    JLabel label_1 = new JLabel("91");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uC804\uACF5\uD544\uC218\uD559\uC810:");
                    
                    JLabel label_2 = new JLabel("\uC804\uACF5\uC120\uD0DD\uD559\uC810:");
                    
                    JLabel label_3 = new JLabel("\uAD50\uC591\uC774\uC218\uD559\uC810:");
                    
                    JLabel label_4 = new JLabel("\uAD50\uC591\uD544\uC218\uD559\uC810:");
                    
                    JLabel label_5 = new JLabel("\uAD50\uC591\uC120\uD0DD\uD559\uC810:");
                    
                    JLabel label_6 = new JLabel("36");
                    
                    JLabel label_7 = new JLabel("22");
                    
                    JLabel label_8 = new JLabel("12");
                    
                    JLabel lblNewLabel_7 = new JLabel("\uD559\uB144:");
                    
                    JLabel lblNewLabel_8 = new JLabel("1");
                    
                    JLabel lblNewLabel_9 = new JLabel("\uD559\uAE30:");
                    
                    JLabel label_9 = new JLabel("2");
                    
                    JLabel label_10 = new JLabel("54");
                    
                    JLabel label_11 = new JLabel("37");
                    
                    JLabel label_12 = new JLabel("41");
                    
                    JLabel label_13 = new JLabel("26");
                    
                    JLabel label_14 = new JLabel("15");
                    
                    JLabel label_15 = new JLabel("10");
                    
                    JLabel label_16 = new JLabel("14");
                    
                    JLabel label_17 = new JLabel("8");
                    
                    JLabel label_18 = new JLabel("6");
                    
                    JLabel lblNewLabel_10 = new JLabel("\uD3C9\uADE0\uC131\uC801:");
                    
                    JLabel lblB = new JLabel("B+");
                    
                    JButton btnNewButton = new JButton("\uD655\uC778");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(41)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addComponent(label)
                                                                                .addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                                .addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(label_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(label_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_4)
                                                                                .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblNewLabel)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(label_10, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_11, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_12, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_13, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_14, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(64)
                                                                      .addComponent(lblNewLabel_10)))
                                                  .addGap(51)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblB, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                                                      .addComponent(btnNewButton)
                                                                      .addGap(31))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(label_18, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_17, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_16, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_15, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_7)
                                                                                .addComponent(label_6)
                                                                                .addComponent(label_8)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                    .addComponent(lblNewLabel_7)
                                                                                                    .addComponent(lblNewLabel_9))
                                                                                          .addGap(30)
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                    .addComponent(label_9)
                                                                                                    .addComponent(lblNewLabel_8))))
                                                                      .addContainerGap(207, Short.MAX_VALUE))))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(32)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label)
                                                            .addComponent(lblNewLabel_7)
                                                            .addComponent(lblNewLabel_8))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(lblNewLabel_9)
                                                            .addComponent(label_9))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(label_6))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(label_1)
                                                            .addComponent(label_7))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(label_8)
                                                            .addComponent(label_10))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_2)
                                                            .addComponent(label_11)
                                                            .addComponent(label_15))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_3)
                                                            .addComponent(label_12)
                                                            .addComponent(label_16))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_4)
                                                            .addComponent(label_13)
                                                            .addComponent(label_17))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_5)
                                                            .addComponent(label_14)
                                                            .addComponent(label_18))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblB)
                                                            .addComponent(lblNewLabel_10))
                                                  .addContainerGap(49, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap(334, Short.MAX_VALUE)
                                                  .addComponent(btnNewButton)
                                                  .addGap(36))
                    );
                    contentPane.setLayout(gl_contentPane);
          }

}
