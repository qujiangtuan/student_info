package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import com.qujia.model.ClassRoom;
import com.qujia.model.TableTime;
import com.qujia.util.DateUtil;
import com.qujia.util.ViewUtil;

public class AddCourseArrangeFrm extends JFrame {

          private JPanel contentPane;
          private JSpinner spinner_1_1, spinner_2_1, spinner_3_1, spinner_4_1,
                              spinner_5_1, spinner_6_1,
                              spinner_1_2, spinner_2_2, spinner_3_2,
                              spinner_4_2, spinner_5_2, spinner_6_2;
          private JCheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4,
                              checkBox_5, checkBox_6;
          private JLabel lebel_name, leabel_pro, leabel_term;
          private JComboBox comboBox_term;
          private JComboBox comboBox_1, comboBox_2, comboBox_3, comboBox_4,
                              comboBox_5, comboBox_6;
          DateUtil dux = new DateUtil();
          private JLabel lblNewLabel;
          private JTextField textField;
          private JLabel lblNewLabel_1;
          private JTextField textField_1;
          private JButton button;
          private JRadioButton xRadioButton,cRadioButton;
          private ButtonGroup bgroup;
          private JTextField textField_2;
          private JTextField textField_3;

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
                    setTitle("개설교과목등록");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 613, 547);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    lebel_name = new JLabel("과목이름:");
                    lebel_name.setBounds(30, 35, 69, 15);

                    leabel_pro = new JLabel("\uB2F4\uB2F9\uAD50\uC218:");
                    leabel_pro.setBounds(304, 35, 70, 15);

                    leabel_term = new JLabel(" 개설학기:");
                    leabel_term.setBounds(314, 80, 74, 15);

                    comboBox_term = new JComboBox();
                    comboBox_term.setBounds(386, 77, 102, 21);
                    comboBox_term.setModel(new DefaultComboBoxModel(new String[] {"1학기", "2학기", "여름계절학기", "겨울계절학기"}));

                    DateUtil du = new DateUtil();

                    JButton submitButton = new JButton("등  록");
                    submitButton.setBounds(282, 444, 74, 23);
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        // ClassRoom[] cr=null;
                                        // Boolean[] bool=null;
                                        // String[] dateStart=null;
                                        // String[] dateEnd=null;
                                        // String[] className=null;
                                        // JCheckBox[]
                                        // checkBox={null,checkBox_1,checkBox_2,checkBox_3,checkBox_4,checkBox_5,checkBox_6,checkBox_7};
                                        // // JSpinner[][] spinner={
                                        // {spinner_1_1,spinner_2_1,spinner_3_1,spinner_4_1,spinner_5_1,spinner_6_1,spinner_7_1},
                                        // //
                                        // {spinner_1_2,spinner_2_2,spinner_3_2,spinner_4_1,spinner_5_2,spinner_6_2,spinner_7_2}};
                                        // JSpinner[][] spinner={
                                        // {spinner_1_1,spinner_1_2},{spinner_2_1,spinner_2_2},{spinner_3_1,spinner_3_2},{spinner_4_1,spinner_4_1},
                                        // {spinner_5_1,spinner_5_2},{spinner_6_1,spinner_6_2},{spinner_7_1,spinner_7_2}};
                                        //
                                        // JComboBox[] comboBox=null;
                                        // TableTime[] tt=null;
                                        // Map<Integer, Object>[] map=null;
                                        // Map<Integer, Object> map1=null;
                                        // // Map<Integer, Object> map2=new
                                        // HashMap<Integer, Object>();
                                        // for (int i = 1; i <= 7; i++) {
                                        // for (int j = 1; j <=2; j++) {
                                        // cr[i] =new ClassRoom();
                                        // bool[i] = checkBox[i].isSelected();
                                        // dateStart[i]=dux.Date2String((Date)
                                        // spinner[i][j].getValue());
                                        // dateEnd[i]=dux.Date2String((Date)
                                        // spinner[i][j].getValue());
                                        // className[i] =
                                        // comboBox[i].getSelectedItem().toString();
                                        // cr[i].setCrName(className[i]);
                                        //
                                        // tt[i]=new TableTime();
                                        // tt[i].setBool(bool[i]);
                                        // tt[i].setDateStart(dateStart[i]);
                                        // tt[i].setDateEnd(dateEnd[i]);
                                        // tt[i].setCr(cr[i]);
                                        // map[i] =new HashMap<Integer,
                                        // Object>();
                                        // map[i].put(1, tt[i].getBool());
                                        // map[i].put(2,tt[i].getDateStart());
                                        // map[i].put(3, tt[i].getDateEnd());
                                        // map[i].put(4, tt[i].getCr());
                                        // System.out.println(map[i]);
                                        // }
                                        // }

                                        // 1
                                        ClassRoom cr1 = new ClassRoom();
                                        Boolean bool1 = checkBox_1.isSelected();
                                        String dateStart1 = dux
                                                            .Date2String((Date) spinner_1_1
                                                                                .getValue());
                                        String dateEnd1 = dux
                                                            .Date2String((Date) spinner_1_2
                                                                                .getValue());
                                        String className1 = comboBox_1
                                                            .getSelectedItem()
                                                            .toString();
                                        cr1.setCrName(className1);

                                        TableTime tt1 = new TableTime();
                                        tt1.setBool(bool1);
                                        tt1.setDateStart(dateStart1);
                                        tt1.setDateEnd(dateEnd1);
                                        tt1.setCr(cr1);
                                        Map<Integer, Object> map1 = new HashMap<Integer, Object>();
                                        map1.put(1, tt1.getBool());
                                        map1.put(2, tt1.getDateStart());
                                        map1.put(3, tt1.getDateEnd());
                                        map1.put(4, tt1.getCr());
                                        // System.out.println(map1);

                                        // 2
                                        ClassRoom cr2 = new ClassRoom();
                                        Boolean bool2 = checkBox_2.isSelected();
                                        String dateStart2 = dux
                                                            .Date2String((Date) spinner_2_1
                                                                                .getValue());
                                        String dateEnd2 = dux
                                                            .Date2String((Date) spinner_2_2
                                                                                .getValue());
                                        String className2 = comboBox_2
                                                            .getSelectedItem()
                                                            .toString();
                                        cr2.setCrName(className2);

                                        TableTime tt2 = new TableTime();
                                        tt2.setBool(bool2);
                                        tt2.setDateStart(dateStart2);
                                        tt2.setDateEnd(dateEnd2);
                                        tt2.setCr(cr2);
                                        Map<Integer, Object> map2 = new HashMap<Integer, Object>();
                                        map2.put(1, tt2.getBool());
                                        map2.put(2, tt2.getDateStart());
                                        map2.put(3, tt2.getDateEnd());
                                        map2.put(4, tt2.getCr());
                                        // System.out.println(map2);

                                        // 3

                                        ClassRoom cr3 = new ClassRoom();
                                        Boolean bool3 = checkBox_3.isSelected();
                                        String dateStart3 = dux
                                                            .Date2String((Date) spinner_3_1
                                                                                .getValue());
                                        String dateEnd3 = dux
                                                            .Date2String((Date) spinner_3_2
                                                                                .getValue());
                                        String className3 = comboBox_3
                                                            .getSelectedItem()
                                                            .toString();
                                        cr3.setCrName(className3);

                                        TableTime tt3 = new TableTime();
                                        tt3.setBool(bool3);
                                        tt3.setDateStart(dateStart3);
                                        tt3.setDateEnd(dateEnd3);
                                        tt3.setCr(cr3);
                                        Map<Integer, Object> map3 = new HashMap<Integer, Object>();
                                        map3.put(1, tt3.getBool());
                                        map3.put(2, tt3.getDateStart());
                                        map3.put(3, tt3.getDateEnd());
                                        map3.put(4, tt3.getCr());
                                        // System.out.println(map3);

                                        // 4
                                        ClassRoom cr4 = new ClassRoom();
                                        Boolean bool4 = checkBox_4.isSelected();
                                        String dateStart4 = dux
                                                            .Date2String((Date) spinner_4_1
                                                                                .getValue());
                                        String dateEnd4 = dux
                                                            .Date2String((Date) spinner_4_2
                                                                                .getValue());
                                        String className4 = comboBox_4
                                                            .getSelectedItem()
                                                            .toString();
                                        cr4.setCrName(className4);

                                        TableTime tt4 = new TableTime();
                                        tt4.setBool(bool4);
                                        tt4.setDateStart(dateStart4);
                                        tt4.setDateEnd(dateEnd4);
                                        tt4.setCr(cr4);
                                        Map<Integer, Object> map4 = new HashMap<Integer, Object>();
                                        map4.put(1, tt4.getBool());
                                        map4.put(2, tt4.getDateStart());
                                        map4.put(3, tt4.getDateEnd());
                                        map4.put(4, tt4.getCr());
                                        // System.out.println(map4);
                                        // 5
                                        ClassRoom cr5 = new ClassRoom();
                                        Boolean bool5 = checkBox_5.isSelected();
                                        String dateStart5 = dux
                                                            .Date2String((Date) spinner_5_1
                                                                                .getValue());
                                        String dateEnd5 = dux
                                                            .Date2String((Date) spinner_5_2
                                                                                .getValue());
                                        String className5 = comboBox_5
                                                            .getSelectedItem()
                                                            .toString();
                                        cr5.setCrName(className5);

                                        TableTime tt5 = new TableTime();
                                        tt5.setBool(bool5);
                                        tt5.setDateStart(dateStart5);
                                        tt5.setDateEnd(dateEnd5);
                                        tt5.setCr(cr5);
                                        Map<Integer, Object> map5 = new HashMap<Integer, Object>();
                                        map5.put(1, tt5.getBool());
                                        map5.put(2, tt5.getDateStart());
                                        map5.put(3, tt5.getDateEnd());
                                        map5.put(4, tt5.getCr());
                                        // System.out.println(map5);
                                        // 6
                                        ClassRoom cr6 = new ClassRoom();
                                        Boolean bool6 = checkBox_6.isSelected();
                                        String dateStart6 = dux
                                                            .Date2String((Date) spinner_6_1
                                                                                .getValue());
                                        String dateEnd6 = dux
                                                            .Date2String((Date) spinner_6_2
                                                                                .getValue());
                                        String className6 = comboBox_6
                                                            .getSelectedItem()
                                                            .toString();
                                        cr6.setCrName(className6);

                                        TableTime tt6 = new TableTime();
                                        tt6.setBool(bool6);
                                        tt6.setDateStart(dateStart6);
                                        tt6.setDateEnd(dateEnd6);
                                        tt6.setCr(cr6);
                                        Map<Integer, Object> map6 = new HashMap<Integer, Object>();
                                        map6.put(1, tt6.getBool());
                                        map6.put(2, tt6.getDateStart());
                                        map6.put(3, tt6.getDateEnd());
                                        map6.put(4, tt6.getCr());
                                        // System.out.println(map6);

                                        // 7
                                        ClassRoom cr7 = new ClassRoom();
//                                        Boolean bool7 = checkBox_7.isSelected();
//                                        String dateStart7 = dux.Date2String((Date) spinner_7_1.getValue());
//                                        String dateEnd7 = dux.Date2String((Date) spinner_7_2.getValue());
//                                        String className7 = comboBox_7.getSelectedItem().toString();
//                                        cr7.setCrName(className7);

                                        TableTime tt7 = new TableTime();
//                                        tt7.setBool(bool7);
//                                        tt7.setDateStart(dateStart7);
//                                        tt7.setDateEnd(dateEnd7);
                                        tt7.setCr(cr7);
                                        Map<Integer, Object> map7 = new HashMap<Integer, Object>();
                                        map7.put(1, tt7.getBool());
                                        map7.put(2, tt7.getDateStart());
                                        map7.put(3, tt7.getDateEnd());
                                        map7.put(4, tt7.getCr());
                                        // System.out.println(map7);
                                        System.out.println("---------------------------------");
                                        // List list=new ArrayList();
                                        // list.add(map1);
                                        // list.add(map2);
                                        // list.add(map3);
                                        // list.add(map4);
                                        // list.add(map5);
                                        // list.add(map6);
                                        // list.add(map7);
                                        // System.out.println(list);
                                        Map<Integer, Object> mapAll = new HashMap<Integer, Object>();
                                        mapAll.put(1, map1);
                                        mapAll.put(2, map2);
                                        mapAll.put(3, map3);
                                        mapAll.put(4, map4);
                                        mapAll.put(5, map5);
                                        mapAll.put(6, map6);
                                        mapAll.put(7, map7);
                                        // System.out.println(mapAll);
                                        List list = new ArrayList();
                                        if (bool1) {

                                                  list.add(map1);
                                        }
                                        if (bool2) {
                                                  list.add(map2);
                                        }
                                        if (bool3) {
                                                  list.add(map3);
                                        }

                                        if (bool4) {
                                                  list.add(map4);
                                        }
                                        if (bool5) {
                                                  list.add(map5);
                                        }
                                        if (bool6) {
                                                  list.add(map6);
                                        }
//                                        if (bool7) {
//                                                  list.add(map7);
//                                        }
                                        // System.out.println(list);
                                        Map<Integer, Object>[] mapOut = null;

                                        for (int i = 0; i < list.size(); i++) {
                                                  System.out.println(list
                                                                      .get(i));
                                        }

                              }
                    });

                    JLabel label_1 = new JLabel("수강요일");
                    label_1.setBounds(30, 196, 65, 15);

                    JLabel label_2 = new JLabel("시작시간");
                    label_2.setBounds(117, 196, 65, 15);

                    JLabel label_3 = new JLabel("끝나시간");
                    label_3.setBounds(263, 196, 62, 15);

                    JLabel label_4 = new JLabel("강의실");
                    label_4.setBounds(365, 196, 147, 15);

                    checkBox_1 = new JCheckBox("월");
                    checkBox_1.setBounds(47, 229, 48, 23);

                    checkBox_2 = new JCheckBox("화");
                    checkBox_2.setBounds(47, 262, 48, 23);

                    checkBox_3 = new JCheckBox("수");
                    checkBox_3.setBounds(47, 294, 48, 23);

                    checkBox_4 = new JCheckBox("목");
                    checkBox_4.setBounds(47, 326, 48, 23);

                    checkBox_5 = new JCheckBox("금");
                    checkBox_5.setBounds(47, 354, 48, 23);

                    checkBox_6 = new JCheckBox("토");
                    checkBox_6.setBounds(47, 386, 48, 23);

                    // SpinnerDateModel model = new SpinnerDateModel();
                    spinner_1_1 = new JSpinner(new SpinnerDateModel());
                    spinner_1_1.setBounds(117, 230, 93, 22);
                    // spinner_1_1.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_2_1 = new JSpinner(new SpinnerDateModel());
                    spinner_2_1.setBounds(117, 262, 93, 22);

                    spinner_3_1 = new JSpinner(new SpinnerDateModel());
                    spinner_3_1.setBounds(117, 294, 93, 22);

                    spinner_4_1 = new JSpinner(new SpinnerDateModel());
                    spinner_4_1.setBounds(117, 326, 93, 22);

                    spinner_5_1 = new JSpinner(new SpinnerDateModel());
                    spinner_5_1.setBounds(117, 354, 93, 22);

                    spinner_6_1 = new JSpinner(new SpinnerDateModel());
                    spinner_6_1.setBounds(117, 386, 93, 22);

                    spinner_1_2 = new JSpinner(new SpinnerDateModel());
                    spinner_1_2.setBounds(245, 230, 102, 22);
                    // spinner_1_2.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_2_2 = new JSpinner(new SpinnerDateModel());
                    spinner_2_2.setBounds(245, 262, 102, 22);

                    spinner_3_2 = new JSpinner(new SpinnerDateModel());
                    spinner_3_2.setBounds(245, 294, 102, 22);

                    spinner_4_2 = new JSpinner(new SpinnerDateModel());
                    spinner_4_2.setBounds(245, 326, 102, 22);

                    spinner_5_2 = new JSpinner(new SpinnerDateModel());
                    spinner_5_2.setBounds(245, 354, 102, 22);

                    spinner_6_2 = new JSpinner(new SpinnerDateModel());
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

                    comboBox_1 = new JComboBox();
                    comboBox_1.setBounds(365, 230, 147, 21);
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_2 = new JComboBox();
                    comboBox_2.setBounds(365, 263, 147, 21);
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_3 = new JComboBox();
                    comboBox_3.setBounds(365, 295, 147, 21);
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_4 = new JComboBox();
                    comboBox_4.setBounds(365, 327, 147, 21);
                    comboBox_4.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_5 = new JComboBox();
                    comboBox_5.setBounds(365, 354, 147, 21);
                    comboBox_5.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_6 = new JComboBox();
                    comboBox_6.setBounds(365, 387, 147, 21);
                    comboBox_6.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    lblNewLabel = new JLabel("분 반:");
                    lblNewLabel.setBounds(48, 119, 48, 15);

                    textField = new JTextField();
                    textField.setBounds(114, 116, 116, 21);
                    textField.setColumns(10);

                    lblNewLabel_1 = new JLabel("정 원:");
                    lblNewLabel_1.setBounds(333, 119, 48, 15);

                    textField_1 = new JTextField();
                    textField_1.setBounds(386, 116, 102, 21);
                    textField_1.setColumns(10);
                    
                    JLabel lblNewLabel_2 = new JLabel("대상학년:");
                    lblNewLabel_2.setBounds(30, 80, 69, 15);
                    
                    JComboBox comboBox = new JComboBox();
                    comboBox.setBounds(114, 77, 116, 21);
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {"1학년", "2학년", "3학년", "4학년", "대학원"}));
                    
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
                    
                    bgroup=new ButtonGroup();
                    bgroup.add(xRadioButton);
                    bgroup.add(cRadioButton);
                    
                    cRadioButton.setBounds(204, 153, 102, 23);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField);
                    contentPane.add(label_1);
                    contentPane.add(checkBox_1);
                    contentPane.add(checkBox_2);
                    contentPane.add(checkBox_3);
                    contentPane.add(checkBox_4);
                    contentPane.add(checkBox_5);
                    contentPane.add(checkBox_6);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(comboBox);
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
                    contentPane.add(comboBox_6);
                    contentPane.add(comboBox_5);
                    contentPane.add(comboBox_4);
                    contentPane.add(comboBox_3);
                    contentPane.add(comboBox_1);
                    contentPane.add(comboBox_2);
                    contentPane.add(leabel_pro);
                    contentPane.add(label_3);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(leabel_term);
                    contentPane.add(textField_1);
                    contentPane.add(comboBox_term);
                    contentPane.add(submitButton);
                    contentPane.add(button);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(xRadioButton);
                    contentPane.add(cRadioButton);
                    
                    textField_2 = new JTextField();
                    textField_2.setBounds(114, 32, 116, 21);
                    contentPane.add(textField_2);
                    textField_2.setColumns(10);
                    
                    JButton btnNewButton = new JButton("조회");
                    btnNewButton.setBounds(230, 31, 65, 23);
                    contentPane.add(btnNewButton);
                    
                    JButton button_1 = new JButton("조회");
                    button_1.setBounds(489, 31, 65, 23);
                    contentPane.add(button_1);
                    
                    textField_3 = new JTextField();
                    textField_3.setBounds(386, 32, 102, 21);
                    contentPane.add(textField_3);
                    textField_3.setColumns(10);
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
