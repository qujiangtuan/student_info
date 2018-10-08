package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class CourseArrangeManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTable table;
          private JSpinner spinner_1, spinner_2, spinner_3, spinner_4,
          spinner_5, spinner_6, spinner_7,
          spinner_8, spinner_9, spinner_10,
          spinner_11, spinner_12, spinner_13,
          spinner_14;
          private JTextField textField_1;
          private JTextField textField_2;

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
          	setTitle("개설교과목관리");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 880, 683);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC218\uAC15\uC774\uB984/\uD559\uC218\uBC88\uD638/\uAD50\uC218\uC774\uB984:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JButton btnNewButton = new JButton("검  색");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel label = new JLabel("수강요일");
                    
                    JCheckBox checkBox = new JCheckBox("월");
                    
                    JCheckBox checkBox_1 = new JCheckBox("화");
                    
                    JCheckBox checkBox_2 = new JCheckBox("수");
                    
                    JCheckBox checkBox_3 = new JCheckBox("목");
                    
                    JCheckBox checkBox_4 = new JCheckBox("금");
                    
                    JCheckBox checkBox_5 = new JCheckBox("토");
                    
                    JCheckBox checkBox_6 = new JCheckBox("일");
                    
                    JLabel label_1 = new JLabel("시작시간");
                    
                    
                    // spinner_1_1.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_1 = new JSpinner(new SpinnerDateModel());

                    spinner_2 = new JSpinner(new SpinnerDateModel());

                    spinner_3 = new JSpinner(new SpinnerDateModel());

                    spinner_4 = new JSpinner(new SpinnerDateModel());

                    spinner_5 = new JSpinner(new SpinnerDateModel());

                    spinner_6 = new JSpinner(new SpinnerDateModel());

                    spinner_7 = new JSpinner(new SpinnerDateModel());
                    // spinner_1_2.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_8= new JSpinner(new SpinnerDateModel());

                    spinner_9 = new JSpinner(new SpinnerDateModel());

                    spinner_10 = new JSpinner(new SpinnerDateModel());

                    spinner_11 = new JSpinner(new SpinnerDateModel());

                    spinner_12 = new JSpinner(new SpinnerDateModel());

                    spinner_13 = new JSpinner(new SpinnerDateModel());
                    spinner_14 = new JSpinner(new SpinnerDateModel());
                    this.setMyModel(spinner_1);
                    this.setMyModel(spinner_2);
                    this.setMyModel(spinner_3);
                    this.setMyModel(spinner_4);
                    this.setMyModel(spinner_5);
                    this.setMyModel(spinner_6);
                    this.setMyModel(spinner_7);
                    this.setMyModel(spinner_8);
                    this.setMyModel(spinner_9);
                    this.setMyModel(spinner_10);
                    this.setMyModel(spinner_11);
                    this.setMyModel(spinner_12);
                    this.setMyModel(spinner_13);
                    this.setMyModel(spinner_14);
                    
                    JLabel label_2 = new JLabel("끝나시간");
                    
                    JLabel label_3 = new JLabel("강의실");
                    
                    JComboBox comboBox = new JComboBox();
                    
                    JComboBox comboBox_1 = new JComboBox();
                    
                    JComboBox comboBox_2 = new JComboBox();
                    
                    JComboBox comboBox_3 = new JComboBox();
                    
                    JComboBox comboBox_4 = new JComboBox();
                    
                    JComboBox comboBox_5 = new JComboBox();
                    
                    JComboBox comboBox_6 = new JComboBox();
                    
                    JLabel label_4 = new JLabel("담당교수:");
                    
                    JComboBox comboBox_7 = new JComboBox();
                    
                    JLabel lblNewLabel_1 = new JLabel("대상학년:");
                    
                    JComboBox comboBox_8 = new JComboBox();
                    
                    JLabel lblNewLabel_2 = new JLabel("학기:");
                    
                    JComboBox comboBox_9 = new JComboBox();
                    
                    JLabel lblNewLabel_3 = new JLabel("분반:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JLabel lblNewLabel_4 = new JLabel("정원:");
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    JButton btnNewButton_1 = new JButton("수 정");
                    btnNewButton_1.setBackground(new Color(224, 255, 255));
                    
                    JButton button = new JButton("삭 제");
                    button.setBackground(new Color(255, 160, 122));
                    
                    JLabel lblNewLabel_5 = new JLabel("상태:");
                    
                    JComboBox comboBox_10 = new JComboBox();
                    comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"", "계설", "폐강"}));
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
                                                                      .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(checkBox_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(22)
                                                                                          .addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(75)
                                                                                          .addComponent(spinner_9, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(18)
                                                                                          .addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(checkBox_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(22)
                                                                                          .addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(75)
                                                                                          .addComponent(spinner_10, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(18)
                                                                                          .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(checkBox_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(22)
                                                                                          .addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(75)
                                                                                          .addComponent(spinner_11, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(18)
                                                                                          .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(checkBox_5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(22)
                                                                                          .addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(75)
                                                                                          .addComponent(spinner_12, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(18)
                                                                                          .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                                                  .addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                  .addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                                                  .addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addGap(22)
                                                                                                                                  .addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
                                                                                                              .addGap(75)
                                                                                                              .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                                                  .addComponent(spinner_8, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addGap(18)
                                                                                                                                  .addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
                                                                                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                                                  .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                                                                                                                  .addGap(40)
                                                                                                                                  .addComponent(label_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addComponent(checkBox_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                                                              .addGap(22)
                                                                                                              .addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                                                              .addGap(75)
                                                                                                              .addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                                              .addGap(18)
                                                                                                              .addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
                                                                                          .addGap(49)
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addGap(8)
                                                                                                              .addComponent(label_4)
                                                                                                              .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                              .addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addGap(9)
                                                                                                              .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                                                        .addComponent(lblNewLabel_4)
                                                                                                                        .addComponent(lblNewLabel_2)
                                                                                                                        .addComponent(lblNewLabel_1)
                                                                                                                        .addComponent(lblNewLabel_3)
                                                                                                                        .addComponent(lblNewLabel_5))
                                                                                                              .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                                        .addComponent(comboBox_10, 0, 135, Short.MAX_VALUE)
                                                                                                                        .addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                                                                                        .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                                                                                        .addComponent(comboBox_9, 0, 135, Short.MAX_VALUE)
                                                                                                                        .addComponent(comboBox_8, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(checkBox_6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(22)
                                                                                          .addComponent(spinner_14, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(75)
                                                                                          .addComponent(spinner_13, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(18)
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addComponent(btnNewButton_1)
                                                                                                              .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                              .addComponent(button, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))))))
                                                  .addContainerGap())
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
                                                  .addGap(30)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(label_2)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_3)
                                                                      .addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(label_4))
                                                            .addComponent(label)
                                                            .addComponent(label_1))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(checkBox)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(1)
                                                                      .addComponent(spinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(1)
                                                                      .addComponent(spinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(1)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(10)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(checkBox_1)
                                                                                .addComponent(spinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(1)
                                                                                          .addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGap(9)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(checkBox_2)
                                                                                .addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(1)
                                                                                          .addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGap(9)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(checkBox_3)
                                                                                .addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(1)
                                                                                          .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGap(5)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(checkBox_4)
                                                                                .addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                          .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                          .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                          .addComponent(lblNewLabel_4))))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(9)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(checkBox_5)
                                                                                .addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(1)
                                                                                          .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGap(5)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(checkBox_6)
                                                                                .addComponent(spinner_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(1)
                                                                                          .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(btnNewButton_1)
                                                                                .addComponent(button)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_5)
                                                                                .addComponent(comboBox_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC0C1\uD0DC", "\uD559\uC218\uBC88\uD638", "\uACFC\uBAA9\uC774\uB984", "\uB2F4\uB2F9\uAD50\uC218", "\uB300\uC0C1\uD559\uB144", "\uD559\uAE30", "\uBD84\uBC18", "\uC815\uC6D0", "\uD604\uC708", "\uC2DC\uAC04/\uAC15\uC758\uC2E4"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(2).setPreferredWidth(127);
                    table.getColumnModel().getColumn(4).setPreferredWidth(73);
                    table.getColumnModel().getColumn(9).setPreferredWidth(146);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(gl_contentPane);
                    
          }

		 // 设置jspinner 类型方法
          private void setMyModel(JSpinner spinner) {
                    spinner.setValue(new Date());
                    // 设置时间格式
                    JSpinner.DateEditor editor = new JSpinner.DateEditor(
                                        spinner, "HH:mm");
                    spinner.setEditor(editor);
          }
}
