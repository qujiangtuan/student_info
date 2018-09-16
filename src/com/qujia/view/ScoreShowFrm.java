package com.qujia.view;
/*
 * 수강신청
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;

import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class ScoreShowFrm extends JFrame {

          private JPanel contentPane;
          private JPanel panel_one,panel_two,panel_three;
          private CardLayout card=null;
          private JPanel panel_c_1=null,panel_c_2=null;
          private final ButtonGroup buttonGroup = new ButtonGroup();
          private JTable table;
          private JTable table_1;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreShowFrm frame = new ScoreShowFrm();
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
          public ScoreShowFrm() {
                    setTitle("성적조회");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 908, 479);
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    panel_one = new JPanel();
                    Border border_1=BorderFactory.createTitledBorder("개인정보");
                    panel_one.setBorder(border_1);
                    
                    panel_two = new JPanel();
                    Border border_2=BorderFactory.createTitledBorder("조희조건");
                    panel_two.setBorder(border_2);
                    
                    card=new CardLayout(0, 0);
                    panel_three = new JPanel(card);
                    
                    
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(panel_three, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                                                            .addComponent(panel_two, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                                                            .addComponent(panel_one, GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addComponent(panel_one, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(10)
                                                  .addComponent(panel_two, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(panel_three, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    
                    panel_three.setLayout(card);
                    
                    panel_c_1 = new JPanel();
                    panel_c_1.setBackground(new Color(0, 255, 255));
                    panel_three.add(panel_c_1, "panel_c_1");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    GroupLayout gl_panel_c_1 = new GroupLayout(panel_c_1);
                    gl_panel_c_1.setHorizontalGroup(
                              gl_panel_c_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_1.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    gl_panel_c_1.setVerticalGroup(
                              gl_panel_c_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_1.createSequentialGroup()
                                                  .addGap(7)
                                                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    
                    table = new JTable();
                    table.setRowHeight(25);
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
                                        {null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "년도/학기", "과목번호", "교과목명", "이수구분", "학점", "등급", "성적유효구분", "비고"
                              }
                    ));
                    table.getColumnModel().getColumn(2).setPreferredWidth(162);
                    table.getColumnModel().getColumn(3).setPreferredWidth(58);
                    table.getColumnModel().getColumn(4).setPreferredWidth(44);
                    table.getColumnModel().getColumn(5).setPreferredWidth(38);
                    table.getColumnModel().getColumn(6).setPreferredWidth(80);
                    scrollPane.setViewportView(table);
                    panel_c_1.setLayout(gl_panel_c_1);
                    
                    panel_c_2 = new JPanel();
                    panel_c_2.setBackground(new Color(173, 255, 47));
                    panel_three.add(panel_c_2, "panel_c_2");
                    
                    JLabel lblNewLabel = new JLabel("학기별 성적");
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    GroupLayout gl_panel_c_2 = new GroupLayout(panel_c_2);
                    gl_panel_c_2.setHorizontalGroup(
                              gl_panel_c_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_2.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_panel_c_2.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                                                            .addComponent(lblNewLabel))
                                                  .addContainerGap())
                    );
                    gl_panel_c_2.setVerticalGroup(
                              gl_panel_c_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_2.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(lblNewLabel)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    
                    table_1 = new JTable();
                    table_1.setRowHeight(25);
                    table_1.setModel(new DefaultTableModel(
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
                                        "학년도/학기", "신청학점", "취득학점", "평점", "백분율", "석차", "F 제외 평점", "비고"
                              }
                    ));
                    scrollPane_1.setViewportView(table_1);
                    panel_c_2.setLayout(gl_panel_c_2);
                    
                    JLabel label_dept = new JLabel("소속대학(원)");
                    
                    JLabel label_schoolyear = new JLabel("학년");
                    
                    JLabel label_major = new JLabel("학부(과):");
                    
                    JLabel label_grade = new JLabel("학위과정:");
                    
                    JLabel label_name = new JLabel("성        명:");
                    
                    JLabel label_no = new JLabel("학    번:");
                    
                    JLabel lblNewLabel_1 = new JLabel("오준택");
                    
                    JLabel lblNewLabel_2 = new JLabel("201211734");
                    
                    JLabel label = new JLabel("4");
                    
                    JLabel lblNewLabel_3 = new JLabel("공과대학");
                    
                    JLabel lblNewLabel_4 = new JLabel("컴퓨터공학과");
                    
                    JLabel lblNewLabel_5 = new JLabel("학사과정");
                    GroupLayout gl_panel_one = new GroupLayout(panel_one);
                    gl_panel_one.setHorizontalGroup(
                              gl_panel_one.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_one.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(label_dept)
                                                            .addComponent(label_name))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(lblNewLabel_3))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(label_no)
                                                            .addComponent(label_major))
                                                  .addGap(18)
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(lblNewLabel_4))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(label_schoolyear)
                                                            .addComponent(label_grade))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(label)
                                                            .addComponent(lblNewLabel_5))
                                                  .addGap(179))
                    );
                    gl_panel_one.setVerticalGroup(
                              gl_panel_one.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_one.createSequentialGroup()
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_name)
                                                            .addComponent(label_schoolyear)
                                                            .addComponent(label_no)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(label))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addGroup(gl_panel_one.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_one.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_dept)
                                                                      .addComponent(label_major)
                                                                      .addComponent(lblNewLabel_3)
                                                                      .addComponent(lblNewLabel_4))
                                                            .addGroup(gl_panel_one.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_grade)
                                                                      .addComponent(lblNewLabel_5)))
                                                  .addContainerGap(21, Short.MAX_VALUE))
                    );
                    panel_one.setLayout(gl_panel_one);
                    
                    JRadioButton all_RadioButton = new JRadioButton("전체학기");
                    all_RadioButton.setSelected(true);
                    buttonGroup.add(all_RadioButton);
                    
                    JRadioButton current_RadioButton = new JRadioButton("해당학기");
                    buttonGroup.add(current_RadioButton);
                    
                    JLabel label_year = new JLabel("년도/학기:");
                    
                    JComboBox comboBox_term = new JComboBox();
                    comboBox_term.setModel(new DefaultComboBoxModel(new String[] {"1학기", "2학기", "여름계절학기", "겨울계절학기"}));
                    comboBox_term.setEditable(true);
                    
                    JSpinner spinner_year = new JSpinner();
                    spinner_year.setModel(new SpinnerNumberModel(2018, 1990, 2030, 1));
                    
                    JButton all_Button = new JButton("전체 성적 보기");
                    all_Button.setBackground(new Color(0, 255, 255));
                    all_Button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        card.show(panel_three,"panel_c_1");
                              }
                    });
                    
                    JButton term_Button = new JButton("학기별 성적 보기");
                    term_Button.setBackground(new Color(173, 255, 47));
                    term_Button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        card.show(panel_three,"panel_c_2");
                              }
                    });
                    
                    JButton search_Button = new JButton("조회");
                    GroupLayout gl_panel_two = new GroupLayout(panel_two);
                    gl_panel_two.setHorizontalGroup(
                              gl_panel_two.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_two.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_panel_two.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_panel_two.createSequentialGroup()
                                                                      .addComponent(all_Button)
                                                                      .addGap(18)
                                                                      .addComponent(term_Button)
                                                                      .addPreferredGap(ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                                                                      .addComponent(search_Button)
                                                                      .addGap(31))
                                                            .addGroup(gl_panel_two.createSequentialGroup()
                                                                      .addComponent(all_RadioButton)
                                                                      .addGap(18)
                                                                      .addComponent(current_RadioButton)
                                                                      .addGap(57)
                                                                      .addComponent(label_year)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(spinner_year, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(26)
                                                                      .addComponent(comboBox_term, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                                                      .addContainerGap(282, Short.MAX_VALUE))))
                    );
                    gl_panel_two.setVerticalGroup(
                              gl_panel_two.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_two.createSequentialGroup()
                                                  .addGroup(gl_panel_two.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(all_RadioButton)
                                                            .addComponent(current_RadioButton)
                                                            .addComponent(comboBox_term, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(spinner_year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_year))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addGroup(gl_panel_two.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(all_Button)
                                                            .addComponent(term_Button)
                                                            .addComponent(search_Button))
                                                  .addContainerGap(14, Short.MAX_VALUE))
                    );
                    panel_two.setLayout(gl_panel_two);
                    contentPane.setLayout(gl_contentPane);
          }
}
