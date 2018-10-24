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

import com.qujia.util.ViewUtil;

public class ScoreShowForProFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JTextField textField;
          private JTextField textField_1;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreShowForProFrm frame = new ScoreShowForProFrm();
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
          public ScoreShowForProFrm() {
                    setTitle("\uAD50\uC218 \uC131\uC801\uD655\uC778");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 754, 431);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAC15\uC758\uBA85:");
                    lblNewLabel.setBounds(32, 25, 59, 15);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4");
                    lblNewLabel_1.setBounds(88, 25, 116, 15);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD559\uC0DD\uBA85\uC218:");
                    lblNewLabel_2.setBounds(256, 25, 61, 15);
                    
                    JLabel lblNewLabel_3 = new JLabel("35");
                    lblNewLabel_3.setBounds(329, 25, 129, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 87, 713, 289);
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD559\uBC88:");
                    lblNewLabel_4.setBounds(44, 62, 47, 15);
                    
                    textField = new JTextField();
                    textField.setBounds(88, 59, 116, 21);
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC774\uB984:");
                    lblNewLabel_5.setBounds(279, 62, 38, 15);
                    
                    textField_1 = new JTextField();
                    textField_1.setBounds(329, 59, 129, 21);
                    textField_1.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uAC80 \uC0C9");
                    btnNewButton.setBounds(524, 58, 61, 23);
                    contentPane.setLayout(null);
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uBC88", "\uD559\uC0DD\uC774\uB984", "\uC911\uAC04\uACE0\uC0AC", "\uAE30\uB9D0\uACE0\uC0AC", "\uACFC\uC81C", "\uCD9C\uC11D", "\uAE30\uD0C0", "\uC131\uC801", "\uB4F1\uAE09", "\uC11D\uCC28", "\uC18C\uC18D\uD559\uACFC", "\uD559\uB144"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, true, false, true, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.add(scrollPane);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(lblNewLabel);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(textField);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(textField_1);
                    contentPane.add(btnNewButton);
                    contentPane.add(lblNewLabel_3);
          }
}
