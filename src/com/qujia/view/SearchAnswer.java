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

import com.qujia.dao.AnswerDao;
import com.qujia.model.Answer;
import com.qujia.util.ViewUtil;

public class SearchAnswer extends JDialog {

          private final JPanel contentPanel = new JPanel();
          private JTextField textField_serchName;
          private JTable table;
          private JComboBox comboBox_searchType;
          private static int row=-1;
          private static String ansName;
          private static String id;
          
          public static String getAnsName() {
                    return ansName;
          }

          public static void setAnsName(String ansName) {
                    SearchAnswer.ansName = ansName;
          }

          public static String getId() {
                    return id;
          }

          public static void setId(String id) {
                    SearchAnswer.id = id;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    try {
                              SearchAnswer dialog = new SearchAnswer(null);
                              dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                              dialog.setVisible(true);
                    } catch (Exception e) {
                              e.printStackTrace();
                    }
          }

          /**
           * Create the dialog.
           */
          public SearchAnswer(JFrame fr) {
                    super(fr,"",true);
                    setTitle("답안유형조회");
                    setBounds(100, 100, 676, 391);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    getContentPane().setLayout(new BorderLayout());
                    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                    getContentPane().add(contentPanel, BorderLayout.CENTER);
                    contentPanel.setLayout(null);
                    {
                              JLabel lblNewLabel = new JLabel("답안유형이름:");
                              lblNewLabel.setBounds(44, 21, 91, 15);
                              contentPanel.add(lblNewLabel);
                    }
                    {
                              textField_serchName = new JTextField();
                              textField_serchName.setBounds(127, 18, 157, 21);
                              contentPanel.add(textField_serchName);
                              textField_serchName.setColumns(10);
                    }
                    {
                              JLabel lblNewLabel_1 = new JLabel("유형구분:");
                              lblNewLabel_1.setBounds(296, 21, 76, 15);
                              contentPanel.add(lblNewLabel_1);
                    }
                    {
                              comboBox_searchType = new JComboBox();
                              comboBox_searchType.setModel(new DefaultComboBoxModel(new String[] {"", "주관식", "객관식"}));
                              comboBox_searchType.setBounds(355, 18, 167, 21);
                              contentPanel.add(comboBox_searchType);
                    }
                    {
                              JButton btnNewButton = new JButton("조회");
                              btnNewButton.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                  searchAnswer(e);
                                        }
                              });
                              btnNewButton.setBounds(534, 17, 97, 23);
                              contentPanel.add(btnNewButton);
                    }
                    {
                              JScrollPane scrollPane = new JScrollPane();
                              scrollPane.setBounds(12, 49, 636, 242);
                              contentPanel.add(scrollPane);
                              {
                                        table = new JTable();
                                        table.addMouseListener(new MouseAdapter() {
                                                  @Override
                                                  public void mouseClicked(MouseEvent e) {
                                                            row=table.getSelectedRow();
                                                  }
                                        });
                                        table.setRowHeight(25);
                                        table.setModel(new DefaultTableModel(
                                                  new Object[][] {
                                                            {null, null, null, null},
                                                  },
                                                  new String[] {
                                                            "\uBC88\uD638", "\uB2F5\uC548\uC720\uD615\uBA85", "\uB2F5\uC548\uC720\uD615\uAD6C\uBD84", "\uCD94\uAC00\uC815\uBCF4"
                                                  }
                                        ) {
                                                  boolean[] columnEditables = new boolean[] {
                                                            false, false, false, false
                                                  };
                                                  public boolean isCellEditable(int row, int column) {
                                                            return columnEditables[column];
                                                  }
                                        });
                                        table.getColumnModel().getColumn(1).setPreferredWidth(298);
                                        table.getColumnModel().getColumn(2).setPreferredWidth(136);
                                        table.getColumnModel().getColumn(3).setPreferredWidth(117);
                                        scrollPane.setViewportView(table);
                              }
                    }
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
                                                            dispose();
                                                            id=null;
                                                            ansName=null;
                                                  }
                                        });
                                        cancelButton.setActionCommand("Cancel");
                                        buttonPane.add(cancelButton);
                              }
                    }
                    setTable(new Answer());
                    
          }

          protected void submitAction(ActionEvent e) {
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "답안유형을 선택해주세요!");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
                    
                    ansName=dft.getValueAt(row, 1).toString();
                    id=dft.getValueAt(row, 0).toString();
          }

          protected void searchAnswer(ActionEvent e) {
                    String serName = textField_serchName.getText().toString();
                    String serType = comboBox_searchType.getSelectedItem().toString();
                    Answer ans=new Answer();
                    ans.setAnsName(serName);
                    ans.setAnsType(serType);
                    setTable(ans);
                    
          }

          private void setTable(Answer answer) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    AnswerDao anDao=new AnswerDao();
                    List<Answer> ansList = anDao.getAnsList(answer);
                    for(Answer a : ansList){
                              Vector v=new Vector();
                              v.add(a.getId());
                              v.add(a.getAnsName());
                              v.add(a.getAnsType());
                              v.add(a.getInfo());
                              dft.addRow(v);
                    }
                    anDao.closeDao();  
          }

}
