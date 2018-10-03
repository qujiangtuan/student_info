package com.qujia.view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;
import com.qujia.util.ViewUtil;

public class LectureOfStudentFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_1;
          private JTextField textField_2;
          private JTable table;
          private JTextField textField_3;
          private JTextField textField_4;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  LectureOfStudentFrm frame = new LectureOfStudentFrm();
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
          public LectureOfStudentFrm() {
                    setTitle("\uC218\uAC15\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 877, 476);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uD559\uC218\uBC88\uD638:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uAD50\uACFC\uBAA9\uBA85:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uAC80 \uC0C9");
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC218\uBA85:");
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC2DC\uC791\uC77C\uC790:");
                    
                    DatePicker datePicker = new DatePicker();
                    
                    JLabel label = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC885\uB8CC\uC77C\uC790:");
                    
                    DatePicker datePicker_1 = new DatePicker();
                    
                    JLabel lblNewLabel_5 = new JLabel("\uD559\uC0DD\uD559\uBC88:");
                    
                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    
                    JButton btnNewButton_3 = new JButton("\uAE30\uAC04\uBCC0\uACBD");
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD559\uC218\uBC88\uD638:");
                    
                    textField_4 = new JTextField();
                    textField_4.setColumns(10);
                    
                    JButton btnNewButton_1 = new JButton("\uD655 \uC778");
                    
                    JButton btnNewButton_2 = new JButton("\uC218\uAC15\uC0AD\uC81C");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 839, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(62)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(57)
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addGap(18)
                                                                      .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(38)
                                                                      .addComponent(lblNewLabel_2)
                                                                      .addGap(18)
                                                                      .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.RELATED))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(lblNewLabel_3)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                                                      .addComponent(label, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(btnNewButton)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(36)
                                                                      .addComponent(btnNewButton_3)))
                                                  .addGap(84))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(27)
                                                  .addComponent(lblNewLabel_5)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(37)
                                                  .addComponent(lblNewLabel_4)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(36)
                                                  .addComponent(btnNewButton_1)
                                                  .addGap(37)
                                                  .addComponent(btnNewButton_2)
                                                  .addContainerGap(119, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                      .addComponent(datePicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton_3))
                                                  .addGap(25)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton_1)
                                                            .addComponent(btnNewButton_2))
                                                  .addContainerGap(119, Short.MAX_VALUE))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC218\uAC15\uBC88\uD638", "\uD559\uBC88", "\uD559\uC0DD\uBA85", "\uD559\uC218\uBC88\uD638", "\uAC1C\uC124\uAD50\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uB2F4\uB2F9\uAD50\uC218", "\uD559\uC810", "\uC2DC\uAC04/\uAC15\uC758\uC2E4"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, true, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(2).setPreferredWidth(84);
                    table.getColumnModel().getColumn(3).setPreferredWidth(95);
                    table.getColumnModel().getColumn(4).setPreferredWidth(101);
                    table.getColumnModel().getColumn(5).setPreferredWidth(56);
                    table.getColumnModel().getColumn(7).setPreferredWidth(63);
                    table.getColumnModel().getColumn(8).setPreferredWidth(179);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          }
}
