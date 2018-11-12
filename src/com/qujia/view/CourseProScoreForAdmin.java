package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.PerCourseDao;
import com.qujia.dao.ProCourseViewDao;
import com.qujia.model.ProCourseView;
import com.qujia.model.ProStaff;
import com.qujia.util.ViewUtil;

public class CourseProScoreForAdmin extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private ProStaff pro,proTemp;
          private DefaultTableModel dft_per;
          private static int index=-1;
          private DefaultTableModel dft;
          private ProCourseView cv;
          private static String couno=null;
          private static String couName=null;
          private JTextField textField_proName;
          private JTextField textField_couName;
          
          
          
          public static String getCouName() {
                    return couName;
          }

          public static void setCouName(String couName) {
                    CourseProScoreForAdmin.couName = couName;
          }

          public static String getCouno() {
                    return couno;
          }

          public static void setCouno(String couno) {
                    CourseProScoreForAdmin.couno = couno;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseProScoreForAdmin frame = new CourseProScoreForAdmin();
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
          public CourseProScoreForAdmin() {
                    this.setResizable(false);
                 // get login user info 
//                    pro =(ProStaff) MainFrm.userObject;
//                    ProStaffDao psDao=new ProStaffDao();
//                    proTemp=psDao.login(pro);
                    
                    setTitle("강의평가결과");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 742, 314);
                    
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel label = new JLabel("교수명:");
                    label.setBounds(25, 15, 56, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(5, 48, 715, 167);
                    
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
                                        "\uAD50\uC218\uBC88\uD638", "\uAD50\uC218\uBA85", "\uD559\uC218\uBC88\uD638", "\uAD50\uACFC\uBAA9\uBA85", "\uBD84\uBC18", "\uAC15\uC758\uD3C9\uAC00\uACB0\uACFC"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(107);
                    table.getColumnModel().getColumn(2).setPreferredWidth(82);
                    table.getColumnModel().getColumn(3).setPreferredWidth(157);
                    table.getColumnModel().getColumn(4).setPreferredWidth(49);
                    table.getColumnModel().getColumn(5).setPreferredWidth(99);
                    scrollPane.setViewportView(table);
//                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
//                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.setLayout(null);
                    contentPane.add(label);
                    contentPane.add(scrollPane);
                    
                    JButton btnNewButton_3 = new JButton("닫기");
                    btnNewButton_3.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    btnNewButton_3.setBounds(623, 236, 97, 23);
                    contentPane.add(btnNewButton_3);
                    
                    textField_proName = new JTextField();
                    textField_proName.setBounds(82, 12, 116, 21);
                    contentPane.add(textField_proName);
                    textField_proName.setColumns(10);
                    
                    JLabel lblNewLabel = new JLabel("교과목명:");
                    lblNewLabel.setBounds(231, 15, 57, 15);
                    contentPane.add(lblNewLabel);
                    
                    textField_couName = new JTextField();
                    textField_couName.setColumns(10);
                    textField_couName.setBounds(298, 12, 116, 21);
                    contentPane.add(textField_couName);
                    
                    JButton btnNewButton = new JButton("검색");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        String proName = textField_proName.getText().toString();
                                        String couName = textField_couName.getText().toString();
                                        ProCourseView cv=new ProCourseView();
                                        cv.setProName(proName);
                                        cv.setCouName(couName);
                                        setTable(cv);
                              }
                    });
                    btnNewButton.setBounds(480, 11, 97, 23);
                    contentPane.add(btnNewButton);
                    
                    dft = (DefaultTableModel) table.getModel();
                    
//                    cv=new ProCourseView();
//                    cv.setPno(proTemp.getpNo());
                    setTable(new ProCourseView());
          }

          private void setTable(ProCourseView cv2) {
                    dft_per = (DefaultTableModel) table.getModel();
                    dft_per.setRowCount(0);
                    ProCourseViewDao cvDao=new ProCourseViewDao();
                    List<ProCourseView> cvList = cvDao.getCourseViewList(cv2);
                    for(ProCourseView cv : cvList){
                              Vector v=new Vector();
                              v.add(cv.getPno());
                              v.add(cv.getProName());
                              v.add(cv.getCouNo());
                              v.add(cv.getCouName());
                              v.add(cv.getClassNo());
//                              v.add(cv.getTtcr());
//                              v.add(cv.getLecEvaMark());
                              v.add(this.getProScore(cv.getCouNo()));
//                              v.add(cv.getName());
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
