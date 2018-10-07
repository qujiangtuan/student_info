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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
          private JTextField textField_searchSub;
          private JTable table;
          private List<Org> orgList;
          private JComboBox comboBox_searchDept;
          private JComboBox comboBox_learnType,comboBox_credit,comboBox_colType;
          private  String[] learnType,credit,colType;
          private JTextArea textArea;
          private ButtonGroup bgoup;
          private JCheckBox deptCheckBox;
          

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
                    setBounds(100, 100, 757, 641);
                    
                  ViewUtil vu=new ViewUtil();
                     vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC774\uC218\uAD6C\uBD84:");
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    comboBox_learnType = new JComboBox();
                    learnType=new String[] {"전필","전선","교필","교선"};
                    comboBox_learnType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_learnType.setModel(new DefaultComboBoxModel(learnType));
                    
                    JLabel label_1 = new JLabel("\uC774\uC218\uD559\uC810:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JLabel lblNewLabel_2 = new JLabel("\uB300       \uC0C1:");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    comboBox_colType = new JComboBox();
                    comboBox_colType.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    colType=new String[] {"대학", "대학원"};
                    comboBox_colType.setModel(new DefaultComboBoxModel(colType));
                    
                    comboBox_credit = new JComboBox();
                    credit=new String[] {"3", "2", "1"};
                    comboBox_credit.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    comboBox_credit.setModel(new DefaultComboBoxModel(credit));
                    
                    JLabel lblNewLabel_6 = new JLabel("\uAD50\uACFC\uBAA9\uBA85:");
                    
                    textField_searchSub = new JTextField();
                    textField_searchSub.setColumns(10);
                    
                    JButton btnNewButton_2 = new JButton("\uAC80  \uC0C9");
                    btnNewButton_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        searchSubjectAction(ae);
                              }
                    });
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel label_2 = new JLabel("\uC124       \uBA85:");
                    label_2.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton updateButton = new JButton("\uC218   \uC815");
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateSubjectAction(e);
                              }
                    });
                    updateButton.setBackground(new Color(176, 224, 230));
                    updateButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton deleteButton = new JButton("\uC0AD   \uC81C");
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        deleteSubjectAction(e);
                              }
                    });
                    deleteButton.setBackground(new Color(255, 127, 80));
                    deleteButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    
                    JLabel lblNewLabel = new JLabel("\uC18C\uC18D\uBD80\uC11C:");
                    
                    comboBox_searchDept = new JComboBox();
                    comboBox_searchDept.setEnabled(false);
                    bgoup=new ButtonGroup();
                    
                    deptCheckBox = new JCheckBox("");
                    deptCheckBox.addItemListener(new ItemListener() {
                              public void itemStateChanged(ItemEvent e) {
                                        if(deptCheckBox.isSelected()){
                                                  comboBox_searchDept.setEnabled(true);
                                        }else{
                                                  comboBox_searchDept.setEnabled(false);
                                        }
                              }
                    });
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(30)
                                                  .addComponent(lblNewLabel_6)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(textField_searchSub, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(22)
                                                  .addComponent(deptCheckBox)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(lblNewLabel)
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(comboBox_searchDept, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(btnNewButton_2)
                                                  .addContainerGap(38, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(20)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                                            .addComponent(updateButton)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(comboBox_learnType, 0, 147, Short.MAX_VALUE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(label_1)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(comboBox_credit, 0, 147, Short.MAX_VALUE))))
                                                  .addGap(100)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(deleteButton)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(label_2)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(comboBox_colType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                  .addGap(129))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 699, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(22, Short.MAX_VALUE))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(deptCheckBox, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel_6)
                                                                      .addComponent(textField_searchSub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(lblNewLabel)
                                                                      .addComponent(comboBox_searchDept, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addComponent(comboBox_colType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(label_2)
                                                                                .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addComponent(comboBox_learnType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGap(18)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                                .addComponent(comboBox_credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(label_1))))
                                                  .addGap(34)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(updateButton)
                                                            .addComponent(deleteButton))
                                                  .addGap(88))
                    );
                    
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
                  setDeptName();
          }
          //교과목 삭제
          protected void deleteSubjectAction(ActionEvent e) {
                    setDeptName();
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요!");
                              return;
                    }
                    if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까？") != JOptionPane.OK_OPTION){
                              return;
                    }
                    SubjectsDao subDao =new SubjectsDao();
                    String subNO=table.getValueAt(row, 0).toString();
                    if(subDao.deleteSubjects(subNO)){
                              JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                    }else{
                              JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                    }
                    subDao.closeDao();
                    setTable(new Subjects());
                    restvalues();
          }

          //교과목수정
          protected void updateSubjectAction(ActionEvent e) {
                    setDeptName();
                    int row=table.getSelectedRow();
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택해주세요!");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    String learnType = comboBox_learnType.getSelectedItem().toString();
                    String credit=comboBox_credit.getSelectedItem().toString();
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
                    if(subDao.updateSubjects(sub)){
                              JOptionPane.showMessageDialog(this, "수정 성공했습니다");
                    }else{
                              JOptionPane.showMessageDialog(this, "수정 실패했습니다");
                    }
                    subDao.closeDao();
                    setTable(new Subjects());
          }

          //search subject
          protected void searchSubjectAction(ActionEvent ae) {
                    setDeptName();
                    Subjects sbj=new Subjects();
                    String searchSubName = textField_searchSub.getText().toString();
                    sbj.setSubName(searchSubName);
                    Org org;
                    if(deptCheckBox.isSelected()){
                              org=(Org) comboBox_searchDept.getSelectedItem();
                              sbj.setOrgId(org.getOrgCode());
                    }
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
                    String getlearnType=dft.getValueAt(table.getSelectedRow(), 5).toString();
                    for(int i=0;i<comboBox_learnType.getItemCount();i++){
                              if(getlearnType.equals(learnType[i])){
                                        comboBox_learnType.setSelectedIndex(i);
                              }
                    }
                    String getcredit=dft.getValueAt(table.getSelectedRow(), 6).toString();
                    for(int i=0;i<comboBox_credit.getItemCount();i++){
                              if(getcredit.equals(credit[i])){
                                        comboBox_credit.setSelectedIndex(i);
                              }
                    }
                    String getcolType=dft.getValueAt(table.getSelectedRow(), 4).toString();
                    for(int i=0;i<comboBox_colType.getItemCount();i++){
                              if(getcolType.equals(colType[i])){
                                        comboBox_colType.setSelectedIndex(i);
                              }
                    }
                    String getSubExp;
                    try {
                              getSubExp=dft.getValueAt(table.getSelectedRow(), 8).toString();
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
                    orgList = orgDao.getOrgdeptNameList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
        //학과(부서)선택-->검색용
          protected void setDeptName() {
                    // TODO Auto-generated method stub
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgdeptNameList(new Org());
                    for (Org org : orgList) {
                               comboBox_searchDept.addItem(org);
                    }
                    orgDao.closeDao();
          }
}
