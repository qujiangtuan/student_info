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

import com.qujia.dao.PerCourseDao;
import com.qujia.dao.ProCourseDao;
import com.qujia.dao.ProCourseViewDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.model.ProCourseView;
import com.qujia.model.ProStaff;
import com.qujia.util.ViewUtil;

public class CourseListProFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private ProStaff pro,proTemp;
          private DefaultTableModel dft_per;
          private static int index=-1;
          private DefaultTableModel dft;
          private ProCourseView cv;
          private JLabel userName;
          private static String couno=null;
          private static String couName=null;
          
          
          
          public static String getCouName() {
                    return couName;
          }

          public static void setCouName(String couName) {
                    CourseListProFrm.couName = couName;
          }

          public static String getCouno() {
                    return couno;
          }

          public static void setCouno(String couno) {
                    CourseListProFrm.couno = couno;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseListProFrm frame = new CourseListProFrm();
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
          public CourseListProFrm() {
                    this.setResizable(false);
                 // get login user info 
                    pro =(ProStaff) MainFrm.userObject;
                    ProStaffDao psDao=new ProStaffDao();
                    proTemp=psDao.login(pro);
                    
                    setTitle("\uAC15\uC758\uBAA9\uB85D");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 742, 334);
                    
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("\uC774\uB984:");
                    label.setBounds(25, 15, 56, 15);
                    
                    userName = new JLabel("\uAE40 * *");
                    userName.setText(proTemp.getpName());
                    userName.setBounds(93, 15, 99, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(5, 48, 715, 167);
                    
                    JButton button = new JButton("학생목록");
                    button.setBounds(15, 233, 99, 23);
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(index==-1){
                                                  JOptionPane.showMessageDialog(null, "강의를 선택해주세요!");
                                                  return;
                                        }
                                        couno = dft.getValueAt(index, 0).toString();
                                        couName=dft.getValueAt(index, 1).toString();
                                        ScoreShowForProFrm ssfp=new ScoreShowForProFrm();
                                        ssfp.setVisible(true);
                              }
                    });
                    
                    JButton btnNewButton = new JButton("\uC131\uC801\uD391\uAC00");
                    btnNewButton.setBounds(123, 233, 99, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        if(index==-1){
                                                  JOptionPane.showMessageDialog(null, "강의를 선택해주세요!");
                                                  return;
                                        }
                                        couno = dft.getValueAt(index, 0).toString();
                                        couName=dft.getValueAt(index, 1).toString();
                                        ScoreEvalutionFrm sef=new ScoreEvalutionFrm();
                                        sef.setVisible(true);
                              }
                    });
                    
                    JButton btnNewButton_1 = new JButton("강의계획서 다운로드");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        DownloadFileFileChooserAction(e);
                              }
                    });
                    btnNewButton_1.setBounds(410, 233, 158, 23);
                    
                    JButton button_1 = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uC5C5\uB85C\uB4DC");
                    button_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        UploadFileChooserAction(e);
                              }
                    });
                    button_1.setBounds(250, 233, 148, 23);
                    
                    JButton btnNewButton_2 = new JButton("\uAC15\uC758\uACC4\uD68D\uC11C \uC0AD\uC81C");
                    btnNewButton_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteFileAction(e);
                              }
                    });
                    btnNewButton_2.setBounds(586, 233, 134, 23);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent arg0) {
                                        index=table.getSelectedRow();
                              }
                    });
                    table.setRowHeight(30);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uC218\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uC2DC\uAC04/\uAC15\uC758\uC2E4", "\uAC15\uC758\uD3C9\uAC00\uACB0\uACFC", "\uAC15\uC758\uACC4\uD68D\uC11C"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(82);
                    table.getColumnModel().getColumn(1).setPreferredWidth(157);
                    table.getColumnModel().getColumn(2).setPreferredWidth(49);
                    table.getColumnModel().getColumn(3).setPreferredWidth(288);
                    table.getColumnModel().getColumn(4).setPreferredWidth(99);
                    table.getColumnModel().getColumn(5).setPreferredWidth(149);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(label);
                    contentPane.add(userName);
                    contentPane.add(button);
                    contentPane.add(btnNewButton);
                    contentPane.add(button_1);
                    contentPane.add(btnNewButton_1);
                    contentPane.add(btnNewButton_2);
                    contentPane.add(scrollPane);
                    
                    JButton btnNewButton_3 = new JButton("닫기");
                    btnNewButton_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                                       couName=null;
                                       couno=null;
                              }
                    });
                    btnNewButton_3.setBounds(623, 272, 97, 23);
                    contentPane.add(btnNewButton_3);
                    
                    JButton btnNewButton_4 = new JButton("평가결과");
                    btnNewButton_4.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent arg0) {
                                        if(index==-1){
                                                  JOptionPane.showMessageDialog(null, "강의를 선택해주세요!");
                                                  return;
                                        }
                                        couno = dft.getValueAt(index, 0).toString();
                                        couName=dft.getValueAt(index, 1).toString();
//                                        ScoreShowForProFrm ssfp=new ScoreShowForProFrm();
//                                        ssfp.setVisible(true);
                                        EvaResultShowForProFrm eva=new EvaResultShowForProFrm();
                                        eva.setVisible(true);
                              }
                    });
                    btnNewButton_4.setBounds(15, 272, 97, 23);
                    contentPane.add(btnNewButton_4);
                    
                    dft = (DefaultTableModel) table.getModel();
                    
                    cv=new ProCourseView();
                    cv.setPno(proTemp.getpNo());
                    setTable(cv);
          }

          protected void deleteFileAction(ActionEvent e) {
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 파일을 선택해주세요!");
                              return;
                    }
                    String couNo = dft.getValueAt(index, 0).toString();
                    String pno = proTemp.getpNo();
                    String fileName;
                    try {
                              fileName = dft.getValueAt(index, 5).toString();
                    } catch (Exception e2) {
                              JOptionPane.showMessageDialog(this, "첨부 파일이 없습니다!");
                              return;
                    }
                    ProCourseDao pcDao=new ProCourseDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "첨부 파일을 삭제하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(pcDao.deleteFile(couNo,pno)){
                                        JOptionPane.showMessageDialog(this, "첨부 파일이 삭제되었습니다!");
                                        setTable(cv);
                                        return;
                              }else{
                                        JOptionPane.showMessageDialog(this, "첨부 파일 삭제가 실패되었습니다!");
                                        return;
                              }
                    }
          }

          protected void DownloadFileFileChooserAction(ActionEvent e) {
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "파일을 선택해주세요!");
                              return;
                    }
                    String couNo = dft.getValueAt(index, 0).toString();
                    String pno = proTemp.getpNo();
                    String fileName;
                    try {
                              fileName = dft.getValueAt(index, 5).toString();
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

          protected void UploadFileChooserAction(ActionEvent e) {
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "과목을 선택해주세요!");
                              return;
                    }
                    String couNo = dft.getValueAt(index, 0).toString();
                    String pno = proTemp.getpNo();
                    
                    //파일 선택
                    JFileChooser jfc=new JFileChooser();  
                    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
                    jfc.showDialog(new JLabel(), "파일 선택");  
                    File file=jfc.getSelectedFile();  
                    try {
                              if(file.isDirectory()){  
                                        JOptionPane.showConfirmDialog(this, "폴더를 선택하면 안된니다,파일을 선택해주세요!");
                                        return;
                              }else if(file.isFile()){ 
                                        ProCourseDao pcDao=new ProCourseDao();
                                        if(pcDao.insertFile(file,couNo,pno)){
                                                  JOptionPane.showMessageDialog(this, "첨부 파일이 업로드되었습니다!");
                                                  setTable(cv);
                                                  return;
                                        }else{
                                                  JOptionPane.showMessageDialog(this, "첨부 파일 업로드가 실패되었습니다!");
                                                  return;
                                        }
                              }  
                    } catch (Exception e2) {
                              return;
                    }
          }

          private void setTable(ProCourseView cv2) {
                    dft_per = (DefaultTableModel) table.getModel();
                    dft_per.setRowCount(0);
                    ProCourseViewDao cvDao=new ProCourseViewDao();
                    List<ProCourseView> cvList = cvDao.getCourseViewList(cv2);
                    for(ProCourseView cv : cvList){
                              Vector v=new Vector();
                              v.add(cv.getCouNo());
                              v.add(cv.getCouName());
                              v.add(cv.getClassNo());
                              v.add(cv.getTtcr());
//                              v.add(cv.getLecEvaMark());
                              v.add(this.getProScore(cv.getCouNo()));
                              v.add(cv.getName());
                              dft_per.addRow(v);
                    }
                    cvDao.closeDao();
                    
          }

          private double getProScore(String couNo2) {
                    PerCourseDao pcDao=new PerCourseDao();
                    double avg=pcDao.getCouAvg(couNo2);
                    return avg;
          }

}
