package com.qujia.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.qujia.dao.ClassDao;
import com.qujia.model.StudentClass;
import com.qujia.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassManagerFrm extends JInternalFrame {
          private JTextField searchClassNameTextField;
          private JTable classListTable;
          private JTextField editClassNameTextField;
          private JTextArea editClassInfoTextArea;

          /**
           * Launch the application.
           */
//          public static void main(String[] args) {
//                    EventQueue.invokeLater(new Runnable() {
//                              public void run() {
//                                        try {
//                                                  ClassManagerFrm frame = new ClassManagerFrm();
//                                                  frame.setVisible(true);
//                                        } catch (Exception e) {
//                                                  e.printStackTrace();
//                                        }
//                              }
//                    });
//          }

          /**
           * Create the frame.
           */
          public ClassManagerFrm() {
                    setTitle("분반정보관리");
                    setBounds(80, 30, 622, 484);
                    setClosable(true);
                    setIconifiable(true);
                    
                    JLabel classNameLabel = new JLabel("분반이름：");
                    classNameLabel.setIcon(new ImageIcon(ClassManagerFrm.class.getResource("/images/className.png")));
                    classNameLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    searchClassNameTextField = new JTextField();
                    searchClassNameTextField.setFont(new Font("나눔명조", Font.PLAIN, 12));
                    searchClassNameTextField.setColumns(10);
                    
                    JButton searchButton = new JButton("검색");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        StudentClass sc=new StudentClass();
                                        String str = searchClassNameTextField.getText().toString();
                                        sc.setName(str);
                                        setTable(sc);
                              }
                    });
                    searchButton.setIcon(new ImageIcon(ClassManagerFrm.class.getResource("/images/search.png")));
                    searchButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel editClassNameLabel = new JLabel("분반이름：");
                    editClassNameLabel.setIcon(new ImageIcon(ClassManagerFrm.class.getResource("/images/className.png")));
                    editClassNameLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    editClassNameTextField = new JTextField();
                    editClassNameTextField.setColumns(10);
                    
                    JLabel editClassInfoLabel = new JLabel("분반정보：");
                    editClassInfoLabel.setIcon(new ImageIcon(ClassManagerFrm.class.getResource("/images/classinfo.png")));
                    editClassInfoLabel.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                   
                    editClassInfoTextArea = new JTextArea();
                    editClassInfoTextArea.setLineWrap(true);//激活自动换行功能 
                    editClassInfoTextArea.setWrapStyleWord(true);//激活断行不断字功能
                    JButton submitEditButton = new JButton("수  정");
                    submitEditButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        subminEditAction(ae);
                              }
                    });
                    submitEditButton.setIcon(new ImageIcon(ClassManagerFrm.class.getResource("/images/submit.png")));
                    submitEditButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    
                    JButton submitDeleteButton = new JButton("삭  제");
                    submitDeleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        deleteClassAction(ae);
                              }
                    });
                    submitDeleteButton.setIcon(new ImageIcon(ClassManagerFrm.class.getResource("/images/delete.png")));
                    submitDeleteButton.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));
                    GroupLayout groupLayout = new GroupLayout(getContentPane());
                    groupLayout.setHorizontalGroup(
                              groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGap(52)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(classNameLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(38)
                                                                      .addComponent(searchButton))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addComponent(editClassInfoLabel)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(editClassInfoTextArea))
                                                                                .addGroup(groupLayout.createSequentialGroup()
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(editClassNameLabel)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
                                                                      .addGap(56)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                  .addContainerGap(38, Short.MAX_VALUE))
                    );
                    groupLayout.setVerticalGroup(
                              groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGap(39)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(classNameLabel)
                                                            .addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchButton))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(editClassNameLabel)
                                                            .addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(submitEditButton))
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(editClassInfoLabel)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(submitDeleteButton))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGap(15)
                                                                      .addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)))
                                                  .addGap(20))
                    );
                    
                    classListTable = new JTable();
                    classListTable.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent me) {
                                         selectedTableRow(me);
                              }
                    });
                    classListTable.setFont(new Font("나눔명조", Font.BOLD, 13));
                    classListTable.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null},
                              },
                              new String[] {
                                        "\uBD84\uBC18\uBC88\uD638", "\uBD84\uBC18\uC774\uB984", "\u73ED\u7EA7\uC815\uBCF4"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    classListTable.getColumnModel().getColumn(0).setPreferredWidth(113);
                    classListTable.getColumnModel().getColumn(1).setPreferredWidth(125);
                    classListTable.getColumnModel().getColumn(2).setPreferredWidth(403);
                    scrollPane.setViewportView(classListTable);
                    getContentPane().setLayout(groupLayout);
                  //set TABLE data in center
                    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
                    cr.setHorizontalAlignment(JLabel.CENTER);
                    classListTable.setDefaultRenderer(Object.class, cr);
                    
                    setTable(new StudentClass());
          }
          //删除行函数
          protected void deleteClassAction(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    
                    if(JOptionPane.showConfirmDialog(this, "삭제 하시겠습니까?？") != JOptionPane.OK_OPTION){
                              return;
                    }
                    int index = classListTable.getSelectedRow();
                    if(index==-1){ 
                              JOptionPane.showMessageDialog(this, "삭제할 행을 선택하십시오.！");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) classListTable.getModel();
                    int id=Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
                    ClassDao classDao=new ClassDao();
                    if(classDao.delete(id)){
                              JOptionPane.showMessageDialog(this, "성공적으로 삭제되었습니다！");
                    }else{
                              JOptionPane.showMessageDialog(this, "삭제 실패했습니다！");
                    }
                    classDao.closeDao();
                    //删除后都要刷新数据库
                    setTable(new StudentClass());
          }

          //确认修改函数
          protected void subminEditAction(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    
                    int index = classListTable.getSelectedRow();
                    if(index==-1){ 
                              JOptionPane.showMessageDialog(this, "수정할 행을 선택하십시오！");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) classListTable.getModel();
                    String className=dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
                    String classInfo=dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
                    
                    String editClassName=editClassNameTextField.getText().toString();
                    String editClassInfo=editClassInfoTextArea.getText().toString();
                    if(StringUtil.isEmpty(editClassName)){
                              JOptionPane.showMessageDialog(this, "수정할 분반 이름을 입력하십시오！");
                              return;
                    }
//                    if(StringUtil.isEmpty(editClassInfo)){
//                              JOptionPane.showMessageDialog(this, "请填写要修改的班级信息！");
//                              return;
//                    }
                    if(className.equals(editClassName)&& classInfo.equals(editClassInfo)){
                              JOptionPane.showMessageDialog(this, "아직 변경하지 않았습니다.！");
                              return;
                    }
                    int id=Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
                    ClassDao classDao=new ClassDao();
                    StudentClass sc=new StudentClass();
                    sc.setId(id);
                    sc.setName(editClassName);
                    sc.setInfo(editClassInfo);
                    if(classDao.update(sc)){
                              JOptionPane.showMessageDialog(this, "성공적으로 수정 되었습니다！");
                    }else{
                              JOptionPane.showMessageDialog(this, "수정 실패했습니다！");
                    }
                    classDao.closeDao();
                    //删除后都要刷新数据库
                    setTable(new StudentClass());
          }

          //选中表格一行出发事件
          protected void selectedTableRow(MouseEvent me) {
                    // TODO Auto-generated method stub
                    DefaultTableModel   dft = (DefaultTableModel) classListTable.getModel();
                    //得到选中表格中的哪一行，那一列的值
                    editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
                    editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
          }

          private void setTable(StudentClass studentClsss){
                    DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
                    //清空列表
                    dft.setRowCount(0);
                    //得到列表内容，并且遍历
                    ClassDao classDao=new ClassDao();
                    List<StudentClass> classList = classDao.getClassList(studentClsss);
                    for (StudentClass sc : classList) {
                              //Vector类 是在 java 中可以实现自动增长的对象数组
                              Vector v=new Vector();
                              v.add(sc.getId());
                              v.add(sc.getName());
                              v.add(sc.getInfo());
                              dft.addRow(v);
                    }
                    classDao.closeDao();
          }
}
