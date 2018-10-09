package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
          comboBox_learnType,comboBox_creditType,comboBox_deptOrg;
          private JButton submitButton,cancelButton;
          private JLabel lblNewLabel_6;
          private JTextArea textArea;
          private JLabel label_2;
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
                    setBounds(100, 100, 589, 385);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);

                    JLabel label = new JLabel("\uACFC\uBAA9\uC774\uB984:");
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_name = new JTextField();
                    textField_name.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField_name.setColumns(10);

                    JLabel lblNewLabel = new JLabel("\uC601\uC5B4\uC774\uB984:");
                    lblNewLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_eName = new JTextField();
                    textField_eName.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    textField_eName.setColumns(10);

                    JLabel lblNewLabel_1 = new JLabel(
                                        "\uC774\uC218\uAD6C\uBD84:");
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    comboBox_learnType  = new JComboBox();
                    comboBox_learnType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_learnType.setModel(new DefaultComboBoxModel(new String[] {
                                        "\uC804\uD544", "\uC804\uC120",
                                        "\uAD50\uD544", "\uAD50\uC120" }));

                    JLabel label_1 = new JLabel("\uC57D \uC5B4 \uBA85:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel lblNewLabel_2 = new JLabel("\uB300\uC0C1\uAD6C\uBD84 :");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));
                    
                    comboBox_colType = new JComboBox();
                    comboBox_colType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_colType.setModel(new DefaultComboBoxModel(new String[] {
                                        "\uB300\uD559", "\uB300\uD559\uC6D0" }));

                    submitButton = new JButton("\uB4F1  \uB85D");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        submitAction(ae);
                              }
                    });
                    submitButton.setBackground(new Color(64, 224, 208));
                    submitButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    cancelButton = new JButton("\uCDE8  \uC18C");
                    cancelButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    cancelButton.setBackground(new Color(224, 255, 255));
                    cancelButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    comboBox_creditType = new JComboBox();
                    comboBox_creditType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_creditType.setModel(new DefaultComboBoxModel(new String[] {
                                        "3", "2", "1" }));
                    
                    label_2 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JPanel panel = new JPanel();
                    
                    textField_mname = new JTextField();
                    textField_mname.setFont(new Font("Dialog", Font.BOLD, 13));
                    textField_mname.setColumns(10);
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(21)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(label)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_name, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_eName, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_mname, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
                                                  .addGap(74)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(comboBox_creditType, 0, 145, Short.MAX_VALUE)
                                                            .addComponent(comboBox_learnType, 0, 145, Short.MAX_VALUE)
                                                            .addComponent(comboBox_colType, Alignment.TRAILING, 0, 145, Short.MAX_VALUE))
                                                  .addGap(30))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(92)
                                                  .addComponent(submitButton)
                                                  .addGap(166)
                                                  .addComponent(cancelButton)
                                                  .addContainerGap(175, Short.MAX_VALUE))
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                  .addComponent(panel, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(23)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(comboBox_colType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label)
                                                            .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_2))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField_eName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(comboBox_learnType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_1)
                                                            .addComponent(comboBox_creditType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField_mname, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(panel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(submitButton)
                                                            .addComponent(cancelButton))
                                                  .addContainerGap(36, Short.MAX_VALUE))
                    );
                    
                    JLabel lblNewLabel_4 = new JLabel("\uC18C\uC18D\uBD80\uC11C:");
                    lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    comboBox_deptOrg = new JComboBox();
                    
                    lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uC124\uBA85:");
                    lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                     textArea = new JTextArea();
                     textArea.setLineWrap(true);
                     scrollPane.setViewportView(textArea);
                    GroupLayout gl_panel = new GroupLayout(panel);
                    gl_panel.setHorizontalGroup(
                              gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                  .addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
                                                            .addGroup(gl_panel.createSequentialGroup()
                                                                      .addGap(16)
                                                                      .addComponent(lblNewLabel_4)
                                                                      .addGap(18)
                                                                      .addComponent(comboBox_deptOrg, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_panel.createSequentialGroup()
                                                                      .addGap(2)
                                                                      .addComponent(lblNewLabel_6)
                                                                      .addGap(18)
                                                                      .addComponent(scrollPane)))
                                                  .addContainerGap(28, Short.MAX_VALUE))
                    );
                    gl_panel.setVerticalGroup(
                              gl_panel.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(comboBox_deptOrg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_6))
                                                  .addContainerGap(12, Short.MAX_VALUE))
                    );
                    panel.setLayout(gl_panel);
                    contentPane.setLayout(gl_contentPane);
                    
                    setDeptName();
          }
          //교과목등록 event
          protected void submitAction(ActionEvent ae) {
                    String name=textField_name.getText().toString();
                    String ename=textField_eName.getText().toString();
                    String colType=comboBox_colType.getSelectedItem().toString();
                    String learnType= comboBox_learnType.getSelectedItem().toString();
                    String creditType=comboBox_creditType.getSelectedItem().toString();
                    Org org = (Org) comboBox_deptOrg.getSelectedItem();
                    String orgId=org.getOrgCode();
                    String subExp=textArea.getText().toString();
                    String subCode;//중복확인
                    subCode=getStudentNumber(orgId);
                    if(this.isRepeat(subCode)){
                              subCode=getStudentNumber(orgId);
                    }
                    String subMname=textField_mname.getText().toString();
                    if(StringUtil.isEmpty(name)){
                              JOptionPane.showMessageDialog(this, "교과목이름을 입력해주세요!");
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
//                    sbj.setSchYear(schYear);
//                    sbj.setTerm(term);
                    sbj.setSubExp(subExp);
                    
                    SubjectsDao sbjDao=new SubjectsDao();
                    if (sbjDao.addSubjects(sbj)) {
                              JOptionPane.showMessageDialog(this,
                                                  "교과목이 등록 성공! ");
                    } else {
                              JOptionPane.showMessageDialog(this,
                                                  "교과목이 등록 실패！");
                    }
                    resetValue(ae);
                    sbjDao.closeDao();
                    
          }
          //등록 입력 초기화
          private void resetValue(ActionEvent ae) {
                    textField_name.setText("");
                    textField_eName.setText("");
                    comboBox_colType.setSelectedIndex(0);
//                    comboBox_schYear.setSelectedIndex(0);
                    comboBox_learnType.setSelectedIndex(0);
//                    comboBox_term.setSelectedIndex(0);
                    comboBox_creditType.setSelectedIndex(0);
                    comboBox_deptOrg.setSelectedIndex(0);
                    textField_mname.setText("");
                    textArea.setText("");
          }
        //교과목의 소속부서 갖다왓다
          protected void setDeptName() {
                    // TODO Auto-generated method stub
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList=orgDao.getOrgdeptNameList(new Org());
                    for (Org org: orgList) {
                              comboBox_deptOrg.addItem(org);
                    }
                    orgDao.closeDao();
          }

          // set subject code
          public String getStudentNumber(String str1) {
                    String str = str1.substring(2, 4);
                    String subCode = str+StringUtil.getRandom3();
                    return subCode;
          }
        //교과목번호 종복학인
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
}
