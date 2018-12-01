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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.StuCouScoreViewDao;
import com.qujia.model.StuCouScoreView;
import com.qujia.util.StringUtil;
import com.qujia.util.ViewUtil;

public class EvaResultShowForProFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JLabel couName_label,stuCounts;
          private JTextArea textArea;
          private String counoPro=null ;
          private String counoAdm=null ;
          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  EvaResultShowForProFrm frame = new EvaResultShowForProFrm();
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
          public EvaResultShowForProFrm() {
                    this.setResizable(false);
                    setTitle("주관식평가결과보기");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 664, 510);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uAC15\uC758\uBA85:");
                    lblNewLabel.setBounds(32, 25, 59, 15);
                    
                    couName_label = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4");
                    String couNamePro = CourseListProFrm.getCouName();
                    String couNameAdm=CourseProScoreForAdmin.getCouName();
                    if(!StringUtil.isEmpty(couNamePro)){
                              couName_label.setText(couNamePro);
                    }else if(!StringUtil.isEmpty(couNameAdm)){
                              couName_label.setText(couNameAdm);
                    }
                   
                    couName_label.setBounds(88, 25, 156, 15);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uD559\uC0DD\uBA85\uC218:");
                    lblNewLabel_2.setBounds(256, 25, 61, 15);
                    
                    stuCounts = new JLabel("35");
                
//                     counoPro = CourseListProFrm.getCouno();
//                     counoAdm = CourseProScoreForAdmin.getCouno();
//                    if(!StringUtil.isEmpty(counoPro)){
//                              stuCounts.setText(this.getCounts(counoPro));
//                    }else if(!StringUtil.isEmpty(counoAdm)){
//                              stuCounts.setText(this.getCounts(counoAdm));
//                    }
                   
                    stuCounts.setBounds(329, 25, 129, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 63, 631, 313);
                    contentPane.setLayout(null);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectRow(e);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null},
                              },
                              new String[] {
                                        "\uC8FC\uAD00\uC2DD \uD3C9\uAC00\uB2F5\uC548"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(636);
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
                    btnNewButton_1.setBounds(549, 448, 97, 23);
                    contentPane.add(btnNewButton_1);
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    scrollPane_1.setBounds(17, 389, 516, 82);
                    contentPane.add(scrollPane_1);
                    
                    textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    scrollPane_1.setViewportView(textArea);
                    
                    StuCouScoreView sc=new StuCouScoreView();
                    counoPro = CourseListProFrm.getCouno();
                    counoAdm = CourseProScoreForAdmin.getCouno();
                   if(!StringUtil.isEmpty(counoPro)){
                             stuCounts.setText(this.getCounts(counoPro));
                             sc.setCouNo(counoPro);
                   }else if(!StringUtil.isEmpty(counoAdm)){
                             stuCounts.setText(this.getCounts(counoAdm));
                             sc.setCouNo(counoAdm);
                   }
                   
                    setTable(sc);
          }

          protected void selectRow(MouseEvent e) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    int row =table.getSelectedRow();
                    String eva=null;
                    try {
                              eva = dft.getValueAt(row, 0).toString();
                    } catch (Exception e2) {
                             eva=null;
                    }
                    textArea.setText(eva);
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
                              v.add(sb.getEva());
//                              v.add(sb.getSno());
//                              v.add(sb.getName());
//                              v.add(this.getDeptNameById(sb.getOrgid()));
//                              v.add(sb.getTel());
//                              v.add(sb.getEmail());
//                              v.add(sb.getSchYear());
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
