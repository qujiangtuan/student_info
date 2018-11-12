package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.model.Org;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class OrgManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTable table;
          private JTextField textField_editName;
          private JComboBox comboBox_co,comboBox_type,comboBox_gdm;
          private JTextField textField_editPar;
          private List<Org> orgList;
          private static String orgType="교육기관";
          private static int row=-1;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  OrgManagerFrm frame = new OrgManagerFrm();
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
          public OrgManagerFrm() {
                    this.setResizable(false);
                    setTitle("조직관리");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 899, 491);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC870\uC9C1\uBA85:");
                    lblNewLabel.setBounds(15, 28, 53, 15);
                    
                    textField_name = new JTextField();
                    textField_name.setBounds(78, 25, 83, 22);
                    textField_name.setColumns(10);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(15, 65, 853, 277);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC870\uC9C1\uBA85:");
                    lblNewLabel_1.setVisible(false);
                    lblNewLabel_1.setBounds(25, 402, 51, 15);
                    
                    textField_editName = new JTextField();
                    textField_editName.setVisible(false);
                    textField_editName.setBounds(96, 399, 248, 21);
                    textField_editName.setColumns(10);
                    
                    JButton updateButton = new JButton("\uC218 \uC815");
                    updateButton.setBounds(424, 362, 79, 23);
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        submiEditAct(e);
                              }
                    });
                    
                    JButton deleteButton = new JButton("\uC0AD \uC81C");
                    deleteButton.setVisible(false);
                    deleteButton.setBounds(735, 358, 79, 23);
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteOrg(e);
                              }
                    });
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC0C1\uC704\uC870\uC9C1:");
                    lblNewLabel_3.setBounds(25, 366, 63, 15);
                    
                    JLabel lblNewLabel_4 = new JLabel("대학/대학원:");
                    lblNewLabel_4.setBounds(331, 28, 83, 15);
                    
                     comboBox_co = new JComboBox();
                     comboBox_co.setBounds(424, 25, 79, 21);
                     comboBox_co.setModel(new DefaultComboBoxModel(new String[] {"", "대학", "대학원"}));
                    
                    JButton searchButton = new JButton("\uAC80 \uC0C9");
                    searchButton.setBounds(760, 24, 63, 23);
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        Org org=new Org();
                                        String searchName,parCode,orgType,coGrCode,gdmCode;
                                        try {
                                                  searchName=textField_name.getText().toString();
                                        } catch (NullPointerException e2) {
                                                   searchName=null;
                                        }
//                                        try {
//                                                  Org org1 = (Org) comboBox_co.getSelectedItem();
//                                                  parCode=org1.getOrgCode();
//                                        } catch (NullPointerException e3) {
//                                                  parCode=null;
//                                        }
                                        try {
                                                  orgType=comboBox_type.getSelectedItem().toString();
                                        } catch (NullPointerException e4) {
                                                  orgType=null;
                                        }
                                        try {
                                                  coGrCode=comboBox_co.getSelectedItem().toString();
                                        } catch (NullPointerException e4) {
                                                  coGrCode=null;
                                        }
                                        try {
                                                  gdmCode= comboBox_gdm.getSelectedItem().toString();
                                        } catch (NullPointerException e4) {
                                                  gdmCode=null;
                                        }
                                        
                                        org.setName(searchName);
//                                        org.setOrgCode(parCode);
                                        org.setOrgType(orgType);
                                        org.setCoGrCode(coGrCode);
                                        org.setGsDepMajCode(gdmCode);
                                        setTable(org);
                                        resetValues();
                              }
                    });
                    
                    JLabel lblNewLabel_5 = new JLabel("기관:");
                    lblNewLabel_5.setBounds(171, 28, 42, 15);
                    
                    comboBox_type = new JComboBox();
                    comboBox_type.setBounds(223, 25, 98, 21);
                    comboBox_type.setModel(new DefaultComboBoxModel(new String[] {"", "교육기관", "부속기관", "본부행정기관"}));
                    
                    JLabel lblNewLabel_6 = new JLabel("학부/과/전공:");
                    lblNewLabel_6.setBounds(547, 28, 87, 15);
                    
                    comboBox_gdm = new JComboBox();
                    comboBox_gdm.setBounds(644, 25, 65, 21);
                    comboBox_gdm.setModel(new DefaultComboBoxModel(new String[] {"", "학부", "학과", "전공"}));
                    
                    textField_editPar = new JTextField();
                    textField_editPar.setBounds(96, 363, 171, 21);
                    textField_editPar.setColumns(10);
                    
                    JButton btnNewButton = new JButton("조회");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(row==-1){
                                                  JOptionPane.showMessageDialog(null, "행을 선택해주세요!");
                                                  return;
                                        }
//                                        System.out.println("orgManager_serach"+orgType);
                                        SearchOrgForOrgFrm sof=new SearchOrgForOrgFrm(new JFrame(),orgType);
                                        sof.setVisible(true);
                                        textField_editPar.setText(addSearchOrg());
                              }
                    });
                    btnNewButton.setBounds(279, 362, 67, 23);
                    
                    table = new JTable();
                    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectedTableRow(e);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC870\uC9C1\uCF54\uB4DC", "\uC870\uC9C1\uBA85", "\uC870\uC9C1\uAD6C\uBD84", "\uB300\uC0C1\uAD6C\uBD84", "\uD559\uBD80\uACFC\uC804\uACF5\uAD6C\uBD84", "\uBD80\uC18D\uAE30\uAD00\uC885\uB958", "\uC0C1\uC704\uC870\uC9C1", "\uB4F1\uB85D\uC77C\uC790"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(69);
                    table.getColumnModel().getColumn(1).setPreferredWidth(155);
                    table.getColumnModel().getColumn(2).setPreferredWidth(103);
                    table.getColumnModel().getColumn(3).setPreferredWidth(107);
                    table.getColumnModel().getColumn(4).setPreferredWidth(135);
                    table.getColumnModel().getColumn(5).setPreferredWidth(89);
                    table.getColumnModel().getColumn(6).setPreferredWidth(98);
                    table.getColumnModel().getColumn(7).setPreferredWidth(89);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(textField_editPar);
                    contentPane.add(btnNewButton);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(textField_editName);
                    contentPane.add(updateButton);
                    contentPane.add(deleteButton);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField_name);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(comboBox_type);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(comboBox_co);
                    contentPane.add(lblNewLabel_6);
                    contentPane.add(comboBox_gdm);
                    contentPane.add(searchButton);
                    contentPane.add(scrollPane);
                    
                    JButton button = new JButton("닫 기");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    button.setBounds(570, 362, 79, 23);
                    contentPane.add(button);
                    
                    setTable(new Org());
          }
          protected String addSearchOrg() {
                    return SearchOrgForOrgFrm.getOrgName();
          }

          //조직 삭제
          protected void deleteOrg(ActionEvent e) {
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
//                    if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까？") != JOptionPane.OK_OPTION){
//                              return;
//                    }
                    OrgDao orgDao =new OrgDao();
                    String orgCode=table.getValueAt(row, 0).toString();
//                    int subCount=orgDao.getSubCount("11063");
                    int subCount=orgDao.getSubCount(orgCode);
//                    System.out.println("out"+subCount);
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(subCount==0){
                                        if(orgDao.deleteOrg(orgCode)){
                                                  JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                                        }else{
                                                  JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                                        }
                              }else{
                                        boolean updateParCode = orgDao.updateParCode(orgCode);
                                        if(orgDao.deleteOrg(orgCode)&&updateParCode){
                                                  JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                                        }else{
                                                  JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                                        }
                              }
                    }
                   
                    
                    
                    orgDao.closeDao();
                    setTable(new Org());
                    resetValues();
                             
          }

          //조직 수정 submit
          protected void submiEditAct(ActionEvent e) {
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    
                    String orgsName,orgParCode,orgParName;
                    String orgName=textField_editName.getText().toString();
//                    try {
//                              orgsName=textField_editsName.getText().toString();
//                    } catch (NullPointerException e2) {
//                              orgsName=null;
//                    }
                    try {
                              orgParName= textField_editPar.getText().toString();
                              orgParCode = this.getOrgidByOrgName(orgParName);
                    } catch (NullPointerException e2) {
                              orgParCode=null;
                    }
                    
                    if(StringUtil.isEmpty(orgName)){
                              JOptionPane.showMessageDialog(this, "조직이름을 입력해주세요");
                              return;
                    }
                    
                    Org org=new Org();
                    org.setName(orgName);
//                    org.setsName(orgsName);
                    org.setParCode(orgParCode);
                    org.setOrgCode(table.getValueAt(row, 0).toString());
                    OrgDao orgDao=new OrgDao();
//                    if(JOptionPane.showConfirmDialog(this, "수정 하시겠습니까？") != JOptionPane.OK_OPTION){
//                              return;
//                      }
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(orgDao.updateOrg(org)){
                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                              }
                    }else{
                              return;
                    }
                    orgDao.closeDao();
                    setTable(new Org());
                    resetValues();
                    
          }

          private void setTable(Org org){
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList = orgDao.getOrgList(org);
                    for(Org o:orgList){
                              Vector v=new Vector();
                              v.add(o.getOrgCode());
                              v.add(o.getName());
//                              v.add(o.getsName());
                              v.add(o.getOrgType());
                              v.add(o.getCoGrCode());
                              v.add(o.getGsDepMajCode());
                              v.add(o.getAftType());
                              v.add(this.getOrgNameById(o.getParCode()));
                              v.add(o.getTodayDate());
                              dft.addRow(v);
                    }
                    orgDao.closeDao();
                    
           }
        //Table중 행을 선택
          protected void selectedTableRow(MouseEvent me) {
                    String parCode=null;
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    row=table.getSelectedRow();
                    orgType=dft.getValueAt(row, 2).toString();
//                    System.out.println("orgManager:"+orgType);
                    //得到选中表格中的哪一行，那一列的值
                    try {
                              textField_editName.setText(dft.getValueAt(table.getSelectedRow(), 1).toString());
                    } catch (NullPointerException e) {
                              textField_editName.setText("");
                    }
                    try {
                              textField_editPar.setText(dft.getValueAt(table.getSelectedRow(),6).toString());
                    } catch (NullPointerException e) {
                              textField_editPar.setText("");
                    }
                    
          }
          private void resetValues(){
                    textField_editName.setText("");
//                    textField_editsName.setText("");
                    textField_editPar.setText("");
          }
        //orgid에 통해서 orgName를 받는다
          public String getOrgNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
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
