package com.qujia.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.NoticeDao;
import com.qujia.model.Admin;
import com.qujia.model.Notice;
import com.qujia.model.ProStaff;
import com.qujia.model.Student;
import com.qujia.model.UserType;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;

public class MainFrm extends JFrame {

          private JPanel contentPane;
          public static UserType userType;//登陆的用户类型
          public static Object userObject;//用于哪个用户登陆
          private CardLayout card;
          private JDesktopPane desktopPane_sys,desktopPane_pro,desktopPane_stu;
          private JLayeredPane layeredPane;
          private JMenu studentMenu,proMenu,systemManagerMenu;
          private JLabel loginUserLabel;
          private JPanel panel_menu;
          private JButton loginButton;
          private JTable table_stuList;
          private JTable table_stuCon;
          private JTable table_proCon;
          private JTable table_proList;
          private JTextField textField_titleAdd;
          private JButton noticeLoginButton;
          private JTable table_listAdmin;
          private JTextField textField_titleUpdate;
          private CardLayout card_notice;
          private JPanel panel_card,panel_login,panel_list,panel_update;
          private static File uploadFile=null;//upload file
          private static String uploadFileName;//upload fileNamee
          private JLabel fileNameAdd,label_fileNameUpdate;
          private JComboBox comboBox_writerAdd,comboBox_objAdd;
          private JTextArea textArea_admin,textArea_update;
         private static int index_admin;
         private JComboBox comboBox_writerUpdate,comboBox_objUpdate;
          
          
          
          public JDesktopPane getDesktopPane_sys() {
                    return desktopPane_sys;
          }
          public void setDesktopPane_sys(JDesktopPane desktopPane_sys) {
                    this.desktopPane_sys = desktopPane_sys;
          }
          public MainFrm(UserType userType,Object userObject) {
                    this.setResizable(false);
                    this.userType=userType;
                    this.userObject=userObject;
                    
                    setTitle("학사관리시스템");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 1136, 707);
                    
                    JMenuBar menuBar = new JMenuBar();
                    menuBar.setBackground(new Color(230, 230, 250));
                    setJMenuBar(menuBar);
                    
                    JMenu settingMenu = new JMenu("시스템");
                    settingMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    settingMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/systemsetting.png")));
                    menuBar.add(settingMenu);
                    
                    JMenuItem editPasswordMenuItem = new JMenuItem("비밀번호변경");
                    editPasswordMenuItem.setFont(new Font("Dialog", Font.BOLD, 13));
                    editPasswordMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        editPassword(ae);
                              }
                    });
                    editPasswordMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/password.png")));
                    settingMenu.add(editPasswordMenuItem);
                    
                    JMenuItem exitSystemMenuItem = new JMenuItem("시스템종료");
                    exitSystemMenuItem.setFont(new Font("Dialog", Font.BOLD, 13));
                    exitSystemMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        if(JOptionPane.showConfirmDialog(MainFrm.this, "종료 하시겠습니까？")==JOptionPane.OK_OPTION){
                                                  System.exit(0);
                                        }
                              }
                    });
                    exitSystemMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
                    settingMenu.add(exitSystemMenuItem);
                    
                    systemManagerMenu = new JMenu("관리자");
                    systemManagerMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/system.png")));
                    systemManagerMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    menuBar.add(systemManagerMenu);
                    
                    JMenu orgManagerMenu = new JMenu("조직관리");
                    orgManagerMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/college.png")));
                    orgManagerMenu.setFont(new Font("Dialog", Font.BOLD, 13));
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
                    
                    JMenuItem menuItem_6 = new JMenuItem("조직목록");
                    menuItem_6.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        OrgManagerFrm omf=new OrgManagerFrm();
                                        layeredPane.setLayer(omf, 200);
                                        omf.setVisible(true);
                              }
                    });
                    menuItem_6.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(menuItem_6);
                    
                    JMenu menu = new JMenu("학사기준관리");
                    menu.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(menu);
                    
                    JMenuItem menuItem_2 = new JMenuItem("학사기준등록");
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
                    
                    JMenuItem menuItem_3 = new JMenuItem("학사기준목록");
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
                    menu.add(mnNewMenu_5);
                    mnNewMenu_5.setFont(new Font("Dialog", Font.BOLD, 13));
                    
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
                    
                    JMenuItem menuItem_10 = new JMenuItem("학년별학과기준목록");
                    menuItem_10.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		YearStandManagerFrm ysmf=new YearStandManagerFrm();
                    		layeredPane.setLayer(ysmf, 200);
                    		ysmf.setVisible(true);
                    	}
                    });
                    menuItem_10.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_5.add(menuItem_10);
                    
                    JMenu mnNewMenu_6 = new JMenu("복수부전공허용관리");
                    mnNewMenu_6.setFont(new Font("Dialog", Font.BOLD, 13));
                    orgManagerMenu.add(mnNewMenu_6);
                    
                    JMenuItem mntmNewMenuItem_8 = new JMenuItem("복수부전공허용추가");
                    mntmNewMenuItem_8.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        AddAppendMajorOrgFrm aamof=new AddAppendMajorOrgFrm();
                                        layeredPane.setLayer(aamof, 200);
                                        aamof.setVisible(true);
                              }
                    });
                    mntmNewMenuItem_8.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_6.add(mntmNewMenuItem_8);
                    
                    JMenuItem mntmNewMenuItem_9 = new JMenuItem("복수부전공허용목록");
                    mntmNewMenuItem_9.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        AppendMajorOrgManagerFrm amomf=new AppendMajorOrgManagerFrm();
                                        layeredPane.setLayer(amomf, 200);
                                        amomf.setVisible(true);
                              }
                    });
                    mntmNewMenuItem_9.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_6.add(mntmNewMenuItem_9);
                    
                    JMenu managerStudentMenu = new JMenu("학생관리");
                    managerStudentMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentManager.png")));
                    managerStudentMenu.setFont(new Font("Dialog", Font.BOLD, 13));
                    systemManagerMenu.add(managerStudentMenu);
                    
                    JMenuItem studentAddMenuItem = new JMenuItem("학생등록");
                    studentAddMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
                    studentAddMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        addStudent(ae);
                              }
                    });
                    studentAddMenuItem.setFont(new Font("Dialog", Font.BOLD, 13));
                    managerStudentMenu.add(studentAddMenuItem);
                    
                    JMenuItem studentListMenuItem = new JMenuItem("학생목록");
                    studentListMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentList.png")));
                    studentListMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        StudentManagerFrm studentManagerFrm=new StudentManagerFrm();
                                        layeredPane.setLayer(studentManagerFrm, 200);
                                        studentManagerFrm.setVisible(true);
                                        desktopPane_sys.add(studentManagerFrm);
                              }
                    });
                    studentListMenuItem.setFont(new Font("Dialog", Font.BOLD, 13));
                    managerStudentMenu.add(studentListMenuItem);
                    
                    JMenuItem mntmNewMenuItem_10 = new JMenuItem("성적확인");
                    mntmNewMenuItem_10.setIcon(new ImageIcon(MainFrm.class.getResource("/images/scoreSearch.png")));
                    mntmNewMenuItem_10.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreShowToAdminFrm sstaf=new ScoreShowToAdminFrm();
                                        layeredPane.setLayer(sstaf, 200);
                                        sstaf.setVisible(true);
                              }
                    });
                    mntmNewMenuItem_10.setFont(new Font("Dialog", Font.BOLD, 13));
                    managerStudentMenu.add(mntmNewMenuItem_10);
                    
                    JMenu mnNewMenu_1 = new JMenu("교직원관리");
                    mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/teacher.png")));
                    mnNewMenu_1.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    systemManagerMenu.add(mnNewMenu_1);
                    
                    JMenuItem menuItem = new JMenuItem("교직원등록");
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
                    
                    JMenuItem menuItem_1 = new JMenuItem("교직원목록");
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
                    
                    JMenu mnNewMenu_3 = new JMenu("교과목관리");
                    mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/newObject.png")));
                    mnNewMenu_3.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    systemManagerMenu.add(mnNewMenu_3);
                    
                    JMenuItem menuItemAddCourse = new JMenuItem("교과목개설");
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
                    menuItem_11.setIcon(new ImageIcon(MainFrm.class.getResource("/images/classroom.png")));
                    systemManagerMenu.add(menuItem_11);
                    menuItem_11.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		ClassRoomFrm crf=new ClassRoomFrm();
                    		layeredPane.setLayer(crf, 200);
                    		crf.setVisible(true);
                    	}
                    });
                    menuItem_11.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    JMenu mnNewMenu = new JMenu("수강관리");
                    mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/scoreManager.png")));
                    mnNewMenu.setFont(new Font("Dialog", Font.BOLD, 13));
                    systemManagerMenu.add(mnNewMenu);
                    
                    JMenuItem mntmNewMenuItem_7 = new JMenuItem("수강목록");
                    mntmNewMenuItem_7.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        CourseListAdmFrm losf=new CourseListAdmFrm();
                                        layeredPane.setLayer(losf, 200);
                                        losf.setVisible(true);
                              }
                    });
                    mntmNewMenuItem_7.setFont(new Font("Dialog", Font.BOLD, 13));
                    mntmNewMenuItem_7.setSelected(true);
                    mnNewMenu.add(mntmNewMenuItem_7);
                    
                    JMenu mnNewMenu_4 = new JMenu("강의평가관리");
                    mnNewMenu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/pingjia4.png")));
                    systemManagerMenu.add(mnNewMenu_4);
                    mnNewMenu_4.setFont(new Font("Dialog", Font.BOLD, 13));
                    
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
                    
                    JMenuItem menuItem_8 = new JMenuItem("평가문답구성");
                    menuItem_8.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		QuestionAnswerShowFrm qasf=new QuestionAnswerShowFrm();
                    		layeredPane.setLayer(qasf, 200);
                    		qasf.setVisible(true);
                    	}
                    });
                    menuItem_8.setFont(new Font("Dialog", Font.BOLD, 13));
                    mnNewMenu_4.add(menuItem_8);
                    
                    studentMenu = new JMenu("학생");
                    studentMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentManager.png")));
                    studentMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    menuBar.add(studentMenu);
                    
                    JMenuItem mntmNewMenuItem_2 = new JMenuItem("개인정보");
                    mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/studentManager.png")));
                    mntmNewMenuItem_2.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		PersonalInfo_stu pis=new PersonalInfo_stu();
                    		layeredPane.setLayer(pis, 200);
                    		pis.setVisible(true);
                    	}
                    });
                    mntmNewMenuItem_2.setFont(new Font("Dialog", Font.BOLD, 13));
                    studentMenu.add(mntmNewMenuItem_2);
                    
                    JMenuItem mntmNewMenuItem = new JMenuItem("수강신청");
                    mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/applySubject3.png")));
                    mntmNewMenuItem.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        CourseApplicationStudentFrm caf=new CourseApplicationStudentFrm();
                                        layeredPane.setLayer(caf, 200);
                                        caf.setVisible(true);
                                        //desktopPane.add(caf);
                              }
                    });
                    mntmNewMenuItem.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    studentMenu.add(mntmNewMenuItem);
                    
                    JMenuItem mntmNewMenuItem_1 = new JMenuItem("성적조희");
                    mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/scoreSearch.png")));
                    mntmNewMenuItem_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreShowToStudentFrm ssf=new ScoreShowToStudentFrm();
                                        layeredPane.setLayer(ssf, 200);
                                        ssf.setVisible(true);
                              }
                    });
                    
                    JMenuItem menu_1 = new JMenuItem("수강목록");
                    menu_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        CourseListStuFrm plof=new CourseListStuFrm();
                                        plof.setVisible(true);
                              }
                    });
                    menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/subjectList.png")));
                    menu_1.setFont(new Font("Dialog", Font.BOLD, 13));
                    studentMenu.add(menu_1);
                    mntmNewMenuItem_1.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    studentMenu.add(mntmNewMenuItem_1);
                    
                    proMenu = new JMenu("교원");
                    proMenu.setFont(new Font("휴먼고딕", Font.BOLD, 14));
                    proMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/proInfo.png")));
                    menuBar.add(proMenu);
                    
                    JMenuItem mntmNewMenuItem_3 = new JMenuItem("개인정보");
                    mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/teacher.png")));
                    mntmNewMenuItem_3.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		PersonalInfo_pro pip=new PersonalInfo_pro();
                    		layeredPane.setLayer(pip, 200);
                    		pip.setVisible(true);
                    	}
                    });
                    mntmNewMenuItem_3.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    proMenu.add(mntmNewMenuItem_3);
                    
                    JMenuItem mntmNewMenuItem_4 = new JMenuItem("강의관리");
                    mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/classList.png")));
                    mntmNewMenuItem_4.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        CourseListProFrm clp=new CourseListProFrm();
                                        layeredPane.setLayer(clp, 200);
                                        clp.setVisible(true);
                              }
                    });
                    mntmNewMenuItem_4.setFont(new Font("휴먼고딕", Font.BOLD, 13));
                    proMenu.add(mntmNewMenuItem_4);
                    
                    panel_menu = new JPanel();
                    panel_menu.setBackground(new Color(230, 230, 250));
                    menuBar.add(panel_menu);
                    loginButton = new JButton("로그아웃");
                    loginButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        closeCurrentWindow(ae);
                                        
                              }
                    });


                    panel_menu.setLayout(new FlowLayout(FlowLayout.RIGHT, 8, 1));
                    
                    JLabel label = new JLabel("");
                    panel_menu.add(label);
                    
                    loginUserLabel = new JLabel("관리자: admin");
                    loginUserLabel.setFont(new Font("Dialog", Font.BOLD, 13));
                    panel_menu.add(loginUserLabel);
                    panel_menu.add(loginButton);
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
                    
                    panel_card = new JPanel();
                    panel_card.setBounds(269, 35, 547, 580);
                    desktopPane_sys.add(panel_card);
                    card_notice=new CardLayout(0, 0);
                    panel_card.setLayout(card_notice);
                    
                    panel_list = new JPanel();
                    panel_card.add(panel_list, "panel_list");
                    panel_list.setLayout(null);
                    
                    JLabel label_8 = new JLabel("공지 목록");
                    label_8.setFont(new Font("나눔명조", Font.BOLD, 24));
                    label_8.setBounds(12, 0, 107, 44);
                    panel_list.add(label_8);
                    
                    JScrollPane scrollPane_6 = new JScrollPane();
                    scrollPane_6.setBounds(12, 54, 523, 436);
                    panel_list.add(scrollPane_6);
                    
                    table_listAdmin = new JTable();
                    table_listAdmin.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent arg0) {
                                        index_admin=table_listAdmin.getSelectedRow();
                              }
                    });
                    table_listAdmin.setRowHeight(25);
                    table_listAdmin.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uBC88\uD638", "\uC81C\uBAA9", "\uC791\uC131\uC790", "\uACF5\uC9C0\uB300\uC0C1", "\uC791\uC131\uC77C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_listAdmin.getColumnModel().getColumn(1).setPreferredWidth(305);
                    table_listAdmin.getColumnModel().getColumn(2).setPreferredWidth(105);
                    table_listAdmin.getColumnModel().getColumn(3).setPreferredWidth(88);
                    table_listAdmin.getColumnModel().getColumn(4).setPreferredWidth(118);
                    scrollPane_6.setViewportView(table_listAdmin);
                    
                    JButton button_2 = new JButton("공지 수정");
                    button_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateNoticeAdmin(e);
                              }
                    });
                    button_2.setFont(new Font("나눔명조", Font.BOLD, 16));
                    button_2.setBounds(209, 522, 128, 36);
                    panel_list.add(button_2);
                    
                    JButton button_3 = new JButton("공지 삭제");
                    button_3.setFont(new Font("나눔명조", Font.BOLD, 16));
                    button_3.setBounds(366, 522, 128, 36);
                    panel_list.add(button_3);
                    
                    noticeLoginButton = new JButton("공지 등록");
                    noticeLoginButton.setBounds(39, 522, 128, 36);
                    panel_list.add(noticeLoginButton);
                    noticeLoginButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        card_notice.show(panel_card, "panel_login");
//                                        noticeListbutton.setBackground(new Color(240, 240, 240));
//                                        noticeLoginButton.setBackground(new Color(152, 251, 152));
                              }
                    });
                    noticeLoginButton.setFont(new Font("나눔명조", Font.BOLD, 16));
                    
                    panel_login = new JPanel();
                    panel_card.add(panel_login, "panel_login");
                    panel_login.setLayout(null);
                    
                    JLabel label_4 = new JLabel("공지 등록");
                    label_4.setBounds(12, 0, 107, 44);
                    panel_login.add(label_4);
                    label_4.setFont(new Font("나눔명조", Font.BOLD, 24));
                    
                    JLabel lblNewLabel_1 = new JLabel("제목:");
                    lblNewLabel_1.setBounds(35, 45, 44, 15);
                    panel_login.add(lblNewLabel_1);
                    lblNewLabel_1.setFont(new Font("나눔명조", Font.BOLD, 14));
                    
                    textField_titleAdd = new JTextField();
                    textField_titleAdd.setBounds(75, 42, 390, 21);
                    panel_login.add(textField_titleAdd);
                    textField_titleAdd.setColumns(10);
                    
                    JLabel label_6 = new JLabel("작성자:");
                    label_6.setBounds(22, 82, 57, 15);
                    panel_login.add(label_6);
                    label_6.setFont(new Font("나눔명조", Font.BOLD, 14));
                    
                    comboBox_writerAdd = new JComboBox();
                    comboBox_writerAdd.setBounds(75, 79, 148, 21);
                    panel_login.add(comboBox_writerAdd);
                    comboBox_writerAdd.setModel(new DefaultComboBoxModel(new String[] {"", "관리자"}));
                    comboBox_writerAdd.setEditable(true);
                    
                    JLabel label_7 = new JLabel("공지내용:");
                    label_7.setBounds(22, 117, 72, 15);
                    panel_login.add(label_7);
                    label_7.setFont(new Font("나눔명조", Font.BOLD, 14));
                    
                    JScrollPane scrollPane_nLogin = new JScrollPane();
                    scrollPane_nLogin.setBounds(12, 142, 523, 325);
                    panel_login.add(scrollPane_nLogin);
                    
                    textArea_admin = new JTextArea();
                    textArea_admin.setLineWrap(true);
                    scrollPane_nLogin.setViewportView(textArea_admin);
                    
                    JLabel lblNewLabel_5 = new JLabel("첨부파일:");
                    lblNewLabel_5.setBounds(12, 477, 57, 15);
                    panel_login.add(lblNewLabel_5);
                    
                    fileNameAdd = new JLabel("없음");
                    fileNameAdd.setBounds(81, 477, 163, 15);
                    panel_login.add(fileNameAdd);
                    
                    JButton uploadButtonAdd = new JButton("업로드");
                    uploadButtonAdd.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        uploadFileAction(e);
                              }
                    });
                    uploadButtonAdd.setBounds(329, 477, 97, 23);
                    panel_login.add(uploadButtonAdd);
                    
                    JButton deleteFileButtonAdd = new JButton("삭제");
                    deleteFileButtonAdd.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "첨부파일을 삭제하시겠습니까?", " WarningDialog!", 
                                                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                                        if(showConfirmDialog==JOptionPane.YES_OPTION){
                                                  fileNameAdd.setText("없음");
                                                  uploadFile=null;
                                        }
                              }
                    });
                    deleteFileButtonAdd.setBounds(438, 477, 97, 23);
                    panel_login.add(deleteFileButtonAdd);
                    
                    JButton loginButtonAdd = new JButton("등 록");
                    loginButtonAdd.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        loginNoticeAction(e);
                              }
                    });
                    loginButtonAdd.setFont(new Font("나눔명조", Font.BOLD, 18));
                    loginButtonAdd.setBounds(185, 549, 97, 23);
                    panel_login.add(loginButtonAdd);
                    
                    JButton cancelButtonAdd = new JButton("취 소");
                    cancelButtonAdd.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        card_notice.show(panel_card, "panel_list");
                                        resetValues();
                              }
                    });
                    cancelButtonAdd.setFont(new Font("나눔명조", Font.BOLD, 18));
                    cancelButtonAdd.setBounds(301, 549, 97, 23);
                    panel_login.add(cancelButtonAdd);
                    
                    JLabel label_15 = new JLabel("공지대상:");
                    label_15.setFont(new Font("나눔명조", Font.BOLD, 14));
                    label_15.setBounds(265, 82, 81, 15);
                    panel_login.add(label_15);
                    
                    comboBox_objAdd = new JComboBox();
                    comboBox_objAdd.setFont(new Font("Dialog", Font.BOLD, 12));
                    comboBox_objAdd.setModel(new DefaultComboBoxModel(new String[] {"전체공지", "학생공지", "교원공지"}));
                    comboBox_objAdd.setBounds(346, 79, 119, 21);
                    panel_login.add(comboBox_objAdd);
                    
                    panel_update = new JPanel();
                    panel_card.add(panel_update, "panel_update");
                    panel_update.setLayout(null);
                    
                    JLabel label_9 = new JLabel("공지 수정");
                    label_9.setFont(new Font("나눔명조", Font.BOLD, 24));
                    label_9.setBounds(12, 10, 107, 44);
                    panel_update.add(label_9);
                    
                    JLabel label_10 = new JLabel("제목:");
                    label_10.setFont(new Font("나눔명조", Font.BOLD, 14));
                    label_10.setBounds(35, 55, 44, 15);
                    panel_update.add(label_10);
                    
                    textField_titleUpdate = new JTextField();
                    textField_titleUpdate.setColumns(10);
                    textField_titleUpdate.setBounds(75, 52, 390, 21);
                    panel_update.add(textField_titleUpdate);
                    
                    JLabel label_11 = new JLabel("작성자:");
                    label_11.setFont(new Font("나눔명조", Font.BOLD, 14));
                    label_11.setBounds(22, 92, 57, 15);
                    panel_update.add(label_11);
                    
                    comboBox_writerUpdate = new JComboBox();
                    comboBox_writerUpdate.setEditable(true);
                    comboBox_writerUpdate.setBounds(75, 89, 163, 21);
                    panel_update.add(comboBox_writerUpdate);
                    
                    JLabel label_12 = new JLabel("공지내용:");
                    label_12.setFont(new Font("나눔명조", Font.BOLD, 14));
                    label_12.setBounds(22, 127, 72, 15);
                    panel_update.add(label_12);
                    
                    JScrollPane scrollPane_7 = new JScrollPane();
                    scrollPane_7.setBounds(12, 152, 523, 325);
                    panel_update.add(scrollPane_7);
                    
                    textArea_update = new JTextArea();
                    textArea_update.setLineWrap(true);
                    scrollPane_7.setViewportView(textArea_update);
                    
                    JLabel label_13 = new JLabel("첨부파일:");
                    label_13.setBounds(12, 487, 57, 15);
                    panel_update.add(label_13);
                    
                    label_fileNameUpdate = new JLabel("New label");
                    label_fileNameUpdate.setBounds(81, 487, 163, 15);
                    panel_update.add(label_fileNameUpdate);
                    
                    JButton uploadUpdatebutton = new JButton("업로드");
                    uploadUpdatebutton.setBounds(329, 487, 97, 23);
                    panel_update.add(uploadUpdatebutton);
                    
                    JButton deleteLoadeUpdatebutton = new JButton("삭제");
                    deleteLoadeUpdatebutton.setBounds(438, 487, 97, 23);
                    panel_update.add(deleteLoadeUpdatebutton);
                    
                    JButton updateButton = new JButton("수 정");
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateNoticeAction(e);
                              }
                    });
                    updateButton.setFont(new Font("나눔명조", Font.BOLD, 18));
                    updateButton.setBounds(192, 547, 97, 23);
                    panel_update.add(updateButton);
                    
                    JButton cancelUpdateButton = new JButton("취 소");
                    cancelUpdateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        card_notice.show(panel_card, "panel_list");
                              }
                    });
                    cancelUpdateButton.setFont(new Font("나눔명조", Font.BOLD, 18));
                    cancelUpdateButton.setBounds(303, 547, 97, 23);
                    panel_update.add(cancelUpdateButton);
                    
                    JLabel label_16 = new JLabel("공지대상:");
                    label_16.setFont(new Font("나눔명조", Font.BOLD, 14));
                    label_16.setBounds(270, 92, 72, 15);
                    panel_update.add(label_16);
                    
                    comboBox_objUpdate = new JComboBox();
                    comboBox_objUpdate.setFont(new Font("Dialog", Font.BOLD, 12));
                    comboBox_objUpdate.setBounds(343, 89, 123, 21);
                    panel_update.add(comboBox_objUpdate);
                    
                    desktopPane_pro = new JDesktopPane();
                    layeredPane.setLayer(desktopPane_pro, 30);
                    desktopPane_pro.setBackground(new Color(143, 188, 143));
                    layeredPane.add(desktopPane_pro, "desktopPane_pro");
                    desktopPane_pro.setLayout(null);
                    
                    JPanel panel_1 = new JPanel();
                    panel_1.setBounds(0, 0, 1110, 25);
                    desktopPane_pro.add(panel_1);
                    
                    JLabel proLabel_1 = new JLabel("교직원");
                    panel_1.add(proLabel_1);
                    
                    JScrollPane scrollPane_2 = new JScrollPane();
                    scrollPane_2.setBounds(67, 98, 450, 466);
                    desktopPane_pro.add(scrollPane_2);
                    
                    table_proList = new JTable();
                    table_proList.setRowHeight(25);
                    table_proList.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null},
                              },
                              new String[] {
                                        "\uBC88\uD638", "\uC81C\uBAA9", "\uC791\uC131\uC790", "\uC791\uC131\uC77C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_proList.getColumnModel().getColumn(1).setPreferredWidth(253);
                    table_proList.getColumnModel().getColumn(2).setPreferredWidth(145);
                    table_proList.getColumnModel().getColumn(3).setPreferredWidth(141);
                    scrollPane_2.setViewportView(table_proList);
                    
                    JLabel label_2 = new JLabel("공지 목록");
                    label_2.setFont(new Font("나눔명조", Font.BOLD, 24));
                    label_2.setBounds(67, 46, 107, 60);
                    desktopPane_pro.add(label_2);
                    
                    JPanel panel_4 = new JPanel();
                    panel_4.setLayout(null);
                    panel_4.setBounds(529, 96, 469, 466);
                    desktopPane_pro.add(panel_4);
                    
                    JScrollPane scrollPane_3 = new JScrollPane();
                    scrollPane_3.setBounds(0, 59, 469, 364);
                    panel_4.add(scrollPane_3);
                    
                    JTextArea textArea_pro = new JTextArea();
                    scrollPane_3.setViewportView(textArea_pro);
                    
                    JLabel label_3 = new JLabel("첨부파일:");
                    label_3.setBounds(0, 441, 57, 15);
                    panel_4.add(label_3);
                    
                    JLabel proFileName = new JLabel("New label");
                    proFileName.setBounds(56, 441, 127, 15);
                    panel_4.add(proFileName);
                    
                    JButton buttondownload = new JButton("다운로드");
                    buttondownload.setBounds(360, 433, 97, 23);
                    panel_4.add(buttondownload);
                    
                    JScrollPane scrollPane_4 = new JScrollPane();
                    scrollPane_4.setBounds(0, 0, 469, 55);
                    panel_4.add(scrollPane_4);
                    
                    table_proCon = new JTable();
                    scrollPane_4.setViewportView(table_proCon);
                    table_proCon.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null},
                              },
                              new String[] {
                                        "\uBC88\uD638", "\uC81C\uBAA9", "\uC791\uC131\uC790", "\uC791\uC131\uC77C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_proCon.getColumnModel().getColumn(1).setPreferredWidth(301);
                    table_proCon.getColumnModel().getColumn(2).setPreferredWidth(111);
                    table_proCon.getColumnModel().getColumn(3).setPreferredWidth(124);
                    table_proCon.setRowHeight(25);
                    
                    JLabel label_5 = new JLabel("공지 내용");
                    label_5.setFont(new Font("나눔명조", Font.BOLD, 24));
                    label_5.setBounds(529, 46, 167, 60);
                    desktopPane_pro.add(label_5);
                    
                    desktopPane_stu = new JDesktopPane();
                    layeredPane.setLayer(desktopPane_stu, 30);
                    desktopPane_stu.setBackground(new Color(240, 255, 240));
                    layeredPane.add(desktopPane_stu, "desktopPane_stu");
                    desktopPane_stu.setLayout(null);
                    
                    JPanel panel_2 = new JPanel();
                    panel_2.setBounds(0, 0, 1110, 25);
                    desktopPane_stu.add(panel_2);
                    
                    JLabel lblNewLabel_2 = new JLabel("학생");
                    panel_2.add(lblNewLabel_2);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(40, 123, 450, 466);
                    desktopPane_stu.add(scrollPane);
                    
                    table_stuList = new JTable();
                    table_stuList.setRowHeight(25);
                    table_stuList.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null},
                              },
                              new String[] {
                                        "\uBC88\uD638", "\uC81C\uBAA9", "\uC791\uC131\uC790", "\uC791\uC131\uC77C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_stuList.getColumnModel().getColumn(1).setPreferredWidth(287);
                    table_stuList.getColumnModel().getColumn(2).setPreferredWidth(96);
                    table_stuList.getColumnModel().getColumn(3).setPreferredWidth(112);
                    scrollPane.setViewportView(table_stuList);
                    
                    JLabel lblNewLabel_3 = new JLabel("공지 목록");
                    lblNewLabel_3.setFont(new Font("나눔명조", Font.BOLD, 24));
                    lblNewLabel_3.setBounds(40, 71, 107, 60);
                    desktopPane_stu.add(lblNewLabel_3);
                    
                    JPanel panel_3 = new JPanel();
                    panel_3.setBounds(502, 121, 469, 466);
                    desktopPane_stu.add(panel_3);
                    panel_3.setLayout(null);
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    scrollPane_1.setBounds(0, 59, 469, 364);
                    panel_3.add(scrollPane_1);
                    
                    JTextArea textArea_stu = new JTextArea();
                    scrollPane_1.setViewportView(textArea_stu);
                    
                    JLabel lblNewLabel_4 = new JLabel("첨부파일:");
                    lblNewLabel_4.setBounds(0, 441, 57, 15);
                    panel_3.add(lblNewLabel_4);
                    
                    JLabel stuFileName = new JLabel("New label");
                    stuFileName.setBounds(56, 441, 127, 15);
                    panel_3.add(stuFileName);
                    
                    JButton downloadButton = new JButton("다운로드");
                    downloadButton.setBounds(360, 433, 97, 23);
                    panel_3.add(downloadButton);
                    
                    JScrollPane scrollPane_5 = new JScrollPane();
                    scrollPane_5.setBounds(0, 0, 469, 56);
                    panel_3.add(scrollPane_5);
                    
                    table_stuCon = new JTable();
                    scrollPane_5.setViewportView(table_stuCon);
                    table_stuCon.setRowHeight(25);
                    table_stuCon.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null},
                              },
                              new String[] {
                                        "\uBC88\uD638", "\uC81C\uBAA9", "\uC791\uC131\uC790", "\uC791\uC131\uC77C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_stuCon.getColumnModel().getColumn(1).setPreferredWidth(251);
                    table_stuCon.getColumnModel().getColumn(2).setPreferredWidth(107);
                    table_stuCon.getColumnModel().getColumn(3).setPreferredWidth(166);
                    
                    JLabel label_1 = new JLabel("공지 내용");
                    label_1.setFont(new Font("나눔명조", Font.BOLD, 24));
                    label_1.setBounds(502, 71, 167, 60);
                    desktopPane_stu.add(label_1);
                    setLocationRelativeTo(null);
                    setAuthority();
                    
          } 
          protected void updateNoticeAction(ActionEvent e) {
//                    DefaultTableModel dft = (DefaultTableModel) table_listAdmin.getModel();
//                    String id = dft.getValueAt(index_admin, 0).toString();
//                    NoticeDao noDao=new NoticeDao();
//                    Notice no=(Notice)noDao.getOneNotice(id);
//                    
//                    textField_titleUpdate.setText(no.getTitle());
//                    
//                    comboBox_writerUpdate.
//                    comboBox_objUpdate
//                    
//                    textArea_update.setText();
//                    label_fileNameUpdate
//                    
//                    
//                    
//                    card_notice.show(panel_card, "panel_list");
          }
          protected void updateNoticeAdmin(ActionEvent e) {
                    card_notice.show(panel_card, "panel_update");
          }
          //공지등록 등록
          protected void loginNoticeAction(ActionEvent e) {
                    String title = textField_titleAdd.getText().toString();
                    String writer = comboBox_writerAdd.getSelectedItem().toString();
                    String obj = comboBox_objAdd.getSelectedItem().toString();
                    String content = textArea_admin.getText().toString();
                    String fileName = fileNameAdd.getText().toString();
                    String loginDate=DateUtil.getTodayDate();
                    String num=StringUtil.getRandom3();
                    while(this.isRepeat(num)){
                              num=StringUtil.getRandom3();
                    }
                    Notice no=new Notice();
                    no.setTitle(title);
                    no.setWriter(writer);
                    no.setObj(obj);
                    no.setContent(content);
                    no.setFileName(fileName);
                    no.setFile(uploadFile);
                    long size = (long) uploadFile.length();
                    no.setSize1(size);
                    no.setLoginDate(loginDate);
                    no.setNum(num);
                    
                    NoticeDao noDao=new NoticeDao();
                    if(noDao.loginNotic(no)){
                              if(noDao.insertFile(uploadFile,num)){
                                        JOptionPane.showMessageDialog(this, "공지를 등록했습니다!");
                                        resetValues();
                              }else{
                                        JOptionPane.showMessageDialog(this, "공지 등록이 실패되었습니다!1");
                              }
                    }else{
                              JOptionPane.showMessageDialog(this, "공지 등록이 실패되었습니다!2");
                    }
          }
          private void resetValues() {
                    textField_titleAdd.setText("");
                    comboBox_writerAdd.setSelectedIndex(0);
                    comboBox_objAdd.setSelectedIndex(0);
                    textArea_admin.setText("");
                    fileNameAdd.setText("없음");
                    uploadFile=null;
          }
          private boolean isRepeat(String num) {
                   NoticeDao noDao =new NoticeDao();
                   if(noDao.isExit(num)){
                             return true;
                   }
                    return false;
          }
          //공지등록 upload
          protected void uploadFileAction(ActionEvent e) {
                    JFileChooser jfc=new JFileChooser();  
                    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
                    jfc.showDialog(new JLabel(), "파일 선택");  
                    try {
                              uploadFile=jfc.getSelectedFile();  
                              uploadFileName=uploadFile.getName();
                    } catch (Exception e2) {
                              uploadFile=null;
                              uploadFileName=null;
                    }
                    fileNameAdd.setText(uploadFileName);
          }
          //close currentWindow open login window
          protected void closeCurrentWindow(ActionEvent ae) {
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "로그아웃 하겠습니까？", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              this.setVisible(false);
                              this.disable();
                              new LoginFrm().setVisible(true);
                    }
          }
          //          권한
          private  void setAuthority() {
        	  if("관리자".equals(userType.getName())) {
        		  proMenu.setEnabled(false);
            	  studentMenu.setEnabled(false);
              	card.show(layeredPane, "desktopPane_sys");
//              	card.show(layeredPane, "desktopPane");
              	
              	Admin admin=(Admin)userObject;
              	String username="【"+ userType.getName()+ "】：" + admin.getName();
              	loginUserLabel.setText(username);
              	setTable_listAdmin(new Notice());
              }else if("교직원".equals(userType.getName())) {
            	  systemManagerMenu.setEnabled(false);
            	  studentMenu.setEnabled(false);
              	card.show(layeredPane, "desktopPane_pro");
//              	card.show(layeredPane, "desktopPane");
              	
              	ProStaff ps=(ProStaff)userObject;
                String username="【"+ userType.getName()+ "】：" + ps.getpName();
                loginUserLabel.setText(username);
              }else {
            	  systemManagerMenu.setEnabled(false);
            	  proMenu.setEnabled(false);
              	  card.show(layeredPane, "desktopPane_stu");
//              	card.show(layeredPane, "desktopPane");
              	  
              	Student st=(Student)userObject;
                String username="【"+ userType.getName()+ "】：" + st.getName();
                loginUserLabel.setText(username);
              }
          }
          private void setTable_listAdmin(Notice notice) {
                    DefaultTableModel dft = (DefaultTableModel) table_listAdmin.getModel();
                    dft.setRowCount(0);
                    NoticeDao noDao=new NoticeDao();
                    List<Notice> noList = noDao.getNoticeList(notice);
                    for(Notice no : noList){
                              Vector v=new Vector();
                              v.add(no.getId());
                              v.add(no.getTitle());
                              v.add(no.getWriter());
                              v.add(no.getObj());
                              v.add(no.getLoginDate());
                              dft.addRow(v);
                    }
                    noDao.closeDao();      
          }
          //add student
          protected void addStudent(ActionEvent ae) {
                    AddStudentFrm asf=new AddStudentFrm();
                    layeredPane.setLayer(asf, 200);
                    asf.setVisible(true);
//                    desktopPane_sys.add(asf);
                    
          }
          //update password
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
}
