package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class SearchDeptFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_deptName;
          private JTable table;
          private JComboBox comboBox_deptType;
          private List<Org> orgList;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SearchDeptFrm frame = new SearchDeptFrm();
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
          public SearchDeptFrm() {
                    setTitle("\uD559\uACFC\uC870\uD68C");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 645, 383);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                    
                    JLabel lblNewLabel = new JLabel("\uD559\uACFC\uC774\uB984:");
                    lblNewLabel.setBounds(34, 27, 68, 15);
                    contentPane.add(lblNewLabel);
                    
                    textField_deptName = new JTextField();
                    textField_deptName.setBounds(112, 24, 142, 21);
                    contentPane.add(textField_deptName);
                    textField_deptName.setColumns(10);
                    
                      comboBox_deptType = new JComboBox();
                    comboBox_deptType.setModel(new DefaultComboBoxModel(new String[] {"", "\uD559\uBD80", "\uD559\uACFC", "\uC804\uACF5"}));
                    comboBox_deptType.setBounds(360, 24, 115, 21);
                    contentPane.add(comboBox_deptType);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5:");
                    lblNewLabel_1.setBounds(272, 27, 78, 15);
                    contentPane.add(lblNewLabel_1);
                    
                    JButton searchButton = new JButton("\uC870\uD68C");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchDept(e);
                              }
                    });
                    searchButton.setBounds(485, 23, 93, 23);
                    contentPane.add(searchButton);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 64, 609, 200);
                    contentPane.add(scrollPane);
                    
                    table = new JTable();
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null},
                              },
                              new String[] {
                                        "\uC774\uB984", "\uAD6C\uBD84", "\uC0C1\uC704\uC870\uC9C1"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(126);
                    table.getColumnModel().getColumn(1).setPreferredWidth(126);
                    table.getColumnModel().getColumn(2).setPreferredWidth(111);
                    scrollPane.setViewportView(table);
                    
                    JButton submitButton = new JButton("\uD655 \uC778");
                    submitButton.setBounds(382, 288, 93, 23);
                    contentPane.add(submitButton);
                    
                    JButton cancelButton = new JButton("\uCDE8 \uC18C");
                    cancelButton.setBounds(485, 288, 93, 23);
                    contentPane.add(cancelButton);
                    
                    setTable(new Org());
          }
          //조회 
          protected void searchDept(ActionEvent e) {
                    
          }

          private void setTable(Org org) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgdeptNameList(org);
                    for(Org o:orgList){
                              Vector v=new Vector();
                              v.add(o.getName());
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
