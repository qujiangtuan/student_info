package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.qujia.dao.OrgDao;
import com.qujia.dao.StuCouScoreViewDao;
import com.qujia.model.StuCouScoreView;
import com.qujia.util.ViewUtil;

public class ScoreShowForProFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JLabel couName_label,stuCounts;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreShowForProFrm frame = new ScoreShowForProFrm();
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
          public ScoreShowForProFrm() {
                    this.setResizable(false);
                    setTitle("학생목록");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 754, 461);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAC15\uC758\uBA85:");
                    lblNewLabel.setBounds(32, 25, 59, 15);
                    
                    couName_label = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4");
                    couName_label.setText(CourseListProFrm.getCouName());
                    couName_label.setBounds(88, 25, 116, 15);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD559\uC0DD\uBA85\uC218:");
                    lblNewLabel_2.setBounds(256, 25, 61, 15);
                    
                    stuCounts = new JLabel("35");
                    stuCounts.setText(this.getCounts(CourseListProFrm.getCouno()));
                    stuCounts.setBounds(329, 25, 129, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 63, 713, 313);
                    contentPane.setLayout(null);
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uBC88", "\uD559\uC0DD\uBA85", "\uC18C\uC18D\uD559\uACFC", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C", "\uD559\uB144"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, true, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(115);
                    table.getColumnModel().getColumn(1).setPreferredWidth(129);
                    table.getColumnModel().getColumn(2).setPreferredWidth(164);
                    table.getColumnModel().getColumn(3).setPreferredWidth(134);
                    table.getColumnModel().getColumn(4).setPreferredWidth(122);
                    table.getColumnModel().getColumn(5).setPreferredWidth(97);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    contentPane.add(scrollPane);
                    contentPane.add(lblNewLabel);
                    contentPane.add(couName_label);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(stuCounts);
                    
                    JButton btnNewButton_1 = new JButton("닫기");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        dispose();
                              }
                    });
                    btnNewButton_1.setBounds(628, 399, 97, 23);
                    contentPane.add(btnNewButton_1);
                    StuCouScoreView sc=new StuCouScoreView();
                    sc.setCouNo(CourseListProFrm.getCouno());
                    setTable(sc);
          }

          private String getCounts(String couno) {
                    StuCouScoreViewDao scDao=new StuCouScoreViewDao();
                    String count=scDao.getCounts(couno);
                    return count;
          }

          private void setTable(StuCouScoreView scsv) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    StuCouScoreViewDao scDao=new StuCouScoreViewDao();
                    List<StuCouScoreView> abList = scDao.getScsvList(scsv);
                    for(StuCouScoreView sb : abList){
                              Vector v=new Vector();
                              v.add(sb.getSno());
                              v.add(sb.getName());
                              v.add(this.getDeptNameById(sb.getOrgid()));
                              v.add(sb.getTel());
                              v.add(sb.getEmail());
                              v.add(sb.getSchYear());
                              dft.addRow(v);
                    }
                    scDao.closeDao();
          }

          private String getDeptNameById(String orgid) {
                    OrgDao orgDao=new OrgDao();
                    String orgName=orgDao.getOrgName(orgid);
                    return orgName;
          }
}
