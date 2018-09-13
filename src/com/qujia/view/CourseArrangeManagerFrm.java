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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import com.eltima.components.ui.DatePicker;

public class CourseArrangeManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTable table;
          private JLabel lblNewLabel_1;
          private JTextField textField_1;
          private JLabel lblNewLabel_2;
          private JTextField textField_2;
          private JTextField textField_3;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseArrangeManagerFrm frame = new CourseArrangeManagerFrm();
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
          public CourseArrangeManagerFrm() {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 875, 675);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC218\uAC15\uC774\uB984/\uD559\uC218\uBC88\uD638/\uAD50\uC218\uC774\uB984:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uCEF4  \uC0C9");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    lblNewLabel_1 = new JLabel("\uD559\uC218\uBC88\uD638:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    lblNewLabel_2 = new JLabel("\uC218\uAC15\uC774\uB984:");
                    
                    JComboBox comboBox = new JComboBox();
                    
                    JLabel lblNewLabel_3 = new JLabel("\uB2F4\uB2F9\uAD50\uC218:");
                    
                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setEditable(true);
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD559    \uB144:");
                    
                    JComboBox comboBox_2 = new JComboBox();
                    
                    JLabel lblNewLabel_5 = new JLabel("\uD559    \uAE30:");
                    
                    JComboBox comboBox_3 = new JComboBox();
                    
                    JLabel lblNewLabel_6 = new JLabel("\uBD84    \uBC18:");
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    JLabel lblNewLabel_7 = new JLabel("\uC815    \uC6D0:");
                    
                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    
                    JLabel lblNewLabel_8 = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC2DC\uC791:");
                    
                    DatePicker datePicker = new DatePicker();
                    
                    JLabel lblNewLabel_9 = new JLabel("\uC218\uAC15\uC2DC\uCCAD\uC885\uB8CC:");
                    
                    DatePicker datePicker_1 = new DatePicker();
                    
                    JButton btnNewButton_1 = new JButton("\uC218  \uC815");
                    
                    JButton btnNewButton_2 = new JButton("\uC0AD  \uC81C");
                    
                    JLabel lblNewLabel_10 = new JLabel("New label");
                    
                    JLabel lblNewLabel_11 = new JLabel("New label");
                    
                    JLabel lblNewLabel_12 = new JLabel("New label");
                    
                    JLabel lblNewLabel_13 = new JLabel("New label");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(53)
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(67)
                                                                      .addComponent(btnNewButton))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(lblNewLabel_8)
                                                                      .addGap(18)
                                                                      .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(lblNewLabel_9)
                                                                      .addGap(18)
                                                                      .addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(btnNewButton_1)
                                                                      .addGap(31)
                                                                      .addComponent(btnNewButton_2)))
                                                  .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_7)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_3))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_5)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(comboBox_3, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_3)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_6)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_2))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_2)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_4)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                  .addGap(27)
                                                  .addComponent(lblNewLabel_10)
                                                  .addGap(45)
                                                  .addComponent(lblNewLabel_11)
                                                  .addGap(47)
                                                  .addComponent(lblNewLabel_12)
                                                  .addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                                  .addComponent(lblNewLabel_13)
                                                  .addGap(55))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(29)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(btnNewButton))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_10)
                                                            .addComponent(lblNewLabel_11)
                                                            .addComponent(lblNewLabel_12)
                                                            .addComponent(lblNewLabel_13))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_7)
                                                            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_8))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(lblNewLabel_9)
                                                            .addComponent(datePicker_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(btnNewButton_1)
                                                            .addComponent(btnNewButton_2))
                                                  .addGap(33))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uC218\uBC88\uD638", "\uC218\uAC15\uC774\uB984", "\uB2F4\uB2F9\uAD50\uC218", "\uB300\uC0C1\uD559\uB144", "\uD559\uAE30", "\uBD84\uBC18", "\uC815\uC6D0", "\uC2DC\uAC04/\uAC15\uC758\uC2E4", "\uC218\uAC15\uC2E0\uCCAD\uC77C\uC9DC"
                              }
                    ));
                    table.getColumnModel().getColumn(3).setPreferredWidth(73);
                    table.getColumnModel().getColumn(7).setPreferredWidth(101);
                    table.getColumnModel().getColumn(8).setPreferredWidth(108);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
          }
}
