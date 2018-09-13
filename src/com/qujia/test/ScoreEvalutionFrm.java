package com.qujia.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.qujia.view.MainFrm;
import com.qujia.view.ScoreInputFrm;

public class ScoreEvalutionFrm extends JFrame {

          private JPanel contentPane;
          private JDesktopPane desktopPane;
          private JLabel label;
          private JTextField textField;
          private JLabel label_1;
          private JTextField textField_1;
          private JLabel label_2;
          private JLabel label_3;
          private JDesktopPane desktopPane_1;
          private JLabel label_4;
          private JComboBox comboBox;
          private JLabel label_5;
          private JComboBox comboBox_1;
          private JLabel label_6;
          private JComboBox comboBox_2;
          private JLabel label_7;
          private JComboBox comboBox_3;
          private JLabel label_8;
          private JComboBox comboBox_4;
          private JScrollPane scrollPane;
          private JTable table;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  ScoreEvalutionFrm frame = new ScoreEvalutionFrm();
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
          public ScoreEvalutionFrm() {
                    setTitle("\uC131\uC801\uD3C9\uAC00");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 699, 474);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    desktopPane = new JDesktopPane();
                    desktopPane.setBackground(new Color(248, 248, 255));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                  .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    
                    label = new JLabel("\uACFC\uBAA9\uBA85:");
                    label.setBounds(10, 13, 42, 15);
                    desktopPane.add(label);
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    textField.setBounds(56, 10, 66, 21);
                    desktopPane.add(textField);
                    
                    label_1 = new JLabel("\uD559\uC0DD\uC218:");
                    label_1.setBounds(132, 13, 42, 15);
                    desktopPane.add(label_1);
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    textField_1.setBounds(178, 10, 66, 21);
                    desktopPane.add(textField_1);
                    
                    label_2 = new JLabel("\uD559\uC810:");
                    label_2.setBounds(274, 13, 42, 15);
                    desktopPane.add(label_2);
                    
                    label_3 = new JLabel("3");
                    label_3.setBounds(322, 13, 6, 15);
                    desktopPane.add(label_3);
                    
                    desktopPane_1 = new JDesktopPane();
                    desktopPane_1.setBounds(412, 10, 1, 1);
                    desktopPane.add(desktopPane_1);
                    
                    label_4 = new JLabel("\uC911\uAC04\uACE0\uC0AC:");
                    label_4.setBounds(10, 374, 54, 15);
                    desktopPane.add(label_4);
                    
                    comboBox = new JComboBox();
                    comboBox.setEditable(true);
                    comboBox.setBounds(68, 371, 53, 21);
                    desktopPane.add(comboBox);
                    
                    label_5 = new JLabel("\uAE30\uB9D0\uACE0\uC0AC:");
                    label_5.setBounds(131, 374, 54, 15);
                    desktopPane.add(label_5);
                    
                    comboBox_1 = new JComboBox();
                    comboBox_1.setEditable(true);
                    comboBox_1.setBounds(189, 371, 53, 21);
                    desktopPane.add(comboBox_1);
                    
                    label_6 = new JLabel("\uACFC\uC81C:");
                    label_6.setBounds(260, 374, 30, 15);
                    desktopPane.add(label_6);
                    
                    comboBox_2 = new JComboBox();
                    comboBox_2.setEditable(true);
                    comboBox_2.setBounds(294, 371, 53, 21);
                    desktopPane.add(comboBox_2);
                    
                    label_7 = new JLabel("\uCD9C\uC11D:");
                    label_7.setBounds(365, 374, 30, 15);
                    desktopPane.add(label_7);
                    
                    comboBox_3 = new JComboBox();
                    comboBox_3.setEditable(true);
                    comboBox_3.setBounds(399, 371, 53, 21);
                    desktopPane.add(comboBox_3);
                    
                    label_8 = new JLabel("\uBC1C\uD45C:");
                    label_8.setBounds(470, 374, 30, 15);
                    desktopPane.add(label_8);
                    
                    comboBox_4 = new JComboBox();
                    comboBox_4.setEditable(true);
                    comboBox_4.setBounds(504, 371, 53, 21);
                    desktopPane.add(comboBox_4);
                    
                    scrollPane = new JScrollPane();
                    scrollPane.setBounds(10, 41, 653, 312);
                    desktopPane.add(scrollPane);
                    
                    table = new JTable();
                    
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                                        {null, null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC21C\uBC88", "\uC18C\uC18D\uD559\uACFC", "\uD559\uB144", "\uD559\uC0DD\uC774\uB984", "\uC131\uC801\uB4F1\uB85D", "\uC131\uC801\uB4F1\uAE09"
                              }
                    ));
                    table.setRowHeight(30);
                    table.getColumnModel().getColumn(4).setCellEditor(new ButtonColRender());
                    table.getColumnModel().getColumn(4).setCellRenderer(new ButtonColRender());
                    table.getColumnModel().getColumn(0).setPreferredWidth(51);
                    table.getColumnModel().getColumn(1).setPreferredWidth(126);
                    table.getColumnModel().getColumn(2).setPreferredWidth(44);
                    table.getColumnModel().getColumn(3).setPreferredWidth(94);
                    table.getColumnModel().getColumn(4).setPreferredWidth(111);
                    table.getColumnModel().getColumn(5).setPreferredWidth(67);
                    table.setRowHeight(30);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(gl_contentPane);
          }
          public class ButtonColRender extends AbstractCellEditor implements ActionListener,TableCellRenderer,TableCellEditor{
                    private JTable table;
                    private DefaultTableModel model;
                    private int row;
                    
                    private JButton button;
                    
                    public ButtonColRender() {
                              super();
                              this.button = new JButton("성적입력");
                              button.addActionListener(new ActionListener() {
                                        
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                                  if(e.getSource()==button){
                                                            ScoreEvalutionFrm sef=new ScoreEvalutionFrm();
                                                            sef.dispose();
                                                            new ScoreInputFrm().setVisible(true);
                                                  }
                                                 
                                        }
                              });
                    }
                    
                    @Override
                    public Object getCellEditorValue() {
                              // TODO Auto-generated method stub
                              return null;
                    }

                    @Override
                    public Component getTableCellEditorComponent(JTable table,
                                        Object value, boolean isSelected, int row,
                                        int cloumn) {
                              this.table=table;
                              this.row=row;
                              this.model=(DefaultTableModel) table.getModel();
                              return button;         
                               
                    }

                    @Override
                    public Component getTableCellRendererComponent(JTable arg0,
                                        Object arg1, boolean arg2,
                                        boolean arg3, int arg4, int arg5) {
                              // TODO Auto-generated method stub
                              return button;
                    }

                    @Override
                    public void actionPerformed(ActionEvent e) {
                              // TODO Auto-generated method stub
                              
                    }
                    
          }
}
