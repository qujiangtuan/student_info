package com.qujia.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.model.Org;
import com.qujia.model.ProStaff;
import com.qujia.util.ViewUtil;

public class ProManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_proName;
          private JTextField textField_proNo;
          private JTable table;
          private JScrollPane scrollPane;
          private JRadioButton radioButtonName,radioButtonNo;
          private List<Org> orgList;
          private List<ProStaff> psList;
          private JComboBox comboBox_editperType;
          private  JComboBox comboBox_proType;
          private ButtonGroup bgroup1,bgroup2;
          private String proTypeList[],perTypeList1[],perTypeList2[],teaTypeList[];
          private JCheckBox checkBox_searchOrg;
          private JLabel label_per;
          private JTextField textField_editOrgName;
          private JButton btnNewButton;
          private JTextField textField_sup2;
          private JButton button_searchSup;
          private static String orgId;
          private static String orgName;
          private static String superName;
          private JTextField textField_orgName;
          private JButton button;
          private static  int row=-1;
          private static String proId;
          private static String proName;
          
          
          public static String getProId() {
                    return proId;
          }

          public static void setProId(String proId) {
                    ProManagerFrm.proId = proId;
          }

          public static String getProName() {
                    return proName;
          }

          public static void setProName(String proName) {
                    ProManagerFrm.proName = proName;
          }

          public static String getOrgName() {
                    return orgName;
          }

          public static void setOrgName(String orgName) {
                    ProManagerFrm.orgName = orgName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ProManagerFrm frame = new ProManagerFrm();
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
          public ProManagerFrm() {
                    this.setResizable(false);
                    setTitle("\uAD50\uC9C1\uC6D0\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 947, 561);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    proTypeList=new String[] {"", "교원", "직원"};
                    
                    label_per = new JLabel("직위:");
                    label_per.setBounds(18, 413, 63, 15);
                    
                    comboBox_editperType = new JComboBox();
                    comboBox_editperType.setBounds(91, 410, 164, 21);
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
                    comboBox_editperType.setModel(new DefaultComboBoxModel(perTypeList1));
                    
                    JLabel lblNewLabel_5 = new JLabel("소속조직:");
                    lblNewLabel_5.setVisible(false);
                    lblNewLabel_5.setBounds(18, 372, 63, 15);
                    
                    JLabel lblNewLabel_10 = new JLabel("교직원이름:");
                    lblNewLabel_10.setFont(new Font("Dialog", Font.BOLD, 12));
                    lblNewLabel_10.setBounds(45, 19, 76, 19);
                    
                    textField_proName = new JTextField();
                    textField_proName.setBounds(124, 19, 67, 21);
                    textField_proName.setColumns(10);
                    
                    JLabel lblNewLabel_11 = new JLabel("교직원번호:");
                    lblNewLabel_11.setFont(new Font("Dialog", Font.BOLD, 12));
                    lblNewLabel_11.setBounds(236, 18, 76, 20);
                    
                    textField_proNo = new JTextField();
                    textField_proNo.setBounds(320, 19, 67, 21);
                    textField_proNo.setColumns(10);
                    
                    scrollPane = new JScrollPane();
                    scrollPane.setBounds(15, 66, 888, 284);
                    
                    JButton searchButton = new JButton("\uCEF4  \uC0C9");
                    searchButton.setBounds(803, 15, 69, 23);
                    searchButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		searchProStaff(ae);
                    	}
                    });
                    
                    JButton btnNewButton_1 = new JButton("\uC218  \uC815");
                    btnNewButton_1.setBounds(267, 473, 69, 23);
                    btnNewButton_1.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		updateProAction(ae);
                    	}
                    });
                    
                    JButton btnNewButton_2 = new JButton("사  직");
                    btnNewButton_2.setVisible(false);
                    btnNewButton_2.setBounds(803, 368, 69, 23);
                    btnNewButton_2.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		deleteProStaffAction(ae);
                    	}
                    });
                    
                    radioButtonName = new JRadioButton("");
                    radioButtonName.setBounds(18, 19, 21, 19);
                    radioButtonName.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent arg0) {
                    		textField_proNo.setText("");
                    		textField_proNo.setEditable(false);
                    		textField_proName.setEditable(true);
                    	}
                    });
                    radioButtonName.setSelected(true);
                    radioButtonNo = new JRadioButton("");
                    radioButtonNo.setBounds(207, 17, 21, 21);
                    radioButtonNo.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent arg0) {
                    		textField_proName.setText("");
                    		textField_proName.setEditable(false);
                    		textField_proNo.setEditable(true);
                    	}
                    });
                    bgroup1=new ButtonGroup();
                    bgroup1.add(radioButtonNo);
                    bgroup1.add(radioButtonName);
                    
                    JLabel lblNewLabel_12 = new JLabel("직속상사:");
                    lblNewLabel_12.setBounds(288, 413, 63, 15);
                    teaTypeList=new String[] {"", "정교수", "부교수", "조교수", "전임강사"};
                    
                    JLabel lblNewLabel_13 = new JLabel("교직원구분:");
                    lblNewLabel_13.setFont(new Font("Dialog", Font.BOLD, 12));
                    lblNewLabel_13.setBounds(399, 19, 76, 23);
                    
                    comboBox_proType = new JComboBox();
                    comboBox_proType.setBounds(479, 21, 69, 21);
                    comboBox_proType.setModel(new DefaultComboBoxModel(new String[] {"", "교원", "직원"}));
                    
                    JLabel lblNewLabel_14 = new JLabel("소속조직:");
                    lblNewLabel_14.setFont(new Font("Dialog", Font.BOLD, 12));
                    lblNewLabel_14.setBounds(593, 19, 62, 19);
                    bgroup2=new ButtonGroup();
                    
                    checkBox_searchOrg = new JCheckBox("");
                    checkBox_searchOrg.setBounds(566, 17, 21, 21);
                    checkBox_searchOrg.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent arg0) {
                                if(checkBox_searchOrg.isSelected()){
                                          textField_orgName.setEnabled(true);
                                }else{
                                          textField_orgName.setEnabled(false);
                                          textField_orgName.setText("");
                                }
                      }
                    });
                    
                    textField_editOrgName = new JTextField();
                    textField_editOrgName.setVisible(false);
                    textField_editOrgName.setEditable(false);
                    textField_editOrgName.setBounds(91, 369, 164, 21);
                    textField_editOrgName.setColumns(10);
                    
                    btnNewButton = new JButton("조회");
                    btnNewButton.setVisible(false);
                    btnNewButton.setBounds(267, 368, 73, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchOrgForProFrm sdf=new SearchOrgForProFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_editOrgName.setText(addSearch());
                              }
                    });
                    
                    textField_sup2 = new JTextField();
                    textField_sup2.setEditable(false);
                    textField_sup2.setBounds(362, 410, 164, 21);
                    textField_sup2.setColumns(10);
                    
                    button_searchSup = new JButton("조회");
                    button_searchSup.setBounds(544, 409, 73, 23);
                    button_searchSup.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchSuperiorFrm ssf=new SearchSuperiorFrm(new JFrame());
                                        ssf.setVisible(true);
                                        textField_sup2.setText(addSearchSuperior());
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
                                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAD50\uC9C1\uC6D0\uBC88\uD638", "\uAD50\uC9C1\uC6D0\uBA85", "\uC601\uC5B4\uBA85", "\uAD50\uC9C1\uC6D0\uAD6C\uBD84", "\uC9C1\uC704", "\uC131\uBCC4", "\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC18C\uC18D\uD559\uACFC", "\uC8FC\uC18C", "\uC5F0\uB77D\uCC98", "\uC774\uBA54\uC77C", "\uB4F1\uB85D\uC77C\uC790", "\uBE44\uBC00\uBC88\uD638", "\uC9C1\uC18D\uC0C1\uC0AC"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(80);
                    table.getColumnModel().getColumn(2).setPreferredWidth(88);
                    table.getColumnModel().getColumn(3).setPreferredWidth(84);
                    table.getColumnModel().getColumn(4).setPreferredWidth(88);
                    table.getColumnModel().getColumn(5).setPreferredWidth(43);
                    table.getColumnModel().getColumn(6).setPreferredWidth(114);
                    table.getColumnModel().getColumn(7).setPreferredWidth(126);
                    table.getColumnModel().getColumn(8).setPreferredWidth(137);
                    table.getColumnModel().getColumn(9).setPreferredWidth(105);
                    table.getColumnModel().getColumn(10).setPreferredWidth(146);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setViewportView(table);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(textField_editOrgName);
                    contentPane.add(btnNewButton);
                    contentPane.add(label_per);
                    contentPane.add(comboBox_editperType);
                    contentPane.add(lblNewLabel_12);
                    contentPane.add(textField_sup2);
                    contentPane.add(button_searchSup);
                    contentPane.add(btnNewButton_1);
                    contentPane.add(btnNewButton_2);
                    contentPane.add(radioButtonName);
                    contentPane.add(lblNewLabel_10);
                    contentPane.add(textField_proName);
                    contentPane.add(radioButtonNo);
                    contentPane.add(lblNewLabel_11);
                    contentPane.add(textField_proNo);
                    contentPane.add(lblNewLabel_13);
                    contentPane.add(comboBox_proType);
                    contentPane.add(checkBox_searchOrg);
                    contentPane.add(lblNewLabel_14);
                    contentPane.add(searchButton);
                    contentPane.add(scrollPane);
                    
                    textField_orgName = new JTextField();
                    textField_orgName.setEnabled(false);
                    textField_orgName.setBounds(663, 19, 116, 19);
                    contentPane.add(textField_orgName);
                    textField_orgName.setColumns(10);
                    
                    button = new JButton("닫기");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    button.setBounds(593, 473, 69, 23);
                    contentPane.add(button);
                    
                    JButton button_1 = new JButton("이력관리");
                    button_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        if(row==-1){
                                                  JOptionPane.showMessageDialog(null, "수정할 행을 선택해주세요!");
                                                  return;
                                        }
                                        UpHistoryProManagerFrm uh=new UpHistoryProManagerFrm();
                                        uh.setVisible(true);
                              }
                    });
                    button_1.setBounds(417, 473, 95, 23);
                    contentPane.add(button_1);
                    //这两条是显示横滚动条
//                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
//                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    
                    setTable(new ProStaff());
          }
          protected String addSearchSuperior() {
                    return SearchSuperiorFrm.getpName();
          }

          protected String addSearch() {
                    return SearchOrgForProFrm.getDeptName();
          }

          // delete ProStaff 교직원 삭제 
          protected void deleteProStaffAction(ActionEvent ae) {
        	  int row=table.getSelectedRow();
              if(row==-1){
                        JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                        return;
              }
              ProStaffDao psDao=new ProStaffDao();
              String pNo=table.getValueAt(row, 0).toString();
              int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
              if(showConfirmDialog==JOptionPane.YES_OPTION){
                        if(psDao.deleteProStaff(pNo)){
                                  JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                        }else{
                                  JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                        }
              }
              
              psDao.closeDao();
              setTable(new ProStaff());
              restvalues();
//              setSuperiorStaff();
		}

		//update Pro 교직원 수정 submit 
          protected void updateProAction(ActionEvent ae) {
        	  
              if(row==-1){
                        JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                        return;
              }
              DefaultTableModel   dft = (DefaultTableModel) table.getModel();
              
              String proType=dft.getValueAt(row, 3).toString();
              String perType=comboBox_editperType.getSelectedItem().toString();
//              String teaType=comboBox_eidtteaType.getSelectedItem().toString();
              
              orgName=textField_editOrgName.getText().toString();
              orgId=this.getOrgidByOrgName(orgName);
//              orgId = SearchOrgFrm.getOrdId();
              ProStaff ps=new ProStaff();
              ps.setpNo(proId);
              ps.setpName(proName);
              ps.setProType(proType);
              ps.setPerType(perType);
//              ps.setTeaType(teaType);
              ps.setOrgId(orgId);
              ps.setOrgName(orgName);
              ProStaff ps1,ps2;
              String superior1,superior2;
              if("교원".equals(proType)) {
              }else {
            	  try {
//                      superior2=SearchSuperiorFrm.getpNo();
            	            superName=textField_sup2.getText();
            	            superior2=this.getProNoByProName(superName);
				} catch (Exception e) {
					superior2=null;
				}
            	  ps.setSupId(superior2);
              }
           ps.setSupName(superName);
             ProStaffDao psDao=new ProStaffDao();
             int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                 JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
             if(showConfirmDialog==JOptionPane.YES_OPTION){
                       if(psDao.updateProStaff(ps)&&psDao.insertHistory(ps)) {
                                 JOptionPane.showMessageDialog(this, "수정 성공했습니다.");
                             }else {
                                 JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                             }
             }
             
             
             psDao.closeDao();
             setTable(new ProStaff());
//             setSuperiorStaff();
              
		}

		//select a row of table
          protected void selectedTableRow(MouseEvent me) {
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                 row=table.getSelectedRow();
                 
                 proId =dft.getValueAt(row, 0).toString();
                 proName=dft.getValueAt(row, 1).toString();
        	  
           //edit 교원/직원
          	String proType;
          	proType=dft.getValueAt(table.getSelectedRow(), 3).toString();
          	//교원구분:전임교수/겸임교수......부장/차장....  수정
          	String perType=dft.getValueAt(table.getSelectedRow(), 4).toString();//교원
          	String supName;
          	try {
          		supName=dft.getValueAt(table.getSelectedRow(), 13).toString();//직속상사 id
			} catch (Exception e) {
			    supName=null;
			}
          	
          	if("교원".equals(proType)) {
          		comboBox_editperType.setModel(new DefaultComboBoxModel(perTypeList1));
          		for(int i=0;i<comboBox_editperType.getItemCount();i++){
                    if(perType.equals(perTypeList1[i])){
                    	comboBox_editperType.setSelectedIndex(i);
                    }
                }
          		textField_sup2.setEnabled(false);
          		textField_sup2.setText("");
          		button_searchSup.setEnabled(false);
          		label_per.setText("교원구분:");
          		//교원 직속상사
//          		for(int i=0;i<comboBox_sup1.getItemCount();i++){
//          			try {
//          				ProStaff psPro=(ProStaff) comboBox_sup1.getItemAt(i);
//          				if(supId.equals(psPro.getpNo())){
//                        	comboBox_sup1.setSelectedIndex(i);
//                        }
//					} catch (Exception e) {
//						comboBox_sup1.setSelectedIndex(0);
//					}
//                }
//          		comboBox_sup2.setEnabled(false);//직소상사 
//          		comboBox_sup2.setSelectedIndex(0);
//          		comboBox_sup1.setEnabled(true);//직소상사 
          	}else {
          		comboBox_editperType.setModel(new DefaultComboBoxModel(perTypeList2));
          		for(int i=0;i<comboBox_editperType.getItemCount();i++){
                    if(perType.equals(perTypeList2[i])){
                    	comboBox_editperType.setSelectedIndex(i);
                    }
                }
          	//직원 직속상사
//          		for(int i=0;i<comboBox_sup2.getItemCount();i++){
//          			try {
//          				ProStaff psPro=(ProStaff) comboBox_sup2.getItemAt(i);
//					} catch (Exception e) {
//						
//					}
//                }
//          		comboBox_sup1.setEnabled(false);//직소상사 
//          		comboBox_sup1.setSelectedIndex(0);
          		textField_sup2.setText(supName);
          		textField_sup2.setEnabled(true);//직소상사 
          		button_searchSup.setEnabled(true);
          		label_per.setText("직원구분:");
          	}
          	
          	
          	//전임교수 부분:정교수/부교수.... 수정
//          	String teaType;
//          	try {
//          		teaType=dft.getValueAt(table.getSelectedRow(), 5).toString();
//          		for(int i=0;i<comboBox_eidtteaType.getItemCount();i++){
//                    if(teaType.equals(teaTypeList[i])&&!StringUtil.isEmpty(teaType)){
//                    	comboBox_eidtteaType.setSelectedIndex(i);
//                    }
//                }
//			} catch (Exception e) {
//				teaType=null;
//				comboBox_eidtteaType.setSelectedIndex(0);
//			}
          	//성별 수정
          	String sex=dft.getValueAt(table.getSelectedRow(), 6).toString();
          	bgroup2.clearSelection();
            //소속조직
            orgName=dft.getValueAt(table.getSelectedRow(), 7).toString();
            textField_editOrgName.setText(orgName);
		}
		//교직원 검색
          protected void searchProStaff(ActionEvent ae) {
//                    setDeptName();
                    ProStaff ps=new ProStaff();
                    if(radioButtonName.isSelected()){
                              ps.setpName(textField_proName.getText().toString());
                    }else{
                    	      ps.setpNo(textField_proNo.getText().toString());
                    }
                    String orgName;
                    if(checkBox_searchOrg.isSelected()){
                              orgName = textField_orgName.getText().toString();
                    }else{
                              orgName=null;
                    }
                    ps.setOrgName(orgName);
                    ps.setProType(comboBox_proType.getSelectedItem().toString());
                    
//                    int row=table.getSelectedRow();
                    if(row==-1){
                              restvalues();
                    }
                    setTable(ps);
                    row=-1;
          }
        private void restvalues() {
        	comboBox_editperType.setSelectedIndex(0);
//        	comboBox_eidtteaType.setSelectedIndex(0);
        	bgroup2.clearSelection();
        	textField_editOrgName.setText("");
        	textField_sup2.setText("");
		}

       // table다시 설정
          public void setTable(ProStaff ps){
                   DefaultTableModel dft = (DefaultTableModel) table.getModel();
                   dft.setRowCount(0);
                   ProStaffDao psDao=new ProStaffDao();
                   List<ProStaff> proStaffList = psDao.getProStaffList(ps);
                   for(ProStaff pslist : proStaffList){
                             Vector v=new Vector();
                             v.add(pslist.getpNo());
                             v.add(pslist.getpName());
                             v.add(pslist.getPeName());
                             v.add(pslist.getProType());
                             v.add(pslist.getPerType());
//                             v.add(pslist.getTeaType());
                             v.add(pslist.getSex());
                             v.add(pslist.getIdCardNo());
                             v.add(this.getOrgNameById(pslist.getOrgId()));
                             v.add(pslist.getAddress());
                             v.add(pslist.getTel());
                             v.add(pslist.getEmail());
                             v.add(pslist.getLoginDate());
                             v.add(pslist.getPassword());
                             v.add(this.getProSupNameById(pslist.getSupId()));
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
