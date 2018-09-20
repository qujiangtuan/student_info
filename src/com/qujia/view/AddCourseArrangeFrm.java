package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.model.ClassRoom;
import com.qujia.model.TableTime;
import com.qujia.util.DateUtil;
import com.qujia.util.ViewUtil;

public class AddCourseArrangeFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_no;
          private JSpinner spinner_1_1, spinner_2_1, spinner_3_1, spinner_4_1,
                              spinner_5_1, spinner_6_1, spinner_7_1,
                              spinner_1_2, spinner_2_2, spinner_3_2,
                              spinner_4_2, spinner_5_2, spinner_6_2,
                              spinner_7_2;
          private JCheckBox checkBox_1, checkBox_2, checkBox_3, checkBox_4,
                              checkBox_5, checkBox_6, checkBox_7;
          private JLabel lebel_name, leabel_no, leabel_pro, leabel_date,
                              leabel_schYear, leabel_term;
          private JComboBox comboBox_name, comboBox_pro, comboBox_schYear,
                              comboBox_term;
          private JComboBox comboBox_1, comboBox_2, comboBox_3, comboBox_4,
                              comboBox_5, comboBox_6, comboBox_7;
          DateUtil dux = new DateUtil();
          private JLabel lblNewLabel;
          private JTextField textField;
          private JLabel lblNewLabel_1;
          private JTextField textField_1;

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
                    setBounds(100, 100, 625, 560);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    lebel_name = new JLabel("\uC218\uAC15\uC774\uB984:");

                    comboBox_name = new JComboBox();
                    comboBox_name.setModel(new DefaultComboBoxModel(
                                        new String[] { "데이터베이스" }));

                    leabel_no = new JLabel("학수번호:");

                    textField_no = new JTextField();
                    textField_no.setColumns(10);

                    leabel_pro = new JLabel("\uB2F4\uB2F9\uAD50\uC218:");

                    comboBox_pro = new JComboBox();
                    comboBox_pro.setModel(new DefaultComboBoxModel(
                                        new String[] { "김**" }));

                    leabel_date = new JLabel(
                                        "\uC218\uAC15\uC2E0\uCCAD\uC77C\uC9DC:");

                    DatePicker datePicker_date = new DatePicker();

                    leabel_schYear = new JLabel("\uD559    \uB144:");

                    comboBox_schYear = new JComboBox();
                    comboBox_schYear.setModel(new DefaultComboBoxModel(
                                        new String[] { "1", "2", "3", "4",
                                                            "대학원1", "대학원2",
                                                            "대학원3" }));

                    leabel_term = new JLabel(" 학기:");

                    comboBox_term = new JComboBox();
                    comboBox_term.setModel(new DefaultComboBoxModel(
                                        new String[] { "1", "2" }));

                    DateUtil du = new DateUtil();

                    JButton submitButton = new JButton("등  록");
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
                                        Boolean bool7 = checkBox_7.isSelected();
                                        String dateStart7 = dux
                                                            .Date2String((Date) spinner_7_1
                                                                                .getValue());
                                        String dateEnd7 = dux
                                                            .Date2String((Date) spinner_7_2
                                                                                .getValue());
                                        String className7 = comboBox_7
                                                            .getSelectedItem()
                                                            .toString();
                                        cr7.setCrName(className7);

                                        TableTime tt7 = new TableTime();
                                        tt7.setBool(bool7);
                                        tt7.setDateStart(dateStart7);
                                        tt7.setDateEnd(dateEnd7);
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
                                        if (bool7) {
                                                  list.add(map7);
                                        }
                                        // System.out.println(list);
                                        Map<Integer, Object>[] mapOut = null;

                                        for (int i = 0; i < list.size(); i++) {
                                                  System.out.println(list
                                                                      .get(i));
                                        }

                              }
                    });

                    JLabel label_1 = new JLabel("수강요일");

                    JLabel label_2 = new JLabel("시작시간");

                    JLabel label_3 = new JLabel("끝나시간");

                    JLabel label_4 = new JLabel("강의실");

                    checkBox_1 = new JCheckBox("월");

                    checkBox_2 = new JCheckBox("화");

                    checkBox_3 = new JCheckBox("수");

                    checkBox_4 = new JCheckBox("목");

                    checkBox_5 = new JCheckBox("금");

                    checkBox_6 = new JCheckBox("토");

                    checkBox_7 = new JCheckBox("일");

                    // SpinnerDateModel model = new SpinnerDateModel();
                    spinner_1_1 = new JSpinner(new SpinnerDateModel());
                    // spinner_1_1.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_2_1 = new JSpinner(new SpinnerDateModel());

                    spinner_3_1 = new JSpinner(new SpinnerDateModel());

                    spinner_4_1 = new JSpinner(new SpinnerDateModel());

                    spinner_5_1 = new JSpinner(new SpinnerDateModel());

                    spinner_6_1 = new JSpinner(new SpinnerDateModel());

                    spinner_7_1 = new JSpinner(new SpinnerDateModel());

                    spinner_1_2 = new JSpinner(new SpinnerDateModel());
                    // spinner_1_2.setModel(new SpinnerDateModel(new
                    // Date(1536505200000L), new Date(1536505200000L), new
                    // Date(1536505200000L), Calendar.HOUR));

                    spinner_2_2 = new JSpinner(new SpinnerDateModel());

                    spinner_3_2 = new JSpinner(new SpinnerDateModel());

                    spinner_4_2 = new JSpinner(new SpinnerDateModel());

                    spinner_5_2 = new JSpinner(new SpinnerDateModel());

                    spinner_6_2 = new JSpinner(new SpinnerDateModel());

                    spinner_7_2 = new JSpinner(new SpinnerDateModel());
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
                    this.setMyModel(spinner_7_1);
                    this.setMyModel(spinner_7_2);

                    comboBox_1 = new JComboBox();
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_3 = new JComboBox();
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_4 = new JComboBox();
                    comboBox_4.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_5 = new JComboBox();
                    comboBox_5.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_6 = new JComboBox();
                    comboBox_6.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    comboBox_7 = new JComboBox();
                    comboBox_7.setModel(new DefaultComboBoxModel(new String[] {
                                        "2001", "2002", "2003", "2004" }));

                    lblNewLabel = new JLabel("분 반:");

                    textField = new JTextField();
                    textField.setColumns(10);

                    lblNewLabel_1 = new JLabel("정 원:");

                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    // btnNewButton.addActionListener(new ActionListener() {
                    // public void getdate(){
                    // Date cellEditorValue = (Date) new
                    // JSpinnerColRender().getCellEditorValue();
                    // }
                    // public void actionPerformed(ActionEvent arg0) {
                    //
                    // ClassRoom cr =new ClassRoom();
                    // Boolean bool = (Boolean)
                    // table_1.getModel().getValueAt(1,0);
                    // String dateStart =(String) new
                    // JSpinnerColRender().getCellEditorValue();
                    // String dateEnd =(String) new
                    // JSpinnerColRender().getCellEditorValue();
                    //
                    // // Date dateStart =(Date) new
                    // JSpinnerColRender().getCellEditorValue();
                    // // Date dateEnd =(Date) new
                    // JSpinnerColRender().getCellEditorValue();
                    // // Date dateStart = (Date)
                    // table_1.getModel().getValueAt(1, 1);
                    // //Date dateEnd = (Date) table_1.getModel().getValueAt(1,
                    // 2);
                    // String crname=(String)
                    // table_1.getModel().getValueAt(1,3);
                    // cr.setCrName(crname);
                    //
                    // TableTime tt=new TableTime();
                    // tt.setBool(bool);
                    // tt.setDateStart(dateStart);
                    // tt.setDateEnd(dateEnd);
                    // tt.setCr(cr);
                    // Map<Integer, Object> map =new HashMap<Integer, Object>();
                    // map.put(1, tt.getBool());
                    // map.put(2,tt.getDateStart());
                    // map.put(3, tt.getDateEnd());
                    // map.put(4, tt.getCr());
                    // System.out.println(map);
                    // //System.out.println(bool);
                    // }
                    // });
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane
                                                            .createSequentialGroup()
                                                            .addGap(42)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addComponent(lblNewLabel)
                                                                                                    .addContainerGap())
                                                                                .addGroup(gl_contentPane
                                                                                                    .createSequentialGroup()
                                                                                                    .addGroup(gl_contentPane
                                                                                                                        .createParallelGroup(
                                                                                                                                            Alignment.LEADING)
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addGroup(gl_contentPane
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.LEADING,
                                                                                                                                                                                                                            false)
                                                                                                                                                                                                        .addComponent(label_1,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(checkBox_1,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(checkBox_2,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(checkBox_3,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(checkBox_4,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(checkBox_5,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(checkBox_6,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(checkBox_7,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE))
                                                                                                                                                                                    .addGap(28)
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.LEADING,
                                                                                                                                                                                                                            false)
                                                                                                                                                                                                        .addComponent(label_2)
                                                                                                                                                                                                        .addComponent(spinner_7_1,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(spinner_6_1,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(spinner_5_1,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(spinner_4_1,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(spinner_3_1,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(spinner_2_1,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(spinner_1_1,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            93,
                                                                                                                                                                                                                            Short.MAX_VALUE)))
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addGap(46)
                                                                                                                                                                                    .addComponent(textField,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        76,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE)))
                                                                                                                                            .addGap(34)
                                                                                                                                            .addGroup(gl_contentPane
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.TRAILING,
                                                                                                                                                                                    false)
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.LEADING)
                                                                                                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                                                                                                            .createParallelGroup(
                                                                                                                                                                                                                                                Alignment.LEADING,
                                                                                                                                                                                                                                                false)
                                                                                                                                                                                                                            .addComponent(spinner_2_2,
                                                                                                                                                                                                                                                Alignment.TRAILING,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                                            .addComponent(spinner_1_2,
                                                                                                                                                                                                                                                Alignment.TRAILING,
                                                                                                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                                                                102,
                                                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                                            .addComponent(spinner_3_2,
                                                                                                                                                                                                                                                Alignment.TRAILING,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                                            .addComponent(spinner_4_2,
                                                                                                                                                                                                                                                Alignment.TRAILING,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                                            .addComponent(spinner_5_2,
                                                                                                                                                                                                                                                Alignment.TRAILING,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                                            .addComponent(spinner_6_2,
                                                                                                                                                                                                                                                Alignment.TRAILING,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                                                                            .addComponent(spinner_7_2,
                                                                                                                                                                                                                                                Alignment.TRAILING,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                0,
                                                                                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                                                                                                            .createSequentialGroup()
                                                                                                                                                                                                                            .addGap(18)
                                                                                                                                                                                                                            .addComponent(label_3,
                                                                                                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                                                                62,
                                                                                                                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                                                                                                    .addGap(18)
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.LEADING,
                                                                                                                                                                                                                            false)
                                                                                                                                                                                                        .addComponent(label_4,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_7,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            147,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_6,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            147,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_5,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            147,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_4,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            147,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_3,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            147,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_1,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            147,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_2,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            147,
                                                                                                                                                                                                                            Short.MAX_VALUE)))
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addComponent(lblNewLabel_1)
                                                                                                                                                                                    .addGap(18)
                                                                                                                                                                                    .addComponent(textField_1,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                    .addPreferredGap(ComponentPlacement.RELATED,
                                                                                                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                        Short.MAX_VALUE)
                                                                                                                                                                                    .addComponent(submitButton)))
                                                                                                                                            .addGap(34))
                                                                                                                        .addGroup(gl_contentPane
                                                                                                                                            .createSequentialGroup()
                                                                                                                                            .addGroup(gl_contentPane
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addComponent(lebel_name)
                                                                                                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                                                                    .addComponent(comboBox_name,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        158,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.LEADING)
                                                                                                                                                                                                        .addComponent(leabel_pro)
                                                                                                                                                                                                        .addComponent(leabel_schYear))
                                                                                                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.LEADING)
                                                                                                                                                                                                        .addComponent(comboBox_schYear,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            158,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(comboBox_pro,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            158,
                                                                                                                                                                                                                            Short.MAX_VALUE))))
                                                                                                                                            .addGap(34)
                                                                                                                                            .addGroup(gl_contentPane
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                    Alignment.LEADING)
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addGap(23)
                                                                                                                                                                                    .addComponent(leabel_no)
                                                                                                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                                                                    .addComponent(textField_no,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                        161,
                                                                                                                                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                                                                                                                .addGroup(gl_contentPane
                                                                                                                                                                                    .createSequentialGroup()
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.TRAILING)
                                                                                                                                                                                                        .addComponent(leabel_term)
                                                                                                                                                                                                        .addComponent(leabel_date))
                                                                                                                                                                                    .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                                                                                                                    .addGroup(gl_contentPane
                                                                                                                                                                                                        .createParallelGroup(
                                                                                                                                                                                                                            Alignment.LEADING,
                                                                                                                                                                                                                            false)
                                                                                                                                                                                                        .addComponent(comboBox_term,
                                                                                                                                                                                                                            0,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE)
                                                                                                                                                                                                        .addComponent(datePicker_date,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                                                            Short.MAX_VALUE))))))
                                                                                                    .addGap(63)))));
                    gl_contentPane.setVerticalGroup(gl_contentPane
                                        .createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane
                                                            .createSequentialGroup()
                                                            .addGap(27)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(lebel_name)
                                                                                .addComponent(comboBox_name,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(textField_no,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(leabel_no))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(gl_contentPane
                                                                                                    .createParallelGroup(
                                                                                                                        Alignment.BASELINE)
                                                                                                    .addComponent(leabel_pro)
                                                                                                    .addComponent(comboBox_pro,
                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(leabel_date))
                                                                                .addComponent(datePicker_date,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(leabel_schYear)
                                                                                .addComponent(leabel_term)
                                                                                .addComponent(comboBox_term,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(comboBox_schYear,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addGap(37)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(label_1)
                                                                                .addComponent(label_2)
                                                                                .addComponent(label_3)
                                                                                .addComponent(label_4))
                                                            .addGap(18)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(checkBox_1)
                                                                                .addComponent(spinner_1_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(comboBox_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_1_2,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(checkBox_2)
                                                                                .addComponent(spinner_2_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_2_2,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(comboBox_2,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(checkBox_3)
                                                                                .addComponent(spinner_3_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_3_2,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(comboBox_3,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(checkBox_4)
                                                                                .addComponent(spinner_4_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_4_2,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(comboBox_4,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(ComponentPlacement.RELATED)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.LEADING)
                                                                                .addGroup(gl_contentPane
                                                                                                    .createParallelGroup(
                                                                                                                        Alignment.BASELINE)
                                                                                                    .addComponent(spinner_5_1,
                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(spinner_5_2,
                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                        GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(comboBox_5,
                                                                                                                        GroupLayout.PREFERRED_SIZE,
                                                                                                                        GroupLayout.DEFAULT_SIZE,
                                                                                                                        GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(checkBox_5))
                                                            .addPreferredGap(ComponentPlacement.UNRELATED)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(spinner_6_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_6_2,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(checkBox_6)
                                                                                .addComponent(comboBox_6,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addPreferredGap(ComponentPlacement.RELATED)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(spinner_7_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(spinner_7_2,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(checkBox_7)
                                                                                .addComponent(comboBox_7,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addGap(26)
                                                            .addGroup(gl_contentPane
                                                                                .createParallelGroup(
                                                                                                    Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel)
                                                                                .addComponent(submitButton)
                                                                                .addComponent(textField,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addComponent(textField_1,
                                                                                                    GroupLayout.PREFERRED_SIZE,
                                                                                                    GroupLayout.DEFAULT_SIZE,
                                                                                                    GroupLayout.PREFERRED_SIZE))
                                                            .addContainerGap(58,
                                                                                Short.MAX_VALUE)));
                    // for (int i = 0; i < rowCount; i++) {
                    // model.setValueAt(new Boolean(false), i, 0);
                    // }

                    contentPane.setLayout(gl_contentPane);
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
