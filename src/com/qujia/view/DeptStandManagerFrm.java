package com.qujia.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.DeptStandDao;
import com.qujia.dao.OrgDao;
import com.qujia.model.DeptStand;
import com.qujia.model.Org;
import com.qujia.util.StringUtil;

public class DeptStandManagerFrm extends JInternalFrame {
          private JTextField searchClassNameTextField;
          private JTable deptListTable;
          private JTextField textField_min;
          private JTextField textField_year2;
          private JTextField textField_max;
          private JTextField textField_year1;
          private JTextArea textArea;
          private List<Org> orgList;
          private JLabel orgName;
          /**
           * Launch the application.
           */
          // public static void main(String[] args) {
          // EventQueue.invokeLater(new Runnable() {
          // public void run() {
          // try {
          // ClassManagerFrm frame = new ClassManagerFrm();
          // frame.setVisible(true);
          // } catch (Exception e) {
          // e.printStackTrace();
          // }
          // }
          // });
          // }

          /**
           * Create the frame.
           */
          public DeptStandManagerFrm() {
                    setTitle("교육부서학사기준관리");
                    setBounds(20, 20, 863, 561);
                    setClosable(true);
                    setIconifiable(true);

                    // ViewUtil vu=new ViewUtil();
                    // vu.showCenter(this);
                    JLabel classNameLabel = new JLabel("학과이름:");
                    classNameLabel.setBounds(52, 43, 80, 19);
                    classNameLabel.setIcon(new ImageIcon(DeptStandManagerFrm.class
                                        .getResource("/images/className.png")));
                    classNameLabel.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    searchClassNameTextField = new JTextField();
                    searchClassNameTextField.setBounds(142, 39, 241, 29);
                    searchClassNameTextField.setFont(new Font("나눔명조",
                                        Font.PLAIN, 12));
                    searchClassNameTextField.setColumns(10);

                    JButton searchButton = new JButton("검색");
                    searchButton.setBounds(421, 39, 129, 27);
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        DeptStand deptStand=new DeptStand();
                                        String orgName ;
                                       try {
                                                 orgName = searchClassNameTextField.getText().toString();
                                      } catch (Exception e) {
                                                orgName=null;
                                      }
                                       deptStand.setOrgName(orgName);
                                        setTable(deptStand);
                                        resetValue();
                              }
                    });
                    searchButton.setIcon(new ImageIcon(DeptStandManagerFrm.class
                                        .getResource("/images/search.png")));
                    searchButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 78, 822, 219);

                    JLabel label = new JLabel("조직이름:");
                    label.setBounds(35, 315, 60, 19);
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel lblNewLabel_1 = new JLabel("학기당최소이수학점:");
                    lblNewLabel_1.setBounds(260, 316, 130, 19);
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_min = new JTextField();
                    textField_min.setBounds(402, 315, 66, 21);
                    textField_min.setColumns(10);

                    JLabel label_1 = new JLabel("재학년한\r\n:");
                    label_1.setBounds(490, 363, 60, 19);
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_year2 = new JTextField();
                    textField_year2.setBounds(562, 362, 123, 21);
                    textField_year2.setColumns(10);

                    JLabel lblNewLabel_2 = new JLabel("학기당최대이수학점:");
                    lblNewLabel_2.setBounds(262, 362, 130, 19);
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_max = new JTextField();
                    textField_max.setBounds(402, 361, 66, 21);
                    textField_max.setColumns(10);

                    JLabel lblNewLabel_3 = new JLabel("학과설명:");
                    lblNewLabel_3.setBounds(35, 363, 60, 19);
                    lblNewLabel_3.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JButton updateButton = new JButton("수  정");
                    updateButton.setBounds(691, 315, 101, 29);
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateDeptStand(e);
                              }
                    });
                    updateButton.setBackground(new Color(50, 205, 50));
                    updateButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JButton deleteButton = new JButton("삭  제\r\n");
                    deleteButton.setBounds(691, 369, 101, 29);
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        deleteDept(ae);
                              }
                    });
                    deleteButton.setBackground(new Color(255, 140, 0));
                    deleteButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JLabel label_2 = new JLabel("수학년한:");
                    label_2.setBounds(490, 320, 60, 19);
                    label_2.setFont(new Font("Dialog", Font.BOLD, 13));

                    textField_year1 = new JTextField();
                    textField_year1.setBounds(560, 319, 125, 21);
                    textField_year1.setColumns(10);
                    
                    JScrollPane scrollPane_text = new JScrollPane();
                    scrollPane_text.setBounds(105, 363, 125, 60);
                    
                    orgName = new JLabel();
                    orgName.setBounds(105, 315, 137, 21);
                    orgName.setFont(new Font("Dialog", Font.BOLD, 13));
                    
                    textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    scrollPane_text.setViewportView(textArea);

                    deptListTable = new JTable();
                    deptListTable.setRowHeight(25);
                    deptListTable.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent me) {
                                        selectedTableRow(me);
                              }
                    });
                    deptListTable.setFont(new Font("나눔명조", Font.BOLD, 13));
                    deptListTable.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uD559\uC0AC\uAE30\uC900\uBC88\uD638", "\uC870\uC9C1\uC774\uB984", "\uD559\uAE30\uB2F9\uCD5C\uC18C\uC774\uC218\uD559\uC810", "\uD559\uAE30\uB2F9\uCD5C\uB300\uC774\uC218\uD559\uC810", "\uC7AC\uD559\uC778\uC6D0", "\uB4F1\uB85D\uC77C\uC790", "\uC218\uD559\uB144\uD559", "\uC7AC\uD559\uB144\uD55C", "\uD559\uACFC\uC124\uBA85"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    deptListTable.getColumnModel().getColumn(0).setPreferredWidth(86);
                    deptListTable.getColumnModel().getColumn(1).setPreferredWidth(112);
                    deptListTable.getColumnModel().getColumn(2).setPreferredWidth(129);
                    deptListTable.getColumnModel().getColumn(3).setPreferredWidth(140);
                    deptListTable.getColumnModel().getColumn(4).setPreferredWidth(83);
                    deptListTable.getColumnModel().getColumn(5).setPreferredWidth(119);
                    deptListTable.getColumnModel().getColumn(6).setPreferredWidth(93);
                    deptListTable.getColumnModel().getColumn(7).setPreferredWidth(88);
                    deptListTable.getColumnModel().getColumn(8).setPreferredWidth(187);
                    scrollPane.setViewportView(deptListTable);
                    deptListTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    getContentPane().setLayout(null);
                    getContentPane().add(classNameLabel);
                    getContentPane().add(searchClassNameTextField);
                    getContentPane().add(searchButton);
                    getContentPane().add(scrollPane);
                    getContentPane().add(label_1);
                    getContentPane().add(label);
                    getContentPane().add(textField_year2);
                    getContentPane().add(orgName);
                    getContentPane().add(lblNewLabel_1);
                    getContentPane().add(lblNewLabel_2);
                    getContentPane().add(textField_max);
                    getContentPane().add(textField_min);
                    getContentPane().add(lblNewLabel_3);
                    getContentPane().add(label_2);
                    getContentPane().add(scrollPane_text);
                    getContentPane().add(textField_year1);
                    getContentPane().add(deleteButton);
                    getContentPane().add(updateButton);
                    
                    // set TABLE data in center
                    DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
                    cr.setHorizontalAlignment(JLabel.CENTER);
                    deptListTable.setDefaultRenderer(Object.class, cr);
                    DeptStand dStand1=new DeptStand();
                    setTable(dStand1);
          }
        //删除学科（delete dept）
          protected void deleteDept(ActionEvent ae) {
                    // TODO Auto-generated method stub
                    
                    int index=deptListTable.getSelectedRow();
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "데이터 라인을 선택하십시오!");
                              return;
                    }
                    DefaultTableModel dft = (DefaultTableModel) deptListTable.getModel();
                    String id=dft.getValueAt(deptListTable.getSelectedRow(),0).toString();
                    DeptStandDao dsDao=new DeptStandDao();
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              //dsDao.deleteStand(id);
                              if(dsDao.deleteStand(id)){
                                        JOptionPane.showMessageDialog(this, "삭제 성공했습니다!");
                              }else{
                                        JOptionPane.showMessageDialog(this, "삭제 실패했습니다!");
                              }
                              setTable(new DeptStand());
                              resetValue();
                    }else{
                              return;
                    }
                    
          }


          //修改学科（update dept）
          protected void updateDeptStand(ActionEvent e) {
                    // TODO Auto-generated method stub
                    int index=deptListTable.getSelectedRow();
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "데이터 라인을 선택하십시오!");
                              return;
                    }
                    //得到表格数据
                    DefaultTableModel dft = (DefaultTableModel) deptListTable.getModel();
                    String dsNo=dft.getValueAt(deptListTable.getSelectedRow(),0).toString();
                    String dsName=dft.getValueAt(deptListTable.getSelectedRow(),1).toString();
                    String college=dft.getValueAt(deptListTable.getSelectedRow(),2).toString();
                    int min=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),2).toString());
                    int year1=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),6).toString());
                    int year2=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),7).toString());
                    int max=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),3).toString());
                    String deptExp = null;
                    try {
                              deptExp=dft.getValueAt(deptListTable.getSelectedRow(),8).toString();
                    } catch (NullPointerException ne) {
                              // TODO: handle exception
                              deptExp="";
                    }
                    //得到编辑框数据
//                    String editDeptNo = textField_no.getText().toString();
//                    String editDeptName = textField_name.getText().toString();
//                    String editCollege = comboBox_college.getSelectedItem().toString();
                    int editmin = Integer.parseInt(textField_min.getText());
                    int edityear1 = Integer.parseInt(textField_year1
                                        .getText());
                    int edityear2= Integer.parseInt(textField_year2
                                        .getText());
                    int editmax = Integer.parseInt(textField_max
                                        .getText());
                    String editDeptExp = textArea.getText().toString();
                    //判断编辑框是否为空
                    if(StringUtil.isEmpty(min)){
                              JOptionPane.showMessageDialog(this, "학기당최소이수학점을 입력합시오");
                              return;
                    }
                    if(StringUtil.isEmpty(max)){
                        JOptionPane.showMessageDialog(this, "학기당최대이수학점을 입력합시오");
                        return;
                    }
                    if(StringUtil.isEmpty(year1)){
                              JOptionPane.showMessageDialog(this, "수학년한을 입력합시오");
                              return;
                    }
                    if(StringUtil.isEmpty(year2)){
                              JOptionPane.showMessageDialog(this, "재학년한을 입력합시오");
                              return;
                    }
                    
                    if (StringUtil.isEmpty(min)
                                        || StringUtil.isEmpty(max)
                                        || StringUtil.isEmpty(year1)
                                        || StringUtil.isEmpty(year2)) {
                              JOptionPane.showMessageDialog(this,
                                                  "데이터를 입력해주세요!");
                              return;
                    }
                    //判断编辑框值是否有变动
                    if (min==editmin
                                        && max==editmax
                                        && year1==edityear1
                                        &&year2==edityear2
                                        &&deptExp.equals(editDeptExp)
                                        ) {
                              JOptionPane.showMessageDialog(this,
                                                  "데이터는 변경되지 않습니다!");
                              return;
                    }
                    DeptStand dStand=new DeptStand();
                    dStand.setStandId(dsNo);
                    dStand.setOrgid(dsNo);
                    dStand.setCollege(college);
                    dStand.setMin(editmin);
                    dStand.setMax(editmax);
                    dStand.setYear1(edityear1);
                    dStand.setYear2(edityear2);
                    dStand.setDeptExplain(editDeptExp);
                    DeptStandDao dsDao=new DeptStandDao();
//                    if(JOptionPane.showConfirmDialog(this, "수정 하시겠습니까？") != JOptionPane.OK_OPTION){
//                              return;
//                      }
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "삭제 하시겠습니까?", " WarningDialog!", 
                                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(showConfirmDialog==JOptionPane.YES_OPTION){
                              if(dsDao.updateDStand(dStand)){
//                                      deptListTable.setValueAt(dsName, index, 1);
//                                      deptListTable.setValueAt(college, index, 2);
                                      JOptionPane.showMessageDialog(this, "수정 성공했습니다!");
                            }else{
                                      JOptionPane.showMessageDialog(this, "수정 실패했습니다!");
                            }
                    }
                   
                    dsDao.closeDao();
                    setTable(new DeptStand());
                    
                    
          }

          // 选中表格一行出发事件(select a row in table)
          protected void selectedTableRow(MouseEvent me) {
                    // TODO Auto-generated method stub
                    DefaultTableModel dft = (DefaultTableModel) deptListTable.getModel();
                    // 得到选中表格中的哪一行，那一列的值
                    orgName.setText(dft.getValueAt(deptListTable.getSelectedRow(),1).toString());
                    textField_min.setText(dft.getValueAt(deptListTable.getSelectedRow(),2).toString());
                    textField_year2.setText(dft.getValueAt(deptListTable.getSelectedRow(),7).toString());
                    textField_max.setText(dft.getValueAt(deptListTable.getSelectedRow(),3).toString());
                    //comboBox_college.setSelectedIndex(0);
                    
                    textField_year1.setText(dft.getValueAt(deptListTable.getSelectedRow(),6).toString());
                    try {
                              textArea.setText(dft.getValueAt(deptListTable.getSelectedRow(),8).toString());
                    } catch (NullPointerException e) {
                              // TODO: handle exception
                              textArea.setText("");
                    }
                    
          }
          //重置编辑框的值
         public void resetValue(){
        	       orgName.setText("");
                   textField_min.setText("");
                   textField_year1.setText("");
                   textField_year2.setText("");
                   textField_max.setText("");
                   textArea.setText("");
          }
          public void setTable(DeptStand dStand) {
                    DefaultTableModel dft = (DefaultTableModel) deptListTable
                                        .getModel();
                    // 清空列表(resetTable)
                    dft.setRowCount(0);
                    // 得到列表内容，并且遍历(get table contents)
                    DeptStandDao dStandDao=new DeptStandDao();
                    List<DeptStand> dStandList = dStandDao.getDeptStandList(dStand);
                    for (DeptStand ds: dStandList) {
                              // Vector类 是在 java 中可以实现自动增长的对象数组
                              Vector v = new Vector();
                              v.add(ds.getStandId());
                              v.add(this.getOrgNameById(ds.getOrgid()));
//                              v.add(this.getOrgCollegeById(ds.getOrgid()));
                              v.add(ds.getMin());
                              v.add(ds.getMax());
                            
                              v.add(ds.getInNum());
                              v.add(ds.getLoginDate());
                             
                              v.add(ds.getYear1());
                              v.add(ds.getYear2());
                              v.add(ds.getDeptExplain());
                              dft.addRow(v);
                    }
                    dStandDao.closeDao();
          }
          public String getOrgNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }
          public String getOrgCollegeById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getCoGrCode();
                    }
                    return "";
          }
}
