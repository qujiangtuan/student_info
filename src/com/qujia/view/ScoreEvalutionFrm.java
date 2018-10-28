package com.qujia.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qujia.util.ViewUtil;

public class ScoreEvalutionFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JLabel lblNewLabel_2;
          private JComboBox comboBox;
          private JLabel label;
          private JComboBox comboBox_1;
          private JLabel label_1;
          private JComboBox comboBox_2;
          private JLabel label_2;
          private JComboBox comboBox_3;
          private JLabel label_3;
          private JComboBox comboBox_4;
          private JDesktopPane desktopPane;
          private JLabel lblNewLabel_4;
          private JLabel label_5;
          private JButton btnNewButton;

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
                    this.setResizable(false);
                    setTitle("\uC131\uC801\uD3C9\uAC00");
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 699, 474);
                    
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uACFC\uBAA9\uBA85:");
                    lblNewLabel.setBounds(17, 19, 50, 15);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uC0DD\uC218:");
                    lblNewLabel_1.setBounds(199, 19, 52, 15);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(17, 48, 649, 312);
                    
                    lblNewLabel_2 = new JLabel("\uC911\uAC04\uACE0\uC0AC:");
                    lblNewLabel_2.setBounds(17, 381, 65, 15);
                    
                    comboBox = new JComboBox();
                    comboBox.setBounds(79, 378, 53, 21);
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox.setEditable(true);
                    
                    label = new JLabel("\uAE30\uB9D0\uACE0\uC0AC:");
                    label.setBounds(150, 381, 55, 15);
                    
                    comboBox_1 = new JComboBox();
                    comboBox_1.setBounds(217, 378, 53, 21);
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_1.setEditable(true);
                    
                    label_1 = new JLabel("\uACFC\uC81C:");
                    label_1.setBounds(303, 381, 40, 15);
                    
                    comboBox_2 = new JComboBox();
                    comboBox_2.setBounds(334, 378, 53, 21);
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_2.setEditable(true);
                    
                    label_2 = new JLabel("\uCD9C\uC11D:");
                    label_2.setBounds(423, 381, 40, 15);
                    
                    comboBox_3 = new JComboBox();
                    comboBox_3.setBounds(461, 378, 53, 21);
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_3.setEditable(true);
                    
                    label_3 = new JLabel("\uBC1C\uD45C:");
                    label_3.setBounds(545, 381, 40, 15);
                    
                    comboBox_4 = new JComboBox();
                    comboBox_4.setBounds(579, 378, 53, 21);
                    comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_4.setEditable(true);
                    
                    desktopPane = new JDesktopPane();
                    desktopPane.setBounds(416, 15, 1, 1);
                    
                    lblNewLabel_4 = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4 \uC2E4\uC2B5");
                    lblNewLabel_4.setBounds(79, 19, 112, 15);
                    
                    label_5 = new JLabel("1");
                    label_5.setBounds(257, 19, 34, 15);
                    
                    btnNewButton = new JButton("\uC131\uC801\uC785\uB825/\uBCC0\uACBD");
                    btnNewButton.setBounds(518, 15, 126, 23);
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        ScoreInputFrm sif=new ScoreInputFrm();
                                        sif.setVisible(true);
                              }
                    });
                    btnNewButton.setBackground(new Color(224, 255, 255));
                    
                    table = new JTable();
                    table.setRowHeight(30);
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                                        {null, null, null, null, null},
                              },
                              new String[] {
                                        "\uC18C\uC18D\uD559\uACFC", "\uD559\uC0DD\uC774\uB984", "\uD559\uBC88", "\uD559\uB144", "\uC131\uC801\uB4F1\uAE09"
                              }
                    ) {
                              boolean[] columnEditables = new boolean[] {
                                        false, false, false, false, false
                              };
                              public boolean isCellEditable(int row, int column) {
                                        return columnEditables[column];
                              }
                    });
                    table.getColumnModel().getColumn(0).setPreferredWidth(121);
                    table.getColumnModel().getColumn(1).setPreferredWidth(112);
                    table.getColumnModel().getColumn(3).setPreferredWidth(59);
                    table.getColumnModel().getColumn(4).setPreferredWidth(97);
                    scrollPane.setViewportView(table);
                    contentPane.setLayout(null);
                    contentPane.add(lblNewLabel);
                    contentPane.add(lblNewLabel_4);
                    contentPane.add(lblNewLabel_1);
                    contentPane.add(label_5);
                    contentPane.add(desktopPane);
                    contentPane.add(btnNewButton);
                    contentPane.add(lblNewLabel_2);
                    contentPane.add(comboBox);
                    contentPane.add(label);
                    contentPane.add(comboBox_1);
                    contentPane.add(label_1);
                    contentPane.add(comboBox_2);
                    contentPane.add(label_2);
                    contentPane.add(comboBox_3);
                    contentPane.add(label_3);
                    contentPane.add(comboBox_4);
                    contentPane.add(scrollPane);
          }
//          public class ButtonColRender extends AbstractCellEditor implements ActionListener,TableCellRenderer,TableCellEditor{
//                    private JTable table;
//                    private DefaultTableModel model;
//                    private int row;
//                    
//                    private JButton button;
//                    
//                    public ButtonColRender() {
//                              super();
//                              this.button = new JButton("�����Է�");
//                              button.addActionListener(new ActionListener() {
//                                        
//                                        @Override
//                                        public void actionPerformed(ActionEvent e) {
//                                                  if(e.getSource()==button){
////                                                            ScoreEvalutionFrm sef=new ScoreEvalutionFrm();
//                                                            
//                                                            ScoreInputFrm sif=new ScoreInputFrm();
////                                                            sef.dispatchEvent(new WindowEvent(sif, WindowEvent.WINDOW_CLOSED));
//                                                            sif.setVisible(true);
//                                                  }
//                                                 
//                                        }
//                              });
//                    }
//                    
//                    @Override
//                    public Object getCellEditorValue() {
//                              // TODO Auto-generated method stub
//                              return null;
//                    }
//
//                    @Override
//                    public Component getTableCellEditorComponent(JTable table,
//                                        Object value, boolean isSelected, int row,
//                                        int cloumn) {
//                              this.table=table;
//                              this.row=row;
//                              this.model=(DefaultTableModel) table.getModel();
//                              return button;         
//                               
//                    }
//
//                    @Override
//                    public Component getTableCellRendererComponent(JTable arg0,
//                                        Object arg1, boolean arg2,
//                                        boolean arg3, int arg4, int arg5) {
//                              // TODO Auto-generated method stub
//                              return button;
//                    }
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                              // TODO Auto-generated method stub
//                              
//                    }
//                    
//          }
}
