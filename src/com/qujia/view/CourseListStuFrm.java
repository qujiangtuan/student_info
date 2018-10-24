package com.qujia.view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class CourseListStuFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;

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
                    setBounds(100, 100, 649, 348);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 47, 613, 168);
                    contentPane.add(scrollPane);
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, "", null},
                              },
                              new String[] {
                                        "\uD559\uC218\uBC88\uD638", "\uACFC\uBAA9\uBA85", "\uB2F4\uB2F9\uAD50\uC218", "\uD559\uC810", "\uC774\uC218\uAD6C\uBD84", "\uC2DC\uAC04/\uAC15\uC758\uC2E4", "\uAC15\uC758\uACC4\uD68D\uC11C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, true, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(2).setPreferredWidth(120);
                    table.getColumnModel().getColumn(3).setPreferredWidth(67);
                    table.getColumnModel().getColumn(4).setPreferredWidth(78);
                    table.getColumnModel().getColumn(5).setPreferredWidth(220);
                    table.getColumnModel().getColumn(6).setPreferredWidth(119);
                    scrollPane.setViewportView(table);
                    
                    JLabel lblNewLabel = new JLabel("\uC774\uB984:");
                    lblNewLabel.setBounds(40, 10, 54, 15);
                    contentPane.add(lblNewLabel);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uAE40\uC0C1\uBBFC");
                    lblNewLabel_1.setBounds(93, 10, 220, 15);
                    contentPane.add(lblNewLabel_1);
                    
                    JButton btnNewButton = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uB2E4\uC6B4\uB85C\uB4DC");
                    btnNewButton.setBounds(391, 240, 161, 23);
                    contentPane.add(btnNewButton);
          }
}
