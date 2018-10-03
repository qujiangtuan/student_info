package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
          private JTextField textField_eName;
          private JComboBox comboBox_colType,comboBox_schYear,
          comboBox_learnType,comboBox_term,comboBox_creditType,comboBox_deptOrg;
          private JButton submitButton,cancelButton;
          private JLabel lblNewLabel_6;
          private JTextArea textArea;
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
                    setBounds(100, 100, 589, 376);
                    
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

                    JLabel label_1 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel lblNewLabel_2 = new JLabel(" \uB300     \uC0C1 :");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));
                    
                    comboBox_colType = new JComboBox();
                    comboBox_colType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_colType.setModel(new DefaultComboBoxModel(new String[] {
                                        "\uB300\uD559", "\uB300\uD559\uC6D0" }));

                    JLabel lblNewLabel_3 = new JLabel(
                                        "\uB300\uC0C1\uD559\uB144:");
                    lblNewLabel_3.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JLabel lblNewLabel_5 = new JLabel(
                                        "\uB300\uC0C1\uD559\uAE30:");
                    lblNewLabel_5.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

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
                    cancelButton.setBackground(new Color(224, 255, 255));
                    cancelButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    comboBox_creditType = new JComboBox();
                    comboBox_creditType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_creditType.setModel(new DefaultComboBoxModel(new String[] {
                                        "3", "2", "1" }));

                    comboBox_schYear = new JComboBox();
                    comboBox_schYear.setModel(new DefaultComboBoxModel(new String[] {
                                        "1", "2", "3", "4",
                                        "\uB300\uD559\uAD001",
                                        "\uB300\uD559\uAD002",
                                        "\uB300\uD559\uAD003" }));
                    comboBox_schYear.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    comboBox_term = new JComboBox();
                    comboBox_term.setFont(new Font("Dialog", Font.BOLD, 13));
                    comboBox_term.setModel(new DefaultComboBoxModel(new String[] {
                                        "1", "2" }));
                    
                    JLabel lblNewLabel_4 = new JLabel("\uC18C\uC18D\uBD80\uC11C:");
                    lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    comboBox_deptOrg = new JComboBox();
                    
                    lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uC124\uBA85:");
                    lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JScrollPane scrollPane = new JScrollPane();
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(21)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(label)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_name, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(textField_eName, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(label_1)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(comboBox_creditType, 0, 148, Short.MAX_VALUE)
                                                                                .addComponent(submitButton)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(comboBox_learnType, 0, 148, Short.MAX_VALUE)))
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(64)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(lblNewLabel_6)
                                                                                .addComponent(lblNewLabel_5)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addComponent(lblNewLabel_2))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                                    .addComponent(comboBox_schYear, Alignment.TRAILING, 0, 158, Short.MAX_VALUE)
                                                                                                    .addComponent(comboBox_term, 0, 158, Short.MAX_VALUE)
                                                                                                    .addComponent(comboBox_colType, Alignment.TRAILING, 0, 158, Short.MAX_VALUE))
                                                                                          .addGap(30))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                                                                          .addContainerGap())))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(116)
                                                                      .addComponent(cancelButton)
                                                                      .addContainerGap())))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(23)
                                                  .addComponent(lblNewLabel_4)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(comboBox_deptOrg, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(208, Short.MAX_VALUE))
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
                                                            .addComponent(comboBox_schYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField_eName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_3))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addComponent(comboBox_learnType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(comboBox_term, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(lblNewLabel_5)))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(label_1)
                                                                                .addComponent(comboBox_creditType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblNewLabel_6))
                                                                      .addGap(23)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_4)
                                                                                .addComponent(comboBox_deptOrg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(submitButton)
                                                            .addComponent(cancelButton))
                                                  .addGap(37))
                    );
                    
                     textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    scrollPane.setViewportView(textArea);
                    contentPane.setLayout(gl_contentPane);
                    
                    setDeptName();
          }
          //교과목등록 event
          protected void submitAction(ActionEvent ae) {
                    String name=textField_name.getText().toString();
                    String ename=textField_eName.getText().toString();
                    String colType=comboBox_colType.getSelectedItem().toString();
                    String schYear=comboBox_schYear.getSelectedItem().toString();
                    String learnType= comboBox_learnType.getSelectedItem().toString();
                    String term= comboBox_term.getSelectedItem().toString();
                    String creditType=comboBox_creditType.getSelectedItem().toString();
                    Org org = (Org) comboBox_deptOrg.getSelectedItem();
                    String orgId=org.getOrgCode();
                    String subExp=textArea.getText().toString();
                    String subCode=getStudentNumber(orgId);
                    
                    Subjects sbj=new Subjects();
                    sbj.setSubCode(subCode);
                    sbj.setSubName(name);
                    sbj.setSubEname(ename);
                    sbj.setLearnType(learnType);
                    sbj.setCreditType(creditType);
                    sbj.setOrgId(orgId);
                    sbj.setColType(colType);
                    sbj.setSchYear(schYear);
                    sbj.setTerm(term);
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
                    comboBox_schYear.setSelectedIndex(0);
                    comboBox_learnType.setSelectedIndex(0);
                    comboBox_term.setSelectedIndex(0);
                    comboBox_creditType.setSelectedIndex(0);
                    comboBox_deptOrg.setSelectedIndex(0);
                    textArea.setText("");
          }
        //교과목의 소속부서 갖다왓다
          protected void setDeptName() {
                    // TODO Auto-generated method stub
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList=orgDao.getColNameList(new Org());
                    for (Org org: orgList) {
                              comboBox_deptOrg.addItem(org);
                    }
                    orgDao.closeDao();
          }

          // set subject code
          public String getStudentNumber(String str1) {
                    String str = str1.substring(1, 4);
                    String subCode = str+StringUtil.getRandom2();
                    return subCode;
          }
}
