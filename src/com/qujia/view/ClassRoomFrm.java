package com.qujia.view;

import java.awt.CardLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.ClassRoomDao;
import com.qujia.model.ClassRoom;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class ClassRoomFrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_cName;
	private JTextField textField_counts;
	private JTextField textField_seaName;
	private JTable table;
	private JTextField textField_editName;
	private JTextField textField_editCounts;
	CardLayout card;
	private JPanel panel,panel_crManager,panel_crAdd;
	private JComboBox comboBox_exp;
	private List<ClassRoom> csList ;
	private JComboBox comboBox_editExp;
	private String[] explist;
	private JComboBox comboBox_sExp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassRoomFrm frame = new ClassRoomFrm();
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
	public ClassRoomFrm() {
	          this.setResizable(false);
		setTitle("\uAC15\uC758\uC2E4\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 729, 480);
		
		 ViewUtil vu = new ViewUtil();
         vu.showCenter(this);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBounds(17, 48, 684, 371);
		JButton managerButton = new JButton("\uAC15\uC758\uC2E4\uAD00\uB9AC");
		managerButton.setBounds(59, 15, 127, 23);
		managerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "panel_crManager");
				setTable(new ClassRoom());
			}
		});
		
		JButton addButton = new JButton("\uAC15\uC758\uC2E4\uB4F1\uB85D");
		addButton.setBounds(198, 15, 118, 23);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "panel_crAdd");
			}
		});
		card=new CardLayout(0, 0);
		panel.setLayout(card);
		
		panel_crManager = new JPanel();
		panel_crManager.setBackground(new Color(240, 240, 240));
		panel.add(panel_crManager, "panel_crManager");
		
		JLabel lblNewLabel_4 = new JLabel("\uAC15\uC758\uC2E4\uBA85:");
		lblNewLabel_4.setBounds(60, 26, 61, 15);
		
		textField_seaName = new JTextField();
		textField_seaName.setBounds(133, 23, 125, 21);
		textField_seaName.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\uAC80 \uC0C9");
		btnNewButton_1.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    searchClassRoomAction(e);
		          }
		});
		btnNewButton_1.setBounds(525, 22, 92, 23);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 55, 642, 172);
		
		JLabel lblNewLabel_5 = new JLabel("\uAC15\uC758\uC2E4\uBA85:");
		lblNewLabel_5.setBounds(22, 248, 66, 15);
		
		textField_editName = new JTextField();
		textField_editName.setBounds(100, 245, 157, 21);
		textField_editName.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uC815\uC6D0:");
		lblNewLabel_6.setBounds(46, 287, 42, 15);
		
		textField_editCounts = new JTextField();
		textField_editCounts.setBounds(100, 284, 157, 21);
		textField_editCounts.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uAC15\uC758\uC2E4\uD2B9\uC131:");
		lblNewLabel_7.setBounds(269, 248, 79, 15);
		
		JButton btnNewButton_2 = new JButton("\uC218 \uC815");
		btnNewButton_2.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    updateCsAction(e);
		          }
		});
		btnNewButton_2.setBounds(181, 338, 92, 23);
		btnNewButton_2.setBackground(new Color(60, 179, 113));
		
		JButton button = new JButton("\uC0AD \uC81C");
		button.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    deleteCRAction(e);
		          }
		});
		button.setBounds(327, 338, 92, 23);
		button.setBackground(new Color(255, 99, 71));
		
		comboBox_editExp = new JComboBox();
		comboBox_editExp.setBounds(360, 245, 172, 21);
		explist=new String[] {"", "일반강의실", "실습강의실"};
		comboBox_editExp.setModel(new DefaultComboBoxModel(explist));
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
		          @Override
		          public void mouseClicked(MouseEvent e) {
		                    selectRowAction(e);
		          }
		});
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
		          new Object[][] {
		                    {null, null, null, null},
		          },
		          new String[] {
		                    "\uBC88\uD638", "\uAC15\uC758\uC2E4\uBA85", "\uC815\uC6D0", "\uAC15\uC758\uC2E4\uD2B9\uC131"
		          }
		) {
		          boolean[] columnEditables = new boolean[] {
		                    false, false, false, false
		          };
		          public boolean isCellEditable(int row, int column) {
		                    return columnEditables[column];
		          }
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(99);
		table.getColumnModel().getColumn(1).setPreferredWidth(135);
		table.getColumnModel().getColumn(2).setPreferredWidth(64);
		table.getColumnModel().getColumn(3).setPreferredWidth(272);
		scrollPane_1.setViewportView(table);
		panel_crManager.setLayout(null);
		panel_crManager.add(lblNewLabel_4);
		panel_crManager.add(textField_seaName);
		panel_crManager.add(btnNewButton_1);
		panel_crManager.add(lblNewLabel_6);
		panel_crManager.add(lblNewLabel_5);
		panel_crManager.add(textField_editCounts);
		panel_crManager.add(textField_editName);
		panel_crManager.add(lblNewLabel_7);
		panel_crManager.add(comboBox_editExp);
		panel_crManager.add(btnNewButton_2);
		panel_crManager.add(button);
		panel_crManager.add(scrollPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("강의실특성:");
		lblNewLabel_3.setBounds(290, 26, 79, 15);
		panel_crManager.add(lblNewLabel_3);
		
		comboBox_sExp = new JComboBox();
		comboBox_sExp.setModel(new DefaultComboBoxModel(new String[] {"", "일반강의실", "실습강의실"}));
		comboBox_sExp.setBounds(360, 23, 132, 21);
		panel_crManager.add(comboBox_sExp);
		
		JButton button_1 = new JButton("닫기");
		button_1.setBackground(new Color(224, 255, 255));
		button_1.setBounds(471, 338, 92, 23);
		panel_crManager.add(button_1);
		
		panel_crAdd = new JPanel();
		panel_crAdd.setBackground(new Color(240, 240, 240));
		panel.add(panel_crAdd, "panel_crAdd");
		
		JLabel lblNewLabel_1 = new JLabel("\uAC15\uC758\uC2E4\uBA85:");
		lblNewLabel_1.setBounds(94, 46, 64, 15);
		
		textField_cName = new JTextField();
		textField_cName.setBounds(176, 43, 216, 21);
		textField_cName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC815\uC6D0:");
		lblNewLabel.setBounds(117, 85, 41, 15);
		
		textField_counts = new JTextField();
		textField_counts.setBounds(176, 82, 216, 21);
		textField_counts.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uAC15\uC758\uC2E4\uD2B9\uC131:");
		lblNewLabel_2.setBounds(82, 124, 76, 15);
		
		JButton btnNewButton = new JButton("\uB4F1  \uB85D");
		btnNewButton.setBounds(176, 281, 102, 23);
		btnNewButton.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    classRoomLoginAction(e);
		          }
		});
		
		comboBox_exp = new JComboBox();
		comboBox_exp.setEditable(true);
		comboBox_exp.setBounds(176, 121, 216, 21);
		comboBox_exp.setModel(new DefaultComboBoxModel(new String[] {"", "일반강의실", "실습강의실"}));
		panel_crAdd.setLayout(null);
		panel_crAdd.add(lblNewLabel_2);
		panel_crAdd.add(lblNewLabel_1);
		panel_crAdd.add(lblNewLabel);
		panel_crAdd.add(btnNewButton);
		panel_crAdd.add(textField_counts);
		panel_crAdd.add(textField_cName);
		panel_crAdd.add(comboBox_exp);
		
		JButton button_2 = new JButton("취 소");
		button_2.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent e) {
		                    card.show(panel, "panel_crManager");
		                    setTable(new ClassRoom());
		          }
		});
		button_2.setBounds(290, 281, 102, 23);
		panel_crAdd.add(button_2);
		contentPane.setLayout(null);
		contentPane.add(managerButton);
		contentPane.add(addButton);
		contentPane.add(panel);
		
		setTable(new ClassRoom());
	}
	//삭제
	         protected void deleteCRAction(ActionEvent e) {
	                   int row=table.getSelectedRow();
	                    if(row==-1){
	                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
	                              return;
	                    }
	                    ClassRoomDao crDao =new ClassRoomDao();
                        String cno = table.getValueAt(row, 0).toString();
	                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
	                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
	                    if(showConfirmDialog==JOptionPane.YES_OPTION){
	                              if(crDao.deleteCR(cno)){
	                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
	                              }else{
	                                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
	                              }  
	                    }
	                    crDao.closeDao();
	                    setTable(new ClassRoom());
	                    resetValueManager();
          }

          //수정
    	protected void updateCsAction(ActionEvent e) {
    	          String orgid;
                  int row=table.getSelectedRow();
                  if(row==-1){
                            JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                            return;
                  }
                  int cno = Integer.parseInt(table.getValueAt(row, 0).toString());
                  String name = textField_editName.getText().toString();
                  int counts =Integer.parseInt(textField_editCounts.getText().toString());
                  String exp = comboBox_editExp.getSelectedItem().toString();                  
                  ClassRoom cr=new ClassRoom();
                  cr.setCrNo(cno);
                  cr.setCrName(name);
                  cr.setCounts(counts);
                  cr.setExp(exp);
                  
                  ClassRoomDao crDao=new ClassRoomDao();
                  int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                      JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                  if(showConfirmDialog==JOptionPane.YES_OPTION){
                            if(crDao.updateCR(cr)){
                                      JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                            }else{
                                      JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                            }
                  }else{
                            return;
                  }
                  crDao.closeDao();
                  setTable(new ClassRoom());
          }

          protected void searchClassRoomAction(ActionEvent e) {
                  String  name=null,crExp=null;
                  ClassRoom cs=new ClassRoom();
                  name=textField_seaName.getText().toString();
                  cs.setCrName(name);
                  crExp = comboBox_sExp.getSelectedItem().toString();
                  cs.setExp(crExp);
                  setTable(cs);
                  resetValueManager();
    	}

          private void resetValueManager() {
                    textField_editName.setText("");
                    textField_counts.setText("");
                    comboBox_editExp.setSelectedIndex(0);
          }

          //select row
	          protected void selectRowAction(MouseEvent e) {
	                    String cno,cname,counts,exp;
	                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
	                    int row=table.getSelectedRow();
	                    
	                    cno = dft.getValueAt(row, 0).toString();
	                    cname=dft.getValueAt(row, 1).toString();
	                    counts=dft.getValueAt(row, 2).toString();
	                    try {
	                              exp=dft.getValueAt(row, 3).toString();
                        } catch (Exception e2) {
                                  exp=null;
                        }
	                    
	                    
	                    textField_editName.setText(cname);
	                    textField_editCounts.setText(counts);
	                    try {
	                              for(int i=0;i<comboBox_editExp.getItemCount();i++){
	                                        if(exp.equals(explist[i])){
	                                                  comboBox_editExp.setSelectedIndex(i);
	                                        } 
	                              }
                        } catch (Exception e2) {
                                  comboBox_editExp.setSelectedIndex(0);
                        }
          }

                    //강의실 등록
          protected void classRoomLoginAction(ActionEvent e) {
                    String cName = textField_cName.getText().toString();
                    int counts =Integer.parseInt(textField_counts.getText().toString());
                    String exp = comboBox_exp.getSelectedItem().toString();
                    if(StringUtil.isEmpty(cName)){
                              JOptionPane.showConfirmDialog(this, "강의실명 입력해주세요!");
                              return;
                    }
                    if(StringUtil.isEmpty(counts)){
                              JOptionPane.showConfirmDialog(this, "정원 입력해주세요!");
                              return;
                    }
                    if(StringUtil.isEmpty(exp)){
                              JOptionPane.showConfirmDialog(this, "강의실 특성 입력해주세요!");
                              return;
                    }
                    ClassRoom cr=new ClassRoom(); 
                    cr.setCrName(cName);
                    cr.setCounts(counts);
                    cr.setExp(exp);
                    ClassRoomDao crDao=new ClassRoomDao();
                    if(crDao.loginCR(cr)){
                              JOptionPane.showMessageDialog(this, "강의실 등록 했습니다!");
                    }else{
                              JOptionPane.showMessageDialog(this, "강의실 등록 실패했습니다!");
                    }
                    crDao.closeDao();
                    resetValue();
          }
          //set table
                    private void setTable(ClassRoom classRoom) {
                              DefaultTableModel dft = (DefaultTableModel) table.getModel();
                              dft.setRowCount(0);
                              ClassRoomDao crDao=new ClassRoomDao();
                              List<ClassRoom> csList = crDao.getCsList(classRoom);
                              for(ClassRoom c : csList){
                                        Vector v=new Vector();
                                        v.add(c.getCrNo());//0
                                        v.add(c.getCrName());
                                        v.add(c.getCounts());
                                        v.add(c.getExp());
                                        dft.addRow(v);
                              }
                              crDao.closeDao();  
                    }

                    private void resetValue() {
                              textField_cName.setText("");
                              textField_counts.setText("");
                              comboBox_exp.setSelectedIndex(0);
                    }
                    
}
