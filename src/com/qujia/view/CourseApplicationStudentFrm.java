package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.CourseApplyViewDao;
import com.qujia.dao.OpenCourseDao;
import com.qujia.dao.PerCourseDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.StuCouDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.CourseApplyView;
import com.qujia.model.PerCourse;
import com.qujia.model.Student;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;
 
 
public class CourseApplicationStudentFrm extends JFrame {
    private JPanel panel_one;
    private JPanel panel_one_button;
    private CardLayout card = null,card_per=null; // CardLayout
    private CardLayout card_2=null;
    
    private JButton b_1 = null, b_2 = null, b_3 = null; // 三个可直接翻转到JPanel组件的按钮
    private JPanel p_1 = null, p_2 = null, p_3 = null; // 要切换的三个JPanel
    private JTable table_perCourse;
    private JPanel panel_two_button;
    private JButton button_no= null,button_self= null,button_liberal= null,button_other= null,button_master= null;
    private JPanel panel_1= null,panel_2= null,panel_3= null,panel_4= null;
    private JPanel panel_two;
    private JLabel label;
    private JTextField textField_searchNC;
    private JScrollPane scrollPane_3;
    private JTable schedule;
    private JTable table_show;
    private JTable table_1;
    private JLabel label_avg2;
    private JLabel label_credit1;
    private JLabel label_credit2;
    private JLabel label_count;
    private JLabel label_name;
    private JLabel nameLabel;
    private JButton btnNewButton_3;
    private Student student,stuTemp;
    private static String dept;
    private static int index=-1;
    private static int index2=-1;
    private DefaultTableModel   dft_1;  //수강신청 목록 table model
    private DefaultTableModel dft_per;//개인 신청 table model
    private PerCourseDao  pcDao;
    private static String sno;//학생 학번
    private static int count;//현원
    
    public static void main(String[] args) {
              EventQueue.invokeLater(new Runnable() {
                  public void run() {
                      try {
                           CourseApplicationStudentFrm frame = new CourseApplicationStudentFrm();
                          frame.setVisible(true);
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }
              });
          }
    
    
    public CourseApplicationStudentFrm() {
              
        super("CardLayout Test");
        setTitle("수강신청");
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     // get login user info 
        student =(Student) MainFrm.userObject;
        StudentDao stuDao=new StudentDao();
        stuTemp=stuDao.login(student);
        setPersonInfo();
        
        
        try {
            // 将LookAndFeel设置成Windows样式
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                 //panel_two = new JPanel(card); 
                 
                  
                   
                    panel_one_button = new JPanel();
                    panel_one_button.setBounds(0, 4, 901, 38);
                    b_1 = new JButton("수강신청 목록");
                    b_1.setBounds(12, 5, 150, 23);
                    b_1.setBackground(new Color(255, 218, 185));
                    b_2 = new JButton("시간표");
                    b_2.setBounds(169, 5, 77, 23);
                    b_2.setBackground(new Color(224, 255, 255));
                    b_3 = new JButton("수강신청확인서");
                    b_3.setBounds(617, 5, 134, 23);
                    b_3.setBackground(new Color(219, 112, 147));
                    b_1.addActionListener(new ActionListener() { // 直接翻转到p_1
                        public void actionPerformed(ActionEvent e) {
                                  card_per.show(panel_one, "p_1");
                                  setTable_perCourse(new PerCourse());
                        }
                    });
                    b_2.addActionListener(new ActionListener() { // 直接翻转到p_2
                        public void actionPerformed(ActionEvent e) {
                                  card_per.show(panel_one, "p_2");
                        }
                    });
                    b_3.addActionListener(new ActionListener() { // 直接翻转到p_3
                        public void actionPerformed(ActionEvent e) {
                                  card_per.show(panel_one, "p_3");
                        }
                    });
                    
                    label_name = new JLabel("이름:");
                    label_name.setBounds(308, 9, 40, 15);
                    
                    nameLabel = new JLabel("취지앙투안");
                    nameLabel.setText(stuTemp.getName());
                    nameLabel.setBounds(348, 9, 106, 15);
                  
                   
                   panel_one = new JPanel(); // JPanel的布局管理将被设置成CardLayout
                   panel_one.setBounds(0, 44, 901, 263);
                   //        b_1.setMargin(new Insets(2,2,2,2));
                   //        b_2.setMargin(new Insets(2,2,2,2));
                   //        b_3.setMargin(new Insets(2,2,2,2));
                           p_1 = new JPanel();
                           p_2 = new JPanel();
                           p_3 = new JPanel();
                           p_1.setBackground(new Color(255, 218, 185));
                           p_2.setBackground(new Color(224, 255, 255));
                           p_3.setBackground(new Color(221, 160, 221));
                           card_per=new CardLayout(0, 0);
                           panel_one.setLayout(card_per);
                           panel_one.add(p_1, "p_1");
                           
                           JLabel label_apply_list = new JLabel("수강신청목록");
                           label_apply_list.setBounds(12, 14, 93, 15);
                           
                           JScrollPane scrollPane = new JScrollPane();
                           scrollPane.setBounds(12, 39, 873, 214);
                           
                           btnNewButton_3 = new JButton("수강 삭제");
                           btnNewButton_3.setBounds(616, 10, 93, 23);
                           btnNewButton_3.addActionListener(new ActionListener() {
                                     public void actionPerformed(ActionEvent e) {
                                               deleteCAction(e);
                                     }
                           });
                           
                           table_perCourse = new JTable();
                           table_perCourse.addMouseListener(new MouseAdapter() {
                                     @Override
                                     public void mouseClicked(MouseEvent arg0) {
                                               index2=table_perCourse.getSelectedRow();
                                     }
                           });
                           table_perCourse.setRowHeight(25);
                           table_perCourse.setModel(new DefaultTableModel(
                                     new Object[][] {
                                               {null, null, null, null, null, null, null},
                                     },
                                     new String[] {
                                               "\uACFC\uBAA9\uBA85 ", "\uD559\uC218\uBC88\uD638 ", "\uC774\uC218\uAD6C\uBD84", "\uB2F4\uB2F9\uAD50\uC218", "\uBD84\uBC18 ", "\uD559\uC810 ", " \uC2DC\uAC04/\uAC15\uC758\uC2E4"
                                     }
                           ) {
                                     boolean[] columnEditables = new boolean[] {
                                               false, false, false, false, false, false, false
                                     };
                                     public boolean isCellEditable(int row, int column) {
                                               return columnEditables[column];
                                     }
                           });
                           table_perCourse.getColumnModel().getColumn(0).setPreferredWidth(158);
                           table_perCourse.getColumnModel().getColumn(1).setPreferredWidth(90);
                           table_perCourse.getColumnModel().getColumn(2).setPreferredWidth(87);
                           table_perCourse.getColumnModel().getColumn(3).setPreferredWidth(88);
                           table_perCourse.getColumnModel().getColumn(6).setPreferredWidth(426);
                           scrollPane.setViewportView(table_perCourse);
                           table_perCourse.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                           scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                           panel_one.add(p_2, "p_2");
                           p_2.setLayout(null);
                           
                           scrollPane_3 = new JScrollPane();
                           scrollPane_3.setBounds(12, 5, 878, 248);
                           
                           schedule = new JTable();
                           schedule.setRowHeight(25);
                           schedule.setModel(new DefaultTableModel(
                                     new Object[][] {
                                               {"0", "08:00", null, null, null, null, null, null, null},
                                               {"0.5", "08:30", null, null, null, null, null, null, null},
                                               {"1", "09:00", null, null, null, null, null, null, null},
                                               {"1.5", "09:30", null, null, null, null, null, null, null},
                                               {"2", "10:00", null, null, null, null, null, null, null},
                                               {"2.5", "10:30", null, null, null, null, null, null, null},
                                               {"3", "11:00", null, null, null, null, null, null, null},
                                               {"3.5", "11:30", null, null, null, null, null, null, null},
                                               {"4", "12:00", null, null, null, null, null, null, null},
                                               {"4.5", "12:30", null, null, null, null, null, null, null},
                                               {"5", "13:00", null, null, null, null, null, null, null},
                                               {"5.5", "13:30", null, null, null, null, null, null, null},
                                               {"6", "14:00", null, null, null, null, null, null, null},
                                               {"6.5", "14:30", null, null, null, null, null, null, null},
                                               {"7", "15:00", null, null, null, null, null, null, null},
                                               {"7.5", "15:30", null, null, null, null, null, null, null},
                                               {"8", "16:00", null, null, null, null, null, null, null},
                                               {"8.5", "16:30", null, null, null, null, null, null, null},
                                               {"9", "17:00", null, null, null, null, null, null, null},
                                               {"9.5", "17:30", null, null, null, null, null, null, null},
                                               {"10", "18:00", "", null, null, null, null, null, null},
                                               {"10.5", "18:30", null, null, null, null, null, null, null},
                                               {"11", "19:00", null, null, null, null, null, null, null},
                                               {"11.5", "19:30", null, null, null, null, null, null, null},
                                               {"12", "20:00", null, null, null, null, null, null, null},
                                     },
                                     new String[] {
                                               "\uAD50\uC2DC", "\uC2DC\uAC04", "\uC6D4", "\uD654", "\uC218", "\uBAA9", "\uAE08", "\uD1A0", "\uC77C"
                                     }
                           ) {
                                     boolean[] columnEditables = new boolean[] {
                                               false, false, true, false, false, false, false, false, false
                                     };
                                     public boolean isCellEditable(int row, int column) {
                                               return columnEditables[column];
                                     }
                           });
                           scrollPane_3.setViewportView(schedule);
                           p_2.add(scrollPane_3);
                           panel_one.add(p_3, "p_3");
                           p_3.setLayout(null);
                           
                           JScrollPane scrollPane_show = new JScrollPane();
                           scrollPane_show.setBounds(5, 5, 888, 248);
                           
                           table_show = new JTable();
                           table_show.setRowHeight(25);
                           table_show.setModel(new DefaultTableModel(
                                     new Object[][] {
                                               {null, null, null, null, null, null, null, null, null, "", null},
                                     },
                                     new String[] {
                                               "\uC2E0\uCCAD\uC0C1\uD0DC", "\uAD6C\uBD84", "\uD559\uC218\uBC88\uD638", "\uBD84\uBC18", "\uACFC\uBAA9\uBA85", "\uD559\uC810", "\uB2F4\uB2F9\uAD50\uC218", "\uAC15\uC758\uC2E4", "\uC7AC\uC218\uAC15", "\uAC1C\uC124\uC8FC\uAD00\uD559\uACFC", "\uC5F0\uB77D\uCC98"
                                     }
                           ));
                           scrollPane_show.setViewportView(table_show);
                           p_3.add(scrollPane_show);
                  
                 
                  panel_two = new JPanel((LayoutManager) null);
                  panel_two.setBounds(0, 378, 901, 38);
                  
                  JPanel panel_show = new JPanel();
                  panel_show.setBounds(0, 306, 901, 30);
                  panel_show.setBackground(Color.PINK);
                  panel_two_button = new JPanel();
                  panel_two_button.setBounds(0, 340, 901, 38);
                  
                  button_no = new JButton("학수번호");
                  button_no.setBounds(10, 5, 98, 23);
                  button_no.setBackground(new Color(230, 230, 250));
                  button_no.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                      card_2.show(panel_two,"panel_1");
                            }
                  });
                  
                  button_self = new JButton("자과과목");
                  button_self.setBounds(120, 5, 99, 23);
                  button_self.setBackground(new Color(189, 183, 107));
                  button_self.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
//                                      card_2.show(panel_two, "panel_2");
                            }
                  });
                  button_other = new JButton("타과과목");
                  button_other.setBounds(340, 5, 98, 23);
                  button_other.setBackground(new Color(102, 205, 170));
                  button_other.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                      card_2.show(panel_two,"panel_4");
                            }
                  });
                  
                  button_liberal = new JButton("교양과목");
                  button_liberal.setBounds(231, 5, 97, 23);
                  button_liberal.setBackground(new Color(65, 105, 225));
                  button_liberal.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
//                                      card_2.show(panel_two,"panel_3");
                            }
                  });
                 
                 JButton btnNewButton_2 = new JButton("수강 신청");
                 btnNewButton_2.setBounds(625, 5, 91, 23);
                 btnNewButton_2.addActionListener(new ActionListener() {
                           public void actionPerformed(ActionEvent ae) {
                                     applyCourseAction(ae);
                           }
                 });
                 btnNewButton_2.setBackground(new Color(175, 238, 238));
                  
                  JPanel panel = new JPanel();
                  panel.setBounds(10, 418, 879, 233);
                  panel.setLayout(null);
                  
                  JScrollPane scrollPane_1 = new JScrollPane();
                  scrollPane_1.setBounds(0, 0, 879, 233);
                  panel.add(scrollPane_1);
                  
                  table_1 = new JTable();
                  table_1.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent me) {
                                      selectRowAction(me);
                            }
                  });
                  scrollPane_1.setViewportView(table_1);
                  table_1.setRowHeight(25);
                  table_1.setModel(new DefaultTableModel(
                            new Object[][] {
                                      {null, null, null, null, null, null, null, null, null, null, null, null},
                            },
                            new String[] {
                                      "\uC0C1\uD0DC", "\uACFC\uBAA9\uBA85", "\uD559\uC218\uBC88\uD638", "\uC218\uAC15\uB300\uC0C1(\uD559\uBD80/\uACFC)", "\uB300\uC0C1\uD559\uB144", "\uC774\uC218\uAD6C\uBD84 ", "\uD559\uC810", "\uB2F4\uB2F9\uAD50\uC218", "\uC815\uC6D0", "\uD604\uC6D0 ", "\uBD84\uBC18", "\uC2DC\uAC04/\uAC15\uC758\uC2E4"
                            }
                  ) {
                            boolean[] columnEditables = new boolean[] {
                                      false, false, false, false, false, false, false, false, false, false, false, false
                            };
                            public boolean isCellEditable(int row, int column) {
                                      return columnEditables[column];
                            }
                  });
                  table_1.getColumnModel().getColumn(1).setPreferredWidth(147);
                  table_1.getColumnModel().getColumn(2).setPreferredWidth(80);
                  table_1.getColumnModel().getColumn(3).setPreferredWidth(128);
                  table_1.getColumnModel().getColumn(11).setPreferredWidth(308);
                  table_1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                  
                  JLabel label_avg = new JLabel("직전학기평점평균:");
                  
                  JLabel label_apply_maybe = new JLabel("신청가능학점:");
                  
                  JLabel label_apply = new JLabel("신청학점:");
                  
                  JLabel label_countsOfCourse = new JLabel("신청과목수:");
                  
                  label_avg2 = new JLabel("3.5");
                  
                  label_credit1 = new JLabel("18");
                  
                  label_credit2 = new JLabel("15");
                  label_credit2.setText(this.getCredit2());
                  
                  label_count = new JLabel("5");
                  label_count.setText(this.getCouCounts());
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
                                                .addComponent(label_credit1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18)
                                                .addComponent(label_apply)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(label_credit2)
                                                .addGap(28)
                                                .addComponent(label_countsOfCourse)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(label_count)
                                                .addContainerGap(346, Short.MAX_VALUE))
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
                                                          .addComponent(label_credit1)
                                                          .addComponent(label_credit2)
                                                          .addComponent(label_count))
                                                .addGap(17))
                  );
                  panel_show.setLayout(gl_panel_show);
                  card_2=new CardLayout(0, 0);
                  panel_two.setLayout(card_2);
                  p_1.setLayout(null);
                  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                  p_1.add(scrollPane);
                  p_1.add(label_apply_list);
                  p_1.add(btnNewButton_3);
                  
                  panel_1 = new JPanel();
                  panel_two.add(panel_1, "panel_1");
                  panel_1.setBackground(new Color(230, 230, 250));
                  
                  label = new JLabel("학수번호/과목명 : ");
                  label.setBounds(12, 11, 113, 15);
                  
                  textField_searchNC = new JTextField();
                  textField_searchNC.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                      
                            }
                  });
                  textField_searchNC.setBounds(119, 8, 170, 21);
                  textField_searchNC.setColumns(10);
                  
                  JButton btnNewButton = new JButton("조희");
                  btnNewButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent ae) {
                                      searchCourseAction(ae);
                            }
                  });
                  btnNewButton.setBounds(301, 7, 79, 23);
                  panel_1.setLayout(null);
                  panel_1.add(label);
                  panel_1.add(textField_searchNC);
                  panel_1.add(btnNewButton);
                  
                  panel_4 = new JPanel();
                  panel_4.setBackground(new Color(102, 205, 170));
                  panel_two.add(panel_4, "panel_4");
                  
                  JLabel label_1 = new JLabel("대학(원):");
                  
                  JComboBox comboBox = new JComboBox();
                  comboBox.setEditable(true);
                  
                  JLabel label_2 = new JLabel("학부(과)/전공:");
                  
                  JComboBox comboBox_2 = new JComboBox();
                  
                  JButton btnNewButton_1 = new JButton("조희");
                  GroupLayout gl_panel_4 = new GroupLayout(panel_4);
                  gl_panel_4.setHorizontalGroup(
                            gl_panel_4.createParallelGroup(Alignment.LEADING)
                                      .addGroup(gl_panel_4.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label_1)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addGap(53)
                                                .addComponent(label_2)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                                                .addComponent(btnNewButton_1)
                                                .addGap(175))
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
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  );
                  panel_4.setLayout(gl_panel_4);
                  getContentPane().setLayout(null);
                  getContentPane().add(panel);
                  getContentPane().add(panel_two);
                  getContentPane().add(panel_one_button);
                  panel_one_button.setLayout(null);
                  panel_one_button.add(b_1);
                  panel_one_button.add(b_2);
                  panel_one_button.add(label_name);
                  panel_one_button.add(nameLabel);
                  panel_one_button.add(b_3);
                  getContentPane().add(panel_one);
                  getContentPane().add(panel_show);
                  getContentPane().add(panel_two_button);
                  panel_two_button.setLayout(null);
                  panel_two_button.add(button_no);
                  panel_two_button.add(button_self);
                  panel_two_button.add(button_liberal);
                  panel_two_button.add(button_other);
                  panel_two_button.add(btnNewButton_2);
        this.setSize(917, 706);
        
        ViewUtil view =new ViewUtil();
        view.showCenter(this);
        
        this.setVisible(true);
        
        //count=getCurrentNum(table_1.getValueAt(index, 2).toString());
        
        setTable_1(new CourseApplyView());
        setTable_perCourse(new PerCourse());
        resetValue();
    }
    private String getCredit2() {
          pcDao=new PerCourseDao();   
          int credit2=pcDao.getCredit2(sno);
          return credit2+"";
    }
  
    //수강신청 과목 개수
    private String getCouCounts() {
          pcDao=new PerCourseDao();    
          int counts=pcDao.getCouCounts(sno);
          return counts+"";
    }


//수강신청 삭제
    protected void deleteCAction(ActionEvent e) {
              
              System.out.println(index2);
              if(index2==-1){
                        JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                        return;
              }
              dft_per = (DefaultTableModel) table_perCourse.getModel();
              String couNo = dft_per.getValueAt(index2, 1).toString();
              pcDao=new PerCourseDao();
              int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수강을 삭제 하시겠습니까?", " WarningDialog!", 
                                  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
              if(showConfirmDialog==JOptionPane.YES_OPTION){
                        if(pcDao.deletePC(couNo,sno)){
                                  count=getCurrentNum(couNo);
                                  boolean updateCurrNum = updateCurrNum(couNo,count);
                                  setTable_1(new CourseApplyView());
                                  setTable_perCourse(new PerCourse());
                                  JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                        }else{
                                  JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                        }
              }
              resetValue();
              pcDao.closeDao();
             
    }


    private boolean updateCurrNum(String couNo, int count2) {
              OpenCourseDao ocDao=new OpenCourseDao();
              if(ocDao.updateCurrNum(couNo,count2)){
                        return true;
              }else{
                        return false;
              }
    }


//set per course
    private void setTable_perCourse(PerCourse perCourse) {
              dft_per = (DefaultTableModel) table_perCourse.getModel();
              dft_per.setRowCount(0);
              PerCourseDao pcDao=new PerCourseDao();
              List<PerCourse> pcList = pcDao.getPCList(perCourse,sno);
              for(PerCourse pc : pcList){
                        Vector v=new Vector();
                        v.add(pc.getCouName());
                        v.add(pc.getCouNo());
                        v.add(pc.getLearnType());
                        v.add(pc.getProName());
                        v.add(pc.getClassNo());
                        v.add(pc.getCreditType());
                        v.add(pc.getTtcr());
                        dft_per.addRow(v);
              }
              pcDao.closeDao();
    }


//신청 submit
    protected void applyCourseAction(ActionEvent ae) {
              if(index==-1){
                        JOptionPane.showMessageDialog(this, "수강과목을 선택해주세요!");
                        return;
              }
              dft_1 = (DefaultTableModel) table_1.getModel();
              int fixedNum = Integer.parseInt(dft_1.getValueAt(index, 8).toString());//정원
              int currNum = Integer.parseInt(dft_1.getValueAt(index, 9).toString());//현원
              int credit1=Integer.parseInt(label_credit1.getText().toString());//신청가능학점
              int credit2=Integer.parseInt(label_credit2.getText().toString());//신청된 학점
             
              String couNo = dft_1.getValueAt(index, 2).toString();
              PerCourse pc=new PerCourse();
              pc.setYear(DateUtil.getThisYear());
              pc.setTerm(DateUtil.getTerm());
              pc.setCouName(dft_1.getValueAt(index, 1).toString());
              pc.setCouNo(couNo);
              pc.setCouDept(dft_1.getValueAt(index, 3).toString());
              pc.setStuDept(dept);
              pc.setLearnType(dft_1.getValueAt(index, 5).toString());
              String proName=dft_1.getValueAt(index, 7).toString();
              pc.setProName(proName);
              pc.setProId(this.getProNo(proName));
              pc.setClassNo(dft_1.getValueAt(index, 10).toString());
              //지금 신청할 이수학점 3점
              int creditCurr = Integer.parseInt(dft_1.getValueAt(index, 6).toString());
              pc.setCreditType(creditCurr);
              pc.setTtcr(dft_1.getValueAt(index, 11).toString());
              pc.setSno(sno);
              pc.setsName(this.getStudentName(sno));
              PerCourseDao pcDao=new PerCourseDao();
            //중복 확인
              if(pcDao.couIsExist(couNo,sno)){
                        JOptionPane.showMessageDialog(this, "이 과목은 이미 신청되었습니다!");
                        return;
              }
              if(credit1<(credit2+creditCurr)){
                        JOptionPane.showMessageDialog(this, "신청가능학점이 초과되었습니다！");
                        return;
              }
              StuCouDao scDao=new StuCouDao();
              if(fixedNum<(currNum+1)&& !(scDao.isSC(stuTemp.getsNo(),couNo))){
                        JOptionPane.showMessageDialog(this, "정원 초과된 과목입니다.");
                        return;
              }else if(fixedNum>=(currNum+1)||(fixedNum<(currNum+1)&& scDao.isSC(stuTemp.getsNo(),couNo))){
                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수강을 신청하시겠습니까?", " WarningDialog!", 
                                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(showConfirmDialog==JOptionPane.YES_OPTION){
                                 
                                            if(pcDao.addApplyCourse(pc)){
                                                      count=getCurrentNum(couNo);
                                                      boolean updateCurrNum = updateCurrNum(couNo,count);
                                                      //두개 table 초기화
                                                      setTable_1(new CourseApplyView());
                                                      setTable_perCourse(new PerCourse());
                                                      JOptionPane.showMessageDialog(this, "수강 신청 성공했습니다!");
                                                      resetValue();
                                                      return;
                                            }else{
                                                      JOptionPane.showMessageDialog(this, "수강 신청 실패했습니다!");
                                                      return;
                                            }
                        }
              }
              
              
              
    }
    private String getProNo(String proName) {
          ProStaffDao psDao=new ProStaffDao();
          String proId = psDao.getProId(proName);
          return proId;
}


//현원
    private int getCurrentNum(String couNo) {
              return CourseArrangeManagerFrm.getCurrNum(couNo);
    }


//신청학점/과목수 초기화
     private void resetValue() {
               index2=-1;
               index=-1;
               label_count.setText(getCouCounts());
               label_credit2.setText(getCredit2());
    }
  // 학생번호에 통해서 학생이름을 찾는다.
     private String getStudentName(String sno) {
               StudentDao sDao=new StudentDao();
               String stuName=sDao.getStuName(sno);
               return stuName;
     }

//select row
    protected void selectRowAction(MouseEvent me) {
              index=table_1.getSelectedRow();
    }


//수강 조회
    protected void searchCourseAction(ActionEvent ae) {
              CourseApplyView cav=new CourseApplyView();
              String couNoName = textField_searchNC.getText().toString();
              if(!("".equals(couNoName))){
                    if(StringUtil.isNumeric(couNoName)){
                              cav.setCouNo(couNoName);
                    }else{
                              cav.setCouName(couNoName);
                    }
              } 
              setTable_1(cav);
              index=-1;
    }


//set name,dept
    private void setPersonInfo() {
              dept=stuTemp.getDeptName();
              sno=stuTemp.getsNo();
    }


//    setTabla_1
     private void setTable_1(CourseApplyView courseApply) {
               DefaultTableModel dft = (DefaultTableModel) table_1.getModel();
               dft.setRowCount(0);
               CourseApplyViewDao cavDao=new CourseApplyViewDao();
               List<CourseApplyView> cavList = cavDao.getCavList( courseApply);
               for(CourseApplyView cav : cavList){
                         Vector v=new Vector();
                         v.add(null);
                         v.add(cav.getCouName());
                         v.add(cav.getCouNo());
                         v.add(cav.getOrgName());
                         v.add(cav.getSchYear());
                         v.add(cav.getLearnType());
                         v.add(cav.getCreditType());
                         v.add(this.getProName(cav.getProId()));
                         v.add(cav.getFixedNum());
                         //현원
                         v.add(cav.getCurrNum());
//                         v.add(getCurrentNum(cav.getCouNo()));
                         v.add(cav.getClassNo());
                         v.add(cav.getTtcr());
                         dft.addRow(v);
               }
               cavDao.closeDao();
              
     }

     //get pro name
        private Object getProName(String proId) {
                  ProStaffDao psDao=new ProStaffDao();
                  String orgName=psDao.getProName(proId);
                  return orgName;
        }


// 设置jspinner 类型方法
    private void setMyModel(JSpinner spinner) {
              spinner.setValue(new Date());
              // 设置时间格式
              JSpinner.DateEditor editor = new JSpinner.DateEditor(
                                  spinner, "HH:mm");
              spinner.setEditor(editor);
    }
}