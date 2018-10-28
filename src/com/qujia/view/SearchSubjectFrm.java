package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.SubjectsDao;
import com.qujia.model.Org;
import com.qujia.model.Subjects;
import com.qujia.util.ViewUtil;

public class SearchSubjectFrm extends JDialog {

          private JPanel contentPane;
          private JTextField textField_searchSub;
          private JTable table;
          private List<Org> orgList;
          private  String[] learnType,credit,colType;
          private ButtonGroup bgoup;
          private JCheckBox deptCheckBox;
          private JTextField textField_searchDept;
          private static int index=-1;
          private static String subNo;
          private static String subName;
          

          public static String getSubNo() {
                    return subNo;
          }

          public static void setSubNo(String subNo) {
                    SearchSubjectFrm.subNo = subNo;
          }

          public static String getSubName() {
                    return subName;
          }

          public static void setSubName(String subName) {
                    SearchSubjectFrm.subName = subName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SearchSubjectFrm frame = new SearchSubjectFrm(null);
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
          public SearchSubjectFrm(JFrame fr) {
                    super(fr, "", true);
                    
                    this.setResizable(false);
                    setTitle("\uAD50\uACFC\uBAA9\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 692, 410);
                    
                  ViewUtil vu=new ViewUtil();
                     vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    learnType=new String[] {"전필","전선","교필","교선"};
                    colType=new String[] {"대학", "대학원"};
                    credit=new String[] {"3", "2", "1"};
                    
                    JLabel lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uBA85:");
                    lblNewLabel_6.setFont(new Font("나눔명조", Font.BOLD, 12));
                    lblNewLabel_6.setBounds(25, 19, 62, 15);
                    
                    textField_searchSub = new JTextField();
                    textField_searchSub.setBounds(99, 16, 157, 21);
                    textField_searchSub.setColumns(10);
                    
                    JButton btnNewButton_2 = new JButton("조회");
                    btnNewButton_2.setBounds(571, 14, 80, 23);
                    btnNewButton_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        searchSubjectAction(ae);
                              }
                    });
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 50, 655, 275);
                    
                    JButton updateButton = new JButton("확인");
                    updateButton.setBounds(512, 335, 72, 23);
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        submitAction(e);
                              }
                    });
                    updateButton.setBackground(new Color(176, 224, 230));
                    updateButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton deleteButton = new JButton("취소");
                    deleteButton.setBounds(596, 335, 65, 23);
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        subNo=null;
                                        subName=null;
                                        dispose();
                              }
                    });
                    deleteButton.setBackground(new Color(255, 127, 80));
                    deleteButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel lblNewLabel = new JLabel("소속조직:");
                    lblNewLabel.setFont(new Font("나눔명조", Font.BOLD, 13));
                    lblNewLabel.setBounds(300, 19, 68, 15);
                    bgoup=new ButtonGroup();
                    
                    deptCheckBox = new JCheckBox("");
                    deptCheckBox.setBounds(278, 15, 21, 23);
                    deptCheckBox.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(deptCheckBox.isSelected()){
                                                  textField_searchDept.setEnabled(true);
                                        }else{
                                                  textField_searchDept.setEnabled(false);
                                                  textField_searchDept.setText("");
                                        }
                              }
                    });
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent me) {
                                        selectTableRowAction(me);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAD50\uACFC\uBAA9\uCF54\uB4DC", "\uAD50\uACFC\uBAA9\uBA85", "\uB300\uC0C1\uAD6C\uBD84", "\uC774\uC218\uAD6C\uBD84", "\uC774\uC218\uD559\uC810", "\uC18C\uC18D\uC870\uC9C1", "\uC124\uBA85"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(133);
                    table.getColumnModel().getColumn(2).setPreferredWidth(64);
                    table.getColumnModel().getColumn(4).setPreferredWidth(61);
                    table.getColumnModel().getColumn(5).setPreferredWidth(111);
                    table.getColumnModel().getColumn(6).setPreferredWidth(134);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                  scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                  contentPane.setLayout(null);
                  contentPane.add(lblNewLabel_6);
                  contentPane.add(textField_searchSub);
                  contentPane.add(deptCheckBox);
                  contentPane.add(lblNewLabel);
                  contentPane.add(btnNewButton_2);
                  contentPane.add(updateButton);
                  contentPane.add(deleteButton);
                  contentPane.add(scrollPane);
                  
                  textField_searchDept = new JTextField();
                  textField_searchDept.setEnabled(false);
                  textField_searchDept.setBounds(363, 15, 116, 21);
                  contentPane.add(textField_searchDept);
                  textField_searchDept.setColumns(10);
                  
                  setTable(new Subjects());
          }

          //교과목수정
          protected void submitAction(ActionEvent e) {
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "교과목을 선택해주세요!");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
                    
                    subNo=dft.getValueAt(index, 0).toString();
                    subName=dft.getValueAt(index, 1).toString();
          }

          //search subject
          protected void searchSubjectAction(ActionEvent ae) {
                    Subjects sbj=new Subjects();
                    String searchSubName;
                    try {
                              searchSubName= textField_searchSub.getText().toString();
                    } catch (Exception e) {
                              searchSubName=null;
                    }
                    sbj.setSubName(searchSubName);
                    String orgName;
                    if(deptCheckBox.isSelected()){
                              orgName = textField_searchDept.getText().toString();
                    }else{
                              orgName=null;
                    }
                    sbj.setOrgName(orgName);
                    int row=table.getSelectedRow();
                    setTable(sbj);
          }

          protected void selectTableRowAction(MouseEvent me) {
                    index=table.getSelectedRow();
          }
          //setTable()
          private void setTable(Subjects subjects) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    SubjectsDao sbDao=new SubjectsDao();
                    List<Subjects> abList = sbDao.getSubjectsList(subjects);
                    for(Subjects sb : abList){
                              Vector v=new Vector();
                              v.add(sb.getSubCode());
                              v.add(sb.getSubName());
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
                    orgList = orgDao.getOrgdeptNameList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
}
