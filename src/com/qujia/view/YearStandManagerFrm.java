package com.qujia.view;

import java.awt.Color;
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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import com.qujia.dao.YearDeptStandDao;
import com.qujia.model.Org;
import com.qujia.model.YearDeptStand;
import com.qujia.util.ViewUtil;

public class YearStandManagerFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_schYear;
	private JTable table;
	private JTextField textField_major;
	private JTextField textField_recTatio;
	private JTextField textField_recTemp;
	private JTextField textField_majorMust;
	private JTextField textField_recForm;
	private JTextField textField_culMust;
	private List<Org> orgList;
	private JCheckBox CheckBox_dept;
	private JLabel label_editDept;
	private JTextField textField_credit;
	private JTextField textField_deptName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YearStandManagerFrm frame = new YearStandManagerFrm();
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
	public YearStandManagerFrm() {
		setTitle("\uD559\uB144\uBCC4\uAD50\uC721\uBD80\uC11C\uD559\uC0AC\uAE30\uC900\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 871, 658);
		
		 ViewUtil vu=new ViewUtil();
         vu.showCenter(this);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uD559\uB144:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		
		textField_schYear = new JTextField();
		textField_schYear.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5\uC774\uB984:");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		  CheckBox_dept = new JCheckBox("");
		  CheckBox_dept.addItemListener(new ItemListener() {
		            public void itemStateChanged(ItemEvent e) {
		                      if(CheckBox_dept.isSelected()){
		                                textField_deptName.setEnabled(true);
		                      }else{
		                                textField_deptName.setEnabled(false);
		                                textField_deptName.setText("");
		                      }
		            }
		  });
		
		  
		JButton btnNewButton = new JButton("\uAC80  \uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    serarchYearDeptStandAction(e);
		          }
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("\uD559\uBD80\uACFC\uC804\uACF5\uC774\uB984:");
		
		 label_editDept = new JLabel("\uCEF4\uD4E8\uD130\uACF5\uD559\uACFC");
		
		JLabel lblNewLabel_5 = new JLabel("\uC804\uACF5\uC774\uC218\uD559\uC810:");
		
		textField_major = new JTextField();
		textField_major.setColumns(10);
		
		JLabel label = new JLabel("\uC218\uC2DC\uBAA8\uC9D1\uBE44\uC728:");
		
		textField_recTatio = new JTextField();
		textField_recTatio.setColumns(10);
		
		JLabel label_2 = new JLabel("수시모집인원:");
		
		textField_recTemp = new JTextField();
		textField_recTemp.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC804\uACF5\uD544\uC218\uD559\uC810:");
		
		textField_majorMust = new JTextField();
		textField_majorMust.setColumns(10);
		
		JLabel label_3 = new JLabel("정시모집인원:");
		
		textField_recForm = new JTextField();
		textField_recForm.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uAD50\uC591\uD544\uC218\uD559\uC810:");
		
		textField_culMust = new JTextField();
		textField_culMust.setColumns(10);
		
		JButton updateButton = new JButton("\uC218 \uC815");
		updateButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    updateYearDeptStand(e);
		          }
		});
		updateButton.setBackground(new Color(224, 255, 255));
		
		JButton deleteButton = new JButton("\uC0AD \uC81C");
		deleteButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    deleteYearDeptStand(e);
		          }
		});
		deleteButton.setBackground(new Color(255, 99, 71));
		
		JLabel label_1 = new JLabel("졸업이수학점:");
		
		textField_credit = new JTextField();
		textField_credit.setColumns(10);
		
		textField_deptName = new JTextField();
		textField_deptName.setEnabled(false);
		textField_deptName.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
		          gl_contentPane.createParallelGroup(Alignment.LEADING)
		                    .addGroup(gl_contentPane.createSequentialGroup()
		                              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                        .addGroup(gl_contentPane.createSequentialGroup()
		                                                  .addGap(75)
		                                                  .addComponent(lblNewLabel)
		                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
		                                                  .addComponent(textField_schYear, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
		                                                  .addGap(44)
		                                                  .addComponent(CheckBox_dept)
		                                                  .addPreferredGap(ComponentPlacement.RELATED)
		                                                  .addComponent(lblNewLabel_1)
		                                                  .addGap(18)
		                                                  .addComponent(textField_deptName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                                  .addGap(191)
		                                                  .addComponent(btnNewButton))
		                                        .addGroup(gl_contentPane.createSequentialGroup()
		                                                  .addGap(59)
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                                            .addGroup(gl_contentPane.createSequentialGroup()
		                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
		                                                                                          .addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                                                                                          .addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                                                                                .addComponent(lblNewLabel_7))
		                                                                      .addGap(18))
		                                                            .addGroup(gl_contentPane.createSequentialGroup()
		                                                                      .addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
		                                                                      .addPreferredGap(ComponentPlacement.RELATED)))
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                                            .addComponent(textField_majorMust, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                                            .addComponent(label_editDept)
		                                                            .addComponent(textField_major, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                                            .addComponent(textField_culMust, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                                                  .addGap(54)
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
		                                                                      .addComponent(label_3, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
		                                                                      .addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                                                                      .addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		                                                            .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
		                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                                                      .addComponent(textField_recTatio, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
		                                                                      .addComponent(textField_recTemp, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
		                                                                      .addComponent(textField_recForm, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
		                                                            .addComponent(textField_credit, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
		                                                  .addGap(75)
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                                            .addComponent(updateButton)
		                                                            .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
		                                                  .addGap(155))
		                                        .addGroup(gl_contentPane.createSequentialGroup()
		                                                  .addContainerGap()
		                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE)))
		                              .addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
		          gl_contentPane.createParallelGroup(Alignment.LEADING)
		                    .addGroup(gl_contentPane.createSequentialGroup()
		                              .addGap(18)
		                              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		                                        .addComponent(CheckBox_dept, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                                                  .addComponent(lblNewLabel)
		                                                  .addComponent(textField_schYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                                  .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
		                                                  .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                                                  .addComponent(textField_deptName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		                              .addGap(18)
		                              .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
		                              .addGap(32)
		                              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                                        .addComponent(label_editDept)
		                                        .addComponent(lblNewLabel_2)
		                                        .addComponent(updateButton)
		                                        .addComponent(label_1)
		                                        .addComponent(textField_credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		                              .addGap(18)
		                              .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                                        .addComponent(lblNewLabel_5)
		                                        .addComponent(textField_major, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(textField_recTatio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                        .addComponent(label)
		                                        .addComponent(deleteButton))
		                              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		                                        .addGroup(gl_contentPane.createSequentialGroup()
		                                                  .addGap(18)
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                                                            .addComponent(textField_recTemp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                                            .addComponent(label_2)
		                                                            .addComponent(textField_majorMust, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                                            .addComponent(lblNewLabel_6))
		                                                  .addGap(18)
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                                                            .addComponent(textField_recForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		                                                            .addComponent(label_3)))
		                                        .addGroup(gl_contentPane.createSequentialGroup()
		                                                  .addGap(60)
		                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		                                                            .addComponent(lblNewLabel_7)
		                                                            .addComponent(textField_culMust, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		                              .addContainerGap(100, Short.MAX_VALUE))
		);
		
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
		                    {null, null, null, null, null, null, null, null, null, null, null, null, null},
		          },
		          new String[] {
		                    "\uAE30\uC900\uBC88\uD638", "\uD559\uACFC\uC774\uB984", "*\uC878\uC5C5\uC774\uC218\uD559\uC810", "*\uC804\uACF5\uC774\uC218\uD559\uC810", "*\uC804\uACF5\uD544\uC218\uD559\uC810", "\uC804\uACF5\uC120\uD0DD\uD559\uC810", "\uAD50\uC591\uC774\uC218\uD559\uC810", "*\uAD50\uC591\uD544\uC218\uD559\uC810", "\uAD50\uC591\uC120\uD0DD\uD559\uC810", "\uC218\uC2DC\uBAA8\uC9D1\uBE44\uC728", "\uC218\uC2DC\uBAA8\uC9D1\uC778\uC6D0", "\uC815\uC2DC\uBAA8\uC9D1\uC778\uC6D0", "\uB4F1\uB85D\uC77C\uC790"
		          }
		) {
		          boolean[] columnEditables = new boolean[] {
		                    false, false, false, false, true, true, false, false, false, false, false, false, false
		          };
		          public boolean isCellEditable(int row, int column) {
		                    return columnEditables[column];
		          }
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		table.getColumnModel().getColumn(4).setPreferredWidth(92);
		table.getColumnModel().getColumn(5).setPreferredWidth(90);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		table.getColumnModel().getColumn(7).setPreferredWidth(92);
		table.getColumnModel().getColumn(8).setPreferredWidth(91);
		table.getColumnModel().getColumn(9).setPreferredWidth(86);
		table.getColumnModel().getColumn(10).setPreferredWidth(89);
		table.getColumnModel().getColumn(11).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.setLayout(gl_contentPane);
		
		setTable(new YearDeptStand());
	}
	          //학년별 학사기준 삭제
	          protected void deleteYearDeptStand(ActionEvent e) {
	                    int row=table.getSelectedRow();
	                    if(row==-1){
	                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
	                              return;
	                    }
 
	                    YearDeptStandDao ydsDao =new YearDeptStandDao();
	                    String yearNo=table.getValueAt(row, 0).toString();
	                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(showConfirmDialog==JOptionPane.YES_OPTION){
                                  if(ydsDao.delete(yearNo)){
                                            JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                                  }else{
                                            JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                                  }
                        }else{
                                  return;
                        }
	                    
	                    ydsDao.closeDao();
	                    setTable(new YearDeptStand());
	                    resetValues();
          }

                    //학년별 학사기준 변경
	          protected void updateYearDeptStand(ActionEvent e) {
	                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
	                    int index=table.getSelectedRow();
	                    if(index==-1){
	                              JOptionPane.showMessageDialog(this, "데이터 라인을 선택하십시오!");
	                              return;
	                    }
//	                  textField_credit.setText("");
//	                   textField_majorMust.setText("");
//	                   textField_culMust.setText("");
//	                   textField_recTatio.setText("");
//	                   textField_recTemp.setText("");
//	                   textField_recForm.setText("");
	                    int credit,major,majorMust,culMust,recTatio,recTemp,recForm;
	                    try {
	                              
	                              credit = Integer.parseInt(textField_credit.getText());
	                              major=Integer.parseInt(textField_major.getText());
	                               majorMust = Integer.parseInt(textField_majorMust.getText());
	                               culMust = Integer.parseInt(textField_culMust.getText());
	                               recTatio= Integer.parseInt(textField_recTatio.getText());
	                               recTemp = Integer.parseInt(textField_recTemp.getText());
	                               recForm = Integer.parseInt(textField_recForm.getText());
                    } catch (Exception e2) {
                              JOptionPane.showMessageDialog(this, "변경할 데이터를 입력합시오!");
                              return;
                    }
	                    String yearNo=dft.getValueAt(table.getSelectedRow(),0).toString();
	                    YearDeptStand ydStand=new YearDeptStand();
	                    ydStand.setCredit(credit);
	                    ydStand.setMajor(major);
	                    ydStand.setMajorMust(majorMust);
	                    ydStand.setCulMust(culMust);
	                    ydStand.setRecTatio(recTatio);
	                    ydStand.setRecTemp(recTemp);
	                    ydStand.setRecForm(recForm);
	                    ydStand.setYearNo(yearNo);
	                    YearDeptStandDao ydsDao=new YearDeptStandDao();
	                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
	                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	                    if(showConfirmDialog==JOptionPane.YES_OPTION){
	                              if(ydsDao.updateDStand(ydStand)){
	                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다!");
	                              }else{
	                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다!");
	                              }
	                    }else{
	                              return;
	                    }
	                    
	                    
	                    ydsDao.closeDao();
	                    setTable(new YearDeptStand());
          }

          //한행 선택
	     protected void selectRow(MouseEvent e) {
	               DefaultTableModel dft = (DefaultTableModel) table.getModel();
                   // 得到选中表格中的哪一行，那一列的值

	               label_editDept.setText(dft.getValueAt(table.getSelectedRow(),1).toString());
	               textField_credit.setText(dft.getValueAt(table.getSelectedRow(),2).toString());
	               textField_major.setText(dft.getValueAt(table.getSelectedRow(),3).toString());
	               textField_majorMust.setText(dft.getValueAt(table.getSelectedRow(),4).toString());
	               textField_culMust.setText(dft.getValueAt(table.getSelectedRow(),7).toString());
	               textField_recTatio.setText(dft.getValueAt(table.getSelectedRow(),9).toString());
	               textField_recTemp.setText(dft.getValueAt(table.getSelectedRow(),10).toString());
	               textField_recForm.setText(dft.getValueAt(table.getSelectedRow(),11).toString());
	               
          }

          //검색
    	protected void serarchYearDeptStandAction(ActionEvent e) {
    	          YearDeptStand yds=new YearDeptStand();
                  String yearNo,deptName;
                  try {
                            yearNo = textField_schYear.getText().toString();
                  } catch (Exception e2) {
                            yearNo =null;
                  }
                  yds.setYearNo(yearNo);
                  if(CheckBox_dept.isSelected()){
//                            Org org = (Org) comboBox_deptName.getSelectedItem();
//                            orgid = org.getOrgCode();
                            deptName=textField_deptName.getText().toString();
                            yds.setDeptName(deptName);
                  }else{
                            deptName=null;
                            yds.setDeptName(null);
                  }
                  setTable(yds);
                  resetValues();
                  
                    
          }

          private void resetValues() {
                    textField_major.setText("");
                    textField_majorMust.setText("");
                    textField_culMust.setText("");
                    textField_recTatio.setText("");
                    textField_recTemp.setText("");
                    textField_recForm.setText("");
          }

          //table 다시 설정
    	private void setTable(YearDeptStand ydStand) {
    	          DefaultTableModel dft = (DefaultTableModel) table.getModel();
                  dft.setRowCount(0);
                  YearDeptStandDao ydDao=new YearDeptStandDao();
                  List<YearDeptStand> ydList = ydDao.getYDSList2(ydStand);
                  for(YearDeptStand yds : ydList){
                            Vector v=new Vector();
                            v.add(yds.getYearNo());
                            v.add(this.getDeptNameById(yds.getOrgId()));
//                            v.add(yds.getYearStart());
//                            v.add(yds.getYearEnd());
                            v.add(yds.getCredit());
                            v.add(yds.getMajor());
                            v.add(yds.getMajorMust());
                            v.add(yds.getMajorChose());
                            v.add(yds.getCul());
                            v.add(yds.getCulMust());
                            v.add(yds.getCulChose());
                            v.add(yds.getRecTatio());
                            v.add(yds.getRecTemp());
                            v.add(yds.getRecForm());
                            v.add(yds.getLoginDate());
                            dft.addRow(v);
                  }
                  ydDao.closeDao();
                   
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
