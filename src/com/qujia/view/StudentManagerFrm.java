package com.qujia.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.ClassDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Student;
import com.qujia.model.StudentClass;
import com.qujia.util.StringUtil;
import java.awt.Color;

public class StudentManagerFrm extends JInternalFrame {
          private JTextField searchStudentNameTextField;
          private JTable studentListTable;
          private JTextField editStudentNameTextField;
          private JTextField editEmailTextField;
          private JComboBox searchClassComboBox;
          private JComboBox editClassComboBox;
          private List<StudentClass> studentClassList;
          private ButtonGroup editSexButtonGroup;
          private JRadioButton editStudentSexManRadioButton;
          private JRadioButton editStudentSexFemalRadioButton;
          private JTextField textField;
          private JTextField textField_1;
          private JTextField textField_2;

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
                    setBounds(2, 5, 951, 467);
                    
                    JLabel searchStudentNameLabel = new JLabel("\uD559\uC0DD\uC774\uB984:");
                    searchStudentNameLabel.setIcon(null);
                    searchStudentNameLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    searchStudentNameTextField = new JTextField();
                    searchStudentNameTextField.setColumns(10);
                    
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
                    
                    searchClassComboBox = new JComboBox();
                    
                    JScrollPane scrollPane =  new JScrollPane();
                    
                    JLabel editStudentNameLabel = new JLabel("\uD559\uC0DD\uC774\uB984:");
                    editStudentNameLabel.setIcon(null);
                    editStudentNameLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editStudentNameTextField = new JTextField();
                    editStudentNameTextField.setColumns(10);
                    
                    JLabel editClassLabel = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    editClassLabel.setIcon(null);
                    editClassLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    editClassComboBox = new JComboBox();
                    
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
                    
                    JLabel label = new JLabel("학번:");
                    label.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel label_1 = new JLabel("전화번호:");
                    label_1.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JLabel label_2 = new JLabel("집주소:");
                    label_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    GroupLayout groupLayout = new GroupLayout(getContentPane());
                    groupLayout.setHorizontalGroup(
                              groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGap(34)
                                                                      .addComponent(searchStudentNameLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(36)
                                                                      .addComponent(label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(textField, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(30)
                                                                      .addComponent(searchClassLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(searchClassComboBox, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(78)
                                                                      .addComponent(searchButton))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(editStudentNameLabel)
                                                                                .addComponent(editClassLabel))
                                                                      .addGap(18)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(editStudentNameTextField)
                                                                                .addComponent(editClassComboBox, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(29)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addComponent(editStudentSexLabel)
                                                                                          .addGap(12)
                                                                                          .addComponent(editStudentSexManRadioButton)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(editStudentSexFemalRadioButton))
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addComponent(editEmailLabel)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(editEmailTextField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addGap(9)
                                                                                          .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                          .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(102)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(deleteStudentButton)
                                                                                .addComponent(submitEidtButton)))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 916, GroupLayout.PREFERRED_SIZE)))
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    groupLayout.setVerticalGroup(
                              groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGap(36)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(searchStudentNameLabel)
                                                            .addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchClassLabel)
                                                            .addComponent(searchClassComboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchButton))
                                                  .addGap(29)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(29)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(editStudentNameLabel)
                                                            .addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(editStudentSexLabel)
                                                            .addComponent(editStudentSexManRadioButton)
                                                            .addComponent(editStudentSexFemalRadioButton)
                                                            .addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(submitEidtButton))
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGap(18)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                                                          .addComponent(editClassLabel)
                                                                                          .addComponent(editClassComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                                                          .addComponent(editEmailLabel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                                                          .addComponent(editEmailTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                                          .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(deleteStudentButton)))
                                                  .addContainerGap(51, Short.MAX_VALUE))
                    );
                    
                    
                    
                    studentListTable = new JTable();
                    studentListTable.setRowHeight(25);
                    studentListTable.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent me) {
                                        selectedTableRow(me);
                              }
                    });
                    studentListTable.setFont(new Font("나눔명조", Font.BOLD, 13));
                    studentListTable.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                                        {null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uBC88", "\uC774\uB984", "\uC18C\uC18D\uD559\uACFC", "\uC131\uBCC4", "\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uC785\uD559\uC77C\uC9DC", "\uC774\uBA54\uC77C", "\uBE44\uBC00\uBC88\uD638", "\uC9D1\uC8FC\uC18C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, true, false, false, false, true
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    studentListTable.getColumnModel().getColumn(4).setPreferredWidth(85);
                    scrollPane.setViewportView(studentListTable);
                    getContentPane().setLayout(groupLayout);
                    //set TABLE data in center
                    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
                    cr.setHorizontalAlignment(JLabel.CENTER);
                    studentListTable.setDefaultRenderer(Object.class, cr);
                    
                    selectClass();
                    setTable(new Student());
          }
          //수정 submit event
          protected void submiEditAct(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    int row=studentListTable.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                    }
                    String studentName=editStudentNameTextField.getText().toString();
                    String studentEmail=editEmailTextField.getText().toString();
                    if(StringUtil.isEmpty(studentName)){
                              JOptionPane.showMessageDialog(this, "학생이름을 입력해주세요");
                              return;
                    }
                    if(StringUtil.isEmpty(studentEmail)){
                              JOptionPane.showMessageDialog(this, "이메일를 입력해주세요");
                              return;
                    }
                    Student student=new Student();
                    student.setName(studentName);
                    student.setEmail(studentEmail);
                    StudentClass sc = (StudentClass) searchClassComboBox.getSelectedItem();
                    student.setClassId(sc.getId());
                    
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
                    editStudentNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 1).toString());
                    editEmailTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 6).toString());
                    String className=dft.getValueAt(studentListTable.getSelectedRow(), 2).toString();
                    for(int i=0;i<editClassComboBox.getItemCount();i++){
                              StudentClass sc=(StudentClass) editClassComboBox.getItemAt(i);
                              if(className.equals(sc.getName())){
                                        editClassComboBox.setSelectedIndex(i);
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
                    if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까?？") != JOptionPane.OK_OPTION){
                              return;
                    }
                    int row=studentListTable.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    StudentDao studentDao =new StudentDao();
                    int id=Integer.parseInt(studentListTable.getValueAt(row, 0).toString());
                    if(studentDao.delete(id)){
                              JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                    }else{
                              JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                    }
                    studentDao.closeDao();
                    setTable(new Student());
          }
          //학생 검색
          protected void searchStudent(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    Student student=new Student();
                    student.setName(searchStudentNameTextField.getText().toString());
                    StudentClass sc=(StudentClass)searchClassComboBox.getSelectedItem();
                    student.setClassId(sc.getId());
                    setTable(student);
          }
          // table다시 설정
          private void setTable(Student student){
                   DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
                   dft.setRowCount(0);
                   StudentDao studentDao=new StudentDao();
                   List<Student> studentList = studentDao.getStudentList(student);
                   for(Student s : studentList){
                             Vector v=new Vector();
                             v.add(s.getsNo());
                             v.add(s.getName());
                             v.add(this.getClassNameById(s.getClassId()));
                             v.add(s.getSex());
                             v.add(s.getIdCardNo());
                             v.add(s.getJoinDate());
                             v.add(s.getEmail());
                             v.add(s.getPassword());
                             dft.addRow(v);
                   }
                   studentDao.closeDao();
                   
          }
          //학과선택
          private void selectClass(){
                    ClassDao classDao=new ClassDao();
                    studentClassList=classDao.getClassList(new StudentClass());
                    for(StudentClass sc:studentClassList){
                              searchClassComboBox.addItem(sc);
                              editClassComboBox.addItem(sc);
                    }
                    classDao.closeDao();
          }
          //classId에 통해서 className를 받는다
          public String getClassNameById(int id){
                    for(StudentClass sc:studentClassList){
                            if(sc.getId()==id) return sc.getName();
                    }
                    return "";
          }
}
