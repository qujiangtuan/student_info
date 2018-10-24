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

public class SearchOrgForProFrm extends JDialog {

          private JPanel contentPane;
          private JTextField textField_deptName;
          private static JTable table;
          private JComboBox comboBox_deptType;
          private List<Org> orgList;
          private static int index;
          private AddStudentFrm af;
          private static String deptName;
          private JComboBox comboBox_orgType;
          

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SearchOrgForProFrm frame = new SearchOrgForProFrm(null);
                                                  frame.setVisible(true);
                                        } catch (Exception e) {
                                                  e.printStackTrace();
                                        }
                              }
                    });
          }

          public static String getDeptName() {
                    return deptName;
          }
          public static void setDeptName(String deptName) {
                    SearchOrgForProFrm.deptName = deptName;
          }
          /**
           * Create the frame.
           */
          public SearchOrgForProFrm(JFrame fr) {
                    super(fr, "", true);
                    
                    setTitle("\uC870\uC9C1\uC870\uD68C");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 750, 383);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                    
                    JLabel lblNewLabel = new JLabel("\uC870\uC9C1\uC774\uB984:");
                    lblNewLabel.setBounds(34, 27, 68, 15);
                    contentPane.add(lblNewLabel);
                    
                    textField_deptName = new JTextField();
                    textField_deptName.setBounds(112, 24, 115, 21);
                    contentPane.add(textField_deptName);
                    textField_deptName.setColumns(10);
                    
                      comboBox_deptType = new JComboBox();
                    comboBox_deptType.setModel(new DefaultComboBoxModel(new String[] {"", "\uD559\uBD80", "\uD559\uACFC", "\uC804\uACF5"}));
                    comboBox_deptType.setBounds(531, 24, 115, 21);
                    contentPane.add(comboBox_deptType);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5:");
                    lblNewLabel_1.setBounds(443, 27, 78, 15);
                    contentPane.add(lblNewLabel_1);
                    
                    JButton searchButton = new JButton("\uC870\uD68C");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchDept(e);
                              }
                    });
                    searchButton.setBounds(656, 23, 68, 23);
                    contentPane.add(searchButton);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 64, 714, 200);
                    contentPane.add(scrollPane);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectRow(e);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC870\uC9C1\uCF54\uB4DC", "\uC774\uB984", "\uAE30\uAD00\uAD6C\uBD84", "\uD559\uBD80\uACFC\uC804\uACF5\uAD6C\uBD84", "\uC0C1\uC704\uC870\uC9C1"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(126);
                    table.getColumnModel().getColumn(2).setPreferredWidth(128);
                    table.getColumnModel().getColumn(3).setPreferredWidth(126);
                    table.getColumnModel().getColumn(4).setPreferredWidth(111);
                    scrollPane.setViewportView(table);
                    
                    JButton submitButton = new JButton("\uD655 \uC778");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        submitAction(e);
                              }
                    });
                    submitButton.setBounds(382, 288, 93, 23);
                    contentPane.add(submitButton);
                    
                    JButton cancelButton = new JButton("\uCDE8 \uC18C");
                    cancelButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
//                                        ProManagerFrm pmf=new ProManagerFrm();
//                                        pmf.getTextField_editOrgName().setText(ProManagerFrm.getOrgName());
                                        dispose();
                              }
                    });
                    cancelButton.setBounds(485, 288, 93, 23);
                    contentPane.add(cancelButton);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAE30\uAD00\uAD6C\uBD84:");
                    lblNewLabel_2.setBounds(237, 27, 64, 15);
                    contentPane.add(lblNewLabel_2);
                    
                     comboBox_orgType = new JComboBox();
                    comboBox_orgType.setModel(new DefaultComboBoxModel(new String[] {"", "\uAD50\uC721\uAE30\uAD00", "\uBD80\uC18D\uAE30\uAD00", "\uBCF8\uBD80\uD589\uC815\uAE30\uAD00"}));
                    comboBox_orgType.setBounds(300, 24, 115, 21);
                    contentPane.add(comboBox_orgType);
                    
                    setTable(new Org());
          }
        //submit
          protected void submitAction(ActionEvent e) {
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
                    deptName=dft.getValueAt(index, 1).toString();
          }
          public static String getOrdId(){
                    String orgid;
                    try {
                              DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                              orgid=dft.getValueAt(index,0).toString();
                    } catch (Exception e) {
                              orgid=null;
                    }
                    
                    return orgid;
          }

          //한행선택 event
          protected void selectRow(MouseEvent e) {
                    index=table.getSelectedRow();
          }

          //조회 
          protected void searchDept(ActionEvent e) {
                    Org org=new Org();
                    String searchName,gdmCode,orgType;
                    
                    try {
                              searchName = textField_deptName.getText().toString();
                    } catch (NullPointerException e4) {
                              searchName=null;
                    }
                    try {
                              orgType = comboBox_orgType.getSelectedItem().toString();
                    } catch (Exception e2) {
                              orgType=null;
                    }
                    try {
                              gdmCode=comboBox_deptType.getSelectedItem().toString();
                    } catch (NullPointerException e4) {
                              gdmCode=null;
                    }
                    org.setName(searchName);
                    org.setOrgType(orgType);
                    org.setGsDepMajCode(gdmCode);
                    setTable(org);
          }

          private void setTable(Org org) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(org);
                    for(Org o:orgList){
                              Vector v=new Vector();
                              v.add(o.getOrgCode());
                              v.add(o.getName());
                              v.add(o.getOrgType());
                              v.add(o.getGsDepMajCode());
                              v.add(this.getDeptNameById(o.getParCode()));
                              dft.addRow(v);
                    }
                    orgDao.closeDao();
          }
        //classId에 통해서 className를 받는다
          public String getDeptNameById(String id){
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
}
