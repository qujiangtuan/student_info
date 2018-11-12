package com.qujia.view;
/*
 * 수강신청
 */
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.PerCourseDao;
import com.qujia.dao.StudentDao;
import com.qujia.dao.YearDeptStandDao;
import com.qujia.model.PerCourse;
import com.qujia.model.Student;
import com.qujia.model.YearDeptStand;
import com.qujia.util.DateUtil;
import com.qujia.util.ViewUtil;

public class ScoreShowToStudentFrm extends JFrame {

          private JPanel contentPane;
          private JPanel panel_one,panel_two,panel_three;
          private CardLayout card=null;
          private JPanel panel_c_1=null,panel_c_2=null;
          private final ButtonGroup buttonGroup = new ButtonGroup();
          private JTable table_scoreAll;
          private JTable table_scoreAvg;
          private JTable table_credit;
          private JButton creditButton;
          private JButton evaButton;
          private Student student,stuTemp;
          private DefaultTableModel dft_scoreAll,dft_scoreAvg;
          private PerCourseDao pcDao;
          private static int index=-1;
          private static String couNo;
          private static String couName;
          private String sno;
          private JLabel label_year,label_term;
          private JSpinner spinner_year;
          private JComboBox comboBox_term;
          private JCheckBox yearTermCheckBox;
          private JButton search_Button;
          private JLabel label;
          private JLabel label_dept;
          private String orgid;
          private static String subName;
          private static String proName;
          
          
          
          public static String getSubName() {
                    return subName;
          }

          public static void setSubName(String subName) {
                    ScoreShowToStudentFrm.subName = subName;
          }

          public static String getProName() {
                    return proName;
          }

          public static void setProName(String proName) {
                    ScoreShowToStudentFrm.proName = proName;
          }

          public static String getCouNo() {
                    return couNo;
          }

          public static void setCouNo(String couNo) {
                    ScoreShowToStudentFrm.couNo = couNo;
          }

          public static String getCouName() {
                    return couName;
          }

          public static void setCouName(String couName) {
                    ScoreShowToStudentFrm.couName = couName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreShowToStudentFrm frame = new ScoreShowToStudentFrm();
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
          public ScoreShowToStudentFrm() {
                    this.setResizable(false);
                    
                    student =(Student) MainFrm.userObject;
                    StudentDao stuDao=new StudentDao();
                    stuTemp=stuDao.login(student);
                    sno=stuTemp.getsNo();
                    orgid=stuTemp.getOrgId();
                    setTitle("\uC131\uC801\uC870\uD76C");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 908, 500);
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    panel_one = new JPanel();
                    panel_one.setBounds(17, 5, 870, 44);
                    Border border_1=BorderFactory.createTitledBorder("개인정보");
                    panel_one.setBorder(border_1);
                    
                    panel_two = new JPanel();
                    panel_two.setBounds(17, 59, 870, 90);
                    Border border_2=BorderFactory.createTitledBorder("조희조건");
                    panel_two.setBorder(border_2);
                    
                    card=new CardLayout(0, 0);
                    panel_three = new JPanel(card);
                    panel_three.setBounds(17, 159, 870, 266);
                    
                    panel_three.setLayout(card);
                    
                    panel_c_1 = new JPanel();
                    panel_three.add(panel_c_1, "panel_c_1");
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    GroupLayout gl_panel_c_1 = new GroupLayout(panel_c_1);
                    gl_panel_c_1.setHorizontalGroup(
                              gl_panel_c_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_1.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    gl_panel_c_1.setVerticalGroup(
                              gl_panel_c_1.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_1.createSequentialGroup()
                                                  .addGap(7)
                                                  .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    
                    table_scoreAll = new JTable();
                    table_scoreAll.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent arg0) {
                                        index=table_scoreAll.getSelectedRow();
                                       
                                        subName=dft_scoreAll.getValueAt(index, 3).toString();
                                        proName = dft_scoreAll.getValueAt(index, 5).toString();
                              }
                    });
                    table_scoreAll.setRowHeight(25);
                    table_scoreAll.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uB144\uB3C4", "\uD559\uAE30", "\uACFC\uBAA9\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uC774\uC218\uAD6C\uBD84", "\uB2F4\uB2F9\uAD50\uC218", "\uD559\uC810", "\uB4F1\uAE09", "\uAC15\uC758\uD3C9\uAC00\uC644\uB8CC\uC5EC\uBD80"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_scoreAll.getColumnModel().getColumn(1).setPreferredWidth(47);
                    table_scoreAll.getColumnModel().getColumn(3).setPreferredWidth(188);
                    table_scoreAll.getColumnModel().getColumn(4).setPreferredWidth(58);
                    table_scoreAll.getColumnModel().getColumn(6).setPreferredWidth(44);
                    table_scoreAll.getColumnModel().getColumn(7).setPreferredWidth(38);
                    table_scoreAll.getColumnModel().getColumn(8).setPreferredWidth(112);
                    scrollPane_1.setViewportView(table_scoreAll);
                    panel_c_1.setLayout(gl_panel_c_1);
                    
                    panel_c_2 = new JPanel();
                    panel_three.add(panel_c_2, "panel_c_2");
                    
                    JLabel lblNewLabel = new JLabel("\uD559\uAE30\uBCC4 \uC131\uC801\uB204\uACC4");
                    
                    JScrollPane scrollPane_2 = new JScrollPane();
                    GroupLayout gl_panel_c_2 = new GroupLayout(panel_c_2);
                    gl_panel_c_2.setHorizontalGroup(
                              gl_panel_c_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_2.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_panel_c_2.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                                                            .addComponent(lblNewLabel))
                                                  .addContainerGap())
                    );
                    gl_panel_c_2.setVerticalGroup(
                              gl_panel_c_2.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_2.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(lblNewLabel)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    
                    table_scoreAvg = new JTable();
                    table_scoreAvg.setRowHeight(25);
                    table_scoreAvg.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uB144\uB3C4", "\uD559\uAE30", "\uC2E0\uCCAD\uD559\uC810", "\uCDE8\uB4DD\uD559\uC810", "\uD3C9\uC810"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        true, false, true, true, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_scoreAvg.getColumnModel().getColumn(0).setPreferredWidth(54);
                    table_scoreAvg.getColumnModel().getColumn(1).setPreferredWidth(37);
                    scrollPane_2.setViewportView(table_scoreAvg);
                    panel_c_2.setLayout(gl_panel_c_2);
                    
                    JPanel panel_c_3 = new JPanel();
                    panel_three.add(panel_c_3, "panel_c_3");
                    
                    JScrollPane scrollPane_3 = new JScrollPane();
                    GroupLayout gl_panel_c_3 = new GroupLayout(panel_c_3);
                    gl_panel_c_3.setHorizontalGroup(
                              gl_panel_c_3.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_3.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                                                  .addContainerGap())
                    );
                    gl_panel_c_3.setVerticalGroup(
                              gl_panel_c_3.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel_c_3.createSequentialGroup()
                                                  .addGap(24)
                                                  .addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(26, Short.MAX_VALUE))
                    );
                    
                    table_credit = new JTable();
                    table_credit.setRowHeight(25);
                    table_credit.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {"\uD559\uACFC\uAE30\uC900\uD559\uC810", "", null, null, null, null, null, null},
                                        {"\uC774\uC218 \uD559\uC810 ", "", null, null, null, null, null, null},
                                        {"\uBBF8\uC218 \uD559\uC810 ", "", null, null, null, null, null, null},
                              },
                              new String[] {
                                        "", "\uC878\uC5C5\uC774\uC218\uD559\uC810", "\uC804\uACF5\uC774\uC218\uD559\uC810", "\uC804\uACF5\uD544\uC218\uD559\uC810", "\uC804\uACF5\uC120\uD0DD\uD559\uC810", "\uAD50\uC591\uC774\uC218\uD559\uC810", "\uAD50\uC591\uD544\uC218\uD559\uC810", "\uAD50\uC591\uC120\uD0DD\uD559\uC810"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, true, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_credit.getColumnModel().getColumn(0).setPreferredWidth(94);
                    table_credit.getColumnModel().getColumn(1).setPreferredWidth(95);
                    table_credit.getColumnModel().getColumn(2).setPreferredWidth(99);
                    table_credit.getColumnModel().getColumn(3).setPreferredWidth(91);
                    table_credit.getColumnModel().getColumn(4).setPreferredWidth(97);
                    table_credit.getColumnModel().getColumn(5).setPreferredWidth(106);
                    table_credit.getColumnModel().getColumn(6).setPreferredWidth(91);
                    table_credit.getColumnModel().getColumn(7).setPreferredWidth(93);
                    scrollPane_3.setViewportView(table_credit);
                    panel_c_3.setLayout(gl_panel_c_3);
                    
                    JLabel label_name = new JLabel("성          명:");
                    label_name.setBounds(18, 17, 91, 15);
                    
                    JLabel label_no = new JLabel("\uD559    \uBC88:");
                    label_no.setBounds(333, 17, 61, 15);
                    
                    JLabel stuNameLabel = new JLabel("\uCDE8\uC9C0\uC559\uD22C\uC548");
                    stuNameLabel.setText(stuTemp.getName());
                    stuNameLabel.setBounds(104, 17, 119, 15);
                    
                    JLabel snoLabel = new JLabel("201518047");
                    snoLabel.setText(stuTemp.getsNo()); 
                    snoLabel.setBounds(395, 17, 119, 15);
                    
                    JRadioButton all_RadioButton = new JRadioButton("전체학기");
                    all_RadioButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        index=-1;
                              }
                    });
                    all_RadioButton.setBounds(122, 17, 87, 23);
                    all_RadioButton.setSelected(true);
                    buttonGroup.add(all_RadioButton);
                    
                    JRadioButton current_RadioButton = new JRadioButton("\uD574\uB2F9\uD559\uAE30");
                    current_RadioButton.setBounds(18, 17, 86, 23);
                    current_RadioButton.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent arg0) {
                                        String year;
                                        int term;
                                        if(current_RadioButton.isSelected()){
                                                  evaButton.setVisible(true);
                                                  label_year.setVisible(false);
                                                  label_term.setVisible(false);
                                                  spinner_year.setVisible(false);
                                                  comboBox_term.setVisible(false);
                                                  yearTermCheckBox.setVisible(false);
                                                  index=-1;
                                                  
                                                  year=DateUtil.getThisYear();
                                                  term=DateUtil.getTerm();
                                                  PerCourse per=new PerCourse();
                                                  per.setYear(year);
                                                  per.setTerm(term);
                                                  setTable_scoreAll(per,sno);
                                        }else{
                                                  evaButton.setVisible(false);
                                                  label_year.setVisible(true);
                                                  label_term.setVisible(true);
                                                  spinner_year.setVisible(true);
                                                  comboBox_term.setVisible(true);
                                                  yearTermCheckBox.setVisible(true);
                                                  
                                                  
                                                  PerCourse per=new PerCourse();
                                                  per.setYear(null);
                                                  per.setTerm(0);
                                                  setTable_scoreAll(per,sno);
                                        }
                              }
                    });
                    buttonGroup.add(current_RadioButton);
                    
                    label_year = new JLabel("년도:");
                    label_year.setBounds(239, 21, 37, 15);
                    
                    comboBox_term = new JComboBox();
                    comboBox_term.setEnabled(false);
                    comboBox_term.setBounds(387, 18, 58, 21);
                    comboBox_term.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
                    comboBox_term.setEditable(true);
                    
                    spinner_year = new JSpinner();
                    spinner_year.setEnabled(false);
                    spinner_year.setBounds(276, 18, 64, 22);
                    spinner_year.setModel(new SpinnerListModel(new String[] {"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049"}));
                    
                    JButton all_Button = new JButton("\uC804\uC81C\uACFC\uBAA9\uC131\uC801");
                    all_Button.setBounds(18, 58, 130, 23);
                    all_Button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        search_Button.setVisible(true);
                                        current_RadioButton.setVisible(true);
                                        all_RadioButton.setVisible(true);
                                        buttonGroup.clearSelection();
                                        all_RadioButton.setSelected(true);
                                        label_year.setVisible(true);
                                        label_term.setVisible(true);
                                        spinner_year.setVisible(true);
                                        comboBox_term.setVisible(true);
                                        yearTermCheckBox.setVisible(true);
                                        index=-1;
                                        
                                        card.show(panel_three,"panel_c_1");
                                        setTable_scoreAll(new PerCourse(),sno);
                              }
                    });
                    
                    JButton term_Button = new JButton("\uB204\uACC4\uC131\uC801");
                    term_Button.setBounds(166, 58, 87, 23);
                    term_Button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        search_Button.setVisible(false);
                                        evaButton.setVisible(false);
                                        current_RadioButton.setVisible(false);
                                        all_RadioButton.setVisible(false);
                                        label_year.setVisible(false);
                                        label_term.setVisible(false);
                                        spinner_year.setVisible(false);
                                        comboBox_term.setVisible(false);
                                        yearTermCheckBox.setVisible(false);
                                        index=-1;
                                        
                                        card.show(panel_three,"panel_c_2");
                                        setTable_scoreAvg(new PerCourse(),sno);
                              }
                    });
                    
                    search_Button = new JButton("\uC870\uD76C");
                    search_Button.setBounds(776, 58, 68, 23);
                    search_Button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        String year;
                                        int term;
                                       if(all_RadioButton.isSelected()){
                                                 if(yearTermCheckBox.isSelected()){
                                                           year = spinner_year.getValue().toString();
                                                           term =Integer.parseInt(comboBox_term.getSelectedItem().toString());
                                                           PerCourse per=new PerCourse();
                                                           per.setYear(year);
                                                           per.setTerm(term);
                                                           setTable_scoreAll(per,sno);
                                                 }else{
                                                           PerCourse per=new PerCourse();
                                                           per.setYear(null);
                                                           per.setTerm(0);
                                                           setTable_scoreAll(per,sno);
                                                 }
                                       }else{
                                                 year=DateUtil.getThisYear();
                                                 term=DateUtil.getTerm();
                                                 PerCourse per=new PerCourse();
                                                 per.setYear(year);
                                                 per.setTerm(term);
                                                 setTable_scoreAll(per,sno);
                                       }
                                        
                              }
                    });
                    
                    evaButton = new JButton("\uAC15\uC758\uD3C9\uAC00");
                    evaButton.setBounds(677, 58, 92, 23);
                    evaButton.setVisible(false);
                    evaButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    	          courseEvaAction(e);
                    	}
                    });
                    
                    creditButton = new JButton("\uD559\uC810\uD655\uC778");
                    creditButton.setBounds(265, 58, 90, 23);
                    creditButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        search_Button.setVisible(false);
                                        evaButton.setVisible(false);
                                        current_RadioButton.setVisible(false);
                                        all_RadioButton.setVisible(false);
                                        label_year.setVisible(false);
                                        label_term.setVisible(false);
                                        spinner_year.setVisible(false);
                                        comboBox_term.setVisible(false);
                                        yearTermCheckBox.setVisible(false);
                                        index=-1;
                                        
                                        card.show(panel_three, "panel_c_3");
                                        YearDeptStand yds=new YearDeptStand();
                                        yds.setOrgId(orgid);
                                        setTable_credit(yds);
                              }
                    });
                    contentPane.setLayout(null);
                    contentPane.add(panel_three);
                    contentPane.add(panel_two);
                    panel_two.setLayout(null);
                    panel_two.add(all_Button);
                    panel_two.add(term_Button);
                    panel_two.add(creditButton);
                    panel_two.add(evaButton);
                    panel_two.add(search_Button);
                    panel_two.add(all_RadioButton);
                    panel_two.add(current_RadioButton);
                    panel_two.add(label_year);
                    panel_two.add(spinner_year);
                    panel_two.add(comboBox_term);
                    
                    label_term = new JLabel("학기:");
                    label_term.setBounds(352, 21, 37, 15);
                    panel_two.add(label_term);
                    
                    yearTermCheckBox = new JCheckBox("");
                    yearTermCheckBox.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(yearTermCheckBox.isSelected()){
                                                  spinner_year.setEnabled(true);
                                                  comboBox_term.setEnabled(true);
                                        }else{
                                                  spinner_year.setEnabled(false);
                                                  comboBox_term.setEnabled(false);
                                        }
                              }
                    });
                    yearTermCheckBox.setBounds(213, 17, 21, 23);
                    panel_two.add(yearTermCheckBox);
                    contentPane.add(panel_one);
                    panel_one.setLayout(null);
                    panel_one.add(label_name);
                    panel_one.add(stuNameLabel);
                    panel_one.add(label_no);
                    panel_one.add(snoLabel);
                    
                    label = new JLabel("학  과:");
                    label.setBounds(623, 17, 50, 15);
                    panel_one.add(label);
                    
                    label_dept = new JLabel((String) null);
                    label_dept.setText(stuTemp.getDeptName());
                    label_dept.setBounds(670, 17, 119, 15);
                    panel_one.add(label_dept);
                    
                    JButton btnNewButton_1 = new JButton("닫기");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    btnNewButton_1.setBounds(773, 435, 97, 23);
                    contentPane.add(btnNewButton_1);
                    
                    pcDao=new PerCourseDao();
                    
                    
                    setTable_scoreAll(new PerCourse(),sno);
          }

          protected void setTable_credit(YearDeptStand ydStand) {
                    DefaultTableModel dft = (DefaultTableModel) table_credit.getModel();
                    dft.setRowCount(0);
                    //기준학점
                    YearDeptStandDao ydDao=new YearDeptStandDao();
                    YearDeptStand ydsObj = ydDao.getYDSObj3(ydStand);
                    int learned1=ydsObj.getCredit();
                    int major1=ydsObj.getMajor();
                    int majMust1=ydsObj.getMajorMust();
                    int majCho1=ydsObj.getMajorChose();
                    int culture1=ydsObj.getCul();
                    int culMust1=ydsObj.getCulMust();
                    int culCho1=ydsObj.getCulChose();
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

          protected void setTable_scoreAvg(PerCourse perCourse, String sno2) {
                    dft_scoreAvg= (DefaultTableModel) table_scoreAvg.getModel();
                    dft_scoreAvg.setRowCount(0);
                    List<PerCourse> pcList = pcDao.getPCList2(perCourse,sno2);
                    for(PerCourse pc : pcList){
                              String year=pc.getYear();
                              int term = pc.getTerm();
//                              System.out.println(year);
//                              System.out.println(term);
                              Vector v=new Vector();
                              v.add(year);
                              v.add(term);
                              v.add(pcDao.getCreditApply(year,term,sno));
                              v.add(pcDao.getCreditCurr(year,term,sno));
                              v.add(pcDao.getAvg(year,term,sno));
                              dft_scoreAvg.addRow(v);
                    }
          }

//          private Object getAvg(String year, int term, String sno2) {
//                    // TODO Auto-generated method stub
//                    return null;
//          }
//
//          private Object getCreditCurr(String year, int term, String sno2) {
//                    // TODO Auto-generated method stub
//                    return null;
//          }
//
//          private Object getCreditApply(String year, int term, String sno2) {
//                    pcDao.getCredit
//                    return null;
//          }

          protected void courseEvaAction(ActionEvent e) {
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "평가할 과목을 선택해주세요!");
                              return;
                    }
                    String isEvn = dft_scoreAll.getValueAt(index, 8).toString();
                    if("yes".equals(isEvn)){
                              JOptionPane.showMessageDialog(this, "이 과목을 이미 평가완료 되었습니다!");
                              return;
                    }
                    couNo = dft_scoreAll.getValueAt(index, 2).toString();
                    couName=dft_scoreAll.getValueAt(index, 3).toString();
                    LectureEvalutaionFrm lef=new LectureEvalutaionFrm(new JFrame());
                    lef.setVisible(true);
                    if(LectureEvalutaionFrm.isFlag()){
                              if(pcDao.updateIsEva(sno,couNo)){
                                        PerCourse per=new PerCourse();
                                        per.setYear(null);
                                        per.setTerm(0);
                                        setTable_scoreAll(per,sno);     
                              }
                    }
          }

          private void setTable_scoreAll(PerCourse perCourse,String sno) {
                    dft_scoreAll = (DefaultTableModel) table_scoreAll.getModel();
                    dft_scoreAll.setRowCount(0);
//                    PerCourseDao pcDao=new PerCourseDao();
                    List<PerCourse> pcList = pcDao.getPCList(perCourse,sno);
                    for(PerCourse pc : pcList){
                              Vector v=new Vector();
                              v.add(pc.getYear());
                              v.add(pc.getTerm());
                              v.add(pc.getCouNo());
                              v.add(pc.getCouName());
                              v.add(pc.getLearnType());
                              v.add(pc.getProName());
                              v.add(pc.getCreditType());
//                              v.add(pc.getGrade());
                              if(pc.getIsEva().equals("yes")){
                                        v.add(pc.getGrade());
                              }else{
                                        v.add(null);
                              }
                              v.add(pc.getIsEva());
                              dft_scoreAll.addRow(v);
                    }
//                    pcDao.closeDao();
          }
}
