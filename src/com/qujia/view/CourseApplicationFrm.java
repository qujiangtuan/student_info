package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.qujia.util.ViewUtil;
 
 
public class CourseApplicationFrm extends JFrame {
    private JPanel panel_one;
    private JPanel panel_one_button;
    private CardLayout card = null; // CardLayout布局管理器
    private CardLayout card_2=null;
    
    private JButton b_1 = null, b_2 = null, b_3 = null; // 三个可直接翻转到JPanel组件的按钮
    private JPanel p_1 = null, p_2 = null, p_3 = null; // 要切换的三个JPanel
    private JTable table;
    private JPanel panel_two_button;
    private JButton button_no= null,button_self= null,button_liberal= null,button_other= null,button_master= null;
    private JPanel panel_1= null,panel_2= null,panel_3= null,panel_4= null;
    private JPanel panel_two;
    private JLabel label;
    private JScrollPane scrollPane_list_no;
    private JTextField textField;
    private JPanel panel_5;
    private JScrollPane scrollPane_1;
    private JScrollPane scrollPane_3;
    private JTable schedule;
    private JTable table_show;
    private JTable table_1;
    private JTable table_2;
    private JTable table_3;
    private JTable table_4;
    private JLabel label_avg2;
    private JLabel lblNewLabel;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel lblNewLabel_1;
    private JTextField searchField;
   
    public CourseApplicationFrm() {
        super("CardLayout Test");
        setTitle("수강신청");
        
        try {
            // 将LookAndFeel设置成Windows样式
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                  card= new CardLayout(5, 5);
                 //panel_two = new JPanel(card); 
                 
                  
                   
                    panel_one_button = new JPanel();
                    b_1 = new JButton("수강신청 목록");
                    b_1.setBackground(new Color(255, 218, 185));
                    b_2 = new JButton("시간표");
                    b_2.setBackground(new Color(224, 255, 255));
                    b_3 = new JButton("수강신청확인서");
                    b_3.setBackground(new Color(219, 112, 147));
                    b_1.addActionListener(new ActionListener() { // 直接翻转到p_1
                        public void actionPerformed(ActionEvent e) {
                                  card.show(panel_one, "p1");
                        }
                    });
                    b_2.addActionListener(new ActionListener() { // 直接翻转到p_2
                        public void actionPerformed(ActionEvent e) {
                            card.show(panel_one, "p2");
                        }
                    });
                    b_3.addActionListener(new ActionListener() { // 直接翻转到p_3
                        public void actionPerformed(ActionEvent e) {
                            card.show(panel_one, "p3");
                        }
                    });
                    
                    label_5 = new JLabel("이름:");
                    
                    lblNewLabel_1 = new JLabel("오준택");
                    GroupLayout gl_panel_one_button = new GroupLayout(panel_one_button);
                    gl_panel_one_button.setHorizontalGroup(
                              gl_panel_one_button.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_one_button.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(b_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(b_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(62)
                                                  .addComponent(label_5)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(lblNewLabel_1)
                                                  .addGap(209)
                                                  .addComponent(b_3)
                                                  .addGap(26))
                    );
                    gl_panel_one_button.setVerticalGroup(
                              gl_panel_one_button.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_one_button.createSequentialGroup()
                                                  .addGap(5)
                                                  .addGroup(gl_panel_one_button.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(b_1)
                                                            .addComponent(b_3)
                                                            .addComponent(b_2)
                                                            .addComponent(label_5)
                                                            .addComponent(lblNewLabel_1))
                                                  .addContainerGap())
                    );
                    panel_one_button.setLayout(gl_panel_one_button);
                  
                   
                   panel_one = new JPanel(card); // JPanel的布局管理将被设置成CardLayout
                   //        b_1.setMargin(new Insets(2,2,2,2));
                   //        b_2.setMargin(new Insets(2,2,2,2));
                   //        b_3.setMargin(new Insets(2,2,2,2));
                           p_1 = new JPanel();
                           p_2 = new JPanel();
                           p_3 = new JPanel();
                           p_1.setBackground(new Color(255, 218, 185));
                           p_2.setBackground(new Color(224, 255, 255));
                           p_3.setBackground(new Color(221, 160, 221));
                           panel_one.add(p_1, "p1");
                           
                           JLabel label_apply_list = new JLabel("수강신청");
                           
                           JScrollPane scrollPane = new JScrollPane();
                           GroupLayout gl_p_1 = new GroupLayout(p_1);
                           gl_p_1.setHorizontalGroup(
                                     gl_p_1.createParallelGroup(Alignment.LEADING)
                                               .addGroup(gl_p_1.createSequentialGroup()
                                                         .addContainerGap()
                                                         .addGroup(gl_p_1.createParallelGroup(Alignment.LEADING)
                                                                   .addComponent(label_apply_list)
                                                                   .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE))
                                                         .addContainerGap())
                           );
                           gl_p_1.setVerticalGroup(
                                     gl_p_1.createParallelGroup(Alignment.LEADING)
                                               .addGroup(gl_p_1.createSequentialGroup()
                                                         .addContainerGap()
                                                         .addComponent(label_apply_list)
                                                         .addPreferredGap(ComponentPlacement.RELATED)
                                                         .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                         .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                           );
                           
                           table = new JTable();
                           table.setModel(new DefaultTableModel(
                                     new Object[][] {
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null},
                                     },
                                     new String[] {
                                               "학수번호", "분반", "과목명", "취득학점", "담당교수", "교과구분", "강의시간", "강의실"
                                     }
                           ));
                           table.setRowHeight(35);
                           scrollPane.setViewportView(table);
           
                           p_1.setLayout(gl_p_1);
                           panel_one.add(p_2, "p2");
                           
                           scrollPane_3 = new JScrollPane();
                           GroupLayout gl_p_2 = new GroupLayout(p_2);
                           gl_p_2.setHorizontalGroup(
                                     gl_p_2.createParallelGroup(Alignment.LEADING)
                                               .addGroup(gl_p_2.createSequentialGroup()
                                                         .addContainerGap()
                                                         .addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 745, Short.MAX_VALUE)
                                                         .addContainerGap())
                           );
                           gl_p_2.setVerticalGroup(
                                     gl_p_2.createParallelGroup(Alignment.LEADING)
                                               .addGroup(gl_p_2.createSequentialGroup()
                                                         .addGap(5)
                                                         .addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                         .addContainerGap())
                           );
                           
                           schedule = new JTable();
                           schedule.setModel(new DefaultTableModel(
                                     new Object[][] {
                                               {"1교시", "09:00", "데이터베이스", null, null, null, null, null, null},
                                               {"2교시", "10:00", "데이터베이스", null, null, null, null, null, null},
                                               {"3교시", "11:00", "데이터베이스", null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
                                               {null, null, null, null, null, null, null, null, null},
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
                                               "교시", "시간", "월", "화", "수", "목", "금", "토", "일"
                                     }
                           ));
                           scrollPane_3.setViewportView(schedule);
                           p_2.setLayout(gl_p_2);
                           panel_one.add(p_3, "p3");
                           
                           JScrollPane scrollPane_show = new JScrollPane();
                           GroupLayout gl_p_3 = new GroupLayout(p_3);
                           gl_p_3.setHorizontalGroup(
                                     gl_p_3.createParallelGroup(Alignment.LEADING)
                                               .addGroup(Alignment.TRAILING, gl_p_3.createSequentialGroup()
                                                         .addContainerGap()
                                                         .addComponent(scrollPane_show, GroupLayout.PREFERRED_SIZE, 745, Short.MAX_VALUE)
                                                         .addContainerGap())
                           );
                           gl_p_3.setVerticalGroup(
                                     gl_p_3.createParallelGroup(Alignment.LEADING)
                                               .addGroup(gl_p_3.createSequentialGroup()
                                                         .addGap(5)
                                                         .addComponent(scrollPane_show, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                         .addContainerGap())
                           );
                           
                           table_show = new JTable();
                           table_show.setModel(new DefaultTableModel(
                                     new Object[][] {
                                               {null, null, null, null, null, null, null, null, null, "", null},
                                     },
                                     new String[] {
                                    		 "삭제", "구분", "학수번호", "분반 ", "과목명 ", "학점 ", "담당교수", " 시간/강의실"
                            		 }
                           ));
                           scrollPane_show.setViewportView(table_show);
                           p_3.setLayout(gl_p_3);
                  
                 
                  panel_two = new JPanel((LayoutManager) null);
                  card_2=new CardLayout(5, 5);
                  panel_two.setLayout(card_2);
                  
                  JPanel panel_show = new JPanel();
                  panel_show.setBackground(Color.PINK);
                  panel_two_button = new JPanel();
                  
                  button_no = new JButton("학수번호");
                  button_no.setMargin(new Insets(2, 2, 2, 2));
                  button_no.setBackground(new Color(230, 230, 250));
                  button_no.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                      card_2.show(panel_two,"panel_1");
                            }
                  });
                  
                  button_self = new JButton("자과과목");
                  button_self.setBackground(new Color(189, 183, 107));
                  button_self.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                      card_2.show(panel_two, "panel_2");
                            }
                  });
                  button_other = new JButton("타과과목");
                  button_other.setMargin(new Insets(2, 2, 2, 2));
                  button_other.setBackground(new Color(102, 205, 170));
                  button_other.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                      card_2.show(panel_two,"panel_4");
                            }
                  });
                  
                  button_liberal = new JButton("교양과목");
                  button_liberal.setMargin(new Insets(2, 2, 2, 2));
                  button_liberal.setBackground(new Color(65, 105, 225));
                  button_liberal.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                      card_2.show(panel_two,"panel_3");
                            }
                  });
                  
                 button_master = new JButton("석사과목");
                 button_master.setMargin(new Insets(2, 2, 2, 2));
                 button_master.setBackground(new Color(135, 206, 235));
                 button_master.addActionListener(new ActionListener() {
                           public void actionPerformed(ActionEvent e) {
                                     card_2.show(panel_two,"panel_5");
                           }
                 });
                 GroupLayout gl_panel_two_button = new GroupLayout(panel_two_button);
                 gl_panel_two_button.setHorizontalGroup(
                           gl_panel_two_button.createParallelGroup(Alignment.LEADING)
                                     .addGroup(gl_panel_two_button.createSequentialGroup()
                                               .addGap(10)
                                               .addComponent(button_no, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                               .addGap(10)
                                               .addComponent(button_self)
                                               .addPreferredGap(ComponentPlacement.UNRELATED)
                                               .addComponent(button_liberal, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                               .addPreferredGap(ComponentPlacement.UNRELATED)
                                               .addComponent(button_other, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                               .addPreferredGap(ComponentPlacement.UNRELATED)
                                               .addComponent(button_master, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                               .addGap(299))
                 );
                 gl_panel_two_button.setVerticalGroup(
                           gl_panel_two_button.createParallelGroup(Alignment.LEADING)
                                     .addGroup(gl_panel_two_button.createSequentialGroup()
                                               .addGap(5)
                                               .addGroup(gl_panel_two_button.createParallelGroup(Alignment.LEADING)
                                                         .addGroup(gl_panel_two_button.createParallelGroup(Alignment.BASELINE)
                                                                   .addComponent(button_self)
                                                                   .addComponent(button_liberal)
                                                                   .addComponent(button_other)
                                                                   .addComponent(button_master))
                                                         .addComponent(button_no))
                                               .addContainerGap())
                 );
                 panel_two_button.setLayout(gl_panel_two_button);
                  
                  
                  JLabel label_avg = new JLabel("직전학기평점평균:");
                  
                  JLabel label_apply_maybe = new JLabel("신청가능학점:");
                  
                  JLabel label_apply = new JLabel("신청학점:");
                  
                  JLabel label_countsOfCourse = new JLabel("신청과목수:");
                  
                  label_avg2 = new JLabel("3.5");
                  
                  lblNewLabel = new JLabel("18");
                  
                  label_3 = new JLabel("15");
                  
                  label_4 = new JLabel("5");
                  GroupLayout gl_panel_show = new GroupLayout(panel_show);
                  gl_panel_show.setHorizontalGroup(
                            gl_panel_show.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_show.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(label_avg)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(label_avg2)
                                                .addGap(18)
                                                .addComponent(label_apply_maybe)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(lblNewLabel)
                                                .addGap(27)
                                                .addComponent(label_apply)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(label_3)
                                                .addGap(28)
                                                .addComponent(label_countsOfCourse)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(label_4)
                                                .addContainerGap(272, Short.MAX_VALUE))
                  );
                  gl_panel_show.setVerticalGroup(
                            gl_panel_show.createParallelGroup(Alignment.TRAILING)
                                      .addGroup(gl_panel_show.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(gl_panel_show.createParallelGroup(Alignment.BASELINE)
                                                          .addComponent(label_apply)
                                                          .addComponent(label_countsOfCourse)
                                                          .addComponent(label_avg)
                                                          .addComponent(label_avg2)
                                                          .addComponent(label_apply_maybe)
                                                          .addComponent(lblNewLabel)
                                                          .addComponent(label_3)
                                                          .addComponent(label_4))
                                                .addGap(17))
                  );
                  panel_show.setLayout(gl_panel_show);
                  
                  
                  //학수번호
                  panel_1 = new JPanel();
                  panel_1.setBackground(new Color(230, 230, 250));
                  
                  
                  label = new JLabel("교과목명 : ");
                  
                  scrollPane_list_no = new JScrollPane();
                  
                  textField = new JTextField();
                  textField.setColumns(10);
                  
                  JButton btnNewButton = new JButton("조회");
                  
              	  //학수번호 테이블 추가
                  table_1 = new JTable();
                  table_1.setModel(new DefaultTableModel(
                            new Object[][] {
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                            },
                            new String[] {
                                      "상태", "구분 ", "학년", "학수번호", "분반", "수강대상", "정원", "현원 ", "과목명", "학점", "담당교수", "시간/강의실"
                            }
                  ));
                  table_1.setRowHeight(35);
                  scrollPane_list_no.setViewportView(table_1);
                  
                  GroupLayout gl_panel_1 = new GroupLayout(panel_1);
                  
                  gl_panel_1.setHorizontalGroup(
                            gl_panel_1.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_1.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                                                          .addGroup(gl_panel_1.createSequentialGroup()
                                                                    .addComponent(scrollPane_list_no, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                                                                    .addContainerGap())
                                                          .addGroup(gl_panel_1.createSequentialGroup()
                                                                    .addComponent(label)
                                                                    .addPreferredGap(ComponentPlacement.RELATED)
                                                                    .addComponent(textField, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(ComponentPlacement.RELATED, 348, Short.MAX_VALUE)
                                                                    .addComponent(btnNewButton)
                                                                    .addGap(32))))
                  );
                  
                  gl_panel_1.setVerticalGroup(
                          gl_panel_1.createParallelGroup(Alignment.LEADING)
                                    .addGroup(gl_panel_1.createSequentialGroup()
                                              .addContainerGap()
                                              .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(label)
                                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnNewButton))
                                              .addPreferredGap(ComponentPlacement.RELATED)
                                              .addComponent(scrollPane_list_no, GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE)
                                              .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                  
                  panel_1.setLayout(gl_panel_1);
                  panel_two.add(panel_1, "panel_1");
 
                  //자과과목
                  panel_2 = new JPanel();
                  panel_2.setBackground(new Color(189, 183, 107));
                  
                  
                  JScrollPane scrollPane_4 = new JScrollPane();
                  
                  table_2 = new JTable();
                  table_2.setModel(new DefaultTableModel(
                            new Object[][] {
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                            },
                            new String[] {
                                      "상태", "구분 ", " 학년", " 학수번호", "분반", "수강대상", "정원", "현원", "과목명", "학점", "담당교수", "시간/강의실"
                            }
                  ));
                  scrollPane_4.setViewportView(table_2);
                  
                  
                  GroupLayout gl_panel_2 = new GroupLayout(panel_2);
                  gl_panel_2.setHorizontalGroup(
                            gl_panel_2.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_2.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 745, Short.MAX_VALUE)
                                                .addContainerGap())
                  );
                  gl_panel_2.setVerticalGroup(
                            gl_panel_2.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_2.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                                .addContainerGap())
                  );
                  
                  panel_2.setLayout(gl_panel_2);
                  panel_two.add(panel_2, "panel_2");
                  
                  
                  //교양과목
                  panel_3 = new JPanel();
                  panel_3.setBackground(new Color(65, 105, 225));
                  
                  
                  JScrollPane scrollPane_5 = new JScrollPane();
                  
                  table_3 = new JTable();
                  table_3.setModel(new DefaultTableModel(
                            new Object[][] {
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                            },
                            new String[] {
                            		"상태", "구분 ", " 학년", " 학수번호", "분반", "수강대상", "정원", "현원", "과목명", "학점", "담당교수", "시간/강의실"
                            }
                  ));
                  scrollPane_5.setViewportView(table_3);
                  
                  
                  
                  GroupLayout gl_panel_3 = new GroupLayout(panel_3);
                  gl_panel_3.setHorizontalGroup(
                            gl_panel_3.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_3.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane_5, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                                                .addContainerGap())
                  );
                  gl_panel_3.setVerticalGroup(
                            gl_panel_3.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_3.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane_5, GroupLayout.PREFERRED_SIZE, 140, Short.MAX_VALUE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  );
                  
                
                  panel_3.setLayout(gl_panel_3);
                  panel_two.add(panel_3, "panel_3");
                  
                  
                  
                  
                  
                  
                  //타과과목
                  panel_4 = new JPanel();
                  panel_4.setBackground(new Color(102, 205, 170));
                  panel_two.add(panel_4, "panel_4");
                  
                  JLabel label_1 = new JLabel("대학(원):");
                  
                  JComboBox comboBox = new JComboBox();
                  comboBox.setEditable(true);
                  
                  JLabel label_2 = new JLabel("학부(과)/전공:");
                  
                  JComboBox comboBox_2 = new JComboBox();
                  
                  
                  
                  JButton btnNewButton_1 = new JButton("조회");
                  
                  
                  
                  JScrollPane scrollPane_2 = new JScrollPane();
                  GroupLayout gl_panel_4 = new GroupLayout(panel_4);
                  gl_panel_4.setHorizontalGroup(
                            gl_panel_4.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_4.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
                                                          .addGroup(gl_panel_4.createSequentialGroup()
                                                                    .addComponent(label_1)
                                                                    .addPreferredGap(ComponentPlacement.RELATED)
                                                                    .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(53)
                                                                    .addComponent(label_2)
                                                                    .addPreferredGap(ComponentPlacement.RELATED)
                                                                    .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                                    .addPreferredGap(ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                                                                    .addComponent(btnNewButton_1)
                                                                    .addGap(36))))
		                                        .addGroup(gl_panel_4.createSequentialGroup()
		                                        		.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
		                                        		.addContainerGap())
                  );
                  gl_panel_4.setVerticalGroup(
                            gl_panel_4.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_4.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
                                                          .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                                                    .addComponent(label_1)
                                                                    .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                          .addGroup(gl_panel_4.createSequentialGroup()
                                                                    .addGap(3)
                                                                    .addComponent(label_2))
                                                          .addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
                                                                    .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(btnNewButton_1)))
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                                .addContainerGap())
                  );
                  
                  table_4 = new JTable();
                  table_4.setModel(new DefaultTableModel(
                            new Object[][] {
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                            },
                            new String[] {
                            		"상태", "구분 ", " 학년", " 학수번호", "분반", "수강대상", "정원", "현원", "과목명", "학점", "담당교수", "시간/강의실"
                            }
                  ));
                  scrollPane_2.setViewportView(table_4);
                  panel_4.setLayout(gl_panel_4);
                  
                  
                  //석사과목
                  panel_5 = new JPanel();
                  panel_5.setBackground(new Color(135, 206, 235));
                  panel_two.add(panel_5, "panel_5");
                  
                  
                  scrollPane_1 = new JScrollPane();
                  GroupLayout gl_panel_5 = new GroupLayout(panel_5);
                  gl_panel_5.setHorizontalGroup(
                            gl_panel_5.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_5.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                                                .addContainerGap())
                  );
                  gl_panel_5.setVerticalGroup(
                            gl_panel_5.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_5.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(30, Short.MAX_VALUE))
                  );
                  panel_5.setLayout(gl_panel_5);
                  
                  
                  GroupLayout groupLayout = new GroupLayout(getContentPane());
                  groupLayout.setHorizontalGroup(
                            groupLayout.createParallelGroup(Alignment.TRAILING)
                                      .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                          .addComponent(panel_one_button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                          .addComponent(panel_one, GroupLayout.PREFERRED_SIZE, 775, Short.MAX_VALUE)
                                                          .addComponent(panel_two, GroupLayout.PREFERRED_SIZE, 765, Short.MAX_VALUE)
                                                          .addComponent(panel_show, GroupLayout.PREFERRED_SIZE, 775, Short.MAX_VALUE)
                                                          .addComponent(panel_two_button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
                                                .addContainerGap())
                  );
                  groupLayout.setVerticalGroup(
                            groupLayout.createParallelGroup(Alignment.LEADING)
                                      .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(4)
                                                .addComponent(panel_one_button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2)
                                                .addComponent(panel_one, GroupLayout.PREFERRED_SIZE, 170, Short.MAX_VALUE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(panel_show, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(panel_two_button, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(1)
                                                .addComponent(panel_two, GroupLayout.PREFERRED_SIZE, 170, Short.MAX_VALUE)
                                                .addGap(4))
                  );
                  
                  
                  
                  getContentPane().setLayout(groupLayout);
        this.setSize(797, 520);
        
        ViewUtil view =new ViewUtil();
        view.showCenter(this);
        
        this.setVisible(true);
    }
   
    public static void main(String[] args) {
        new CourseApplicationFrm();
    }
}