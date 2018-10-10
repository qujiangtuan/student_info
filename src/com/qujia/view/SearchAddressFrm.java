package com.qujia.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.dao.AddressDao;
import com.qujia.model.Address;
import com.qujia.util.ViewUtil;

public class SearchAddressFrm extends JDialog {

          private JPanel contentPane;
          private JTextField textField_dong;
          private JTable table;
          private JTextField textField_bldg;
          private static int index;
          private static String searchAddr;
          

          public static String getSearchAddr() {
                    return searchAddr;
          }

          public static void setSearchAddr(String searchAddr) {
                    SearchAddressFrm.searchAddr = searchAddr;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  SearchAddressFrm frame = new SearchAddressFrm(null);
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
          public SearchAddressFrm(JFrame fr) {
                    super(fr, "", true);
                    
                    setTitle("\uC8FC\uC18C\uAC80\uC0C9");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 763, 435);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                    
                    JLabel label_dong = new JLabel("\uB3D9:");
                    label_dong.setBounds(58, 29, 26, 15);
                    contentPane.add(label_dong);
                    
                    textField_dong = new JTextField();
                    textField_dong.setBounds(105, 26, 152, 21);
                    contentPane.add(textField_dong);
                    textField_dong.setColumns(10);
                    
                    JButton btnNewButton = new JButton("\uC870 \uD68C");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        searchAddress(e);
                              }
                    });
                    btnNewButton.setBounds(615, 25, 93, 23);
                    contentPane.add(btnNewButton);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 61, 727, 239);
                    contentPane.add(scrollPane);
                    
                    table = new JTable();
                    table.addMouseListener(new MouseAdapter() {
                              @Override
                              public void mouseClicked(MouseEvent e) {
                                        selectRowME(e);
                              }
                    });
                    table.setRowHeight(25);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC6B0\uD3B8\uBC88\uD638", "\uC2DC", "\uAD70", "\uB3D9", "\uB9AC", "\uAC74\uBB3C", "\uBC88\uC9C0", "\uC21C\uBC88"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(66);
                    table.getColumnModel().getColumn(1).setPreferredWidth(62);
                    table.getColumnModel().getColumn(2).setPreferredWidth(78);
                    table.getColumnModel().getColumn(3).setPreferredWidth(79);
                    table.getColumnModel().getColumn(4).setPreferredWidth(103);
                    table.getColumnModel().getColumn(5).setPreferredWidth(145);
                    table.getColumnModel().getColumn(6).setPreferredWidth(151);
                    table.getColumnModel().getColumn(7).setPreferredWidth(65);
                    scrollPane.setViewportView(table);
                    table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
                    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    
                    JButton btnNewButton_1 = new JButton("\uD655 \uC778");
                    btnNewButton_1.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        serarchAddrAction(e);
//                                        printAddress();
                              }
                    });
                    btnNewButton_1.setBounds(501, 326, 93, 23);
                    contentPane.add(btnNewButton_1);
                    
                    JButton btnNewButton_2 = new JButton("\uCDE8 \uC18C");
                    btnNewButton_2.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        index=-1;
                                        searchAddr=null;
                                        dispose();
                              }
                    });
                    btnNewButton_2.setBounds(615, 326, 93, 23);
                    contentPane.add(btnNewButton_2);
                    
                    JLabel lblNewLabel = new JLabel("\uAC74\uBB3C:");
                    lblNewLabel.setBounds(319, 29, 54, 15);
                    contentPane.add(lblNewLabel);
                    
                    textField_bldg = new JTextField();
                    textField_bldg.setBounds(365, 26, 195, 21);
                    contentPane.add(textField_bldg);
                    textField_bldg.setColumns(10);
                    
                    setTable(new Address());
          }
          protected void serarchAddrAction(ActionEvent e) {
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
//                    deptName=dft.getValueAt(index, 1).toString();
                    String seq=dft.getValueAt(index, 7).toString();
                    Address addr=new Address();
                    Address addrTmp=new Address();
                    addr.setSeq(seq);
                    AddressDao addrDao =new AddressDao();
                    addrTmp=addrDao.getSearchAddr(addr);
                    searchAddr=addrTmp.toString();
          }

          //select 선택
          protected void selectRowME(MouseEvent e) {
                    index=table.getSelectedRow();
//                    System.out.println("index-"+index);
          }

//          private void printAddress() {
//                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
//                    String seq=dft.getValueAt(index, 7).toString();
////                    System.out.println("seq:"+seq);
//                    Address addr=new Address();
//                    Address addrTmp=new Address();
//                    addr.setSeq(seq);
//                    AddressDao addrDao =new AddressDao();
//                    addrTmp=addrDao.getSearchAddr(addr);
//                    searchAddr=addrTmp.toString();
////                    System.out.println(addrTmp);
//          }

          //주소 조회
          protected void searchAddress(ActionEvent e) {
                    Address addr=new Address();
                    String dong = textField_dong.getText().toString();
                    String bldg=textField_bldg.getText().toString();
                    addr.setDong(dong);
                    addr.setBldg(bldg);
                    setTable(addr);
          }
          //table 설정
          private void setTable(Address address) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    AddressDao addrDao=new AddressDao();
                    List<Address> addrList = addrDao.getAddressList(address);
                    for(Address a : addrList){
                              Vector v=new Vector();
                              v.add(a.getZipcode());
                              v.add(a.getSido());
                              v.add(a.getGugun());
                              v.add(a.getDong());
                              v.add(a.getRi());
                              v.add(a.getBldg());
                              v.add(a.getBunji());
                              v.add(a.getSeq());
                              dft.addRow(v);
                    }
                    addrDao.closeDao();
          }
}
