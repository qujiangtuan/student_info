package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.PerCourseDao;
import com.qujia.dao.StuCouScoreViewDao;
import com.qujia.model.PerCourse;
import com.qujia.model.StuCouScoreView;
import com.qujia.util.ViewUtil;

public class ScoreEvalutionFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JDesktopPane desktopPane;
          private JLabel couName_lable;
          private JLabel stuCounts;
          private JLabel lblNewLabel_2;
          private JLabel stuNameLabel;
          private JLabel lblNewLabel_5;
          private JComboBox comboBox_score;
          private JButton btnNewButton;
          private static int index;
          private String[] score;
          private DefaultTableModel dft;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreEvalutionFrm frame = new ScoreEvalutionFrm();
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
          public ScoreEvalutionFrm() {
                    this.setResizable(false);
                    setTitle("\uC131\uC801\uD3C9\uAC00");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 699, 474);
                    
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uACFC\uBAA9\uBA85:");
                    lblNewLabel.setBounds(17, 19, 50, 15);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uC0DD\uC218:");
                    lblNewLabel_1.setBounds(291, 19, 52, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 44, 649, 316);
                    
                    desktopPane = new JDesktopPane();
                    desktopPane.setBounds(416, 15, 1, 1);
                    
                    couName_lable = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4 \uC2E4\uC2B5");
                    couName_lable.setText(CourseListProFrm.getCouName());
                    couName_lable.setBounds(79, 19, 186, 15);
                    
                    stuCounts = new JLabel("1");
                    stuCounts.setText(this.getCounts(CourseListProFrm.getCouno()));
                    stuCounts.setBounds(349, 19, 68, 15);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectRowAction(e);
                              }
                    });
                    table.setRowHeight(30);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uC0DD\uBA85", "\uD559\uBC88", "\uC18C\uC18D\uD559\uACFC", "\uD559\uB144", "\uC131\uC801"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(112);
                    table.getColumnModel().getColumn(2).setPreferredWidth(121);
                    table.getColumnModel().getColumn(3).setPreferredWidth(59);
                    table.getColumnModel().getColumn(4).setPreferredWidth(97);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(couName_lable);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(stuCounts);
                    contentPane.add(desktopPane);
                    contentPane.add(scrollPane);
                    
                    lblNewLabel_2 = new JLabel("학생명:");
                    lblNewLabel_2.setBounds(17, 394, 57, 15);
                    contentPane.add(lblNewLabel_2);
                    
                    stuNameLabel = new JLabel("");
                    stuNameLabel.setBounds(79, 394, 97, 15);
                    contentPane.add(stuNameLabel);
                    
                    lblNewLabel_5 = new JLabel("성적입력:");
                    lblNewLabel_5.setBounds(267, 394, 66, 15);
                    contentPane.add(lblNewLabel_5);
                    
                    comboBox_score = new JComboBox();
                    score=new String[] {"", "A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
                    comboBox_score.setModel(new DefaultComboBoxModel(score));
                    comboBox_score.setBounds(331, 391, 84, 21);
                    contentPane.add(comboBox_score);
                    
                    btnNewButton = new JButton("성적입력");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateScoreAction(e);
                              }
                    });
                    btnNewButton.setBounds(451, 390, 112, 23);
                    contentPane.add(btnNewButton);
                    
                    JButton btnNewButton_1 = new JButton("닫기");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                         dispose();
                              }
                    });
                    btnNewButton_1.setBounds(584, 390, 84, 23);
                    contentPane.add(btnNewButton_1);
                    
                    dft = (DefaultTableModel) table.getModel();
                    
                    StuCouScoreView sc=new StuCouScoreView();
                    sc.setCouNo(CourseListProFrm.getCouno());
                    setTable(sc);
          }
          protected void updateScoreAction(ActionEvent e) {
                    String sno = dft.getValueAt(index, 1).toString();
                    String couNo=CourseListProFrm.getCouno();
                    String grade = comboBox_score.getSelectedItem().toString();
                    double score=0;
                    switch (grade) {
                    case "A+":
                              score=4.5;
                              break;
                    case "A0":
                              score=4.0;
                              break;
                    case "B+":
                              score=3.5;
                              break;
                    case "B0":
                              score=3.0;
                              break;
                    case "C+":
                              score=2.5;
                              break;
                    case "C0":
                              score=2.0;
                              break;     
                    case "D+":
                              score=1.5;
                              break;
                    case "D0":
                              score=1.0;
                              break;       
                    case "F":
                              score=0;
                              break;             
                    default:
                              score=0;
                              break;
                    }
                    PerCourse ss=new PerCourse();
                    ss.setSno(sno);
                    ss.setCouNo(couNo);
                    ss.setGrade(grade);
                    ss.setScore(score);
                    PerCourseDao pcDao=new PerCourseDao();
                    if(pcDao.UpdateScore(ss)){
                              JOptionPane.showMessageDialog(this, "성적이 저정되었습니다.");
                              StuCouScoreView sc=new StuCouScoreView();
                              sc.setCouNo(CourseListProFrm.getCouno());
                              setTable(sc);
                              resetValue();
                              return;
                    }else{
                              JOptionPane.showMessageDialog(this, "성적이 저정되지 않습니다.");
                              return;
                    }
          }

          private void resetValue() {
                    stuNameLabel.setText("");
                    comboBox_score.setSelectedIndex(0);
          }

          protected void selectRowAction(MouseEvent e) {
                    index=table.getSelectedRow();
                    String couName = dft.getValueAt(index, 0).toString();
                    stuNameLabel.setText(couName);
                    String scoreData=null;
                    try {
                              scoreData=dft.getValueAt(index, 4).toString();
                    } catch (Exception e2) {
                              scoreData=null;
                    }
                    if(scoreData==null){
                              comboBox_score.setSelectedIndex(0);
                    }else{
                              for(int i=0;i<comboBox_score.getItemCount();i++){
                                        if(scoreData.equals(score[i])){
                                                  comboBox_score.setSelectedIndex(i);
                                        }
                              }
                    }
          }

          private void setTable(StuCouScoreView scsv) {
                    dft.setRowCount(0);
                    StuCouScoreViewDao scDao=new StuCouScoreViewDao();
                    List<StuCouScoreView> abList = scDao.getScsvList(scsv);
                    for(StuCouScoreView sb : abList){
                              Vector v=new Vector();
                              v.add(sb.getName());
                              v.add(sb.getSno());
                              v.add(this.getDeptNameById(sb.getOrgid()));
                              v.add(sb.getSchYear());
                              v.add(sb.getGrade());
                              dft.addRow(v);
                    }
                    scDao.closeDao();
          }

          private String getDeptNameById(String orgid) {
                    OrgDao orgDao=new OrgDao();
                    String orgName=orgDao.getOrgName(orgid);
                    return orgName;
          }
          private String getCounts(String couno) {
                    StuCouScoreViewDao scDao=new StuCouScoreViewDao();
                    String count=scDao.getCounts(couno);
                    return count;
          }
}
