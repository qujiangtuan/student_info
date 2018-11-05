package com.qujia.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.ProStaffDao;
import com.qujia.model.ProStaff;
import com.qujia.util.ViewUtil;

public class SearchProfroCourseFrm extends JDialog {

          private final JPanel contentPanel = new JPanel();
          private JTextField textField_proName;
          private JTable table;
          private static int index=-1;
          private static String pNo;
          private static String pName;
          private JComboBox comboBox_perType;
          

          public static String getpNo() {
                    return pNo;
          }

          public static void setpNo(String pNo) {
                    SearchProfroCourseFrm.pNo = pNo;
          }

          public static String getpName() {
                    return pName;
          }

          public static void setpName(String pName) {
                    SearchProfroCourseFrm.pName = pName;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    try {
                              SearchProfroCourseFrm dialog = new SearchProfroCourseFrm(null);
                              dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                              dialog.setVisible(true);
                    } catch (Exception e) {
                              e.printStackTrace();
                    }
          }

          /**
           * Create the dialog.
           */
          public SearchProfroCourseFrm(JFrame fr) {
                    super(fr, "", true);
                    setTitle("교원조회");
                    setBounds(100, 100, 686, 390);
                    this.setResizable(false);

                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    getContentPane().setLayout(new BorderLayout());
                    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                    getContentPane().add(contentPanel, BorderLayout.CENTER);
                    contentPanel.setLayout(null);
                    {
                              JLabel lblNewLabel = new JLabel("교원명:");
                              lblNewLabel.setBounds(28, 24, 57, 15);
                              contentPanel.add(lblNewLabel);
                    }
                    {
                              textField_proName = new JTextField();
                              textField_proName.setBounds(97, 21, 116, 21);
                              contentPanel.add(textField_proName);
                              textField_proName.setColumns(10);
                    }
                    {
                              JLabel lblNewLabel_1 = new JLabel("교원구분:");
                              lblNewLabel_1.setBounds(225, 24, 65, 15);
                              contentPanel.add(lblNewLabel_1);
                    }
                    {
                              comboBox_perType = new JComboBox();
                              comboBox_perType.setModel(new DefaultComboBoxModel(new String[] {"", "전임교수", "겸임교수", "시간강사"}));
                              comboBox_perType.setBounds(288, 21, 104, 21);
                              contentPanel.add(comboBox_perType);
                    }
                    
                    JButton btnNewButton = new JButton("조회");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        String proName = textField_proName.getText().toString();
                                        String perType = comboBox_perType.getSelectedItem().toString();
                                        ProStaff ps=new ProStaff();
                                        ps.setpName(proName);
                                        ps.setPerType(perType);
                                        setTable(ps);
                              }
                    });
                    btnNewButton.setBounds(465, 20, 97, 23);
                    contentPanel.add(btnNewButton);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(12, 57, 646, 253);
                    contentPanel.add(scrollPane);
                    
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
                                        {null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uAD50\uC6D0\uBC88\uD638", "\uAD50\uC6D0\uBA85", "\uAD50\uC6D0\uAD6C\uBD84", "\uC804\uC784\uAD50\uC218\uAD6C\uBD84", "\uC131\uBCC4", "\uC18C\uC18D\uD559\uACFC"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(3).setPreferredWidth(99);
                    scrollPane.setViewportView(table);
                    {
                              JPanel buttonPane = new JPanel();
                              buttonPane.setLayout(new FlowLayout(
                                                  FlowLayout.RIGHT));
                              getContentPane().add(buttonPane,
                                                  BorderLayout.SOUTH);
                              {
                                        JButton okButton = new JButton("확인");
                                        okButton.addActionListener(new ActionListener() {
                                                  public void actionPerformed(ActionEvent e) {
                                                            submitAction(e);
                                                  }
                                        });
                                        okButton.setActionCommand("OK");
                                        buttonPane.add(okButton);
                                        getRootPane().setDefaultButton(okButton);
                              }
                              {
                                        JButton cancelButton = new JButton(
                                                            "취소");
                                        cancelButton.addActionListener(new ActionListener() {
                                                  public void actionPerformed(ActionEvent e) {
                                                            pNo=null;
                                                            pName=null;
                                                            dispose();
                                                  }
                                        });
                                        cancelButton.setActionCommand("Cancel");
                                        buttonPane.add(cancelButton);
                              }
                    }
                    setTable(new ProStaff());
          }
          //submit
          protected void submitAction(ActionEvent e) {
                    if(index==-1){
                              JOptionPane.showMessageDialog(this, "평가질문유형을 선택해주세요!");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
                    
                    pNo=dft.getValueAt(index, 0).toString();
                    pName=dft.getValueAt(index, 1).toString();
          }

          //select one row
          protected void selectRow(MouseEvent e) {
                    index=table.getSelectedRow();
          }

          //setTable
          private void setTable(ProStaff proStaff) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    ProStaffDao psDao=new ProStaffDao();
                    List<ProStaff> proStaffList = psDao.getSearchProList(proStaff);
                    for(ProStaff pslist : proStaffList){
                              Vector v=new Vector();
                              v.add(pslist.getpNo());
                              v.add(pslist.getpName());
                              v.add(pslist.getPerType());
                              v.add(pslist.getTeaType());
                              v.add(pslist.getSex());
                              v.add(pslist.getOrgName());
                              dft.addRow(v);
                    }
                    psDao.closeDao();
          }
          
}
