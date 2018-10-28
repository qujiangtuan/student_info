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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class LectureOfProFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_2;
          private JTable table;
          private JTextField textField;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  LectureOfProFrm frame = new LectureOfProFrm();
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
          public LectureOfProFrm() {
                    this.setResizable(false);
                    setTitle("\uAC15\uC758\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 742, 372);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JButton btnNewButton = new JButton("\uAC80 \uC0C9");
                    btnNewButton.setBounds(604, 15, 84, 23);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC218\uBA85:");
                    lblNewLabel_2.setBounds(33, 19, 54, 15);
                    
                    textField_2 = new JTextField();
                    textField_2.setBounds(92, 16, 192, 21);
                    textField_2.setColumns(10);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 48, 696, 232);
                    
                    JLabel lblNewLabel = new JLabel("\uAC15\uC758\uBA85:");
                    lblNewLabel.setBounds(296, 19, 55, 15);
                    
                    textField = new JTextField();
                    textField.setBounds(363, 16, 181, 21);
                    textField.setColumns(10);
                    
                    JButton btnNewButton_1 = new JButton("\uB2EC \uAE30");
                    btnNewButton_1.setBounds(629, 298, 84, 23);
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAC15\uC758\uBC88\uD638", "\uAD50\uC6D0\uBC88\uD638", "\uAD50\uC218\uBA85", "\uAC15\uC758\uBA85", "\uBD84\uBC18", "\uD559\uC810", "\uC2DC\uAC04/\uAC15\uC758\uC2E4"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(2).setPreferredWidth(84);
                    table.getColumnModel().getColumn(3).setPreferredWidth(181);
                    table.getColumnModel().getColumn(4).setPreferredWidth(56);
                    table.getColumnModel().getColumn(5).setPreferredWidth(63);
                    table.getColumnModel().getColumn(6).setPreferredWidth(191);
                    contentPane.setLayout(null);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.add(scrollPane);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(textField_2);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField);
                    contentPane.add(btnNewButton);
                    contentPane.add(btnNewButton_1);
          }
}
