package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.DeptStandDao;
import com.qujia.dao.OrgDao;
import com.qujia.model.DeptStand;
import com.qujia.model.Org;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddDeptStandFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_max;
          private JTextField textField_year1;
          private JTextField textField_year2;
          private JTextField textField_min;
          private JTextArea textArea_explain;
          private JTextField textField_deptName;
          private List<Org> orgList;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddDeptStandFrm frame = new AddDeptStandFrm();
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
          public AddDeptStandFrm() {
                    this.setResizable(false);
                    setTitle("교육부서학사기준등록");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 664, 355);

                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    JLabel label_credit = new JLabel(
                                        "학기당최소이수학점:");
                    label_credit.setBounds(81, 65, 123, 15);
                    label_credit.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_max = new JTextField();
                    textField_max.setBounds(233, 101, 116, 21);
                    textField_max.setColumns(10);

                    JLabel label_num = new JLabel("학기당최대이수학점:");
                    label_num.setBounds(81, 104, 123, 15);
                    label_num.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    label_num.setBackground(new Color(175, 238, 238));

                    JLabel label_year1 = new JLabel("\uC218\uD559\uB144\uD55C:");
                    label_year1.setBounds(370, 68, 58, 15);
                    label_year1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_year1 = new JTextField();
                    textField_year1.setBounds(457, 65, 116, 21);
                    textField_year1.setColumns(10);

                    JLabel label_year2 = new JLabel("\uC7AC\uD559\uB144\uD55C:");
                    label_year2.setBounds(370, 107, 58, 15);
                    label_year2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_year2 = new JTextField();
                    textField_year2.setBounds(457, 104, 116, 21);
                    textField_year2.setColumns(10);

                    JButton button_submit = new JButton("\uB4F1 \uB85D");
                    button_submit.setBounds(142, 259, 71, 25);
                    button_submit.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        addDept(e);
                              }
                    });
                    button_submit.setBackground(new Color(175, 238, 238));
                    button_submit.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    textField_min = new JTextField();
                    textField_min.setBounds(233, 62, 116, 21);
                    textField_min.setColumns(10);

                    JLabel label_name = new JLabel("\uD559\uACFC/\uC804\uACF5\uC774\uB984:");
                    label_name.setBounds(112, 25, 92, 19);
                    label_name.setFont(new Font("Dialog", Font.BOLD, 13));

                    JButton button_cancel = new JButton("\uCDE8 \uC18C");
                    button_cancel.setBounds(380, 257, 77, 29);
                    button_cancel.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                       dispose();
                              }
                    });
                    button_cancel.setFont(new Font("Dialog", Font.BOLD, 14));
                    button_cancel.setBackground(new Color(175, 238, 238));

                    JLabel label_explain = new JLabel(
                                        "\uD559\uACFC\uC124\uBA85:");
                    label_explain.setBounds(142, 153, 60, 19);
                    label_explain.setFont(new Font("Dialog", Font.BOLD, 13));

                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(233, 153, 224, 82);
                    
                    textArea_explain = new JTextArea();
                    textArea_explain.setLineWrap(true);
                    scrollPane.setViewportView(textArea_explain);
                    contentPane.setLayout(null);
                    contentPane.add(button_submit);
                    contentPane.add(button_cancel);
                    contentPane.add(label_explain);
                    contentPane.add(label_year2);
                    contentPane.add(label_year1);
                    contentPane.add(label_name);
                    contentPane.add(label_credit);
                    contentPane.add(label_num);
                    contentPane.add(scrollPane);
                    contentPane.add(textField_year2);
                    contentPane.add(textField_min);
                    contentPane.add(textField_max);
                    contentPane.add(textField_year1);
                    
                    textField_deptName = new JTextField();
                    textField_deptName.setEditable(false);
                    textField_deptName.setBounds(233, 24, 116, 21);
                    contentPane.add(textField_deptName);
                    textField_deptName.setColumns(10);
                    
                    JButton btnNewButton = new JButton("조회");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        SearchDeptForStuFrm sdf=new SearchDeptForStuFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_deptName.setText(addSearch());
                              }
                    });
                    btnNewButton.setBounds(360, 23, 97, 23);
                    contentPane.add(btnNewButton);
          }

          protected String addSearch() {
                    return SearchDeptForStuFrm.getDeptName();
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
                    String orgid,deptName,loginDate, dept_exp;
                    int max, min, year1, year2;
//                    Org org1 = (Org) comboBox_name.getSelectedItem();
                    deptName = textField_deptName.getText().toString();
                    orgid=this.getOrgidByOrgName(deptName);
//                    deptName=org1.getName();
                    try {
                              max = Integer.parseInt(textField_max.getText());

                              loginDate = DateUtil.getTodayDate();
                              min = Integer.parseInt(textField_min
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

                    if (StringUtil.isEmpty(deptName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "학과이름을 선택해주세요!");
                              return;
                    }
                    if (StringUtil.isEmpty(min)) {
                              JOptionPane.showMessageDialog(this,
                                                  "학기당최소이수학점을 입력해주세요!");
                              return;
                    }
                    if (StringUtil.isEmpty(max)) {
                              JOptionPane.showMessageDialog(this,
                                                  "학기당최대이수학점을 입력해주세요!");
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
                    if (StringUtil.isEmpty(deptName)
                                        || StringUtil.isEmpty(min)
                                        || StringUtil.isEmpty(max)
                                        || StringUtil.isEmpty(year1)
                                        || StringUtil.isEmpty(year2)) {
                              JOptionPane.showMessageDialog(this,
                                                  "데이터를 입력해주세요!");
                              return;
                    }
                    DeptStandDao dsDao=new DeptStandDao();
//                    int inNum=dsDao.getStudentCount(orgid);
                   DeptStand dStand=new DeptStand();
                   dStand.setOrgid(orgid);
                   dStand.setOrgName(deptName);
                   dStand.setMin(min);
                   dStand.setMax(max);
                   dStand.setLoginDate(loginDate);
                   dStand.setYear1(year1);
                   dStand.setYear2(year2);
                   dStand.setDeptExplain(dept_exp);
//                   dStand.setInNum(inNum);

                    
                    
                    if (dsDao.addDeptStand(dStand)) {
                              JOptionPane.showMessageDialog(this, "등록 성공했습니다 !");
                    } else {
                              JOptionPane.showMessageDialog(this, "등록 실패했습니다 !");
                    }
                    dsDao.closeDao();
                    resetValue(e);
          }
          // 초기화
          private void resetValue(ActionEvent e) {
                    // TODO Auto-generated method stub
//                    textField_no.setText("");
//                    textField_name.setText("");
//                    comboBox_uni.setSelectedIndex(0);
                    textField_deptName.setText("");
                    textField_max.setText("");

                    // datePicker.getValue();
                    textField_min.setText("");
                    textField_year1.setText("");
                    textField_year2.setText("");
                    textArea_explain.setText("");
          }
        //orgName에 통해서 orgid를 받는다
          public String getOrgidByOrgName(String name){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getName().equals(name)) return org.getOrgCode();
                    }
                    return "";
          }
}
