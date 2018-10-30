package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.ProCourseDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.dao.StuCourseViewDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.StuCourseView;
import com.qujia.model.Student;
import com.qujia.util.ViewUtil;

public class CourseListStuFrm extends JFrame {

          private JPanel contentPane;
          private JTable table_perCourse;
          private DefaultTableModel dft_per;
          private Student student,stuTemp;
          private static int index;
          private DefaultTableModel dft;     
          private JLabel userName;
          private JLabel deptName;
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
                    this.setResizable(false);
                 // get login user info 
                    student =(Student) MainFrm.userObject;
                    StudentDao stuDao=new StudentDao();
                    stuTemp=stuDao.login(student);
                    
                    
                    setTitle("\uC218\uAC15\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 789, 365);
                    
                    ViewUtil vu = new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 47, 751, 213);
                    contentPane.add(scrollPane);
                    
                    table_perCourse = new JTable();
                    table_perCourse.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent arg0) {
                                        index=table_perCourse.getSelectedRow();
                              }
                    });
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
                    
                    userName = new JLabel("\uAE40\uC0C1\uBBFC");
                    userName.setText(stuTemp.getName());
                    userName.setBounds(93, 10, 109, 15);
                    contentPane.add(userName);
                    
                    JButton btnNewButton = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uB2E4\uC6B4\uB85C\uB4DC");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        DownloadFileFileChooserAction(e);
                              }
                    });
                    btnNewButton.setBounds(423, 279, 161, 23);
                    contentPane.add(btnNewButton);
                    
                    JLabel lblNewLabel_1 = new JLabel("학과:");
                    lblNewLabel_1.setBounds(214, 10, 57, 15);
                    contentPane.add(lblNewLabel_1);
                    
                    deptName = new JLabel("컴공");
                    deptName.setText(stuTemp.getDeptName());
                    deptName.setBounds(263, 10, 168, 15);
                    contentPane.add(deptName);
                    
                    JButton btnNewButton_1 = new JButton("닫기");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    btnNewButton_1.setBounds(651, 279, 97, 23);
                    contentPane.add(btnNewButton_1);
                    
                    dft = (DefaultTableModel) table_perCourse.getModel();
                    
                    
                    StuCourseView cv=new StuCourseView();
                    cv.setSno(stuTemp.getsNo());
                    setTable(cv);
          }

          protected void DownloadFileFileChooserAction(ActionEvent e) {
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "파일을 선택해주세요!");
                              return;
                    }
                    String couNo = dft.getValueAt(index, 0).toString();
                    String proName = dft.getValueAt(index, 2).toString();
                    String pno = this.getProName(proName);
                    String fileName;
                    try {
                              fileName = dft.getValueAt(index, 7).toString();
                    } catch (Exception e2) {
                              JOptionPane.showMessageDialog(this, "첨부 파일이 없습니다!");
                              return;
                    }
                    //파일 선택
                    JFileChooser jfc=new JFileChooser();  
                    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
                    jfc.showDialog(new JLabel(), "폴더 선택");  
                    File file=jfc.getSelectedFile();  
                    try {
                              if(file.isDirectory()){
                                        String Path = file.getAbsolutePath()+"/";
                                        String absolutePath=Path.replaceAll("\\\\", "/");
                                        ProCourseDao pcDao=new ProCourseDao();
                                        if(pcDao.downFile(absolutePath,fileName,couNo,pno)){
                                                  JOptionPane.showMessageDialog(this, "첨부 파일이 다운로드되었습니다! \n 파일 위치 : " +absolutePath+fileName);
                                                  return;
                                        }else{
                                                  JOptionPane.showMessageDialog(this, "첨부 파일 다운로드가 실패되었습니다!");
                                                  return;
                                        }
                              }else if(file.isFile()){ 
                                        JOptionPane.showMessageDialog(this, "파일를 선택하면 안된니다,폴더를 선택해주세요!");
                                        return;
                              }    
                    } catch (Exception e2) {
                             return;
                    }
                    
          }

          private String getProName(String proName) {
                   ProStaffDao psDao=new ProStaffDao();
                   String proId = psDao.getProId(proName);
                    return proId;
          }

          private void setTable(StuCourseView pcou) {
                    dft_per = (DefaultTableModel) table_perCourse.getModel();
                    dft_per.setRowCount(0);
                    StuCourseViewDao cvDao=new StuCourseViewDao();
                    List<StuCourseView> cvList = cvDao.getCourseViewList(pcou);
                    for(StuCourseView cv : cvList){
                              Vector v=new Vector();
                              v.add(cv.getCouNo());
                              v.add(cv.getCouName());
                              v.add(cv.getProName());
                              v.add(cv.getCreditType());
                              v.add(cv.getLearnType());
                              v.add(cv.getClassNo());
                              v.add(cv.getTtcr());
                              v.add(cv.getName());
                              dft_per.addRow(v);
                    }
                    cvDao.closeDao();
          }
}
