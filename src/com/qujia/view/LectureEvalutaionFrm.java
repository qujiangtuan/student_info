package com.qujia.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.qujia.model.QuestionItem;
import com.qujia.test1.MyRadioCellEditor;
import com.qujia.test1.MyRadioCellRenderer;
import com.qujia.test1.MyRadioPanel;

public class LectureEvalutaionFrm extends JFrame {

          private JPanel contentPane;
          private JTable table;
          private JTextField textField;
          private JTextField textField_1;

          /**
           * Launch the application.
           */
          public static void main(String[] args) {
                    EventQueue.invokeLater(new Runnable() {
                              public void run() {
                                        try {
                                                  LectureEvalutaionFrm frame = new LectureEvalutaionFrm();
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
          public LectureEvalutaionFrm() {
                    setTitle("\uAC15\uC758\uD3C9\uAC00");
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setBounds(100, 100, 718, 445);
                    contentPane = new JPanel();
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    
                    JScrollPane scrollPane = new JScrollPane();
                    
                    JLabel lblNewLabel = new JLabel("\uACFC\uBAA9\uBA85:");
                    
                    textField = new JTextField();
                    textField.setColumns(10);
                    
                    table = new JTable();
                    table.setRowHeight(20);
                   
                    table.setModel(new DefaultTableModel(
                              new Object[][] {
                                        {null, null, null},
                                        {null, null, null},
                                        {null, null, null},
                                        {null, null, null},
                                        {null, null, null},
                              },
                              new String[] {
                                        "\uBC88\uD638", "\uC124\uBB38\uD56D\uBAA9", "점수 평가"
                              }
                    ));
//                    table.getColumnModel().getColumn(1).setPreferredWidth(425);
//                    table.getColumnModel().getColumn(2).setPreferredWidth(127);
//                    
//                    TableColumn column = table.getColumnModel().getColumn(2);
//                    column.setMinWidth(206);
//                    
//                    table.getColumnModel().getColumn(2).setCellEditor(new OperationColRender());
//                    table.getColumnModel().getColumn(2).setCellRenderer(new OperationColRender());
//                    
//                    scrollPane.setViewportView(table);
//                    contentPane.setLayout(gl_contentPane);
                    
                    table.getColumnModel().getColumn(1).setPreferredWidth(425);
                    table.getColumnModel().getColumn(2).setPreferredWidth(127);
                    
                    TableColumn column = table.getColumnModel().getColumn(2);
                    column.setMinWidth(206);
                    String[] answer = { "5", "4", "3","2","1" };
                    table.getColumnModel().getColumn(2).setCellEditor(new MyRadioCellEditor(new MyRadioPanel(answer)));
                    table.getColumnModel().getColumn(2).setCellRenderer(new MyRadioCellRenderer(answer));
                    
                    scrollPane.setViewportView(table);
                    
                    JLabel lblNewLabel_1 = new JLabel("\uB2F4\uB2F9\uAD50\uC218:");
                    
                    textField_1 = new JTextField();
                    textField_1.setColumns(10);
                    
                    JLabel lblNewLabel_2 = new JLabel("\uAC1D\uAD00\uC2DD:");
                    
                    JLabel lblNewLabel_3 = new JLabel("\uC8FC\uAD00\uC2DD:");
                    
                    JLabel label = new JLabel("\uC810\uACF5\uC774\uB098 \uAD50\uC591\uAD50\uC721\uACFC\uC815\uC5D0 \uB300\uD55C \uAC74\uC758\uC0AC\uD56D\uC774\uB098 \uAC1C\uC120\uD560 \uC810\uC774 \uC788\uB2E4\uBA74 \uC790\uC720\uB86D\uAC8C \uC81C\uC2DC\uD574 \uC8FC\uC2ED\uC2DC\uC624.");
                    
                    JScrollPane scrollPane_1 = new JScrollPane();
                    scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
                    
                    JLabel lblNewLabel_4 = new JLabel("[\uB9E4\uC6B0\uADF8\uB807\uB2E4]:(5) [\uB300\uCCB4\uB85C \uADF8\uB807\uB2E4]:(4) [\uADF8\uC800 \uADF8\uB807\uB2E4]:(3) [\uB300\uCCB4\uB85C \uC544\uB2C8\uB2E4]:(2) [\uC804\uD600 \uC544\uB2C8\uB2E4]:(1)");
                    
                    JButton btnNewButton = new JButton("\uD655\uC778");
                    btnNewButton.addActionListener(new ActionListener() {
                              public void actionPerformed(ActionEvent e) {
                                        QuestionItem qi=new QuestionItem();
                                        String score;
                                        JRadioButton radioButton = (JRadioButton) table.getColumnModel().getColumn(2).getCellEditor().getCellEditorValue();
                                        score=radioButton.getText();
                                        qi.setScore(score);
                                        System.err.println(qi);
                              }
                    });
                    btnNewButton.setBackground(new Color(176, 224, 230));
                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
                    gl_contentPane.setHorizontalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGap(19)
                                                                                .addComponent(lblNewLabel)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(34)
                                                                                .addComponent(lblNewLabel_1)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addGap(10)
                                                                                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(lblNewLabel_2)
                                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                                .addComponent(lblNewLabel_4))
                                                                      .addGroup(gl_contentPane.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(lblNewLabel_3)
                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                .addComponent(label)))
                                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                                      .addContainerGap()
                                                                      .addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)))
                                                  .addContainerGap())
                                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                                  .addContainerGap(587, Short.MAX_VALUE)
                                                  .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(29))
                    );
                    gl_contentPane.setVerticalGroup(
                              gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                  .addGap(10)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel)
                                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblNewLabel_1)
                                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                  .addGap(14)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_2)
                                                            .addComponent(lblNewLabel_4))
                                                  .addPreferredGap(ComponentPlacement.RELATED)
                                                  .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                                  .addPreferredGap(ComponentPlacement.UNRELATED)
                                                  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                                            .addComponent(lblNewLabel_3)
                                                            .addComponent(label))
                                                  .addGap(18)
                                                  .addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18)
                                                  .addComponent(btnNewButton)
                                                  .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    
                    JTextArea textArea = new JTextArea();
                    textArea.setLineWrap(true);
                    scrollPane_1.setViewportView(textArea);
                    contentPane.setLayout(gl_contentPane);
                    
                    
          }
          public class OperationColRender extends AbstractCellEditor implements TableCellRenderer,TableCellEditor{
                    private JTable table;
                    private int row;
                    private DefaultTableModel model;
                    private JPanel jPanel=new JPanel();
                    private JRadioButton  radioButton_1,radioButton_2,radioButton_3,radioButton_4,radioButton_5;
                    private ButtonGroup btGroup;
                    public OperationColRender() {
                             jPanel.setLayout(null);
                             radioButton_1=new JRadioButton("5");
                             radioButton_2=new JRadioButton("4");
                             radioButton_3=new JRadioButton("3");
                             radioButton_4=new JRadioButton("2");
                             radioButton_5=new JRadioButton("1");
                             radioButton_1.setBounds(5, 5, 40, 15);
                             radioButton_2.setBounds(45,5,40,15);
                             radioButton_3.setBounds(85, 5, 40, 15);
                             radioButton_4.setBounds(125,5,40,15);
                             radioButton_5.setBounds(165, 5, 40, 15);
                             btGroup=new ButtonGroup();
                             btGroup.add(radioButton_1);
                             btGroup.add(radioButton_2);
                             btGroup.add(radioButton_3);
                             btGroup.add(radioButton_4);
                             btGroup.add(radioButton_5);
//                             radioButton_1.setSelected(true);
                             jPanel.add(radioButton_1);
                             jPanel.add(radioButton_2);
                             jPanel.add(radioButton_3);
                             jPanel.add(radioButton_4);
                             jPanel.add(radioButton_5);
                             radioButton_1.addActionListener(new ActionListener() {
                              
                              @Override
                              public void actionPerformed(ActionEvent e) {
                                         radioButton_1 = (JRadioButton) e.getSource();
                                         if(radioButton_1.isSelected()){
                                                   JRadioButton button=(JRadioButton) e.getSource();
                                                   button.setBackground(new Color(176, 224, 230));
                                                   System.out.println("hello");
                                         }
                              }
                           });
                    }
                    @Override
                    public Object getCellEditorValue() {
                              // TODO Auto-generated method stub
                             return null;
                             // return Boolean.valueOf(radioButton_1.isSelected());
                    }

                    @Override
                    public Component getTableCellEditorComponent(JTable table,
                                        Object value, boolean isSelected,
                                        int row, int column) {
                              this.table=table;
                              this.row=row;
                              this.model=(DefaultTableModel) table.getModel();
                              //radioButton_1.setSelected(((Boolean) value).booleanValue());
                              return jPanel;
                    }

                    @Override
                    public Component getTableCellRendererComponent(JTable  table,
                                        Object  value,
                                        boolean isSelected,
                                        boolean hasFocus,
                                        int     row,
                                        int     column) {
//                              if (value instanceof Boolean) {
//                                        radioButton_1.setSelected(((Boolean) value).booleanValue());
//                              }
                              return jPanel;
                    }
                    
          }
 
}
