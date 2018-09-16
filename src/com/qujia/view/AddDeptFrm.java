package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.DeptDao;
import com.qujia.model.Dept;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddDeptFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTextField textField_num;
          private JTextField textField_3;
          private JTextField textField_year1;
          private JTextField textField_year2;
          private JTextField textField_credit;
          private JTextField textField_no;
          private JComboBox comboBox_uni;
          private DatePicker datePicker;
          private JTextArea textArea_explain;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddDeptFrm frame = new AddDeptFrm();
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
          public AddDeptFrm() {
                    setTitle("\uD559\uACFC(\uC804\uACF5)\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 471, 546);

                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    JLabel label_no = new JLabel("\uD559\uACFC\uCF54\uB4DC:");
                    label_no.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_name = new JTextField();
                    textField_name.setColumns(10);

                    JLabel label_uni = new JLabel("\uC18C\uC18D\uB300\uD559:");
                    label_uni.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel label_credit = new JLabel(
                                        "\uC878\uC5C5\uC774\uC218\uD559\uC810:");
                    label_credit.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_num = new JTextField();
                    textField_num.setColumns(10);

                    JLabel label_num = new JLabel("\uBAA8\uC9D1\uC778\uC6D0:");
                    label_num.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    label_num.setBackground(new Color(175, 238, 238));

                    textField_3 = new JTextField();
                    textField_3.setColumns(10);

                    JLabel label_loginDate = new JLabel(
                                        "\uB4F1\uB85D\uC77C\uC9DC:");
                    label_loginDate.setFont(new Font("NanumMyeongjo",
                                        Font.BOLD, 13));

                    JLabel label_year1 = new JLabel("\uC218\uD559\uB144\uD55C:");
                    label_year1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_year1 = new JTextField();
                    textField_year1.setColumns(10);

                    JLabel label_year2 = new JLabel("\uC7AC\uD559\uB144\uD55C:");
                    label_year2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_year2 = new JTextField();
                    textField_year2.setColumns(10);

                    comboBox_uni = new JComboBox();
                    comboBox_uni.setEditable(true);
                    comboBox_uni.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));
                    comboBox_uni.setModel(new DefaultComboBoxModel(
                                        new String[] {
                                                            "\uACF5\uD559\uB300\uD559",
                                                            "\uBB38\uD654\uB300\uD559",
                                                            "\uACBD\uC601\uB300\uD559",
                                                            "\uC218\uC0B0\uB300\uD559" }));

                    JButton button_submit = new JButton("\uB4F1 \uB85D");
                    button_submit.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        addDept(e);
                              }
                    });
                    button_submit.setBackground(new Color(175, 238, 238));
                    button_submit.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    textField_credit = new JTextField();
                    textField_credit.setColumns(10);

                    JLabel label_name = new JLabel("\uD559\uACFC\uC774\uB984:");
                    label_name.setFont(new Font("Dialog", Font.BOLD, 13));

                    textField_no = new JTextField();
                    textField_no.setColumns(10);

                    datePicker = new DatePicker();

                    JButton button_cancel = new JButton("\uCDE8 \uC18C");
                    button_cancel.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
//                                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                                        AddDeptFrm adf=new AddDeptFrm();
////                                        adf.dispose();
////                                        adf.setVisible(false);
////                                        
//                                        adf.dispatchEvent(new WindowEvent(adf, WindowEvent.WINDOW_CLOSING));
                              }
                    });
                    button_cancel.setFont(new Font("Dialog", Font.BOLD, 14));
                    button_cancel.setBackground(new Color(175, 238, 238));

                    JLabel label_explain = new JLabel(
                                        "\uD559\uACFC\uC124\uBA85:");
                    label_explain.setFont(new Font("Dialog", Font.BOLD, 13));

                    JScrollPane scrollPane = new JScrollPane();
                    
                    JButton btnNewButton = new JButton("\uC911\uBCF5\uD559\uC778");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        String deptNo= textField_no.getText().toString();
                                        if(StringUtil.isEmpty(deptNo)){
                                                  JOptionPane.showMessageDialog(null, "학과코드 입력합시오!");
                                                  return;
                                        }
                                        Dept dept=new Dept();
                                        DeptDao deptDao=new DeptDao();
                                        List<Dept> deptList = deptDao.getDeptList(dept);
                                        List<String> deptNoList = new ArrayList<String>();
                                        for (Dept deptNo2 : deptList) {
                                                  String string1=deptNo2.getDeptNo();
                                                  deptNoList.add(string1);
                                        }
                                        if(!deptNoList.contains(deptNo)){
                                                  JOptionPane.showMessageDialog(null, "학과코드 사용할 수 있습니다!");
                                                  return;
                                        }else{
                                                  JOptionPane.showMessageDialog(null, "학과코드 중복됩니다!");
                                                  textField_no.setText("");
                                                  return;
                                        }
                                        
                              }
                    });
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(76)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(label_year1)
                                                            .addComponent(label_year2)
                                                            .addComponent(label_num)
                                                            .addComponent(label_loginDate)
                                                            .addComponent(label_credit)
                                                            .addComponent(label_uni)
                                                            .addComponent(label_name)
                                                            .addComponent(label_no)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                      .addComponent(button_submit, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(label_explain, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(29)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(textField_name, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                                                .addComponent(textField_no, 142, 142, 142)
                                                                                .addComponent(textField_credit, 142, 142, Short.MAX_VALUE)
                                                                                .addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                                                .addComponent(textField_year1, 125, 142, Short.MAX_VALUE)
                                                                                .addComponent(textField_year2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                                                .addComponent(textField_3, 125, 142, Short.MAX_VALUE)
                                                                                .addComponent(textField_num, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                                                                .addComponent(comboBox_uni, 0, 142, Short.MAX_VALUE)
                                                                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(btnNewButton)
                                                  .addGap(23))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(23)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_no)
                                                            .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField_no, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_name)
                                                            .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(26)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_uni)
                                                            .addComponent(comboBox_uni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_credit)
                                                            .addComponent(textField_credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_num))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(label_loginDate)
                                                            .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(16)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(textField_year1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_year1))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(textField_year2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_year2)))
                                                            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(label_explain, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(19)
                                                                      .addComponent(button_submit))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(18)
                                                                      .addComponent(button_cancel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
                                                  .addGap(22))
                    );

                    textArea_explain = new JTextArea();
                    textArea_explain.setLineWrap(true);
                    scrollPane.setViewportView(textArea_explain);
                    contentPane.setLayout(gl_contentPane);
          }

          public String getStringDate(DatePicker datepick) {
                    String stringDate;
                    SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = (Date) datepick.getValue();
                    //System.out.println(date);
                    stringDate = form.format(date);
                    return stringDate;
          }

          // 등록 submit
          protected void addDept(ActionEvent e) {
                    String deptNo, deptName, college, loginDate, dept_exp;
                    int pNum, credit, year1, year2;
                    try {
                              deptNo = textField_no.getText().toString();
                              deptName = textField_name.getText().toString();
                              college = comboBox_uni.getSelectedItem()
                                                  .toString();
                              pNum = Integer.parseInt(textField_num.getText());

                              loginDate = getStringDate(datePicker);
                              credit = Integer.parseInt(textField_credit
                                                  .getText());
                              year1 = Integer.parseInt(textField_year1
                                                  .getText());
                              year2 = Integer.parseInt(textField_year2
                                                  .getText());
                              dept_exp = textArea_explain.getText().toString();
                    } catch (Exception e1) {
                              JOptionPane.showMessageDialog(this,
                                                  "데이터를 입력해주세요!");
                              return;
                    }

                    if (StringUtil.isEmpty(deptNo)) {
                              JOptionPane.showMessageDialog(this,
                                                  "학과코드를 입력해주세요!");
                              return;
                    }
                    if (StringUtil.isEmpty(deptName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "학과이름을 입력해주세요!");
                              return;
                    }
                    if (StringUtil.isEmpty(credit)) {
                              JOptionPane.showMessageDialog(this,
                                                  "졸업이수학점을 입력해주세요!");
                              return;
                    }
                    if (StringUtil.isEmpty(pNum)) {
                              JOptionPane.showMessageDialog(this,
                                                  "모집인원을 입력해주세요!");
                              return;
                    }

                    if (StringUtil.isEmpty(year1)) {
                              JOptionPane.showMessageDialog(this,
                                                  "수학년한을 입력해주세요!");
                              return;
                    }
                    if (StringUtil.isEmpty(year2)) {
                              JOptionPane.showMessageDialog(this,
                                                  "재학년한을 입력해주세요!");
                              return;
                    }
                    if (StringUtil.isEmpty(deptNo)
                                        || StringUtil.isEmpty(deptName)
                                        || StringUtil.isEmpty(credit)
                                        || StringUtil.isEmpty(pNum)
                                        || StringUtil.isEmpty(year1)
                                        || StringUtil.isEmpty(year2)) {
                              JOptionPane.showMessageDialog(this,
                                                  "데이터를 입력해주세요!");
                              return;
                    }
                    Dept dept = new Dept();
                    dept.setDeptNo(deptNo);
                    dept.setDeptName(deptName);
                    dept.setCollege(college);
                    dept.setpNum(pNum);
                    dept.setLoginDate(loginDate);
                    dept.setCredit(credit);
                    dept.setYear1(year1);
                    dept.setYear2(year2);
                    dept.setDeptExplain(dept_exp);

                    DeptDao dd = new DeptDao();
                    if (dd.addDept(dept)) {
                              JOptionPane.showMessageDialog(this, "등록 성공 !");
                    } else {
                              JOptionPane.showMessageDialog(this, "등록 실패 !");
                    }
                    dd.closeDao();
                    resetValue(e);
          }

          // 초기화
          private void resetValue(ActionEvent e) {
                    // TODO Auto-generated method stub
                    textField_no.setText("");
                    textField_name.setText("");
                    comboBox_uni.setSelectedIndex(0);
                    textField_num.setText("");

                    // datePicker.getValue();
                    textField_credit.setText("");
                    textField_year1.setText("");
                    textField_year2.setText("");
                    textArea_explain.setText("");
          }
}
