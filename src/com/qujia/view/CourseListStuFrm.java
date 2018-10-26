package com.qujia.view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.PerCourseDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.PerCourse;
import com.qujia.model.Student;
import com.qujia.util.ViewUtil;

public class CourseListStuFrm extends JFrame {

          private JPanel contentPane;
          private JTable table_perCourse;
          private DefaultTableModel dft_per;
          private Student student,stuTemp;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseListStuFrm frame = new CourseListStuFrm();
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
          public CourseListStuFrm() {
                 // get login user info 
                    student =(Student) MainFrm.userObject;
                    StudentDao stuDao=new StudentDao();
                    stuTemp=stuDao.login(student);
                    
                    
                    setTitle("\uC218\uAC15\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 649, 348);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 47, 613, 168);
                    contentPane.add(scrollPane);
                    
                    table_perCourse = new JTable();
                    table_perCourse.setRowHeight(25);
                    table_perCourse.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, "", null},
                              },
                              new String[] {
                                        "\uD559\uC218\uBC88\uD638", "\uACFC\uBAA9\uBA85", "\uB2F4\uB2F9\uAD50\uC218", "\uD559\uC810", "\uC774\uC218\uAD6C\uBD84", "\uBD84\uBC18", "\uC2DC\uAC04/\uAC15\uC758\uC2E4", "\uAC15\uC758\uACC4\uD68D\uC11C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, true, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table_perCourse.getColumnModel().getColumn(1).setPreferredWidth(172);
                    table_perCourse.getColumnModel().getColumn(2).setPreferredWidth(112);
                    table_perCourse.getColumnModel().getColumn(3).setPreferredWidth(67);
                    table_perCourse.getColumnModel().getColumn(4).setPreferredWidth(78);
                    table_perCourse.getColumnModel().getColumn(6).setPreferredWidth(326);
                    table_perCourse.getColumnModel().getColumn(7).setPreferredWidth(189);
                    table_perCourse.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    scrollPane.setViewportView(table_perCourse);
                    
                    JLabel lblNewLabel = new JLabel("\uC774\uB984:");
                    lblNewLabel.setBounds(40, 10, 54, 15);
                    contentPane.add(lblNewLabel);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uAE40\uC0C1\uBBFC");
                    lblNewLabel_1.setBounds(93, 10, 220, 15);
                    contentPane.add(lblNewLabel_1);
                    
                    JButton btnNewButton = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uB2E4\uC6B4\uB85C\uB4DC");
                    btnNewButton.setBounds(391, 240, 161, 23);
                    contentPane.add(btnNewButton);
                    PerCourse pc=new PerCourse();
                    pc.setSno(stuTemp.getsNo());
                    setTable(pc);
          }

          private void setTable(PerCourse pcou) {
                    dft_per = (DefaultTableModel) table_perCourse.getModel();
                    dft_per.setRowCount(0);
                    PerCourseDao pcDao=new PerCourseDao();
                    List<PerCourse> pcList = pcDao.getCourseList(pcou);
                    for(PerCourse pc : pcList){
                              Vector v=new Vector();
                              v.add(pc.getCouNo());
                              v.add(pc.getCouName());
                              v.add(pc.getProName());
                              v.add(pc.getCreditType());
                              v.add(pc.getLearnType());
                              v.add(pc.getClassNo());
                              v.add(pc.getTtcr());
                              dft_per.addRow(v);
                    }
                    pcDao.closeDao();
          }
          
}
