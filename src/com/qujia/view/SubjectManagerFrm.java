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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.SubjectsDao;
import com.qujia.model.Org;
import com.qujia.model.Subjects;
import com.qujia.util.ViewUtil;

public class SubjectManagerFrm extends JFrame {

          private JPanel contentPane;
          private JTextField textField_searchSub;
          private JTable table;
          private List<Org> orgList;
          private JComboBox comboBox_learnType,comboBox_credit,comboBox_colType;
          private  String[] learnType,credit,colType;
          private JTextArea textArea;
          private ButtonGroup bgoup;
          private JCheckBox deptCheckBox;
          private JTextField textField_searchDept;
          

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
                    this.setResizable(false);
                    setTitle("\uAD50\uACFC\uBAA9\uAD00\uB9AC");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 757, 641);
                    
                  ViewUtil vu=new ViewUtil();
                     vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC774\uC218\uAD6C\uBD84:");
                    lblNewLabel_1.setBounds(17, 346, 66, 15);
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    comboBox_learnType = new JComboBox();
                    comboBox_learnType.setBounds(95, 343, 138, 21);
                    learnType=new String[] {"전필","전선","교필","교선"};
                    comboBox_learnType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_learnType.setModel(new DefaultComboBoxModel(learnType));
                    
                    JLabel label_1 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_1.setBounds(17, 385, 66, 15);
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uB300       \uC0C1:");
                    lblNewLabel_2.setBounds(333, 346, 67, 15);
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    comboBox_colType = new JComboBox();
                    comboBox_colType.setBounds(412, 343, 195, 21);
                    comboBox_colType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    colType=new String[] {"대학", "대학원"};
                    comboBox_colType.setModel(new DefaultComboBoxModel(colType));
                    
                    comboBox_credit = new JComboBox();
                    comboBox_credit.setBounds(95, 382, 138, 21);
                    credit=new String[] {"3", "2", "1"};
                    comboBox_credit.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_credit.setModel(new DefaultComboBoxModel(credit));
                    
                    JLabel lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uBA85:");
                    lblNewLabel_6.setFont(new Font("나눔명조", Font.BOLD, 12));
                    lblNewLabel_6.setBounds(25, 19, 62, 15);
                    
                    textField_searchSub = new JTextField();
                    textField_searchSub.setBounds(99, 16, 157, 21);
                    textField_searchSub.setColumns(10);
                    
                    JButton btnNewButton_2 = new JButton("\uAC80  \uC0C9");
                    btnNewButton_2.setBounds(571, 14, 80, 23);
                    btnNewButton_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        searchSubjectAction(ae);
                              }
                    });
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 50, 699, 275);
                    
                    JLabel label_2 = new JLabel("\uC124       \uBA85:");
                    label_2.setBounds(333, 382, 67, 15);
                    label_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton updateButton = new JButton("\uC218   \uC815");
                    updateButton.setBounds(129, 486, 104, 23);
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateSubjectAction(e);
                              }
                    });
                    updateButton.setBackground(new Color(176, 224, 230));
                    updateButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton deleteButton = new JButton("\uC0AD   \uC81C");
                    deleteButton.setBounds(333, 486, 104, 23);
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteSubjectAction(e);
                              }
                    });
                    deleteButton.setBackground(new Color(255, 127, 80));
                    deleteButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    scrollPane_1.setBounds(412, 382, 195, 70);
                    
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
                    
                    textArea = new JTextArea();
                    scrollPane_1.setViewportView(textArea);
                    
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
                                        {null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAD50\uACFC\uBAA9\uCF54\uB4DC", "\uAD50\uACFC\uBAA9\uBA85", "\uC601\uC5B4\uBA85", "\uB300\uC0C1\uAD6C\uBD84", "\uC774\uC218\uAD6C\uBD84", "\uC774\uC218\uD559\uC810", "\uC18C\uC18D\uC870\uC9C1", "\uC124\uBA85"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(1).setPreferredWidth(133);
                    table.getColumnModel().getColumn(2).setPreferredWidth(142);
                    table.getColumnModel().getColumn(3).setPreferredWidth(64);
                    table.getColumnModel().getColumn(5).setPreferredWidth(61);
                    table.getColumnModel().getColumn(6).setPreferredWidth(111);
                    table.getColumnModel().getColumn(7).setPreferredWidth(214);
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
                  contentPane.add(lblNewLabel_1);
                  contentPane.add(comboBox_learnType);
                  contentPane.add(label_1);
                  contentPane.add(comboBox_credit);
                  contentPane.add(deleteButton);
                  contentPane.add(label_2);
                  contentPane.add(scrollPane_1);
                  contentPane.add(lblNewLabel_2);
                  contentPane.add(comboBox_colType);
                  contentPane.add(scrollPane);
                  
                  textField_searchDept = new JTextField();
                  textField_searchDept.setEnabled(false);
                  textField_searchDept.setBounds(363, 15, 116, 21);
                  contentPane.add(textField_searchDept);
                  textField_searchDept.setColumns(10);
                  
                  setTable(new Subjects());
          }
          //교과목 삭제
          protected void deleteSubjectAction(ActionEvent e) {
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    SubjectsDao subDao =new SubjectsDao();
                    String subNO=table.getValueAt(row, 0).toString();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(subDao.deleteSubjects(subNO)){
                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                              }else{
                                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                              }
                    }
                    
                    subDao.closeDao();
                    setTable(new Subjects());
                    restvalues();
          }

          //교과목수정
          protected void updateSubjectAction(ActionEvent e) {
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    String learnType = comboBox_learnType.getSelectedItem().toString();
                    int credit=Integer.parseInt(comboBox_credit.getSelectedItem().toString());
                    String colType = comboBox_colType.getSelectedItem().toString();
                    String subExp;
                    try {
                              subExp= textArea.getText().toString();
                    } catch (Exception e2) {
                              subExp= null;
                    }
                    String subCode=dft.getValueAt(row, 0).toString();
                    Subjects sub=new Subjects();
                    sub.setLearnType(learnType);
                    sub.setCreditType(credit);
                    sub.setColType(colType);
                    sub.setSubExp(subExp);
                    sub.setSubCode(subCode);
                     
                    SubjectsDao subDao=new SubjectsDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "수정 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(subDao.updateSubjects(sub)){
                                        JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                              }else{
                                        JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                              }
                    }
                    
                    subDao.closeDao();
                    setTable(new Subjects());
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
                    if(row==-1){
                              restvalues();
                    }
                    setTable(sbj);
          }

          private void restvalues() {
                    // TODO Auto-generated method stub
                    //comboBox_learnType,comboBox_credit,comboBox_colType;
                    comboBox_learnType.setSelectedIndex(0);
                    comboBox_credit.setSelectedIndex(0);
                    comboBox_colType.setSelectedIndex(0);
                    textArea.setText("");
          }

          protected void selectTableRowAction(MouseEvent me) {
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    int row=table.getSelectedRow();
                    if(row==-1){
                              restvalues();
                    }
                    //이수구분/이수학점/대상 learnType,credit,colType;
                    //comboBox_learnType,comboBox_credit,comboBox_colType;
                    String getlearnType=dft.getValueAt(table.getSelectedRow(), 4).toString();
                    for(int i=0;i<comboBox_learnType.getItemCount();i++){
                              if(getlearnType.equals(learnType[i])){
                                        comboBox_learnType.setSelectedIndex(i);
                              }
                    }
                    String getcredit=dft.getValueAt(table.getSelectedRow(), 5).toString();
                    for(int i=0;i<comboBox_credit.getItemCount();i++){
                              if(getcredit.equals(credit[i])){
                                        comboBox_credit.setSelectedIndex(i);
                              }
                    }
                    String getcolType=dft.getValueAt(table.getSelectedRow(), 3).toString();
                    for(int i=0;i<comboBox_colType.getItemCount();i++){
                              if(getcolType.equals(colType[i])){
                                        comboBox_colType.setSelectedIndex(i);
                              }
                    }
                    String getSubExp;
                    try {
                              getSubExp=dft.getValueAt(table.getSelectedRow(), 7).toString();
                              textArea.setText(getSubExp);
                    } catch (Exception e) {
                              textArea.setText("");
                    }
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
                              v.add(sb.getSubEname());
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
