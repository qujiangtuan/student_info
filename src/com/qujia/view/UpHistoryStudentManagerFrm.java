package com.qujia.view;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.Org;
import com.qujia.model.Student;
import com.qujia.util.ViewUtil;

public class UpHistoryStudentManagerFrm extends JFrame {
          private JTable studentListTable;
//          private List<StudentClass> studentClassList;
          private List<Org> orgList;
          private ButtonGroup editSexButtonGroup;
          private  ButtonGroup bg;
          private static int selectIndex;
          private String isInSchool[];
          private String degreeP[];
          private static String staticSno;
          private JPanel contentPane;
          private JButton button_1;
          private JLabel label_stuName;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  UpHistoryStudentManagerFrm frame = new UpHistoryStudentManagerFrm();
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
          public UpHistoryStudentManagerFrm() {
//                    setFrameIcon(new ImageIcon(StudentManagerFrm.class.getResource("/images/studentManager.png")));
//                    setClosable(true);
                    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    setIconifiable(true);
                    setTitle("학생목록");
                    setBounds(2, 5, 956, 426);
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
                    
                    JScrollPane scrollPane =  new JScrollPane();
                    scrollPane.setBounds(12, 83, 933, 240);
                    
                    editSexButtonGroup=new ButtonGroup();
                    bg=new ButtonGroup();
                    
                    isInSchool=new String[] {"","재학", "휴학", "졸업", "자퇴", "퇴학"};
                    
                    
                    
                    studentListTable = new JTable();
                    studentListTable.setRowHeight(25);
                    studentListTable.setFont(new Font("나눔명조", Font.BOLD, 13));
                    studentListTable.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uBC88", "\uC18C\uC18D\uD559\uACFC", "\uC774\uB984", "\uD559\uB144", "\uC7AC\uD559\uC0C1\uD0DC", "\uD559\uC704\uACFC\uC815", "\uCD94\uAC00\uC804\uACF5\uAD6C\uBD84", "\uCD94\uAC00\uC804\uACF5\uC774\uB984", "\uBCC0\uACBD\uB0A0\uC790"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    studentListTable.getColumnModel().getColumn(1).setPreferredWidth(141);
                    studentListTable.getColumnModel().getColumn(6).setPreferredWidth(94);
                    studentListTable.getColumnModel().getColumn(7).setPreferredWidth(129);
                    studentListTable.getColumnModel().getColumn(8).setPreferredWidth(198);
                    scrollPane.setViewportView(studentListTable);
                    //set TABLE data in center
                    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
                    cr.setHorizontalAlignment(JLabel.CENTER);
                    studentListTable.setDefaultRenderer(Object.class, cr);
                    studentListTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    getContentPane().add(searchStudentNameLabel);
                    getContentPane().add(scrollPane);
                    
                    button_1 = new JButton("닫기");
                    button_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                                        StudentManagerFrm.setRow(-1);
                              }
                    });
                    button_1.setFont(new Font("Dialog", Font.BOLD, 13));
                    button_1.setBounds(834, 347, 89, 27);
                    contentPane.add(button_1);
                    
                    label_stuName = new JLabel("강단");
                    label_stuName.setText(StudentManagerFrm.getStuName());
                    label_stuName.setFont(new Font("Dialog", Font.BOLD, 13));
                    label_stuName.setBounds(122, 28, 256, 26);
                    contentPane.add(label_stuName);
//                    Student student =(Student) MainFrm.userObject;
//                    StudentDao stuDao=new StudentDao();
//                    Student stuTemp=stuDao.login(student);
                    String sno=StudentManagerFrm.getSno();
                    Student stu=new Student();
                    stu.setsNo(sno);
                    setTable(stu);
          }
          // table다시 설정
          public void setTable(Student student){
                   DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
                   dft.setRowCount(0);
                   StudentDao studentDao=new StudentDao();
                   List<Student> studentList = studentDao.getStudentHisList(student);
                   for(Student s : studentList){
                             Vector v=new Vector();
                             v.add(s.getsNo());//0
                             v.add(s.getDeptName());//1
                             v.add(s.getName());//2
                             v.add(s.getInSchYear());//3
                             v.add(s.getInSchState());//4
                             v.add(s.getDegreeProcess());//5
                             v.add(s.getMajorType());//7
                             v.add(s.getMajor());//8
                             v.add(s.getJoinDate());//6
                             dft.addRow(v);
                   }
                   studentDao.closeDao();
                   
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
