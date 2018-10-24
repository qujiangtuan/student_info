package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class CourseListProFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseListProFrm frame = new CourseListProFrm();
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
          public CourseListProFrm() {
                    setTitle("\uAC15\uC758\uBAA9\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 742, 334);
                    
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uC774\uB984:");
                    label.setBounds(25, 15, 56, 15);
                    
                    JLabel label_1 = new JLabel("\uAE40 * *");
                    label_1.setBounds(93, 15, 99, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(5, 48, 715, 167);
                    
                    JButton button = new JButton("\uC131\uC801\uD655\uC778");
                    button.setBounds(24, 233, 81, 23);
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreShowForProFrm ssfp=new ScoreShowForProFrm();
                                        ssfp.setVisible(true);
                              }
                    });
                    
                    JButton btnNewButton = new JButton("\uC131\uC801\uD391\uAC00");
                    btnNewButton.setBounds(123, 233, 81, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreEvalutionFrm sef=new ScoreEvalutionFrm();
                                        sef.setVisible(true);
                              }
                    });
                    
                    JButton btnNewButton_1 = new JButton("\uB2E4\uC6B4\uB85C\uB4DC");
                    btnNewButton_1.setBounds(479, 233, 89, 23);
                    
                    JButton button_1 = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uC5C5\uB85C\uB4DC");
                    button_1.setBounds(313, 233, 148, 23);
                    
                    JButton btnNewButton_2 = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uC0AD\uC81C");
                    btnNewButton_2.setBounds(586, 233, 121, 23);
                    
                    table = new JTable();
                    table.setRowHeight(30);
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
                              },
                              new String[] {
                                        "\uAC1C\uC124\uD559\uACFC", "\uC774\uC218\uAD6C\uBD84", "\uD559\uC218\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uD559\uC810", "\uC2DC\uAC04/\uAC15\uC758\uC2E4", "\uAC15\uC758\uD3C9\uAC00\uACB0\uACFC", "\uAC15\uC758\uACC4\uD68D\uC11C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(2).setPreferredWidth(82);
                    table.getColumnModel().getColumn(6).setPreferredWidth(90);
                    table.getColumnModel().getColumn(7).setPreferredWidth(110);
                    table.getColumnModel().getColumn(8).setPreferredWidth(95);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(label);
                    contentPane.add(label_1);
                    contentPane.add(button);
                    contentPane.add(btnNewButton);
                    contentPane.add(button_1);
                    contentPane.add(btnNewButton_1);
                    contentPane.add(btnNewButton_2);
                    contentPane.add(scrollPane);
          }

}
