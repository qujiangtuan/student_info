package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.ProStaff;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class ProManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_editName;
          private JTextField textField_editAddress;
          private JTextField textField_tel;
          private JTextField textField_email;
          private JTextField textField_editEname;
          private JTextField textField_proName;
          private JTextField textField_proNo;
          private JTable table;
          private JScrollPane scrollPane;
          private JRadioButton radioButtonName,radioButtonNo;
          private List<Org> orgList;
          private JComboBox comboBox_sOrgName,comboBox_editOrgName;
          private JComboBox comboBox_editProType,comboBox_editperType;
          private  JComboBox comboBox_eidtteaType,comboBox_proType;
          private JRadioButton radioButton_male,radioButton_female;
          private ButtonGroup bgroup1,bgroup2;
          private  JComboBox comboBox_sup1,comboBox_sup2;
          private String proTypeList[],perTypeList1[],perTypeList2[],teaTypeList[];
          private JCheckBox checkBox_searchOrg;
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
                    setTitle("\uAD50\uC9C1\uC6D0\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 947, 694);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uAD50\uC6D0\uC774\uB984:");
                    
                    textField_editName = new JTextField();
                    textField_editName.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC601\uC5B4\uC774\uB984:");
                    
                    JLabel lblNewLabel = new JLabel("교직원구분:");
                    
                    comboBox_editProType = new JComboBox();
                    
                    proTypeList=new String[] {"", "교원", "직원"};
                    comboBox_editProType.setModel(new DefaultComboBoxModel(proTypeList));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC6D0\uAD6C\uBD84:");
                    
                    comboBox_editperType = new JComboBox();
                    comboBox_editperType.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent ie) {
                    		if(ie.getStateChange()==ItemEvent.SELECTED) {
                    			String selectText=comboBox_editperType.getSelectedItem().toString();
                    			if("전임교수".equals(selectText)) {
                    				comboBox_eidtteaType.setEnabled(true);
                    			}else {
                    				comboBox_eidtteaType.setEnabled(false);
                    				comboBox_eidtteaType.setSelectedIndex(0);
                    			}
                    		}
                    	}
                    });
                    perTypeList1=new String[] {"", "전임교수", "겸임교수", "시간강사"};
                    perTypeList2=new String[] {"", "부장", "차장", "대리", "사원"};
                    comboBox_editperType.setModel(new DefaultComboBoxModel(perTypeList1));
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC124\uBCC4:");
                    
                    JLabel lblNewLabel_5 = new JLabel("소속조직:");
                    
                    JLabel lblNewLabel_6 = new JLabel("\uC8FC\uC18C:");
                    
                    textField_editAddress = new JTextField();
                    textField_editAddress.setColumns(10);
                    
                    JLabel lblNewLabel_7 = new JLabel("\uC804\uD654\uBC88\uD638:");
                    
                    textField_tel = new JTextField();
                    textField_tel.setColumns(10);
                    
                    JLabel lblNewLabel_8 = new JLabel("\uC774\uBA54\uC77C:");
                    
                    textField_email = new JTextField();
                    textField_email.setColumns(10);
                    
                    textField_editEname = new JTextField();
                    textField_editEname.setColumns(10);
                    
                    comboBox_editOrgName = new JComboBox();
                    
                    JLabel lblNewLabel_10 = new JLabel("\uAD50\uC218\uC774\uB984:");
                    
                    textField_proName = new JTextField();
                    textField_proName.setColumns(10);
                    
                    JLabel lblNewLabel_11 = new JLabel("\uAD50\uC218\uBC88\uD638:");
                    
                    textField_proNo = new JTextField();
                    textField_proNo.setColumns(10);
                    
                    scrollPane = new JScrollPane();
                    
                    JButton searchButton = new JButton("\uCEF4  \uC0C9");
                    searchButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		searchProStaff(ae);
                    	}
                    });
                    
                    JButton btnNewButton_1 = new JButton("\uC218  \uC815");
                    btnNewButton_1.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		updateProAction(ae);
                    	}
                    });
                    btnNewButton_1.setBackground(new Color(224, 255, 255));
                    
                    JButton btnNewButton_2 = new JButton("\uC0AD  \uC81C");
                    btnNewButton_2.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent ae) {
                    		deleteProStaffAction(ae);
                    	}
                    });
                    btnNewButton_2.setBackground(new Color(255, 182, 193));
                    
                    radioButtonName = new JRadioButton("");
                    radioButtonName.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent arg0) {
                    		textField_proNo.setText("");
                    		textField_proNo.setEditable(false);
                    		textField_proName.setEditable(true);
                    	}
                    });
                    radioButtonName.setSelected(true);
                    radioButtonNo = new JRadioButton("");
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
                    
                    comboBox_sup1 = new JComboBox();
                    comboBox_sup1.setModel(new DefaultComboBoxModel(new String[] {""}));
                    
                    comboBox_sup2 = new JComboBox();
                    comboBox_sup2.setModel(new DefaultComboBoxModel(new String[] {""}));
                   
                    comboBox_eidtteaType = new JComboBox();
                    teaTypeList=new String[] {"", "정교수", "부교수", "조교수", "전임강사"};
                    comboBox_eidtteaType.setModel(new DefaultComboBoxModel(teaTypeList));
                    
                    JLabel lblNewLabel_13 = new JLabel("교직원구분:");
                    
                    comboBox_proType = new JComboBox();
                    comboBox_proType.setModel(new DefaultComboBoxModel(new String[] {"", "교원", "직원"}));
                    
                    JLabel lblNewLabel_14 = new JLabel("소속조직:");
                    
                    comboBox_sOrgName = new JComboBox();
                    comboBox_sOrgName.setEnabled(false);
                    bgroup2=new ButtonGroup();
                   radioButton_male = new JRadioButton("남");
                    radioButton_female = new JRadioButton("여");
                    bgroup2.add(radioButton_female);
                    bgroup2.add(radioButton_male);
                    
                    checkBox_searchOrg = new JCheckBox("");
                    checkBox_searchOrg.addItemListener(new ItemListener() {
                    	public void itemStateChanged(ItemEvent arg0) {
                                if(checkBox_searchOrg.isSelected()){
                                	comboBox_sOrgName.setEnabled(true);
                                }else{
                                	comboBox_sOrgName.setEnabled(false);
                                }
                      }
                    });
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addContainerGap()
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(lblNewLabel)
                    								.addComponent(label)
                    								.addComponent(lblNewLabel_5)
                    								.addComponent(lblNewLabel_3)
                    								.addComponent(lblNewLabel_7))
                    							.addGap(18)
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    								.addComponent(textField_tel, 242, 242, 242)
                    								.addComponent(comboBox_editOrgName, 0, 242, Short.MAX_VALUE)
                    								.addGroup(gl_contentPane.createSequentialGroup()
                    									.addComponent(radioButton_male, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    									.addGap(18)
                    									.addComponent(radioButton_female, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
                    								.addComponent(textField_editName, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    								.addComponent(comboBox_editProType, 0, 242, Short.MAX_VALUE)))
                    						.addComponent(btnNewButton_1))
                    					.addGap(18)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    							.addComponent(lblNewLabel_2)
                    							.addComponent(lblNewLabel_1)
                    							.addComponent(lblNewLabel_12)
                    							.addComponent(lblNewLabel_6, Alignment.TRAILING))
                    						.addComponent(lblNewLabel_8))
                    					.addGap(27)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(textField_email, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    								.addGroup(gl_contentPane.createSequentialGroup()
                    									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    										.addComponent(comboBox_sup1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    										.addComponent(comboBox_editperType, 0, 115, Short.MAX_VALUE))
                    									.addPreferredGap(ComponentPlacement.RELATED)
                    									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    										.addComponent(comboBox_sup2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    										.addComponent(comboBox_eidtteaType, 0, 195, Short.MAX_VALUE))
                    									.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    								.addGroup(gl_contentPane.createSequentialGroup()
                    									.addPreferredGap(ComponentPlacement.UNRELATED)
                    									.addComponent(textField_editAddress, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                    								.addGroup(gl_contentPane.createSequentialGroup()
                    									.addComponent(textField_editEname, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    									.addPreferredGap(ComponentPlacement.RELATED)))
                    							.addGap(140))
                    						.addGroup(gl_contentPane.createSequentialGroup()
                    							.addComponent(btnNewButton_2)
                    							.addContainerGap())))
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addGap(9)
                    					.addComponent(radioButtonName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(lblNewLabel_10)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(textField_proName, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(radioButtonNo, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(lblNewLabel_11)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(textField_proNo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.UNRELATED)
                    					.addComponent(lblNewLabel_13)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(comboBox_proType, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(checkBox_searchOrg, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(lblNewLabel_14)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(comboBox_sOrgName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    					.addGap(12)
                    					.addComponent(searchButton)
                    					.addContainerGap())
                    				.addGroup(gl_contentPane.createSequentialGroup()
                    					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 888, GroupLayout.PREFERRED_SIZE)
                    					.addContainerGap())))
                    );
                    gl_contentPane.setVerticalGroup(
                    	gl_contentPane.createParallelGroup(Alignment.LEADING)
                    		.addGroup(gl_contentPane.createSequentialGroup()
                    			.addContainerGap()
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                    					.addComponent(radioButtonName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(lblNewLabel_10)
                    						.addComponent(textField_proName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(comboBox_proType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(lblNewLabel_13)
                    						.addComponent(searchButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    						.addComponent(lblNewLabel_14)
                    						.addComponent(comboBox_sOrgName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    					.addComponent(radioButtonNo)
                    					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(textField_proNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(lblNewLabel_11)))
                    				.addComponent(checkBox_searchOrg, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                    			.addGap(28)
                    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                    			.addGap(30)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(textField_editName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(label)
                    				.addComponent(textField_editEname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel_1))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(comboBox_editProType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(comboBox_editperType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel)
                    				.addComponent(comboBox_eidtteaType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel_2))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(lblNewLabel_3)
                    					.addComponent(radioButton_male)
                    					.addComponent(radioButton_female))
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(comboBox_sup1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(comboBox_sup2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(lblNewLabel_12)))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(lblNewLabel_5)
                    					.addComponent(comboBox_editOrgName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(lblNewLabel_6))
                    				.addComponent(textField_editAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    			.addGap(18)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(textField_tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(textField_email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    				.addComponent(lblNewLabel_7)
                    				.addComponent(lblNewLabel_8))
                    			.addGap(33)
                    			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                    				.addComponent(btnNewButton_2)
                    				.addComponent(btnNewButton_1))
                    			.addGap(33))
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
                    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                    		{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                    	},
                    	new String[] {
                    		"\uAD50\uC6D0\uBC88\uD638", "\uC774\uB984", "\uC601\uC5B4\uC774\uB984", "\uAD50\uC9C1\uC6D0\uAD6C\uBD84", "\uAD50\uC6D0\uAD6C\uBD84", "\uC804\uC784\uAD50\uC218\uAD6C\uBD84", "\uC131\uBCC4", "\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC18D\uC18D\uD559\uACFC", "\uC8FC\uC18C", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C", "\uB4F1\uB85D\uC77C\uC9DC", "\uBE44\uBC00\uBC88\uD638", "\uC9C1\uC18D\uC0AC\uC0C1"
                    	}
                    ) {
                    	boolean[] columnEditables = new boolean[] {
                    		false, false, false, false, false, true, false, false, false, false, false, false, false, false, true
                    	};
                    	public boolean isCellEditable(int row, int column) {
                    		return columnEditables[column];
                    	}
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(80);
                    table.getColumnModel().getColumn(2).setPreferredWidth(88);
                    table.getColumnModel().getColumn(3).setPreferredWidth(84);
                    table.getColumnModel().getColumn(4).setPreferredWidth(88);
                    table.getColumnModel().getColumn(5).setPreferredWidth(83);
                    table.getColumnModel().getColumn(6).setPreferredWidth(43);
                    table.getColumnModel().getColumn(7).setPreferredWidth(114);
                    table.getColumnModel().getColumn(8).setPreferredWidth(126);
                    table.getColumnModel().getColumn(9).setPreferredWidth(137);
                    table.getColumnModel().getColumn(10).setPreferredWidth(105);
                    table.getColumnModel().getColumn(11).setPreferredWidth(146);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setViewportView(table);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(gl_contentPane);
                    //这两条是显示横滚动条
//                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
//                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    
                    setTable(new ProStaff());
                    setOrgName();//조직 갖다온다
                    setSuperiorStaff();//직속상사 갖다온다
          }
          // delete ProStaff 교직원 삭제 
          protected void deleteProStaffAction(ActionEvent ae) {
        	  int row=table.getSelectedRow();
              if(row==-1){
                        JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                        return;
              }
              if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까？") != JOptionPane.OK_OPTION){
                        return;
              }
              ProStaffDao psDao=new ProStaffDao();
              String pNo=table.getValueAt(row, 0).toString();
              if(psDao.deleteProStaff(pNo)){
                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
              }else{
                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
              }
              psDao.closeDao();
              setTable(new ProStaff());
              restvalues();
		}

		//update Pro 교직원 수정 submit 
          protected void updateProAction(ActionEvent ae) {
        	  int row=table.getSelectedRow();
              if(row==-1){
                        JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                        return;
              }
              DefaultTableModel   dft = (DefaultTableModel) table.getModel();
              String proId =dft.getValueAt(row, 0).toString();
              String proName=textField_editName.getText().toString();
              String proEname=textField_editEname.getText().toString();
              String proType=comboBox_editProType.getSelectedItem().toString();
              String perType=comboBox_editperType.getSelectedItem().toString();
              String teaType=comboBox_eidtteaType.getSelectedItem().toString();
              String sex=radioButton_male.isSelected()? radioButton_male.getText():radioButton_female.getText();
              
              Org org =(Org) comboBox_editOrgName.getSelectedItem();
              String orgId = org.getOrgCode();
              String address = textField_editAddress.getText().toString();
              String tel = textField_tel.getText().toString();
              String email = textField_email.getText().toString();
              if(StringUtil.isEmpty(proName)){
                  JOptionPane.showMessageDialog(this, "교직원이름을 입력해주세요");
                  return;
              }
              if(StringUtil.isEmpty(tel)){
                  JOptionPane.showMessageDialog(this, "전화번호을 입력해주세요");
                  return;
              }
              if(StringUtil.isEmpty(email)){
                  JOptionPane.showMessageDialog(this, "이메일을 입력해주세요");
                  return;
              }
              ProStaff ps=new ProStaff();
              ps.setpNo(proId);
              ps.setpName(proName);
              ps.setPeName(proEname);
              ps.setProType(proType);
              ps.setPerType(perType);
              ps.setTeaType(teaType);
              ps.setSex(sex);
              ps.setOrgId(orgId);
              ps.setAddress(address);
              ps.setTel(tel);
              ps.setEmail(email);
              ProStaff ps1,ps2;
              String superior1,superior2;
              if("교원".equals(proType)) {
            	  try {
            		  ps1 = (ProStaff) comboBox_sup1.getSelectedItem();
                      superior1=ps1.getpNo();
				} catch (Exception e) {
					superior1=null;
				}
            	  ps.setSupId(superior1);
              }else {
            	  try {
            		  ps2 = (ProStaff) comboBox_sup2.getSelectedItem();
                      superior2=ps2.getpNo();
				} catch (Exception e) {
					superior2=null;
				}
            	  ps.setSupId(superior2);
              }
             ProStaffDao psDao=new ProStaffDao();
             if(psDao.updateProStaff(ps)) {
            	 JOptionPane.showMessageDialog(this, "수정 성공했습니다.");
             }else {
            	 JOptionPane.showMessageDialog(this, "수정 실패했습니다");
             }
             
             psDao.closeDao();
             setTable(new ProStaff());
              
              
		}

		//select a row of table
          protected void selectedTableRow(MouseEvent me) {
        	  DefaultTableModel   dft = (DefaultTableModel) table.getModel();
        	  textField_editName.setText(dft.getValueAt(table.getSelectedRow(), 1).toString());
          	textField_editEname.setText(dft.getValueAt(table.getSelectedRow(), 2).toString());
           //edit 교원/직원
          	String proType;
          	proType=dft.getValueAt(table.getSelectedRow(), 3).toString();
          	for(int i=0;i<comboBox_editProType.getItemCount();i++){
              if(proType.equals(proTypeList[i])){
            	  comboBox_editProType.setSelectedIndex(i);
              }
          	}
          	//교원구분:전임교수/겸임교수......부장/차장....  수정
          	String perType=dft.getValueAt(table.getSelectedRow(), 4).toString();//교원
          	String supId;
          	try {
          		supId=dft.getValueAt(table.getSelectedRow(), 14).toString();//직속상사 id
			} catch (Exception e) {
				supId=null;
			}
          	
          	if("교원".equals(proType)) {
          		comboBox_editperType.setModel(new DefaultComboBoxModel(perTypeList1));
          		for(int i=0;i<comboBox_editperType.getItemCount();i++){
                    if(perType.equals(perTypeList1[i])){
                    	comboBox_editperType.setSelectedIndex(i);
                    }
                }
          		//교원 직속상사
          		for(int i=0;i<comboBox_sup1.getItemCount();i++){
          			try {
          				ProStaff psPro=(ProStaff) comboBox_sup1.getItemAt(i);
          				if(supId.equals(psPro.getpNo())){
                        	comboBox_sup1.setSelectedIndex(i);
                        }
					} catch (Exception e) {
						comboBox_sup1.setSelectedIndex(0);
					}
                }
          		comboBox_sup2.setEnabled(false);//직소상사 
          		comboBox_sup2.setSelectedIndex(0);
          		comboBox_sup1.setEnabled(true);//직소상사 
          	}else {
          		comboBox_editperType.setModel(new DefaultComboBoxModel(perTypeList2));
          		for(int i=0;i<comboBox_editperType.getItemCount();i++){
                    if(perType.equals(perTypeList2[i])){
                    	comboBox_editperType.setSelectedIndex(i);
                    }
                }
          	//직원 직속상사
          		for(int i=0;i<comboBox_sup2.getItemCount();i++){
          			try {
          				ProStaff psPro=(ProStaff) comboBox_sup2.getItemAt(i);
                        if(supId.equals(psPro.getpNo())){
                        	comboBox_sup2.setSelectedIndex(i);
                        }
					} catch (Exception e) {
						comboBox_sup2.setSelectedIndex(0);
					}
                }
          		comboBox_sup1.setEnabled(false);//직소상사 
          		comboBox_sup1.setSelectedIndex(0);
          		comboBox_sup2.setEnabled(true);//직소상사 
          	}
          	
          	
          	//전임교수 부분:정교수/부교수.... 수정
          	String teaType;
          	try {
          		teaType=dft.getValueAt(table.getSelectedRow(), 5).toString();
          		for(int i=0;i<comboBox_eidtteaType.getItemCount();i++){
                    if(teaType.equals(teaTypeList[i])&&!StringUtil.isEmpty(teaType)){
                    	comboBox_eidtteaType.setSelectedIndex(i);
                    }
                }
			} catch (Exception e) {
				teaType=null;
				comboBox_eidtteaType.setSelectedIndex(0);
			}
          	//성별 수정
          	String sex=dft.getValueAt(table.getSelectedRow(), 6).toString();
          	bgroup2.clearSelection();
            if(sex.equals(radioButton_male.getText())) radioButton_male.setSelected(true);
            if(sex.equals(radioButton_female.getText())) radioButton_female.setSelected(true);
            //소속조직
            String orgName=dft.getValueAt(table.getSelectedRow(), 8).toString();
            for(int i=0;i<comboBox_editOrgName.getItemCount();i++){
                      Org org = (Org) comboBox_editOrgName.getItemAt(i);
                      if(orgName.equals(org.getName())){
                    	  comboBox_editOrgName.setSelectedIndex(i);
                      }
            }
          	textField_editAddress.setText(dft.getValueAt(table.getSelectedRow(), 9).toString());
          	textField_tel.setText(dft.getValueAt(table.getSelectedRow(), 10).toString());
          	textField_email.setText(dft.getValueAt(table.getSelectedRow(), 11).toString());
            
		}
        //직속상사 从数据库中把数据填充选择框
          protected void setSuperiorStaff() {
                    // TODO Auto-generated method stub
//                    comboBox_editPar.removeAllItems();
                   ProStaffDao psDao=new ProStaffDao();
                   ProStaff ps1=new ProStaff();
                   ps1.setProType("교원");
                   ProStaff ps2=new ProStaff();
                   ps2.setProType("직원");
                    List<ProStaff> pslist1 = psDao.getProStaffList(ps1);
                    List<ProStaff> pslist2 = psDao.getProStaffList(ps2);
                    String str=null;
                    comboBox_sup1.addItem(str);
                    comboBox_sup2.addItem(str);
                    for (ProStaff ps1Date : pslist1) {
                    	comboBox_sup1.addItem(ps1Date);
                    }
                    for (ProStaff ps2Date : pslist2) {
                    	comboBox_sup2.addItem(ps2Date);
                    }
                    psDao.closeDao();
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
                    Org org;
                    if(checkBox_searchOrg.isSelected()){
                        org=(Org) comboBox_sOrgName.getSelectedItem();
                        ps.setOrgId(org.getOrgCode());
                    }
//                    	org=(Org) comboBox_sOrgName.getSelectedItem();
//                    	ps.setOrgId(org.getOrgCode());
					
                    ps.setProType(comboBox_proType.getSelectedItem().toString());
                    
                    int row=table.getSelectedRow();
                    if(row==-1){
                              restvalues();
                    }
                    setTable(ps);
          }
        private void restvalues() {
			// TODO Auto-generated method stub
        	textField_editName.setText("");
        	textField_editEname.setText("");
        	comboBox_editProType.setSelectedIndex(0);
        	comboBox_editperType.setSelectedIndex(0);
        	comboBox_eidtteaType.setSelectedIndex(0);
        	bgroup2.clearSelection();
//        	textField_idCard1.setText("");
//        	textField_idCard2.setText("");
        	comboBox_editOrgName.setSelectedIndex(0);
        	textField_editAddress.setText("");
        	textField_tel.setText("");
        	textField_email.setText("");
//        	comboBox_empType.setSelectedIndex(0);
        	comboBox_sup1.setSelectedIndex(0);
        	comboBox_sup2.setSelectedIndex(0);
		}

		//学科 从数据库中把数据填充选择框
          protected void setOrgName() {
                    // TODO Auto-generated method stub
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList=orgDao.getOrgList(new Org());
//                    String str="";
//                    comboBox_editOrgName.addItem(str);
//                	comboBox_sOrgName.addItem(str);
                    for (Org org: orgList) {
                    	comboBox_editOrgName.addItem(org);
                    	comboBox_sOrgName.addItem(org);
                    }
                    orgDao.closeDao();
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
                             v.add(pslist.getTeaType());
                             v.add(pslist.getSex());
                             v.add(pslist.getIdCardNo());
                             v.add(this.getOrgNameById(pslist.getOrgId()));
                             v.add(pslist.getAddress());
                             v.add(pslist.getTel());
                             v.add(pslist.getEmail());
                             v.add(pslist.getLoginDate());
                             v.add(pslist.getPassword());
                             v.add(pslist.getSupId());
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
}
