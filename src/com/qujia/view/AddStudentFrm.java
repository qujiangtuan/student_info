package com.qujia.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.OrgDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.SendEmailToSP;
import com.qujia.model.Student;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class AddStudentFrm extends JFrame {
          private JTextField studentNameTextField;
          private JRadioButton studentSexManRadioButton;
          private JRadioButton studentSexFemalRadioButton;
          private ButtonGroup sexButtonGroup;
          private JTextField identityTextField_1;
          private JTextField identityTextField_2;
          private JLabel emailLabel;
          private JTextField emailTextField;
          private JLabel lblNewLabel;
          private JTextField textField_tel2;
          private JTextField textField_address1;
          private JLabel label;
          private JTextField textField_deptName;
          private JButton btnNewButton;
          private static String deptNameFine;
          private JLabel lblNewLabel_2;
          private JComboBox comboBox_degree;
          private JComboBox email2comboBox;
          private JLabel label_ait;
          private JComboBox comboBox_tel1;
          private JTextField textField_tel3;
          private JLabel label_1;
          private JLabel label_2;
          private JButton btnNewButton_1;
          private JTextField textField_address2;
          private List<Org> orgList;
          
          
          public static String getDeptNameFine(String str) {
                    return deptNameFine=str;
          }

          public static void setDeptNameFine(String deptNameFine) {
                    AddStudentFrm.deptNameFine = deptNameFine;
          }

          public JTextField getTextField_deptName() {
                    return textField_deptName;
          }

          public void setTextField_deptName(JTextField textField_deptName) {
                    this.textField_deptName = textField_deptName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  AddStudentFrm frame = new AddStudentFrm();
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
          public AddStudentFrm() {
                    this.setResizable(false);
                    getContentPane().setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setTitle("학생등록");
                    setBounds(100, 50, 502, 496);
//                    setClosable(true);
//                    setIconifiable(true);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);

                    JLabel studentNameLabel = new JLabel("학생이름:");
                    studentNameLabel.setBounds(64, 36, 67, 19);
                    studentNameLabel.setIcon(null);
                    studentNameLabel.setFont(new Font("Dialog", Font.BOLD, 13));

                    studentNameTextField = new JTextField();
                    studentNameTextField.setBounds(141, 36, 235, 21);
                    studentNameTextField.setColumns(10);

                    JLabel studentClassLabel = new JLabel("소속조직:");
                    studentClassLabel.setBounds(64, 76, 67, 19);
                    studentClassLabel.setIcon(null);
                    studentClassLabel.setFont(new Font("Dialog", Font.BOLD, 13));

                    JLabel studentSexLabel = new JLabel(" 성    별 :");
                    studentSexLabel.setBounds(64, 117, 67, 19);
                    studentSexLabel.setIcon(null);
                    studentSexLabel.setFont(new Font("Dialog", Font.BOLD, 13));

                    JButton submitButton = new JButton("등   록");
                    submitButton.setBounds(144, 389, 88, 27);
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        studentAddAction(ae);
                              }
                    });
                    submitButton.setIcon(null);
                    submitButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    studentSexManRadioButton = new JRadioButton("남");
                    studentSexManRadioButton.setBounds(141, 116, 91, 23);
                    studentSexManRadioButton.setSelected(true);

                    studentSexFemalRadioButton = new JRadioButton("여");
                    studentSexFemalRadioButton.setBounds(257, 115, 81, 23);

                    sexButtonGroup = new ButtonGroup();
                    sexButtonGroup.add(studentSexManRadioButton);
                    sexButtonGroup.add(studentSexFemalRadioButton);
                    JButton cancelButton = new JButton("취  소");
                    cancelButton.setBounds(295, 389, 81, 27);
                    cancelButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
//                                        resetValue(ae);
//                                        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//                                        AddStudentFrm asf=new AddStudentFrm();
//                                        asf.dispatchEvent(new WindowEvent(asf,WindowEvent.WINDOW_CLOSING) );
//                                        asf.dispose();
                                        dispose();
//                                        try {
//                                                  asf.setClosed(true);
//                                        } catch (PropertyVetoException e) {
//                                                  // TODO Auto-generated catch block
//                                                  e.printStackTrace();
//                                        }
                              }
                    });
                    cancelButton.setIcon(null);
                    cancelButton.setFont(new Font("Dialog", Font.BOLD, 13));

                    JLabel identityLabel = new JLabel("주민등록번호:");
                    identityLabel.setBounds(34, 157, 98, 19);
                    identityLabel.setIcon(null);
                    identityLabel.setFont(new Font("Dialog", Font.BOLD, 13));

                    identityTextField_1 = new JTextField();
                    identityTextField_1.setBounds(142, 156, 110, 21);
                    identityTextField_1.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar = ke.getKeyChar();
                                        if (keyChar >= KeyEvent.VK_0
                                                            && keyChar <= KeyEvent.VK_9
                                                            || keyChar == KeyEvent.VK_BACK_SPACE
                                                            || keyChar == KeyEvent.VK_DELETE) {

                                        } else {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "숫자만 입력 가능합니다!");
                                                  return;
                                        }
                                        int len = identityTextField_1.getText()
                                                            .length();
                                        if (len > 5) {
                                                  ke.consume();
                                                  // JOptionPane.showMessageDialog(null,
                                                  // "6짜리 초과하면 안 됩니다!");
                                                  KeyboardFocusManager.getCurrentKeyboardFocusManager()
                                                                      .focusNextComponent();
                                                  return;
                                        }

                              }
                    });
                    identityTextField_1.setColumns(10);

                    identityTextField_2 = new JTextField();
                    identityTextField_2.setBounds(266, 156, 110, 21);
                    identityTextField_2.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar = ke.getKeyChar();
                                        if (keyChar >= KeyEvent.VK_0
                                                            && keyChar <= KeyEvent.VK_9
                                                            || keyChar == KeyEvent.VK_BACK_SPACE
                                                            || keyChar == KeyEvent.VK_DELETE) {

                                        } else {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "숫자만 입력 가능합니다!");
                                                  ke.consume();
                                                  return;
                                        }
                                        int len = identityTextField_2.getText()
                                                            .length();
                                        if (len > 6) {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "7자리 초과하면 안됩니다!");
                                                  ke.consume();
                                                  return;
                                        }
                              }
                    });
                    identityTextField_2.setColumns(10);

                    emailLabel = new JLabel("이메일:");
                    emailLabel.setBounds(64, 238, 67, 19);
                    emailLabel.setIcon(null);
                    emailLabel.setFont(new Font("Dialog", Font.BOLD, 13));

                    emailTextField = new JTextField();
                    emailTextField.setBounds(141, 238, 110, 21);
                    emailTextField.setColumns(10);
                    //注释下列一行才能打开 界面编辑
                    //datePicker = getDatePicker();
                    lblNewLabel = new JLabel("연락처:");
                    lblNewLabel.setBounds(64, 278, 68, 16);
                    lblNewLabel.setFont(new Font("휴먼명조", Font.BOLD, 13));

                    textField_tel2 = new JTextField();
                    textField_tel2.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar = ke.getKeyChar();
                                        if (keyChar >= KeyEvent.VK_0
                                                            && keyChar <= KeyEvent.VK_9
                                                            || keyChar == KeyEvent.VK_BACK_SPACE
                                                            || keyChar == KeyEvent.VK_DELETE) {

                                        } else {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "숫자만 입력 가능합니다!");
                                                  return;
                                        }
                                        int len = textField_tel2.getText()
                                                            .length();
                                        if (len > 3) {
                                                  ke.consume();
                                                  // JOptionPane.showMessageDialog(null,
                                                  // "6짜리 초과하면 안 됩니다!");
                                                  KeyboardFocusManager.getCurrentKeyboardFocusManager()
                                                                      .focusNextComponent();
                                                  return;
                                        }
                              }
                    });
                    textField_tel2.setBounds(222, 276, 56, 21);
                    textField_tel2.setColumns(10);

                    JLabel lblNewLabel_1 = new JLabel("주소:");
                    lblNewLabel_1.setBounds(76, 318, 56, 16);
                    lblNewLabel_1.setFont(new Font("휴먼명조", Font.BOLD, 13));

                    textField_address1 = new JTextField();
                    textField_address1.setBounds(141, 316, 235, 21);
                    textField_address1.setColumns(10);
                    
                    label = new JLabel("-");
                    label.setBounds(254, 159, 13, 15);
                    
                    textField_deptName = new JTextField();
                    textField_deptName.setEditable(false);
                    textField_deptName.setBounds(141, 76, 235, 21);
                    textField_deptName.setColumns(10);
                    btnNewButton = new JButton("조회");
                    btnNewButton.setBounds(386, 74, 62, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchDeptForStuFrm sdf=new SearchDeptForStuFrm(new JFrame());
                                        sdf.setVisible(true);
                                        textField_deptName.setText(addSearch());
                              }
                    });
                    
                    lblNewLabel_2 = new JLabel("학위과정:");
                    lblNewLabel_2.setBounds(50, 197, 81, 19);
                    lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    comboBox_degree = new JComboBox();
                    comboBox_degree.setBounds(141, 195, 235, 25);
                    comboBox_degree.setFont(new Font("Dialog", Font.BOLD, 13));
                    comboBox_degree.setModel(new DefaultComboBoxModel(new String[] {"학사과정", "석사과정", "박사과정"}));
                    
                    email2comboBox = new JComboBox();
                    email2comboBox.setBounds(272, 238, 104, 21);
                    email2comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "pukyong.ac.kr", "hanmail.com", "hanmail.net", "daum.net", "kornet.net", "korea.com", "hanafos.com", "yahoo.com.kr", "qq.com", "163.com"}));
                    email2comboBox.setEditable(true);
                    
                    label_ait = new JLabel("@");
                    label_ait.setBounds(254, 239, 13, 19);
                    label_ait.setFont(new Font("Dialog", Font.BOLD, 13));
                    getContentPane().setLayout(null);
                    getContentPane().add(email2comboBox);
                    getContentPane().add(label_ait);
                    getContentPane().add(submitButton);
                    getContentPane().add(cancelButton);
                    getContentPane().add(identityLabel);
                    getContentPane().add(studentSexLabel);
                    getContentPane().add(studentClassLabel);
                    getContentPane().add(studentNameLabel);
                    getContentPane().add(emailLabel);
                    getContentPane().add(lblNewLabel_1);
                    getContentPane().add(lblNewLabel);
                    getContentPane().add(lblNewLabel_2);
                    getContentPane().add(textField_address1);
                    getContentPane().add(textField_tel2);
                    getContentPane().add(comboBox_degree);
                    getContentPane().add(studentNameTextField);
                    getContentPane().add(textField_deptName);
                    getContentPane().add(btnNewButton);
                    getContentPane().add(emailTextField);
                    getContentPane().add(identityTextField_1);
                    getContentPane().add(label);
                    getContentPane().add(studentSexManRadioButton);
                    getContentPane().add(studentSexFemalRadioButton);
                    getContentPane().add(identityTextField_2);
                    
                    comboBox_tel1 = new JComboBox();
                    comboBox_tel1.setModel(new DefaultComboBoxModel(new String[] {"010", "02", "032", "062", "051", "053", "042", "052", "031", "033", "043", "041", "063", "061", "054", "055", "064"}));
                    comboBox_tel1.setBounds(141, 276, 67, 21);
                    getContentPane().add(comboBox_tel1);
                    
                    textField_tel3 = new JTextField();
                    textField_tel3.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar = ke.getKeyChar();
                                        if (keyChar >= KeyEvent.VK_0
                                                            && keyChar <= KeyEvent.VK_9
                                                            || keyChar == KeyEvent.VK_BACK_SPACE
                                                            || keyChar == KeyEvent.VK_DELETE) {

                                        } else {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "숫자만 입력 가능합니다!");
                                                  ke.consume();
                                                  return;
                                        }
                                        int len = textField_tel3.getText()
                                                            .length();
                                        if (len > 3) {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(
                                                                      null,
                                                                      "4자리 초과하면 안됩니다!");
                                                  ke.consume();
                                                  return;
                                        }
                              }
                    });
                    textField_tel3.setColumns(10);
                    textField_tel3.setBounds(288, 276, 88, 21);
                    getContentPane().add(textField_tel3);
                    
                    label_1 = new JLabel("-");
                    label_1.setBounds(211, 279, 8, 15);
                    getContentPane().add(label_1);
                    
                    label_2 = new JLabel("-");
                    label_2.setBounds(279, 279, 8, 15);
                    getContentPane().add(label_2);
                    
                    btnNewButton_1 = new JButton("조회");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        SearchAddressFrm saf=new SearchAddressFrm(new JFrame());
                                        saf.setVisible(true);
                                        textField_address1.setText(addSearchAddress());
                              }
                    });
                    btnNewButton_1.setBounds(386, 314, 62, 23);
                    getContentPane().add(btnNewButton_1);
                    
                    textField_address2 = new JTextField();
                    textField_address2.setBounds(141, 347, 235, 21);
                    getContentPane().add(textField_address2);
                    textField_address2.setColumns(10);
//                    setDeptName();
          }

          protected String addSearchAddress() {
//                    SearchAddressFrm saf=new SearchAddressFrm(new JFrame());
                    return SearchAddressFrm.getSearchAddr();
          }

          // 添加学生，确认提交
          protected void studentAddAction(ActionEvent ae) {
                    
                    // TODO Auto-generated method stub
                    String studentName = studentNameTextField.getText()
                                        .toString();
                    if (StringUtil.isEmpty(studentName)) {
                              JOptionPane.showMessageDialog(this,
                                                  "학생 이름을 입력하십시오！");
                              return;
                    }
                    String idCardNo_1 = identityTextField_1.getText()
                                        .toString();
                    String idCardNo_2 = identityTextField_2.getText()
                                        .toString();
                    String idCardNo = idCardNo_1 + "-" + idCardNo_2;

                    String joinDate = DateUtil.getTodayDate();
                    //이메일
                    String email1=emailTextField.getText().toString();
                    String label=label_ait.getText().toString();
                    String email2 = email2comboBox.getSelectedItem().toString();
                    String email=email1+label+email2;
                    
                    String deptName=textField_deptName.getText().toString();
//                    String orgid=SearchDeptForStuFrm.getOrdId();//조직코드
                    String orgid=this.getOrgidByOrgName(deptName);
//                    System.out.println("orgid="+orgid);
//                    Org org1,org2;
//                    org1=new Org();
//                    org1.setOrgCode(orgid);
//                    OrgDao orgDao=new OrgDao();
//                    org2=orgDao.getSearchDept(org1);
//                    String col=org2.getCoGrCode();
//                    System.out.println("col="+col);
                    
                    String degreeProcess;//학사과정
                    degreeProcess = comboBox_degree.getSelectedItem().toString();
                    
                    String inSchYear=getSchYear(joinDate);//학년
                    
                    String sNo;//학번종복학인
                    sNo = getStudentNumber(joinDate,orgid);
                    if (StringUtil.isEmpty(orgid)) {
                              JOptionPane.showMessageDialog(this,
                                                  "소속학과를 입력하십시오！");
                              return;
                    }
                    while(this.isRepeat(sNo)){
                            //학번종복학인
                              sNo = getStudentNumber(joinDate,orgid);
                    }
                    String sex = studentSexManRadioButton.isSelected() ? studentSexManRadioButton
                                        .getText() : studentSexFemalRadioButton
                                        .getText();
                    String passWord = identityTextField_1.getText().toString();
                    //전화번호
                    String tel1=comboBox_tel1.getSelectedItem().toString();
                    String tel2=textField_tel2.getText().toString();
                    String tel3=textField_tel3.getText().toString();
                    String tel=tel1+tel2+tel3;
                    //주소
                    String address1=textField_address1.getText().toString();
                    String address2;
                    try {
                              address2=textField_address2.getText().toString();
                    } catch (Exception e) {
                              address2="";
                    }
                    String address=address1+address2;
                    if (StringUtil.isEmpty(idCardNo_1)||StringUtil.isEmpty(idCardNo_2)) {
                              JOptionPane.showMessageDialog(this,
                                                  "주민등록번호를 입력하십시오！");
                              return;
                    }
                    
                    if (StringUtil.isEmpty(joinDate)) {
                              JOptionPane.showMessageDialog(this,
                                                  "입학일짜을 입력하십시오！");
                              return;
                    }
                    if (StringUtil.isEmpty(email1)||StringUtil.isEmpty(email2)) {
                              JOptionPane.showMessageDialog(this,
                                                  "이메일을 입력하십시오！");
                              return;
                    }
                    if (StringUtil.isEmpty(tel1)||StringUtil.isEmpty(tel1)) {
                              JOptionPane.showMessageDialog(this,
                                                  "전화번호를 입력하십시오！");
                              return;
                    }
                    if (StringUtil.isEmpty(address1)) {
                              JOptionPane.showMessageDialog(this,
                                                  "주소를 입력하십시오！");
                              return;
                    }
                    
                    
                    Student student = new Student();
                    student.setsNo(sNo);
                    student.setName(studentName);
                    student.setOrgId(orgid);
                    student.setPassword(passWord);
                    student.setSex(sex);
                    student.setIdCardNo(idCardNo);
                    student.setJoinDate(joinDate);
                    student.setEmail(email);
                    student.setTel(tel);
                    student.setAdress(address);
                    student.setDegreeProcess(degreeProcess);
                    student.setInSchYear(inSchYear);
                    student.setDeptName(deptName);
                    //System.out.println(student);
                    StudentDao studentDao = new StudentDao();
                    if (studentDao.addStudent(student)) {
                            //id,password 학생의 이메일에 보내기
                              try {
                                        new SendEmailToSP(sNo,passWord, email);
                              } catch (Exception e) {
//                                        if(JOptionPane.showConfirmDialog(this, "이메일주소가 무효입니다, 다시입력하시겠습니까？예:다시입력하기 아니요:건너가기") != JOptionPane.OK_OPTION){
//                                                return;
//                                        }
                              }
                              JOptionPane.showMessageDialog(this,
                                                  "학생을 등록했습니다! ");
                    } else {
                              JOptionPane.showMessageDialog(this,
                                                  "학생등록을 실패했습니다！");
                    }
                    resetValue(ae);
                    studentDao.closeDao();
          }
          //학년 
          public String getSchYear(String str) {
                    String str1= str.substring(0, 4);
                    String str2=DateUtil.getThisYear();
//                    System.out.println("str2="+str2);
                    
                    int maxYear=Integer.parseInt(str2);
                    int minYear=Integer.parseInt(str1);
                    int year=maxYear-minYear;
                    String str3;
                    str3=year+1+"";
//                    System.out.println("str3="+str3);
                    return str3;
          }
          // 获取学生id
          public String getStudentNumber(String str1,String string) {
                    String str = str1.substring(0, 4);
                    String str2;
                    str2=string.substring(3, 5);
                    String sNo = str + str2 + getRandom();
                    return sNo;
          }
          //학생번호 종복학인
          private boolean isRepeat(String str){
                  Student st=new Student();
                  StudentDao stDao=new StudentDao();
                  List<Student> stList = stDao.getStudentList(st);
                  List<String> stNoList = new ArrayList<String>();
                  for (Student stNo2 : stList) {
                            String string1=stNo2.getsNo();
                            stNoList.add(string1);
                  }
                  if(!stNoList.contains(str)){
                            return false;
                  }else{
                            return true;
                  }
        }
//          public String getStudentNumber(String string) {
//                    String str = string.substring(0, 4);
//                    int no = Integer.parseInt(str) + 4;
//                    String str2 = String.valueOf(no);
//                    String str3 = str2.substring(str2.length() - 2);
//                    String sNo = str + String.valueOf(str3) + getRandom();
//
//                    return sNo;
//          }

          // 获取一个随机产生的三位数（001,001）
          public String getRandom() {
                    String threeNumber;
                    Random random = new Random();
                    int i = random.nextInt(1000);
                    String str = i + "";
                    if (i >= 0 && i <= 9) {
                              threeNumber = "00" + str;
                    } else if (i >= 10 && i <= 99) {
                              threeNumber = "0" + str;
                    } else {
                              threeNumber = str;
                    }
                    return threeNumber;
          }
//          //학과 받기
//          protected void setDeptName() {
//                    // TODO Auto-generated method stub
//                    OrgDao orgDao=new OrgDao();
//                    List<Org> orgList=orgDao.getOrgdeptNameList(new Org());
//                    for (Org org: orgList) {
//                              orgComboBox.addItem(org);
//                    }
//                    orgDao.closeDao();
//          }

          // 添加学生的重置按钮事件
          protected void resetValue(ActionEvent ae) {
                    studentNameTextField.setText("");
                    sexButtonGroup.clearSelection();
                    studentSexManRadioButton.setSelected(true);
                    identityTextField_1.setText("");
                    identityTextField_2.setText("");
                    emailTextField.setText("");
                    comboBox_tel1.setSelectedIndex(0);
                    textField_tel2.setText("");
                    textField_tel3.setText("");
                    textField_address1.setText("");
                    textField_deptName.setText("");
                    email2comboBox.setSelectedIndex(0);
                    textField_address2.setText("");
                    
          }

          // 数据库中获取日期
          public String getStringDate(DatePicker datepick) {
                    String stringDate;
                    SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
                    Date date;
                    if(datepick.getValue()==null){
                              date=new Date();
                    }else{
                              date = (Date) datepick.getValue();
                    }
                    stringDate = form.format(date);
                    return stringDate;
          }

          // 表单中获取日期格式"yyyy-MM-dd"
          public static DatePicker getDatePicker() {
                    final DatePicker datepick;
                    // 格式
                    String DefaultFormat = "yyyy-MM-dd";
                    // 当前时间
                    Date date = new Date();
                    // 字体
                    Font font = new Font("Times New Roman", Font.BOLD, 14);
                    Dimension dimension = new Dimension(177, 24);

                    // 构造方法（初始时间，时间显示格式，字体，控件大小）
                    datepick = new DatePicker(date, DefaultFormat, font,
                                        dimension);
                    datepick.setTimePanleVisible(true);
                    return datepick;
          }
          public String addSearch(){
                     
//                    return AddStudentFrm.deptNameFine;
                    return SearchDeptForStuFrm.getDeptName();
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
