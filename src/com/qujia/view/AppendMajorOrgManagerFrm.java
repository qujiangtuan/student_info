package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.SecondMajorRangeDao;
import com.qujia.model.Org;
import com.qujia.model.SecondMajorRange;
import com.qujia.util.ViewUtil;

public class AppendMajorOrgManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_baseOrg;
          private JButton searchButton;
          private JScrollPane scrollPane;
          private JTable table;
          private JComboBox comboBox_editAllowOrg;
          private JSpinner spinner_start,spinner_end;
          private JComboBox comboBox_allowType,comboBox_rangeType;
          private List<Org> orgList;
          private JTextField textField_allowOrg;
          private String[] allowTypeList,rangeTypeList;
          private JLabel lblNewLabel_7;
          private JRadioButton yesRadioButton;
          private JRadioButton noRadioButton;
          private ButtonGroup bgroup;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AppendMajorOrgManagerFrm frame = new AppendMajorOrgManagerFrm();
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
          public AppendMajorOrgManagerFrm() {
                    setTitle("\uBCF5\uC218\uBD80\uC804\uACF5\uD5C8\uC6A9\uBC94\uC704\uBAA9\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 668, 508);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAE30\uC900\uD559\uACFC:");
                    
                    textField_baseOrg = new JTextField();
                    textField_baseOrg.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    
                     textField_allowOrg = new JTextField();
                    textField_allowOrg.setColumns(10);
                    
                    searchButton = new JButton("\uAC80 \uC0C9");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchSecondMajorRange(e);
                              }
                    });
                    
                    scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    
                      comboBox_editAllowOrg = new JComboBox();
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC2DC\uC791\uB144\uB3C4:");
                    
                      spinner_start = new JSpinner();
                    spinner_start.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                      spinner_end = new JSpinner();
                    spinner_end.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD5C8\uC6A9\uAD6C\uBD84:");
                    
                    comboBox_allowType = new JComboBox();
                    allowTypeList=new String[] {"복수전공", "부전공"};
                    comboBox_allowType.setModel(new DefaultComboBoxModel(allowTypeList));
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC885\uB8CC\uB144\uB3C4:");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uBC94\uC704\uAD6C\uBD84:");
                    
                    comboBox_rangeType = new JComboBox();
                    rangeTypeList=new String[] {"대학", "학부", "학과", "전공"};
                    comboBox_rangeType.setModel(new DefaultComboBoxModel(rangeTypeList));
                    
                    JButton updateButton = new JButton("\uC218 \uC815");
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateSecondAllow(e);
                              }
                    });
                    updateButton.setBackground(new Color(224, 255, 255));
                    
                    JButton deleteButton = new JButton("\uC0AD \uC81C");
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteSecondAllow(e);
                              }
                    });
                    deleteButton.setBackground(new Color(255, 127, 80));
                    
                    lblNewLabel_7 = new JLabel("허용여부:");
                    
                    yesRadioButton = new JRadioButton("Yes");
                    
                    noRadioButton = new JRadioButton("No");
                    bgroup=new ButtonGroup();
                    bgroup.add(yesRadioButton);
                    bgroup.add(noRadioButton);
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(47)
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(textField_baseOrg, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(45)
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addGap(18)
                                                                      .addComponent(textField_allowOrg, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(70)
                                                                      .addComponent(searchButton))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)))
                                                  .addContainerGap(14, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(27)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_7)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(yesRadioButton)
                                                                      .addGap(440))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(lblNewLabel_2)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(comboBox_editAllowOrg, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addComponent(lblNewLabel_4)
                                                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                              .addComponent(comboBox_allowType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addComponent(lblNewLabel_3)
                                                                                                              .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                              .addComponent(spinner_start, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addComponent(noRadioButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                                                                          .addGap(59)
                                                                                          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addComponent(lblNewLabel_5)
                                                                                                              .addGap(18)
                                                                                                              .addComponent(spinner_end, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(gl_contentPane.createSequentialGroup()
                                                                                                              .addComponent(lblNewLabel_6)
                                                                                                              .addGap(18)
                                                                                                              .addComponent(comboBox_rangeType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                                                      .addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(updateButton)
                                                                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(37))))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(27)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_allowOrg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField_baseOrg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchButton))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(comboBox_editAllowOrg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(updateButton))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(spinner_start, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(spinner_end, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(deleteButton))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(comboBox_allowType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(comboBox_rangeType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_7)
                                                            .addComponent(yesRadioButton)
                                                            .addComponent(noRadioButton))
                                                  .addContainerGap(48, Short.MAX_VALUE))
                    );
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent me) {
                                        selectedTableRow(me);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, "", null, null, null, null},
                              },
                              new String[] {
                                        "\uD5C8\uC6A9\uCF54\uB4DC", "\uAE30\uC900\uD559\uACFC", "\uD5C8\uC6A9\uD559\uACFC", "\uC801\uC6A9\uC2DC\uC791\uB144\uB3C4", "\uC801\uC6A9\uC885\uB8CC\uB144\uB3C4", "\uD5C8\uC6A9\uAD6C\uBD84", "\uBC94\uC704\uAD6C\uBD84", "\uB4F1\uB85D\uC77C\uC790", "\uD5C8\uC6A9\uC5EC\uBD80"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(118);
                    table.getColumnModel().getColumn(2).setPreferredWidth(122);
                    table.getColumnModel().getColumn(3).setPreferredWidth(101);
                    table.getColumnModel().getColumn(4).setPreferredWidth(101);
                    table.getColumnModel().getColumn(5).setPreferredWidth(85);
                    table.getColumnModel().getColumn(7).setPreferredWidth(86);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    
                    contentPane.setLayout(gl_contentPane);
                    setDeptName();
                    setTable(new SecondMajorRange());
          }
          //수정
          protected void updateSecondAllow(ActionEvent e) {
                    setDeptName();
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    String allowNo=table.getValueAt(row, 0).toString();
                    Org org=(Org) comboBox_editAllowOrg.getSelectedItem();
                    String allowOrgId = org.getOrgCode();
                    String allowOrgName=org.getName();
                    String startTime = spinner_start.getValue().toString();
                    String endTime=spinner_end.getValue().toString();
                    
                    String allowType = comboBox_allowType.getSelectedItem().toString();
                    String rangeType = comboBox_rangeType.getSelectedItem().toString();
                    String isAllow=yesRadioButton.isSelected()? yesRadioButton.getText(): noRadioButton.getText();
                    SecondMajorRange smr=new SecondMajorRange();
                    smr.setOrgidAllow(allowOrgId);
                    smr.setStartTime(startTime);
                    smr.setEndTime(endTime);
                    smr.setAllowType(allowType);
                    smr.setRangeType(rangeType);
                    smr.setIsAllow(isAllow);
                    smr.setOrgidAllowName(allowOrgName);
                    smr.setAllowNo(allowNo);
                    SecondMajorRangeDao smrDao=new SecondMajorRangeDao();
                    if(smrDao.updateSMR(smr)){
                              JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                    }else{
                              JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                    }
                    smrDao.closeDao();
                    setTable(new SecondMajorRange());
          }

          //delete 삭제 SecondMajorRange
         protected void deleteSecondAllow(ActionEvent e) {
                   setDeptName();
                   int row=table.getSelectedRow();
                   if(row==-1){
                             JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                             return;
                   }
                   if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까？") != JOptionPane.OK_OPTION){
                             return;
                   }
                   SecondMajorRangeDao amrDao =new SecondMajorRangeDao();
                   String allowNo=table.getValueAt(row, 0).toString();
                   if(amrDao.delete(allowNo)){
                             JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                   }else{
                             JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                   }
                   amrDao.closeDao();
                   setTable(new SecondMajorRange());
          }

//검색SecondMajorRange
        protected void searchSecondMajorRange(ActionEvent e) {
                  setDeptName();
                  SecondMajorRange smr=new SecondMajorRange();
                  String baseOrgName = textField_baseOrg.getText().toString();
                  String allowOrgName = textField_allowOrg.getText().toString();
                  smr.setOrgidBaseName(baseOrgName);
                  smr.setOrgidAllowName(allowOrgName);
//                  if(row==-1){
//                            restvalues();
//                  }
                  setTable(smr);
          }

//학과 받기
          protected void setDeptName() {
                    // TODO Auto-generated method stub
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList=orgDao.getOrgdeptNameList(new Org());
                    for (Org org: orgList) {
                              comboBox_editAllowOrg.addItem(org);
                    }
                    orgDao.closeDao();
          }
//        selectedTableRow
        protected void selectedTableRow(MouseEvent me) {
                  // TODO Auto-generated method stub
                  DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                  int row=table.getSelectedRow();
                  //허용학과 편집
                  String allowOrgName=dft.getValueAt(table.getSelectedRow(), 2).toString();
                  for(int i=0;i<comboBox_editAllowOrg.getItemCount();i++){
                            Org org=(Org)comboBox_editAllowOrg.getItemAt(i);
                            if(allowOrgName.equals(org.getName())){
                                      comboBox_editAllowOrg.setSelectedIndex(i);
                            }
                  }
                  //적용시간 수정
                  String start=dft.getValueAt(table.getSelectedRow(), 3).toString();
                  spinner_start.setValue(start);
                  String end=dft.getValueAt(table.getSelectedRow(), 4).toString();
                  spinner_end.setValue(end);
                  //허용구분
                  String allowType=dft.getValueAt(table.getSelectedRow(), 5).toString();
//                  comboBox_allowType
                  for(int i=0;i<comboBox_allowType.getItemCount();i++){
                            if(allowType.equals(allowTypeList[i])){
                                      comboBox_allowType.setSelectedIndex(i);
                            }
                  }
                  //허용부서
                  String rangeType=dft.getValueAt(table.getSelectedRow(), 6).toString();
//                comboBox_allowType
                for(int i=0;i<comboBox_rangeType.getItemCount();i++){
                          if(rangeType.equals(rangeTypeList[i])){
                                    comboBox_rangeType.setSelectedIndex(i);
                          }
                }
                //허용여부
                String isAllow=dft.getValueAt(table.getSelectedRow(), 8).toString();
                if(isAllow.equals(yesRadioButton.getText())) yesRadioButton.setSelected(true);
                if(isAllow.equals(noRadioButton.getText())) noRadioButton.setSelected(true);
        }
     // table다시 설정SecondMajorRange
        public void setTable(SecondMajorRange smr){
                 DefaultTableModel dft = (DefaultTableModel) table.getModel();
                 dft.setRowCount(0);
                 SecondMajorRangeDao smrDao=new SecondMajorRangeDao();
                 List<SecondMajorRange> smrList = smrDao.getSMRList(smr);
                 for(SecondMajorRange s : smrList){
                           Vector v=new Vector();
                           v.add(s.getAllowNo());
                           v.add(this.getDeptNameById(s.getOrgidBase()));
                           v.add(this.getDeptNameById(s.getOrgidAllow()));
                           v.add(s.getStartTime());
                           v.add(s.getEndTime());
                           v.add(s.getAllowType());
                           v.add(s.getRangeType());
                           v.add(s.getLoginDate());
                           v.add(s.getIsAllow());
                           dft.addRow(v);
                 }
                 smrDao.closeDao();
                 
        }
      //classId에 통해서 className를 받는다
        public String getDeptNameById(String id){
                  OrgDao orgDao=new OrgDao();
                  orgList = orgDao.getOrgdeptNameList(new Org());
                  for(Org org:orgList){
                          if(org.getOrgCode().equals(id)) return org.getName();
                  }
                  return "";
        }
}
