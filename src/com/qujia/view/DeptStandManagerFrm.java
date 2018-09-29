package com.qujia.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
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
          private JTextField textField_pnum;
          private JTextField textField_year1;
          private JTextField textField_year2;
          private JTextField textField_credit;
          private JTextArea textArea;
          private List<Org> orgList;
          private JLabel label_name;
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
                    setBounds(20, 20, 863, 482);
                    setClosable(true);
                    setIconifiable(true);

                    // ViewUtil vu=new ViewUtil();
                    // vu.showCenter(this);
                    JLabel classNameLabel = new JLabel("학과이름:");
                    classNameLabel.setIcon(new ImageIcon(DeptStandManagerFrm.class
                                        .getResource("/images/className.png")));
                    classNameLabel.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    searchClassNameTextField = new JTextField();
                    searchClassNameTextField.setFont(new Font("나눔명조",
                                        Font.PLAIN, 12));
                    searchClassNameTextField.setColumns(10);

                    JButton searchButton = new JButton("검색");
                    searchButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        DeptStand deptStand=new DeptStand();
                                        String str = searchClassNameTextField
                                                            .getText()
                                                            .toString();
                                        if(StringUtil.isEmpty(str)){
                                                  JOptionPane.showMessageDialog(null, "이름을 입력해주세요!");
                                        } 
                                        deptStand.setOrgName(str);
                                        setTable(deptStand);
                                        resetValut();
                              }
                    });
                    searchButton.setIcon(new ImageIcon(DeptStandManagerFrm.class
                                        .getResource("/images/search.png")));
                    searchButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JScrollPane scrollPane = new JScrollPane();

                    JLabel label = new JLabel("조직이름:");
                    label.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    JLabel lblNewLabel_1 = new JLabel("모집인원:");
                    lblNewLabel_1.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_pnum = new JTextField();
                    textField_pnum.setColumns(10);

                    JLabel label_1 = new JLabel("수학년한\r\n:");
                    label_1.setFont(new Font("NanumMyeongjo", Font.BOLD, 13));

                    textField_year1 = new JTextField();
                    textField_year1.setColumns(10);

                    JLabel lblNewLabel_2 = new JLabel("재학년한:");
                    lblNewLabel_2.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    textField_year2 = new JTextField();
                    textField_year2.setColumns(10);

                    JLabel lblNewLabel_3 = new JLabel("부가설명:");
                    lblNewLabel_3.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        13));

                    JButton updateButton = new JButton("수  정");
                    updateButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        updateDeptStand(e);
                              }
                    });
                    updateButton.setBackground(new Color(50, 205, 50));
                    updateButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JButton deleteButton = new JButton("삭  제\r\n");
                    deleteButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent ae) {
                                        deleteDept(ae);
                              }
                    });
                    deleteButton.setBackground(new Color(255, 140, 0));
                    deleteButton.setFont(new Font("NanumMyeongjo", Font.BOLD,
                                        14));

                    JLabel label_2 = new JLabel("졸업이수학점:");
                    label_2.setFont(new Font("Dialog", Font.BOLD, 13));

                    textField_credit = new JTextField();
                    textField_credit.setColumns(10);
                    
                    JScrollPane scrollPane_text = new JScrollPane();
                    
                    label_name = new JLabel();
                    GroupLayout groupLayout = new GroupLayout(getContentPane());
                    groupLayout.setHorizontalGroup(
                              groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGap(52)
                                                                      .addComponent(classNameLabel)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(38)
                                                                      .addComponent(searchButton))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addGap(35)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                                                .addComponent(label_1)
                                                                                .addComponent(label))
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(textField_year1, Alignment.TRAILING)
                                                                                .addComponent(label_name, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                                                                      .addGap(33)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addComponent(lblNewLabel_2))
                                                                      .addGap(18)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(textField_pnum)
                                                                                .addComponent(textField_year2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                                                      .addGap(18)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(lblNewLabel_3, Alignment.TRAILING)
                                                                                .addComponent(label_2, Alignment.TRAILING))
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                .addComponent(scrollPane_text, 0, 0, Short.MAX_VALUE)
                                                                                .addComponent(textField_credit, 125, 125, Short.MAX_VALUE))
                                                                      .addGap(18)
                                                                      .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                                                .addComponent(deleteButton)
                                                                                .addComponent(updateButton)))
                                                            .addGroup(groupLayout.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 822, GroupLayout.PREFERRED_SIZE)))
                                                  .addGap(36))
                    );
                    groupLayout.setVerticalGroup(
                              groupLayout.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                  .addGap(39)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(classNameLabel)
                                                            .addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(searchButton))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(label)
                                                            .addComponent(label_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_pnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(textField_credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(updateButton))
                                                  .addGap(25)
                                                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(label_1)
                                                                      .addComponent(textField_year1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel_2)
                                                                      .addComponent(textField_year2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(lblNewLabel_3))
                                                            .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(scrollPane_text, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                                      .addComponent(deleteButton)))
                                                  .addGap(97))
                    );
                    
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
                                        {null, null, null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC21C\uBC88", "\uC870\uC9C1\uC774\uB984", "\uC18C\uC18D\uC870\uC9C1", "\uBAA8\uC9D1\uC778\uC6D0", "\uC7AC\uD559\uC778\uC6D0", "\uB4F1\uB85D\uC77C\uC790", "\uC878\uC5C5\uC774\uC218\uD559\uC810", "\uC218\uD559\uB144\uD559", "\uC7AC\uD559\uB144\uD55C", "\uBD80\uAC00\uC124\uBA85"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    deptListTable.getColumnModel().getColumn(0).setPreferredWidth(80);
                    deptListTable.getColumnModel().getColumn(1).setPreferredWidth(112);
                    deptListTable.getColumnModel().getColumn(2).setPreferredWidth(81);
                    deptListTable.getColumnModel().getColumn(3).setPreferredWidth(95);
                    deptListTable.getColumnModel().getColumn(4).setPreferredWidth(79);
                    deptListTable.getColumnModel().getColumn(5).setPreferredWidth(108);
                    deptListTable.getColumnModel().getColumn(6).setPreferredWidth(133);
                    deptListTable.getColumnModel().getColumn(7).setPreferredWidth(93);
                    deptListTable.getColumnModel().getColumn(8).setPreferredWidth(88);
                    deptListTable.getColumnModel().getColumn(9).setPreferredWidth(129);
                    scrollPane.setViewportView(deptListTable);
                    getContentPane().setLayout(groupLayout);
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
                                        JOptionPane.showMessageDialog(this, "삭제 했습니다!");
                              }
                              setTable(new DeptStand());
                              resetValut();
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
                    int pNum=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),3).toString());
                    int year1=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),7).toString());
                    int year2=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),8).toString());
                  
                    
                    int credit=Integer.parseInt(dft.getValueAt(deptListTable.getSelectedRow(),6).toString());
                    String deptExp = null;
                    try {
                              deptExp=dft.getValueAt(deptListTable.getSelectedRow(),9).toString();
                    } catch (NullPointerException ne) {
                              // TODO: handle exception
                              deptExp="";
                    }
                    //得到编辑框数据
//                    String editDeptNo = textField_no.getText().toString();
//                    String editDeptName = textField_name.getText().toString();
//                    String editCollege = comboBox_college.getSelectedItem().toString();
                    int editpNum = Integer.parseInt(textField_pnum.getText());
                    int editCredit = Integer.parseInt(textField_credit
                                        .getText());
                    int editYear1 = Integer.parseInt(textField_year1
                                        .getText());
                    int editYear2 = Integer.parseInt(textField_year2
                                        .getText());
                    String editDeptExp = textArea.getText().toString();
                    //判断编辑框是否为空
                    if(StringUtil.isEmpty(pNum)){
                              JOptionPane.showMessageDialog(this, "모집인원을 입력합시오");
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
                    if(StringUtil.isEmpty(credit)){
                              JOptionPane.showMessageDialog(this, "이수학점을 입력합시오");
                              return;
                    }
                    if (StringUtil.isEmpty(credit)
                                        || StringUtil.isEmpty(pNum)
                                        || StringUtil.isEmpty(year1)
                                        || StringUtil.isEmpty(year2)) {
                              JOptionPane.showMessageDialog(this,
                                                  "데이터를 입력해주세요!");
                              return;
                    }
                    //判断编辑框值是否有变动
                    if (credit==editCredit
                                        && pNum==editpNum
                                        && year1==editYear1
                                        &&year2==editYear2
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
                    dStand.setpNum(editpNum);
                    dStand.setCredit(editCredit);
                    dStand.setYear1(editYear1);
                    dStand.setYear2(editYear2);
                    dStand.setDeptExplain(editDeptExp);
                    DeptStandDao dsDao=new DeptStandDao();
                    if(dsDao.updateDStand(dStand)){
//                              deptListTable.setValueAt(dsName, index, 1);
//                              deptListTable.setValueAt(college, index, 2);
                              JOptionPane.showMessageDialog(this, "수정 성공!");
                    }else{
                              JOptionPane.showMessageDialog(this, "수정 실패!");
                    }
                    dsDao.closeDao();
                    setTable(new DeptStand());
                    
                    
          }

          // 选中表格一行出发事件(select a row in table)
          protected void selectedTableRow(MouseEvent me) {
                    // TODO Auto-generated method stub
                    DefaultTableModel dft = (DefaultTableModel) deptListTable.getModel();
                    // 得到选中表格中的哪一行，那一列的值
                    label_name.setText(dft.getValueAt(deptListTable.getSelectedRow(),1).toString());
                    textField_pnum.setText(dft.getValueAt(deptListTable.getSelectedRow(),3).toString());
                    textField_year1.setText(dft.getValueAt(deptListTable.getSelectedRow(),7).toString());
                    textField_year2.setText(dft.getValueAt(deptListTable.getSelectedRow(),8).toString());
                    //comboBox_college.setSelectedIndex(0);
                    
                    textField_credit.setText(dft.getValueAt(deptListTable.getSelectedRow(),6).toString());
                    try {
                              textArea.setText(dft.getValueAt(deptListTable.getSelectedRow(),9).toString());
                    } catch (NullPointerException e) {
                              // TODO: handle exception
                              textArea.setText("");
                    }
                    
          }
          //重置编辑框的值
         public void resetValut(){
        	       label_name.setText("");
                   textField_pnum.setText("");
                   textField_credit.setText("");
                   textField_year1.setText("");
                   textField_year2.setText("");
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
                              v.add(this.getOrgCollegeById(ds.getOrgid()));
                              v.add(ds.getpNum());
                              v.add(ds.getInNum());
                              v.add(ds.getLoginDate());
                              v.add(ds.getCredit());
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
