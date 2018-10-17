package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class CourseArrangeManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JSpinner spinner_1, spinner_2, spinner_3, spinner_4,
          spinner_5, spinner_6, spinner_7,
          spinner_8, spinner_9, spinner_10,
          spinner_11, spinner_12;
          private JTextField textField_1;
          private JTextField textField_2;
          private JTextField textField_3;
          private JTextField textField;
          private JTextField textField_4;
          private JTextField textField_5;

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
                    
                    JLabel lblNewLabel = new JLabel("학수번호:");
                    lblNewLabel.setBounds(24, 24, 65, 15);
                    
                    JButton btnNewButton = new JButton("검  색");
                    btnNewButton.setBounds(686, 20, 94, 23);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 67, 830, 247);
                    
                    JLabel label = new JLabel("수강요일");
                    label.setBounds(17, 344, 65, 15);
                    
                    JCheckBox checkBox = new JCheckBox("월");
                    checkBox.setBounds(17, 385, 48, 23);
                    
                    JCheckBox checkBox_1 = new JCheckBox("화");
                    checkBox_1.setBounds(17, 418, 48, 23);
                    
                    JCheckBox checkBox_2 = new JCheckBox("수");
                    checkBox_2.setBounds(17, 450, 48, 23);
                    
                    JCheckBox checkBox_3 = new JCheckBox("목");
                    checkBox_3.setBounds(17, 482, 48, 23);
                    
                    JCheckBox checkBox_4 = new JCheckBox("금");
                    checkBox_4.setBounds(17, 510, 48, 23);
                    
                    JCheckBox checkBox_5 = new JCheckBox("토");
                    checkBox_5.setBounds(17, 542, 48, 23);
                    
                    JLabel label_1 = new JLabel("시작시간");
                    label_1.setBounds(89, 344, 91, 15);
                    
                    
                    // spinner_1_1.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_1 = new JSpinner(new SpinnerDateModel());
                    spinner_1.setBounds(87, 542, 93, 22);

                    spinner_2 = new JSpinner(new SpinnerDateModel());
                    spinner_2.setBounds(87, 510, 93, 22);

                    spinner_3 = new JSpinner(new SpinnerDateModel());
                    spinner_3.setBounds(87, 482, 93, 22);

                    spinner_4 = new JSpinner(new SpinnerDateModel());
                    spinner_4.setBounds(87, 450, 93, 22);

                    spinner_5 = new JSpinner(new SpinnerDateModel());
                    spinner_5.setBounds(87, 418, 93, 22);

                    spinner_6 = new JSpinner(new SpinnerDateModel());
                    spinner_6.setBounds(87, 386, 93, 22);

                    spinner_7 = new JSpinner(new SpinnerDateModel());
                    spinner_7.setBounds(255, 418, 102, 22);
                    // spinner_1_2.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_8= new JSpinner(new SpinnerDateModel());
                    spinner_8.setBounds(255, 386, 102, 22);

                    spinner_9 = new JSpinner(new SpinnerDateModel());
                    spinner_9.setBounds(255, 450, 102, 22);

                    spinner_10 = new JSpinner(new SpinnerDateModel());
                    spinner_10.setBounds(255, 482, 102, 22);

                    spinner_11 = new JSpinner(new SpinnerDateModel());
                    spinner_11.setBounds(255, 510, 102, 22);

                    spinner_12 = new JSpinner(new SpinnerDateModel());
                    spinner_12.setBounds(255, 542, 102, 22);
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
                    
                    JLabel label_2 = new JLabel("종료시간");
                    label_2.setBounds(270, 344, 65, 15);
                    
                    JLabel label_3 = new JLabel("강의실");
                    label_3.setBounds(408, 347, 116, 15);
                    
                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setBounds(375, 543, 149, 21);
                    
                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setBounds(375, 510, 149, 21);
                    
                    JComboBox comboBox_3 = new JComboBox();
                    comboBox_3.setBounds(375, 483, 149, 21);
                    
                    JComboBox comboBox_4 = new JComboBox();
                    comboBox_4.setBounds(375, 451, 149, 21);
                    
                    JComboBox comboBox_5 = new JComboBox();
                    comboBox_5.setBounds(375, 386, 149, 21);
                    
                    JComboBox comboBox_6 = new JComboBox();
                    comboBox_6.setBounds(375, 419, 149, 21);
                    
                    JLabel label_4 = new JLabel("담당교수:");
                    label_4.setBounds(568, 347, 65, 15);
                    
                    JLabel lblNewLabel_1 = new JLabel("대상학년:");
                    lblNewLabel_1.setBounds(568, 389, 66, 15);
                    
                    JComboBox comboBox_8 = new JComboBox();
                    comboBox_8.setBounds(646, 386, 116, 21);
                    
                    JLabel lblNewLabel_2 = new JLabel("학기:");
                    lblNewLabel_2.setBounds(591, 429, 43, 15);
                    
                    JComboBox comboBox_9 = new JComboBox();
                    comboBox_9.setBounds(646, 426, 116, 21);
                    
                    JLabel lblNewLabel_3 = new JLabel("분반:");
                    lblNewLabel_3.setBounds(591, 468, 43, 15);
                    
                    textField_1 = new JTextField();
                    textField_1.setBounds(646, 465, 116, 21);
                    textField_1.setColumns(10);
                    
                    JLabel lblNewLabel_4 = new JLabel("정원:");
                    lblNewLabel_4.setBounds(591, 513, 43, 15);
                    
                    textField_2 = new JTextField();
                    textField_2.setBounds(646, 510, 116, 21);
                    textField_2.setColumns(10);
                    
                    JButton btnNewButton_1 = new JButton("수 정");
                    btnNewButton_1.setBounds(375, 611, 91, 23);
                    btnNewButton_1.setBackground(new Color(224, 255, 255));
                    
                    JButton button = new JButton("삭 제");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                              }
                    });
                    button.setBounds(570, 611, 80, 23);
                    button.setBackground(new Color(255, 160, 122));
                    
                    JLabel lblNewLabel_5 = new JLabel("개폐상태:");
                    lblNewLabel_5.setBounds(568, 554, 66, 15);
                    
                    JComboBox comboBox_10 = new JComboBox();
                    comboBox_10.setBounds(646, 551, 116, 21);
                    comboBox_10.setModel(new DefaultComboBoxModel(new String[] {"", "개설", "폐강"}));
                    
                    textField_3 = new JTextField();
                    textField_3.setBounds(645, 344, 116, 21);
                    textField_3.setColumns(10);
                    
                    JButton btnNewButton_2 = new JButton("조회");
                    btnNewButton_2.setBounds(763, 343, 65, 23);
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAC1C\uD3D0\uC0C1\uD0DC", "\uD559\uC218\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uB2F4\uB2F9\uAD50\uC218", "\uB300\uC0C1\uD559\uB144", "\uD559\uAE30", "\uBD84\uBC18", "\uC815\uC6D0", "\uD604\uC708", "\uC2DC\uAC04/\uAC15\uC758\uC2E4"
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
                    contentPane.setLayout(null);
                    contentPane.add(textField_3);
                    contentPane.add(btnNewButton_2);
                    contentPane.add(lblNewLabel);
                    contentPane.add(btnNewButton);
                    contentPane.add(scrollPane);
                    contentPane.add(checkBox_2);
                    contentPane.add(spinner_4);
                    contentPane.add(spinner_9);
                    contentPane.add(comboBox_4);
                    contentPane.add(checkBox_3);
                    contentPane.add(spinner_3);
                    contentPane.add(spinner_10);
                    contentPane.add(comboBox_3);
                    contentPane.add(checkBox_4);
                    contentPane.add(spinner_2);
                    contentPane.add(spinner_11);
                    contentPane.add(comboBox_2);
                    contentPane.add(checkBox_5);
                    contentPane.add(spinner_1);
                    contentPane.add(spinner_12);
                    contentPane.add(comboBox_1);
                    contentPane.add(label);
                    contentPane.add(label_1);
                    contentPane.add(checkBox);
                    contentPane.add(spinner_6);
                    contentPane.add(spinner_8);
                    contentPane.add(comboBox_5);
                    contentPane.add(label_2);
                    contentPane.add(label_3);
                    contentPane.add(checkBox_1);
                    contentPane.add(spinner_5);
                    contentPane.add(spinner_7);
                    contentPane.add(comboBox_6);
                    contentPane.add(label_4);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(comboBox_10);
                    contentPane.add(textField_2);
                    contentPane.add(textField_1);
                    contentPane.add(comboBox_9);
                    contentPane.add(comboBox_8);
                    contentPane.add(btnNewButton_1);
                    contentPane.add(button);
                    
                    JLabel lblNewLabel_6 = new JLabel("교과목명:");
                    lblNewLabel_6.setBounds(244, 23, 65, 15);
                    contentPane.add(lblNewLabel_6);
                    
                    JLabel label_5 = new JLabel("담당교수:");
                    label_5.setBounds(473, 24, 65, 15);
                    contentPane.add(label_5);
                    
                    textField = new JTextField();
                    textField.setBounds(101, 20, 116, 21);
                    contentPane.add(textField);
                    textField.setColumns(10);
                    
                    textField_4 = new JTextField();
                    textField_4.setBounds(320, 21, 116, 21);
                    contentPane.add(textField_4);
                    textField_4.setColumns(10);
                    
                    textField_5 = new JTextField();
                    textField_5.setBounds(534, 21, 116, 21);
                    contentPane.add(textField_5);
                    textField_5.setColumns(10);
                    
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
