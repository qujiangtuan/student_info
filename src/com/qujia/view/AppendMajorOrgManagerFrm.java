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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class AppendMajorOrgManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_1;
          private JButton btnNewButton;
          private JScrollPane scrollPane;
          private JTable table;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AppendMajorOrgManagerFrm frame = new AppendMajorOrgManagerFrm();
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
          public AppendMajorOrgManagerFrm() {
                    setTitle("\uBCF5\uC218\uBD80\uC804\uACF5\uD5C8\uC6A9\uBC94\uC704\uBAA9\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 668, 478);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAE30\uC900\uD559\uACFC:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    btnNewButton = new JButton("\uAC80 \uC0C9");
                    
                    scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    
                    JComboBox comboBox = new JComboBox();
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC2DC\uC791\uB144\uB3C4:");
                    
                    JSpinner spinner = new JSpinner();
                    spinner.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    JSpinner spinner_1 = new JSpinner();
                    spinner_1.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD5C8\uC6A9\uAD6C\uBD84:");
                    
                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\uBCF5\uC218\uC804\uACF5", "\uBD80\uC804\uACF5"}));
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC885\uB8CC\uB144\uB3C4:");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uBC94\uC704\uAD6C\uBD84:");
                    
                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "\uB300\uD559", "\uD559\uBD80", "\uD559\uACFC", "\uC804\uACF5"}));
                    
                    JButton btnNewButton_1 = new JButton("\uC218 \uC815");
                    btnNewButton_1.setBackground(new Color(224, 255, 255));
                    
                    JButton button = new JButton("\uC0AD \uC81C");
                    button.setBackground(new Color(255, 127, 80));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(47)
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(textField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(45)
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addGap(18)
                                                                      .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(70)
                                                                      .addComponent(btnNewButton))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)))
                                                  .addContainerGap(14, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(27)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_2)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(lblNewLabel_4)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(lblNewLabel_3)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(spinner, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGap(59)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(lblNewLabel_5)
                                                                                          .addGap(18)
                                                                                          .addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(lblNewLabel_6)
                                                                                          .addGap(18)
                                                                                          .addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(btnNewButton_1)
                                                            .addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(37))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(27)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton_1))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(button))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addContainerGap(30, Short.MAX_VALUE))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, "", null, null, null},
                              },
                              new String[] {
                                        "\uD5C8\uC6A9\uCF54\uB4DC", "\uAE30\uC900\uD559\uACFC", "\uD5C8\uC6A9\uD559\uACFC", "\uC801\uC6A9\uC2DC\uC791\uB144\uB3C4", "\uC801\uC6A9\uC885\uB8CC\uB144\uB3C4", "\uD5C8\uC6A9\uAD6C\uBD84", "\uBC94\uC704\uAD6C\uBD84", "\uB4F1\uB85D\uC77C\uC790"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(3).setPreferredWidth(101);
                    table.getColumnModel().getColumn(4).setPreferredWidth(101);
                    table.getColumnModel().getColumn(5).setPreferredWidth(85);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
          }
}
