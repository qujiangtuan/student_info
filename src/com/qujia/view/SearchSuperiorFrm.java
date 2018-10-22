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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.OrgDao;
import com.qujia.dao.ProStaffDao;
import com.qujia.model.Org;
import com.qujia.model.ProStaff;
import com.qujia.util.ViewUtil;

public class SearchSuperiorFrm extends JDialog {

          private JPanel contentPane;
          private JTextField textField_proName;
          private JTable table;
          private List<Org> orgList;
          private List<ProStaff> staffList;
          private JComboBox comboBox_perType;
          private static int index;
          private static String pNo;
          private static String pName;
          
          public static String getpNo() {
                    return pNo;
          }

          public static void setpNo(String pNo) {
                    SearchSuperiorFrm.pNo = pNo;
          }

          public static String getpName() {
                    return pName;
          }

          public static void setpName(String pName) {
                    SearchSuperiorFrm.pName = pName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SearchSuperiorFrm frame = new SearchSuperiorFrm(null);
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
          public SearchSuperiorFrm(JFrame fr) {
                    super(fr, "", true);
                    setTitle("직속상사조회");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 554, 300);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                    
                    JLabel lblNewLabel = new JLabel("\uC9C1\uC6D0\uC774\uB984:");
                    lblNewLabel.setBounds(10, 24, 65, 15);
                    contentPane.add(lblNewLabel);
                    
                    textField_proName = new JTextField();
                    textField_proName.setBounds(85, 21, 98, 21);
                    contentPane.add(textField_proName);
                    textField_proName.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uC870\uD68C");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchStaffAction(e);
                              }
                    });
                    btnNewButton.setBounds(391, 20, 76, 23);
                    contentPane.add(btnNewButton);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 48, 518, 170);
                    contentPane.add(scrollPane);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectRowAction(e);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC9C1\uC6D0\uBC88\uD638", "\uC9C1\uC6D0\uC774\uB984", "\uC131\uBCC4", "\uC9C1\uC6D0\uAD6C\uBD84", "\uC18C\uC18D\uC870\uC9C1", "\uC9C1\uC18D\uC0C1\uC0AC"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(67);
                    table.getColumnModel().getColumn(1).setPreferredWidth(68);
                    table.getColumnModel().getColumn(2).setPreferredWidth(48);
                    table.getColumnModel().getColumn(4).setPreferredWidth(112);
                    table.getColumnModel().getColumn(5).setPreferredWidth(70);
                    scrollPane.setViewportView(table);
                    
                    JButton btnNewButton_1 = new JButton("\uD655 \uC778");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        submitAction(e);
                              }
                    });
                    btnNewButton_1.setBounds(278, 228, 68, 23);
                    contentPane.add(btnNewButton_1);
                    
                    JButton button = new JButton("\uCDE8 \uC18C");
                    button.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        pNo=null;
                                        pName=null;
                                        dispose();
                              }
                    });
                    button.setBounds(410, 228, 68, 23);
                    contentPane.add(button);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uC9C1\uC6D0\uAD6C\uBD84:");
                    lblNewLabel_1.setBounds(204, 24, 68, 15);
                    contentPane.add(lblNewLabel_1);
                    
                     comboBox_perType = new JComboBox();
                    comboBox_perType.setModel(new DefaultComboBoxModel(new String[] {"", "\uBD80\uC7A5", "\uCC28\uC7A5", "\uB300\uB9AC", "\uC0AC\uC6D0"}));
                    comboBox_perType.setBounds(277, 21, 104, 21);
                    contentPane.add(comboBox_perType);
                    
                    setTable(new ProStaff());
          }
          
          protected void submitAction(ActionEvent e) {
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
                    
                    pNo=dft.getValueAt(index, 0).toString();
                    pName=dft.getValueAt(index, 1).toString();
          }

          protected void selectRowAction(MouseEvent e) {
                    index=table.getSelectedRow();
          }

          protected void searchStaffAction(ActionEvent e) {
                    // TODO Auto-generated method stub
                    String staffName = textField_proName.getText().toString();
                    String perType = comboBox_perType.getSelectedItem().toString();
                    ProStaff ps=new ProStaff();
                    ps.setpName(staffName);
                    ps.setPerType(perType);
                    setTable(ps);
          }

          private void setTable(ProStaff proStaff) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    ProStaffDao psDao=new ProStaffDao();
                    List<ProStaff> proStaffList = psDao.getProStaffList( proStaff);
                    for(ProStaff pslist : proStaffList){
                              Vector v=new Vector();
                              v.add(pslist.getpNo());
                              v.add(pslist.getpName());
                              v.add(pslist.getSex());
                              v.add(pslist.getPerType());
                              v.add(this.getOrgNameById(pslist.getOrgId()));
                              v.add(this.getStaffNameById(pslist.getSupId()));
//                              v.add(pslist.getSupId());
                              dft.addRow(v);
                    }
                    psDao.closeDao();
          }

          private Object getStaffNameById(String supId) {
                    ProStaffDao psDao=new ProStaffDao();
                    staffList=psDao.getProStaffList(new ProStaff());
                    for (ProStaff ps : staffList) {
                              if(ps.getpNo().equals(supId)) return ps.getpName();
                    }
                    return null;
          }

          public String getOrgNameById(String id){
                    OrgDao orgDao=new OrgDao();
                    orgList = orgDao.getOrgList(new Org());
                    for(Org org:orgList){
                            if(org.getOrgCode().equals(id)) return org.getName();
                    }
                    return "";
          }

}
