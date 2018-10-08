package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
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
                    
                    JLabel label_1 = new JLabel("\uAE40 * *");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JButton button = new JButton("\uC131\uC801\uD655\uC778");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreShowForProFrm ssfp=new ScoreShowForProFrm();
                                        ssfp.setVisible(true);
                              }
                    });
                    
                    JButton btnNewButton = new JButton("\uC131\uC801\uD391\uAC00");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreEvalutionFrm sef=new ScoreEvalutionFrm();
                                        sef.setVisible(true);
                              }
                    });
                    
                    JButton btnNewButton_1 = new JButton("\uB2E4\uC6B4\uB85C\uB4DC");
                    
                    JButton button_1 = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uC5C5\uB85C\uB4DC");
                    
                    JButton btnNewButton_2 = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uC0AD\uC81C");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(20)
                                                                      .addComponent(label)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(label_1))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(19)
                                                                      .addComponent(button)
                                                                      .addGap(18)
                                                                      .addComponent(btnNewButton)
                                                                      .addGap(109)
                                                                      .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(18)
                                                                      .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(18)
                                                                      .addComponent(btnNewButton_2))
                                                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 715, GroupLayout.PREFERRED_SIZE))
                                                  .addContainerGap(34, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label)
                                                            .addComponent(label_1))
                                                  .addGap(18)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(button)
                                                            .addComponent(btnNewButton)
                                                            .addComponent(button_1)
                                                            .addComponent(btnNewButton_1)
                                                            .addComponent(btnNewButton_2))
                                                  .addContainerGap(34, Short.MAX_VALUE))
                    );
                    
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
                                        "\uAC1C\uC124\uD559\uACFC", "\uC774\uC218\uAD6C\uBD84", "\uD559\uC218\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uD559\uC810", "\uAE30\uAC04/\uAC15\uC758\uC2E4", "\uAC15\uC758\uD3C9\uAC00\uACB0\uACFC", "\uAC15\uC758\uACC4\uD68D\uC11C"
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
                    contentPane.setLayout(gl_contentPane);
          }

}
