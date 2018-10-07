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
                    
                    JLabel lblNewLabel_1 = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4");
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD559\uC0DD\uBA85\uC218:");
                    
                    JLabel lblNewLabel_3 = new JLabel("35");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD559\uBC88:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC774\uB984:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uAC80 \uC0C9");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(31)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(lblNewLabel_4)
                                                                                .addComponent(lblNewLabel))
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(61)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(lblNewLabel_5))
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(66)
                                                                                          .addComponent(btnNewButton))
                                                                                .addComponent(lblNewLabel_3))))
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(20)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(lblNewLabel_3))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton))
                                                  .addGap(28)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(19, Short.MAX_VALUE))
                    );
                    
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
                    contentPane.setLayout(gl_contentPane);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          }
}
