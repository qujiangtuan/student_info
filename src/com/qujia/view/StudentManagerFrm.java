package com.qujia.view;

import java.awt.Color;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;

public class StudentManagerFrm extends JInternalFrame {
          private JTextField nameTextField;
          private JTable studentListTable;
          private JTextField editNameTextField;
          private JTextField editEmailTextField;
          private JComboBox searchOrgComboBox;
          private JComboBox editOrgComboBox;
//          private List<StudentClass> studentClassList;
          private List<Org> orgList;
          private ButtonGroup editSexButtonGroup;
          private JRadioButton editStudentSexManRadioButton;
          private JRadioButton editStudentSexFemalRadioButton;
          private JTextField editTel_textField;
          private JTextField editAddress_textField;
          private JCheckBox checkBox_3;
          private JTextField textField_no;
          private JRadioButton radioButton_2;
          private JRadioButton radioButton_1;
          private  ButtonGroup bg;
          private JButton button;
          private static int selectIndex;

          /**
           * Launch the application.
           */
//          public static void main(String[] args) {
//                    EventQueue.invokeLater(new Runnable() {
//                              public void run() {
//                                        try {
//                                                  StudentManagerFrm frame = new StudentManagerFrm();
//                                                  frame.setVisible(true);
//                                        } catch (Exception e) {
//                                                  e.printStackTrace();
//                                        }
//                              }
//                    });
//          }

          /**
           * Create the frame.
           */
          public StudentManagerFrm() {
                    setFrameIcon(new ImageIcon(StudentManagerFrm.class.getResource("/images/studentManager.png")));
                    setClosable(true);
                    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setIconifiable(true);
                    setTitle("\uD559\uC0DD\uB9AC\uC2A4\uD2B8");
                    setBounds(2, 5, 1104, 475);
                    
                    JLabel searchStudentNameLabel = new JLabel("학생이름:");
                    searchStudentNameLabel.setIcon(null);
                    searchStudentNameLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    nameTextField = new JTextField();
                    nameTextField.setColumns(10);
                    nameTextField.setEnabled(true);
                    JButton searchButton = new JButton("\uAC80\uC0C9");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        searchStudent(ae);
                              }
                    });
                    searchButton.setIcon(null);
                    searchButton.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    JLabel searchClassLabel = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    searchClassLabel.setIcon(null);
                    searchClassLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    searchOrgComboBox = new JComboBox();
                    searchOrgComboBox.setEnabled(false);
                    
                    JScrollPane scrollPane =  new JScrollPane();
                    
                    JLabel editStudentNameLabel = new JLabel("\uD559\uC0DD\uC774\uB984:");
                    editStudentNameLabel.setIcon(null);
                    editStudentNameLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editNameTextField = new JTextField();
                    editNameTextField.setColumns(10);
                    
                    JLabel editClassLabel = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    editClassLabel.setIcon(null);
                    editClassLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editOrgComboBox = new JComboBox();
                    
                    JLabel editStudentSexLabel = new JLabel("\uC131\uBCC4:");
                    editStudentSexLabel.setIcon(null);
                    editStudentSexLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editStudentSexManRadioButton = new JRadioButton("\uB0A8");
                    editStudentSexManRadioButton.setSelected(true);
                    editStudentSexManRadioButton.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editStudentSexFemalRadioButton = new JRadioButton("\uC5EC");
                    editStudentSexFemalRadioButton.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editSexButtonGroup=new ButtonGroup();
                    editSexButtonGroup.add(editStudentSexManRadioButton);
                    editSexButtonGroup.add(editStudentSexFemalRadioButton);
                    
                    JLabel editEmailLabel = new JLabel("이메일:");
                    editEmailLabel.setIcon(null);
                    editEmailLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editEmailTextField = new JTextField();
                    
                    JButton submitEidtButton = new JButton("\uC218\uC815");
                    submitEidtButton.setBackground(new Color(176, 224, 230));
                    submitEidtButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                          submiEditAct(ae);
                              }
                    });
                    submitEidtButton.setIcon(null);
                    submitEidtButton.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    JButton deleteStudentButton = new JButton("\uC0AD\uC81C");
                    deleteStudentButton.setBackground(new Color(255, 105, 180));
                    deleteStudentButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        deleteStudent(ae);
                              }
                    });
                    deleteStudentButton.setIcon(null);
                    deleteStudentButton.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    JLabel label_1 = new JLabel("전화번호:");
                    label_1.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    editTel_textField = new JTextField();
                    editTel_textField.setColumns(10);
                    
                    JLabel label_2 = new JLabel("집주소:");
                    label_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    editAddress_textField = new JTextField();
                    editAddress_textField.setColumns(10);
                    
                    checkBox_3 = new JCheckBox("");
                    
                    checkBox_3.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(checkBox_3.isSelected()){
                                                  searchOrgComboBox.setEnabled(true);
                                        }else{
                                                  searchOrgComboBox.setEnabled(false);
                                        }
                              }
                    });
                    
                    textField_no = new JTextField();
                    textField_no.setColumns(10);
                    textField_no.setEnabled(false);
                    JLabel label_ = new JLabel("학 번:");
                    label_.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    radioButton_2 = new JRadioButton("");
                    radioButton_2.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_2.isSelected()){
                                                  textField_no.setEnabled(true);
                                        }else{
                                                  textField_no.setEnabled(false);
                                        }
                              }
                    });
                    radioButton_1 = new JRadioButton("");
                    radioButton_1.setSelected(true);
                    radioButton_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_1.isSelected()){
                                                  nameTextField.setEnabled(true);
                                        }else{
                                                  nameTextField.setEnabled(false);
                                        }
                              }
                    });
                    bg=new ButtonGroup();
                    bg.add(radioButton_1);
                    bg.add(radioButton_2);
                    
                    button = new JButton("추가\r\n전공");
                    button.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		 int row=studentListTable.getSelectedRow();
                             if(row==-1){
                                       JOptionPane.showMessageDialog(null, "수정할 행을 선택해주세요!");
                                       return;
                             }
                    		AddAppendMajor aam=new AddAppendMajor();
                    		aam.setVisible(true);
                    	}
                    });
                    button.setFont(new Font("Dialog", Font.BOLD, 13));
                    button.setBackground(new Color(72, 209, 204));
                    GroupLayout groupLayout = new GroupLayout(getContentPane());
                    groupLayout.setHorizontalGroup(
                    	groupLayout.createParallelGroup(Alignment.LEADING)
                    		.addGroup(groupLayout.createSequentialGroup()
                    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    				.addGroup(groupLayout.createSequentialGroup()
                    					.addGap(7)
                    					.addComponent(radioButton_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.UNRELATED)
                    					.addComponent(searchStudentNameLabel)
                    					.addPreferredGap(ComponentPlacement.UNRELATED)
                    					.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                    					.addGap(24)
                    					.addComponent(radioButton_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(label_, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(textField_no, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                    					.addGap(41)
                    					.addComponent(checkBox_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(searchClassLabel)
                    					.addGap(18)
                    					.addComponent(searchOrgComboBox, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                    					.addGap(18)
                    					.addComponent(searchButton))
                    				.addGroup(groupLayout.createSequentialGroup()
                    					.addContainerGap()
                    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
                    						.addGroup(groupLayout.createSequentialGroup()
                    							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(editStudentNameLabel)
                    								.addComponent(editClassLabel))
                    							.addGap(18)
                    							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                    								.addComponent(editNameTextField)
                    								.addComponent(editOrgComboBox, 0, 284, Short.MAX_VALUE))
                    							.addPreferredGap(ComponentPlacement.UNRELATED)
                    							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(editEmailLabel)
                    								.addComponent(editStudentSexLabel))
                    							.addPreferredGap(ComponentPlacement.UNRELATED)
                    							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    								.addComponent(editEmailTextField, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                    								.addGroup(groupLayout.createSequentialGroup()
                    									.addComponent(editStudentSexManRadioButton)
                    									.addGap(18)
                    									.addComponent(editStudentSexFemalRadioButton)))
                    							.addGap(18)
                    							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                    							.addGap(18)
                    							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                    								.addComponent(editAddress_textField)
                    								.addComponent(editTel_textField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                    							.addPreferredGap(ComponentPlacement.UNRELATED)
                    							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    								.addComponent(submitEidtButton)
                    								.addComponent(deleteStudentButton))
                    							.addPreferredGap(ComponentPlacement.UNRELATED)
                    							.addComponent(button)))))
                    			.addContainerGap())
                    );
                    groupLayout.setVerticalGroup(
                    	groupLayout.createParallelGroup(Alignment.LEADING)
                    		.addGroup(groupLayout.createSequentialGroup()
                    			.addContainerGap(26, Short.MAX_VALUE)
                    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                    					.addComponent(checkBox_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    					.addComponent(radioButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(label_, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(textField_no, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    					.addComponent(radioButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(searchStudentNameLabel)
                    						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
                    				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(searchClassLabel)
                    					.addComponent(searchOrgComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(searchButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    			.addGap(29)
                    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                    			.addGap(29)
                    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    				.addGroup(groupLayout.createSequentialGroup()
                    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(editStudentNameLabel)
                    						.addComponent(editNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    					.addGap(18)
                    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(editClassLabel)
                    						.addComponent(editOrgComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    				.addGroup(groupLayout.createSequentialGroup()
                    					.addPreferredGap(ComponentPlacement.RELATED)
                    					.addComponent(submitEidtButton)
                    					.addGap(18)
                    					.addComponent(deleteStudentButton))
                    				.addComponent(button, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                    				.addGroup(groupLayout.createSequentialGroup()
                    					.addGap(3)
                    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(editStudentSexManRadioButton)
                    						.addComponent(editStudentSexFemalRadioButton)
                    						.addComponent(editStudentSexLabel))
                    					.addGap(18)
                    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    						.addComponent(editAddress_textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(editEmailTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    						.addComponent(editEmailLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
                    				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                    					.addComponent(editTel_textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
                    			.addContainerGap(71, Short.MAX_VALUE))
                    );
                    
                    
                    
                    studentListTable = new JTable();
//                    studentListTable.addFocusListener(new FocusAdapter() {
//                              @Override
//                              public void focusLost(FocusEvent e) {
//                                        editNameTextField.setText("");
//                                        editEmailTextField.setText("");
//                                        editTel_textField.setText("");
//                                        editAddress_textField.setText("");
//                                        editDeptComboBox.setSelectedIndex(0);
//                                        editSexButtonGroup.clearSelection();
//                              }
//                    });
                    studentListTable.setRowHeight(25);
                    studentListTable.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent me) {
                                        selectedTableRow(me);
                                        getStudentName();
                              }
                    });
                    studentListTable.setFont(new Font("나눔명조", Font.BOLD, 13));
                    studentListTable.setModel(new DefaultTableModel(
                    	new Object[][] {
                    		{null, null, null, null, null, null, null, null, null, null, null, null, null},
                    	},
                    	new String[] {
                    		"\uD559\uBC88", "\uC774\uB984", "\uC18C\uC18D\uD559\uACFC", "\uC131\uBCC4", "\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uC785\uD559\uC77C\uC790", "\uC774\uBA54\uC77C", "\uBE44\uBC00\uBC88\uD638", "\uC9D1\uC8FC\uC18C", "\uCD94\uAC00\uC804\uACF5\uAD6C\uBD84", "\uCD94\uAC00\uC804\uACF5\uC774\uB984", "\uC2E0\uCCAD\uC77C\uC790"
                    	}
                    ) {
                    	boolean[] columnEditables = new boolean[] {
                    		false, false, false, false, false, false, false, false, false, false, false, false, false
                    	};
                    	public boolean isCellEditable(int row, int column) {
                    		return columnEditables[column];
                    	}
                    });
                    studentListTable.getColumnModel().getColumn(2).setPreferredWidth(87);
                    studentListTable.getColumnModel().getColumn(4).setPreferredWidth(111);
                    studentListTable.getColumnModel().getColumn(5).setPreferredWidth(103);
                    studentListTable.getColumnModel().getColumn(6).setPreferredWidth(88);
                    studentListTable.getColumnModel().getColumn(7).setPreferredWidth(104);
                    studentListTable.getColumnModel().getColumn(9).setPreferredWidth(112);
                    studentListTable.getColumnModel().getColumn(10).setPreferredWidth(94);
                    studentListTable.getColumnModel().getColumn(11).setPreferredWidth(93);
                    studentListTable.getColumnModel().getColumn(12).setPreferredWidth(81);
                    scrollPane.setViewportView(studentListTable);
                    getContentPane().setLayout(groupLayout);
                    //set TABLE data in center
                    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
                    cr.setHorizontalAlignment(JLabel.CENTER);
                    studentListTable.setDefaultRenderer(Object.class, cr);
                    studentListTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                   scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    setDeptName();
                    setTable(new Student());
          }
          protected String getStudentName() {
			// TODO Auto-generated method stub
        	  String name = studentListTable.getValueAt(selectIndex, 1).toString();
        	  return name;
		}
		//수정 submit event
          protected void submiEditAct(ActionEvent ae) {
                    setDeptName();
                    int row=studentListTable.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    String studentName=editNameTextField.getText().toString();
                    String studentEmail=editEmailTextField.getText().toString();
                    String studentTel=editTel_textField.getText().toString();
                    String studentAddress=editAddress_textField.getText().toString();
                    if(StringUtil.isEmpty(studentName)){
                              JOptionPane.showMessageDialog(this, "학생이름을 입력해주세요");
                              return;
                    }
                    if(StringUtil.isEmpty(studentEmail)){
                              JOptionPane.showMessageDialog(this, "이메일를 입력해주세요");
                              return;
                    }
                    if(StringUtil.isEmpty(studentTel)){
                              JOptionPane.showMessageDialog(this, "전화번호를 입력해주세요");
                              return;
                    }
                    if(StringUtil.isEmpty(studentAddress)){
                              JOptionPane.showMessageDialog(this, "주소를 입력해주세요");
                              return;
                    }
                    Student student=new Student();
                    student.setName(studentName);
                    student.setEmail(studentEmail);
                    student.setTel(studentTel);
                    student.setAdress(studentAddress);
//                    StudentClass sc = (StudentClass) searchClassComboBox.getSelectedItem();
                   Org org=(Org) editOrgComboBox.getSelectedItem();
                    student.setOrgId(org.getOrgCode());
                    
                    student.setsNo(studentListTable.getValueAt(row, 0).toString());
                    if(editStudentSexManRadioButton.isSelected()) student.setSex(editStudentSexManRadioButton.getText().toString());
                    if(editStudentSexFemalRadioButton.isSelected()) student.setSex(editStudentSexFemalRadioButton.getText().toString());
                     
                    StudentDao studentDao=new StudentDao();
                    if(studentDao.updateStudent(student)){
                              JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                    }else{
                              JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                    }
                    studentDao.closeDao();
                    setTable(new Student());
          }
          //Table중 행을 선택
          protected void selectedTableRow(MouseEvent me) {
                    // TODO Auto-generated method stub
                    DefaultTableModel   dft = (DefaultTableModel) studentListTable.getModel();
                    //得到选中表格中的哪一行，那一列的值
                    selectIndex=studentListTable.getSelectedRow();
                    editNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 1).toString());
                    editEmailTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 7).toString());
                    editTel_textField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 5).toString());
                    editAddress_textField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 9).toString());
                    String orgName=dft.getValueAt(studentListTable.getSelectedRow(), 2).toString();
                    for(int i=0;i<editOrgComboBox.getItemCount();i++){
                              Org org=(Org)editOrgComboBox.getItemAt(i);
                              if(orgName.equals(org.getName())){
                                        editOrgComboBox.setSelectedIndex(i);
                              }
                    }
                    String sex=dft.getValueAt(studentListTable.getSelectedRow(), 3).toString();
                    editSexButtonGroup.clearSelection();
                    if(sex.equals(editStudentSexManRadioButton.getText())) editStudentSexManRadioButton.setSelected(true);
                    if(sex.equals(editStudentSexFemalRadioButton.getText())) editStudentSexFemalRadioButton.setSelected(true);
                    
                    
                    
          }
          //학생삭제
          protected void deleteStudent(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    setDeptName();
                    int row=studentListTable.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까？") != JOptionPane.OK_OPTION){
                              return;
                    }
                    StudentDao studentDao =new StudentDao();
                    String sNo=studentListTable.getValueAt(row, 0).toString();
                    if(studentDao.delete(sNo)){
                              JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                    }else{
                              JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                    }
                    studentDao.closeDao();
                    setTable(new Student());
                    restvalues();
          }
          //학생 검색
          protected void searchStudent(ActionEvent ae) {
                    setDeptName();
                    Student student=new Student();
                    if(radioButton_1.isSelected()){
                              student.setName(nameTextField.getText().toString());
                    }else{
                              student.setsNo(textField_no.getText().toString());
                    }
                    Org org;
                    if(checkBox_3.isSelected()){
                              org=(Org) searchOrgComboBox.getSelectedItem();
                              student.setOrgId(org.getOrgCode());
                    }
                    int row=studentListTable.getSelectedRow();
                    if(row==-1){
                              restvalues();
                    }
                    setTable(student);
          }
          private void restvalues() {
                    editNameTextField.setText("");
                          editEmailTextField.setText("");
                          editTel_textField.setText("");
                          editAddress_textField.setText("");
                          editOrgComboBox.setSelectedIndex(0);
                          editSexButtonGroup.clearSelection();
          }
          // table다시 설정
          public void setTable(Student student){
                   DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
                   dft.setRowCount(0);
                   StudentDao studentDao=new StudentDao();
                   List<Student> studentList = studentDao.getStudentList(student);
                   for(Student s : studentList){
                             Vector v=new Vector();
                             v.add(s.getsNo());
                             v.add(s.getName());
                             v.add(this.getDeptNameById(s.getOrgId()));
//                             v.add(s.getDeptId());
                             v.add(s.getSex());
                             v.add(s.getIdCardNo());
                             v.add(s.getTel());
                             v.add(s.getJoinDate());
                             v.add(s.getEmail());
                             v.add(s.getPassword());
                             v.add(s.getAdress());
                             v.add(s.getMajorType());
                             v.add(s.getMajor());
                             v.add(s.getApplyDate());
                             dft.addRow(v);
                   }
                   studentDao.closeDao();
                   
          }
        //학과선택
          protected void setDeptName() {
                    // TODO Auto-generated method stub
                    OrgDao orgDao=new OrgDao();
                    
                    orgList = orgDao.getOrgList(new Org());
                    for (Org org : orgList) {
                              searchOrgComboBox.addItem(org);
                              editOrgComboBox.addItem(org);
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
