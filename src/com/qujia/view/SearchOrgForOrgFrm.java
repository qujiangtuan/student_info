package com.qujia.view;

import java.awt.Color;
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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.model.Org;
import com.qujia.util.ViewUtil;

public class SearchOrgForOrgFrm extends JDialog {

          private JPanel contentPane;
          private JTextField textField_name;
          private JTable table;
          private JComboBox comboBox_co,comboBox_gdm;
          private static int index;
          private static String orgName;
          private List<Org> orgList;
          private static String orgType;
          

          public static String getOrgName() {
                    return orgName;
          }

          public static void setOrgName(String orgName) {
                    SearchOrgForOrgFrm.orgName = orgName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SearchOrgForOrgFrm frame = new SearchOrgForOrgFrm(null,null);
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
          public SearchOrgForOrgFrm(JFrame fr,String orgType1) {
                    super(fr, "", true);
                    this.setResizable(false);
                    this.orgType=orgType1;
                    setTitle("조직조회");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 899, 453);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC870\uC9C1\uBA85:");
                    lblNewLabel.setBounds(17, 28, 46, 15);
                    
                    textField_name = new JTextField();
                    textField_name.setBounds(75, 25, 83, 22);
                    textField_name.setColumns(10);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 65, 849, 277);
                    
                    JButton updateButton = new JButton("확 인");
                    updateButton.setBounds(535, 360, 83, 23);
                    updateButton.setBackground(new Color(240,240,240));
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        submiEditAct(e);
                              }
                    });
                    
                    JButton deleteButton = new JButton("취 소");
                    deleteButton.setBounds(657, 360, 83, 23);
                    deleteButton.setBackground(new Color(240,240,240));
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteOrg(e);
                              }
                    });
                    
                    JLabel label_cogr = new JLabel("대학/대학원:");
                    label_cogr.setBounds(191, 28, 83, 15);
                    
                     comboBox_co = new JComboBox();
                     comboBox_co.setBounds(286, 25, 79, 21);
                     comboBox_co.setModel(new DefaultComboBoxModel(new String[] {"", "대학", "대학원"}));
                    
                    JButton searchButton = new JButton("조 회");
                    searchButton.setBounds(582, 24, 100, 23);
                    searchButton.setBackground(new Color(224, 255, 255));
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        Org org=new Org();
                                        String searchName,parCode,coGrCode,gdmCode;
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
//                                        try {
//                                                  orgType=comboBox_type.getSelectedItem().toString();
//                                        } catch (NullPointerException e4) {
//                                                  orgType=null;
//                                        }
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
//                                        org.setOrgType(orgType);
                                        org.setCoGrCode(coGrCode);
                                        org.setGsDepMajCode(gdmCode);
                                        setTable(org);
                              }
                    });
                    
                    JLabel label_dept = new JLabel("학부/과/전공:");
                    label_dept.setBounds(389, 28, 83, 15);
                    
                    comboBox_gdm = new JComboBox();
                    comboBox_gdm.setBounds(492, 25, 65, 21);
                    comboBox_gdm.setModel(new DefaultComboBoxModel(new String[] {"", "학부", "학과", "전공"}));
                    
                    table = new JTable();
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
                                        "\uC870\uC9C1\uCF54\uB4DC", "\uC870\uC9C1\uBA85", "\uC870\uC9C1\uAD6C\uBD84", "\uB300\uD559/\uB300\uD559\uC6D0\uAD6C\uBD84", "\uBD80\uC11C(\uD559\uBD80/\uD559\uACFC/\uC804\uACF5)", "\uBD80\uC18D\uAE30\uAD00\uC885\uB958", "\uC0C1\uC704\uC870\uC9C1", "\uB4F1\uB85D\uC77C\uC790"
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
                    table.getColumnModel().getColumn(1).setPreferredWidth(137);
                    table.getColumnModel().getColumn(2).setPreferredWidth(103);
                    table.getColumnModel().getColumn(3).setPreferredWidth(107);
                    table.getColumnModel().getColumn(4).setPreferredWidth(135);
                    table.getColumnModel().getColumn(5).setPreferredWidth(89);
                    table.getColumnModel().getColumn(6).setPreferredWidth(126);
                    table.getColumnModel().getColumn(7).setPreferredWidth(89);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField_name);
                    contentPane.add(label_cogr);
                    contentPane.add(comboBox_co);
                    contentPane.add(label_dept);
                    contentPane.add(comboBox_gdm);
                    contentPane.add(searchButton);
                    contentPane.add(scrollPane);
                    contentPane.add(updateButton);
                    contentPane.add(deleteButton);
                    if(orgType.equals("부속기관")||orgType.equals("본부행정기관")){
                              label_cogr.setVisible(false);
                              comboBox_co.setVisible(false);
                              label_dept.setVisible(false);
                              comboBox_gdm.setVisible(false);
                    }else{
                              label_cogr.setVisible(true);
                              comboBox_co.setVisible(true);
                              label_dept.setVisible(true);
                              comboBox_gdm.setVisible(true);
                    }
                    
                    Org org=new Org();
                    org.setOrgType(orgType);
                    setTable(org);
          }
          //조직 삭제
          protected void deleteOrg(ActionEvent e) {
                    orgName=null;
                    dispose();
          }

          //조직 확인 submit
          protected void submiEditAct(ActionEvent e) {
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
                    orgName=dft.getValueAt(index, 1).toString();
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
                    index=table.getSelectedRow();
          }
        //classId에 통해서 className를 받는다
          public String getOrgNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList=orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }

}
