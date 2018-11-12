package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.model.Org;
import com.qujia.model.ProStaff;
import com.qujia.util.ViewUtil;

public class UpHistoryProManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JScrollPane scrollPane;
          private List<Org> orgList;
          private List<ProStaff> psList;
          private ButtonGroup bgroup1,bgroup2;
          private String proTypeList[],perTypeList1[],perTypeList2[],teaTypeList[];
          private static String orgId;
          private static String orgName;
          private static String superName;
          private JButton button;
          private JLabel label_proName;
          
          public static String getOrgName() {
                    return orgName;
          }

          public static void setOrgName(String orgName) {
                    UpHistoryProManagerFrm.orgName = orgName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  UpHistoryProManagerFrm frame = new UpHistoryProManagerFrm();
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
          public UpHistoryProManagerFrm() {
                    this.setResizable(false);
                    setTitle("교직원 이력관리");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 716, 446);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    proTypeList=new String[] {"", "교원", "직원"};
//                    comboBox_editperType.addItemListener(new ItemListener() {
//                    	public void itemStateChanged(ItemEvent ie) {
//                    		if(ie.getStateChange()==ItemEvent.SELECTED) {
//                    			String selectText=comboBox_editperType.getSelectedItem().toString();
//                    			if("전임교수".equals(selectText)) {
//                    				comboBox_eidtteaType.setEnabled(true);
//                    			}else {
//                    				comboBox_eidtteaType.setEnabled(false);
//                    				comboBox_eidtteaType.setSelectedIndex(0);
//                    			}
//                    		}
//                    	}
//                    });
                    perTypeList1=new String[] {"", "정교수", "부교수", "조교수", "전임강사", "겸임교수", "시간강사"};
                    perTypeList2=new String[] {"", "부장", "차장", "대리", "사원"};
                    
                    scrollPane = new JScrollPane();
                    scrollPane.setBounds(15, 66, 682, 284);
                    bgroup1=new ButtonGroup();
                    teaTypeList=new String[] {"", "정교수", "부교수", "조교수", "전임강사"};
                    bgroup2=new ButtonGroup();
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAD50\uC9C1\uC6D0\uBC88\uD638", "\uAD50\uC9C1\uC6D0\uBA85", "\uAD50\uC9C1\uC6D0\uAD6C\uBD84", "\uC9C1\uC704", "\uC18C\uC18D\uD559\uACFC", "\uC9C1\uC18D\uC0C1\uC0AC", "\uBCC0\uACBD\uC77C\uC790"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(112);
                    table.getColumnModel().getColumn(2).setPreferredWidth(84);
                    table.getColumnModel().getColumn(3).setPreferredWidth(88);
                    table.getColumnModel().getColumn(4).setPreferredWidth(154);
                    table.getColumnModel().getColumn(6).setPreferredWidth(139);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    scrollPane.setViewportView(table);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(scrollPane);
                    
                    button = new JButton("닫기");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    button.setBounds(628, 360, 69, 23);
                    contentPane.add(button);
                    
                    JLabel lblNewLabel = new JLabel("교직원명:");
                    lblNewLabel.setBounds(15, 28, 57, 15);
                    contentPane.add(lblNewLabel);
                    
                    label_proName = new JLabel("강단");
                    label_proName.setText(ProManagerFrm.getProName());
                    label_proName.setBounds(84, 28, 221, 15);
                    contentPane.add(label_proName);
                    //这两条是显示横滚动条
//                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
//                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    
                    ProStaff ps=new ProStaff();
                    ps.setpNo(ProManagerFrm.getProId());
                    setTable(ps);
          }

       // table다시 설정
          public void setTable(ProStaff ps){
                   DefaultTableModel dft = (DefaultTableModel) table.getModel();
                   dft.setRowCount(0);
                   ProStaffDao psDao=new ProStaffDao();
                   List<ProStaff> proStaffList = psDao.getProHistory(ps);
                   for(ProStaff pslist : proStaffList){
                             Vector v=new Vector();
                             v.add(pslist.getpNo());
                             v.add(pslist.getpName());
                             v.add(pslist.getProType());
                             v.add(pslist.getPerType());
                             v.add(pslist.getOrgName());
                             v.add(pslist.getSupName());
                             v.add(pslist.getLoginDate());
                             dft.addRow(v);
                   }
                   psDao.closeDao();
                   
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
        //proSup에 통해서 proSupName를 받는다
          public String getProSupNameById(String id){
                    ProStaffDao psDao=new ProStaffDao();
                    psList = psDao.getProStaffList(new ProStaff());
                    for(ProStaff ps:psList){
                            if(ps.getpNo().equals(id)) return ps.getpName();
                    }
                    return "";
          }
        //proSup에 통해서 proSupName를 받는다
          public String getProNoByProName(String name){
                    ProStaffDao psDao=new ProStaffDao();
                    psList = psDao.getProStaffList(new ProStaff());
                    for(ProStaff ps:psList){
                            if(ps.getpName().equals(name)) return ps.getpNo();
                    }
                    return "";
          }
}
