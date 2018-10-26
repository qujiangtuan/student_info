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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

import com.eltima.components.ui.DatePicker;
import com.qujia.dao.OpenCourseDao;
import com.qujia.dao.PerCourseDao;
import com.qujia.dao.StuCouDao;
import com.qujia.dao.StudentDao;
import com.qujia.model.PerCourse;
import com.qujia.model.StuCou;
import com.qujia.util.DateUtil;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class CourseListAdmFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_stu;
          private JTextField textField_cou;
          private JTextField textField_pro;
          private JTable table;
          private JTextField textField_upStu;
          private JTextField textField_upCou;
          private DefaultTableModel dft;
          private PerCourseDao pcDao;
          private static int row;
          private JTextField textField_sName;
          private JTextField textField_souNo;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  CourseListAdmFrm frame = new CourseListAdmFrm();
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
          public CourseListAdmFrm() {
                    setTitle("\uC218\uAC15\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 877, 476);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("학번/학생명:");
                    lblNewLabel.setBounds(51, 69, 86, 15);
                    
                    textField_stu = new JTextField();
                    textField_stu.setBounds(131, 66, 116, 21);
                    textField_stu.setColumns(10);
                    
                    JLabel lblNewLabel_1 = new JLabel("학수번호/교과목명:");
                    lblNewLabel_1.setBounds(259, 69, 129, 15);
                    
                    textField_cou = new JTextField();
                    textField_cou.setBounds(372, 66, 129, 21);
                    textField_cou.setColumns(10);
                    
                    JButton searchButton = new JButton("\uAC80 \uC0C9");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchCourseAction(e);
                              }
                    });
                    searchButton.setBounds(719, 65, 81, 23);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAD50\uC218\uBA85:");
                    lblNewLabel_2.setBounds(524, 69, 52, 15);
                    
                    textField_pro = new JTextField();
                    textField_pro.setBounds(571, 66, 115, 21);
                    textField_pro.setColumns(10);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 106, 832, 232);
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC2DC\uC791\uC77C\uC790:");
                    lblNewLabel_3.setBounds(51, 15, 116, 25);
                    
                    DatePicker datePicker = new DatePicker();
                    datePicker.setBounds(179, 15, 160, 25);
                    
                    JLabel label = new JLabel("\uC218\uAC15\uC2E0\uCCAD\uC885\uB8CC\uC77C\uC790:");
                    label.setBounds(427, 15, 129, 25);
                    
                    DatePicker datePicker_1 = new DatePicker();
                    datePicker_1.setBounds(561, 15, 160, 21);
                    
                    JLabel lblNewLabel_5 = new JLabel("\uD559\uC0DD\uD559\uBC88:");
                    lblNewLabel_5.setBounds(17, 360, 67, 15);
                    
                    textField_upStu = new JTextField();
                    textField_upStu.getDocument().addDocumentListener(new DocumentListener() {
                              String snoInput=null;
                              String snoOracle=null;
                              String snoName=null;
                              @Override
                              public void removeUpdate(DocumentEvent e) {
                                        Action(e);
                              }
                              @Override
                              public void insertUpdate(DocumentEvent e) {
                                        Action(e);
                              }
                              @Override
                              public void changedUpdate(DocumentEvent e) {
                                        Action(e);
                              }
                              private void Action(DocumentEvent e) {
                                        try {
                                                  snoInput = e.getDocument().getText(e.getDocument().getStartPosition().getOffset(), e.getDocument().getLength());
                                                  StudentDao sDao=new StudentDao();
                                                  snoName = sDao.getStuName(snoInput);
                                                  if(sDao.isStuNo(snoInput)){
                                                            textField_sName.setText(snoName);
                                                  }else{
                                                            textField_sName.setText("");
                                                  }
                                        } catch (BadLocationException e1) {
                                                  // TODO Auto-generated catch block
                                                  e1.printStackTrace();
                                        }
                                        
                              }
                    });
                    textField_upStu.setBounds(96, 357, 126, 21);
                    textField_upStu.setColumns(10);
                    
                    JButton btnNewButton_3 = new JButton("\uAE30\uAC04\uBCC0\uACBD");
                    btnNewButton_3.setBounds(733, 15, 105, 23);
                    
                    JLabel lblNewLabel_4 = new JLabel("\uD559\uC218\uBC88\uD638:");
                    lblNewLabel_4.setBounds(243, 360, 68, 15);
                    
                    textField_upCou = new JTextField();
                    textField_upCou.getDocument().addDocumentListener(new DocumentListener() {
                              String cnoInput=null;
                              String cnoOracle=null;
                              String cnoName=null;
                              @Override
                              public void removeUpdate(DocumentEvent e) {
                                        Action(e);
                              }
                              @Override
                              public void insertUpdate(DocumentEvent e) {
                                        Action(e);
                              }
                              @Override
                              public void changedUpdate(DocumentEvent e) {
                                        Action(e);
                              }
                              private void Action(DocumentEvent e) {
                                        try {
                                                  cnoInput = e.getDocument().getText(e.getDocument().getStartPosition().getOffset(), e.getDocument().getLength());
                                                  OpenCourseDao ocDao=new OpenCourseDao();
                                                  cnoName = ocDao.getCouName(cnoInput);
                                                  if(ocDao.isCouNo(cnoInput)){
                                                            textField_souNo.setText(cnoName);
                                                  }else{
                                                            textField_souNo.setText("");
                                                  }
                                        } catch (BadLocationException e1) {
                                                  // TODO Auto-generated catch block
                                                  e1.printStackTrace();
                                        }
                                        
                              }
                    });
                    textField_upCou.setBounds(323, 357, 178, 21);
                    textField_upCou.setColumns(10);
                    
                    JButton submitButton = new JButton("\uD655 \uC778");
                    submitButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        OtherApplyCourse(e);
                              }
                    });
                    submitButton.setBounds(544, 356, 86, 23);
                    
                    JButton deleteCouButton = new JButton("\uC218\uAC15\uC0AD\uC81C");
                    deleteCouButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteCourseAction(e);
                              }
                    });
                    deleteCouButton.setBounds(642, 356, 97, 23);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent arg0) {
                                        row=table.getSelectedRow();
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uB144\uB3C4", "\uD559\uAE30", "\uD559\uBC88", "\uD559\uC0DD\uBA85", "\uC18C\uC18D\uD559\uACFC", "\uD559\uC218\uBC88\uD638", "\uAC1C\uC124\uAD50\uACFC\uBAA9\uBA85", "\uC218\uAC15\uB300\uC0C1(\uD559\uBD80/\uACFC)", "\uBD84\uBC18", "\uB2F4\uB2F9\uAD50\uC218", "\uD559\uC810", "\uC2DC\uAC04/\uAC15\uC758\uC2E4"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, true, false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(3).setPreferredWidth(84);
                    table.getColumnModel().getColumn(4).setPreferredWidth(141);
                    table.getColumnModel().getColumn(5).setPreferredWidth(95);
                    table.getColumnModel().getColumn(6).setPreferredWidth(114);
                    table.getColumnModel().getColumn(7).setPreferredWidth(194);
                    table.getColumnModel().getColumn(8).setPreferredWidth(56);
                    table.getColumnModel().getColumn(10).setPreferredWidth(63);
                    table.getColumnModel().getColumn(11).setPreferredWidth(276);
                    contentPane.setLayout(null);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.add(scrollPane);
                    contentPane.add(lblNewLabel);
                    contentPane.add(textField_stu);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(textField_cou);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(textField_pro);
                    contentPane.add(lblNewLabel_3);
                    contentPane.add(datePicker);
                    contentPane.add(label);
                    contentPane.add(datePicker_1);
                    contentPane.add(searchButton);
                    contentPane.add(btnNewButton_3);
                    contentPane.add(lblNewLabel_5);
                    contentPane.add(textField_upStu);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(textField_upCou);
                    contentPane.add(submitButton);
                    contentPane.add(deleteCouButton);
                    
                    textField_sName = new JTextField();
                    textField_sName.setEditable(false);
                    textField_sName.setBounds(96, 388, 126, 21);
                    contentPane.add(textField_sName);
                    textField_sName.setColumns(10);
                    
                    textField_souNo = new JTextField();
                    textField_souNo.setEditable(false);
                    textField_souNo.setColumns(10);
                    textField_souNo.setBounds(323, 388, 178, 21);
                    contentPane.add(textField_souNo);
                    
                    setTable(new PerCourse());
          }
          //정원이 되면 학과사무실 수강신청
          protected void OtherApplyCourse(ActionEvent e) {
                    String sno=textField_upStu.getText().toString();
                    String sname=textField_sName.getText().toString();
                    String couNo=textField_upCou.getText().toString();
                    String couName = textField_souNo.getText().toString();
                    String applyDate=DateUtil.getTodayDate();
                    
                    StuCou sc=new StuCou();
                    sc.setSno(sno);
                    sc.setSname(sname);
                    sc.setCouNo(couNo);
                    sc.setCouName(couName);
                    sc.setApplyDate(applyDate);
                    
                    StuCouDao  scDao=new StuCouDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "학생 수강을 허용하겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(scDao.AddSC(sc)){
                                        JOptionPane.showMessageDialog(this, "학생 수강을 허용되었습니다!");
                              }else{
                                        JOptionPane.showMessageDialog(this, "학생 수강을 허용되지않 습니다!");
                              }
                    }
                    resetValue();
                    
          }
          //학번 /학수번호 초기화
          private void resetValue() {
                    textField_upStu.setText("");
                    textField_upCou.setText("");
          }

          protected void deleteCourseAction(ActionEvent e) {
                    row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    PerCourseDao pcDao=new PerCourseDao();
                    String sno=table.getValueAt(row, 2).toString();
                    String couNo=table.getValueAt(row, 5).toString();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수강을 삭제하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(pcDao.deleteCourse(sno,couNo)){
                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                              }else{
                                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                              }
                    }
                    
                    pcDao.closeDao();
                    setTable(new PerCourse());
                    
          }

          protected void searchCourseAction(ActionEvent e) {
                    PerCourse pc=new PerCourse();
                    String stu = textField_stu.getText().toString();
                    if(!("".equals(stu))){
                          if(StringUtil.isNumeric(stu)){
                                    pc.setSno(stu);
                          }else{
                                    pc.setsName(stu);
                          }
                    } 
                    //학수번호 /교과목명 검색
                    String cou = textField_cou.getText().toString();
                    if(!("".equals(cou))){
                          if(StringUtil.isNumeric(cou)){
                                    pc.setCouNo(cou);
                          }else{
                                    pc.setCouName(cou);
                          }
                    } 
                    //교수명 검색
                    String pro=textField_pro.getText().toString();
                    if(!("".equals(pro))){
                              pc.setProName(pro);
                    }
                    setTable(pc);
//                    setTable(new PerCourse());
          }

          private void setTable(PerCourse perCourse) {
                    dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    pcDao=new PerCourseDao();
                    List<PerCourse> pcList = pcDao.getCourseList(perCourse);
                    for(PerCourse pc : pcList){
                              Vector v=new Vector();
                              v.add(pc.getYear());
                              v.add(pc.getTerm());
                              v.add(pc.getSno());
                              v.add(this.getStudentName(pc.getSno()));
                              v.add(pc.getStuDept());
                              v.add(pc.getCouNo());
                              v.add(pc.getCouName());
                              v.add(pc.getCouDept());
                              v.add(pc.getClassNo());
                              v.add(pc.getProName());
                              v.add(pc.getCreditType());
                              v.add(pc.getTtcr());
                              dft.addRow(v);
                    }
                    pcDao.closeDao();
          }
          // 학생번호에 통해서 학생이름을 찾는다.
          private String getStudentName(String sno) {
                    StudentDao sDao=new StudentDao();
                    String stuName=sDao.getStuName(sno);
                    return stuName;
          }
}
