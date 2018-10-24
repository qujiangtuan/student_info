package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.ClassRoomDao;
import com.qujia.dao.OpenCourseDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.SubjectsDao;
import com.qujia.dao.TimeTableDao;
import com.qujia.model.ClassRoom;
import com.qujia.model.OpenCourse;
import com.qujia.model.TimeTable;
import com.qujia.model.TimeView;
import com.qujia.util.DateUtil;
import com.qujia.util.ViewUtil;

public class CourseArrangeManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JSpinner spinner_61, spinner_51, spinner_41, spinner_31,
          spinner_21, spinner_11, spinner_22,
          spinner_12, spinner_32, spinner_42,
          spinner_52, spinner_62;
          private JTextField textField_fexidNum;
          private JTextField textField_editPro;
          private JTextField textField_srarchNO;
          private JTextField textField_searchName;
          private JTextField textField_searchPro;
          private  JComboBox comboBox_editSchYear,comboBox_editTerm,comboBox_editStatus ;
          private static String editProName;
          private  String[] SchYear,term,classNo,status;
          private JSpinner spinner_classNo;
          private JRadioButton radioButton_1,radioButton_2,radioButton_3;
          private ButtonGroup bgoup;
          private static int row;
          private JCheckBox checkBox_1,checkBox_2,checkBox_3,checkBox_4,checkBox_5,checkBox_6;
          private JTextField textField_1;
          private JButton button_1;
          private JTextField textField_2;
          private JButton button_2;
          private JTextField textField_3;
          private JButton button_3;
          private JTextField textField_4;
          private JButton button_4;
          private JTextField textField_5;
          private JButton button_5;
          private JTextField textField_6;
          private JButton button_6;
          private SubjectsDao subDao=new SubjectsDao();
          private ProStaffDao psDao=new ProStaffDao();
          private TimeView[] tvArray ;
          private static List<TimeView> tvList=new ArrayList<TimeView>();
          DateUtil dux = new DateUtil();
          
          private Boolean bool1,bool2,bool3,bool4,bool5,bool6;
          private String crName1,crName2,crName3,crName4,crName5,crName6;
          private int crNo1,crNo2,crNo3,crNo4,crNo5,crNo6;
          private String week1,week2,week3,week4,week5,week6;
          private String dateStart1,dateStart2,dateStart3,dateStart4,dateStart5,dateStart6;
          private String dateEnd1,dateEnd2,dateEnd3,dateEnd4,dateEnd5,dateEnd6;
          private TimeTable tt1,tt2,tt3,tt4,tt5,tt6;
          private List<String> week = null;
          private String couNo2;
          private  DefaultTableModel dft=new DefaultTableModel();
          private OpenCourseDao ocDao=new OpenCourseDao();
          private String couNo;
          
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseArrangeManagerFrm frame = new CourseArrangeManagerFrm();
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
          public CourseArrangeManagerFrm() {
          	setTitle("개설교과목관리");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 880, 707);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("학수번호:");
                    lblNewLabel.setBounds(46, 24, 65, 15);
                    
                    JButton searchButton = new JButton("검  색");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchOpenCourse(e);
                              }
                    });
                    searchButton.setBounds(728, 20, 94, 23);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 67, 830, 247);
                    
                    JLabel label = new JLabel("수강요일");
                    label.setBounds(17, 344, 65, 15);
                    
                    checkBox_1 = new JCheckBox("월");
                    checkBox_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(checkBox_1.isSelected()){
                                                  spinner_11.setEnabled(true);
                                                  spinner_12.setEnabled(true);
                                                  textField_1.setEnabled(true);
                                                  button_1.setEnabled(true);
                                        }else{
                                                  spinner_11.setEnabled(false);
                                                  spinner_12.setEnabled(false);
                                                  textField_1.setEnabled(false);
                                                  textField_1.setText("");
                                                  button_1.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_1.setBounds(17, 385, 48, 23);
                    
                    checkBox_2 = new JCheckBox("화");
                    checkBox_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(checkBox_2.isSelected()){
                                                  spinner_21.setEnabled(true);
                                                  spinner_22.setEnabled(true);
                                                  textField_2.setEnabled(true);
                                                  button_2.setEnabled(true);
                                        }else{
                                                  spinner_21.setEnabled(false);
                                                  spinner_22.setEnabled(false);
                                                  textField_2.setEnabled(false);
                                                  textField_2.setText("");
                                                  button_2.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_2.setBounds(17, 418, 48, 23);
                    
                    checkBox_3 = new JCheckBox("수");
                    checkBox_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(checkBox_3.isSelected()){
                                                  spinner_31.setEnabled(true);
                                                  spinner_32.setEnabled(true);
                                                  textField_3.setEnabled(true);
                                                  button_3.setEnabled(true);
                                        }else{
                                                  spinner_31.setEnabled(false);
                                                  spinner_32.setEnabled(false);
                                                  textField_3.setEnabled(false);
                                                  textField_3.setText("");
                                                  button_3.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_3.setBounds(17, 450, 48, 23);
                    
                    checkBox_4 = new JCheckBox("목");
                    checkBox_4.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(checkBox_4.isSelected()){
                                                  spinner_41.setEnabled(true);
                                                  spinner_42.setEnabled(true);
                                                  textField_4.setEnabled(true);
                                                  button_4.setEnabled(true);
                                        }else{
                                                  spinner_41.setEnabled(false);
                                                  spinner_42.setEnabled(false);
                                                  textField_4.setEnabled(false);
                                                  textField_4.setText("");
                                                  button_4.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_4.setBounds(17, 482, 48, 23);
                    
                    checkBox_5 = new JCheckBox("금");
                    checkBox_5.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(checkBox_5.isSelected()){
                                                  spinner_51.setEnabled(true);
                                                  spinner_52.setEnabled(true);
                                                  textField_5.setEnabled(true);
                                                  button_5.setEnabled(true);
                                        }else{
                                                  spinner_51.setEnabled(false);
                                                  spinner_52.setEnabled(false);
                                                  textField_5.setEnabled(false);
                                                  textField_5.setText("");
                                                  button_5.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_5.setBounds(17, 510, 48, 23);
                    
                    checkBox_6 = new JCheckBox("토");
                    checkBox_6.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(checkBox_6.isSelected()){
                                                  spinner_61.setEnabled(true);
                                                  spinner_62.setEnabled(true);
                                                  textField_6.setEnabled(true);
                                                  button_6.setEnabled(true);
                                        }else{
                                                  spinner_61.setEnabled(false);
                                                  spinner_62.setEnabled(false);
                                                  textField_6.setEnabled(false);
                                                  textField_6.setText("");
                                                  button_6.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_6.setBounds(17, 542, 48, 23);
                    
                    JLabel label_1 = new JLabel("시작시간");
                    label_1.setBounds(89, 344, 91, 15);
                    
                    
                    // spinner_1_1.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_61 = new JSpinner(new SpinnerDateModel());
                    spinner_61.setBounds(87, 542, 93, 22);

                    spinner_51 = new JSpinner(new SpinnerDateModel());
                    spinner_51.setBounds(87, 510, 93, 22);

                    spinner_41 = new JSpinner(new SpinnerDateModel());
                    spinner_41.setBounds(87, 482, 93, 22);

                    spinner_31 = new JSpinner(new SpinnerDateModel());
                    spinner_31.setBounds(87, 450, 93, 22);

                    spinner_21 = new JSpinner(new SpinnerDateModel());
                    spinner_21.setBounds(87, 418, 93, 22);

                    spinner_11 = new JSpinner(new SpinnerDateModel());
                    spinner_11.setBounds(87, 386, 93, 22);

                    spinner_22 = new JSpinner(new SpinnerDateModel());
                    spinner_22.setBounds(205, 418, 102, 22);

                    spinner_12= new JSpinner(new SpinnerDateModel());
                    spinner_12.setBounds(205, 386, 102, 22);

                    spinner_32 = new JSpinner(new SpinnerDateModel());
                    spinner_32.setBounds(205, 450, 102, 22);

                    spinner_42 = new JSpinner(new SpinnerDateModel());
                    spinner_42.setBounds(205, 482, 102, 22);

                    spinner_52 = new JSpinner(new SpinnerDateModel());
                    spinner_52.setBounds(205, 510, 102, 22);

                    spinner_62 = new JSpinner(new SpinnerDateModel());
                    spinner_62.setBounds(205, 542, 102, 22);
                    this.setMyModel(spinner_61);
                    this.setMyModel(spinner_51);
                    this.setMyModel(spinner_41);
                    this.setMyModel(spinner_31);
                    this.setMyModel(spinner_21);
                    this.setMyModel(spinner_11);
                    this.setMyModel(spinner_22);
                    this.setMyModel(spinner_12);
                    this.setMyModel(spinner_32);
                    this.setMyModel(spinner_42);
                    this.setMyModel(spinner_52);
                    this.setMyModel(spinner_62);
                    
                    JLabel label_2 = new JLabel("종료시간");
                    label_2.setBounds(220, 344, 65, 15);
                    
                    JLabel label_3 = new JLabel("강의실");
                    label_3.setBounds(389, 347, 80, 15);
                    
                    JLabel label_4 = new JLabel("담당교수:");
                    label_4.setBounds(568, 347, 65, 15);
                    
                    JLabel lblNewLabel_1 = new JLabel("대상학년:");
                    lblNewLabel_1.setBounds(568, 389, 66, 15);
                   
                    comboBox_editSchYear = new JComboBox();
                    SchYear=new String[] {"1학년", "2학년", "3학년", "4학년", "대학원"};
                    comboBox_editSchYear.setModel(new DefaultComboBoxModel(SchYear));
                    comboBox_editSchYear.setBounds(646, 386, 116, 21);
                    
                    JLabel lblNewLabel_2 = new JLabel("학기:");
                    lblNewLabel_2.setBounds(591, 429, 43, 15);
                    
                    comboBox_editTerm = new JComboBox();
                    term=new String[] {"1학기", "2학기", "여름계절학기", "겨울계절학기"};
                    comboBox_editTerm.setModel(new DefaultComboBoxModel(term));
                    comboBox_editTerm.setBounds(646, 426, 116, 21);
                    
                    JLabel lblNewLabel_3 = new JLabel("분반:");
                    lblNewLabel_3.setBounds(591, 468, 43, 15);
                    
                    JLabel lblNewLabel_4 = new JLabel("정원:");
                    lblNewLabel_4.setBounds(591, 513, 43, 15);
                    
                    textField_fexidNum = new JTextField();
                    textField_fexidNum.setBounds(646, 510, 116, 21);
                    textField_fexidNum.setColumns(10);
                    
                    JButton submitButton = new JButton("수 정");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateOpenCourse(e);
                              }
                    });
                    submitButton.setBounds(433, 600, 91, 23);
                    submitButton.setBackground(new Color(224, 255, 255));
                    
                    JButton deleteButton = new JButton("삭 제");
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteAction(e);
                              }
                    });
                    deleteButton.setBounds(598, 600, 80, 23);
                    deleteButton.setBackground(new Color(255, 160, 122));
                    
                    JLabel lblNewLabel_5 = new JLabel("개폐상태:");
                    lblNewLabel_5.setBounds(568, 554, 66, 15);
                    
                    comboBox_editStatus = new JComboBox();
                    comboBox_editStatus.setBounds(646, 551, 116, 21);
                    status=new String[] {"", "개설", "폐강"};
                    comboBox_editStatus.setModel(new DefaultComboBoxModel(status));
                    
                    textField_editPro = new JTextField();
                    textField_editPro.setBounds(645, 344, 116, 21);
                    textField_editPro.setColumns(10);
                    
                    JButton button_sPro = new JButton("조회");
                    button_sPro.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchProfroCourseFrm spcf=new SearchProfroCourseFrm(new JFrame());
                                        spcf.setVisible(true);
                                        editProName=addSearchPro();
                                        textField_editPro.setText(editProName);
                              }
                    });
                    button_sPro.setBounds(763, 343, 65, 23);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectRowAction(e);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAC1C\uD3D0\uC0C1\uD0DC", "\uD559\uC218\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uB2F4\uB2F9\uAD50\uC218", "\uB300\uC0C1\uD559\uB144", "\uD559\uAE30", "\uBD84\uBC18", "\uC815\uC6D0", "\uD604\uC708", "\uC2DC\uAC04/\uAC15\uC758\uC2E4", "\uB4F1\uB85D\uC77C\uC790"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(2).setPreferredWidth(127);
                    table.getColumnModel().getColumn(4).setPreferredWidth(73);
                    table.getColumnModel().getColumn(9).setPreferredWidth(389);
                    table.getColumnModel().getColumn(10).setPreferredWidth(91);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(textField_editPro);
                    contentPane.add(button_sPro);
                    contentPane.add(lblNewLabel);
                    contentPane.add(searchButton);
                    contentPane.add(scrollPane);
                    contentPane.add(checkBox_3);
                    contentPane.add(spinner_31);
                    contentPane.add(spinner_32);
                    contentPane.add(checkBox_4);
                    contentPane.add(spinner_41);
                    contentPane.add(spinner_42);
                    contentPane.add(checkBox_5);
                    contentPane.add(spinner_51);
                    contentPane.add(spinner_52);
                    contentPane.add(checkBox_6);
                    contentPane.add(spinner_61);
                    contentPane.add(spinner_62);
                    contentPane.add(label);
                    contentPane.add(label_1);
                    contentPane.add(checkBox_1);
                    contentPane.add(spinner_11);
                    contentPane.add(spinner_12);
                    contentPane.add(label_2);
                    contentPane.add(label_3);
                    contentPane.add(checkBox_2);
                    contentPane.add(spinner_21);
                    contentPane.add(spinner_22);
                    contentPane.add(label_4);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(comboBox_editStatus);
                    contentPane.add(textField_fexidNum);
                    contentPane.add(comboBox_editTerm);
                    contentPane.add(comboBox_editSchYear);
                    contentPane.add(submitButton);
                    contentPane.add(deleteButton);
                    
                    JLabel lblNewLabel_6 = new JLabel("교과목명:");
                    lblNewLabel_6.setBounds(281, 24, 65, 15);
                    contentPane.add(lblNewLabel_6);
                    
                    JLabel label_5 = new JLabel("담당교수:");
                    label_5.setBounds(523, 24, 65, 15);
                    contentPane.add(label_5);
                    
                    textField_srarchNO = new JTextField();
                    textField_srarchNO.setBounds(113, 21, 116, 21);
                    contentPane.add(textField_srarchNO);
                    textField_srarchNO.setColumns(10);
                    
                    textField_searchName = new JTextField();
                    textField_searchName.setEnabled(false);
                    textField_searchName.setBounds(350, 21, 116, 21);
                    contentPane.add(textField_searchName);
                    textField_searchName.setColumns(10);
                    
                    textField_searchPro = new JTextField();
                    textField_searchPro.setEnabled(false);
                    textField_searchPro.setBounds(600, 21, 116, 21);
                    contentPane.add(textField_searchPro);
                    textField_searchPro.setColumns(10);
                    
                    spinner_classNo = new JSpinner();
                    classNo=new String[] {"101", "102", "103", "104", "105", "106", "107", "108", "109", "110"};
                    spinner_classNo.setModel(new SpinnerListModel(classNo));
                    spinner_classNo.setBounds(645, 465, 116, 22);
                    contentPane.add(spinner_classNo);
                    
                   
                    radioButton_1 = new JRadioButton("");
                    radioButton_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent arg0) {
                                        if(radioButton_1.isSelected()){
                                                  textField_srarchNO.setEnabled(true);
                                                  textField_searchName.setEnabled(false);
                                                  textField_searchName.setText("");
                                                  textField_searchPro.setEnabled(false);
                                                  textField_searchPro.setText("");
                                        }else{
                                                  textField_srarchNO.setEnabled(false);
                                        }
                              }
                    });
                    radioButton_1.setSelected(true);
                    radioButton_1.setBounds(17, 20, 21, 23);
                    contentPane.add(radioButton_1);
                    
                    radioButton_2 = new JRadioButton("");
                    radioButton_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(radioButton_2.isSelected()){
                                                  textField_searchName.setEnabled(true);
                                                  textField_searchPro.setEnabled(false);
                                                  textField_searchPro.setText("");
                                                  textField_srarchNO.setEnabled(false);
                                                  textField_srarchNO.setText("");
                                        }else{
                                                  textField_searchName.setEnabled(false);
                                        }
                                        
                              }
                    });
                    radioButton_2.setBounds(255, 20, 21, 23);
                    contentPane.add(radioButton_2);
                    
                    radioButton_3 = new JRadioButton("");
                    radioButton_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(radioButton_3.isSelected()){
                                                  textField_searchPro.setEnabled(true);
                                                  textField_srarchNO.setEnabled(false);
                                                  textField_srarchNO.setText("");
                                                  textField_searchName.setEnabled(false);
                                                  textField_searchName.setText(""); 
                                        }else{
                                                  textField_searchPro.setEnabled(false);
                                        }
                                        
                              }
                    });
                    radioButton_3.setBounds(503, 20, 21, 23);
                    contentPane.add(radioButton_3);
                    bgoup=new ButtonGroup();
                    bgoup.add(radioButton_1);
                    bgoup.add(radioButton_2);
                    bgoup.add(radioButton_3);
                    
                    textField_1 = new JTextField();
                    textField_1.setBounds(339, 386, 80, 21);
                    contentPane.add(textField_1);
                    textField_1.setColumns(10);
                    
                    button_1 = new JButton("조회");
                    button_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf=new SearchClassRoomFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_1.setText(addSearchCR());
                              }
                    });
                    button_1.setBounds(427, 385, 65, 23);
                    contentPane.add(button_1);
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    textField_2.setBounds(339, 419, 80, 21);
                    contentPane.add(textField_2);
                    
                    button_2 = new JButton("조회");
                    button_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf=new SearchClassRoomFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_2.setText(addSearchCR());
                              }
                    });
                    button_2.setBounds(427, 418, 65, 23);
                    contentPane.add(button_2);
                    
                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    textField_3.setBounds(339, 451, 80, 21);
                    contentPane.add(textField_3);
                    
                    button_3 = new JButton("조회");
                    button_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf=new SearchClassRoomFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_3.setText(addSearchCR());
                              }
                    });
                    button_3.setBounds(427, 450, 65, 23);
                    contentPane.add(button_3);
                    
                    textField_4 = new JTextField();
                    textField_4.setColumns(10);
                    textField_4.setBounds(339, 483, 80, 21);
                    contentPane.add(textField_4);
                    
                    button_4 = new JButton("조회");
                    button_4.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf=new SearchClassRoomFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_4.setText(addSearchCR());
                              }
                    });
                    button_4.setBounds(427, 482, 65, 23);
                    contentPane.add(button_4);
                    
                    textField_5 = new JTextField();
                    textField_5.setColumns(10);
                    textField_5.setBounds(339, 511, 80, 21);
                    contentPane.add(textField_5);
                    
                    button_5 = new JButton("조회");
                    button_5.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf=new SearchClassRoomFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_5.setText(addSearchCR());
                              }
                    });
                    button_5.setBounds(427, 510, 65, 23);
                    contentPane.add(button_5);
                    
                    textField_6 = new JTextField();
                    textField_6.setColumns(10);
                    textField_6.setBounds(339, 543, 80, 21);
                    contentPane.add(textField_6);
                    
                    button_6 = new JButton("조회");
                    button_6.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf=new SearchClassRoomFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_6.setText(addSearchCR());
                              }
                    });
                    button_6.setBounds(427, 542, 65, 23);
                    contentPane.add(button_6);
                    
                    
                    setTable(new OpenCourse());
                    resetValue();
//                    setClassRoomName();
//                    setTime(new OpenCourse());
          }
          protected String addSearchCR() {
                    return SearchClassRoomFrm.getCrName();
          }

          protected void deleteAction(ActionEvent e) {
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    //시간 수정
                    getTimeObject(couNo);
                    TimeTableDao ttDao = new TimeTableDao();
                    boolean c1 = false, c2 = false, c3 = false, c4 = false, c5 = false, c6 = false;
                    
                    OpenCourseDao ocDao=new OpenCourseDao();
                    String couNO=table.getValueAt(row, 1).toString();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(true){
                                        if (bool1) {
                                                if(week.contains(tt1.getWeek())){
                                                          c1=ttDao.deleteTT1(tt1);                           
                                                }
                                        }
                                        if (bool2) {
                                                if(week.contains(tt2.getWeek())){
                                                          c2=ttDao.deleteTT2(tt2);                           
                                                }
                                        }
                                        if (bool3) {
                                                if(week.contains(tt3.getWeek())){
                                                          c3=ttDao.deleteTT3(tt3);                           
                                                }
                                        }
                                        if (bool4) {
                                                if(week.contains(tt4.getWeek())){
                                                          c4=ttDao.deleteTT4(tt4);                           
                                                }
                                        }
                                        if (bool5) {
                                                if(week.contains(tt5.getWeek())){
                                                          c5=ttDao.deleteTT5(tt5);                           
                                                }
                                        }
                                        if (bool6) {
                                                if(week.contains(tt6.getWeek())){
                                                          c6=ttDao.deleteTT6(tt6);                           
                                                }
                                        }
                                        if (bool1 == c1 && bool2 == c2 && bool3 == c3
                                                                                && bool4 == c4 && bool5 == c5
                                                                                && bool6 == c6) {
                                                  if(ocDao.deleteOC(couNO)){
                                                            JOptionPane.showMessageDialog(this,
                                                                                "삭제 성공했습니다!");
                                                  }else{
                                                            JOptionPane.showMessageDialog(this,
                                                                                "삭제 실패했습니다!");
                                                  }
                                                  
                                        }else{
                                                  JOptionPane.showMessageDialog(this,
                                                                      "삭제 실패했습니다!");
                                        }
//                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                              }
                    }
                    
                    ocDao.closeDao();
                    setTable(new OpenCourse());
                    resetValue();
          }

          //수정
          protected void updateOpenCourse(ActionEvent e) {
                    
                    String editProName = textField_editPro.getText().toString();
                    String pno=getProIdByProName(editProName);
                    String schYear = comboBox_editSchYear.getSelectedItem().toString();
                    String term = comboBox_editTerm.getSelectedItem().toString();
                    String classNo = spinner_classNo.getValue().toString();
                    int fixedNum = Integer.parseInt(textField_fexidNum.getText().toString());
                    String status = comboBox_editStatus.getSelectedItem().toString();
                    
//                    String couNo=dft.getValueAt(row,1).toString();
//                    String classStr=null;
//                    tvList=ocDao.getTimeList(couNo);
//                    String classStr2=this.listToString2(tvList,',');
                    
                    OpenCourse oc=new OpenCourse();
                    oc.setCouNo(couNo);
                    oc.setProId(pno);
                    oc.setProName(editProName);
                    oc.setSchYear(schYear);
                    oc.setTerm(term);
                    oc.setClassNo(classNo);
                    oc.setFixedNum(fixedNum);
                    oc.setStatus(status);
                    
                    OpenCourseDao ocDao=new OpenCourseDao();
                    
                    //시간 받기
                    getTimeObject(couNo);
                    //set ttno for every Object
                    for (TimeView tv : tvList) {
                              if("월".equals(tv.getWeek())){
                                        tt1.setTtNo(tv.getTtNo());
                              }
                              if("화".equals(tv.getWeek())){
                                        tt2.setTtNo(tv.getTtNo());
                              }
                              if("수".equals(tv.getWeek())){
                                        tt3.setTtNo(tv.getTtNo());
                              }
                              if("목".equals(tv.getWeek())){
                                        tt4.setTtNo(tv.getTtNo());
                              }
                              if("금".equals(tv.getWeek())){
                                        tt5.setTtNo(tv.getTtNo());
                              }
                              if("토".equals(tv.getWeek())){
                                        tt6.setTtNo(tv.getTtNo());
                              }
                     }
                    //요일 선택하고 나서 강의실 꼭 채위 알림
                    List<TimeTable> ttList=new ArrayList<TimeTable>();
                    String classStr = null;
                    if (bool1) {
                              ttList.add(tt1);
                              if("".equals(textField_1.getText())){
                                        JOptionPane.showMessageDialog(this, "월요일 수업의 강의실을 선택해주세요!");
                                        return;
                              }
                    }
                    if (bool2) {
                              ttList.add(tt2);
                              if("".equals(textField_2.getText())){
                                        JOptionPane.showMessageDialog(this, "화요일 수업의 강의실을 선택해주세요!");
                                        return;
                              }
                    }
                    if (bool3) {
                              ttList.add(tt3);
                              if("".equals(textField_3.getText())){
                                        JOptionPane.showMessageDialog(this, "수요일 수업의 강의실을 선택해주세요!");
                                        return;
                              }
                    } 
                    if (bool4) {
                              ttList.add(tt4);
                              if("".equals(textField_4.getText())){
                                        JOptionPane.showMessageDialog(this, "목요일 수업의 강의실을 선택해주세요!");
                                        return;
                              }
                    }
                    if (bool5) {
                              ttList.add(tt5);
                              if("".equals(textField_5.getText())){
                                        JOptionPane.showMessageDialog(this, "금요일 수업의 강의실을 선택해주세요!");
                                        return;
                              }
                    }
                    if (bool6) {
                              ttList.add(tt6);
                              if("".equals(textField_6.getText())){
                                        JOptionPane.showMessageDialog(this, "토요일 수업의 강의실을 선택해주세요!");
                                        return;
                              }
                    }
                    classStr=this.listToString2(ttList,',');
                    oc.setTtcr(classStr);
//                    System.out.println(classStr);
                    TimeTableDao ttDao = new TimeTableDao();
                    boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;
                    boolean c1 = false, c2 = false, c3 = false, c4 = false, c5 = false, c6 = false;
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(ocDao.updateOC(oc)){
                                        if (bool1) {
                                                  if(ttDao.isExistWC1(tt1)){
                                                            b1= ttDao.updateTT1(tt1);
                                                  }else{
                                                            b1 = ttDao.loginTT1(tt1);
                                                  }
                                                  
                                        }else{
                                                if(week.contains(tt1.getWeek())){
                                                          c1=ttDao.deleteTT1(tt1);                           
                                                }
                                        }
                                        if (bool2) {
                                                  if(ttDao.isExistWC2(tt2)){
                                                            b2= ttDao.updateTT2(tt2);
                                                  }else{
                                                            b2 = ttDao.loginTT2(tt2);
                                                  }
                                        }else{
                                                if(week.contains(tt2.getWeek())){
                                                          c2=ttDao.deleteTT2(tt2);                           
                                                }
                                        }
                                        if (bool3) {
                                                  if(ttDao.isExistWC3(tt3)){
                                                            b3= ttDao.updateTT3(tt3);
                                                  }else{
                                                            b3 = ttDao.loginTT3(tt3);
                                                  }
                                        }else{
                                                if(week.contains(tt3.getWeek())){
                                                          c3=ttDao.deleteTT3(tt3);                           
                                                }
                                        }
                                        if (bool4) {
                                                  if(ttDao.isExistWC4(tt4)){
                                                            b4= ttDao.updateTT4(tt4);
                                                  }else{
                                                            b4 = ttDao.loginTT4(tt4);
                                                  }
                                        }else{
                                                if(week.contains(tt4.getWeek())){
                                                          c4=ttDao.deleteTT4(tt4);                           
                                                }
                                        }
                                        if (bool5) {
                                                  if(ttDao.isExistWC5(tt5)){
                                                            b5= ttDao.updateTT5(tt5);
                                                  }else{
                                                            b5 = ttDao.loginTT5(tt5);
                                                  }
                                        }else{
                                                if(week.contains(tt5.getWeek())){
                                                          c5=ttDao.deleteTT5(tt5);                           
                                                }
                                        }
                                        if (bool6) {
                                                  if(ttDao.isExistWC6(tt6)){
                                                            b6= ttDao.updateTT6(tt6);
                                                  }else{
                                                            b6 = ttDao.loginTT6(tt6);
                                                  }
                                        }else{
                                                if(week.contains(tt6.getWeek())){
                                                          c6=ttDao.deleteTT6(tt6);                           
                                                }
                                        }
                                        if ((bool1 == b1 && bool2 == b2 && bool3 == b3
                                                            && bool4 == b4 && bool5 == b5
                                                            && bool6 == b6)||(bool1 == c1 && bool2 == c2 && bool3 == c3
                                                                                && bool4 == c4 && bool5 == c5
                                                                                && bool6 == c6)) {
                                                  JOptionPane.showMessageDialog(this,
                                                                      "수정 성공했습니다!");
                                        }else{
                                                  JOptionPane.showMessageDialog(this,
                                                                      "수정 실패했습니다!");
                                        }
//                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다.");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다!");
                              }
                    }
                    resetValue();
                    setTable(new OpenCourse());
                    
          }

          private void getTimeObject(String couNo) {
                    week=new ArrayList<String>();
                    tvList=ocDao.getTimeList(couNo);
                    for (TimeView tv1 : tvList) {
                             week.add(tv1.getWeek());
                    }
                    // 1
                    crName1 = textField_1.getText().toString();
                     crNo1 = this.getcrNo(crName1);
                     bool1 = checkBox_1.isSelected();
                     week1 = checkBox_1.getText().toString();
                     dateStart1 = dux.Date2String((Date) spinner_11.getValue());
                     dateEnd1 = dux.Date2String((Date) spinner_12.getValue());

                     tt1 = new TimeTable();
                    tt1.setBool(bool1);
                    tt1.setWeek(week1);
                    tt1.setDateStart(dateStart1);
                    tt1.setDateEnd(dateEnd1);
                    tt1.setCrId(crNo1);
                    tt1.setCouNo(couNo);
                    tt1.setCrName(crName1);
                    
                    // 2
                    crName2 = textField_2.getText().toString();
                     crNo2 = this.getcrNo(crName2);
                     bool2 = checkBox_2.isSelected();
                     week2 = checkBox_2.getText().toString();
                     dateStart2 = dux.Date2String((Date) spinner_21.getValue());
                     dateEnd2 = dux.Date2String((Date) spinner_22.getValue());

                     tt2 = new TimeTable();
                    tt2.setBool(bool2);
                    tt2.setWeek(week2);
                    tt2.setDateStart(dateStart2);
                    tt2.setDateEnd(dateEnd2);
                    tt2.setCrId(crNo2);
                    tt2.setCouNo(couNo);
                    tt2.setCrName(crName2);

                    // 3

                    crName3 = textField_3.getText().toString();
                     crNo3 = this.getcrNo(crName3);
                     bool3 = checkBox_3.isSelected();
                     week3 = checkBox_3.getText().toString();
                     dateStart3 = dux.Date2String((Date) spinner_31.getValue());
                     dateEnd3 = dux.Date2String((Date) spinner_32.getValue());

                     tt3 = new TimeTable();
                    tt3.setBool(bool3);
                    tt3.setWeek(week3);
                    tt3.setDateStart(dateStart3);
                    tt3.setDateEnd(dateEnd3);
                    tt3.setCrId(crNo3);
                    tt3.setCouNo(couNo);
                    tt3.setCrName(crName3);

                    // 4
                  crName4 = textField_4.getText().toString();
                     crNo4 = this.getcrNo(crName4);
                     bool4 = checkBox_4.isSelected();
                     week4 = checkBox_4.getText().toString();
                     dateStart4 = dux.Date2String((Date) spinner_41.getValue());
                     dateEnd4 = dux.Date2String((Date) spinner_42.getValue());

                     tt4 = new TimeTable();
                    tt4.setBool(bool4);
                    tt4.setWeek(week4);
                    tt4.setDateStart(dateStart4);
                    tt4.setDateEnd(dateEnd4);
                    tt4.setCrId(crNo4);
                    tt4.setCouNo(couNo);
                    tt4.setCrName(crName4);

                    // 5
                    crName5 = textField_5.getText().toString();
                     crNo5 = this.getcrNo(crName5);
                    bool5 = checkBox_5.isSelected();
                     week5 = checkBox_5.getText().toString();
                     dateStart5 = dux.Date2String((Date) spinner_51.getValue());
                     dateEnd5 = dux.Date2String((Date) spinner_52.getValue());

                     tt5 = new TimeTable();
                    tt5.setBool(bool5);
                    tt5.setWeek(week5);
                    tt5.setDateStart(dateStart5);
                    tt5.setDateEnd(dateEnd5);
                    tt5.setCrId(crNo5);
                    tt5.setCouNo(couNo);
                    tt5.setCrName(crName5);
                    // 6
                    crName6 = textField_6.getText().toString();
                     crNo6 = this.getcrNo(crName6);
                    bool6 = checkBox_6.isSelected();
                     week6 = checkBox_6.getText().toString();
                     dateStart6 = dux.Date2String((Date) spinner_61.getValue());
                     dateEnd6 = dux.Date2String((Date) spinner_62.getValue());

                     tt6 = new TimeTable();
                    tt6.setBool(bool6);
                    tt6.setWeek(week6);
                    tt6.setDateStart(dateStart6);
                    tt6.setDateEnd(dateEnd6);
                    tt6.setCrId(crNo6);
                    tt6.setCouNo(couNo);
                    tt6.setCrName(crName6);
          }

          private void resetValue() {
                    textField_editPro.setText("");
                    comboBox_editSchYear.setSelectedIndex(0);
                    comboBox_editTerm.setSelectedIndex(0);
                    spinner_classNo.setValue("101");
                    textField_fexidNum.setText("");
                    comboBox_editStatus.setSelectedIndex(0);
                    
                    checkBox_1.setSelected(false);
                    checkBox_2.setSelected(false);
                    checkBox_3.setSelected(false);
                    checkBox_4.setSelected(false);
                    checkBox_5.setSelected(false);
                    checkBox_6.setSelected(false);
                    
                    spinner_11.setEnabled(false);
                    spinner_21.setEnabled(false);
                    spinner_31.setEnabled(false);
                    spinner_41.setEnabled(false);
                    spinner_51.setEnabled(false);
                    spinner_61.setEnabled(false);
                    
                    spinner_12.setEnabled(false);
                    spinner_22.setEnabled(false);
                    spinner_32.setEnabled(false);
                    spinner_42.setEnabled(false);
                    spinner_52.setEnabled(false);
                    spinner_62.setEnabled(false);
                    
                    textField_1.setText("");
                    textField_1.setEnabled(false);
                    textField_1.setEditable(false);
                    button_1.setEnabled(false);
                    
                    textField_2.setText("");
                    textField_2.setEnabled(false);
                    textField_2.setEditable(false);
                    button_2.setEnabled(false);
                    
                    textField_3.setText("");
                    textField_3.setEnabled(false);
                    textField_3.setEditable(false);
                    button_3.setEnabled(false);
                    
                    textField_4.setText("");
                    textField_4.setEnabled(false);
                    textField_4.setEditable(false);
                    button_4.setEnabled(false);
                    
                    textField_5.setText("");
                    textField_5.setEnabled(false);
                    textField_5.setEditable(false);
                    button_5.setEnabled(false);
                    
                    textField_6.setText("");
                    textField_6.setEnabled(false);
                    textField_6.setEditable(false);
                    button_6.setEnabled(false);
                    
          }

          protected void searchOpenCourse(ActionEvent e) {
                    String couNo=null,couName=null,proName=null;
                    if(radioButton_1.isSelected()){
                              try {
                                        couNo = textField_srarchNO.getText().toString();
                              } catch (Exception e2) {
                                        couNo=null;
                              }
                    }else if(radioButton_2.isSelected()){
                              try {
                                        couName = textField_searchName.getText().toString();
                              } catch (Exception e2) {
                                        couName=null;
                              }
                    }else{
                              try {
                                        proName = textField_searchPro.getText().toString();
                              } catch (Exception e2) {
                                        proName=null;
                              }
                    }
                    OpenCourse oc=new OpenCourse();
                    oc.setCouNo(couNo);
                    oc.setCouName(couName);
                    oc.setProName(proName);
                    setTable(oc);
          }

          protected String addSearchPro() {
                    return SearchProfroCourseFrm.getpName();
          }

          protected void selectRowAction(MouseEvent e) {
                    resetValue();
                    row=table.getSelectedRow();
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    couNo = dft.getValueAt(row, 1).toString();
                    editProName=dft.getValueAt(row, 3).toString();
                    String editSchYear=dft.getValueAt(row, 4).toString();
                    String editTerm=dft.getValueAt(row, 5).toString();
                    String editClassNo=dft.getValueAt(row, 6).toString();
                    String editFeixdNum=dft.getValueAt(row, 7).toString();
                    String editStatus=dft.getValueAt(row, 0).toString();
                    
                    textField_editPro.setText(editProName);
                    for(int i=0;i<comboBox_editSchYear.getItemCount();i++){
                              if(editSchYear.equals(SchYear[i])){
                                        comboBox_editSchYear.setSelectedIndex(i);
                              }
                    }
                    for(int i=0;i<comboBox_editTerm.getItemCount();i++){
                              if(editTerm.equals(term[i])){
                                        comboBox_editTerm.setSelectedIndex(i);
                              }
                    }
                    spinner_classNo.setValue(editClassNo);
                    textField_fexidNum.setText(editFeixdNum);
                    
                    for(int i=0;i<comboBox_editStatus.getItemCount();i++){
                              if(editStatus.equals(status[i])){
                                        comboBox_editStatus.setSelectedIndex(i);
                              }
                    }
                    //time table
                    
                    OpenCourseDao ocDao=new OpenCourseDao();
                    String couNo = dft.getValueAt(row, 1).toString();
                    tvList=ocDao.getTimeList(couNo);
                    tvArray =new TimeView[tvList.size()];
                    for (int i = 0; i <tvList.size(); i++) {
                                        tvArray[i]=tvList.get(i);
                    }
                    //시간 list 출력 test
//                    for (int i = 0; i <tvList.size(); i++) {
//                              System.out.println(tvArray[i]);
//                    }
                    String ttno1,ttno2,ttno3,tton4,tton5,tton6;
                    for (int i = 0; i <tvArray.length; i++) {
                              tvArray[i]=tvList.get(i);
                              String week = tvArray[i].getWeek();
                              ClassRoom cr=new ClassRoom();
                              cr.setCrName(tvArray[i].getCrName());
                                        if("월".equals(week)){
                                                  checkBox_1.setSelected(true);
                                                  this.setMyModel2(spinner_11,tvArray[i].getStartTime());
                                                  spinner_11.setEnabled(true);
                                                  this.setMyModel2(spinner_12,tvArray[i].getEndTime());
                                                  spinner_12.setEnabled(true);
                                                  textField_1.setText(tvArray[i].getCrName());
                                                  textField_1.setEnabled(true);
                                                  button_1.setEnabled(true);
                                        }else
                                        if("화".equals(tvArray[i].getWeek())){
                                                  checkBox_2.setSelected(true);
                                                  this.setMyModel2(spinner_21,tvArray[i].getStartTime());
                                                  spinner_21.setEnabled(true);
                                                  this.setMyModel2(spinner_22,tvArray[i].getEndTime());
                                                  spinner_22.setEnabled(true);
                                                  textField_2.setText(tvArray[i].getCrName());
                                                  textField_2.setEnabled(true);
                                                  button_2.setEnabled(true);
                                        }else
                                        if("수".equals(tvArray[i].getWeek())){
                                                  checkBox_3.setSelected(true);
                                                  this.setMyModel2(spinner_31,tvArray[i].getStartTime());
                                                  spinner_31.setEnabled(true);
                                                  this.setMyModel2(spinner_32,tvArray[i].getEndTime());
                                                  spinner_32.setEnabled(true);
                                                  textField_3.setText(tvArray[i].getCrName());
                                                  textField_3.setEnabled(true);
                                                  button_3.setEnabled(true);
                                        }else
                                        if("목".equals(tvArray[i].getWeek())){
                                                  checkBox_4.setSelected(true);
                                                  this.setMyModel2(spinner_41,tvArray[i].getStartTime());
                                                  spinner_41.setEnabled(true);
                                                  this.setMyModel2(spinner_42,tvArray[i].getEndTime());
                                                  spinner_42.setEnabled(true);
                                                  textField_4.setText(tvArray[i].getCrName());
                                                  textField_4.setEnabled(true);
                                                  button_4.setEnabled(true);
                                        }else
                                        if("금".equals(tvArray[i].getWeek())){
                                                  checkBox_5.setSelected(true);
                                                  this.setMyModel2(spinner_51,tvArray[i].getStartTime());
                                                  spinner_51.setEnabled(true);
                                                  this.setMyModel2(spinner_52,tvArray[i].getEndTime());
                                                  spinner_52.setEnabled(true);
                                                  textField_5.setText(tvArray[i].getCrName());
                                                  textField_5.setEnabled(true);
                                                  button_5.setEnabled(true);
                                        }else
                                        if("토".equals(tvArray[i].getWeek())){
                                                  checkBox_6.setSelected(true);
                                                  this.setMyModel2(spinner_61,tvArray[i].getStartTime());
                                                  spinner_61.setEnabled(true);
                                                  this.setMyModel2(spinner_62,tvArray[i].getEndTime());
                                                  spinner_62.setEnabled(true);
                                                  textField_6.setText(tvArray[i].getCrName());
                                                  textField_6.setEnabled(true);
                                                  button_6.setEnabled(true);
                                        }
                    }
                    
          }

          //set Table
		 private void setTable(OpenCourse oc) {
		           DefaultTableModel dft = (DefaultTableModel) table.getModel();
                   dft.setRowCount(0);
                   OpenCourseDao ocDao=new OpenCourseDao();
                   List<OpenCourse> ocList = ocDao.getOCList(oc);
                   List<TimeView>  tvList;
                   String classStr=null;
                   for(OpenCourse o : ocList){
                             Vector v=new Vector();
                             v.add(o.getStatus());//0
                             v.add(o.getCouNo());
                             v.add(o.getCouName());
                             v.add(getProNameByProId(o.getProId()));
                             v.add(o.getSchYear());
                             v.add(o.getTerm());
                             v.add(o.getClassNo());
                             v.add(o.getFixedNum());
                             v.add(o.getCurrNum());
//                             tvList=ocDao.getTimeList(o.getCouNo());
//                             classStr=this.listToString2(tvList,',');
//                             v.add(classStr);
                             v.add(o.getTtcr());
                             v.add(o.getLoginDate());
                             dft.addRow(v);
                   }
                   ocDao.closeDao();
          }
          // set jspinner model 1
          private void setMyModel(JSpinner spinner) {
                    spinner.setValue(new Date());
                    JSpinner.DateEditor de_spinner_61 = new JSpinner.DateEditor(
                                        spinner, "HH:mm");
                    spinner.setEditor(de_spinner_61);
          }
       // set jspinner model 2
          private void setMyModel2(JSpinner spinner,String str) {
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
//                    SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = null;
                    try {
                              date=simpleDateFormat.parse(str);
                    } catch (ParseException e) {
                              e.printStackTrace();
                    }
                    spinner.setValue(date);
                    // set time format
                    JSpinner.DateEditor de_spinner_61 = new JSpinner.DateEditor(
                                        spinner, "HH:mm");
                    spinner.setEditor(de_spinner_61);
          }
        //subjectName에 통해서 subjectId를 받는다
          public String getSubNameBySubId(String subid){
                    String subName = subDao.getSubName(subid);
                    return subName;
          }
        //proId에 통해서 proName를 받는다
          public String getProNameByProId(String proid){
                    String proName = psDao.getProName(proid);
                    return proName;
          }
        //proName에 통해서 proid를 받는다getProId
          public String getProIdByProName(String proName){
                    String proId = psDao.getProId(proName);
                    return proId;
          }
          public String listToString2(List list, char separator) {  
                    StringBuilder sb = new StringBuilder();  
                    for (int i = 0; i < list.size(); i++) {  
                        if (i == list.size() - 1) {  
                            sb.append(list.get(i));  
                        } else {  
                            sb.append(list.get(i));  
                            sb.append(separator);  
                        }  
                    }  
                    return sb.toString();  
                }  
          private int getcrNo(String crName) {
                    ClassRoomDao crDao = new ClassRoomDao();
                    int crNo = crDao.getCrNo(crName);
                    return crNo;
          }
}
