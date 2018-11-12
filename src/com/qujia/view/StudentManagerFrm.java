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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.Student;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class StudentManagerFrm extends JFrame {
          private JTextField nameTextField;
          private JTable studentListTable;
//          private List<StudentClass> studentClassList;
          private List<Org> orgList;
          private ButtonGroup editSexButtonGroup;
          private JCheckBox checkBox_3;
          private JTextField textField_no;
          private JRadioButton radioButton_2;
          private JRadioButton radioButton_1;
          private  ButtonGroup bg;
          private JButton button;
          private static int selectIndex;
          private JComboBox inSchStatusComboBox;
          private String isInSchool[];
          private String degreeP[];
          private JTextField textField_deptName;
          private JButton deptSearchButton;
          private JTextField textField_seaDeptName;
          private static String staticSno;
          private JPanel contentPane;
          private JButton button_1;
          private static int row=-1;
          private static  String sno=null;
          private static  String stuName=null;
          private static String pw=null;
          
          
          public static String getPw() {
                    return pw;
          }

          public static void setPw(String pw) {
                    StudentManagerFrm.pw = pw;
          }

          public static int getRow() {
                    return row;
          }

          public static void setRow(int row) {
                    StudentManagerFrm.row = row;
          }

          public static String getSno() {
                    return sno;
          }

          public static void setSno(String sno) {
                    StudentManagerFrm.sno = sno;
          }

          public static String getStuName() {
                    return stuName;
          }

          public static void setStuName(String stuName) {
                    StudentManagerFrm.stuName = stuName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  StudentManagerFrm frame = new StudentManagerFrm();
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
          public StudentManagerFrm() {
//                    setFrameIcon(new ImageIcon(StudentManagerFrm.class.getResource("/images/studentManager.png")));
//                    setClosable(true);
                    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    setIconifiable(true);
                    setTitle("학생목록");
                    setBounds(2, 5, 1034, 455);
                    this.setResizable(false);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel searchStudentNameLabel = new JLabel("학생이름:");
                    searchStudentNameLabel.setBounds(36, 28, 74, 26);
                    searchStudentNameLabel.setIcon(null);
                    searchStudentNameLabel.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    nameTextField = new JTextField();
                    nameTextField.setBounds(109, 28, 99, 26);
                    nameTextField.setColumns(10);
                    nameTextField.setEnabled(true);
                    JButton searchButton = new JButton("검 색");
                    searchButton.setBounds(781, 28, 89, 26);
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        searchStudent(ae);
                              }
                    });
                    searchButton.setIcon(null);
                    searchButton.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JLabel searchClassLabel = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    searchClassLabel.setBounds(499, 28, 72, 26);
                    searchClassLabel.setIcon(null);
                    searchClassLabel.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JScrollPane scrollPane =  new JScrollPane();
                    scrollPane.setBounds(12, 83, 994, 240);
                    
                    JLabel editClassLabel = new JLabel("\uC18C\uC18D\uD559\uACFC:");
                    editClassLabel.setVisible(false);
                    editClassLabel.setBounds(12, 397, 60, 19);
                    editClassLabel.setIcon(null);
                    editClassLabel.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    editSexButtonGroup=new ButtonGroup();
                    
                    JButton submitEidtButton = new JButton("\uC218\uC815");
                    submitEidtButton.setBounds(424, 347, 89, 27);
                    submitEidtButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                          submiEditAct(ae);
                              }
                    });
                    submitEidtButton.setIcon(null);
                    submitEidtButton.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    checkBox_3 = new JCheckBox("");
                    checkBox_3.setBounds(474, 28, 23, 26);
                    
                    checkBox_3.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(checkBox_3.isSelected()){
                                                  textField_seaDeptName.setEnabled(true);
                                        }else{
                                                  textField_seaDeptName.setEnabled(false);
                                                  textField_seaDeptName.setText("");
                                        }
                              }
                    });
                    
                    textField_no = new JTextField();
                    textField_no.setBounds(299, 28, 114, 26);
                    textField_no.setColumns(10);
                    textField_no.setEnabled(false);
                    JLabel label_ = new JLabel("학 번:");
                    label_.setBounds(251, 28, 60, 26);
                    label_.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    radioButton_2 = new JRadioButton("");
                    radioButton_2.setBounds(229, 28, 21, 26);
                    radioButton_2.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_2.isSelected()){
                                                  textField_no.setEnabled(true);
                                                  nameTextField.setText("");
                                        }else{
                                                  textField_no.setEnabled(false);
                                        }
                              }
                    });
                    radioButton_1 = new JRadioButton("");
                    radioButton_1.setBounds(12, 28, 21, 26);
                    radioButton_1.setSelected(true);
                    radioButton_1.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(radioButton_1.isSelected()){
                                                  nameTextField.setEnabled(true);
                                                  textField_no.setText("");
                                        }else{
                                                  nameTextField.setEnabled(false);
                                                  
                                        }
                              }
                    });
                    bg=new ButtonGroup();
                    bg.add(radioButton_1);
                    bg.add(radioButton_2);
                    
                    button = new JButton("추가\r\n전공");
                    button.setBounds(576, 347, 114, 27);
                    button.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    	          DefaultTableModel   dft = (DefaultTableModel) studentListTable.getModel();
//                    		 int row=studentListTable.getSelectedRow();
                             if(row==-1){
                                       JOptionPane.showMessageDialog(null, "수정할 행을 선택해주세요!");
                                       return;
                             }
                             String major2=null;
                             try {
                                       major2= dft.getValueAt(row, 13).toString();
                            } catch (Exception e2) {
                                      major2=null;
                            }
                            if(major2!=null){
                                      JOptionPane.showMessageDialog(null, "추가전공를 할 수 있습니다!");
                                      return;
                            }
                    		AddAppendMajorStudentFrm aam=new AddAppendMajorStudentFrm(new JFrame());
                    		aam.setVisible(true);
                    		
                    		boolean flag = AddAppendMajorStudentFrm.isFlag();
                    		if(flag){
                    		          setTable(new Student());
                    		}
                    	}
                    });
                    button.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JLabel label = new JLabel("재학상태:");
                    label.setBounds(12, 351, 60, 19);
                    label.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    inSchStatusComboBox = new JComboBox();
                    inSchStatusComboBox.setBounds(84, 347, 166, 26);
                    
                    isInSchool=new String[] {"","재학", "휴학", "졸업", "자퇴", "퇴학"};
                    inSchStatusComboBox.setModel(new DefaultComboBoxModel(isInSchool));
//                    degreeP=new String[] {"", "학사과정", "석사과정", "박사과정"};
                    
                    textField_deptName = new JTextField();
                    textField_deptName.setVisible(false);
                    textField_deptName.setEditable(false);
                    textField_deptName.setBounds(84, 394, 143, 26);
                    textField_deptName.setColumns(10);
                    
                    deptSearchButton = new JButton("조회");
                    deptSearchButton.setVisible(false);
                    deptSearchButton.setBounds(229, 393, 74, 27);
                    deptSearchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchDeptForStuFrm sdf=new SearchDeptForStuFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_deptName.setText(addSearch());
                              }
                    });
                    deptSearchButton.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    textField_seaDeptName = new JTextField();
                    textField_seaDeptName.setBounds(576, 28, 162, 26);
                    textField_seaDeptName.setEnabled(false);
                    textField_seaDeptName.setColumns(10);
                    
                    
                    
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
//                                        getStudentName();
                              }
                    });
                    studentListTable.setFont(new Font("나눔명조", Font.BOLD, 13));
                    studentListTable.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uBC88", "\uC18C\uC18D\uD559\uACFC", "\uC774\uB984", "\uD559\uB144", "\uC7AC\uD559\uC0C1\uD0DC", "\uD559\uC704\uACFC\uC815", "\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638", "\uC131\uBCC4", "\uBE44\uBC00\uBC88\uD638", "\uC774\uBA54\uC77C", "\uC5F0\uB77D\uCC98", "\uC8FC\uC18C", "\uC785\uD559\uC77C\uC790", "\uCD94\uAC00\uC804\uACF5\uAD6C\uBD84", "\uCD94\uAC00\uC804\uACF5\uC774\uB984", "\uC2E0\uCCAD\uC77C\uC790"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    studentListTable.getColumnModel().getColumn(1).setPreferredWidth(141);
                    studentListTable.getColumnModel().getColumn(6).setPreferredWidth(132);
                    studentListTable.getColumnModel().getColumn(7).setPreferredWidth(63);
                    studentListTable.getColumnModel().getColumn(9).setPreferredWidth(121);
                    studentListTable.getColumnModel().getColumn(10).setPreferredWidth(103);
                    studentListTable.getColumnModel().getColumn(11).setPreferredWidth(141);
                    studentListTable.getColumnModel().getColumn(12).setPreferredWidth(103);
                    studentListTable.getColumnModel().getColumn(13).setPreferredWidth(94);
                    studentListTable.getColumnModel().getColumn(14).setPreferredWidth(129);
                    studentListTable.getColumnModel().getColumn(15).setPreferredWidth(104);
                    scrollPane.setViewportView(studentListTable);
                    //set TABLE data in center
                    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
                    cr.setHorizontalAlignment(JLabel.CENTER);
                    studentListTable.setDefaultRenderer(Object.class, cr);
                    studentListTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    getContentPane().add(radioButton_1);
                    getContentPane().add(searchStudentNameLabel);
                    getContentPane().add(nameTextField);
                    getContentPane().add(radioButton_2);
                    getContentPane().add(label_);
                    getContentPane().add(textField_no);
                    getContentPane().add(checkBox_3);
                    getContentPane().add(searchClassLabel);
                    getContentPane().add(textField_seaDeptName);
                    getContentPane().add(searchButton);
                    getContentPane().add(editClassLabel);
                    getContentPane().add(textField_deptName);
                    getContentPane().add(deptSearchButton);
                    getContentPane().add(label);
                    getContentPane().add(inSchStatusComboBox);
                    getContentPane().add(submitEidtButton);
                    getContentPane().add(button);
                    getContentPane().add(scrollPane);
                    
                    button_1 = new JButton("닫기");
                    button_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    button_1.setFont(new Font("Dialog", Font.BOLD, 13));
                    button_1.setBounds(917, 350, 89, 27);
                    contentPane.add(button_1);
                    
                    JButton button_2 = new JButton("변경이력");
                    button_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        if(row==-1){
                                                  JOptionPane.showMessageDialog(null, "수정할 행을 선택해주세요!");
                                                  return;
                                        }
                                        UpHistoryStudentManagerFrm smf=new UpHistoryStudentManagerFrm();
                                        smf.setVisible(true);
                              }
                    });
                    button_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    button_2.setBounds(751, 347, 100, 27);
                    contentPane.add(button_2);
                    setTable(new Student());
          }
          protected String addSearch() {
                    return SearchDeptForStuFrm.getDeptName();
          }
          public Student getSelectObject(){
                    Student student,stuTmp;
                    StudentDao stDao=new StudentDao();
                    student=new Student();
                    student.setsNo(staticSno);
                    stuTmp=stDao.getSelectRowObject(student);
                    return stuTmp;
          }
		//수정 submit event
          protected void submiEditAct(ActionEvent ae) {
                    DefaultTableModel   dft = (DefaultTableModel) studentListTable.getModel();
                    String orgid;
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    String schYear=dft.getValueAt(row, 3).toString();
                    String inSchStatus = inSchStatusComboBox.getSelectedItem().toString();
                    String degreeProcess=dft.getValueAt(row, 5).toString();
                    String deptName1=textField_deptName.getText().toString();
                    orgid=this.getOrgidByOrgName(deptName1);
                    String major2,majorType;
                    try {
                              majorType=dft.getValueAt(row, 13).toString();
                    } catch (Exception e) {
                              majorType=null;
                    }
                    try {
                              major2=dft.getValueAt(row, 14).toString();
                    } catch (Exception e) {
                              major2=null;
                    }
                    Student student=new Student();
                    student.setOrgId(orgid);
                    student.setName(stuName);
                    student.setInSchYear(schYear);
                    student.setDeptName(deptName1);
                    student.setInSchState(inSchStatus);
                    student.setDegreeProcess(degreeProcess);
                    student.setsNo(sno);
                    student.setMajorType(majorType);
                    student.setMajor(major2);
//                    student.set
                    StudentDao stuDao=new StudentDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(stuDao.updateStudent(student)&&stuDao.AddUpdateHistory(student)){
                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                              }
                    }else{
                              return;
                    }
                    stuDao.closeDao();
                    setTable(new Student());
                    row=-1;
          }
          //Table중 행을 선택
          protected void selectedTableRow(MouseEvent me) {
                    // TODO Auto-generated method stub
                    DefaultTableModel   dft = (DefaultTableModel) studentListTable.getModel();
                    row=studentListTable.getSelectedRow();
                     sno=dft.getValueAt(row, 0).toString();
                     stuName=dft.getValueAt(row, 2).toString();
                     pw=dft.getValueAt(row, 8).toString();
                    //得到选中表格中的哪一行，那一列的值
                    selectIndex=studentListTable.getSelectedRow();
                    //학번
                    staticSno = studentListTable.getValueAt(selectIndex, 0).toString();
                    //소속학과
                    String orgName=dft.getValueAt(studentListTable.getSelectedRow(), 1).toString();
                    textField_deptName.setText(orgName);
                    //재학상태
                    String inSchStatus;
                    try {
                              inSchStatus=dft.getValueAt(studentListTable.getSelectedRow(), 4).toString();
                    } catch (Exception e) {
                              inSchStatus=null;
                    }
//                    System.out.println("1 "+inSchStatus);
                    try {
                              for(int i=0;i<inSchStatusComboBox.getItemCount();i++){
                                        if(inSchStatus.equals(isInSchool[i])){
//                                                  System.out.println("2 "+isInSchool[i]);
                                                  inSchStatusComboBox.setSelectedIndex(i);
                                        } 
                              }
                    } catch (Exception e) {
                              inSchStatusComboBox.setSelectedIndex(0);
                    }
//                    //학사과정
//                    String degree;
//                    try {
//                              degree=dft.getValueAt(studentListTable.getSelectedRow(), 14).toString();
//                    } catch (Exception e) {
//                              degree=null;
//                    }
//                    try {
//                              for(int i=0;i<degreeComboBox.getItemCount();i++){
//                                        if(degree.equals(degreeP[i])){
//                                                  degreeComboBox.setSelectedIndex(i);
//                                        } 
//                              }
//                    } catch (Exception e) {
//                              degreeComboBox.setSelectedIndex(0);
//                    }
                    
          }
//          //학생삭제
//          protected void deleteStudent(ActionEvent ae) {
//                    // TODO Auto-generated method stub
//                    setDeptName();
//                    int row=studentListTable.getSelectedRow();
//                    if(row==-1){
//                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
//                              return;
//                    }
//                    if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까？") != JOptionPane.OK_OPTION){
//                              return;
//                    }
//                    StudentDao studentDao =new StudentDao();
//                    String sNo=studentListTable.getValueAt(row, 0).toString();
//                    if(studentDao.delete(sNo)){
//                              JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
//                    }else{
//                              JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
//                    }
//                    studentDao.closeDao();
//                    setTable(new Student());
//                    restvalues();
//          }
          //학생 검색
          protected void searchStudent(ActionEvent ae) {
                    Student student=new Student();
                    String name = null,sno = null;
                    if(radioButton_1.isSelected()){
                              name=nameTextField.getText().toString();
                              if(StringUtil.isEmpty(name)){
                                        name=null;
                              }
                              sno=null;
                    }else{
                              sno=textField_no.getText().toString();
                              if(StringUtil.isEmpty(sno)){
                                        sno=null;
                              }
                              name=null;
                    }
                    student.setName(name);
                    student.setsNo(sno);
                    
                    int i=0;
                    String deptName=null,orgCode=null,string2,string1;
                    string1=textField_seaDeptName.getText().toString();//학과명
                    string2=this.getOrgidByOrgName(string1);//학과코드
                    
                    if(checkBox_3.isSelected()){
                              deptName=string1;
                              orgCode=string2;
                              student.setOrgId(orgCode);
                              student.setDeptName(deptName);
                    }
                    int row=studentListTable.getSelectedRow();
                    setTable(student);
                    restvalues();
                    row=-1;
          }
          private void restvalues() {
                          textField_deptName.setText("");
                          inSchStatusComboBox.setSelectedIndex(0);
          }
          // table다시 설정
          public void setTable(Student student){
                   DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
                   dft.setRowCount(0);
                   StudentDao studentDao=new StudentDao();
                   List<Student> studentList = studentDao.getStudentList(student);
                   for(Student s : studentList){
                             Vector v=new Vector();
                             v.add(s.getsNo());//0
                             v.add(this.getDeptNameById(s.getOrgId()));//1
                             v.add(s.getName());//2
                             v.add(s.getInSchYear());//3
                             v.add(s.getInSchState());//4
                             v.add(s.getDegreeProcess());//5
                             v.add(s.getIdCardNo());//6
                             v.add(s.getSex());//7
                             v.add(s.getPassword());//8
                             v.add(s.getEmail());//9
                             v.add(s.getTel());//10
                             v.add(s.getAdress());//11
                             v.add(s.getJoinDate());//12
                             v.add(s.getMajorType());//13
                             v.add(s.getMajor());//14
                             v.add(s.getApplyDate());//15
                             dft.addRow(v);
                   }
                   studentDao.closeDao();
                   
          }
//        //학과선택
//          protected void setDeptName() {
//                    // TODO Auto-generated method stub
//                    OrgDao orgDao=new OrgDao();
//                    
//                    for (Org org : orgList) {
//                              searchOrgComboBox.addItem(org);
//                    }
//                    orgDao.closeDao();
//          }
          //classId에 통해서 className를 받는다
          public String getDeptNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgdeptNameList(new Org());
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
}
