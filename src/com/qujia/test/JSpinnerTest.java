package com.qujia.test;

import java.awt.EventQueue;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

public class JSpinnerTest extends JFrame {

          private JPanel contentPane;
          /**
           * @wbp.nonvisual location=21,-3
           */
          private final JSpinner spinner = new JSpinner();

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  JSpinnerTest frame = new JSpinnerTest();
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
          public JSpinnerTest() {
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 450, 300);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    SpinnerDateModel model = new SpinnerDateModel();
                    JSpinner spinner_1 = new JSpinner(model);
                    this.setTime(spinner_1);
                    
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(35)
                                                  .addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(302, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(35)
                                                  .addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(194, Short.MAX_VALUE))
                    );
                    contentPane.setLayout(gl_contentPane);
          }

          private void setTime(JSpinner spinner) {
                    // TODO Auto-generated method stub
                    
                    //获得JSPinner对象
                   // JSpinner spinner_1 = new JSpinner(model);
                    spinner.setValue(new Date());
                    //设置时间格式
                    JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner,"HH:mm");
                    spinner.setEditor(editor);
          }

}
