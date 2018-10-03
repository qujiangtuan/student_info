package com.qujia.view;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;

import com.qujia.util.ViewUtil;

public class AddAppendMajorOrgFrm extends JFrame {

          private JPanel contentPane;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddAppendMajorOrgFrm frame = new AddAppendMajorOrgFrm();
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
          public AddAppendMajorOrgFrm() {
                    setTitle("\uBCF5\uC218\uBD80\uC804\uACF5\uD5C8\uC6A9\uBC94\uC704\uCD94\uAC00");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 576, 322);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAE30\uC900\uD559\uACFC:");
                    
                    JComboBox comboBox = new JComboBox();
                    
                    JComboBox comboBox_1 = new JComboBox();
                    
                    JLabel label = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC801\uC6A9\uB144\uB3C4:");
                    
                    JSpinner spinner = new JSpinner();
                    spinner.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    JSpinner spinner_1 = new JSpinner();
                    spinner_1.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD5C8\uC6A9\uAD6C\uBD84:");
                    
                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "\uBCF5\uC218\uC804\uACF5", "\uBD80\uC804\uACF5"}));
                    
                    JLabel lblNewLabel_3 = new JLabel("\uBC94\uC704\uAD6C\uBD84:");
                    
                    JComboBox comboBox_3 = new JComboBox();
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "\uB300\uD559", "\uD559\uBD80", "\uD559\uACFC", "\uC804\uACF5"}));
                    
                    JButton btnNewButton = new JButton("\uCD94 \uAC00");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(80)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(label)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(lblNewLabel_2))
                                                  .addGap(24)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(btnNewButton)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                      .addComponent(comboBox, 0, 285, Short.MAX_VALUE)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                                                                          .addComponent(comboBox_2, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                          .addComponent(spinner, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                          .addComponent(spinner_1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                                                          .addComponent(comboBox_3, Alignment.LEADING, 0, 110, Short.MAX_VALUE)))))
                                                  .addGap(107))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(37)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel))
                                                  .addGap(19)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                                  .addComponent(btnNewButton)
                                                  .addGap(29))
                    );
                    contentPane.setLayout(gl_contentPane);
          }
}
