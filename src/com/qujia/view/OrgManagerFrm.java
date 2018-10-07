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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
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
          private JTextField textField_editsName;
          private JComboBox comboBox_editPar,comboBox_co,comboBox_type,comboBox_gdm;

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
                    setTitle("조직관리");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 899, 512);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uC870\uC9C1\uBA85:");
                    
                    textField_name = new JTextField();
                    textField_name.setColumns(10);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC870\uC9C1\uBA85:");
                    
                    textField_editName = new JTextField();
                    textField_editName.setColumns(10);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uC57D\uC5B4\uBA85");
                    
                    textField_editsName = new JTextField();
                    textField_editsName.setColumns(10);
                    
                    JButton updateButton = new JButton("\uC218 \uC815");
                    updateButton.setBackground(new Color(102, 205, 170));
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        submiEditAct(e);
                              }
                    });
                    
                    JButton deleteButton = new JButton("\uC0AD \uC81C");
                    deleteButton.setBackground(new Color(255, 99, 71));
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteOrg(e);
                              }
                    });
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC0C1\uC704\uC870\uC9C1:");
                    
                     comboBox_editPar = new JComboBox();
                    
                    JLabel lblNewLabel_4 = new JLabel("대학/대학원:");
                    
                     comboBox_co = new JComboBox();
                     comboBox_co.setModel(new DefaultComboBoxModel(new String[] {"", "대학", "대학원"}));
                    
                    JButton searchButton = new JButton("\uAC80 \uC0C9");
                    searchButton.setBackground(new Color(224, 255, 255));
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
                    
                    comboBox_type = new JComboBox();
                    comboBox_type.setModel(new DefaultComboBoxModel(new String[] {"", "교육기관", "부속기관", "본부행정기관"}));
                    
                    JLabel lblNewLabel_6 = new JLabel("학부/과/전공:");
                    
                    comboBox_gdm = new JComboBox();
                    comboBox_gdm.setModel(new DefaultComboBoxModel(new String[] {"", "학부", "학과", "전공"}));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(22)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addComponent(lblNewLabel_1))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(comboBox_editPar, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(textField_editName, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                                                                      .addGap(29)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addComponent(lblNewLabel_2)
                                                                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                          .addComponent(textField_editsName, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                                                                          .addGap(18)
                                                                                          .addComponent(updateButton))
                                                                                .addComponent(deleteButton)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(lblNewLabel_5)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(comboBox_type, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(lblNewLabel_4)
                                                                      .addGap(12)
                                                                      .addComponent(comboBox_co, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(lblNewLabel_6)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(comboBox_gdm, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(28)
                                                                      .addComponent(searchButton))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)))
                                                  .addContainerGap())
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(19)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(comboBox_co, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_4)
                                                            .addComponent(lblNewLabel_5)
                                                            .addComponent(comboBox_type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(comboBox_gdm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchButton))
                                                  .addGap(18)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(textField_editName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(textField_editsName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(updateButton))
                                                  .addGap(32)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(comboBox_editPar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(deleteButton))
                                                  .addContainerGap(70, Short.MAX_VALUE))
                    );
                    
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
                                        {null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC870\uC9C1\uCF54\uB4DC", "\uC870\uC9C1\uBA85", "\uC57D\uC5B4\uBA85", "\uC870\uC9C1\uAD6C\uBD84", "\uB300\uD559/\uB300\uD559\uC6D0\uAD6C\uBD84", "\uBD80\uC11C(\uD559\uBD80/\uD559\uACFC/\uC804\uACF5)", "\uBD80\uC18D\uAE30\uAD00\uC885\uB958", "\uC0C1\uC704\uC870\uC9C1\uCF54\uB4DC", "\uB4F1\uB85D\uC77C\uC790"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, true, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(69);
                    table.getColumnModel().getColumn(1).setPreferredWidth(137);
                    table.getColumnModel().getColumn(2).setPreferredWidth(116);
                    table.getColumnModel().getColumn(3).setPreferredWidth(103);
                    table.getColumnModel().getColumn(4).setPreferredWidth(107);
                    table.getColumnModel().getColumn(5).setPreferredWidth(135);
                    table.getColumnModel().getColumn(6).setPreferredWidth(89);
                    table.getColumnModel().getColumn(7).setPreferredWidth(98);
                    table.getColumnModel().getColumn(8).setPreferredWidth(89);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    
                    setOrgName();
                    setTable(new Org());
          }
          //조직 삭제
          protected void deleteOrg(ActionEvent e) {
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까？") != JOptionPane.OK_OPTION){
                              return;
                    }
                    OrgDao orgDao =new OrgDao();
                    String orgCode=table.getValueAt(row, 0).toString();
                    if(table.getValueAt(row, 7)==null){
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
                    
                    
                    orgDao.closeDao();
                    setTable(new Org());
                    resetValues();
                             
          }

          //조직 수정 submit
          protected void submiEditAct(ActionEvent e) {
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    
                    String orgsName,orgCode;
                    String orgName=textField_editName.getText().toString();
                    try {
                              orgsName=textField_editsName.getText().toString();
                    } catch (NullPointerException e2) {
                              orgsName=null;
                    }
                    try {
                              Org org1= (Org) comboBox_editPar.getSelectedItem();
                              orgCode = org1.getOrgCode();
                    } catch (NullPointerException e2) {
                              orgCode=null;
                    }
                    
                    if(StringUtil.isEmpty(orgName)){
                              JOptionPane.showMessageDialog(this, "조직이름을 입력해주세요");
                              return;
                    }
                    
                    Org org=new Org();
                    org.setName(orgName);
                    org.setsName(orgsName);
                    org.setParCode(orgCode);
                    org.setOrgCode(table.getValueAt(row, 0).toString());
                    OrgDao orgDao=new OrgDao();
                    if(orgDao.updateOrg(org)){
                              JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                    }else{
                              JOptionPane.showMessageDialog(this, "수정 실패했습니다");
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
                              v.add(o.getsName());
                              v.add(o.getOrgType());
                              v.add(o.getCoGrCode());
                              v.add(o.getGsDepMajCode());
                              v.add(o.getAftType());
                              v.add(o.getParCode());
                              v.add(o.getTodayDate());
                              dft.addRow(v);
                    }
                    orgDao.closeDao();
                    
           }
        //상위 조직 从数据库中把数据填充选择框
          protected void setOrgName() {
                    // TODO Auto-generated method stub
                    comboBox_editPar.removeAllItems();
                   OrgDao orgDao=new OrgDao();
                    List<Org> orgList = orgDao.getOrgList(new Org());
                    String str=null;
                    comboBox_editPar.addItem(str);
                    for (Org org : orgList) {
                              comboBox_editPar.addItem(org);
                    }
                    orgDao.closeDao();
          }
        //Table중 행을 선택
          protected void selectedTableRow(MouseEvent me) {
                    String parCode=null;
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    //得到选中表格中的哪一行，那一列的值
                    try {
                              textField_editName.setText(dft.getValueAt(table.getSelectedRow(), 1).toString());
                    } catch (NullPointerException e) {
                              textField_editName.setText("");
                    }
                    try {
                              textField_editsName.setText(dft.getValueAt(table.getSelectedRow(), 2).toString());
                    } catch (NullPointerException e) {
                              textField_editsName.setText("");
                    }
                    try {
                              parCode=dft.getValueAt(table.getSelectedRow(),7).toString();
                    } catch (NullPointerException e) {
                              parCode=null;
                    }
                    
                    for(int i=0;i<comboBox_editPar.getItemCount();i++){
                              Org org=(Org) comboBox_editPar.getItemAt(i);
                              try {
                                        if(parCode.equals(org.getOrgCode())){
                                                  comboBox_editPar.setSelectedIndex(i);
                                        }
                              } catch (NullPointerException e) {
                                        comboBox_editPar.setSelectedIndex(0);
                              }
                              
                    }
          }
          private void resetValues(){
                    textField_editName.setText("");
                    textField_editsName.setText("");
                    comboBox_editPar.setSelectedIndex(0);
          }

}
