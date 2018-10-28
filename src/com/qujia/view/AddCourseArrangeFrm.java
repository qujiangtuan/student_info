package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.ClassRoomDao;
import com.qujia.dao.OpenCourseDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.SubjectsDao;
import com.qujia.dao.TimeTableDao;
import com.qujia.model.OpenCourse;
import com.qujia.model.TimeTable;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddCourseArrangeFrm extends JFrame {

          private JPanel contentPane;
          private JSpinner spinner_1_1, spinner_2_1, spinner_3_1, spinner_4_1,
                              spinner_5_1, spinner_6_1, spinner_1_2,
                              spinner_2_2, spinner_3_2, spinner_4_2,
                              spinner_5_2, spinner_6_2;
          private JCheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4,
                              checkBox_5, checkBox_6;
          private JLabel lebel_name, leabel_pro, leabel_term;
          private JComboBox comboBox_term;
          DateUtil dux = new DateUtil();
          private JLabel lblNewLabel;
          private JLabel lblNewLabel_1;
          private JTextField textField_num;
          private JButton button;
          private JRadioButton xRadioButton, cRadioButton;
          private ButtonGroup bgroup;
          private JTextField textField_subject;
          private JTextField textField_pro;
          private JLabel lblNewLabel_4;
          private JTextField textField_couName;
          private JComboBox comboBox_schYear;
          private JSpinner spinner_classNo;
          private static String couNo;
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

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddCourseArrangeFrm frame = new AddCourseArrangeFrm();
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
          public AddCourseArrangeFrm() {
                    this.setResizable(false);
                    setTitle("개설교과목등록");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 613, 547);

                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);

                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    lebel_name = new JLabel("교과목명:");
                    lebel_name.setBounds(30, 35, 69, 15);

                    leabel_pro = new JLabel("\uB2F4\uB2F9\uAD50\uC218:");
                    leabel_pro.setBounds(319, 80, 61, 15);

                    leabel_term = new JLabel(" 개설학기:");
                    leabel_term.setBounds(319, 119, 69, 15);

                    comboBox_term = new JComboBox();
                    comboBox_term.setBounds(386, 116, 102, 21);
                    comboBox_term.setModel(new DefaultComboBoxModel(
                                        new String[] { "1학기", "2학기", "여름계절학기",
                                                            "겨울계절학기" }));

                    DateUtil du = new DateUtil();

                    JButton submitButton = new JButton("등  록");
                    submitButton.setBounds(282, 444, 74, 23);
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        loginCourseAction(e);
                                        // loginTimeAction(e);

                              }

                    });

                    JLabel label_1 = new JLabel("수강요일");
                    label_1.setBounds(30, 196, 65, 15);

                    JLabel label_2 = new JLabel("시작시간");
                    label_2.setBounds(117, 196, 65, 15);

                    JLabel label_3 = new JLabel("종료시간");
                    label_3.setBounds(263, 196, 62, 15);

                    JLabel label_4 = new JLabel("강의실");
                    label_4.setBounds(365, 196, 147, 15);

                    checkBox_1 = new JCheckBox("월");
                    checkBox_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent arg0) {
                                        if (checkBox_1.isSelected()) {
                                                  spinner_1_1.setEnabled(true);
                                                  spinner_1_2.setEnabled(true);
                                                  button_1.setEnabled(true);
                                        } else {
                                                  spinner_1_1.setEnabled(false);
                                                  spinner_1_2.setEnabled(false);
                                                  button_1.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_1.setBounds(47, 229, 48, 23);

                    checkBox_2 = new JCheckBox("화");
                    checkBox_2.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if (checkBox_2.isSelected()) {
                                                  spinner_2_1.setEnabled(true);
                                                  spinner_2_2.setEnabled(true);
                                                  button_2.setEnabled(true);
                                        } else {
                                                  spinner_2_1.setEnabled(false);
                                                  spinner_2_2.setEnabled(false);
                                                  button_2.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_2.setBounds(47, 262, 48, 23);

                    checkBox_3 = new JCheckBox("수");
                    checkBox_3.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if (checkBox_3.isSelected()) {
                                                  spinner_3_1.setEnabled(true);
                                                  spinner_3_2.setEnabled(true);
                                                  button_3.setEnabled(true);
                                        } else {
                                                  spinner_3_1.setEnabled(false);
                                                  spinner_3_2.setEnabled(false);
                                                  button_3.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_3.setBounds(47, 294, 48, 23);

                    checkBox_4 = new JCheckBox("목");
                    checkBox_4.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if (checkBox_4.isSelected()) {
                                                  spinner_4_1.setEnabled(true);
                                                  spinner_4_2.setEnabled(true);
                                                  button_4.setEnabled(true);
                                        } else {
                                                  spinner_4_1.setEnabled(false);
                                                  spinner_4_2.setEnabled(false);
                                                  button_4.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_4.setBounds(47, 326, 48, 23);

                    checkBox_5 = new JCheckBox("금");
                    checkBox_5.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if (checkBox_5.isSelected()) {
                                                  spinner_5_1.setEnabled(true);
                                                  spinner_5_2.setEnabled(true);
                                                  button_5.setEnabled(true);
                                        } else {
                                                  spinner_5_1.setEnabled(false);
                                                  spinner_5_2.setEnabled(false);
                                                  button_5.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_5.setBounds(47, 354, 48, 23);

                    checkBox_6 = new JCheckBox("토");
                    checkBox_6.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if (checkBox_6.isSelected()) {
                                                  spinner_6_1.setEnabled(true);
                                                  spinner_6_2.setEnabled(true);
                                                  button_6.setEnabled(true);
                                        } else {
                                                  spinner_6_1.setEnabled(false);
                                                  spinner_6_2.setEnabled(false);
                                                  button_6.setEnabled(false);
                                        }
                              }
                    });
                    checkBox_6.setBounds(47, 386, 48, 23);

                    // SpinnerDateModel model = new SpinnerDateModel();
                    spinner_1_1 = new JSpinner(new SpinnerDateModel());
                    spinner_1_1.setEnabled(false);
                    spinner_1_1.setBounds(117, 230, 93, 22);
                    // spinner_1_1.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_2_1 = new JSpinner(new SpinnerDateModel());
                    spinner_2_1.setEnabled(false);
                    spinner_2_1.setBounds(117, 262, 93, 22);

                    spinner_3_1 = new JSpinner(new SpinnerDateModel());
                    spinner_3_1.setEnabled(false);
                    spinner_3_1.setBounds(117, 294, 93, 22);

                    spinner_4_1 = new JSpinner(new SpinnerDateModel());
                    spinner_4_1.setEnabled(false);
                    spinner_4_1.setBounds(117, 326, 93, 22);

                    spinner_5_1 = new JSpinner(new SpinnerDateModel());
                    spinner_5_1.setEnabled(false);
                    spinner_5_1.setBounds(117, 354, 93, 22);

                    spinner_6_1 = new JSpinner(new SpinnerDateModel());
                    spinner_6_1.setEnabled(false);
                    spinner_6_1.setBounds(117, 386, 93, 22);

                    spinner_1_2 = new JSpinner(new SpinnerDateModel());
                    spinner_1_2.setEnabled(false);
                    spinner_1_2.setBounds(245, 230, 102, 22);
                    // spinner_1_2.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_2_2 = new JSpinner(new SpinnerDateModel());
                    spinner_2_2.setEnabled(false);
                    spinner_2_2.setBounds(245, 262, 102, 22);

                    spinner_3_2 = new JSpinner(new SpinnerDateModel());
                    spinner_3_2.setEnabled(false);
                    spinner_3_2.setBounds(245, 294, 102, 22);

                    spinner_4_2 = new JSpinner(new SpinnerDateModel());
                    spinner_4_2.setEnabled(false);
                    spinner_4_2.setBounds(245, 326, 102, 22);

                    spinner_5_2 = new JSpinner(new SpinnerDateModel());
                    spinner_5_2.setEnabled(false);
                    spinner_5_2.setBounds(245, 354, 102, 22);

                    spinner_6_2 = new JSpinner(new SpinnerDateModel());
                    spinner_6_2.setEnabled(false);
                    spinner_6_2.setBounds(245, 386, 102, 22);
                    this.setMyModel(spinner_1_1);
                    this.setMyModel(spinner_1_2);
                    this.setMyModel(spinner_2_1);
                    this.setMyModel(spinner_2_2);
                    this.setMyModel(spinner_3_1);
                    this.setMyModel(spinner_3_2);
                    this.setMyModel(spinner_4_1);
                    this.setMyModel(spinner_4_2);
                    this.setMyModel(spinner_5_1);
                    this.setMyModel(spinner_5_2);
                    this.setMyModel(spinner_6_1);
                    this.setMyModel(spinner_6_2);

                    lblNewLabel = new JLabel("분 반:");
                    lblNewLabel.setBounds(48, 119, 48, 15);

                    lblNewLabel_1 = new JLabel("정 원:");
                    lblNewLabel_1.setBounds(340, 157, 40, 15);

                    textField_num = new JTextField();
                    textField_num.setBounds(386, 154, 102, 21);
                    textField_num.setColumns(10);

                    JLabel lblNewLabel_2 = new JLabel("대상학년:");
                    lblNewLabel_2.setBounds(30, 80, 69, 15);

                    comboBox_schYear = new JComboBox();
                    comboBox_schYear.setBounds(114, 77, 116, 21);
                    comboBox_schYear.setModel(new DefaultComboBoxModel(
                                        new String[] { "1학년", "2학년", "3학년",
                                                            "4학년", "대학원" }));

                    button = new JButton("취 소");
                    button.setBounds(406, 444, 86, 23);
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });

                    JLabel lblNewLabel_3 = new JLabel("평가방식:");
                    lblNewLabel_3.setBounds(30, 157, 72, 15);

                    xRadioButton = new JRadioButton("상대평가");
                    xRadioButton.setSelected(true);
                    xRadioButton.setBounds(114, 153, 86, 23);

                    cRadioButton = new JRadioButton("절대평가");

                    bgroup = new ButtonGroup();
                    bgroup.add(xRadioButton);
                    bgroup.add(cRadioButton);

                    cRadioButton.setBounds(204, 153, 102, 23);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(label_1);
                    contentPane.add(checkBox_1);
                    contentPane.add(checkBox_2);
                    contentPane.add(checkBox_3);
                    contentPane.add(checkBox_4);
                    contentPane.add(checkBox_5);
                    contentPane.add(checkBox_6);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(comboBox_schYear);
                    contentPane.add(label_2);
                    contentPane.add(spinner_6_1);
                    contentPane.add(spinner_5_1);
                    contentPane.add(spinner_4_1);
                    contentPane.add(spinner_3_1);
                    contentPane.add(spinner_2_1);
                    contentPane.add(spinner_1_1);
                    contentPane.add(lebel_name);
                    contentPane.add(spinner_2_2);
                    contentPane.add(spinner_1_2);
                    contentPane.add(spinner_3_2);
                    contentPane.add(spinner_4_2);
                    contentPane.add(spinner_5_2);
                    contentPane.add(spinner_6_2);
                    contentPane.add(label_4);
                    contentPane.add(leabel_pro);
                    contentPane.add(label_3);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(leabel_term);
                    contentPane.add(textField_num);
                    contentPane.add(comboBox_term);
                    contentPane.add(submitButton);
                    contentPane.add(button);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(xRadioButton);
                    contentPane.add(cRadioButton);

                    textField_subject = new JTextField();
                    textField_subject.setEditable(false);
                    textField_subject.setBounds(114, 32, 116, 21);
                    contentPane.add(textField_subject);
                    textField_subject.setColumns(10);

                    JButton button_searchSub = new JButton("조회");
                    button_searchSub.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchSubjectFrm ssf = new SearchSubjectFrm(
                                                            new JFrame());
                                        ssf.setVisible(true);
                                        textField_subject.setText(addSearchSub());
                              }
                    });
                    button_searchSub.setBounds(230, 31, 65, 23);
                    contentPane.add(button_searchSub);

                    JButton button_searchPro = new JButton("조회");
                    button_searchPro.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchProfroCourseFrm spcf = new SearchProfroCourseFrm(
                                                            new JFrame());
                                        spcf.setVisible(true);
                                        textField_pro.setText(addSearchPro());
                              }
                    });
                    button_searchPro.setBounds(488, 76, 65, 23);
                    contentPane.add(button_searchPro);

                    textField_pro = new JTextField();
                    textField_pro.setEditable(false);
                    textField_pro.setBounds(386, 77, 102, 21);
                    contentPane.add(textField_pro);
                    textField_pro.setColumns(10);

                    lblNewLabel_4 = new JLabel("개설교과목명:");
                    lblNewLabel_4.setBounds(302, 35, 86, 15);
                    contentPane.add(lblNewLabel_4);

                    textField_couName = new JTextField();
                    textField_couName.setBounds(386, 32, 102, 21);
                    contentPane.add(textField_couName);
                    textField_couName.setColumns(10);

                    spinner_classNo = new JSpinner();
                    spinner_classNo.setModel(new SpinnerListModel(new String[] {
                                        "101", "102", "103", "104", "105",
                                        "106", "107", "108", "109", "110" }));
                    spinner_classNo.setBounds(114, 116, 116, 22);
                    contentPane.add(spinner_classNo);

                    textField_1 = new JTextField();
                    textField_1.setBounds(359, 230, 54, 21);
                    contentPane.add(textField_1);
                    textField_1.setColumns(10);

                    button_1 = new JButton("조회");
                    button_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf = new SearchClassRoomFrm(
                                                            new JFrame());
                                        sdf.setVisible(true);
                                        textField_1.setText(addSearchCR());
                              }
                    });
                    button_1.setBounds(415, 229, 69, 23);
                    contentPane.add(button_1);

                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    textField_2.setBounds(359, 263, 54, 21);
                    contentPane.add(textField_2);

                    button_2 = new JButton("조회");
                    button_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf = new SearchClassRoomFrm(
                                                            new JFrame());
                                        sdf.setVisible(true);
                                        textField_2.setText(addSearchCR());
                              }
                    });
                    button_2.setBounds(415, 262, 69, 23);
                    contentPane.add(button_2);

                    textField_3 = new JTextField();
                    textField_3.setColumns(10);
                    textField_3.setBounds(359, 295, 54, 21);
                    contentPane.add(textField_3);

                    button_3 = new JButton("조회");
                    button_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf = new SearchClassRoomFrm(
                                                            new JFrame());
                                        sdf.setVisible(true);
                                        textField_3.setText(addSearchCR());
                              }
                    });
                    button_3.setBounds(415, 294, 69, 23);
                    contentPane.add(button_3);

                    textField_4 = new JTextField();
                    textField_4.setColumns(10);
                    textField_4.setBounds(359, 327, 54, 21);
                    contentPane.add(textField_4);

                    button_4 = new JButton("조회");
                    button_4.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf = new SearchClassRoomFrm(
                                                            new JFrame());
                                        sdf.setVisible(true);
                                        textField_4.setText(addSearchCR());
                              }
                    });
                    button_4.setBounds(415, 326, 69, 23);
                    contentPane.add(button_4);

                    textField_5 = new JTextField();
                    textField_5.setColumns(10);
                    textField_5.setBounds(359, 355, 54, 21);
                    contentPane.add(textField_5);

                    button_5 = new JButton("조회");
                    button_5.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf = new SearchClassRoomFrm(
                                                            new JFrame());
                                        sdf.setVisible(true);
                                        textField_5.setText(addSearchCR());
                              }
                    });
                    button_5.setBounds(415, 354, 69, 23);
                    contentPane.add(button_5);

                    textField_6 = new JTextField();
                    textField_6.setColumns(10);
                    textField_6.setBounds(359, 387, 54, 21);
                    contentPane.add(textField_6);

                    button_6 = new JButton("조회");
                    button_6.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchClassRoomFrm sdf = new SearchClassRoomFrm(
                                                            new JFrame());
                                        sdf.setVisible(true);
                                        textField_6.setText(addSearchCR());
                              }
                    });
                    button_6.setBounds(415, 386, 69, 23);
                    contentPane.add(button_6);

                    resetValues();
                    // setClassRoomName();
          }

          protected String addSearchCR() {
                    return SearchClassRoomFrm.getCrName();
          }

          protected String addSearchSub() {
                    return SearchSubjectFrm.getSubName();
          }

          protected String addSearchPro() {
                    return SearchProfroCourseFrm.getpName();
          }

          // course login
          protected void loginCourseAction(ActionEvent e) {
                    // 교과목개설 정보 등록
                    String sub = textField_subject.getText().toString();
                    String subid = getSubIdBySubName(sub);
                    if (StringUtil.isEmpty(sub)) {
                              JOptionPane.showMessageDialog(this,
                                                  "교과목을 선택해주세요!");
                              return;
                    }
                    String couName = textField_couName.getText().toString();
                    if (StringUtil.isEmpty(couName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "개설교과목명을 입력해주세요!");
                              return;
                    }
                    String schYear = comboBox_schYear.getSelectedItem()
                                        .toString();
                    String proName = textField_pro.getText().toString();
                    String pno = getProIdByProName(proName);
                    if (StringUtil.isEmpty(proName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "담당교수를 선택해주세요!");
                              return;
                    }
                    String classNo = spinner_classNo.getValue().toString();
                    String term = comboBox_term.getSelectedItem().toString();
                    String envMethod = xRadioButton.isSelected() ? xRadioButton.getText() : cRadioButton.getText();
                    String fixedNumStr=textField_num.getText().toString();
                    if (StringUtil.isEmpty(fixedNumStr)) {
                              JOptionPane.showMessageDialog(this, "정원을 입력해주세요!");
                              return;
                    }
                    int fixedNum = Integer.parseInt(fixedNumStr);
                    couNo = getCouNo(subid);
                    String loginDate = DateUtil.getTodayDate();
                    OpenCourse oc = new OpenCourse();
                    oc.setCouNo(couNo);
                    oc.setSubCode(subid);
                    oc.setCouName(couName);
                    oc.setSchYear(schYear);
                    oc.setProId(pno);
                    oc.setClassNo(classNo);
                    oc.setTerm(term);
                    oc.setEnvMethod(envMethod);
                    oc.setFixedNum(fixedNum);
                    oc.setStatus("개설");
                    oc.setProName(proName);
                    oc.setLoginDate(loginDate);

                    OpenCourseDao ocDao = new OpenCourseDao();

                    // 시산 등록
                    // 1
                    String crName1 = textField_1.getText().toString();
                    int crNo1 = this.getcrNo(crName1);
                    Boolean bool1 = checkBox_1.isSelected();
                    String week1 = checkBox_1.getText().toString();
                    String dateStart1 = dux.Date2String((Date) spinner_1_1.getValue());
                    String dateEnd1 = dux.Date2String((Date) spinner_1_2.getValue());

                    TimeTable tt1 = new TimeTable();
                    tt1.setBool(bool1);
                    tt1.setWeek(week1);
                    tt1.setDateStart(dateStart1);
                    tt1.setDateEnd(dateEnd1);
                    tt1.setCrId(crNo1);
                    tt1.setCouNo(couNo);
                    tt1.setCrName(crName1);

                    // 2
                    String crName2 = textField_2.getText().toString();
                    int crNo2 = this.getcrNo(crName2);
                    Boolean bool2 = checkBox_2.isSelected();
                    String week2 = checkBox_2.getText().toString();
                    String dateStart2 = dux.Date2String((Date) spinner_2_1.getValue());
                    String dateEnd2 = dux.Date2String((Date) spinner_2_2.getValue());

                    TimeTable tt2 = new TimeTable();
                    tt2.setBool(bool2);
                    tt2.setWeek(week2);
                    tt2.setDateStart(dateStart2);
                    tt2.setDateEnd(dateEnd2);
                    tt2.setCrId(crNo2);
                    tt2.setCouNo(couNo);
                    tt2.setCrName(crName2);

                    // 3

                    String crName3 = textField_3.getText().toString();
                    int crNo3 = this.getcrNo(crName3);
                    Boolean bool3 = checkBox_3.isSelected();
                    String week3 = checkBox_3.getText().toString();
                    String dateStart3 = dux.Date2String((Date) spinner_3_1.getValue());
                    String dateEnd3 = dux.Date2String((Date) spinner_3_2.getValue());

                    TimeTable tt3 = new TimeTable();
                    tt3.setBool(bool3);
                    tt3.setWeek(week3);
                    tt3.setDateStart(dateStart3);
                    tt3.setDateEnd(dateEnd3);
                    tt3.setCrId(crNo3);
                    tt3.setCouNo(couNo);
                    tt3.setCrName(crName3);

                    // 4
                    String crName4 = textField_4.getText().toString();
                    int crNo4 = this.getcrNo(crName4);
                    Boolean bool4 = checkBox_4.isSelected();
                    String week4 = checkBox_4.getText().toString();
                    String dateStart4 = dux.Date2String((Date) spinner_4_1.getValue());
                    String dateEnd4 = dux.Date2String((Date) spinner_4_2.getValue());

                    TimeTable tt4 = new TimeTable();
                    tt4.setBool(bool4);
                    tt4.setWeek(week4);
                    tt4.setDateStart(dateStart4);
                    tt4.setDateEnd(dateEnd4);
                    tt4.setCrId(crNo4);
                    tt4.setCouNo(couNo);
                    tt4.setCrName(crName4);

                    // 5
                    String crName5 = textField_5.getText().toString();
                    int crNo5 = this.getcrNo(crName5);
                    Boolean bool5 = checkBox_5.isSelected();
                    String week5 = checkBox_5.getText().toString();
                    String dateStart5 = dux.Date2String((Date) spinner_5_1.getValue());
                    String dateEnd5 = dux.Date2String((Date) spinner_5_2.getValue());

                    TimeTable tt5 = new TimeTable();
                    tt5.setBool(bool5);
                    tt5.setWeek(week5);
                    tt5.setDateStart(dateStart5);
                    tt5.setDateEnd(dateEnd5);
                    tt5.setCrId(crNo5);
                    tt5.setCouNo(couNo);
                    tt5.setCrName(crName5);
                    // 6
                    String crName6 = textField_6.getText().toString();
                    int crNo6 = this.getcrNo(crName6);
                    Boolean bool6 = checkBox_6.isSelected();
                    String week6 = checkBox_6.getText().toString();
                    String dateStart6 = dux.Date2String((Date) spinner_6_1.getValue());
                    String dateEnd6 = dux.Date2String((Date) spinner_6_2.getValue());

                    TimeTable tt6 = new TimeTable();
                    tt6.setBool(bool6);
                    tt6.setWeek(week6);
                    tt6.setDateStart(dateStart6);
                    tt6.setDateEnd(dateEnd6);
                    tt6.setCrId(crNo6);
                    tt6.setCouNo(couNo);
                    tt6.setCrName(crName6);
                    List<TimeTable> ttList=new ArrayList<TimeTable>();
                    String classStr;
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
//                    System.out.println(classStr);
                    //set 시간 
                    oc.setTtcr(classStr);
                    
                    TimeTableDao ttDao = new TimeTableDao();
                    boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false, b6 = false;
                    if (ocDao.loginCourse(oc)) {
                              if (bool1) {
                                        b1 = ttDao.loginTT1(tt1);
                              }
                              if (bool2) {
                                        b2 = ttDao.loginTT2(tt2);
                              }
                              if (bool3) {
                                        b3 = ttDao.loginTT3(tt3);
                              }

                              if (bool4) {
                                        b4 = ttDao.loginTT4(tt4);
                              }
                              if (bool5) {
                                        b5 = ttDao.loginTT5(tt5);
                              }
                              if (bool6) {
                                        b6 = ttDao.loginTT6(tt6);
                              }
                              if (bool1 == b1 && bool2 == b2 && bool3 == b3
                                                  && bool4 == b4 && bool5 == b5
                                                  && bool6 == b6) {
                                        JOptionPane.showMessageDialog(this,
                                                            "교과목이 개설되었습니다!");
                              }
                    } else {
                              JOptionPane.showMessageDialog(this,
                                                  "교과목 개설이 실패되었습니다!");
                    }
                    resetValues();
          }

          private String listToString2(List<TimeTable> ttList, char c) {
                    StringBuilder sb = new StringBuilder();  
                    for (int i = 0; i < ttList.size(); i++) {  
                        if (i == ttList.size() - 1) {  
                            sb.append(ttList.get(i));  
                        } else {  
                            sb.append(ttList.get(i));  
                            sb.append(c);  
                        }  
                    }  
                    return sb.toString();  
          }

          private int getcrNo(String crName) {
                    ClassRoomDao crDao = new ClassRoomDao();
                    int crNo = crDao.getCrNo(crName);
                    return crNo;
          }

          private String getCouNo(String subid) {
                    String couNo = null;
                    couNo = subid + StringUtil.getRandom2();
                    return couNo;
          }
          private void resetValues() {
                    textField_subject.setText("");
                    textField_couName.setText("");
                    comboBox_schYear.setSelectedIndex(0);
                    comboBox_term.setSelectedIndex(0);
                    textField_pro.setText("");
                    spinner_classNo.setValue("101");
                    bgroup.clearSelection();
                    xRadioButton.setSelected(true);
                    textField_num.setText("");
                    checkBox_1.setSelected(false);
                    checkBox_2.setSelected(false);
                    checkBox_3.setSelected(false);
                    checkBox_4.setSelected(false);
                    checkBox_5.setSelected(false);
                    checkBox_6.setSelected(false);

                    textField_1.setText("");
                    textField_1.setEditable(false);
                    button_1.setEnabled(false);
                    textField_2.setText("");
                    textField_2.setEditable(false);
                    button_2.setEnabled(false);
                    textField_3.setText("");
                    textField_3.setEditable(false);
                    button_3.setEnabled(false);
                    textField_4.setText("");
                    textField_4.setEditable(false);
                    button_4.setEnabled(false);
                    textField_5.setText("");
                    textField_5.setEditable(false);
                    button_5.setEnabled(false);
                    textField_6.setText("");
                    textField_6.setEditable(false);
                    button_6.setEnabled(false);
          }

          // 设置jspinner 类型方法
          private void setMyModel(JSpinner spinner) {
                    spinner.setValue(new Date());
                    // 设置时间格式
                    JSpinner.DateEditor editor = new JSpinner.DateEditor(
                                        spinner, "HH:mm");
                    spinner.setEditor(editor);
          }

          // // //classroom
          // protected void setClassRoomName() {
          // // TODO Auto-generated method stub
          // ClassRoomDao crDao=new ClassRoomDao();
          // List<ClassRoom> csList = crDao.getCsList(new ClassRoom());
          // for (ClassRoom cr : csList) {
          // comboBox_1.addItem(cr);
          // comboBox_2.addItem(cr);
          // comboBox_3.addItem(cr);
          // comboBox_4.addItem(cr);
          // comboBox_5.addItem(cr);
          // comboBox_6.addItem(cr);
          // }
          // crDao.closeDao();
          // }
          // subjectName에 통해서 subjectId를 받는다
          public String getSubIdBySubName(String subName) {
                    SubjectsDao subDao = new SubjectsDao();
                    String subid = subDao.getSubId(subName);
                    return subid;
          }

          // proName에 통해서 pno를 받는다
          public String getProIdByProName(String proName) {
                    ProStaffDao pDao = new ProStaffDao();
                    String proid = pDao.getProId(proName);
                    return proid;
          }
}
