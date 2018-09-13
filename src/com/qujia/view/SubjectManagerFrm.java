package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.eltima.components.ui.DatePicker;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class SubjectManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_1;
          private JTextField textField_2;
          private JTable table;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SubjectManagerFrm frame = new SubjectManagerFrm();
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
          public SubjectManagerFrm() {
                    setTitle("\uAD50\uACFC\uBAA9\uACFC\uB9AC");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 736, 641);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uACFC\uBAA9\uC774\uB984:");
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField = new JTextField();
                    textField.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel = new JLabel("\uC601\uC5B4\uC774\uB984:");
                    lblNewLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    textField_1 = new JTextField();
                    textField_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField_1.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC774\uC218\uAD6C\uBD84:");
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JComboBox comboBox = new JComboBox();
                    comboBox.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uD544", "\uC804\uC120", "\uAD50\uD544", "\uAD50\uC120"}));
                    
                    JLabel label_1 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uB300       \uC0C1:");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uB300\uD559", "\uB300\uD559\uC6D0"}));
                    
                    JLabel lblNewLabel_3 = new JLabel("\uB300\uC0C1\uD559\uB144:");
                    lblNewLabel_3.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel lblNewLabel_5 = new JLabel("\uB300\uC0C1\uD559\uAE30:");
                    lblNewLabel_5.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"3", "2", "1"}));
                    
                    JComboBox comboBox_3 = new JComboBox();
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "\uB300\uD559\uAD001", "\uB300\uD559\uAD002", "\uB300\uD559\uAD003"}));
                    comboBox_3.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JComboBox comboBox_5 = new JComboBox();
                    comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
                    
                    JLabel lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uBA85:");
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    JButton btnNewButton_2 = new JButton("\uCEF4   \uC0C9");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel label_2 = new JLabel("\uC124       \uBA85:");
                    label_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JTextArea textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    
                    JLabel lblNewLabel_4 = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    lblNewLabel_4.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JComboBox comboBox_4 = new JComboBox();
                    comboBox_4.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC"}));
                    
                    JButton btnNewButton = new JButton("\uC218   \uC815");
                    btnNewButton.setBackground(new Color(176, 224, 230));
                    btnNewButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton btnNewButton_1 = new JButton("\uC0AD   \uC81C");
                    btnNewButton_1.setBackground(new Color(255, 127, 80));
                    btnNewButton_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(30)
                                                  .addComponent(lblNewLabel_6)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(49)
                                                  .addComponent(btnNewButton_2)
                                                  .addContainerGap(178, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                                                  .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(btnNewButton)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(textField_1))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(label)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                          .addComponent(lblNewLabel_4)
                                                                                          .addComponent(label_1))
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                          .addComponent(comboBox_4, 0, 126, Short.MAX_VALUE)
                                                                                          .addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                  .addGap(100)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_5)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                          .addComponent(lblNewLabel_2)
                                                                                          .addComponent(lblNewLabel_3))
                                                                                .addComponent(label_2))
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(textArea, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                                                                .addComponent(comboBox_5, 0, 143, Short.MAX_VALUE)
                                                                                .addComponent(comboBox_3, 0, 143, Short.MAX_VALUE)
                                                                                .addComponent(comboBox_1, 0, 143, Short.MAX_VALUE))
                                                                      .addGap(195))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(btnNewButton_1)
                                                                      .addContainerGap())))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton_2))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(label)
                                                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel)
                                                                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(58)))
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_2)
                                                            .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_1))
                                                                      .addGap(19)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_4)
                                                                                .addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                  .addGap(38)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(btnNewButton)
                                                            .addComponent(btnNewButton_1))
                                                  .addGap(44))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAD50\uACFC\uBAA9\uCF54\uB4DC", "\uAD50\uACFC\uBAA9\uBA85", "\uC601\uC5B4\uBA85", "\uC774\uC218\uAD6C\uBD84", "\uC774\uC218\uD559\uC810", "\uC18C\uC18D\uD559\uACFC", "\uB300\uC0C1", "\uB300\uC0C1\uD559\uB144", "\uB300\uC0C1\uD559\uAE30", "\uC124\uBA85"
                              }
                    ));
                    table.getColumnModel().getColumn(0).setPreferredWidth(84);
                    table.getColumnModel().getColumn(6).setPreferredWidth(56);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
          }
}
