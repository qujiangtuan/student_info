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

import com.qujia.dao.QuestionDao;
import com.qujia.model.Question;
import com.qujia.util.ViewUtil;

public class searchQuestion extends JDialog {

          private final JPanel contentPanel = new JPanel();
          private JTextField textField_proName;
          private JTable table;
          private JComboBox comboBox_perType ;
          private static int row=-1;
          private static String queName;
          private static String id;
          
          public static String getQueName() {
                    return queName;
          }

          public static void setQueName(String queName) {
                    searchQuestion.queName = queName;
          }
          public static String getId() {
                    return id;
          }

          public static void setId(String id) {
                    searchQuestion.id = id;
          }

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    try {
                              searchQuestion dialog = new searchQuestion(null);
                              dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                              dialog.setVisible(true);
                    } catch (Exception e) {
                              e.printStackTrace();
                    }
          }

          /**
           * Create the dialog.
           */
          public searchQuestion(JFrame fr) {
                    super(fr, "", true);
                    
                    setTitle("질문유형조회");
                    setBounds(100, 100, 682, 359);
                    
                    ViewUtil vu=new ViewUtil();
                    vu.showCenter(this);
                    
                    getContentPane().setLayout(new BorderLayout());
                    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                    getContentPane().add(contentPanel, BorderLayout.CENTER);
                    contentPanel.setLayout(null);
                    {
                              JLabel lblNewLabel = new JLabel("평가질문내용:");
                              lblNewLabel.setBounds(24, 22, 90, 15);
                              contentPanel.add(lblNewLabel);
                    }
                    {
                              textField_proName = new JTextField();
                              textField_proName.setBounds(106, 19, 177, 21);
                              contentPanel.add(textField_proName);
                              textField_proName.setColumns(10);
                    }
                    {
                              JLabel lblNewLabel_1 = new JLabel("평가대상:");
                              lblNewLabel_1.setBounds(304, 22, 73, 15);
                              contentPanel.add(lblNewLabel_1);
                    }
                    {
                              comboBox_perType = new JComboBox();
                              comboBox_perType.setModel(new DefaultComboBoxModel(new String[] {"", "개설과정", "강의교수"}));
                              comboBox_perType.setBounds(362, 19, 146, 21);
                              contentPanel.add(comboBox_perType);
                    }
                    {
                              JButton btnNewButton = new JButton("조회");
                              btnNewButton.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                  searchQue(e);
                                        }
                              });
                              btnNewButton.setBounds(520, 18, 97, 23);
                              contentPanel.add(btnNewButton);
                    }
                    {
                              JScrollPane scrollPane = new JScrollPane();
                              scrollPane.setBounds(12, 51, 639, 207);
                              contentPanel.add(scrollPane);
                              
                              table = new JTable();
                              table.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent arg0) {
                                                  row=table.getSelectedRow();
                                        }
                              });
                              table.setRowHeight(25);
                              table.setModel(new DefaultTableModel(
                                        new Object[][] {
                                                  {null, null, null},
                                        },
                                        new String[] {
                                                  "\uBC88\uD638", "\uD3C9\uAC00\uC9C8\uBB38\uB0B4\uC6A9", "\uD3C9\uAC00\uC9C8\uBB38\uB300\uC0C1"
                                        }
                              ) {
                                        boolean[] columnEditables = new boolean[] {
                                                  false, false, false
                                        };
                                        public boolean isCellEditable(int row, int column) {
                                                  return columnEditables[column];
                                        }
                              });
                              table.getColumnModel().getColumn(1).setPreferredWidth(427);
                              table.getColumnModel().getColumn(2).setPreferredWidth(140);
                              scrollPane.setViewportView(table);
                    }
                    {
                              JPanel buttonPane = new JPanel();
                              buttonPane.setLayout(new FlowLayout(
                                                  FlowLayout.RIGHT));
                              getContentPane().add(buttonPane,
                                                  BorderLayout.SOUTH);
                              {
                                        JButton okButton = new JButton("학인");
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
                                                            queName=null;
                                                  }
                                        });
                                        cancelButton.setActionCommand("Cancel");
                                        buttonPane.add(cancelButton);
                              }
                    }
                    setTable(new Question());
                    
                    
          }
          protected void searchQue(ActionEvent e) {
                    String name = textField_proName.getText().toString();
                    String type;
                    try {
                              type = comboBox_perType.getSelectedItem().toString();
                    } catch (Exception e2) {
                              type=null;
                    }
                    Question que=new Question();
                    que.setQue(name);
                    que.setObj(type);
                    setTable(que);
          }

          protected void submitAction(ActionEvent e) {
                    if(row==-1){
                              JOptionPane.showMessageDialog(this, "교원 선택해주세요!");
                              return;
                    }
                    DefaultTableModel   dft = (DefaultTableModel) table.getModel();
                    this.setVisible(false);
                    this.disable();
                    
                    queName=dft.getValueAt(row, 1).toString();
                    id=dft.getValueAt(row, 0).toString();
                    
          }

          private void setTable(Question question) {
                    DefaultTableModel dft = (DefaultTableModel) table.getModel();
                    dft.setRowCount(0);
                    QuestionDao quDao=new QuestionDao();
                    List<Question> quList = quDao.getQueList(question);
                    for(Question q : quList){
                              Vector v=new Vector();
                              v.add(q.getId());//0
                              v.add(q.getQue());
                              v.add(q.getObj());
                              dft.addRow(v);
                    }
                    quDao.closeDao();  
          }
}
