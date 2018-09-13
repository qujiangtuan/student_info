package com.qujia.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.JDesktopPane;

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
          private JLabel label_4;
          private JLabel lblNewLabel_3;
          private JDesktopPane desktopPane;
          private JLabel lblNewLabel_4;
          private JLabel label_5;

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
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    setBounds(100, 100, 699, 474);
                    
                    ViewUtil view =new ViewUtil();
                    view.showCenter(this);
                    
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JLabel lblNewLabel = new JLabel("\uACFC\uBAA9\uBA85:");
                    
                    JLabel lblNewLabel_1 = new JLabel("\uD559\uC0DD\uC218:");
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    lblNewLabel_2 = new JLabel("\uC911\uAC04\uACE0\uC0AC:");
                    
                    comboBox = new JComboBox();
                    comboBox.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox.setEditable(true);
                    
                    label = new JLabel("\uAE30\uB9D0\uACE0\uC0AC:");
                    
                    comboBox_1 = new JComboBox();
                    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_1.setEditable(true);
                    
                    label_1 = new JLabel("\uACFC\uC81C:");
                    
                    comboBox_2 = new JComboBox();
                    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_2.setEditable(true);
                    
                    label_2 = new JLabel("\uCD9C\uC11D:");
                    
                    comboBox_3 = new JComboBox();
                    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_3.setEditable(true);
                    
                    label_3 = new JLabel("\uBC1C\uD45C:");
                    
                    comboBox_4 = new JComboBox();
                    comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"0%", "5%", "10%", "15%", "20%", "25%", "30%", "40%", "45%", "50%", "55%", "60%", "65%", "70%", "75%", "80%", "85%", "90%", "95%", "100%"}));
                    comboBox_4.setEditable(true);
                    
                    label_4 = new JLabel("\uD559\uC810:");
                    
                    lblNewLabel_3 = new JLabel("3");
                    
                    desktopPane = new JDesktopPane();
                    
                    lblNewLabel_4 = new JLabel("\uB370\uC774\uD130\uBCA0\uC774\uC2A4 \uC2E4\uC2B5");
                    
                    label_5 = new JLabel("1");
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(lblNewLabel_4)
                                                                      .addGap(20)
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(label_5)
                                                                      .addGap(6)
                                                                      .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(30)
                                                                                          .addComponent(label_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                                                          .addPreferredGap(ComponentPlacement.RELATED)
                                                                                          .addComponent(lblNewLabel_3))
                                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                                          .addGap(168)
                                                                                          .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addComponent(lblNewLabel_2)
                                                                      .addPreferredGap(ComponentPlacement.RELATED)
                                                                      .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                      .addComponent(label)
                                                                      .addGap(4)
                                                                      .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(18)
                                                                      .addComponent(label_1)
                                                                      .addGap(4)
                                                                      .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(18)
                                                                      .addComponent(label_2)
                                                                      .addGap(4)
                                                                      .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                                                      .addGap(18)
                                                                      .addComponent(label_3)
                                                                      .addGap(4)
                                                                      .addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
                                                  .addContainerGap())
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addContainerGap()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel)
                                                                      .addComponent(lblNewLabel_1)
                                                                      .addComponent(label_4)
                                                                      .addComponent(lblNewLabel_3)
                                                                      .addComponent(lblNewLabel_4)
                                                                      .addComponent(label_5))
                                                            .addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(3)
                                                                      .addComponent(label_3))
                                                            .addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(3)
                                                                      .addComponent(label_2))
                                                            .addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(3)
                                                                      .addComponent(label_1))
                                                            .addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                                      .addComponent(lblNewLabel_2)
                                                                      .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addGap(3)
                                                                      .addComponent(label))
                                                            .addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    );
                    
                    table = new JTable();
                    table.setRowHeight(30);
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
                              },
                              new String[] {
                                        "\uC21C\uBC88", "\uC18C\uC18D\uD559\uACFC", "\uD559\uB144", "\uD559\uC0DD\uC774\uB984", "\uC131\uC801\uB4F1\uB85D", "\uC131\uC801\uB4F1\uAE09"
                              }
                    ));
                    table.getColumnModel().getColumn(4).setCellEditor(new ButtonColRender());
                    table.getColumnModel().getColumn(4).setCellRenderer(new ButtonColRender());
                    table.getColumnModel().getColumn(1).setPreferredWidth(121);
                    table.getColumnModel().getColumn(2).setPreferredWidth(59);
                    table.getColumnModel().getColumn(3).setPreferredWidth(112);
                    table.getColumnModel().getColumn(5).setPreferredWidth(97);
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
//                                                            ScoreEvalutionFrm sef=new ScoreEvalutionFrm();
                                                            
                                                            ScoreInputFrm sif=new ScoreInputFrm();
//                                                            sef.dispatchEvent(new WindowEvent(sif, WindowEvent.WINDOW_CLOSED));
                                                            sif.setVisible(true);
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
