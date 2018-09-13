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
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.ClassDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Student;
import com.qujia.model.StudentClass;
import com.qujia.util.StringUtil;

public class AddStudentFrm extends JInternalFrame {
          private JTextField studentNameTextField;
          private JRadioButton studentSexManRadioButton;
          private JRadioButton studentSexFemalRadioButton;
          private ButtonGroup sexButtonGroup;
          private JComboBox studentClassComboBox;
          private JTextField identityTextField_1;
          private JTextField identityTextField_2;
          private JLabel emailLabel;
          private JTextField emailTextField;
          private DatePicker datePicker;
          private JLabel lblNewLabel;
          private JTextField textField;
          private JTextField textField_1;
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
                    getContentPane().setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    setTitle("학생등록");
                    setBounds(100, 50, 485, 462);
                    setClosable(true);
                    setIconifiable(true);
                   
//                    this.add
                   
                    
                    JLabel studentNameLabel = new JLabel("학생이름:");
                    studentNameLabel.setIcon(null);
                    studentNameLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    studentNameTextField = new JTextField();
                    studentNameTextField.setColumns(10);
                    
                    JLabel studentClassLabel = new JLabel("소속학과:");
                    studentClassLabel.setIcon(null);
                    studentClassLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    studentClassComboBox = new JComboBox();
                    
                    JLabel studentSexLabel = new JLabel(" 성    별 :");
                    studentSexLabel.setIcon(null);
                    studentSexLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton submitButton = new JButton("학  인");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        studentAddAction(ae);
                              }
                    });
                    submitButton.setIcon(null);
                    submitButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    studentSexManRadioButton = new JRadioButton("남");
                    studentSexManRadioButton.setSelected(true);
                    
                    studentSexFemalRadioButton = new JRadioButton("여");
                    
                    sexButtonGroup =new ButtonGroup();
                    sexButtonGroup.add(studentSexManRadioButton);
                    sexButtonGroup.add(studentSexFemalRadioButton);
                    JButton resetButton = new JButton("취  소");
                    resetButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        resetValue(ae);
                              }
                    });
                    resetButton.setIcon(null);
                    resetButton.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JLabel identityLabel = new JLabel("주민등록번호:");
                    identityLabel.setIcon(null);
                    identityLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    identityTextField_1 = new JTextField();
                    identityTextField_1.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar=ke.getKeyChar();
                                        if(keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 
                                                            ||keyChar==KeyEvent.VK_BACK_SPACE 
                                                            ||keyChar==KeyEvent.VK_DELETE){
                                                  
                                        }else{
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(null, "숫자 입력해주세요!");
                                                  return;
                                        }
                                        int len=identityTextField_1.getText().length();
                                        if(len>5) {
                                                  ke.consume();
                                                  //JOptionPane.showMessageDialog(null, "6짜리 초과하면 안 됩니다!");
                                                  KeyboardFocusManager.
                                                  getCurrentKeyboardFocusManager().focusNextComponent();
                                                  return;
                                        }
                                                  
                              }
                    });
                    identityTextField_1.setColumns(10);
                    
                    identityTextField_2 = new JTextField();
                    identityTextField_2.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyTyped(KeyEvent ke) {
                                        int keyChar=ke.getKeyChar();
                                        if(keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9 
                                                            ||keyChar==KeyEvent.VK_BACK_SPACE 
                                                            ||keyChar==KeyEvent.VK_DELETE){
                                                  
                                        }else{
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(null, "숫자 입력해주세요!");
                                                  ke.consume();
                                                  return;
                                        }
                                       int len=identityTextField_2.getText().length();
                                        if(len>6) {
                                                  ke.consume();
                                                  JOptionPane.showMessageDialog(null, "7짜리 초과하면 안 됩니다!");
                                                  ke.consume();
                                                  return;
                                        }
                              }
                    });
                    identityTextField_2.setColumns(10);
                    
                    JLabel joinDateLabel = new JLabel("입학일자:");
                    joinDateLabel.setIcon(null);
                    joinDateLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    
                    emailLabel = new JLabel("이메일:");
                    emailLabel.setIcon(null);
                    emailLabel.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    emailTextField = new JTextField();
                    emailTextField.setColumns(10);
                    
                    
                    datePicker = new DatePicker();
                    
                    lblNewLabel = new JLabel("전화번호:");
                    lblNewLabel.setFont(new Font("휴먼명조", Font.BOLD, 13));
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("집주소:");
                    lblNewLabel_1.setFont(new Font("휴먼명조", Font.BOLD, 13));
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                 //  datePicker=getDatePicker();
                    //datepick.setColumns(10);
                    GroupLayout groupLayout = new GroupLayout(getContentPane());
                    groupLayout.setHorizontalGroup(
                              groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGap(121)
                                                                      .addComponent(submitButton)
                                                                      .addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                                                      .addComponent(resetButton))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGap(65)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(identityLabel)
                                                                                .addComponent(studentSexLabel)
                                                                                .addComponent(joinDateLabel)
                                                                                .addComponent(studentClassLabel)
                                                                                .addComponent(studentNameLabel)
                                                                                .addComponent(emailLabel)
                                                                                .addComponent(lblNewLabel)
                                                                                .addComponent(lblNewLabel_1))
                                                                      .addGap(18)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                                                                .addComponent(studentNameTextField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addComponent(studentSexManRadioButton)
                                                                                          .addGap(18)
                                                                                          .addComponent(studentSexFemalRadioButton))
                                                                                .addComponent(studentClassComboBox, 0, 160, Short.MAX_VALUE)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addComponent(identityTextField_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(identityTextField_2, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                                                                                .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                                                .addComponent(datePicker, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(textField, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))))
                                                  .addGap(137))
                    );
                    groupLayout.setVerticalGroup(
                              groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGap(36)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(studentNameLabel))
                                                  .addGap(18)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(studentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(studentClassLabel))
                                                  .addGap(18)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(studentSexManRadioButton)
                                                            .addComponent(studentSexFemalRadioButton)
                                                            .addComponent(studentSexLabel))
                                                  .addGap(17)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(identityLabel)
                                                            .addComponent(identityTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(identityTextField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(joinDateLabel)
                                                            .addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(13)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(emailLabel))
                                                  .addGap(18)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(18)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(52)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(resetButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                  .addGap(38))
                    );
                    getContentPane().setLayout(groupLayout);
                    setStudentClassInfo();
                    
                    
          }
         
          //添加学生，确认提交
          protected void studentAddAction(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    String studentName=studentNameTextField.getText().toString();
                    
                    String idCardNo_1=identityTextField_1.getText().toString();
                    String idCardNo_2=identityTextField_2.getText().toString();
                    String idCardNo=idCardNo_1+"-"+idCardNo_2;
                    
                    String joinDate=getStringDate(datePicker);
                    //System.out.println(joinDate);
                    String email=emailTextField.getText().toString();
                    
                    String sNo=getStudentNumber(joinDate);
                    if(StringUtil.isEmpty(studentName)){
                              JOptionPane.showMessageDialog(this, "학생 이름을 입력하십시오！");
                              return;
                    }
                    if(StringUtil.isEmpty(idCardNo)){
                              JOptionPane.showMessageDialog(this, "주민등록번호를 입력하십시오！");
                              return;
                    }
                    if(StringUtil.isEmpty(joinDate)){
                              JOptionPane.showMessageDialog(this, "입학일짜을 입력하십시오！");
                              return;
                    }
                    if(StringUtil.isEmpty(email)){
                              JOptionPane.showMessageDialog(this, "이메일을 입력하십시오！");
                              return;
                    }
                    StudentClass sc=(StudentClass) studentClassComboBox.getSelectedItem();
                    String sex=studentSexManRadioButton.isSelected() ? studentSexManRadioButton.getText() : 
                              studentSexFemalRadioButton.getText();
                    String passWord=identityTextField_1.getText().toString();
                    
                    Student student=new Student();
                    student.setsNo(sNo);
                    student.setName(studentName);
                    student.setClassId(sc.getId());
                    student.setPassword(passWord);
                    student.setSex(sex);
                    student.setIdCardNo(idCardNo);
                    student.setJoinDate(joinDate);
                    student.setEmail(email);
                    StudentDao studentDao=new StudentDao();
                    if(studentDao.addStudent(student)){
                              JOptionPane.showMessageDialog(this, "학생이 성공적으로 추가되었습니다! ");
                    }else{
                              JOptionPane.showMessageDialog(this, "학생 추가에 실패했습니다！");
                    }
                    resetValue(ae);
                    studentDao.closeDao();
          }
          //获取学生id
          public String getStudentNumber(String string){
                    String str=string.substring(0,4);
                    //System.out.println(str);
                    int no=Integer.parseInt(str)+4;
                    String str2=String.valueOf(no);
                    String str3=str2.substring(str2.length()-2);
                    String sNo=str+String.valueOf(str3)+getRandom();
                   
                    return sNo;
          }
          //获取一个随机产生的三位数（001,001）
          public String getRandom(){
                    String threeNumber;
                    Random random=new Random();
                    int i=random.nextInt(1000);
                    String str=i+""; 
                    if(i>=0&&i<=9){
                              threeNumber="00"+str;
                    }else if(i>=10&&i<=99){
                              threeNumber="0"+str;
                    }else{
                              threeNumber=str;
                    }
                    return threeNumber;
          }
          //班级选择事件
          protected void setStudentClassInfo() {
                    // TODO Auto-generated method stub
                    ClassDao classDao=new ClassDao();
                    List<StudentClass> classList=classDao.getClassList(new StudentClass());
                    for (StudentClass sc : classList) {
                              studentClassComboBox.addItem(sc);
                    }
                    classDao.closeDao();
          }
          //添加学生的重置按钮事件
          protected void resetValue(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    studentNameTextField.setText("");
                    //studentPasswordField.setText("");
                    studentClassComboBox.setSelectedIndex(0);
                    sexButtonGroup.clearSelection();
                    studentSexManRadioButton.setSelected(true);
                    identityTextField_1.setText("");
                    identityTextField_2.setText("");
                    //datePicker=getDatePicker();
                    emailTextField.setText("");
                    
          }
          //数据库中获取日期
          public String getStringDate(DatePicker datepick ){
                    String stringDate;
                    SimpleDateFormat  form=new SimpleDateFormat("yyyy-mm-dd");
                    Date date = (Date) datepick.getValue();
                    stringDate=form.format(date);
                    return stringDate;
          }
          //表单中获取日期格式"yyyy-MM-dd"
          public static DatePicker getDatePicker() {
                    final DatePicker datepick;
                    // 格式
                    String DefaultFormat = "yyyy-MM-dd";
                    // 当前时间
                    Date date = new Date();
                    // 字体
                    Font font = new Font("Times New Roman", Font.BOLD, 14);
                    Dimension dimension = new Dimension(177, 24);
 
                //构造方法（初始时间，时间显示格式，字体，控件大小）
                    datepick = new DatePicker(date, DefaultFormat, font, dimension);
                    datepick.setTimePanleVisible(true);
                    return datepick;
                }
}
