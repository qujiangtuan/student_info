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
                    setBounds(100, 100, 721, 311);
                    
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uC774\uB984:");
                    
                    JLabel label_1 = new JLabel("\uAE40 * *");
                    
                    JLabel lblNewLabel = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    
                    JLabel lblNewLabel_1 = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JButton button = new JButton("\uC218\uAC15\uD559\uC0DD\uB9AC\uC2A4\uD2B8");
                    
                    JButton btnNewButton = new JButton("\uC131\uC801\uD391\uAC00");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreEvalutionFrm sef=new ScoreEvalutionFrm();
                                        sef.setVisible(true);
                              }
                    });
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(20)
                                                                      .addComponent(label)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(label_1)
                                                                      .addGap(18)
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(lblNewLabel_1))
                                                            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(19)
                                                                      .addComponent(button)
                                                                      .addGap(18)
                                                                      .addComponent(btnNewButton)))
                                                  .addContainerGap())
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label)
                                                            .addComponent(label_1)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(lblNewLabel_1))
                                                  .addGap(18)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(button)
                                                            .addComponent(btnNewButton))
                                                  .addContainerGap(116, Short.MAX_VALUE))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(30);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAC1C\uC124\uD559\uACFC", "\uC774\uC218\uAD6C\uBD84", "\uAD50\uACFC\uBAA9\uBA70\uBC88\uD638", "\uBD84\uBC18", "\uAD50\uACFC\uBAA9\uBA85", "\uD559\uC810", "\uAC15\uC758\uAE30\uAC04"
                              }
                    ));
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
          }

}
