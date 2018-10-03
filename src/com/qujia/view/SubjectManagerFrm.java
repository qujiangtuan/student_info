package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.SubjectsDao;
import com.qujia.model.Org;
import com.qujia.model.Subjects;
import com.qujia.util.ViewUtil;

public class SubjectManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_2;
          private JTable table;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SubjectManagerFrm frame = new SubjectManagerFrm();
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
          public SubjectManagerFrm() {
                    setTitle("\uAD50\uACFC\uBAA9\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 736, 641);
                    
                  ViewUtil vu=new ViewUtil();
                     vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC774\uC218\uAD6C\uBD84:");
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JComboBox comboBox = new JComboBox();
                    comboBox.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uD544", "\uC804\uC120", "\uAD50\uD544", "\uAD50\uC120"}));
                    
                    JLabel label_1 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uB300       \uC0C1:");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JComboBox comboBox_1 = new JComboBox();
                    comboBox_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\uB300\uD559", "\uB300\uD559\uC6D0"}));
                    
                    JComboBox comboBox_2 = new JComboBox();
                    comboBox_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"3", "2", "1"}));
                    
                    JLabel lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uBA85:");
                    
                    textField_2 = new JTextField();
                    textField_2.setColumns(10);
                    
                    JButton btnNewButton_2 = new JButton("\uAC80   \uC0C9");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel label_2 = new JLabel("\uC124       \uBA85:");
                    label_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton btnNewButton = new JButton("\uC218   \uC815");
                    btnNewButton.setBackground(new Color(176, 224, 230));
                    btnNewButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton btnNewButton_1 = new JButton("\uC0AD   \uC81C");
                    btnNewButton_1.setBackground(new Color(255, 127, 80));
                    btnNewButton_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(30)
                                                  .addComponent(lblNewLabel_6)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(49)
                                                  .addComponent(btnNewButton_2)
                                                  .addContainerGap(178, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                                                  .addContainerGap())
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(20)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(btnNewButton)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(label_1)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(comboBox_2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                  .addGap(100)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(btnNewButton_1)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(label_2)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                  .addGap(129))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_6)
                                                            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnNewButton_2))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_2)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_1))))
                                                  .addGap(34)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(btnNewButton)
                                                            .addComponent(btnNewButton_1))
                                                  .addGap(88))
                    );
                    
                    JTextArea textArea = new JTextArea();
                    scrollPane_1.setViewportView(textArea);
                    
                    table = new JTable();
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAD50\uACFC\uBAA9\uCF54\uB4DC", "\uAD50\uACFC\uBAA9\uBA85", "\uC601\uC5B4\uBA85", "\uC57D\uC5B4\uBA85", "\uB300\uC0C1\uAD6C\uBD84", "\uC774\uC218\uAD6C\uBD84", "\uC774\uC218\uD559\uC810", "\uAC1C\uC124\uBD80\uC11C", "\uC124\uBA85"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(133);
                    table.getColumnModel().getColumn(2).setPreferredWidth(142);
                    table.getColumnModel().getColumn(4).setPreferredWidth(64);
                    table.getColumnModel().getColumn(6).setPreferredWidth(61);
                    table.getColumnModel().getColumn(7).setPreferredWidth(111);
                    table.getColumnModel().getColumn(8).setPreferredWidth(134);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                  
                  setTable(new Subjects());
          }
          //setTable()
          private void setTable(Subjects subjects) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    SubjectsDao sbDao=new SubjectsDao();
                    List<Subjects> abList = sbDao.getSubjectsList(new Subjects());
                    for(Subjects sb : abList){
                              Vector v=new Vector();
                              v.add(sb.getSubCode());
                              v.add(sb.getSubName());
                              v.add(sb.getSubEname());
                              v.add(sb.getSubMname());
                              v.add(sb.getColType());
                              v.add(sb.getLearnType());
                              v.add(sb.getCreditType());
                              v.add(this.getDeptNameById(sb.getOrgId()));
                              v.add(sb.getSubExp());
                              dft.addRow(v);
                    }
                    sbDao.closeDao();
          }
        //orgid에 통해서 deptName를 받는다
          public String getDeptNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    List<Org> orgList = orgDao.getOrgdeptNameList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
          
}
