package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.qujia.dao.OrgDao;
import com.qujia.dao.SubjectsDao;
import com.qujia.model.Org;
import com.qujia.model.Subjects;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddSubjectFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTextField textField_eName,textField_mname;
          private JComboBox comboBox_colType,
          comboBox_learnType,comboBox_creditType;
          private JButton submitButton,cancelButton;
          private JLabel lblNewLabel_6;
          private JTextArea textArea;
          private JLabel label_2;
          private JTextField textField_orgName;
          private List<Org> orgList;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddSubjectFrm frame = new AddSubjectFrm();
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
          public AddSubjectFrm() {
                    setTitle("\uAD50\uACFC\uBAA9\uB4F1\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 631, 375);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    JLabel label = new JLabel("\uACFC\uBAA9\uC774\uB984:");
                    label.setBounds(12, 31, 72, 15);
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_name = new JTextField();
                    textField_name.setBounds(96, 28, 146, 21);
                    textField_name.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField_name.setColumns(10);

                    JLabel lblNewLabel = new JLabel("\uC601\uC5B4\uC774\uB984:");
                    lblNewLabel.setBounds(12, 70, 72, 15);
                    lblNewLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_eName = new JTextField();
                    textField_eName.setBounds(96, 67, 146, 21);
                    textField_eName.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField_eName.setColumns(10);

                    JLabel lblNewLabel_1 = new JLabel(
                                        "\uC774\uC218\uAD6C\uBD84:");
                    lblNewLabel_1.setBounds(330, 70, 58, 15);
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    comboBox_learnType  = new JComboBox();
                    comboBox_learnType.setBounds(406, 67, 146, 21);
                    comboBox_learnType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_learnType.setModel(new DefaultComboBoxModel(new String[] {
                                        "\uC804\uD544", "\uC804\uC120",
                                        "\uAD50\uD544", "\uAD50\uC120" }));

                    JLabel label_1 = new JLabel("\uC57D \uC5B4 \uBA85:");
                    label_1.setBounds(12, 111, 74, 15);
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel lblNewLabel_2 = new JLabel("\uB300\uC0C1\uAD6C\uBD84 :");
                    lblNewLabel_2.setBounds(325, 31, 63, 15);
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));
                    
                    comboBox_colType = new JComboBox();
                    comboBox_colType.setBounds(406, 28, 146, 21);
                    comboBox_colType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_colType.setModel(new DefaultComboBoxModel(new String[] {
                                        "\uB300\uD559", "\uB300\uD559\uC6D0" }));

                    submitButton = new JButton("\uB4F1  \uB85D");
                    submitButton.setBounds(168, 268, 83, 25);
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        submitAction(ae);
                              }
                    });
                    submitButton.setBackground(new Color(64, 224, 208));
                    submitButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    cancelButton = new JButton("\uCDE8  \uC18C");
                    cancelButton.setBounds(334, 268, 90, 25);
                    cancelButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    cancelButton.setBackground(new Color(224, 255, 255));
                    cancelButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    comboBox_creditType = new JComboBox();
                    comboBox_creditType.setBounds(406, 108, 146, 21);
                    comboBox_creditType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_creditType.setModel(new DefaultComboBoxModel(new String[] {
                                        "3", "2", "1" }));
                    
                    label_2 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_2.setBounds(328, 109, 60, 19);
                    label_2.setFont(new Font("��������", Font.BOLD, 13));
                    
                    textField_mname = new JTextField();
                    textField_mname.setBounds(96, 106, 146, 25);
                    textField_mname.setFont(new Font("Dialog", Font.BOLD, 13));
                    textField_mname.setColumns(10);
                    contentPane.setLayout(null);
                    contentPane.add(label);
                    contentPane.add(textField_name);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField_eName);
                    contentPane.add(label_1);
                    contentPane.add(textField_mname);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(label_2);
                    contentPane.add(comboBox_creditType);
                    contentPane.add(comboBox_learnType);
                    contentPane.add(comboBox_colType);
                    contentPane.add(submitButton);
                    contentPane.add(cancelButton);
                    
                    lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uC124\uBA85:");
                    lblNewLabel_6.setBounds(325, 155, 74, 19);
                    contentPane.add(lblNewLabel_6);
                    lblNewLabel_6.setFont(new Font("��������", Font.BOLD, 13));
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(406, 152, 146, 60);
                    contentPane.add(scrollPane);
                    
                     textArea = new JTextArea();
                     textArea.setLineWrap(true);
                     scrollPane.setViewportView(textArea);
                     
                     JLabel lblNewLabel_4 = new JLabel("\uC18C\uC18D\uBD80\uC11C:");
                     lblNewLabel_4.setBounds(12, 152, 74, 19);
                     contentPane.add(lblNewLabel_4);
                     lblNewLabel_4.setFont(new Font("��������", Font.BOLD, 13));
                     
                     textField_orgName = new JTextField();
                     textField_orgName.setBounds(96, 151, 146, 23);
                     contentPane.add(textField_orgName);
                     textField_orgName.setColumns(10);
                     
                     JButton searchButton = new JButton("\uC870\uD68C");
                     searchButton.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent arg0) {
                                         SearchDeptForStuFrm sdf=new SearchDeptForStuFrm(new JFrame());
                                         sdf.setVisible(true);
                                         textField_orgName.setText(addSearch());
                               }
                     });
                     searchButton.setBounds(241, 152, 72, 22);
                     contentPane.add(searchButton);
                    
//                    setDeptName();
          }
          protected String addSearch() {
                    return SearchDeptForStuFrm.getDeptName();
          }

          //�������� event
          protected void submitAction(ActionEvent ae) {
                    String name=textField_name.getText().toString();
                    String ename=textField_eName.getText().toString();
                    String colType=comboBox_colType.getSelectedItem().toString();
                    String learnType= comboBox_learnType.getSelectedItem().toString();
                    String creditType=comboBox_creditType.getSelectedItem().toString();
                    
                    String deptName=textField_orgName.getText().toString();
                    String orgId=this.getOrgidByOrgName(deptName);
                    
                    String subExp=textArea.getText().toString();
                    String subCode;//�ߺ�Ȯ��
                    subCode=getStudentNumber(orgId);
                    if(this.isRepeat(subCode)){
                              subCode=getStudentNumber(orgId);
                    }
                    String subMname=textField_mname.getText().toString();
                    if(StringUtil.isEmpty(name)){
                              JOptionPane.showMessageDialog(this, "�������̸��� �Է����ּ���!");
                              return;
                    }
                    Subjects sbj=new Subjects();
                    sbj.setSubCode(subCode);
                    sbj.setSubName(name);
                    sbj.setSubEname(ename);
                    sbj.setLearnType(learnType);
                    sbj.setCreditType(creditType);
                    sbj.setOrgId(orgId);
                    sbj.setColType(colType);
                    sbj.setSubMname(subMname);
                    sbj.setOrgName(deptName);
//                    sbj.setSchYear(schYear);
//                    sbj.setTerm(term);
                    sbj.setSubExp(subExp);
                    
                    SubjectsDao sbjDao=new SubjectsDao();
                    if (sbjDao.addSubjects(sbj)) {
                              JOptionPane.showMessageDialog(this,
                                                  "�������� ��� �����߽��ϴ�! ");
                    } else {
                              JOptionPane.showMessageDialog(this,
                                                  "�������� ��� �����߽��ϴ٣�");
                    }
                    resetValue(ae);
                    sbjDao.closeDao();
                    
          }
          //��� �Է� �ʱ�ȭ
          private void resetValue(ActionEvent ae) {
                    textField_name.setText("");
                    textField_eName.setText("");
                    comboBox_colType.setSelectedIndex(0);
//                    comboBox_schYear.setSelectedIndex(0);
                    comboBox_learnType.setSelectedIndex(0);
//                    comboBox_term.setSelectedIndex(0);
                    comboBox_creditType.setSelectedIndex(0);
                    textField_orgName.setText("");
                    textField_mname.setText("");
                    textArea.setText("");
          }
//        //�������� �ҼӺμ� ���ٿӴ�
//          protected void setDeptName() {
//                    // TODO Auto-generated method stub
//                    OrgDao orgDao=new OrgDao();
//                    List<Org> orgList=orgDao.getOrgdeptNameList(new Org());
//                    for (Org org: orgList) {
//                              comboBox_deptOrg.addItem(org);
//                    }
//                    orgDao.closeDao();
//          }

          // set subject code
          public String getStudentNumber(String str1) {
                    String str = str1.substring(2, 4);
                    String subCode = str+StringUtil.getRandom3();
                    return subCode;
          }
        //�������ȣ ��������
          private boolean isRepeat(String str){
                  Subjects sb=new Subjects();
                  SubjectsDao sbDao=new SubjectsDao();
                  List<Subjects> sbList = sbDao.getSubjectsList(new Subjects());
                  List<String> sbNoList = new ArrayList<String>();
                  for (Subjects sbNo2 : sbList) {
                            String string1=sbNo2.getSubCode();
                            sbNoList.add(string1);
                  }
                  if(!sbNoList.contains(str)){
                            return false;
                  }else{
                            return true;
                  }
        }
        //orgName�� ���ؼ� orgid�� �޴´�
          public String getOrgidByOrgName(String name){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getName().equals(name)) return org.getOrgCode();
                    }
                    return "";
          }
}
