package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class ScoreShowToAdminFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField;
          private JTextField textField_1;
          private JTable table_student;
          private JTable table_score;
          private JTable table_credit;
          private JPanel panel_score,panel_credit,panel_card;
          private JButton scoreButton,creditButton;
          private CardLayout card;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreShowToAdminFrm frame = new ScoreShowToAdminFrm();
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
          public ScoreShowToAdminFrm() {
                    setTitle("\uC131\uC801\uD559\uC810\uD655\uC778");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 738, 515);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uD559\uC0DD\uC774\uB984:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uBC88:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JButton searchStuButton = new JButton("\uC870 \uD68C");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD559\uC0DD\uC774\uB984:");
                    
                    JLabel lblNewLabel_3 = new JLabel("\uCDE8 \uC9C0\uC559\uD22C\uC548");
                    
                    scoreButton = new JButton("\uC131\uC801\uD655\uC778");
                    scoreButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        card.show(panel_card, "panel_score");
                              }
                    });
                    
                    creditButton = new JButton("\uD559\uC810\uD655\uC778");
                    creditButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        card.show(panel_card, "panel_credit");
                              }
                    });
                    
                    panel_card = new JPanel();
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(46)
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(75)
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(57)
                                                                      .addComponent(searchStuButton))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(48)
                                                                      .addComponent(lblNewLabel_2)
                                                                      .addGap(18)
                                                                      .addComponent(lblNewLabel_3)
                                                                      .addGap(152)
                                                                      .addComponent(scoreButton)
                                                                      .addGap(18)
                                                                      .addComponent(creditButton))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(30)
                                                                      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 645, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(panel_card, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)))
                                                  .addContainerGap(11, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(20)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchStuButton))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(26)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(scoreButton)
                                                            .addComponent(creditButton))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(panel_card, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(53, Short.MAX_VALUE))
                    );
                    card=new CardLayout(0, 0);
                    panel_card.setLayout(card);
                    
                    panel_score = new JPanel();
                    panel_score.setBackground(new Color(255, 248, 220));
                    panel_card.add(panel_score, "panel_score");
                    
                    JScrollPane scrollPane_score = new JScrollPane();
                    GroupLayout gl_panel_score = new GroupLayout(panel_score);
                    gl_panel_score.setHorizontalGroup(
                              gl_panel_score.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_score.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_score, GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    gl_panel_score.setVerticalGroup(
                              gl_panel_score.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_panel_score.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_score, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    
                    table_score = new JTable();
                    scrollPane_score.setViewportView(table_score);
                    table_score.setRowHeight(25);
                    table_score.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uB144\uB3C4/\uD559\uAE30", "\uD559\uC218\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uC774\uC218\uAD6C\uBD84", "\uD559\uC810", "\uB4F1\uAE09", "\uC131\uC801\uC720\uD6A8\uAD6C\uBD84", "\uBE44\uACE0"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_score.getColumnModel().getColumn(6).setPreferredWidth(98);
                    panel_score.setLayout(gl_panel_score);
                    
                    panel_credit = new JPanel();
                    panel_credit.setBackground(new Color(176, 224, 230));
                    panel_card.add(panel_credit, "panel_credit");
                    
                    JScrollPane scrollPane_credit = new JScrollPane();
                    GroupLayout gl_panel_credit = new GroupLayout(panel_credit);
                    gl_panel_credit.setHorizontalGroup(
                              gl_panel_credit.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_credit.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_credit, GroupLayout.PREFERRED_SIZE, 677, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    gl_panel_credit.setVerticalGroup(
                              gl_panel_credit.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_credit.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_credit, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    
                    table_credit = new JTable();
                    table_credit.setRowHeight(25);
                    table_credit.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {"\uD559\uACFC\uAE30\uC874\uD559\uC810 ", null, null, null, null, null, null, null},
                                        {"\uC774\uC218 \uD559\uC810", null, null, null, null, null, null, null},
                                        {"\uBBF8\uC218 \uD559\uC810 ", null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC878\uC5C5\uC774\uC218\uD559\uC810", "\uC804\uACF5\uC774\uC218\uD559\uC810", "\uC804\uACF5\uD544\uC218\uD559\uC810", "\uC804\uACF5\uC120\uD0DD\uD559\uC810", "\uAD50\uC591\uC774\uC218\uD559\uC810", "\uAD50\uC591\uD544\uC218\uD559\uC810", "\uAD50\uC591\uC120\uD0DD\uD559\uC810", "\uD569\uACC4"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        true, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_credit.getColumnModel().getColumn(0).setPreferredWidth(95);
                    table_credit.getColumnModel().getColumn(1).setPreferredWidth(95);
                    table_credit.getColumnModel().getColumn(2).setPreferredWidth(100);
                    table_credit.getColumnModel().getColumn(3).setPreferredWidth(93);
                    table_credit.getColumnModel().getColumn(4).setPreferredWidth(95);
                    table_credit.getColumnModel().getColumn(5).setPreferredWidth(94);
                    table_credit.getColumnModel().getColumn(6).setPreferredWidth(99);
                    scrollPane_credit.setViewportView(table_credit);
                    panel_credit.setLayout(gl_panel_credit);
                    
                    table_student = new JTable();
                    table_student.setRowHeight(25);
                    table_student.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uBC88", "\uC774\uB984", "\uC18C\uC18D\uD559\uACFC", "\uD559\uB144", "\uD559\uC0AC\uACFC\uC815"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    scrollPane.setViewportView(table_student);
                    contentPane.setLayout(gl_contentPane);
          }
}
