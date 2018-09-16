package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qujia.model.UserType;

public class MainFrm extends JFrame {

          private JPanel contentPane;
          public static UserType userType;//登陆的用户类型
          public static Object userObject;//用于哪个用户登陆
          private CardLayout card;
          private JDesktopPane desktopPane;
          private JLayeredPane layeredPane;
          /**
           * Launch the application.
           */
          




          /**
           * Create the frame.
           */
          public MainFrm(UserType userType,Object userObject) {
                    this.userType=userType;
                    this.userObject=userObject;
                    
                    setTitle("학사관리시스템");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 992, 659);
                    
                    JMenuBar menuBar = new JMenuBar();
                    setJMenuBar(menuBar);
                    
                    JMenu systemManagerMenu = new JMenu("시스템");
                    systemManagerMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/system.png")));
                    systemManagerMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    menuBar.add(systemManagerMenu);
                    
                    JMenu managerStudentMenu = new JMenu("학생관리");
                    managerStudentMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentManager.png")));
                    managerStudentMenu.setFont(new Font("나눔명조", Font.BOLD, 13));
                    systemManagerMenu.add(managerStudentMenu);
                    
                    JMenuItem studentAddMenuItem = new JMenuItem("학생등록");
                    studentAddMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
                    studentAddMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        addStudent(ae);
                              }
                    });
                    studentAddMenuItem.setFont(new Font("나눔명조", Font.BOLD, 13));
                    managerStudentMenu.add(studentAddMenuItem);
                    
                    JMenuItem studentListMenuItem = new JMenuItem("학생리스트");
                    studentListMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentList.png")));
                    studentListMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        StudentManagerFrm studentManagerFrm=new StudentManagerFrm();
                                        layeredPane.setLayer(studentManagerFrm, 200);
                                        studentManagerFrm.setVisible(true);
                                        desktopPane.add(studentManagerFrm);
                              }
                    });
                    studentListMenuItem.setFont(new Font("나눔명조", Font.BOLD, 13));
                    managerStudentMenu.add(studentListMenuItem);
                    
                    JMenu mnNewMenu_1 = new JMenu("교원관리");
                    mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/teacher.png")));
                    mnNewMenu_1.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    systemManagerMenu.add(mnNewMenu_1);
                    
                    JMenuItem menuItem = new JMenuItem("교원등록");
                    menuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        AddProFrm apf=new AddProFrm();
                                        layeredPane.setLayer(apf, 200);
                                        apf.setVisible(true);
                                        //desktopPane.add(apf);
                              }
                    });
                    menuItem.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
                    mnNewMenu_1.add(menuItem);
                    
                    JMenuItem menuItem_1 = new JMenuItem("교원리스트");
                    menuItem_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ProManagerFrm pmf=new ProManagerFrm ();
                                        layeredPane.setLayer(pmf, 200);
                                        pmf.setVisible(true);
                                        //desktopPane.add(pmf);
                              }
                    });
                    menuItem_1.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentList.png")));
                    mnNewMenu_1.add(menuItem_1);
                    
                    JMenu mnNewMenu_3 = new JMenu("수강관리");
                    mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/scoreManager.png")));
                    mnNewMenu_3.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    systemManagerMenu.add(mnNewMenu_3);
                    
                    JMenuItem menuItemAddCourse = new JMenuItem("수강등록");
                    menuItemAddCourse.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        
                              }
                    });
                    
                    JMenuItem menuItemSubject = new JMenuItem("교과목관리");
                    menuItemSubject.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItemSubject);
                    menuItemAddCourse.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItemAddCourse);
                    
                    JMenuItem menuItemManagerCourse = new JMenuItem("수강관리");
                    menuItemManagerCourse.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItemManagerCourse);
                    
                    JMenu menuClassRoom = new JMenu("강의실관리");
                    menuClassRoom.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuClassRoom);
                    
                    JMenuItem menuItemAddClassRoom = new JMenuItem("강의실등록");
                    menuItemAddClassRoom.setFont(new Font("Dialog", Font.BOLD, 13));
                    menuClassRoom.add(menuItemAddClassRoom);
                    
                    JMenuItem menuItemManClassRoom = new JMenuItem("강의실관리");
                    menuItemManClassRoom.setFont(new Font("Dialog", Font.BOLD, 13));
                    menuClassRoom.add(menuItemManClassRoom);
                    
                    JMenu orgManagerMenu = new JMenu("조직관리");
                    orgManagerMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/college.png")));
                    orgManagerMenu.setFont(new Font("나눔명조", Font.BOLD, 13));
                    systemManagerMenu.add(orgManagerMenu);
                    
                    JMenu collegeMenu = new JMenu("대학(학부)");
                    collegeMenu.setFont(new Font("나눔명조", Font.BOLD, 13));
                    orgManagerMenu.add(collegeMenu);
                    
                    JMenu majorMenu = new JMenu("학과(전공)");
                    majorMenu.setFont(new Font("나눔명조", Font.BOLD, 13));
                    collegeMenu.add(majorMenu);
                    
                    JMenuItem majorAddMenuItem = new JMenuItem("학과(전공)추가");
                    majorAddMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        addDept(ae);
                              }
                    });
                    majorAddMenuItem.setFont(new Font("나눔명조", Font.BOLD, 13));
                    majorMenu.add(majorAddMenuItem);
                    
                    JMenuItem majorManagerMenuItem = new JMenuItem("학과(전공)관리");
                    majorManagerMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent  e) {
                                        DeptManagerFrm dmf=new DeptManagerFrm();
                                        layeredPane.setLayer(dmf, 200);
                                        dmf.setVisible(true);
                                        desktopPane.add(dmf);
                              }
                    });
                    majorManagerMenuItem.setFont(new Font("나눔명조", Font.BOLD, 13));
                    majorMenu.add(majorManagerMenuItem);
                    
                    JMenuItem collegeAddMenuItem = new JMenuItem("대학(학부)등록");
                    collegeAddMenuItem.setFont(new Font("나눔명조", Font.BOLD, 13));
                    collegeMenu.add(collegeAddMenuItem);
                    
                    JMenuItem collegeManagerMenuItem = new JMenuItem("대학(학부)관리");
                    collegeManagerMenuItem.setFont(new Font("나눔명조", Font.BOLD, 13));
                    collegeMenu.add(collegeManagerMenuItem);
                    
                    JMenu menu = new JMenu("대학관");
                    menu.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(menu);
                    
                    JMenuItem menuItem_2 = new JMenuItem("대학관추가");
                    menuItem_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    menu.add(menuItem_2);
                    
                    JMenuItem menuItem_3 = new JMenuItem("대학관관리");
                    menuItem_3.setFont(new Font("Dialog", Font.BOLD, 13));
                    menu.add(menuItem_3);
                    
                    JMenu affiliateMenu = new JMenu("부속기관");
                    affiliateMenu.setFont(new Font("나눔명조", Font.BOLD, 13));
                    orgManagerMenu.add(affiliateMenu);
                    
                    JMenuItem menuItem_7 = new JMenuItem("부속기관추가");
                    menuItem_7.setFont(new Font("나눔명조", Font.BOLD, 13));
                    affiliateMenu.add(menuItem_7);
                    
                    JMenuItem menuItem_8 = new JMenuItem("부속기관관리");
                    menuItem_8.setFont(new Font("나눔명조", Font.BOLD, 13));
                    affiliateMenu.add(menuItem_8);
                    
                    JMenu mnNewMenu_2 = new JMenu("공지관리");
                    mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tongzhi1.png")));
                    mnNewMenu_2.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    systemManagerMenu.add(mnNewMenu_2);
                    
                    JMenu studentMenu = new JMenu("학생");
                    studentMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentManager.png")));
                    studentMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    menuBar.add(studentMenu);
                    
                    JMenuItem mntmNewMenuItem_2 = new JMenuItem("개인정보");
                    mntmNewMenuItem_2.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    studentMenu.add(mntmNewMenuItem_2);
                    
                    JMenuItem mntmNewMenuItem = new JMenuItem("수강신청");
                    mntmNewMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        CourseApplicationFrm caf=new CourseApplicationFrm();
                                        layeredPane.setLayer(caf, 200);
                                        caf.setVisible(true);
                                        //desktopPane.add(caf);
                              }
                    });
                    mntmNewMenuItem.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    studentMenu.add(mntmNewMenuItem);
                    
                    JMenuItem mntmNewMenuItem_1 = new JMenuItem("성적조희");
                    mntmNewMenuItem_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreShowFrm ssf=new ScoreShowFrm();
                                        layeredPane.setLayer(ssf, 200);
                                        ssf.setVisible(true);
                              }
                    });
                    mntmNewMenuItem_1.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    studentMenu.add(mntmNewMenuItem_1);
                    
                    JMenu mnNewMenu = new JMenu("교원");
                    mnNewMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/teacher.png")));
                    menuBar.add(mnNewMenu);
                    
                    JMenuItem mntmNewMenuItem_3 = new JMenuItem("개인정보");
                    mntmNewMenuItem_3.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    mnNewMenu.add(mntmNewMenuItem_3);
                    
                    JMenuItem mntmNewMenuItem_4 = new JMenuItem("개인수강");
                    mntmNewMenuItem_4.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    mnNewMenu.add(mntmNewMenuItem_4);
                    
                    JMenu settingMenu = new JMenu("설정");
                    settingMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    settingMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/systemsetting.png")));
                    menuBar.add(settingMenu);
                    
                    JMenuItem editPasswordMenuItem = new JMenuItem("안호변경");
                    editPasswordMenuItem.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    editPasswordMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        editPassword(ae);
                              }
                    });
                    editPasswordMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/password.png")));
                    settingMenu.add(editPasswordMenuItem);
                    
                    JMenuItem exitSystemMenuItem = new JMenuItem("시스템종료");
                    exitSystemMenuItem.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    exitSystemMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        if(JOptionPane.showConfirmDialog(MainFrm.this, "종료 하시겠습니까？")==JOptionPane.OK_OPTION){
                                                  System.exit(0);
                                        }
                              }
                    });
                    exitSystemMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
                    settingMenu.add(exitSystemMenuItem);
                    
                    JMenu menu_3 = new JMenu("도움");
                    menu_3.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/help.png")));
                    menuBar.add(menu_3);
                    
                    JMenuItem menuItem_5 = new JMenuItem("우리에 대함");
                    menuItem_5.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    menuItem_5.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        aboutUs(ae);
                              }
                    });
                    menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/aboutUs.png")));
                    menu_3.add(menuItem_5);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    //desktopPane.setVisible(false);
                    card=new CardLayout(0,0);
                    contentPane.setLayout(card);
                    
                    layeredPane = new JLayeredPane();
                    contentPane.add(layeredPane, "layeredPane");
                    layeredPane.setLayout(new CardLayout(0, 0));
                    
                    desktopPane = new JDesktopPane();
                    layeredPane.setLayer(desktopPane, 30);
                    desktopPane.setBackground(new Color(224, 255, 255));
                    layeredPane.add(desktopPane, "name_2735345872256");
                    
                    JPanel panel_sys = new JPanel();
                    panel_sys.setBackground(new Color(100, 149, 237));
                    layeredPane.add(panel_sys, "name_2735377943895");
                    GroupLayout gl_panel_sys = new GroupLayout(panel_sys);
                    gl_panel_sys.setHorizontalGroup(
                              gl_panel_sys.createParallelGroup(Alignment.LEADING)
                                        .addGap(0, 878, Short.MAX_VALUE)
                    );
                    gl_panel_sys.setVerticalGroup(
                              gl_panel_sys.createParallelGroup(Alignment.LEADING)
                                        .addGap(0, 530, Short.MAX_VALUE)
                    );
                    panel_sys.setLayout(gl_panel_sys);
                    
                    JPanel panel_student = new JPanel();
                    panel_student.setBackground(new Color(144, 238, 144));
                    layeredPane.add(panel_student, "name_2735399246744");
                    GroupLayout gl_panel_student = new GroupLayout(panel_student);
                    gl_panel_student.setHorizontalGroup(
                              gl_panel_student.createParallelGroup(Alignment.LEADING)
                                        .addGap(0, 878, Short.MAX_VALUE)
                    );
                    gl_panel_student.setVerticalGroup(
                              gl_panel_student.createParallelGroup(Alignment.LEADING)
                                        .addGap(0, 530, Short.MAX_VALUE)
                    );
                    panel_student.setLayout(gl_panel_student);
                    
                    JPanel panel_pro = new JPanel();
                    panel_pro.setBackground(new Color(255, 182, 193));
                    layeredPane.add(panel_pro, "name_2735419649076");
                    GroupLayout gl_panel_pro = new GroupLayout(panel_pro);
                    gl_panel_pro.setHorizontalGroup(
                              gl_panel_pro.createParallelGroup(Alignment.LEADING)
                                        .addGap(0, 878, Short.MAX_VALUE)
                    );
                    gl_panel_pro.setVerticalGroup(
                              gl_panel_pro.createParallelGroup(Alignment.LEADING)
                                        .addGap(0, 530, Short.MAX_VALUE)
                    );
                    panel_pro.setLayout(gl_panel_pro);
                    setLocationRelativeTo(null);
          }

          //添加学生
          protected void addStudent(ActionEvent ae) {
                    AddStudentFrm asf=new AddStudentFrm();
                    layeredPane.setLayer(asf, 200);
                    asf.setVisible(true);
                    desktopPane.add(asf);
                    
          }
        

          //添加学部
          protected void addDept(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    AddDeptFrm adf=new AddDeptFrm();
                    layeredPane.setLayer(adf, 200);
                    adf.setVisible(true);
                    //desktopPane.add(adf);
          }
          //修改密码
          protected void editPassword(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    EditPasswordFrm editPasswordFrm =new EditPasswordFrm();
                    layeredPane.setLayer(editPasswordFrm, 200);
                    editPasswordFrm.setVisible(true);
                    desktopPane.add(editPasswordFrm);
          }
          //关于我们 
          protected void aboutUs(ActionEvent ae) {
                    String info="【屈江团】出品 \n";
                    info+="网址：http://programmer.ischoolbar.com \n";
                    info+="환영합니다！";
                   // JOptionPane.showMessageDialog(this, info);
                    String[] buttons={"가 보자","다음 가"};
                    int ret = JOptionPane.showOptionDialog(this, info, "우리에 대함", JOptionPane.YES_NO_CANCEL_OPTION, 
                                        JOptionPane.DEFAULT_OPTION, 
                                        new ImageIcon(LoginFrm.class.getResource("/images/student2.png")), buttons, null);
                    if(ret==0){
                              //采用Java调用系统浏览其打开制定网址
                              try {
                                        URI uri=new URI("http://programmer.ischoolbar.com");
                                        //以下两种方式都可以访问网站
                                        //Desktop.getDesktop().browse(uri);
                                        Runtime.getRuntime().exec("explorer http://programmer.ischoolbar.com");
                              } catch ( Exception e) {
                                        // TODO Auto-generated catch block 
                                        e.printStackTrace();
                              }
                              
//                             JOptionPane.showMessageDialog(this, "迫不及待");
                    }else{
                              JOptionPane.showMessageDialog(this, "다음에 꼭 오세요！");
                    }
          }
          private static class __Tmp {
                    private static void __tmp() {
                                javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
                    }
          }
}
