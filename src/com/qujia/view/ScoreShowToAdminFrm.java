package com.qujia.view;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.PerCourseDao;
import com.qujia.dao.StudentDao;
import com.qujia.dao.YearDeptStandDao;
import com.qujia.model.PerCourse;
import com.qujia.model.Student;
import com.qujia.model.YearDeptStand;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class ScoreShowToAdminFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_sname;
          private JTextField textField_sno;
          private JTable table_student;
          private JTable table_score;
          private JTable table_credit;
          private JPanel panel_score,panel_credit,panel_card;
          private JButton scoreButton,creditButton;
          private CardLayout card;
          private JRadioButton radio_1,radio_2;
          private ButtonGroup group;
          private static int index=-1;
          private DefaultTableModel dft_stuList,dft_score,dft_score2 ;
          private static String sno,orgid;
          private JLabel label_name;
          private JScrollPane scrollPane_1;
          private JTable table_score2;
          private int row_score=-1;
          
          
          
          
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
                    this.setResizable(false);
                    setTitle("\uC131\uC801\uD559\uC810\uD655\uC778");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 738, 632);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("학생명:");
                    lblNewLabel.setBounds(73, 29, 68, 15);
                    
                    textField_sname = new JTextField();
                    textField_sname.setBounds(142, 26, 109, 21);
                    textField_sname.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uBC88:");
                    lblNewLabel_1.setBounds(299, 29, 41, 15);
                    
                    textField_sno = new JTextField();
                    textField_sno.setBounds(339, 26, 116, 21);
                    textField_sno.setColumns(10);
                    
                    JButton searchStuButton = new JButton("\uC870 \uD68C");
                    searchStuButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        Student student=new Student();
                                        String name = null,sno = null;
                                        if(radio_1.isSelected()){
                                                  name=textField_sname.getText().toString();
                                                  if(StringUtil.isEmpty(name)){
                                                            name=null;
                                                  }
                                                  sno=null;
                                        }else{
                                                  sno=textField_sno.getText().toString();
                                                  if(StringUtil.isEmpty(sno)){
                                                            sno=null;
                                                  }
                                                  name=null;
                                        }
                                        student.setName(name);
                                        student.setsNo(sno);
                                        setStudentTable(student);
                                        index=-1;
                                        row_score=-1;
                                        dft_score.setRowCount(0);
                                        dft_score2.setRowCount(0);
                              }
                    });
                    searchStuButton.setBounds(512, 25, 81, 23);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(35, 58, 645, 89);
                    
                    JLabel lblNewLabel_2 = new JLabel("학생명:");
                    lblNewLabel_2.setBounds(50, 177, 70, 15);
                    
                    label_name = new JLabel("");
                    label_name.setBounds(123, 177, 128, 15);
                    
                    scoreButton = new JButton("\uC131\uC801\uD655\uC778");
                    scoreButton.setBounds(317, 173, 103, 23);
                    scoreButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(index==-1){
                                                  JOptionPane.showMessageDialog(null, "해당 학생을 선택해주세요!");
                                                  return;
                                        }
                                        scrollPane_1.setVisible(true);
                                        card.show(panel_card, "panel_score");
                                        setTable_scoreAvg(new PerCourse(), sno);
                              }
                    });
                    
                    creditButton = new JButton("\uD559\uC810\uD655\uC778");
                    creditButton.setBounds(438, 173, 103, 23);
                    creditButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(index==-1){
                                                  JOptionPane.showMessageDialog(null, "해당 학생을 선택해주세요!");
                                                  return;
                                        }
                                        scrollPane_1.setVisible(false);
                                        card.show(panel_card, "panel_credit");
                                        YearDeptStand yds=new YearDeptStand();
                                        yds.setOrgId(orgid);
                                        setTable_credit(yds);
                              }
                    });
                    
                    panel_card = new JPanel();
                    panel_card.setBounds(17, 202, 691, 184);
                    card=new CardLayout(0, 0);
                    panel_card.setLayout(card);
                    
                    panel_score = new JPanel();
                    Border border_1=BorderFactory.createTitledBorder("성적확인");
                    panel_score.setBorder(border_1);
                    panel_card.add(panel_score, "panel_score");
                    
                    JScrollPane scrollPane_score = new JScrollPane();
                    GroupLayout gl_panel_score = new GroupLayout(panel_score);
                    gl_panel_score.setHorizontalGroup(
                              gl_panel_score.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_score.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_score, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    gl_panel_score.setVerticalGroup(
                              gl_panel_score.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(Alignment.LEADING, gl_panel_score.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_score, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(71, Short.MAX_VALUE))
                    );
                    
                    table_score = new JTable();
                    table_score.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectTableScore(e);
                              }
                    });
                    scrollPane_score.setViewportView(table_score);
                    table_score.setRowHeight(25);
                    table_score.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uB144\uB3C4", "\uD559\uAE30", "\uC2E0\uCCAD\uD559\uC810", "\uCDE8\uB4DD\uD559\uC810", "\uC131\uC801"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    panel_score.setLayout(gl_panel_score);
                    
                    panel_credit = new JPanel();
                    Border border_2=BorderFactory.createTitledBorder("학점확인");
                    panel_credit.setBorder(border_2);
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
                                                  .addComponent(scrollPane_credit, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(123, Short.MAX_VALUE))
                    );
                    
                    table_credit = new JTable();
                    table_credit.setRowHeight(25);
                    table_credit.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {"\uD559\uACFC\uAE30\uC874\uD559\uC810 ", "", null, null, null, null, null, null},
                                        {"\uC774\uC218 \uD559\uC810", "", null, null, null, null, null, null},
                                        {"\uBBF8\uC218 \uD559\uC810 ", "", null, null, null, null, null, null},
                              },
                              new String[] {
                                        "", "\uC878\uC5C5\uC774\uC218\uD559\uC810", "\uC804\uACF5\uC774\uC218\uD559\uC810", "\uC804\uACF5\uD544\uC218\uD559\uC810", "\uC804\uACF5\uC120\uD0DD\uD559\uC810", "\uAD50\uC591\uC774\uC218\uD559\uC810", "\uAD50\uC591\uD544\uC218\uD559\uC810", "\uAD50\uC591\uC120\uD0DD\uD559\uC810"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_credit.getColumnModel().getColumn(0).setPreferredWidth(86);
                    table_credit.getColumnModel().getColumn(1).setPreferredWidth(95);
                    table_credit.getColumnModel().getColumn(2).setPreferredWidth(95);
                    table_credit.getColumnModel().getColumn(3).setPreferredWidth(100);
                    table_credit.getColumnModel().getColumn(4).setPreferredWidth(93);
                    table_credit.getColumnModel().getColumn(5).setPreferredWidth(95);
                    table_credit.getColumnModel().getColumn(6).setPreferredWidth(94);
                    table_credit.getColumnModel().getColumn(7).setPreferredWidth(99);
                    scrollPane_credit.setViewportView(table_credit);
                    panel_credit.setLayout(gl_panel_credit);
                    
                    table_student = new JTable();
                    table_student.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectRowStudent(e);
                              }
                    });
                    table_student.setRowHeight(25);
                    table_student.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uBC88", "\uD559\uC0DD\uBA85", "\uC18C\uC18D\uD559\uACFC", "\uD559\uB144", "\uD559\uC0AC\uACFC\uC815"
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
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField_sname);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(textField_sno);
                    contentPane.add(searchStuButton);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(label_name);
                    contentPane.add(scoreButton);
                    contentPane.add(creditButton);
                    contentPane.add(scrollPane);
                    contentPane.add(panel_card);
                    
                    radio_1= new JRadioButton("");
                    radio_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent arg0) {
                                        if(radio_1.isSelected()){
                                                  textField_sname.setEnabled(true);
                                                  textField_sno.setEnabled(false);
                                                  textField_sno.setText("");
                                        }else{
                                                  textField_sno.setEnabled(true);
                                                  textField_sname.setEnabled(false);
                                                  textField_sname.setText("");
                                        }
                              }
                    });
                    radio_1.setSelected(true);
                    radio_1.setBounds(50, 29, 21, 15);
                    contentPane.add(radio_1);
                    
                    radio_2 = new JRadioButton("");
                    radio_2.setBounds(278, 29, 21, 15);
                    contentPane.add(radio_2);
                    group=new ButtonGroup();
                    group.add(radio_1);
                    group.add(radio_2);
                    
                    scrollPane_1 = new JScrollPane();
                    scrollPane_1.setBounds(17, 396, 691, 184);
                    contentPane.add(scrollPane_1);
                    
                    table_score2 = new JTable();
                    table_score2.setRowHeight(25);
                    table_score2.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uB144\uB3C4", "\uD559\uAE30", "\uACFC\uBAA9\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uC774\uC218\uAD6C\uBD84", "\uB2F5\uB2F9\uAD50\uC218", "\uD559\uC810", "\uB4F1\uAE09"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_score2.getColumnModel().getColumn(0).setPreferredWidth(59);
                    table_score2.getColumnModel().getColumn(1).setPreferredWidth(40);
                    table_score2.getColumnModel().getColumn(3).setPreferredWidth(189);
                    scrollPane_1.setViewportView(table_score2);
                    dft_stuList = (DefaultTableModel) table_student.getModel();
                    dft_score = (DefaultTableModel) table_score.getModel();
                    dft_score2 = (DefaultTableModel) table_score2.getModel();
                    setStudentTable(new Student());
                    
          }
          protected void selectTableScore(MouseEvent e) {
                    row_score=table_score.getSelectedRow();
                    String year;
                    int term;
                    year=dft_score.getValueAt(row_score, 0).toString();
                    term=Integer.parseInt(dft_score.getValueAt(row_score, 1).toString());
                    PerCourse per=new PerCourse();
                    per.setYear(year);
                    per.setTerm(term);
                    setTable_score2(per,sno);
          }

          private void setTable_score2(PerCourse per, String sno2) {
                    dft_score2.setRowCount(0);
                    PerCourseDao pcDao=new PerCourseDao();
                    List<PerCourse> pcList = pcDao.getPCList(per,sno);
                    for(PerCourse pc : pcList){
                              Vector v=new Vector();
                              v.add(pc.getYear());
                              v.add(pc.getTerm());
                              v.add(pc.getCouNo());
                              v.add(pc.getCouName());
                              v.add(pc.getLearnType());
                              v.add(pc.getProName());
                              v.add(pc.getCreditType());
                              v.add(pc.getGrade());
                              v.add(pc.getIsEva());
                              dft_score2.addRow(v);
                    }
          }

          protected void selectRowStudent(MouseEvent e) {
                 index=table_student.getSelectedRow();
                 sno=dft_stuList.getValueAt(index, 0).toString();
                 String sname=dft_stuList.getValueAt(index, 1).toString();
                 label_name.setText(sname);
                 
                 String deptName=dft_stuList.getValueAt(index, 2).toString();
                 orgid=this.getOrgidByName(deptName);
                 setTable_scoreAvg(new PerCourse(), sno);
                 
                 YearDeptStand yds=new YearDeptStand();
                 yds.setOrgId(orgid);
                 setTable_credit(yds);
                 setTable_score3(); 
          }
          private void setTable_score3() {
                    dft_score2.setRowCount(0);
          }
          //table_score
          protected void setTable_scoreAvg(PerCourse perCourse, String sno) {
                    dft_score= (DefaultTableModel) table_score.getModel();
                    dft_score.setRowCount(0);
                    PerCourseDao pcDao=new PerCourseDao();
                    List<PerCourse> pcList = pcDao.getPCList2(perCourse,sno);
                    for(PerCourse pc : pcList){
                              String year=pc.getYear();
                              int term = pc.getTerm();
                              Vector v=new Vector();
                              v.add(year);
                              v.add(term);
                              v.add(pcDao.getCreditApply(year,term,sno));
                              v.add(pcDao.getCreditCurr(year,term,sno));
                              v.add(pcDao.getAvg(year,term,sno));
                              dft_score.addRow(v);
                    }
          }
          // table다시 설정
          public void setStudentTable(Student student){
                   
                   dft_stuList.setRowCount(0);
                   StudentDao studentDao=new StudentDao();
                   List<Student> studentList = studentDao.getStudentList(student);
                   for(Student s : studentList){
                             Vector v=new Vector();
                             v.add(s.getsNo());//0
                             v.add(s.getName());//2
                             v.add(this.getDeptNameById(s.getOrgId()));//1
                             v.add(s.getInSchYear());//3
                             v.add(s.getDegreeProcess());//5
                             
                             dft_stuList.addRow(v);
                   }
                   studentDao.closeDao();
                   
          }
          protected void setTable_credit(YearDeptStand ydStand) {
                    DefaultTableModel dft = (DefaultTableModel) table_credit.getModel();
                    dft.setRowCount(0);
                    //기준학점
                    YearDeptStandDao ydDao=new YearDeptStandDao();
                    YearDeptStand ydsObj = ydDao.getYDSObj3(ydStand);
                    int learned1=0,major1=0,majMust1=0,majCho1=0,culture1=0,culMust1=0,culCho1=0;
                    try {
                                learned1=ydsObj.getCredit();
                                major1=ydsObj.getMajor();
                                majMust1=ydsObj.getMajorMust();
                                majCho1=ydsObj.getMajorChose();
                                culture1=ydsObj.getCul();
                                culMust1=ydsObj.getCulMust();
                                culCho1=ydsObj.getCulChose();
                    } catch (Exception e) {
                                learned1=0;
                                major1=0;
                                majMust1=0;
                                majCho1=0;
                                culture1=0;
                                culMust1=0;
                                culCho1=0;
                    }
                              Vector v=new Vector();
                              v.add("학과기준학점");
                              v.add(learned1);
                              v.add(major1);
                              v.add(majMust1);
                              v.add(majCho1);
                              v.add(culture1);
                              v.add(culMust1);
                              v.add(culCho1);
                              dft.addRow(v);
                              //이수학점:
                              //전공이수
                              PerCourseDao perDao=new PerCourseDao();
                              int majMust2= perDao.getMajMust(sno);
                              int majCho2=perDao.getMajCho(sno);
                              int major2=majMust2+majCho2;
                              int culMust2=perDao.getCulMust(sno);
                              int culCho2=perDao.getCulCho(sno);
                              int culture2=culMust2+culCho2;
                              int learned2=major2+culture2;
                              Vector v2=new Vector();
                              v2.add("이수 학점");
                              v2.add(learned2);
                              v2.add(major2);
                              v2.add(majMust2);
                              v2.add(majCho2);
                              v2.add(culture2);
                              v2.add(culMust2);
                              v2.add(culCho2);
                              dft.addRow(v2);
                              //미수학점:
                              int learned3=learned1-learned2;
                              int major3=major1-major2;
                              int majMust3=majMust1-majMust2;
                              int majCho3=majCho1-majCho2;
                              int culture3=culture1-culture2;
                              int culMust3=culMust1-culMust2;
                              int culCho3=culCho1-culCho2;
                              Vector v3=new Vector();
                              v3.add("미수 학점");
                              v3.add(learned3);
                              v3.add(major3);
                              v3.add(majMust3);
                              v3.add(majCho3);
                              v3.add(culture3);
                              v3.add(culMust3);
                              v3.add(culCho3);
                              dft.addRow(v3);
          }
        private Object getDeptNameById(String orgId) {
                  OrgDao orgDao=new OrgDao();
                  String orgName = orgDao.getOrgName(orgId);
                  return orgName;
        }
        private String getOrgidByName(String deptName) {
                  OrgDao orgDao=new OrgDao();
                  String orgid = orgDao.getOrgid(deptName);
                  return orgid;
        }
}
