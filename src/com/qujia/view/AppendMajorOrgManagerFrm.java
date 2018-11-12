package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
          private JSpinner spinner_start,spinner_end;
          private JComboBox comboBox_allowType,comboBox_rangeType;
          private List<Org> orgList;
          private JTextField textField_allowOrg;
          private String[] allowTypeList,rangeTypeList;
          private JLabel lblNewLabel_7;
          private JRadioButton yesRadioButton;
          private JRadioButton noRadioButton;
          private ButtonGroup bgroup;
          private JTextField textField_editAllow;
          private JButton btnNewButton;
          private JButton button;
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
                    this.setResizable(false);
                    setTitle("\uBCF5\uC218\uBD80\uC804\uACF5\uD5C8\uC6A9\uBC94\uC704\uBAA9\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 668, 542);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAE30\uC900\uD559\uACFC:");
                    lblNewLabel.setBounds(32, 36, 72, 15);
                    
                    textField_baseOrg = new JTextField();
                    textField_baseOrg.setBounds(109, 33, 88, 21);
                    textField_baseOrg.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    lblNewLabel_1.setBounds(233, 36, 61, 15);
                    
                     textField_allowOrg = new JTextField();
                     textField_allowOrg.setBounds(312, 33, 96, 21);
                    textField_allowOrg.setColumns(10);
                    
                    searchButton = new JButton("\uAC80 \uC0C9");
                    searchButton.setBounds(478, 32, 77, 23);
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchSecondMajorRange(e);
                              }
                    });
                    
                    scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 65, 618, 197);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD5C8\uC6A9\uD559\uACFC:");
                    lblNewLabel_2.setBounds(41, 284, 67, 15);
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC2DC\uC791\uB144\uB3C4:");
                    lblNewLabel_3.setBounds(41, 325, 67, 15);
                    
                      spinner_start = new JSpinner();
                      spinner_start.setBounds(113, 322, 123, 22);
                    spinner_start.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                      spinner_end = new JSpinner();
                      spinner_end.setBounds(445, 325, 123, 22);
                    spinner_end.setModel(new SpinnerListModel(new String[] {"2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"}));
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD5C8\uC6A9\uAD6C\uBD84:");
                    lblNewLabel_4.setBounds(41, 365, 67, 15);
                    
                    comboBox_allowType = new JComboBox();
                    comboBox_allowType.setBounds(113, 362, 123, 21);
                    allowTypeList=new String[] {"복수전공", "부전공"};
                    comboBox_allowType.setModel(new DefaultComboBoxModel(allowTypeList));
                    
                    JLabel lblNewLabel_5 = new JLabel("\uC885\uB8CC\uB144\uB3C4:");
                    lblNewLabel_5.setBounds(366, 328, 61, 15);
                    
                    JLabel lblNewLabel_6 = new JLabel("\uBC94\uC704\uAD6C\uBD84:");
                    lblNewLabel_6.setBounds(366, 368, 61, 15);
                    
                    comboBox_rangeType = new JComboBox();
                    comboBox_rangeType.setBounds(445, 365, 123, 21);
                    rangeTypeList=new String[] {"대학", "학부", "학과", "전공"};
                    comboBox_rangeType.setModel(new DefaultComboBoxModel(rangeTypeList));
                    
                    JButton updateButton = new JButton("\uC218 \uC815");
                    updateButton.setBounds(157, 446, 77, 23);
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateSecondAllow(e);
                              }
                    });
                    
                    JButton deleteButton = new JButton("\uC0AD \uC81C");
                    deleteButton.setBounds(312, 446, 79, 23);
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteSecondAllow(e);
                              }
                    });
                    
                    lblNewLabel_7 = new JLabel("허용여부:");
                    lblNewLabel_7.setBounds(41, 405, 67, 15);
                    
                    yesRadioButton = new JRadioButton("Yes");
                    yesRadioButton.setBounds(109, 401, 47, 23);
                    
                    noRadioButton = new JRadioButton("No");
                    noRadioButton.setBounds(193, 401, 43, 23);
                    bgroup=new ButtonGroup();
                    bgroup.add(yesRadioButton);
                    bgroup.add(noRadioButton);
                    
                    textField_editAllow = new JTextField();
                    textField_editAllow.setEditable(false);
                    textField_editAllow.setBounds(113, 281, 123, 21);
                    textField_editAllow.setColumns(10);
                    
                    btnNewButton = new JButton("조회");
                    btnNewButton.setBounds(248, 280, 70, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchDeptForStuFrm sdf=new SearchDeptForStuFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_editAllow.setText(addSearch());
                              }
                    });
                    
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
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField_baseOrg);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(textField_allowOrg);
                    contentPane.add(searchButton);
                    contentPane.add(scrollPane);
                    contentPane.add(lblNewLabel_7);
                    contentPane.add(yesRadioButton);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(textField_editAllow);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(comboBox_allowType);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(spinner_start);
                    contentPane.add(noRadioButton);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(spinner_end);
                    contentPane.add(lblNewLabel_6);
                    contentPane.add(comboBox_rangeType);
                    contentPane.add(btnNewButton);
                    contentPane.add(updateButton);
                    contentPane.add(deleteButton);
                    
                    button = new JButton("닫기");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    button.setBounds(478, 446, 79, 23);
                    contentPane.add(button);
                    setTable(new SecondMajorRange());
          }
          protected String addSearch() {
                    return SearchDeptForStuFrm.getDeptName();
          }

          //수정
          protected void updateSecondAllow(ActionEvent e) {
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    String allowNo=table.getValueAt(row, 0).toString();
//                    Org org=(Org) comboBox_editAllowOrg.getSelectedItem();
                    String allowOrgName=textField_editAllow.getText().toString();
                    String allowOrgId = this.getOrgidByOrgName(allowOrgName);
                    
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
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(smrDao.updateSMR(smr)){
                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                              } 
                    }
                    
                    smrDao.closeDao();
                    setTable(new SecondMajorRange());
          }

          //delete 삭제 SecondMajorRange
         protected void deleteSecondAllow(ActionEvent e) {
                   int row=table.getSelectedRow();
                   if(row==-1){
                             JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                             return;
                   }
                   SecondMajorRangeDao amrDao =new SecondMajorRangeDao();
                   String allowNo=table.getValueAt(row, 0).toString();
                   int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                       JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                   if(showConfirmDialog==JOptionPane.YES_OPTION){
                             if(amrDao.delete(allowNo)){
                                       JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                             }else{
                                       JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                             }
                   }
                   amrDao.closeDao();
                   setTable(new SecondMajorRange());
          }

//검색SecondMajorRange
        protected void searchSecondMajorRange(ActionEvent e) {
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

//        selectedTableRow
        protected void selectedTableRow(MouseEvent me) {
                  // TODO Auto-generated method stub
                  DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                  int row=table.getSelectedRow();
                  //허용학과 편집
                  String allowOrgName=dft.getValueAt(table.getSelectedRow(), 2).toString();
                  textField_editAllow.setText(allowOrgName);
//                  for(int i=0;i<comboBox_editAllowOrg.getItemCount();i++){
//                            Org org=(Org)comboBox_editAllowOrg.getItemAt(i);
//                            if(allowOrgName.equals(org.getName())){
//                                      comboBox_editAllowOrg.setSelectedIndex(i);
//                            }
//                  }
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
