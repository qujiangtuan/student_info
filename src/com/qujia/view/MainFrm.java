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
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class MainFrm extends JFrame {

          private JPanel contentPane;
          public static UserType userType;//登陆的用户类型
          public static Object userObject;//用于哪个用户登陆
          private CardLayout card;
          private JDesktopPane desktopPane_sys,desktopPane_pro,desktopPane_stu;
          private JLayeredPane layeredPane;
          private JMenu studentMenu,proMenu,systemManagerMenu;
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
                    setBounds(100, 100, 1136, 707);
                    
                    JMenuBar menuBar = new JMenuBar();
                    setJMenuBar(menuBar);
                    
                    systemManagerMenu = new JMenu("시스템");
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
                                        desktopPane_sys.add(studentManagerFrm);
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
                    
                    JMenuItem menuItemAddCourse = new JMenuItem("개설교과목등록");
                    menuItemAddCourse.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        AddCourseArrangeFrm acaf=new AddCourseArrangeFrm();
                                        layeredPane.setLayer(acaf, 200);
                                        acaf.setVisible(true);
                                        //desktopPane.add(acaf);
                                        
                              }
                    });
                    
                    JMenuItem menuItemSubject = new JMenuItem("교과목등록");
                    menuItemSubject.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        AddSubjectFrm asf=new AddSubjectFrm();
                                        layeredPane.setLayer(asf, 200);
                                        asf.setVisible(true);
                                        //desktopPane.add(asf);
                              }
                    });
                    menuItemSubject.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItemSubject);
                    
                    JMenuItem menuItem_9 = new JMenuItem("교과목관리");
                    menuItem_9.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		SubjectManagerFrm smf=new SubjectManagerFrm();
                    		 layeredPane.setLayer(smf, 200);
                    		 smf.setVisible(true);
                    	}
                    });
                    menuItem_9.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItem_9);
                    menuItemAddCourse.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItemAddCourse);
                    
                    JMenuItem menuItemManagerCourse = new JMenuItem("개설교과목관리");
                    menuItemManagerCourse.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent arg0) {
                    		CourseArrangeManagerFrm camf=new CourseArrangeManagerFrm();
                            layeredPane.setLayer(camf, 200);
                            camf.setVisible(true);
                    	}
                    });
                    menuItemManagerCourse.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItemManagerCourse);
                    
                    JMenuItem menuItem_11 = new JMenuItem("강의실관리");
                    menuItem_11.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		ClassRoomFrm crf=new ClassRoomFrm();
                    		layeredPane.setLayer(crf, 200);
                    		crf.setVisible(true);
                    	}
                    });
                    menuItem_11.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(menuItem_11);
                    
                    JMenu mnNewMenu_4 = new JMenu("강의평가관리");
                    mnNewMenu_4.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_3.add(mnNewMenu_4);
                    
                    JMenuItem mntmNewMenuItem_5 = new JMenuItem("평가질문관리");
                    mntmNewMenuItem_5.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		EvaluationQuestionFrm eqf=new EvaluationQuestionFrm();
                    		layeredPane.setLayer(eqf, 200);
                    		eqf.setVisible(true);
                    	}
                    });
                    mntmNewMenuItem_5.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_4.add(mntmNewMenuItem_5);
                    
                    JMenuItem menuItem_7 = new JMenuItem("답안유형관리");
                    menuItem_7.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		AnswerTypeManagerFrm atmf=new AnswerTypeManagerFrm();
                    		layeredPane.setLayer(atmf, 200);
                    		atmf.setVisible(true);
                    	}
                    });
                    menuItem_7.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_4.add(menuItem_7);
                    
                    JMenuItem menuItem_8 = new JMenuItem("답안보기구성");
                    menuItem_8.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		QuestionAnswerShowFrm qasf=new QuestionAnswerShowFrm();
                    		layeredPane.setLayer(qasf, 200);
                    		qasf.setVisible(true);
                    	}
                    });
                    menuItem_8.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_4.add(menuItem_8);
                    
                    JMenu orgManagerMenu = new JMenu("조직관리");
                    orgManagerMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/college.png")));
                    orgManagerMenu.setFont(new Font("나눔명조", Font.BOLD, 13));
                    systemManagerMenu.add(orgManagerMenu);
                    
                    JMenuItem menuItem_4 = new JMenuItem("조직등록");
                    menuItem_4.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        AddOrgFrm aof=new AddOrgFrm();
                                        layeredPane.setLayer(aof, 200);
                                        aof.setVisible(true);
                              }
                    });
                    menuItem_4.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(menuItem_4);
                    
                    JMenuItem menuItem_6 = new JMenuItem("조직관리");
                    menuItem_6.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        OrgManagerFrm omf=new OrgManagerFrm();
                                        layeredPane.setLayer(omf, 200);
                                        omf.setVisible(true);
                              }
                    });
                    menuItem_6.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(menuItem_6);
                    
                    JMenu menu = new JMenu("학과기준");
                    menu.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(menu);
                    
                    JMenuItem menuItem_2 = new JMenuItem("학과기준등록");
                    menuItem_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        AddDeptStandFrm adsf=new AddDeptStandFrm();
                                        layeredPane.setLayer(adsf, 200);
                                        adsf.setVisible(true);
//                                        desktopPane.add(adsf);
                              }
                    });
                    menuItem_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    menu.add(menuItem_2);
                    
                    JMenuItem menuItem_3 = new JMenuItem("학과기준관리");
                    menuItem_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        DeptStandManagerFrm dsmf=new DeptStandManagerFrm();
                                        layeredPane.setLayer(dsmf, 200);
                                        dsmf.setVisible(true);
                                        desktopPane_sys.add(dsmf);
                              }
                    });
                    menuItem_3.setFont(new Font("Dialog", Font.BOLD, 13));
                    menu.add(menuItem_3);
                    
                    JMenu mnNewMenu_5 = new JMenu("학년별학과기준");
                    mnNewMenu_5.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(mnNewMenu_5);
                    
                    JMenuItem mntmNewMenuItem_6 = new JMenuItem("학년별학과기준등록");
                    mntmNewMenuItem_6.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		AddYearStandFrm aysf=new AddYearStandFrm();
                    		layeredPane.setLayer(aysf, 200);
                    		aysf.setVisible(true);
                    	}
                    });
                    mntmNewMenuItem_6.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_5.add(mntmNewMenuItem_6);
                    
                    JMenuItem menuItem_10 = new JMenuItem("학년별학과기준관리");
                    menuItem_10.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		YearStandManagerFrm ysmf=new YearStandManagerFrm();
                    		layeredPane.setLayer(ysmf, 200);
                    		ysmf.setVisible(true);
                    	}
                    });
                    menuItem_10.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_5.add(menuItem_10);
                    
                    JMenu mnNewMenu_2 = new JMenu("공지관리");
                    mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/tongzhi1.png")));
                    mnNewMenu_2.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    systemManagerMenu.add(mnNewMenu_2);
                    
                    studentMenu = new JMenu("학생");
                    studentMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentManager.png")));
                    studentMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    menuBar.add(studentMenu);
                    
                    JMenuItem mntmNewMenuItem_2 = new JMenuItem("개인정보");
                    mntmNewMenuItem_2.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		PersonalInfo_stu pis=new PersonalInfo_stu();
                    		layeredPane.setLayer(pis, 200);
                    		pis.setVisible(true);
                    	}
                    });
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
                    
                    proMenu = new JMenu("교원");
                    proMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    proMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/teacher.png")));
                    menuBar.add(proMenu);
                    
                    JMenuItem mntmNewMenuItem_3 = new JMenuItem("개인정보");
                    mntmNewMenuItem_3.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		PersonalInfo_pro pip=new PersonalInfo_pro();
                    		layeredPane.setLayer(pip, 200);
                    		pip.setVisible(true);
                    	}
                    });
                    mntmNewMenuItem_3.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    proMenu.add(mntmNewMenuItem_3);
                    
                    JMenuItem mntmNewMenuItem_4 = new JMenuItem("개인수강");
                    mntmNewMenuItem_4.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        CourseListProFrm clp=new CourseListProFrm();
                                        layeredPane.setLayer(clp, 200);
                                        clp.setVisible(true);
                              }
                    });
                    mntmNewMenuItem_4.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    proMenu.add(mntmNewMenuItem_4);
                    
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
                    contentPane.setLayout(null);
                    
                    layeredPane = new JLayeredPane();
                    layeredPane.setBounds(5, 5, 1110, 637);
                    contentPane.add(layeredPane);
                    card=new CardLayout(0, 0);
                    layeredPane.setLayout(card);
                    
                    desktopPane_sys = new JDesktopPane();
                    layeredPane.setLayer(desktopPane_sys, 30);
                    desktopPane_sys.setBackground(new Color(224, 255, 255));
                    layeredPane.add(desktopPane_sys, "desktopPane");
                    desktopPane_sys.setLayout(null);
                    
                    JPanel panel = new JPanel();
                    panel.setBounds(0, 0, 1110, 25);
                    desktopPane_sys.add(panel);
                    
                    JLabel lblNewLabel = new JLabel("관리자");
                    panel.add(lblNewLabel);
                    
                    JLabel lblNewLabel_4 = new JLabel("test");
                    lblNewLabel_4.setBounds(251, 252, 200, 50);
                    desktopPane_sys.add(lblNewLabel_4);
                    
                    desktopPane_pro = new JDesktopPane();
                    layeredPane.setLayer(desktopPane_pro, 30);
                    desktopPane_pro.setBackground(new Color(143, 188, 143));
                    layeredPane.add(desktopPane_pro, "desktopPane_pro");
                    desktopPane_pro.setLayout(null);
                    
                    JPanel panel_1 = new JPanel();
                    panel_1.setBounds(0, 0, 1110, 25);
                    desktopPane_pro.add(panel_1);
                    
                    JLabel lblNewLabel_1 = new JLabel("교직원");
                    panel_1.add(lblNewLabel_1);
                    
                    JLabel lblNewLabel_3 = new JLabel("test");
                    lblNewLabel_3.setBounds(243, 260, 200, 50);
                    desktopPane_pro.add(lblNewLabel_3);
                    
                    desktopPane_stu = new JDesktopPane();
                    layeredPane.setLayer(desktopPane_stu, 30);
                    desktopPane_stu.setBackground(new Color(147, 112, 219));
                    layeredPane.add(desktopPane_stu, "desktopPane_stu");
                    desktopPane_stu.setLayout(null);
                    
                    JLabel label_1 = new JLabel("test");
                    label_1.setBounds(0, 25, 1110, 612);
                    desktopPane_stu.add(label_1);
                    
                    JPanel panel_2 = new JPanel();
                    panel_2.setBounds(0, 0, 1110, 25);
                    desktopPane_stu.add(panel_2);
                    
                    JLabel lblNewLabel_2 = new JLabel("학생");
                    panel_2.add(lblNewLabel_2);
                    
                    JLabel lblTest = new JLabel("test");
                    lblTest.setBounds(225, 273, 200, 50);
                    desktopPane_stu.add(lblTest);
                    setLocationRelativeTo(null);
                    setAuthority();
                    
          }
//          권한
          private  void setAuthority() {
        	  if("관리자".equals(userType.getName())) {
        		  proMenu.setEnabled(false);
            	  studentMenu.setEnabled(false);
              	card.show(layeredPane, "desktopPane_sys");
//              	card.show(layeredPane, "desktopPane");
              }else if("교직원".equals(userType.getName())) {
            	  systemManagerMenu.setEnabled(false);
            	  studentMenu.setEnabled(false);
              	card.show(layeredPane, "desktopPane_pro");
//              	card.show(layeredPane, "desktopPane");
              }else {
            	  systemManagerMenu.setEnabled(false);
            	  proMenu.setEnabled(false);
              	card.show(layeredPane, "desktopPane_stu");
//              	card.show(layeredPane, "desktopPane");
              }
          }
          //添加学生
          protected void addStudent(ActionEvent ae) {
                    AddStudentFrm asf=new AddStudentFrm();
                    layeredPane.setLayer(asf, 200);
                    asf.setVisible(true);
                    desktopPane_sys.add(asf);
                    
          }
          //修改密码
          protected void editPassword(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    EditPasswordFrm editPasswordFrm =new EditPasswordFrm();
                    layeredPane.setLayer(editPasswordFrm, 200);
                    editPasswordFrm.setVisible(true);
                    if("관리자".equals(userType.getName())) {
                    	desktopPane_sys.add(editPasswordFrm);
                    }else if("교직원".equals(userType.getName())) {
                    	desktopPane_pro.add(editPasswordFrm);
                    }else {
                    	desktopPane_stu.add(editPasswordFrm);
                    }
          }
          //关于我们 
          protected void aboutUs(ActionEvent ae) {
                    String info="【취 지앙투안】出品 \n";
                    info+="URL：https://github.com/qujiangtuan/student_info \n";
                    info+="환영합니다！";
                   // JOptionPane.showMessageDialog(this, info);
                    String[] buttons={"가 보자","다음 가"};
                    int ret = JOptionPane.showOptionDialog(this, info, "우리에 대함", JOptionPane.YES_NO_CANCEL_OPTION, 
                                        JOptionPane.DEFAULT_OPTION, 
                                        new ImageIcon(LoginFrm.class.getResource("/images/student2.png")), buttons, null);
                    if(ret==0){
                              //采用Java调用系统浏览其打开制定网址
                              try {
                                        URI uri=new URI("https://github.com/qujiangtuan/student_info");
                                        //以下两种方式都可以访问网站
                                        //Desktop.getDesktop().browse(uri);
                                        Runtime.getRuntime().exec("explorer https://github.com/qujiangtuan/student_info");
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
