package com.qujia.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.eltima.components.ui.DatePicker;
import com.qujia.util.ViewUtil;

public class CourseListStuFrm extends JFrame {

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
                                                  CourseListStuFrm frame = new CourseListStuFrm();
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
          public CourseListStuFrm() {
                    setTitle("\uC218\uAC15\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 877, 476);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uD559\uC218\uBC88\uD638:");
                    lblNewLabel.setBounds(51, 69, 68, 15);
                    
                    textField = new JTextField();
                    textField.setBounds(131, 66, 116, 21);
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uAD50\uACFC\uBAA9\uBA85:");
                    lblNewLabel_1.setBounds(295, 69, 61, 15);
                    
                    textField_1 = new JTextField();
                    textField_1.setBounds(374, 66, 129, 21);
                    textField_1.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uAC80 \uC0C9");
                    btnNewButton.setBounds(721, 65, 81, 23);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC218\uBA85:");
                    lblNewLabel_2.setBounds(529, 69, 52, 15);
                    
                    textField_2 = new JTextField();
                    textField_2.setBounds(599, 66, 115, 21);
                    textField_2.setColumns(10);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 106, 839, 232);
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC2DC\uC791\uC77C\uC790:");
                    lblNewLabel_3.setBounds(51, 15, 116, 25);
                    
                    DatePicker datePicker = new DatePicker();
                    datePicker.setBounds(179, 15, 160, 25);
                    
                    JLabel label = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC885\uB8CC\uC77C\uC790:");
                    label.setBounds(427, 15, 129, 25);
                    
                    DatePicker datePicker_1 = new DatePicker();
                    datePicker_1.setBounds(561, 15, 160, 21);
                    
                    JLabel lblNewLabel_5 = new JLabel("\uD559\uC0DD\uD559\uBC88:");
                    lblNewLabel_5.setBounds(17, 360, 67, 15);
                    
                    textField_3 = new JTextField();
                    textField_3.setBounds(96, 357, 126, 21);
                    textField_3.setColumns(10);
                    
                    JButton btnNewButton_3 = new JButton("\uAE30\uAC04\uBCC0\uACBD");
                    btnNewButton_3.setBounds(733, 15, 105, 23);
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD559\uC218\uBC88\uD638:");
                    lblNewLabel_4.setBounds(243, 360, 68, 15);
                    
                    textField_4 = new JTextField();
                    textField_4.setBounds(323, 357, 185, 21);
                    textField_4.setColumns(10);
                    
                    JButton btnNewButton_1 = new JButton("\uD655 \uC778");
                    btnNewButton_1.setBounds(544, 356, 86, 23);
                    
                    JButton btnNewButton_2 = new JButton("\uC218\uAC15\uC0AD\uC81C");
                    btnNewButton_2.setBounds(642, 356, 97, 23);
                    
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
                    table.getColumnModel().getColumn(4).setPreferredWidth(114);
                    table.getColumnModel().getColumn(5).setPreferredWidth(56);
                    table.getColumnModel().getColumn(7).setPreferredWidth(63);
                    table.getColumnModel().getColumn(8).setPreferredWidth(276);
                    contentPane.setLayout(null);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.add(scrollPane);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(textField_1);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(textField_2);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(datePicker);
                    contentPane.add(label);
                    contentPane.add(datePicker_1);
                    contentPane.add(btnNewButton);
                    contentPane.add(btnNewButton_3);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(textField_3);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(textField_4);
                    contentPane.add(btnNewButton_1);
                    contentPane.add(btnNewButton_2);
          }
}
